package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.k.e;
import com.baidu.tieba.k.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String ais;
    private i kyk;
    private String kyz;

    public a(String str, String str2, i iVar) {
        this.ais = str;
        this.kyz = str2;
        this.kyk = iVar;
    }

    @Override // com.baidu.tieba.k.e.a
    public void zx(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.ag("obj_locate", 1);
            anVar.dh("tid", this.ais);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.ais);
            httpMessage.addParam("video_url", this.kyz);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.kyk != null) {
                this.kyk.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.k.b
                    public void dr(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void ds(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void dt(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.ag("obj_locate", 1);
        anVar.ag("obj_param1", z ? 1 : 0);
        anVar.dh("tid", this.ais);
        TiebaStatic.log(anVar);
        if (this.kyk != null) {
            this.kyk.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.k.b
                public void dr(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void ds(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dt(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void qw(boolean z) {
    }
}
