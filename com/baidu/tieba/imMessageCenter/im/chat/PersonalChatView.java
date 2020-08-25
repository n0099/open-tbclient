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
/* loaded from: classes16.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity jBe;
    private LinearLayout jBf;
    private LinearLayout jBg;
    private TextView jBh;
    private TextView jBi;
    private TextView jBj;
    private Button jBk;
    private View.OnClickListener jBl;
    private TextView jeQ;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.jBl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.jBe.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.jBe.cIK() && this.mTool != null) {
            b(this.mTool.qb(6));
            b(this.mTool.qb(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.jBe = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jeQ = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jeQ.setText(string);
        }
        if (!this.jBe.cIK()) {
            this.jBf = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.jBg = (LinearLayout) this.jBf.findViewById(R.id.add_friend_tip_full);
            this.jBh = (TextView) this.jBf.findViewById(R.id.add_friend_tip_title);
            this.jBi = (TextView) this.jBf.findViewById(R.id.add_friend_tip_content);
            this.jBj = (TextView) this.jBf.findViewById(R.id.add_friend_tip_center);
            this.jBk = (Button) this.jBf.findViewById(R.id.add_friend_tip_button);
            this.jBk.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.jBf.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jeQ != null) {
            ap.setViewTextColor(this.jeQ, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.jBl);
        }
    }

    private void cIN() {
        if (this.mTool != null) {
            this.mTool.brF();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.jBf.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cIO();
                return;
            case WAIT:
                ra(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                s(z, str);
                return;
            case PASS:
                rb(z);
                return;
            default:
                return;
        }
    }

    private void cIO() {
        this.jBf.setVisibility(8);
        this.jBg.setVisibility(0);
        this.jBj.setVisibility(8);
        this.jBh.setText(R.string.add_friend_title);
        this.jBi.setText(R.string.add_friend_content);
        this.jBk.setText(R.string.add_friend_button);
    }

    private void ra(boolean z) {
        if (this.jBe.cII().cJu() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.jBj.startAnimation(translateAnimation);
                }
            });
            this.jBj.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.jBj.setVisibility(0);
                    PersonalChatView.this.jBj.setAnimation(translateAnimation3);
                }
            });
            this.jBg.setVisibility(8);
            this.jBg.startAnimation(translateAnimation4);
        } else {
            this.jBg.setVisibility(8);
            this.jBj.setVisibility(0);
        }
        this.jBj.setText(R.string.add_friend_wait);
        this.jBk.setText(R.string.add_friend_button);
    }

    private void s(boolean z, final String str) {
        final String name_show = this.jBe.cII().getUser().getName_show();
        this.jBj.setVisibility(8);
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
                    PersonalChatView.this.jBg.clearAnimation();
                    PersonalChatView.this.jBh.setText(PersonalChatView.this.jBe.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.jBi.setText(str);
                    PersonalChatView.this.jBg.setAnimation(translateAnimation);
                }
            });
            this.jBg.setVisibility(0);
            this.jBg.startAnimation(translateAnimation2);
        } else {
            this.jBg.setVisibility(0);
            this.jBh.setText(this.jBe.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.jBi.setText(str);
        }
        this.jBk.setText(R.string.add_friend_agree_button);
    }

    private void rb(boolean z) {
        cIN();
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
                    PersonalChatView.this.jBf.setVisibility(8);
                }
            });
            this.jBf.startAnimation(translateAnimation);
            return;
        }
        this.jBf.setVisibility(8);
    }

    public Button cIP() {
        return this.jBk;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
