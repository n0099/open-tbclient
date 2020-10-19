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
    TextView bwx;
    LinearLayout ibY;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    final View myC;
    final View myD;
    LinearLayout myE;
    private ImageView myG;
    BdListView myH;
    BdListView myI;
    TextView myJ;
    TextView myK;
    LinearLayout myL;
    TextView myM;
    ImageView myN;
    LinearLayout myO;
    TextView myP;
    ImageView myQ;
    g myR;
    g myS;
    PopupWindow myT;
    View myU;
    ForumListActivity myV;
    ListView myW;
    a myX;
    LinearLayout myY;
    boolean myF = true;
    private int myZ = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.ibY = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.myE = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.myY = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bwx = (TextView) this.myY.findViewById(R.id.title_text);
        this.myG = (ImageView) this.myY.findViewById(R.id.forum_list_title_arrow);
        this.myJ = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.myJ.setOnClickListener(forumListActivity);
        this.myK = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.myK.setOnClickListener(forumListActivity);
        this.myR = new g(forumListActivity.getPageContext());
        this.myS = new g(forumListActivity.getPageContext());
        this.myL = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.myC = this.myL.findViewById(R.id.footer_background);
        this.myM = (TextView) this.myL.findViewById(R.id.footer_text);
        this.myN = (ImageView) this.myL.findViewById(R.id.footer_icon);
        this.myO = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.myD = this.myO.findViewById(R.id.footer_background);
        this.myP = (TextView) this.myO.findViewById(R.id.footer_text);
        this.myQ = (ImageView) this.myO.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.myV = forumListActivity;
        this.myX = new a(this.myV.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.myV.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.myW = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.myW.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.myZ = this.myX.getCount();
        this.myW.setAdapter((ListAdapter) this.myX);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.myU == null) {
                this.myU = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.myV.getPageContext().getPageActivity(), 160.0f) - this.myY.getWidth()) / 2;
            if (this.myT == null) {
                this.myT = new PopupWindow(this.myU, l.dip2px(this.myV.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.myT.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.myZ > 6) {
                    this.myT.setHeight(l.dip2px(this.myV.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.myT.setOutsideTouchable(true);
            this.myT.setFocusable(true);
            this.myU.setFocusable(true);
            this.myU.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.myT, this.myY, 0 - dip2px, l.dip2px(this.myV.getPageContext().getPageActivity(), 0.0f));
            this.myU.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.myT.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.myT, c.this.myV.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.myU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.myT.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.myT, c.this.myV.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.myT.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.myT, this.myV.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dCP() {
        this.myE.setVisibility(0);
    }

    public void dCQ() {
        this.myE.setVisibility(8);
    }

    public void dCR() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.myH != null) {
                this.myH.completePullRefreshPostDelayed(0L);
            } else if (this.myI != null) {
                this.myI.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dCS() {
        this.myG.setVisibility(4);
        this.myY.setClickable(false);
        this.myY.setOnClickListener(null);
    }

    public void dCT() {
        this.myG.setVisibility(0);
    }
}
