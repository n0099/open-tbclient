package com.baidu.tieba;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.im.base.core.inputtool.GroupInputViewController;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.RelativeMemeDetail;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
/* loaded from: classes7.dex */
public class ll8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final GroupInputViewController a;
    @NonNull
    public final d b;
    @NonNull
    public final FastRequest c;
    @NonNull
    public final akc<CharSequence> d;
    @NonNull
    public final bkc<CharSequence, Boolean> e;
    public vl8 f;
    @Nullable
    public cn8 g;
    @Nullable
    public yk8 h;
    @Nullable
    public vk8 i;
    public tl8 j;
    @NonNull
    public final c<RelativeMemeDetail> k;

    /* loaded from: classes7.dex */
    public interface c<Result> {
        void a();

        void b(@NonNull Result result);
    }

    /* loaded from: classes7.dex */
    public interface e {
        void a(AbilityItem abilityItem);

        void onFail();

        void onFinish();

        void onStart();
    }

    /* loaded from: classes7.dex */
    public class a implements c<RelativeMemeDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ll8 a;

        /* renamed from: com.baidu.tieba.ll8$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0374a implements wl8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.ll8$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0375a implements e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbilityItem a;
                public final /* synthetic */ String b;
                public final /* synthetic */ C0374a c;

                public C0375a(C0374a c0374a, AbilityItem abilityItem, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0374a, abilityItem, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = c0374a;
                    this.a = abilityItem;
                    this.b = str;
                }

                @Override // com.baidu.tieba.ll8.e
                public void a(AbilityItem abilityItem) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) {
                        if (this.c.a.a.j != null) {
                            List<tm8> f = this.c.a.a.j.f();
                            ArrayList arrayList = new ArrayList();
                            for (tm8 tm8Var : f) {
                                arrayList.add(new b(tm8Var));
                            }
                            arrayList.add(1, new b(abilityItem));
                            this.c.a.a.j.h(arrayList);
                        }
                        this.c.a.a.f.n(Boolean.TRUE);
                    }
                }

                @Override // com.baidu.tieba.ll8.e
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.c.a.a.s(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.ll8.e
                public void onFinish() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                        return;
                    }
                    this.c.a.a.s(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.ll8.e
                public void onStart() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                        if (this.c.a.a.j != null) {
                            this.c.a.a.t(this.a);
                        }
                        this.c.a.a.f.n(Boolean.FALSE);
                    }
                }
            }

            public C0374a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.wl8
            public void a(AbilityItem abilityItem) {
                String str;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) && this.a.a.g != null && abilityItem != null) {
                    if (abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getDay() != null) {
                        str = abilityItem.getStyleConf().getDay().getIcon();
                    } else {
                        str = "";
                    }
                    this.a.a.g.d(abilityItem, null, new C0375a(this, abilityItem, str));
                    if (!"pic_gen_commit".equals(abilityItem.getType())) {
                        this.a.a.a.A0();
                    }
                }
            }
        }

        public a(ll8 ll8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ll8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ll8Var;
        }

        @Override // com.baidu.tieba.ll8.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f != null) {
                    this.a.f.j();
                }
                this.a.m(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ll8.c
        /* renamed from: c */
        public void b(@NonNull RelativeMemeDetail relativeMemeDetail) {
            RelativeLayout relativeLayout;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, relativeMemeDetail) == null) {
                if (this.a.f == null) {
                    if (this.a.a.P0() != null) {
                        relativeLayout = this.a.a.P0().O();
                    } else {
                        relativeLayout = null;
                    }
                    if (relativeLayout != null) {
                        this.a.f = new vl8(relativeLayout.findViewById(R.id.obfuscated_res_0x7f090457), new C0374a(this));
                        vl8 vl8Var = this.a.f;
                        long j2 = 0;
                        if (this.a.h != null) {
                            j = this.a.h.d();
                        } else {
                            j = 0;
                        }
                        vl8Var.p(j);
                        vl8 vl8Var2 = this.a.f;
                        if (this.a.i != null) {
                            j2 = this.a.i.a();
                        }
                        vl8Var2.o(j2);
                        ll8 ll8Var = this.a;
                        ll8Var.j = ll8Var.f.i();
                    }
                }
                if (this.a.f != null) {
                    this.a.m(true);
                    this.a.f.q(relativeMemeDetail);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final akc<CharSequence> a;
        public final bkc<CharSequence, Boolean> b;
        public final FastRequest c;
        public final c<RelativeMemeDetail> d;
        @Nullable
        public yk8 e;
        @Nullable
        public vk8 f;

        /* loaded from: classes7.dex */
        public class a extends FastRequest.b<RelativeMemeDetail> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CharSequence d;
            public final /* synthetic */ d e;

            public a(d dVar, CharSequence charSequence) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, charSequence};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.e = dVar;
                this.d = charSequence;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: l */
            public void f(int i, @NonNull String str, @Nullable RelativeMemeDetail relativeMemeDetail) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, relativeMemeDetail) == null) {
                    super.f(i, str, relativeMemeDetail);
                    this.e.d.a();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.net.FastRequest.b
            /* renamed from: m */
            public void i(@NonNull RelativeMemeDetail relativeMemeDetail) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, relativeMemeDetail) == null) {
                    super.i(relativeMemeDetail);
                    if (((Boolean) this.e.b.call(this.d)).booleanValue() && relativeMemeDetail.getAbilityItems() != null && !relativeMemeDetail.getAbilityItems().isEmpty()) {
                        this.e.d.b(relativeMemeDetail);
                    } else {
                        this.e.d.a();
                    }
                }
            }
        }

        public d(akc<CharSequence> akcVar, bkc<CharSequence, Boolean> bkcVar, FastRequest fastRequest, @NonNull c<RelativeMemeDetail> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {akcVar, bkcVar, fastRequest, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = akcVar;
            this.c = fastRequest;
            this.d = cVar;
            this.b = bkcVar;
        }

        public void c(CharSequence charSequence, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                FastRequest fastRequest = this.c;
                fastRequest.P("chatroom_id", String.valueOf(j));
                fastRequest.P("forum_id", String.valueOf(j2));
                fastRequest.P("keyword", charSequence);
                fastRequest.R(new a(this, charSequence));
                fastRequest.Q();
            }
        }

        public void d(yk8 yk8Var, vk8 vk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yk8Var, vk8Var) == null) {
                this.e = yk8Var;
                this.f = vk8Var;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            long j;
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                CharSequence call = this.a.call();
                if (this.b.call(call).booleanValue()) {
                    yk8 yk8Var = this.e;
                    if (yk8Var != null) {
                        j = yk8Var.d();
                    } else {
                        j = 0;
                    }
                    vk8 vk8Var = this.f;
                    if (vk8Var != null) {
                        j2 = vk8Var.a();
                    } else {
                        j2 = 0;
                    }
                    c(call, j, j2);
                    return;
                }
                this.d.a();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;

        public b(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = obj;
        }
    }

    public ll8(@NonNull GroupInputViewController groupInputViewController, @NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull akc<CharSequence> akcVar, @Nullable cn8 cn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupInputViewController, tbPageContext, akcVar, cn8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new bkc() { // from class: com.baidu.tieba.kl8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bkc
            public final Object call(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(ll8.this.k((CharSequence) obj)) : invokeL.objValue;
            }
        };
        this.k = new a(this);
        this.a = groupInputViewController;
        this.d = akcVar;
        this.g = cn8Var;
        FastRequest fastRequest = new FastRequest(tbPageContext, CmdConfigHttp.CMD_HTTP_RELATIVE_MEME_LIST, TbConfig.GET_RELATIVE_MEME_LIST);
        this.c = fastRequest;
        this.b = new d(akcVar, this.e, fastRequest, this.k);
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && this.a.P0() != null) {
            this.a.P0().F(z);
        }
    }

    public void n(final long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.jl8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ll8.this.o(j);
                    }
                }
            });
        }
    }

    public /* synthetic */ void o(long j) {
        q();
        if (this.e.call(this.d.call()).booleanValue()) {
            SafeHandler.getInst().postDelayed(this.b, j);
        } else {
            this.k.a();
        }
    }

    public void r(yk8 yk8Var, vk8 vk8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, yk8Var, vk8Var) == null) {
            this.h = yk8Var;
            this.i = vk8Var;
            this.b.d(yk8Var, vk8Var);
        }
    }

    public final boolean k(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            if (this.a.P0() != null && this.a.P0().V() != null && !this.a.P0().c0() && this.a.R0() != null && !this.a.R0().n() && this.a.X0() != null && !this.a.X0().e() && this.a.W0() != null && !this.a.W0().e() && !this.a.P0().R() && this.a.P0().V().hasFocus() && !TextUtils.isEmpty(charSequence) && charSequence.length() <= 5) {
                try {
                    Pattern compile = Pattern.compile("[a-zA-Z一-龥]");
                    for (int i = 0; i < charSequence.length(); i++) {
                        if (!compile.matcher(String.valueOf(charSequence.charAt(i))).find()) {
                            return false;
                        }
                    }
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q();
            this.k.a();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vl8 vl8Var = this.f;
            if (vl8Var != null) {
                vl8Var.l();
            }
            q();
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.b);
            this.c.cancelLoadData();
        }
    }

    public final void s(AbilityItem abilityItem, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, abilityItem, str) == null) {
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDay())).setIcon(str);
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDark())).setIcon(str);
            this.j.a(0, false, abilityItem);
        }
    }

    public final void t(AbilityItem abilityItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, abilityItem) == null) && abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getAndroidExtra() != null) {
            String waitingIcon = abilityItem.getStyleConf().getAndroidExtra().getWaitingIcon();
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDay())).setIcon(waitingIcon);
            ((AbilityItem.Style) Objects.requireNonNull(abilityItem.getStyleConf().getDark())).setIcon(waitingIcon);
            this.j.a(0, false, abilityItem);
        }
    }
}
