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
    private String ahO;
    private String kgH;
    private i kgs;

    public a(String str, String str2, i iVar) {
        this.ahO = str;
        this.kgH = str2;
        this.kgs = iVar;
    }

    @Override // com.baidu.tieba.k.e.a
    public void yP(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.af("obj_locate", 1);
            anVar.cI("tid", this.ahO);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.ahO);
            httpMessage.addParam("video_url", this.kgH);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.kgs != null) {
                this.kgs.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.k.b
                    public void dk(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void dl(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void dm(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.af("obj_locate", 1);
        anVar.af("obj_param1", z ? 1 : 0);
        anVar.cI("tid", this.ahO);
        TiebaStatic.log(anVar);
        if (this.kgs != null) {
            this.kgs.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.k.b
                public void dk(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dl(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dm(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void pZ(boolean z) {
    }
}
