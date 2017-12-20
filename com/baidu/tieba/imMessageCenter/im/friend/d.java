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
    private BdListView Hh;
    private View Se;
    private EditText dVi;
    private final InviteFriendListActivity dYK;
    private c dYL;
    private View dYM;
    private InviteFriendCandidateList dYN;
    private LinearLayout dYO;
    private Button dYP;
    private int dYQ;
    private boolean dYR;
    private TextView dYS;
    private View dYT;
    private View dYU;
    private TextView dYV;
    private ImageView dYW;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private g mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dYQ = 0;
        this.dYK = inviteFriendListActivity;
        this.dYR = z;
        wB();
    }

    public View getRootView() {
        return this.Se;
    }

    private void wB() {
        this.dYK.setContentView(d.h.invite_friend_list);
        this.Se = this.dYK.findViewById(d.g.root_view);
        ana();
        this.Hh = (BdListView) this.Se.findViewById(d.g.friend_list);
        this.Hh.setOnItemClickListener(this.dYK);
        if (this.dYR) {
            this.mNoDataView = NoDataViewFactory.a(this.dYK.getPageContext().getPageActivity(), this.Se, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aML), NoDataViewFactory.d.D(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dYK.getPageContext().getPageActivity(), this.Se, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aML), NoDataViewFactory.d.D(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dYK.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Se.findViewById(d.g.progress);
        this.dYN = (InviteFriendCandidateList) this.Se.findViewById(d.g.candidate_list);
        this.dYN.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Hh.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dYO = (LinearLayout) this.Se.findViewById(d.g.invite_candidate);
        this.dYM = this.Se.findViewById(d.g.invite_candidate_border);
        if (this.dYR) {
            this.dYO.setVisibility(8);
            this.dYM.setVisibility(8);
        }
        aEs();
        this.dYP = (Button) this.Se.findViewById(d.g.button_send);
        this.dYP.setOnClickListener(this.dYK);
        wC();
        aEk();
        nX(0);
    }

    private void ana() {
        this.mNavigationBar = (NavigationBar) this.Se.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dYT != null && d.this.dYT.getVisibility() == 0) {
                    d.this.aEl();
                    return;
                }
                l.a(d.this.dYK.getPageContext().getPageActivity(), d.this.dVi);
                d.this.dYK.finish();
            }
        });
        if (this.dYR) {
            this.dYS = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.dYS = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.dYU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dYS.setVisibility(8);
                d.this.dYU.setVisibility(8);
                d.this.dYT.setVisibility(0);
                d.this.dVi.requestFocus();
                l.b(d.this.dYK.getPageContext().getPageActivity(), d.this.dVi);
            }
        });
        this.dYW = (ImageView) this.dYU.findViewById(d.g.new_friend_search);
        this.dYT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.dYT.setVisibility(8);
        this.dVi = (EditText) this.dYT.findViewById(d.g.search_bar_edit);
        if (this.dVi.getParent() != null) {
            ((View) this.dVi.getParent()).setFocusable(true);
            ((View) this.dVi.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dYV.setVisibility(0);
                    } else {
                        d.this.dYV.setVisibility(8);
                    }
                    d.this.aEj();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dVi.addTextChangedListener(this.mTextWatcher);
        this.dYV = (TextView) this.dYT.findViewById(d.g.search_bar_delete_button);
        this.dYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dVi.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEj() {
        if (this.dYK != null) {
            this.dYK.aEh();
        }
    }

    public void wC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dYK.getLayoutMode().ag(skinType == 1);
        this.dYK.getLayoutMode().t(this.Se);
        aj.a(this.dYW, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dYK.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dYK.getPageContext(), skinType);
        aj.j(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aEk() {
        this.Hh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aEu();
                return false;
            }
        });
    }

    public void aEl() {
        l.a(this.dYK.getPageContext().getPageActivity(), this.dVi);
        this.dYT.setVisibility(8);
        this.dYS.setVisibility(0);
        this.dYU.setVisibility(0);
        this.dVi.getText().clear();
    }

    public boolean aEm() {
        return this.dYT != null && this.dYT.getVisibility() == 0;
    }

    public int aEn() {
        return this.dYP.getId();
    }

    public String aEo() {
        Editable text = this.dVi.getText();
        return text != null ? text.toString() : "";
    }

    public String aEp() {
        return this.dYN.aEe();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dYL == null) {
            this.dYL = new c(this.dYK, this.dYR);
            this.dYL.a(this);
            this.dYL.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aEu();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aEv() <= d.this.dYN.getItemLength()) {
                                d.this.dYK.showToast(String.format(d.this.dYK.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.dYQ)));
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
            this.Hh.setAdapter((ListAdapter) this.dYL);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hh.setVisibility(8);
            if (!this.dYR) {
                this.dYO.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hh.setVisibility(0);
        this.dYL.setData(list);
        this.dYL.notifyDataSetChanged();
        if (!this.dYR) {
            this.dYO.setVisibility(0);
        }
    }

    public void aEq() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dYK.getPageContext());
        }
    }

    public void aEr() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aEs() {
        int dimensionPixelSize = this.dYK.getResources().getDimensionPixelSize(d.e.ds80) + this.dYK.getResources().getDimensionPixelSize(d.e.ds16) + this.dYK.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.dYK.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hh.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYN.d(aVar);
            nX(this.dYN.getItemLength());
            aEt();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYN.f(aVar);
            nX(this.dYN.getItemLength());
            aEt();
        }
    }

    private void aEt() {
        if (this.dYN.getItemLength() > 0) {
            this.dYP.setEnabled(true);
        } else {
            this.dYP.setEnabled(false);
        }
    }

    public void aEu() {
        l.a(this.dYK.getPageContext().getPageActivity(), this.dVi);
    }

    private void nX(int i) {
        this.dYP.setText(String.format(this.dYK.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aEv() {
        return this.dYQ;
    }

    public void nY(int i) {
        this.dYQ = i;
        this.dYN.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dYN.e(aVar);
        }
    }

    public void onDestroy() {
        this.dVi.removeTextChangedListener(this.mTextWatcher);
    }
}
