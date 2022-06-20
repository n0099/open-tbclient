package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fr4;
import com.repackage.ng;
import com.repackage.o05;
import com.repackage.pi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class PersonalChatView extends CommonPersonalMsglistView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public PersonalChatActivity c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public Button i;
    public EMTextView j;
    public LinearLayout k;
    public NoDataView l;
    public ArrayList<ReportPrivateMsgData> m;
    public View.OnClickListener n;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public a(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                BdTopToast bdTopToast = new BdTopToast(((AbsMsglistView) this.a).mContext);
                bdTopToast.i(false);
                bdTopToast.h(SelectorHelper.getResources().getString(R.string.obfuscated_res_0x7f0f00bf));
                bdTopToast.j(this.a.mRootView);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AbsMsglistView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public b(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.i
        public void a(ArrayList<ReportPrivateMsgData> arrayList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, arrayList, z) == null) {
                this.a.m = arrayList;
                EMTextView eMTextView = this.a.j;
                eMTextView.setText(ListUtils.getCount(arrayList) + "/20");
                if (this.a.mBtnGroupInfo == null || !z) {
                    return;
                }
                this.a.mBtnGroupInfo.setEnabled(true);
                if (this.a.b != null) {
                    this.a.b.setEnabled(true);
                }
                if (this.a.a != null) {
                    this.a.a.setEnabled(true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ PersonalChatView b;

        public c(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatView;
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.h.startAnimation(this.a);
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

    /* loaded from: classes3.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ PersonalChatView b;

        public d(PersonalChatView personalChatView, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personalChatView;
            this.a = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.b.h.setVisibility(0);
                this.b.h.setAnimation(this.a);
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

    /* loaded from: classes3.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Animation c;
        public final /* synthetic */ PersonalChatView d;

        public e(PersonalChatView personalChatView, String str, String str2, Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView, str, str2, animation};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = personalChatView;
            this.a = str;
            this.b = str2;
            this.c = animation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.d.e.clearAnimation();
                this.d.f.setText(this.d.c.getResources().getString(R.string.obfuscated_res_0x7f0f00bd, this.a));
                this.d.g.setText(this.b);
                this.d.e.setAnimation(this.c);
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

    /* loaded from: classes3.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public f(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personalChatView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.d.setVisibility(8);
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

    /* loaded from: classes3.dex */
    public class g implements Comparator<ReportPrivateMsgData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public g(PersonalChatView personalChatView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personalChatView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ReportPrivateMsgData reportPrivateMsgData, ReportPrivateMsgData reportPrivateMsgData2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, reportPrivateMsgData, reportPrivateMsgData2)) == null) ? ng.g(reportPrivateMsgData.getTime(), -1L) >= ng.g(reportPrivateMsgData2.getTime(), -1L) ? 1 : -1 : invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-958944279, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-958944279, "Lcom/baidu/tieba/imMessageCenter/im/chat/PersonalChatView$h;");
                    return;
                }
            }
            int[] iArr = new int[PersonalMsglistModel.CardStatus.values().length];
            a = iArr;
            try {
                iArr[PersonalMsglistModel.CardStatus.APPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.WAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.AGREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PersonalMsglistModel.CardStatus.PASS.ordinal()] = 4;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((MsglistActivity) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        if (this.c.b1() || (editorTools = this.mTool) == null) {
            return;
        }
        v(editorTools.m(6));
        v(this.mTool.m(2));
    }

    public void A(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{cardStatus, Boolean.valueOf(z), strArr}) == null) {
            this.d.setVisibility(0);
            int i = h.a[cardStatus.ordinal()];
            if (i == 1) {
                C();
            } else if (i == 2) {
                E(z);
            } else if (i == 3) {
                B(z, (strArr == null || strArr.length <= 0) ? "" : strArr[0]);
            } else if (i != 4) {
            } else {
                D(z);
            }
        }
    }

    public final void B(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str) == null) {
            String name_show = this.c.Z1().getUser().getName_show();
            this.h.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new e(this, name_show, str, translateAnimation));
                this.e.setVisibility(0);
                this.e.startAnimation(translateAnimation2);
            } else {
                this.e.setVisibility(0);
                this.f.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f00bd, name_show));
                this.g.setText(str);
            }
            this.i.setText(R.string.obfuscated_res_0x7f0f00bc);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.h.setVisibility(8);
            this.f.setText(R.string.obfuscated_res_0x7f0f00c7);
            this.g.setText(R.string.obfuscated_res_0x7f0f00c4);
            this.i.setText(R.string.obfuscated_res_0x7f0f00be);
        }
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            z();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new f(this));
                this.d.startAnimation(translateAnimation);
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public final void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            if (this.c.Z1().I() == PersonalMsglistModel.CardStatus.WAIT && z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new c(this, translateAnimation));
                this.h.startAnimation(translateAnimation2);
                return;
            }
            if (z) {
                TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation3.setDuration(400L);
                translateAnimation3.setFillAfter(true);
                TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation4.setDuration(400L);
                translateAnimation4.setFillAfter(true);
                translateAnimation4.setAnimationListener(new d(this, translateAnimation3));
                this.e.setVisibility(8);
                this.e.startAnimation(translateAnimation4);
            } else {
                this.e.setVisibility(8);
                this.h.setVisibility(0);
            }
            this.h.setText(R.string.obfuscated_res_0x7f0f00c8);
            this.i.setText(R.string.obfuscated_res_0x7f0f00be);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, talkableActivity, z) == null) {
            super.initPersonalHeader(talkableActivity, z);
            PersonalChatActivity personalChatActivity = (PersonalChatActivity) talkableActivity;
            this.c = personalChatActivity;
            String string = personalChatActivity.d2() ? talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f041f) : talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ae3);
            if (this.c.d2()) {
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06c9, talkableActivity);
                this.mBtnGroupInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090c9e);
                this.a = textView;
                textView.setText(string);
                this.a.setVisibility(0);
            } else {
                View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d06c9, talkableActivity);
                this.mBtnGroupInfo = addCustomView2;
                this.b = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f090c9d);
                int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070309);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f2, f2);
                layoutParams.rightMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
                this.mBtnGroupInfo.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (!this.c.b1()) {
                LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091d9c)).inflate();
                this.d = linearLayout;
                this.e = (LinearLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09010c);
                this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09010d);
                this.g = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09010b);
                this.h = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09010a);
                Button button = (Button) this.d.findViewById(R.id.obfuscated_res_0x7f090109);
                this.i = button;
                button.setOnClickListener(talkableActivity);
                if (!TbadkCoreApplication.getInst().appResponseToIntentClass(AddressListActivityConfig.class)) {
                    this.d.setVisibility(8);
                }
            }
            if (this.c.d2()) {
                if (this.mBtnGroupInfo != null) {
                    TextView textView2 = this.a;
                    if (textView2 != null) {
                        textView2.setEnabled(false);
                    }
                    ImageView imageView = this.b;
                    if (imageView != null) {
                        imageView.setEnabled(false);
                    }
                    this.mBtnGroupInfo.setEnabled(false);
                }
                this.mNavigationBar.setCenterTextTitle(getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0efe));
                if (!this.c.W1()) {
                    KeyboardLayout keyboardLayout = this.mRootView;
                    NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                    aVar.i(NoDataViewFactory.ImgType.LOCAL);
                    aVar.h(R.drawable.new_pic_emotion_01);
                    aVar.j(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0702c2));
                    NoDataView a2 = NoDataViewFactory.a(talkableActivity, keyboardLayout, aVar.f(), NoDataViewFactory.e.d(null, talkableActivity.getString(R.string.obfuscated_res_0x7f0f0c50)), null);
                    this.l = a2;
                    a2.setVisibility(0);
                    this.l.f(talkableActivity.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.obfuscated_res_0x7f091789)).inflate();
                    this.k = linearLayout2;
                    linearLayout2.setVisibility(0);
                    EMTextView eMTextView = (EMTextView) this.k.findViewById(R.id.obfuscated_res_0x7f091c60);
                    this.j = eMTextView;
                    eMTextView.setVisibility(0);
                    EMTextView eMTextView2 = this.j;
                    eMTextView2.setText(ListUtils.getCount(this.c.f2()) + "/20");
                    setUpdateListener(new b(this));
                }
                closeNotNotify();
                closeReceiver();
                closeTitleView();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isFromReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c.d2() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            super.onChangeSkinType(i);
            ImageView imageView = this.b;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f0809d2, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.a;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i));
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            LinearLayout linearLayout = this.k;
            if (linearLayout != null) {
                fr4.d(linearLayout).f(R.color.CAM_X0201);
            }
            EMTextView eMTextView = this.j;
            if (eMTextView != null) {
                fr4 d2 = fr4.d(eMTextView);
                d2.v(R.color.CAM_X0107);
                d2.z(R.dimen.T_X05);
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c.f2() : (ArrayList) invokeV.objValue;
    }

    public final void v(o05 o05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, o05Var) == null) || o05Var == null || o05Var == null || !(o05Var instanceof View)) {
            return;
        }
        ((View) o05Var).setOnClickListener(this.n);
    }

    public Button w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.i : (Button) invokeV.objValue;
    }

    public ArrayList<ReportPrivateMsgData> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (!ListUtils.isEmpty(this.m)) {
                Collections.sort(this.m, new g(this));
            }
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ViewGroup y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRootView : (ViewGroup) invokeV.objValue;
    }

    public final void z() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (editorTools = this.mTool) == null) {
            return;
        }
        editorTools.z();
    }
}
