package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.text.MessageFormat;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class m extends Dialog implements View.OnClickListener {
    private Context a;
    private Button b;
    private Button c;
    private TextView d;
    private EditText e;
    private l f;
    private String g;
    private String h;
    private final int i;
    @SuppressLint({"HandlerLeak"})
    private Handler j;

    public void a(String str) {
        this.g = str;
    }

    public void b(String str) {
        this.h = str;
    }

    public m(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = new n(this);
        this.a = context;
    }

    public void a(l lVar) {
        this.f = lVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chatterbox_edit_dialog);
        this.b = (Button) findViewById(R.id.chatterbox_edit_confirm);
        this.c = (Button) findViewById(R.id.chatterbox_edit_cancel);
        this.c.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d = (TextView) findViewById(R.id.size_tip);
        this.e = (EditText) findViewById(R.id.chat_editText);
        this.d.setText(MessageFormat.format(this.a.getResources().getString(R.string.chat_custom_default_text), SocialConstants.FALSE));
        this.e.addTextChangedListener(new o(this));
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.j.sendEmptyMessage(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.c && view == this.b) {
            this.g = this.e.getText().toString().trim().replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\t", "");
            this.h = null;
            if (TextUtils.isEmpty(this.g)) {
                UtilHelper.a(TiebaApplication.g().b().getApplicationContext(), (int) R.string.chat_input);
                return;
            } else if (this.f != null) {
                this.f.a(this.g, this.h, false);
            }
        }
        cancel();
    }
}
