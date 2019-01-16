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
    private BdListView OQ;
    private View ano;
    private final InviteFriendListActivity ffZ;
    private c fga;
    private View fgb;
    private InviteFriendCandidateList fgc;
    private LinearLayout fgd;
    private Button fge;
    private int fgf;
    private boolean fgg;
    private TextView fgh;
    private View fgi;
    private View fgj;
    private TextView fgk;
    private ImageView fgl;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.fgf = 0;
        this.ffZ = inviteFriendListActivity;
        this.fgg = z;
        initialize();
    }

    public View getRootView() {
        return this.ano;
    }

    private void initialize() {
        this.ffZ.setContentView(e.h.invite_friend_list);
        this.ano = this.ffZ.findViewById(e.g.root_view);
        azR();
        this.OQ = (BdListView) this.ano.findViewById(e.g.friend_list);
        this.OQ.setOnItemClickListener(this.ffZ);
        if (this.fgg) {
            this.mNoDataView = NoDataViewFactory.a(this.ffZ.getPageContext().getPageActivity(), this.ano, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bja), NoDataViewFactory.d.H(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.ffZ.getPageContext().getPageActivity(), this.ano, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bja), NoDataViewFactory.d.H(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.ffZ.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.ano.findViewById(e.g.progress);
        this.fgc = (InviteFriendCandidateList) this.ano.findViewById(e.g.candidate_list);
        this.fgc.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.OQ.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.fgd = (LinearLayout) this.ano.findViewById(e.g.invite_candidate);
        this.fgb = this.ano.findViewById(e.g.invite_candidate_border);
        if (this.fgg) {
            this.fgd.setVisibility(8);
            this.fgb.setVisibility(8);
        }
        aWC();
        this.fge = (Button) this.ano.findViewById(e.g.button_send);
        this.fge.setOnClickListener(this.ffZ);
        Fw();
        aWu();
        qL(0);
    }

    private void azR() {
        this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fgi != null && d.this.fgi.getVisibility() == 0) {
                    d.this.aWv();
                    return;
                }
                l.b(d.this.ffZ.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.ffZ.finish();
            }
        });
        if (this.fgg) {
            this.fgh = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.fgh = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.fgj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fgh.setVisibility(8);
                d.this.fgj.setVisibility(8);
                d.this.fgi.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.ffZ.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.fgl = (ImageView) this.fgj.findViewById(e.g.new_friend_search);
        this.fgi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.fgi.setVisibility(8);
        this.mEditText = (EditText) this.fgi.findViewById(e.g.search_bar_edit);
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
                        d.this.fgk.setVisibility(0);
                    } else {
                        d.this.fgk.setVisibility(8);
                    }
                    d.this.aWt();
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
        this.fgk = (TextView) this.fgi.findViewById(e.g.search_bar_delete_button);
        this.fgk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWt() {
        if (this.ffZ != null) {
            this.ffZ.aWr();
        }
    }

    public void Fw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ffZ.getLayoutMode().setNightMode(skinType == 1);
        this.ffZ.getLayoutMode().onModeChanged(this.ano);
        al.a(this.fgl, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.ffZ.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ffZ.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aWu() {
        this.OQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aWE();
                return false;
            }
        });
    }

    public void aWv() {
        l.b(this.ffZ.getPageContext().getPageActivity(), this.mEditText);
        this.fgi.setVisibility(8);
        this.fgh.setVisibility(0);
        this.fgj.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aWw() {
        return this.fgi != null && this.fgi.getVisibility() == 0;
    }

    public int aWx() {
        return this.fge.getId();
    }

    public String aWy() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aWz() {
        return this.fgc.aWo();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.fga == null) {
            this.fga = new c(this.ffZ, this.fgg);
            this.fga.a(this);
            this.fga.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aWE();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aWF() <= d.this.fgc.getItemLength()) {
                                d.this.ffZ.showToast(String.format(d.this.ffZ.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.fgf)));
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
            this.OQ.setAdapter((ListAdapter) this.fga);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OQ.setVisibility(8);
            if (!this.fgg) {
                this.fgd.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OQ.setVisibility(0);
        this.fga.setData(list);
        this.fga.notifyDataSetChanged();
        if (!this.fgg) {
            this.fgd.setVisibility(0);
        }
    }

    public void aWA() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ffZ.getPageContext());
        }
    }

    public void aWB() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aWC() {
        int dimensionPixelSize = this.ffZ.getResources().getDimensionPixelSize(e.C0210e.ds80) + this.ffZ.getResources().getDimensionPixelSize(e.C0210e.ds16) + this.ffZ.getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.mListFooter = new View(this.ffZ.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OQ.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fgc.d(aVar);
            qL(this.fgc.getItemLength());
            aWD();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fgc.f(aVar);
            qL(this.fgc.getItemLength());
            aWD();
        }
    }

    private void aWD() {
        if (this.fgc.getItemLength() > 0) {
            this.fge.setEnabled(true);
        } else {
            this.fge.setEnabled(false);
        }
    }

    public void aWE() {
        l.b(this.ffZ.getPageContext().getPageActivity(), this.mEditText);
    }

    private void qL(int i) {
        this.fge.setText(String.format(this.ffZ.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aWF() {
        return this.fgf;
    }

    public void qM(int i) {
        this.fgf = i;
        this.fgc.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fgc.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
