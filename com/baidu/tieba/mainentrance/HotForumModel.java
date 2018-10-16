package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class HotForumModel extends BdBaseModel {
    private a fle;
    private List<b> flf;
    private HotSearchInfoData mHotSearchInfo;
    private com.baidu.adp.base.e mPageContext;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes3.dex */
    public interface a {
        void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);

        void qK(String str);
    }

    public HotForumModel(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.mPageContext = eVar;
        this.fle = aVar;
        aYq();
    }

    public void aYp() {
        sendMessage(new HotForumNetMessage());
    }

    private void aYq() {
        registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_HTTP_GET_HOTFORUM, 303116) { // from class: com.baidu.tieba.mainentrance.HotForumModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    HotForumModel.this.fle.qK(HotForumModel.this.mPageContext.getString(e.j.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    HotForumModel.this.fle.qK(HotForumModel.this.mPageContext.getString(e.j.neterror));
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        HotForumModel.this.fle.qK(responsedMessage.getErrorString());
                    } else {
                        HotForumModel.this.fle.qK(HotForumModel.this.mPageContext.getString(e.j.neterror));
                    }
                } else {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        HotForumModel.this.flf = hotForumHttpResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.fle.a(HotForumModel.this.flf, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                    if (responsedMessage instanceof HotForumSocketResponseMessage) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        HotForumModel.this.flf = hotForumSocketResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.fle.a(HotForumModel.this.flf, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
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
