package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.x.h;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f53207e;

    /* renamed from: f  reason: collision with root package name */
    public PersonalChatActivity f53208f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f53209g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f53210h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f53211i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f53212j;
    public TextView k;
    public Button l;
    public View.OnClickListener m;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f53213e;

        public a(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53213e = personalChatView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53213e.f53208f.showToast(R.string.add_friend_cannot_send);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f53214a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f53215b;

        public b(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53215b = personalChatView;
            this.f53214a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f53215b.k.startAnimation(this.f53214a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation f53216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f53217b;

        public c(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53217b = personalChatView;
            this.f53216a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f53217b.k.setVisibility(0);
                this.f53217b.k.setAnimation(this.f53216a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f53218a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f53219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Animation f53220c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f53221d;

        public d(PersonalChatView personalChatView, String str, String str2, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, str, str2, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53221d = personalChatView;
            this.f53218a = str;
            this.f53219b = str2;
            this.f53220c = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f53221d.f53210h.clearAnimation();
                this.f53221d.f53211i.setText(this.f53221d.f53208f.getResources().getString(R.string.add_friend_agree_title, this.f53218a));
                this.f53221d.f53212j.setText(this.f53219b);
                this.f53221d.f53210h.setAnimation(this.f53220c);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonalChatView f53222a;

        public e(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53222a = personalChatView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f53222a.f53209g.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class f {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f53223a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-958944341, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-958944341, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$f;");
                    return;
                }
            }
            int[] iArr = new int[PersonalMsglistModel.CardStatus.values().length];
            f53223a = iArr;
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f53223a[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f53223a[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f53223a[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalChatView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msglistActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        if (this.f53208f.isFriend() || (editorTools = this.mTool) == null) {
            return;
        }
        i(editorTools.findLauncherById(6));
        i(this.mTool.findLauncherById(2));
    }

    public final void i(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hVar) == null) || hVar == null || hVar == null || !(hVar instanceof View)) {
            return;
        }
        ((View) hVar).setOnClickListener(this.m);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, talkableActivity, z) == null) {
            super.initPersonalHeader(talkableActivity, z);
            this.f53208f = (PersonalChatActivity) talkableActivity;
            String string = talkableActivity.getPageContext().getString(R.string.more);
            if (string != null) {
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.personal_info_btn, talkableActivity);
                this.mBtnGroupInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.group_info_btn_txt);
                this.f53207e = textView;
                textView.setText(string);
            }
            if (this.f53208f.isFriend()) {
                return;
            }
            LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
            this.f53209g = linearLayout;
            this.f53210h = (LinearLayout) linearLayout.findViewById(R.id.add_friend_tip_full);
            this.f53211i = (TextView) this.f53209g.findViewById(R.id.add_friend_tip_title);
            this.f53212j = (TextView) this.f53209g.findViewById(R.id.add_friend_tip_content);
            this.k = (TextView) this.f53209g.findViewById(R.id.add_friend_tip_center);
            Button button = (Button) this.f53209g.findViewById(R.id.add_friend_tip_button);
            this.l = button;
            button.setOnClickListener(talkableActivity);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                return;
            }
            this.f53209g.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public Button j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (Button) invokeV.objValue;
    }

    public final void k() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (editorTools = this.mTool) == null) {
            return;
        }
        editorTools.resetLaunchers();
    }

    public void l(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{cardStatus, Boolean.valueOf(z), strArr}) == null) {
            this.f53209g.setVisibility(0);
            int i2 = f.f53223a[cardStatus.ordinal()];
            if (i2 == 1) {
                n();
            } else if (i2 == 2) {
                p(z);
            } else if (i2 == 3) {
                m(z, (strArr == null || strArr.length <= 0) ? "" : strArr[0]);
            } else if (i2 != 4) {
            } else {
                o(z);
            }
        }
    }

    public final void m(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            String name_show = this.f53208f.getCurrentModel().getUser().getName_show();
            this.k.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new d(this, name_show, str, translateAnimation));
                this.f53210h.setVisibility(0);
                this.f53210h.startAnimation(translateAnimation2);
            } else {
                this.f53210h.setVisibility(0);
                this.f53211i.setText(this.f53208f.getResources().getString(R.string.add_friend_agree_title, name_show));
                this.f53212j.setText(str);
            }
            this.l.setText(R.string.add_friend_agree_button);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f53209g.setVisibility(8);
            this.f53210h.setVisibility(0);
            this.k.setVisibility(8);
            this.f53211i.setText(R.string.add_friend_title);
            this.f53212j.setText(R.string.add_friend_content);
            this.l.setText(R.string.add_friend_button);
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            k();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new e(this));
                this.f53209g.startAnimation(translateAnimation);
                return;
            }
            this.f53209g.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            TextView textView = this.f53207e;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (this.f53208f.getCurrentModel().F() == PersonalMsglistModel.CardStatus.WAIT && z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new b(this, translateAnimation));
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
                translateAnimation4.setAnimationListener(new c(this, translateAnimation3));
                this.f53210h.setVisibility(8);
                this.f53210h.startAnimation(translateAnimation4);
            } else {
                this.f53210h.setVisibility(8);
                this.k.setVisibility(0);
            }
            this.k.setText(R.string.add_friend_wait);
            this.l.setText(R.string.add_friend_button);
        }
    }
}
