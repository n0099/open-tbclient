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
    private TextView gaK;
    private PersonalChatActivity guP;
    private LinearLayout guQ;
    private LinearLayout guR;
    private TextView guS;
    private TextView guT;
    private TextView guU;
    private Button guV;
    private View.OnClickListener guW;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.guW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.guP.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.guP.bwD() && this.mTool != null) {
            b(this.mTool.jt(6));
            b(this.mTool.jt(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.guP = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.gaK = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.gaK.setText(string);
        }
        if (!this.guP.bwD()) {
            this.guQ = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.guR = (LinearLayout) this.guQ.findViewById(d.g.add_friend_tip_full);
            this.guS = (TextView) this.guQ.findViewById(d.g.add_friend_tip_title);
            this.guT = (TextView) this.guQ.findViewById(d.g.add_friend_tip_content);
            this.guU = (TextView) this.guQ.findViewById(d.g.add_friend_tip_center);
            this.guV = (Button) this.guQ.findViewById(d.g.add_friend_tip_button);
            this.guV.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.guQ.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gaK != null) {
            al.d(this.gaK, d.C0277d.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.guW);
        }
    }

    private void bwF() {
        if (this.mTool != null) {
            this.mTool.amc();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.guQ.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bwG();
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

    private void bwG() {
        this.guQ.setVisibility(8);
        this.guR.setVisibility(0);
        this.guU.setVisibility(8);
        this.guS.setText(d.j.add_friend_title);
        this.guT.setText(d.j.add_friend_content);
        this.guV.setText(d.j.add_friend_button);
    }

    private void lA(boolean z) {
        if (this.guP.bwB().bxm() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.guU.startAnimation(translateAnimation);
                }
            });
            this.guU.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.guU.setVisibility(0);
                    PersonalChatView.this.guU.setAnimation(translateAnimation3);
                }
            });
            this.guR.setVisibility(8);
            this.guR.startAnimation(translateAnimation4);
        } else {
            this.guR.setVisibility(8);
            this.guU.setVisibility(0);
        }
        this.guU.setText(d.j.add_friend_wait);
        this.guV.setText(d.j.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.guP.bwB().getUser().getName_show();
        this.guU.setVisibility(8);
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
                    PersonalChatView.this.guR.clearAnimation();
                    PersonalChatView.this.guS.setText(PersonalChatView.this.guP.getResources().getString(d.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.guT.setText(str);
                    PersonalChatView.this.guR.setAnimation(translateAnimation);
                }
            });
            this.guR.setVisibility(0);
            this.guR.startAnimation(translateAnimation2);
        } else {
            this.guR.setVisibility(0);
            this.guS.setText(this.guP.getResources().getString(d.j.add_friend_agree_title, name_show));
            this.guT.setText(str);
        }
        this.guV.setText(d.j.add_friend_agree_button);
    }

    private void lB(boolean z) {
        bwF();
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
                    PersonalChatView.this.guQ.setVisibility(8);
                }
            });
            this.guQ.startAnimation(translateAnimation);
            return;
        }
        this.guQ.setVisibility(8);
    }

    public Button bwH() {
        return this.guV;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
