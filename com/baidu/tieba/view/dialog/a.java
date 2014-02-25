package com.baidu.tieba.view.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.k;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private String b;
    private View c;
    private String d;
    private String e;
    private String f;
    private String g;
    private c h;
    private c i;
    private c j;
    private AlertDialog k;
    private Activity l;
    private ViewGroup m;
    private LayoutInflater n;
    private int a = -1;
    private boolean o = false;
    private boolean p = true;

    public a a(String str) {
        this.d = str;
        return this;
    }

    public a a(View view) {
        this.c = view;
        return this;
    }

    public a a(int i) {
        if (this.l != null) {
            this.d = this.l.getResources().getString(i);
        }
        return this;
    }

    public a a(int i, c cVar) {
        if (this.l != null) {
            this.e = this.l.getResources().getString(i);
            this.h = cVar;
        }
        return this;
    }

    public a b(int i, c cVar) {
        if (this.l != null) {
            this.f = this.l.getResources().getString(i);
            this.i = cVar;
        }
        return this;
    }

    public a a(boolean z) {
        this.p = z;
        return this;
    }

    public a(Activity activity) {
        this.l = activity;
        this.n = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.m = (ViewGroup) this.n.inflate(R.layout.dialog_bdalert, (ViewGroup) null);
    }

    public a a() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (!this.o) {
            this.o = true;
            d();
            TextView textView = (TextView) this.m.findViewById(R.id.title);
            LinearLayout linearLayout = (LinearLayout) this.m.findViewById(R.id.content);
            TextView textView2 = (TextView) this.m.findViewById(R.id.message);
            Button button = (Button) this.m.findViewById(R.id.yes);
            Button button2 = (Button) this.m.findViewById(R.id.no);
            Button button3 = (Button) this.m.findViewById(R.id.cancel);
            if (!TextUtils.isEmpty(this.b)) {
                textView.setText(this.b);
            } else {
                textView.setVisibility(8);
            }
            if (this.c != null) {
                linearLayout.removeAllViews();
                linearLayout.addView(this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                textView2.setText(this.d);
            }
            if (TextUtils.isEmpty(this.e)) {
                z = false;
            } else {
                button.setText(this.e);
                if (this.h != null) {
                    button.setOnClickListener(new b(this, this, this.h));
                }
                z = true;
            }
            if (TextUtils.isEmpty(this.f)) {
                z2 = false;
            } else {
                button2.setText(this.f);
                if (this.i != null) {
                    button2.setOnClickListener(new b(this, this, this.i));
                }
                z2 = true;
            }
            if (TextUtils.isEmpty(this.g)) {
                z3 = false;
            } else {
                button3.setText(this.g);
                if (this.j != null) {
                    button3.setOnClickListener(new b(this, this, this.j));
                }
            }
            a(z, z2, z3, button, button2, button3);
        }
        return this;
    }

    private void d() {
        int al = TiebaApplication.g().al();
        if (this.l instanceof com.baidu.tieba.f) {
            com.baidu.tieba.f fVar = (com.baidu.tieba.f) this.l;
            fVar.getLayoutMode().a(al == 1);
            fVar.getLayoutMode().a((View) this.m);
        } else if (this.l instanceof k) {
            k kVar = (k) this.l;
            kVar.a().a(al == 1);
            kVar.a().a((View) this.m);
        }
    }

    private void a(boolean z, boolean z2, boolean z3, Button button, Button button2, Button button3) {
        boolean[] zArr = {z2, z, z3};
        Button[] buttonArr = {button2, button, button3};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            if (zArr[i]) {
                arrayList.add(buttonArr[i]);
                buttonArr[i].setVisibility(0);
            } else {
                buttonArr[i].setVisibility(8);
            }
        }
        if (arrayList.size() == 3) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 3) {
                    break;
                }
                a((Button) arrayList.get(i3), 70, i3 == 2 ? 0 : 10);
                i2 = i3 + 1;
            }
        }
        if (arrayList.size() == 2) {
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= 2) {
                    break;
                }
                a((Button) arrayList.get(i5), SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN, i5 == 1 ? 0 : 10);
                i4 = i5 + 1;
            }
        }
        if (arrayList.size() == 1) {
            a((Button) arrayList.get(0), 230, 0);
        }
    }

    private void a(Button button, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = a(this.l, i);
        layoutParams.rightMargin = i2;
        button.setLayoutParams(layoutParams);
    }

    public a b() {
        if (!this.o) {
            throw new RuntimeException("Dialog must be created by function create()!");
        }
        if (this.k != null) {
            this.k.show();
        } else {
            this.k = new AlertDialog.Builder(this.l).create();
            this.k.setCanceledOnTouchOutside(this.p);
            this.k.show();
            Window window = this.k.getWindow();
            if (this.a == -1) {
                this.a = 17;
            }
            window.setGravity(this.a);
            window.setLayout(-2, -2);
            window.setContentView(this.m);
        }
        return this;
    }

    public void c() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }

    private int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
