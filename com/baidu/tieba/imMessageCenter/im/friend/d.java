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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private View aGK;
    private BdListView avm;
    private final InviteFriendListActivity eMM;
    private c eMN;
    private View eMO;
    private InviteFriendCandidateList eMP;
    private LinearLayout eMQ;
    private Button eMR;
    private int eMS;
    private boolean eMT;
    private TextView eMU;
    private View eMV;
    private View eMW;
    private TextView eMX;
    private ImageView eMY;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rE;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eMS = 0;
        this.eMM = inviteFriendListActivity;
        this.eMT = z;
        DS();
    }

    public View getRootView() {
        return this.aGK;
    }

    private void DS() {
        this.eMM.setContentView(d.h.invite_friend_list);
        this.aGK = this.eMM.findViewById(d.g.root_view);
        avQ();
        this.avm = (BdListView) this.aGK.findViewById(d.g.friend_list);
        this.avm.setOnItemClickListener(this.eMM);
        if (this.eMT) {
            this.mNoDataView = NoDataViewFactory.a(this.eMM.getPageContext().getPageActivity(), this.aGK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAS), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eMM.getPageContext().getPageActivity(), this.aGK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bAS), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.eMM.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aGK.findViewById(d.g.progress);
        this.eMP = (InviteFriendCandidateList) this.aGK.findViewById(d.g.candidate_list);
        this.eMP.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.avm.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eMQ = (LinearLayout) this.aGK.findViewById(d.g.invite_candidate);
        this.eMO = this.aGK.findViewById(d.g.invite_candidate_border);
        if (this.eMT) {
            this.eMQ.setVisibility(8);
            this.eMO.setVisibility(8);
        }
        aLE();
        this.eMR = (Button) this.aGK.findViewById(d.g.button_send);
        this.eMR.setOnClickListener(this.eMM);
        DT();
        aLw();
        qI(0);
    }

    private void avQ() {
        this.mNavigationBar = (NavigationBar) this.aGK.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eMV != null && d.this.eMV.getVisibility() == 0) {
                    d.this.aLx();
                    return;
                }
                l.a(d.this.eMM.getPageContext().getPageActivity(), d.this.rE);
                d.this.eMM.finish();
            }
        });
        if (this.eMT) {
            this.eMU = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eMU = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eMW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eMU.setVisibility(8);
                d.this.eMW.setVisibility(8);
                d.this.eMV.setVisibility(0);
                d.this.rE.requestFocus();
                l.b(d.this.eMM.getPageContext().getPageActivity(), d.this.rE);
            }
        });
        this.eMY = (ImageView) this.eMW.findViewById(d.g.new_friend_search);
        this.eMV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMV.setVisibility(8);
        this.rE = (EditText) this.eMV.findViewById(d.g.search_bar_edit);
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
                        d.this.eMX.setVisibility(0);
                    } else {
                        d.this.eMX.setVisibility(8);
                    }
                    d.this.aLv();
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
        this.eMX = (TextView) this.eMV.findViewById(d.g.search_bar_delete_button);
        this.eMX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rE.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLv() {
        if (this.eMM != null) {
            this.eMM.aLt();
        }
    }

    public void DT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eMM.getLayoutMode().aN(skinType == 1);
        this.eMM.getLayoutMode().aM(this.aGK);
        aj.a(this.eMY, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eMM.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eMM.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aLw() {
        this.avm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aLG();
                return false;
            }
        });
    }

    public void aLx() {
        l.a(this.eMM.getPageContext().getPageActivity(), this.rE);
        this.eMV.setVisibility(8);
        this.eMU.setVisibility(0);
        this.eMW.setVisibility(0);
        this.rE.getText().clear();
    }

    public boolean aLy() {
        return this.eMV != null && this.eMV.getVisibility() == 0;
    }

    public int aLz() {
        return this.eMR.getId();
    }

    public String aLA() {
        Editable text = this.rE.getText();
        return text != null ? text.toString() : "";
    }

    public String aLB() {
        return this.eMP.aLq();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eMN == null) {
            this.eMN = new c(this.eMM, this.eMT);
            this.eMN.a(this);
            this.eMN.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aLG();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aLH() <= d.this.eMP.getItemLength()) {
                                d.this.eMM.showToast(String.format(d.this.eMM.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eMS)));
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
            this.avm.setAdapter((ListAdapter) this.eMN);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.avm.setVisibility(8);
            if (!this.eMT) {
                this.eMQ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.avm.setVisibility(0);
        this.eMN.setData(list);
        this.eMN.notifyDataSetChanged();
        if (!this.eMT) {
            this.eMQ.setVisibility(0);
        }
    }

    public void aLC() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eMM.getPageContext());
        }
    }

    public void aLD() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aLE() {
        int dimensionPixelSize = this.eMM.getResources().getDimensionPixelSize(d.e.ds80) + this.eMM.getResources().getDimensionPixelSize(d.e.ds16) + this.eMM.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eMM.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.avm.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMP.d(aVar);
            qI(this.eMP.getItemLength());
            aLF();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMP.f(aVar);
            qI(this.eMP.getItemLength());
            aLF();
        }
    }

    private void aLF() {
        if (this.eMP.getItemLength() > 0) {
            this.eMR.setEnabled(true);
        } else {
            this.eMR.setEnabled(false);
        }
    }

    public void aLG() {
        l.a(this.eMM.getPageContext().getPageActivity(), this.rE);
    }

    private void qI(int i) {
        this.eMR.setText(String.format(this.eMM.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aLH() {
        return this.eMS;
    }

    public void qJ(int i) {
        this.eMS = i;
        this.eMP.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMP.e(aVar);
        }
    }

    public void onDestroy() {
        this.rE.removeTextChangedListener(this.mTextWatcher);
    }
}
