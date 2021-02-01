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
    private PersonalChatActivity kNV;
    private LinearLayout kNW;
    private LinearLayout kNX;
    private TextView kNY;
    private TextView kNZ;
    private TextView kOa;
    private Button kOb;
    private View.OnClickListener kOc;
    private TextView kzY;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kOc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.kNV.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.kNV.cYk() && this.mTool != null) {
            b(this.mTool.qR(6));
            b(this.mTool.qR(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.kNV = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.kzY = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kzY.setText(string);
        }
        if (!this.kNV.cYk()) {
            this.kNW = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kNX = (LinearLayout) this.kNW.findViewById(R.id.add_friend_tip_full);
            this.kNY = (TextView) this.kNW.findViewById(R.id.add_friend_tip_title);
            this.kNZ = (TextView) this.kNW.findViewById(R.id.add_friend_tip_content);
            this.kOa = (TextView) this.kNW.findViewById(R.id.add_friend_tip_center);
            this.kOb = (Button) this.kNW.findViewById(R.id.add_friend_tip_button);
            this.kOb.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.kNW.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kzY != null) {
            ap.setViewTextColor(this.kzY, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.kOc);
        }
    }

    private void cYn() {
        if (this.mTool != null) {
            this.mTool.bBt();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.kNW.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cYo();
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

    private void cYo() {
        this.kNW.setVisibility(8);
        this.kNX.setVisibility(0);
        this.kOa.setVisibility(8);
        this.kNY.setText(R.string.add_friend_title);
        this.kNZ.setText(R.string.add_friend_content);
        this.kOb.setText(R.string.add_friend_button);
    }

    private void tg(boolean z) {
        if (this.kNV.cYi().cYU() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.kOa.startAnimation(translateAnimation);
                }
            });
            this.kOa.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.kOa.setVisibility(0);
                    PersonalChatView.this.kOa.setAnimation(translateAnimation3);
                }
            });
            this.kNX.setVisibility(8);
            this.kNX.startAnimation(translateAnimation4);
        } else {
            this.kNX.setVisibility(8);
            this.kOa.setVisibility(0);
        }
        this.kOa.setText(R.string.add_friend_wait);
        this.kOb.setText(R.string.add_friend_button);
    }

    private void C(boolean z, final String str) {
        final String name_show = this.kNV.cYi().getUser().getName_show();
        this.kOa.setVisibility(8);
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
                    PersonalChatView.this.kNX.clearAnimation();
                    PersonalChatView.this.kNY.setText(PersonalChatView.this.kNV.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kNZ.setText(str);
                    PersonalChatView.this.kNX.setAnimation(translateAnimation);
                }
            });
            this.kNX.setVisibility(0);
            this.kNX.startAnimation(translateAnimation2);
        } else {
            this.kNX.setVisibility(0);
            this.kNY.setText(this.kNV.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kNZ.setText(str);
        }
        this.kOb.setText(R.string.add_friend_agree_button);
    }

    private void th(boolean z) {
        cYn();
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
                    PersonalChatView.this.kNW.setVisibility(8);
                }
            });
            this.kNW.startAnimation(translateAnimation);
            return;
        }
        this.kNW.setVisibility(8);
    }

    public Button cYp() {
        return this.kOb;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
