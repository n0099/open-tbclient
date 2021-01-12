package com.baidu.tieba.square.flist;

import android.graphics.drawable.ColorDrawable;
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
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class c {
    ViewPager Zi;
    TextView bIw;
    LinearLayout iNK;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    PopupWindow nhA;
    View nhB;
    ForumListActivity nhC;
    ListView nhD;
    a nhE;
    LinearLayout nhF;
    final View nhj;
    final View nhk;
    LinearLayout nhl;
    private ImageView nhn;
    BdListView nho;
    BdListView nhp;
    TextView nhq;
    TextView nhr;
    LinearLayout nhs;
    TextView nht;
    ImageView nhu;
    LinearLayout nhv;
    TextView nhw;
    ImageView nhx;
    g nhy;
    g nhz;
    boolean nhm = true;
    private int nhG = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iNK = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.Zi = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.Zi.setOnPageChangeListener(forumListActivity);
        this.nhl = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.nhF = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bIw = (TextView) this.nhF.findViewById(R.id.title_text);
        this.nhn = (ImageView) this.nhF.findViewById(R.id.forum_list_title_arrow);
        this.nhq = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.nhq.setOnClickListener(forumListActivity);
        this.nhr = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.nhr.setOnClickListener(forumListActivity);
        this.nhy = new g(forumListActivity.getPageContext());
        this.nhz = new g(forumListActivity.getPageContext());
        this.nhs = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nhj = this.nhs.findViewById(R.id.footer_background);
        this.nht = (TextView) this.nhs.findViewById(R.id.footer_text);
        this.nhu = (ImageView) this.nhs.findViewById(R.id.footer_icon);
        this.nhv = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.nhk = this.nhv.findViewById(R.id.footer_background);
        this.nhw = (TextView) this.nhv.findViewById(R.id.footer_text);
        this.nhx = (ImageView) this.nhv.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.nhC = forumListActivity;
        this.nhE = new a(this.nhC.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.nhC.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.nhD = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.nhD.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.nhG = this.nhE.getCount();
        this.nhD.setAdapter((ListAdapter) this.nhE);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.nhB == null) {
                this.nhB = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.nhC.getPageContext().getPageActivity(), 160.0f) - this.nhF.getWidth()) / 2;
            if (this.nhA == null) {
                this.nhA = new PopupWindow(this.nhB, l.dip2px(this.nhC.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.nhA.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.nhG > 6) {
                    this.nhA.setHeight(l.dip2px(this.nhC.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.nhA.setOutsideTouchable(true);
            this.nhA.setFocusable(true);
            this.nhB.setFocusable(true);
            this.nhB.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.nhA, this.nhF, 0 - dip2px, l.dip2px(this.nhC.getPageContext().getPageActivity(), 0.0f));
            this.nhB.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.nhA.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nhA, c.this.nhC.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nhB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.nhA.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.nhA, c.this.nhC.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.nhA.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhA, this.nhC.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dJI() {
        this.nhl.setVisibility(0);
    }

    public void dJJ() {
        this.nhl.setVisibility(8);
    }

    public void dJK() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.Zi != null) {
            if (this.Zi.getCurrentItem() == 0 && this.nho != null) {
                this.nho.completePullRefreshPostDelayed(0L);
            } else if (this.nhp != null) {
                this.nhp.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dJL() {
        this.nhn.setVisibility(4);
        this.nhF.setClickable(false);
        this.nhF.setOnClickListener(null);
    }

    public void dJM() {
        this.nhn.setVisibility(0);
    }
}
