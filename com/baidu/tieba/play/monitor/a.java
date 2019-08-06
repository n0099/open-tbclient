package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String bWU;
    private i iwB;
    private String iwP;

    public a(String str, String str2, i iVar) {
        this.bWU = str;
        this.iwP = str2;
        this.iwB = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void xm(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.P("obj_locate", 1);
            anVar.bT("tid", this.bWU);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.bWU);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.iwP);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.iwB != null) {
                this.iwB.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void bJ(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void bK(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void bL(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        an anVar = new an("c12621");
        anVar.P("obj_locate", 1);
        anVar.P("obj_param1", z ? 1 : 0);
        anVar.bT("tid", this.bWU);
        TiebaStatic.log(anVar);
        if (this.iwB != null) {
            this.iwB.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void bJ(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void bK(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void bL(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void nw(boolean z) {
    }
}
