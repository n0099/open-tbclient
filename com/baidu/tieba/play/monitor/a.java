package com.baidu.tieba.play.monitor;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.j.e;
import com.baidu.tieba.j.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements e.a {
    private String biw;
    private i gCJ;
    private String gCY;

    public a(String str, String str2, i iVar) {
        this.biw = str;
        this.gCY = str2;
        this.gCJ = iVar;
    }

    @Override // com.baidu.tieba.j.e.a
    public void rG(int i) {
        if (i == 1) {
            am amVar = new am("c12620");
            amVar.x("obj_locate", 1);
            amVar.aA("tid", this.biw);
            TiebaStatic.log(amVar);
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_MOOV_UPLOAD);
            httpMessage.addParam("thread_id", this.biw);
            httpMessage.addParam(WebVideoActivityConfig.KEY_VIDEO_URL, this.gCY);
            MessageManager.getInstance().sendMessage(httpMessage);
            if (this.gCJ != null) {
                this.gCJ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.1
                    @Override // com.baidu.tieba.j.b
                    public void ao(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void ap(JSONObject jSONObject) throws JSONException {
                    }

                    @Override // com.baidu.tieba.j.b
                    public void aq(JSONObject jSONObject) throws JSONException {
                        jSONObject.put("moov_bottom", 1);
                    }
                });
            }
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void onChange(final boolean z) {
        am amVar = new am("c12621");
        amVar.x("obj_locate", 1);
        amVar.x("obj_param1", z ? 1 : 0);
        amVar.aA("tid", this.biw);
        TiebaStatic.log(amVar);
        if (this.gCJ != null) {
            this.gCJ.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.a.2
                @Override // com.baidu.tieba.j.b
                public void ao(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void ap(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void aq(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("moov_bottom_fix", z ? 1 : 0);
                }
            });
        }
    }

    @Override // com.baidu.tieba.j.e.a
    public void jO(boolean z) {
    }
}
