package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.c.bp;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.e {
    private bp c = null;
    private ImageView d = null;
    private Button e = null;
    private ImageView f = null;
    private EditText g = null;
    private ProgressBar h = null;
    private s i = null;
    private r j = null;
    private InputMethodManager k = null;
    private DialogInterface.OnCancelListener l = null;
    private RelativeLayout m = null;
    private LinearLayout n = null;
    private TextView o = null;

    public static void a(Activity activity, bp bpVar, int i) {
        if (bpVar != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", bpVar);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, bp bpVar, boolean z, int i) {
        if (bpVar != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", bpVar);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        b();
        a(bundle);
        c(this.c.m());
    }

    private void a(Bundle bundle) {
        this.l = new n(this);
        if (bundle != null) {
            this.c = (bp) bundle.getSerializable("model");
        } else {
            this.c = (bp) getIntent().getSerializableExtra("model");
        }
        this.k = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.cancel();
        }
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.h != null) {
            this.h.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.c);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        int i2;
        super.b(i);
        com.baidu.tieba.d.ac.a(this.m, i);
        com.baidu.tieba.d.ac.d(this.n, i);
        com.baidu.tieba.d.ac.a(this.d, i);
        com.baidu.tieba.d.ac.g((TextView) this.e, i);
        if (i == 1) {
            i2 = com.baidu.tieba.d.ac.a(i);
        } else {
            i2 = -12895429;
        }
        this.o.setTextColor(i2);
    }

    private void b() {
        this.m = (RelativeLayout) findViewById(R.id.parent);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.o = (TextView) findViewById(R.id.info);
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new o(this));
        this.e = (Button) findViewById(R.id.post);
        this.e.setOnClickListener(new p(this));
        this.g = (EditText) findViewById(R.id.input);
        this.f = (ImageView) findViewById(R.id.vcode_image);
        this.f.setImageBitmap(null);
        this.f.setOnClickListener(new q(this));
        this.h = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.j != null) {
            this.j.cancel();
        }
        this.h.setVisibility(0);
        this.f.setImageBitmap(null);
        this.j = new r(this, null);
        this.j.setPriority(3);
        this.j.execute(str);
    }
}
