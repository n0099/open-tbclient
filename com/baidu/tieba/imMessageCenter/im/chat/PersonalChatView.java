package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bKn;
    private PersonalChatActivity bKf;
    private LinearLayout bKg;
    private LinearLayout bKh;
    private TextView bKi;
    private TextView bKj;
    private TextView bKk;
    private Button bKl;
    private View.OnClickListener bKm;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] Ye() {
        int[] iArr = bKn;
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
            bKn = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bKm = new p(this);
        if (!this.bKf.XZ() && this.mTool != null) {
            b(this.mTool.dS(6));
            b(this.mTool.dS(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bKf = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(i.h.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(i.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bKf.XZ()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bKg = (LinearLayout) ((ViewStub) talkableActivity.findViewById(i.f.stranger_person_add_friend_stub)).inflate();
            this.bKh = (LinearLayout) this.bKg.findViewById(i.f.add_friend_tip_full);
            this.bKi = (TextView) this.bKg.findViewById(i.f.add_friend_tip_title);
            this.bKj = (TextView) this.bKg.findViewById(i.f.add_friend_tip_content);
            this.bKk = (TextView) this.bKg.findViewById(i.f.add_friend_tip_center);
            this.bKl = (Button) this.bKg.findViewById(i.f.add_friend_tip_button);
            this.bKl.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.p pVar) {
        if (pVar != null && pVar != null && (pVar instanceof View)) {
            ((View) pVar).setOnClickListener(this.bKm);
        }
    }

    private void Yb() {
        if (this.mTool != null) {
            this.mTool.AG();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (Ye()[cardStatus.ordinal()]) {
            case 1:
                Yc();
                return;
            case 2:
                du(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                dv(z);
                return;
            default:
                return;
        }
    }

    private void Yc() {
        this.bKh.setVisibility(0);
        this.bKk.setVisibility(8);
        this.bKi.setText(i.h.add_friend_title);
        this.bKj.setText(i.h.add_friend_content);
        this.bKl.setText(i.h.add_friend_button);
    }

    private void du(boolean z) {
        if (this.bKf.XW().ZW() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bKk.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new r(this, translateAnimation3));
            this.bKh.setVisibility(8);
            this.bKh.startAnimation(translateAnimation4);
        } else {
            this.bKh.setVisibility(8);
            this.bKk.setVisibility(0);
        }
        this.bKk.setText(i.h.add_friend_wait);
        this.bKl.setText(i.h.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.bKf.XW().getUser().getUserName();
        this.bKk.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bKh.setVisibility(0);
            this.bKh.startAnimation(translateAnimation2);
        } else {
            this.bKh.setVisibility(0);
            this.bKi.setText(this.bKf.getResources().getString(i.h.add_friend_agree_title, userName));
            this.bKj.setText(str);
        }
        this.bKl.setText(i.h.add_friend_agree_button);
    }

    private void dv(boolean z) {
        Yb();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bKg.startAnimation(translateAnimation);
            return;
        }
        this.bKg.setVisibility(8);
    }

    public Button Yd() {
        return this.bKl;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
