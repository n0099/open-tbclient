package com.baidu.tieba.immessagecenter.im.chat;

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
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GamePlayServiceData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.widget.BottomInputLayout;
import com.baidu.tbadk.widget.KeyboardLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.immessagecenter.im.chat.GamePlayServiceView;
import com.baidu.tieba.immessagecenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.p45;
import com.baidu.tieba.pg;
import com.baidu.tieba.r58;
import com.baidu.tieba.ri;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class PersonalChatView extends CommonPersonalMsglistView implements BottomInputLayout.a, GamePlayServiceView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GamePlayServiceView a;
    public TextView b;
    public ImageView c;
    public PersonalChatActivity d;
    public LinearLayout e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public TextView i;
    public Button j;
    public EMTextView k;
    public LinearLayout l;
    public NoDataView m;
    public ArrayList<ReportPrivateMsgData> n;
    public boolean o;
    public String p;
    public View.OnClickListener q;

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
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
                bdTopToast.h(false);
                bdTopToast.g(SelectorHelper.getResources().getString(R.string.add_friend_cannot_send));
                bdTopToast.i(this.a.mRootView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AbsMsglistView.j {
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

        @Override // com.baidu.tieba.im.chat.AbsMsglistView.j
        public void a(ArrayList<ReportPrivateMsgData> arrayList, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLZ(1048576, this, arrayList, z) != null) {
                return;
            }
            this.a.n = arrayList;
            EMTextView eMTextView = this.a.k;
            eMTextView.setText(ListUtils.getCount(arrayList) + "/20");
            if (this.a.mBtnForumInfo != null && z) {
                this.a.mBtnForumInfo.setEnabled(true);
                if (this.a.c != null) {
                    this.a.c.setEnabled(true);
                }
                if (this.a.b != null) {
                    this.a.b.setEnabled(true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ PersonalChatView b;

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
                this.b.i.startAnimation(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation a;
        public final /* synthetic */ PersonalChatView b;

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
                this.b.i.setVisibility(0);
                this.b.i.setAnimation(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Animation c;
        public final /* synthetic */ PersonalChatView d;

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
                this.d.f.clearAnimation();
                this.d.g.setText(this.d.d.getResources().getString(R.string.obfuscated_res_0x7f0f00eb, this.a));
                this.d.h.setText(this.b);
                this.d.f.setAnimation(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

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
                this.a.e.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, reportPrivateMsgData, reportPrivateMsgData2)) == null) {
                if (pg.g(reportPrivateMsgData.getTime(), -1L) >= pg.g(reportPrivateMsgData2.getTime(), -1L)) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class h {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19558423, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatView$h;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-19558423, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatView$h;");
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
        this.o = false;
        this.q = new a(this);
        if (!this.d.W1() && (editorTools = this.mTool) != null) {
            M(editorTools.o(6));
            M(this.mTool.o(2));
        }
    }

    public final void M(ze5 ze5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ze5Var) == null) && ze5Var != null && ze5Var != null && (ze5Var instanceof View)) {
            ((View) ze5Var).setOnClickListener(this.q);
        }
    }

    public void R(GamePlayServiceData gamePlayServiceData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, gamePlayServiceData) != null) || gamePlayServiceData == null) {
            return;
        }
        this.o = gamePlayServiceData.isGod();
        this.p = gamePlayServiceData.getGid();
        if (this.o) {
            K();
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EditorTools editorTools = this.mTool;
            if (editorTools != null) {
                int indexOfChild = editorTools.indexOfChild(editorTools.a);
                GamePlayServiceView gamePlayServiceView = new GamePlayServiceView(this.d);
                this.a = gamePlayServiceView;
                this.mTool.addView(gamePlayServiceView, indexOfChild);
                this.a.c(this);
                r58.b(this.p);
            }
            ViewGroup viewGroup = this.mLayBottom;
            if (viewGroup instanceof BottomInputLayout) {
                ((BottomInputLayout) viewGroup).setOnInputLayoutChangeListener(this);
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.i.setVisibility(8);
            this.g.setText(R.string.obfuscated_res_0x7f0f00f5);
            this.h.setText(R.string.obfuscated_res_0x7f0f00f2);
            this.j.setText(R.string.obfuscated_res_0x7f0f00ec);
        }
    }

    public Button N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Button) invokeV.objValue;
    }

    public ArrayList<ReportPrivateMsgData> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!ListUtils.isEmpty(this.n)) {
                Collections.sort(this.n, new g(this));
            }
            return this.n;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ViewGroup P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRootView;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void Q() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (editorTools = this.mTool) != null) {
            editorTools.B();
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isFromReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d.b3();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.d.e3();
        }
        return (ArrayList) invokeV.objValue;
    }

    public void S(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cardStatus, Boolean.valueOf(z), strArr}) == null) {
            this.e.setVisibility(0);
            int i = h.a[cardStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            V(z);
                            return;
                        }
                        return;
                    }
                    if (strArr != null && strArr.length > 0) {
                        str = strArr[0];
                    } else {
                        str = "";
                    }
                    T(z, str);
                    return;
                }
                W(z);
                return;
            }
            U();
        }
    }

    public final void T(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(InputDeviceCompat.SOURCE_TOUCHPAD, this, z, str) == null) {
            String name_show = this.d.W2().getUser().getName_show();
            this.i.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new e(this, name_show, str, translateAnimation));
                this.f.setVisibility(0);
                this.f.startAnimation(translateAnimation2);
            } else {
                this.f.setVisibility(0);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f00eb, name_show));
                this.h.setText(str);
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f00ea);
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            Q();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new f(this));
                this.e.startAnimation(translateAnimation);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.GamePlayServiceView.b
    public void h(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && i == 0) {
            UrlSchemaJumpHelper.jumpGameGodsPage(this.d, "com.baidu.tieba://unidispatch/GameGodsDetailPage?god_id=" + this.p + "&" + BdUniDispatchSchemeController.PARAM_FROM_NATIVE + "=1");
            r58.a(this.p);
        }
    }

    @Override // com.baidu.tbadk.widget.BottomInputLayout.a
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || !this.o) {
            return;
        }
        GamePlayServiceView gamePlayServiceView = this.a;
        if (gamePlayServiceView != null) {
            if (!z) {
                if (gamePlayServiceView.getVisibility() != 8) {
                    this.a.setVisibility(8);
                }
            } else if (gamePlayServiceView.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
        } else if (z) {
            K();
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (this.d.W2().d0() == PersonalMsglistModel.CardStatus.WAIT && z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new c(this, translateAnimation));
                this.i.startAnimation(translateAnimation2);
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
                this.f.setVisibility(8);
                this.f.startAnimation(translateAnimation4);
            } else {
                this.f.setVisibility(8);
                this.i.setVisibility(0);
            }
            this.i.setText(R.string.obfuscated_res_0x7f0f00f6);
            this.j.setText(R.string.obfuscated_res_0x7f0f00ec);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, talkableActivity, z) == null) {
            super.initPersonalHeader(talkableActivity, z);
            PersonalChatActivity personalChatActivity = (PersonalChatActivity) talkableActivity;
            this.d = personalChatActivity;
            if (personalChatActivity.b3()) {
                string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04b2);
            } else {
                string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c43);
            }
            if (this.d.b3()) {
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d07bb, talkableActivity);
                this.mBtnForumInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090e81);
                this.b = textView;
                textView.setText(string);
                this.b.setVisibility(0);
            } else {
                View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d07bb, talkableActivity);
                this.mBtnForumInfo = addCustomView2;
                this.c = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f090e80);
                int g2 = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07040f);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(g2, g2);
                layoutParams.rightMargin = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
                this.mBtnForumInfo.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (!this.d.W1()) {
                LinearLayout linearLayout = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.stranger_person_add_friend_stub)).inflate();
                this.e = linearLayout;
                this.f = (LinearLayout) linearLayout.findViewById(R.id.add_friend_tip_full);
                this.g = (TextView) this.e.findViewById(R.id.add_friend_tip_title);
                this.h = (TextView) this.e.findViewById(R.id.add_friend_tip_content);
                this.i = (TextView) this.e.findViewById(R.id.add_friend_tip_center);
                Button button = (Button) this.e.findViewById(R.id.add_friend_tip_button);
                this.j = button;
                button.setOnClickListener(talkableActivity);
                this.e.setVisibility(8);
            }
            if (this.d.b3()) {
                if (this.mBtnForumInfo != null) {
                    TextView textView2 = this.b;
                    if (textView2 != null) {
                        textView2.setEnabled(false);
                    }
                    ImageView imageView = this.c;
                    if (imageView != null) {
                        imageView.setEnabled(false);
                    }
                    this.mBtnForumInfo.setEnabled(false);
                }
                this.mNavigationBar.setCenterTextTitle(getPageContext().getResources().getString(R.string.private_message_report_name));
                if (!this.d.T2()) {
                    KeyboardLayout keyboardLayout = this.mRootView;
                    NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                    aVar.i(NoDataViewFactory.ImgType.LOCAL);
                    aVar.h(R.drawable.new_pic_emotion_01);
                    aVar.j(ri.g(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703c8));
                    NoDataView a2 = NoDataViewFactory.a(talkableActivity, keyboardLayout, aVar.f(), NoDataViewFactory.e.d(null, talkableActivity.getString(R.string.no_data_common_txt)), null);
                    this.m = a2;
                    a2.setVisibility(0);
                    this.m.f(talkableActivity.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) ((ViewStub) talkableActivity.findViewById(R.id.person_chat_select)).inflate();
                    this.l = linearLayout2;
                    linearLayout2.setVisibility(0);
                    EMTextView eMTextView = (EMTextView) this.l.findViewById(R.id.select_number);
                    this.k = eMTextView;
                    eMTextView.setVisibility(0);
                    EMTextView eMTextView2 = this.k;
                    eMTextView2.setText(ListUtils.getCount(this.d.e3()) + "/20");
                    setUpdateListener(new b(this));
                }
                closeNotNotify();
                closeReceiver();
                closeTitleView();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i));
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                p45.d(linearLayout).f(R.color.CAM_X0201);
            }
            EMTextView eMTextView = this.k;
            if (eMTextView != null) {
                p45 d2 = p45.d(eMTextView);
                d2.w(R.color.CAM_X0107);
                d2.B(R.dimen.T_X05);
            }
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i);
            }
        }
    }
}
