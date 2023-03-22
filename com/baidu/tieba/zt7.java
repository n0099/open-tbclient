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
import android.widget.ImageView;
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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.flowdialog.NotificationType;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.data.UserReplyInfoData;
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
/* loaded from: classes7.dex */
public class zt7 extends y8 implements yt7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int K;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public String D;
    public long E;
    public String F;
    public int G;
    public TBAlertBuilder H;
    public av7 I;
    public bv7 J;
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
    public LinearLayout m;
    public HeadImageView n;
    public ImageView o;
    public TextView p;
    public EMTextView q;
    public View r;
    public BaseMsg s;
    public ChatRoomDetail t;
    public int u;
    public int v;
    public boolean w;
    public FastRequest x;
    public FastRequest y;
    public long z;

    public boolean t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i2, i3)) == null) ? i2 > 1 && i2 > i3 : invokeII.booleanValue;
    }

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zt7 zt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var, Integer.valueOf(i)};
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
            this.a = zt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public b(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.F();
                nx7.b("c15092", String.valueOf(this.a.B), this.a.E, this.a.z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomMessageListener a;

        public c(zt7 zt7Var, CustomMessageListener customMessageListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var, customMessageListener};
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

    /* loaded from: classes7.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-220686996, "Lcom/baidu/tieba/zt7$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-220686996, "Lcom/baidu/tieba/zt7$d;");
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

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public e(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.s != null) {
                if (this.a.s.getMsgType() == 1 || this.a.s.getMsgType() == 101) {
                    String str = null;
                    if (this.a.s instanceof TextMsg) {
                        str = ((TextMsg) this.a.s).getText();
                    } else if (this.a.s instanceof TextGenImageMsg) {
                        str = ((TextGenImageMsg) this.a.s).getText();
                    }
                    if (!StringUtils.isNull(str)) {
                        xh.a(str);
                        qt7.a(this.a.a);
                        BdTopToast bdTopToast = new BdTopToast(this.a.a.getContext());
                        bdTopToast.h(true);
                        bdTopToast.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f087d));
                        bdTopToast.i((ViewGroup) this.a.a.getPageActivity().findViewById(16908290));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public f(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qt7.a(this.a.a);
                this.a.H();
                nx7.b("c15091", String.valueOf(this.a.C), this.a.E, this.a.z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public g(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qt7.a(this.a.a);
                this.a.T();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public h(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.G();
                qt7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public i(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                qt7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public j(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                UserReplyInfoData userReplyInfoData = new UserReplyInfoData();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.a.s.getReplyPrefix());
                spannableStringBuilder.append(this.a.s.getThumbnailText());
                userReplyInfoData.setmContent(spannableStringBuilder);
                userReplyInfoData.setmNameShow(this.a.s.getCommonMsgField().getUserName());
                userReplyInfoData.setmPortrait(this.a.s.getCommonMsgField().getPortrait());
                userReplyInfoData.setmUid(this.a.s.getCommonMsgField().getUserId());
                userReplyInfoData.setRobot(this.a.s.getCommonMsgField().isRobot());
                this.a.I.a(userReplyInfoData, this.a.s);
                qt7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 a;

        public k(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || ListUtils.isEmpty(this.a.t.getLongPressMsgBtn())) {
                return;
            }
            this.a.J.a(this.a.t.getLongPressMsgBtn().get(0), this.a.s);
            qt7.a(this.a.a);
        }
    }

    /* loaded from: classes7.dex */
    public class l extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zt7 b;

        public l(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zt7Var;
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
                bdTopToast.g(this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f0882));
                bdTopToast.i((ViewGroup) this.b.a.getPageActivity().findViewById(16908290));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends FastRequest.b<Void> {
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

        public m(zt7 zt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zt7Var};
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948371564, "Lcom/baidu/tieba/zt7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948371564, "Lcom/baidu/tieba/zt7;");
                return;
            }
        }
        K = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    public void E() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tBAlertBuilder = this.H) != null) {
            tBAlertBuilder.g();
        }
    }

    public void O() {
        ChatRoomDetail chatRoomDetail;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (chatRoomDetail = this.t) != null && chatRoomDetail.getExtraInfo() != null && this.t.getUserInfo() != null) {
            EMTextView eMTextView = this.i;
            if (z()) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            M(true);
            O();
            P(false);
            N(false);
            Q(true);
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zt7(TbPageContext<BaseFragmentActivity> tbPageContext, BaseMsg baseMsg, ChatRoomDetail chatRoomDetail, av7 av7Var, bv7 bv7Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, baseMsg, chatRoomDetail, av7Var, bv7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.s = baseMsg;
        this.t = chatRoomDetail;
        this.I = av7Var;
        this.J = bv7Var;
        y();
        x();
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 64) {
                M(true);
                O();
                P(true);
                N(false);
                Q(false);
            }
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            I();
            R(i2);
        }
    }

    public void M(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EMTextView eMTextView = this.h;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void N(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void P(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void Q(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            EMTextView eMTextView = this.j;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    @Override // com.baidu.tieba.yt7
    public void a(@NonNull NotificationType notificationType) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, notificationType) == null) && d.a[notificationType.ordinal()] == 1) {
            O();
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = Constants.METHOD_IM_FETCH_BUSINESS_SESSION_MSG;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    if (i2 == 64) {
                        M(true);
                        O();
                        P(true);
                        N(false);
                        Q(true);
                        return;
                    }
                    return;
                }
                M(true);
                O();
                P(true);
                N(false);
                Q(false);
                return;
            }
            M(true);
            O();
            P(true);
            N(true);
            Q(true);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.x == null) {
                this.x = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.x;
            fastRequest.S("uid", String.valueOf(this.C));
            fastRequest.S("chatroom_id", String.valueOf(this.z));
            fastRequest.S("op_type", 1);
            fastRequest.S("block_uid", String.valueOf(this.B));
            fastRequest.S("forum_id", String.valueOf(this.E));
            fastRequest.U(new l(this));
            fastRequest.T();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.y == null) {
                this.y = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.y;
            fastRequest.S("msg_type", Integer.valueOf(this.G));
            fastRequest.S("uid_to", String.valueOf(this.B));
            fastRequest.S("chatroom_id", String.valueOf(this.z));
            fastRequest.S("msg_id", String.valueOf(this.A));
            fastRequest.S("msg_key", String.valueOf(this.D));
            fastRequest.S("forum_id", String.valueOf(this.E));
            fastRequest.U(new m(this));
            fastRequest.T();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.t.getExtraInfo() != null && this.t.getUserInfo() != null) {
                if (this.t.getExtraInfo().getIsFreezing() == 1 || this.t.getExtraInfo().getIsTalkBanned() == 1 || this.t.getUserInfo().getIsBeenTalkBanned() == 1) {
                    return false;
                }
                if ((this.t.getExtraInfo().getTalkType() == 1 && this.t.getUserInfo().getIdentityRole() != 3) || t(this.t.getExtraInfo().getTalkThresholdLevel(), this.t.getUserInfo().getForumLevel())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> tbPageContext = this.a;
            urlManager.dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/tpl/wise-bawu-core/report?type=5" + ("&chatroom_msg_id=" + this.A) + ("&chatroom_id=" + this.z)});
        }
    }

    public void I() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n15 d2 = n15.d(this.c);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            n15 d3 = n15.d(this.d);
            d3.o(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.q, R.color.CAM_X0213);
            n15 d4 = n15.d(this.e);
            d4.w(R.color.CAM_X0109);
            d4.A(R.dimen.T_X08);
            d4.B(R.string.F_X01);
            n15 d5 = n15.d(this.f);
            d5.w(R.color.CAM_X0107);
            d5.A(R.dimen.T_X08);
            n15 d6 = n15.d(this.p);
            d6.w(R.color.CAM_X0107);
            d6.A(R.dimen.T_X09);
            SkinManager.setViewTextColorSelector(this.q, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (A()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.g.setHorizontalSpacing(i2);
            S(this.h, R.drawable.obfuscated_res_0x7f08046c);
            S(this.j, R.drawable.obfuscated_res_0x7f080470);
            S(this.k, R.drawable.obfuscated_res_0x7f08046d);
            S(this.l, R.drawable.obfuscated_res_0x7f08046f);
            S(this.i, R.drawable.obfuscated_res_0x7f08046e);
        }
    }

    public void T() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ChatRoomDetail chatRoomDetail = this.t;
            if (chatRoomDetail != null && !StringUtils.isNull(chatRoomDetail.getForbiddenContent())) {
                str = String.format(this.t.getForbiddenContent().replaceAll("\\\\n", "\n"), this.F);
            } else {
                str = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f087f), this.F) + "\n" + TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0880);
            }
            a aVar = new a(this, 2001304);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageActivity());
            this.H = tBAlertBuilder;
            tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f087e);
            this.H.q(str);
            this.H.o(true);
            this.H.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f051b, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f087e, TBAlertConfig.OperateBtnStyle.MAIN, new b(this)));
            this.H.i();
            this.H.j(false);
            this.H.z();
            MessageManager.getInstance().registerListener(aVar);
            this.H.s(new c(this, aVar));
        }
    }

    public final void J(@NonNull AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, abilityItem) == null) && abilityItem.getStyleConf() != null && !StringUtils.isNull(abilityItem.getStyleConf().getContent())) {
            this.p.setText(abilityItem.getStyleConf().getContent());
            this.p.setVisibility(0);
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 64) {
                    M(true);
                    P(true);
                    O();
                    N(false);
                    Q(true);
                    return;
                }
                return;
            }
            M(true);
            P(true);
            O();
            N(true);
            Q(true);
        }
    }

    public final void R(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i2) == null) && !ListUtils.isEmpty(this.t.getLongPressMsgBtn()) && this.t.getLongPressMsgBtn().get(0) != null) {
            AbilityItem abilityItem = this.t.getLongPressMsgBtn().get(0);
            if (abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getDay() != null && abilityItem.getStyleConf().getDay().getIcon() != null && i2 == 0) {
                this.n.M(abilityItem.getStyleConf().getDay().getIcon(), 12, false);
            }
            if (abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getDark() != null && abilityItem.getStyleConf().getDark().getIcon() != null && i2 == 4) {
                this.n.M(abilityItem.getStyleConf().getDark().getIcon(), 12, false);
            }
        }
    }

    public final void S(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048593, this, textView, i2) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = K;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void x() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.s.getCommonMsgField() != null) {
                if (this.s.getCommonMsgField().getUserName() != null) {
                    TextView textView = this.e;
                    textView.setText(this.s.getCommonMsgField().getUserName() + ZeusCrashHandler.NAME_SEPERATOR);
                    this.F = this.s.getCommonMsgField().getUserName();
                }
                if (this.s.getCommonMsgField().getMsgKey() != null) {
                    this.D = this.s.getCommonMsgField().getMsgKey();
                }
                this.v = this.s.getCommonMsgField().getRole();
                if (this.s.getCommonMsgField().getRobotRole() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.w = z;
                this.z = this.s.getCommonMsgField().getRoomId();
                this.A = this.s.getCommonMsgField().getMsgId();
                this.B = this.s.getCommonMsgField().getUserId();
                this.C = TbadkCoreApplication.getCurrentAccountId();
                this.G = this.s.getMsgType();
                if (this.t.getBasicInfo() != null) {
                    this.E = this.t.getBasicInfo().getForumId();
                }
            }
            if (this.t.getUserInfo() != null) {
                this.u = this.t.getUserInfo().getIdentityRole();
            }
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setText(this.s.getThumbnailText());
            if (this.B != this.C) {
                int i2 = this.u;
                int i3 = 64;
                if (i2 == 0) {
                    if (!this.w) {
                        i3 = this.v;
                    }
                    C(i3);
                } else if (i2 != 2 && i2 != 3) {
                    if (i2 == 1) {
                        if (!this.w) {
                            i3 = this.v;
                        }
                        U(i3);
                    }
                } else {
                    if (!this.w) {
                        i3 = this.v;
                    }
                    B(i3);
                }
            } else {
                V();
            }
            BaseMsg baseMsg = this.s;
            if (baseMsg != null && baseMsg.getMsgType() != 1 && this.s.getMsgType() != 101) {
                M(false);
            }
            BaseMsg baseMsg2 = this.s;
            if ((baseMsg2 instanceof TextMsg) && ((TextMsg) baseMsg2).isRobotGuideMsg()) {
                Q(false);
            }
            if (!ListUtils.isEmpty(this.t.getLongPressMsgBtn()) && this.t.getLongPressMsgBtn().get(0) != null) {
                AbilityItem abilityItem = this.t.getLongPressMsgBtn().get(0);
                if (!StringUtils.isNull(abilityItem.getType()) && abilityItem.getType().equals("call_robot")) {
                    J(abilityItem);
                }
            } else {
                this.m.setVisibility(8);
            }
            if (this.w) {
                this.m.setVisibility(8);
            }
            BaseMsg baseMsg3 = this.s;
            if (baseMsg3 != null) {
                if (baseMsg3.getMsgType() == 7009 || this.s.getMsgType() == 7010) {
                    this.m.setVisibility(8);
                }
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d080e, (ViewGroup) null);
            this.b = inflate;
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090e36);
            this.d = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090e2f);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e33);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e32);
            this.g = (FlowLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090e18);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e29);
            this.h = eMTextView;
            eMTextView.setOnClickListener(new e(this));
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e2d);
            this.j = eMTextView2;
            eMTextView2.setOnClickListener(new f(this));
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e2a);
            this.k = eMTextView3;
            eMTextView3.setOnClickListener(new g(this));
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e2c);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(new h(this));
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e16);
            this.q = eMTextView5;
            eMTextView5.setOnClickListener(new i(this));
            EMTextView eMTextView6 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090e2b);
            this.i = eMTextView6;
            eMTextView6.setOnClickListener(new j(this));
            this.m = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091e1a);
            this.n = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091e1e);
            this.o = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091e1d);
            this.p = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091e2c);
            this.n.setIsRound(true);
            this.n.setDrawBorder(false);
            this.n.setPlaceHolder(1);
            this.m.setOnClickListener(new k(this));
            this.r = this.b.findViewById(R.id.obfuscated_res_0x7f090409);
            if (!A()) {
                L();
            }
        }
    }
}
