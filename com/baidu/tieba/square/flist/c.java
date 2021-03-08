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
    ViewPager aaw;
    TextView bNG;
    LinearLayout iVo;
    private boolean isShow;
    NavigationBar mNavigationBar;
    ProgressBar mProgressBar;
    private ImageView ntA;
    BdListView ntB;
    BdListView ntC;
    TextView ntD;
    TextView ntE;
    LinearLayout ntF;
    TextView ntG;
    ImageView ntH;
    LinearLayout ntI;
    TextView ntJ;
    ImageView ntK;
    g ntL;
    g ntM;
    PopupWindow ntN;
    View ntO;
    ForumListActivity ntP;
    ListView ntQ;
    a ntR;
    LinearLayout ntS;
    final View ntw;
    final View ntx;
    LinearLayout nty;
    boolean ntz = true;
    private int ntT = 0;

    public c(ForumListActivity forumListActivity) {
        this.isShow = false;
        this.iVo = (LinearLayout) forumListActivity.findViewById(R.id.forum_list_root);
        this.aaw = (ViewPager) forumListActivity.findViewById(R.id.view_pager);
        this.aaw.setOnPageChangeListener(forumListActivity);
        this.nty = (LinearLayout) forumListActivity.findViewById(R.id.tab_strip);
        this.mNavigationBar = (NavigationBar) forumListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ntS = (LinearLayout) this.mNavigationBar.setTitleView(R.layout.nb_item_forum_list, (View.OnClickListener) null);
        this.bNG = (TextView) this.ntS.findViewById(R.id.title_text);
        this.ntA = (ImageView) this.ntS.findViewById(R.id.forum_list_title_arrow);
        this.ntD = (TextView) forumListActivity.findViewById(R.id.tab_recommends);
        this.ntD.setOnClickListener(forumListActivity);
        this.ntE = (TextView) forumListActivity.findViewById(R.id.tab_hot);
        this.ntE.setOnClickListener(forumListActivity);
        this.ntL = new g(forumListActivity.getPageContext());
        this.ntM = new g(forumListActivity.getPageContext());
        this.ntF = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ntw = this.ntF.findViewById(R.id.footer_background);
        this.ntG = (TextView) this.ntF.findViewById(R.id.footer_text);
        this.ntH = (ImageView) this.ntF.findViewById(R.id.footer_icon);
        this.ntI = (LinearLayout) LayoutInflater.from(forumListActivity.getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
        this.ntx = this.ntI.findViewById(R.id.footer_background);
        this.ntJ = (TextView) this.ntI.findViewById(R.id.footer_text);
        this.ntK = (ImageView) this.ntI.findViewById(R.id.footer_icon);
        this.mProgressBar = (ProgressBar) forumListActivity.findViewById(R.id.loading);
        this.isShow = false;
        this.ntP = forumListActivity;
        this.ntR = new a(this.ntP.getPageContext().getContext());
    }

    public View a(int i, AdapterView.OnItemClickListener onItemClickListener) {
        View inflate = LayoutInflater.from(this.ntP.getPageContext().getPageActivity()).inflate(R.layout.forum_list__dir_menu, (ViewGroup) null);
        this.ntQ = (ListView) inflate.findViewById(R.id.dir_menu_list);
        this.ntQ.setOnItemClickListener(onItemClickListener);
        inflate.setBackgroundResource(R.drawable.bg_allsproutpop_dropdown);
        this.ntT = this.ntR.getCount();
        this.ntQ.setAdapter((ListAdapter) this.ntR);
        return inflate;
    }

    public void c(AdapterView.OnItemClickListener onItemClickListener) {
        if (!this.isShow) {
            this.isShow = true;
            if (this.ntO == null) {
                this.ntO = a(0, onItemClickListener);
            }
            int dip2px = (l.dip2px(this.ntP.getPageContext().getPageActivity(), 160.0f) - this.ntS.getWidth()) / 2;
            if (this.ntN == null) {
                this.ntN = new PopupWindow(this.ntO, l.dip2px(this.ntP.getPageContext().getPageActivity(), 160.0f), -2, true);
                this.ntN.setBackgroundDrawable(new ColorDrawable(17170445));
                if (this.ntT > 6) {
                    this.ntN.setHeight(l.dip2px(this.ntP.getPageContext().getPageActivity(), 272.0f));
                }
            }
            this.ntN.setOutsideTouchable(true);
            this.ntN.setFocusable(true);
            this.ntO.setFocusable(true);
            this.ntO.setFocusableInTouchMode(true);
            com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(this.ntN, this.ntS, 0 - dip2px, l.dip2px(this.ntP.getPageContext().getPageActivity(), 0.0f));
            this.ntO.setOnKeyListener(new View.OnKeyListener() { // from class: com.baidu.tieba.square.flist.c.1
                @Override // android.view.View.OnKeyListener
                public boolean onKey(View view, int i, KeyEvent keyEvent) {
                    if (i == 4 && c.this.ntN.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ntN, c.this.ntP.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ntO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.square.flist.c.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (c.this.ntN.isShowing()) {
                        com.baidu.adp.lib.f.g.dismissPopupWindow(c.this.ntN, c.this.ntP.getPageContext().getPageActivity());
                        return false;
                    }
                    return false;
                }
            });
            this.ntN.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.square.flist.c.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    c.this.isShow = false;
                }
            });
            return;
        }
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ntN, this.ntP.getPageContext().getPageActivity());
        this.isShow = false;
    }

    public void dMj() {
        this.nty.setVisibility(0);
    }

    public void dMk() {
        this.nty.setVisibility(8);
    }

    public void dMl() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.aaw != null) {
            if (this.aaw.getCurrentItem() == 0 && this.ntB != null) {
                this.ntB.completePullRefreshPostDelayed(0L);
            } else if (this.ntC != null) {
                this.ntC.completePullRefreshPostDelayed(0L);
            }
        }
    }

    public void dMm() {
        this.ntA.setVisibility(4);
        this.ntS.setClickable(false);
        this.ntS.setOnClickListener(null);
    }

    public void dMn() {
        this.ntA.setVisibility(0);
    }
}
