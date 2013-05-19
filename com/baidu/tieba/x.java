package com.baidu.tieba;

import com.slidingmenu.lib.R;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends com.baidu.adp.lib.a.a {
    final /* synthetic */ LabelActivity a;
    private com.baidu.tieba.d.t b = null;
    private boolean c;
    private String[] d;

    public x(LabelActivity labelActivity, boolean z, String[] strArr) {
        this.a = labelActivity;
        this.c = z;
        this.d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        this.a.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(String... strArr) {
        com.baidu.tieba.c.ac acVar;
        try {
            new com.baidu.tieba.account.af(LabelActivity.c, String.valueOf(this.d.length)).start();
            if (!this.c) {
                acVar = this.a.q;
                com.baidu.tieba.d.k.a(acVar.f(), 12);
                this.a.O = false;
            } else {
                this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/tag/edit_tag");
                if (this.d == null || this.d.length != 2) {
                    this.a.O = false;
                    return null;
                }
                if (this.d[0].length() > 0) {
                    this.b.a("add_tag_id_list", this.d[0]);
                }
                if (this.d[1].length() > 0) {
                    this.b.a("del_tag_id_list", this.d[1]);
                }
                this.b.d(true);
                String i = this.b.i();
                if (this.b.c() && this.b.b()) {
                    return i;
                }
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.d.ae.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.N = null;
        this.a.b(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        this.a.N = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                    if (optJSONObject.optInt("errno") == 0) {
                        com.baidu.tieba.d.k.a("", 12);
                        this.a.O = false;
                    } else if (optJSONObject.has("usermsg")) {
                        String optString = optJSONObject.optString("usermsg");
                        if (optString != null && optString.length() > 0) {
                            this.a.a(optString);
                        } else {
                            this.a.a(this.a.getString(R.string.add_tag_fail));
                        }
                    }
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.a.a(this.a.getString(R.string.attention_fail));
                return;
            } finally {
                this.a.s();
            }
        }
        if (this.b != null && this.b.f() != null) {
            this.a.a(this.b.f());
        }
    }
}
