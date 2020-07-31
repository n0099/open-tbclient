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
/* loaded from: classes17.dex */
public class c {
    TextView bjS;
    LinearLayout hsG;
    private boolean isShow;
    final View lHA;
    final View lHB;
    LinearLayout lHC;
    private ImageView lHE;
    BdListView lHF;
    BdListView lHG;
    TextView lHH;
    TextView lHI;
    LinearLayout lHJ;
    TextView lHK;
    ImageView lHL;
    LinearLayout lHM;
    TextView lHN;
    ImageView lHO;
    g lHP;
    g lHQ;
    PopupWindow lHR;
    View lHS;
    ForumListActivity lHT;
    ListView lHU;
    a lHV;
    LinearLayout lHW;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lHD = true;
    private int lHX = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hsG = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lHC = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lHW = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bjS = (TextView) this.lHW.findViewById(R.id.title_text);
        this.lHE = (ImageView) this.lHW.findViewById(R.id.forum_list_title_arrow);
        this.lHH = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lHH.setOnClickListener(forumListActivity);
        this.lHI = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lHI.setOnClickListener(forumListActivity);
        this.lHP = new g(forumListActivity.getPageContext());
        this.lHQ = new g(forumListActivity.getPageContext());
        this.lHJ = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lHA = this.lHJ.findViewById(R.id.footer_background);
        this.lHK = (TextView) this.lHJ.findViewById(R.id.footer_text);
        this.lHL = (ImageView) this.lHJ.findViewById(R.id.footer_icon);
        this.lHM = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lHB = this.lHM.findViewById(R.id.footer_background);
        this.lHN = (TextView) this.lHM.findViewById(R.id.footer_text);
        this.lHO = (ImageView) this.lHM.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lHT = forumListActivity;
        this.lHV = new a(this.lHT.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lHT.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lHU = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lHU.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lHX = this.lHV.getCount();
        this.lHU.setAdapter((ListAdapter) this.lHV);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lHS == null) {
                this.lHS = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lHT.getPageContext().getPageActivity(), 160.0f) - this.lHW.getWidth()) / 2;
            if (this.lHR == null) {
                this.lHR = new PopupWindow(this.lHS, l.dip2px(this.lHT.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lHR.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lHX > 6) {
                    this.lHR.setHeight(l.dip2px(this.lHT.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lHR.setOutsideTouchable(true);
            this.lHR.setFocusable(true);
            this.lHS.setFocusable(true);
            this.lHS.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lHR, this.lHW, 0 - dip2px, l.dip2px(this.lHT.getPageContext().getPageActivity(), 0.0f));
            this.lHS.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lHR.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lHR, c.this.lHT.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lHS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lHR.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lHR, c.this.lHT.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lHR.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lHR, this.lHT.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void djJ() {
        this.lHC.setVisibility(0);
    }

    public void djK() {
        this.lHC.setVisibility(8);
    }

    public void djL() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lHF != null) {
                this.lHF.completePullRefreshPostDelayed(0L);
            } else if (this.lHG != null) {
                this.lHG.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void djM() {
        this.lHE.setVisibility(4);
        this.lHW.setClickable(false);
        this.lHW.setOnClickListener(null);
    }

    public void djN() {
        this.lHE.setVisibility(0);
    }
}
