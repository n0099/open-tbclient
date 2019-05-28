package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes6.dex */
public class HotForumModel extends BdBaseModel {
    private a heo;
    private List<b> hep;
    private HotSearchInfoData mHotSearchInfo;
    private com.baidu.adp.base.e mPageContext;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes6.dex */
    public interface a {
        void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);

        void zy(String str);
    }

    public HotForumModel(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mPageContext = eVar;
        this.heo = aVar;
        bJf();
    }

    public void bJe() {
        sendMessage(new HotForumNetMessage());
    }

    private void bJf() {
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116) { // from class: com.baidu.tieba.mainentrance.HotForumModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    HotForumModel.this.heo.zy(HotForumModel.this.mPageContext.getString(R.string.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    HotForumModel.this.heo.zy(HotForumModel.this.mPageContext.getString(R.string.neterror));
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        HotForumModel.this.heo.zy(responsedMessage.getErrorString());
                    } else {
                        HotForumModel.this.heo.zy(HotForumModel.this.mPageContext.getString(R.string.neterror));
                    }
                } else {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        HotForumModel.this.hep = hotForumHttpResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.heo.a(HotForumModel.this.hep, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                    if (responsedMessage instanceof HotForumSocketResponseMessage) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        HotForumModel.this.hep = hotForumSocketResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.heo.a(HotForumModel.this.hep, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                }
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
