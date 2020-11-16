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
    private BdListView Wa;
    private final InviteFriendListActivity ktg;
    private c kth;
    private View kti;
    private InviteFriendCandidateList ktj;
    private LinearLayout ktk;
    private Button ktl;
    private int ktm;
    private boolean ktn;
    private TextView kto;
    private View ktp;
    private View ktq;
    private TextView ktr;
    private ImageView kts;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.ktm = 0;
        this.ktg = inviteFriendListActivity;
        this.ktn = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.ktg.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.ktg.findViewById(R.id.root_view);
        bCo();
        this.Wa = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.Wa.setOnItemClickListener(this.ktg);
        if (this.ktn) {
            this.mNoDataView = NoDataViewFactory.a(this.ktg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fxH), NoDataViewFactory.d.aY(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.ktg.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, BdListViewHelper.fxH), NoDataViewFactory.d.aY(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.ktg.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.ktj = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.ktj.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Wa.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.ktk = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kti = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.ktn) {
            this.ktk.setVisibility(8);
            this.kti.setVisibility(8);
        }
        cVR();
        this.ktl = (Button) this.mRoot.findViewById(R.id.button_send);
        this.ktl.setOnClickListener(this.ktg);
        brT();
        cVJ();
        DY(0);
    }

    private void bCo() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ktp != null && d.this.ktp.getVisibility() == 0) {
                    d.this.cVK();
                    return;
                }
                l.hideSoftKeyPad(d.this.ktg.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.ktg.finish();
            }
        });
        if (this.ktn) {
            this.kto = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kto = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.ktq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kto.setVisibility(8);
                d.this.ktq.setVisibility(8);
                d.this.ktp.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.ktg.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.kts = (ImageView) this.ktq.findViewById(R.id.new_friend_search);
        this.ktp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.ktp.setVisibility(8);
        this.mEditText = (EditText) this.ktp.findViewById(R.id.search_bar_edit);
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
                        d.this.ktr.setVisibility(0);
                    } else {
                        d.this.ktr.setVisibility(8);
                    }
                    d.this.cVI();
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
        this.ktr = (TextView) this.ktp.findViewById(R.id.search_bar_delete_button);
        this.ktr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVI() {
        if (this.ktg != null) {
            this.ktg.cVG();
        }
    }

    public void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ktg.getLayoutMode().setNightMode(skinType == 1);
        this.ktg.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bqB().a(this.kts, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.ktg.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ktg.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cVJ() {
        this.Wa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cVK() {
        l.hideSoftKeyPad(this.ktg.getPageContext().getPageActivity(), this.mEditText);
        this.ktp.setVisibility(8);
        this.kto.setVisibility(0);
        this.ktq.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cVL() {
        return this.ktp != null && this.ktp.getVisibility() == 0;
    }

    public int cVM() {
        return this.ktl.getId();
    }

    public String cVN() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cVO() {
        return this.ktj.getDataList();
    }

    public void r(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kth == null) {
            this.kth = new c(this.ktg, this.ktn);
            this.kth.a(this);
            this.kth.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cVT() <= d.this.ktj.getItemLength()) {
                                d.this.ktg.showToast(String.format(d.this.ktg.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.ktm)));
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
            this.Wa.setAdapter((ListAdapter) this.kth);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Wa.setVisibility(8);
            if (!this.ktn) {
                this.ktk.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Wa.setVisibility(0);
        this.kth.setData(list);
        this.kth.notifyDataSetChanged();
        if (!this.ktn) {
            this.ktk.setVisibility(0);
        }
    }

    public void cVP() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ktg.getPageContext());
        }
    }

    public void cVQ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.brC();
        }
    }

    private void cVR() {
        int dimensionPixelSize = this.ktg.getResources().getDimensionPixelSize(R.dimen.ds80) + this.ktg.getResources().getDimensionPixelSize(R.dimen.ds16) + this.ktg.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.ktg.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Wa.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ktj.d(aVar);
            DY(this.ktj.getItemLength());
            cVS();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ktj.f(aVar);
            DY(this.ktj.getItemLength());
            cVS();
        }
    }

    private void cVS() {
        if (this.ktj.getItemLength() > 0) {
            this.ktl.setEnabled(true);
        } else {
            this.ktl.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.ktg.getPageContext().getPageActivity(), this.mEditText);
    }

    private void DY(int i) {
        this.ktl.setText(String.format(this.ktg.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cVT() {
        return this.ktm;
    }

    public void DZ(int i) {
        this.ktm = i;
        this.ktj.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ktj.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
