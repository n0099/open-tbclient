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
import com.baidu.adp.lib.g.g;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class c {
    LinearLayout fdF;
    TextView ffr;
    final View iZB;
    final View iZC;
    LinearLayout iZD;
    private ImageView iZF;
    BdListView iZG;
    BdListView iZH;
    TextView iZI;
    TextView iZJ;
    LinearLayout iZK;
    TextView iZL;
    ImageView iZM;
    LinearLayout iZN;
    TextView iZO;
    ImageView iZP;
    i iZQ;
    i iZR;
    PopupWindow iZS;
    View iZT;
    ForumListActivity iZU;
    ListView iZV;
    a iZW;
    LinearLayout iZX;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean iZE = true;
    private int iZY = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.fdF = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.iZD = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iZX = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.ffr = (TextView) this.iZX.findViewById(R.id.title_text);
        this.iZF = (ImageView) this.iZX.findViewById(R.id.forum_list_title_arrow);
        this.iZI = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.iZI.setOnClickListener(forumListActivity);
        this.iZJ = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.iZJ.setOnClickListener(forumListActivity);
        this.iZQ = new i(forumListActivity.getPageContext());
        this.iZR = new i(forumListActivity.getPageContext());
        this.iZK = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iZB = this.iZK.findViewById(R.id.footer_background);
        this.iZL = (TextView) this.iZK.findViewById(R.id.footer_text);
        this.iZM = (ImageView) this.iZK.findViewById(R.id.footer_icon);
        this.iZN = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.iZC = this.iZN.findViewById(R.id.footer_background);
        this.iZO = (TextView) this.iZN.findViewById(R.id.footer_text);
        this.iZP = (ImageView) this.iZN.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.iZU = forumListActivity;
        this.iZW = new a(this.iZU.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.iZU.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.iZV = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.iZV.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.iZY = this.iZW.getCount();
        this.iZV.setAdapter((ListAdapter) this.iZW);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.iZT == null) {
                this.iZT = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.iZU.getPageContext().getPageActivity(), 160.0f) - this.iZX.getWidth()) / 2;
            if (this.iZS == null) {
                this.iZS = new PopupWindow(this.iZT, l.dip2px(this.iZU.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.iZS.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.iZY > 6) {
                    this.iZS.setHeight(l.dip2px(this.iZU.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.iZS.setOutsideTouchable(true);
            this.iZS.setFocusable(true);
            this.iZT.setFocusable(true);
            this.iZT.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.iZS, this.iZX, 0 - dip2px, l.dip2px(this.iZU.getPageContext().getPageActivity(), 0.0f));
            this.iZT.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.iZS.isShowing()) {
                        g.a(c.this.iZS, c.this.iZU.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iZT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.iZS.isShowing()) {
                        g.a(c.this.iZS, c.this.iZU.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.iZS.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.iZS, this.iZU.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cnP() {
        this.iZD.setVisibility(0);
    }

    public void cnQ() {
        this.iZD.setVisibility(8);
    }

    public void cnR() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.iZG != null) {
                this.iZG.completePullRefreshPostDelayed(0L);
            } else if (this.iZH != null) {
                this.iZH.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cnS() {
        this.iZF.setVisibility(4);
        this.iZX.setClickable(false);
        this.iZX.setOnClickListener(null);
    }

    public void cnT() {
        this.iZF.setVisibility(0);
    }
}
