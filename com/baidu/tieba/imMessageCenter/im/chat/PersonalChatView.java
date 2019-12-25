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
/* loaded from: classes6.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity hGa;
    private LinearLayout hGb;
    private LinearLayout hGc;
    private TextView hGd;
    private TextView hGe;
    private TextView hGf;
    private Button hGg;
    private View.OnClickListener hGh;
    private TextView hmb;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.hGh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.hGa.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.hGa.bVQ() && this.mTool != null) {
            b(this.mTool.lU(6));
            b(this.mTool.lU(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.hGa = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.hmb = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.hmb.setText(string);
        }
        if (!this.hGa.bVQ()) {
            this.hGb = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.hGc = (LinearLayout) this.hGb.findViewById(R.id.add_friend_tip_full);
            this.hGd = (TextView) this.hGb.findViewById(R.id.add_friend_tip_title);
            this.hGe = (TextView) this.hGb.findViewById(R.id.add_friend_tip_content);
            this.hGf = (TextView) this.hGb.findViewById(R.id.add_friend_tip_center);
            this.hGg = (Button) this.hGb.findViewById(R.id.add_friend_tip_button);
            this.hGg.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.hGb.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hmb != null) {
            am.setViewTextColor(this.hmb, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.hGh);
        }
    }

    private void bVS() {
        if (this.mTool != null) {
            this.mTool.aLL();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.hGb.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                bVT();
                return;
            case WAIT:
                nI(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                n(z, str);
                return;
            case PASS:
                nJ(z);
                return;
            default:
                return;
        }
    }

    private void bVT() {
        this.hGb.setVisibility(8);
        this.hGc.setVisibility(0);
        this.hGf.setVisibility(8);
        this.hGd.setText(R.string.add_friend_title);
        this.hGe.setText(R.string.add_friend_content);
        this.hGg.setText(R.string.add_friend_button);
    }

    private void nI(boolean z) {
        if (this.hGa.bVO().bWy() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.hGf.startAnimation(translateAnimation);
                }
            });
            this.hGf.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.hGf.setVisibility(0);
                    PersonalChatView.this.hGf.setAnimation(translateAnimation3);
                }
            });
            this.hGc.setVisibility(8);
            this.hGc.startAnimation(translateAnimation4);
        } else {
            this.hGc.setVisibility(8);
            this.hGf.setVisibility(0);
        }
        this.hGf.setText(R.string.add_friend_wait);
        this.hGg.setText(R.string.add_friend_button);
    }

    private void n(boolean z, final String str) {
        final String name_show = this.hGa.bVO().getUser().getName_show();
        this.hGf.setVisibility(8);
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
                    PersonalChatView.this.hGc.clearAnimation();
                    PersonalChatView.this.hGd.setText(PersonalChatView.this.hGa.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.hGe.setText(str);
                    PersonalChatView.this.hGc.setAnimation(translateAnimation);
                }
            });
            this.hGc.setVisibility(0);
            this.hGc.startAnimation(translateAnimation2);
        } else {
            this.hGc.setVisibility(0);
            this.hGd.setText(this.hGa.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.hGe.setText(str);
        }
        this.hGg.setText(R.string.add_friend_agree_button);
    }

    private void nJ(boolean z) {
        bVS();
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
                    PersonalChatView.this.hGb.setVisibility(8);
                }
            });
            this.hGb.startAnimation(translateAnimation);
            return;
        }
        this.hGb.setVisibility(8);
    }

    public Button bVU() {
        return this.hGg;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
