package com.baidu.tieba.square.flist;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class c {
    LinearLayout eIu;
    TextView eKg;
    TextView iAA;
    ImageView iAB;
    LinearLayout iAC;
    TextView iAD;
    ImageView iAE;
    i iAF;
    i iAG;
    PopupWindow iAH;
    View iAI;
    ForumListActivity iAJ;
    ListView iAK;
    a iAL;
    LinearLayout iAM;
    final View iAq;
    final View iAr;
    LinearLayout iAs;
    private ImageView iAu;
    BdListView iAv;
    BdListView iAw;
    TextView iAx;
    TextView iAy;
    LinearLayout iAz;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iAt = true;
    private int iAN = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eIu = (LinearLayout) forumListActivity.findViewById(d.g.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(d.g.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iAs = (LinearLayout) forumListActivity.findViewById(d.g.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iAM = (LinearLayout) this.mNavigationBar.setTitleView(d.h.nb_item_forum_list, (View.OnClickListener) null);
        this.eKg = (TextView) this.iAM.findViewById(d.g.title_text);
        this.iAu = (ImageView) this.iAM.findViewById(d.g.forum_list_title_arrow);
        this.iAx = (TextView) forumListActivity.findViewById(d.g.tab_recommends);
        this.iAx.setOnClickListener(forumListActivity);
        this.iAy = (TextView) forumListActivity.findViewById(d.g.tab_hot);
        this.iAy.setOnClickListener(forumListActivity);
        this.iAF = new i(forumListActivity.getPageContext());
        this.iAG = new i(forumListActivity.getPageContext());
        this.iAz = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAq = this.iAz.findViewById(d.g.footer_background);
        this.iAA = (TextView) this.iAz.findViewById(d.g.footer_text);
        this.iAB = (ImageView) this.iAz.findViewById(d.g.footer_icon);
        this.iAC = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAr = this.iAC.findViewById(d.g.footer_background);
        this.iAD = (TextView) this.iAC.findViewById(d.g.footer_text);
        this.iAE = (ImageView) this.iAC.findViewById(d.g.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(d.g.loading);
        this.isShow = false;
        this.iAJ = forumListActivity;
        this.iAL = new a(this.iAJ.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iAJ.getPageContext().getPageActivity()).inflate(d.h.forum_list__dir_menu, (ViewGroup) null);
        this.iAK = (ListView) inflate.findViewById(d.g.dir_menu_list);
        this.iAK.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(d.f.bg_allsproutpop_dropdown);
        this.iAN = this.iAL.getCount();
        this.iAK.setAdapter((ListAdapter) this.iAL);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iAI == null) {
                this.iAI = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iAJ.getPageContext().getPageActivity(), 160.0f) - this.iAM.getWidth()) / 2;
            if (this.iAH == null) {
                this.iAH = new PopupWindow(this.iAI, l.dip2px(this.iAJ.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iAH.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iAN > 6) {
                    this.iAH.setHeight(l.dip2px(this.iAJ.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iAH.setOutsideTouchable(true);
            this.iAH.setFocusable(true);
            this.iAI.setFocusable(true);
            this.iAI.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iAH, this.iAM, 0 - dip2px, l.dip2px(this.iAJ.getPageContext().getPageActivity(), 0.0f));
            this.iAI.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iAH.isShowing()) {
                        g.a(c.this.iAH, c.this.iAJ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iAH.isShowing()) {
                        g.a(c.this.iAH, c.this.iAJ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAH.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iAH, this.iAJ.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ccQ() {
        this.iAs.setVisibility(0);
    }

    public void ccR() {
        this.iAs.setVisibility(8);
    }

    public void ccS() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iAv != null) {
                this.iAv.completePullRefreshPostDelayed(0L);
            } else if (this.iAw != null) {
                this.iAw.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ccT() {
        this.iAu.setVisibility(4);
        this.iAM.setClickable(false);
        this.iAM.setOnClickListener(null);
    }

    public void ccU() {
        this.iAu.setVisibility(0);
    }
}
