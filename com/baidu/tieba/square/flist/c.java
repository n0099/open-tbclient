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
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class c {
    TextView aWU;
    LinearLayout gLM;
    private boolean isShow;
    final View kMO;
    final View kMP;
    LinearLayout kMQ;
    private ImageView kMS;
    BdListView kMT;
    BdListView kMU;
    TextView kMV;
    TextView kMW;
    LinearLayout kMX;
    TextView kMY;
    ImageView kMZ;
    LinearLayout kNa;
    TextView kNb;
    ImageView kNc;
    h kNd;
    h kNe;
    PopupWindow kNf;
    View kNg;
    ForumListActivity kNh;
    ListView kNi;
    a kNj;
    LinearLayout kNk;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kMR = true;
    private int kNl = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gLM = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kMQ = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNk = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aWU = (TextView) this.kNk.findViewById(R.id.title_text);
        this.kMS = (ImageView) this.kNk.findViewById(R.id.forum_list_title_arrow);
        this.kMV = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kMV.setOnClickListener(forumListActivity);
        this.kMW = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kMW.setOnClickListener(forumListActivity);
        this.kNd = new h(forumListActivity.getPageContext());
        this.kNe = new h(forumListActivity.getPageContext());
        this.kMX = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kMO = this.kMX.findViewById(R.id.footer_background);
        this.kMY = (TextView) this.kMX.findViewById(R.id.footer_text);
        this.kMZ = (ImageView) this.kMX.findViewById(R.id.footer_icon);
        this.kNa = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kMP = this.kNa.findViewById(R.id.footer_background);
        this.kNb = (TextView) this.kNa.findViewById(R.id.footer_text);
        this.kNc = (ImageView) this.kNa.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kNh = forumListActivity;
        this.kNj = new a(this.kNh.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kNh.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kNi = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kNi.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kNl = this.kNj.getCount();
        this.kNi.setAdapter((ListAdapter) this.kNj);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kNg == null) {
                this.kNg = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kNh.getPageContext().getPageActivity(), 160.0f) - this.kNk.getWidth()) / 2;
            if (this.kNf == null) {
                this.kNf = new PopupWindow(this.kNg, l.dip2px(this.kNh.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kNf.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kNl > 6) {
                    this.kNf.setHeight(l.dip2px(this.kNh.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kNf.setOutsideTouchable(true);
            this.kNf.setFocusable(true);
            this.kNg.setFocusable(true);
            this.kNg.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kNf, this.kNk, 0 - dip2px, l.dip2px(this.kNh.getPageContext().getPageActivity(), 0.0f));
            this.kNg.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kNf.isShowing()) {
                        g.dismissPopupWindow(c.this.kNf, c.this.kNh.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kNg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kNf.isShowing()) {
                        g.dismissPopupWindow(c.this.kNf, c.this.kNh.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kNf.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kNf, this.kNh.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cUQ() {
        this.kMQ.setVisibility(0);
    }

    public void cUR() {
        this.kMQ.setVisibility(8);
    }

    public void cUS() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kMT != null) {
                this.kMT.completePullRefreshPostDelayed(0L);
            } else if (this.kMU != null) {
                this.kMU.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cUT() {
        this.kMS.setVisibility(4);
        this.kNk.setClickable(false);
        this.kNk.setOnClickListener(null);
    }

    public void cUU() {
        this.kMS.setVisibility(0);
    }
}
