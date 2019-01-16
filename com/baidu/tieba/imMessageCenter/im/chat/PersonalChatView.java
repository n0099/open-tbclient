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
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView eKI;
    private PersonalChatActivity feI;
    private LinearLayout feJ;
    private LinearLayout feK;
    private TextView feL;
    private TextView feM;
    private TextView feN;
    private Button feO;
    private View.OnClickListener feP;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.feP = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.feI.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.feI.aVY() && this.mTool != null) {
            b(this.mTool.fI(6));
            b(this.mTool.fI(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.feI = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.eKI = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eKI.setText(string);
        }
        if (!this.feI.aVY()) {
            this.feJ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.feK = (LinearLayout) this.feJ.findViewById(e.g.add_friend_tip_full);
            this.feL = (TextView) this.feJ.findViewById(e.g.add_friend_tip_title);
            this.feM = (TextView) this.feJ.findViewById(e.g.add_friend_tip_content);
            this.feN = (TextView) this.feJ.findViewById(e.g.add_friend_tip_center);
            this.feO = (Button) this.feJ.findViewById(e.g.add_friend_tip_button);
            this.feO.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.feJ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eKI != null) {
            al.c(this.eKI, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.feP);
        }
    }

    private void aWa() {
        if (this.mTool != null) {
            this.mTool.My();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.feJ.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aWb();
                return;
            case WAIT:
                ja(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                jb(z);
                return;
            default:
                return;
        }
    }

    private void aWb() {
        this.feJ.setVisibility(8);
        this.feK.setVisibility(0);
        this.feN.setVisibility(8);
        this.feL.setText(e.j.add_friend_title);
        this.feM.setText(e.j.add_friend_content);
        this.feO.setText(e.j.add_friend_button);
    }

    private void ja(boolean z) {
        if (this.feI.aVW().aWI() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.feN.startAnimation(translateAnimation);
                }
            });
            this.feN.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.feN.setVisibility(0);
                    PersonalChatView.this.feN.setAnimation(translateAnimation3);
                }
            });
            this.feK.setVisibility(8);
            this.feK.startAnimation(translateAnimation4);
        } else {
            this.feK.setVisibility(8);
            this.feN.setVisibility(0);
        }
        this.feN.setText(e.j.add_friend_wait);
        this.feO.setText(e.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String name_show = this.feI.aVW().getUser().getName_show();
        this.feN.setVisibility(8);
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
                    PersonalChatView.this.feK.clearAnimation();
                    PersonalChatView.this.feL.setText(PersonalChatView.this.feI.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.feM.setText(str);
                    PersonalChatView.this.feK.setAnimation(translateAnimation);
                }
            });
            this.feK.setVisibility(0);
            this.feK.startAnimation(translateAnimation2);
        } else {
            this.feK.setVisibility(0);
            this.feL.setText(this.feI.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.feM.setText(str);
        }
        this.feO.setText(e.j.add_friend_agree_button);
    }

    private void jb(boolean z) {
        aWa();
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
                    PersonalChatView.this.feJ.setVisibility(8);
                }
            });
            this.feJ.startAnimation(translateAnimation);
            return;
        }
        this.feJ.setVisibility(8);
    }

    public Button aWc() {
        return this.feO;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
