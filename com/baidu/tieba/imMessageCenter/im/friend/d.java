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
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView VG;
    private final InviteFriendListActivity jLd;
    private c jLe;
    private View jLf;
    private InviteFriendCandidateList jLg;
    private LinearLayout jLh;
    private Button jLi;
    private int jLj;
    private boolean jLk;
    private TextView jLl;
    private View jLm;
    private View jLn;
    private TextView jLo;
    private ImageView jLp;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.jLj = 0;
        this.jLd = inviteFriendListActivity;
        this.jLk = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.jLd.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.jLd.findViewById(R.id.root_view);
        bvT();
        this.VG = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.VG.setOnItemClickListener(this.jLd);
        if (this.jLk) {
            this.mNoDataView = NoDataViewFactory.a(this.jLd.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eXP), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.jLd.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.eXP), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.jLd.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.jLg = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.jLg.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.VG.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.jLh = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.jLf = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.jLk) {
            this.jLh.setVisibility(8);
            this.jLf.setVisibility(8);
        }
        cMV();
        this.jLi = (Button) this.mRoot.findViewById(R.id.button_send);
        this.jLi.setOnClickListener(this.jLd);
        blA();
        cMN();
        Co(0);
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.jLm != null && d.this.jLm.getVisibility() == 0) {
                    d.this.cMO();
                    return;
                }
                l.hideSoftKeyPad(d.this.jLd.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.jLd.finish();
            }
        });
        if (this.jLk) {
            this.jLl = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.jLl = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.jLn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.jLl.setVisibility(8);
                d.this.jLn.setVisibility(8);
                d.this.jLm.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.jLd.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.jLp = (ImageView) this.jLn.findViewById(R.id.new_friend_search);
        this.jLm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.jLm.setVisibility(8);
        this.mEditText = (EditText) this.jLm.findViewById(R.id.search_bar_edit);
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
                        d.this.jLo.setVisibility(0);
                    } else {
                        d.this.jLo.setVisibility(8);
                    }
                    d.this.cMM();
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
        this.jLo = (TextView) this.jLm.findViewById(R.id.search_bar_delete_button);
        this.jLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMM() {
        if (this.jLd != null) {
            this.jLd.cMK();
        }
    }

    public void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.jLd.getLayoutMode().setNightMode(skinType == 1);
        this.jLd.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bkl().a(this.jLp, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.jLd.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.jLd.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cMN() {
        this.VG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cMO() {
        l.hideSoftKeyPad(this.jLd.getPageContext().getPageActivity(), this.mEditText);
        this.jLm.setVisibility(8);
        this.jLl.setVisibility(0);
        this.jLn.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cMP() {
        return this.jLm != null && this.jLm.getVisibility() == 0;
    }

    public int cMQ() {
        return this.jLi.getId();
    }

    public String cMR() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cMS() {
        return this.jLg.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.jLe == null) {
            this.jLe = new c(this.jLd, this.jLk);
            this.jLe.a(this);
            this.jLe.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cMX() <= d.this.jLg.getItemLength()) {
                                d.this.jLd.showToast(String.format(d.this.jLd.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.jLj)));
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
            this.VG.setAdapter((ListAdapter) this.jLe);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.VG.setVisibility(8);
            if (!this.jLk) {
                this.jLh.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.VG.setVisibility(0);
        this.jLe.setData(list);
        this.jLe.notifyDataSetChanged();
        if (!this.jLk) {
            this.jLh.setVisibility(0);
        }
    }

    public void cMT() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.jLd.getPageContext());
        }
    }

    public void cMU() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bll();
        }
    }

    private void cMV() {
        int dimensionPixelSize = this.jLd.getResources().getDimensionPixelSize(R.dimen.ds80) + this.jLd.getResources().getDimensionPixelSize(R.dimen.ds16) + this.jLd.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.jLd.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.VG.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jLg.d(aVar);
            Co(this.jLg.getItemLength());
            cMW();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jLg.f(aVar);
            Co(this.jLg.getItemLength());
            cMW();
        }
    }

    private void cMW() {
        if (this.jLg.getItemLength() > 0) {
            this.jLi.setEnabled(true);
        } else {
            this.jLi.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.jLd.getPageContext().getPageActivity(), this.mEditText);
    }

    private void Co(int i) {
        this.jLi.setText(String.format(this.jLd.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cMX() {
        return this.jLj;
    }

    public void Cp(int i) {
        this.jLj = i;
        this.jLg.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.jLg.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
