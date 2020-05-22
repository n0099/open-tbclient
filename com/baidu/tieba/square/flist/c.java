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
    TextView bem;
    LinearLayout hay;
    private boolean isShow;
    a lfA;
    LinearLayout lfB;
    final View lff;
    final View lfg;
    LinearLayout lfh;
    private ImageView lfj;
    BdListView lfk;
    BdListView lfl;
    TextView lfm;
    TextView lfn;
    LinearLayout lfo;
    TextView lfp;
    ImageView lfq;
    LinearLayout lfr;
    TextView lfs;
    ImageView lft;
    g lfu;
    g lfv;
    PopupWindow lfw;
    View lfx;
    ForumListActivity lfy;
    ListView lfz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lfi = true;
    private int lfC = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hay = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lfh = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lfB = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bem = (TextView) this.lfB.findViewById(R.id.title_text);
        this.lfj = (ImageView) this.lfB.findViewById(R.id.forum_list_title_arrow);
        this.lfm = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lfm.setOnClickListener(forumListActivity);
        this.lfn = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lfn.setOnClickListener(forumListActivity);
        this.lfu = new g(forumListActivity.getPageContext());
        this.lfv = new g(forumListActivity.getPageContext());
        this.lfo = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lff = this.lfo.findViewById(R.id.footer_background);
        this.lfp = (TextView) this.lfo.findViewById(R.id.footer_text);
        this.lfq = (ImageView) this.lfo.findViewById(R.id.footer_icon);
        this.lfr = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lfg = this.lfr.findViewById(R.id.footer_background);
        this.lfs = (TextView) this.lfr.findViewById(R.id.footer_text);
        this.lft = (ImageView) this.lfr.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lfy = forumListActivity;
        this.lfA = new a(this.lfy.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lfy.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lfz = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lfz.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lfC = this.lfA.getCount();
        this.lfz.setAdapter((ListAdapter) this.lfA);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lfx == null) {
                this.lfx = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lfy.getPageContext().getPageActivity(), 160.0f) - this.lfB.getWidth()) / 2;
            if (this.lfw == null) {
                this.lfw = new PopupWindow(this.lfx, l.dip2px(this.lfy.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lfw.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lfC > 6) {
                    this.lfw.setHeight(l.dip2px(this.lfy.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lfw.setOutsideTouchable(true);
            this.lfw.setFocusable(true);
            this.lfx.setFocusable(true);
            this.lfx.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lfw, this.lfB, 0 - dip2px, l.dip2px(this.lfy.getPageContext().getPageActivity(), 0.0f));
            this.lfx.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lfw.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lfw, c.this.lfy.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lfx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lfw.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lfw, c.this.lfy.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lfw.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lfw, this.lfy.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dbV() {
        this.lfh.setVisibility(0);
    }

    public void dbW() {
        this.lfh.setVisibility(8);
    }

    public void dbX() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lfk != null) {
                this.lfk.completePullRefreshPostDelayed(0L);
            } else if (this.lfl != null) {
                this.lfl.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dbY() {
        this.lfj.setVisibility(4);
        this.lfB.setClickable(false);
        this.lfB.setOnClickListener(null);
    }

    public void dbZ() {
        this.lfj.setVisibility(0);
    }
}
