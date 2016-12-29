package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] cZp;
    private TextView cEO;
    private PersonalChatActivity cZh;
    private LinearLayout cZi;
    private LinearLayout cZj;
    private TextView cZk;
    private TextView cZl;
    private TextView cZm;
    private Button cZn;
    private View.OnClickListener cZo;

    static /* synthetic */ int[] atN() {
        int[] iArr = cZp;
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
            cZp = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.cZo = new q(this);
        if (!this.cZh.atI() && this.mTool != null) {
            b(this.mTool.eA(6));
            b(this.mTool.eA(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.cZh = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(r.j.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.personal_info_btn, talkableActivity);
            this.cEO = (TextView) this.mBtnGroupInfo.findViewById(r.g.group_info_btn_txt);
            this.cEO.setText(string);
        }
        if (!this.cZh.atI()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.cZi = (LinearLayout) ((ViewStub) talkableActivity.findViewById(r.g.stranger_person_add_friend_stub)).inflate();
            this.cZj = (LinearLayout) this.cZi.findViewById(r.g.add_friend_tip_full);
            this.cZk = (TextView) this.cZi.findViewById(r.g.add_friend_tip_title);
            this.cZl = (TextView) this.cZi.findViewById(r.g.add_friend_tip_content);
            this.cZm = (TextView) this.cZi.findViewById(r.g.add_friend_tip_center);
            this.cZn = (Button) this.cZi.findViewById(r.g.add_friend_tip_button);
            this.cZn.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.m9getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.cZi.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cEO != null) {
            ar.c(this.cEO, r.d.cp_cont_b, 1);
        }
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.cZo);
        }
    }

    private void atK() {
        if (this.mTool != null) {
            this.mTool.CI();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (atN()[cardStatus.ordinal()]) {
            case 1:
                atL();
                return;
            case 2:
                go(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                gp(z);
                return;
            default:
                return;
        }
    }

    private void atL() {
        this.cZj.setVisibility(0);
        this.cZm.setVisibility(8);
        this.cZk.setText(r.j.add_friend_title);
        this.cZl.setText(r.j.add_friend_content);
        this.cZn.setText(r.j.add_friend_button);
    }

    private void go(boolean z) {
        if (this.cZh.atF().auB() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new r(this, translateAnimation));
            this.cZm.startAnimation(translateAnimation2);
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
            this.cZj.setVisibility(8);
            this.cZj.startAnimation(translateAnimation4);
        } else {
            this.cZj.setVisibility(8);
            this.cZm.setVisibility(0);
        }
        this.cZm.setText(r.j.add_friend_wait);
        this.cZn.setText(r.j.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.cZh.atF().getUser().getUserName();
        this.cZm.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new t(this, userName, str, translateAnimation));
            this.cZj.setVisibility(0);
            this.cZj.startAnimation(translateAnimation2);
        } else {
            this.cZj.setVisibility(0);
            this.cZk.setText(this.cZh.getResources().getString(r.j.add_friend_agree_title, userName));
            this.cZl.setText(str);
        }
        this.cZn.setText(r.j.add_friend_agree_button);
    }

    private void gp(boolean z) {
        atK();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new u(this));
            this.cZi.startAnimation(translateAnimation);
            return;
        }
        this.cZi.setVisibility(8);
    }

    public Button atM() {
        return this.cZn;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
