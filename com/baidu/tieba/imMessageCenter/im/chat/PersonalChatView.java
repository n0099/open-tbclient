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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes2.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private PersonalChatActivity ePs;
    private LinearLayout ePt;
    private LinearLayout ePu;
    private TextView ePv;
    private TextView ePw;
    private TextView ePx;
    private Button ePy;
    private View.OnClickListener ePz;
    private TextView evg;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.ePz = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.ePs.showToast(d.j.add_friend_cannot_send);
            }
        };
        if (!this.ePs.aMx() && this.mTool != null) {
            b(this.mTool.hG(6));
            b(this.mTool.hG(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.ePs = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(d.j.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.personal_info_btn, talkableActivity);
            this.evg = (TextView) this.mBtnGroupInfo.findViewById(d.g.group_info_btn_txt);
            this.evg.setText(string);
        }
        if (!this.ePs.aMx()) {
            this.ePt = (LinearLayout) ((ViewStub) talkableActivity.findViewById(d.g.stranger_person_add_friend_stub)).inflate();
            this.ePu = (LinearLayout) this.ePt.findViewById(d.g.add_friend_tip_full);
            this.ePv = (TextView) this.ePt.findViewById(d.g.add_friend_tip_title);
            this.ePw = (TextView) this.ePt.findViewById(d.g.add_friend_tip_content);
            this.ePx = (TextView) this.ePt.findViewById(d.g.add_friend_tip_center);
            this.ePy = (Button) this.ePt.findViewById(d.g.add_friend_tip_button);
            this.ePy.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.ePt.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.evg != null) {
            aj.e(this.evg, d.C0140d.cp_cont_b, 1);
        }
    }

    private void b(l lVar) {
        if (lVar != null && lVar != null && (lVar instanceof View)) {
            ((View) lVar).setOnClickListener(this.ePz);
        }
    }

    private void aMz() {
        if (this.mTool != null) {
            this.mTool.Ll();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.ePt.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                aMA();
                return;
            case WAIT:
                hW(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                h(z, str);
                return;
            case PASS:
                hX(z);
                return;
            default:
                return;
        }
    }

    private void aMA() {
        this.ePt.setVisibility(8);
        this.ePu.setVisibility(0);
        this.ePx.setVisibility(8);
        this.ePv.setText(d.j.add_friend_title);
        this.ePw.setText(d.j.add_friend_content);
        this.ePy.setText(d.j.add_friend_button);
    }

    private void hW(boolean z) {
        if (this.ePs.aMv().aNm() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.ePx.startAnimation(translateAnimation);
                }
            });
            this.ePx.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.ePx.setVisibility(0);
                    PersonalChatView.this.ePx.setAnimation(translateAnimation3);
                }
            });
            this.ePu.setVisibility(8);
            this.ePu.startAnimation(translateAnimation4);
        } else {
            this.ePu.setVisibility(8);
            this.ePx.setVisibility(0);
        }
        this.ePx.setText(d.j.add_friend_wait);
        this.ePy.setText(d.j.add_friend_button);
    }

    private void h(boolean z, final String str) {
        final String userName = this.ePs.aMv().getUser().getUserName();
        this.ePx.setVisibility(8);
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
                    PersonalChatView.this.ePu.clearAnimation();
                    PersonalChatView.this.ePv.setText(PersonalChatView.this.ePs.getResources().getString(d.j.add_friend_agree_title, userName));
                    PersonalChatView.this.ePw.setText(str);
                    PersonalChatView.this.ePu.setAnimation(translateAnimation);
                }
            });
            this.ePu.setVisibility(0);
            this.ePu.startAnimation(translateAnimation2);
        } else {
            this.ePu.setVisibility(0);
            this.ePv.setText(this.ePs.getResources().getString(d.j.add_friend_agree_title, userName));
            this.ePw.setText(str);
        }
        this.ePy.setText(d.j.add_friend_agree_button);
    }

    private void hX(boolean z) {
        aMz();
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
                    PersonalChatView.this.ePt.setVisibility(8);
                }
            });
            this.ePt.startAnimation(translateAnimation);
            return;
        }
        this.ePt.setVisibility(8);
    }

    public Button aMB() {
        return this.ePy;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
