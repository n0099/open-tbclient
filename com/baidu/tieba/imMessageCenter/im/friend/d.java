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
    private BdListView WX;
    private final InviteFriendListActivity kGC;
    private c kGD;
    private View kGE;
    private InviteFriendCandidateList kGF;
    private LinearLayout kGG;
    private Button kGH;
    private int kGI;
    private boolean kGJ;
    private TextView kGK;
    private View kGL;
    private View kGM;
    private TextView kGN;
    private ImageView kGO;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kGI = 0;
        this.kGC = inviteFriendListActivity;
        this.kGJ = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kGC.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kGC.findViewById(R.id.root_view);
        bFP();
        this.WX = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WX.setOnItemClickListener(this.kGC);
        if (this.kGJ) {
            this.mNoDataView = NoDataViewFactory.a(this.kGC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fFw), NoDataViewFactory.d.ba(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kGC.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fFw), NoDataViewFactory.d.ba(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kGC.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kGF = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kGF.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.WX.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kGG = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kGE = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kGJ) {
            this.kGG.setVisibility(8);
            this.kGE.setVisibility(8);
        }
        dbe();
        this.kGH = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kGH.setOnClickListener(this.kGC);
        bvt();
        daW();
        EN(0);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kGL != null && d.this.kGL.getVisibility() == 0) {
                    d.this.daX();
                    return;
                }
                l.hideSoftKeyPad(d.this.kGC.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.kGC.finish();
            }
        });
        if (this.kGJ) {
            this.kGK = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kGK = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kGM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kGK.setVisibility(8);
                d.this.kGM.setVisibility(8);
                d.this.kGL.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.kGC.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.kGO = (ImageView) this.kGM.findViewById(R.id.new_friend_search);
        this.kGL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kGL.setVisibility(8);
        this.mEditText = (EditText) this.kGL.findViewById(R.id.search_bar_edit);
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
                        d.this.kGN.setVisibility(0);
                    } else {
                        d.this.kGN.setVisibility(8);
                    }
                    d.this.daV();
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
        this.kGN = (TextView) this.kGL.findViewById(R.id.search_bar_delete_button);
        this.kGN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daV() {
        if (this.kGC != null) {
            this.kGC.daT();
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGC.getLayoutMode().setNightMode(skinType == 1);
        this.kGC.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.btW().a(this.kGO, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kGC.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kGC.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void daW() {
        this.WX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void daX() {
        l.hideSoftKeyPad(this.kGC.getPageContext().getPageActivity(), this.mEditText);
        this.kGL.setVisibility(8);
        this.kGK.setVisibility(0);
        this.kGM.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean daY() {
        return this.kGL != null && this.kGL.getVisibility() == 0;
    }

    public int daZ() {
        return this.kGH.getId();
    }

    public String dba() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String dbb() {
        return this.kGF.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kGD == null) {
            this.kGD = new c(this.kGC, this.kGJ);
            this.kGD.a(this);
            this.kGD.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.dbg() <= d.this.kGF.getItemLength()) {
                                d.this.kGC.showToast(String.format(d.this.kGC.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kGI)));
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
            this.WX.setAdapter((ListAdapter) this.kGD);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WX.setVisibility(8);
            if (!this.kGJ) {
                this.kGG.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WX.setVisibility(0);
        this.kGD.setData(list);
        this.kGD.notifyDataSetChanged();
        if (!this.kGJ) {
            this.kGG.setVisibility(0);
        }
    }

    public void dbc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kGC.getPageContext());
        }
    }

    public void dbd() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
        }
    }

    private void dbe() {
        int dimensionPixelSize = this.kGC.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kGC.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kGC.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kGC.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WX.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGF.d(aVar);
            EN(this.kGF.getItemLength());
            dbf();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGF.f(aVar);
            EN(this.kGF.getItemLength());
            dbf();
        }
    }

    private void dbf() {
        if (this.kGF.getItemLength() > 0) {
            this.kGH.setEnabled(true);
        } else {
            this.kGH.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kGC.getPageContext().getPageActivity(), this.mEditText);
    }

    private void EN(int i) {
        this.kGH.setText(String.format(this.kGC.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int dbg() {
        return this.kGI;
    }

    public void EO(int i) {
        this.kGI = i;
        this.kGF.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGF.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
