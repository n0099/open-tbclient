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
    ViewPager Zk;
    TextView bNi;
    LinearLayout iSr;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    final View nlP;
    final View nlQ;
    LinearLayout nlR;
    private ImageView nlT;
    BdListView nlU;
    BdListView nlV;
    TextView nlW;
    TextView nlX;
    LinearLayout nlY;
    TextView nlZ;
    ImageView nma;
    LinearLayout nmb;
    TextView nmc;
    ImageView nmd;
    g nme;
    g nmf;
    PopupWindow nmg;
    View nmh;
    ForumListActivity nmi;
    ListView nmj;
    a nmk;
    LinearLayout nml;
    boolean nlS = true;
    private int nmm = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iSr = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.Zk = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.Zk.setOnPageChangeListener(forumListActivity);
        this.nlR = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nml = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bNi = (TextView) this.nml.findViewById(R.id.title_text);
        this.nlT = (ImageView) this.nml.findViewById(R.id.forum_list_title_arrow);
        this.nlW = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.nlW.setOnClickListener(forumListActivity);
        this.nlX = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.nlX.setOnClickListener(forumListActivity);
        this.nme = new g(forumListActivity.getPageContext());
        this.nmf = new g(forumListActivity.getPageContext());
        this.nlY = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nlP = this.nlY.findViewById(R.id.footer_background);
        this.nlZ = (TextView) this.nlY.findViewById(R.id.footer_text);
        this.nma = (ImageView) this.nlY.findViewById(R.id.footer_icon);
        this.nmb = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nlQ = this.nmb.findViewById(R.id.footer_background);
        this.nmc = (TextView) this.nmb.findViewById(R.id.footer_text);
        this.nmd = (ImageView) this.nmb.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.nmi = forumListActivity;
        this.nmk = new a(this.nmi.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.nmi.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.nmj = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.nmj.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.nmm = this.nmk.getCount();
        this.nmj.setAdapter((ListAdapter) this.nmk);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.nmh == null) {
                this.nmh = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.nmi.getPageContext().getPageActivity(), 160.0f) - this.nml.getWidth()) / 2;
            if (this.nmg == null) {
                this.nmg = new PopupWindow(this.nmh, l.dip2px(this.nmi.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.nmg.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.nmm > 6) {
                    this.nmg.setHeight(l.dip2px(this.nmi.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.nmg.setOutsideTouchable(true);
            this.nmg.setFocusable(true);
            this.nmh.setFocusable(true);
            this.nmh.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.nmg, this.nml, 0 - dip2px, l.dip2px(this.nmi.getPageContext().getPageActivity(), 0.0f));
            this.nmh.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.nmg.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nmg, c.this.nmi.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nmh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.nmg.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nmg, c.this.nmi.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nmg.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmg, this.nmi.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dNz() {
        this.nlR.setVisibility(0);
    }

    public void dNA() {
        this.nlR.setVisibility(8);
    }

    public void dNB() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Zk != null) {
            if (this.Zk.getCurrentItem() == 0 && this.nlU != null) {
                this.nlU.completePullRefreshPostDelayed(0L);
            } else if (this.nlV != null) {
                this.nlV.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dNC() {
        this.nlT.setVisibility(4);
        this.nml.setClickable(false);
        this.nml.setOnClickListener(null);
    }

    public void dND() {
        this.nlT.setVisibility(0);
    }
}
