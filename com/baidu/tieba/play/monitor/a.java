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
    private String Pj;
    private i juV;
    private String jvk;

    public a(String str, String str2, i iVar) {
        this.Pj = str;
        this.jvk = str2;
        this.juV = iVar;
    }

    @Override // com.baidu.tieba.k.e.a
    public void yg(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.X("obj_locate", 1);
            anVar.cy("tid", this.Pj);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.Pj);
            httpMessage.addParam("video_url", this.jvk);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.juV != null) {
                this.juV.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.k.b
                    public void cZ(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void da(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.k.b
                    public void db(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.X("obj_locate", 1);
        anVar.X("obj_param1", z ? 1 : 0);
        anVar.cy("tid", this.Pj);
        TiebaStatic.log(anVar);
        if (this.juV != null) {
            this.juV.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.k.b
                public void cZ(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void da(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void db(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.k.e.a
    public void oP(boolean z) {
    }
}
