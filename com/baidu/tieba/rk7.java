package com.baidu.tieba;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
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
public class rk7 extends q9 {
    public static /* synthetic */ Interceptable $ic;
    public static final int C;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public TBAlertBuilder B;
    public TbPageContext<BaseFragmentActivity> a;
    public View b;
    public LinearLayout c;
    public LinearLayout d;
    public TextView e;
    public TbRichTextView f;
    public FlowLayout g;
    public EMTextView h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public View m;
    public BaseMsg n;
    public ChatRoomDetail o;
    public int p;
    public int q;
    public boolean r;
    public FastRequest s;
    public FastRequest t;
    public long u;
    public long v;
    public long w;
    public long x;
    public String y;
    public long z;

    /* loaded from: classes6.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CustomMessageListener a;

        public a(rk7 rk7Var, CustomMessageListener customMessageListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var, customMessageListener};
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
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public b(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.n != null) {
                if (this.a.n.getMsgType() == 1 || this.a.n.getMsgType() == 101) {
                    String str = null;
                    if (this.a.n instanceof TextMsg) {
                        str = ((TextMsg) this.a.n).getText();
                    } else if (this.a.n instanceof TextGenImageMsg) {
                        str = ((TextGenImageMsg) this.a.n).getText();
                    }
                    if (!StringUtils.isNull(str)) {
                        pi.a(str);
                        jk7.a(this.a.a);
                        BdTopToast bdTopToast = new BdTopToast(this.a.a.getContext());
                        bdTopToast.h(true);
                        bdTopToast.g(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0849));
                        bdTopToast.i((ViewGroup) this.a.a.getPageActivity().findViewById(16908290));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public c(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jk7.a(this.a.a);
                this.a.y();
                TiebaStatic.log(new StatisticItem("c15091").param("uid", this.a.x).param("fid", this.a.z).param("room_id", this.a.u));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public d(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jk7.a(this.a.a);
                this.a.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public e(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x();
                jk7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public f(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jk7.a(this.a.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends FastRequest.b<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 b;

        public g(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rk7Var;
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
                bdTopToast.g(this.b.a.getResources().getString(R.string.obfuscated_res_0x7f0f084e));
                bdTopToast.i((ViewGroup) this.b.a.getPageActivity().findViewById(16908290));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends FastRequest.b<Void> {
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

        public h(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
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
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(rk7 rk7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var, Integer.valueOf(i)};
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
            this.a = rk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk7 a;

        public j(rk7 rk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.w();
                TiebaStatic.log(new StatisticItem("c15092").param("uid", this.a.w).param("fid", this.a.z).param("room_id", this.a.u));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948124587, "Lcom/baidu/tieba/rk7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948124587, "Lcom/baidu/tieba/rk7;");
                return;
            }
        }
        C = zi.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            B(true);
            D(false);
            C(false);
            E(false);
        }
    }

    public View p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void v() {
        TBAlertBuilder tBAlertBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (tBAlertBuilder = this.B) != null) {
            tBAlertBuilder.g();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk7(TbPageContext<BaseFragmentActivity> tbPageContext, BaseMsg baseMsg, ChatRoomDetail chatRoomDetail) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, baseMsg, chatRoomDetail};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((s9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.n = baseMsg;
        this.o = chatRoomDetail;
        r();
        q();
    }

    public void B(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            EMTextView eMTextView = this.h;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void C(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            EMTextView eMTextView = this.j;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void D(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            EMTextView eMTextView = this.k;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void E(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            EMTextView eMTextView = this.i;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            eMTextView.setVisibility(i2);
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 4) {
                B(true);
                D(true);
                C(false);
                E(false);
            }
        }
    }

    public final void F(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048581, this, textView, i2) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = C;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void G() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s9<T> s9Var = this.mContext;
            if (s9Var != 0) {
                str = String.format(s9Var.getString(R.string.obfuscated_res_0x7f0f084b), this.A) + "\n" + String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f084c), new Object[0]);
            } else {
                str = null;
            }
            i iVar = new i(this, 2001304);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.getPageActivity());
            this.B = tBAlertBuilder;
            tBAlertBuilder.w(R.string.obfuscated_res_0x7f0f084a);
            if (!yi.isEmpty(str)) {
                this.B.q(str);
            }
            this.B.o(true);
            this.B.u(new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0509, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f084a, TBAlertConfig.OperateBtnStyle.MAIN, new j(this)));
            this.B.i();
            this.B.j(false);
            this.B.z();
            MessageManager.getInstance().registerListener(iVar);
            this.B.s(new a(this, iVar));
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2 || i2 == 4) {
                    B(true);
                    D(true);
                    C(false);
                    E(true);
                    return;
                }
                return;
            }
            B(true);
            D(true);
            C(true);
            E(true);
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    if (i2 == 4) {
                        B(true);
                        D(true);
                        C(false);
                        E(true);
                        return;
                    }
                    return;
                }
                B(true);
                D(true);
                C(false);
                E(false);
                return;
            }
            B(true);
            D(true);
            C(true);
            E(true);
        }
    }

    public final TbRichText K(BaseMsg baseMsg) {
        InterceptResult invokeL;
        TbRichText tbRichText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, baseMsg)) == null) {
            int msgType = baseMsg.getMsgType();
            if (msgType != 1) {
                if (msgType != 2) {
                    if (msgType != 3) {
                        if (msgType != 32) {
                            if (msgType != 101) {
                                if (msgType != 7009) {
                                    return new TbRichText(we7.c("", 0));
                                }
                                return new TbRichText(we7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_forum_share), 0));
                            }
                            tbRichText = new TbRichText(we7.c(((TextGenImageMsg) baseMsg).getText(), 0));
                        } else {
                            return new TbRichText(we7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_thread_share), 0));
                        }
                    } else {
                        return new TbRichText(we7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_voice), 0));
                    }
                } else {
                    return new TbRichText(we7.c(TbadkCoreApplication.getInst().getString(R.string.last_msg_pic), 0));
                }
            } else {
                tbRichText = new TbRichText(we7.c(((TextMsg) baseMsg).getText(), 0));
            }
            return tbRichText;
        }
        return (TbRichText) invokeL.objValue;
    }

    public void q() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.n.getCommonMsgField() != null) {
                if (this.n.getCommonMsgField().getUserName() != null) {
                    TextView textView = this.e;
                    textView.setText(this.n.getCommonMsgField().getUserName() + ZeusCrashHandler.NAME_SEPERATOR);
                    this.A = this.n.getCommonMsgField().getUserName();
                }
                if (this.n.getCommonMsgField().getMsgKey() != null) {
                    this.y = this.n.getCommonMsgField().getMsgKey();
                }
                this.q = this.n.getCommonMsgField().getRole();
                if (this.n.getCommonMsgField().getRobotRole() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.r = z;
                this.u = this.n.getCommonMsgField().getRoomId();
                this.v = this.n.getCommonMsgField().getMsgId();
                this.w = this.n.getCommonMsgField().getUserId();
                this.x = TbadkCoreApplication.getCurrentAccountId();
                if (this.o.getBasicInfo() != null) {
                    this.z = this.o.getBasicInfo().getForumId();
                }
            }
            if (this.o.getUserInfo() != null) {
                this.p = this.o.getUserInfo().getIdentityRole();
            }
            this.f.setMaxLines(1);
            this.f.setAddTruncateListener(true);
            this.f.setTextEllipsize(TextUtils.TruncateAt.END);
            this.f.setText(K(this.n));
            if (this.w != this.x) {
                int i2 = this.p;
                int i3 = 4;
                if (i2 == 0) {
                    if (!this.r) {
                        i3 = this.q;
                    }
                    u(i3);
                } else if (i2 != 2 && i2 != 3) {
                    if (i2 == 1) {
                        if (!this.r) {
                            i3 = this.q;
                        }
                        H(i3);
                    }
                } else {
                    if (!this.r) {
                        i3 = this.q;
                    }
                    t(i3);
                }
            } else {
                J();
            }
            BaseMsg baseMsg = this.n;
            if (baseMsg != null && baseMsg.getMsgType() != 1 && this.n.getMsgType() != 101) {
                B(false);
            }
            BaseMsg baseMsg2 = this.n;
            if ((baseMsg2 instanceof TextMsg) && ((TextMsg) baseMsg2).isRobotGuideMsg()) {
                E(false);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d07d2, (ViewGroup) null);
            this.b = inflate;
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d73);
            this.d = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d6c);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d70);
            this.f = (TbRichTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d6f);
            this.g = (FlowLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090d56);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d67);
            this.h = eMTextView;
            eMTextView.setOnClickListener(new b(this));
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d6a);
            this.i = eMTextView2;
            eMTextView2.setOnClickListener(new c(this));
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d68);
            this.j = eMTextView3;
            eMTextView3.setOnClickListener(new d(this));
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d69);
            this.k = eMTextView4;
            eMTextView4.setOnClickListener(new e(this));
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f090d54);
            this.l = eMTextView5;
            eMTextView5.setOnClickListener(new f(this));
            this.m = this.b.findViewById(R.id.obfuscated_res_0x7f0903c8);
            if (!s()) {
                A();
            }
        }
    }

    public void z() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            cx4 d2 = cx4.d(this.c);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0213);
            cx4 d3 = cx4.d(this.d);
            d3.n(R.string.J_X14);
            d3.f(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.m, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0213);
            cx4 d4 = cx4.d(this.e);
            d4.v(R.color.CAM_X0109);
            d4.z(R.dimen.T_X08);
            d4.A(R.string.F_X01);
            this.f.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f.setTextSize(UtilHelper.getDimenPixelSize(R.dimen.T_X08));
            SkinManager.setViewTextColorSelector(this.l, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getPageActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (s()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 4)) / 3;
            } else {
                i2 = (width - 804) / 3;
            }
            this.g.setHorizontalSpacing(i2);
            F(this.h, R.drawable.obfuscated_res_0x7f080460);
            F(this.i, R.drawable.obfuscated_res_0x7f080463);
            F(this.j, R.drawable.obfuscated_res_0x7f080461);
            F(this.k, R.drawable.obfuscated_res_0x7f080462);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.s == null) {
                this.s = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_LIMIT_MESSAGE, "c/c/chatroom/controlSpeak");
            }
            FastRequest fastRequest = this.s;
            fastRequest.H("uid", String.valueOf(this.x));
            fastRequest.H("chatroom_id", String.valueOf(this.u));
            fastRequest.H("op_type", 1);
            fastRequest.H("block_uid", String.valueOf(this.w));
            fastRequest.H("forum_id", String.valueOf(this.z));
            fastRequest.J(new g(this));
            fastRequest.I();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.t == null) {
                this.t = new FastRequest(this.a, CmdConfigHttp.CMD_GET_GROUP_CHAT_ROLLBACK_MESSAGE, "c/c/chatroom/withdrawMsg");
            }
            FastRequest fastRequest = this.t;
            fastRequest.H("uid_to", String.valueOf(this.w));
            fastRequest.H("chatroom_id", String.valueOf(this.u));
            fastRequest.H("msg_id", String.valueOf(this.v));
            fastRequest.H("msg_key", String.valueOf(this.y));
            fastRequest.H("forum_id", String.valueOf(this.z));
            fastRequest.J(new h(this));
            fastRequest.I();
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            UrlManager urlManager = UrlManager.getInstance();
            TbPageContext<BaseFragmentActivity> tbPageContext = this.a;
            urlManager.dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/tpl/wise-bawu-core/report?type=5" + ("&chatroom_msg_id=" + this.v) + ("&chatroom_id=" + this.u)});
        }
    }
}
