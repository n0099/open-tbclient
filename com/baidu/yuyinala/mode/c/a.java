package com.baidu.yuyinala.mode.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.ap.b;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private w aFN;
    private InterfaceC0959a oKG;
    private int oKH = -1;

    /* renamed from: com.baidu.yuyinala.mode.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0959a {
        void eku();

        void ekv();
    }

    public a(w wVar, InterfaceC0959a interfaceC0959a) {
        this.aFN = wVar;
        this.oKG = interfaceC0959a;
        registerListener();
    }

    public void aB(w wVar) {
        this.aFN = wVar;
    }

    private void registerListener() {
        registerListener(new HttpMessageListener(1031079) { // from class: com.baidu.yuyinala.mode.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage.getCmd() == 1031079) {
                    if (httpResponsedMessage.getError() != 0) {
                        if (a.this.oKG != null) {
                            a.this.oKG.eku();
                            return;
                        }
                        return;
                    }
                    if (a.this.oKG != null) {
                        a.this.oKG.ekv();
                    }
                    a.this.ekz();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501073));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekz() {
        if (this.oKH >= 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_MODE, this.oKH == 0 ? "normal" : "dating");
                if (this.oKG != null) {
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, b.YX().Zd().aKL.croom_id);
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

    public void OT(int i) {
        this.oKH = i;
        String str = null;
        if (this.aFN != null && this.aFN.aKL != null) {
            str = this.aFN.aKL.aUg;
        }
        HttpMessage httpMessage = new HttpMessage(1031079);
        httpMessage.addParam("room_id", str);
        httpMessage.addParam("room_mode", i);
        sendMessage(httpMessage);
    }
}
