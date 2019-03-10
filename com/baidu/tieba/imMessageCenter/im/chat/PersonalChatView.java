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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView gaL;
    private PersonalChatActivity guQ;
    private LinearLayout guR;
    private LinearLayout guS;
    private TextView guT;
    private TextView guU;
    private TextView guV;
    private Button guW;
    private View.OnClickListener guX;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.guX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.guQ.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.guQ.bwE() && this.mTool != null) {
            b(this.mTool.jt(6));
            b(this.mTool.jt(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.guQ = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.gaL = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gaL.setText(string);
        }
        if (!this.guQ.bwE()) {
            this.guR = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.guS = (LinearLayout) this.guR.findViewById(d.g.add_friend_tip_full);
            this.guT = (TextView) this.guR.findViewById(d.g.add_friend_tip_title);
            this.guU = (TextView) this.guR.findViewById(d.g.add_friend_tip_content);
            this.guV = (TextView) this.guR.findViewById(d.g.add_friend_tip_center);
            this.guW = (Button) this.guR.findViewById(d.g.add_friend_tip_button);
            this.guW.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.guR.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gaL != null) {
            al.d(this.gaL, d.C0236d.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.guX);
        }
    }

    private void bwG() {
        if (this.mTool != null) {
            this.mTool.amd();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.guR.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bwH();
                return;
            case WAIT:
                lA(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                lB(z);
                return;
            default:
                return;
        }
    }

    private void bwH() {
        this.guR.setVisibility(8);
        this.guS.setVisibility(0);
        this.guV.setVisibility(8);
        this.guT.setText(d.j.add_friend_title);
        this.guU.setText(d.j.add_friend_content);
        this.guW.setText(d.j.add_friend_button);
    }

    private void lA(boolean z) {
        if (this.guQ.bwC().bxn() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.guV.startAnimation(translateAnimation);
                }
            });
            this.guV.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.guV.setVisibility(0);
                    PersonalChatView.this.guV.setAnimation(translateAnimation3);
                }
            });
            this.guS.setVisibility(8);
            this.guS.startAnimation(translateAnimation4);
        } else {
            this.guS.setVisibility(8);
            this.guV.setVisibility(0);
        }
        this.guV.setText(d.j.add_friend_wait);
        this.guW.setText(d.j.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.guQ.bwC().getUser().getName_show();
        this.guV.setVisibility(8);
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
                    PersonalChatView.this.guS.clearAnimation();
                    PersonalChatView.this.guT.setText(PersonalChatView.this.guQ.getResources().getString(d.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.guU.setText(str);
                    PersonalChatView.this.guS.setAnimation(translateAnimation);
                }
            });
            this.guS.setVisibility(0);
            this.guS.startAnimation(translateAnimation2);
        } else {
            this.guS.setVisibility(0);
            this.guT.setText(this.guQ.getResources().getString(d.j.add_friend_agree_title, name_show));
            this.guU.setText(str);
        }
        this.guW.setText(d.j.add_friend_agree_button);
    }

    private void lB(boolean z) {
        bwG();
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
                    PersonalChatView.this.guR.setVisibility(8);
                }
            });
            this.guR.startAnimation(translateAnimation);
            return;
        }
        this.guR.setVisibility(8);
    }

    public Button bwI() {
        return this.guW;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
