package com.baidu.tieba.recommend;

import com.baidu.tieba.LabelActivity;
import com.baidu.tieba.d.ae;
import com.baidu.tieba.d.k;
import com.baidu.tieba.d.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.lib.a.a {
    final /* synthetic */ NewHomeActivity a;
    private t b = null;
    private String c;

    public d(NewHomeActivity newHomeActivity, String str) {
        this.a = newHomeActivity;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public Boolean a(String... strArr) {
        boolean z = true;
        try {
            this.b = new t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/tag/edit_tag");
            if (this.c == null || this.c.length() == 0) {
                return false;
            }
            this.b.a("add_tag_id_list", this.c);
            this.b.a("st_type", LabelActivity.c);
            this.b.d(true);
            this.b.i();
            if (!this.b.c() || !this.b.b()) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            ae.b(getClass().getName(), "", "AddFanAsyncTask.doInBackground error = " + e.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(Boolean bool) {
        this.a.x = null;
        if (this.b != null && bool.booleanValue()) {
            k.a("", 12);
        }
    }
}
