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
    LinearLayout eYD;
    TextView fap;
    LinearLayout iTA;
    final View iTe;
    final View iTf;
    LinearLayout iTg;
    private ImageView iTi;
    BdListView iTj;
    BdListView iTk;
    TextView iTl;
    TextView iTm;
    LinearLayout iTn;
    TextView iTo;
    ImageView iTp;
    LinearLayout iTq;
    TextView iTr;
    ImageView iTs;
    i iTt;
    i iTu;
    PopupWindow iTv;
    View iTw;
    ForumListActivity iTx;
    ListView iTy;
    a iTz;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iTh = true;
    private int iTB = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eYD = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iTg = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTA = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.fap = (TextView) this.iTA.findViewById(R.id.title_text);
        this.iTi = (ImageView) this.iTA.findViewById(R.id.forum_list_title_arrow);
        this.iTl = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.iTl.setOnClickListener(forumListActivity);
        this.iTm = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.iTm.setOnClickListener(forumListActivity);
        this.iTt = new i(forumListActivity.getPageContext());
        this.iTu = new i(forumListActivity.getPageContext());
        this.iTn = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTe = this.iTn.findViewById(R.id.footer_background);
        this.iTo = (TextView) this.iTn.findViewById(R.id.footer_text);
        this.iTp = (ImageView) this.iTn.findViewById(R.id.footer_icon);
        this.iTq = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTf = this.iTq.findViewById(R.id.footer_background);
        this.iTr = (TextView) this.iTq.findViewById(R.id.footer_text);
        this.iTs = (ImageView) this.iTq.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.iTx = forumListActivity;
        this.iTz = new a(this.iTx.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iTx.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.iTy = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.iTy.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.iTB = this.iTz.getCount();
        this.iTy.setAdapter((ListAdapter) this.iTz);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iTw == null) {
                this.iTw = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iTx.getPageContext().getPageActivity(), 160.0f) - this.iTA.getWidth()) / 2;
            if (this.iTv == null) {
                this.iTv = new PopupWindow(this.iTw, l.dip2px(this.iTx.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iTv.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iTB > 6) {
                    this.iTv.setHeight(l.dip2px(this.iTx.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iTv.setOutsideTouchable(true);
            this.iTv.setFocusable(true);
            this.iTw.setFocusable(true);
            this.iTw.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iTv, this.iTA, 0 - dip2px, l.dip2px(this.iTx.getPageContext().getPageActivity(), 0.0f));
            this.iTw.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iTv.isShowing()) {
                        g.a(c.this.iTv, c.this.iTx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iTv.isShowing()) {
                        g.a(c.this.iTv, c.this.iTx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iTv, this.iTx.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ckU() {
        this.iTg.setVisibility(0);
    }

    public void ckV() {
        this.iTg.setVisibility(8);
    }

    public void ckW() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iTj != null) {
                this.iTj.completePullRefreshPostDelayed(0L);
            } else if (this.iTk != null) {
                this.iTk.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void ckX() {
        this.iTi.setVisibility(4);
        this.iTA.setClickable(false);
        this.iTA.setOnClickListener(null);
    }

    public void ckY() {
        this.iTi.setVisibility(0);
    }
}
