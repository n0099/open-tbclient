package com.baidu.tieba.more;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tieba.e {
    private ArrayList b = null;
    private m c = null;
    private ListView d = null;
    private Button e = null;
    private Button f = null;
    private View.OnClickListener g = null;
    private k h = null;
    private h i = null;

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, AccountActivity.class));
    }

    private void g() {
        this.b = com.baidu.tieba.c.k.j();
    }

    private void h() {
        this.g = new d(this);
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new e(this));
        this.f = (Button) findViewById(R.id.edit);
        this.f.setOnClickListener(new f(this));
        this.c = new m(this, this.g);
        this.c.a(this.b);
        this.d = (ListView) findViewById(R.id.list);
        this.d.setAdapter((ListAdapter) this.c);
        this.d.setOnItemClickListener(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_activity);
        g();
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
