package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] drf;
    private TextView cWx;
    private PersonalChatActivity dqX;
    private LinearLayout dqY;
    private LinearLayout dqZ;
    private TextView dra;
    private TextView drb;
    private TextView drc;
    private Button drd;
    private View.OnClickListener dre;

    static /* synthetic */ int[] awL() {
        int[] iArr = drf;
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
            drf = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dre = new q(this);
        if (!this.dqX.awG() && this.mTool != null) {
            b(this.mTool.ey(6));
            b(this.mTool.ey(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dqX = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(w.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.personal_info_btn, talkableActivity);
            this.cWx = (TextView) this.mBtnGroupInfo.findViewById(w.h.group_info_btn_txt);
            this.cWx.setText(string);
        }
        if (!this.dqX.awG()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dqY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(w.h.stranger_person_add_friend_stub)).inflate();
            this.dqZ = (LinearLayout) this.dqY.findViewById(w.h.add_friend_tip_full);
            this.dra = (TextView) this.dqY.findViewById(w.h.add_friend_tip_title);
            this.drb = (TextView) this.dqY.findViewById(w.h.add_friend_tip_content);
            this.drc = (TextView) this.dqY.findViewById(w.h.add_friend_tip_center);
            this.drd = (Button) this.dqY.findViewById(w.h.add_friend_tip_button);
            this.drd.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dqY.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cWx != null) {
            as.c(this.cWx, w.e.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.dre);
        }
    }

    private void awI() {
        if (this.mTool != null) {
            this.mTool.CO();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (awL()[cardStatus.ordinal()]) {
            case 1:
                awJ();
                return;
            case 2:
                gy(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case 4:
                gz(z);
                return;
            default:
                return;
        }
    }

    private void awJ() {
        this.dqZ.setVisibility(0);
        this.drc.setVisibility(8);
        this.dra.setText(w.l.add_friend_title);
        this.drb.setText(w.l.add_friend_content);
        this.drd.setText(w.l.add_friend_button);
    }

    private void gy(boolean z) {
        if (this.dqX.awE().axv() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.drc.startAnimation(translateAnimation2);
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
            this.dqZ.setVisibility(8);
            this.dqZ.startAnimation(translateAnimation4);
        } else {
            this.dqZ.setVisibility(8);
            this.drc.setVisibility(0);
        }
        this.drc.setText(w.l.add_friend_wait);
        this.drd.setText(w.l.add_friend_button);
    }

    private void g(boolean z, String str) {
        String userName = this.dqX.awE().getUser().getUserName();
        this.drc.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.dqZ.setVisibility(0);
            this.dqZ.startAnimation(translateAnimation2);
        } else {
            this.dqZ.setVisibility(0);
            this.dra.setText(this.dqX.getResources().getString(w.l.add_friend_agree_title, userName));
            this.drb.setText(str);
        }
        this.drd.setText(w.l.add_friend_agree_button);
    }

    private void gz(boolean z) {
        awI();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.dqY.startAnimation(translateAnimation);
            return;
        }
        this.dqY.setVisibility(8);
    }

    public Button awK() {
        return this.drd;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
