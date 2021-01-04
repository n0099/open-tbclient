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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.h;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView kKA;
    private TextView kKB;
    private Button kKC;
    private View.OnClickListener kKD;
    private PersonalChatActivity kKw;
    private LinearLayout kKx;
    private LinearLayout kKy;
    private TextView kKz;
    private TextView kww;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kKD = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.kKw.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.kKw.dad() && this.mTool != null) {
            b(this.mTool.ss(6));
            b(this.mTool.ss(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.kKw = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.kww = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kww.setText(string);
        }
        if (!this.kKw.dad()) {
            this.kKx = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kKy = (LinearLayout) this.kKx.findViewById(R.id.add_friend_tip_full);
            this.kKz = (TextView) this.kKx.findViewById(R.id.add_friend_tip_title);
            this.kKA = (TextView) this.kKx.findViewById(R.id.add_friend_tip_content);
            this.kKB = (TextView) this.kKx.findViewById(R.id.add_friend_tip_center);
            this.kKC = (Button) this.kKx.findViewById(R.id.add_friend_tip_button);
            this.kKC.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.kKx.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kww != null) {
            ao.setViewTextColor(this.kww, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.kKD);
        }
    }

    private void dag() {
        if (this.mTool != null) {
            this.mTool.bEU();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.kKx.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                dah();
                return;
            case WAIT:
                sX(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                v(z, str);
                return;
            case PASS:
                sY(z);
                return;
            default:
                return;
        }
    }

    private void dah() {
        this.kKx.setVisibility(8);
        this.kKy.setVisibility(0);
        this.kKB.setVisibility(8);
        this.kKz.setText(R.string.add_friend_title);
        this.kKA.setText(R.string.add_friend_content);
        this.kKC.setText(R.string.add_friend_button);
    }

    private void sX(boolean z) {
        if (this.kKw.dab().daN() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.kKB.startAnimation(translateAnimation);
                }
            });
            this.kKB.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.kKB.setVisibility(0);
                    PersonalChatView.this.kKB.setAnimation(translateAnimation3);
                }
            });
            this.kKy.setVisibility(8);
            this.kKy.startAnimation(translateAnimation4);
        } else {
            this.kKy.setVisibility(8);
            this.kKB.setVisibility(0);
        }
        this.kKB.setText(R.string.add_friend_wait);
        this.kKC.setText(R.string.add_friend_button);
    }

    private void v(boolean z, final String str) {
        final String name_show = this.kKw.dab().getUser().getName_show();
        this.kKB.setVisibility(8);
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
                    PersonalChatView.this.kKy.clearAnimation();
                    PersonalChatView.this.kKz.setText(PersonalChatView.this.kKw.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kKA.setText(str);
                    PersonalChatView.this.kKy.setAnimation(translateAnimation);
                }
            });
            this.kKy.setVisibility(0);
            this.kKy.startAnimation(translateAnimation2);
        } else {
            this.kKy.setVisibility(0);
            this.kKz.setText(this.kKw.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kKA.setText(str);
        }
        this.kKC.setText(R.string.add_friend_agree_button);
    }

    private void sY(boolean z) {
        dag();
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
                    PersonalChatView.this.kKx.setVisibility(8);
                }
            });
            this.kKx.startAnimation(translateAnimation);
            return;
        }
        this.kKx.setVisibility(8);
    }

    public Button dai() {
        return this.kKC;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
