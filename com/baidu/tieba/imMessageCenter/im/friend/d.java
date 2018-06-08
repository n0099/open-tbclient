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
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView LQ;
    private View abp;
    private final InviteFriendListActivity exJ;
    private c exK;
    private View exL;
    private InviteFriendCandidateList exM;
    private LinearLayout exN;
    private Button exO;
    private int exP;
    private boolean exQ;
    private TextView exR;
    private View exS;
    private View exT;
    private TextView exU;
    private ImageView exV;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.exP = 0;
        this.exJ = inviteFriendListActivity;
        this.exQ = z;
        initialize();
    }

    public View getRootView() {
        return this.abp;
    }

    private void initialize() {
        this.exJ.setContentView(d.i.invite_friend_list);
        this.abp = this.exJ.findViewById(d.g.root_view);
        avi();
        this.LQ = (BdListView) this.abp.findViewById(d.g.friend_list);
        this.LQ.setOnItemClickListener(this.exJ);
        if (this.exQ) {
            this.mNoDataView = NoDataViewFactory.a(this.exJ.getPageContext().getPageActivity(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aVl), NoDataViewFactory.d.D(d.k.no_friends, d.k.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.exJ.getPageContext().getPageActivity(), this.abp, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aVl), NoDataViewFactory.d.D(d.k.no_chat_friends, d.k.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.k.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.exJ.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.abp.findViewById(d.g.progress);
        this.exM = (InviteFriendCandidateList) this.abp.findViewById(d.g.candidate_list);
        this.exM.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.LQ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.exN = (LinearLayout) this.abp.findViewById(d.g.invite_candidate);
        this.exL = this.abp.findViewById(d.g.invite_candidate_border);
        if (this.exQ) {
            this.exN.setVisibility(8);
            this.exL.setVisibility(8);
        }
        aMU();
        this.exO = (Button) this.abp.findViewById(d.g.button_send);
        this.exO.setOnClickListener(this.exJ);
        Ay();
        aMM();
        on(0);
    }

    private void avi() {
        this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.exS != null && d.this.exS.getVisibility() == 0) {
                    d.this.aMN();
                    return;
                }
                l.b(d.this.exJ.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.exJ.finish();
            }
        });
        if (this.exQ) {
            this.exR = this.mNavigationBar.setTitleText(d.k.invite_contact_title);
        } else {
            this.exR = this.mNavigationBar.setTitleText(d.k.invite_friend);
        }
        this.exT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.exR.setVisibility(8);
                d.this.exT.setVisibility(8);
                d.this.exS.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.exJ.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.exV = (ImageView) this.exT.findViewById(d.g.new_friend_search);
        this.exS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.exS.setVisibility(8);
        this.mEditText = (EditText) this.exS.findViewById(d.g.search_bar_edit);
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
                        d.this.exU.setVisibility(0);
                    } else {
                        d.this.exU.setVisibility(8);
                    }
                    d.this.aML();
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
        this.exU = (TextView) this.exS.findViewById(d.g.search_bar_delete_button);
        this.exU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aML() {
        if (this.exJ != null) {
            this.exJ.aMJ();
        }
    }

    public void Ay() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.exJ.getLayoutMode().setNightMode(skinType == 1);
        this.exJ.getLayoutMode().onModeChanged(this.abp);
        al.a(this.exV, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.exJ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.exJ.getPageContext(), skinType);
        al.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aMM() {
        this.LQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aMW();
                return false;
            }
        });
    }

    public void aMN() {
        l.b(this.exJ.getPageContext().getPageActivity(), this.mEditText);
        this.exS.setVisibility(8);
        this.exR.setVisibility(0);
        this.exT.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aMO() {
        return this.exS != null && this.exS.getVisibility() == 0;
    }

    public int aMP() {
        return this.exO.getId();
    }

    public String aMQ() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aMR() {
        return this.exM.aMG();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.exK == null) {
            this.exK = new c(this.exJ, this.exQ);
            this.exK.a(this);
            this.exK.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aMW();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aMX() <= d.this.exM.getItemLength()) {
                                d.this.exJ.showToast(String.format(d.this.exJ.getPageContext().getString(d.k.invite_friend_exceed_max_count), Integer.valueOf(d.this.exP)));
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
            this.LQ.setAdapter((ListAdapter) this.exK);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.LQ.setVisibility(8);
            if (!this.exQ) {
                this.exN.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.LQ.setVisibility(0);
        this.exK.setData(list);
        this.exK.notifyDataSetChanged();
        if (!this.exQ) {
            this.exN.setVisibility(0);
        }
    }

    public void aMS() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.exJ.getPageContext());
        }
    }

    public void aMT() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aMU() {
        int dimensionPixelSize = this.exJ.getResources().getDimensionPixelSize(d.e.ds80) + this.exJ.getResources().getDimensionPixelSize(d.e.ds16) + this.exJ.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.exJ.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.LQ.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.exM.d(aVar);
            on(this.exM.getItemLength());
            aMV();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.exM.f(aVar);
            on(this.exM.getItemLength());
            aMV();
        }
    }

    private void aMV() {
        if (this.exM.getItemLength() > 0) {
            this.exO.setEnabled(true);
        } else {
            this.exO.setEnabled(false);
        }
    }

    public void aMW() {
        l.b(this.exJ.getPageContext().getPageActivity(), this.mEditText);
    }

    private void on(int i) {
        this.exO.setText(String.format(this.exJ.getPageContext().getString(d.k.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aMX() {
        return this.exP;
    }

    public void oo(int i) {
        this.exP = i;
        this.exM.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.exM.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
