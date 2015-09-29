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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private boolean arG = false;
    private Animation cIO;
    private Animation cIP;
    private ViewGroup cIS;
    private a cIT;
    private g cIU;
    private View rootView;

    /* loaded from: classes.dex */
    public interface a {
        void aqu();
    }

    public h(ViewGroup viewGroup) {
        this.cIS = viewGroup;
    }

    public void a(a aVar) {
        this.cIT = aVar;
    }

    public boolean isShowing() {
        return this.arG;
    }

    public void a(Context context, List<String> list, int i) {
        if (!this.arG) {
            this.arG = true;
            this.rootView = b(context, list, i);
            this.cIS.addView(this.rootView);
            am.j(this.rootView, i.c.recommend_frs_more_background);
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
        this.cIU = new g(context, i);
        this.cIU.bp(list);
        gridView.setAdapter((ListAdapter) this.cIU);
        gridView.setOnItemClickListener(new i(this, context));
        return inflate;
    }

    private Animation aL(Context context) {
        if (this.cIO == null) {
            this.cIO = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_enter);
        }
        return this.cIO;
    }

    private Animation aM(Context context) {
        if (this.cIP == null) {
            this.cIP = AnimationUtils.loadAnimation(context, i.a.dialog_ani_t2b_exit);
        }
        this.cIP.setAnimationListener(new j(this));
        return this.cIP;
    }

    public void cP(int i) {
        am.j(this.rootView, i.c.recommend_frs_more_background);
        if (this.cIU != null) {
            this.cIU.notifyDataSetChanged();
        }
    }
}
