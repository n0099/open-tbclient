package com.baidu.tieba;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.NotificationType;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputTool.robotfloor.data.UserReplyInfoData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes6.dex */
public class wp7 extends v9 implements vp7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int F;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public String B;
    public int C;
    public TBAlertBuilder D;
    public hq7 E;
    public TbPageContext<BaseFragmentActivity> a;
    public View b;
    public LinearLayout c;
    public LinearLayout d;
    public TextView e;
    public TextView f;
    public FlowLayout g;
    public EMTextView h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public View n;
    public BaseMsg o;
    public ChatRoomDetail p;
    public int q;
    public int r;
    public boolean s;
    public FastRequest t;
    public FastRequest u;
    public long v;
    public long w;
    public long x;
    public long y;
    public String z;

    public boolean r(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048591, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public a(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.A();
                pr7.b("c15092", String.valueOf(this.a.x), this.a.A, this.a.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomMessageListener a;

        public b(wp7 wp7Var, CustomMessageListener customMessageListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var, customMessageListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = customMessageListener;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().unRegisterListener(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-310268564, "Lcom/baidu/tieba/wp7$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-310268564, "Lcom/baidu/tieba/wp7$c;");
                    return;
                }
            }
            int[] iArr = new int[NotificationType.values().length];
            a = iArr;
            try {
                iArr[NotificationType.TYPE_REPLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public d(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.o != null) {
                if (this.a.o.getMsgType() == 1 || this.a.o.getMsgType() == 101) {
                    String str = null;
                    if (this.a.o instanceof TextMsg) {
                        str = ((TextMsg) this.a.o).getText();
                    } else if (this.a.o instanceof TextGenImageMsg) {
                        str = ((TextGenImageMsg) this.a.o).getText();
                    }
                    if (!StringUtils.isNull(str)) {
                        ui.a(str);
                        np7.a(this.a.a);
                        BdTopToast bdTopToast = new BdTopToast(this.a.a.getContext());
                        bdTopToast.h(true);
                        bdTopToast.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0874));
                        bdTopToast.i((ViewGroup) this.a.a.getPageActivity().findViewById(16908290));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public e(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                np7.a(this.a.a);
                this.a.C();
                pr7.b("c15091", String.valueOf(this.a.y), this.a.A, this.a.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public f(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                np7.a(this.a.a);
                this.a.M();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public g(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.B();
                np7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public h(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                np7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        public i(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.a.o.getReplyPrefix());
                spannableStringBuilder.append(this.a.o.getThumbnailText());
                userReplyInfoData.setmContent(spannableStringBuilder);
                userReplyInfoData.setmNameShow(this.a.o.getCommonMsgField().getUserName());
                userReplyInfoData.setmPortrait(this.a.o.getCommonMsgField().getPortrait());
                userReplyInfoData.setmUid(this.a.o.getCommonMsgField().getUserId());
                userReplyInfoData.setRobot(this.a.o.getCommonMsgField().isRobot());
                this.a.E.a(userReplyInfoData);
                np7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 b;

        public j(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
                BdTopToast bdTopToast = new BdTopToast(this.b.a.getContext());
                bdTopToast.h(true);
                bdTopToast.g(this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f0879));
                bdTopToast.i((ViewGroup) this.b.a.getPageActivity().findViewById(16908290));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(@NonNull Void r5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, r5) == null) {
            }
        }

        public k(wp7 wp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var};
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
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, @NonNull String str, @Nullable Void r7) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, r7) == null) {
                super.b(i, str, r7);
                BdLog.d("error: " + i + " " + str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(wp7 wp7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wp7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.z();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948278347, "Lcom/baidu/tieba/wp7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948278347, "Lcom/baidu/tieba/wp7;");
                return;
            }
        }
        F = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    public void H() {
        ChatRoomDetail chatRoomDetail;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (chatRoomDetail = this.p) != null && chatRoomDetail.getExtraInfo() != null && this.p.getUserInfo() != null) {
            EMTextView eMTextView = this.i;
            if (v()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            F(true);
            H();
            J(false);
            G(false);
            K(true);
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void z() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (tBAlertBuilder = this.D) != null) {
            tBAlertBuilder.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wp7(TbPageContext<BaseFragmentActivity> tbPageContext, BaseMsg baseMsg, ChatRoomDetail chatRoomDetail, hq7 hq7Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, baseMsg, chatRoomDetail, hq7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((x9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.o = baseMsg;
        this.p = chatRoomDetail;
        this.E = hq7Var;
        u();
        t();
    }

    public void F(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            EMTextView eMTextView = this.h;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void G(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void J(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void K(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            EMTextView eMTextView = this.j;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.vp7
    public void a(@NonNull NotificationType notificationType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, notificationType) == null) && c.a[notificationType.ordinal()] == 1) {
            H();
        }
    }

    public void y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 4) {
                F(true);
                H();
                J(true);
                G(false);
                K(false);
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.t == null) {
                this.t = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.t;
            fastRequest.H("uid", String.valueOf(this.y));
            fastRequest.H("chatroom_id", String.valueOf(this.v));
            fastRequest.H("op_type", 1);
            fastRequest.H("block_uid", String.valueOf(this.x));
            fastRequest.H("forum_id", String.valueOf(this.A));
            fastRequest.J(new j(this));
            fastRequest.I();
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> tbPageContext = this.a;
            urlManager.dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/tpl/wise-bawu-core/report?type=5" + ("&chatroom_msg_id=" + this.w) + ("&chatroom_id=" + this.v)});
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.u == null) {
                this.u = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.u;
            fastRequest.H("msg_type", Integer.valueOf(this.C));
            fastRequest.H("uid_to", String.valueOf(this.x));
            fastRequest.H("chatroom_id", String.valueOf(this.v));
            fastRequest.H("msg_id", String.valueOf(this.w));
            fastRequest.H("msg_key", String.valueOf(this.z));
            fastRequest.H("forum_id", String.valueOf(this.A));
            fastRequest.J(new k(this));
            fastRequest.I();
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.p.getExtraInfo() != null && this.p.getUserInfo() != null) {
                if (this.p.getExtraInfo().getIsFreezing() == 1 || this.p.getExtraInfo().getIsTalkBanned() == 1 || this.p.getUserInfo().getIsBeenTalkBanned() == 1) {
                    return false;
                }
                if ((this.p.getExtraInfo().getTalkType() == 1 && this.p.getUserInfo().getIdentityRole() != 3) || r(this.p.getExtraInfo().getTalkThresholdLevel(), this.p.getUserInfo().getForumLevel())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            p15 d2 = p15.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            p15 d3 = p15.d(this.d);
            d3.n(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0213);
            p15 d4 = p15.d(this.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X08);
            d4.A(R.string.F_X01);
            p15 d5 = p15.d(this.f);
            d5.v(R.color.CAM_X0107);
            d5.z(R.dimen.T_X08);
            SkinManager.setViewTextColorSelector(this.m, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (w()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.g.setHorizontalSpacing(i2);
            L(this.h, R.drawable.obfuscated_res_0x7f080460);
            L(this.j, R.drawable.obfuscated_res_0x7f080464);
            L(this.k, R.drawable.obfuscated_res_0x7f080461);
            L(this.l, R.drawable.obfuscated_res_0x7f080463);
            L(this.i, R.drawable.obfuscated_res_0x7f080462);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07dd, (ViewGroup) null);
            this.b = inflate;
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090dc7);
            this.d = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090dc0);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dc4);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dc3);
            this.g = (FlowLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090da9);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dba);
            this.h = eMTextView;
            eMTextView.setOnClickListener(new d(this));
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dbe);
            this.j = eMTextView2;
            eMTextView2.setOnClickListener(new e(this));
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dbb);
            this.k = eMTextView3;
            eMTextView3.setOnClickListener(new f(this));
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dbd);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(new g(this));
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090da7);
            this.m = eMTextView5;
            eMTextView5.setOnClickListener(new h(this));
            EMTextView eMTextView6 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dbc);
            this.i = eMTextView6;
            eMTextView6.setOnClickListener(new i(this));
            this.n = this.b.findViewById(R.id.obfuscated_res_0x7f0903c5);
            if (!w()) {
                E();
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = Constants.METHOD_IM_FETCH_BUSINESS_SESSION_MSG;
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            if (i2 % 160 != 0 && (i2 * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void L(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048586, this, textView, i2) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = F;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void M() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            x9<T> x9Var = this.mContext;
            if (x9Var != 0) {
                str = String.format(x9Var.getString(R.string.obfuscated_res_0x7f0f0876), this.B) + "\n" + String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0877), new Object[0]);
            } else {
                str = null;
            }
            l lVar = new l(this, 2001304);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageActivity());
            this.D = tBAlertBuilder;
            tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f0875);
            if (!dj.isEmpty(str)) {
                this.D.q(str);
            }
            this.D.o(true);
            this.D.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0518, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0875, TBAlertConfig.OperateBtnStyle.MAIN, new a(this)));
            this.D.i();
            this.D.j(false);
            this.D.z();
            MessageManager.getInstance().registerListener(lVar);
            this.D.s(new b(this, lVar));
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 4) {
                    F(true);
                    J(true);
                    H();
                    G(false);
                    K(true);
                    return;
                }
                return;
            }
            F(true);
            J(true);
            H();
            G(true);
            K(true);
        }
    }

    public void t() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.o.getCommonMsgField() != null) {
                if (this.o.getCommonMsgField().getUserName() != null) {
                    TextView textView = this.e;
                    textView.setText(this.o.getCommonMsgField().getUserName() + ZeusCrashHandler.NAME_SEPERATOR);
                    this.B = this.o.getCommonMsgField().getUserName();
                }
                if (this.o.getCommonMsgField().getMsgKey() != null) {
                    this.z = this.o.getCommonMsgField().getMsgKey();
                }
                this.r = this.o.getCommonMsgField().getRole();
                if (this.o.getCommonMsgField().getRobotRole() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.s = z;
                this.v = this.o.getCommonMsgField().getRoomId();
                this.w = this.o.getCommonMsgField().getMsgId();
                this.x = this.o.getCommonMsgField().getUserId();
                this.y = TbadkCoreApplication.getCurrentAccountId();
                this.C = this.o.getMsgType();
                if (this.p.getBasicInfo() != null) {
                    this.A = this.p.getBasicInfo().getForumId();
                }
            }
            if (this.p.getUserInfo() != null) {
                this.q = this.p.getUserInfo().getIdentityRole();
            }
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setText(this.o.getThumbnailText());
            if (this.x != this.y) {
                int i2 = this.q;
                int i3 = 4;
                if (i2 == 0) {
                    if (!this.s) {
                        i3 = this.r;
                    }
                    y(i3);
                } else if (i2 != 2 && i2 != 3) {
                    if (i2 == 1) {
                        if (!this.s) {
                            i3 = this.r;
                        }
                        N(i3);
                    }
                } else {
                    if (!this.s) {
                        i3 = this.r;
                    }
                    x(i3);
                }
            } else {
                O();
            }
            BaseMsg baseMsg = this.o;
            if (baseMsg != null && baseMsg.getMsgType() != 1 && this.o.getMsgType() != 101) {
                F(false);
            }
            BaseMsg baseMsg2 = this.o;
            if ((baseMsg2 instanceof TextMsg) && ((TextMsg) baseMsg2).isRobotGuideMsg()) {
                K(false);
            }
        }
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    if (i2 == 4) {
                        F(true);
                        H();
                        J(true);
                        G(false);
                        K(true);
                        return;
                    }
                    return;
                }
                F(true);
                H();
                J(true);
                G(false);
                K(false);
                return;
            }
            F(true);
            H();
            J(true);
            G(true);
            K(true);
        }
    }
}
