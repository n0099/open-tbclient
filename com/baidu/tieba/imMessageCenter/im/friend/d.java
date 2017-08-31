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
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView Hw;
    private View Rh;
    private EditText dHA;
    private final InviteFriendListActivity dLb;
    private c dLc;
    private View dLd;
    private InviteFriendCandidateList dLe;
    private LinearLayout dLf;
    private Button dLg;
    private int dLh;
    private boolean dLi;
    private TextView dLj;
    private View dLk;
    private View dLl;
    private TextView dLm;
    private ImageView dLn;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dLh = 0;
        this.dLb = inviteFriendListActivity;
        this.dLi = z;
        xb();
    }

    public View getRootView() {
        return this.Rh;
    }

    private void xb() {
        this.dLb.setContentView(d.j.invite_friend_list);
        this.Rh = this.dLb.findViewById(d.h.root_view);
        Xs();
        this.Hw = (BdListView) this.Rh.findViewById(d.h.friend_list);
        this.Hw.setOnItemClickListener(this.dLb);
        if (this.dLi) {
            this.mNoDataView = NoDataViewFactory.a(this.dLb.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMe), NoDataViewFactory.d.B(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dLb.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMe), NoDataViewFactory.d.B(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dLb.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dLe = (InviteFriendCandidateList) this.Rh.findViewById(d.h.candidate_list);
        this.dLe.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.Hw.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dLf = (LinearLayout) this.Rh.findViewById(d.h.invite_candidate);
        this.dLd = this.Rh.findViewById(d.h.invite_candidate_border);
        if (this.dLi) {
            this.dLf.setVisibility(8);
            this.dLd.setVisibility(8);
        }
        aBu();
        this.dLg = (Button) this.Rh.findViewById(d.h.button_send);
        this.dLg.setOnClickListener(this.dLb);
        xc();
        aBm();
        nn(0);
    }

    private void Xs() {
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dLk != null && d.this.dLk.getVisibility() == 0) {
                    d.this.aBn();
                    return;
                }
                k.a(d.this.dLb.getPageContext().getPageActivity(), d.this.dHA);
                d.this.dLb.finish();
            }
        });
        if (this.dLi) {
            this.dLj = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dLj = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dLl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dLj.setVisibility(8);
                d.this.dLl.setVisibility(8);
                d.this.dLk.setVisibility(0);
                d.this.dHA.requestFocus();
                k.b(d.this.dLb.getPageContext().getPageActivity(), d.this.dHA);
            }
        });
        this.dLn = (ImageView) this.dLl.findViewById(d.h.new_friend_search);
        this.dLk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dLk.setVisibility(8);
        this.dHA = (EditText) this.dLk.findViewById(d.h.search_bar_edit);
        if (this.dHA.getParent() != null) {
            ((View) this.dHA.getParent()).setFocusable(true);
            ((View) this.dHA.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = com.baidu.adp.lib.util.j.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dLm.setVisibility(0);
                    } else {
                        d.this.dLm.setVisibility(8);
                    }
                    d.this.aBl();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dHA.addTextChangedListener(this.mTextWatcher);
        this.dLm = (TextView) this.dLk.findViewById(d.h.search_bar_delete_button);
        this.dLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dHA.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBl() {
        if (this.dLb != null) {
            this.dLb.aBj();
        }
    }

    public void xc() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dLb.getLayoutMode().ah(skinType == 1);
        this.dLb.getLayoutMode().t(this.Rh);
        aj.a(this.dLn, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dLb.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dLb.getPageContext(), skinType);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aBm() {
        this.Hw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aBw();
                return false;
            }
        });
    }

    public void aBn() {
        k.a(this.dLb.getPageContext().getPageActivity(), this.dHA);
        this.dLk.setVisibility(8);
        this.dLj.setVisibility(0);
        this.dLl.setVisibility(0);
        this.dHA.getText().clear();
    }

    public boolean aBo() {
        return this.dLk != null && this.dLk.getVisibility() == 0;
    }

    public int aBp() {
        return this.dLg.getId();
    }

    public String aBq() {
        Editable text = this.dHA.getText();
        return text != null ? text.toString() : "";
    }

    public String aBr() {
        return this.dLe.aBg();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dLc == null) {
            this.dLc = new c(this.dLb, this.dLi);
            this.dLc.a(this);
            this.dLc.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aBw();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aBx() <= d.this.dLe.getItemLength()) {
                                d.this.dLb.showToast(String.format(d.this.dLb.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dLh)));
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
            this.Hw.setAdapter((ListAdapter) this.dLc);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hw.setVisibility(8);
            if (!this.dLi) {
                this.dLf.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hw.setVisibility(0);
        this.dLc.setData(list);
        this.dLc.notifyDataSetChanged();
        if (!this.dLi) {
            this.dLf.setVisibility(0);
        }
    }

    public void aBs() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dLb.getPageContext());
        }
    }

    public void aBt() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aBu() {
        int dimensionPixelSize = this.dLb.getResources().getDimensionPixelSize(d.f.ds80) + this.dLb.getResources().getDimensionPixelSize(d.f.ds16) + this.dLb.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dLb.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hw.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLe.d(aVar);
            nn(this.dLe.getItemLength());
            aBv();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLe.f(aVar);
            nn(this.dLe.getItemLength());
            aBv();
        }
    }

    private void aBv() {
        if (this.dLe.getItemLength() > 0) {
            this.dLg.setEnabled(true);
        } else {
            this.dLg.setEnabled(false);
        }
    }

    public void aBw() {
        k.a(this.dLb.getPageContext().getPageActivity(), this.dHA);
    }

    private void nn(int i) {
        this.dLg.setText(String.format(this.dLb.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aBx() {
        return this.dLh;
    }

    public void no(int i) {
        this.dLh = i;
        this.dLe.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLe.e(aVar);
        }
    }

    public void onDestroy() {
        this.dHA.removeTextChangedListener(this.mTextWatcher);
    }
}
