package com.baidu.tieba.recommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.FrsHeaderView;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public class ae extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f1635a;
    private com.baidu.tieba.data.ac b;
    private com.baidu.tieba.util.a c;
    private int d;
    private boolean f;
    private View.OnClickListener h;
    private int e = 200;
    private float g = 0.4f;

    public ae(Context context, View.OnClickListener onClickListener) {
        this.d = 200;
        this.f = false;
        this.h = null;
        this.f1635a = context;
        this.c = new com.baidu.tieba.util.a(this.f1635a);
        this.h = onClickListener;
        this.d = com.baidu.tieba.util.am.a(context);
        boolean bl = TiebaApplication.f().bl();
        this.f = bl;
        a(bl);
    }

    public void a(com.baidu.tieba.data.ac acVar) {
        this.b = acVar;
    }

    public void a(boolean z) {
        if (this.f != z) {
            this.f = z;
        }
        this.e = this.d;
        if (this.f) {
            if (this.e > 480) {
                this.e = 480;
            }
            if (this.e > com.baidu.tieba.util.am.a(this.f1635a, 320.0f)) {
                this.e = com.baidu.tieba.util.am.a(this.f1635a, 320.0f);
            }
            this.c.a(1);
            this.c.b("_small");
        } else {
            if (this.e > this.g * 480.0f) {
                this.e = (int) (this.g * 480.0f);
            }
            if (this.e > com.baidu.tieba.util.am.a(this.f1635a, 320.0f) * this.g) {
                this.e = (int) (com.baidu.tieba.util.am.a(this.f1635a, 320.0f) * this.g);
            }
            this.c.a(2);
            this.c.b("_mobile");
        }
        this.c.a(this.e, this.e);
    }

    public com.baidu.tieba.util.a a() {
        return this.c;
    }

    private LinearLayout a(com.baidu.tieba.data.ad adVar, int i, int i2) {
        int i3;
        int i4;
        com.baidu.tieba.view.ap apVar = new com.baidu.tieba.view.ap(this.f1635a, adVar.a());
        LinearLayout linearLayout = new LinearLayout(this.f1635a);
        apVar.setPicNum(i);
        int a2 = this.d - com.baidu.tieba.util.am.a(this.f1635a, 16.0f);
        int a3 = com.baidu.tieba.util.am.a(this.f1635a, 2.0f);
        int i5 = 100;
        if (i == 1) {
            if (this.f) {
                i5 = (int) (a2 * 0.5d);
                i3 = 0;
                i4 = a3;
            } else {
                int i6 = (int) (a2 * this.g);
                i5 = (int) (i6 * 0.5d);
                i4 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                i3 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                a2 = (i6 - i4) - i3;
            }
        } else if (i == 2) {
            a2 /= 2;
            i5 = (a2 * 2) / 3;
            if (i2 != 0) {
                if (i2 == 1) {
                    i4 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                    i3 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = a3;
            } else {
                int a4 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                a2 -= a4;
                i4 = a4;
                i3 = 0;
            }
        } else if (i != 3) {
            a2 = 100;
            i3 = 0;
            i4 = a3;
        } else {
            a2 /= 3;
            i5 = (a2 * 3) / 4;
            if (i2 == 0) {
                int a5 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                a2 -= a5;
                i4 = a5;
                i3 = 0;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    i4 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                    i3 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                    a2 = (a2 - i4) - i3;
                }
                i3 = 0;
                i4 = a3;
            } else {
                int a6 = com.baidu.tieba.util.am.a(this.f1635a, 10.0f);
                a2 -= a6;
                i4 = a6;
                i3 = 0;
            }
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, i5);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, -2);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i3;
        layoutParams2.topMargin = 0;
        layoutParams2.bottomMargin = 0;
        apVar.setTag(adVar.b());
        apVar.setFocusable(false);
        apVar.setLayoutParams(layoutParams);
        apVar.setIsWifi(this.f);
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(apVar);
        return linearLayout;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.b != null) {
            return this.b.a().size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.a().size()) {
            return null;
        }
        return this.b.a().get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = a(i);
        }
        a((af) view.getTag(), (com.baidu.tieba.data.af) getItem(i));
        return view;
    }

    private View a(int i) {
        af afVar = new af(this, null);
        View inflate = LayoutInflater.from(this.f1635a).inflate(R.layout.discovery_list_item, (ViewGroup) null);
        afVar.b = (TextView) inflate.findViewById(R.id.discovery_tag);
        afVar.e = (TextView) inflate.findViewById(R.id.discovery_bar);
        afVar.f = (TextView) inflate.findViewById(R.id.discovery_title);
        afVar.g = (LinearLayout) inflate.findViewById(R.id.discovery_image);
        afVar.h = (TextView) inflate.findViewById(R.id.discovery_abstract);
        afVar.i = (TextView) inflate.findViewById(R.id.discovery_replynum);
        afVar.j = (TextView) inflate.findViewById(R.id.discovery_author);
        afVar.k = (TextView) inflate.findViewById(R.id.discovery_time);
        afVar.c = (LinearLayout) inflate.findViewById(R.id.discovery_head);
        afVar.d = (RelativeLayout) inflate.findViewById(R.id.discovery_bottom);
        afVar.l = inflate.findViewById(R.id.line1);
        afVar.m = inflate.findViewById(R.id.line2);
        afVar.e.setOnClickListener(this.h);
        inflate.setTag(afVar);
        return inflate;
    }

    private void a(af afVar, com.baidu.tieba.data.af afVar2) {
        int i;
        if (afVar2 != null) {
            afVar.b.setText(afVar2.b());
            afVar.e.setText(String.valueOf(afVar2.d()) + this.f1635a.getResources().getString(R.string.bar));
            afVar.i.setText(String.valueOf(afVar2.g()));
            afVar.j.setText(afVar2.i());
            afVar.h.setText(afVar2.j());
            afVar.f.setText(afVar2.f());
            afVar.k.setText(com.baidu.tieba.util.ai.e(new Date(afVar2.h() * 1000)));
            afVar.g.removeAllViews();
            if (afVar2.a() != null) {
                int size = afVar2.a().size();
                if (size > 3) {
                    size = 3;
                }
                for (int i2 = 0; i2 < size; i2++) {
                    afVar.g.addView(a((com.baidu.tieba.data.ad) afVar2.a().get(i2), size, i2));
                }
            }
            int au = TiebaApplication.f().au();
            if (au == 1) {
                i = FrsHeaderView.c[0];
            } else {
                i = FrsHeaderView.b[0];
            }
            try {
                int intValue = Integer.valueOf(afVar2.c()).intValue();
                if (au == 1) {
                    i = FrsHeaderView.c[intValue];
                } else {
                    i = FrsHeaderView.b[intValue];
                }
            } catch (Exception e) {
            }
            afVar.b.setBackgroundResource(i);
            if (au != afVar.f1636a) {
                afVar.f1636a = au;
                com.baidu.tieba.util.ah.c(afVar.e, au);
                com.baidu.tieba.util.ah.c(afVar.f, au);
                com.baidu.tieba.util.ah.e(afVar.h, au);
                com.baidu.tieba.util.ah.d(afVar.j, au);
                com.baidu.tieba.util.ah.d(afVar.k, au);
                com.baidu.tieba.util.ah.d(afVar.i, au);
                if (au == 1) {
                    afVar.c.setBackgroundResource(R.drawable.bg_list_top_1);
                    afVar.d.setBackgroundResource(R.drawable.bg_list_bottom_1);
                    afVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment_1, 0, 0, 0);
                    afVar.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time_1, 0, 0, 0);
                    afVar.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_people_1, 0, 0, 0);
                    afVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_right_1, 0);
                    afVar.l.setBackgroundResource(R.drawable.discovery_dot_line_1);
                    afVar.m.setBackgroundResource(R.drawable.discovery_dot_line_1);
                } else {
                    afVar.c.setBackgroundResource(R.drawable.bg_list_top);
                    afVar.d.setBackgroundResource(R.drawable.bg_list_bottom);
                    afVar.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_comment, 0, 0, 0);
                    afVar.k.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_time, 0, 0, 0);
                    afVar.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_little_people, 0, 0, 0);
                    afVar.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_right, 0);
                    afVar.l.setBackgroundResource(R.drawable.discovery_dot_line);
                    afVar.m.setBackgroundResource(R.drawable.discovery_dot_line);
                }
            }
            afVar.c.setPadding(0, 0, 0, 0);
        }
    }
}
