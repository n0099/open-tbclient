package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    private static /* synthetic */ int[] bZs;
    private PersonalChatActivity bZk;
    private LinearLayout bZl;
    private LinearLayout bZm;
    private TextView bZn;
    private TextView bZo;
    private TextView bZp;
    private Button bZq;
    private View.OnClickListener bZr;
    private TextView mGroupInfoBtnTxt;

    static /* synthetic */ int[] abk() {
        int[] iArr = bZs;
        if (iArr == null) {
            iArr = new int[PersonalMsglistModel.CardStatus.valuesCustom().length];
            try {
                iArr[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            bZs = iArr;
        }
        return iArr;
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        this.bZr = new p(this);
        if (!this.bZk.abf() && this.mTool != null) {
            b(this.mTool.eg(6));
            b(this.mTool.eg(2));
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.bZk = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(n.i.msglist_personInfo);
        if (string != null) {
            this.mBtnGroupInfo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.personal_info_btn, talkableActivity);
            this.mGroupInfoBtnTxt = (TextView) this.mBtnGroupInfo.findViewById(n.f.group_info_btn_txt);
            this.mGroupInfoBtnTxt.setText(string);
        }
        if (!this.bZk.abf()) {
            this.mBtnGroupInfo.setVisibility(8);
            this.bZl = (LinearLayout) ((ViewStub) talkableActivity.findViewById(n.f.stranger_person_add_friend_stub)).inflate();
            this.bZm = (LinearLayout) this.bZl.findViewById(n.f.add_friend_tip_full);
            this.bZn = (TextView) this.bZl.findViewById(n.f.add_friend_tip_title);
            this.bZo = (TextView) this.bZl.findViewById(n.f.add_friend_tip_content);
            this.bZp = (TextView) this.bZl.findViewById(n.f.add_friend_tip_center);
            this.bZq = (Button) this.bZl.findViewById(n.f.add_friend_tip_button);
            this.bZq.setOnClickListener(talkableActivity);
            return;
        }
        this.mBtnGroupInfo.setVisibility(0);
    }

    private void b(com.baidu.tbadk.editortools.r rVar) {
        if (rVar != null && rVar != null && (rVar instanceof View)) {
            ((View) rVar).setOnClickListener(this.bZr);
        }
    }

    private void abh() {
        if (this.mTool != null) {
            this.mTool.BD();
        }
    }

    public void a(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        switch (abk()[cardStatus.ordinal()]) {
            case 1:
                abi();
                return;
            case 2:
                dP(z);
                return;
            case 3:
                String str = "";
                if (strArr != null && strArr.length > 0) {
                    str = strArr[0];
                }
                i(z, str);
                return;
            case 4:
                dQ(z);
                return;
            default:
                return;
        }
    }

    private void abi() {
        this.bZm.setVisibility(0);
        this.bZp.setVisibility(8);
        this.bZn.setText(n.i.add_friend_title);
        this.bZo.setText(n.i.add_friend_content);
        this.bZq.setText(n.i.add_friend_button);
    }

    private void dP(boolean z) {
        if (this.bZk.abc().adc() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new q(this, translateAnimation));
            this.bZp.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new r(this, translateAnimation3));
            this.bZm.setVisibility(8);
            this.bZm.startAnimation(translateAnimation4);
        } else {
            this.bZm.setVisibility(8);
            this.bZp.setVisibility(0);
        }
        this.bZp.setText(n.i.add_friend_wait);
        this.bZq.setText(n.i.add_friend_button);
    }

    private void i(boolean z, String str) {
        String userName = this.bZk.abc().getUser().getUserName();
        this.bZp.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new s(this, userName, str, translateAnimation));
            this.bZm.setVisibility(0);
            this.bZm.startAnimation(translateAnimation2);
        } else {
            this.bZm.setVisibility(0);
            this.bZn.setText(this.bZk.getResources().getString(n.i.add_friend_agree_title, userName));
            this.bZo.setText(str);
        }
        this.bZq.setText(n.i.add_friend_agree_button);
    }

    private void dQ(boolean z) {
        abh();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new t(this));
            this.bZl.startAnimation(translateAnimation);
            return;
        }
        this.bZl.setVisibility(8);
    }

    public Button abj() {
        return this.bZq;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }
}
