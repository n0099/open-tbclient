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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private View aHT;
    private BdListView auZ;
    private final InviteFriendListActivity eQY;
    private c eQZ;
    private View eRa;
    private InviteFriendCandidateList eRb;
    private LinearLayout eRc;
    private Button eRd;
    private int eRe;
    private boolean eRf;
    private TextView eRg;
    private View eRh;
    private View eRi;
    private TextView eRj;
    private ImageView eRk;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private h mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;
    private EditText rD;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.eRe = 0;
        this.eQY = inviteFriendListActivity;
        this.eRf = z;
        Em();
    }

    public View getRootView() {
        return this.aHT;
    }

    private void Em() {
        this.eQY.setContentView(d.h.invite_friend_list);
        this.aHT = this.eQY.findViewById(d.g.root_view);
        awO();
        this.auZ = (BdListView) this.aHT.findViewById(d.g.friend_list);
        this.auZ.setOnItemClickListener(this.eQY);
        if (this.eRf) {
            this.mNoDataView = NoDataViewFactory.a(this.eQY.getPageContext().getPageActivity(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCM), NoDataViewFactory.d.aC(d.j.no_friends, d.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.eQY.getPageContext().getPageActivity(), this.aHT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bCM), NoDataViewFactory.d.aC(d.j.no_chat_friends, d.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.eQY.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.aHT.findViewById(d.g.progress);
        this.eRb = (InviteFriendCandidateList) this.aHT.findViewById(d.g.candidate_list);
        this.eRb.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.auZ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.eRc = (LinearLayout) this.aHT.findViewById(d.g.invite_candidate);
        this.eRa = this.aHT.findViewById(d.g.invite_candidate_border);
        if (this.eRf) {
            this.eRc.setVisibility(8);
            this.eRa.setVisibility(8);
        }
        aNg();
        this.eRd = (Button) this.aHT.findViewById(d.g.button_send);
        this.eRd.setOnClickListener(this.eQY);
        En();
        aMY();
        qH(0);
    }

    private void awO() {
        this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.eRh != null && d.this.eRh.getVisibility() == 0) {
                    d.this.aMZ();
                    return;
                }
                l.a(d.this.eQY.getPageContext().getPageActivity(), d.this.rD);
                d.this.eQY.finish();
            }
        });
        if (this.eRf) {
            this.eRg = this.mNavigationBar.setTitleText(d.j.invite_contact_title);
        } else {
            this.eRg = this.mNavigationBar.setTitleText(d.j.invite_friend);
        }
        this.eRi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.eRg.setVisibility(8);
                d.this.eRi.setVisibility(8);
                d.this.eRh.setVisibility(0);
                d.this.rD.requestFocus();
                l.b(d.this.eQY.getPageContext().getPageActivity(), d.this.rD);
            }
        });
        this.eRk = (ImageView) this.eRi.findViewById(d.g.new_friend_search);
        this.eRh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.eRh.setVisibility(8);
        this.rD = (EditText) this.eRh.findViewById(d.g.search_bar_edit);
        if (this.rD.getParent() != null) {
            ((View) this.rD.getParent()).setFocusable(true);
            ((View) this.rD.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.eRj.setVisibility(0);
                    } else {
                        d.this.eRj.setVisibility(8);
                    }
                    d.this.aMX();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.rD.addTextChangedListener(this.mTextWatcher);
        this.eRj = (TextView) this.eRh.findViewById(d.g.search_bar_delete_button);
        this.eRj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.rD.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMX() {
        if (this.eQY != null) {
            this.eQY.aMV();
        }
    }

    public void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.eQY.getLayoutMode().aQ(skinType == 1);
        this.eQY.getLayoutMode().aM(this.aHT);
        aj.a(this.eRk, d.f.icon_search_bg_s, d.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.eQY.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.eQY.getPageContext(), skinType);
        aj.s(this.mListFooter, d.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aMY() {
        this.auZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aNi();
                return false;
            }
        });
    }

    public void aMZ() {
        l.a(this.eQY.getPageContext().getPageActivity(), this.rD);
        this.eRh.setVisibility(8);
        this.eRg.setVisibility(0);
        this.eRi.setVisibility(0);
        this.rD.getText().clear();
    }

    public boolean aNa() {
        return this.eRh != null && this.eRh.getVisibility() == 0;
    }

    public int aNb() {
        return this.eRd.getId();
    }

    public String aNc() {
        Editable text = this.rD.getText();
        return text != null ? text.toString() : "";
    }

    public String aNd() {
        return this.eRb.aMS();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.eQZ == null) {
            this.eQZ = new c(this.eQY, this.eRf);
            this.eQZ.a(this);
            this.eQZ.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aNi();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aNj() <= d.this.eRb.getItemLength()) {
                                d.this.eQY.showToast(String.format(d.this.eQY.getPageContext().getString(d.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.eRe)));
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
            this.auZ.setAdapter((ListAdapter) this.eQZ);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.auZ.setVisibility(8);
            if (!this.eRf) {
                this.eRc.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.auZ.setVisibility(0);
        this.eQZ.setData(list);
        this.eQZ.notifyDataSetChanged();
        if (!this.eRf) {
            this.eRc.setVisibility(0);
        }
    }

    public void aNe() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.eQY.getPageContext());
        }
    }

    public void aNf() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aNg() {
        int dimensionPixelSize = this.eQY.getResources().getDimensionPixelSize(d.e.ds80) + this.eQY.getResources().getDimensionPixelSize(d.e.ds16) + this.eQY.getResources().getDimensionPixelSize(d.e.ds16);
        this.mListFooter = new View(this.eQY.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.auZ.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eRb.d(aVar);
            qH(this.eRb.getItemLength());
            aNh();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eRb.f(aVar);
            qH(this.eRb.getItemLength());
            aNh();
        }
    }

    private void aNh() {
        if (this.eRb.getItemLength() > 0) {
            this.eRd.setEnabled(true);
        } else {
            this.eRd.setEnabled(false);
        }
    }

    public void aNi() {
        l.a(this.eQY.getPageContext().getPageActivity(), this.rD);
    }

    private void qH(int i) {
        this.eRd.setText(String.format(this.eQY.getPageContext().getString(d.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aNj() {
        return this.eRe;
    }

    public void qI(int i) {
        this.eRe = i;
        this.eRb.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.eRb.e(aVar);
        }
    }

    public void onDestroy() {
        this.rD.removeTextChangedListener(this.mTextWatcher);
    }
}
