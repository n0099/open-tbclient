package com.baidu.yuyinala.mode.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends BdBaseModel {
    private x aBr;
    private InterfaceC0957a oMu;
    private int oMv = -1;

    /* renamed from: com.baidu.yuyinala.mode.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0957a {
        void egL();

        void egM();
    }

    public a(x xVar, InterfaceC0957a interfaceC0957a) {
        this.aBr = xVar;
        this.oMu = interfaceC0957a;
        registerListener();
    }

    public void aO(x xVar) {
        this.aBr = xVar;
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031079) { // from class: com.baidu.yuyinala.mode.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031079) {
                    if (httpResponsedMessage.getError() != 0) {
                        if (a.this.oMu != null) {
                            a.this.oMu.egL();
                            return;
                        }
                        return;
                    }
                    if (a.this.oMu != null) {
                        a.this.oMu.egM();
                    }
                    a.this.egQ();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501073));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egQ() {
        if (this.oMv >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.oMv == 0) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "normal");
                } else if (this.oMv == 1) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "dating");
                } else if (this.oMv == 2) {
                    jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, "battle");
                }
                jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, com.baidu.live.aq.a.Wu().WA().aGy.croom_id);
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

    public void Nb(int i) {
        this.oMv = i;
        String str = null;
        if (this.aBr != null && this.aBr.aGy != null) {
            str = this.aBr.aGy.aQH;
        }
        HttpMessage httpMessage = new HttpMessage(1031079);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam("room_mode", i);
        sendMessage(httpMessage);
    }
}
