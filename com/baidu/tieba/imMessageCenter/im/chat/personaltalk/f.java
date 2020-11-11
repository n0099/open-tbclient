package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes22.dex */
public class f {
    private DataRes data;
    private com.baidu.tbadk.coreExtra.model.a eNr;
    private final BlackListModel krE;
    private PersonalTalkSettingActivity krF;
    private a krG;
    private boolean isAttention = false;
    private boolean krC = false;
    private boolean krD = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c jUQ = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_UPDATE_MASK_INFO /* 104102 */:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.krF.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.krF.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.krC = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.krG != null) {
                                        f.this.krG.updateUI();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case CmdConfigSocket.CMD_QUERY_USER_INFO /* 205003 */:
                        if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                            f.this.krF.hideProgressBar();
                            f.this.krF.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.krC = f.this.data.isBlacklist.intValue() == 1;
                                f.this.krF.hideProgressBar();
                                if (f.this.krG != null) {
                                    f.this.krG.updateUI();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (f.this.krF != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.krF.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.krF != null) {
                    if (f.this.isAttention) {
                        f.this.krF.showToast(R.string.add_success);
                    } else {
                        f.this.krF.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.krG != null) {
                    f.this.krG.updateUI();
                }
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void updateUI();
    }

    public boolean cVN() {
        return this.krD;
    }

    public void st(boolean z) {
        this.krD = z;
    }

    public DataRes cVO() {
        return this.data;
    }

    public boolean cVP() {
        return this.krC;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.krF = personalTalkSettingActivity;
        this.krG = aVar;
        this.eNr = new com.baidu.tbadk.coreExtra.model.a(personalTalkSettingActivity.getPageContext());
        this.krE = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        ae.b(new ad<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ad
            /* renamed from: cVS */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.cVh().fs(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new m<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.krD = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void su(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void sv(boolean z) {
        this.krF.showLoadingDialog(null);
        if (z) {
            this.krE.addToBlackList(this.data.id.longValue());
        } else {
            this.krE.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.eNr != null) {
            this.eNr.cancel();
        }
        if (this.krE != null) {
            this.krE.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c cVQ() {
        return this.jUQ;
    }

    public CustomMessageListener cVR() {
        return this.mCustomListener;
    }
}
