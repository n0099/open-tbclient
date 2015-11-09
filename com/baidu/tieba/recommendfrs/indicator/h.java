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
    private boolean aqm = false;
    private Animation cKJ;
    private Animation cKK;
    private ViewGroup cKN;
    private a cKO;
    private g cKP;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void arc();
    }

    public h(ViewGroup viewGroup) {
        this.cKN = viewGroup;
    }

    public void a(a aVar) {
        this.cKO = aVar;
    }

    public boolean isShowing() {
        return this.aqm;
    }

    public void a(Context context, List<String> list, int i) {
        if (!this.aqm) {
            this.aqm = true;
            this.rootView = b(context, list, i);
            this.cKN.addView(this.rootView);
            an.j(this.rootView, i.c.recommend_frs_more_background);
            this.rootView.startAnimation(aK(context));
        }
    }

    public void aJ(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aL(context));
        }
    }

    private View b(Context context, List<String> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(i.g.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(i.f.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cKP = new g(context, i);
        this.cKP.bu(list);
        gridView.setAdapter((ListAdapter) this.cKP);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aK(Context context) {
        if (this.cKJ == null) {
            this.cKJ = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_enter);
        }
        return this.cKJ;
    }

    private Animation aL(Context context) {
        if (this.cKK == null) {
            this.cKK = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_exit);
        }
        this.cKK.setAnimationListener(new j(this));
        return this.cKK;
    }

    public void cP(int i) {
        an.j(this.rootView, i.c.recommend_frs_more_background);
        if (this.cKP != null) {
            this.cKP.notifyDataSetChanged();
        }
    }
}
