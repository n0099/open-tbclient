package com.baidu.tieba.imMessageCenter.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes2.dex */
public class f {
    private com.baidu.tbadk.coreExtra.model.a aqA;
    private DataRes data;
    private final BlackListModel ewT;
    private PersonalTalkSettingActivity ewU;
    private a ewV;
    private boolean isAttention = false;
    private boolean ewR = false;
    private boolean ewS = false;
    private BdUniqueId tag = BdUniqueId.gen();
    private com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 104102:
                        if (socketResponsedMessage instanceof ResponsedMessage) {
                            f.this.ewU.closeLoadingDialog();
                            if (socketResponsedMessage.getError() != 0) {
                                f.this.ewU.showToast(socketResponsedMessage.getErrorString());
                            }
                        }
                        if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                            ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                            if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                                RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                                if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                                    f.this.ewR = requestUpdateMaskInfoMessage.getIsMask() == 1;
                                    if (f.this.ewV != null) {
                                        f.this.ewV.Al();
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    case 205003:
                        if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                            f.this.ewU.hideProgressBar();
                            f.this.ewU.showToast(socketResponsedMessage.getErrorString());
                            return;
                        } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                            ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                            if (responseQueryUserInfoMessage.getResData() != null) {
                                f.this.data = responseQueryUserInfoMessage.getResData();
                                f.this.isAttention = f.this.data.hasConcerned.intValue() == 1;
                                f.this.ewR = f.this.data.isBlacklist.intValue() == 1;
                                f.this.ewU.hideProgressBar();
                                if (f.this.ewV != null) {
                                    f.this.ewV.Al();
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
                    if (f.this.ewU != null && !TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        f.this.ewU.showToast(updateAttentionMessage.getErrorString());
                        return;
                    }
                    return;
                }
                f.this.isAttention = updateAttentionMessage.isAttention();
                if (f.this.ewU != null) {
                    if (f.this.isAttention) {
                        f.this.ewU.showToast(d.k.add_success);
                    } else {
                        f.this.ewU.showToast(d.k.remove_succ);
                    }
                }
                if (f.this.ewV != null) {
                    f.this.ewV.Al();
                }
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void Al();
    }

    public boolean aMv() {
        return this.ewS;
    }

    public void hK(boolean z) {
        this.ewS = z;
    }

    public DataRes aMw() {
        return this.data;
    }

    public boolean aMx() {
        return this.ewR;
    }

    public f(final PersonalTalkSettingActivity personalTalkSettingActivity, a aVar, final long j) {
        this.ewU = personalTalkSettingActivity;
        this.ewV = aVar;
        this.aqA = new com.baidu.tbadk.coreExtra.model.a(personalTalkSettingActivity.getPageContext());
        this.ewT = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        w.b(new v<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            /* renamed from: aMA */
            public PersonalSettingItemData doInBackground() {
                return com.baidu.tieba.im.settingcache.e.aLQ().bq(TbadkCoreApplication.getCurrentAccount(), String.valueOf(j));
            }
        }, new h<PersonalSettingItemData>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: a */
            public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
                if (personalSettingItemData != null) {
                    f.this.ewS = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(j);
                personalTalkSettingActivity.sendMessage(requestQueryUserInfoMessage);
            }
        });
    }

    public void hL(boolean z) {
        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
        requestUpdateMaskInfoMessage.setMaskType(9);
        requestUpdateMaskInfoMessage.setList(String.valueOf(this.data.id));
        requestUpdateMaskInfoMessage.setSettingMask(z);
        requestUpdateMaskInfoMessage.setTag(this.tag);
        MessageManager.getInstance().removeMessage(104102, this.tag);
        MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
    }

    public void hM(boolean z) {
        this.ewU.showLoadingDialog(null);
        if (z) {
            this.ewT.addToBlackList(this.data.id.longValue());
        } else {
            this.ewT.removeFromBlackList(this.data.id.longValue());
        }
    }

    public void onDestory() {
        if (this.aqA != null) {
            this.aqA.cancel();
        }
        if (this.ewT != null) {
            this.ewT.cancelLoadData();
        }
    }

    public com.baidu.adp.framework.listener.c aMy() {
        return this.ecb;
    }

    public CustomMessageListener aMz() {
        return this.mCustomListener;
    }
}
