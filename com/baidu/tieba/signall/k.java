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
public class k extends BaseAdapter implements AbsListView.OnScrollListener, aa {
    private a b;
    private Context c;
    private LayoutInflater d;
    private boolean h;
    private TextView i;
    private ArrayList<b> a = new ArrayList<>();
    private HashMap<String, z> e = new HashMap<>();
    private ColorDrawable f = new ColorDrawable(-13881543);
    private ColorDrawable g = new ColorDrawable(-1775893);

    public k(Context context, TextView textView) {
        this.c = context;
        this.i = textView;
        this.d = (LayoutInflater) this.c.getSystemService("layout_inflater");
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
            n nVar = new n(this);
            nVar.a = (HeadImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_avatar);
            nVar.a.setIsRound(false);
            nVar.a.setGifIconSupport(false);
            nVar.c = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_name);
            nVar.d = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level);
            nVar.e = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_exp);
            nVar.f = (FrameLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_res_container);
            nVar.g = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_days);
            nVar.h = (RelativeLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_container);
            nVar.i = (ImageView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_icon);
            nVar.j = (ProgressBar) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_progress);
            nVar.k = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_resign_text);
            nVar.l = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_error);
            nVar.b = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.signallforum_item_level_container);
            nVar.m = (TextView) inflate.findViewById(com.baidu.tieba.v.signallforum_item_increaseexp);
            inflate.setTag(nVar);
            return inflate;
        }
        View view = new View(this.c);
        view.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.j.a(this.c, 1.0f)));
        return view;
    }

    private void a(View view, View view2, int i) {
        BaseActivity baseActivity = (BaseActivity) this.c;
        baseActivity.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        baseActivity.getLayoutMode().a(view);
        n nVar = (n) view.getTag();
        b bVar = (b) getItem(i);
        nVar.c.setText(bVar.b());
        nVar.d.setText(new StringBuilder(String.valueOf(bVar.f())).toString());
        nVar.d.setBackgroundResource(com.baidu.tbadk.core.util.h.b(bVar.f()));
        nVar.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
        nVar.m.clearAnimation();
        nVar.f.clearAnimation();
        if (bVar.i()) {
            nVar.b.setVisibility(0);
            nVar.l.setVisibility(8);
            nVar.g.setVisibility(0);
            nVar.h.setVisibility(8);
            nVar.g.setText(String.format(this.c.getString(com.baidu.tieba.y.signallforum_days), Integer.valueOf(bVar.e())));
            if (bVar.o()) {
                nVar.e.setText(this.c.getString(com.baidu.tieba.y.signallforum_uplevel));
                nVar.m.setVisibility(8);
            } else {
                nVar.e.setText(String.valueOf(bVar.g()) + "/" + bVar.h());
                nVar.m.setVisibility(0);
            }
            int m = bVar.m();
            if (m > 0) {
                nVar.m.setVisibility(0);
                nVar.m.setText("+" + m);
            } else {
                nVar.m.setVisibility(8);
            }
            if (!bVar.l()) {
                m mVar = new m(nVar.f);
                mVar.setDuration(800L);
                mVar.setFillAfter(true);
                mVar.setInterpolator(new DecelerateInterpolator());
                nVar.f.startAnimation(mVar);
                if (m > 0) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(800L);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setInterpolator(new DecelerateInterpolator());
                    nVar.m.startAnimation(alphaAnimation);
                }
                bVar.d(true);
            }
        } else if (bVar.j()) {
            String n = bVar.n();
            if (!TextUtils.isEmpty(n)) {
                nVar.b.setVisibility(8);
                nVar.l.setVisibility(0);
                nVar.m.setVisibility(8);
                nVar.l.setText(n);
            } else {
                nVar.b.setVisibility(0);
                nVar.l.setVisibility(8);
                nVar.m.setVisibility(8);
            }
            nVar.g.setVisibility(8);
            nVar.h.setVisibility(0);
            if (bVar.k()) {
                nVar.i.setVisibility(4);
                nVar.j.setVisibility(0);
                nVar.k.setText(com.baidu.tieba.y.signallforum_resigning);
            } else {
                nVar.i.setVisibility(0);
                nVar.j.setVisibility(4);
                nVar.k.setText(com.baidu.tieba.y.signallforum_resign);
            }
            nVar.h.setOnClickListener(new l(this, bVar, nVar));
        } else {
            nVar.g.setVisibility(8);
            nVar.h.setVisibility(8);
            nVar.m.setVisibility(8);
            nVar.b.setVisibility(0);
            nVar.l.setVisibility(8);
        }
        String c = bVar.c();
        nVar.a.setTag(c);
        nVar.a.a(c, 10, false);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i);
        View a = view == null ? a(itemViewType) : view;
        if (itemViewType == 1) {
            if (TbadkApplication.m252getInst().getSkinType() == 1) {
                a.setBackgroundDrawable(this.f);
            } else {
                a.setBackgroundDrawable(this.g);
            }
        } else {
            a(a, viewGroup, i);
        }
        return a;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // com.baidu.tieba.signall.aa
    public void a(SignData signData) {
        String forumId = signData.getForumId();
        synchronized (this) {
            this.e.remove(forumId);
        }
        a(forumId, true, signData, null);
    }

    @Override // com.baidu.tieba.signall.aa
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            com.baidu.adp.lib.util.j.a(this.c, str2);
        }
        synchronized (this) {
            this.e.remove(str);
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
                    this.i.setText(this.c.getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(size3), Integer.valueOf(size2 - size3)));
                } else {
                    bVar.a(str2);
                }
                if (!this.h) {
                    notifyDataSetChanged();
                    return;
                }
                return;
            }
        }
    }

    public void a() {
        this.h = true;
        synchronized (this) {
            for (Map.Entry<String, z> entry : this.e.entrySet()) {
                entry.getValue().a();
            }
            this.e.clear();
        }
    }
}
