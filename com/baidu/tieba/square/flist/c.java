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
/* loaded from: classes22.dex */
public class c {
    TextView bsJ;
    LinearLayout hNd;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    final View mjb;
    final View mjc;
    LinearLayout mjd;
    private ImageView mjf;
    BdListView mjg;
    BdListView mjh;
    TextView mji;
    TextView mjj;
    LinearLayout mjk;
    TextView mjl;
    ImageView mjm;
    LinearLayout mjn;
    TextView mjo;
    ImageView mjp;
    g mjq;
    g mjr;
    PopupWindow mjs;
    View mjt;
    ForumListActivity mju;
    ListView mjv;
    a mjw;
    LinearLayout mjx;
    boolean mje = true;
    private int mjy = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hNd = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.mjd = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mjx = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bsJ = (TextView) this.mjx.findViewById(R.id.title_text);
        this.mjf = (ImageView) this.mjx.findViewById(R.id.forum_list_title_arrow);
        this.mji = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.mji.setOnClickListener(forumListActivity);
        this.mjj = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.mjj.setOnClickListener(forumListActivity);
        this.mjq = new g(forumListActivity.getPageContext());
        this.mjr = new g(forumListActivity.getPageContext());
        this.mjk = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mjb = this.mjk.findViewById(R.id.footer_background);
        this.mjl = (TextView) this.mjk.findViewById(R.id.footer_text);
        this.mjm = (ImageView) this.mjk.findViewById(R.id.footer_icon);
        this.mjn = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mjc = this.mjn.findViewById(R.id.footer_background);
        this.mjo = (TextView) this.mjn.findViewById(R.id.footer_text);
        this.mjp = (ImageView) this.mjn.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.mju = forumListActivity;
        this.mjw = new a(this.mju.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.mju.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.mjv = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.mjv.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.mjy = this.mjw.getCount();
        this.mjv.setAdapter((ListAdapter) this.mjw);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.mjt == null) {
                this.mjt = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.mju.getPageContext().getPageActivity(), 160.0f) - this.mjx.getWidth()) / 2;
            if (this.mjs == null) {
                this.mjs = new PopupWindow(this.mjt, l.dip2px(this.mju.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.mjs.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.mjy > 6) {
                    this.mjs.setHeight(l.dip2px(this.mju.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.mjs.setOutsideTouchable(true);
            this.mjs.setFocusable(true);
            this.mjt.setFocusable(true);
            this.mjt.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.mjs, this.mjx, 0 - dip2px, l.dip2px(this.mju.getPageContext().getPageActivity(), 0.0f));
            this.mjt.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.mjs.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mjs, c.this.mju.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mjt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.mjs.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mjs, c.this.mju.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mjs.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mjs, this.mju.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dze() {
        this.mjd.setVisibility(0);
    }

    public void dzf() {
        this.mjd.setVisibility(8);
    }

    public void dzg() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.mjg != null) {
                this.mjg.completePullRefreshPostDelayed(0L);
            } else if (this.mjh != null) {
                this.mjh.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dzh() {
        this.mjf.setVisibility(4);
        this.mjx.setClickable(false);
        this.mjx.setOnClickListener(null);
    }

    public void dzi() {
        this.mjf.setVisibility(0);
    }
}
