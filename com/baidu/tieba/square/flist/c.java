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
    LinearLayout haJ;
    private boolean isShow;
    LinearLayout lgA;
    TextView lgB;
    ImageView lgC;
    g lgD;
    g lgE;
    PopupWindow lgF;
    View lgG;
    ForumListActivity lgH;
    ListView lgI;
    a lgJ;
    LinearLayout lgK;
    final View lgo;
    final View lgp;
    LinearLayout lgq;
    private ImageView lgs;
    BdListView lgt;
    BdListView lgu;
    TextView lgv;
    TextView lgw;
    LinearLayout lgx;
    TextView lgy;
    ImageView lgz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lgr = true;
    private int lgL = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.haJ = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lgq = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lgK = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bem = (TextView) this.lgK.findViewById(R.id.title_text);
        this.lgs = (ImageView) this.lgK.findViewById(R.id.forum_list_title_arrow);
        this.lgv = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lgv.setOnClickListener(forumListActivity);
        this.lgw = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lgw.setOnClickListener(forumListActivity);
        this.lgD = new g(forumListActivity.getPageContext());
        this.lgE = new g(forumListActivity.getPageContext());
        this.lgx = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lgo = this.lgx.findViewById(R.id.footer_background);
        this.lgy = (TextView) this.lgx.findViewById(R.id.footer_text);
        this.lgz = (ImageView) this.lgx.findViewById(R.id.footer_icon);
        this.lgA = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lgp = this.lgA.findViewById(R.id.footer_background);
        this.lgB = (TextView) this.lgA.findViewById(R.id.footer_text);
        this.lgC = (ImageView) this.lgA.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lgH = forumListActivity;
        this.lgJ = new a(this.lgH.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lgH.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lgI = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lgI.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lgL = this.lgJ.getCount();
        this.lgI.setAdapter((ListAdapter) this.lgJ);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lgG == null) {
                this.lgG = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lgH.getPageContext().getPageActivity(), 160.0f) - this.lgK.getWidth()) / 2;
            if (this.lgF == null) {
                this.lgF = new PopupWindow(this.lgG, l.dip2px(this.lgH.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lgF.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lgL > 6) {
                    this.lgF.setHeight(l.dip2px(this.lgH.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lgF.setOutsideTouchable(true);
            this.lgF.setFocusable(true);
            this.lgG.setFocusable(true);
            this.lgG.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lgF, this.lgK, 0 - dip2px, l.dip2px(this.lgH.getPageContext().getPageActivity(), 0.0f));
            this.lgG.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lgF.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lgF, c.this.lgH.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lgG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lgF.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lgF, c.this.lgH.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lgF.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lgF, this.lgH.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dck() {
        this.lgq.setVisibility(0);
    }

    public void dcl() {
        this.lgq.setVisibility(8);
    }

    public void dcm() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lgt != null) {
                this.lgt.completePullRefreshPostDelayed(0L);
            } else if (this.lgu != null) {
                this.lgu.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dcn() {
        this.lgs.setVisibility(4);
        this.lgK.setClickable(false);
        this.lgK.setOnClickListener(null);
    }

    public void dco() {
        this.lgs.setVisibility(0);
    }
}
