package com.baidu.tieba.imMessageCenter.im.friend;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private View aGJ;
    private BdListView avk;
    private final InviteFriendListActivity eKR;
    private c eKS;
    private View eKT;
    private InviteFriendCandidateList eKU;
    private LinearLayout eKV;
    private Button eKW;
    private int eKX;
    private boolean eKY;
    private TextView eKZ;
    private View eLa;
    private View eLb;
    private TextView eLc;
    private ImageView eLd;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rE;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eKX = 0;
        this.eKR = inviteFriendListActivity;
        this.eKY = z;
        DZ();
    }

    public View getRootView() {
        return this.aGJ;
    }

    private void DZ() {
        this.eKR.setContentView(d.h.invite_friend_list);
        this.aGJ = this.eKR.findViewById(d.g.root_view);
        auI();
        this.avk = (BdListView) this.aGJ.findViewById(d.g.friend_list);
        this.avk.setOnItemClickListener(this.eKR);
        if (this.eKY) {
            this.mNoDataView = NoDataViewFactory.a(this.eKR.getPageContext().getPageActivity(), this.aGJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAB), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eKR.getPageContext().getPageActivity(), this.aGJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAB), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.eKR.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aGJ.findViewById(d.g.progress);
        this.eKU = (InviteFriendCandidateList) this.aGJ.findViewById(d.g.candidate_list);
        this.eKU.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.avk.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eKV = (LinearLayout) this.aGJ.findViewById(d.g.invite_candidate);
        this.eKT = this.aGJ.findViewById(d.g.invite_candidate_border);
        if (this.eKY) {
            this.eKV.setVisibility(8);
            this.eKT.setVisibility(8);
        }
        aLu();
        this.eKW = (Button) this.aGJ.findViewById(d.g.button_send);
        this.eKW.setOnClickListener(this.eKR);
        Ea();
        aLm();
        qP(0);
    }

    private void auI() {
        this.mNavigationBar = (NavigationBar) this.aGJ.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eLa != null && d.this.eLa.getVisibility() == 0) {
                    d.this.aLn();
                    return;
                }
                l.a(d.this.eKR.getPageContext().getPageActivity(), d.this.rE);
                d.this.eKR.finish();
            }
        });
        if (this.eKY) {
            this.eKZ = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eKZ = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eLb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eKZ.setVisibility(8);
                d.this.eLb.setVisibility(8);
                d.this.eLa.setVisibility(0);
                d.this.rE.requestFocus();
                l.b(d.this.eKR.getPageContext().getPageActivity(), d.this.rE);
            }
        });
        this.eLd = (ImageView) this.eLb.findViewById(d.g.new_friend_search);
        this.eLa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eLa.setVisibility(8);
        this.rE = (EditText) this.eLa.findViewById(d.g.search_bar_edit);
        if (this.rE.getParent() != null) {
            ((View) this.rE.getParent()).setFocusable(true);
            ((View) this.rE.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eLc.setVisibility(0);
                    } else {
                        d.this.eLc.setVisibility(8);
                    }
                    d.this.aLl();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.rE.addTextChangedListener(this.mTextWatcher);
        this.eLc = (TextView) this.eLa.findViewById(d.g.search_bar_delete_button);
        this.eLc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rE.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLl() {
        if (this.eKR != null) {
            this.eKR.aLj();
        }
    }

    public void Ea() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eKR.getLayoutMode().aM(skinType == 1);
        this.eKR.getLayoutMode().aM(this.aGJ);
        aj.a(this.eLd, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eKR.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eKR.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aLm() {
        this.avk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aLw();
                return false;
            }
        });
    }

    public void aLn() {
        l.a(this.eKR.getPageContext().getPageActivity(), this.rE);
        this.eLa.setVisibility(8);
        this.eKZ.setVisibility(0);
        this.eLb.setVisibility(0);
        this.rE.getText().clear();
    }

    public boolean aLo() {
        return this.eLa != null && this.eLa.getVisibility() == 0;
    }

    public int aLp() {
        return this.eKW.getId();
    }

    public String aLq() {
        Editable text = this.rE.getText();
        return text != null ? text.toString() : "";
    }

    public String aLr() {
        return this.eKU.aLg();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eKS == null) {
            this.eKS = new c(this.eKR, this.eKY);
            this.eKS.a(this);
            this.eKS.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aLw();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aLx() <= d.this.eKU.getItemLength()) {
                                d.this.eKR.showToast(String.format(d.this.eKR.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eKX)));
                                tbCheckBox.setChecked(false);
                                ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                                return;
                            }
                            d.this.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                            return;
                        }
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            });
            this.avk.setAdapter((ListAdapter) this.eKS);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.avk.setVisibility(8);
            if (!this.eKY) {
                this.eKV.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.avk.setVisibility(0);
        this.eKS.setData(list);
        this.eKS.notifyDataSetChanged();
        if (!this.eKY) {
            this.eKV.setVisibility(0);
        }
    }

    public void aLs() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eKR.getPageContext());
        }
    }

    public void aLt() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aLu() {
        int dimensionPixelSize = this.eKR.getResources().getDimensionPixelSize(d.e.ds80) + this.eKR.getResources().getDimensionPixelSize(d.e.ds16) + this.eKR.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eKR.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.avk.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eKU.d(aVar);
            qP(this.eKU.getItemLength());
            aLv();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eKU.f(aVar);
            qP(this.eKU.getItemLength());
            aLv();
        }
    }

    private void aLv() {
        if (this.eKU.getItemLength() > 0) {
            this.eKW.setEnabled(true);
        } else {
            this.eKW.setEnabled(false);
        }
    }

    public void aLw() {
        l.a(this.eKR.getPageContext().getPageActivity(), this.rE);
    }

    private void qP(int i) {
        this.eKW.setText(String.format(this.eKR.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aLx() {
        return this.eKX;
    }

    public void qQ(int i) {
        this.eKX = i;
        this.eKU.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eKU.e(aVar);
        }
    }

    public void onDestroy() {
        this.rE.removeTextChangedListener(this.mTextWatcher);
    }
}
