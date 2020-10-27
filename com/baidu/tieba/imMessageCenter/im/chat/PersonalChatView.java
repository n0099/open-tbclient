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
/* loaded from: classes22.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private TextView jOY;
    private PersonalChatActivity klj;
    private LinearLayout klk;
    private LinearLayout kll;
    private TextView klm;
    private TextView kln;
    private TextView klo;
    private Button klp;
    private View.OnClickListener klq;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.klq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.klj.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.klj.cTg() && this.mTool != null) {
            b(this.mTool.qX(6));
            b(this.mTool.qX(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.klj = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.jOY = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.jOY.setText(string);
        }
        if (!this.klj.cTg()) {
            this.klk = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kll = (LinearLayout) this.klk.findViewById(R.id.add_friend_tip_full);
            this.klm = (TextView) this.klk.findViewById(R.id.add_friend_tip_title);
            this.kln = (TextView) this.klk.findViewById(R.id.add_friend_tip_content);
            this.klo = (TextView) this.klk.findViewById(R.id.add_friend_tip_center);
            this.klp = (Button) this.klk.findViewById(R.id.add_friend_tip_button);
            this.klp.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.klk.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jOY != null) {
            ap.setViewTextColor(this.jOY, R.color.cp_cont_b, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.klq);
        }
    }

    private void cTj() {
        if (this.mTool != null) {
            this.mTool.bxk();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.klk.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                cTk();
                return;
            case WAIT:
                si(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                u(z, str);
                return;
            case PASS:
                sj(z);
                return;
            default:
                return;
        }
    }

    private void cTk() {
        this.klk.setVisibility(8);
        this.kll.setVisibility(0);
        this.klo.setVisibility(8);
        this.klm.setText(R.string.add_friend_title);
        this.kln.setText(R.string.add_friend_content);
        this.klp.setText(R.string.add_friend_button);
    }

    private void si(boolean z) {
        if (this.klj.cTe().cTQ() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.klo.startAnimation(translateAnimation);
                }
            });
            this.klo.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.klo.setVisibility(0);
                    PersonalChatView.this.klo.setAnimation(translateAnimation3);
                }
            });
            this.kll.setVisibility(8);
            this.kll.startAnimation(translateAnimation4);
        } else {
            this.kll.setVisibility(8);
            this.klo.setVisibility(0);
        }
        this.klo.setText(R.string.add_friend_wait);
        this.klp.setText(R.string.add_friend_button);
    }

    private void u(boolean z, final String str) {
        final String name_show = this.klj.cTe().getUser().getName_show();
        this.klo.setVisibility(8);
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
                    PersonalChatView.this.kll.clearAnimation();
                    PersonalChatView.this.klm.setText(PersonalChatView.this.klj.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kln.setText(str);
                    PersonalChatView.this.kll.setAnimation(translateAnimation);
                }
            });
            this.kll.setVisibility(0);
            this.kll.startAnimation(translateAnimation2);
        } else {
            this.kll.setVisibility(0);
            this.klm.setText(this.klj.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kln.setText(str);
        }
        this.klp.setText(R.string.add_friend_agree_button);
    }

    private void sj(boolean z) {
        cTj();
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
                    PersonalChatView.this.klk.setVisibility(8);
                }
            });
            this.klk.startAnimation(translateAnimation);
            return;
        }
        this.klk.setVisibility(8);
    }

    public Button cTl() {
        return this.klp;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
