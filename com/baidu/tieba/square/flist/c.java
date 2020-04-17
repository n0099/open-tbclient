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
    TextView aWP;
    LinearLayout gLG;
    private boolean isShow;
    final View kMK;
    final View kML;
    LinearLayout kMM;
    private ImageView kMO;
    BdListView kMP;
    BdListView kMQ;
    TextView kMR;
    TextView kMS;
    LinearLayout kMT;
    TextView kMU;
    ImageView kMV;
    LinearLayout kMW;
    TextView kMX;
    ImageView kMY;
    h kMZ;
    h kNa;
    PopupWindow kNb;
    View kNc;
    ForumListActivity kNd;
    ListView kNe;
    a kNf;
    LinearLayout kNg;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kMN = true;
    private int kNh = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gLG = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kMM = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kNg = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aWP = (TextView) this.kNg.findViewById(R.id.title_text);
        this.kMO = (ImageView) this.kNg.findViewById(R.id.forum_list_title_arrow);
        this.kMR = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kMR.setOnClickListener(forumListActivity);
        this.kMS = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kMS.setOnClickListener(forumListActivity);
        this.kMZ = new h(forumListActivity.getPageContext());
        this.kNa = new h(forumListActivity.getPageContext());
        this.kMT = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kMK = this.kMT.findViewById(R.id.footer_background);
        this.kMU = (TextView) this.kMT.findViewById(R.id.footer_text);
        this.kMV = (ImageView) this.kMT.findViewById(R.id.footer_icon);
        this.kMW = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kML = this.kMW.findViewById(R.id.footer_background);
        this.kMX = (TextView) this.kMW.findViewById(R.id.footer_text);
        this.kMY = (ImageView) this.kMW.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kNd = forumListActivity;
        this.kNf = new a(this.kNd.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kNd.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kNe = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kNe.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kNh = this.kNf.getCount();
        this.kNe.setAdapter((ListAdapter) this.kNf);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kNc == null) {
                this.kNc = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kNd.getPageContext().getPageActivity(), 160.0f) - this.kNg.getWidth()) / 2;
            if (this.kNb == null) {
                this.kNb = new PopupWindow(this.kNc, l.dip2px(this.kNd.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kNb.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kNh > 6) {
                    this.kNb.setHeight(l.dip2px(this.kNd.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kNb.setOutsideTouchable(true);
            this.kNb.setFocusable(true);
            this.kNc.setFocusable(true);
            this.kNc.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kNb, this.kNg, 0 - dip2px, l.dip2px(this.kNd.getPageContext().getPageActivity(), 0.0f));
            this.kNc.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kNb.isShowing()) {
                        g.dismissPopupWindow(c.this.kNb, c.this.kNd.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kNc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kNb.isShowing()) {
                        g.dismissPopupWindow(c.this.kNb, c.this.kNd.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kNb.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kNb, this.kNd.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cUT() {
        this.kMM.setVisibility(0);
    }

    public void cUU() {
        this.kMM.setVisibility(8);
    }

    public void cUV() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kMP != null) {
                this.kMP.completePullRefreshPostDelayed(0L);
            } else if (this.kMQ != null) {
                this.kMQ.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cUW() {
        this.kMO.setVisibility(4);
        this.kNg.setClickable(false);
        this.kNg.setOnClickListener(null);
    }

    public void cUX() {
        this.kMO.setVisibility(0);
    }
}
