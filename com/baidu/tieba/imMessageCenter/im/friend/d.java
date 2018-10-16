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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView OE;
    private View aix;
    private final InviteFriendListActivity eUn;
    private c eUo;
    private View eUp;
    private InviteFriendCandidateList eUq;
    private LinearLayout eUr;
    private Button eUs;
    private int eUt;
    private boolean eUu;
    private TextView eUv;
    private View eUw;
    private View eUx;
    private TextView eUy;
    private ImageView eUz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eUt = 0;
        this.eUn = inviteFriendListActivity;
        this.eUu = z;
        initialize();
    }

    public View getRootView() {
        return this.aix;
    }

    private void initialize() {
        this.eUn.setContentView(e.h.invite_friend_list);
        this.aix = this.eUn.findViewById(e.g.root_view);
        axv();
        this.OE = (BdListView) this.aix.findViewById(e.g.friend_list);
        this.OE.setOnItemClickListener(this.eUn);
        if (this.eUu) {
            this.mNoDataView = NoDataViewFactory.a(this.eUn.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bdY), NoDataViewFactory.d.G(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eUn.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bdY), NoDataViewFactory.d.G(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eUn.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aix.findViewById(e.g.progress);
        this.eUq = (InviteFriendCandidateList) this.aix.findViewById(e.g.candidate_list);
        this.eUq.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.OE.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eUr = (LinearLayout) this.aix.findViewById(e.g.invite_candidate);
        this.eUp = this.aix.findViewById(e.g.invite_candidate_border);
        if (this.eUu) {
            this.eUr.setVisibility(8);
            this.eUp.setVisibility(8);
        }
        aUa();
        this.eUs = (Button) this.aix.findViewById(e.g.button_send);
        this.eUs.setOnClickListener(this.eUn);
        DV();
        aTS();
        pK(0);
    }

    private void axv() {
        this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eUw != null && d.this.eUw.getVisibility() == 0) {
                    d.this.aTT();
                    return;
                }
                l.a(d.this.eUn.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eUn.finish();
            }
        });
        if (this.eUu) {
            this.eUv = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.eUv = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.eUx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eUv.setVisibility(8);
                d.this.eUx.setVisibility(8);
                d.this.eUw.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.b(d.this.eUn.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eUz = (ImageView) this.eUx.findViewById(e.g.new_friend_search);
        this.eUw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eUw.setVisibility(8);
        this.mEditText = (EditText) this.eUw.findViewById(e.g.search_bar_edit);
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
                        d.this.eUy.setVisibility(0);
                    } else {
                        d.this.eUy.setVisibility(8);
                    }
                    d.this.aTR();
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
        this.eUy = (TextView) this.eUw.findViewById(e.g.search_bar_delete_button);
        this.eUy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTR() {
        if (this.eUn != null) {
            this.eUn.aTP();
        }
    }

    public void DV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eUn.getLayoutMode().setNightMode(skinType == 1);
        this.eUn.getLayoutMode().onModeChanged(this.aix);
        al.a(this.eUz, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eUn.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eUn.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aTS() {
        this.OE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aUc();
                return false;
            }
        });
    }

    public void aTT() {
        l.a(this.eUn.getPageContext().getPageActivity(), this.mEditText);
        this.eUw.setVisibility(8);
        this.eUv.setVisibility(0);
        this.eUx.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aTU() {
        return this.eUw != null && this.eUw.getVisibility() == 0;
    }

    public int aTV() {
        return this.eUs.getId();
    }

    public String aTW() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aTX() {
        return this.eUq.aTM();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eUo == null) {
            this.eUo = new c(this.eUn, this.eUu);
            this.eUo.a(this);
            this.eUo.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aUc();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aUd() <= d.this.eUq.getItemLength()) {
                                d.this.eUn.showToast(String.format(d.this.eUn.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eUt)));
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
            this.OE.setAdapter((ListAdapter) this.eUo);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OE.setVisibility(8);
            if (!this.eUu) {
                this.eUr.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OE.setVisibility(0);
        this.eUo.setData(list);
        this.eUo.notifyDataSetChanged();
        if (!this.eUu) {
            this.eUr.setVisibility(0);
        }
    }

    public void aTY() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eUn.getPageContext());
        }
    }

    public void aTZ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aUa() {
        int dimensionPixelSize = this.eUn.getResources().getDimensionPixelSize(e.C0175e.ds80) + this.eUn.getResources().getDimensionPixelSize(e.C0175e.ds16) + this.eUn.getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.mListFooter = new View(this.eUn.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OE.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUq.d(aVar);
            pK(this.eUq.getItemLength());
            aUb();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUq.f(aVar);
            pK(this.eUq.getItemLength());
            aUb();
        }
    }

    private void aUb() {
        if (this.eUq.getItemLength() > 0) {
            this.eUs.setEnabled(true);
        } else {
            this.eUs.setEnabled(false);
        }
    }

    public void aUc() {
        l.a(this.eUn.getPageContext().getPageActivity(), this.mEditText);
    }

    private void pK(int i) {
        this.eUs.setText(String.format(this.eUn.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aUd() {
        return this.eUt;
    }

    public void pL(int i) {
        this.eUt = i;
        this.eUq.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUq.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
