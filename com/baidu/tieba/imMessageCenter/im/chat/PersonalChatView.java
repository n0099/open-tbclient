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
    private TextView eHf;
    private PersonalChatActivity fbe;
    private LinearLayout fbf;
    private LinearLayout fbg;
    private TextView fbh;
    private TextView fbi;
    private TextView fbj;
    private Button fbk;
    private View.OnClickListener fbl;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.fbl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.fbe.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.fbe.aUL() && this.mTool != null) {
            b(this.mTool.fH(6));
            b(this.mTool.fH(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.fbe = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.eHf = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eHf.setText(string);
        }
        if (!this.fbe.aUL()) {
            this.fbf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.fbg = (LinearLayout) this.fbf.findViewById(e.g.add_friend_tip_full);
            this.fbh = (TextView) this.fbf.findViewById(e.g.add_friend_tip_title);
            this.fbi = (TextView) this.fbf.findViewById(e.g.add_friend_tip_content);
            this.fbj = (TextView) this.fbf.findViewById(e.g.add_friend_tip_center);
            this.fbk = (Button) this.fbf.findViewById(e.g.add_friend_tip_button);
            this.fbk.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.fbf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eHf != null) {
            al.c(this.eHf, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.fbl);
        }
    }

    private void aUN() {
        if (this.mTool != null) {
            this.mTool.Mg();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.fbf.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aUO();
                return;
            case WAIT:
                iX(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                iY(z);
                return;
            default:
                return;
        }
    }

    private void aUO() {
        this.fbf.setVisibility(8);
        this.fbg.setVisibility(0);
        this.fbj.setVisibility(8);
        this.fbh.setText(e.j.add_friend_title);
        this.fbi.setText(e.j.add_friend_content);
        this.fbk.setText(e.j.add_friend_button);
    }

    private void iX(boolean z) {
        if (this.fbe.aUJ().aVv() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.fbj.startAnimation(translateAnimation);
                }
            });
            this.fbj.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.fbj.setVisibility(0);
                    PersonalChatView.this.fbj.setAnimation(translateAnimation3);
                }
            });
            this.fbg.setVisibility(8);
            this.fbg.startAnimation(translateAnimation4);
        } else {
            this.fbg.setVisibility(8);
            this.fbj.setVisibility(0);
        }
        this.fbj.setText(e.j.add_friend_wait);
        this.fbk.setText(e.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String name_show = this.fbe.aUJ().getUser().getName_show();
        this.fbj.setVisibility(8);
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
                    PersonalChatView.this.fbg.clearAnimation();
                    PersonalChatView.this.fbh.setText(PersonalChatView.this.fbe.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.fbi.setText(str);
                    PersonalChatView.this.fbg.setAnimation(translateAnimation);
                }
            });
            this.fbg.setVisibility(0);
            this.fbg.startAnimation(translateAnimation2);
        } else {
            this.fbg.setVisibility(0);
            this.fbh.setText(this.fbe.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.fbi.setText(str);
        }
        this.fbk.setText(e.j.add_friend_agree_button);
    }

    private void iY(boolean z) {
        aUN();
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
                    PersonalChatView.this.fbf.setVisibility(8);
                }
            });
            this.fbf.startAnimation(translateAnimation);
            return;
        }
        this.fbf.setVisibility(8);
    }

    public Button aUP() {
        return this.fbk;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
