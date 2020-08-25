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
    TextView bpx;
    LinearLayout hFW;
    private boolean isShow;
    View lZA;
    ForumListActivity lZB;
    ListView lZC;
    a lZD;
    LinearLayout lZE;
    final View lZi;
    final View lZj;
    LinearLayout lZk;
    private ImageView lZm;
    BdListView lZn;
    BdListView lZo;
    TextView lZp;
    TextView lZq;
    LinearLayout lZr;
    TextView lZs;
    ImageView lZt;
    LinearLayout lZu;
    TextView lZv;
    ImageView lZw;
    g lZx;
    g lZy;
    PopupWindow lZz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lZl = true;
    private int lZF = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hFW = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lZk = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lZE = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bpx = (TextView) this.lZE.findViewById(R.id.title_text);
        this.lZm = (ImageView) this.lZE.findViewById(R.id.forum_list_title_arrow);
        this.lZp = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lZp.setOnClickListener(forumListActivity);
        this.lZq = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lZq.setOnClickListener(forumListActivity);
        this.lZx = new g(forumListActivity.getPageContext());
        this.lZy = new g(forumListActivity.getPageContext());
        this.lZr = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZi = this.lZr.findViewById(R.id.footer_background);
        this.lZs = (TextView) this.lZr.findViewById(R.id.footer_text);
        this.lZt = (ImageView) this.lZr.findViewById(R.id.footer_icon);
        this.lZu = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lZj = this.lZu.findViewById(R.id.footer_background);
        this.lZv = (TextView) this.lZu.findViewById(R.id.footer_text);
        this.lZw = (ImageView) this.lZu.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lZB = forumListActivity;
        this.lZD = new a(this.lZB.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lZB.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lZC = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lZC.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lZF = this.lZD.getCount();
        this.lZC.setAdapter((ListAdapter) this.lZD);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lZA == null) {
                this.lZA = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lZB.getPageContext().getPageActivity(), 160.0f) - this.lZE.getWidth()) / 2;
            if (this.lZz == null) {
                this.lZz = new PopupWindow(this.lZA, l.dip2px(this.lZB.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lZz.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lZF > 6) {
                    this.lZz.setHeight(l.dip2px(this.lZB.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lZz.setOutsideTouchable(true);
            this.lZz.setFocusable(true);
            this.lZA.setFocusable(true);
            this.lZA.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lZz, this.lZE, 0 - dip2px, l.dip2px(this.lZB.getPageContext().getPageActivity(), 0.0f));
            this.lZA.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lZz.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lZz, c.this.lZB.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lZA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lZz.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lZz, c.this.lZB.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lZz.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lZz, this.lZB.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dvg() {
        this.lZk.setVisibility(0);
    }

    public void dvh() {
        this.lZk.setVisibility(8);
    }

    public void dvi() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lZn != null) {
                this.lZn.completePullRefreshPostDelayed(0L);
            } else if (this.lZo != null) {
                this.lZo.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dvj() {
        this.lZm.setVisibility(4);
        this.lZE.setClickable(false);
        this.lZE.setOnClickListener(null);
    }

    public void dvk() {
        this.lZm.setVisibility(0);
    }
}
