package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String bXN;
    private i iyC;
    private String iyR;

    public a(String str, String str2, i iVar) {
        this.bXN = str;
        this.iyR = str2;
        this.iyC = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void xp(int i) {
        if (i == 1) {
            an anVar = new an("c12620");
            anVar.P("obj_locate", 1);
            anVar.bT("tid", this.bXN);
            TiebaStatic.log(anVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.bXN);
            httpMessage.addParam("video_url", this.iyR);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.iyC != null) {
                this.iyC.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
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
        anVar.bT("tid", this.bXN);
        TiebaStatic.log(anVar);
        if (this.iyC != null) {
            this.iyC.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
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
    public void nz(boolean z) {
    }
}
