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
/* loaded from: classes16.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Vo;
    private Button jCA;
    private int jCB;
    private boolean jCC;
    private TextView jCD;
    private View jCE;
    private View jCF;
    private TextView jCG;
    private ImageView jCH;
    private final InviteFriendListActivity jCv;
    private c jCw;
    private View jCx;
    private InviteFriendCandidateList jCy;
    private LinearLayout jCz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jCB = 0;
        this.jCv = inviteFriendListActivity;
        this.jCC = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jCv.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jCv.findViewById(R.id.root_view);
        buO();
        this.Vo = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Vo.setOnItemClickListener(this.jCv);
        if (this.jCC) {
            this.mNoDataView = NoDataViewFactory.a(this.jCv.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eUU), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jCv.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eUU), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jCv.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jCy = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jCy.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Vo.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jCz = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jCx = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jCC) {
            this.jCz.setVisibility(8);
            this.jCx.setVisibility(8);
        }
        cJo();
        this.jCA = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jCA.setOnClickListener(this.jCv);
        bkF();
        cJg();
        BN(0);
    }

    private void buO() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jCE != null && d.this.jCE.getVisibility() == 0) {
                    d.this.cJh();
                    return;
                }
                l.hideSoftKeyPad(d.this.jCv.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jCv.finish();
            }
        });
        if (this.jCC) {
            this.jCD = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jCD = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jCF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jCD.setVisibility(8);
                d.this.jCF.setVisibility(8);
                d.this.jCE.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jCv.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jCH = (ImageView) this.jCF.findViewById(R.id.new_friend_search);
        this.jCE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jCE.setVisibility(8);
        this.mEditText = (EditText) this.jCE.findViewById(R.id.search_bar_edit);
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
                        d.this.jCG.setVisibility(0);
                    } else {
                        d.this.jCG.setVisibility(8);
                    }
                    d.this.cJf();
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
        this.jCG = (TextView) this.jCE.findViewById(R.id.search_bar_delete_button);
        this.jCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJf() {
        if (this.jCv != null) {
            this.jCv.cJd();
        }
    }

    public void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jCv.getLayoutMode().setNightMode(skinType == 1);
        this.jCv.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bjq().a(this.jCH, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jCv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jCv.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cJg() {
        this.Vo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cJh() {
        l.hideSoftKeyPad(this.jCv.getPageContext().getPageActivity(), this.mEditText);
        this.jCE.setVisibility(8);
        this.jCD.setVisibility(0);
        this.jCF.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cJi() {
        return this.jCE != null && this.jCE.getVisibility() == 0;
    }

    public int cJj() {
        return this.jCA.getId();
    }

    public String cJk() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cJl() {
        return this.jCy.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jCw == null) {
            this.jCw = new c(this.jCv, this.jCC);
            this.jCw.a(this);
            this.jCw.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cJq() <= d.this.jCy.getItemLength()) {
                                d.this.jCv.showToast(String.format(d.this.jCv.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jCB)));
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
            this.Vo.setAdapter((ListAdapter) this.jCw);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Vo.setVisibility(8);
            if (!this.jCC) {
                this.jCz.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Vo.setVisibility(0);
        this.jCw.setData(list);
        this.jCw.notifyDataSetChanged();
        if (!this.jCC) {
            this.jCz.setVisibility(0);
        }
    }

    public void cJm() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jCv.getPageContext());
        }
    }

    public void cJn() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bkq();
        }
    }

    private void cJo() {
        int dimensionPixelSize = this.jCv.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jCv.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jCv.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jCv.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Vo.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCy.d(aVar);
            BN(this.jCy.getItemLength());
            cJp();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCy.f(aVar);
            BN(this.jCy.getItemLength());
            cJp();
        }
    }

    private void cJp() {
        if (this.jCy.getItemLength() > 0) {
            this.jCA.setEnabled(true);
        } else {
            this.jCA.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jCv.getPageContext().getPageActivity(), this.mEditText);
    }

    private void BN(int i) {
        this.jCA.setText(String.format(this.jCv.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cJq() {
        return this.jCB;
    }

    public void BO(int i) {
        this.jCB = i;
        this.jCy.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jCy.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
