package com.baidu.tieba.widget.share;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class d implements View.OnClickListener {
    private LayoutInflater a;
    private Context b;
    private View c;
    private TextView d;
    private View e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private Button l;
    private LinearLayout m;
    private AlertDialog n;
    private SparseArray<String> q;
    private SparseArray<f> o = new SparseArray<>(7);
    private boolean p = false;
    private a r = new e(this);

    public d(Context context) {
        this.b = context;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = this.a.inflate(R.layout.share_dialog_content, (ViewGroup) null);
        this.d = (TextView) this.c.findViewById(R.id.share_dialog_title);
        this.e = this.c.findViewById(R.id.share_dialog_content);
        this.l = (Button) this.c.findViewById(R.id.btnShareCancel);
        this.l.setOnClickListener(this);
        this.f = (TextView) this.c.findViewById(R.id.iconWeixinTimeline);
        this.f.setOnClickListener(this);
        this.g = (TextView) this.c.findViewById(R.id.iconWeixin);
        this.g.setOnClickListener(this);
        this.h = (TextView) this.c.findViewById(R.id.iconQZone);
        this.h.setOnClickListener(this);
        this.i = (TextView) this.c.findViewById(R.id.iconQQWeibo);
        this.i.setOnClickListener(this);
        this.j = (TextView) this.c.findViewById(R.id.iconSinaWeibo);
        this.j.setOnClickListener(this);
        this.k = (TextView) this.c.findViewById(R.id.iconRenren);
        this.k.setOnClickListener(this);
        this.m = (LinearLayout) this.c.findViewById(R.id.customViewBox);
    }

    public final void a(SparseArray<String> sparseArray) {
        this.q = sparseArray;
    }

    public final void a(f fVar, boolean z) {
        Location b = b();
        if (b != null) {
            fVar.e = b;
        }
        this.o.put(1, fVar);
    }

    public final void a(int i, f fVar, boolean z) {
        Location b = b();
        if (b != null) {
            fVar.e = b;
        }
        this.o.put(3, fVar);
    }

    private Location b() {
        LocationManager locationManager = (LocationManager) this.b.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(1);
        try {
            return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        } catch (Exception e) {
            return null;
        }
    }

    public final void a(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            this.m.addView(view);
            if (onClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
            this.m.setVisibility(0);
        }
    }

    public final void a() {
        if (!UtilHelper.b()) {
            BdUtilHelper.a(this.b, (int) R.string.share_on_no_network);
            return;
        }
        this.n = new AlertDialog.Builder(this.b).create();
        this.n.setCanceledOnTouchOutside(true);
        this.n.show();
        Window window = this.n.getWindow();
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        a aVar = this.r;
        if (aVar != null) {
            this.r = aVar;
        }
        window.setContentView(this.c);
        a(this.f, R.drawable.icon_unite_share_friend, R.color.share_to, R.drawable.icon_unite_share_friend_1, R.color.share_to_1);
        a(this.g, R.drawable.icon_unite_share_weixin, R.color.share_to, R.drawable.icon_unite_share_weixin_1, R.color.share_to_1);
        a(this.h, R.drawable.icon_unite_share_qqzon, R.color.share_to, R.drawable.icon_unite_share_qqzon_1, R.color.share_to_1);
        a(this.i, R.drawable.icon_unite_share_tencent, R.color.share_to, R.drawable.icon_unite_share_tencent_1, R.color.share_to_1);
        a(this.j, R.drawable.icon_unite_share_sina, R.color.share_to, R.drawable.icon_unite_share_sina_1, R.color.share_to_1);
        a(this.k, R.drawable.icon_unite_share_renren, R.color.share_to, R.drawable.icon_unite_share_renren_1, R.color.share_to_1);
        int paddingLeft = this.d.getPaddingLeft();
        if (TiebaApplication.g().ae() == 1) {
            this.e.setBackgroundResource(R.drawable.bg_unite_popup_share_down_1);
            this.d.setBackgroundResource(R.drawable.bg_unite_popup_share_up_1);
            this.d.setTextColor(this.b.getResources().getColor(R.color.share_to_1));
            this.l.setBackgroundResource(R.drawable.btn_w_square_1);
            this.l.setTextColor(this.b.getResources().getColor(R.color.share_to_1));
        } else {
            this.e.setBackgroundResource(R.drawable.bg_unite_popup_share_down);
            this.d.setBackgroundResource(R.drawable.bg_unite_popup_share_up);
            this.d.setTextColor(this.b.getResources().getColor(R.color.share_to));
            this.l.setBackgroundResource(R.drawable.btn_w_square);
            this.l.setTextColor(this.b.getResources().getColor(R.color.share_to));
        }
        this.d.setPadding(paddingLeft, 0, 0, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.n != null) {
            this.p = false;
            this.n.dismiss();
        }
        if (this.o.size() != 0) {
            if (view.getId() == R.id.btnShareCancel || !this.p) {
                this.p = true;
                g gVar = new g(this.b, this.r);
                int id = view.getId();
                if (id == R.id.btnShareCancel) {
                    a("share_cancel");
                    a aVar = this.r;
                } else if (id == R.id.iconWeixin) {
                    a("share_to_weixin");
                    b(3);
                    f a = a(3);
                    if (a != null) {
                        gVar.a(a);
                    }
                } else if (id == R.id.iconWeixinTimeline) {
                    a("share_to_pyq");
                    b(2);
                    f a2 = a(2);
                    if (a2 != null) {
                        gVar.b(a2);
                    }
                } else if (id == R.id.iconQZone) {
                    a("share_to_qzone");
                    b(4);
                    f a3 = a(4);
                    if (a3 != null) {
                        gVar.c(a3);
                    }
                } else if (id == R.id.iconQQWeibo) {
                    a("share_to_qweibo");
                    b(5);
                    f a4 = a(5);
                    if (a4 != null) {
                        gVar.d(a4);
                    }
                } else if (id == R.id.iconSinaWeibo) {
                    a("share_to_sweibo");
                    b(6);
                    f a5 = a(6);
                    if (a5 != null) {
                        gVar.e(a5);
                    }
                } else if (id == R.id.iconRenren) {
                    a("share_to_renren");
                    b(7);
                    f a6 = a(7);
                    if (a6 != null) {
                        gVar.f(a6);
                    }
                }
            }
        }
    }

    private f a(int i) {
        f fVar = this.o.get(i);
        if (fVar == null) {
            return this.o.get(1);
        }
        return fVar;
    }

    private void b(int i) {
        if (i <= 7 && i > 0) {
            this.p = true;
            if (this.q != null) {
                String str = this.q.get(i);
                if (!bs.c(str)) {
                    a(str);
                }
            }
        }
    }

    private void a(String str) {
        cb.a(this.b, str, "click", 1, new Object[0]);
    }

    private void a(TextView textView, int i, int i2, int i3, int i4) {
        int ae = TiebaApplication.g().ae();
        if (ae != 1) {
            i3 = i;
        }
        int i5 = ae == 1 ? R.color.share_to_1 : R.color.share_to;
        Drawable drawable = this.b.getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setTextColor(this.b.getResources().getColor(i5));
    }
}
