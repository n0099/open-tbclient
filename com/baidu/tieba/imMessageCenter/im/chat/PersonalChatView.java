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
    private PersonalChatActivity eLd;
    private LinearLayout eLe;
    private LinearLayout eLf;
    private TextView eLg;
    private TextView eLh;
    private TextView eLi;
    private Button eLj;
    private View.OnClickListener eLk;
    private TextView eqV;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eLk = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eLd.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.eLd.aKV() && this.mTool != null) {
            b(this.mTool.hH(6));
            b(this.mTool.hH(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eLd = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.eqV = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.eqV.setText(string);
        }
        if (!this.eLd.aKV()) {
            this.eLe = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.eLf = (LinearLayout) this.eLe.findViewById(d.g.add_friend_tip_full);
            this.eLg = (TextView) this.eLe.findViewById(d.g.add_friend_tip_title);
            this.eLh = (TextView) this.eLe.findViewById(d.g.add_friend_tip_content);
            this.eLi = (TextView) this.eLe.findViewById(d.g.add_friend_tip_center);
            this.eLj = (Button) this.eLe.findViewById(d.g.add_friend_tip_button);
            this.eLj.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eLe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eqV != null) {
            aj.e(this.eqV, d.C0108d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.eLk);
        }
    }

    private void aKX() {
        if (this.mTool != null) {
            this.mTool.KF();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eLe.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aKY();
                return;
            case WAIT:
                hM(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                hN(z);
                return;
            default:
                return;
        }
    }

    private void aKY() {
        this.eLe.setVisibility(8);
        this.eLf.setVisibility(0);
        this.eLi.setVisibility(8);
        this.eLg.setText(d.j.add_friend_title);
        this.eLh.setText(d.j.add_friend_content);
        this.eLj.setText(d.j.add_friend_button);
    }

    private void hM(boolean z) {
        if (this.eLd.aKT().aLK() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eLi.startAnimation(translateAnimation);
                }
            });
            this.eLi.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eLi.setVisibility(0);
                    PersonalChatView.this.eLi.setAnimation(translateAnimation3);
                }
            });
            this.eLf.setVisibility(8);
            this.eLf.startAnimation(translateAnimation4);
        } else {
            this.eLf.setVisibility(8);
            this.eLi.setVisibility(0);
        }
        this.eLi.setText(d.j.add_friend_wait);
        this.eLj.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.eLd.aKT().getUser().getUserName();
        this.eLi.setVisibility(8);
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
                    PersonalChatView.this.eLf.clearAnimation();
                    PersonalChatView.this.eLg.setText(PersonalChatView.this.eLd.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.eLh.setText(str);
                    PersonalChatView.this.eLf.setAnimation(translateAnimation);
                }
            });
            this.eLf.setVisibility(0);
            this.eLf.startAnimation(translateAnimation2);
        } else {
            this.eLf.setVisibility(0);
            this.eLg.setText(this.eLd.getResources().getString(d.j.add_friend_agree_title, userName));
            this.eLh.setText(str);
        }
        this.eLj.setText(d.j.add_friend_agree_button);
    }

    private void hN(boolean z) {
        aKX();
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
                    PersonalChatView.this.eLe.setVisibility(8);
                }
            });
            this.eLe.startAnimation(translateAnimation);
            return;
        }
        this.eLe.setVisibility(8);
    }

    public Button aKZ() {
        return this.eLj;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
