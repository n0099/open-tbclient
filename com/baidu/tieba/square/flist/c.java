package com.baidu.tieba.square.flist;

import android.graphics.drawable.ColorDrawable;
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
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class c {
    ViewPager Ze;
    TextView bMg;
    LinearLayout iTF;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    TextView nrA;
    LinearLayout nrB;
    TextView nrC;
    ImageView nrD;
    LinearLayout nrE;
    TextView nrF;
    ImageView nrG;
    g nrH;
    g nrI;
    PopupWindow nrJ;
    View nrK;
    ForumListActivity nrL;
    ListView nrM;
    a nrN;
    LinearLayout nrO;
    final View nrs;
    final View nrt;
    LinearLayout nru;
    private ImageView nrw;
    BdListView nrx;
    BdListView nry;
    TextView nrz;
    boolean nrv = true;
    private int nrP = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iTF = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.Ze = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.Ze.setOnPageChangeListener(forumListActivity);
        this.nru = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nrO = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bMg = (TextView) this.nrO.findViewById(R.id.title_text);
        this.nrw = (ImageView) this.nrO.findViewById(R.id.forum_list_title_arrow);
        this.nrz = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.nrz.setOnClickListener(forumListActivity);
        this.nrA = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.nrA.setOnClickListener(forumListActivity);
        this.nrH = new g(forumListActivity.getPageContext());
        this.nrI = new g(forumListActivity.getPageContext());
        this.nrB = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nrs = this.nrB.findViewById(R.id.footer_background);
        this.nrC = (TextView) this.nrB.findViewById(R.id.footer_text);
        this.nrD = (ImageView) this.nrB.findViewById(R.id.footer_icon);
        this.nrE = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nrt = this.nrE.findViewById(R.id.footer_background);
        this.nrF = (TextView) this.nrE.findViewById(R.id.footer_text);
        this.nrG = (ImageView) this.nrE.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.nrL = forumListActivity;
        this.nrN = new a(this.nrL.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.nrL.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.nrM = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.nrM.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.nrP = this.nrN.getCount();
        this.nrM.setAdapter((ListAdapter) this.nrN);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.nrK == null) {
                this.nrK = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.nrL.getPageContext().getPageActivity(), 160.0f) - this.nrO.getWidth()) / 2;
            if (this.nrJ == null) {
                this.nrJ = new PopupWindow(this.nrK, l.dip2px(this.nrL.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.nrJ.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.nrP > 6) {
                    this.nrJ.setHeight(l.dip2px(this.nrL.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.nrJ.setOutsideTouchable(true);
            this.nrJ.setFocusable(true);
            this.nrK.setFocusable(true);
            this.nrK.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.nrJ, this.nrO, 0 - dip2px, l.dip2px(this.nrL.getPageContext().getPageActivity(), 0.0f));
            this.nrK.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.nrJ.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nrJ, c.this.nrL.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nrK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.nrJ.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nrJ, c.this.nrL.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nrJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nrJ, this.nrL.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dMb() {
        this.nru.setVisibility(0);
    }

    public void dMc() {
        this.nru.setVisibility(8);
    }

    public void dMd() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Ze != null) {
            if (this.Ze.getCurrentItem() == 0 && this.nrx != null) {
                this.nrx.completePullRefreshPostDelayed(0L);
            } else if (this.nry != null) {
                this.nry.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dMe() {
        this.nrw.setVisibility(4);
        this.nrO.setClickable(false);
        this.nrO.setOnClickListener(null);
    }

    public void dMf() {
        this.nrw.setVisibility(0);
    }
}
