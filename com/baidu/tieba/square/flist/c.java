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
    TextView bEW;
    private boolean isShow;
    LinearLayout iux;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    g mRA;
    PopupWindow mRB;
    View mRC;
    ForumListActivity mRD;
    ListView mRE;
    a mRF;
    LinearLayout mRG;
    final View mRk;
    final View mRl;
    LinearLayout mRm;
    private ImageView mRo;
    BdListView mRp;
    BdListView mRq;
    TextView mRr;
    TextView mRs;
    LinearLayout mRt;
    TextView mRu;
    ImageView mRv;
    LinearLayout mRw;
    TextView mRx;
    ImageView mRy;
    g mRz;
    ViewPager mViewPager;
    boolean mRn = true;
    private int mRH = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iux = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.mRm = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mRG = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bEW = (TextView) this.mRG.findViewById(R.id.title_text);
        this.mRo = (ImageView) this.mRG.findViewById(R.id.forum_list_title_arrow);
        this.mRr = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.mRr.setOnClickListener(forumListActivity);
        this.mRs = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.mRs.setOnClickListener(forumListActivity);
        this.mRz = new g(forumListActivity.getPageContext());
        this.mRA = new g(forumListActivity.getPageContext());
        this.mRt = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mRk = this.mRt.findViewById(R.id.footer_background);
        this.mRu = (TextView) this.mRt.findViewById(R.id.footer_text);
        this.mRv = (ImageView) this.mRt.findViewById(R.id.footer_icon);
        this.mRw = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.mRl = this.mRw.findViewById(R.id.footer_background);
        this.mRx = (TextView) this.mRw.findViewById(R.id.footer_text);
        this.mRy = (ImageView) this.mRw.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.mRD = forumListActivity;
        this.mRF = new a(this.mRD.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.mRD.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.mRE = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.mRE.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.mRH = this.mRF.getCount();
        this.mRE.setAdapter((ListAdapter) this.mRF);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.mRC == null) {
                this.mRC = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.mRD.getPageContext().getPageActivity(), 160.0f) - this.mRG.getWidth()) / 2;
            if (this.mRB == null) {
                this.mRB = new PopupWindow(this.mRC, l.dip2px(this.mRD.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.mRB.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.mRH > 6) {
                    this.mRB.setHeight(l.dip2px(this.mRD.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.mRB.setOutsideTouchable(true);
            this.mRB.setFocusable(true);
            this.mRC.setFocusable(true);
            this.mRC.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.mRB, this.mRG, 0 - dip2px, l.dip2px(this.mRD.getPageContext().getPageActivity(), 0.0f));
            this.mRC.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.mRB.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mRB, c.this.mRD.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mRC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.mRB.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.mRB, c.this.mRD.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.mRB.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.mRB, this.mRD.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dIz() {
        this.mRm.setVisibility(0);
    }

    public void dIA() {
        this.mRm.setVisibility(8);
    }

    public void dIB() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.mRp != null) {
                this.mRp.completePullRefreshPostDelayed(0L);
            } else if (this.mRq != null) {
                this.mRq.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dIC() {
        this.mRo.setVisibility(4);
        this.mRG.setClickable(false);
        this.mRG.setOnClickListener(null);
    }

    public void dID() {
        this.mRo.setVisibility(0);
    }
}
