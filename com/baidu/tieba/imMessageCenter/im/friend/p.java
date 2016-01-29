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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView IY;
    private View Sn;
    private TextWatcher aJy;
    private ProgressBar aNo;
    private EditText cfX;
    private InviteFriendCandidateList clA;
    private LinearLayout clB;
    private Button clC;
    private int clD;
    private boolean clE;
    private TextView clF;
    private View clG;
    private View clH;
    private TextView clI;
    private final InviteFriendListActivity clx;
    private o cly;
    private View clz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.clD = 0;
        this.clx = inviteFriendListActivity;
        this.clE = z;
        initialize();
    }

    public View getRootView() {
        return this.Sn;
    }

    private void initialize() {
        this.clx.setContentView(t.h.invite_friend_list);
        this.Sn = this.clx.findViewById(t.g.root_view);
        SG();
        this.IY = (BdListView) this.Sn.findViewById(t.g.friend_list);
        this.IY.setOnItemClickListener(this.clx);
        if (this.clE) {
            this.mNoDataView = NoDataViewFactory.a(this.clx.getPageContext().getPageActivity(), this.Sn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.y(t.j.no_friends, t.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.clx.getPageContext().getPageActivity(), this.Sn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA), NoDataViewFactory.d.y(t.j.no_chat_friends, t.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m411getInst().getResources().getString(t.j.find_new_friend), new q(this))));
        }
        this.aNo = (ProgressBar) this.Sn.findViewById(t.g.progress);
        this.clA = (InviteFriendCandidateList) this.Sn.findViewById(t.g.candidate_list);
        this.clA.a(new r(this));
        this.clB = (LinearLayout) this.Sn.findViewById(t.g.invite_candidate);
        this.clz = this.Sn.findViewById(t.g.invite_candidate_border);
        if (this.clE) {
            this.clB.setVisibility(8);
            this.clz.setVisibility(8);
        }
        ahp();
        this.clC = (Button) this.Sn.findViewById(t.g.button_send);
        this.clC.setOnClickListener(this.clx);
        xf();
        ahh();
        jM(0);
    }

    private void SG() {
        this.mNavigationBar = (NavigationBar) this.Sn.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.clE) {
            this.clF = this.mNavigationBar.setTitleText(t.j.invite_contact_title);
        } else {
            this.clF = this.mNavigationBar.setTitleText(t.j.invite_friend);
        }
        this.clH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new t(this));
        this.clG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.clG.setVisibility(8);
        this.cfX = (EditText) this.clG.findViewById(t.g.search_bar_edit);
        if (this.cfX.getParent() != null) {
            ((View) this.cfX.getParent()).setFocusable(true);
            ((View) this.cfX.getParent()).setFocusableInTouchMode(true);
        }
        this.aJy = new u(this);
        this.cfX.addTextChangedListener(this.aJy);
        this.clI = (TextView) this.clG.findViewById(t.g.search_bar_delete_button);
        this.clI.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahg() {
        if (this.clx != null) {
            this.clx.ahe();
        }
    }

    public void xf() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        this.clx.getLayoutMode().ac(skinType == 1);
        this.clx.getLayoutMode().x(this.Sn);
        this.mNavigationBar.onChangeSkinType(this.clx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.clx.getPageContext(), skinType);
        ar.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void ahh() {
        this.IY.setOnTouchListener(new w(this));
    }

    public void ahi() {
        com.baidu.adp.lib.util.k.c(this.clx.getPageContext().getPageActivity(), this.cfX);
        this.clG.setVisibility(8);
        this.clF.setVisibility(0);
        this.clH.setVisibility(0);
        this.cfX.getText().clear();
    }

    public boolean ahj() {
        return this.clG != null && this.clG.getVisibility() == 0;
    }

    public int ahk() {
        return this.clC.getId();
    }

    public String ahl() {
        Editable text = this.cfX.getText();
        return text != null ? text.toString() : "";
    }

    public String ahm() {
        return this.clA.ahb();
    }

    public void c(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.cly == null) {
            this.cly = new o(this.clx, this.clE);
            this.cly.a(this);
            this.cly.a(new x(this));
            this.IY.setAdapter((ListAdapter) this.cly);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.IY.setVisibility(8);
            if (!this.clE) {
                this.clB.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.IY.setVisibility(0);
        this.cly.setData(list);
        this.cly.notifyDataSetChanged();
        if (!this.clE) {
            this.clB.setVisibility(0);
        }
    }

    public void ahn() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.clx.getPageContext());
        }
    }

    public void aho() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [383=4] */
    private void ahp() {
        int dimensionPixelSize = this.clx.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + this.clx.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + this.clx.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(this.clx.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.IY.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.clA.d(aVar);
            jM(this.clA.getItemLength());
            ahq();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.clA.f(aVar);
            jM(this.clA.getItemLength());
            ahq();
        }
    }

    private void ahq() {
        if (this.clA.getItemLength() > 0) {
            this.clC.setEnabled(true);
        } else {
            this.clC.setEnabled(false);
        }
    }

    public void ahr() {
        com.baidu.adp.lib.util.k.c(this.clx.getPageContext().getPageActivity(), this.cfX);
    }

    private void jM(int i) {
        this.clC.setText(String.format(this.clx.getPageContext().getString(t.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ahs() {
        return this.clD;
    }

    public void jN(int i) {
        this.clD = i;
        this.clA.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.clA.e(aVar);
        }
    }

    public void onDestroy() {
        this.cfX.removeTextChangedListener(this.aJy);
    }
}
