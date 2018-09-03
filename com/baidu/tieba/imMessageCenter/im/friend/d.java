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
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView LO;
    private View aaW;
    private TextView eFA;
    private ImageView eFB;
    private final InviteFriendListActivity eFp;
    private c eFq;
    private View eFr;
    private InviteFriendCandidateList eFs;
    private LinearLayout eFt;
    private Button eFu;
    private int eFv;
    private boolean eFw;
    private TextView eFx;
    private View eFy;
    private View eFz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eFv = 0;
        this.eFp = inviteFriendListActivity;
        this.eFw = z;
        AC();
    }

    public View getRootView() {
        return this.aaW;
    }

    private void AC() {
        this.eFp.setContentView(f.h.invite_friend_list);
        this.aaW = this.eFp.findViewById(f.g.root_view);
        asl();
        this.LO = (BdListView) this.aaW.findViewById(f.g.friend_list);
        this.LO.setOnItemClickListener(this.eFp);
        if (this.eFw) {
            this.mNoDataView = NoDataViewFactory.a(this.eFp.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.E(f.j.no_friends, f.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eFp.getPageContext().getPageActivity(), this.aaW, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aWi), NoDataViewFactory.d.E(f.j.no_chat_friends, f.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(f.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eFp.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aaW.findViewById(f.g.progress);
        this.eFs = (InviteFriendCandidateList) this.aaW.findViewById(f.g.candidate_list);
        this.eFs.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.LO.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eFt = (LinearLayout) this.aaW.findViewById(f.g.invite_candidate);
        this.eFr = this.aaW.findViewById(f.g.invite_candidate_border);
        if (this.eFw) {
            this.eFt.setVisibility(8);
            this.eFr.setVisibility(8);
        }
        aOx();
        this.eFu = (Button) this.aaW.findViewById(f.g.button_send);
        this.eFu.setOnClickListener(this.eFp);
        AD();
        aOp();
        oI(0);
    }

    private void asl() {
        this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eFy != null && d.this.eFy.getVisibility() == 0) {
                    d.this.aOq();
                    return;
                }
                l.a(d.this.eFp.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.eFp.finish();
            }
        });
        if (this.eFw) {
            this.eFx = this.mNavigationBar.setTitleText(f.j.invite_contact_title);
        } else {
            this.eFx = this.mNavigationBar.setTitleText(f.j.invite_friend);
        }
        this.eFz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eFx.setVisibility(8);
                d.this.eFz.setVisibility(8);
                d.this.eFy.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.b(d.this.eFp.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.eFB = (ImageView) this.eFz.findViewById(f.g.new_friend_search);
        this.eFy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eFy.setVisibility(8);
        this.mEditText = (EditText) this.eFy.findViewById(f.g.search_bar_edit);
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
                        d.this.eFA.setVisibility(0);
                    } else {
                        d.this.eFA.setVisibility(8);
                    }
                    d.this.aOo();
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
        this.eFA = (TextView) this.eFy.findViewById(f.g.search_bar_delete_button);
        this.eFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOo() {
        if (this.eFp != null) {
            this.eFp.aOm();
        }
    }

    public void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eFp.getLayoutMode().setNightMode(skinType == 1);
        this.eFp.getLayoutMode().onModeChanged(this.aaW);
        am.a(this.eFB, f.C0146f.icon_search_bg_s, f.C0146f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eFp.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eFp.getPageContext(), skinType);
        am.i(this.mListFooter, f.C0146f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aOp() {
        this.LO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aOz();
                return false;
            }
        });
    }

    public void aOq() {
        l.a(this.eFp.getPageContext().getPageActivity(), this.mEditText);
        this.eFy.setVisibility(8);
        this.eFx.setVisibility(0);
        this.eFz.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aOr() {
        return this.eFy != null && this.eFy.getVisibility() == 0;
    }

    public int aOs() {
        return this.eFu.getId();
    }

    public String aOt() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aOu() {
        return this.eFs.aOj();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eFq == null) {
            this.eFq = new c(this.eFp, this.eFw);
            this.eFq.a(this);
            this.eFq.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aOz();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aOA() <= d.this.eFs.getItemLength()) {
                                d.this.eFp.showToast(String.format(d.this.eFp.getPageContext().getString(f.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eFv)));
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
            this.LO.setAdapter((ListAdapter) this.eFq);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.LO.setVisibility(8);
            if (!this.eFw) {
                this.eFt.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.LO.setVisibility(0);
        this.eFq.setData(list);
        this.eFq.notifyDataSetChanged();
        if (!this.eFw) {
            this.eFt.setVisibility(0);
        }
    }

    public void aOv() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eFp.getPageContext());
        }
    }

    public void aOw() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aOx() {
        int dimensionPixelSize = this.eFp.getResources().getDimensionPixelSize(f.e.ds80) + this.eFp.getResources().getDimensionPixelSize(f.e.ds16) + this.eFp.getResources().getDimensionPixelSize(f.e.ds16);
        this.mListFooter = new View(this.eFp.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.LO.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFs.d(aVar);
            oI(this.eFs.getItemLength());
            aOy();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFs.f(aVar);
            oI(this.eFs.getItemLength());
            aOy();
        }
    }

    private void aOy() {
        if (this.eFs.getItemLength() > 0) {
            this.eFu.setEnabled(true);
        } else {
            this.eFu.setEnabled(false);
        }
    }

    public void aOz() {
        l.a(this.eFp.getPageContext().getPageActivity(), this.mEditText);
    }

    private void oI(int i) {
        this.eFu.setText(String.format(this.eFp.getPageContext().getString(f.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aOA() {
        return this.eFv;
    }

    public void oJ(int i) {
        this.eFv = i;
        this.eFs.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eFs.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
