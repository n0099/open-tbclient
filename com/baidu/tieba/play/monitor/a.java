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
    private String OC;
    private String jqC;
    private i jqn;

    public a(String str, String str2, i iVar) {
        this.OC = str;
        this.jqC = str2;
        this.jqn = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void xV(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.Z("obj_locate", 1);
            anVar.cp("tid", this.OC);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(1003388);
            httpMessage.addParam("thread_id", this.OC);
            httpMessage.addParam("video_url", this.jqC);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.jqn != null) {
                this.jqn.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void cZ(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void da(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void db(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.Z("obj_locate", 1);
        anVar.Z("obj_param1", z ? 1 : 0);
        anVar.cp("tid", this.OC);
        TiebaStatic.log(anVar);
        if (this.jqn != null) {
            this.jqn.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void cZ(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void da(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void db(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void oA(boolean z) {
    }
}
