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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* loaded from: classes.dex */
public class h {
    private boolean asq = false;
    private Animation djf;
    private Animation djg;
    private ViewGroup djj;
    private a djk;
    private g djl;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void awA();
    }

    public h(ViewGroup viewGroup) {
        this.djj = viewGroup;
    }

    public void a(a aVar) {
        this.djk = aVar;
    }

    public boolean isShowing() {
        return this.asq;
    }

    public void a(Context context, List<ExcellentTagInfo> list, int i) {
        if (!this.asq) {
            this.asq = true;
            this.rootView = b(context, list, i);
            this.djj.addView(this.rootView);
            as.j(this.rootView, n.c.recommend_frs_more_background);
            this.rootView.startAnimation(aK(context));
        }
    }

    public void aJ(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aL(context));
        }
    }

    private View b(Context context, List<ExcellentTagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(n.g.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(n.f.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.djl = new g(context, i);
        this.djl.bG(list);
        gridView.setAdapter((ListAdapter) this.djl);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aK(Context context) {
        if (this.djf == null) {
            this.djf = AnimationUtils.loadAnimation(context, n.a.dialog_ani_t2b_enter);
        }
        return this.djf;
    }

    private Animation aL(Context context) {
        if (this.djg == null) {
            this.djg = AnimationUtils.loadAnimation(context, n.a.dialog_ani_t2b_exit);
        }
        this.djg.setAnimationListener(new j(this));
        return this.djg;
    }

    public void cX(int i) {
        as.j(this.rootView, n.c.recommend_frs_more_background);
        if (this.djl != null) {
            this.djl.notifyDataSetChanged();
        }
    }
}
