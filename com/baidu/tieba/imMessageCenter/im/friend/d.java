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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView LS;
    private View abt;
    private c eBA;
    private View eBB;
    private InviteFriendCandidateList eBC;
    private LinearLayout eBD;
    private Button eBE;
    private int eBF;
    private boolean eBG;
    private TextView eBH;
    private View eBI;
    private View eBJ;
    private TextView eBK;
    private ImageView eBL;
    private final InviteFriendListActivity eBz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eBF = 0;
        this.eBz = inviteFriendListActivity;
        this.eBG = z;
        initialize();
    }

    public View getRootView() {
        return this.abt;
    }

    private void initialize() {
        this.eBz.setContentView(d.i.invite_friend_list);
        this.abt = this.eBz.findViewById(d.g.root_view);
        arI();
        this.LS = (BdListView) this.abt.findViewById(d.g.friend_list);
        this.LS.setOnItemClickListener(this.eBz);
        if (this.eBG) {
            this.mNoDataView = NoDataViewFactory.a(this.eBz.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWg), NoDataViewFactory.d.D(d.k.no_friends, d.k.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eBz.getPageContext().getPageActivity(), this.abt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWg), NoDataViewFactory.d.D(d.k.no_chat_friends, d.k.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.k.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eBz.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.abt.findViewById(d.g.progress);
        this.eBC = (InviteFriendCandidateList) this.abt.findViewById(d.g.candidate_list);
        this.eBC.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.LS.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eBD = (LinearLayout) this.abt.findViewById(d.g.invite_candidate);
        this.eBB = this.abt.findViewById(d.g.invite_candidate_border);
        if (this.eBG) {
            this.eBD.setVisibility(8);
            this.eBB.setVisibility(8);
        }
        aNA();
        this.eBE = (Button) this.abt.findViewById(d.g.button_send);
        this.eBE.setOnClickListener(this.eBz);
        AP();
        aNs();
        ou(0);
    }

    private void arI() {
        this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eBI != null && d.this.eBI.getVisibility() == 0) {
                    d.this.aNt();
                    return;
                }
                l.b(d.this.eBz.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eBz.finish();
            }
        });
        if (this.eBG) {
            this.eBH = this.mNavigationBar.setTitleText(d.k.invite_contact_title);
        } else {
            this.eBH = this.mNavigationBar.setTitleText(d.k.invite_friend);
        }
        this.eBJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eBH.setVisibility(8);
                d.this.eBJ.setVisibility(8);
                d.this.eBI.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.eBz.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eBL = (ImageView) this.eBJ.findViewById(d.g.new_friend_search);
        this.eBI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.navigationbar_search_edit, (View.OnClickListener) null);
        this.eBI.setVisibility(8);
        this.mEditText = (EditText) this.eBI.findViewById(d.g.search_bar_edit);
        if (this.mEditText.getParent() != null) {
            ((View) this.mEditText.getParent()).setFocusable(true);
            ((View) this.mEditText.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eBK.setVisibility(0);
                    } else {
                        d.this.eBK.setVisibility(8);
                    }
                    d.this.aNr();
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
        this.eBK = (TextView) this.eBI.findViewById(d.g.search_bar_delete_button);
        this.eBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNr() {
        if (this.eBz != null) {
            this.eBz.aNp();
        }
    }

    public void AP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eBz.getLayoutMode().setNightMode(skinType == 1);
        this.eBz.getLayoutMode().onModeChanged(this.abt);
        am.a(this.eBL, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eBz.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eBz.getPageContext(), skinType);
        am.i(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aNs() {
        this.LS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aNC();
                return false;
            }
        });
    }

    public void aNt() {
        l.b(this.eBz.getPageContext().getPageActivity(), this.mEditText);
        this.eBI.setVisibility(8);
        this.eBH.setVisibility(0);
        this.eBJ.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aNu() {
        return this.eBI != null && this.eBI.getVisibility() == 0;
    }

    public int aNv() {
        return this.eBE.getId();
    }

    public String aNw() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aNx() {
        return this.eBC.aNm();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eBA == null) {
            this.eBA = new c(this.eBz, this.eBG);
            this.eBA.a(this);
            this.eBA.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aNC();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aND() <= d.this.eBC.getItemLength()) {
                                d.this.eBz.showToast(String.format(d.this.eBz.getPageContext().getString(d.k.invite_friend_exceed_max_count), Integer.valueOf(d.this.eBF)));
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
            this.LS.setAdapter((ListAdapter) this.eBA);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.LS.setVisibility(8);
            if (!this.eBG) {
                this.eBD.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.LS.setVisibility(0);
        this.eBA.setData(list);
        this.eBA.notifyDataSetChanged();
        if (!this.eBG) {
            this.eBD.setVisibility(0);
        }
    }

    public void aNy() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eBz.getPageContext());
        }
    }

    public void aNz() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aNA() {
        int dimensionPixelSize = this.eBz.getResources().getDimensionPixelSize(d.e.ds80) + this.eBz.getResources().getDimensionPixelSize(d.e.ds16) + this.eBz.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eBz.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.LS.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eBC.d(aVar);
            ou(this.eBC.getItemLength());
            aNB();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eBC.f(aVar);
            ou(this.eBC.getItemLength());
            aNB();
        }
    }

    private void aNB() {
        if (this.eBC.getItemLength() > 0) {
            this.eBE.setEnabled(true);
        } else {
            this.eBE.setEnabled(false);
        }
    }

    public void aNC() {
        l.b(this.eBz.getPageContext().getPageActivity(), this.mEditText);
    }

    private void ou(int i) {
        this.eBE.setText(String.format(this.eBz.getPageContext().getString(d.k.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aND() {
        return this.eBF;
    }

    public void ov(int i) {
        this.eBF = i;
        this.eBC.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eBC.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
