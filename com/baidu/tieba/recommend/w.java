package com.baidu.tieba.recommend;

import android.location.Address;
import android.os.AsyncTask;
import android.widget.Button;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.aw;
import com.baidu.tieba.account.ak;
import com.baidu.tieba.c.ag;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends AsyncTask {
    final /* synthetic */ TagContentActivity a;
    private com.baidu.tieba.c.t b = null;
    private String c = null;
    private boolean d;

    public w(TagContentActivity tagContentActivity, boolean z) {
        this.a = tagContentActivity;
        this.d = false;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        String str;
        String str2;
        String str3;
        new ak("tagthread").start();
        if (this.d) {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/tag/add_tag");
            this.b.d(true);
            this.b.a("_version_more", "1");
            this.b.a("platform", "android");
            com.baidu.tieba.c.t tVar = this.b;
            str3 = this.a.d;
            tVar.a("tag_info", str3);
            Address aC = TiebaApplication.b().aC();
            if (aC != null && TiebaApplication.b().m()) {
                this.b.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
            }
            try {
                this.c = this.b.i();
                if (this.b.c()) {
                    return this.c;
                }
            } catch (Exception e) {
                ag.b("AttentionAsyncTask", "doInBackground", "error = " + e.getMessage());
            }
            return null;
        }
        String b = com.baidu.tieba.c.k.b(12);
        com.baidu.tieba.b.f fVar = new com.baidu.tieba.b.f();
        fVar.a(b);
        aw awVar = new aw();
        str = this.a.d;
        awVar.a(str);
        str2 = this.a.c;
        awVar.b(str2);
        fVar.a(awVar);
        com.baidu.tieba.c.k.a(fVar.f(), 12);
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        Button button;
        Button button2;
        Button button3;
        String str2;
        String str3;
        Button button4;
        if (str == null) {
            button4 = this.a.g;
            button4.setVisibility(0);
        } else if (this.d) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                if (optJSONObject.optInt("errno") == 0) {
                    button3 = this.a.g;
                    button3.setVisibility(8);
                    this.a.b(this.a.getString(R.string.attention_success));
                    ArrayList arrayList = NewHomeActivity.c;
                    str2 = this.a.d;
                    if (!arrayList.contains(str2)) {
                        ArrayList arrayList2 = NewHomeActivity.c;
                        str3 = this.a.d;
                        arrayList2.add(str3);
                        return;
                    }
                    return;
                }
                if (optJSONObject.has("usermsg")) {
                    String optString = optJSONObject.optString("usermsg");
                    if (optString != null && optString.length() > 0) {
                        this.a.b(optString);
                    } else {
                        this.a.b(this.a.getString(R.string.attention_fail));
                    }
                }
                button2 = this.a.g;
                button2.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
                button = this.a.g;
                button.setVisibility(0);
                this.a.b(this.a.getString(R.string.attention_fail));
            }
        } else {
            this.a.b(this.a.getString(R.string.attention_success));
        }
    }
}
