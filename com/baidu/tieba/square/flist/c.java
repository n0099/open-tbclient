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
/* loaded from: classes22.dex */
public class c {
    TextView bDl;
    private boolean isShow;
    LinearLayout ivl;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    LinearLayout mSA;
    final View mSd;
    final View mSe;
    LinearLayout mSf;
    private ImageView mSh;
    BdListView mSi;
    BdListView mSj;
    TextView mSk;
    TextView mSl;
    LinearLayout mSm;
    TextView mSn;
    ImageView mSo;
    LinearLayout mSq;
    TextView mSr;
    ImageView mSs;
    g mSt;
    g mSu;
    PopupWindow mSv;
    View mSw;
    ForumListActivity mSx;
    ListView mSy;
    a mSz;
    ViewPager mViewPager;
    boolean mSg = true;
    private int mSB = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.ivl = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.mSf = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mSA = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bDl = (TextView) this.mSA.findViewById(R.id.title_text);
        this.mSh = (ImageView) this.mSA.findViewById(R.id.forum_list_title_arrow);
        this.mSk = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.mSk.setOnClickListener(forumListActivity);
        this.mSl = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.mSl.setOnClickListener(forumListActivity);
        this.mSt = new g(forumListActivity.getPageContext());
        this.mSu = new g(forumListActivity.getPageContext());
        this.mSm = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mSd = this.mSm.findViewById(R.id.footer_background);
        this.mSn = (TextView) this.mSm.findViewById(R.id.footer_text);
        this.mSo = (ImageView) this.mSm.findViewById(R.id.footer_icon);
        this.mSq = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mSe = this.mSq.findViewById(R.id.footer_background);
        this.mSr = (TextView) this.mSq.findViewById(R.id.footer_text);
        this.mSs = (ImageView) this.mSq.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.mSx = forumListActivity;
        this.mSz = new a(this.mSx.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.mSx.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.mSy = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.mSy.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.mSB = this.mSz.getCount();
        this.mSy.setAdapter((ListAdapter) this.mSz);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.mSw == null) {
                this.mSw = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.mSx.getPageContext().getPageActivity(), 160.0f) - this.mSA.getWidth()) / 2;
            if (this.mSv == null) {
                this.mSv = new PopupWindow(this.mSw, l.dip2px(this.mSx.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.mSv.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.mSB > 6) {
                    this.mSv.setHeight(l.dip2px(this.mSx.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.mSv.setOutsideTouchable(true);
            this.mSv.setFocusable(true);
            this.mSw.setFocusable(true);
            this.mSw.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.mSv, this.mSA, 0 - dip2px, l.dip2px(this.mSx.getPageContext().getPageActivity(), 0.0f));
            this.mSw.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.mSv.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mSv, c.this.mSx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mSw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.mSv.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mSv, c.this.mSx.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mSv.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mSv, this.mSx.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dIq() {
        this.mSf.setVisibility(0);
    }

    public void dIr() {
        this.mSf.setVisibility(8);
    }

    public void dIs() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.mSi != null) {
                this.mSi.completePullRefreshPostDelayed(0L);
            } else if (this.mSj != null) {
                this.mSj.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dIt() {
        this.mSh.setVisibility(4);
        this.mSA.setClickable(false);
        this.mSA.setOnClickListener(null);
    }

    public void dIu() {
        this.mSh.setVisibility(0);
    }
}
