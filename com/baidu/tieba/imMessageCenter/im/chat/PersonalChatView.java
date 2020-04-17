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
    private TextView ida;
    private PersonalChatActivity ixh;
    private LinearLayout ixi;
    private LinearLayout ixj;
    private TextView ixk;
    private TextView ixl;
    private TextView ixm;
    private Button ixn;
    private View.OnClickListener ixo;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ixo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ixh.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.ixh.cjw() && this.mTool != null) {
            b(this.mTool.mA(6));
            b(this.mTool.mA(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ixh = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.ida = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.ida.setText(string);
        }
        if (!this.ixh.cjw()) {
            this.ixi = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.ixj = (LinearLayout) this.ixi.findViewById(R.id.add_friend_tip_full);
            this.ixk = (TextView) this.ixi.findViewById(R.id.add_friend_tip_title);
            this.ixl = (TextView) this.ixi.findViewById(R.id.add_friend_tip_content);
            this.ixm = (TextView) this.ixi.findViewById(R.id.add_friend_tip_center);
            this.ixn = (Button) this.ixi.findViewById(R.id.add_friend_tip_button);
            this.ixn.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ixi.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ida != null) {
            am.setViewTextColor(this.ida, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.ixo);
        }
    }

    private void cjy() {
        if (this.mTool != null) {
            this.mTool.aWY();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ixi.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cjz();
                return;
            case WAIT:
                pg(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                p(z, str);
                return;
            case PASS:
                ph(z);
                return;
            default:
                return;
        }
    }

    private void cjz() {
        this.ixi.setVisibility(8);
        this.ixj.setVisibility(0);
        this.ixm.setVisibility(8);
        this.ixk.setText(R.string.add_friend_title);
        this.ixl.setText(R.string.add_friend_content);
        this.ixn.setText(R.string.add_friend_button);
    }

    private void pg(boolean z) {
        if (this.ixh.cju().cke() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ixm.startAnimation(translateAnimation);
                }
            });
            this.ixm.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ixm.setVisibility(0);
                    PersonalChatView.this.ixm.setAnimation(translateAnimation3);
                }
            });
            this.ixj.setVisibility(8);
            this.ixj.startAnimation(translateAnimation4);
        } else {
            this.ixj.setVisibility(8);
            this.ixm.setVisibility(0);
        }
        this.ixm.setText(R.string.add_friend_wait);
        this.ixn.setText(R.string.add_friend_button);
    }

    private void p(boolean z, final String str) {
        final String name_show = this.ixh.cju().getUser().getName_show();
        this.ixm.setVisibility(8);
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
                    PersonalChatView.this.ixj.clearAnimation();
                    PersonalChatView.this.ixk.setText(PersonalChatView.this.ixh.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.ixl.setText(str);
                    PersonalChatView.this.ixj.setAnimation(translateAnimation);
                }
            });
            this.ixj.setVisibility(0);
            this.ixj.startAnimation(translateAnimation2);
        } else {
            this.ixj.setVisibility(0);
            this.ixk.setText(this.ixh.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.ixl.setText(str);
        }
        this.ixn.setText(R.string.add_friend_agree_button);
    }

    private void ph(boolean z) {
        cjy();
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
                    PersonalChatView.this.ixi.setVisibility(8);
                }
            });
            this.ixi.startAnimation(translateAnimation);
            return;
        }
        this.ixi.setVisibility(8);
    }

    public Button cjA() {
        return this.ixn;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
