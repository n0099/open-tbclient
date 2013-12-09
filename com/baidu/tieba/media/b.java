package com.baidu.tieba.media;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.ba;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f1930a;
    private ProgressBar b;
    private TextView c;
    private TextView d;
    private TextView e;
    private Button f;
    private Button g;
    private View h;
    private View i;

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
        if (TiebaApplication.h().an() == 1) {
            this.c.setTextColor(-9207399);
            this.d.setTextColor(-11446171);
            this.e.setTextColor(-11446171);
            this.b.setProgressDrawable(this.f1930a.getResources().getDrawable(R.drawable.tieba_progress_bar_1));
            this.f.setTextColor(this.f1930a.getResources().getColorStateList(R.color.color_black_white_1));
            this.f.setBackgroundResource(R.drawable.btn_white_blue_1);
            this.g.setTextColor(this.f1930a.getResources().getColorStateList(R.color.color_black_white_1));
            this.g.setBackgroundResource(R.drawable.btn_white_blue_1);
            ba.e(this.h, (int) R.drawable.floating_bg_up_1);
            ba.e(this.i, (int) R.drawable.floating_bg_down_1);
            return;
        }
        this.c.setTextColor(-14277082);
        this.d.setTextColor(-10197916);
        this.e.setTextColor(-10197916);
        this.b.setProgressDrawable(this.f1930a.getResources().getDrawable(R.drawable.tieba_progress_bar));
        this.f.setTextColor(this.f1930a.getResources().getColorStateList(R.color.color_black_white));
        this.f.setBackgroundResource(R.drawable.btn_white_blue);
        this.g.setTextColor(this.f1930a.getResources().getColorStateList(R.color.color_black_white));
        this.g.setBackgroundResource(R.drawable.btn_white_blue);
        ba.e(this.h, (int) R.drawable.floating_bg_up);
        ba.e(this.i, (int) R.drawable.floating_bg_down);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        if (this.c != null) {
            this.c.setText(charSequence);
        }
    }
}
