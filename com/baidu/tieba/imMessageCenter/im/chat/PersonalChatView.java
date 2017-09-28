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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity dGB;
    private LinearLayout dGC;
    private LinearLayout dGD;
    private TextView dGE;
    private TextView dGF;
    private TextView dGG;
    private Button dGH;
    private View.OnClickListener dGI;
    private TextView dmi;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dGI = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dGB.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dGB.azH() && this.mTool != null) {
            b(this.mTool.eN(6));
            b(this.mTool.eN(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dGB = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.dmi = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.dmi.setText(string);
        }
        if (!this.dGB.azH()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dGC = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dGD = (LinearLayout) this.dGC.findViewById(d.h.add_friend_tip_full);
            this.dGE = (TextView) this.dGC.findViewById(d.h.add_friend_tip_title);
            this.dGF = (TextView) this.dGC.findViewById(d.h.add_friend_tip_content);
            this.dGG = (TextView) this.dGC.findViewById(d.h.add_friend_tip_center);
            this.dGH = (Button) this.dGC.findViewById(d.h.add_friend_tip_button);
            this.dGH.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dGC.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dmi != null) {
            aj.c(this.dmi, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dGI);
        }
    }

    private void azJ() {
        if (this.mTool != null) {
            this.mTool.CH();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                azK();
                return;
            case WAIT:
                gL(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                gM(z);
                return;
            default:
                return;
        }
    }

    private void azK() {
        this.dGD.setVisibility(0);
        this.dGG.setVisibility(8);
        this.dGE.setText(d.l.add_friend_title);
        this.dGF.setText(d.l.add_friend_content);
        this.dGH.setText(d.l.add_friend_button);
    }

    private void gL(boolean z) {
        if (this.dGB.azF().aAw() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dGG.startAnimation(translateAnimation);
                }
            });
            this.dGG.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dGG.setVisibility(0);
                    PersonalChatView.this.dGG.setAnimation(translateAnimation3);
                }
            });
            this.dGD.setVisibility(8);
            this.dGD.startAnimation(translateAnimation4);
        } else {
            this.dGD.setVisibility(8);
            this.dGG.setVisibility(0);
        }
        this.dGG.setText(d.l.add_friend_wait);
        this.dGH.setText(d.l.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.dGB.azF().getUser().getUserName();
        this.dGG.setVisibility(8);
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
                    PersonalChatView.this.dGD.clearAnimation();
                    PersonalChatView.this.dGE.setText(PersonalChatView.this.dGB.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dGF.setText(str);
                    PersonalChatView.this.dGD.setAnimation(translateAnimation);
                }
            });
            this.dGD.setVisibility(0);
            this.dGD.startAnimation(translateAnimation2);
        } else {
            this.dGD.setVisibility(0);
            this.dGE.setText(this.dGB.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dGF.setText(str);
        }
        this.dGH.setText(d.l.add_friend_agree_button);
    }

    private void gM(boolean z) {
        azJ();
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
                    PersonalChatView.this.dGC.setVisibility(8);
                }
            });
            this.dGC.startAnimation(translateAnimation);
            return;
        }
        this.dGC.setVisibility(8);
    }

    public Button azL() {
        return this.dGH;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
