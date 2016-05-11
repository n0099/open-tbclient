package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] ctt;
    private TextView bYV;
    private PersonalChatActivity ctl;
    private LinearLayout ctm;
    private LinearLayout ctn;
    private TextView cto;
    private TextView ctp;
    private TextView ctq;
    private Button ctr;
    private View.OnClickListener cts;

    static /* synthetic */ int[] ajc() {
        int[] iArr = ctt;
        if (iArr == null) {
            iArr = new int[PersonalMsglistModel.CardStatus.valuesCustom().length];
            try {
                iArr[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            ctt = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.cts = new q(this);
        if (!this.ctl.aiX() && this.mTool != null) {
            b(this.mTool.eg(6));
            b(this.mTool.eg(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ctl = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(t.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.personal_info_btn, talkableActivity);
            this.bYV = (TextView) this.mBtnGroupInfo.findViewById(t.g.group_info_btn_txt);
            this.bYV.setText(string);
        }
        if (!this.ctl.aiX()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.ctm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(t.g.stranger_person_add_friend_stub)).inflate();
            this.ctn = (LinearLayout) this.ctm.findViewById(t.g.add_friend_tip_full);
            this.cto = (TextView) this.ctm.findViewById(t.g.add_friend_tip_title);
            this.ctp = (TextView) this.ctm.findViewById(t.g.add_friend_tip_content);
            this.ctq = (TextView) this.ctm.findViewById(t.g.add_friend_tip_center);
            this.ctr = (Button) this.ctm.findViewById(t.g.add_friend_tip_button);
            this.ctr.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ctm.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bYV != null) {
            at.c(this.bYV, t.d.s_navbar_title_color, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.s sVar) {
        if (sVar != null && sVar != null && (sVar instanceof View)) {
            ((View) sVar).setOnClickListener(this.cts);
        }
    }

    private void aiZ() {
        if (this.mTool != null) {
            this.mTool.Bk();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (ajc()[cardStatus.ordinal()]) {
            case 1:
                aja();
                return;
            case 2:
                eU(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case 4:
                eV(z);
                return;
            default:
                return;
        }
    }

    private void aja() {
        this.ctn.setVisibility(0);
        this.ctq.setVisibility(8);
        this.cto.setText(t.j.add_friend_title);
        this.ctp.setText(t.j.add_friend_content);
        this.ctr.setText(t.j.add_friend_button);
    }

    private void eU(boolean z) {
        if (this.ctl.aiU().akV() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.ctq.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new s(this, translateAnimation3));
            this.ctn.setVisibility(8);
            this.ctn.startAnimation(translateAnimation4);
        } else {
            this.ctn.setVisibility(8);
            this.ctq.setVisibility(0);
        }
        this.ctq.setText(t.j.add_friend_wait);
        this.ctr.setText(t.j.add_friend_button);
    }

    private void j(boolean z, String str) {
        String userName = this.ctl.aiU().getUser().getUserName();
        this.ctq.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.ctn.setVisibility(0);
            this.ctn.startAnimation(translateAnimation2);
        } else {
            this.ctn.setVisibility(0);
            this.cto.setText(this.ctl.getResources().getString(t.j.add_friend_agree_title, userName));
            this.ctp.setText(str);
        }
        this.ctr.setText(t.j.add_friend_agree_button);
    }

    private void eV(boolean z) {
        aiZ();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.ctm.startAnimation(translateAnimation);
            return;
        }
        this.ctm.setVisibility(8);
    }

    public Button ajb() {
        return this.ctr;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
