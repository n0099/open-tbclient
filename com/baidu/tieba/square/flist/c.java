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
    TextView aqv;
    private boolean cGJ;
    LinearLayout fiG;
    final View jcR;
    final View jcS;
    LinearLayout jcT;
    private ImageView jcV;
    BdListView jcW;
    BdListView jcX;
    TextView jcY;
    TextView jcZ;
    LinearLayout jda;
    TextView jdb;
    ImageView jdc;
    LinearLayout jdd;
    TextView jde;
    ImageView jdf;
    i jdg;
    i jdh;
    PopupWindow jdi;
    View jdj;
    ForumListActivity jdk;
    ListView jdl;
    a jdm;
    LinearLayout jdn;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean jcU = true;
    private int jdo = 0;

    public c(ForumListActivity forumListActivity) {
        this.cGJ = false;
        this.fiG = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.jcT = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jdn = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aqv = (TextView) this.jdn.findViewById(R.id.title_text);
        this.jcV = (ImageView) this.jdn.findViewById(R.id.forum_list_title_arrow);
        this.jcY = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.jcY.setOnClickListener(forumListActivity);
        this.jcZ = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.jcZ.setOnClickListener(forumListActivity);
        this.jdg = new i(forumListActivity.getPageContext());
        this.jdh = new i(forumListActivity.getPageContext());
        this.jda = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jcR = this.jda.findViewById(R.id.footer_background);
        this.jdb = (TextView) this.jda.findViewById(R.id.footer_text);
        this.jdc = (ImageView) this.jda.findViewById(R.id.footer_icon);
        this.jdd = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jcS = this.jdd.findViewById(R.id.footer_background);
        this.jde = (TextView) this.jdd.findViewById(R.id.footer_text);
        this.jdf = (ImageView) this.jdd.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.cGJ = false;
        this.jdk = forumListActivity;
        this.jdm = new a(this.jdk.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.jdk.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.jdl = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.jdl.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.jdo = this.jdm.getCount();
        this.jdl.setAdapter((ListAdapter) this.jdm);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.cGJ) {
            this.cGJ = true;
            if (this.jdj == null) {
                this.jdj = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.jdk.getPageContext().getPageActivity(), 160.0f) - this.jdn.getWidth()) / 2;
            if (this.jdi == null) {
                this.jdi = new PopupWindow(this.jdj, l.dip2px(this.jdk.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.jdi.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.jdo > 6) {
                    this.jdi.setHeight(l.dip2px(this.jdk.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.jdi.setOutsideTouchable(true);
            this.jdi.setFocusable(true);
            this.jdj.setFocusable(true);
            this.jdj.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.jdi, this.jdn, 0 - dip2px, l.dip2px(this.jdk.getPageContext().getPageActivity(), 0.0f));
            this.jdj.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.jdi.isShowing()) {
                        g.dismissPopupWindow(c.this.jdi, c.this.jdk.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jdj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.jdi.isShowing()) {
                        g.dismissPopupWindow(c.this.jdi, c.this.jdk.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jdi.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.cGJ = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.jdi, this.jdk.getPageContext().getPageActivity());
        this.cGJ = false;
    }

    public void cmK() {
        this.jcT.setVisibility(0);
    }

    public void cmL() {
        this.jcT.setVisibility(8);
    }

    public void cmM() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.jcW != null) {
                this.jcW.completePullRefreshPostDelayed(0L);
            } else if (this.jcX != null) {
                this.jcX.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cmN() {
        this.jcV.setVisibility(4);
        this.jdn.setClickable(false);
        this.jdn.setOnClickListener(null);
    }

    public void cmO() {
        this.jcV.setVisibility(0);
    }
}
