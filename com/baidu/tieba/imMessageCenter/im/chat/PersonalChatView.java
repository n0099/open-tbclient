package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] djj;
    private TextView cOB;
    private PersonalChatActivity djb;
    private LinearLayout djc;
    private LinearLayout djd;
    private TextView dje;
    private TextView djf;
    private TextView djg;
    private Button djh;
    private View.OnClickListener dji;

    static /* synthetic */ int[] atb() {
        int[] iArr = djj;
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
            djj = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dji = new q(this);
        if (!this.djb.asW() && this.mTool != null) {
            b(this.mTool.ew(6));
            b(this.mTool.ew(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.djb = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cOB = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cOB.setText(string);
        }
        if (!this.djb.asW()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.djc = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.djd = (LinearLayout) this.djc.findViewById(w.h.add_friend_tip_full);
            this.dje = (TextView) this.djc.findViewById(w.h.add_friend_tip_title);
            this.djf = (TextView) this.djc.findViewById(w.h.add_friend_tip_content);
            this.djg = (TextView) this.djc.findViewById(w.h.add_friend_tip_center);
            this.djh = (Button) this.djc.findViewById(w.h.add_friend_tip_button);
            this.djh.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.djc.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cOB != null) {
            aq.c(this.cOB, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.dji);
        }
    }

    private void asY() {
        if (this.mTool != null) {
            this.mTool.Ct();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (atb()[cardStatus.ordinal()]) {
            case 1:
                asZ();
                return;
            case 2:
                gg(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case 4:
                gh(z);
                return;
            default:
                return;
        }
    }

    private void asZ() {
        this.djd.setVisibility(0);
        this.djg.setVisibility(8);
        this.dje.setText(w.l.add_friend_title);
        this.djf.setText(w.l.add_friend_content);
        this.djh.setText(w.l.add_friend_button);
    }

    private void gg(boolean z) {
        if (this.djb.asT().atN() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.djg.startAnimation(translateAnimation2);
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
            this.djd.setVisibility(8);
            this.djd.startAnimation(translateAnimation4);
        } else {
            this.djd.setVisibility(8);
            this.djg.setVisibility(0);
        }
        this.djg.setText(w.l.add_friend_wait);
        this.djh.setText(w.l.add_friend_button);
    }

    private void g(boolean z, String str) {
        String userName = this.djb.asT().getUser().getUserName();
        this.djg.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.djd.setVisibility(0);
            this.djd.startAnimation(translateAnimation2);
        } else {
            this.djd.setVisibility(0);
            this.dje.setText(this.djb.getResources().getString(w.l.add_friend_agree_title, userName));
            this.djf.setText(str);
        }
        this.djh.setText(w.l.add_friend_agree_button);
    }

    private void gh(boolean z) {
        asY();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.djc.startAnimation(translateAnimation);
            return;
        }
        this.djc.setVisibility(8);
    }

    public Button ata() {
        return this.djh;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
