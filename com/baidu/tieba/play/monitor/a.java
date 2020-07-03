package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.k.e;
import com.baidu.tieba.k.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String ajO;
    private String kTC;
    private i kTn;

    public a(String str, String str2, i iVar) {
        this.ajO = str;
        this.kTC = str2;
        this.kTn = iVar;
    }

    @Override // com.baidu.tieba.k.e.a
    public void Al(int i) {
        if (i == 1) {
            ao aoVar = new ao("c12620");
            aoVar.ag("obj_locate", 1);
            aoVar.dk("tid", this.ajO);
            TiebaStatic.log(aoVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.ajO);
            httpMessage.addParam("video_url", this.kTC);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.kTn != null) {
                this.kTn.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.k.b
                    public void dB(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void dC(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void dD(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void onChange(final boolean z) {
        ao aoVar = new ao("c12621");
        aoVar.ag("obj_locate", 1);
        aoVar.ag("obj_param1", z ? 1 : 0);
        aoVar.dk("tid", this.ajO);
        TiebaStatic.log(aoVar);
        if (this.kTn != null) {
            this.kTn.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.k.b
                public void dB(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dC(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dD(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void qG(boolean z) {
    }
}
