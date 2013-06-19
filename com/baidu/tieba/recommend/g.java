package com.baidu.tieba.recommend;

import android.location.Address;
import android.widget.Button;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bb;
import com.baidu.tieba.account.af;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import com.baidu.tieba.d.t;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.a.a {
    final /* synthetic */ TagContentActivity a;
    private t b = null;
    private String c = null;
    private boolean d;

    public g(TagContentActivity tagContentActivity, boolean z) {
        this.a = tagContentActivity;
        this.d = false;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        String str2;
        String str3;
        new af("tagthread").start();
        if (this.d) {
            this.b = new t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/tag/add_tag");
            this.b.d(true);
            this.b.a("_version_more", "1");
            this.b.a("platform", "android");
            t tVar = this.b;
            str3 = this.a.d;
            tVar.a("tag_info", str3);
            Address aM = TiebaApplication.e().aM();
            if (aM != null && TiebaApplication.e().q()) {
                this.b.a("lbs", String.valueOf(String.valueOf(aM.getLatitude())) + "," + String.valueOf(aM.getLongitude()));
            }
            try {
                this.c = this.b.i();
                if (this.b.c()) {
                    return this.c;
                }
            } catch (Exception e) {
                ae.b("AttentionAsyncTask", "doInBackground", "error = " + e.getMessage());
            }
            return null;
        }
        String b = k.b(12);
        com.baidu.tieba.c.af afVar = new com.baidu.tieba.c.af();
        afVar.a(b);
        bb bbVar = new bb();
        str = this.a.d;
        bbVar.a(str);
        str2 = this.a.c;
        bbVar.b(str2);
        afVar.a(bbVar);
        k.a(afVar.f(), 12);
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        Button button;
        Button button2;
        Button button3;
        String str2;
        String str3;
        Button button4;
        this.a.q = null;
        if (str == null) {
            button4 = this.a.g;
            button4.setVisibility(0);
        } else if (this.d) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                if (optJSONObject.optInt("errno") == 0) {
                    button3 = this.a.g;
                    button3.setVisibility(8);
                    this.a.a(this.a.getString(R.string.attention_success));
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
                        this.a.a(optString);
                    } else {
                        this.a.a(this.a.getString(R.string.attention_fail));
                    }
                }
                button2 = this.a.g;
                button2.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
                button = this.a.g;
                button.setVisibility(0);
                this.a.a(this.a.getString(R.string.attention_fail));
            }
        } else {
            this.a.a(this.a.getString(R.string.attention_success));
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }
}
