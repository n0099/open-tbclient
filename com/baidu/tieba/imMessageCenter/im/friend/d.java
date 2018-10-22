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
    private ImageView eUA;
    private final InviteFriendListActivity eUo;
    private c eUp;
    private View eUq;
    private InviteFriendCandidateList eUr;
    private LinearLayout eUs;
    private Button eUt;
    private int eUu;
    private boolean eUv;
    private TextView eUw;
    private View eUx;
    private View eUy;
    private TextView eUz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eUu = 0;
        this.eUo = inviteFriendListActivity;
        this.eUv = z;
        initialize();
    }

    public View getRootView() {
        return this.aix;
    }

    private void initialize() {
        this.eUo.setContentView(e.h.invite_friend_list);
        this.aix = this.eUo.findViewById(e.g.root_view);
        axw();
        this.OE = (BdListView) this.aix.findViewById(e.g.friend_list);
        this.OE.setOnItemClickListener(this.eUo);
        if (this.eUv) {
            this.mNoDataView = NoDataViewFactory.a(this.eUo.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bdY), NoDataViewFactory.d.G(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eUo.getPageContext().getPageActivity(), this.aix, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bdY), NoDataViewFactory.d.G(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eUo.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aix.findViewById(e.g.progress);
        this.eUr = (InviteFriendCandidateList) this.aix.findViewById(e.g.candidate_list);
        this.eUr.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.eUs = (LinearLayout) this.aix.findViewById(e.g.invite_candidate);
        this.eUq = this.aix.findViewById(e.g.invite_candidate_border);
        if (this.eUv) {
            this.eUs.setVisibility(8);
            this.eUq.setVisibility(8);
        }
        aUa();
        this.eUt = (Button) this.aix.findViewById(e.g.button_send);
        this.eUt.setOnClickListener(this.eUo);
        DV();
        aTS();
        pK(0);
    }

    private void axw() {
        this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eUx != null && d.this.eUx.getVisibility() == 0) {
                    d.this.aTT();
                    return;
                }
                l.a(d.this.eUo.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eUo.finish();
            }
        });
        if (this.eUv) {
            this.eUw = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.eUw = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.eUy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eUw.setVisibility(8);
                d.this.eUy.setVisibility(8);
                d.this.eUx.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.b(d.this.eUo.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eUA = (ImageView) this.eUy.findViewById(e.g.new_friend_search);
        this.eUx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eUx.setVisibility(8);
        this.mEditText = (EditText) this.eUx.findViewById(e.g.search_bar_edit);
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
                        d.this.eUz.setVisibility(0);
                    } else {
                        d.this.eUz.setVisibility(8);
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
        this.eUz = (TextView) this.eUx.findViewById(e.g.search_bar_delete_button);
        this.eUz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTR() {
        if (this.eUo != null) {
            this.eUo.aTP();
        }
    }

    public void DV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eUo.getLayoutMode().setNightMode(skinType == 1);
        this.eUo.getLayoutMode().onModeChanged(this.aix);
        al.a(this.eUA, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eUo.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eUo.getPageContext(), skinType);
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
        l.a(this.eUo.getPageContext().getPageActivity(), this.mEditText);
        this.eUx.setVisibility(8);
        this.eUw.setVisibility(0);
        this.eUy.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aTU() {
        return this.eUx != null && this.eUx.getVisibility() == 0;
    }

    public int aTV() {
        return this.eUt.getId();
    }

    public String aTW() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aTX() {
        return this.eUr.aTM();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eUp == null) {
            this.eUp = new c(this.eUo, this.eUv);
            this.eUp.a(this);
            this.eUp.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aUc();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aUd() <= d.this.eUr.getItemLength()) {
                                d.this.eUo.showToast(String.format(d.this.eUo.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eUu)));
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
            this.OE.setAdapter((ListAdapter) this.eUp);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OE.setVisibility(8);
            if (!this.eUv) {
                this.eUs.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OE.setVisibility(0);
        this.eUp.setData(list);
        this.eUp.notifyDataSetChanged();
        if (!this.eUv) {
            this.eUs.setVisibility(0);
        }
    }

    public void aTY() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eUo.getPageContext());
        }
    }

    public void aTZ() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aUa() {
        int dimensionPixelSize = this.eUo.getResources().getDimensionPixelSize(e.C0175e.ds80) + this.eUo.getResources().getDimensionPixelSize(e.C0175e.ds16) + this.eUo.getResources().getDimensionPixelSize(e.C0175e.ds16);
        this.mListFooter = new View(this.eUo.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OE.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUr.d(aVar);
            pK(this.eUr.getItemLength());
            aUb();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUr.f(aVar);
            pK(this.eUr.getItemLength());
            aUb();
        }
    }

    private void aUb() {
        if (this.eUr.getItemLength() > 0) {
            this.eUt.setEnabled(true);
        } else {
            this.eUt.setEnabled(false);
        }
    }

    public void aUc() {
        l.a(this.eUo.getPageContext().getPageActivity(), this.mEditText);
    }

    private void pK(int i) {
        this.eUt.setText(String.format(this.eUo.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aUd() {
        return this.eUu;
    }

    public void pL(int i) {
        this.eUu = i;
        this.eUr.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eUr.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
