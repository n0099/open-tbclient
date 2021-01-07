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
import com.baidu.adp.lib.f.d;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.c.e;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private boolean isShow = false;
    private Animation kuW;
    private Animation kuX;
    private ViewGroup kvb;
    private a lcv;
    private b lcw;
    private View rootView;

    /* loaded from: classes9.dex */
    public interface a {
        void cVs();
    }

    public c(ViewGroup viewGroup) {
        this.kvb = viewGroup;
    }

    public void a(a aVar) {
        this.lcv = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<e> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.kvb.addView(this.rootView);
            ao.setBackgroundColor(this.rootView, R.color.CAM_X0111);
            this.rootView.startAnimation(gp(context));
        }
    }

    public void go(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(gq(context));
        }
    }

    private View b(final Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        this.lcw = new b(context, i);
        this.lcw.setTagList(list);
        gridView.setAdapter((ListAdapter) this.lcw);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.lego.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                e item = c.this.lcw.getItem(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, item));
                c.this.go(context);
            }
        });
        return inflate;
    }

    private Animation gp(Context context) {
        if (this.kuW == null) {
            this.kuW = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.kuW;
    }

    private Animation gq(Context context) {
        if (this.kuX == null) {
            this.kuX = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.kuX.setAnimationListener(new d() { // from class: com.baidu.tieba.lego.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.lcv != null) {
                    c.this.lcv.cVs();
                }
                c.this.kvb.removeView(c.this.rootView);
            }
        });
        return this.kuX;
    }

    public void onChangeSkin(int i) {
        ao.setBackgroundColor(this.rootView, R.color.CAM_X0111);
        if (this.lcw != null) {
            this.lcw.notifyDataSetChanged();
        }
    }
}
