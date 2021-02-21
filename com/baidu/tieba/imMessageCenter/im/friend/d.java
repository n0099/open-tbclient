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
    private BdListView WO;
    private EditText cBd;
    private View kPA;
    private InviteFriendCandidateList kPB;
    private LinearLayout kPC;
    private Button kPD;
    private int kPE;
    private boolean kPF;
    private TextView kPG;
    private View kPH;
    private View kPI;
    private TextView kPJ;
    private ImageView kPK;
    private final InviteFriendListActivity kPy;
    private c kPz;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kPE = 0;
        this.kPy = inviteFriendListActivity;
        this.kPF = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kPy.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kPy.findViewById(R.id.root_view);
        bEL();
        this.WO = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WO.setOnItemClickListener(this.kPy);
        if (this.kPF) {
            this.mNoDataView = NoDataViewFactory.a(this.kPy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fMD), NoDataViewFactory.d.aV(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kPy.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fMD), NoDataViewFactory.d.aV(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kPy.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kPB = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kPB.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.WO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kPC = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kPA = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kPF) {
            this.kPC.setVisibility(8);
            this.kPA.setVisibility(8);
        }
        cYV();
        this.kPD = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kPD.setOnClickListener(this.kPy);
        bup();
        cYN();
        Dq(0);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kPH != null && d.this.kPH.getVisibility() == 0) {
                    d.this.cYO();
                    return;
                }
                l.hideSoftKeyPad(d.this.kPy.getPageContext().getPageActivity(), d.this.cBd);
                d.this.kPy.finish();
            }
        });
        if (this.kPF) {
            this.kPG = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kPG = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kPI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kPG.setVisibility(8);
                d.this.kPI.setVisibility(8);
                d.this.kPH.setVisibility(0);
                d.this.cBd.requestFocus();
                l.showSoftKeyPad(d.this.kPy.getPageContext().getPageActivity(), d.this.cBd);
            }
        });
        this.kPK = (ImageView) this.kPI.findViewById(R.id.new_friend_search);
        this.kPH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kPH.setVisibility(8);
        this.cBd = (EditText) this.kPH.findViewById(R.id.search_bar_edit);
        if (this.cBd.getParent() != null) {
            ((View) this.cBd.getParent()).setFocusable(true);
            ((View) this.cBd.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.kPJ.setVisibility(0);
                    } else {
                        d.this.kPJ.setVisibility(8);
                    }
                    d.this.cYM();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.cBd.addTextChangedListener(this.mTextWatcher);
        this.kPJ = (TextView) this.kPH.findViewById(R.id.search_bar_delete_button);
        this.kPJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cBd.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYM() {
        if (this.kPy != null) {
            this.kPy.cYK();
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kPy.getLayoutMode().setNightMode(skinType == 1);
        this.kPy.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bsR().a(this.kPK, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kPy.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kPy.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cYN() {
        this.WO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cYO() {
        l.hideSoftKeyPad(this.kPy.getPageContext().getPageActivity(), this.cBd);
        this.kPH.setVisibility(8);
        this.kPG.setVisibility(0);
        this.kPI.setVisibility(0);
        this.cBd.getText().clear();
    }

    public boolean cYP() {
        return this.kPH != null && this.kPH.getVisibility() == 0;
    }

    public int cYQ() {
        return this.kPD.getId();
    }

    public String cYR() {
        Editable text = this.cBd.getText();
        return text != null ? text.toString() : "";
    }

    public String cYS() {
        return this.kPB.getDataList();
    }

    public void u(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kPz == null) {
            this.kPz = new c(this.kPy, this.kPF);
            this.kPz.a(this);
            this.kPz.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cYX() <= d.this.kPB.getItemLength()) {
                                d.this.kPy.showToast(String.format(d.this.kPy.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kPE)));
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
            this.WO.setAdapter((ListAdapter) this.kPz);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WO.setVisibility(8);
            if (!this.kPF) {
                this.kPC.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WO.setVisibility(0);
        this.kPz.setData(list);
        this.kPz.notifyDataSetChanged();
        if (!this.kPF) {
            this.kPC.setVisibility(0);
        }
    }

    public void cYT() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kPy.getPageContext());
        }
    }

    public void cYU() {
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    private void cYV() {
        int dimensionPixelSize = this.kPy.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kPy.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kPy.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kPy.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WO.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPB.d(aVar);
            Dq(this.kPB.getItemLength());
            cYW();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPB.f(aVar);
            Dq(this.kPB.getItemLength());
            cYW();
        }
    }

    private void cYW() {
        if (this.kPB.getItemLength() > 0) {
            this.kPD.setEnabled(true);
        } else {
            this.kPD.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kPy.getPageContext().getPageActivity(), this.cBd);
    }

    private void Dq(int i) {
        this.kPD.setText(String.format(this.kPy.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cYX() {
        return this.kPE;
    }

    public void Dr(int i) {
        this.kPE = i;
        this.kPB.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPB.e(aVar);
        }
    }

    public void onDestroy() {
        this.cBd.removeTextChangedListener(this.mTextWatcher);
    }
}
