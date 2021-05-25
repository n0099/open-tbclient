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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import d.a.m0.w.h;
/* loaded from: classes4.dex */
public class PersonalChatView extends CommonPersonalMsglistView {

    /* renamed from: e  reason: collision with root package name */
    public TextView f17438e;

    /* renamed from: f  reason: collision with root package name */
    public PersonalChatActivity f17439f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f17440g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f17441h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f17442i;
    public TextView j;
    public TextView k;
    public Button l;
    public View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalChatView.this.f17439f.showToast(R.string.add_friend_cannot_send);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f17444a;

        public b(Animation animation) {
            this.f17444a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PersonalChatView.this.k.startAnimation(this.f17444a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f17446a;

        public c(Animation animation) {
            this.f17446a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PersonalChatView.this.k.setVisibility(0);
            PersonalChatView.this.k.setAnimation(this.f17446a);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17448a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f17449b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animation f17450c;

        public d(String str, String str2, Animation animation) {
            this.f17448a = str;
            this.f17449b = str2;
            this.f17450c = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PersonalChatView.this.f17441h.clearAnimation();
            PersonalChatView.this.f17442i.setText(PersonalChatView.this.f17439f.getResources().getString(R.string.add_friend_agree_title, this.f17448a));
            PersonalChatView.this.j.setText(this.f17449b);
            PersonalChatView.this.f17441h.setAnimation(this.f17450c);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Animation.AnimationListener {
        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PersonalChatView.this.f17440g.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class f {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17453a;

        static {
            int[] iArr = new int[PersonalMsglistModel.CardStatus.values().length];
            f17453a = iArr;
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17453a[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17453a[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17453a[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        EditorTools editorTools;
        this.m = new a();
        if (this.f17439f.isFriend() || (editorTools = this.mTool) == null) {
            return;
        }
        k(editorTools.m(6));
        k(this.mTool.m(2));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        this.f17439f = (PersonalChatActivity) talkableActivity;
        String string = talkableActivity.getPageContext().getString(R.string.more);
        if (string != null) {
            View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
            this.mBtnGroupInfo = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.group_info_btn_txt);
            this.f17438e = textView;
            textView.setText(string);
        }
        if (this.f17439f.isFriend()) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
        this.f17440g = linearLayout;
        this.f17441h = (LinearLayout) linearLayout.findViewById(R.id.add_friend_tip_full);
        this.f17442i = (TextView) this.f17440g.findViewById(R.id.add_friend_tip_title);
        this.j = (TextView) this.f17440g.findViewById(R.id.add_friend_tip_content);
        this.k = (TextView) this.f17440g.findViewById(R.id.add_friend_tip_center);
        Button button = (Button) this.f17440g.findViewById(R.id.add_friend_tip_button);
        this.l = button;
        button.setOnClickListener(talkableActivity);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
            return;
        }
        this.f17440g.setVisibility(8);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        return true;
    }

    public final void k(h hVar) {
        if (hVar == null || hVar == null || !(hVar instanceof View)) {
            return;
        }
        ((View) hVar).setOnClickListener(this.m);
    }

    public Button l() {
        return this.l;
    }

    public final void m() {
        EditorTools editorTools = this.mTool;
        if (editorTools != null) {
            editorTools.z();
        }
    }

    public void n(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        this.f17440g.setVisibility(0);
        int i2 = f.f17453a[cardStatus.ordinal()];
        if (i2 == 1) {
            p();
        } else if (i2 == 2) {
            r(z);
        } else if (i2 == 3) {
            o(z, (strArr == null || strArr.length <= 0) ? "" : strArr[0]);
        } else if (i2 != 4) {
        } else {
            q(z);
        }
    }

    public final void o(boolean z, String str) {
        String name_show = this.f17439f.getCurrentModel().getUser().getName_show();
        this.k.setVisibility(8);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new d(name_show, str, translateAnimation));
            this.f17441h.setVisibility(0);
            this.f17441h.startAnimation(translateAnimation2);
        } else {
            this.f17441h.setVisibility(0);
            this.f17442i.setText(this.f17439f.getResources().getString(R.string.add_friend_agree_title, name_show));
            this.j.setText(str);
        }
        this.l.setText(R.string.add_friend_agree_button);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        TextView textView = this.f17438e;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
    }

    public final void p() {
        this.f17440g.setVisibility(8);
        this.f17441h.setVisibility(0);
        this.k.setVisibility(8);
        this.f17442i.setText(R.string.add_friend_title);
        this.j.setText(R.string.add_friend_content);
        this.l.setText(R.string.add_friend_button);
    }

    public final void q(boolean z) {
        m();
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            translateAnimation.setAnimationListener(new e());
            this.f17440g.startAnimation(translateAnimation);
            return;
        }
        this.f17440g.setVisibility(8);
    }

    public final void r(boolean z) {
        if (this.f17439f.getCurrentModel().B() == PersonalMsglistModel.CardStatus.WAIT && z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(true);
            TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation2.setDuration(400L);
            translateAnimation2.setFillAfter(true);
            translateAnimation2.setAnimationListener(new b(translateAnimation));
            this.k.startAnimation(translateAnimation2);
            return;
        }
        if (z) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
            translateAnimation3.setDuration(400L);
            translateAnimation3.setFillAfter(true);
            TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
            translateAnimation4.setDuration(400L);
            translateAnimation4.setFillAfter(true);
            translateAnimation4.setAnimationListener(new c(translateAnimation3));
            this.f17441h.setVisibility(8);
            this.f17441h.startAnimation(translateAnimation4);
        } else {
            this.f17441h.setVisibility(8);
            this.k.setVisibility(0);
        }
        this.k.setText(R.string.add_friend_wait);
        this.l.setText(R.string.add_friend_button);
    }
}
