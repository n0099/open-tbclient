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
    private BdListView VX;
    private final InviteFriendListActivity kaa;
    private c kab;
    private View kac;
    private InviteFriendCandidateList kad;
    private LinearLayout kae;
    private Button kaf;
    private int kag;
    private boolean kah;
    private TextView kai;
    private View kaj;
    private View kak;
    private TextView kal;
    private ImageView kam;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private View mRoot;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.kag = 0;
        this.kaa = inviteFriendListActivity;
        this.kah = z;
        initialize();
    }

    public View getRootView() {
        return this.mRoot;
    }

    private void initialize() {
        this.kaa.setContentView(R.layout.invite_friend_list);
        this.mRoot = this.kaa.findViewById(R.id.root_view);
        byD();
        this.VX = (BdListView) this.mRoot.findViewById(R.id.friend_list);
        this.VX.setOnItemClickListener(this.kaa);
        if (this.kah) {
            this.mNoDataView = NoDataViewFactory.a(this.kaa.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fkb), NoDataViewFactory.d.aX(R.string.no_friends, R.string.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.kaa.getPageContext().getPageActivity(), this.mRoot, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.fkb), NoDataViewFactory.d.aX(R.string.no_chat_friends, R.string.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(R.string.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.kaa.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.mRoot.findViewById(R.id.progress);
        this.kad = (InviteFriendCandidateList) this.mRoot.findViewById(R.id.candidate_list);
        this.kad.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void a(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.VX.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.kae = (LinearLayout) this.mRoot.findViewById(R.id.invite_candidate);
        this.kac = this.mRoot.findViewById(R.id.invite_candidate_border);
        if (this.kah) {
            this.kae.setVisibility(8);
            this.kac.setVisibility(8);
        }
        cQD();
        this.kaf = (Button) this.mRoot.findViewById(R.id.button_send);
        this.kaf.setOnClickListener(this.kaa);
        bok();
        cQv();
        CU(0);
    }

    private void byD() {
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.kaj != null && d.this.kaj.getVisibility() == 0) {
                    d.this.cQw();
                    return;
                }
                l.hideSoftKeyPad(d.this.kaa.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.kaa.finish();
            }
        });
        if (this.kah) {
            this.kai = this.mNavigationBar.setTitleText(R.string.invite_contact_title);
        } else {
            this.kai = this.mNavigationBar.setTitleText(R.string.invite_friend);
        }
        this.kak = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.kai.setVisibility(8);
                d.this.kak.setVisibility(8);
                d.this.kaj.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.showSoftKeyPad(d.this.kaa.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.kam = (ImageView) this.kak.findViewById(R.id.new_friend_search);
        this.kaj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
        this.kaj.setVisibility(8);
        this.mEditText = (EditText) this.kaj.findViewById(R.id.search_bar_edit);
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
                        d.this.kal.setVisibility(0);
                    } else {
                        d.this.kal.setVisibility(8);
                    }
                    d.this.cQu();
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
        this.kal = (TextView) this.kaj.findViewById(R.id.search_bar_delete_button);
        this.kal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQu() {
        if (this.kaa != null) {
            this.kaa.cQs();
        }
    }

    public void bok() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.kaa.getLayoutMode().setNightMode(skinType == 1);
        this.kaa.getLayoutMode().onModeChanged(this.mRoot);
        SvgManager.bmU().a(this.kam, R.drawable.icon_pure_topbar_search44_svg, R.color.cp_cont_b, (SvgManager.SvgResourceStateType) null);
        this.mNavigationBar.onChangeSkinType(this.kaa.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.kaa.getPageContext(), skinType);
        ap.setBackgroundResource(this.mListFooter, R.drawable.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void cQv() {
        this.VX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.hideKeyboard();
                return false;
            }
        });
    }

    public void cQw() {
        l.hideSoftKeyPad(this.kaa.getPageContext().getPageActivity(), this.mEditText);
        this.kaj.setVisibility(8);
        this.kai.setVisibility(0);
        this.kak.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean cQx() {
        return this.kaj != null && this.kaj.getVisibility() == 0;
    }

    public int cQy() {
        return this.kaf.getId();
    }

    public String cQz() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String cQA() {
        return this.kad.getDataList();
    }

    public void q(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.kab == null) {
            this.kab = new c(this.kaa, this.kah);
            this.kab.a(this);
            this.kab.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.hideKeyboard();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.cQF() <= d.this.kad.getItemLength()) {
                                d.this.kaa.showToast(String.format(d.this.kaa.getPageContext().getString(R.string.invite_friend_exceed_max_count), Integer.valueOf(d.this.kag)));
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
            this.VX.setAdapter((ListAdapter) this.kab);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.VX.setVisibility(8);
            if (!this.kah) {
                this.kae.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.VX.setVisibility(0);
        this.kab.setData(list);
        this.kab.notifyDataSetChanged();
        if (!this.kah) {
            this.kae.setVisibility(0);
        }
    }

    public void cQB() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.kaa.getPageContext());
        }
    }

    public void cQC() {
        if (this.mNoDataView != null) {
            this.mNoDataView.bnV();
        }
    }

    private void cQD() {
        int dimensionPixelSize = this.kaa.getResources().getDimensionPixelSize(R.dimen.ds80) + this.kaa.getResources().getDimensionPixelSize(R.dimen.ds16) + this.kaa.getResources().getDimensionPixelSize(R.dimen.ds16);
        this.mListFooter = new View(this.kaa.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.VX.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kad.d(aVar);
            CU(this.kad.getItemLength());
            cQE();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kad.f(aVar);
            CU(this.kad.getItemLength());
            cQE();
        }
    }

    private void cQE() {
        if (this.kad.getItemLength() > 0) {
            this.kaf.setEnabled(true);
        } else {
            this.kaf.setEnabled(false);
        }
    }

    public void hideKeyboard() {
        l.hideSoftKeyPad(this.kaa.getPageContext().getPageActivity(), this.mEditText);
    }

    private void CU(int i) {
        this.kaf.setText(String.format(this.kaa.getPageContext().getString(R.string.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int cQF() {
        return this.kag;
    }

    public void CV(int i) {
        this.kag = i;
        this.kad.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.kad.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
