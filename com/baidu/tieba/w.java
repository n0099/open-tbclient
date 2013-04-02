package com.baidu.tieba;

import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends AsyncTask {
    final /* synthetic */ LabelActivity a;
    private com.baidu.tieba.c.t b = null;
    private boolean c;
    private String[] d;

    public w(LabelActivity labelActivity, boolean z, String[] strArr) {
        this.a = labelActivity;
        this.c = z;
        this.d = strArr;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.a.b(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        com.baidu.tieba.b.f fVar;
        try {
            new com.baidu.tieba.account.ak(LabelActivity.c, String.valueOf(this.d.length)).start();
            if (!this.c) {
                fVar = this.a.q;
                com.baidu.tieba.c.k.a(fVar.f(), 12);
                this.a.O = false;
            } else {
                this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/edit_tag");
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
            com.baidu.tieba.c.ag.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return null;
        }
    }

    public void a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.N = null;
        this.a.b(false);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        this.a.N = null;
        if (str != null) {
            try {
                if (str.length() != 0) {
                    JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                    if (optJSONObject.optInt("errno") == 0) {
                        com.baidu.tieba.c.k.a("", 12);
                        this.a.O = false;
                    } else if (optJSONObject.has("usermsg")) {
                        String optString = optJSONObject.optString("usermsg");
                        if (optString != null && optString.length() > 0) {
                            this.a.b(optString);
                        } else {
                            this.a.b(this.a.getString(R.string.add_tag_fail));
                        }
                    }
                    return;
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.a.b(this.a.getString(R.string.attention_fail));
                return;
            } finally {
                this.a.r();
            }
        }
        if (this.b != null && this.b.f() != null) {
            this.a.b(this.b.f());
        }
    }
}
