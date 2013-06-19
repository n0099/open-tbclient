package com.baidu.tieba.media;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.d.ac;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d extends Dialog {
    private Context a;
    private ProgressBar b;
    private TextView c;
    private TextView d;
    private TextView e;
    private Button f;
    private Button g;
    private View h;
    private View i;
    private StringBuilder j;

    public d(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = new StringBuilder();
        this.a = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.media_download_dialog);
        this.b = (ProgressBar) findViewById(R.id.progress);
        this.b.setSecondaryProgress(0);
        this.c = (TextView) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.sub_title);
        this.e = (TextView) findViewById(R.id.progress_percent);
        this.f = (Button) findViewById(R.id.positive);
        this.g = (Button) findViewById(R.id.negative);
        this.h = findViewById(R.id.title_bg);
        this.i = findViewById(R.id.contant_bg);
        this.c = (TextView) findViewById(R.id.title);
        a();
    }

    private void a() {
        if (TiebaApplication.e().as() == 1) {
            this.c.setTextColor(-9207399);
            this.d.setTextColor(-11446171);
            this.e.setTextColor(-11446171);
            this.b.setProgressDrawable(this.a.getResources().getDrawable(R.drawable.tieba_progress_bar_1));
            this.f.setTextColor(this.a.getResources().getColorStateList(R.color.color_black_white_1));
            this.f.setBackgroundResource(R.drawable.btn_white_blue_1);
            this.g.setTextColor(this.a.getResources().getColorStateList(R.color.color_black_white_1));
            this.g.setBackgroundResource(R.drawable.btn_white_blue_1);
            ac.h(this.h, (int) R.drawable.floating_bg_up_1);
            ac.h(this.i, (int) R.drawable.floating_bg_down_1);
            return;
        }
        this.c.setTextColor(-14277082);
        this.d.setTextColor(-10197916);
        this.e.setTextColor(-10197916);
        this.b.setProgressDrawable(this.a.getResources().getDrawable(R.drawable.tieba_progress_bar));
        this.f.setTextColor(this.a.getResources().getColorStateList(R.color.color_black_white));
        this.f.setBackgroundResource(R.drawable.btn_white_blue);
        this.g.setTextColor(this.a.getResources().getColorStateList(R.color.color_black_white));
        this.g.setBackgroundResource(R.drawable.btn_white_blue);
        ac.h(this.h, (int) R.drawable.floating_bg_up);
        ac.h(this.i, (int) R.drawable.floating_bg_down);
    }

    public void a(int i) {
        if (this.b != null && this.e != null) {
            this.b.setProgress(i);
            int max = this.b.getMax();
            if (max > 0) {
                this.j.delete(0, this.j.length());
                this.j.append((i * 100) / max);
                this.j.append("%  ");
                if (i > 1000) {
                    this.j.append(i / 1000);
                    this.j.append("KB");
                } else {
                    this.j.append(i);
                    this.j.append("B");
                }
                this.j.append("/");
                if (max > 1000) {
                    this.j.append(max / 1000);
                    this.j.append("KB");
                } else {
                    this.j.append(max);
                    this.j.append("B");
                }
                this.e.setText(this.j.toString());
                return;
            }
            this.e.setText("0%");
        }
    }

    public void b(int i) {
        if (this.b != null) {
            this.b.setMax(i);
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        if (this.c != null) {
            this.c.setText(charSequence);
        }
    }

    public void a(CharSequence charSequence) {
        if (this.d != null) {
            this.d.setText(charSequence);
        }
    }

    public void a(String str, View.OnClickListener onClickListener) {
        if (this.f != null) {
            this.f.setText(str);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void b(String str, View.OnClickListener onClickListener) {
        if (this.g != null) {
            this.g.setText(str);
            this.g.setOnClickListener(onClickListener);
        }
    }
}
