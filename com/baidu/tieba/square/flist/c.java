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
/* loaded from: classes7.dex */
public class c {
    TextView axT;
    LinearLayout fWp;
    private boolean isShow;
    private ImageView jWB;
    BdListView jWC;
    BdListView jWD;
    TextView jWE;
    TextView jWF;
    LinearLayout jWG;
    TextView jWH;
    ImageView jWI;
    LinearLayout jWJ;
    TextView jWK;
    ImageView jWL;
    h jWM;
    h jWN;
    PopupWindow jWO;
    View jWP;
    ForumListActivity jWQ;
    ListView jWR;
    a jWS;
    LinearLayout jWT;
    final View jWx;
    final View jWy;
    LinearLayout jWz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean jWA = true;
    private int jWU = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.fWp = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.jWz = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jWT = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.axT = (TextView) this.jWT.findViewById(R.id.title_text);
        this.jWB = (ImageView) this.jWT.findViewById(R.id.forum_list_title_arrow);
        this.jWE = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.jWE.setOnClickListener(forumListActivity);
        this.jWF = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.jWF.setOnClickListener(forumListActivity);
        this.jWM = new h(forumListActivity.getPageContext());
        this.jWN = new h(forumListActivity.getPageContext());
        this.jWG = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jWx = this.jWG.findViewById(R.id.footer_background);
        this.jWH = (TextView) this.jWG.findViewById(R.id.footer_text);
        this.jWI = (ImageView) this.jWG.findViewById(R.id.footer_icon);
        this.jWJ = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jWy = this.jWJ.findViewById(R.id.footer_background);
        this.jWK = (TextView) this.jWJ.findViewById(R.id.footer_text);
        this.jWL = (ImageView) this.jWJ.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.jWQ = forumListActivity;
        this.jWS = new a(this.jWQ.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.jWQ.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.jWR = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.jWR.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.jWU = this.jWS.getCount();
        this.jWR.setAdapter((ListAdapter) this.jWS);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.jWP == null) {
                this.jWP = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.jWQ.getPageContext().getPageActivity(), 160.0f) - this.jWT.getWidth()) / 2;
            if (this.jWO == null) {
                this.jWO = new PopupWindow(this.jWP, l.dip2px(this.jWQ.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.jWO.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.jWU > 6) {
                    this.jWO.setHeight(l.dip2px(this.jWQ.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.jWO.setOutsideTouchable(true);
            this.jWO.setFocusable(true);
            this.jWP.setFocusable(true);
            this.jWP.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.jWO, this.jWT, 0 - dip2px, l.dip2px(this.jWQ.getPageContext().getPageActivity(), 0.0f));
            this.jWP.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.jWO.isShowing()) {
                        g.dismissPopupWindow(c.this.jWO, c.this.jWQ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jWP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.jWO.isShowing()) {
                        g.dismissPopupWindow(c.this.jWO, c.this.jWQ.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jWO.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.jWO, this.jWQ.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cGR() {
        this.jWz.setVisibility(0);
    }

    public void cGS() {
        this.jWz.setVisibility(8);
    }

    public void cGT() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.jWC != null) {
                this.jWC.completePullRefreshPostDelayed(0L);
            } else if (this.jWD != null) {
                this.jWD.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cGU() {
        this.jWB.setVisibility(4);
        this.jWT.setClickable(false);
        this.jWT.setOnClickListener(null);
    }

    public void cGV() {
        this.jWB.setVisibility(0);
    }
}
