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
    private PersonalChatActivity eJi;
    private LinearLayout eJj;
    private LinearLayout eJk;
    private TextView eJl;
    private TextView eJm;
    private TextView eJn;
    private Button eJo;
    private View.OnClickListener eJp;
    private TextView epd;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eJp = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eJi.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.eJi.aKL() && this.mTool != null) {
            b(this.mTool.hL(6));
            b(this.mTool.hL(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eJi = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.epd = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.epd.setText(string);
        }
        if (!this.eJi.aKL()) {
            this.eJj = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.eJk = (LinearLayout) this.eJj.findViewById(d.g.add_friend_tip_full);
            this.eJl = (TextView) this.eJj.findViewById(d.g.add_friend_tip_title);
            this.eJm = (TextView) this.eJj.findViewById(d.g.add_friend_tip_content);
            this.eJn = (TextView) this.eJj.findViewById(d.g.add_friend_tip_center);
            this.eJo = (Button) this.eJj.findViewById(d.g.add_friend_tip_button);
            this.eJo.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eJj.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epd != null) {
            aj.e(this.epd, d.C0108d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.eJp);
        }
    }

    private void aKN() {
        if (this.mTool != null) {
            this.mTool.KO();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eJj.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aKO();
                return;
            case WAIT:
                hG(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                hH(z);
                return;
            default:
                return;
        }
    }

    private void aKO() {
        this.eJj.setVisibility(8);
        this.eJk.setVisibility(0);
        this.eJn.setVisibility(8);
        this.eJl.setText(d.j.add_friend_title);
        this.eJm.setText(d.j.add_friend_content);
        this.eJo.setText(d.j.add_friend_button);
    }

    private void hG(boolean z) {
        if (this.eJi.aKJ().aLA() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eJn.startAnimation(translateAnimation);
                }
            });
            this.eJn.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eJn.setVisibility(0);
                    PersonalChatView.this.eJn.setAnimation(translateAnimation3);
                }
            });
            this.eJk.setVisibility(8);
            this.eJk.startAnimation(translateAnimation4);
        } else {
            this.eJk.setVisibility(8);
            this.eJn.setVisibility(0);
        }
        this.eJn.setText(d.j.add_friend_wait);
        this.eJo.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.eJi.aKJ().getUser().getUserName();
        this.eJn.setVisibility(8);
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
                    PersonalChatView.this.eJk.clearAnimation();
                    PersonalChatView.this.eJl.setText(PersonalChatView.this.eJi.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.eJm.setText(str);
                    PersonalChatView.this.eJk.setAnimation(translateAnimation);
                }
            });
            this.eJk.setVisibility(0);
            this.eJk.startAnimation(translateAnimation2);
        } else {
            this.eJk.setVisibility(0);
            this.eJl.setText(this.eJi.getResources().getString(d.j.add_friend_agree_title, userName));
            this.eJm.setText(str);
        }
        this.eJo.setText(d.j.add_friend_agree_button);
    }

    private void hH(boolean z) {
        aKN();
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
                    PersonalChatView.this.eJj.setVisibility(8);
                }
            });
            this.eJj.startAnimation(translateAnimation);
            return;
        }
        this.eJj.setVisibility(8);
    }

    public Button aKP() {
        return this.eJo;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
