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
    private final InviteFriendListActivity kGA;
    private c kGB;
    private View kGC;
    private InviteFriendCandidateList kGD;
    private LinearLayout kGE;
    private Button kGF;
    private int kGG;
    private boolean kGH;
    private TextView kGI;
    private View kGJ;
    private View kGK;
    private TextView kGL;
    private ImageView kGM;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kGG = 0;
        this.kGA = inviteFriendListActivity;
        this.kGH = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kGA.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kGA.findViewById(R.id.root_view);
        bFP();
        this.WX = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WX.setOnItemClickListener(this.kGA);
        if (this.kGH) {
            this.mNoDataView = NoDataViewFactory.a(this.kGA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fFw), NoDataViewFactory.d.ba(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kGA.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fFw), NoDataViewFactory.d.ba(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kGA.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kGD = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kGD.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.kGE = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kGC = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kGH) {
            this.kGE.setVisibility(8);
            this.kGC.setVisibility(8);
        }
        dbd();
        this.kGF = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kGF.setOnClickListener(this.kGA);
        bvt();
        daV();
        EN(0);
    }

    private void bFP() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kGJ != null && d.this.kGJ.getVisibility() == 0) {
                    d.this.daW();
                    return;
                }
                l.hideSoftKeyPad(d.this.kGA.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.kGA.finish();
            }
        });
        if (this.kGH) {
            this.kGI = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kGI = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kGK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kGI.setVisibility(8);
                d.this.kGK.setVisibility(8);
                d.this.kGJ.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.kGA.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.kGM = (ImageView) this.kGK.findViewById(R.id.new_friend_search);
        this.kGJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kGJ.setVisibility(8);
        this.mEditText = (EditText) this.kGJ.findViewById(R.id.search_bar_edit);
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
                        d.this.kGL.setVisibility(0);
                    } else {
                        d.this.kGL.setVisibility(8);
                    }
                    d.this.daU();
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
        this.kGL = (TextView) this.kGJ.findViewById(R.id.search_bar_delete_button);
        this.kGL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daU() {
        if (this.kGA != null) {
            this.kGA.daS();
        }
    }

    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kGA.getLayoutMode().setNightMode(skinType == 1);
        this.kGA.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.btW().a(this.kGM, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kGA.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kGA.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void daV() {
        this.WX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void daW() {
        l.hideSoftKeyPad(this.kGA.getPageContext().getPageActivity(), this.mEditText);
        this.kGJ.setVisibility(8);
        this.kGI.setVisibility(0);
        this.kGK.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean daX() {
        return this.kGJ != null && this.kGJ.getVisibility() == 0;
    }

    public int daY() {
        return this.kGF.getId();
    }

    public String daZ() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String dba() {
        return this.kGD.getDataList();
    }

    public void s(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kGB == null) {
            this.kGB = new c(this.kGA, this.kGH);
            this.kGB.a(this);
            this.kGB.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.dbf() <= d.this.kGD.getItemLength()) {
                                d.this.kGA.showToast(String.format(d.this.kGA.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kGG)));
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
            this.WX.setAdapter((ListAdapter) this.kGB);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WX.setVisibility(8);
            if (!this.kGH) {
                this.kGE.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WX.setVisibility(0);
        this.kGB.setData(list);
        this.kGB.notifyDataSetChanged();
        if (!this.kGH) {
            this.kGE.setVisibility(0);
        }
    }

    public void dbb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kGA.getPageContext());
        }
    }

    public void dbc() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bvb();
        }
    }

    private void dbd() {
        int dimensionPixelSize = this.kGA.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kGA.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kGA.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kGA.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WX.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGD.d(aVar);
            EN(this.kGD.getItemLength());
            dbe();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGD.f(aVar);
            EN(this.kGD.getItemLength());
            dbe();
        }
    }

    private void dbe() {
        if (this.kGD.getItemLength() > 0) {
            this.kGF.setEnabled(true);
        } else {
            this.kGF.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kGA.getPageContext().getPageActivity(), this.mEditText);
    }

    private void EN(int i) {
        this.kGF.setText(String.format(this.kGA.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int dbf() {
        return this.kGG;
    }

    public void EO(int i) {
        this.kGG = i;
        this.kGD.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kGD.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
