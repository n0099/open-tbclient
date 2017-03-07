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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e<InviteFriendListActivity> implements o.b {
    private BdListView IK;
    private View QZ;
    private ProgressBar bqO;
    private EditText dgY;
    private InviteFriendCandidateList dkA;
    private LinearLayout dkB;
    private Button dkC;
    private int dkD;
    private boolean dkE;
    private TextView dkF;
    private View dkG;
    private View dkH;
    private TextView dkI;
    private ImageView dkJ;
    private final InviteFriendListActivity dkx;
    private o dky;
    private View dkz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dkD = 0;
        this.dkx = inviteFriendListActivity;
        this.dkE = z;
        wO();
    }

    public View getRootView() {
        return this.QZ;
    }

    private void wO() {
        this.dkx.setContentView(w.j.invite_friend_list);
        this.QZ = this.dkx.findViewById(w.h.root_view);
        auN();
        this.IK = (BdListView) this.QZ.findViewById(w.h.friend_list);
        this.IK.setOnItemClickListener(this.dkx);
        if (this.dkE) {
            this.mNoDataView = NoDataViewFactory.a(this.dkx.getPageContext().getPageActivity(), this.QZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aID), NoDataViewFactory.d.E(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dkx.getPageContext().getPageActivity(), this.QZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aID), NoDataViewFactory.d.E(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.bqO = (ProgressBar) this.QZ.findViewById(w.h.progress);
        this.dkA = (InviteFriendCandidateList) this.QZ.findViewById(w.h.candidate_list);
        this.dkA.a(new r(this));
        this.dkB = (LinearLayout) this.QZ.findViewById(w.h.invite_candidate);
        this.dkz = this.QZ.findViewById(w.h.invite_candidate_border);
        if (this.dkE) {
            this.dkB.setVisibility(8);
            this.dkz.setVisibility(8);
        }
        auX();
        this.dkC = (Button) this.QZ.findViewById(w.h.button_send);
        this.dkC.setOnClickListener(this.dkx);
        wP();
        auP();
        md(0);
    }

    private void auN() {
        this.mNavigationBar = (NavigationBar) this.QZ.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dkE) {
            this.dkF = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dkF = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.dkH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dkJ = (ImageView) this.dkH.findViewById(w.h.new_friend_search);
        this.dkG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dkG.setVisibility(8);
        this.dgY = (EditText) this.dkG.findViewById(w.h.search_bar_edit);
        if (this.dgY.getParent() != null) {
            ((View) this.dgY.getParent()).setFocusable(true);
            ((View) this.dgY.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dgY.addTextChangedListener(this.mTextWatcher);
        this.dkI = (TextView) this.dkG.findViewById(w.h.search_bar_delete_button);
        this.dkI.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auO() {
        if (this.dkx != null) {
            this.dkx.auL();
        }
    }

    public void wP() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dkx.getLayoutMode().ah(skinType == 1);
        this.dkx.getLayoutMode().t(this.QZ);
        aq.b(this.dkJ, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dkx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dkx.getPageContext(), skinType);
        aq.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void auP() {
        this.IK.setOnTouchListener(new w(this));
    }

    public void auQ() {
        com.baidu.adp.lib.util.k.b(this.dkx.getPageContext().getPageActivity(), this.dgY);
        this.dkG.setVisibility(8);
        this.dkF.setVisibility(0);
        this.dkH.setVisibility(0);
        this.dgY.getText().clear();
    }

    public boolean auR() {
        return this.dkG != null && this.dkG.getVisibility() == 0;
    }

    public int auS() {
        return this.dkC.getId();
    }

    public String auT() {
        Editable text = this.dgY.getText();
        return text != null ? text.toString() : "";
    }

    public String auU() {
        return this.dkA.auI();
    }

    public void i(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dky == null) {
            this.dky = new o(this.dkx, this.dkE);
            this.dky.a(this);
            this.dky.a(new x(this));
            this.IK.setAdapter((ListAdapter) this.dky);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.IK.setVisibility(8);
            if (!this.dkE) {
                this.dkB.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.IK.setVisibility(0);
        this.dky.setData(list);
        this.dky.notifyDataSetChanged();
        if (!this.dkE) {
            this.dkB.setVisibility(0);
        }
    }

    public void auV() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dkx.getPageContext());
        }
    }

    public void auW() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void auX() {
        int dimensionPixelSize = this.dkx.getResources().getDimensionPixelSize(w.f.ds80) + this.dkx.getResources().getDimensionPixelSize(w.f.ds16) + this.dkx.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.dkx.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.IK.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkA.d(aVar);
            md(this.dkA.getItemLength());
            auY();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkA.f(aVar);
            md(this.dkA.getItemLength());
            auY();
        }
    }

    private void auY() {
        if (this.dkA.getItemLength() > 0) {
            this.dkC.setEnabled(true);
        } else {
            this.dkC.setEnabled(false);
        }
    }

    public void auZ() {
        com.baidu.adp.lib.util.k.b(this.dkx.getPageContext().getPageActivity(), this.dgY);
    }

    private void md(int i) {
        this.dkC.setText(String.format(this.dkx.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ava() {
        return this.dkD;
    }

    public void me(int i) {
        this.dkD = i;
        this.dkA.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dkA.e(aVar);
        }
    }

    public void onDestroy() {
        this.dgY.removeTextChangedListener(this.mTextWatcher);
    }
}
