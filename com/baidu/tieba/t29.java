package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.u29;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class t29 extends BdBaseView<BaseFragmentActivity> implements r29, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int J;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;
    public Runnable B;
    public TBAlertBuilder C;
    @Nullable
    public TBAlertBuilder D;
    public boolean E;
    public boolean F;
    public boolean G;
    @Nullable
    public BaseItem H;
    public final FastRequest.b<u29.e> I;
    public final WeakReference<Activity> a;
    @Nullable
    public AlertDialog b;
    public View c;
    public LinearLayout d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public FlowLayout h;
    @NonNull
    public final w29 i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public EMTextView r;
    public LinearLayout s;
    public HeadImageView t;
    public TextView u;
    public View v;
    public List<View> w;
    public EMTextView x;
    public View y;
    @Nullable
    public p29 z;

    /* loaded from: classes8.dex */
    public class a implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public a(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
                this.a.L();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public b(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.Y();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public c(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yb.a(this.a.b, this.a.mContext.getPageActivity());
                this.a.L();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public d(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.z != null) {
                this.a.z.b(25, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public e(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ChatRoomDetail.BasicInfo b;
        public final /* synthetic */ TbBaseMsg c;
        public final /* synthetic */ t29 d;

        public f(t29 t29Var, Activity activity, ChatRoomDetail.BasicInfo basicInfo, TbBaseMsg tbBaseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var, activity, basicInfo, tbBaseMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t29Var;
            this.a = activity;
            this.b = basicInfo;
            this.c = tbBaseMsg;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a, String.valueOf(this.b.getForumId()), this.b.getForumName(), "", TbadkCoreApplication.getCurrentAccount(), this.c.getUserName(), this.c.getUserName(), "", this.c.getPortrait(), "chatroom", this.c.getSessionId(), this.c.getMsgId())));
                this.d.D.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) ? i == 4 : invokeLIL.booleanValue;
        }

        public g(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h extends FastRequest.b<u29.e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 d;

        public h(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t29Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(@NonNull u29.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
                if (eVar.b() == 1) {
                    this.d.G = true;
                } else {
                    this.d.G = false;
                }
                this.d.h();
                this.d.onChangeSkinType();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, @NonNull String str, @Nullable u29.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, eVar) == null) {
                super.f(i, str, eVar);
                this.d.G = false;
                this.d.h();
                this.d.onChangeSkinType();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948129454, "Lcom/baidu/tieba/t29;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948129454, "Lcom/baidu/tieba/t29;");
                return;
            }
        }
        J = UtilHelper.getDimenPixelSize(R.dimen.tbds78);
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            F(0L);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            AlertDialog create = new AlertDialog.Builder(this.mContext.getPageActivity(), R.style.obfuscated_res_0x7f10010d).create();
            this.b = create;
            create.setCanceledOnTouchOutside(true);
            this.b.setOnDismissListener(new a(this));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
            return;
        }
        while (true) {
            List<View> list = this.w;
            if (list != null && list.size() > 0) {
                this.h.removeView(this.w.get(0));
                this.w.remove(0);
            } else {
                return;
            }
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && this.s != null) {
            EMManager.from(this.u).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X09);
        }
    }

    @Override // com.baidu.tieba.r29
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            X(0L);
        }
    }

    @Override // com.baidu.tieba.r29
    public FastRequest.b<u29.e> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.I;
        }
        return (FastRequest.b) invokeV.objValue;
    }

    @Override // com.baidu.tieba.r29
    public void q() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (linearLayout = this.s) != null) {
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.r29
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.F;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t29(@NonNull BdPageContext<BaseFragmentActivity> bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.w = new ArrayList();
        this.E = false;
        this.F = false;
        this.G = false;
        this.I = new h(this);
        this.a = new WeakReference<>(bdPageContext.getPageActivity());
        G();
        H();
        w29 w29Var = new w29(this);
        this.i = w29Var;
        w29Var.b(this.c);
    }

    @Override // com.baidu.tieba.r29
    public void n(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, obj) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01a1, (ViewGroup) null);
            this.v = inflate;
            this.s = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092050);
            this.t = (HeadImageView) this.v.findViewById(R.id.obfuscated_res_0x7f092055);
            this.u = (TextView) this.v.findViewById(R.id.obfuscated_res_0x7f092067);
            W();
            this.t.setIsRound(true);
            this.t.setDrawBorder(false);
            this.t.setPlaceHolder(1);
            this.s.setOnClickListener(this);
            this.s.setTag(obj);
            this.h.addView(this.v);
            this.w.add(this.v);
            LinearLayout linearLayout = this.s;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            if (this.A == null) {
                this.A = new c(this);
            }
            SafeHandler.getInst().postDelayed(this.A, j);
        }
    }

    public void M(@NonNull Reaction reaction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, reaction) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext_reaction", reaction);
            this.z.b(26, hashMap);
        }
    }

    public final void O(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            EMTextView eMTextView = this.q;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void P(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            EMTextView eMTextView = this.r;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void Q(@Nullable Map<String, Object> map) {
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
            if (map != null && map.containsKey("is_show_copy")) {
                z = ((Boolean) map.get("is_show_copy")).booleanValue();
            } else {
                z = true;
            }
            EMTextView eMTextView = this.j;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void R(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.F = z;
            EMTextView eMTextView = this.m;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void S(@Nullable Map<String, Object> map) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, map) == null) {
            int i = 0;
            if (map != null && map.containsKey("is_show_reply")) {
                z = ((Boolean) map.get("is_show_reply")).booleanValue();
            } else {
                z = false;
            }
            EMTextView eMTextView = this.k;
            if (!z) {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void T(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            EMTextView eMTextView = this.n;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public final void U(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            EMTextView eMTextView = this.l;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            eMTextView.setVisibility(i);
        }
    }

    public void X(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            if (this.B == null) {
                this.B = new b(this);
            }
            SafeHandler.getInst().postDelayed(this.B, j);
        }
    }

    public final void a0(@Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, map) == null) {
            Q(map);
            S(map);
            T(false);
            R(false);
            U(true);
        }
    }

    public void b0(@Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && !StringUtils.isNull(str)) {
            this.t.startLoad(str, 12, false);
        }
    }

    @Override // com.baidu.tieba.o29
    public void d(@NonNull List<Reaction> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            this.i.c(list);
        }
    }

    @Override // com.baidu.tieba.r29
    public void l(@NonNull p29 p29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, p29Var) == null) {
            this.z = p29Var;
        }
    }

    public final void K(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, map) == null) {
            if (i == 0 || i == 1 || i == 2 || i == 4 || i == 64) {
                Q(map);
                S(map);
                T(true);
                R(false);
                U(false);
            }
        }
    }

    public final void V(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048594, this, textView, i) != null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = J;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    @Override // com.baidu.tieba.r29
    public void c(@NonNull BaseItem<? extends TbBaseMsg> baseItem, @NonNull ChatRoomDetail chatRoomDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, baseItem, chatRoomDetail) == null) {
            this.H = baseItem;
            onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.r29
    @SuppressLint({"SetTextI18n"})
    public void k(@NonNull String str, @NonNull CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, str, charSequence) == null) {
            TextView textView = this.f;
            textView.setText(str + ZeusCrashHandler.NAME_SEPERATOR);
            this.g.setText(charSequence);
        }
    }

    @Override // com.baidu.tieba.r29
    public void s(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
            this.u.setText(str);
            b0(str2);
            this.s.setVisibility(0);
        }
    }

    public final void D(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 64) {
                    Q(map);
                    S(map);
                    T(true);
                    R(false);
                    U(false);
                    return;
                }
                return;
            }
            Q(map);
            S(map);
            T(true);
            R(true);
            U(false);
        }
    }

    public final void Z(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i, map) == null) {
            if (i != 0) {
                if (i == 1 || i == 2 || i == 4 || i == 64) {
                    Q(map);
                    T(true);
                    S(map);
                    R(false);
                    U(true);
                    return;
                }
                return;
            }
            Q(map);
            T(true);
            S(map);
            R(true);
            U(true);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d08c9, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090f1e);
            this.e = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090f17);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f1c);
            TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f1b);
            this.g = textView;
            textView.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.h = (FlowLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090eff);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f10);
            this.j = eMTextView;
            eMTextView.setOnClickListener(this);
            EMTextView eMTextView2 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f15);
            this.l = eMTextView2;
            eMTextView2.setOnClickListener(this);
            EMTextView eMTextView3 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f12);
            this.m = eMTextView3;
            eMTextView3.setOnClickListener(this);
            EMTextView eMTextView4 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f14);
            this.n = eMTextView4;
            eMTextView4.setOnClickListener(this);
            EMTextView eMTextView5 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090efc);
            this.x = eMTextView5;
            eMTextView5.setOnClickListener(this);
            EMTextView eMTextView6 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f13);
            this.k = eMTextView6;
            eMTextView6.setOnClickListener(this);
            EMTextView eMTextView7 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f0f);
            this.p = eMTextView7;
            eMTextView7.setOnClickListener(this);
            EMTextView eMTextView8 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f11);
            this.o = eMTextView8;
            eMTextView8.setOnClickListener(this);
            EMTextView eMTextView9 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f0d);
            this.q = eMTextView9;
            eMTextView9.setOnClickListener(this);
            this.y = this.c.findViewById(R.id.obfuscated_res_0x7f090446);
            EMTextView eMTextView10 = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f0e);
            this.r = eMTextView10;
            eMTextView10.setOnClickListener(this);
            if (!I()) {
                N();
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            if (i % 160 != 0 && (i * 1.0f) / 160.0f != 1.5d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r29
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            if (this.b != null) {
                this.b = null;
            }
            if (this.B != null) {
                SafeHandler.getInst().removeCallbacks(this.B);
                this.B = null;
            }
            if (this.A != null) {
                SafeHandler.getInst().removeCallbacks(this.A);
                this.A = null;
            }
        }
    }

    public final void J(int i, @Nullable Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, map) == null) {
            if (i != 0) {
                if (i != 1 && i != 2 && i != 3 && i != 4) {
                    if (i == 64) {
                        Q(map);
                        S(map);
                        T(true);
                        R(false);
                        U(true);
                        return;
                    }
                    return;
                }
                Q(map);
                S(map);
                T(true);
                R(false);
                U(false);
                return;
            }
            Q(map);
            S(map);
            T(true);
            R(true);
            U(true);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.q.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.o.getLayoutParams().width = 201;
            this.r.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            LinearLayout linearLayout = this.s;
            if (linearLayout != null) {
                linearLayout.getLayoutParams().width = 201;
            }
        }
    }

    public final boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null) {
                return false;
            }
            boolean i = yb.i(alertDialog, this.mContext.getPageActivity());
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f100421);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.c);
            window.setDimAmount(0.33f);
            return i;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r29
    public void a(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            new BdTopToast(this.mContext.getContext()).setIcon(true).setContent(str).show((ViewGroup) this.mContext.getPageActivity().findViewById(16908290));
        }
    }

    @Override // com.baidu.tieba.r29
    public void i(boolean z, int i, int i2, @Nullable Map<String, Object> map, boolean z2, int i3, long j, long j2) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), map, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            boolean z3 = true;
            if (z) {
                a0(map);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 4) {
                            D(i, map);
                        }
                    } else {
                        Z(i, map);
                    }
                } else {
                    J(i, map);
                }
            } else {
                K(i, map);
            }
            int i5 = 8;
            if (map != null && map.containsKey("is_show_bubble")) {
                boolean booleanValue = ((Boolean) map.get("is_show_bubble")).booleanValue();
                EMTextView eMTextView = this.p;
                if (booleanValue) {
                    i4 = 0;
                } else {
                    i4 = 8;
                }
                eMTextView.setVisibility(i4);
            } else {
                this.p.setVisibility(8);
            }
            if (map != null && map.containsKey("is_show_emoji_reply")) {
                this.i.d(((Boolean) map.get("is_show_emoji_reply")).booleanValue());
            } else {
                this.i.d(true);
            }
            if (z2) {
                O(true);
                bs8.a(1, 1, j, j2);
            } else {
                O(false);
            }
            if (map != null && map.containsKey("is_show_excellent_btn")) {
                boolean booleanValue2 = ((Boolean) map.get("is_show_excellent_btn")).booleanValue();
                EMTextView eMTextView2 = this.o;
                if (booleanValue2) {
                    i5 = 0;
                }
                eMTextView2.setVisibility(i5);
            } else {
                this.o.setVisibility(8);
            }
            int i6 = R.string.obfuscated_res_0x7f0f0424;
            int i7 = R.drawable.obfuscated_res_0x7f0804ee;
            if (map != null && map.containsKey("is_excellent_msg")) {
                boolean booleanValue3 = ((Boolean) map.get("is_excellent_msg")).booleanValue();
                this.E = booleanValue3;
                EMTextView eMTextView3 = this.o;
                if (booleanValue3) {
                    i7 = R.drawable.obfuscated_res_0x7f0804ed;
                }
                V(eMTextView3, i7);
                EMTextView eMTextView4 = this.o;
                if (this.E) {
                    i6 = R.string.obfuscated_res_0x7f0f0423;
                }
                eMTextView4.setText(i6);
            } else {
                V(this.o, R.drawable.obfuscated_res_0x7f0804ee);
                this.o.setText(R.string.obfuscated_res_0x7f0f0424);
            }
            if ((i3 != 1 && i3 != 2) || i != 0 || z) {
                z3 = false;
            }
            P(z3);
        }
    }

    @Override // com.baidu.tieba.r29
    public void j(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(this.a.get());
            this.C = tBAlertBuilder;
            tBAlertBuilder.setTitle(R.string.obfuscated_res_0x7f0f096b);
            this.C.setDescStr(str);
            this.C.setDescLightStyle(true);
            this.C.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f05a0, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f096b, TBAlertConfig.OperateBtnStyle.MAIN, new d(this)));
            this.C.setAutoClose();
            this.C.setCancelable(false);
            this.C.show();
        }
    }

    @Override // com.baidu.tieba.r29
    public void onChangeSkinType() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            EMManager.from(this.d).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0213);
            EMManager.from(this.e).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0209);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.x, R.color.CAM_X0213);
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(this.g).setTextColor(R.color.CAM_X0107).setTextSize(R.dimen.T_X08);
            W();
            SkinManager.setViewTextColorSelector(this.x, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.mContext.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (I()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.h.setHorizontalSpacing(i);
            V(this.q, R.drawable.obfuscated_res_0x7f0800e6);
            V(this.j, R.drawable.obfuscated_res_0x7f0804e7);
            V(this.l, R.drawable.obfuscated_res_0x7f0804ec);
            if (this.G) {
                V(this.m, R.drawable.obfuscated_res_0x7f0804e9);
                this.m.setText(R.string.obfuscated_res_0x7f0f096f);
            } else {
                V(this.m, R.drawable.obfuscated_res_0x7f0804e8);
                this.m.setText(R.string.obfuscated_res_0x7f0f096b);
            }
            V(this.n, R.drawable.obfuscated_res_0x7f0804eb);
            V(this.k, R.drawable.obfuscated_res_0x7f0804ea);
            V(this.p, R.drawable.obfuscated_res_0x7f080bcd);
            EMTextView eMTextView = this.o;
            if (this.E) {
                i2 = R.drawable.obfuscated_res_0x7f0804ed;
            } else {
                i2 = R.drawable.obfuscated_res_0x7f0804ee;
            }
            V(eMTextView, i2);
            V(this.r, R.drawable.obfuscated_res_0x7f080bb3);
            TBAlertBuilder tBAlertBuilder = this.C;
            if (tBAlertBuilder != null) {
                tBAlertBuilder.onChangeSkinType();
            }
            TBAlertBuilder tBAlertBuilder2 = this.D;
            if (tBAlertBuilder2 != null) {
                tBAlertBuilder2.onChangeSkinType();
            }
            this.i.onChangeSkinType(TbadkApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        p29 p29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f090f10) {
                p29 p29Var2 = this.z;
                if (p29Var2 != null) {
                    p29Var2.b(19, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f15) {
                p29 p29Var3 = this.z;
                if (p29Var3 != null) {
                    p29Var3.b(18, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f12) {
                p29 p29Var4 = this.z;
                if (p29Var4 != null) {
                    if (this.G) {
                        p29Var4.b(36, null);
                    } else {
                        p29Var4.b(17, null);
                    }
                }
            } else if (id == R.id.obfuscated_res_0x7f090f14) {
                p29 p29Var5 = this.z;
                if (p29Var5 != null) {
                    p29Var5.b(20, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f13) {
                p29 p29Var6 = this.z;
                if (p29Var6 != null) {
                    p29Var6.b(21, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090efc) {
                p29 p29Var7 = this.z;
                if (p29Var7 != null) {
                    p29Var7.b(22, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f0f) {
                p29 p29Var8 = this.z;
                if (p29Var8 != null) {
                    p29Var8.b(23, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f092050) {
                if (this.z != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("robot_tag", view2.getTag());
                    this.z.b(24, hashMap);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f11) {
                p29 p29Var9 = this.z;
                if (p29Var9 != null) {
                    p29Var9.b(33, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f0d) {
                p29 p29Var10 = this.z;
                if (p29Var10 != null) {
                    p29Var10.b(32, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f091865) {
                p29 p29Var11 = this.z;
                if (p29Var11 != null) {
                    p29Var11.b(34, null);
                }
            } else if (id == R.id.obfuscated_res_0x7f090f0e && (p29Var = this.z) != null) {
                p29Var.b(35, null);
            }
            E();
        }
    }

    @Override // com.baidu.tieba.r29
    public void t(int i, int i2, @Nullable String str, Object obj) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, obj}) == null) {
            if (i != 1) {
                if (i != 3) {
                    if (i == 4 && i2 == 1 && (obj instanceof u29.e)) {
                        u29.e eVar = (u29.e) obj;
                        if (eVar.b() == 1) {
                            UrlManager.getInstance().dealOneLink(eVar.a());
                        } else {
                            a(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0971));
                        }
                    }
                } else if (i2 == 1) {
                    boolean z = !this.E;
                    this.E = z;
                    EMTextView eMTextView = this.o;
                    if (z) {
                        i3 = R.drawable.obfuscated_res_0x7f0804ed;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f0804ee;
                    }
                    V(eMTextView, i3);
                    a(str);
                }
            } else if (i2 == 1) {
                a(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0970));
            } else if (i2 == 2140004 && !rd.isEmpty(str)) {
                a(str);
            }
        }
    }

    @Override // com.baidu.tieba.r29
    public void u(@Nullable BaseItem baseItem, @Nullable ChatRoomDetail chatRoomDetail) {
        WeakReference<Activity> weakReference;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048618, this, baseItem, chatRoomDetail) == null) && (weakReference = this.a) != null && weakReference.get() != null && baseItem != null && baseItem.getTbMsg() != null && chatRoomDetail != null && chatRoomDetail.getUserInfo() != null && chatRoomDetail.getBasicInfo() != null) {
            Activity activity = this.a.get();
            TbBaseMsg tbMsg = baseItem.getTbMsg();
            ChatRoomDetail.BasicInfo basicInfo = chatRoomDetail.getBasicInfo();
            ChatRoomDetail.UserInfo userInfo = chatRoomDetail.getUserInfo();
            String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a7d);
            String banAllForumContent = userInfo.getBanAllForumContent();
            if (StringUtils.isNull(banAllForumContent)) {
                banAllForumContent = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a7b);
            }
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(activity);
            this.D = tBAlertBuilder;
            tBAlertBuilder.setTitleStr(string);
            this.D.setDescStr(String.format(banAllForumContent, tbMsg.getUserName(), basicInfo.getForumName()));
            this.D.setOperateBtn(new TBAlertConfig.OperateBtnConfig(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a81), TBAlertConfig.OperateBtnStyle.SECONDARY, new e(this)), new TBAlertConfig.OperateBtnConfig(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a7d), TBAlertConfig.OperateBtnStyle.MAIN, new f(this, activity, basicInfo, tbMsg)));
            this.D.setOnKeyListener(new g(this));
            this.D.setAutoClose();
            this.D.setCancelable(false);
            this.D.show();
        }
    }
}
