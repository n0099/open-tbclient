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
    private PersonalChatActivity dKm;
    private LinearLayout dKn;
    private LinearLayout dKo;
    private TextView dKp;
    private TextView dKq;
    private TextView dKr;
    private Button dKs;
    private View.OnClickListener dKt;
    private TextView dpT;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dKt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dKm.showToast(d.l.add_friend_cannot_send);
            }
        };
        if (!this.dKm.aAW() && this.mTool != null) {
            b(this.mTool.eC(6));
            b(this.mTool.eC(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dKm = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.l.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.personal_info_btn, talkableActivity);
            this.dpT = (TextView) this.mBtnGroupInfo.findViewById(d.h.group_info_btn_txt);
            this.dpT.setText(string);
        }
        if (!this.dKm.aAW()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dKn = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.h.stranger_person_add_friend_stub)).inflate();
            this.dKo = (LinearLayout) this.dKn.findViewById(d.h.add_friend_tip_full);
            this.dKp = (TextView) this.dKn.findViewById(d.h.add_friend_tip_title);
            this.dKq = (TextView) this.dKn.findViewById(d.h.add_friend_tip_content);
            this.dKr = (TextView) this.dKn.findViewById(d.h.add_friend_tip_center);
            this.dKs = (Button) this.dKn.findViewById(d.h.add_friend_tip_button);
            this.dKs.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dKn.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dpT != null) {
            aj.c(this.dpT, d.e.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dKt);
        }
    }

    private void aAY() {
        if (this.mTool != null) {
            this.mTool.Dd();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aAZ();
                return;
            case WAIT:
                gY(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                gZ(z);
                return;
            default:
                return;
        }
    }

    private void aAZ() {
        this.dKo.setVisibility(0);
        this.dKr.setVisibility(8);
        this.dKp.setText(d.l.add_friend_title);
        this.dKq.setText(d.l.add_friend_content);
        this.dKs.setText(d.l.add_friend_button);
    }

    private void gY(boolean z) {
        if (this.dKm.aAU().aBL() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dKr.startAnimation(translateAnimation);
                }
            });
            this.dKr.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dKr.setVisibility(0);
                    PersonalChatView.this.dKr.setAnimation(translateAnimation3);
                }
            });
            this.dKo.setVisibility(8);
            this.dKo.startAnimation(translateAnimation4);
        } else {
            this.dKo.setVisibility(8);
            this.dKr.setVisibility(0);
        }
        this.dKr.setText(d.l.add_friend_wait);
        this.dKs.setText(d.l.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.dKm.aAU().getUser().getUserName();
        this.dKr.setVisibility(8);
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
                    PersonalChatView.this.dKo.clearAnimation();
                    PersonalChatView.this.dKp.setText(PersonalChatView.this.dKm.getResources().getString(d.l.add_friend_agree_title, userName));
                    PersonalChatView.this.dKq.setText(str);
                    PersonalChatView.this.dKo.setAnimation(translateAnimation);
                }
            });
            this.dKo.setVisibility(0);
            this.dKo.startAnimation(translateAnimation2);
        } else {
            this.dKo.setVisibility(0);
            this.dKp.setText(this.dKm.getResources().getString(d.l.add_friend_agree_title, userName));
            this.dKq.setText(str);
        }
        this.dKs.setText(d.l.add_friend_agree_button);
    }

    private void gZ(boolean z) {
        aAY();
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
                    PersonalChatView.this.dKn.setVisibility(8);
                }
            });
            this.dKn.startAnimation(translateAnimation);
            return;
        }
        this.dKn.setVisibility(8);
    }

    public Button aBa() {
        return this.dKs;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
