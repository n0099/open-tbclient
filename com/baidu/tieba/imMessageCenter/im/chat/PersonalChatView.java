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
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView ecg;
    private View.OnClickListener ewA;
    private PersonalChatActivity ewt;
    private LinearLayout ewu;
    private LinearLayout ewv;
    private TextView eww;
    private TextView ewx;
    private TextView ewy;
    private Button ewz;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ewA = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ewt.showToast(d.k.add_friend_cannot_send);
            }
        };
        if (!this.ewt.aMq() && this.mTool != null) {
            b(this.mTool.eJ(6));
            b(this.mTool.eJ(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ewt = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.k.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.personal_info_btn, talkableActivity);
            this.ecg = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.ecg.setText(string);
        }
        if (!this.ewt.aMq()) {
            this.ewu = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ewv = (LinearLayout) this.ewu.findViewById(d.g.add_friend_tip_full);
            this.eww = (TextView) this.ewu.findViewById(d.g.add_friend_tip_title);
            this.ewx = (TextView) this.ewu.findViewById(d.g.add_friend_tip_content);
            this.ewy = (TextView) this.ewu.findViewById(d.g.add_friend_tip_center);
            this.ewz = (Button) this.ewu.findViewById(d.g.add_friend_tip_button);
            this.ewz.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ewu.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ecg != null) {
            al.c(this.ecg, d.C0141d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.ewA);
        }
    }

    private void aMs() {
        if (this.mTool != null) {
            this.mTool.Hp();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ewu.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aMt();
                return;
            case WAIT:
                hI(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                k(z, str);
                return;
            case PASS:
                hJ(z);
                return;
            default:
                return;
        }
    }

    private void aMt() {
        this.ewu.setVisibility(8);
        this.ewv.setVisibility(0);
        this.ewy.setVisibility(8);
        this.eww.setText(d.k.add_friend_title);
        this.ewx.setText(d.k.add_friend_content);
        this.ewz.setText(d.k.add_friend_button);
    }

    private void hI(boolean z) {
        if (this.ewt.aMo().aNa() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ewy.startAnimation(translateAnimation);
                }
            });
            this.ewy.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ewy.setVisibility(0);
                    PersonalChatView.this.ewy.setAnimation(translateAnimation3);
                }
            });
            this.ewv.setVisibility(8);
            this.ewv.startAnimation(translateAnimation4);
        } else {
            this.ewv.setVisibility(8);
            this.ewy.setVisibility(0);
        }
        this.ewy.setText(d.k.add_friend_wait);
        this.ewz.setText(d.k.add_friend_button);
    }

    private void k(boolean z, final String str) {
        final String name_show = this.ewt.aMo().getUser().getName_show();
        this.ewy.setVisibility(8);
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
                    PersonalChatView.this.ewv.clearAnimation();
                    PersonalChatView.this.eww.setText(PersonalChatView.this.ewt.getResources().getString(d.k.add_friend_agree_title, name_show));
                    PersonalChatView.this.ewx.setText(str);
                    PersonalChatView.this.ewv.setAnimation(translateAnimation);
                }
            });
            this.ewv.setVisibility(0);
            this.ewv.startAnimation(translateAnimation2);
        } else {
            this.ewv.setVisibility(0);
            this.eww.setText(this.ewt.getResources().getString(d.k.add_friend_agree_title, name_show));
            this.ewx.setText(str);
        }
        this.ewz.setText(d.k.add_friend_agree_button);
    }

    private void hJ(boolean z) {
        aMs();
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
                    PersonalChatView.this.ewu.setVisibility(8);
                }
            });
            this.ewu.startAnimation(translateAnimation);
            return;
        }
        this.ewu.setVisibility(8);
    }

    public Button aMu() {
        return this.ewz;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
