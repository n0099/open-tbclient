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
    LinearLayout eIt;
    TextView eKf;
    ImageView iAA;
    LinearLayout iAB;
    TextView iAC;
    ImageView iAD;
    i iAE;
    i iAF;
    PopupWindow iAG;
    View iAH;
    ForumListActivity iAI;
    ListView iAJ;
    a iAK;
    LinearLayout iAL;
    final View iAp;
    final View iAq;
    LinearLayout iAr;
    private ImageView iAt;
    BdListView iAu;
    BdListView iAv;
    TextView iAw;
    TextView iAx;
    LinearLayout iAy;
    TextView iAz;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iAs = true;
    private int iAM = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eIt = (LinearLayout) forumListActivity.findViewById(d.g.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(d.g.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iAr = (LinearLayout) forumListActivity.findViewById(d.g.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iAL = (LinearLayout) this.mNavigationBar.setTitleView(d.h.nb_item_forum_list, (View.OnClickListener) null);
        this.eKf = (TextView) this.iAL.findViewById(d.g.title_text);
        this.iAt = (ImageView) this.iAL.findViewById(d.g.forum_list_title_arrow);
        this.iAw = (TextView) forumListActivity.findViewById(d.g.tab_recommends);
        this.iAw.setOnClickListener(forumListActivity);
        this.iAx = (TextView) forumListActivity.findViewById(d.g.tab_hot);
        this.iAx.setOnClickListener(forumListActivity);
        this.iAE = new i(forumListActivity.getPageContext());
        this.iAF = new i(forumListActivity.getPageContext());
        this.iAy = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAp = this.iAy.findViewById(d.g.footer_background);
        this.iAz = (TextView) this.iAy.findViewById(d.g.footer_text);
        this.iAA = (ImageView) this.iAy.findViewById(d.g.footer_icon);
        this.iAB = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAq = this.iAB.findViewById(d.g.footer_background);
        this.iAC = (TextView) this.iAB.findViewById(d.g.footer_text);
        this.iAD = (ImageView) this.iAB.findViewById(d.g.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(d.g.loading);
        this.isShow = false;
        this.iAI = forumListActivity;
        this.iAK = new a(this.iAI.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iAI.getPageContext().getPageActivity()).inflate(d.h.forum_list__dir_menu, (ViewGroup) null);
        this.iAJ = (ListView) inflate.findViewById(d.g.dir_menu_list);
        this.iAJ.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(d.f.bg_allsproutpop_dropdown);
        this.iAM = this.iAK.getCount();
        this.iAJ.setAdapter((ListAdapter) this.iAK);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iAH == null) {
                this.iAH = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iAI.getPageContext().getPageActivity(), 160.0f) - this.iAL.getWidth()) / 2;
            if (this.iAG == null) {
                this.iAG = new PopupWindow(this.iAH, l.dip2px(this.iAI.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iAG.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iAM > 6) {
                    this.iAG.setHeight(l.dip2px(this.iAI.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iAG.setOutsideTouchable(true);
            this.iAG.setFocusable(true);
            this.iAH.setFocusable(true);
            this.iAH.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iAG, this.iAL, 0 - dip2px, l.dip2px(this.iAI.getPageContext().getPageActivity(), 0.0f));
            this.iAH.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iAG.isShowing()) {
                        g.a(c.this.iAG, c.this.iAI.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iAG.isShowing()) {
                        g.a(c.this.iAG, c.this.iAI.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAG.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iAG, this.iAI.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ccQ() {
        this.iAr.setVisibility(0);
    }

    public void ccR() {
        this.iAr.setVisibility(8);
    }

    public void ccS() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iAu != null) {
                this.iAu.completePullRefreshPostDelayed(0L);
            } else if (this.iAv != null) {
                this.iAv.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ccT() {
        this.iAt.setVisibility(4);
        this.iAL.setClickable(false);
        this.iAL.setOnClickListener(null);
    }

    public void ccU() {
        this.iAt.setVisibility(0);
    }
}
