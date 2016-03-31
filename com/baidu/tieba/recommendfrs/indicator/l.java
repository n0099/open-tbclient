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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class l {
    private View aAh;
    private boolean avm = false;
    private Animation cIo;
    private Animation cIp;
    private ViewGroup cIs;
    private a dXw;
    private k dXx;

    /* loaded from: classes.dex */
    public interface a {
        void aok();
    }

    public l(ViewGroup viewGroup) {
        this.cIs = viewGroup;
    }

    public void a(a aVar) {
        this.dXw = aVar;
    }

    public boolean isShowing() {
        return this.avm;
    }

    public void a(Context context, List<TagInfo> list, int i) {
        if (!this.avm) {
            this.avm = true;
            this.aAh = b(context, list, i);
            this.cIs.addView(this.aAh);
            at.l(this.aAh, t.d.recommend_frs_more_background);
            this.aAh.startAnimation(az(context));
        }
    }

    public void ay(Context context) {
        if (this.aAh != null) {
            this.aAh.startAnimation(aA(context));
        }
    }

    private View b(Context context, List<TagInfo> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(t.h.scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(t.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(17170445));
        this.dXx = new k(context, i);
        this.dXx.bx(list);
        gridView.setAdapter((ListAdapter) this.dXx);
        gridView.setOnItemClickListener(new m(this, context));
        return inflate;
    }

    private Animation az(Context context) {
        if (this.cIo == null) {
            this.cIo = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_enter);
        }
        return this.cIo;
    }

    private Animation aA(Context context) {
        if (this.cIp == null) {
            this.cIp = AnimationUtils.loadAnimation(context, t.a.dialog_ani_t2b_exit);
        }
        this.cIp.setAnimationListener(new n(this));
        return this.cIp;
    }

    public void dn(int i) {
        at.l(this.aAh, t.d.recommend_frs_more_background);
        if (this.dXx != null) {
            this.dXx.notifyDataSetChanged();
        }
    }
}
