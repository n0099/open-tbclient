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
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity gSd;
    private LinearLayout gSe;
    private LinearLayout gSf;
    private TextView gSg;
    private TextView gSh;
    private TextView gSi;
    private Button gSj;
    private View.OnClickListener gSk;
    private TextView gyc;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.gSk = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.gSd.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.gSd.bGT() && this.mTool != null) {
            b(this.mTool.km(6));
            b(this.mTool.km(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.gSd = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.gyc = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.gyc.setText(string);
        }
        if (!this.gSd.bGT()) {
            this.gSe = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.gSf = (LinearLayout) this.gSe.findViewById(R.id.add_friend_tip_full);
            this.gSg = (TextView) this.gSe.findViewById(R.id.add_friend_tip_title);
            this.gSh = (TextView) this.gSe.findViewById(R.id.add_friend_tip_content);
            this.gSi = (TextView) this.gSe.findViewById(R.id.add_friend_tip_center);
            this.gSj = (Button) this.gSe.findViewById(R.id.add_friend_tip_button);
            this.gSj.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.gSe.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gyc != null) {
            am.f(this.gyc, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.gSk);
        }
    }

    private void bGV() {
        if (this.mTool != null) {
            this.mTool.asi();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.gSe.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bGW();
                return;
            case WAIT:
                mE(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                mF(z);
                return;
            default:
                return;
        }
    }

    private void bGW() {
        this.gSe.setVisibility(8);
        this.gSf.setVisibility(0);
        this.gSi.setVisibility(8);
        this.gSg.setText(R.string.add_friend_title);
        this.gSh.setText(R.string.add_friend_content);
        this.gSj.setText(R.string.add_friend_button);
    }

    private void mE(boolean z) {
        if (this.gSd.bGR().bHC() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.gSi.startAnimation(translateAnimation);
                }
            });
            this.gSi.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.gSi.setVisibility(0);
                    PersonalChatView.this.gSi.setAnimation(translateAnimation3);
                }
            });
            this.gSf.setVisibility(8);
            this.gSf.startAnimation(translateAnimation4);
        } else {
            this.gSf.setVisibility(8);
            this.gSi.setVisibility(0);
        }
        this.gSi.setText(R.string.add_friend_wait);
        this.gSj.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.gSd.bGR().getUser().getName_show();
        this.gSi.setVisibility(8);
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
                    PersonalChatView.this.gSf.clearAnimation();
                    PersonalChatView.this.gSg.setText(PersonalChatView.this.gSd.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.gSh.setText(str);
                    PersonalChatView.this.gSf.setAnimation(translateAnimation);
                }
            });
            this.gSf.setVisibility(0);
            this.gSf.startAnimation(translateAnimation2);
        } else {
            this.gSf.setVisibility(0);
            this.gSg.setText(this.gSd.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.gSh.setText(str);
        }
        this.gSj.setText(R.string.add_friend_agree_button);
    }

    private void mF(boolean z) {
        bGV();
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
                    PersonalChatView.this.gSe.setVisibility(8);
                }
            });
            this.gSe.startAnimation(translateAnimation);
            return;
        }
        this.gSe.setVisibility(8);
    }

    public Button bGX() {
        return this.gSj;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
