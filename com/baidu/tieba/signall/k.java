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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ai;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends BaseAdapter implements AbsListView.OnScrollListener, ab {
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

    public void a(a aVar) {
        this.b = aVar;
        this.a = aVar.j();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i % 2 == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.size() * 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i % 2 == 0) {
            return this.a.get(i / 2);
        }
        return -1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    private View a(int i) {
        if (i == 0) {
            View inflate = this.d.inflate(com.baidu.tieba.w.signallforum_item, (ViewGroup) null);
            o oVar = new o(this);
            oVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            oVar.a.setIsRound(false);
            oVar.a.setGifIconSupport(false);
            oVar.c = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            oVar.d = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            oVar.e = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            oVar.f = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            oVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            oVar.h = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            oVar.i = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            oVar.j = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            oVar.k = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            oVar.l = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            oVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            oVar.m = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(oVar);
            return inflate;
        }
        View view = new View(this.c);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.a(this.c, 1.0f)));
        return view;
    }

    private void a(View view, View view2, int i) {
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(view);
        o oVar = (o) view.getTag();
        b bVar = (b) getItem(i);
        oVar.c.setText(bVar.b());
        oVar.d.setText(new StringBuilder(String.valueOf(bVar.f())).toString());
        oVar.d.setBackgroundResource(com.baidu.tbadk.core.util.g.b(bVar.f()));
        oVar.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
        oVar.m.clearAnimation();
        oVar.f.clearAnimation();
        if (bVar.i()) {
            oVar.b.setVisibility(0);
            oVar.l.setVisibility(8);
            oVar.g.setVisibility(0);
            oVar.h.setVisibility(8);
            oVar.g.setText(String.format(this.c.getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(bVar.e())));
            if (bVar.o()) {
                oVar.e.setText(this.c.getString(com.baidu.tieba.y.signallforum_uplevel));
                oVar.m.setVisibility(8);
            } else {
                oVar.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
                oVar.m.setVisibility(0);
            }
            int m = bVar.m();
            if (m > 0) {
                oVar.m.setVisibility(0);
                oVar.m.setText("+" + m);
            } else {
                oVar.m.setVisibility(8);
            }
            if (!bVar.l()) {
                n nVar = new n(oVar.f);
                nVar.setDuration(800L);
                nVar.setFillAfter(true);
                nVar.setInterpolator(new DecelerateInterpolator());
                oVar.f.startAnimation(nVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    oVar.m.startAnimation(alphaAnimation);
                }
                bVar.d(true);
            }
        } else if (bVar.j()) {
            String n = bVar.n();
            if (!TextUtils.isEmpty(n)) {
                oVar.b.setVisibility(8);
                oVar.l.setVisibility(0);
                oVar.m.setVisibility(8);
                oVar.l.setText(n);
            } else {
                oVar.b.setVisibility(0);
                oVar.l.setVisibility(8);
                oVar.m.setVisibility(8);
            }
            oVar.g.setVisibility(8);
            oVar.h.setVisibility(0);
            if (bVar.k()) {
                oVar.i.setVisibility(4);
                oVar.j.setVisibility(0);
                oVar.k.setText(com.baidu.tieba.y.signallforum_resigning);
            } else {
                oVar.i.setVisibility(0);
                oVar.j.setVisibility(4);
                oVar.k.setText(com.baidu.tieba.y.signallforum_resign);
            }
            oVar.h.setOnClickListener(new l(this, bVar, oVar));
        } else {
            oVar.g.setVisibility(8);
            oVar.h.setVisibility(8);
            oVar.m.setVisibility(8);
            oVar.b.setVisibility(0);
            oVar.l.setVisibility(8);
        }
        String c = bVar.c();
        oVar.a.setTag(c);
        if (this.f.d(c) != null) {
            oVar.a.invalidate();
        } else if (!this.e) {
            this.f.b(bVar.c(), new m(this, view2));
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        View a = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                a.setBackgroundDrawable(this.h);
            } else {
                a.setBackgroundDrawable(this.i);
            }
        } else {
            a(a, viewGroup, i);
        }
        return a;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.e = false;
            notifyDataSetChanged();
            return;
        }
        this.e = true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.ab
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.g.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.ab
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.k.a(this.c, str2);
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
                    ai.c().a(bVar.b(), signData.getBonusPoint(), -1);
                    ArrayList<b> m = this.b.m();
                    if (m.contains(bVar)) {
                        m.remove(bVar);
                        this.b.l().add(bVar);
                    }
                    int size2 = this.b.j().size();
                    int size3 = this.b.l().size();
                    this.k.setText(this.c.getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
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

    public void a() {
        this.j = true;
        synchronized (this) {
            for (Map.Entry<String, aa> entry : this.g.entrySet()) {
                entry.getValue().a();
            }
            this.g.clear();
        }
    }

    public void b() {
        if (this.f != null) {
            this.f.d();
        }
    }
}
