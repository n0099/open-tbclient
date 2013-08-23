package com.baidu.tieba.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private Context f1874a;
    private View.OnClickListener e;
    private int b = 200;
    private boolean c = true;
    private float d = 0.4f;
    private r f = new r(this, null);

    public p(Context context) {
        this.f1874a = context;
        this.e = new q(this, context);
    }

    public void a(int i, boolean z, float f) {
        this.b = i;
        this.c = z;
        this.d = f;
    }

    public void a(View view, com.baidu.tieba.data.x xVar) {
        v vVar;
        int i = 0;
        if (view.getTag() != null && (vVar = (v) view.getTag()) != null) {
            vVar.c.setText(String.valueOf(xVar.b()) + this.f1874a.getResources().getString(R.string.forum_name_suffix));
            vVar.c.setTag(xVar.b());
            if (xVar.i() > 0) {
                vVar.d.setText(b(view, xVar));
            } else {
                vVar.d.setText(xVar.d());
            }
            vVar.f.setText(xVar.f());
            vVar.h.setText(String.valueOf(xVar.e()));
            vVar.g.setText(com.baidu.tieba.util.ap.g(new Date(xVar.g() * 1000)));
            if (xVar.h() != null && xVar.h().length() > 0) {
                vVar.e.setText(xVar.h());
                vVar.e.setVisibility(0);
            } else {
                vVar.e.setText((CharSequence) null);
                vVar.e.setVisibility(8);
            }
            vVar.j = xVar.a();
            vVar.k = xVar.c();
            int childCount = vVar.i.getChildCount();
            ArrayList j = xVar.j();
            if (j != null) {
                int size = j.size();
                int i2 = size <= 3 ? size : 3;
                if (i2 == childCount) {
                    while (i < i2) {
                        LinearLayout linearLayout = (LinearLayout) vVar.i.getChildAt(i);
                        if (linearLayout != null) {
                            this.f.a(this.f1874a, linearLayout, this.b, this.c, vVar.m ^ this.c, this.d, (com.baidu.tieba.data.ai) j.get(i), i2, i);
                        }
                        i++;
                    }
                } else {
                    vVar.i.removeAllViews();
                    while (i < i2) {
                        vVar.i.addView(this.f.a(this.f1874a, this.b, this.c, this.d, (com.baidu.tieba.data.ai) j.get(i), i2, i));
                        i++;
                    }
                }
            }
            vVar.m = this.c;
            view.setTag(vVar);
        }
    }

    private SpannableString b(View view, com.baidu.tieba.data.x xVar) {
        Drawable drawable = view.getResources().getDrawable(R.drawable.icon_elite);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, 1);
        SpannableString spannableString = new SpannableString("  " + xVar.d());
        spannableString.setSpan(imageSpan, 0, 1, 18);
        return spannableString;
    }

    public View a() {
        v vVar = new v(this);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f1874a).inflate(R.layout.forum_feed_item, (ViewGroup) null);
        vVar.f1880a = (LinearLayout) linearLayout.findViewById(R.id.layoutForumTop);
        vVar.b = (RelativeLayout) linearLayout.findViewById(R.id.layoutForumBottom);
        vVar.c = (TextView) linearLayout.findViewById(R.id.textHomeListFrsName);
        vVar.d = (TextView) linearLayout.findViewById(R.id.textHomeListTitle);
        vVar.e = (TextView) linearLayout.findViewById(R.id.textHomeListAbstract);
        vVar.f = (TextView) linearLayout.findViewById(R.id.textHomeListAuthor);
        vVar.g = (TextView) linearLayout.findViewById(R.id.textHomeListTime);
        vVar.h = (TextView) linearLayout.findViewById(R.id.textHomeListRplyNum);
        vVar.i = (LinearLayout) linearLayout.findViewById(R.id.layoutFeedImage);
        vVar.c.setOnClickListener(this.e);
        linearLayout.setOnClickListener(this.e);
        linearLayout.setTag(vVar);
        return linearLayout;
    }

    public void a(int i, View view) {
        v vVar;
        if (view != null && (vVar = (v) view.getTag()) != null && vVar.l != i) {
            switch (i) {
                case 1:
                    b(vVar);
                    break;
                default:
                    a(vVar);
                    break;
            }
            vVar.l = i;
        }
    }

    private void a(v vVar) {
        Resources resources = this.f1874a.getResources();
        com.baidu.tieba.util.ao.g((View) vVar.c, (int) R.drawable.bg_forum_feed_label);
        vVar.c.setTextColor(resources.getColor(R.color.white));
        vVar.d.setTextColor(resources.getColor(R.color.c_262626));
        vVar.f1880a.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_top));
        vVar.e.setTextSize(12.0f);
        vVar.e.setTextColor(resources.getColor(R.color.c_777777));
        vVar.f.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_people), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.f.setPadding(UtilHelper.a(this.f1874a, 11.0f), 0, 0, 0);
        vVar.f.setTextColor(resources.getColor(R.color.c_b2b6ba));
        vVar.g.setTextColor(resources.getColor(R.color.c_b2b6ba));
        vVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_forum_feed_little_comment_s), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.h.setTextColor(resources.getColor(R.color.c_6697d4));
        vVar.b.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_bottom));
    }

    private void b(v vVar) {
        Resources resources = this.f1874a.getResources();
        com.baidu.tieba.util.ao.g((View) vVar.c, (int) R.drawable.bg_forum_feed_label_1);
        vVar.c.setTextColor(resources.getColor(R.color.c_acc5e0));
        vVar.d.setTextColor(resources.getColor(R.color.c_7b8591));
        vVar.e.setTextSize(14.0f);
        vVar.e.setTextColor(resources.getColor(R.color.c_515865));
        vVar.f.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_little_people_1), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.f.setPadding(UtilHelper.a(this.f1874a, 11.0f), 0, 0, 0);
        vVar.f.setTextColor(resources.getColor(R.color.c_738199));
        vVar.g.setTextColor(resources.getColor(R.color.c_738199));
        vVar.h.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.icon_forum_feed_little_comment_s_1), (Drawable) null, (Drawable) null, (Drawable) null);
        vVar.h.setTextColor(resources.getColor(R.color.c_608abf));
        vVar.f1880a.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_top_1));
        vVar.b.setBackgroundDrawable(resources.getDrawable(R.drawable.bg_list_bottom_1));
    }
}
