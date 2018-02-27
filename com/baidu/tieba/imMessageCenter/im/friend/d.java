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
    private View aHS;
    private BdListView auY;
    private final InviteFriendListActivity eQJ;
    private c eQK;
    private View eQL;
    private InviteFriendCandidateList eQM;
    private LinearLayout eQN;
    private Button eQO;
    private int eQP;
    private boolean eQQ;
    private TextView eQR;
    private View eQS;
    private View eQT;
    private TextView eQU;
    private ImageView eQV;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rD;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eQP = 0;
        this.eQJ = inviteFriendListActivity;
        this.eQQ = z;
        El();
    }

    public View getRootView() {
        return this.aHS;
    }

    private void El() {
        this.eQJ.setContentView(d.h.invite_friend_list);
        this.aHS = this.eQJ.findViewById(d.g.root_view);
        awM();
        this.auY = (BdListView) this.aHS.findViewById(d.g.friend_list);
        this.auY.setOnItemClickListener(this.eQJ);
        if (this.eQQ) {
            this.mNoDataView = NoDataViewFactory.a(this.eQJ.getPageContext().getPageActivity(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCJ), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eQJ.getPageContext().getPageActivity(), this.aHS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCJ), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eQJ.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aHS.findViewById(d.g.progress);
        this.eQM = (InviteFriendCandidateList) this.aHS.findViewById(d.g.candidate_list);
        this.eQM.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.auY.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eQN = (LinearLayout) this.aHS.findViewById(d.g.invite_candidate);
        this.eQL = this.aHS.findViewById(d.g.invite_candidate_border);
        if (this.eQQ) {
            this.eQN.setVisibility(8);
            this.eQL.setVisibility(8);
        }
        aNf();
        this.eQO = (Button) this.aHS.findViewById(d.g.button_send);
        this.eQO.setOnClickListener(this.eQJ);
        Em();
        aMX();
        qH(0);
    }

    private void awM() {
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eQS != null && d.this.eQS.getVisibility() == 0) {
                    d.this.aMY();
                    return;
                }
                l.a(d.this.eQJ.getPageContext().getPageActivity(), d.this.rD);
                d.this.eQJ.finish();
            }
        });
        if (this.eQQ) {
            this.eQR = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eQR = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eQT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eQR.setVisibility(8);
                d.this.eQT.setVisibility(8);
                d.this.eQS.setVisibility(0);
                d.this.rD.requestFocus();
                l.b(d.this.eQJ.getPageContext().getPageActivity(), d.this.rD);
            }
        });
        this.eQV = (ImageView) this.eQT.findViewById(d.g.new_friend_search);
        this.eQS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eQS.setVisibility(8);
        this.rD = (EditText) this.eQS.findViewById(d.g.search_bar_edit);
        if (this.rD.getParent() != null) {
            ((View) this.rD.getParent()).setFocusable(true);
            ((View) this.rD.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eQU.setVisibility(0);
                    } else {
                        d.this.eQU.setVisibility(8);
                    }
                    d.this.aMW();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.rD.addTextChangedListener(this.mTextWatcher);
        this.eQU = (TextView) this.eQS.findViewById(d.g.search_bar_delete_button);
        this.eQU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rD.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMW() {
        if (this.eQJ != null) {
            this.eQJ.aMU();
        }
    }

    public void Em() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQJ.getLayoutMode().aQ(skinType == 1);
        this.eQJ.getLayoutMode().aM(this.aHS);
        aj.a(this.eQV, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eQJ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQJ.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aMX() {
        this.auY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aNh();
                return false;
            }
        });
    }

    public void aMY() {
        l.a(this.eQJ.getPageContext().getPageActivity(), this.rD);
        this.eQS.setVisibility(8);
        this.eQR.setVisibility(0);
        this.eQT.setVisibility(0);
        this.rD.getText().clear();
    }

    public boolean aMZ() {
        return this.eQS != null && this.eQS.getVisibility() == 0;
    }

    public int aNa() {
        return this.eQO.getId();
    }

    public String aNb() {
        Editable text = this.rD.getText();
        return text != null ? text.toString() : "";
    }

    public String aNc() {
        return this.eQM.aMR();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eQK == null) {
            this.eQK = new c(this.eQJ, this.eQQ);
            this.eQK.a(this);
            this.eQK.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aNh();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aNi() <= d.this.eQM.getItemLength()) {
                                d.this.eQJ.showToast(String.format(d.this.eQJ.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eQP)));
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
            this.auY.setAdapter((ListAdapter) this.eQK);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.auY.setVisibility(8);
            if (!this.eQQ) {
                this.eQN.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.auY.setVisibility(0);
        this.eQK.setData(list);
        this.eQK.notifyDataSetChanged();
        if (!this.eQQ) {
            this.eQN.setVisibility(0);
        }
    }

    public void aNd() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eQJ.getPageContext());
        }
    }

    public void aNe() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aNf() {
        int dimensionPixelSize = this.eQJ.getResources().getDimensionPixelSize(d.e.ds80) + this.eQJ.getResources().getDimensionPixelSize(d.e.ds16) + this.eQJ.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eQJ.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.auY.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQM.d(aVar);
            qH(this.eQM.getItemLength());
            aNg();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQM.f(aVar);
            qH(this.eQM.getItemLength());
            aNg();
        }
    }

    private void aNg() {
        if (this.eQM.getItemLength() > 0) {
            this.eQO.setEnabled(true);
        } else {
            this.eQO.setEnabled(false);
        }
    }

    public void aNh() {
        l.a(this.eQJ.getPageContext().getPageActivity(), this.rD);
    }

    private void qH(int i) {
        this.eQO.setText(String.format(this.eQJ.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aNi() {
        return this.eQP;
    }

    public void qI(int i) {
        this.eQP = i;
        this.eQM.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eQM.e(aVar);
        }
    }

    public void onDestroy() {
        this.rD.removeTextChangedListener(this.mTextWatcher);
    }
}
