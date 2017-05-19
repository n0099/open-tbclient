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
    private static /* synthetic */ int[] ddO;
    private TextView cJd;
    private PersonalChatActivity ddG;
    private LinearLayout ddH;
    private LinearLayout ddI;
    private TextView ddJ;
    private TextView ddK;
    private TextView ddL;
    private Button ddM;
    private View.OnClickListener ddN;

    static /* synthetic */ int[] asd() {
        int[] iArr = ddO;
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
            ddO = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ddN = new q(this);
        if (!this.ddG.arY() && this.mTool != null) {
            b(this.mTool.ev(6));
            b(this.mTool.ev(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ddG = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cJd = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cJd.setText(string);
        }
        if (!this.ddG.arY()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.ddH = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.ddI = (LinearLayout) this.ddH.findViewById(w.h.add_friend_tip_full);
            this.ddJ = (TextView) this.ddH.findViewById(w.h.add_friend_tip_title);
            this.ddK = (TextView) this.ddH.findViewById(w.h.add_friend_tip_content);
            this.ddL = (TextView) this.ddH.findViewById(w.h.add_friend_tip_center);
            this.ddM = (Button) this.ddH.findViewById(w.h.add_friend_tip_button);
            this.ddM.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ddH.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cJd != null) {
            aq.c(this.cJd, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.ddN);
        }
    }

    private void asa() {
        if (this.mTool != null) {
            this.mTool.Cz();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (asd()[cardStatus.ordinal()]) {
            case 1:
                asb();
                return;
            case 2:
                fT(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case 4:
                fU(z);
                return;
            default:
                return;
        }
    }

    private void asb() {
        this.ddI.setVisibility(0);
        this.ddL.setVisibility(8);
        this.ddJ.setText(w.l.add_friend_title);
        this.ddK.setText(w.l.add_friend_content);
        this.ddM.setText(w.l.add_friend_button);
    }

    private void fT(boolean z) {
        if (this.ddG.arV().asS() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.ddL.startAnimation(translateAnimation2);
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
            this.ddI.setVisibility(8);
            this.ddI.startAnimation(translateAnimation4);
        } else {
            this.ddI.setVisibility(8);
            this.ddL.setVisibility(0);
        }
        this.ddL.setText(w.l.add_friend_wait);
        this.ddM.setText(w.l.add_friend_button);
    }

    private void g(boolean z, String str) {
        String userName = this.ddG.arV().getUser().getUserName();
        this.ddL.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.ddI.setVisibility(0);
            this.ddI.startAnimation(translateAnimation2);
        } else {
            this.ddI.setVisibility(0);
            this.ddJ.setText(this.ddG.getResources().getString(w.l.add_friend_agree_title, userName));
            this.ddK.setText(str);
        }
        this.ddM.setText(w.l.add_friend_agree_button);
    }

    private void fU(boolean z) {
        asa();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.ddH.startAnimation(translateAnimation);
            return;
        }
        this.ddH.setVisibility(8);
    }

    public Button asc() {
        return this.ddM;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
