package com.baidu.tieba.recommend;

import android.location.Address;
import android.widget.Button;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bl;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TagContentActivity f1659a;
    private com.baidu.tieba.util.u b = null;
    private String c = null;
    private boolean d;

    public bd(TagContentActivity tagContentActivity, boolean z) {
        this.f1659a = tagContentActivity;
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
        new com.baidu.tieba.account.ag("tagthread").start();
        if (this.d) {
            this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/tag/add_tag");
            this.b.e(true);
            this.b.a("_version_more", "1");
            this.b.a("platform", "android");
            com.baidu.tieba.util.u uVar = this.b;
            str3 = this.f1659a.b;
            uVar.a("tag_info", str3);
            Address aT = TiebaApplication.f().aT();
            if (aT != null && TiebaApplication.f().u()) {
                this.b.a("lbs", String.valueOf(String.valueOf(aT.getLatitude())) + "," + String.valueOf(aT.getLongitude()));
            }
            try {
                this.c = this.b.k();
                if (this.b.e()) {
                    return this.c;
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b("AttentionAsyncTask", "doInBackground", "error = " + e.getMessage());
            }
            return null;
        }
        String b = DatabaseService.b(12);
        com.baidu.tieba.model.aq aqVar = new com.baidu.tieba.model.aq();
        aqVar.a(b);
        bl blVar = new bl();
        str = this.f1659a.b;
        blVar.a(str);
        str2 = this.f1659a.f1630a;
        blVar.b(str2);
        aqVar.a(blVar);
        DatabaseService.a(aqVar.g(), 12);
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
        this.f1659a.q = null;
        if (str == null) {
            button4 = this.f1659a.e;
            button4.setVisibility(0);
        } else if (this.d) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("error");
                if (optJSONObject.optInt("errno") == 0) {
                    button3 = this.f1659a.e;
                    button3.setVisibility(8);
                    this.f1659a.a(this.f1659a.getString(R.string.attention_success));
                    ArrayList arrayList = NewHomeActivity.f1628a;
                    str2 = this.f1659a.b;
                    if (!arrayList.contains(str2)) {
                        ArrayList arrayList2 = NewHomeActivity.f1628a;
                        str3 = this.f1659a.b;
                        arrayList2.add(str3);
                        return;
                    }
                    return;
                }
                if (optJSONObject.has("usermsg")) {
                    String optString = optJSONObject.optString("usermsg");
                    if (optString != null && optString.length() > 0) {
                        this.f1659a.a(optString);
                    } else {
                        this.f1659a.a(this.f1659a.getString(R.string.attention_fail));
                    }
                }
                button2 = this.f1659a.e;
                button2.setVisibility(0);
            } catch (JSONException e) {
                e.printStackTrace();
                button = this.f1659a.e;
                button.setVisibility(0);
                this.f1659a.a(this.f1659a.getString(R.string.attention_fail));
            }
        } else {
            this.f1659a.a(this.f1659a.getString(R.string.attention_success));
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        if (this.b != null) {
            this.b.i();
        }
        super.cancel(true);
    }
}
