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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView Ck;
    private View MJ;
    private TextWatcher aUJ;
    private ProgressBar ban;
    private EditText cXt;
    private final InviteFriendListActivity daS;
    private o daT;
    private View daU;
    private InviteFriendCandidateList daV;
    private LinearLayout daW;
    private Button daX;
    private int daY;
    private boolean daZ;
    private TextView dba;
    private View dbb;
    private View dbc;
    private TextView dbd;
    private ImageView dbe;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.daY = 0;
        this.daS = inviteFriendListActivity;
        this.daZ = z;
        ww();
    }

    public View getRootView() {
        return this.MJ;
    }

    private void ww() {
        this.daS.setContentView(r.h.invite_friend_list);
        this.MJ = this.daS.findViewById(r.g.root_view);
        acE();
        this.Ck = (BdListView) this.MJ.findViewById(r.g.friend_list);
        this.Ck.setOnItemClickListener(this.daS);
        if (this.daZ) {
            this.mNoDataView = NoDataViewFactory.a(this.daS.getPageContext().getPageActivity(), this.MJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEq), NoDataViewFactory.d.x(r.j.no_friends, r.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.daS.getPageContext().getPageActivity(), this.MJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEq), NoDataViewFactory.d.x(r.j.no_chat_friends, r.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(r.j.find_new_friend), new q(this))));
        }
        this.ban = (ProgressBar) this.MJ.findViewById(r.g.progress);
        this.daV = (InviteFriendCandidateList) this.MJ.findViewById(r.g.candidate_list);
        this.daV.a(new r(this));
        this.daW = (LinearLayout) this.MJ.findViewById(r.g.invite_candidate);
        this.daU = this.MJ.findViewById(r.g.invite_candidate_border);
        if (this.daZ) {
            this.daW.setVisibility(8);
            this.daU.setVisibility(8);
        }
        auv();
        this.daX = (Button) this.MJ.findViewById(r.g.button_send);
        this.daX.setOnClickListener(this.daS);
        wx();
        aun();
        lA(0);
    }

    private void acE() {
        this.mNavigationBar = (NavigationBar) this.MJ.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.daZ) {
            this.dba = this.mNavigationBar.setTitleText(r.j.invite_contact_title);
        } else {
            this.dba = this.mNavigationBar.setTitleText(r.j.invite_friend);
        }
        this.dbc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new t(this));
        this.dbe = (ImageView) this.dbc.findViewById(r.g.new_friend_search);
        this.dbb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dbb.setVisibility(8);
        this.cXt = (EditText) this.dbb.findViewById(r.g.search_bar_edit);
        if (this.cXt.getParent() != null) {
            ((View) this.cXt.getParent()).setFocusable(true);
            ((View) this.cXt.getParent()).setFocusableInTouchMode(true);
        }
        this.aUJ = new u(this);
        this.cXt.addTextChangedListener(this.aUJ);
        this.dbd = (TextView) this.dbb.findViewById(r.g.search_bar_delete_button);
        this.dbd.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aum() {
        if (this.daS != null) {
            this.daS.auk();
        }
    }

    public void wx() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.daS.getLayoutMode().ai(skinType == 1);
        this.daS.getLayoutMode().x(this.MJ);
        ar.b(this.dbe, r.f.icon_search_bg_s, r.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.daS.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.daS.getPageContext(), skinType);
        ar.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aun() {
        this.Ck.setOnTouchListener(new w(this));
    }

    public void auo() {
        com.baidu.adp.lib.util.k.b(this.daS.getPageContext().getPageActivity(), this.cXt);
        this.dbb.setVisibility(8);
        this.dba.setVisibility(0);
        this.dbc.setVisibility(0);
        this.cXt.getText().clear();
    }

    public boolean aup() {
        return this.dbb != null && this.dbb.getVisibility() == 0;
    }

    public int auq() {
        return this.daX.getId();
    }

    public String aur() {
        Editable text = this.cXt.getText();
        return text != null ? text.toString() : "";
    }

    public String aus() {
        return this.daV.auh();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.daT == null) {
            this.daT = new o(this.daS, this.daZ);
            this.daT.a(this);
            this.daT.a(new x(this));
            this.Ck.setAdapter((ListAdapter) this.daT);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ck.setVisibility(8);
            if (!this.daZ) {
                this.daW.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ck.setVisibility(0);
        this.daT.setData(list);
        this.daT.notifyDataSetChanged();
        if (!this.daZ) {
            this.daW.setVisibility(0);
        }
    }

    public void aut() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.daS.getPageContext());
        }
    }

    public void auu() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void auv() {
        int dimensionPixelSize = this.daS.getResources().getDimensionPixelSize(r.e.ds80) + this.daS.getResources().getDimensionPixelSize(r.e.ds16) + this.daS.getResources().getDimensionPixelSize(r.e.ds16);
        this.mListFooter = new View(this.daS.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ck.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.daV.d(aVar);
            lA(this.daV.getItemLength());
            auw();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.daV.f(aVar);
            lA(this.daV.getItemLength());
            auw();
        }
    }

    private void auw() {
        if (this.daV.getItemLength() > 0) {
            this.daX.setEnabled(true);
        } else {
            this.daX.setEnabled(false);
        }
    }

    public void aux() {
        com.baidu.adp.lib.util.k.b(this.daS.getPageContext().getPageActivity(), this.cXt);
    }

    private void lA(int i) {
        this.daX.setText(String.format(this.daS.getPageContext().getString(r.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int auy() {
        return this.daY;
    }

    public void lB(int i) {
        this.daY = i;
        this.daV.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.daV.e(aVar);
        }
    }

    public void onDestroy() {
        this.cXt.removeTextChangedListener(this.aUJ);
    }
}
