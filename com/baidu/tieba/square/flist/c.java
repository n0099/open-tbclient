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
    LinearLayout iTr;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    final View nqS;
    final View nqT;
    LinearLayout nqU;
    private ImageView nqW;
    BdListView nqX;
    BdListView nqY;
    TextView nqZ;
    TextView nra;
    LinearLayout nrb;
    TextView nrc;
    ImageView nrd;
    LinearLayout nre;
    TextView nrf;
    ImageView nrg;
    g nrh;
    g nri;
    PopupWindow nrj;
    View nrk;
    ForumListActivity nrl;
    ListView nrm;
    a nrn;
    LinearLayout nro;
    boolean nqV = true;
    private int nrp = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iTr = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.Ze = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.Ze.setOnPageChangeListener(forumListActivity);
        this.nqU = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nro = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bMg = (TextView) this.nro.findViewById(R.id.title_text);
        this.nqW = (ImageView) this.nro.findViewById(R.id.forum_list_title_arrow);
        this.nqZ = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.nqZ.setOnClickListener(forumListActivity);
        this.nra = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.nra.setOnClickListener(forumListActivity);
        this.nrh = new g(forumListActivity.getPageContext());
        this.nri = new g(forumListActivity.getPageContext());
        this.nrb = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nqS = this.nrb.findViewById(R.id.footer_background);
        this.nrc = (TextView) this.nrb.findViewById(R.id.footer_text);
        this.nrd = (ImageView) this.nrb.findViewById(R.id.footer_icon);
        this.nre = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nqT = this.nre.findViewById(R.id.footer_background);
        this.nrf = (TextView) this.nre.findViewById(R.id.footer_text);
        this.nrg = (ImageView) this.nre.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.nrl = forumListActivity;
        this.nrn = new a(this.nrl.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.nrl.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.nrm = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.nrm.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.nrp = this.nrn.getCount();
        this.nrm.setAdapter((ListAdapter) this.nrn);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.nrk == null) {
                this.nrk = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.nrl.getPageContext().getPageActivity(), 160.0f) - this.nro.getWidth()) / 2;
            if (this.nrj == null) {
                this.nrj = new PopupWindow(this.nrk, l.dip2px(this.nrl.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.nrj.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.nrp > 6) {
                    this.nrj.setHeight(l.dip2px(this.nrl.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.nrj.setOutsideTouchable(true);
            this.nrj.setFocusable(true);
            this.nrk.setFocusable(true);
            this.nrk.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.nrj, this.nro, 0 - dip2px, l.dip2px(this.nrl.getPageContext().getPageActivity(), 0.0f));
            this.nrk.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.nrj.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nrj, c.this.nrl.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nrk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.nrj.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nrj, c.this.nrl.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nrj.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nrj, this.nrl.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dLT() {
        this.nqU.setVisibility(0);
    }

    public void dLU() {
        this.nqU.setVisibility(8);
    }

    public void dLV() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Ze != null) {
            if (this.Ze.getCurrentItem() == 0 && this.nqX != null) {
                this.nqX.completePullRefreshPostDelayed(0L);
            } else if (this.nqY != null) {
                this.nqY.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dLW() {
        this.nqW.setVisibility(4);
        this.nro.setClickable(false);
        this.nro.setOnClickListener(null);
    }

    public void dLX() {
        this.nqW.setVisibility(0);
    }
}
