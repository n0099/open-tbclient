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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class l {
    private boolean auM = false;
    private View azA;
    private ViewGroup dFC;
    private a dFD;
    private k dFE;
    private Animation dFy;
    private Animation dFz;

    /* loaded from: classes.dex */
    public interface a {
        void aFO();
    }

    public l(ViewGroup viewGroup) {
        this.dFC = viewGroup;
    }

    public void a(a aVar) {
        this.dFD = aVar;
    }

    public boolean isShowing() {
        return this.auM;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.auM) {
            this.auM = true;
            this.azA = b(context, list, i);
            this.dFC.addView(this.azA);
            ar.l(this.azA, t.d.recommend_frs_more_background);
            this.azA.startAnimation(aM(context));
        }
    }

    public void aL(Context context) {
        if (this.azA != null) {
            this.azA.startAnimation(aN(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(t.h.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(t.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.dFE = new k(context, i);
        this.dFE.bU(list);
        gridView.setAdapter((ListAdapter) this.dFE);
        gridView.setOnItemClickListener(new m(this, context));
        return inflate;
    }

    private Animation aM(Context context) {
        if (this.dFy == null) {
            this.dFy = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_enter);
        }
        return this.dFy;
    }

    private Animation aN(Context context) {
        if (this.dFz == null) {
            this.dFz = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_exit);
        }
        this.dFz.setAnimationListener(new n(this));
        return this.dFz;
    }

    public void dk(int i) {
        ar.l(this.azA, t.d.recommend_frs_more_background);
        if (this.dFE != null) {
            this.dFE.notifyDataSetChanged();
        }
    }
}
