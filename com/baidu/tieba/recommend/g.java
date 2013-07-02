package com.baidu.tieba.recommend;

import android.location.Address;
import android.widget.Button;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.af;
import com.baidu.tieba.data.az;
import com.baidu.tieba.model.ai;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.r;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends BdAsyncTask {
    final /* synthetic */ TagContentActivity a;
    private r b = null;
    private String c = null;
    private boolean d;

    public g(TagContentActivity tagContentActivity, boolean z) {
        this.a = tagContentActivity;
        this.d = false;
        this.d = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String a(Object... objArr) {
        String str;
        String str2;
        String str3;
        new af("tagthread").start();
        if (this.d) {
            this.b = new r(String.valueOf(com.baidu.tieba.data.g.a) + "c/s/tag/add_tag");
            this.b.d(true);
            this.b.a("_version_more", "1");
            this.b.a("platform", "android");
            r rVar = this.b;
            str3 = this.a.b;
            rVar.a("tag_info", str3);
            Address aP = TiebaApplication.f().aP();
            if (aP != null && TiebaApplication.f().u()) {
                this.b.a("lbs", String.valueOf(String.valueOf(aP.getLatitude())) + "," + String.valueOf(aP.getLongitude()));
            }
            try {
                this.c = this.b.j();
                if (this.b.d()) {
                    return this.c;
                }
            } catch (Exception e) {
                z.b("AttentionAsyncTask", "doInBackground", "error = " + e.getMessage());
            }
            return null;
        }
        String b = DatabaseService.b(12);
        ai aiVar = new ai();
        aiVar.a(b);
        az azVar = new az();
        str = this.a.b;
        azVar.a(str);
        str2 = this.a.a;
        azVar.b(str2);
        aiVar.a(azVar);
        DatabaseService.a(aiVar.f(), 12);
        return "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Button button;
        Button button2;
        Button button3;
        String str2;
        String str3;
        Button button4;
        this.a.q = null;
        if (str == null) {
            button4 = this.a.e;
            button4.setVisibility(0);
        } else if (this.d) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                if (optJSONObject.optInt("errno") == 0) {
                    button3 = this.a.e;
                    button3.setVisibility(8);
                    this.a.a(this.a.getString(R.string.attention_success));
                    ArrayList arrayList = NewHomeActivity.a;
                    str2 = this.a.b;
                    if (!arrayList.contains(str2)) {
                        ArrayList arrayList2 = NewHomeActivity.a;
                        str3 = this.a.b;
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
                button2 = this.a.e;
                button2.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
                button = this.a.e;
                button.setVisibility(0);
                this.a.a(this.a.getString(R.string.attention_fail));
            }
        } else {
            this.a.a(this.a.getString(R.string.attention_success));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.h();
        }
        super.cancel(true);
    }
}
