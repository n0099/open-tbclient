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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.c.e;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    private boolean isShow = false;
    private ViewGroup kyD;
    private Animation kyy;
    private Animation kyz;
    private a lfS;
    private b lfT;
    private View rootView;

    /* loaded from: classes9.dex */
    public interface a {
        void cTz();
    }

    public c(ViewGroup viewGroup) {
        this.kyD = viewGroup;
    }

    public void a(a aVar) {
        this.lfS = aVar;
    }

    public boolean isShowing() {
        return this.isShow;
    }

    public void a(Context context, List<e> list, int i) {
        if (!this.isShow) {
            this.isShow = true;
            this.rootView = b(context, list, i);
            this.kyD.addView(this.rootView);
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0111);
            this.rootView.startAnimation(go(context));
        }
    }

    public void gn(Context context) {
        if (this.rootView != null) {
            this.rootView.startAnimation(gp(context));
        }
    }

    private View b(final Context context, List<e> list, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
        gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
        this.lfT = new b(context, i);
        this.lfT.setTagList(list);
        gridView.setAdapter((ListAdapter) this.lfT);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.lego.indicator.c.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                e item = c.this.lfT.getItem(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB_FROM_POP_WINDOW));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_LEGO_SWITCH_TAB, item));
                c.this.gn(context);
            }
        });
        return inflate;
    }

    private Animation go(Context context) {
        if (this.kyy == null) {
            this.kyy = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
        }
        return this.kyy;
    }

    private Animation gp(Context context) {
        if (this.kyz == null) {
            this.kyz = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
        }
        this.kyz.setAnimationListener(new d() { // from class: com.baidu.tieba.lego.indicator.c.2
            @Override // com.baidu.adp.lib.f.d, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                c.this.isShow = false;
                if (c.this.lfS != null) {
                    c.this.lfS.cTz();
                }
                c.this.kyD.removeView(c.this.rootView);
            }
        });
        return this.kyz;
    }

    public void onChangeSkin(int i) {
        ap.setBackgroundColor(this.rootView, R.color.CAM_X0111);
        if (this.lfT != null) {
            this.lfT.notifyDataSetChanged();
        }
    }
}
