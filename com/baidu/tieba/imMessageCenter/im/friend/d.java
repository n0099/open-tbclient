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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
import com.baidu.tieba.imMessageCenter.im.friend.c;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<InviteFriendListActivity> implements c.b {
    private BdListView HN;
    private View Rt;
    private EditText dEK;
    private final InviteFriendListActivity dIl;
    private c dIm;
    private View dIn;
    private InviteFriendCandidateList dIo;
    private LinearLayout dIp;
    private Button dIq;
    private int dIr;
    private boolean dIs;
    private TextView dIt;
    private View dIu;
    private View dIv;
    private TextView dIw;
    private ImageView dIx;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private f mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dIr = 0;
        this.dIl = inviteFriendListActivity;
        this.dIs = z;
        wA();
    }

    public View getRootView() {
        return this.Rt;
    }

    private void wA() {
        this.dIl.setContentView(d.j.invite_friend_list);
        this.Rt = this.dIl.findViewById(d.h.root_view);
        aiB();
        this.HN = (BdListView) this.Rt.findViewById(d.h.friend_list);
        this.HN.setOnItemClickListener(this.dIl);
        if (this.dIs) {
            this.mNoDataView = NoDataViewFactory.a(this.dIl.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLD), NoDataViewFactory.d.D(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dIl.getPageContext().getPageActivity(), this.Rt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aLD), NoDataViewFactory.d.D(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dIl.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Rt.findViewById(d.h.progress);
        this.dIo = (InviteFriendCandidateList) this.Rt.findViewById(d.h.candidate_list);
        this.dIo.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
            @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
            public void b(View view, Object obj) {
                if (obj != null) {
                    if (obj instanceof TbCheckBox.b) {
                        ((TbCheckBox.b) obj).setChecked(false);
                    }
                    View findViewWithTag = d.this.HN.findViewWithTag(obj);
                    if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                        ((TbCheckBox) findViewWithTag).setChecked(false);
                    } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                        d.this.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
                    }
                }
            }
        });
        this.dIp = (LinearLayout) this.Rt.findViewById(d.h.invite_candidate);
        this.dIn = this.Rt.findViewById(d.h.invite_candidate_border);
        if (this.dIs) {
            this.dIp.setVisibility(8);
            this.dIn.setVisibility(8);
        }
        aAq();
        this.dIq = (Button) this.Rt.findViewById(d.h.button_send);
        this.dIq.setOnClickListener(this.dIl);
        wB();
        aAi();
        nl(0);
    }

    private void aiB() {
        this.mNavigationBar = (NavigationBar) this.Rt.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dIu != null && d.this.dIu.getVisibility() == 0) {
                    d.this.aAj();
                    return;
                }
                l.a(d.this.dIl.getPageContext().getPageActivity(), d.this.dEK);
                d.this.dIl.finish();
            }
        });
        if (this.dIs) {
            this.dIt = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dIt = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dIv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dIt.setVisibility(8);
                d.this.dIv.setVisibility(8);
                d.this.dIu.setVisibility(0);
                d.this.dEK.requestFocus();
                l.b(d.this.dIl.getPageContext().getPageActivity(), d.this.dEK);
            }
        });
        this.dIx = (ImageView) this.dIv.findViewById(d.h.new_friend_search);
        this.dIu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dIu.setVisibility(8);
        this.dEK = (EditText) this.dIu.findViewById(d.h.search_bar_edit);
        if (this.dEK.getParent() != null) {
            ((View) this.dEK.getParent()).setFocusable(true);
            ((View) this.dEK.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = k.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dIw.setVisibility(0);
                    } else {
                        d.this.dIw.setVisibility(8);
                    }
                    d.this.aAh();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dEK.addTextChangedListener(this.mTextWatcher);
        this.dIw = (TextView) this.dIu.findViewById(d.h.search_bar_delete_button);
        this.dIw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dEK.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAh() {
        if (this.dIl != null) {
            this.dIl.aAf();
        }
    }

    public void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dIl.getLayoutMode().ai(skinType == 1);
        this.dIl.getLayoutMode().t(this.Rt);
        aj.a(this.dIx, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dIl.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dIl.getPageContext(), skinType);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aAi() {
        this.HN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aAs();
                return false;
            }
        });
    }

    public void aAj() {
        l.a(this.dIl.getPageContext().getPageActivity(), this.dEK);
        this.dIu.setVisibility(8);
        this.dIt.setVisibility(0);
        this.dIv.setVisibility(0);
        this.dEK.getText().clear();
    }

    public boolean aAk() {
        return this.dIu != null && this.dIu.getVisibility() == 0;
    }

    public int aAl() {
        return this.dIq.getId();
    }

    public String aAm() {
        Editable text = this.dEK.getText();
        return text != null ? text.toString() : "";
    }

    public String aAn() {
        return this.dIo.aAc();
    }

    public void k(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dIm == null) {
            this.dIm = new c(this.dIl, this.dIs);
            this.dIm.a(this);
            this.dIm.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aAs();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aAt() <= d.this.dIo.getItemLength()) {
                                d.this.dIl.showToast(String.format(d.this.dIl.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dIr)));
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
            this.HN.setAdapter((ListAdapter) this.dIm);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.HN.setVisibility(8);
            if (!this.dIs) {
                this.dIp.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.HN.setVisibility(0);
        this.dIm.setData(list);
        this.dIm.notifyDataSetChanged();
        if (!this.dIs) {
            this.dIp.setVisibility(0);
        }
    }

    public void aAo() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dIl.getPageContext());
        }
    }

    public void aAp() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aAq() {
        int dimensionPixelSize = this.dIl.getResources().getDimensionPixelSize(d.f.ds80) + this.dIl.getResources().getDimensionPixelSize(d.f.ds16) + this.dIl.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dIl.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.HN.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIo.d(aVar);
            nl(this.dIo.getItemLength());
            aAr();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIo.f(aVar);
            nl(this.dIo.getItemLength());
            aAr();
        }
    }

    private void aAr() {
        if (this.dIo.getItemLength() > 0) {
            this.dIq.setEnabled(true);
        } else {
            this.dIq.setEnabled(false);
        }
    }

    public void aAs() {
        l.a(this.dIl.getPageContext().getPageActivity(), this.dEK);
    }

    private void nl(int i) {
        this.dIq.setText(String.format(this.dIl.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aAt() {
        return this.dIr;
    }

    public void nm(int i) {
        this.dIr = i;
        this.dIo.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dIo.e(aVar);
        }
    }

    public void onDestroy() {
        this.dEK.removeTextChangedListener(this.mTextWatcher);
    }
}
