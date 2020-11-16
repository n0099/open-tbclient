package com.baidu.yuyinala.mode.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.al.b;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private w aDh;
    private InterfaceC0942a ovA;
    private int ovB = -1;

    /* renamed from: com.baidu.yuyinala.mode.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0942a {
        void eeH();

        void eeI();
    }

    public a(w wVar, InterfaceC0942a interfaceC0942a) {
        this.aDh = wVar;
        this.ovA = interfaceC0942a;
        registerListener();
    }

    public void aw(w wVar) {
        this.aDh = wVar;
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031079) { // from class: com.baidu.yuyinala.mode.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031079) {
                    if (httpResponsedMessage.getError() != 0) {
                        if (a.this.ovA != null) {
                            a.this.ovA.eeH();
                            return;
                        }
                        return;
                    }
                    if (a.this.ovA != null) {
                        a.this.ovA.eeI();
                    }
                    a.this.eeM();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501073));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eeM() {
        if (this.ovB >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, this.ovB == 0 ? "normal" : "dating");
                if (this.ovA != null) {
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.Wy().WE().aHZ.croom_id);
                }
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

    public void NV(int i) {
        this.ovB = i;
        String str = null;
        if (this.aDh != null && this.aDh.aHZ != null) {
            str = this.aDh.aHZ.aRe;
        }
        HttpMessage httpMessage = new HttpMessage(1031079);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam("room_mode", i);
        sendMessage(httpMessage);
    }
}
