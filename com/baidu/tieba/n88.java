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
public class n88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final GroupInputViewController a;
    @NonNull
    public final d b;
    @NonNull
    public final FastRequest c;
    @NonNull
    public final z6c<CharSequence> d;
    @NonNull
    public final a7c<CharSequence, Boolean> e;
    public x88 f;
    @Nullable
    public ea8 g;
    @Nullable
    public a88 h;
    @Nullable
    public x78 i;
    public v88 j;
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
        public final /* synthetic */ n88 a;

        /* renamed from: com.baidu.tieba.n88$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0394a implements y88 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.n88$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0395a implements e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AbilityItem a;
                public final /* synthetic */ String b;
                public final /* synthetic */ C0394a c;

                public C0395a(C0394a c0394a, AbilityItem abilityItem, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0394a, abilityItem, str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = c0394a;
                    this.a = abilityItem;
                    this.b = str;
                }

                @Override // com.baidu.tieba.n88.e
                public void a(AbilityItem abilityItem) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) {
                        if (this.c.a.a.j != null) {
                            List<v98> f = this.c.a.a.j.f();
                            ArrayList arrayList = new ArrayList();
                            for (v98 v98Var : f) {
                                arrayList.add(new b(v98Var));
                            }
                            arrayList.add(1, new b(abilityItem));
                            this.c.a.a.j.h(arrayList);
                        }
                        this.c.a.a.f.n(Boolean.TRUE);
                    }
                }

                @Override // com.baidu.tieba.n88.e
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.c.a.a.s(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.n88.e
                public void onFinish() {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                        return;
                    }
                    this.c.a.a.s(this.a, this.b);
                    this.c.a.a.f.n(Boolean.TRUE);
                }

                @Override // com.baidu.tieba.n88.e
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

            public C0394a(a aVar) {
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

            @Override // com.baidu.tieba.y88
            public void a(AbilityItem abilityItem) {
                String str;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) && this.a.a.g != null && abilityItem != null) {
                    if (abilityItem.getStyleConf() != null && abilityItem.getStyleConf().getDay() != null) {
                        str = abilityItem.getStyleConf().getDay().getIcon();
                    } else {
                        str = "";
                    }
                    this.a.a.g.d(abilityItem, null, new C0395a(this, abilityItem, str));
                    if (!"pic_gen_commit".equals(abilityItem.getType())) {
                        this.a.a.a.A0();
                    }
                }
            }
        }

        public a(n88 n88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n88Var;
        }

        @Override // com.baidu.tieba.n88.c
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
        @Override // com.baidu.tieba.n88.c
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
                        this.a.f = new x88(relativeLayout.findViewById(R.id.obfuscated_res_0x7f09043e), new C0394a(this));
                        x88 x88Var = this.a.f;
                        long j2 = 0;
                        if (this.a.h != null) {
                            j = this.a.h.d();
                        } else {
                            j = 0;
                        }
                        x88Var.p(j);
                        x88 x88Var2 = this.a.f;
                        if (this.a.i != null) {
                            j2 = this.a.i.a();
                        }
                        x88Var2.o(j2);
                        n88 n88Var = this.a;
                        n88Var.j = n88Var.f.i();
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
        public final z6c<CharSequence> a;
        public final a7c<CharSequence, Boolean> b;
        public final FastRequest c;
        public final c<RelativeMemeDetail> d;
        @Nullable
        public a88 e;
        @Nullable
        public x78 f;

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

        public d(z6c<CharSequence> z6cVar, a7c<CharSequence, Boolean> a7cVar, FastRequest fastRequest, @NonNull c<RelativeMemeDetail> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z6cVar, a7cVar, fastRequest, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z6cVar;
            this.c = fastRequest;
            this.d = cVar;
            this.b = a7cVar;
        }

        public void c(CharSequence charSequence, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                FastRequest fastRequest = this.c;
                fastRequest.O("chatroom_id", String.valueOf(j));
                fastRequest.O("forum_id", String.valueOf(j2));
                fastRequest.O("keyword", charSequence);
                fastRequest.Q(new a(this, charSequence));
                fastRequest.P();
            }
        }

        public void d(a88 a88Var, x78 x78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a88Var, x78Var) == null) {
                this.e = a88Var;
                this.f = x78Var;
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
                    a88 a88Var = this.e;
                    if (a88Var != null) {
                        j = a88Var.d();
                    } else {
                        j = 0;
                    }
                    x78 x78Var = this.f;
                    if (x78Var != null) {
                        j2 = x78Var.a();
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

    public n88(@NonNull GroupInputViewController groupInputViewController, @NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull z6c<CharSequence> z6cVar, @Nullable ea8 ea8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {groupInputViewController, tbPageContext, z6cVar, ea8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a7c() { // from class: com.baidu.tieba.m88
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.a7c
            public final Object call(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? Boolean.valueOf(n88.this.k((CharSequence) obj)) : invokeL.objValue;
            }
        };
        this.k = new a(this);
        this.a = groupInputViewController;
        this.d = z6cVar;
        this.g = ea8Var;
        FastRequest fastRequest = new FastRequest(tbPageContext, CmdConfigHttp.CMD_HTTP_RELATIVE_MEME_LIST, TbConfig.GET_RELATIVE_MEME_LIST);
        this.c = fastRequest;
        this.b = new d(z6cVar, this.e, fastRequest, this.k);
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
            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.l88
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        n88.this.o(j);
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

    public void r(a88 a88Var, x78 x78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, a88Var, x78Var) == null) {
            this.h = a88Var;
            this.i = x78Var;
            this.b.d(a88Var, x78Var);
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
            x88 x88Var = this.f;
            if (x88Var != null) {
                x88Var.l();
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
