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
    private LinearLayout c;
    private TextView d;
    private TextView e;
    private Button f;
    private Button g;
    private ProgressBar h;
    private ProgressBar i;
    private ImageView j;
    private View.OnClickListener k;
    private View l;
    private Activity o;
    private o p;
    private String q;
    private String r;
    private int m = 0;
    private int n = 0;
    private p s = null;
    private n t = null;
    private boolean u = false;
    private int v = 0;

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
        this.l = null;
        this.o = null;
        this.p = o.FRS_LIST;
        this.q = null;
        this.r = null;
        this.k = new m(this);
        this.o = activity;
        this.p = oVar;
        this.q = str;
        this.r = str2;
        this.l = LayoutInflater.from(activity).inflate(R.layout.frs_header, (ViewGroup) null);
        if (this.q == null || this.r == null) {
            this.l.setVisibility(8);
        }
        this.a = (LinearLayout) this.l.findViewById(R.id.container);
        this.b = (LinearLayout) this.l.findViewById(R.id.like_button);
        this.c = (LinearLayout) this.l.findViewById(R.id.sign_button);
        this.d = (TextView) this.l.findViewById(R.id.like_text);
        this.e = (TextView) this.l.findViewById(R.id.sign_text);
        this.h = (ProgressBar) this.l.findViewById(R.id.sign_progress);
        this.i = (ProgressBar) this.l.findViewById(R.id.like_progress);
        this.f = (Button) this.l.findViewById(R.id.switch_list);
        this.g = (Button) this.l.findViewById(R.id.switch_image);
        this.b.setOnClickListener(this.k);
        this.c.setOnClickListener(this.k);
        this.f.setOnClickListener(this.k);
        this.g.setOnClickListener(this.k);
        this.j = (ImageView) this.l.findViewById(R.id.divider);
    }

    public void a(int i) {
        this.v = i;
        com.baidu.tieba.c.ae.a(this.a, i);
        if (i == 1) {
            this.j.setBackgroundResource(R.drawable.my_sign_line_1);
            if (this.p == o.FRS_LIST) {
                this.f.setBackgroundResource(R.drawable.frs_list_select_1);
                this.g.setBackgroundResource(R.drawable.frs_image_button_1);
            } else {
                this.g.setBackgroundResource(R.drawable.frs_image_select_1);
                this.f.setBackgroundResource(R.drawable.frs_list_button_1);
            }
            this.e.setCompoundDrawablesWithIntrinsicBounds(this.o.getResources().getDrawable(R.drawable.my_icon_sign_1), (Drawable) null, (Drawable) null, (Drawable) null);
            this.d.setCompoundDrawablesWithIntrinsicBounds(this.o.getResources().getDrawable(R.drawable.add_love_1), (Drawable) null, (Drawable) null, (Drawable) null);
            return;
        }
        this.j.setBackgroundResource(R.drawable.my_sign_line);
        if (this.p == o.FRS_LIST) {
            this.f.setBackgroundResource(R.drawable.frs_list_select);
            this.g.setBackgroundResource(R.drawable.frs_image_button);
        } else {
            this.f.setBackgroundResource(R.drawable.frs_list_button);
            this.g.setBackgroundResource(R.drawable.frs_image_select);
        }
        this.e.setCompoundDrawablesWithIntrinsicBounds(this.o.getResources().getDrawable(R.drawable.my_icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.d.setCompoundDrawablesWithIntrinsicBounds(this.o.getResources().getDrawable(R.drawable.add_love), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void a() {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a(this.o, this.o.getString(R.string.login_to_use), true, 1100002);
        } else if (this.m == 0 && this.t == null) {
            this.t = new n(this, null);
            this.t.execute(new Object[0]);
        }
    }

    public void b() {
        String y = TiebaApplication.y();
        if (y == null || y.length() <= 0) {
            LoginActivity.a(this.o, this.o.getString(R.string.login_to_use), true, 1100014);
        } else if (this.n == 0 && this.s == null) {
            this.s = new p(this, null);
            this.s.execute(new Object[0]);
        }
    }

    public View c() {
        return this.l;
    }

    public void d() {
        this.f.setVisibility(8);
        this.g.setVisibility(8);
    }

    public void a(String str, String str2) {
        this.q = str;
        this.r = str2;
        this.l.setVisibility(0);
    }

    public void a(int i, String str, int i2) {
        Drawable drawable;
        this.m = i;
        Resources resources = this.o.getResources();
        if (i == 0) {
            if (this.v == 1) {
                drawable = resources.getDrawable(R.drawable.add_love_1);
            } else {
                drawable = resources.getDrawable(R.drawable.add_love);
            }
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                ((BitmapDrawable) drawable).setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            this.d.setCompoundDrawables(drawable, null, null, null);
            this.d.setTextColor(resources.getColor(R.color.frs_like_enable));
            this.d.setText(this.o.getString(R.string.ilike));
            return;
        }
        this.d.setCompoundDrawables(null, null, null, null);
        if (str == null) {
            this.d.setTextColor(resources.getColor(R.color.frs_likesign_disable));
            this.d.setText(this.o.getString(R.string.iliked));
            return;
        }
        if (this.v == 1) {
            this.d.setTextColor(resources.getColor(R.color.skin_1_common_color));
        } else {
            this.d.setTextColor(resources.getColor(R.color.frs_like_level_name));
        }
        String str2 = String.valueOf(str) + "  " + String.valueOf(i2) + this.o.getString(R.string.grade);
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.frs_like_level)), "  ".length() + str.length(), str2.length(), 33);
        this.d.setText(spannableString);
    }

    public void b(int i) {
        Drawable drawable;
        Drawable drawable2;
        Bitmap bitmap;
        Drawable drawable3;
        this.n = i;
        Resources resources = this.o.getResources();
        if (i == 0) {
            if (this.v == 1) {
                drawable3 = resources.getDrawable(R.drawable.my_icon_sign_1);
                this.e.setTextColor(resources.getColor(R.color.skin_1_common_color));
            } else {
                drawable3 = resources.getDrawable(R.drawable.my_icon_sign);
                this.e.setTextColor(resources.getColor(R.color.frs_sign_enable));
            }
            this.e.setText(this.o.getString(R.string.sign));
            drawable2 = drawable3;
        } else {
            if (this.v == 1) {
                drawable = resources.getDrawable(R.drawable.my_icon_sign_d_1);
            } else {
                drawable = resources.getDrawable(R.drawable.my_icon_sign_d);
            }
            this.e.setTextColor(resources.getColor(R.color.frs_likesign_disable));
            this.e.setText(this.o.getString(R.string.signed));
            drawable2 = drawable;
        }
        if (drawable2 != null && (drawable2 instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable2).getBitmap()) != null) {
            ((BitmapDrawable) drawable2).setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        this.e.setCompoundDrawables(drawable2, null, null, null);
    }

    public void a(boolean z) {
        this.u = z;
        if (this.u) {
            this.j.setVisibility(0);
            this.c.setVisibility(0);
            return;
        }
        this.j.setVisibility(8);
        this.c.setVisibility(8);
    }

    public void e() {
        if (this.s != null) {
            this.s.a();
        }
        if (this.t != null) {
            this.t.a();
        }
    }
}
