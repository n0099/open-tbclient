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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.h;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView kAm;
    private PersonalChatActivity kOj;
    private LinearLayout kOk;
    private LinearLayout kOl;
    private TextView kOm;
    private TextView kOn;
    private TextView kOo;
    private Button kOp;
    private View.OnClickListener kOq;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kOq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.kOj.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.kOj.cYr() && this.mTool != null) {
            b(this.mTool.qR(6));
            b(this.mTool.qR(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.kOj = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.kAm = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kAm.setText(string);
        }
        if (!this.kOj.cYr()) {
            this.kOk = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kOl = (LinearLayout) this.kOk.findViewById(R.id.add_friend_tip_full);
            this.kOm = (TextView) this.kOk.findViewById(R.id.add_friend_tip_title);
            this.kOn = (TextView) this.kOk.findViewById(R.id.add_friend_tip_content);
            this.kOo = (TextView) this.kOk.findViewById(R.id.add_friend_tip_center);
            this.kOp = (Button) this.kOk.findViewById(R.id.add_friend_tip_button);
            this.kOp.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.kOk.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kAm != null) {
            ap.setViewTextColor(this.kAm, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.kOq);
        }
    }

    private void cYu() {
        if (this.mTool != null) {
            this.mTool.bBt();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.kOk.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cYv();
                return;
            case WAIT:
                tg(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                C(z, str);
                return;
            case PASS:
                th(z);
                return;
            default:
                return;
        }
    }

    private void cYv() {
        this.kOk.setVisibility(8);
        this.kOl.setVisibility(0);
        this.kOo.setVisibility(8);
        this.kOm.setText(R.string.add_friend_title);
        this.kOn.setText(R.string.add_friend_content);
        this.kOp.setText(R.string.add_friend_button);
    }

    private void tg(boolean z) {
        if (this.kOj.cYp().cZb() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.kOo.startAnimation(translateAnimation);
                }
            });
            this.kOo.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.kOo.setVisibility(0);
                    PersonalChatView.this.kOo.setAnimation(translateAnimation3);
                }
            });
            this.kOl.setVisibility(8);
            this.kOl.startAnimation(translateAnimation4);
        } else {
            this.kOl.setVisibility(8);
            this.kOo.setVisibility(0);
        }
        this.kOo.setText(R.string.add_friend_wait);
        this.kOp.setText(R.string.add_friend_button);
    }

    private void C(boolean z, final String str) {
        final String name_show = this.kOj.cYp().getUser().getName_show();
        this.kOo.setVisibility(8);
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
                    PersonalChatView.this.kOl.clearAnimation();
                    PersonalChatView.this.kOm.setText(PersonalChatView.this.kOj.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kOn.setText(str);
                    PersonalChatView.this.kOl.setAnimation(translateAnimation);
                }
            });
            this.kOl.setVisibility(0);
            this.kOl.startAnimation(translateAnimation2);
        } else {
            this.kOl.setVisibility(0);
            this.kOm.setText(this.kOj.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kOn.setText(str);
        }
        this.kOp.setText(R.string.add_friend_agree_button);
    }

    private void th(boolean z) {
        cYu();
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
                    PersonalChatView.this.kOk.setVisibility(8);
                }
            });
            this.kOk.startAnimation(translateAnimation);
            return;
        }
        this.kOk.setVisibility(8);
    }

    public Button cYw() {
        return this.kOp;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
