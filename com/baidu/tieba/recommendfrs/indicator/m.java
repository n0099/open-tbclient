package com.baidu.tieba.recommendfrs.indicator;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class m {
    private boolean arl = false;
    private View awk;
    private View bbZ;
    private Animation cIS;
    private Animation cIT;
    private ViewGroup cIW;
    private a eaG;
    private l eaH;
    private int topHeight;

    /* loaded from: classes.dex */
    public interface a {
        void aon();
    }

    public m(ViewGroup viewGroup) {
        this.cIW = viewGroup;
    }

    public void a(a aVar) {
        this.eaG = aVar;
    }

    public boolean isShowing() {
        return this.arl;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.arl) {
            this.arl = true;
            this.awk = b(context, list, i);
            this.cIW.addView(this.awk);
            at.l(this.awk, t.d.recommend_frs_more_background);
            this.awk.startAnimation(aF(context));
        }
    }

    public void aE(Context context) {
        if (this.awk != null) {
            this.awk.startAnimation(aG(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(t.h.scroll_fragment_more, (ViewGroup) null);
        this.bbZ = inflate.findViewById(t.g.more_top_view);
        ow(this.topHeight);
        GridView gridView = (GridView) inflate.findViewById(t.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.eaH = new l(context, i);
        this.eaH.bx(list);
        gridView.setAdapter((ListAdapter) this.eaH);
        gridView.setOnItemClickListener(new n(this, context));
        return inflate;
    }

    public void ow(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bbZ.getLayoutParams();
        layoutParams.height = i;
        this.bbZ.setLayoutParams(layoutParams);
    }

    private Animation aF(Context context) {
        if (this.cIS == null) {
            this.cIS = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_enter);
        }
        return this.cIS;
    }

    private Animation aG(Context context) {
        if (this.cIT == null) {
            this.cIT = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_exit);
        }
        this.cIT.setAnimationListener(new o(this));
        return this.cIT;
    }

    public void ox(int i) {
        this.topHeight = i;
    }

    public void cW(int i) {
        at.l(this.awk, t.d.recommend_frs_more_background);
        if (this.eaH != null) {
            this.eaH.notifyDataSetChanged();
        }
    }
}
