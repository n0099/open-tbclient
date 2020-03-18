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
/* loaded from: classes9.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity hNq;
    private LinearLayout hNr;
    private LinearLayout hNs;
    private TextView hNt;
    private TextView hNu;
    private TextView hNv;
    private Button hNw;
    private View.OnClickListener hNx;
    private TextView htr;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hNx = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hNq.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hNq.bYV() && this.mTool != null) {
            b(this.mTool.mo(6));
            b(this.mTool.mo(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hNq = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.htr = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.htr.setText(string);
        }
        if (!this.hNq.bYV()) {
            this.hNr = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hNs = (LinearLayout) this.hNr.findViewById(R.id.add_friend_tip_full);
            this.hNt = (TextView) this.hNr.findViewById(R.id.add_friend_tip_title);
            this.hNu = (TextView) this.hNr.findViewById(R.id.add_friend_tip_content);
            this.hNv = (TextView) this.hNr.findViewById(R.id.add_friend_tip_center);
            this.hNw = (Button) this.hNr.findViewById(R.id.add_friend_tip_button);
            this.hNw.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hNr.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.htr != null) {
            am.setViewTextColor(this.htr, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hNx);
        }
    }

    private void bYX() {
        if (this.mTool != null) {
            this.mTool.aOH();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hNr.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bYY();
                return;
            case WAIT:
                oc(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                o(z, str);
                return;
            case PASS:
                od(z);
                return;
            default:
                return;
        }
    }

    private void bYY() {
        this.hNr.setVisibility(8);
        this.hNs.setVisibility(0);
        this.hNv.setVisibility(8);
        this.hNt.setText(R.string.add_friend_title);
        this.hNu.setText(R.string.add_friend_content);
        this.hNw.setText(R.string.add_friend_button);
    }

    private void oc(boolean z) {
        if (this.hNq.bYT().bZD() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hNv.startAnimation(translateAnimation);
                }
            });
            this.hNv.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hNv.setVisibility(0);
                    PersonalChatView.this.hNv.setAnimation(translateAnimation3);
                }
            });
            this.hNs.setVisibility(8);
            this.hNs.startAnimation(translateAnimation4);
        } else {
            this.hNs.setVisibility(8);
            this.hNv.setVisibility(0);
        }
        this.hNv.setText(R.string.add_friend_wait);
        this.hNw.setText(R.string.add_friend_button);
    }

    private void o(boolean z, final String str) {
        final String name_show = this.hNq.bYT().getUser().getName_show();
        this.hNv.setVisibility(8);
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
                    PersonalChatView.this.hNs.clearAnimation();
                    PersonalChatView.this.hNt.setText(PersonalChatView.this.hNq.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hNu.setText(str);
                    PersonalChatView.this.hNs.setAnimation(translateAnimation);
                }
            });
            this.hNs.setVisibility(0);
            this.hNs.startAnimation(translateAnimation2);
        } else {
            this.hNs.setVisibility(0);
            this.hNt.setText(this.hNq.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hNu.setText(str);
        }
        this.hNw.setText(R.string.add_friend_agree_button);
    }

    private void od(boolean z) {
        bYX();
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
                    PersonalChatView.this.hNr.setVisibility(8);
                }
            });
            this.hNr.startAnimation(translateAnimation);
            return;
        }
        this.hNr.setVisibility(8);
    }

    public Button bYZ() {
        return this.hNw;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
