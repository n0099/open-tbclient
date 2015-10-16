package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private boolean arH = false;
    private Animation cJn;
    private Animation cJo;
    private ViewGroup cJr;
    private a cJs;
    private g cJt;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void aqA();
    }

    public h(ViewGroup viewGroup) {
        this.cJr = viewGroup;
    }

    public void a(a aVar) {
        this.cJs = aVar;
    }

    public boolean isShowing() {
        return this.arH;
    }

    public void a(Context context, List<String> list, int i) {
        if (!this.arH) {
            this.arH = true;
            this.rootView = b(context, list, i);
            this.cJr.addView(this.rootView);
            an.j(this.rootView, i.c.recommend_frs_more_background);
            this.rootView.startAnimation(aL(context));
        }
    }

    public void aK(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aM(context));
        }
    }

    private View b(Context context, List<String> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(i.g.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(i.f.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cJt = new g(context, i);
        this.cJt.bq(list);
        gridView.setAdapter((ListAdapter) this.cJt);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aL(Context context) {
        if (this.cJn == null) {
            this.cJn = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_enter);
        }
        return this.cJn;
    }

    private Animation aM(Context context) {
        if (this.cJo == null) {
            this.cJo = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_exit);
        }
        this.cJo.setAnimationListener(new j(this));
        return this.cJo;
    }

    public void cP(int i) {
        an.j(this.rootView, i.c.recommend_frs_more_background);
        if (this.cJt != null) {
            this.cJt.notifyDataSetChanged();
        }
    }
}
