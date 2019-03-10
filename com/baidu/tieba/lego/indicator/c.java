package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.c.e;
import java.util.List;
/* loaded from: classes2.dex */
public class c {
    private Animation fZk;
    private Animation fZl;
    private ViewGroup fZq;
    private a gLl;
    private b gLm;
    private boolean isShow = false;
    private View rootView;

    /* loaded from: classes2.dex */
    public interface a {
        void boO();
    }

    public c(ViewGroup viewGroup) {
        this.fZq = viewGroup;
    }

    public void a(a aVar) {
        this.gLl = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<e> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.fZq.addView(this.rootView);
            al.l(this.rootView, d.C0236d.cp_cont_g);
            this.rootView.startAnimation(dR(context));
        }
    }

    public void dQ(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(dS(context));
        }
    }

    private View b(final Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(d.h.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(d.g.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        this.gLm = new b(context, i);
        this.gLm.setTagList(list);
        gridView.setAdapter((ListAdapter) this.gLm);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.lego.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                e item = c.this.gLm.getItem(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
                c.this.dQ(context);
            }
        });
        return inflate;
    }

    private Animation dR(Context context) {
        if (this.fZk == null) {
            this.fZk = AnimationUtils.loadAnimation(context, d.a.dialog_ani_t2b_enter);
        }
        return this.fZk;
    }

    private Animation dS(Context context) {
        if (this.fZl == null) {
            this.fZl = AnimationUtils.loadAnimation(context, d.a.dialog_ani_t2b_exit);
        }
        this.fZl.setAnimationListener(new com.baidu.adp.lib.g.d() { // from class: com.baidu.tieba.lego.indicator.c.2
            @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.gLl != null) {
                    c.this.gLl.boO();
                }
                c.this.fZq.removeView(c.this.rootView);
            }
        });
        return this.fZl;
    }

    public void ij(int i) {
        al.l(this.rootView, d.C0236d.cp_cont_g);
        if (this.gLm != null) {
            this.gLm.notifyDataSetChanged();
        }
    }
}
