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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.f<InviteFriendListActivity> implements o.b {
    private BdListView Cj;
    private View MM;
    private TextWatcher aVs;
    private ProgressBar cub;
    private EditText dsz;
    private final InviteFriendListActivity dxT;
    private o dxU;
    private View dxV;
    private InviteFriendCandidateList dxW;
    private LinearLayout dxX;
    private Button dxY;
    private int dxZ;
    private boolean dya;
    private TextView dyb;
    private View dyc;
    private View dyd;
    private TextView dye;
    private ImageView dyf;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.w mNoDataView;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dxZ = 0;
        this.dxT = inviteFriendListActivity;
        this.dya = z;
        initialize();
    }

    public View getRootView() {
        return this.MM;
    }

    private void initialize() {
        this.dxT.setContentView(r.h.invite_friend_list);
        this.MM = this.dxT.findViewById(r.g.root_view);
        WB();
        this.Cj = (BdListView) this.MM.findViewById(r.g.friend_list);
        this.Cj.setOnItemClickListener(this.dxT);
        if (this.dya) {
            this.mNoDataView = NoDataViewFactory.a(this.dxT.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEW), NoDataViewFactory.d.x(r.j.no_friends, r.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dxT.getPageContext().getPageActivity(), this.MM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aEW), NoDataViewFactory.d.x(r.j.no_chat_friends, r.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(r.j.find_new_friend), new q(this))));
        }
        this.cub = (ProgressBar) this.MM.findViewById(r.g.progress);
        this.dxW = (InviteFriendCandidateList) this.MM.findViewById(r.g.candidate_list);
        this.dxW.a(new r(this));
        this.dxX = (LinearLayout) this.MM.findViewById(r.g.invite_candidate);
        this.dxV = this.MM.findViewById(r.g.invite_candidate_border);
        if (this.dya) {
            this.dxX.setVisibility(8);
            this.dxV.setVisibility(8);
        }
        aAY();
        this.dxY = (Button) this.MM.findViewById(r.g.button_send);
        this.dxY.setOnClickListener(this.dxT);
        wM();
        aAR();
        mx(0);
    }

    private void WB() {
        this.mNavigationBar = (NavigationBar) this.MM.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dya) {
            this.dyb = this.mNavigationBar.setTitleText(r.j.invite_contact_title);
        } else {
            this.dyb = this.mNavigationBar.setTitleText(r.j.invite_friend);
        }
        this.dyd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.add_new_friend_text, new t(this));
        this.dyf = (ImageView) this.dyd.findViewById(r.g.new_friend_search);
        this.dyc = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dyc.setVisibility(8);
        this.dsz = (EditText) this.dyc.findViewById(r.g.search_bar_edit);
        if (this.dsz.getParent() != null) {
            ((View) this.dsz.getParent()).setFocusable(true);
            ((View) this.dsz.getParent()).setFocusableInTouchMode(true);
        }
        this.aVs = new u(this);
        this.dsz.addTextChangedListener(this.aVs);
        this.dye = (TextView) this.dyc.findViewById(r.g.search_bar_delete_button);
        this.dye.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAQ() {
        if (this.dxT != null) {
            this.dxT.aAO();
        }
    }

    public void wM() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dxT.getLayoutMode().ai(skinType == 1);
        this.dxT.getLayoutMode().x(this.MM);
        at.b(this.dyf, r.f.icon_search_bg_s, r.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dxT.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dxT.getPageContext(), skinType);
        at.k(this.mListFooter, r.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aAR() {
        this.Cj.setOnTouchListener(new w(this));
    }

    public void aAS() {
        com.baidu.adp.lib.util.k.b(this.dxT.getPageContext().getPageActivity(), this.dsz);
        this.dyc.setVisibility(8);
        this.dyb.setVisibility(0);
        this.dyd.setVisibility(0);
        this.dsz.getText().clear();
    }

    public boolean aAT() {
        return this.dyc != null && this.dyc.getVisibility() == 0;
    }

    public int aAU() {
        return this.dxY.getId();
    }

    public String getSearchText() {
        Editable text = this.dsz.getText();
        return text != null ? text.toString() : "";
    }

    public String aAV() {
        return this.dxW.aAL();
    }

    public void g(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dxU == null) {
            this.dxU = new o(this.dxT, this.dya);
            this.dxU.a(this);
            this.dxU.a(new x(this));
            this.Cj.setAdapter((ListAdapter) this.dxU);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Cj.setVisibility(8);
            if (!this.dya) {
                this.dxX.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Cj.setVisibility(0);
        this.dxU.setData(list);
        this.dxU.notifyDataSetChanged();
        if (!this.dya) {
            this.dxX.setVisibility(0);
        }
    }

    public void aAW() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dxT.getPageContext());
        }
    }

    public void aAX() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void aAY() {
        int dimensionPixelSize = this.dxT.getResources().getDimensionPixelSize(r.e.ds80) + this.dxT.getResources().getDimensionPixelSize(r.e.ds16) + this.dxT.getResources().getDimensionPixelSize(r.e.ds16);
        this.mListFooter = new View(this.dxT.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Cj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dxW.d(aVar);
            mx(this.dxW.getItemLength());
            aAZ();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dxW.f(aVar);
            mx(this.dxW.getItemLength());
            aAZ();
        }
    }

    private void aAZ() {
        if (this.dxW.getItemLength() > 0) {
            this.dxY.setEnabled(true);
        } else {
            this.dxY.setEnabled(false);
        }
    }

    public void aBa() {
        com.baidu.adp.lib.util.k.b(this.dxT.getPageContext().getPageActivity(), this.dsz);
    }

    private void mx(int i) {
        this.dxY.setText(String.format(this.dxT.getPageContext().getString(r.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aBb() {
        return this.dxZ;
    }

    public void my(int i) {
        this.dxZ = i;
        this.dxW.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dxW.e(aVar);
        }
    }

    public void onDestroy() {
        this.dsz.removeTextChangedListener(this.aVs);
    }
}
