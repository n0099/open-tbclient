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
    LinearLayout fef;
    TextView ffR;
    private boolean isShow;
    final View jaF;
    final View jaG;
    LinearLayout jaH;
    private ImageView jaJ;
    BdListView jaK;
    BdListView jaL;
    TextView jaM;
    TextView jaN;
    LinearLayout jaO;
    TextView jaP;
    ImageView jaQ;
    LinearLayout jaR;
    TextView jaS;
    ImageView jaT;
    i jaU;
    i jaV;
    PopupWindow jaW;
    View jaX;
    ForumListActivity jaY;
    ListView jaZ;
    a jba;
    LinearLayout jbb;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean jaI = true;
    private int jbc = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.fef = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.jaH = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jbb = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.ffR = (TextView) this.jbb.findViewById(R.id.title_text);
        this.jaJ = (ImageView) this.jbb.findViewById(R.id.forum_list_title_arrow);
        this.jaM = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.jaM.setOnClickListener(forumListActivity);
        this.jaN = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.jaN.setOnClickListener(forumListActivity);
        this.jaU = new i(forumListActivity.getPageContext());
        this.jaV = new i(forumListActivity.getPageContext());
        this.jaO = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jaF = this.jaO.findViewById(R.id.footer_background);
        this.jaP = (TextView) this.jaO.findViewById(R.id.footer_text);
        this.jaQ = (ImageView) this.jaO.findViewById(R.id.footer_icon);
        this.jaR = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jaG = this.jaR.findViewById(R.id.footer_background);
        this.jaS = (TextView) this.jaR.findViewById(R.id.footer_text);
        this.jaT = (ImageView) this.jaR.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.jaY = forumListActivity;
        this.jba = new a(this.jaY.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.jaY.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.jaZ = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.jaZ.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.jbc = this.jba.getCount();
        this.jaZ.setAdapter((ListAdapter) this.jba);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.jaX == null) {
                this.jaX = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.jaY.getPageContext().getPageActivity(), 160.0f) - this.jbb.getWidth()) / 2;
            if (this.jaW == null) {
                this.jaW = new PopupWindow(this.jaX, l.dip2px(this.jaY.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.jaW.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.jbc > 6) {
                    this.jaW.setHeight(l.dip2px(this.jaY.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.jaW.setOutsideTouchable(true);
            this.jaW.setFocusable(true);
            this.jaX.setFocusable(true);
            this.jaX.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.jaW, this.jbb, 0 - dip2px, l.dip2px(this.jaY.getPageContext().getPageActivity(), 0.0f));
            this.jaX.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.jaW.isShowing()) {
                        g.a(c.this.jaW, c.this.jaY.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jaX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.jaW.isShowing()) {
                        g.a(c.this.jaW, c.this.jaY.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.jaW.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.a(this.jaW, this.jaY.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void coh() {
        this.jaH.setVisibility(0);
    }

    public void coi() {
        this.jaH.setVisibility(8);
    }

    public void coj() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.jaK != null) {
                this.jaK.completePullRefreshPostDelayed(0L);
            } else if (this.jaL != null) {
                this.jaL.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cok() {
        this.jaJ.setVisibility(4);
        this.jbb.setClickable(false);
        this.jbb.setOnClickListener(null);
    }

    public void col() {
        this.jaJ.setVisibility(0);
    }
}
