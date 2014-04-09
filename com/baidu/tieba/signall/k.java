package com.baidu.tieba.signall;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class k extends BaseAdapter implements AbsListView.OnScrollListener, ab {
    private a b;
    private Context c;
    private LayoutInflater d;
    private volatile boolean e;
    private com.baidu.tbadk.editortool.ab f;
    private boolean j;
    private TextView k;
    private ArrayList<b> a = new ArrayList<>();
    private HashMap<String, aa> g = new HashMap<>();
    private ColorDrawable h = new ColorDrawable(-13881543);
    private ColorDrawable i = new ColorDrawable(-1775893);

    public k(Context context, TextView textView) {
        this.c = context;
        this.k = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
        this.f = new com.baidu.tbadk.editortool.ab(this.c);
    }

    public final void a(a aVar) {
        this.b = aVar;
        this.a = aVar.j();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getItemViewType(int i) {
        return i % 2 == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size() * 2;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i % 2 == 0) {
            return this.a.get(i / 2);
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        View view3;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            if (itemViewType == 0) {
                View inflate = this.d.inflate(com.baidu.tieba.a.i.signallforum_item, (ViewGroup) null);
                o oVar = new o(this);
                oVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_avatar);
                oVar.a.setIsRound(false);
                oVar.a.setGifIconSupport(false);
                oVar.c = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_name);
                oVar.d = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_level);
                oVar.e = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_exp);
                oVar.f = (FrameLayout) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_res_container);
                oVar.g = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_days);
                oVar.h = (RelativeLayout) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_resign_container);
                oVar.i = (ImageView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_resign_icon);
                oVar.j = (ProgressBar) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_resign_progress);
                oVar.k = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_resign_text);
                oVar.l = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_error);
                oVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_level_container);
                oVar.m = (TextView) inflate.findViewById(com.baidu.tieba.a.h.signallforum_item_increaseexp);
                inflate.setTag(oVar);
                view3 = inflate;
            } else {
                view3 = new View(this.c);
                view3.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.i.a(this.c, 1.0f)));
            }
            view2 = view3;
        } else {
            view2 = view;
        }
        if (itemViewType == 1) {
            if (TbadkApplication.j().l() == 1) {
                view2.setBackgroundDrawable(this.h);
            } else {
                view2.setBackgroundDrawable(this.i);
            }
            return view2;
        }
        com.baidu.tbadk.a aVar = (com.baidu.tbadk.a) this.c;
        aVar.getLayoutMode().a(TbadkApplication.j().l() == 1);
        aVar.getLayoutMode().a(view2);
        o oVar2 = (o) view2.getTag();
        b bVar = (b) getItem(i);
        oVar2.c.setText(bVar.b());
        oVar2.d.setText(new StringBuilder(String.valueOf(bVar.f())).toString());
        oVar2.d.setBackgroundResource(com.baidu.tbadk.core.util.g.b(bVar.f()));
        oVar2.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
        oVar2.m.clearAnimation();
        oVar2.f.clearAnimation();
        if (bVar.i()) {
            oVar2.b.setVisibility(0);
            oVar2.l.setVisibility(8);
            oVar2.g.setVisibility(0);
            oVar2.h.setVisibility(8);
            oVar2.g.setText(String.format(this.c.getString(com.baidu.tieba.a.k.signallforum_days), Integer.valueOf(bVar.e())));
            if (bVar.o()) {
                oVar2.e.setText(this.c.getString(com.baidu.tieba.a.k.signallforum_uplevel));
                oVar2.m.setVisibility(8);
            } else {
                oVar2.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
                oVar2.m.setVisibility(0);
            }
            int m = bVar.m();
            if (m > 0) {
                oVar2.m.setVisibility(0);
                oVar2.m.setText("+" + m);
            } else {
                oVar2.m.setVisibility(8);
            }
            if (!bVar.l()) {
                n nVar = new n(oVar2.f);
                nVar.setDuration(800L);
                nVar.setFillAfter(true);
                nVar.setInterpolator(new DecelerateInterpolator());
                oVar2.f.startAnimation(nVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    oVar2.m.startAnimation(alphaAnimation);
                }
                bVar.d(true);
            }
        } else if (bVar.j()) {
            String n = bVar.n();
            if (TextUtils.isEmpty(n)) {
                oVar2.b.setVisibility(0);
                oVar2.l.setVisibility(8);
                oVar2.m.setVisibility(8);
            } else {
                oVar2.b.setVisibility(8);
                oVar2.l.setVisibility(0);
                oVar2.m.setVisibility(8);
                oVar2.l.setText(n);
            }
            oVar2.g.setVisibility(8);
            oVar2.h.setVisibility(0);
            if (bVar.k()) {
                oVar2.i.setVisibility(4);
                oVar2.j.setVisibility(0);
                oVar2.k.setText(com.baidu.tieba.a.k.signallforum_resigning);
            } else {
                oVar2.i.setVisibility(0);
                oVar2.j.setVisibility(4);
                oVar2.k.setText(com.baidu.tieba.a.k.signallforum_resign);
            }
            oVar2.h.setOnClickListener(new l(this, bVar, oVar2));
        } else {
            oVar2.g.setVisibility(8);
            oVar2.h.setVisibility(8);
            oVar2.m.setVisibility(8);
            oVar2.b.setVisibility(0);
            oVar2.l.setVisibility(8);
        }
        String c = bVar.c();
        oVar2.a.setTag(c);
        com.baidu.tbadk.editortool.ab abVar = this.f;
        if (com.baidu.tbadk.imageManager.e.a().c(c) != null) {
            oVar2.a.invalidate();
        } else if (!this.e) {
            this.f.b(bVar.c(), new m(this, viewGroup));
        }
        return view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.e = false;
            notifyDataSetChanged();
            return;
        }
        this.e = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.ab
    public final void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.g.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab
    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.i.a(this.c, str2);
        }
        synchronized (this) {
            this.g.remove(str);
        }
        a(str, false, null, str2);
    }

    private void a(String str, boolean z, SignData signData, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.a.get(i);
            if (new StringBuilder(String.valueOf(bVar.a())).toString().equals(str)) {
                bVar.a(z);
                bVar.b(!z);
                bVar.c(false);
                if (z) {
                    bVar.b(signData.getCountSignNum());
                    bVar.d(signData.getBonusPoint());
                    bVar.a(1);
                    com.baidu.tieba.p.c().a(bVar.b(), signData.getBonusPoint(), -1);
                    ArrayList<b> m = this.b.m();
                    if (m.contains(bVar)) {
                        m.remove(bVar);
                        this.b.l().add(bVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(this.c.getString(com.baidu.tieba.a.k.signallforum_res, Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
                } else {
                    bVar.a(str2);
                }
                if (!this.j) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public final void a() {
        this.j = true;
        synchronized (this) {
            for (Map.Entry<String, aa> entry : this.g.entrySet()) {
                entry.getValue().a();
            }
            this.g.clear();
        }
    }

    public final void b() {
        if (this.f != null) {
            this.f.c();
        }
    }
}
