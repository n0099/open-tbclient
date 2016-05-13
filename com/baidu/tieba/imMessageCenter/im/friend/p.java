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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private View KB;
    private TextWatcher aIE;
    private ProgressBar bDI;
    private EditText crz;
    private final InviteFriendListActivity cwX;
    private o cwY;
    private View cwZ;
    private InviteFriendCandidateList cxa;
    private LinearLayout cxb;
    private Button cxc;
    private int cxd;
    private boolean cxe;
    private TextView cxf;
    private View cxg;
    private View cxh;
    private TextView cxi;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.q mNoDataView;
    private BdListView zu;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.cxd = 0;
        this.cwX = inviteFriendListActivity;
        this.cxe = z;
        vl();
    }

    public View getRootView() {
        return this.KB;
    }

    private void vl() {
        this.cwX.setContentView(t.h.invite_friend_list);
        this.KB = this.cwX.findViewById(t.g.root_view);
        Ux();
        this.zu = (BdListView) this.KB.findViewById(t.g.friend_list);
        this.zu.setOnItemClickListener(this.cwX);
        if (this.cxe) {
            this.mNoDataView = NoDataViewFactory.a(this.cwX.getPageContext().getPageActivity(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.azU), NoDataViewFactory.d.v(t.j.no_friends, t.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.cwX.getPageContext().getPageActivity(), this.KB, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.azU), NoDataViewFactory.d.v(t.j.no_chat_friends, t.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m11getInst().getResources().getString(t.j.find_new_friend), new q(this))));
        }
        this.bDI = (ProgressBar) this.KB.findViewById(t.g.progress);
        this.cxa = (InviteFriendCandidateList) this.KB.findViewById(t.g.candidate_list);
        this.cxa.a(new r(this));
        this.cxb = (LinearLayout) this.KB.findViewById(t.g.invite_candidate);
        this.cwZ = this.KB.findViewById(t.g.invite_candidate_border);
        if (this.cxe) {
            this.cxb.setVisibility(8);
            this.cwZ.setVisibility(8);
        }
        akR();
        this.cxc = (Button) this.KB.findViewById(t.g.button_send);
        this.cxc.setOnClickListener(this.cwX);
        vm();
        akJ();
        jW(0);
    }

    private void Ux() {
        this.mNavigationBar = (NavigationBar) this.KB.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.cxe) {
            this.cxf = this.mNavigationBar.setTitleText(t.j.invite_contact_title);
        } else {
            this.cxf = this.mNavigationBar.setTitleText(t.j.invite_friend);
        }
        this.cxh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.add_new_friend_text, new t(this));
        this.cxg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, t.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.cxg.setVisibility(8);
        this.crz = (EditText) this.cxg.findViewById(t.g.search_bar_edit);
        if (this.crz.getParent() != null) {
            ((View) this.crz.getParent()).setFocusable(true);
            ((View) this.crz.getParent()).setFocusableInTouchMode(true);
        }
        this.aIE = new u(this);
        this.crz.addTextChangedListener(this.aIE);
        this.cxi = (TextView) this.cxg.findViewById(t.g.search_bar_delete_button);
        this.cxi.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        if (this.cwX != null) {
            this.cwX.akG();
        }
    }

    public void vm() {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        this.cwX.getLayoutMode().ae(skinType == 1);
        this.cwX.getLayoutMode().x(this.KB);
        this.mNavigationBar.onChangeSkinType(this.cwX.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.cwX.getPageContext(), skinType);
        at.k(this.mListFooter, t.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void akJ() {
        this.zu.setOnTouchListener(new w(this));
    }

    public void akK() {
        com.baidu.adp.lib.util.k.a(this.cwX.getPageContext().getPageActivity(), this.crz);
        this.cxg.setVisibility(8);
        this.cxf.setVisibility(0);
        this.cxh.setVisibility(0);
        this.crz.getText().clear();
    }

    public boolean akL() {
        return this.cxg != null && this.cxg.getVisibility() == 0;
    }

    public int akM() {
        return this.cxc.getId();
    }

    public String akN() {
        Editable text = this.crz.getText();
        return text != null ? text.toString() : "";
    }

    public String akO() {
        return this.cxa.akD();
    }

    public void e(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.cwY == null) {
            this.cwY = new o(this.cwX, this.cxe);
            this.cwY.a(this);
            this.cwY.a(new x(this));
            this.zu.setAdapter((ListAdapter) this.cwY);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.zu.setVisibility(8);
            if (!this.cxe) {
                this.cxb.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.zu.setVisibility(0);
        this.cwY.setData(list);
        this.cwY.notifyDataSetChanged();
        if (!this.cxe) {
            this.cxb.setVisibility(0);
        }
    }

    public void akP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.cwX.getPageContext());
        }
    }

    public void akQ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [384=4] */
    private void akR() {
        int dimensionPixelSize = this.cwX.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height) + this.cwX.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_bottom) + this.cwX.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_padding_top);
        this.mListFooter = new View(this.cwX.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.zu.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cxa.d(aVar);
            jW(this.cxa.getItemLength());
            akS();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cxa.f(aVar);
            jW(this.cxa.getItemLength());
            akS();
        }
    }

    private void akS() {
        if (this.cxa.getItemLength() > 0) {
            this.cxc.setEnabled(true);
        } else {
            this.cxc.setEnabled(false);
        }
    }

    public void akT() {
        com.baidu.adp.lib.util.k.a(this.cwX.getPageContext().getPageActivity(), this.crz);
    }

    private void jW(int i) {
        this.cxc.setText(String.format(this.cwX.getPageContext().getString(t.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int akU() {
        return this.cxd;
    }

    public void jX(int i) {
        this.cxd = i;
        this.cxa.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.cxa.e(aVar);
        }
    }

    public void onDestroy() {
        this.crz.removeTextChangedListener(this.aIE);
    }
}
