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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c {
    LinearLayout ffS;
    TextView fhE;
    private boolean isShow;
    final View jda;
    final View jdb;
    LinearLayout jdc;
    private ImageView jde;
    BdListView jdf;
    BdListView jdg;
    TextView jdh;
    TextView jdi;
    LinearLayout jdj;
    TextView jdk;
    ImageView jdl;
    LinearLayout jdm;
    TextView jdn;
    ImageView jdo;
    i jdp;
    i jdq;
    PopupWindow jdr;
    View jds;
    ForumListActivity jdt;
    ListView jdu;
    a jdv;
    LinearLayout jdw;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean jdd = true;
    private int jdx = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.ffS = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.jdc = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdw = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.fhE = (TextView) this.jdw.findViewById(R.id.title_text);
        this.jde = (ImageView) this.jdw.findViewById(R.id.forum_list_title_arrow);
        this.jdh = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.jdh.setOnClickListener(forumListActivity);
        this.jdi = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.jdi.setOnClickListener(forumListActivity);
        this.jdp = new i(forumListActivity.getPageContext());
        this.jdq = new i(forumListActivity.getPageContext());
        this.jdj = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jda = this.jdj.findViewById(R.id.footer_background);
        this.jdk = (TextView) this.jdj.findViewById(R.id.footer_text);
        this.jdl = (ImageView) this.jdj.findViewById(R.id.footer_icon);
        this.jdm = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jdb = this.jdm.findViewById(R.id.footer_background);
        this.jdn = (TextView) this.jdm.findViewById(R.id.footer_text);
        this.jdo = (ImageView) this.jdm.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.jdt = forumListActivity;
        this.jdv = new a(this.jdt.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.jdt.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.jdu = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.jdu.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.jdx = this.jdv.getCount();
        this.jdu.setAdapter((ListAdapter) this.jdv);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.jds == null) {
                this.jds = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.jdt.getPageContext().getPageActivity(), 160.0f) - this.jdw.getWidth()) / 2;
            if (this.jdr == null) {
                this.jdr = new PopupWindow(this.jds, l.dip2px(this.jdt.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.jdr.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.jdx > 6) {
                    this.jdr.setHeight(l.dip2px(this.jdt.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.jdr.setOutsideTouchable(true);
            this.jdr.setFocusable(true);
            this.jds.setFocusable(true);
            this.jds.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.jdr, this.jdw, 0 - dip2px, l.dip2px(this.jdt.getPageContext().getPageActivity(), 0.0f));
            this.jds.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.jdr.isShowing()) {
                        g.a(c.this.jdr, c.this.jdt.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jds.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.jdr.isShowing()) {
                        g.a(c.this.jdr, c.this.jdt.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jdr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.jdr, this.jdt.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void coU() {
        this.jdc.setVisibility(0);
    }

    public void coV() {
        this.jdc.setVisibility(8);
    }

    public void coW() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.jdf != null) {
                this.jdf.completePullRefreshPostDelayed(0L);
            } else if (this.jdg != null) {
                this.jdg.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void coX() {
        this.jde.setVisibility(4);
        this.jdw.setClickable(false);
        this.jdw.setOnClickListener(null);
    }

    public void coY() {
        this.jde.setVisibility(0);
    }
}
