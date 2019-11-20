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
import com.baidu.tbadk.core.util.am;
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
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private ImageView gTA;
    private final InviteFriendListActivity gTo;
    private c gTp;
    private View gTq;
    private InviteFriendCandidateList gTr;
    private LinearLayout gTs;
    private Button gTt;
    private int gTu;
    private boolean gTv;
    private TextView gTw;
    private View gTx;
    private View gTy;
    private TextView gTz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;
    private BdListView xL;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.gTu = 0;
        this.gTo = inviteFriendListActivity;
        this.gTv = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.gTo.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.gTo.findViewById(R.id.root_view);
        aJv();
        this.xL = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.xL.setOnItemClickListener(this.gTo);
        if (this.gTv) {
            this.mNoDataView = NoDataViewFactory.a(this.gTo.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.ai(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.gTo.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.NET_RERESHNEW_TOP_MARGIN), NoDataViewFactory.d.ai(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.gTo.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.gTr = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.gTr.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.xL.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.gTs = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.gTq = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.gTv) {
            this.gTs.setVisibility(8);
            this.gTq.setVisibility(8);
        }
        bFh();
        this.gTt = (Button) this.mRoot.findViewById(R.id.button_send);
        this.gTt.setOnClickListener(this.gTo);
        anM();
        bEZ();
        uK(0);
    }

    private void aJv() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.gTx != null && d.this.gTx.getVisibility() == 0) {
                    d.this.bFa();
                    return;
                }
                l.hideSoftKeyPad(d.this.gTo.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.gTo.finish();
            }
        });
        if (this.gTv) {
            this.gTw = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.gTw = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.gTy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.gTw.setVisibility(8);
                d.this.gTy.setVisibility(8);
                d.this.gTx.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.gTo.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.gTA = (ImageView) this.gTy.findViewById(R.id.new_friend_search);
        this.gTx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.gTx.setVisibility(8);
        this.mEditText = (EditText) this.gTx.findViewById(R.id.search_bar_edit);
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
                        d.this.gTz.setVisibility(0);
                    } else {
                        d.this.gTz.setVisibility(8);
                    }
                    d.this.bEY();
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
        this.gTz = (TextView) this.gTx.findViewById(R.id.search_bar_delete_button);
        this.gTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEY() {
        if (this.gTo != null) {
            this.gTo.bEW();
        }
    }

    public void anM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.gTo.getLayoutMode().setNightMode(skinType == 1);
        this.gTo.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.amL().a(this.gTA, R.drawable.icon_pure_topbar_search_n_svg, R.color.cp_cont_b, null);
        this.mNavigationBar.onChangeSkinType(this.gTo.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.gTo.getPageContext(), skinType);
        am.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void bEZ() {
        this.xL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void bFa() {
        l.hideSoftKeyPad(this.gTo.getPageContext().getPageActivity(), this.mEditText);
        this.gTx.setVisibility(8);
        this.gTw.setVisibility(0);
        this.gTy.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean bFb() {
        return this.gTx != null && this.gTx.getVisibility() == 0;
    }

    public int bFc() {
        return this.gTt.getId();
    }

    public String bFd() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String bFe() {
        return this.gTr.getDataList();
    }

    public void p(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.gTp == null) {
            this.gTp = new c(this.gTo, this.gTv);
            this.gTp.a(this);
            this.gTp.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.bFj() <= d.this.gTr.getItemLength()) {
                                d.this.gTo.showToast(String.format(d.this.gTo.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.gTu)));
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
            this.xL.setAdapter((ListAdapter) this.gTp);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.xL.setVisibility(8);
            if (!this.gTv) {
                this.gTs.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.xL.setVisibility(0);
        this.gTp.setData(list);
        this.gTp.notifyDataSetChanged();
        if (!this.gTv) {
            this.gTs.setVisibility(0);
        }
    }

    public void bFf() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.gTo.getPageContext());
        }
    }

    public void bFg() {
        if (this.mNoDataView != null) {
            this.mNoDataView.anE();
        }
    }

    private void bFh() {
        int dimensionPixelSize = this.gTo.getResources().getDimensionPixelSize(R.dimen.ds80) + this.gTo.getResources().getDimensionPixelSize(R.dimen.ds16) + this.gTo.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.gTo.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.xL.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTr.d(aVar);
            uK(this.gTr.getItemLength());
            bFi();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTr.f(aVar);
            uK(this.gTr.getItemLength());
            bFi();
        }
    }

    private void bFi() {
        if (this.gTr.getItemLength() > 0) {
            this.gTt.setEnabled(true);
        } else {
            this.gTt.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.gTo.getPageContext().getPageActivity(), this.mEditText);
    }

    private void uK(int i) {
        this.gTt.setText(String.format(this.gTo.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int bFj() {
        return this.gTu;
    }

    public void uL(int i) {
        this.gTu = i;
        this.gTr.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.gTr.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
