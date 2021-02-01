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
    private final InviteFriendListActivity kPk;
    private c kPl;
    private View kPm;
    private InviteFriendCandidateList kPn;
    private LinearLayout kPo;
    private Button kPp;
    private int kPq;
    private boolean kPr;
    private TextView kPs;
    private View kPt;
    private View kPu;
    private TextView kPv;
    private ImageView kPw;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kPq = 0;
        this.kPk = inviteFriendListActivity;
        this.kPr = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kPk.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kPk.findViewById(R.id.root_view);
        bEL();
        this.WO = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WO.setOnItemClickListener(this.kPk);
        if (this.kPr) {
            this.mNoDataView = NoDataViewFactory.a(this.kPk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fMD), NoDataViewFactory.d.aV(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kPk.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fMD), NoDataViewFactory.d.aV(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kPk.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kPn = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kPn.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.kPo = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kPm = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kPr) {
            this.kPo.setVisibility(8);
            this.kPm.setVisibility(8);
        }
        cYO();
        this.kPp = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kPp.setOnClickListener(this.kPk);
        bup();
        cYG();
        Dq(0);
    }

    private void bEL() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kPt != null && d.this.kPt.getVisibility() == 0) {
                    d.this.cYH();
                    return;
                }
                l.hideSoftKeyPad(d.this.kPk.getPageContext().getPageActivity(), d.this.cBd);
                d.this.kPk.finish();
            }
        });
        if (this.kPr) {
            this.kPs = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kPs = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kPu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kPs.setVisibility(8);
                d.this.kPu.setVisibility(8);
                d.this.kPt.setVisibility(0);
                d.this.cBd.requestFocus();
                l.showSoftKeyPad(d.this.kPk.getPageContext().getPageActivity(), d.this.cBd);
            }
        });
        this.kPw = (ImageView) this.kPu.findViewById(R.id.new_friend_search);
        this.kPt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kPt.setVisibility(8);
        this.cBd = (EditText) this.kPt.findViewById(R.id.search_bar_edit);
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
                        d.this.kPv.setVisibility(0);
                    } else {
                        d.this.kPv.setVisibility(8);
                    }
                    d.this.cYF();
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
        this.kPv = (TextView) this.kPt.findViewById(R.id.search_bar_delete_button);
        this.kPv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cBd.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYF() {
        if (this.kPk != null) {
            this.kPk.cYD();
        }
    }

    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kPk.getLayoutMode().setNightMode(skinType == 1);
        this.kPk.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bsR().a(this.kPw, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kPk.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kPk.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cYG() {
        this.WO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cYH() {
        l.hideSoftKeyPad(this.kPk.getPageContext().getPageActivity(), this.cBd);
        this.kPt.setVisibility(8);
        this.kPs.setVisibility(0);
        this.kPu.setVisibility(0);
        this.cBd.getText().clear();
    }

    public boolean cYI() {
        return this.kPt != null && this.kPt.getVisibility() == 0;
    }

    public int cYJ() {
        return this.kPp.getId();
    }

    public String cYK() {
        Editable text = this.cBd.getText();
        return text != null ? text.toString() : "";
    }

    public String cYL() {
        return this.kPn.getDataList();
    }

    public void u(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kPl == null) {
            this.kPl = new c(this.kPk, this.kPr);
            this.kPl.a(this);
            this.kPl.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cYQ() <= d.this.kPn.getItemLength()) {
                                d.this.kPk.showToast(String.format(d.this.kPk.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kPq)));
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
            this.WO.setAdapter((ListAdapter) this.kPl);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WO.setVisibility(8);
            if (!this.kPr) {
                this.kPo.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WO.setVisibility(0);
        this.kPl.setData(list);
        this.kPl.notifyDataSetChanged();
        if (!this.kPr) {
            this.kPo.setVisibility(0);
        }
    }

    public void cYM() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kPk.getPageContext());
        }
    }

    public void cYN() {
        if (this.mNoDataView != null) {
            this.mNoDataView.btX();
        }
    }

    private void cYO() {
        int dimensionPixelSize = this.kPk.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kPk.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kPk.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kPk.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WO.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPn.d(aVar);
            Dq(this.kPn.getItemLength());
            cYP();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPn.f(aVar);
            Dq(this.kPn.getItemLength());
            cYP();
        }
    }

    private void cYP() {
        if (this.kPn.getItemLength() > 0) {
            this.kPp.setEnabled(true);
        } else {
            this.kPp.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kPk.getPageContext().getPageActivity(), this.cBd);
    }

    private void Dq(int i) {
        this.kPp.setText(String.format(this.kPk.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cYQ() {
        return this.kPq;
    }

    public void Dr(int i) {
        this.kPq = i;
        this.kPn.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kPn.e(aVar);
        }
    }

    public void onDestroy() {
        this.cBd.removeTextChangedListener(this.mTextWatcher);
    }
}
