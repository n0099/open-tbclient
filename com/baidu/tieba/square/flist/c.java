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
    final View nlO;
    final View nlP;
    LinearLayout nlQ;
    private ImageView nlS;
    BdListView nlT;
    BdListView nlU;
    TextView nlV;
    TextView nlW;
    LinearLayout nlX;
    TextView nlY;
    ImageView nlZ;
    LinearLayout nma;
    TextView nmb;
    ImageView nmc;
    g nmd;
    g nme;
    PopupWindow nmf;
    View nmg;
    ForumListActivity nmh;
    ListView nmi;
    a nmj;
    LinearLayout nmk;
    boolean nlR = true;
    private int nml = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iSr = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.Zk = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.Zk.setOnPageChangeListener(forumListActivity);
        this.nlQ = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nmk = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bNi = (TextView) this.nmk.findViewById(R.id.title_text);
        this.nlS = (ImageView) this.nmk.findViewById(R.id.forum_list_title_arrow);
        this.nlV = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.nlV.setOnClickListener(forumListActivity);
        this.nlW = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.nlW.setOnClickListener(forumListActivity);
        this.nmd = new g(forumListActivity.getPageContext());
        this.nme = new g(forumListActivity.getPageContext());
        this.nlX = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nlO = this.nlX.findViewById(R.id.footer_background);
        this.nlY = (TextView) this.nlX.findViewById(R.id.footer_text);
        this.nlZ = (ImageView) this.nlX.findViewById(R.id.footer_icon);
        this.nma = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nlP = this.nma.findViewById(R.id.footer_background);
        this.nmb = (TextView) this.nma.findViewById(R.id.footer_text);
        this.nmc = (ImageView) this.nma.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.nmh = forumListActivity;
        this.nmj = new a(this.nmh.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.nmh.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.nmi = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.nmi.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.nml = this.nmj.getCount();
        this.nmi.setAdapter((ListAdapter) this.nmj);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.nmg == null) {
                this.nmg = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.nmh.getPageContext().getPageActivity(), 160.0f) - this.nmk.getWidth()) / 2;
            if (this.nmf == null) {
                this.nmf = new PopupWindow(this.nmg, l.dip2px(this.nmh.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.nmf.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.nml > 6) {
                    this.nmf.setHeight(l.dip2px(this.nmh.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.nmf.setOutsideTouchable(true);
            this.nmf.setFocusable(true);
            this.nmg.setFocusable(true);
            this.nmg.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.nmf, this.nmk, 0 - dip2px, l.dip2px(this.nmh.getPageContext().getPageActivity(), 0.0f));
            this.nmg.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.nmf.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nmf, c.this.nmh.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nmg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.nmf.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nmf, c.this.nmh.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nmf.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nmf, this.nmh.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dNA() {
        this.nlQ.setVisibility(0);
    }

    public void dNB() {
        this.nlQ.setVisibility(8);
    }

    public void dNC() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Zk != null) {
            if (this.Zk.getCurrentItem() == 0 && this.nlT != null) {
                this.nlT.completePullRefreshPostDelayed(0L);
            } else if (this.nlU != null) {
                this.nlU.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dND() {
        this.nlS.setVisibility(4);
        this.nmk.setClickable(false);
        this.nmk.setOnClickListener(null);
    }

    public void dNE() {
        this.nlS.setVisibility(0);
    }
}
