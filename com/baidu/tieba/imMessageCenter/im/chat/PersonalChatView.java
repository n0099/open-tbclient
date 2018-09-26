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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.g;
import com.baidu.tieba.e;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity eLn;
    private LinearLayout eLo;
    private LinearLayout eLp;
    private TextView eLq;
    private TextView eLr;
    private TextView eLs;
    private Button eLt;
    private View.OnClickListener eLu;
    private TextView erf;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.eLu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.eLn.showToast(e.j.add_friend_cannot_send);
            }
        };
        if (!this.eLn.aQi() && this.mTool != null) {
            b(this.mTool.eW(6));
            b(this.mTool.eW(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.eLn = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(e.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.personal_info_btn, talkableActivity);
            this.erf = (TextView) this.mBtnGroupInfo.findViewById(e.g.group_info_btn_txt);
            this.erf.setText(string);
        }
        if (!this.eLn.aQi()) {
            this.eLo = (LinearLayout) ((ViewStub) talkableActivity.findViewById(e.g.stranger_person_add_friend_stub)).inflate();
            this.eLp = (LinearLayout) this.eLo.findViewById(e.g.add_friend_tip_full);
            this.eLq = (TextView) this.eLo.findViewById(e.g.add_friend_tip_title);
            this.eLr = (TextView) this.eLo.findViewById(e.g.add_friend_tip_content);
            this.eLs = (TextView) this.eLo.findViewById(e.g.add_friend_tip_center);
            this.eLt = (Button) this.eLo.findViewById(e.g.add_friend_tip_button);
            this.eLt.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.eLo.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.erf != null) {
            al.c(this.erf, e.d.cp_cont_b, 1);
        }
    }

    private void b(g gVar) {
        if (gVar != null && gVar != null && (gVar instanceof View)) {
            ((View) gVar).setOnClickListener(this.eLu);
        }
    }

    private void aQk() {
        if (this.mTool != null) {
            this.mTool.IS();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.eLo.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aQl();
                return;
            case WAIT:
                it(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                j(z, str);
                return;
            case PASS:
                iu(z);
                return;
            default:
                return;
        }
    }

    private void aQl() {
        this.eLo.setVisibility(8);
        this.eLp.setVisibility(0);
        this.eLs.setVisibility(8);
        this.eLq.setText(e.j.add_friend_title);
        this.eLr.setText(e.j.add_friend_content);
        this.eLt.setText(e.j.add_friend_button);
    }

    private void it(boolean z) {
        if (this.eLn.aQg().aQS() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.eLs.startAnimation(translateAnimation);
                }
            });
            this.eLs.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.eLs.setVisibility(0);
                    PersonalChatView.this.eLs.setAnimation(translateAnimation3);
                }
            });
            this.eLp.setVisibility(8);
            this.eLp.startAnimation(translateAnimation4);
        } else {
            this.eLp.setVisibility(8);
            this.eLs.setVisibility(0);
        }
        this.eLs.setText(e.j.add_friend_wait);
        this.eLt.setText(e.j.add_friend_button);
    }

    private void j(boolean z, final String str) {
        final String name_show = this.eLn.aQg().getUser().getName_show();
        this.eLs.setVisibility(8);
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
                    PersonalChatView.this.eLp.clearAnimation();
                    PersonalChatView.this.eLq.setText(PersonalChatView.this.eLn.getResources().getString(e.j.add_friend_agree_title, name_show));
                    PersonalChatView.this.eLr.setText(str);
                    PersonalChatView.this.eLp.setAnimation(translateAnimation);
                }
            });
            this.eLp.setVisibility(0);
            this.eLp.startAnimation(translateAnimation2);
        } else {
            this.eLp.setVisibility(0);
            this.eLq.setText(this.eLn.getResources().getString(e.j.add_friend_agree_title, name_show));
            this.eLr.setText(str);
        }
        this.eLt.setText(e.j.add_friend_agree_button);
    }

    private void iu(boolean z) {
        aQk();
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
                    PersonalChatView.this.eLo.setVisibility(8);
                }
            });
            this.eLo.startAnimation(translateAnimation);
            return;
        }
        this.eLo.setVisibility(8);
    }

    public Button aQm() {
        return this.eLt;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
