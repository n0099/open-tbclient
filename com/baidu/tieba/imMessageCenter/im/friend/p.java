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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.w;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class p extends com.baidu.adp.base.e<InviteFriendListActivity> implements o.b {
    private BdListView Ib;
    private View Qr;
    private EditText dpg;
    private final InviteFriendListActivity dsH;
    private o dsI;
    private View dsJ;
    private InviteFriendCandidateList dsK;
    private LinearLayout dsL;
    private Button dsM;
    private int dsN;
    private boolean dsO;
    private TextView dsP;
    private View dsQ;
    private View dsR;
    private TextView dsS;
    private ImageView dsT;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.y mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dsN = 0;
        this.dsH = inviteFriendListActivity;
        this.dsO = z;
        wJ();
    }

    public View getRootView() {
        return this.Qr;
    }

    private void wJ() {
        this.dsH.setContentView(w.j.invite_friend_list);
        this.Qr = this.dsH.findViewById(w.h.root_view);
        Vk();
        this.Ib = (BdListView) this.Qr.findViewById(w.h.friend_list);
        this.Ib.setOnItemClickListener(this.dsH);
        if (this.dsO) {
            this.mNoDataView = NoDataViewFactory.a(this.dsH.getPageContext().getPageActivity(), this.Qr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aJZ), NoDataViewFactory.d.B(w.l.no_friends, w.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dsH.getPageContext().getPageActivity(), this.Qr, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aJZ), NoDataViewFactory.d.B(w.l.no_chat_friends, w.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(w.l.find_new_friend), new q(this))));
        }
        this.mProgress = (ProgressBar) this.Qr.findViewById(w.h.progress);
        this.dsK = (InviteFriendCandidateList) this.Qr.findViewById(w.h.candidate_list);
        this.dsK.a(new r(this));
        this.dsL = (LinearLayout) this.Qr.findViewById(w.h.invite_candidate);
        this.dsJ = this.Qr.findViewById(w.h.invite_candidate_border);
        if (this.dsO) {
            this.dsL.setVisibility(8);
            this.dsJ.setVisibility(8);
        }
        axp();
        this.dsM = (Button) this.Qr.findViewById(w.h.button_send);
        this.dsM.setOnClickListener(this.dsH);
        wK();
        axh();
        mC(0);
    }

    private void Vk() {
        this.mNavigationBar = (NavigationBar) this.Qr.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dsO) {
            this.dsP = this.mNavigationBar.setTitleText(w.l.invite_contact_title);
        } else {
            this.dsP = this.mNavigationBar.setTitleText(w.l.invite_friend);
        }
        this.dsR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.add_new_friend_text, new t(this));
        this.dsT = (ImageView) this.dsR.findViewById(w.h.new_friend_search);
        this.dsQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, w.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dsQ.setVisibility(8);
        this.dpg = (EditText) this.dsQ.findViewById(w.h.search_bar_edit);
        if (this.dpg.getParent() != null) {
            ((View) this.dpg.getParent()).setFocusable(true);
            ((View) this.dpg.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.dpg.addTextChangedListener(this.mTextWatcher);
        this.dsS = (TextView) this.dsQ.findViewById(w.h.search_bar_delete_button);
        this.dsS.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axg() {
        if (this.dsH != null) {
            this.dsH.axe();
        }
    }

    public void wK() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dsH.getLayoutMode().ah(skinType == 1);
        this.dsH.getLayoutMode().t(this.Qr);
        as.b(this.dsT, w.g.icon_search_bg_s, w.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dsH.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dsH.getPageContext(), skinType);
        as.j(this.mListFooter, w.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void axh() {
        this.Ib.setOnTouchListener(new w(this));
    }

    public void axi() {
        com.baidu.adp.lib.util.k.b(this.dsH.getPageContext().getPageActivity(), this.dpg);
        this.dsQ.setVisibility(8);
        this.dsP.setVisibility(0);
        this.dsR.setVisibility(0);
        this.dpg.getText().clear();
    }

    public boolean axj() {
        return this.dsQ != null && this.dsQ.getVisibility() == 0;
    }

    public int axk() {
        return this.dsM.getId();
    }

    public String axl() {
        Editable text = this.dpg.getText();
        return text != null ? text.toString() : "";
    }

    public String axm() {
        return this.dsK.axb();
    }

    public void l(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dsI == null) {
            this.dsI = new o(this.dsH, this.dsO);
            this.dsI.a(this);
            this.dsI.a(new x(this));
            this.Ib.setAdapter((ListAdapter) this.dsI);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ib.setVisibility(8);
            if (!this.dsO) {
                this.dsL.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ib.setVisibility(0);
        this.dsI.setData(list);
        this.dsI.notifyDataSetChanged();
        if (!this.dsO) {
            this.dsL.setVisibility(0);
        }
    }

    public void axn() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dsH.getPageContext());
        }
    }

    public void axo() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void axp() {
        int dimensionPixelSize = this.dsH.getResources().getDimensionPixelSize(w.f.ds80) + this.dsH.getResources().getDimensionPixelSize(w.f.ds16) + this.dsH.getResources().getDimensionPixelSize(w.f.ds16);
        this.mListFooter = new View(this.dsH.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ib.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsK.d(aVar);
            mC(this.dsK.getItemLength());
            axq();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsK.f(aVar);
            mC(this.dsK.getItemLength());
            axq();
        }
    }

    private void axq() {
        if (this.dsK.getItemLength() > 0) {
            this.dsM.setEnabled(true);
        } else {
            this.dsM.setEnabled(false);
        }
    }

    public void axr() {
        com.baidu.adp.lib.util.k.b(this.dsH.getPageContext().getPageActivity(), this.dpg);
    }

    private void mC(int i) {
        this.dsM.setText(String.format(this.dsH.getPageContext().getString(w.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int axs() {
        return this.dsN;
    }

    public void mD(int i) {
        this.dsN = i;
        this.dsK.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dsK.e(aVar);
        }
    }

    public void onDestroy() {
        this.dpg.removeTextChangedListener(this.mTextWatcher);
    }
}
