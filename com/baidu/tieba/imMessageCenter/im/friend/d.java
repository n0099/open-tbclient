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
import com.baidu.tbadk.core.util.ao;
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
    private BdListView WT;
    private EditText cyH;
    private final InviteFriendListActivity kHg;
    private c kHh;
    private View kHi;
    private InviteFriendCandidateList kHj;
    private LinearLayout kHk;
    private Button kHl;
    private int kHm;
    private boolean kHn;
    private TextView kHo;
    private View kHp;
    private View kHq;
    private TextView kHr;
    private ImageView kHs;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kHm = 0;
        this.kHg = inviteFriendListActivity;
        this.kHn = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kHg.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kHg.findViewById(R.id.root_view);
        bEt();
        this.WT = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.WT.setOnItemClickListener(this.kHg);
        if (this.kHn) {
            this.mNoDataView = NoDataViewFactory.a(this.kHg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fKs), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kHg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fKs), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kHg.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kHj = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kHj.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.WT.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kHk = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kHi = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kHn) {
            this.kHk.setVisibility(8);
            this.kHi.setVisibility(8);
        }
        cWQ();
        this.kHl = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kHl.setOnClickListener(this.kHg);
        btV();
        cWI();
        CZ(0);
    }

    private void bEt() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kHp != null && d.this.kHp.getVisibility() == 0) {
                    d.this.cWJ();
                    return;
                }
                l.hideSoftKeyPad(d.this.kHg.getPageContext().getPageActivity(), d.this.cyH);
                d.this.kHg.finish();
            }
        });
        if (this.kHn) {
            this.kHo = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kHo = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kHq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kHo.setVisibility(8);
                d.this.kHq.setVisibility(8);
                d.this.kHp.setVisibility(0);
                d.this.cyH.requestFocus();
                l.showSoftKeyPad(d.this.kHg.getPageContext().getPageActivity(), d.this.cyH);
            }
        });
        this.kHs = (ImageView) this.kHq.findViewById(R.id.new_friend_search);
        this.kHp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kHp.setVisibility(8);
        this.cyH = (EditText) this.kHp.findViewById(R.id.search_bar_edit);
        if (this.cyH.getParent() != null) {
            ((View) this.cyH.getParent()).setFocusable(true);
            ((View) this.cyH.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String charSequence2String = k.charSequence2String(editable, null);
                if (charSequence2String != null) {
                    if (charSequence2String.length() > 0) {
                        d.this.kHr.setVisibility(0);
                    } else {
                        d.this.kHr.setVisibility(8);
                    }
                    d.this.cWH();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.cyH.addTextChangedListener(this.mTextWatcher);
        this.kHr = (TextView) this.kHp.findViewById(R.id.search_bar_delete_button);
        this.kHr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.cyH.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWH() {
        if (this.kHg != null) {
            this.kHg.cWF();
        }
    }

    public void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kHg.getLayoutMode().setNightMode(skinType == 1);
        this.kHg.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bsx().a(this.kHs, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kHg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kHg.getPageContext(), skinType);
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cWI() {
        this.WT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cWJ() {
        l.hideSoftKeyPad(this.kHg.getPageContext().getPageActivity(), this.cyH);
        this.kHp.setVisibility(8);
        this.kHo.setVisibility(0);
        this.kHq.setVisibility(0);
        this.cyH.getText().clear();
    }

    public boolean cWK() {
        return this.kHp != null && this.kHp.getVisibility() == 0;
    }

    public int cWL() {
        return this.kHl.getId();
    }

    public String cWM() {
        Editable text = this.cyH.getText();
        return text != null ? text.toString() : "";
    }

    public String cWN() {
        return this.kHj.getDataList();
    }

    public void t(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kHh == null) {
            this.kHh = new c(this.kHg, this.kHn);
            this.kHh.a(this);
            this.kHh.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cWS() <= d.this.kHj.getItemLength()) {
                                d.this.kHg.showToast(String.format(d.this.kHg.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kHm)));
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
            this.WT.setAdapter((ListAdapter) this.kHh);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.WT.setVisibility(8);
            if (!this.kHn) {
                this.kHk.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.WT.setVisibility(0);
        this.kHh.setData(list);
        this.kHh.notifyDataSetChanged();
        if (!this.kHn) {
            this.kHk.setVisibility(0);
        }
    }

    public void cWO() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kHg.getPageContext());
        }
    }

    public void cWP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.btD();
        }
    }

    private void cWQ() {
        int dimensionPixelSize = this.kHg.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kHg.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kHg.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kHg.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.WT.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kHj.d(aVar);
            CZ(this.kHj.getItemLength());
            cWR();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kHj.f(aVar);
            CZ(this.kHj.getItemLength());
            cWR();
        }
    }

    private void cWR() {
        if (this.kHj.getItemLength() > 0) {
            this.kHl.setEnabled(true);
        } else {
            this.kHl.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kHg.getPageContext().getPageActivity(), this.cyH);
    }

    private void CZ(int i) {
        this.kHl.setText(String.format(this.kHg.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cWS() {
        return this.kHm;
    }

    public void Da(int i) {
        this.kHm = i;
        this.kHj.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kHj.e(aVar);
        }
    }

    public void onDestroy() {
        this.cyH.removeTextChangedListener(this.mTextWatcher);
    }
}
