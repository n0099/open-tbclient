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
import com.baidu.tbadk.core.util.an;
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
    private BdListView US;
    private final InviteFriendListActivity jeZ;
    private c jfa;
    private View jfb;
    private InviteFriendCandidateList jfc;
    private LinearLayout jfd;
    private Button jfe;
    private int jff;
    private boolean jfg;
    private TextView jfh;
    private View jfi;
    private View jfj;
    private TextView jfk;
    private ImageView jfl;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jff = 0;
        this.jeZ = inviteFriendListActivity;
        this.jfg = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jeZ.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jeZ.findViewById(R.id.root_view);
        biq();
        this.US = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.US.setOnItemClickListener(this.jeZ);
        if (this.jfg) {
            this.mNoDataView = NoDataViewFactory.a(this.jeZ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eDT), NoDataViewFactory.d.aP(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jeZ.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eDT), NoDataViewFactory.d.aP(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jeZ.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jfc = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jfc.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.US.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jfd = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jfb = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jfg) {
            this.jfd.setVisibility(8);
            this.jfb.setVisibility(8);
        }
        cuu();
        this.jfe = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jfe.setOnClickListener(this.jeZ);
        aYj();
        cum();
        yV(0);
    }

    private void biq() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jfi != null && d.this.jfi.getVisibility() == 0) {
                    d.this.cun();
                    return;
                }
                l.hideSoftKeyPad(d.this.jeZ.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jeZ.finish();
            }
        });
        if (this.jfg) {
            this.jfh = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jfh = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jfj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jfh.setVisibility(8);
                d.this.jfj.setVisibility(8);
                d.this.jfi.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jeZ.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jfl = (ImageView) this.jfj.findViewById(R.id.new_friend_search);
        this.jfi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jfi.setVisibility(8);
        this.mEditText = (EditText) this.jfi.findViewById(R.id.search_bar_edit);
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
                        d.this.jfk.setVisibility(0);
                    } else {
                        d.this.jfk.setVisibility(8);
                    }
                    d.this.cul();
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
        this.jfk = (TextView) this.jfi.findViewById(R.id.search_bar_delete_button);
        this.jfk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cul() {
        if (this.jeZ != null) {
            this.jeZ.cuj();
        }
    }

    public void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jeZ.getLayoutMode().setNightMode(skinType == 1);
        this.jeZ.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.aWQ().a(this.jfl, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jeZ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jeZ.getPageContext(), skinType);
        an.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cum() {
        this.US.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cun() {
        l.hideSoftKeyPad(this.jeZ.getPageContext().getPageActivity(), this.mEditText);
        this.jfi.setVisibility(8);
        this.jfh.setVisibility(0);
        this.jfj.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cuo() {
        return this.jfi != null && this.jfi.getVisibility() == 0;
    }

    public int cup() {
        return this.jfe.getId();
    }

    public String cuq() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cur() {
        return this.jfc.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jfa == null) {
            this.jfa = new c(this.jeZ, this.jfg);
            this.jfa.a(this);
            this.jfa.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cuw() <= d.this.jfc.getItemLength()) {
                                d.this.jeZ.showToast(String.format(d.this.jeZ.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jff)));
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
            this.US.setAdapter((ListAdapter) this.jfa);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.US.setVisibility(8);
            if (!this.jfg) {
                this.jfd.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.US.setVisibility(0);
        this.jfa.setData(list);
        this.jfa.notifyDataSetChanged();
        if (!this.jfg) {
            this.jfd.setVisibility(0);
        }
    }

    public void cus() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jeZ.getPageContext());
        }
    }

    public void cut() {
        if (this.mNoDataView != null) {
            this.mNoDataView.aXU();
        }
    }

    private void cuu() {
        int dimensionPixelSize = this.jeZ.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jeZ.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jeZ.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jeZ.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.US.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jfc.d(aVar);
            yV(this.jfc.getItemLength());
            cuv();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jfc.f(aVar);
            yV(this.jfc.getItemLength());
            cuv();
        }
    }

    private void cuv() {
        if (this.jfc.getItemLength() > 0) {
            this.jfe.setEnabled(true);
        } else {
            this.jfe.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jeZ.getPageContext().getPageActivity(), this.mEditText);
    }

    private void yV(int i) {
        this.jfe.setText(String.format(this.jeZ.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cuw() {
        return this.jff;
    }

    public void yW(int i) {
        this.jff = i;
        this.jfc.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jfc.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
