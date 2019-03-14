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
    LinearLayout eIH;
    TextView eKt;
    final View iAF;
    final View iAG;
    LinearLayout iAH;
    private ImageView iAJ;
    BdListView iAK;
    BdListView iAL;
    TextView iAM;
    TextView iAN;
    LinearLayout iAO;
    TextView iAP;
    ImageView iAQ;
    LinearLayout iAR;
    TextView iAS;
    ImageView iAT;
    i iAU;
    i iAV;
    PopupWindow iAW;
    View iAX;
    ForumListActivity iAY;
    ListView iAZ;
    a iBa;
    LinearLayout iBb;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iAI = true;
    private int iBc = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eIH = (LinearLayout) forumListActivity.findViewById(d.g.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(d.g.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iAH = (LinearLayout) forumListActivity.findViewById(d.g.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iBb = (LinearLayout) this.mNavigationBar.setTitleView(d.h.nb_item_forum_list, (View.OnClickListener) null);
        this.eKt = (TextView) this.iBb.findViewById(d.g.title_text);
        this.iAJ = (ImageView) this.iBb.findViewById(d.g.forum_list_title_arrow);
        this.iAM = (TextView) forumListActivity.findViewById(d.g.tab_recommends);
        this.iAM.setOnClickListener(forumListActivity);
        this.iAN = (TextView) forumListActivity.findViewById(d.g.tab_hot);
        this.iAN.setOnClickListener(forumListActivity);
        this.iAU = new i(forumListActivity.getPageContext());
        this.iAV = new i(forumListActivity.getPageContext());
        this.iAO = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAF = this.iAO.findViewById(d.g.footer_background);
        this.iAP = (TextView) this.iAO.findViewById(d.g.footer_text);
        this.iAQ = (ImageView) this.iAO.findViewById(d.g.footer_icon);
        this.iAR = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(d.h.forum_list_forum_footer, (ViewGroup) null);
        this.iAG = this.iAR.findViewById(d.g.footer_background);
        this.iAS = (TextView) this.iAR.findViewById(d.g.footer_text);
        this.iAT = (ImageView) this.iAR.findViewById(d.g.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(d.g.loading);
        this.isShow = false;
        this.iAY = forumListActivity;
        this.iBa = new a(this.iAY.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iAY.getPageContext().getPageActivity()).inflate(d.h.forum_list__dir_menu, (ViewGroup) null);
        this.iAZ = (ListView) inflate.findViewById(d.g.dir_menu_list);
        this.iAZ.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(d.f.bg_allsproutpop_dropdown);
        this.iBc = this.iBa.getCount();
        this.iAZ.setAdapter((ListAdapter) this.iBa);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iAX == null) {
                this.iAX = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iAY.getPageContext().getPageActivity(), 160.0f) - this.iBb.getWidth()) / 2;
            if (this.iAW == null) {
                this.iAW = new PopupWindow(this.iAX, l.dip2px(this.iAY.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iAW.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iBc > 6) {
                    this.iAW.setHeight(l.dip2px(this.iAY.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iAW.setOutsideTouchable(true);
            this.iAW.setFocusable(true);
            this.iAX.setFocusable(true);
            this.iAX.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iAW, this.iBb, 0 - dip2px, l.dip2px(this.iAY.getPageContext().getPageActivity(), 0.0f));
            this.iAX.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iAW.isShowing()) {
                        g.a(c.this.iAW, c.this.iAY.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iAW.isShowing()) {
                        g.a(c.this.iAW, c.this.iAY.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iAW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iAW, this.iAY.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ccU() {
        this.iAH.setVisibility(0);
    }

    public void ccV() {
        this.iAH.setVisibility(8);
    }

    public void ccW() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iAK != null) {
                this.iAK.completePullRefreshPostDelayed(0L);
            } else if (this.iAL != null) {
                this.iAL.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ccX() {
        this.iAJ.setVisibility(4);
        this.iBb.setClickable(false);
        this.iBb.setOnClickListener(null);
    }

    public void ccY() {
        this.iAJ.setVisibility(0);
    }
}
