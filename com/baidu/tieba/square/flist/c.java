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
    TextView aCT;
    LinearLayout gbA;
    private boolean isShow;
    ListView kbA;
    a kbB;
    LinearLayout kbC;
    final View kbg;
    final View kbh;
    LinearLayout kbi;
    private ImageView kbk;
    BdListView kbl;
    BdListView kbm;
    TextView kbn;
    TextView kbo;
    LinearLayout kbp;
    TextView kbq;
    ImageView kbr;
    LinearLayout kbs;
    TextView kbt;
    ImageView kbu;
    h kbv;
    h kbw;
    PopupWindow kbx;
    View kby;
    ForumListActivity kbz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kbj = true;
    private int kbD = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gbA = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kbi = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kbC = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aCT = (TextView) this.kbC.findViewById(R.id.title_text);
        this.kbk = (ImageView) this.kbC.findViewById(R.id.forum_list_title_arrow);
        this.kbn = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kbn.setOnClickListener(forumListActivity);
        this.kbo = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kbo.setOnClickListener(forumListActivity);
        this.kbv = new h(forumListActivity.getPageContext());
        this.kbw = new h(forumListActivity.getPageContext());
        this.kbp = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbg = this.kbp.findViewById(R.id.footer_background);
        this.kbq = (TextView) this.kbp.findViewById(R.id.footer_text);
        this.kbr = (ImageView) this.kbp.findViewById(R.id.footer_icon);
        this.kbs = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbh = this.kbs.findViewById(R.id.footer_background);
        this.kbt = (TextView) this.kbs.findViewById(R.id.footer_text);
        this.kbu = (ImageView) this.kbs.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kbz = forumListActivity;
        this.kbB = new a(this.kbz.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kbz.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kbA = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kbA.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kbD = this.kbB.getCount();
        this.kbA.setAdapter((ListAdapter) this.kbB);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kby == null) {
                this.kby = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kbz.getPageContext().getPageActivity(), 160.0f) - this.kbC.getWidth()) / 2;
            if (this.kbx == null) {
                this.kbx = new PopupWindow(this.kby, l.dip2px(this.kbz.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kbx.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kbD > 6) {
                    this.kbx.setHeight(l.dip2px(this.kbz.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kbx.setOutsideTouchable(true);
            this.kbx.setFocusable(true);
            this.kby.setFocusable(true);
            this.kby.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kbx, this.kbC, 0 - dip2px, l.dip2px(this.kbz.getPageContext().getPageActivity(), 0.0f));
            this.kby.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kbx.isShowing()) {
                        g.dismissPopupWindow(c.this.kbx, c.this.kbz.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kby.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kbx.isShowing()) {
                        g.dismissPopupWindow(c.this.kbx, c.this.kbz.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kbx.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kbx, this.kbz.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cJD() {
        this.kbi.setVisibility(0);
    }

    public void cJE() {
        this.kbi.setVisibility(8);
    }

    public void cJF() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kbl != null) {
                this.kbl.completePullRefreshPostDelayed(0L);
            } else if (this.kbm != null) {
                this.kbm.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cJG() {
        this.kbk.setVisibility(4);
        this.kbC.setClickable(false);
        this.kbC.setOnClickListener(null);
    }

    public void cJH() {
        this.kbk.setVisibility(0);
    }
}
