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
/* loaded from: classes10.dex */
public class c {
    TextView bjy;
    LinearLayout hmU;
    private boolean isShow;
    g lAA;
    g lAB;
    PopupWindow lAC;
    View lAD;
    ForumListActivity lAE;
    ListView lAF;
    a lAG;
    LinearLayout lAH;
    final View lAl;
    final View lAm;
    LinearLayout lAn;
    private ImageView lAp;
    BdListView lAq;
    BdListView lAr;
    TextView lAs;
    TextView lAt;
    LinearLayout lAu;
    TextView lAv;
    ImageView lAw;
    LinearLayout lAx;
    TextView lAy;
    ImageView lAz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lAo = true;
    private int lAI = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hmU = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lAn = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lAH = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bjy = (TextView) this.lAH.findViewById(R.id.title_text);
        this.lAp = (ImageView) this.lAH.findViewById(R.id.forum_list_title_arrow);
        this.lAs = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lAs.setOnClickListener(forumListActivity);
        this.lAt = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lAt.setOnClickListener(forumListActivity);
        this.lAA = new g(forumListActivity.getPageContext());
        this.lAB = new g(forumListActivity.getPageContext());
        this.lAu = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lAl = this.lAu.findViewById(R.id.footer_background);
        this.lAv = (TextView) this.lAu.findViewById(R.id.footer_text);
        this.lAw = (ImageView) this.lAu.findViewById(R.id.footer_icon);
        this.lAx = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lAm = this.lAx.findViewById(R.id.footer_background);
        this.lAy = (TextView) this.lAx.findViewById(R.id.footer_text);
        this.lAz = (ImageView) this.lAx.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lAE = forumListActivity;
        this.lAG = new a(this.lAE.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lAE.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lAF = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lAF.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lAI = this.lAG.getCount();
        this.lAF.setAdapter((ListAdapter) this.lAG);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lAD == null) {
                this.lAD = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lAE.getPageContext().getPageActivity(), 160.0f) - this.lAH.getWidth()) / 2;
            if (this.lAC == null) {
                this.lAC = new PopupWindow(this.lAD, l.dip2px(this.lAE.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lAC.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lAI > 6) {
                    this.lAC.setHeight(l.dip2px(this.lAE.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lAC.setOutsideTouchable(true);
            this.lAC.setFocusable(true);
            this.lAD.setFocusable(true);
            this.lAD.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lAC, this.lAH, 0 - dip2px, l.dip2px(this.lAE.getPageContext().getPageActivity(), 0.0f));
            this.lAD.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lAC.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lAC, c.this.lAE.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lAD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lAC.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lAC, c.this.lAE.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lAC.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lAC, this.lAE.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dgA() {
        this.lAn.setVisibility(0);
    }

    public void dgB() {
        this.lAn.setVisibility(8);
    }

    public void dgC() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lAq != null) {
                this.lAq.completePullRefreshPostDelayed(0L);
            } else if (this.lAr != null) {
                this.lAr.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dgD() {
        this.lAp.setVisibility(4);
        this.lAH.setClickable(false);
        this.lAH.setOnClickListener(null);
    }

    public void dgE() {
        this.lAp.setVisibility(0);
    }
}
