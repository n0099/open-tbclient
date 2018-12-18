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
    private Button fcA;
    private int fcB;
    private boolean fcC;
    private TextView fcD;
    private View fcE;
    private View fcF;
    private TextView fcG;
    private ImageView fcH;
    private final InviteFriendListActivity fcv;
    private c fcw;
    private View fcx;
    private InviteFriendCandidateList fcy;
    private LinearLayout fcz;
    private EditText mEditText;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.fcB = 0;
        this.fcv = inviteFriendListActivity;
        this.fcC = z;
        initialize();
    }

    public View getRootView() {
        return this.amM;
    }

    private void initialize() {
        this.fcv.setContentView(e.h.invite_friend_list);
        this.amM = this.fcv.findViewById(e.g.root_view);
        ayF();
        this.OF = (BdListView) this.amM.findViewById(e.g.friend_list);
        this.OF.setOnItemClickListener(this.fcv);
        if (this.fcC) {
            this.mNoDataView = NoDataViewFactory.a(this.fcv.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bio), NoDataViewFactory.d.H(e.j.no_friends, e.j.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.fcv.getPageContext().getPageActivity(), this.amM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.bio), NoDataViewFactory.d.H(e.j.no_chat_friends, e.j.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(e.j.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(d.this.fcv.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.amM.findViewById(e.g.progress);
        this.fcy = (InviteFriendCandidateList) this.amM.findViewById(e.g.candidate_list);
        this.fcy.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.fcz = (LinearLayout) this.amM.findViewById(e.g.invite_candidate);
        this.fcx = this.amM.findViewById(e.g.invite_candidate_border);
        if (this.fcC) {
            this.fcz.setVisibility(8);
            this.fcx.setVisibility(8);
        }
        aVo();
        this.fcA = (Button) this.amM.findViewById(e.g.button_send);
        this.fcA.setOnClickListener(this.fcv);
        Fj();
        aVg();
        qx(0);
    }

    private void ayF() {
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.fcE != null && d.this.fcE.getVisibility() == 0) {
                    d.this.aVh();
                    return;
                }
                l.b(d.this.fcv.getPageContext().getPageActivity(), d.this.mEditText);
                d.this.fcv.finish();
            }
        });
        if (this.fcC) {
            this.fcD = this.mNavigationBar.setTitleText(e.j.invite_contact_title);
        } else {
            this.fcD = this.mNavigationBar.setTitleText(e.j.invite_friend);
        }
        this.fcF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.fcD.setVisibility(8);
                d.this.fcF.setVisibility(8);
                d.this.fcE.setVisibility(0);
                d.this.mEditText.requestFocus();
                l.c(d.this.fcv.getPageContext().getPageActivity(), d.this.mEditText);
            }
        });
        this.fcH = (ImageView) this.fcF.findViewById(e.g.new_friend_search);
        this.fcE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.navigationbar_search_edit, (View.OnClickListener) null);
        this.fcE.setVisibility(8);
        this.mEditText = (EditText) this.fcE.findViewById(e.g.search_bar_edit);
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
                        d.this.fcG.setVisibility(0);
                    } else {
                        d.this.fcG.setVisibility(8);
                    }
                    d.this.aVf();
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
        this.fcG = (TextView) this.fcE.findViewById(e.g.search_bar_delete_button);
        this.fcG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.mEditText.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVf() {
        if (this.fcv != null) {
            this.fcv.aVd();
        }
    }

    public void Fj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.fcv.getLayoutMode().setNightMode(skinType == 1);
        this.fcv.getLayoutMode().onModeChanged(this.amM);
        al.a(this.fcH, e.f.icon_search_bg_s, e.f.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.fcv.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.fcv.getPageContext(), skinType);
        al.i(this.mListFooter, e.f.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aVg() {
        this.OF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aVq();
                return false;
            }
        });
    }

    public void aVh() {
        l.b(this.fcv.getPageContext().getPageActivity(), this.mEditText);
        this.fcE.setVisibility(8);
        this.fcD.setVisibility(0);
        this.fcF.setVisibility(0);
        this.mEditText.getText().clear();
    }

    public boolean aVi() {
        return this.fcE != null && this.fcE.getVisibility() == 0;
    }

    public int aVj() {
        return this.fcA.getId();
    }

    public String aVk() {
        Editable text = this.mEditText.getText();
        return text != null ? text.toString() : "";
    }

    public String aVl() {
        return this.fcy.aVa();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.fcw == null) {
            this.fcw = new c(this.fcv, this.fcC);
            this.fcw.a(this);
            this.fcw.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aVq();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aVr() <= d.this.fcy.getItemLength()) {
                                d.this.fcv.showToast(String.format(d.this.fcv.getPageContext().getString(e.j.invite_friend_exceed_max_count), Integer.valueOf(d.this.fcB)));
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
            this.OF.setAdapter((ListAdapter) this.fcw);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.OF.setVisibility(8);
            if (!this.fcC) {
                this.fcz.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.OF.setVisibility(0);
        this.fcw.setData(list);
        this.fcw.notifyDataSetChanged();
        if (!this.fcC) {
            this.fcz.setVisibility(0);
        }
    }

    public void aVm() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.fcv.getPageContext());
        }
    }

    public void aVn() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aVo() {
        int dimensionPixelSize = this.fcv.getResources().getDimensionPixelSize(e.C0210e.ds80) + this.fcv.getResources().getDimensionPixelSize(e.C0210e.ds16) + this.fcv.getResources().getDimensionPixelSize(e.C0210e.ds16);
        this.mListFooter = new View(this.fcv.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.OF.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fcy.d(aVar);
            qx(this.fcy.getItemLength());
            aVp();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fcy.f(aVar);
            qx(this.fcy.getItemLength());
            aVp();
        }
    }

    private void aVp() {
        if (this.fcy.getItemLength() > 0) {
            this.fcA.setEnabled(true);
        } else {
            this.fcA.setEnabled(false);
        }
    }

    public void aVq() {
        l.b(this.fcv.getPageContext().getPageActivity(), this.mEditText);
    }

    private void qx(int i) {
        this.fcA.setText(String.format(this.fcv.getPageContext().getString(e.j.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aVr() {
        return this.fcB;
    }

    public void qy(int i) {
        this.fcB = i;
        this.fcy.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.fcy.e(aVar);
        }
    }

    public void onDestroy() {
        this.mEditText.removeTextChangedListener(this.mTextWatcher);
    }
}
