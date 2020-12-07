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
/* loaded from: classes23.dex */
public class c {
    TextView bIt;
    LinearLayout iGd;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    ForumListActivity ngA;
    ListView ngB;
    a ngC;
    LinearLayout ngD;
    final View ngh;
    final View ngi;
    LinearLayout ngj;
    private ImageView ngl;
    BdListView ngm;
    BdListView ngn;
    TextView ngo;
    TextView ngp;
    LinearLayout ngq;
    TextView ngr;
    ImageView ngs;
    LinearLayout ngt;
    TextView ngu;
    ImageView ngv;
    g ngw;
    g ngx;
    PopupWindow ngy;
    View ngz;
    boolean ngk = true;
    private int ngE = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iGd = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.ngj = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ngD = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bIt = (TextView) this.ngD.findViewById(R.id.title_text);
        this.ngl = (ImageView) this.ngD.findViewById(R.id.forum_list_title_arrow);
        this.ngo = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.ngo.setOnClickListener(forumListActivity);
        this.ngp = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.ngp.setOnClickListener(forumListActivity);
        this.ngw = new g(forumListActivity.getPageContext());
        this.ngx = new g(forumListActivity.getPageContext());
        this.ngq = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ngh = this.ngq.findViewById(R.id.footer_background);
        this.ngr = (TextView) this.ngq.findViewById(R.id.footer_text);
        this.ngs = (ImageView) this.ngq.findViewById(R.id.footer_icon);
        this.ngt = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ngi = this.ngt.findViewById(R.id.footer_background);
        this.ngu = (TextView) this.ngt.findViewById(R.id.footer_text);
        this.ngv = (ImageView) this.ngt.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.ngA = forumListActivity;
        this.ngC = new a(this.ngA.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.ngA.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.ngB = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.ngB.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.ngE = this.ngC.getCount();
        this.ngB.setAdapter((ListAdapter) this.ngC);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.ngz == null) {
                this.ngz = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.ngA.getPageContext().getPageActivity(), 160.0f) - this.ngD.getWidth()) / 2;
            if (this.ngy == null) {
                this.ngy = new PopupWindow(this.ngz, l.dip2px(this.ngA.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.ngy.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.ngE > 6) {
                    this.ngy.setHeight(l.dip2px(this.ngA.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.ngy.setOutsideTouchable(true);
            this.ngy.setFocusable(true);
            this.ngz.setFocusable(true);
            this.ngz.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.ngy, this.ngD, 0 - dip2px, l.dip2px(this.ngA.getPageContext().getPageActivity(), 0.0f));
            this.ngz.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.ngy.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ngy, c.this.ngA.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ngz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.ngy.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ngy, c.this.ngA.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ngy.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ngy, this.ngA.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dNG() {
        this.ngj.setVisibility(0);
    }

    public void dNH() {
        this.ngj.setVisibility(8);
    }

    public void dNI() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.ngm != null) {
                this.ngm.completePullRefreshPostDelayed(0L);
            } else if (this.ngn != null) {
                this.ngn.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dNJ() {
        this.ngl.setVisibility(4);
        this.ngD.setClickable(false);
        this.ngD.setOnClickListener(null);
    }

    public void dNK() {
        this.ngl.setVisibility(0);
    }
}
