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
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView VY;
    private final InviteFriendListActivity kmA;
    private c kmB;
    private View kmC;
    private InviteFriendCandidateList kmD;
    private LinearLayout kmE;
    private Button kmF;
    private int kmG;
    private boolean kmH;
    private TextView kmI;
    private View kmJ;
    private View kmK;
    private TextView kmL;
    private ImageView kmM;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kmG = 0;
        this.kmA = inviteFriendListActivity;
        this.kmH = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kmA.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kmA.findViewById(R.id.root_view);
        bAw();
        this.VY = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.VY.setOnItemClickListener(this.kmA);
        if (this.kmH) {
            this.mNoDataView = NoDataViewFactory.a(this.kmA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fsA), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kmA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fsA), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kmA.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kmD = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kmD.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.VY.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kmE = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kmC = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kmH) {
            this.kmE.setVisibility(8);
            this.kmC.setVisibility(8);
        }
        cTK();
        this.kmF = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kmF.setOnClickListener(this.kmA);
        bqd();
        cTC();
        Dn(0);
    }

    private void bAw() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kmJ != null && d.this.kmJ.getVisibility() == 0) {
                    d.this.cTD();
                    return;
                }
                l.hideSoftKeyPad(d.this.kmA.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.kmA.finish();
            }
        });
        if (this.kmH) {
            this.kmI = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kmI = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kmK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kmI.setVisibility(8);
                d.this.kmK.setVisibility(8);
                d.this.kmJ.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.kmA.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.kmM = (ImageView) this.kmK.findViewById(R.id.new_friend_search);
        this.kmJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kmJ.setVisibility(8);
        this.mEditText = (EditText) this.kmJ.findViewById(R.id.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.kmL.setVisibility(0);
                    } else {
                        d.this.kmL.setVisibility(8);
                    }
                    d.this.cTB();
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
        this.kmL = (TextView) this.kmJ.findViewById(R.id.search_bar_delete_button);
        this.kmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTB() {
        if (this.kmA != null) {
            this.kmA.cTz();
        }
    }

    public void bqd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kmA.getLayoutMode().setNightMode(skinType == 1);
        this.kmA.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.boN().a(this.kmM, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kmA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kmA.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cTC() {
        this.VY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cTD() {
        l.hideSoftKeyPad(this.kmA.getPageContext().getPageActivity(), this.mEditText);
        this.kmJ.setVisibility(8);
        this.kmI.setVisibility(0);
        this.kmK.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cTE() {
        return this.kmJ != null && this.kmJ.getVisibility() == 0;
    }

    public int cTF() {
        return this.kmF.getId();
    }

    public String cTG() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cTH() {
        return this.kmD.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kmB == null) {
            this.kmB = new c(this.kmA, this.kmH);
            this.kmB.a(this);
            this.kmB.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cTM() <= d.this.kmD.getItemLength()) {
                                d.this.kmA.showToast(String.format(d.this.kmA.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kmG)));
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
            this.VY.setAdapter((ListAdapter) this.kmB);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.VY.setVisibility(8);
            if (!this.kmH) {
                this.kmE.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.VY.setVisibility(0);
        this.kmB.setData(list);
        this.kmB.notifyDataSetChanged();
        if (!this.kmH) {
            this.kmE.setVisibility(0);
        }
    }

    public void cTI() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kmA.getPageContext());
        }
    }

    public void cTJ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bpO();
        }
    }

    private void cTK() {
        int dimensionPixelSize = this.kmA.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kmA.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kmA.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kmA.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.VY.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kmD.d(aVar);
            Dn(this.kmD.getItemLength());
            cTL();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kmD.f(aVar);
            Dn(this.kmD.getItemLength());
            cTL();
        }
    }

    private void cTL() {
        if (this.kmD.getItemLength() > 0) {
            this.kmF.setEnabled(true);
        } else {
            this.kmF.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kmA.getPageContext().getPageActivity(), this.mEditText);
    }

    private void Dn(int i) {
        this.kmF.setText(String.format(this.kmA.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cTM() {
        return this.kmG;
    }

    public void Do(int i) {
        this.kmG = i;
        this.kmD.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kmD.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
