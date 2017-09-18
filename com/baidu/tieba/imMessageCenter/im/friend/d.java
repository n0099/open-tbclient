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
    private EditText dIv;
    private final InviteFriendListActivity dLV;
    private c dLW;
    private View dLX;
    private InviteFriendCandidateList dLY;
    private LinearLayout dLZ;
    private Button dMa;
    private int dMb;
    private boolean dMc;
    private TextView dMd;
    private View dMe;
    private View dMf;
    private TextView dMg;
    private ImageView dMh;
    private View mListFooter;
    private NavigationBar mNavigationBar;
    private j mNoDataView;
    private ProgressBar mProgress;
    private TextWatcher mTextWatcher;

    public d(InviteFriendListActivity inviteFriendListActivity, boolean z) {
        super(inviteFriendListActivity.getPageContext());
        this.dMb = 0;
        this.dLV = inviteFriendListActivity;
        this.dMc = z;
        xb();
    }

    public View getRootView() {
        return this.Rh;
    }

    private void xb() {
        this.dLV.setContentView(d.j.invite_friend_list);
        this.Rh = this.dLV.findViewById(d.h.root_view);
        XD();
        this.Hw = (BdListView) this.Rh.findViewById(d.h.friend_list);
        this.Hw.setOnItemClickListener(this.dLV);
        if (this.dMc) {
            this.mNoDataView = NoDataViewFactory.a(this.dLV.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMb), NoDataViewFactory.d.B(d.l.no_friends, d.l.no_friends_tip), null);
        } else {
            this.mNoDataView = NoDataViewFactory.a(this.dLV.getPageContext().getPageActivity(), this.Rh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.aMb), NoDataViewFactory.d.B(d.l.no_chat_friends, d.l.no_chat_friends_tip), NoDataViewFactory.b.a(new NoDataViewFactory.a(TbadkCoreApplication.getInst().getResources().getString(d.l.find_new_friend), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(d.this.dLV.getPageContext().getPageActivity())));
                }
            })));
        }
        this.mProgress = (ProgressBar) this.Rh.findViewById(d.h.progress);
        this.dLY = (InviteFriendCandidateList) this.Rh.findViewById(d.h.candidate_list);
        this.dLY.a(new InviteFriendCandidateList.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.2
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
        this.dLZ = (LinearLayout) this.Rh.findViewById(d.h.invite_candidate);
        this.dLX = this.Rh.findViewById(d.h.invite_candidate_border);
        if (this.dMc) {
            this.dLZ.setVisibility(8);
            this.dLX.setVisibility(8);
        }
        aBF();
        this.dMa = (Button) this.Rh.findViewById(d.h.button_send);
        this.dMa.setOnClickListener(this.dLV);
        xc();
        aBx();
        np(0);
    }

    private void XD() {
        this.mNavigationBar = (NavigationBar) this.Rh.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.dMe != null && d.this.dMe.getVisibility() == 0) {
                    d.this.aBy();
                    return;
                }
                k.a(d.this.dLV.getPageContext().getPageActivity(), d.this.dIv);
                d.this.dLV.finish();
            }
        });
        if (this.dMc) {
            this.dMd = this.mNavigationBar.setTitleText(d.l.invite_contact_title);
        } else {
            this.dMd = this.mNavigationBar.setTitleText(d.l.invite_friend);
        }
        this.dMf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.add_new_friend_text, new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dMd.setVisibility(8);
                d.this.dMf.setVisibility(8);
                d.this.dMe.setVisibility(0);
                d.this.dIv.requestFocus();
                k.b(d.this.dLV.getPageContext().getPageActivity(), d.this.dIv);
            }
        });
        this.dMh = (ImageView) this.dMf.findViewById(d.h.new_friend_search);
        this.dMe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.j.navigationbar_search_edit, (View.OnClickListener) null);
        this.dMe.setVisibility(8);
        this.dIv = (EditText) this.dMe.findViewById(d.h.search_bar_edit);
        if (this.dIv.getParent() != null) {
            ((View) this.dIv.getParent()).setFocusable(true);
            ((View) this.dIv.getParent()).setFocusableInTouchMode(true);
        }
        this.mTextWatcher = new TextWatcher() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.5
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String a = com.baidu.adp.lib.util.j.a(editable, null);
                if (a != null) {
                    if (a.length() > 0) {
                        d.this.dMg.setVisibility(0);
                    } else {
                        d.this.dMg.setVisibility(8);
                    }
                    d.this.aBw();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        this.dIv.addTextChangedListener(this.mTextWatcher);
        this.dMg = (TextView) this.dMe.findViewById(d.h.search_bar_delete_button);
        this.dMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                d.this.dIv.getText().clear();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBw() {
        if (this.dLV != null) {
            this.dLV.aBu();
        }
    }

    public void xc() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        this.dLV.getLayoutMode().ah(skinType == 1);
        this.dLV.getLayoutMode().t(this.Rh);
        aj.a(this.dMh, d.g.icon_search_bg_s, d.g.icon_search_bg);
        this.mNavigationBar.onChangeSkinType(this.dLV.getPageContext(), skinType);
        this.mNoDataView.onChangeSkinType(this.dLV.getPageContext(), skinType);
        aj.j(this.mListFooter, d.g.invite_friend_list_item_bg_color);
        this.mListFooter.setEnabled(false);
    }

    public void aBx() {
        this.Hw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                d.this.aBH();
                return false;
            }
        });
    }

    public void aBy() {
        k.a(this.dLV.getPageContext().getPageActivity(), this.dIv);
        this.dMe.setVisibility(8);
        this.dMd.setVisibility(0);
        this.dMf.setVisibility(0);
        this.dIv.getText().clear();
    }

    public boolean aBz() {
        return this.dMe != null && this.dMe.getVisibility() == 0;
    }

    public int aBA() {
        return this.dMa.getId();
    }

    public String aBB() {
        Editable text = this.dIv.getText();
        return text != null ? text.toString() : "";
    }

    public String aBC() {
        return this.dLY.aBr();
    }

    public void m(List<com.baidu.tbadk.coreExtra.relationship.a> list, boolean z) {
        if (this.dLW == null) {
            this.dLW = new c(this.dLV, this.dMc);
            this.dLW.a(this);
            this.dLW.a(new TbCheckBox.a() { // from class: com.baidu.tieba.imMessageCenter.im.friend.d.8
                @Override // com.baidu.tbadk.core.view.TbCheckBox.a
                public void a(TbCheckBox tbCheckBox, boolean z2, Object obj) {
                    d.this.aBH();
                    if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                        if (z2) {
                            if (d.this.aBI() <= d.this.dLY.getItemLength()) {
                                d.this.dLV.showToast(String.format(d.this.dLV.getPageContext().getString(d.l.invite_friend_exceed_max_count), Integer.valueOf(d.this.dMb)));
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
            this.Hw.setAdapter((ListAdapter) this.dLW);
        }
        if (!z && list.isEmpty()) {
            this.mNoDataView.setVisibility(0);
            this.Hw.setVisibility(8);
            if (!this.dMc) {
                this.dLZ.setVisibility(8);
                return;
            }
            return;
        }
        this.mNoDataView.setVisibility(8);
        this.Hw.setVisibility(0);
        this.dLW.setData(list);
        this.dLW.notifyDataSetChanged();
        if (!this.dMc) {
            this.dLZ.setVisibility(0);
        }
    }

    public void aBD() {
        if (this.mNoDataView != null) {
            this.mNoDataView.e(this.dLV.getPageContext());
        }
    }

    public void aBE() {
        if (this.mNoDataView != null) {
            this.mNoDataView.onActivityStop();
        }
    }

    private void aBF() {
        int dimensionPixelSize = this.dLV.getResources().getDimensionPixelSize(d.f.ds80) + this.dLV.getResources().getDimensionPixelSize(d.f.ds16) + this.dLV.getResources().getDimensionPixelSize(d.f.ds16);
        this.mListFooter = new View(this.dLV.getPageContext().getPageActivity());
        this.mListFooter.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.mListFooter.setEnabled(false);
        this.Hw.addFooterView(this.mListFooter);
    }

    public void g(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLY.d(aVar);
            np(this.dLY.getItemLength());
            aBG();
        }
    }

    public void h(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLY.f(aVar);
            np(this.dLY.getItemLength());
            aBG();
        }
    }

    private void aBG() {
        if (this.dLY.getItemLength() > 0) {
            this.dMa.setEnabled(true);
        } else {
            this.dMa.setEnabled(false);
        }
    }

    public void aBH() {
        k.a(this.dLV.getPageContext().getPageActivity(), this.dIv);
    }

    private void np(int i) {
        this.dMa.setText(String.format(this.dLV.getPageContext().getString(d.l.invite_friend_candidate_send), Integer.valueOf(i)));
    }

    public int aBI() {
        return this.dMb;
    }

    public void nq(int i) {
        this.dMb = i;
        this.dLY.setMaxCount(i);
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.c.b
    public void a(View view, com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (aVar != null) {
            this.dLY.e(aVar);
        }
    }

    public void onDestroy() {
        this.dIv.removeTextChangedListener(this.mTextWatcher);
    }
}
