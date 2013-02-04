package com.baidu.tieba.write;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VcodeActivity extends com.baidu.tieba.e {
    private com.baidu.tieba.b.u b = null;
    private Button c = null;
    private Button d = null;
    private ImageView e = null;
    private EditText f = null;
    private ProgressBar g = null;
    private s h = null;
    private r i = null;
    private InputMethodManager j = null;
    private DialogInterface.OnCancelListener k = null;

    public static void a(Activity activity, com.baidu.tieba.b.u uVar, int i) {
        if (uVar == null) {
            return;
        }
        Intent intent = new Intent(activity, VcodeActivity.class);
        intent.putExtra("model", uVar);
        activity.startActivityForResult(intent, i);
    }

    private void a(Bundle bundle) {
        this.k = new n(this);
        if (bundle != null) {
            this.b = (com.baidu.tieba.b.u) bundle.getSerializable("model");
        } else {
            this.b = (com.baidu.tieba.b.u) getIntent().getSerializableExtra("model");
        }
        this.j = (InputMethodManager) getSystemService("input_method");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        if (this.i != null) {
            this.i.a();
        }
        this.g.setVisibility(0);
        this.e.setImageBitmap(null);
        this.i = new r(this, null);
        this.i.execute(str);
    }

    private void g() {
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new o(this));
        this.d = (Button) findViewById(R.id.post);
        this.d.setOnClickListener(new p(this));
        this.f = (EditText) findViewById(R.id.input);
        this.e = (ImageView) findViewById(R.id.vcode_image);
        this.e.setImageBitmap(null);
        this.e.setOnClickListener(new q(this));
        this.g = (ProgressBar) findViewById(R.id.progress);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vcode_activity);
        g();
        a(bundle);
        c(this.b.l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.h != null) {
            this.h.a();
        }
        if (this.i != null) {
            this.i.a();
        }
        if (this.g != null) {
            this.g.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putSerializable("model", this.b);
        super.onSaveInstanceState(bundle);
    }
}
