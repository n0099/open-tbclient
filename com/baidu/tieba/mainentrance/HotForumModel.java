package com.baidu.tieba.mainentrance;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes11.dex */
public class HotForumModel extends BdBaseModel {
    private com.baidu.adp.base.e dJb;
    private a jfM;
    private List<b> jfN;
    private HotSearchInfoData mHotSearchInfo;
    private List<c> mTopicInfoList;
    private String mTopicInfoTitle;

    /* loaded from: classes11.dex */
    public interface a {
        void HH(String str);

        void a(List<b> list, List<c> list2, HotSearchInfoData hotSearchInfoData, String str);
    }

    public HotForumModel(com.baidu.adp.base.e eVar, a aVar) {
        super(eVar);
        this.dJb = eVar;
        this.jfM = aVar;
        cvs();
    }

    public void cvr() {
        sendMessage(new HotForumNetMessage());
    }

    private void cvs() {
        registerListener(new com.baidu.adp.framework.listener.a(1001534, CmdConfigSocket.CMD_GET_HOTFORUM) { // from class: com.baidu.tieba.mainentrance.HotForumModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!(responsedMessage instanceof HotForumSocketResponseMessage) && !(responsedMessage instanceof HotForumHttpResponseMessage)) {
                    HotForumModel.this.jfM.HH(HotForumModel.this.dJb.getString(R.string.neterror));
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotForumNetMessage)) {
                    HotForumModel.this.jfM.HH(HotForumModel.this.dJb.getString(R.string.neterror));
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (!TextUtils.isEmpty(responsedMessage.getErrorString())) {
                        HotForumModel.this.jfM.HH(responsedMessage.getErrorString());
                    } else {
                        HotForumModel.this.jfM.HH(HotForumModel.this.dJb.getString(R.string.neterror));
                    }
                } else {
                    if (responsedMessage instanceof HotForumHttpResponseMessage) {
                        HotForumHttpResponseMessage hotForumHttpResponseMessage = (HotForumHttpResponseMessage) responsedMessage;
                        HotForumModel.this.jfN = hotForumHttpResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumHttpResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumHttpResponseMessage.getHotSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumHttpResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.jfM.a(HotForumModel.this.jfN, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
                    }
                    if (responsedMessage instanceof HotForumSocketResponseMessage) {
                        HotForumSocketResponseMessage hotForumSocketResponseMessage = (HotForumSocketResponseMessage) responsedMessage;
                        HotForumModel.this.jfN = hotForumSocketResponseMessage.getForumInfoList();
                        HotForumModel.this.mTopicInfoList = hotForumSocketResponseMessage.getTopicInfoList();
                        HotForumModel.this.mHotSearchInfo = hotForumSocketResponseMessage.getSearchInfo();
                        HotForumModel.this.mTopicInfoTitle = hotForumSocketResponseMessage.getTopicInfoTitle();
                        HotForumModel.this.jfM.a(HotForumModel.this.jfN, HotForumModel.this.mTopicInfoList, HotForumModel.this.mHotSearchInfo, HotForumModel.this.mTopicInfoTitle);
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
