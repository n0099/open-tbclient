package com.baidu.yuyinala.mode.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.ab;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends BdBaseModel {
    private ab aDd;
    private InterfaceC0963a oXa;
    private int oXb = -1;

    /* renamed from: com.baidu.yuyinala.mode.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0963a {
        void ejl();

        void ejm();
    }

    public a(ab abVar, InterfaceC0963a interfaceC0963a) {
        this.aDd = abVar;
        this.oXa = interfaceC0963a;
        registerListener();
    }

    public void aR(ab abVar) {
        this.aDd = abVar;
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031079) { // from class: com.baidu.yuyinala.mode.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031079) {
                    if (httpResponsedMessage.getError() != 0) {
                        if (a.this.oXa != null) {
                            a.this.oXa.ejl();
                            return;
                        }
                        return;
                    }
                    if (a.this.oXa != null) {
                        a.this.oXa.ejm();
                    }
                    a.this.ejq();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501073));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ejq() {
        if (this.oXb >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.oXb == 0) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                } else if (this.oXb == 1) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                } else if (this.oXb == 2) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                }
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, com.baidu.live.ao.a.Yj().Yq().aIU.croom_id);
            } catch (Exception e) {
                BdLog.e(e);
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "modswitch_suc").setContentExt(jSONObject));
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void Ny(int i) {
        this.oXb = i;
        String str = null;
        if (this.aDd != null && this.aDd.aIU != null) {
            str = this.aDd.aIU.aTK;
        }
        HttpMessage httpMessage = new HttpMessage(1031079);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam("room_mode", i);
        sendMessage(httpMessage);
    }
}
