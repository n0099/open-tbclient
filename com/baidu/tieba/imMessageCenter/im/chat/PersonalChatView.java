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
    private TextView dCW;
    private PersonalChatActivity dXa;
    private LinearLayout dXb;
    private LinearLayout dXc;
    private TextView dXd;
    private TextView dXe;
    private TextView dXf;
    private Button dXg;
    private View.OnClickListener dXh;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dXh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dXa.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.dXa.aDJ() && this.mTool != null) {
            b(this.mTool.eN(6));
            b(this.mTool.eN(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dXa = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.dCW = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dCW.setText(string);
        }
        if (!this.dXa.aDJ()) {
            this.dXb = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.dXc = (LinearLayout) this.dXb.findViewById(d.g.add_friend_tip_full);
            this.dXd = (TextView) this.dXb.findViewById(d.g.add_friend_tip_title);
            this.dXe = (TextView) this.dXb.findViewById(d.g.add_friend_tip_content);
            this.dXf = (TextView) this.dXb.findViewById(d.g.add_friend_tip_center);
            this.dXg = (Button) this.dXb.findViewById(d.g.add_friend_tip_button);
            this.dXg.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dXb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dCW != null) {
            aj.c(this.dCW, d.C0096d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dXh);
        }
    }

    private void aDL() {
        if (this.mTool != null) {
            this.mTool.Dn();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.dXb.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aDM();
                return;
            case WAIT:
                hh(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                hi(z);
                return;
            default:
                return;
        }
    }

    private void aDM() {
        this.dXb.setVisibility(8);
        this.dXc.setVisibility(0);
        this.dXf.setVisibility(8);
        this.dXd.setText(d.j.add_friend_title);
        this.dXe.setText(d.j.add_friend_content);
        this.dXg.setText(d.j.add_friend_button);
    }

    private void hh(boolean z) {
        if (this.dXa.aDH().aEy() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dXf.startAnimation(translateAnimation);
                }
            });
            this.dXf.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dXf.setVisibility(0);
                    PersonalChatView.this.dXf.setAnimation(translateAnimation3);
                }
            });
            this.dXc.setVisibility(8);
            this.dXc.startAnimation(translateAnimation4);
        } else {
            this.dXc.setVisibility(8);
            this.dXf.setVisibility(0);
        }
        this.dXf.setText(d.j.add_friend_wait);
        this.dXg.setText(d.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String userName = this.dXa.aDH().getUser().getUserName();
        this.dXf.setVisibility(8);
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
                    PersonalChatView.this.dXc.clearAnimation();
                    PersonalChatView.this.dXd.setText(PersonalChatView.this.dXa.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.dXe.setText(str);
                    PersonalChatView.this.dXc.setAnimation(translateAnimation);
                }
            });
            this.dXc.setVisibility(0);
            this.dXc.startAnimation(translateAnimation2);
        } else {
            this.dXc.setVisibility(0);
            this.dXd.setText(this.dXa.getResources().getString(d.j.add_friend_agree_title, userName));
            this.dXe.setText(str);
        }
        this.dXg.setText(d.j.add_friend_agree_button);
    }

    private void hi(boolean z) {
        aDL();
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
                    PersonalChatView.this.dXb.setVisibility(8);
                }
            });
            this.dXb.startAnimation(translateAnimation);
            return;
        }
        this.dXb.setVisibility(8);
    }

    public Button aDN() {
        return this.dXg;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
