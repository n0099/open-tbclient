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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView dQU;
    private PersonalChatActivity elc;
    private LinearLayout eld;
    private LinearLayout ele;
    private TextView elf;
    private TextView elg;
    private TextView elh;
    private Button eli;
    private View.OnClickListener elj;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.elj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PersonalChatView.this.elc.showToast(d.k.add_friend_cannot_send);
            }
        };
        if (!this.elc.aHv() && this.mTool != null) {
            b(this.mTool.eF(6));
            b(this.mTool.eF(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.elc = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.k.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.personal_info_btn, talkableActivity);
            this.dQU = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.dQU.setText(string);
        }
        if (!this.elc.aHv()) {
            this.eld = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ele = (LinearLayout) this.eld.findViewById(d.g.add_friend_tip_full);
            this.elf = (TextView) this.eld.findViewById(d.g.add_friend_tip_title);
            this.elg = (TextView) this.eld.findViewById(d.g.add_friend_tip_content);
            this.elh = (TextView) this.eld.findViewById(d.g.add_friend_tip_center);
            this.eli = (Button) this.eld.findViewById(d.g.add_friend_tip_button);
            this.eli.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eld.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dQU != null) {
            ak.c(this.dQU, d.C0126d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.elj);
        }
    }

    private void aHx() {
        if (this.mTool != null) {
            this.mTool.DM();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eld.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aHy();
                return;
            case WAIT:
                hC(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                hD(z);
                return;
            default:
                return;
        }
    }

    private void aHy() {
        this.eld.setVisibility(8);
        this.ele.setVisibility(0);
        this.elh.setVisibility(8);
        this.elf.setText(d.k.add_friend_title);
        this.elg.setText(d.k.add_friend_content);
        this.eli.setText(d.k.add_friend_button);
    }

    private void hC(boolean z) {
        if (this.elc.aHt().aIf() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.elh.startAnimation(translateAnimation);
                }
            });
            this.elh.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.elh.setVisibility(0);
                    PersonalChatView.this.elh.setAnimation(translateAnimation3);
                }
            });
            this.ele.setVisibility(8);
            this.ele.startAnimation(translateAnimation4);
        } else {
            this.ele.setVisibility(8);
            this.elh.setVisibility(0);
        }
        this.elh.setText(d.k.add_friend_wait);
        this.eli.setText(d.k.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String userName = this.elc.aHt().getUser().getUserName();
        this.elh.setVisibility(8);
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
                    PersonalChatView.this.ele.clearAnimation();
                    PersonalChatView.this.elf.setText(PersonalChatView.this.elc.getResources().getString(d.k.add_friend_agree_title, userName));
                    PersonalChatView.this.elg.setText(str);
                    PersonalChatView.this.ele.setAnimation(translateAnimation);
                }
            });
            this.ele.setVisibility(0);
            this.ele.startAnimation(translateAnimation2);
        } else {
            this.ele.setVisibility(0);
            this.elf.setText(this.elc.getResources().getString(d.k.add_friend_agree_title, userName));
            this.elg.setText(str);
        }
        this.eli.setText(d.k.add_friend_agree_button);
    }

    private void hD(boolean z) {
        aHx();
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
                    PersonalChatView.this.eld.setVisibility(8);
                }
            });
            this.eld.startAnimation(translateAnimation);
            return;
        }
        this.eld.setVisibility(8);
    }

    public Button aHz() {
        return this.eli;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
