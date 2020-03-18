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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c {
    TextView aDi;
    LinearLayout gcw;
    private boolean isShow;
    final View kcU;
    final View kcV;
    LinearLayout kcW;
    private ImageView kcY;
    BdListView kcZ;
    BdListView kda;
    TextView kdb;
    TextView kdc;
    LinearLayout kdd;
    TextView kde;
    ImageView kdf;
    LinearLayout kdg;
    TextView kdh;
    ImageView kdi;
    h kdj;
    h kdk;
    PopupWindow kdl;
    View kdm;
    ForumListActivity kdn;
    ListView kdo;
    a kdp;
    LinearLayout kdq;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kcX = true;
    private int kdr = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gcw = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kcW = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kdq = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aDi = (TextView) this.kdq.findViewById(R.id.title_text);
        this.kcY = (ImageView) this.kdq.findViewById(R.id.forum_list_title_arrow);
        this.kdb = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kdb.setOnClickListener(forumListActivity);
        this.kdc = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kdc.setOnClickListener(forumListActivity);
        this.kdj = new h(forumListActivity.getPageContext());
        this.kdk = new h(forumListActivity.getPageContext());
        this.kdd = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kcU = this.kdd.findViewById(R.id.footer_background);
        this.kde = (TextView) this.kdd.findViewById(R.id.footer_text);
        this.kdf = (ImageView) this.kdd.findViewById(R.id.footer_icon);
        this.kdg = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kcV = this.kdg.findViewById(R.id.footer_background);
        this.kdh = (TextView) this.kdg.findViewById(R.id.footer_text);
        this.kdi = (ImageView) this.kdg.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kdn = forumListActivity;
        this.kdp = new a(this.kdn.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kdn.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kdo = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kdo.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kdr = this.kdp.getCount();
        this.kdo.setAdapter((ListAdapter) this.kdp);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kdm == null) {
                this.kdm = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kdn.getPageContext().getPageActivity(), 160.0f) - this.kdq.getWidth()) / 2;
            if (this.kdl == null) {
                this.kdl = new PopupWindow(this.kdm, l.dip2px(this.kdn.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kdl.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kdr > 6) {
                    this.kdl.setHeight(l.dip2px(this.kdn.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kdl.setOutsideTouchable(true);
            this.kdl.setFocusable(true);
            this.kdm.setFocusable(true);
            this.kdm.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kdl, this.kdq, 0 - dip2px, l.dip2px(this.kdn.getPageContext().getPageActivity(), 0.0f));
            this.kdm.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kdl.isShowing()) {
                        g.dismissPopupWindow(c.this.kdl, c.this.kdn.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kdm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kdl.isShowing()) {
                        g.dismissPopupWindow(c.this.kdl, c.this.kdn.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kdl.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kdl, this.kdn.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cJY() {
        this.kcW.setVisibility(0);
    }

    public void cJZ() {
        this.kcW.setVisibility(8);
    }

    public void cKa() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kcZ != null) {
                this.kcZ.completePullRefreshPostDelayed(0L);
            } else if (this.kda != null) {
                this.kda.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cKb() {
        this.kcY.setVisibility(4);
        this.kdq.setClickable(false);
        this.kdq.setOnClickListener(null);
    }

    public void cKc() {
        this.kcY.setVisibility(0);
    }
}
