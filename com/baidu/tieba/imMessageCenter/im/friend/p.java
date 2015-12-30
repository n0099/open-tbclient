package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.n;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aIu;
    private EditText cbx;
    private final InviteFriendListActivity cgV;
    private o cgW;
    private View cgX;
    private InviteFriendCandidateList cgY;
    private LinearLayout cgZ;
    private Button cha;
    private int chb;
    private boolean chc;
    private TextView chd;
    private View che;
    private View chf;
    private TextView chg;
    private View mListFooter;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.chb = 0;
        this.cgV = inviteFriendListActivity;
        this.chc = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.cgV.setContentView(n.h.invite_friend_list);
        this.mRoot = this.cgV.findViewById(n.g.root_view);
        Qz();
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.friend_list);
        this.mListView.setOnItemClickListener(this.cgV);
        if (this.chc) {
            this.mNoDataView = NoDataViewFactory.a(this.cgV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(n.j.no_friends, n.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.cgV.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(n.j.no_chat_friends, n.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(n.j.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(n.g.progress);
        this.cgY = (InviteFriendCandidateList) this.mRoot.findViewById(n.g.candidate_list);
        this.cgY.a(new r(this));
        this.cgZ = (LinearLayout) this.mRoot.findViewById(n.g.invite_candidate);
        this.cgX = this.mRoot.findViewById(n.g.invite_candidate_border);
        if (this.chc) {
            this.cgZ.setVisibility(8);
            this.cgX.setVisibility(8);
        }
        aef();
        this.cha = (Button) this.mRoot.findViewById(n.g.button_send);
        this.cha.setOnClickListener(this.cgV);
        vR();
        adX();
        jo(0);
    }

    private void Qz() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.chc) {
            this.chd = this.mNavigationBar.setTitleText(n.j.invite_contact_title);
        } else {
            this.chd = this.mNavigationBar.setTitleText(n.j.invite_friend);
        }
        this.chf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.add_new_friend_text, new t(this));
        this.che = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, n.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.che.setVisibility(8);
        this.cbx = (EditText) this.che.findViewById(n.g.search_bar_edit);
        if (this.cbx.getParent() != null) {
            ((View) this.cbx.getParent()).setFocusable(true);
            ((View) this.cbx.getParent()).setFocusableInTouchMode(true);
        }
        this.aIu = new u(this);
        this.cbx.addTextChangedListener(this.aIu);
        this.chg = (TextView) this.che.findViewById(n.g.search_bar_delete_button);
        this.chg.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adW() {
        if (this.cgV != null) {
            this.cgV.adU();
        }
    }

    public void vR() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.cgV.getLayoutMode().ac(skinType == 1);
        this.cgV.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.cgV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cgV.getPageContext(), skinType);
        as.i(this.mListFooter, n.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void adX() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void adY() {
        com.baidu.adp.lib.util.k.c(this.cgV.getPageContext().getPageActivity(), this.cbx);
        this.che.setVisibility(8);
        this.chd.setVisibility(0);
        this.chf.setVisibility(0);
        this.cbx.getText().clear();
    }

    public boolean adZ() {
        return this.che != null && this.che.getVisibility() == 0;
    }

    public int aea() {
        return this.cha.getId();
    }

    public String aeb() {
        Editable text = this.cbx.getText();
        return text != null ? text.toString() : "";
    }

    public String aec() {
        return this.cgY.adR();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.cgW == null) {
            this.cgW = new o(this.cgV, this.chc);
            this.cgW.a(this);
            this.cgW.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.cgW);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.chc) {
                this.cgZ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.cgW.setData(list);
        this.cgW.notifyDataSetChanged();
        if (!this.chc) {
            this.cgZ.setVisibility(0);
        }
    }

    public void aed() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cgV.getPageContext());
        }
    }

    public void aee() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void aef() {
        int dimensionPixelSize = this.cgV.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_height) + this.cgV.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_padding_bottom) + this.cgV.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(this.cgV.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.mListView.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cgY.d(aVar);
            jo(this.cgY.getItemLength());
            aeg();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cgY.f(aVar);
            jo(this.cgY.getItemLength());
            aeg();
        }
    }

    private void aeg() {
        if (this.cgY.getItemLength() > 0) {
            this.cha.setEnabled(true);
        } else {
            this.cha.setEnabled(false);
        }
    }

    public void aeh() {
        com.baidu.adp.lib.util.k.c(this.cgV.getPageContext().getPageActivity(), this.cbx);
    }

    private void jo(int i) {
        this.cha.setText(String.format(this.cgV.getPageContext().getString(n.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aei() {
        return this.chb;
    }

    public void jp(int i) {
        this.chb = i;
        this.cgY.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cgY.e(aVar);
        }
    }

    public void onDestroy() {
        this.cbx.removeTextChangedListener(this.aIu);
    }
}
