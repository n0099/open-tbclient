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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView LO;
    private View aaV;
    private boolean eFA;
    private TextView eFB;
    private View eFC;
    private View eFD;
    private TextView eFE;
    private ImageView eFF;
    private final InviteFriendListActivity eFt;
    private c eFu;
    private View eFv;
    private InviteFriendCandidateList eFw;
    private LinearLayout eFx;
    private Button eFy;
    private int eFz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eFz = 0;
        this.eFt = inviteFriendListActivity;
        this.eFA = z;
        AF();
    }

    public View getRootView() {
        return this.aaV;
    }

    private void AF() {
        this.eFt.setContentView(d.h.invite_friend_list);
        this.aaV = this.eFt.findViewById(d.g.root_view);
        asl();
        this.LO = (BdListView) this.aaV.findViewById(d.g.friend_list);
        this.LO.setOnItemClickListener(this.eFt);
        if (this.eFA) {
            this.mNoDataView = NoDataViewFactory.a(this.eFt.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.E(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eFt.getPageContext().getPageActivity(), this.aaV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.E(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eFt.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aaV.findViewById(d.g.progress);
        this.eFw = (InviteFriendCandidateList) this.aaV.findViewById(d.g.candidate_list);
        this.eFw.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.LO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eFx = (LinearLayout) this.aaV.findViewById(d.g.invite_candidate);
        this.eFv = this.aaV.findViewById(d.g.invite_candidate_border);
        if (this.eFA) {
            this.eFx.setVisibility(8);
            this.eFv.setVisibility(8);
        }
        aOA();
        this.eFy = (Button) this.aaV.findViewById(d.g.button_send);
        this.eFy.setOnClickListener(this.eFt);
        AG();
        aOs();
        oI(0);
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.aaV.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eFC != null && d.this.eFC.getVisibility() == 0) {
                    d.this.aOt();
                    return;
                }
                l.a(d.this.eFt.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eFt.finish();
            }
        });
        if (this.eFA) {
            this.eFB = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eFB = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eFD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eFB.setVisibility(8);
                d.this.eFD.setVisibility(8);
                d.this.eFC.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.b(d.this.eFt.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eFF = (ImageView) this.eFD.findViewById(d.g.new_friend_search);
        this.eFC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eFC.setVisibility(8);
        this.mEditText = (EditText) this.eFC.findViewById(d.g.search_bar_edit);
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
                        d.this.eFE.setVisibility(0);
                    } else {
                        d.this.eFE.setVisibility(8);
                    }
                    d.this.aOr();
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
        this.eFE = (TextView) this.eFC.findViewById(d.g.search_bar_delete_button);
        this.eFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOr() {
        if (this.eFt != null) {
            this.eFt.aOp();
        }
    }

    public void AG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eFt.getLayoutMode().setNightMode(skinType == 1);
        this.eFt.getLayoutMode().onModeChanged(this.aaV);
        am.a(this.eFF, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eFt.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eFt.getPageContext(), skinType);
        am.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aOs() {
        this.LO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aOC();
                return false;
            }
        });
    }

    public void aOt() {
        l.a(this.eFt.getPageContext().getPageActivity(), this.mEditText);
        this.eFC.setVisibility(8);
        this.eFB.setVisibility(0);
        this.eFD.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aOu() {
        return this.eFC != null && this.eFC.getVisibility() == 0;
    }

    public int aOv() {
        return this.eFy.getId();
    }

    public String aOw() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aOx() {
        return this.eFw.aOm();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eFu == null) {
            this.eFu = new c(this.eFt, this.eFA);
            this.eFu.a(this);
            this.eFu.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aOC();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aOD() <= d.this.eFw.getItemLength()) {
                                d.this.eFt.showToast(String.format(d.this.eFt.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eFz)));
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
            this.LO.setAdapter((ListAdapter) this.eFu);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.LO.setVisibility(8);
            if (!this.eFA) {
                this.eFx.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.LO.setVisibility(0);
        this.eFu.setData(list);
        this.eFu.notifyDataSetChanged();
        if (!this.eFA) {
            this.eFx.setVisibility(0);
        }
    }

    public void aOy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eFt.getPageContext());
        }
    }

    public void aOz() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aOA() {
        int dimensionPixelSize = this.eFt.getResources().getDimensionPixelSize(d.e.ds80) + this.eFt.getResources().getDimensionPixelSize(d.e.ds16) + this.eFt.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eFt.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.LO.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFw.d(aVar);
            oI(this.eFw.getItemLength());
            aOB();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFw.f(aVar);
            oI(this.eFw.getItemLength());
            aOB();
        }
    }

    private void aOB() {
        if (this.eFw.getItemLength() > 0) {
            this.eFy.setEnabled(true);
        } else {
            this.eFy.setEnabled(false);
        }
    }

    public void aOC() {
        l.a(this.eFt.getPageContext().getPageActivity(), this.mEditText);
    }

    private void oI(int i) {
        this.eFy.setText(String.format(this.eFt.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aOD() {
        return this.eFz;
    }

    public void oJ(int i) {
        this.eFz = i;
        this.eFw.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFw.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
