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
    TextView aCS;
    LinearLayout gby;
    private boolean isShow;
    LinearLayout kbA;
    final View kbe;
    final View kbf;
    LinearLayout kbg;
    private ImageView kbi;
    BdListView kbj;
    BdListView kbk;
    TextView kbl;
    TextView kbm;
    LinearLayout kbn;
    TextView kbo;
    ImageView kbp;
    LinearLayout kbq;
    TextView kbr;
    ImageView kbs;
    h kbt;
    h kbu;
    PopupWindow kbv;
    View kbw;
    ForumListActivity kbx;
    ListView kby;
    a kbz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kbh = true;
    private int kbB = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gby = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kbg = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kbA = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aCS = (TextView) this.kbA.findViewById(R.id.title_text);
        this.kbi = (ImageView) this.kbA.findViewById(R.id.forum_list_title_arrow);
        this.kbl = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kbl.setOnClickListener(forumListActivity);
        this.kbm = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kbm.setOnClickListener(forumListActivity);
        this.kbt = new h(forumListActivity.getPageContext());
        this.kbu = new h(forumListActivity.getPageContext());
        this.kbn = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbe = this.kbn.findViewById(R.id.footer_background);
        this.kbo = (TextView) this.kbn.findViewById(R.id.footer_text);
        this.kbp = (ImageView) this.kbn.findViewById(R.id.footer_icon);
        this.kbq = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbf = this.kbq.findViewById(R.id.footer_background);
        this.kbr = (TextView) this.kbq.findViewById(R.id.footer_text);
        this.kbs = (ImageView) this.kbq.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kbx = forumListActivity;
        this.kbz = new a(this.kbx.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kbx.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kby = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kby.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kbB = this.kbz.getCount();
        this.kby.setAdapter((ListAdapter) this.kbz);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kbw == null) {
                this.kbw = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kbx.getPageContext().getPageActivity(), 160.0f) - this.kbA.getWidth()) / 2;
            if (this.kbv == null) {
                this.kbv = new PopupWindow(this.kbw, l.dip2px(this.kbx.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kbv.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kbB > 6) {
                    this.kbv.setHeight(l.dip2px(this.kbx.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kbv.setOutsideTouchable(true);
            this.kbv.setFocusable(true);
            this.kbw.setFocusable(true);
            this.kbw.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kbv, this.kbA, 0 - dip2px, l.dip2px(this.kbx.getPageContext().getPageActivity(), 0.0f));
            this.kbw.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kbv.isShowing()) {
                        g.dismissPopupWindow(c.this.kbv, c.this.kbx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kbw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kbv.isShowing()) {
                        g.dismissPopupWindow(c.this.kbv, c.this.kbx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kbv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kbv, this.kbx.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cJB() {
        this.kbg.setVisibility(0);
    }

    public void cJC() {
        this.kbg.setVisibility(8);
    }

    public void cJD() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kbj != null) {
                this.kbj.completePullRefreshPostDelayed(0L);
            } else if (this.kbk != null) {
                this.kbk.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cJE() {
        this.kbi.setVisibility(4);
        this.kbA.setClickable(false);
        this.kbA.setOnClickListener(null);
    }

    public void cJF() {
        this.kbi.setVisibility(0);
    }
}
