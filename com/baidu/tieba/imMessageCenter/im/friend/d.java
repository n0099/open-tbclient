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
    private LinearLayout ksA;
    private Button ksB;
    private int ksC;
    private boolean ksD;
    private TextView ksE;
    private View ksF;
    private View ksG;
    private TextView ksH;
    private ImageView ksI;
    private final InviteFriendListActivity ksw;
    private c ksx;
    private View ksy;
    private InviteFriendCandidateList ksz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.ksC = 0;
        this.ksw = inviteFriendListActivity;
        this.ksD = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.ksw.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.ksw.findViewById(R.id.root_view);
        bCV();
        this.VY = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.VY.setOnItemClickListener(this.ksw);
        if (this.ksD) {
            this.mNoDataView = NoDataViewFactory.a(this.ksw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fys), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.ksw.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fys), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.ksw.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.ksz = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.ksz.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.ksA = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.ksy = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.ksD) {
            this.ksA.setVisibility(8);
            this.ksy.setVisibility(8);
        }
        cWl();
        this.ksB = (Button) this.mRoot.findViewById(R.id.button_send);
        this.ksB.setOnClickListener(this.ksw);
        bsD();
        cWd();
        DA(0);
    }

    private void bCV() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ksF != null && d.this.ksF.getVisibility() == 0) {
                    d.this.cWe();
                    return;
                }
                l.hideSoftKeyPad(d.this.ksw.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.ksw.finish();
            }
        });
        if (this.ksD) {
            this.ksE = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.ksE = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.ksG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ksE.setVisibility(8);
                d.this.ksG.setVisibility(8);
                d.this.ksF.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.ksw.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.ksI = (ImageView) this.ksG.findViewById(R.id.new_friend_search);
        this.ksF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.ksF.setVisibility(8);
        this.mEditText = (EditText) this.ksF.findViewById(R.id.search_bar_edit);
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
                        d.this.ksH.setVisibility(0);
                    } else {
                        d.this.ksH.setVisibility(8);
                    }
                    d.this.cWc();
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
        this.ksH = (TextView) this.ksF.findViewById(R.id.search_bar_delete_button);
        this.ksH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWc() {
        if (this.ksw != null) {
            this.ksw.cWa();
        }
    }

    public void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ksw.getLayoutMode().setNightMode(skinType == 1);
        this.ksw.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.brn().a(this.ksI, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.ksw.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ksw.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cWd() {
        this.VY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cWe() {
        l.hideSoftKeyPad(this.ksw.getPageContext().getPageActivity(), this.mEditText);
        this.ksF.setVisibility(8);
        this.ksE.setVisibility(0);
        this.ksG.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cWf() {
        return this.ksF != null && this.ksF.getVisibility() == 0;
    }

    public int cWg() {
        return this.ksB.getId();
    }

    public String cWh() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cWi() {
        return this.ksz.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.ksx == null) {
            this.ksx = new c(this.ksw, this.ksD);
            this.ksx.a(this);
            this.ksx.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cWn() <= d.this.ksz.getItemLength()) {
                                d.this.ksw.showToast(String.format(d.this.ksw.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.ksC)));
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
            this.VY.setAdapter((ListAdapter) this.ksx);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.VY.setVisibility(8);
            if (!this.ksD) {
                this.ksA.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.VY.setVisibility(0);
        this.ksx.setData(list);
        this.ksx.notifyDataSetChanged();
        if (!this.ksD) {
            this.ksA.setVisibility(0);
        }
    }

    public void cWj() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ksw.getPageContext());
        }
    }

    public void cWk() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bso();
        }
    }

    private void cWl() {
        int dimensionPixelSize = this.ksw.getResources().getDimensionPixelSize(R.dimen.ds80) + this.ksw.getResources().getDimensionPixelSize(R.dimen.ds16) + this.ksw.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.ksw.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.VY.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ksz.d(aVar);
            DA(this.ksz.getItemLength());
            cWm();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ksz.f(aVar);
            DA(this.ksz.getItemLength());
            cWm();
        }
    }

    private void cWm() {
        if (this.ksz.getItemLength() > 0) {
            this.ksB.setEnabled(true);
        } else {
            this.ksB.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.ksw.getPageContext().getPageActivity(), this.mEditText);
    }

    private void DA(int i) {
        this.ksB.setText(String.format(this.ksw.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cWn() {
        return this.ksC;
    }

    public void DB(int i) {
        this.ksC = i;
        this.ksz.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ksz.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
