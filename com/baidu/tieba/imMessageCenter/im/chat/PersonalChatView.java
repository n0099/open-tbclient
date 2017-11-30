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
    private TextView dBS;
    private PersonalChatActivity dVV;
    private LinearLayout dVW;
    private LinearLayout dVX;
    private TextView dVY;
    private TextView dVZ;
    private TextView dWa;
    private Button dWb;
    private View.OnClickListener dWc;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dWc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dVV.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.dVV.aDB() && this.mTool != null) {
            b(this.mTool.eN(6));
            b(this.mTool.eN(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dVV = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.dBS = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dBS.setText(string);
        }
        if (!this.dVV.aDB()) {
            this.dVW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.dVX = (LinearLayout) this.dVW.findViewById(d.g.add_friend_tip_full);
            this.dVY = (TextView) this.dVW.findViewById(d.g.add_friend_tip_title);
            this.dVZ = (TextView) this.dVW.findViewById(d.g.add_friend_tip_content);
            this.dWa = (TextView) this.dVW.findViewById(d.g.add_friend_tip_center);
            this.dWb = (Button) this.dVW.findViewById(d.g.add_friend_tip_button);
            this.dWb.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dVW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dBS != null) {
            aj.c(this.dBS, d.C0082d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dWc);
        }
    }

    private void aDD() {
        if (this.mTool != null) {
            this.mTool.Dm();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.dVW.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aDE();
                return;
            case WAIT:
                hg(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                hh(z);
                return;
            default:
                return;
        }
    }

    private void aDE() {
        this.dVW.setVisibility(8);
        this.dVX.setVisibility(0);
        this.dWa.setVisibility(8);
        this.dVY.setText(d.j.add_friend_title);
        this.dVZ.setText(d.j.add_friend_content);
        this.dWb.setText(d.j.add_friend_button);
    }

    private void hg(boolean z) {
        if (this.dVV.aDz().aEq() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dWa.startAnimation(translateAnimation);
                }
            });
            this.dWa.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dWa.setVisibility(0);
                    PersonalChatView.this.dWa.setAnimation(translateAnimation3);
                }
            });
            this.dVX.setVisibility(8);
            this.dVX.startAnimation(translateAnimation4);
        } else {
            this.dVX.setVisibility(8);
            this.dWa.setVisibility(0);
        }
        this.dWa.setText(d.j.add_friend_wait);
        this.dWb.setText(d.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String userName = this.dVV.aDz().getUser().getUserName();
        this.dWa.setVisibility(8);
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
                    PersonalChatView.this.dVX.clearAnimation();
                    PersonalChatView.this.dVY.setText(PersonalChatView.this.dVV.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.dVZ.setText(str);
                    PersonalChatView.this.dVX.setAnimation(translateAnimation);
                }
            });
            this.dVX.setVisibility(0);
            this.dVX.startAnimation(translateAnimation2);
        } else {
            this.dVX.setVisibility(0);
            this.dVY.setText(this.dVV.getResources().getString(d.j.add_friend_agree_title, userName));
            this.dVZ.setText(str);
        }
        this.dWb.setText(d.j.add_friend_agree_button);
    }

    private void hh(boolean z) {
        aDD();
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
                    PersonalChatView.this.dVW.setVisibility(8);
                }
            });
            this.dVW.startAnimation(translateAnimation);
            return;
        }
        this.dVW.setVisibility(8);
    }

    public Button aDF() {
        return this.dWb;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
