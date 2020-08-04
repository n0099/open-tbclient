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
    final View lHC;
    final View lHD;
    LinearLayout lHE;
    private ImageView lHG;
    BdListView lHH;
    BdListView lHI;
    TextView lHJ;
    TextView lHK;
    LinearLayout lHL;
    TextView lHM;
    ImageView lHN;
    LinearLayout lHO;
    TextView lHP;
    ImageView lHQ;
    g lHR;
    g lHS;
    PopupWindow lHT;
    View lHU;
    ForumListActivity lHV;
    ListView lHW;
    a lHX;
    LinearLayout lHY;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean lHF = true;
    private int lHZ = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.hsG = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.lHE = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.lHY = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bjS = (TextView) this.lHY.findViewById(R.id.title_text);
        this.lHG = (ImageView) this.lHY.findViewById(R.id.forum_list_title_arrow);
        this.lHJ = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.lHJ.setOnClickListener(forumListActivity);
        this.lHK = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.lHK.setOnClickListener(forumListActivity);
        this.lHR = new g(forumListActivity.getPageContext());
        this.lHS = new g(forumListActivity.getPageContext());
        this.lHL = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lHC = this.lHL.findViewById(R.id.footer_background);
        this.lHM = (TextView) this.lHL.findViewById(R.id.footer_text);
        this.lHN = (ImageView) this.lHL.findViewById(R.id.footer_icon);
        this.lHO = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.lHD = this.lHO.findViewById(R.id.footer_background);
        this.lHP = (TextView) this.lHO.findViewById(R.id.footer_text);
        this.lHQ = (ImageView) this.lHO.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.lHV = forumListActivity;
        this.lHX = new a(this.lHV.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.lHV.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.lHW = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.lHW.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.lHZ = this.lHX.getCount();
        this.lHW.setAdapter((ListAdapter) this.lHX);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.lHU == null) {
                this.lHU = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.lHV.getPageContext().getPageActivity(), 160.0f) - this.lHY.getWidth()) / 2;
            if (this.lHT == null) {
                this.lHT = new PopupWindow(this.lHU, l.dip2px(this.lHV.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.lHT.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.lHZ > 6) {
                    this.lHT.setHeight(l.dip2px(this.lHV.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.lHT.setOutsideTouchable(true);
            this.lHT.setFocusable(true);
            this.lHU.setFocusable(true);
            this.lHU.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.lHT, this.lHY, 0 - dip2px, l.dip2px(this.lHV.getPageContext().getPageActivity(), 0.0f));
            this.lHU.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.lHT.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lHT, c.this.lHV.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lHU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.lHT.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.lHT, c.this.lHV.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.lHT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lHT, this.lHV.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void djJ() {
        this.lHE.setVisibility(0);
    }

    public void djK() {
        this.lHE.setVisibility(8);
    }

    public void djL() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.lHH != null) {
                this.lHH.completePullRefreshPostDelayed(0L);
            } else if (this.lHI != null) {
                this.lHI.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void djM() {
        this.lHG.setVisibility(4);
        this.lHY.setClickable(false);
        this.lHY.setOnClickListener(null);
    }

    public void djN() {
        this.lHG.setVisibility(0);
    }
}
