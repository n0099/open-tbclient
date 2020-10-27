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
/* loaded from: classes23.dex */
public class c {
    TextView byL;
    LinearLayout ioA;
    private boolean isShow;
    ImageView mLA;
    g mLB;
    g mLC;
    PopupWindow mLD;
    View mLE;
    ForumListActivity mLF;
    ListView mLG;
    a mLH;
    LinearLayout mLI;
    final View mLm;
    final View mLn;
    LinearLayout mLo;
    private ImageView mLq;
    BdListView mLr;
    BdListView mLs;
    TextView mLt;
    TextView mLu;
    LinearLayout mLv;
    TextView mLw;
    ImageView mLx;
    LinearLayout mLy;
    TextView mLz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean mLp = true;
    private int mLJ = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.ioA = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.mLo = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mLI = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.byL = (TextView) this.mLI.findViewById(R.id.title_text);
        this.mLq = (ImageView) this.mLI.findViewById(R.id.forum_list_title_arrow);
        this.mLt = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.mLt.setOnClickListener(forumListActivity);
        this.mLu = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.mLu.setOnClickListener(forumListActivity);
        this.mLB = new g(forumListActivity.getPageContext());
        this.mLC = new g(forumListActivity.getPageContext());
        this.mLv = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mLm = this.mLv.findViewById(R.id.footer_background);
        this.mLw = (TextView) this.mLv.findViewById(R.id.footer_text);
        this.mLx = (ImageView) this.mLv.findViewById(R.id.footer_icon);
        this.mLy = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mLn = this.mLy.findViewById(R.id.footer_background);
        this.mLz = (TextView) this.mLy.findViewById(R.id.footer_text);
        this.mLA = (ImageView) this.mLy.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.mLF = forumListActivity;
        this.mLH = new a(this.mLF.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.mLF.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.mLG = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.mLG.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.mLJ = this.mLH.getCount();
        this.mLG.setAdapter((ListAdapter) this.mLH);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.mLE == null) {
                this.mLE = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.mLF.getPageContext().getPageActivity(), 160.0f) - this.mLI.getWidth()) / 2;
            if (this.mLD == null) {
                this.mLD = new PopupWindow(this.mLE, l.dip2px(this.mLF.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.mLD.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.mLJ > 6) {
                    this.mLD.setHeight(l.dip2px(this.mLF.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.mLD.setOutsideTouchable(true);
            this.mLD.setFocusable(true);
            this.mLE.setFocusable(true);
            this.mLE.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.mLD, this.mLI, 0 - dip2px, l.dip2px(this.mLF.getPageContext().getPageActivity(), 0.0f));
            this.mLE.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.mLD.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mLD, c.this.mLF.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mLE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.mLD.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mLD, c.this.mLF.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mLD.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mLD, this.mLF.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dFX() {
        this.mLo.setVisibility(0);
    }

    public void dFY() {
        this.mLo.setVisibility(8);
    }

    public void dFZ() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.mLr != null) {
                this.mLr.completePullRefreshPostDelayed(0L);
            } else if (this.mLs != null) {
                this.mLs.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dGa() {
        this.mLq.setVisibility(4);
        this.mLI.setClickable(false);
        this.mLI.setOnClickListener(null);
    }

    public void dGb() {
        this.mLq.setVisibility(0);
    }
}
