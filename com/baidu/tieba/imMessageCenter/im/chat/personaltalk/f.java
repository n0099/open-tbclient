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
/* loaded from: classes2.dex */
public class f {
    private DataRes data;
    private com.baidu.tbadk.coreExtra.model.a eYq;
    private final BlackListModel kGp;
    private PersonalTalkSettingActivity kGq;
    private a kGr;
    private boolean isAttention = false;
    private boolean kGo = false;
    private boolean auW = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c krM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_UPDATE_MASK_INFO /* 104102 */:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.kGq.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.kGq.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.kGo = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.kGr != null) {
                                        f.this.kGr.updateUI();
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
                            f.this.kGq.hideProgressBar();
                            f.this.kGq.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.kGo = f.this.data.isBlacklist.intValue() == 1;
                                f.this.kGq.hideProgressBar();
                                if (f.this.kGr != null) {
                                    f.this.kGr.updateUI();
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
                    if (f.this.kGq != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.kGq.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.kGq != null) {
                    if (f.this.isAttention) {
                        f.this.kGq.showToast(R.string.add_success);
                    } else {
                        f.this.kGq.showToast(R.string.remove_succ);
                    }
                }
                if (f.this.kGr != null) {
                    f.this.kGr.updateUI();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void updateUI();
    }

    public boolean cWs() {
        return this.auW;
    }

    public void sV(boolean z) {
        this.auW = z;
    }

    public DataRes cWt() {
        return this.data;
    }

    public boolean cWu() {
        return this.kGo;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.kGq = personalTalkSettingActivity;
        this.kGr = aVar;
        this.eYq = new com.baidu.tbadk.coreExtra.model.a(personalTalkSettingActivity.getPageContext());
        this.kGp = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        ac.b(new ab<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: cWx */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.cVW().fx(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new l<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.auW = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void sW(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(CmdConfigSocket.CMD_UPDATE_MASK_INFO, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void sX(boolean z) {
        this.kGq.showLoadingDialog(null);
        if (z) {
            this.kGp.addToBlackList(this.data.id.longValue());
        } else {
            this.kGp.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.eYq != null) {
            this.eYq.cancel();
        }
        if (this.kGp != null) {
            this.kGp.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c cWv() {
        return this.krM;
    }

    public CustomMessageListener cWw() {
        return this.mCustomListener;
    }
}
