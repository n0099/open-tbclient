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
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView TX;
    private InviteFriendCandidateList iyA;
    private LinearLayout iyB;
    private Button iyC;
    private int iyD;
    private boolean iyE;
    private TextView iyF;
    private View iyG;
    private View iyH;
    private TextView iyI;
    private ImageView iyJ;
    private final InviteFriendListActivity iyx;
    private c iyy;
    private View iyz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.iyD = 0;
        this.iyx = inviteFriendListActivity;
        this.iyE = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.iyx.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.iyx.findViewById(R.id.root_view);
        blF();
        this.TX = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.TX.setOnItemClickListener(this.iyx);
        if (this.iyE) {
            this.mNoDataView = NoDataViewFactory.a(this.iyx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egw), NoDataViewFactory.d.aJ(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.iyx.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egw), NoDataViewFactory.d.aJ(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.iyx.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iyA = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.iyA.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.TX.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.iyB = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.iyz = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.iyE) {
            this.iyB.setVisibility(8);
            this.iyz.setVisibility(8);
        }
        cjZ();
        this.iyC = (Button) this.mRoot.findViewById(R.id.button_send);
        this.iyC.setOnClickListener(this.iyx);
        aQp();
        cjR();
        xD(0);
    }

    private void blF() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iyG != null && d.this.iyG.getVisibility() == 0) {
                    d.this.cjS();
                    return;
                }
                l.hideSoftKeyPad(d.this.iyx.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.iyx.finish();
            }
        });
        if (this.iyE) {
            this.iyF = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.iyF = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.iyH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.iyF.setVisibility(8);
                d.this.iyH.setVisibility(8);
                d.this.iyG.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.iyx.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.iyJ = (ImageView) this.iyH.findViewById(R.id.new_friend_search);
        this.iyG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.iyG.setVisibility(8);
        this.mEditText = (EditText) this.iyG.findViewById(R.id.search_bar_edit);
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
                        d.this.iyI.setVisibility(0);
                    } else {
                        d.this.iyI.setVisibility(8);
                    }
                    d.this.cjQ();
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
        this.iyI = (TextView) this.iyG.findViewById(R.id.search_bar_delete_button);
        this.iyI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjQ() {
        if (this.iyx != null) {
            this.iyx.cjO();
        }
    }

    public void aQp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iyx.getLayoutMode().setNightMode(skinType == 1);
        this.iyx.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aOU().a(this.iyJ, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.iyx.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iyx.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cjR() {
        this.TX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cjS() {
        l.hideSoftKeyPad(this.iyx.getPageContext().getPageActivity(), this.mEditText);
        this.iyG.setVisibility(8);
        this.iyF.setVisibility(0);
        this.iyH.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cjT() {
        return this.iyG != null && this.iyG.getVisibility() == 0;
    }

    public int cjU() {
        return this.iyC.getId();
    }

    public String cjV() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cjW() {
        return this.iyA.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.iyy == null) {
            this.iyy = new c(this.iyx, this.iyE);
            this.iyy.a(this);
            this.iyy.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.ckb() <= d.this.iyA.getItemLength()) {
                                d.this.iyx.showToast(String.format(d.this.iyx.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.iyD)));
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
            this.TX.setAdapter((ListAdapter) this.iyy);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.TX.setVisibility(8);
            if (!this.iyE) {
                this.iyB.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.TX.setVisibility(0);
        this.iyy.setData(list);
        this.iyy.notifyDataSetChanged();
        if (!this.iyE) {
            this.iyB.setVisibility(0);
        }
    }

    public void cjX() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iyx.getPageContext());
        }
    }

    public void cjY() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aPY();
        }
    }

    private void cjZ() {
        int dimensionPixelSize = this.iyx.getResources().getDimensionPixelSize(R.dimen.ds80) + this.iyx.getResources().getDimensionPixelSize(R.dimen.ds16) + this.iyx.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.iyx.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.TX.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyA.d(aVar);
            xD(this.iyA.getItemLength());
            cka();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyA.f(aVar);
            xD(this.iyA.getItemLength());
            cka();
        }
    }

    private void cka() {
        if (this.iyA.getItemLength() > 0) {
            this.iyC.setEnabled(true);
        } else {
            this.iyC.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.iyx.getPageContext().getPageActivity(), this.mEditText);
    }

    private void xD(int i) {
        this.iyC.setText(String.format(this.iyx.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int ckb() {
        return this.iyD;
    }

    public void xE(int i) {
        this.iyD = i;
        this.iyA.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyA.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
