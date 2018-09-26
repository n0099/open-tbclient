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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Op;
    private View adA;
    private final InviteFriendListActivity eMF;
    private c eMG;
    private View eMH;
    private InviteFriendCandidateList eMI;
    private LinearLayout eMJ;
    private Button eMK;
    private int eML;
    private boolean eMM;
    private TextView eMN;
    private View eMO;
    private View eMP;
    private TextView eMQ;
    private ImageView eMR;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eML = 0;
        this.eMF = inviteFriendListActivity;
        this.eMM = z;
        BP();
    }

    public View getRootView() {
        return this.adA;
    }

    private void BP() {
        this.eMF.setContentView(e.h.invite_friend_list);
        this.adA = this.eMF.findViewById(e.g.root_view);
        atZ();
        this.Op = (BdListView) this.adA.findViewById(e.g.friend_list);
        this.Op.setOnItemClickListener(this.eMF);
        if (this.eMM) {
            this.mNoDataView = NoDataViewFactory.a(this.eMF.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aZy), NoDataViewFactory.d.G(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eMF.getPageContext().getPageActivity(), this.adA, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aZy), NoDataViewFactory.d.G(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eMF.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.adA.findViewById(e.g.progress);
        this.eMI = (InviteFriendCandidateList) this.adA.findViewById(e.g.candidate_list);
        this.eMI.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Op.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eMJ = (LinearLayout) this.adA.findViewById(e.g.invite_candidate);
        this.eMH = this.adA.findViewById(e.g.invite_candidate_border);
        if (this.eMM) {
            this.eMJ.setVisibility(8);
            this.eMH.setVisibility(8);
        }
        aQM();
        this.eMK = (Button) this.adA.findViewById(e.g.button_send);
        this.eMK.setOnClickListener(this.eMF);
        BQ();
        aQE();
        pm(0);
    }

    private void atZ() {
        this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eMO != null && d.this.eMO.getVisibility() == 0) {
                    d.this.aQF();
                    return;
                }
                l.a(d.this.eMF.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eMF.finish();
            }
        });
        if (this.eMM) {
            this.eMN = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.eMN = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.eMP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eMN.setVisibility(8);
                d.this.eMP.setVisibility(8);
                d.this.eMO.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.b(d.this.eMF.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eMR = (ImageView) this.eMP.findViewById(e.g.new_friend_search);
        this.eMO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eMO.setVisibility(8);
        this.mEditText = (EditText) this.eMO.findViewById(e.g.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eMQ.setVisibility(0);
                    } else {
                        d.this.eMQ.setVisibility(8);
                    }
                    d.this.aQD();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.mEditText.addTextChangedListener(this.mTextWatcher);
        this.eMQ = (TextView) this.eMO.findViewById(e.g.search_bar_delete_button);
        this.eMQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        if (this.eMF != null) {
            this.eMF.aQB();
        }
    }

    public void BQ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eMF.getLayoutMode().setNightMode(skinType == 1);
        this.eMF.getLayoutMode().onModeChanged(this.adA);
        al.a(this.eMR, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eMF.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eMF.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aQE() {
        this.Op.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aQO();
                return false;
            }
        });
    }

    public void aQF() {
        l.a(this.eMF.getPageContext().getPageActivity(), this.mEditText);
        this.eMO.setVisibility(8);
        this.eMN.setVisibility(0);
        this.eMP.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aQG() {
        return this.eMO != null && this.eMO.getVisibility() == 0;
    }

    public int aQH() {
        return this.eMK.getId();
    }

    public String aQI() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aQJ() {
        return this.eMI.aQy();
    }

    public void l(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eMG == null) {
            this.eMG = new c(this.eMF, this.eMM);
            this.eMG.a(this);
            this.eMG.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aQO();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aQP() <= d.this.eMI.getItemLength()) {
                                d.this.eMF.showToast(String.format(d.this.eMF.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eML)));
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
            this.Op.setAdapter((ListAdapter) this.eMG);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Op.setVisibility(8);
            if (!this.eMM) {
                this.eMJ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Op.setVisibility(0);
        this.eMG.setData(list);
        this.eMG.notifyDataSetChanged();
        if (!this.eMM) {
            this.eMJ.setVisibility(0);
        }
    }

    public void aQK() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eMF.getPageContext());
        }
    }

    public void aQL() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aQM() {
        int dimensionPixelSize = this.eMF.getResources().getDimensionPixelSize(e.C0141e.ds80) + this.eMF.getResources().getDimensionPixelSize(e.C0141e.ds16) + this.eMF.getResources().getDimensionPixelSize(e.C0141e.ds16);
        this.mListFooter = new View(this.eMF.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Op.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMI.d(aVar);
            pm(this.eMI.getItemLength());
            aQN();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMI.f(aVar);
            pm(this.eMI.getItemLength());
            aQN();
        }
    }

    private void aQN() {
        if (this.eMI.getItemLength() > 0) {
            this.eMK.setEnabled(true);
        } else {
            this.eMK.setEnabled(false);
        }
    }

    public void aQO() {
        l.a(this.eMF.getPageContext().getPageActivity(), this.mEditText);
    }

    private void pm(int i) {
        this.eMK.setText(String.format(this.eMF.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aQP() {
        return this.eML;
    }

    public void pn(int i) {
        this.eML = i;
        this.eMI.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eMI.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
