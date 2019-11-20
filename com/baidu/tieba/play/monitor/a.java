package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String cma;
    private String iwC;
    private i iwn;

    public a(String str, String str2, i iVar) {
        this.cma = str;
        this.iwC = str2;
        this.iwn = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void vU(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.O("obj_locate", 1);
            anVar.bS("tid", this.cma);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.cma);
            httpMessage.addParam("video_url", this.iwC);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.iwn != null) {
                this.iwn.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void cj(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void ck(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void cl(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.O("obj_locate", 1);
        anVar.O("obj_param1", z ? 1 : 0);
        anVar.bS("tid", this.cma);
        TiebaStatic.log(anVar);
        if (this.iwn != null) {
            this.iwn.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void cj(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void ck(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void cl(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void nl(boolean z) {
    }
}
