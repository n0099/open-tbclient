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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class c {
    TextView bpA;
    LinearLayout hGc;
    private boolean isShow;
    private ImageView lZB;
    BdListView lZC;
    BdListView lZD;
    TextView lZE;
    TextView lZF;
    LinearLayout lZG;
    TextView lZH;
    ImageView lZI;
    LinearLayout lZJ;
    TextView lZK;
    ImageView lZL;
    g lZM;
    g lZN;
    PopupWindow lZO;
    View lZP;
    ForumListActivity lZQ;
    ListView lZR;
    a lZS;
    LinearLayout lZT;
    final View lZx;
    final View lZy;
    LinearLayout lZz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lZA = true;
    private int lZU = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hGc = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lZz = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lZT = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bpA = (TextView) this.lZT.findViewById(R.id.title_text);
        this.lZB = (ImageView) this.lZT.findViewById(R.id.forum_list_title_arrow);
        this.lZE = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lZE.setOnClickListener(forumListActivity);
        this.lZF = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lZF.setOnClickListener(forumListActivity);
        this.lZM = new g(forumListActivity.getPageContext());
        this.lZN = new g(forumListActivity.getPageContext());
        this.lZG = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZx = this.lZG.findViewById(R.id.footer_background);
        this.lZH = (TextView) this.lZG.findViewById(R.id.footer_text);
        this.lZI = (ImageView) this.lZG.findViewById(R.id.footer_icon);
        this.lZJ = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZy = this.lZJ.findViewById(R.id.footer_background);
        this.lZK = (TextView) this.lZJ.findViewById(R.id.footer_text);
        this.lZL = (ImageView) this.lZJ.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lZQ = forumListActivity;
        this.lZS = new a(this.lZQ.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lZQ.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lZR = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lZR.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lZU = this.lZS.getCount();
        this.lZR.setAdapter((ListAdapter) this.lZS);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lZP == null) {
                this.lZP = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lZQ.getPageContext().getPageActivity(), 160.0f) - this.lZT.getWidth()) / 2;
            if (this.lZO == null) {
                this.lZO = new PopupWindow(this.lZP, l.dip2px(this.lZQ.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lZO.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lZU > 6) {
                    this.lZO.setHeight(l.dip2px(this.lZQ.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lZO.setOutsideTouchable(true);
            this.lZO.setFocusable(true);
            this.lZP.setFocusable(true);
            this.lZP.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lZO, this.lZT, 0 - dip2px, l.dip2px(this.lZQ.getPageContext().getPageActivity(), 0.0f));
            this.lZP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lZO.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lZO, c.this.lZQ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lZP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lZO.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lZO, c.this.lZQ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lZO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lZO, this.lZQ.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dvl() {
        this.lZz.setVisibility(0);
    }

    public void dvm() {
        this.lZz.setVisibility(8);
    }

    public void dvn() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lZC != null) {
                this.lZC.completePullRefreshPostDelayed(0L);
            } else if (this.lZD != null) {
                this.lZD.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dvo() {
        this.lZB.setVisibility(4);
        this.lZT.setClickable(false);
        this.lZT.setOnClickListener(null);
    }

    public void dvp() {
        this.lZB.setVisibility(0);
    }
}
