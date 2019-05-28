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
    LinearLayout eYE;
    TextView faq;
    ListView iTA;
    a iTB;
    LinearLayout iTC;
    final View iTg;
    final View iTh;
    LinearLayout iTi;
    private ImageView iTk;
    BdListView iTl;
    BdListView iTm;
    TextView iTn;
    TextView iTo;
    LinearLayout iTp;
    TextView iTq;
    ImageView iTr;
    LinearLayout iTs;
    TextView iTt;
    ImageView iTu;
    i iTv;
    i iTw;
    PopupWindow iTx;
    View iTy;
    ForumListActivity iTz;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iTj = true;
    private int iTD = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eYE = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iTi = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTC = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.faq = (TextView) this.iTC.findViewById(R.id.title_text);
        this.iTk = (ImageView) this.iTC.findViewById(R.id.forum_list_title_arrow);
        this.iTn = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.iTn.setOnClickListener(forumListActivity);
        this.iTo = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.iTo.setOnClickListener(forumListActivity);
        this.iTv = new i(forumListActivity.getPageContext());
        this.iTw = new i(forumListActivity.getPageContext());
        this.iTp = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTg = this.iTp.findViewById(R.id.footer_background);
        this.iTq = (TextView) this.iTp.findViewById(R.id.footer_text);
        this.iTr = (ImageView) this.iTp.findViewById(R.id.footer_icon);
        this.iTs = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTh = this.iTs.findViewById(R.id.footer_background);
        this.iTt = (TextView) this.iTs.findViewById(R.id.footer_text);
        this.iTu = (ImageView) this.iTs.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.iTz = forumListActivity;
        this.iTB = new a(this.iTz.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iTz.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.iTA = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.iTA.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.iTD = this.iTB.getCount();
        this.iTA.setAdapter((ListAdapter) this.iTB);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iTy == null) {
                this.iTy = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iTz.getPageContext().getPageActivity(), 160.0f) - this.iTC.getWidth()) / 2;
            if (this.iTx == null) {
                this.iTx = new PopupWindow(this.iTy, l.dip2px(this.iTz.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iTx.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iTD > 6) {
                    this.iTx.setHeight(l.dip2px(this.iTz.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iTx.setOutsideTouchable(true);
            this.iTx.setFocusable(true);
            this.iTy.setFocusable(true);
            this.iTy.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iTx, this.iTC, 0 - dip2px, l.dip2px(this.iTz.getPageContext().getPageActivity(), 0.0f));
            this.iTy.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iTx.isShowing()) {
                        g.a(c.this.iTx, c.this.iTz.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iTx.isShowing()) {
                        g.a(c.this.iTx, c.this.iTz.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iTx, this.iTz.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ckW() {
        this.iTi.setVisibility(0);
    }

    public void ckX() {
        this.iTi.setVisibility(8);
    }

    public void ckY() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iTl != null) {
                this.iTl.completePullRefreshPostDelayed(0L);
            } else if (this.iTm != null) {
                this.iTm.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ckZ() {
        this.iTk.setVisibility(4);
        this.iTC.setClickable(false);
        this.iTC.setOnClickListener(null);
    }

    public void cla() {
        this.iTk.setVisibility(0);
    }
}
