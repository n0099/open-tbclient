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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.im.friend.o;
import com.baidu.tieba.r;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.base.e<InviteFriendListActivity> implements o.b {
    private BdListView Bw;
    private View LW;
    private ProgressBar bkd;
    private EditText deH;
    private final InviteFriendListActivity dif;
    private o dig;
    private View dih;
    private InviteFriendCandidateList dii;
    private LinearLayout dij;
    private Button dik;
    private int dil;
    private boolean dim;
    private TextView din;
    private View dio;
    private View dip;
    private TextView diq;
    private ImageView dir;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.x mNoDataView;
    private TextWatcher mTextWatcher;

    public p(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dil = 0;
        this.dif = inviteFriendListActivity;
        this.dim = z;
        wr();
    }

    public View getRootView() {
        return this.LW;
    }

    private void wr() {
        this.dif.setContentView(r.j.invite_friend_list);
        this.LW = this.dif.findViewById(r.h.root_view);
        adO();
        this.Bw = (BdListView) this.LW.findViewById(r.h.friend_list);
        this.Bw.setOnItemClickListener(this.dif);
        if (this.dim) {
            this.mNoDataView = NoDataViewFactory.a(this.dif.getPageContext().getPageActivity(), this.LW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aDg), NoDataViewFactory.d.y(r.l.no_friends, r.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dif.getPageContext().getPageActivity(), this.LW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aDg), NoDataViewFactory.d.y(r.l.no_chat_friends, r.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.m9getInst().getResources().getString(r.l.find_new_friend), new q(this))));
        }
        this.bkd = (ProgressBar) this.LW.findViewById(r.h.progress);
        this.dii = (InviteFriendCandidateList) this.LW.findViewById(r.h.candidate_list);
        this.dii.a(new r(this));
        this.dij = (LinearLayout) this.LW.findViewById(r.h.invite_candidate);
        this.dih = this.LW.findViewById(r.h.invite_candidate_border);
        if (this.dim) {
            this.dij.setVisibility(8);
            this.dih.setVisibility(8);
        }
        avB();
        this.dik = (Button) this.LW.findViewById(r.h.button_send);
        this.dik.setOnClickListener(this.dif);
        ws();
        avt();
        mn(0);
    }

    private void adO() {
        this.mNavigationBar = (NavigationBar) this.LW.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new s(this));
        if (this.dim) {
            this.din = this.mNavigationBar.setTitleText(r.l.invite_contact_title);
        } else {
            this.din = this.mNavigationBar.setTitleText(r.l.invite_friend);
        }
        this.dip = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.add_new_friend_text, new t(this));
        this.dir = (ImageView) this.dip.findViewById(r.h.new_friend_search);
        this.dio = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, r.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dio.setVisibility(8);
        this.deH = (EditText) this.dio.findViewById(r.h.search_bar_edit);
        if (this.deH.getParent() != null) {
            ((View) this.deH.getParent()).setFocusable(true);
            ((View) this.deH.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new u(this);
        this.deH.addTextChangedListener(this.mTextWatcher);
        this.diq = (TextView) this.dio.findViewById(r.h.search_bar_delete_button);
        this.diq.setOnClickListener(new v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avs() {
        if (this.dif != null) {
            this.dif.avq();
        }
    }

    public void ws() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        this.dif.getLayoutMode().ai(skinType == 1);
        this.dif.getLayoutMode().v(this.LW);
        ap.b(this.dir, r.g.icon_search_bg_s, r.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dif.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dif.getPageContext(), skinType);
        ap.j(this.mListFooter, r.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void avt() {
        this.Bw.setOnTouchListener(new w(this));
    }

    public void avu() {
        com.baidu.adp.lib.util.k.b(this.dif.getPageContext().getPageActivity(), this.deH);
        this.dio.setVisibility(8);
        this.din.setVisibility(0);
        this.dip.setVisibility(0);
        this.deH.getText().clear();
    }

    public boolean avv() {
        return this.dio != null && this.dio.getVisibility() == 0;
    }

    public int avw() {
        return this.dik.getId();
    }

    public String avx() {
        Editable text = this.deH.getText();
        return text != null ? text.toString() : "";
    }

    public String avy() {
        return this.dii.avn();
    }

    public void i(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dig == null) {
            this.dig = new o(this.dif, this.dim);
            this.dig.a(this);
            this.dig.a(new x(this));
            this.Bw.setAdapter((ListAdapter) this.dig);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Bw.setVisibility(8);
            if (!this.dim) {
                this.dij.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Bw.setVisibility(0);
        this.dig.setData(list);
        this.dig.notifyDataSetChanged();
        if (!this.dim) {
            this.dij.setVisibility(0);
        }
    }

    public void avz() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dif.getPageContext());
        }
    }

    public void avA() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [387=4] */
    private void avB() {
        int dimensionPixelSize = this.dif.getResources().getDimensionPixelSize(r.f.ds80) + this.dif.getResources().getDimensionPixelSize(r.f.ds16) + this.dif.getResources().getDimensionPixelSize(r.f.ds16);
        this.mListFooter = new View(this.dif.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Bw.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dii.d(aVar);
            mn(this.dii.getItemLength());
            avC();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dii.f(aVar);
            mn(this.dii.getItemLength());
            avC();
        }
    }

    private void avC() {
        if (this.dii.getItemLength() > 0) {
            this.dik.setEnabled(true);
        } else {
            this.dik.setEnabled(false);
        }
    }

    public void avD() {
        com.baidu.adp.lib.util.k.b(this.dif.getPageContext().getPageActivity(), this.deH);
    }

    private void mn(int i) {
        this.dik.setText(String.format(this.dif.getPageContext().getString(r.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int avE() {
        return this.dil;
    }

    public void mo(int i) {
        this.dil = i;
        this.dii.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.o.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dii.e(aVar);
        }
    }

    public void onDestroy() {
        this.deH.removeTextChangedListener(this.mTextWatcher);
    }
}
