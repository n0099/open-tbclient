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
/* loaded from: classes8.dex */
public class c {
    TextView ayC;
    LinearLayout fZy;
    private boolean isShow;
    a kaA;
    LinearLayout kaB;
    final View kae;
    final View kaf;
    LinearLayout kag;
    private ImageView kai;
    BdListView kaj;
    BdListView kak;
    TextView kal;
    TextView kam;
    LinearLayout kan;
    TextView kao;
    ImageView kap;
    LinearLayout kaq;
    TextView kar;
    ImageView kas;
    h kat;
    h kau;
    PopupWindow kaw;
    View kax;
    ForumListActivity kay;
    ListView kaz;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kah = true;
    private int kaC = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.fZy = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kag = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kaB = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.ayC = (TextView) this.kaB.findViewById(R.id.title_text);
        this.kai = (ImageView) this.kaB.findViewById(R.id.forum_list_title_arrow);
        this.kal = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kal.setOnClickListener(forumListActivity);
        this.kam = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kam.setOnClickListener(forumListActivity);
        this.kat = new h(forumListActivity.getPageContext());
        this.kau = new h(forumListActivity.getPageContext());
        this.kan = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kae = this.kan.findViewById(R.id.footer_background);
        this.kao = (TextView) this.kan.findViewById(R.id.footer_text);
        this.kap = (ImageView) this.kan.findViewById(R.id.footer_icon);
        this.kaq = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kaf = this.kaq.findViewById(R.id.footer_background);
        this.kar = (TextView) this.kaq.findViewById(R.id.footer_text);
        this.kas = (ImageView) this.kaq.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kay = forumListActivity;
        this.kaA = new a(this.kay.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kay.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kaz = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kaz.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kaC = this.kaA.getCount();
        this.kaz.setAdapter((ListAdapter) this.kaA);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kax == null) {
                this.kax = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kay.getPageContext().getPageActivity(), 160.0f) - this.kaB.getWidth()) / 2;
            if (this.kaw == null) {
                this.kaw = new PopupWindow(this.kax, l.dip2px(this.kay.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kaw.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kaC > 6) {
                    this.kaw.setHeight(l.dip2px(this.kay.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kaw.setOutsideTouchable(true);
            this.kaw.setFocusable(true);
            this.kax.setFocusable(true);
            this.kax.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kaw, this.kaB, 0 - dip2px, l.dip2px(this.kay.getPageContext().getPageActivity(), 0.0f));
            this.kax.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kaw.isShowing()) {
                        g.dismissPopupWindow(c.this.kaw, c.this.kay.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kax.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kaw.isShowing()) {
                        g.dismissPopupWindow(c.this.kaw, c.this.kay.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kaw.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kaw, this.kay.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cHX() {
        this.kag.setVisibility(0);
    }

    public void cHY() {
        this.kag.setVisibility(8);
    }

    public void cHZ() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kaj != null) {
                this.kaj.completePullRefreshPostDelayed(0L);
            } else if (this.kak != null) {
                this.kak.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cIa() {
        this.kai.setVisibility(4);
        this.kaB.setClickable(false);
        this.kaB.setOnClickListener(null);
    }

    public void cIb() {
        this.kai.setVisibility(0);
    }
}
