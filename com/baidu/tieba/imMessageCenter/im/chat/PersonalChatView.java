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
    private PersonalChatActivity kFl;
    private LinearLayout kFm;
    private LinearLayout kFn;
    private TextView kFo;
    private TextView kFp;
    private TextView kFq;
    private Button kFr;
    private View.OnClickListener kFs;
    private TextView kjk;

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.kFs = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.chat.PersonalChatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonalChatView.this.kFl.showToast(R.string.add_friend_cannot_send);
            }
        };
        if (!this.kFl.daz() && this.mTool != null) {
            b(this.mTool.sg(6));
            b(this.mTool.sg(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.kFl = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.kjk = (TextView) this.mBtnGroupInfo.findViewById(R.id.group_info_btn_txt);
            this.kjk.setText(string);
        }
        if (!this.kFl.daz()) {
            this.kFm = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.kFn = (LinearLayout) this.kFm.findViewById(R.id.add_friend_tip_full);
            this.kFo = (TextView) this.kFm.findViewById(R.id.add_friend_tip_title);
            this.kFp = (TextView) this.kFm.findViewById(R.id.add_friend_tip_content);
            this.kFq = (TextView) this.kFm.findViewById(R.id.add_friend_tip_center);
            this.kFr = (Button) this.kFm.findViewById(R.id.add_friend_tip_button);
            this.kFr.setOnClickListener(talkableActivity);
            if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                this.kFm.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kjk != null) {
            ap.setViewTextColor(this.kjk, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    private void b(h hVar) {
        if (hVar != null && hVar != null && (hVar instanceof View)) {
            ((View) hVar).setOnClickListener(this.kFs);
        }
    }

    private void daC() {
        if (this.mTool != null) {
            this.mTool.bCz();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.kFm.setVisibility(0);
        switch (cardStatus) {
            case APPLY:
                daD();
                return;
            case WAIT:
                sW(z);
                return;
            case AGREE:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                v(z, str);
                return;
            case PASS:
                sX(z);
                return;
            default:
                return;
        }
    }

    private void daD() {
        this.kFm.setVisibility(8);
        this.kFn.setVisibility(0);
        this.kFq.setVisibility(8);
        this.kFo.setText(R.string.add_friend_title);
        this.kFp.setText(R.string.add_friend_content);
        this.kFr.setText(R.string.add_friend_button);
    }

    private void sW(boolean z) {
        if (this.kFl.dax().dbj() == PersonalMsglistModel.CardStatus.WAIT && z) {
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
                    PersonalChatView.this.kFq.startAnimation(translateAnimation);
                }
            });
            this.kFq.startAnimation(translateAnimation2);
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
                    PersonalChatView.this.kFq.setVisibility(0);
                    PersonalChatView.this.kFq.setAnimation(translateAnimation3);
                }
            });
            this.kFn.setVisibility(8);
            this.kFn.startAnimation(translateAnimation4);
        } else {
            this.kFn.setVisibility(8);
            this.kFq.setVisibility(0);
        }
        this.kFq.setText(R.string.add_friend_wait);
        this.kFr.setText(R.string.add_friend_button);
    }

    private void v(boolean z, final String str) {
        final String name_show = this.kFl.dax().getUser().getName_show();
        this.kFq.setVisibility(8);
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
                    PersonalChatView.this.kFn.clearAnimation();
                    PersonalChatView.this.kFo.setText(PersonalChatView.this.kFl.getResources().getString(R.string.add_friend_agree_title, name_show));
                    PersonalChatView.this.kFp.setText(str);
                    PersonalChatView.this.kFn.setAnimation(translateAnimation);
                }
            });
            this.kFn.setVisibility(0);
            this.kFn.startAnimation(translateAnimation2);
        } else {
            this.kFn.setVisibility(0);
            this.kFo.setText(this.kFl.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.kFp.setText(str);
        }
        this.kFr.setText(R.string.add_friend_agree_button);
    }

    private void sX(boolean z) {
        daC();
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
                    PersonalChatView.this.kFm.setVisibility(8);
                }
            });
            this.kFm.startAnimation(translateAnimation);
            return;
        }
        this.kFm.setVisibility(8);
    }

    public Button daE() {
        return this.kFr;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
