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
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.y c = null;
    private Button d = null;
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

    public static void a(Activity activity, com.baidu.tieba.b.y yVar, int i) {
        if (yVar != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", yVar);
            activity.startActivityForResult(intent, i);
        }
    }

    public static void a(Activity activity, com.baidu.tieba.b.y yVar, boolean z, int i) {
        if (yVar != null) {
            Intent intent = new Intent(activity, VcodeActivity.class);
            intent.putExtra("model", yVar);
            intent.putExtra("is_ad", z);
            activity.startActivityForResult(intent, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        i();
        a(bundle);
        c(this.c.l());
    }

    private void a(Bundle bundle) {
        this.l = new n(this);
        if (bundle != null) {
            this.c = (com.baidu.tieba.b.y) bundle.getSerializable("model");
        } else {
            this.c = (com.baidu.tieba.b.y) getIntent().getSerializableExtra("model");
        }
        this.k = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.i != null) {
            this.i.a();
        }
        if (this.j != null) {
            this.j.a();
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
        com.baidu.tieba.c.ae.a(this.m, i);
        com.baidu.tieba.c.ae.c(this.n, i);
        com.baidu.tieba.c.ae.e((TextView) this.d, i);
        com.baidu.tieba.c.ae.d((TextView) this.e, i);
        if (i == 1) {
            i2 = com.baidu.tieba.c.ae.a(i);
        } else {
            i2 = -12895429;
        }
        this.o.setTextColor(i2);
    }

    private void i() {
        this.m = (RelativeLayout) findViewById(R.id.parent);
        this.n = (LinearLayout) findViewById(R.id.title);
        this.o = (TextView) findViewById(R.id.info);
        this.d = (Button) findViewById(R.id.back);
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
            this.j.a();
        }
        this.h.setVisibility(0);
        this.f.setImageBitmap(null);
        this.j = new r(this, null);
        this.j.execute(str);
    }
}
