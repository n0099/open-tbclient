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
    private TextView kCo;
    private PersonalChatActivity kQl;
    private LinearLayout kQm;
    private LinearLayout kQn;
    private TextView kQo;
    private TextView kQp;
    private TextView kQq;
    private Button kQr;
    private View.OnClickListener kQs;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kQs = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.kQl.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.kQl.cYy() && this.mTool != null) {
            b(this.mTool.qS(6));
            b(this.mTool.qS(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.kQl = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.kCo = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kCo.setText(string);
        }
        if (!this.kQl.cYy()) {
            this.kQm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kQn = (LinearLayout) this.kQm.findViewById(R.id.add_friend_tip_full);
            this.kQo = (TextView) this.kQm.findViewById(R.id.add_friend_tip_title);
            this.kQp = (TextView) this.kQm.findViewById(R.id.add_friend_tip_content);
            this.kQq = (TextView) this.kQm.findViewById(R.id.add_friend_tip_center);
            this.kQr = (Button) this.kQm.findViewById(R.id.add_friend_tip_button);
            this.kQr.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.kQm.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kCo != null) {
            ap.setViewTextColor(this.kCo, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.kQs);
        }
    }

    private void cYB() {
        if (this.mTool != null) {
            this.mTool.bBw();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.kQm.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cYC();
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

    private void cYC() {
        this.kQm.setVisibility(8);
        this.kQn.setVisibility(0);
        this.kQq.setVisibility(8);
        this.kQo.setText(R.string.add_friend_title);
        this.kQp.setText(R.string.add_friend_content);
        this.kQr.setText(R.string.add_friend_button);
    }

    private void tg(boolean z) {
        if (this.kQl.cYw().cZi() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.kQq.startAnimation(translateAnimation);
                }
            });
            this.kQq.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.kQq.setVisibility(0);
                    PersonalChatView.this.kQq.setAnimation(translateAnimation3);
                }
            });
            this.kQn.setVisibility(8);
            this.kQn.startAnimation(translateAnimation4);
        } else {
            this.kQn.setVisibility(8);
            this.kQq.setVisibility(0);
        }
        this.kQq.setText(R.string.add_friend_wait);
        this.kQr.setText(R.string.add_friend_button);
    }

    private void C(boolean z, final String str) {
        final String name_show = this.kQl.cYw().getUser().getName_show();
        this.kQq.setVisibility(8);
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
                    PersonalChatView.this.kQn.clearAnimation();
                    PersonalChatView.this.kQo.setText(PersonalChatView.this.kQl.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kQp.setText(str);
                    PersonalChatView.this.kQn.setAnimation(translateAnimation);
                }
            });
            this.kQn.setVisibility(0);
            this.kQn.startAnimation(translateAnimation2);
        } else {
            this.kQn.setVisibility(0);
            this.kQo.setText(this.kQl.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kQp.setText(str);
        }
        this.kQr.setText(R.string.add_friend_agree_button);
    }

    private void th(boolean z) {
        cYB();
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
                    PersonalChatView.this.kQm.setVisibility(8);
                }
            });
            this.kQm.startAnimation(translateAnimation);
            return;
        }
        this.kQm.setVisibility(8);
    }

    public Button cYD() {
        return this.kQr;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
