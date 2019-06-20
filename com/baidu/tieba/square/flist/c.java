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
    i iTA;
    PopupWindow iTB;
    View iTC;
    ForumListActivity iTD;
    ListView iTE;
    a iTF;
    LinearLayout iTG;
    final View iTk;
    final View iTl;
    LinearLayout iTm;
    private ImageView iTo;
    BdListView iTp;
    BdListView iTq;
    TextView iTr;
    TextView iTs;
    LinearLayout iTt;
    TextView iTu;
    ImageView iTv;
    LinearLayout iTw;
    TextView iTx;
    ImageView iTy;
    i iTz;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iTn = true;
    private int iTH = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.eYE = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iTm = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iTG = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.faq = (TextView) this.iTG.findViewById(R.id.title_text);
        this.iTo = (ImageView) this.iTG.findViewById(R.id.forum_list_title_arrow);
        this.iTr = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.iTr.setOnClickListener(forumListActivity);
        this.iTs = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.iTs.setOnClickListener(forumListActivity);
        this.iTz = new i(forumListActivity.getPageContext());
        this.iTA = new i(forumListActivity.getPageContext());
        this.iTt = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTk = this.iTt.findViewById(R.id.footer_background);
        this.iTu = (TextView) this.iTt.findViewById(R.id.footer_text);
        this.iTv = (ImageView) this.iTt.findViewById(R.id.footer_icon);
        this.iTw = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iTl = this.iTw.findViewById(R.id.footer_background);
        this.iTx = (TextView) this.iTw.findViewById(R.id.footer_text);
        this.iTy = (ImageView) this.iTw.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.iTD = forumListActivity;
        this.iTF = new a(this.iTD.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iTD.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.iTE = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.iTE.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.iTH = this.iTF.getCount();
        this.iTE.setAdapter((ListAdapter) this.iTF);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iTC == null) {
                this.iTC = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iTD.getPageContext().getPageActivity(), 160.0f) - this.iTG.getWidth()) / 2;
            if (this.iTB == null) {
                this.iTB = new PopupWindow(this.iTC, l.dip2px(this.iTD.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iTB.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iTH > 6) {
                    this.iTB.setHeight(l.dip2px(this.iTD.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iTB.setOutsideTouchable(true);
            this.iTB.setFocusable(true);
            this.iTC.setFocusable(true);
            this.iTC.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iTB, this.iTG, 0 - dip2px, l.dip2px(this.iTD.getPageContext().getPageActivity(), 0.0f));
            this.iTC.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iTB.isShowing()) {
                        g.a(c.this.iTB, c.this.iTD.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iTB.isShowing()) {
                        g.a(c.this.iTB, c.this.iTD.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iTB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iTB, this.iTD.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void ckX() {
        this.iTm.setVisibility(0);
    }

    public void ckY() {
        this.iTm.setVisibility(8);
    }

    public void ckZ() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iTp != null) {
                this.iTp.completePullRefreshPostDelayed(0L);
            } else if (this.iTq != null) {
                this.iTq.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cla() {
        this.iTo.setVisibility(4);
        this.iTG.setClickable(false);
        this.iTG.setOnClickListener(null);
    }

    public void clb() {
        this.iTo.setVisibility(0);
    }
}
