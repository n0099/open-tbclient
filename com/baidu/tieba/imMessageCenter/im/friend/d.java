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
    private BdListView OF;
    private View amM;
    private final InviteFriendListActivity ffm;
    private c ffn;
    private View ffo;
    private InviteFriendCandidateList ffp;
    private LinearLayout ffq;
    private Button ffr;
    private int ffs;
    private boolean fft;
    private TextView ffu;
    private View ffv;
    private View ffw;
    private TextView ffx;
    private ImageView ffy;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.ffs = 0;
        this.ffm = inviteFriendListActivity;
        this.fft = z;
        initialize();
    }

    public View getRootView() {
        return this.amM;
    }

    private void initialize() {
        this.ffm.setContentView(e.h.invite_friend_list);
        this.amM = this.ffm.findViewById(e.g.root_view);
        azu();
        this.OF = (BdListView) this.amM.findViewById(e.g.friend_list);
        this.OF.setOnItemClickListener(this.ffm);
        if (this.fft) {
            this.mNoDataView = NoDataViewFactory.a(this.ffm.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bir), NoDataViewFactory.d.H(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.ffm.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bir), NoDataViewFactory.d.H(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.ffm.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.amM.findViewById(e.g.progress);
        this.ffp = (InviteFriendCandidateList) this.amM.findViewById(e.g.candidate_list);
        this.ffp.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.OF.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.ffq = (LinearLayout) this.amM.findViewById(e.g.invite_candidate);
        this.ffo = this.amM.findViewById(e.g.invite_candidate_border);
        if (this.fft) {
            this.ffq.setVisibility(8);
            this.ffo.setVisibility(8);
        }
        aWc();
        this.ffr = (Button) this.amM.findViewById(e.g.button_send);
        this.ffr.setOnClickListener(this.ffm);
        Fj();
        aVU();
        qK(0);
    }

    private void azu() {
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.ffv != null && d.this.ffv.getVisibility() == 0) {
                    d.this.aVV();
                    return;
                }
                l.b(d.this.ffm.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.ffm.finish();
            }
        });
        if (this.fft) {
            this.ffu = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.ffu = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.ffw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.ffu.setVisibility(8);
                d.this.ffw.setVisibility(8);
                d.this.ffv.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.ffm.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.ffy = (ImageView) this.ffw.findViewById(e.g.new_friend_search);
        this.ffv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.ffv.setVisibility(8);
        this.mEditText = (EditText) this.ffv.findViewById(e.g.search_bar_edit);
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
                        d.this.ffx.setVisibility(0);
                    } else {
                        d.this.ffx.setVisibility(8);
                    }
                    d.this.aVT();
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
        this.ffx = (TextView) this.ffv.findViewById(e.g.search_bar_delete_button);
        this.ffx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVT() {
        if (this.ffm != null) {
            this.ffm.aVR();
        }
    }

    public void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.ffm.getLayoutMode().setNightMode(skinType == 1);
        this.ffm.getLayoutMode().onModeChanged(this.amM);
        al.a(this.ffy, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.ffm.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.ffm.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aVU() {
        this.OF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aWe();
                return false;
            }
        });
    }

    public void aVV() {
        l.b(this.ffm.getPageContext().getPageActivity(), this.mEditText);
        this.ffv.setVisibility(8);
        this.ffu.setVisibility(0);
        this.ffw.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aVW() {
        return this.ffv != null && this.ffv.getVisibility() == 0;
    }

    public int aVX() {
        return this.ffr.getId();
    }

    public String aVY() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aVZ() {
        return this.ffp.aVO();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.ffn == null) {
            this.ffn = new c(this.ffm, this.fft);
            this.ffn.a(this);
            this.ffn.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aWe();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aWf() <= d.this.ffp.getItemLength()) {
                                d.this.ffm.showToast(String.format(d.this.ffm.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.ffs)));
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
            this.OF.setAdapter((ListAdapter) this.ffn);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OF.setVisibility(8);
            if (!this.fft) {
                this.ffq.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OF.setVisibility(0);
        this.ffn.setData(list);
        this.ffn.notifyDataSetChanged();
        if (!this.fft) {
            this.ffq.setVisibility(0);
        }
    }

    public void aWa() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.ffm.getPageContext());
        }
    }

    public void aWb() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aWc() {
        int dimensionPixelSize = this.ffm.getResources().getDimensionPixelSize(e.C0210e.ds80) + this.ffm.getResources().getDimensionPixelSize(e.C0210e.ds16) + this.ffm.getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.mListFooter = new View(this.ffm.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OF.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ffp.d(aVar);
            qK(this.ffp.getItemLength());
            aWd();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ffp.f(aVar);
            qK(this.ffp.getItemLength());
            aWd();
        }
    }

    private void aWd() {
        if (this.ffp.getItemLength() > 0) {
            this.ffr.setEnabled(true);
        } else {
            this.ffr.setEnabled(false);
        }
    }

    public void aWe() {
        l.b(this.ffm.getPageContext().getPageActivity(), this.mEditText);
    }

    private void qK(int i) {
        this.ffr.setText(String.format(this.ffm.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aWf() {
        return this.ffs;
    }

    public void qL(int i) {
        this.ffs = i;
        this.ffp.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.ffp.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
