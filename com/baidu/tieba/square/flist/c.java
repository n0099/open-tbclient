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
    TextView bIt;
    LinearLayout iGf;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    PopupWindow ngA;
    View ngB;
    ForumListActivity ngC;
    ListView ngD;
    a ngE;
    LinearLayout ngF;
    final View ngj;
    final View ngk;
    LinearLayout ngl;
    private ImageView ngn;
    BdListView ngo;
    BdListView ngp;
    TextView ngq;
    TextView ngr;
    LinearLayout ngs;
    TextView ngt;
    ImageView ngu;
    LinearLayout ngv;
    TextView ngw;
    ImageView ngx;
    g ngy;
    g ngz;
    boolean ngm = true;
    private int ngG = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iGf = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.ngl = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ngF = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bIt = (TextView) this.ngF.findViewById(R.id.title_text);
        this.ngn = (ImageView) this.ngF.findViewById(R.id.forum_list_title_arrow);
        this.ngq = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.ngq.setOnClickListener(forumListActivity);
        this.ngr = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.ngr.setOnClickListener(forumListActivity);
        this.ngy = new g(forumListActivity.getPageContext());
        this.ngz = new g(forumListActivity.getPageContext());
        this.ngs = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ngj = this.ngs.findViewById(R.id.footer_background);
        this.ngt = (TextView) this.ngs.findViewById(R.id.footer_text);
        this.ngu = (ImageView) this.ngs.findViewById(R.id.footer_icon);
        this.ngv = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ngk = this.ngv.findViewById(R.id.footer_background);
        this.ngw = (TextView) this.ngv.findViewById(R.id.footer_text);
        this.ngx = (ImageView) this.ngv.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.ngC = forumListActivity;
        this.ngE = new a(this.ngC.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.ngC.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.ngD = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.ngD.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.ngG = this.ngE.getCount();
        this.ngD.setAdapter((ListAdapter) this.ngE);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.ngB == null) {
                this.ngB = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.ngC.getPageContext().getPageActivity(), 160.0f) - this.ngF.getWidth()) / 2;
            if (this.ngA == null) {
                this.ngA = new PopupWindow(this.ngB, l.dip2px(this.ngC.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.ngA.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.ngG > 6) {
                    this.ngA.setHeight(l.dip2px(this.ngC.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.ngA.setOutsideTouchable(true);
            this.ngA.setFocusable(true);
            this.ngB.setFocusable(true);
            this.ngB.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.ngA, this.ngF, 0 - dip2px, l.dip2px(this.ngC.getPageContext().getPageActivity(), 0.0f));
            this.ngB.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.ngA.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ngA, c.this.ngC.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ngB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.ngA.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ngA, c.this.ngC.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ngA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ngA, this.ngC.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dNH() {
        this.ngl.setVisibility(0);
    }

    public void dNI() {
        this.ngl.setVisibility(8);
    }

    public void dNJ() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.ngo != null) {
                this.ngo.completePullRefreshPostDelayed(0L);
            } else if (this.ngp != null) {
                this.ngp.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dNK() {
        this.ngn.setVisibility(4);
        this.ngF.setClickable(false);
        this.ngF.setOnClickListener(null);
    }

    public void dNL() {
        this.ngn.setVisibility(0);
    }
}
