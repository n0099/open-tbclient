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
    private TextView gay;
    private PersonalChatActivity guD;
    private LinearLayout guE;
    private LinearLayout guF;
    private TextView guG;
    private TextView guH;
    private TextView guI;
    private Button guJ;
    private View.OnClickListener guK;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.guK = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.guD.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.guD.bwA() && this.mTool != null) {
            b(this.mTool.js(6));
            b(this.mTool.js(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.guD = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.gay = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gay.setText(string);
        }
        if (!this.guD.bwA()) {
            this.guE = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.guF = (LinearLayout) this.guE.findViewById(d.g.add_friend_tip_full);
            this.guG = (TextView) this.guE.findViewById(d.g.add_friend_tip_title);
            this.guH = (TextView) this.guE.findViewById(d.g.add_friend_tip_content);
            this.guI = (TextView) this.guE.findViewById(d.g.add_friend_tip_center);
            this.guJ = (Button) this.guE.findViewById(d.g.add_friend_tip_button);
            this.guJ.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.guE.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gay != null) {
            al.d(this.gay, d.C0277d.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.guK);
        }
    }

    private void bwC() {
        if (this.mTool != null) {
            this.mTool.alZ();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.guE.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bwD();
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

    private void bwD() {
        this.guE.setVisibility(8);
        this.guF.setVisibility(0);
        this.guI.setVisibility(8);
        this.guG.setText(d.j.add_friend_title);
        this.guH.setText(d.j.add_friend_content);
        this.guJ.setText(d.j.add_friend_button);
    }

    private void lA(boolean z) {
        if (this.guD.bwy().bxj() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.guI.startAnimation(translateAnimation);
                }
            });
            this.guI.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.guI.setVisibility(0);
                    PersonalChatView.this.guI.setAnimation(translateAnimation3);
                }
            });
            this.guF.setVisibility(8);
            this.guF.startAnimation(translateAnimation4);
        } else {
            this.guF.setVisibility(8);
            this.guI.setVisibility(0);
        }
        this.guI.setText(d.j.add_friend_wait);
        this.guJ.setText(d.j.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.guD.bwy().getUser().getName_show();
        this.guI.setVisibility(8);
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
                    PersonalChatView.this.guF.clearAnimation();
                    PersonalChatView.this.guG.setText(PersonalChatView.this.guD.getResources().getString(d.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.guH.setText(str);
                    PersonalChatView.this.guF.setAnimation(translateAnimation);
                }
            });
            this.guF.setVisibility(0);
            this.guF.startAnimation(translateAnimation2);
        } else {
            this.guF.setVisibility(0);
            this.guG.setText(this.guD.getResources().getString(d.j.add_friend_agree_title, name_show));
            this.guH.setText(str);
        }
        this.guJ.setText(d.j.add_friend_agree_button);
    }

    private void lB(boolean z) {
        bwC();
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
                    PersonalChatView.this.guE.setVisibility(8);
                }
            });
            this.guE.startAnimation(translateAnimation);
            return;
        }
        this.guE.setVisibility(8);
    }

    public Button bwE() {
        return this.guJ;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
