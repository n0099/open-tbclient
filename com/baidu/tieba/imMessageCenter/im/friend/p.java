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
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private View KB;
    private TextWatcher aMb;
    private EditText cWP;
    private ProgressBar cbl;
    private final InviteFriendListActivity dcm;
    private o dcn;
    private View dco;
    private InviteFriendCandidateList dcp;
    private LinearLayout dcq;
    private Button dcr;
    private int dcs;
    private boolean dct;
    private TextView dcv;
    private View dcw;
    private View dcx;
    private TextView dcy;
    private ImageView dcz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zt;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dcs = 0;
        this.dcm = inviteFriendListActivity;
        this.dct = z;
        initialize();
    }

    public View getRootView() {
        return this.KB;
    }

    private void initialize() {
        this.dcm.setContentView(u.h.invite_friend_list);
        this.KB = this.dcm.findViewById(u.g.root_view);
        PQ();
        this.zt = (BdListView) this.KB.findViewById(u.g.friend_list);
        this.zt.setOnItemClickListener(this.dcm);
        if (this.dct) {
            this.mNoDataView = NoDataViewFactory.a(this.dcm.getPageContext().getPageActivity(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aAL), NoDataViewFactory.d.v(u.j.no_friends, u.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dcm.getPageContext().getPageActivity(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aAL), NoDataViewFactory.d.v(u.j.no_chat_friends, u.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(u.j.find_new_friend), new q(this))));
        }
        this.cbl = (ProgressBar) this.KB.findViewById(u.g.progress);
        this.dcp = (InviteFriendCandidateList) this.KB.findViewById(u.g.candidate_list);
        this.dcp.a(new r(this));
        this.dcq = (LinearLayout) this.KB.findViewById(u.g.invite_candidate);
        this.dco = this.KB.findViewById(u.g.invite_candidate_border);
        if (this.dct) {
            this.dcq.setVisibility(8);
            this.dco.setVisibility(8);
        }
        atd();
        this.dcr = (Button) this.KB.findViewById(u.g.button_send);
        this.dcr.setOnClickListener(this.dcm);
        vm();
        asW();
        ly(0);
    }

    private void PQ() {
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dct) {
            this.dcv = this.mNavigationBar.setTitleText(u.j.invite_contact_title);
        } else {
            this.dcv = this.mNavigationBar.setTitleText(u.j.invite_friend);
        }
        this.dcx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.add_new_friend_text, new t(this));
        this.dcz = (ImageView) this.dcx.findViewById(u.g.new_friend_search);
        this.dcw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, u.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dcw.setVisibility(8);
        this.cWP = (EditText) this.dcw.findViewById(u.g.search_bar_edit);
        if (this.cWP.getParent() != null) {
            ((View) this.cWP.getParent()).setFocusable(true);
            ((View) this.cWP.getParent()).setFocusableInTouchMode(true);
        }
        this.aMb = new u(this);
        this.cWP.addTextChangedListener(this.aMb);
        this.dcy = (TextView) this.dcw.findViewById(u.g.search_bar_delete_button);
        this.dcy.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asV() {
        if (this.dcm != null) {
            this.dcm.asT();
        }
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dcm.getLayoutMode().ad(skinType == 1);
        this.dcm.getLayoutMode().w(this.KB);
        av.a(this.dcz, u.f.icon_search_bg_s, u.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dcm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dcm.getPageContext(), skinType);
        av.k(this.mListFooter, u.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void asW() {
        this.zt.setOnTouchListener(new w(this));
    }

    public void asX() {
        com.baidu.adp.lib.util.k.a(this.dcm.getPageContext().getPageActivity(), this.cWP);
        this.dcw.setVisibility(8);
        this.dcv.setVisibility(0);
        this.dcx.setVisibility(0);
        this.cWP.getText().clear();
    }

    public boolean asY() {
        return this.dcw != null && this.dcw.getVisibility() == 0;
    }

    public int asZ() {
        return this.dcr.getId();
    }

    public String getSearchText() {
        Editable text = this.cWP.getText();
        return text != null ? text.toString() : "";
    }

    public String ata() {
        return this.dcp.asQ();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dcn == null) {
            this.dcn = new o(this.dcm, this.dct);
            this.dcn.a(this);
            this.dcn.a(new x(this));
            this.zt.setAdapter((ListAdapter) this.dcn);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.zt.setVisibility(8);
            if (!this.dct) {
                this.dcq.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.zt.setVisibility(0);
        this.dcn.setData(list);
        this.dcn.notifyDataSetChanged();
        if (!this.dct) {
            this.dcq.setVisibility(0);
        }
    }

    public void atb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dcm.getPageContext());
        }
    }

    public void atc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void atd() {
        int dimensionPixelSize = this.dcm.getResources().getDimensionPixelSize(u.e.ds80) + this.dcm.getResources().getDimensionPixelSize(u.e.ds16) + this.dcm.getResources().getDimensionPixelSize(u.e.ds16);
        this.mListFooter = new View(this.dcm.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.zt.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dcp.d(aVar);
            ly(this.dcp.getItemLength());
            ate();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dcp.f(aVar);
            ly(this.dcp.getItemLength());
            ate();
        }
    }

    private void ate() {
        if (this.dcp.getItemLength() > 0) {
            this.dcr.setEnabled(true);
        } else {
            this.dcr.setEnabled(false);
        }
    }

    public void atf() {
        com.baidu.adp.lib.util.k.a(this.dcm.getPageContext().getPageActivity(), this.cWP);
    }

    private void ly(int i) {
        this.dcr.setText(String.format(this.dcm.getPageContext().getString(u.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int atg() {
        return this.dcs;
    }

    public void lz(int i) {
        this.dcs = i;
        this.dcp.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dcp.e(aVar);
        }
    }

    public void onDestroy() {
        this.cWP.removeTextChangedListener(this.aMb);
    }
}
