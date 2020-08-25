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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes16.dex */
public class f {
    private DataRes data;
    private com.baidu.tbadk.coreExtra.model.a ekD;
    private final BlackListModel jBD;
    private PersonalTalkSettingActivity jBE;
    private a jBF;
    private boolean isAttention = false;
    private boolean jBB = false;
    private boolean jBC = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c jeL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_UPDATE_MASK_INFO /* 104102 */:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.jBE.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.jBE.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.jBB = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.jBF != null) {
                                        f.this.jBF.updateUI();
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
                            f.this.jBE.hideProgressBar();
                            f.this.jBE.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.jBB = f.this.data.isBlacklist.intValue() == 1;
                                f.this.jBE.hideProgressBar();
                                if (f.this.jBF != null) {
                                    f.this.jBF.updateUI();
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
                    if (f.this.jBE != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.jBE.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.jBE != null) {
                    if (f.this.isAttention) {
                        f.this.jBE.showToast(R.string.add_success);
                    } else {
                        f.this.jBE.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.jBF != null) {
                    f.this.jBF.updateUI();
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void updateUI();
    }

    public boolean cIQ() {
        return this.jBC;
    }

    public void rc(boolean z) {
        this.jBC = z;
    }

    public DataRes cIR() {
        return this.data;
    }

    public boolean cIS() {
        return this.jBB;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.jBE = personalTalkSettingActivity;
        this.jBF = aVar;
        this.ekD = new com.baidu.tbadk.coreExtra.model.a(personalTalkSettingActivity.getPageContext());
        this.jBD = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        ad.b(new ac<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ac
            /* renamed from: cIV */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.cIk().eS(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new l<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.jBC = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void rd(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void re(boolean z) {
        this.jBE.showLoadingDialog(null);
        if (z) {
            this.jBD.addToBlackList(this.data.id.longValue());
        } else {
            this.jBD.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.ekD != null) {
            this.ekD.cancel();
        }
        if (this.jBD != null) {
            this.jBD.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c cIT() {
        return this.jeL;
    }

    public CustomMessageListener cIU() {
        return this.mCustomListener;
    }
}
