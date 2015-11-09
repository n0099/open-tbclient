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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.i;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private TextWatcher aDU;
    private EditText bIr;
    private final InviteFriendListActivity bNR;
    private o bNS;
    private View bNT;
    private InviteFriendCandidateList bNU;
    private LinearLayout bNV;
    private Button bNW;
    private View bNX;
    private int bNY;
    private boolean bNZ;
    private TextView bOa;
    private View bOb;
    private View bOc;
    private TextView bOd;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.m mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.bNY = 0;
        this.bNR = inviteFriendListActivity;
        this.bNZ = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.bNR.setContentView(i.g.invite_friend_list);
        this.mRoot = this.bNR.findViewById(i.f.root_view);
        OC();
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.friend_list);
        this.mListView.setOnItemClickListener(this.bNR);
        if (this.bNZ) {
            this.mNoDataView = NoDataViewFactory.a(this.bNR.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_friends, i.h.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.bNR.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.C(i.h.no_chat_friends, i.h.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(i.h.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(i.f.progress);
        this.bNU = (InviteFriendCandidateList) this.mRoot.findViewById(i.f.candidate_list);
        this.bNU.a(new r(this));
        this.bNV = (LinearLayout) this.mRoot.findViewById(i.f.invite_candidate);
        this.bNT = this.mRoot.findViewById(i.f.invite_candidate_border);
        if (this.bNZ) {
            this.bNV.setVisibility(8);
            this.bNT.setVisibility(8);
        }
        ZQ();
        this.bNW = (Button) this.mRoot.findViewById(i.f.button_send);
        this.bNW.setOnClickListener(this.bNR);
        vB();
        ZI();
        ib(0);
    }

    private void OC() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.bNZ) {
            this.bOa = this.mNavigationBar.setTitleText(i.h.invite_contact_title);
        } else {
            this.bOa = this.mNavigationBar.setTitleText(i.h.invite_friend);
        }
        this.bOc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.add_new_friend_text, new t(this));
        this.bOb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, i.g.navigationbar_search_edit, (View.OnClickListener) null);
        this.bOb.setVisibility(8);
        this.bIr = (EditText) this.bOb.findViewById(i.f.search_bar_edit);
        if (this.bIr.getParent() != null) {
            ((View) this.bIr.getParent()).setFocusable(true);
            ((View) this.bIr.getParent()).setFocusableInTouchMode(true);
        }
        this.aDU = new u(this);
        this.bIr.addTextChangedListener(this.aDU);
        this.bOd = (TextView) this.bOb.findViewById(i.f.search_bar_delete_button);
        this.bOd.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZH() {
        if (this.bNR != null) {
            this.bNR.ZF();
        }
    }

    public void vB() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.bNR.getLayoutMode().ad(skinType == 1);
        this.bNR.getLayoutMode().k(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.bNR.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.bNR.getPageContext(), skinType);
        an.i(this.bNX, i.e.invite_friend_list_item_bg_color);
        this.bNX.setEnabled(false);
    }

    public void ZI() {
        this.mListView.setOnTouchListener(new w(this));
    }

    public void ZJ() {
        com.baidu.adp.lib.util.k.c(this.bNR.getPageContext().getPageActivity(), this.bIr);
        this.bOb.setVisibility(8);
        this.bOa.setVisibility(0);
        this.bOc.setVisibility(0);
        this.bIr.getText().clear();
    }

    public boolean ZK() {
        return this.bOb != null && this.bOb.getVisibility() == 0;
    }

    public int ZL() {
        return this.bNW.getId();
    }

    public String ZM() {
        Editable text = this.bIr.getText();
        return text != null ? text.toString() : "";
    }

    public String ZN() {
        return this.bNU.ZC();
    }

    public void d(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.bNS == null) {
            this.bNS = new o(this.bNR, this.bNZ);
            this.bNS.a(this);
            this.bNS.setCheckBoxStateChangedListener(new x(this));
            this.mListView.setAdapter((ListAdapter) this.bNS);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.mListView.setVisibility(8);
            if (!this.bNZ) {
                this.bNV.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.bNS.setData(list);
        this.bNS.notifyDataSetChanged();
        if (!this.bNZ) {
            this.bNV.setVisibility(0);
        }
    }

    public void ZO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.bNR.getPageContext());
        }
    }

    public void ZP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void ZQ() {
        int dimensionPixelSize = this.bNR.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height) + this.bNR.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_bottom) + this.bNR.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_padding_top);
        this.bNX = new View(this.bNR.getPageContext().getPageActivity());
        this.bNX.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.bNX.setEnabled(false);
        this.mListView.addFooterView(this.bNX);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNU.d(aVar);
            ib(this.bNU.getItemLength());
            ZR();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNU.f(aVar);
            ib(this.bNU.getItemLength());
            ZR();
        }
    }

    private void ZR() {
        if (this.bNU.getItemLength() > 0) {
            this.bNW.setEnabled(true);
        } else {
            this.bNW.setEnabled(false);
        }
    }

    public void ZS() {
        com.baidu.adp.lib.util.k.c(this.bNR.getPageContext().getPageActivity(), this.bIr);
    }

    private void ib(int i) {
        this.bNW.setText(String.format(this.bNR.getPageContext().getString(i.h.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ZT() {
        return this.bNY;
    }

    public void ic(int i) {
        this.bNY = i;
        this.bNU.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.bNU.e(aVar);
        }
    }

    public void onDestroy() {
        this.bIr.removeTextChangedListener(this.aDU);
    }
}
