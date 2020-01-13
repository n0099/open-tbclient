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
    final View jZZ;
    final View kaa;
    LinearLayout kab;
    private ImageView kad;
    BdListView kae;
    BdListView kaf;
    TextView kag;
    TextView kah;
    LinearLayout kai;
    TextView kaj;
    ImageView kak;
    LinearLayout kal;
    TextView kam;
    ImageView kan;
    h kao;
    h kap;
    PopupWindow kaq;
    View kar;
    ForumListActivity kas;
    ListView kat;
    a kau;
    LinearLayout kaw;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    ViewPager mViewPager;
    boolean kac = true;
    private int kax = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.fZy = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.mViewPager = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.mViewPager.setOnPageChangeListener(forumListActivity);
        this.kab = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kaw = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.ayC = (TextView) this.kaw.findViewById(R.id.title_text);
        this.kad = (ImageView) this.kaw.findViewById(R.id.forum_list_title_arrow);
        this.kag = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.kag.setOnClickListener(forumListActivity);
        this.kah = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.kah.setOnClickListener(forumListActivity);
        this.kao = new h(forumListActivity.getPageContext());
        this.kap = new h(forumListActivity.getPageContext());
        this.kai = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.jZZ = this.kai.findViewById(R.id.footer_background);
        this.kaj = (TextView) this.kai.findViewById(R.id.footer_text);
        this.kak = (ImageView) this.kai.findViewById(R.id.footer_icon);
        this.kal = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.kaa = this.kal.findViewById(R.id.footer_background);
        this.kam = (TextView) this.kal.findViewById(R.id.footer_text);
        this.kan = (ImageView) this.kal.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.kas = forumListActivity;
        this.kau = new a(this.kas.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.kas.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.kat = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.kat.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.kax = this.kau.getCount();
        this.kat.setAdapter((ListAdapter) this.kau);
        return inflate;
    }

    public void d(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.kar == null) {
                this.kar = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.kas.getPageContext().getPageActivity(), 160.0f) - this.kaw.getWidth()) / 2;
            if (this.kaq == null) {
                this.kaq = new PopupWindow(this.kar, l.dip2px(this.kas.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.kaq.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.kax > 6) {
                    this.kaq.setHeight(l.dip2px(this.kas.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.kaq.setOutsideTouchable(true);
            this.kaq.setFocusable(true);
            this.kar.setFocusable(true);
            this.kar.setFocusableInTouchMode(true);
            g.showPopupWindowAsDropDown(this.kaq, this.kaw, 0 - dip2px, l.dip2px(this.kas.getPageContext().getPageActivity(), 0.0f));
            this.kar.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.kaq.isShowing()) {
                        g.dismissPopupWindow(c.this.kaq, c.this.kas.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kar.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.kaq.isShowing()) {
                        g.dismissPopupWindow(c.this.kaq, c.this.kas.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.kaq.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        g.dismissPopupWindow(this.kaq, this.kas.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void cHV() {
        this.kab.setVisibility(0);
    }

    public void cHW() {
        this.kab.setVisibility(8);
    }

    public void cHX() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.mViewPager != null) {
            if (this.mViewPager.getCurrentItem() == 0 && this.kae != null) {
                this.kae.completePullRefreshPostDelayed(0L);
            } else if (this.kaf != null) {
                this.kaf.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void cHY() {
        this.kad.setVisibility(4);
        this.kaw.setClickable(false);
        this.kaw.setOnClickListener(null);
    }

    public void cHZ() {
        this.kad.setVisibility(0);
    }
}
