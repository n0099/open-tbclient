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
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity eAk;
    private LinearLayout eAl;
    private LinearLayout eAm;
    private TextView eAn;
    private TextView eAo;
    private TextView eAp;
    private Button eAq;
    private View.OnClickListener eAr;
    private TextView ega;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eAr = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eAk.showToast(d.k.add_friend_cannot_send);
            }
        };
        if (!this.eAk.aMW() && this.mTool != null) {
            b(this.mTool.eK(6));
            b(this.mTool.eK(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eAk = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.k.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.personal_info_btn, talkableActivity);
            this.ega = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.ega.setText(string);
        }
        if (!this.eAk.aMW()) {
            this.eAl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.eAm = (LinearLayout) this.eAl.findViewById(d.g.add_friend_tip_full);
            this.eAn = (TextView) this.eAl.findViewById(d.g.add_friend_tip_title);
            this.eAo = (TextView) this.eAl.findViewById(d.g.add_friend_tip_content);
            this.eAp = (TextView) this.eAl.findViewById(d.g.add_friend_tip_center);
            this.eAq = (Button) this.eAl.findViewById(d.g.add_friend_tip_button);
            this.eAq.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eAl.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.ega != null) {
            am.c(this.ega, d.C0142d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.eAr);
        }
    }

    private void aMY() {
        if (this.mTool != null) {
            this.mTool.HH();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eAl.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aMZ();
                return;
            case WAIT:
                hS(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                k(z, str);
                return;
            case PASS:
                hT(z);
                return;
            default:
                return;
        }
    }

    private void aMZ() {
        this.eAl.setVisibility(8);
        this.eAm.setVisibility(0);
        this.eAp.setVisibility(8);
        this.eAn.setText(d.k.add_friend_title);
        this.eAo.setText(d.k.add_friend_content);
        this.eAq.setText(d.k.add_friend_button);
    }

    private void hS(boolean z) {
        if (this.eAk.aMU().aNG() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eAp.startAnimation(translateAnimation);
                }
            });
            this.eAp.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eAp.setVisibility(0);
                    PersonalChatView.this.eAp.setAnimation(translateAnimation3);
                }
            });
            this.eAm.setVisibility(8);
            this.eAm.startAnimation(translateAnimation4);
        } else {
            this.eAm.setVisibility(8);
            this.eAp.setVisibility(0);
        }
        this.eAp.setText(d.k.add_friend_wait);
        this.eAq.setText(d.k.add_friend_button);
    }

    private void k(boolean z, final String str) {
        final String name_show = this.eAk.aMU().getUser().getName_show();
        this.eAp.setVisibility(8);
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
                    PersonalChatView.this.eAm.clearAnimation();
                    PersonalChatView.this.eAn.setText(PersonalChatView.this.eAk.getResources().getString(d.k.add_friend_agree_title, name_show));
                    PersonalChatView.this.eAo.setText(str);
                    PersonalChatView.this.eAm.setAnimation(translateAnimation);
                }
            });
            this.eAm.setVisibility(0);
            this.eAm.startAnimation(translateAnimation2);
        } else {
            this.eAm.setVisibility(0);
            this.eAn.setText(this.eAk.getResources().getString(d.k.add_friend_agree_title, name_show));
            this.eAo.setText(str);
        }
        this.eAq.setText(d.k.add_friend_agree_button);
    }

    private void hT(boolean z) {
        aMY();
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
                    PersonalChatView.this.eAl.setVisibility(8);
                }
            });
            this.eAl.startAnimation(translateAnimation);
            return;
        }
        this.eAl.setVisibility(8);
    }

    public Button aNa() {
        return this.eAq;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
