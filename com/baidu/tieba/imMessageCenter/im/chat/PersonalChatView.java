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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.f;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity eDX;
    private LinearLayout eDY;
    private LinearLayout eDZ;
    private TextView eEa;
    private TextView eEb;
    private TextView eEc;
    private Button eEd;
    private View.OnClickListener eEe;
    private TextView ejM;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eEe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eDX.showToast(f.j.add_friend_cannot_send);
            }
        };
        if (!this.eDX.aNT() && this.mTool != null) {
            b(this.mTool.eK(6));
            b(this.mTool.eK(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eDX = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(f.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.personal_info_btn, talkableActivity);
            this.ejM = (TextView) this.mBtnGroupInfo.findViewById(f.g.group_info_btn_txt);
            this.ejM.setText(string);
        }
        if (!this.eDX.aNT()) {
            this.eDY = (LinearLayout) ((ViewStub) talkableActivity.findViewById(f.g.stranger_person_add_friend_stub)).inflate();
            this.eDZ = (LinearLayout) this.eDY.findViewById(f.g.add_friend_tip_full);
            this.eEa = (TextView) this.eDY.findViewById(f.g.add_friend_tip_title);
            this.eEb = (TextView) this.eDY.findViewById(f.g.add_friend_tip_content);
            this.eEc = (TextView) this.eDY.findViewById(f.g.add_friend_tip_center);
            this.eEd = (Button) this.eDY.findViewById(f.g.add_friend_tip_button);
            this.eEd.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eDY.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ejM != null) {
            am.c(this.ejM, f.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.eEe);
        }
    }

    private void aNV() {
        if (this.mTool != null) {
            this.mTool.HC();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eDY.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aNW();
                return;
            case WAIT:
                hV(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                hW(z);
                return;
            default:
                return;
        }
    }

    private void aNW() {
        this.eDY.setVisibility(8);
        this.eDZ.setVisibility(0);
        this.eEc.setVisibility(8);
        this.eEa.setText(f.j.add_friend_title);
        this.eEb.setText(f.j.add_friend_content);
        this.eEd.setText(f.j.add_friend_button);
    }

    private void hV(boolean z) {
        if (this.eDX.aNR().aOD() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eEc.startAnimation(translateAnimation);
                }
            });
            this.eEc.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eEc.setVisibility(0);
                    PersonalChatView.this.eEc.setAnimation(translateAnimation3);
                }
            });
            this.eDZ.setVisibility(8);
            this.eDZ.startAnimation(translateAnimation4);
        } else {
            this.eDZ.setVisibility(8);
            this.eEc.setVisibility(0);
        }
        this.eEc.setText(f.j.add_friend_wait);
        this.eEd.setText(f.j.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String name_show = this.eDX.aNR().getUser().getName_show();
        this.eEc.setVisibility(8);
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
                    PersonalChatView.this.eDZ.clearAnimation();
                    PersonalChatView.this.eEa.setText(PersonalChatView.this.eDX.getResources().getString(f.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.eEb.setText(str);
                    PersonalChatView.this.eDZ.setAnimation(translateAnimation);
                }
            });
            this.eDZ.setVisibility(0);
            this.eDZ.startAnimation(translateAnimation2);
        } else {
            this.eDZ.setVisibility(0);
            this.eEa.setText(this.eDX.getResources().getString(f.j.add_friend_agree_title, name_show));
            this.eEb.setText(str);
        }
        this.eEd.setText(f.j.add_friend_agree_button);
    }

    private void hW(boolean z) {
        aNV();
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
                    PersonalChatView.this.eDY.setVisibility(8);
                }
            });
            this.eDY.startAnimation(translateAnimation);
            return;
        }
        this.eDY.setVisibility(8);
    }

    public Button aNX() {
        return this.eEd;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
