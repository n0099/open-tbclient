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
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class h {
    private boolean atU = false;
    private Animation dpJ;
    private Animation dpK;
    private ViewGroup dpN;
    private a dpO;
    private g dpP;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void ayG();
    }

    public h(ViewGroup viewGroup) {
        this.dpN = viewGroup;
    }

    public void a(a aVar) {
        this.dpO = aVar;
    }

    public boolean isShowing() {
        return this.atU;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.atU) {
            this.atU = true;
            this.rootView = b(context, list, i);
            this.dpN.addView(this.rootView);
            as.j(this.rootView, n.d.recommend_frs_more_background);
            this.rootView.startAnimation(aK(context));
        }
    }

    public void aJ(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(aL(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(n.h.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(n.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.dpP = new g(context, i);
        this.dpP.bI(list);
        gridView.setAdapter((ListAdapter) this.dpP);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aK(Context context) {
        if (this.dpJ == null) {
            this.dpJ = AnimationUtils.loadAnimation(context, n.a.dialog_ani_t2b_enter);
        }
        return this.dpJ;
    }

    private Animation aL(Context context) {
        if (this.dpK == null) {
            this.dpK = AnimationUtils.loadAnimation(context, n.a.dialog_ani_t2b_exit);
        }
        this.dpK.setAnimationListener(new j(this));
        return this.dpK;
    }

    public void cR(int i) {
        as.j(this.rootView, n.d.recommend_frs_more_background);
        if (this.dpP != null) {
            this.dpP.notifyDataSetChanged();
        }
    }
}
