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
    private boolean atj = false;
    private Animation cBN;
    private Animation cBO;
    private ViewGroup cBR;
    private a cBS;
    private g cBT;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void aoc();
    }

    public h(ViewGroup viewGroup) {
        this.cBR = viewGroup;
    }

    public void a(a aVar) {
        this.cBS = aVar;
    }

    public boolean isShowing() {
        return this.atj;
    }

    public void a(Context context, List<String> list, int i) {
        if (!this.atj) {
            this.atj = true;
            this.rootView = b(context, list, i);
            this.cBR.addView(this.rootView);
            al.i(this.rootView, i.c.recommend_frs_more_background);
            this.rootView.startAnimation(aM(context));
        }
    }

    public void aL(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aN(context));
        }
    }

    private View b(Context context, List<String> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(i.g.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(i.f.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.cBT = new g(context, i);
        this.cBT.bn(list);
        gridView.setAdapter((ListAdapter) this.cBT);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aM(Context context) {
        if (this.cBN == null) {
            this.cBN = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_enter);
        }
        return this.cBN;
    }

    private Animation aN(Context context) {
        if (this.cBO == null) {
            this.cBO = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_exit);
        }
        this.cBO.setAnimationListener(new j(this));
        return this.cBO;
    }

    public void cO(int i) {
        al.i(this.rootView, i.c.recommend_frs_more_background);
        if (this.cBT != null) {
            this.cBT.notifyDataSetChanged();
        }
    }
}
