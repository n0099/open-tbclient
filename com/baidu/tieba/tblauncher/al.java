package com.baidu.tieba.tblauncher;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class al extends LinearLayout {
    public static final int cbD = com.baidu.tieba.v.icon_news_down_bar_one;
    private int WF;
    String cbA;
    int cbB;
    int cbC;
    private View.OnClickListener cbE;
    private com.baidu.tbadk.mainTab.e cbw;
    ViewGroup cbx;
    private ImageView cby;
    private View cbz;
    private Context mContext;
    private View.OnClickListener mOnClickListener;
    private TextView mTitle;

    public al(Context context, com.baidu.tbadk.mainTab.e eVar) {
        super(context);
        this.cbA = null;
        this.cbB = 0;
        this.cbC = 0;
        this.cbE = new am(this);
        this.mContext = context;
        this.cbw = eVar;
        init();
        FY();
    }

    private void init() {
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.main_tab_more_pop_window_item, this, true);
        setOrientation(1);
        this.cbx = (ViewGroup) findViewById(com.baidu.tieba.w.item_container_more);
        this.cby = (ImageView) findViewById(com.baidu.tieba.w.more_pop_item_new_icon);
        this.mTitle = (TextView) findViewById(com.baidu.tieba.w.more_pop_item_title);
        this.cbz = findViewById(com.baidu.tieba.w.more_pop_item_line);
    }

    private void FY() {
        id(this.cbw.uB());
        ig(this.cbw.uC());
        ie(this.cbw.wh());
        aiO();
        wc();
        eC(true);
        setOnClickListener(this.cbE);
    }

    public al id(int i) {
        if (i <= 0) {
            return null;
        }
        this.cbB = i;
        com.baidu.tbadk.core.util.ax.c(this.cby, this.cbB);
        return this;
    }

    public al ie(int i) {
        if (i <= 0) {
            return null;
        }
        this.cbC = i;
        Drawable drawable = com.baidu.tbadk.core.util.ax.getDrawable(i);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        if (drawable != null) {
            this.mTitle.setCompoundDrawables(drawable, null, null, null);
            return this;
        }
        return this;
    }

    public al ig(int i) {
        if (i <= 0) {
            return null;
        }
        this.mTitle.setText(i);
        return this;
    }

    public void aiN() {
        if (this.cbw != null) {
            this.cbw.du(0);
            this.cbw.aL(false);
        }
    }

    public al eB(boolean z) {
        this.cby.setVisibility(z ? 0 : 8);
        return this;
    }

    public al eC(boolean z) {
        this.cbz.setVisibility(z ? 0 : 8);
        return this;
    }

    public al H(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        return this;
    }

    public void wc() {
        if (this.cbB >= 0) {
            id(this.cbB);
        }
        if (this.cbC >= 0) {
            ie(this.cbC);
        }
    }

    public void aiO() {
        id(this.cbB);
        if (this.cbw.wg() > 0 && this.cbw.wf()) {
            eB(true);
        } else {
            eB(false);
        }
    }

    public int getTypeId() {
        return this.WF;
    }
}
