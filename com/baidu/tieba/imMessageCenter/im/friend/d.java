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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.d<InviteFriendListActivity> implements c.b {
    private BdListView Yj;
    private EditText cCD;
    private final InviteFriendListActivity kRA;
    private c kRB;
    private View kRC;
    private InviteFriendCandidateList kRD;
    private LinearLayout kRE;
    private Button kRF;
    private int kRG;
    private boolean kRH;
    private TextView kRI;
    private View kRJ;
    private View kRK;
    private TextView kRL;
    private ImageView kRM;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kRG = 0;
        this.kRA = inviteFriendListActivity;
        this.kRH = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kRA.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kRA.findViewById(R.id.root_view);
        bEP();
        this.Yj = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Yj.setOnItemClickListener(this.kRA);
        if (this.kRH) {
            this.mNoDataView = NoDataViewFactory.a(this.kRA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fOd), NoDataViewFactory.d.aV(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kRA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fOd), NoDataViewFactory.d.aV(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kRA.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kRD = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kRD.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Yj.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kRE = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kRC = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kRH) {
            this.kRE.setVisibility(8);
            this.kRC.setVisibility(8);
        }
        cZc();
        this.kRF = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kRF.setOnClickListener(this.kRA);
        bus();
        cYU();
        Dt(0);
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kRJ != null && d.this.kRJ.getVisibility() == 0) {
                    d.this.cYV();
                    return;
                }
                l.hideSoftKeyPad(d.this.kRA.getPageContext().getPageActivity(), d.this.cCD);
                d.this.kRA.finish();
            }
        });
        if (this.kRH) {
            this.kRI = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kRI = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kRK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kRI.setVisibility(8);
                d.this.kRK.setVisibility(8);
                d.this.kRJ.setVisibility(0);
                d.this.cCD.requestFocus();
                l.showSoftKeyPad(d.this.kRA.getPageContext().getPageActivity(), d.this.cCD);
            }
        });
        this.kRM = (ImageView) this.kRK.findViewById(R.id.new_friend_search);
        this.kRJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kRJ.setVisibility(8);
        this.cCD = (EditText) this.kRJ.findViewById(R.id.search_bar_edit);
        if (this.cCD.getParent() != null) {
            ((View) this.cCD.getParent()).setFocusable(true);
            ((View) this.cCD.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.kRL.setVisibility(0);
                    } else {
                        d.this.kRL.setVisibility(8);
                    }
                    d.this.cYT();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.cCD.addTextChangedListener(this.mTextWatcher);
        this.kRL = (TextView) this.kRJ.findViewById(R.id.search_bar_delete_button);
        this.kRL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cCD.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYT() {
        if (this.kRA != null) {
            this.kRA.cYR();
        }
    }

    public void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kRA.getLayoutMode().setNightMode(skinType == 1);
        this.kRA.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bsU().a(this.kRM, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kRA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kRA.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cYU() {
        this.Yj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cYV() {
        l.hideSoftKeyPad(this.kRA.getPageContext().getPageActivity(), this.cCD);
        this.kRJ.setVisibility(8);
        this.kRI.setVisibility(0);
        this.kRK.setVisibility(0);
        this.cCD.getText().clear();
    }

    public boolean cYW() {
        return this.kRJ != null && this.kRJ.getVisibility() == 0;
    }

    public int cYX() {
        return this.kRF.getId();
    }

    public String cYY() {
        Editable text = this.cCD.getText();
        return text != null ? text.toString() : "";
    }

    public String cYZ() {
        return this.kRD.getDataList();
    }

    public void u(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kRB == null) {
            this.kRB = new c(this.kRA, this.kRH);
            this.kRB.a(this);
            this.kRB.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cZe() <= d.this.kRD.getItemLength()) {
                                d.this.kRA.showToast(String.format(d.this.kRA.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kRG)));
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
            this.Yj.setAdapter((ListAdapter) this.kRB);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Yj.setVisibility(8);
            if (!this.kRH) {
                this.kRE.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Yj.setVisibility(0);
        this.kRB.setData(list);
        this.kRB.notifyDataSetChanged();
        if (!this.kRH) {
            this.kRE.setVisibility(0);
        }
    }

    public void cZa() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kRA.getPageContext());
        }
    }

    public void cZb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bua();
        }
    }

    private void cZc() {
        int dimensionPixelSize = this.kRA.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kRA.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kRA.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kRA.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Yj.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kRD.d(aVar);
            Dt(this.kRD.getItemLength());
            cZd();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kRD.f(aVar);
            Dt(this.kRD.getItemLength());
            cZd();
        }
    }

    private void cZd() {
        if (this.kRD.getItemLength() > 0) {
            this.kRF.setEnabled(true);
        } else {
            this.kRF.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kRA.getPageContext().getPageActivity(), this.cCD);
    }

    private void Dt(int i) {
        this.kRF.setText(String.format(this.kRA.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cZe() {
        return this.kRG;
    }

    public void Du(int i) {
        this.kRG = i;
        this.kRD.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kRD.e(aVar);
        }
    }

    public void onDestroy() {
        this.cCD.removeTextChangedListener(this.mTextWatcher);
    }
}
