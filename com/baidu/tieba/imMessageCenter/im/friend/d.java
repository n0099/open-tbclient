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
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Vo;
    private final InviteFriendListActivity jCB;
    private c jCC;
    private View jCD;
    private InviteFriendCandidateList jCE;
    private LinearLayout jCF;
    private Button jCG;
    private int jCH;
    private boolean jCI;
    private TextView jCJ;
    private View jCK;
    private View jCL;
    private TextView jCM;
    private ImageView jCN;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jCH = 0;
        this.jCB = inviteFriendListActivity;
        this.jCI = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jCB.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jCB.findViewById(R.id.root_view);
        buP();
        this.Vo = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Vo.setOnItemClickListener(this.jCB);
        if (this.jCI) {
            this.mNoDataView = NoDataViewFactory.a(this.jCB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eUY), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jCB.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eUY), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jCB.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jCE = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jCE.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Vo.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jCF = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jCD = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jCI) {
            this.jCF.setVisibility(8);
            this.jCD.setVisibility(8);
        }
        cJp();
        this.jCG = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jCG.setOnClickListener(this.jCB);
        bkF();
        cJh();
        BN(0);
    }

    private void buP() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jCK != null && d.this.jCK.getVisibility() == 0) {
                    d.this.cJi();
                    return;
                }
                l.hideSoftKeyPad(d.this.jCB.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jCB.finish();
            }
        });
        if (this.jCI) {
            this.jCJ = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jCJ = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jCL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jCJ.setVisibility(8);
                d.this.jCL.setVisibility(8);
                d.this.jCK.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jCB.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jCN = (ImageView) this.jCL.findViewById(R.id.new_friend_search);
        this.jCK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jCK.setVisibility(8);
        this.mEditText = (EditText) this.jCK.findViewById(R.id.search_bar_edit);
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
                        d.this.jCM.setVisibility(0);
                    } else {
                        d.this.jCM.setVisibility(8);
                    }
                    d.this.cJg();
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
        this.jCM = (TextView) this.jCK.findViewById(R.id.search_bar_delete_button);
        this.jCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJg() {
        if (this.jCB != null) {
            this.jCB.cJe();
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jCB.getLayoutMode().setNightMode(skinType == 1);
        this.jCB.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bjq().a(this.jCN, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jCB.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jCB.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cJh() {
        this.Vo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cJi() {
        l.hideSoftKeyPad(this.jCB.getPageContext().getPageActivity(), this.mEditText);
        this.jCK.setVisibility(8);
        this.jCJ.setVisibility(0);
        this.jCL.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cJj() {
        return this.jCK != null && this.jCK.getVisibility() == 0;
    }

    public int cJk() {
        return this.jCG.getId();
    }

    public String cJl() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cJm() {
        return this.jCE.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jCC == null) {
            this.jCC = new c(this.jCB, this.jCI);
            this.jCC.a(this);
            this.jCC.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cJr() <= d.this.jCE.getItemLength()) {
                                d.this.jCB.showToast(String.format(d.this.jCB.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jCH)));
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
            this.Vo.setAdapter((ListAdapter) this.jCC);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Vo.setVisibility(8);
            if (!this.jCI) {
                this.jCF.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Vo.setVisibility(0);
        this.jCC.setData(list);
        this.jCC.notifyDataSetChanged();
        if (!this.jCI) {
            this.jCF.setVisibility(0);
        }
    }

    public void cJn() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jCB.getPageContext());
        }
    }

    public void cJo() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bkq();
        }
    }

    private void cJp() {
        int dimensionPixelSize = this.jCB.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jCB.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jCB.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jCB.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Vo.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCE.d(aVar);
            BN(this.jCE.getItemLength());
            cJq();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCE.f(aVar);
            BN(this.jCE.getItemLength());
            cJq();
        }
    }

    private void cJq() {
        if (this.jCE.getItemLength() > 0) {
            this.jCG.setEnabled(true);
        } else {
            this.jCG.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jCB.getPageContext().getPageActivity(), this.mEditText);
    }

    private void BN(int i) {
        this.jCG.setText(String.format(this.jCB.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cJr() {
        return this.jCH;
    }

    public void BO(int i) {
        this.jCH = i;
        this.jCE.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCE.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
