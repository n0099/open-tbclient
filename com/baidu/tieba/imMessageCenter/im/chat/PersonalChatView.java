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
    private TextView dDa;
    private PersonalChatActivity dXe;
    private LinearLayout dXf;
    private LinearLayout dXg;
    private TextView dXh;
    private TextView dXi;
    private TextView dXj;
    private Button dXk;
    private View.OnClickListener dXl;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.dXl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.dXe.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.dXe.aDK() && this.mTool != null) {
            b(this.mTool.eN(6));
            b(this.mTool.eN(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.dXe = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.dDa = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dDa.setText(string);
        }
        if (!this.dXe.aDK()) {
            this.dXf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.dXg = (LinearLayout) this.dXf.findViewById(d.g.add_friend_tip_full);
            this.dXh = (TextView) this.dXf.findViewById(d.g.add_friend_tip_title);
            this.dXi = (TextView) this.dXf.findViewById(d.g.add_friend_tip_content);
            this.dXj = (TextView) this.dXf.findViewById(d.g.add_friend_tip_center);
            this.dXk = (Button) this.dXf.findViewById(d.g.add_friend_tip_button);
            this.dXk.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.dXf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dDa != null) {
            aj.c(this.dDa, d.C0095d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.dXl);
        }
    }

    private void aDM() {
        if (this.mTool != null) {
            this.mTool.Dn();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.dXf.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aDN();
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

    private void aDN() {
        this.dXf.setVisibility(8);
        this.dXg.setVisibility(0);
        this.dXj.setVisibility(8);
        this.dXh.setText(d.j.add_friend_title);
        this.dXi.setText(d.j.add_friend_content);
        this.dXk.setText(d.j.add_friend_button);
    }

    private void hh(boolean z) {
        if (this.dXe.aDI().aEz() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.dXj.startAnimation(translateAnimation);
                }
            });
            this.dXj.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.dXj.setVisibility(0);
                    PersonalChatView.this.dXj.setAnimation(translateAnimation3);
                }
            });
            this.dXg.setVisibility(8);
            this.dXg.startAnimation(translateAnimation4);
        } else {
            this.dXg.setVisibility(8);
            this.dXj.setVisibility(0);
        }
        this.dXj.setText(d.j.add_friend_wait);
        this.dXk.setText(d.j.add_friend_button);
    }

    private void i(boolean z, final String str) {
        final String userName = this.dXe.aDI().getUser().getUserName();
        this.dXj.setVisibility(8);
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
                    PersonalChatView.this.dXg.clearAnimation();
                    PersonalChatView.this.dXh.setText(PersonalChatView.this.dXe.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.dXi.setText(str);
                    PersonalChatView.this.dXg.setAnimation(translateAnimation);
                }
            });
            this.dXg.setVisibility(0);
            this.dXg.startAnimation(translateAnimation2);
        } else {
            this.dXg.setVisibility(0);
            this.dXh.setText(this.dXe.getResources().getString(d.j.add_friend_agree_title, userName));
            this.dXi.setText(str);
        }
        this.dXk.setText(d.j.add_friend_agree_button);
    }

    private void hi(boolean z) {
        aDM();
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
                    PersonalChatView.this.dXf.setVisibility(8);
                }
            });
            this.dXf.startAnimation(translateAnimation);
            return;
        }
        this.dXf.setVisibility(8);
    }

    public Button aDO() {
        return this.dXk;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
