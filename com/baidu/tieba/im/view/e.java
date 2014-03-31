package com.baidu.tieba.im.view;

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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import java.text.MessageFormat;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class e extends Dialog implements View.OnClickListener {
    private Context a;
    private Button b;
    private Button c;
    private TextView d;
    private EditText e;
    private d f;
    private String g;
    private String h;
    private final int i;
    @SuppressLint({"HandlerLeak"})
    private final Handler j;

    public final void a(String str) {
        this.g = str;
    }

    public final void b(String str) {
        this.h = str;
    }

    public e(Context context, int i) {
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
        this.j = new f(this);
        this.a = context;
    }

    public final void a(d dVar) {
        this.f = dVar;
    }

    @Override // android.app.Dialog
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.im.i.chatterbox_edit_dialog);
        this.b = (Button) findViewById(com.baidu.tieba.im.h.chatterbox_edit_confirm);
        this.c = (Button) findViewById(com.baidu.tieba.im.h.chatterbox_edit_cancel);
        this.c.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.d = (TextView) findViewById(com.baidu.tieba.im.h.size_tip);
        this.e = (EditText) findViewById(com.baidu.tieba.im.h.chat_editText);
        this.d.setText(MessageFormat.format(this.a.getResources().getString(com.baidu.tieba.im.j.chat_custom_default_text), "0"));
        this.e.addTextChangedListener(new g(this));
    }

    @Override // android.app.Dialog
    public final void show() {
        super.show();
        this.j.sendEmptyMessage(0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != this.c && view == this.b) {
            this.g = this.e.getText().toString().trim().replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\t", "");
            this.h = null;
            if (TextUtils.isEmpty(this.g)) {
                UtilHelper.a(TbadkApplication.j().b().getApplicationContext(), com.baidu.tieba.im.j.chat_input);
                return;
            } else if (this.f != null) {
                this.f.a(this.g, this.h, false);
            }
        }
        cancel();
    }
}
