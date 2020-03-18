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
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes9.dex */
public class f {
    private com.baidu.tbadk.coreExtra.model.a dap;
    private DataRes data;
    private final BlackListModel hNP;
    private PersonalTalkSettingActivity hNQ;
    private a hNR;
    private boolean isAttention = false;
    private boolean hNN = false;
    private boolean hNO = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c htm = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_UPDATE_MASK_INFO /* 104102 */:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.hNQ.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.hNQ.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.hNN = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.hNR != null) {
                                        f.this.hNR.updateUI();
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
                            f.this.hNQ.hideProgressBar();
                            f.this.hNQ.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.hNN = f.this.data.isBlacklist.intValue() == 1;
                                f.this.hNQ.hideProgressBar();
                                if (f.this.hNR != null) {
                                    f.this.hNR.updateUI();
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
                    if (f.this.hNQ != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.hNQ.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.hNQ != null) {
                    if (f.this.isAttention) {
                        f.this.hNQ.showToast(R.string.add_success);
                    } else {
                        f.this.hNQ.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.hNR != null) {
                    f.this.hNR.updateUI();
                }
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void updateUI();
    }

    public boolean bZa() {
        return this.hNO;
    }

    public void oe(boolean z) {
        this.hNO = z;
    }

    public DataRes bZb() {
        return this.data;
    }

    public boolean bZc() {
        return this.hNN;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.hNQ = personalTalkSettingActivity;
        this.hNR = aVar;
        this.dap = new com.baidu.tbadk.coreExtra.model.a(personalTalkSettingActivity.getPageContext());
        this.hNP = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        ac.b(new ab<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: bZf */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.bYv().dD(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new l<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.hNO = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void of(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void og(boolean z) {
        this.hNQ.showLoadingDialog(null);
        if (z) {
            this.hNP.addToBlackList(this.data.id.longValue());
        } else {
            this.hNP.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.dap != null) {
            this.dap.cancel();
        }
        if (this.hNP != null) {
            this.hNP.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c bZd() {
        return this.htm;
    }

    public CustomMessageListener bZe() {
        return this.mCustomListener;
    }
}
