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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private boolean arz = false;
    private a ctA;
    private g ctB;
    private Animation ctv;
    private Animation ctw;
    private ViewGroup ctz;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void ajW();
    }

    public h(ViewGroup viewGroup) {
        this.ctz = viewGroup;
    }

    public void a(a aVar) {
        this.ctA = aVar;
    }

    public boolean isShowing() {
        return this.arz;
    }

    public void a(Context context, List<String> list, int i) {
        if (!this.arz) {
            this.arz = true;
            this.rootView = b(context, list, i);
            this.ctz.addView(this.rootView);
            al.j(this.rootView, i.c.recommend_frs_more_background);
            this.rootView.startAnimation(aJ(context));
        }
    }

    public void aI(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aK(context));
        }
    }

    private View b(Context context, List<String> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(i.g.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(i.f.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.ctB = new g(context, i);
        this.ctB.bf(list);
        gridView.setAdapter((ListAdapter) this.ctB);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aJ(Context context) {
        if (this.ctv == null) {
            this.ctv = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_enter);
        }
        return this.ctv;
    }

    private Animation aK(Context context) {
        if (this.ctw == null) {
            this.ctw = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_exit);
        }
        this.ctw.setAnimationListener(new j(this));
        return this.ctw;
    }

    public void cI(int i) {
        al.j(this.rootView, i.c.recommend_frs_more_background);
        if (this.ctB != null) {
            this.ctB.notifyDataSetChanged();
        }
    }
}
