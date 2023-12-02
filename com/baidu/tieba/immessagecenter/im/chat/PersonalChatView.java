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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GamePlayServiceData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.immessagecenter.im.model.GamePlayCanSendCardModel;
import com.baidu.tieba.immessagecenter.im.model.PersonalMsglistModel;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qoc;
import com.baidu.tieba.tz8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.ww8;
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
public class PersonalChatView extends CommonPersonalMsglistView implements BottomInputLayout.a, GamePlayServiceView.c {
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
    public boolean q;
    public GamePlayCanSendCardModel r;
    public GamePlayCanSendCardModel.a s;
    public boolean t;
    public String u;
    public View.OnClickListener v;

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-19558640, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-19558640, "Lcom/baidu/tieba/immessagecenter/im/chat/PersonalChatView$a;");
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                new BdTopToast(((AbsMsglistView) this.a).mContext).setIcon(false).setContent(SelectorHelper.getResources().getString(R.string.add_friend_cannot_send)).show(this.a.mRootView);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AbsMsglistView.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public c(PersonalChatView personalChatView) {
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
                this.b.i.startAnimation(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Animation.AnimationListener {
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

        public e(PersonalChatView personalChatView, Animation animation) {
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
    public class f implements Animation.AnimationListener {
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

        public f(PersonalChatView personalChatView, String str, String str2, Animation animation) {
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
                this.d.g.setText(this.d.d.getResources().getString(R.string.obfuscated_res_0x7f0f00ee, this.a));
                this.d.h.setText(this.b);
                this.d.f.setAnimation(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Animation.AnimationListener {
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
    public class h implements Comparator<ReportPrivateMsgData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h(PersonalChatView personalChatView) {
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
                if (JavaTypesHelper.toLong(reportPrivateMsgData.getTime(), -1L) >= JavaTypesHelper.toLong(reportPrivateMsgData2.getTime(), -1L)) {
                    return 1;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ww8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public i(PersonalChatView personalChatView) {
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

        @Override // com.baidu.tieba.ww8.a
        public void a(String str, String str2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) && "0".equals(str) && this.a.r != null && this.a.s != null) {
                this.a.r.loadSendCardFromServer(String.valueOf(this.a.d.i3()), this.a.s);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements qoc {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonalChatView a;

        public j(PersonalChatView personalChatView) {
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

        @Override // com.baidu.tieba.qoc
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SEND_POSTCARD_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.a.d.i3()));
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
        this.o = false;
        this.q = false;
        this.t = false;
        this.v = new b(this);
        if (!this.d.R1() && (editorTools = this.mTool) != null) {
            O(editorTools.t(6));
            O(this.mTool.t(2));
        }
    }

    public final void O(qe5 qe5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe5Var) == null) && qe5Var != null && qe5Var != null && (qe5Var instanceof View)) {
            ((View) qe5Var).setOnClickListener(this.v);
        }
    }

    public void U(GamePlayCanSendCardModel gamePlayCanSendCardModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gamePlayCanSendCardModel) == null) {
            this.r = gamePlayCanSendCardModel;
        }
    }

    public void V(GamePlayServiceData gamePlayServiceData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gamePlayServiceData) != null) || gamePlayServiceData == null) {
            return;
        }
        this.o = gamePlayServiceData.isGod();
        this.p = gamePlayServiceData.getGid();
        if (this.o) {
            N();
        }
    }

    public void W(GamePlayCanSendCardModel.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            this.s = aVar;
        }
    }

    public void T(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            this.u = str;
            if (i2 == 1) {
                this.q = true;
            } else {
                this.q = false;
            }
            if (i2 == 1 || i2 == 2) {
                this.t = true;
                N();
            }
        }
    }

    public final void N() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (editorTools = this.mTool) == null) {
            return;
        }
        int indexOfChild = editorTools.indexOfChild(editorTools.a);
        if (this.a == null) {
            this.a = new GamePlayServiceView(this.d);
        }
        if (this.a.getParent() == null) {
            this.mTool.addView(this.a, indexOfChild);
        }
        this.a.e(this.o);
        this.a.g(this.t, new j(this));
        this.a.f(this);
        tz8.b(this.p);
        ViewGroup viewGroup = this.mLayBottom;
        if (viewGroup instanceof BottomInputLayout) {
            ((BottomInputLayout) viewGroup).setOnInputLayoutChangeListener(this);
        }
    }

    public Button P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (Button) invokeV.objValue;
    }

    public ArrayList<ReportPrivateMsgData> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!ListUtils.isEmpty(this.n)) {
                Collections.sort(this.n, new h(this));
            }
            return this.n;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ViewGroup R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRootView;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void S() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (editorTools = this.mTool) != null) {
            editorTools.J();
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isFromReport() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.d.n3();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestory();
            this.s = null;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public ArrayList<ReportPrivateMsgData> selectList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.d.q3();
        }
        return (ArrayList) invokeV.objValue;
    }

    public void X(PersonalMsglistModel.CardStatus cardStatus, boolean z, String... strArr) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{cardStatus, Boolean.valueOf(z), strArr}) == null) {
            this.e.setVisibility(0);
            int i2 = a.a[cardStatus.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            a0(z);
                            return;
                        }
                        return;
                    }
                    if (strArr != null && strArr.length > 0) {
                        str = strArr[0];
                    } else {
                        str = "";
                    }
                    Y(z, str);
                    return;
                }
                b0(z);
                return;
            }
            Z();
        }
    }

    public final void Y(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048587, this, z, str) == null) {
            String name_show = this.d.f3().getUser().getName_show();
            this.i.setVisibility(8);
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new f(this, name_show, str, translateAnimation));
                this.f.setVisibility(0);
                this.f.startAnimation(translateAnimation2);
            } else {
                this.f.setVisibility(0);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f00ee, name_show));
                this.h.setText(str);
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f00ed);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.i.setVisibility(8);
            this.g.setText(R.string.obfuscated_res_0x7f0f00f8);
            this.h.setText(R.string.obfuscated_res_0x7f0f00f5);
            this.j.setText(R.string.obfuscated_res_0x7f0f00ef);
        }
    }

    public final void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            S();
            if (z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new g(this));
                this.e.startAnimation(translateAnimation);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.widget.BottomInputLayout.a
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (!this.o && !this.q) {
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
                N();
            }
        }
    }

    public final void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (this.d.f3().X() == PersonalMsglistModel.CardStatus.WAIT && z) {
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(400L);
                translateAnimation.setFillAfter(true);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, -1.0f);
                translateAnimation2.setDuration(400L);
                translateAnimation2.setFillAfter(true);
                translateAnimation2.setAnimationListener(new d(this, translateAnimation));
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
                translateAnimation4.setAnimationListener(new e(this, translateAnimation3));
                this.f.setVisibility(8);
                this.f.startAnimation(translateAnimation4);
            } else {
                this.f.setVisibility(8);
                this.i.setVisibility(0);
            }
            this.i.setText(R.string.obfuscated_res_0x7f0f00f9);
            this.j.setText(R.string.obfuscated_res_0x7f0f00ef);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.im.chat.GamePlayServiceView.c
    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 == 0) {
                UrlSchemaJumpHelper.jumpGameGodsPage(this.d, "com.baidu.tieba://unidispatch/GameGodsDetailPage?god_id=" + this.p + "&" + BdUniDispatchSchemeController.PARAM_FROM_NATIVE + "=1");
                tz8.a(this.p);
            } else if (i2 == 1) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SEND_POSTCARD_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_id", this.d.i3()));
                if (!this.q) {
                    BdUtilHelper.showToast(((AbsMsglistView) this).mContext, this.u);
                } else if (!StringUtils.isNull(this.d.i3())) {
                    ww8 ww8Var = new ww8();
                    this.d.f3().sendGameTeamMessage(this.d.b0);
                    ww8Var.c(new i(this), this.d.h3().getUserId());
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, talkableActivity, z) == null) {
            super.initPersonalHeader(talkableActivity, z);
            PersonalChatActivity personalChatActivity = (PersonalChatActivity) talkableActivity;
            this.d = personalChatActivity;
            if (personalChatActivity.n3()) {
                string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f04d2);
            } else {
                string = talkableActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0cdf);
            }
            if (this.d.n3()) {
                View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0836, talkableActivity);
                this.mBtnForumInfo = addCustomView;
                TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f090f2f);
                this.b = textView;
                textView.setText(string);
                this.b.setVisibility(0);
            } else {
                View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0836, talkableActivity);
                this.mBtnForumInfo = addCustomView2;
                this.c = (ImageView) addCustomView2.findViewById(R.id.obfuscated_res_0x7f090f2e);
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070421);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimens, dimens);
                layoutParams.rightMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
                this.mBtnForumInfo.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            if (!this.d.R1()) {
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
            if (this.d.n3()) {
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
                if (!this.d.c3()) {
                    KeyboardLayout keyboardLayout = this.mRootView;
                    NoDataViewFactory.d.a aVar = new NoDataViewFactory.d.a();
                    aVar.i(NoDataViewFactory.ImgType.LOCAL);
                    aVar.h(R.drawable.new_pic_emotion_01);
                    aVar.j(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0703da));
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
                    eMTextView2.setText(ListUtils.getCount(this.d.q3()) + "/20");
                    setUpdateListener(new c(this));
                }
                closeNotNotify();
                closeReceiver();
                closeTitleView();
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            super.onChangeSkinType(i2);
            ImageView imageView = this.c;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setTextColor(SkinManager.getColorStateListWithClickAndDisableState(R.color.CAM_X0304, i2));
            }
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                EMManager.from(linearLayout).setBackGroundColor(R.color.CAM_X0201);
            }
            EMTextView eMTextView = this.k;
            if (eMTextView != null) {
                EMManager.from(eMTextView).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X05);
            }
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            GamePlayServiceView gamePlayServiceView = this.a;
            if (gamePlayServiceView != null) {
                gamePlayServiceView.c(getPageContext(), i2);
            }
        }
    }
}
