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
    TextView aCU;
    LinearLayout gbN;
    private boolean isShow;
    TextView kbA;
    LinearLayout kbB;
    TextView kbC;
    ImageView kbD;
    LinearLayout kbE;
    TextView kbF;
    ImageView kbG;
    h kbH;
    h kbI;
    PopupWindow kbJ;
    View kbK;
    ForumListActivity kbL;
    ListView kbM;
    a kbN;
    LinearLayout kbO;
    final View kbs;
    final View kbt;
    LinearLayout kbu;
    private ImageView kbw;
    BdListView kbx;
    BdListView kby;
    TextView kbz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kbv = true;
    private int kbP = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.gbN = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kbu = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kbO = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.aCU = (TextView) this.kbO.findViewById(R.id.title_text);
        this.kbw = (ImageView) this.kbO.findViewById(R.id.forum_list_title_arrow);
        this.kbz = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kbz.setOnClickListener(forumListActivity);
        this.kbA = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kbA.setOnClickListener(forumListActivity);
        this.kbH = new h(forumListActivity.getPageContext());
        this.kbI = new h(forumListActivity.getPageContext());
        this.kbB = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbs = this.kbB.findViewById(R.id.footer_background);
        this.kbC = (TextView) this.kbB.findViewById(R.id.footer_text);
        this.kbD = (ImageView) this.kbB.findViewById(R.id.footer_icon);
        this.kbE = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kbt = this.kbE.findViewById(R.id.footer_background);
        this.kbF = (TextView) this.kbE.findViewById(R.id.footer_text);
        this.kbG = (ImageView) this.kbE.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kbL = forumListActivity;
        this.kbN = new a(this.kbL.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kbL.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kbM = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kbM.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kbP = this.kbN.getCount();
        this.kbM.setAdapter((ListAdapter) this.kbN);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kbK == null) {
                this.kbK = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kbL.getPageContext().getPageActivity(), 160.0f) - this.kbO.getWidth()) / 2;
            if (this.kbJ == null) {
                this.kbJ = new PopupWindow(this.kbK, l.dip2px(this.kbL.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kbJ.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kbP > 6) {
                    this.kbJ.setHeight(l.dip2px(this.kbL.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kbJ.setOutsideTouchable(true);
            this.kbJ.setFocusable(true);
            this.kbK.setFocusable(true);
            this.kbK.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kbJ, this.kbO, 0 - dip2px, l.dip2px(this.kbL.getPageContext().getPageActivity(), 0.0f));
            this.kbK.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kbJ.isShowing()) {
                        g.dismissPopupWindow(c.this.kbJ, c.this.kbL.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kbK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kbJ.isShowing()) {
                        g.dismissPopupWindow(c.this.kbJ, c.this.kbL.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kbJ.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kbJ, this.kbL.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cJE() {
        this.kbu.setVisibility(0);
    }

    public void cJF() {
        this.kbu.setVisibility(8);
    }

    public void cJG() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kbx != null) {
                this.kbx.completePullRefreshPostDelayed(0L);
            } else if (this.kby != null) {
                this.kby.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cJH() {
        this.kbw.setVisibility(4);
        this.kbO.setClickable(false);
        this.kbO.setOnClickListener(null);
    }

    public void cJI() {
        this.kbw.setVisibility(0);
    }
}
