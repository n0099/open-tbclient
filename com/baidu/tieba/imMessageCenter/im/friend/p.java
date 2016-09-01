package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView Cj;
    private View MN;
    private TextWatcher aSp;
    private ProgressBar coz;
    private EditText dlt;
    private final InviteFriendListActivity dqR;
    private o dqS;
    private View dqT;
    private InviteFriendCandidateList dqU;
    private LinearLayout dqV;
    private Button dqW;
    private int dqX;
    private boolean dqY;
    private TextView dqZ;
    private View dra;
    private View drb;
    private TextView drc;
    private ImageView drd;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dqX = 0;
        this.dqR = inviteFriendListActivity;
        this.dqY = z;
        initialize();
    }

    public View getRootView() {
        return this.MN;
    }

    private void initialize() {
        this.dqR.setContentView(t.h.invite_friend_list);
        this.MN = this.dqR.findViewById(t.g.root_view);
        Vg();
        this.Cj = (BdListView) this.MN.findViewById(t.g.friend_list);
        this.Cj.setOnItemClickListener(this.dqR);
        if (this.dqY) {
            this.mNoDataView = NoDataViewFactory.a(this.dqR.getPageContext().getPageActivity(), this.MN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEI), NoDataViewFactory.d.x(t.j.no_friends, t.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dqR.getPageContext().getPageActivity(), this.MN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEI), NoDataViewFactory.d.x(t.j.no_chat_friends, t.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(t.j.find_new_friend), new q(this))));
        }
        this.coz = (ProgressBar) this.MN.findViewById(t.g.progress);
        this.dqU = (InviteFriendCandidateList) this.MN.findViewById(t.g.candidate_list);
        this.dqU.a(new r(this));
        this.dqV = (LinearLayout) this.MN.findViewById(t.g.invite_candidate);
        this.dqT = this.MN.findViewById(t.g.invite_candidate_border);
        if (this.dqY) {
            this.dqV.setVisibility(8);
            this.dqT.setVisibility(8);
        }
        ayD();
        this.dqW = (Button) this.MN.findViewById(t.g.button_send);
        this.dqW.setOnClickListener(this.dqR);
        wq();
        ayw();
        mh(0);
    }

    private void Vg() {
        this.mNavigationBar = (NavigationBar) this.MN.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dqY) {
            this.dqZ = this.mNavigationBar.setTitleText(t.j.invite_contact_title);
        } else {
            this.dqZ = this.mNavigationBar.setTitleText(t.j.invite_friend);
        }
        this.drb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new t(this));
        this.drd = (ImageView) this.drb.findViewById(t.g.new_friend_search);
        this.dra = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dra.setVisibility(8);
        this.dlt = (EditText) this.dra.findViewById(t.g.search_bar_edit);
        if (this.dlt.getParent() != null) {
            ((View) this.dlt.getParent()).setFocusable(true);
            ((View) this.dlt.getParent()).setFocusableInTouchMode(true);
        }
        this.aSp = new u(this);
        this.dlt.addTextChangedListener(this.aSp);
        this.drc = (TextView) this.dra.findViewById(t.g.search_bar_delete_button);
        this.drc.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayv() {
        if (this.dqR != null) {
            this.dqR.ayt();
        }
    }

    public void wq() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dqR.getLayoutMode().ah(skinType == 1);
        this.dqR.getLayoutMode().x(this.MN);
        av.b(this.drd, t.f.icon_search_bg_s, t.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dqR.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dqR.getPageContext(), skinType);
        av.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void ayw() {
        this.Cj.setOnTouchListener(new w(this));
    }

    public void ayx() {
        com.baidu.adp.lib.util.k.b(this.dqR.getPageContext().getPageActivity(), this.dlt);
        this.dra.setVisibility(8);
        this.dqZ.setVisibility(0);
        this.drb.setVisibility(0);
        this.dlt.getText().clear();
    }

    public boolean ayy() {
        return this.dra != null && this.dra.getVisibility() == 0;
    }

    public int ayz() {
        return this.dqW.getId();
    }

    public String getSearchText() {
        Editable text = this.dlt.getText();
        return text != null ? text.toString() : "";
    }

    public String ayA() {
        return this.dqU.ayq();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dqS == null) {
            this.dqS = new o(this.dqR, this.dqY);
            this.dqS.a(this);
            this.dqS.a(new x(this));
            this.Cj.setAdapter((ListAdapter) this.dqS);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Cj.setVisibility(8);
            if (!this.dqY) {
                this.dqV.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Cj.setVisibility(0);
        this.dqS.setData(list);
        this.dqS.notifyDataSetChanged();
        if (!this.dqY) {
            this.dqV.setVisibility(0);
        }
    }

    public void ayB() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dqR.getPageContext());
        }
    }

    public void ayC() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void ayD() {
        int dimensionPixelSize = this.dqR.getResources().getDimensionPixelSize(t.e.ds80) + this.dqR.getResources().getDimensionPixelSize(t.e.ds16) + this.dqR.getResources().getDimensionPixelSize(t.e.ds16);
        this.mListFooter = new View(this.dqR.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Cj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dqU.d(aVar);
            mh(this.dqU.getItemLength());
            ayE();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dqU.f(aVar);
            mh(this.dqU.getItemLength());
            ayE();
        }
    }

    private void ayE() {
        if (this.dqU.getItemLength() > 0) {
            this.dqW.setEnabled(true);
        } else {
            this.dqW.setEnabled(false);
        }
    }

    public void ayF() {
        com.baidu.adp.lib.util.k.b(this.dqR.getPageContext().getPageActivity(), this.dlt);
    }

    private void mh(int i) {
        this.dqW.setText(String.format(this.dqR.getPageContext().getString(t.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ayG() {
        return this.dqX;
    }

    public void mi(int i) {
        this.dqX = i;
        this.dqU.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dqU.e(aVar);
        }
    }

    public void onDestroy() {
        this.dlt.removeTextChangedListener(this.aSp);
    }
}
