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
    private TextView eAq;
    private PersonalChatActivity eUp;
    private LinearLayout eUq;
    private LinearLayout eUr;
    private TextView eUs;
    private TextView eUt;
    private TextView eUu;
    private Button eUv;
    private View.OnClickListener eUw;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eUw = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eUp.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.eUp.aST() && this.mTool != null) {
            b(this.mTool.ft(6));
            b(this.mTool.ft(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eUp = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.eAq = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.eAq.setText(string);
        }
        if (!this.eUp.aST()) {
            this.eUq = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.eUr = (LinearLayout) this.eUq.findViewById(e.g.add_friend_tip_full);
            this.eUs = (TextView) this.eUq.findViewById(e.g.add_friend_tip_title);
            this.eUt = (TextView) this.eUq.findViewById(e.g.add_friend_tip_content);
            this.eUu = (TextView) this.eUq.findViewById(e.g.add_friend_tip_center);
            this.eUv = (Button) this.eUq.findViewById(e.g.add_friend_tip_button);
            this.eUv.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eUq.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eAq != null) {
            al.c(this.eAq, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.eUw);
        }
    }

    private void aSV() {
        if (this.mTool != null) {
            this.mTool.Lc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eUq.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aSW();
                return;
            case WAIT:
                iU(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case PASS:
                iV(z);
                return;
            default:
                return;
        }
    }

    private void aSW() {
        this.eUq.setVisibility(8);
        this.eUr.setVisibility(0);
        this.eUu.setVisibility(8);
        this.eUs.setText(e.j.add_friend_title);
        this.eUt.setText(e.j.add_friend_content);
        this.eUv.setText(e.j.add_friend_button);
    }

    private void iU(boolean z) {
        if (this.eUp.aSR().aTD() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eUu.startAnimation(translateAnimation);
                }
            });
            this.eUu.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eUu.setVisibility(0);
                    PersonalChatView.this.eUu.setAnimation(translateAnimation3);
                }
            });
            this.eUr.setVisibility(8);
            this.eUr.startAnimation(translateAnimation4);
        } else {
            this.eUr.setVisibility(8);
            this.eUu.setVisibility(0);
        }
        this.eUu.setText(e.j.add_friend_wait);
        this.eUv.setText(e.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String name_show = this.eUp.aSR().getUser().getName_show();
        this.eUu.setVisibility(8);
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
                    PersonalChatView.this.eUr.clearAnimation();
                    PersonalChatView.this.eUs.setText(PersonalChatView.this.eUp.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.eUt.setText(str);
                    PersonalChatView.this.eUr.setAnimation(translateAnimation);
                }
            });
            this.eUr.setVisibility(0);
            this.eUr.startAnimation(translateAnimation2);
        } else {
            this.eUr.setVisibility(0);
            this.eUs.setText(this.eUp.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.eUt.setText(str);
        }
        this.eUv.setText(e.j.add_friend_agree_button);
    }

    private void iV(boolean z) {
        aSV();
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
                    PersonalChatView.this.eUq.setVisibility(8);
                }
            });
            this.eUq.startAnimation(translateAnimation);
            return;
        }
        this.eUq.setVisibility(8);
    }

    public Button aSX() {
        return this.eUv;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
