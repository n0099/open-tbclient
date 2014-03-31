package com.baidu.tieba.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.CombineDownload;
import com.baidu.tieba.data.VersionData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class bb {
    private int f;
    private int g = 0;
    private VersionData a = new VersionData();
    private com.baidu.tieba.data.c b = new com.baidu.tieba.data.c();
    private com.baidu.tieba.data.e c = new com.baidu.tieba.data.e();
    private CombineDownload d = new CombineDownload();
    private ah e = new ah();

    public final void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                try {
                    this.a.parserJson(jSONObject.optJSONObject("version"));
                    this.b.a(jSONObject.optJSONObject("client"));
                    com.baidu.tbadk.core.util.m.a(jSONObject.optString("client_ip", null));
                    this.c.a(jSONObject.optJSONObject("config"));
                    this.d.parserJson(jSONObject.optJSONObject("combine_download"));
                    this.e.a(jSONObject.optJSONObject("mainbar"));
                    this.g = jSONObject.optInt("sync_active", 0);
                    com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2001145, jSONObject));
                    this.f = jSONObject.optInt("faceshop_version");
                    if (this.f > TbadkApplication.j().an()) {
                        TbadkApplication.j().h(this.f);
                        TbadkApplication.j().f(true);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("lcs_strategy");
                    if (optJSONObject != null) {
                        com.baidu.tieba.r.c();
                        com.baidu.tieba.r.m(optJSONObject.toString());
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e.getMessage());
                }
            }
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "parserJson", e2.getMessage());
        }
    }

    public final com.baidu.tieba.data.e a() {
        return this.c;
    }

    public final CombineDownload b() {
        return this.d;
    }

    public final VersionData c() {
        return this.a;
    }

    public final com.baidu.tieba.data.c d() {
        return this.b;
    }
}
