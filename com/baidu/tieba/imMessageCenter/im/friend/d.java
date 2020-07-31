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
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView UL;
    private Button jnA;
    private int jnB;
    private boolean jnC;
    private TextView jnD;
    private View jnE;
    private View jnF;
    private TextView jnG;
    private ImageView jnH;
    private final InviteFriendListActivity jnv;
    private c jnw;
    private View jnx;
    private InviteFriendCandidateList jny;
    private LinearLayout jnz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jnB = 0;
        this.jnv = inviteFriendListActivity;
        this.jnC = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jnv.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jnv.findViewById(R.id.root_view);
        bmb();
        this.UL = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.UL.setOnItemClickListener(this.jnv);
        if (this.jnC) {
            this.mNoDataView = NoDataViewFactory.a(this.jnv.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eKp), NoDataViewFactory.d.aQ(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jnv.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eKp), NoDataViewFactory.d.aQ(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jnv.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jny = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jny.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.UL.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jnz = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jnx = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jnC) {
            this.jnz.setVisibility(8);
            this.jnx.setVisibility(8);
        }
        cyx();
        this.jnA = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jnA.setOnClickListener(this.jnv);
        bci();
        cyp();
        zu(0);
    }

    private void bmb() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jnE != null && d.this.jnE.getVisibility() == 0) {
                    d.this.cyq();
                    return;
                }
                l.hideSoftKeyPad(d.this.jnv.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jnv.finish();
            }
        });
        if (this.jnC) {
            this.jnD = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jnD = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jnF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jnD.setVisibility(8);
                d.this.jnF.setVisibility(8);
                d.this.jnE.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jnv.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jnH = (ImageView) this.jnF.findViewById(R.id.new_friend_search);
        this.jnE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jnE.setVisibility(8);
        this.mEditText = (EditText) this.jnE.findViewById(R.id.search_bar_edit);
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
                        d.this.jnG.setVisibility(0);
                    } else {
                        d.this.jnG.setVisibility(8);
                    }
                    d.this.cyo();
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
        this.jnG = (TextView) this.jnE.findViewById(R.id.search_bar_delete_button);
        this.jnG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyo() {
        if (this.jnv != null) {
            this.jnv.cym();
        }
    }

    public void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jnv.getLayoutMode().setNightMode(skinType == 1);
        this.jnv.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.baR().a(this.jnH, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jnv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jnv.getPageContext(), skinType);
        ao.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cyp() {
        this.UL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cyq() {
        l.hideSoftKeyPad(this.jnv.getPageContext().getPageActivity(), this.mEditText);
        this.jnE.setVisibility(8);
        this.jnD.setVisibility(0);
        this.jnF.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cyr() {
        return this.jnE != null && this.jnE.getVisibility() == 0;
    }

    public int cys() {
        return this.jnA.getId();
    }

    public String cyt() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cyu() {
        return this.jny.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jnw == null) {
            this.jnw = new c(this.jnv, this.jnC);
            this.jnw.a(this);
            this.jnw.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cyz() <= d.this.jny.getItemLength()) {
                                d.this.jnv.showToast(String.format(d.this.jnv.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jnB)));
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
            this.UL.setAdapter((ListAdapter) this.jnw);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.UL.setVisibility(8);
            if (!this.jnC) {
                this.jnz.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.UL.setVisibility(0);
        this.jnw.setData(list);
        this.jnw.notifyDataSetChanged();
        if (!this.jnC) {
            this.jnz.setVisibility(0);
        }
    }

    public void cyv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jnv.getPageContext());
        }
    }

    public void cyw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bbU();
        }
    }

    private void cyx() {
        int dimensionPixelSize = this.jnv.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jnv.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jnv.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jnv.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.UL.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jny.d(aVar);
            zu(this.jny.getItemLength());
            cyy();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jny.f(aVar);
            zu(this.jny.getItemLength());
            cyy();
        }
    }

    private void cyy() {
        if (this.jny.getItemLength() > 0) {
            this.jnA.setEnabled(true);
        } else {
            this.jnA.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jnv.getPageContext().getPageActivity(), this.mEditText);
    }

    private void zu(int i) {
        this.jnA.setText(String.format(this.jnv.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cyz() {
        return this.jnB;
    }

    public void zv(int i) {
        this.jnB = i;
        this.jny.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jny.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
