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
    private BdListView Ua;
    private final InviteFriendListActivity iyD;
    private c iyE;
    private View iyF;
    private InviteFriendCandidateList iyG;
    private LinearLayout iyH;
    private Button iyI;
    private int iyJ;
    private boolean iyK;
    private TextView iyL;
    private View iyM;
    private View iyN;
    private TextView iyO;
    private ImageView iyP;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.iyJ = 0;
        this.iyD = inviteFriendListActivity;
        this.iyK = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.iyD.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.iyD.findViewById(R.id.root_view);
        blD();
        this.Ua = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Ua.setOnItemClickListener(this.iyD);
        if (this.iyK) {
            this.mNoDataView = NoDataViewFactory.a(this.iyD.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egB), NoDataViewFactory.d.aJ(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.iyD.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.egB), NoDataViewFactory.d.aJ(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.iyD.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.iyG = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.iyG.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Ua.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.iyH = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.iyF = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.iyK) {
            this.iyH.setVisibility(8);
            this.iyF.setVisibility(8);
        }
        cjX();
        this.iyI = (Button) this.mRoot.findViewById(R.id.button_send);
        this.iyI.setOnClickListener(this.iyD);
        aQm();
        cjP();
        xD(0);
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.iyM != null && d.this.iyM.getVisibility() == 0) {
                    d.this.cjQ();
                    return;
                }
                l.hideSoftKeyPad(d.this.iyD.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.iyD.finish();
            }
        });
        if (this.iyK) {
            this.iyL = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.iyL = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.iyN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.iyL.setVisibility(8);
                d.this.iyN.setVisibility(8);
                d.this.iyM.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.iyD.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.iyP = (ImageView) this.iyN.findViewById(R.id.new_friend_search);
        this.iyM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.iyM.setVisibility(8);
        this.mEditText = (EditText) this.iyM.findViewById(R.id.search_bar_edit);
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
                        d.this.iyO.setVisibility(0);
                    } else {
                        d.this.iyO.setVisibility(8);
                    }
                    d.this.cjO();
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
        this.iyO = (TextView) this.iyM.findViewById(R.id.search_bar_delete_button);
        this.iyO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjO() {
        if (this.iyD != null) {
            this.iyD.cjM();
        }
    }

    public void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.iyD.getLayoutMode().setNightMode(skinType == 1);
        this.iyD.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aOR().a(this.iyP, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.iyD.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.iyD.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cjP() {
        this.Ua.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cjQ() {
        l.hideSoftKeyPad(this.iyD.getPageContext().getPageActivity(), this.mEditText);
        this.iyM.setVisibility(8);
        this.iyL.setVisibility(0);
        this.iyN.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cjR() {
        return this.iyM != null && this.iyM.getVisibility() == 0;
    }

    public int cjS() {
        return this.iyI.getId();
    }

    public String cjT() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cjU() {
        return this.iyG.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.iyE == null) {
            this.iyE = new c(this.iyD, this.iyK);
            this.iyE.a(this);
            this.iyE.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cjZ() <= d.this.iyG.getItemLength()) {
                                d.this.iyD.showToast(String.format(d.this.iyD.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.iyJ)));
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
            this.Ua.setAdapter((ListAdapter) this.iyE);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Ua.setVisibility(8);
            if (!this.iyK) {
                this.iyH.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Ua.setVisibility(0);
        this.iyE.setData(list);
        this.iyE.notifyDataSetChanged();
        if (!this.iyK) {
            this.iyH.setVisibility(0);
        }
    }

    public void cjV() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.iyD.getPageContext());
        }
    }

    public void cjW() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aPV();
        }
    }

    private void cjX() {
        int dimensionPixelSize = this.iyD.getResources().getDimensionPixelSize(R.dimen.ds80) + this.iyD.getResources().getDimensionPixelSize(R.dimen.ds16) + this.iyD.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.iyD.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Ua.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyG.d(aVar);
            xD(this.iyG.getItemLength());
            cjY();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyG.f(aVar);
            xD(this.iyG.getItemLength());
            cjY();
        }
    }

    private void cjY() {
        if (this.iyG.getItemLength() > 0) {
            this.iyI.setEnabled(true);
        } else {
            this.iyI.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.iyD.getPageContext().getPageActivity(), this.mEditText);
    }

    private void xD(int i) {
        this.iyI.setText(String.format(this.iyD.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cjZ() {
        return this.iyJ;
    }

    public void xE(int i) {
        this.iyJ = i;
        this.iyG.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.iyG.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
