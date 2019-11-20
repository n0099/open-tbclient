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
    TextView aqd;
    private boolean cFS;
    LinearLayout fhN;
    final View jca;
    final View jcb;
    LinearLayout jcc;
    private ImageView jce;
    BdListView jcf;
    BdListView jcg;
    TextView jch;
    TextView jci;
    LinearLayout jcj;
    TextView jck;
    ImageView jcl;
    LinearLayout jcm;
    TextView jcn;
    ImageView jco;
    i jcp;
    i jcq;
    PopupWindow jcr;
    View jcs;
    ForumListActivity jct;
    ListView jcu;
    a jcv;
    LinearLayout jcw;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean jcd = true;
    private int jcx = 0;

    public c(ForumListActivity forumListActivity) {
        this.cFS = false;
        this.fhN = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.jcc = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jcw = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aqd = (TextView) this.jcw.findViewById(R.id.title_text);
        this.jce = (ImageView) this.jcw.findViewById(R.id.forum_list_title_arrow);
        this.jch = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.jch.setOnClickListener(forumListActivity);
        this.jci = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.jci.setOnClickListener(forumListActivity);
        this.jcp = new i(forumListActivity.getPageContext());
        this.jcq = new i(forumListActivity.getPageContext());
        this.jcj = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jca = this.jcj.findViewById(R.id.footer_background);
        this.jck = (TextView) this.jcj.findViewById(R.id.footer_text);
        this.jcl = (ImageView) this.jcj.findViewById(R.id.footer_icon);
        this.jcm = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jcb = this.jcm.findViewById(R.id.footer_background);
        this.jcn = (TextView) this.jcm.findViewById(R.id.footer_text);
        this.jco = (ImageView) this.jcm.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.cFS = false;
        this.jct = forumListActivity;
        this.jcv = new a(this.jct.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.jct.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.jcu = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.jcu.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.jcx = this.jcv.getCount();
        this.jcu.setAdapter((ListAdapter) this.jcv);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.cFS) {
            this.cFS = true;
            if (this.jcs == null) {
                this.jcs = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.jct.getPageContext().getPageActivity(), 160.0f) - this.jcw.getWidth()) / 2;
            if (this.jcr == null) {
                this.jcr = new PopupWindow(this.jcs, l.dip2px(this.jct.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.jcr.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.jcx > 6) {
                    this.jcr.setHeight(l.dip2px(this.jct.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.jcr.setOutsideTouchable(true);
            this.jcr.setFocusable(true);
            this.jcs.setFocusable(true);
            this.jcs.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.jcr, this.jcw, 0 - dip2px, l.dip2px(this.jct.getPageContext().getPageActivity(), 0.0f));
            this.jcs.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.jcr.isShowing()) {
                        g.dismissPopupWindow(c.this.jcr, c.this.jct.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jcs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.jcr.isShowing()) {
                        g.dismissPopupWindow(c.this.jcr, c.this.jct.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jcr.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.cFS = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.jcr, this.jct.getPageContext().getPageActivity());
        this.cFS = false;
    }

    public void cmI() {
        this.jcc.setVisibility(0);
    }

    public void cmJ() {
        this.jcc.setVisibility(8);
    }

    public void cmK() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.jcf != null) {
                this.jcf.completePullRefreshPostDelayed(0L);
            } else if (this.jcg != null) {
                this.jcg.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cmL() {
        this.jce.setVisibility(4);
        this.jcw.setClickable(false);
        this.jcw.setOnClickListener(null);
    }

    public void cmM() {
        this.jce.setVisibility(0);
    }
}
