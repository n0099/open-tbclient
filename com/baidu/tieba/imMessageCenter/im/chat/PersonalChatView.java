package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView dff;
    private LinearLayout dzA;
    private LinearLayout dzB;
    private TextView dzC;
    private TextView dzD;
    private TextView dzE;
    private Button dzF;
    private View.OnClickListener dzG;
    private PersonalChatActivity dzz;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dzG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dzz.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dzz.ayj() && this.mTool != null) {
            b(this.mTool.eA(6));
            b(this.mTool.eA(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dzz = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.dff = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.dff.setText(string);
        }
        if (!this.dzz.ayj()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dzA = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dzB = (LinearLayout) this.dzA.findViewById(d.h.add_friend_tip_full);
            this.dzC = (TextView) this.dzA.findViewById(d.h.add_friend_tip_title);
            this.dzD = (TextView) this.dzA.findViewById(d.h.add_friend_tip_content);
            this.dzE = (TextView) this.dzA.findViewById(d.h.add_friend_tip_center);
            this.dzF = (Button) this.dzA.findViewById(d.h.add_friend_tip_button);
            this.dzF.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dzA.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dff != null) {
            ai.c(this.dff, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dzG);
        }
    }

    private void ayl() {
        if (this.mTool != null) {
            this.mTool.Da();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aym();
                return;
            case WAIT:
                gM(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                g(z, str);
                return;
            case PASS:
                gN(z);
                return;
            default:
                return;
        }
    }

    private void aym() {
        this.dzB.setVisibility(0);
        this.dzE.setVisibility(8);
        this.dzC.setText(d.l.add_friend_title);
        this.dzD.setText(d.l.add_friend_content);
        this.dzF.setText(d.l.add_friend_button);
    }

    private void gM(boolean z) {
        if (this.dzz.ayh().ayY() == PersonalMsglistModel.CardStatus.WAIT && z) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dzE.startAnimation(translateAnimation);
                }
            });
            this.dzE.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            final TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dzE.setVisibility(0);
                    PersonalChatView.this.dzE.setAnimation(translateAnimation3);
                }
            });
            this.dzB.setVisibility(8);
            this.dzB.startAnimation(translateAnimation4);
        } else {
            this.dzB.setVisibility(8);
            this.dzE.setVisibility(0);
        }
        this.dzE.setText(d.l.add_friend_wait);
        this.dzF.setText(d.l.add_friend_button);
    }

    private void g(boolean z, final String str) {
        final String userName = this.dzz.ayh().getUser().getUserName();
        this.dzE.setVisibility(8);
        if (z) {
            final TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dzB.clearAnimation();
                    PersonalChatView.this.dzC.setText(PersonalChatView.this.dzz.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dzD.setText(str);
                    PersonalChatView.this.dzB.setAnimation(translateAnimation);
                }
            });
            this.dzB.setVisibility(0);
            this.dzB.startAnimation(translateAnimation2);
        } else {
            this.dzB.setVisibility(0);
            this.dzC.setText(this.dzz.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dzD.setText(str);
        }
        this.dzF.setText(d.l.add_friend_agree_button);
    }

    private void gN(boolean z) {
        ayl();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PersonalChatView.this.dzA.setVisibility(8);
                }
            });
            this.dzA.startAnimation(translateAnimation);
            return;
        }
        this.dzA.setVisibility(8);
    }

    public Button ayn() {
        return this.dzF;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
