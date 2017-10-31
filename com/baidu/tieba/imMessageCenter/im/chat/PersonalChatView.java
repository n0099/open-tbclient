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
    private PersonalChatActivity dOb;
    private LinearLayout dOc;
    private LinearLayout dOd;
    private TextView dOe;
    private TextView dOf;
    private TextView dOg;
    private Button dOh;
    private View.OnClickListener dOi;
    private TextView dtL;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dOi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dOb.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.dOb.aBX() && this.mTool != null) {
            b(this.mTool.eN(6));
            b(this.mTool.eN(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dOb = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.dtL = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dtL.setText(string);
        }
        if (!this.dOb.aBX()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.dOc = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.dOd = (LinearLayout) this.dOc.findViewById(d.g.add_friend_tip_full);
            this.dOe = (TextView) this.dOc.findViewById(d.g.add_friend_tip_title);
            this.dOf = (TextView) this.dOc.findViewById(d.g.add_friend_tip_content);
            this.dOg = (TextView) this.dOc.findViewById(d.g.add_friend_tip_center);
            this.dOh = (Button) this.dOc.findViewById(d.g.add_friend_tip_button);
            this.dOh.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dOc.setVisibility(8);
                return;
            }
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dtL != null) {
            aj.c(this.dtL, d.C0080d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dOi);
        }
    }

    private void aBZ() {
        if (this.mTool != null) {
            this.mTool.CQ();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (cardStatus) {
            case APPLY:
                aCa();
                return;
            case WAIT:
                gG(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                gH(z);
                return;
            default:
                return;
        }
    }

    private void aCa() {
        this.dOd.setVisibility(0);
        this.dOg.setVisibility(8);
        this.dOe.setText(d.j.add_friend_title);
        this.dOf.setText(d.j.add_friend_content);
        this.dOh.setText(d.j.add_friend_button);
    }

    private void gG(boolean z) {
        if (this.dOb.aBV().aCM() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dOg.startAnimation(translateAnimation);
                }
            });
            this.dOg.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dOg.setVisibility(0);
                    PersonalChatView.this.dOg.setAnimation(translateAnimation3);
                }
            });
            this.dOd.setVisibility(8);
            this.dOd.startAnimation(translateAnimation4);
        } else {
            this.dOd.setVisibility(8);
            this.dOg.setVisibility(0);
        }
        this.dOg.setText(d.j.add_friend_wait);
        this.dOh.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.dOb.aBV().getUser().getUserName();
        this.dOg.setVisibility(8);
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
                    PersonalChatView.this.dOd.clearAnimation();
                    PersonalChatView.this.dOe.setText(PersonalChatView.this.dOb.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.dOf.setText(str);
                    PersonalChatView.this.dOd.setAnimation(translateAnimation);
                }
            });
            this.dOd.setVisibility(0);
            this.dOd.startAnimation(translateAnimation2);
        } else {
            this.dOd.setVisibility(0);
            this.dOe.setText(this.dOb.getResources().getString(d.j.add_friend_agree_title, userName));
            this.dOf.setText(str);
        }
        this.dOh.setText(d.j.add_friend_agree_button);
    }

    private void gH(boolean z) {
        aBZ();
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
                    PersonalChatView.this.dOc.setVisibility(8);
                }
            });
            this.dOc.startAnimation(translateAnimation);
            return;
        }
        this.dOc.setVisibility(8);
    }

    public Button aCb() {
        return this.dOh;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
