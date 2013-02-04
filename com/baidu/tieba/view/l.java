package com.baidu.tieba.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
/* loaded from: classes.dex */
public class l {
    private LinearLayout a;
    private LinearLayout b;
    private TextView c;
    private TextView d;
    private Button e;
    private Button f;
    private ProgressBar g;
    private ProgressBar h;
    private ImageView i;
    private View.OnClickListener j;
    private View k;
    private Activity n;
    private o o;
    private String p;
    private String q;
    private int l = 0;
    private int m = 0;
    private p r = null;
    private n s = null;
    private boolean t = false;

    public l(Activity activity, o oVar, String str, String str2) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.n = null;
        this.o = o.FRS_LIST;
        this.p = null;
        this.q = null;
        this.j = new m(this);
        this.n = activity;
        this.o = oVar;
        this.p = str;
        this.q = str2;
        this.k = LayoutInflater.from(activity).inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.p == null || this.q == null) {
            this.k.setVisibility(8);
        }
        this.a = (LinearLayout) this.k.findViewById(R.id.like_button);
        this.b = (LinearLayout) this.k.findViewById(R.id.sign_button);
        this.c = (TextView) this.k.findViewById(R.id.like_text);
        this.d = (TextView) this.k.findViewById(R.id.sign_text);
        this.g = (ProgressBar) this.k.findViewById(R.id.sign_progress);
        this.h = (ProgressBar) this.k.findViewById(R.id.like_progress);
        this.e = (Button) this.k.findViewById(R.id.switch_list);
        this.f = (Button) this.k.findViewById(R.id.switch_image);
        this.a.setOnClickListener(this.j);
        this.b.setOnClickListener(this.j);
        this.e.setOnClickListener(this.j);
        this.f.setOnClickListener(this.j);
        this.i = (ImageView) this.k.findViewById(R.id.divider);
        if (this.o == o.FRS_LIST) {
            this.e.setBackgroundResource(R.drawable.frs_list_select);
        } else {
            this.f.setBackgroundResource(R.drawable.frs_image_select);
        }
    }

    public void a() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a(this.n, this.n.getString(R.string.login_to_use), true, 1100002);
        } else if (this.l == 0 && this.s == null) {
            this.s = new n(this, null);
            this.s.execute(new Object[0]);
        }
    }

    public void a(int i) {
        Drawable drawable;
        Bitmap bitmap;
        this.m = i;
        Resources resources = this.n.getResources();
        if (i == 0) {
            drawable = resources.getDrawable(R.drawable.my_icon_sign);
            this.d.setTextColor(resources.getColor(R.color.frs_sign_enable));
            this.d.setText(this.n.getString(R.string.sign));
        } else {
            drawable = resources.getDrawable(R.drawable.my_icon_sign_d);
            this.d.setTextColor(resources.getColor(R.color.frs_likesign_disable));
            this.d.setText(this.n.getString(R.string.signed));
        }
        if (drawable != null && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            ((BitmapDrawable) drawable).setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        this.d.setCompoundDrawables(drawable, null, null, null);
    }

    public void a(int i, String str, int i2) {
        this.l = i;
        Resources resources = this.n.getResources();
        if (i == 0) {
            Drawable drawable = resources.getDrawable(R.drawable.add_love);
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                ((BitmapDrawable) drawable).setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            this.c.setCompoundDrawables(drawable, null, null, null);
            this.c.setTextColor(resources.getColor(R.color.frs_like_enable));
            this.c.setText(this.n.getString(R.string.ilike));
            return;
        }
        this.c.setCompoundDrawables(null, null, null, null);
        if (str == null) {
            this.c.setTextColor(resources.getColor(R.color.frs_likesign_disable));
            this.c.setText(this.n.getString(R.string.iliked));
            return;
        }
        this.c.setTextColor(resources.getColor(R.color.frs_like_level_name));
        String str2 = String.valueOf(str) + "  " + String.valueOf(i2) + this.n.getString(R.string.grade);
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.frs_like_level)), "  ".length() + str.length(), str2.length(), 33);
        this.c.setText(spannableString);
    }

    public void a(String str, String str2) {
        this.p = str;
        this.q = str2;
        this.k.setVisibility(0);
    }

    public void a(boolean z) {
        this.t = z;
        if (this.t) {
            this.i.setVisibility(0);
            this.b.setVisibility(0);
            return;
        }
        this.i.setVisibility(8);
        this.b.setVisibility(8);
    }

    public void b() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            LoginActivity.a(this.n, this.n.getString(R.string.login_to_use), true, 1100014);
        } else if (this.m == 0 && this.r == null) {
            this.r = new p(this, null);
            this.r.execute(new Object[0]);
        }
    }

    public View c() {
        return this.k;
    }

    public void d() {
        this.e.setVisibility(8);
        this.f.setVisibility(8);
    }

    public void e() {
        if (this.r != null) {
            this.r.a();
        }
        if (this.s != null) {
            this.s.a();
        }
    }
}
