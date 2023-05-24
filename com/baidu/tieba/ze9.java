package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.q4a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes8.dex */
public class ze9 {
    public static /* synthetic */ Interceptable $ic;
    public static ze9 c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public v59 b;

    /* loaded from: classes8.dex */
    public class a implements q4a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ ze9 b;

        public a(ze9 ze9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.q4a.g
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            this.b.a = i;
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_CLICK_STAR).param("obj_type", this.b.a));
            this.b.o(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements q4a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ ze9 b;

        public b(ze9 ze9Var, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze9Var;
            this.a = tbPageContext;
        }

        @Override // com.baidu.tieba.q4a.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.b == null) {
                return;
            }
            this.b.b.dismiss();
            this.b.b = null;
            if (this.b.a == 1 || this.b.a == 2) {
                this.b.h(this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_FEEDBACK));
                return;
            }
            this.b.i(this.a);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_SCORE));
        }
    }

    /* loaded from: classes8.dex */
    public class c implements q4a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ze9 a;

        public c(ze9 ze9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ze9Var;
        }

        @Override // com.baidu.tieba.q4a.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.b == null) {
                return;
            }
            this.a.b.dismiss();
            this.a.b = null;
            if (this.a.a != 1 && this.a.a != 2) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_CLICK_CANCEL));
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_CLICK_CANCEL));
            }
        }
    }

    public ze9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    public static ze9 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == null) {
                synchronized (ze9.class) {
                    if (c == null) {
                        c = new ze9();
                    }
                }
            }
            return c;
        }
        return (ze9) invokeV.objValue;
    }

    public final void h(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{TbConfig.getFeedBackUrl()}, true);
    }

    public void m(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        k(tbPageContext);
    }

    public final void i(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
            try {
                Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(BaseConstants.MARKET_PREFIX + TbadkCoreApplication.getInst().getPackageName()));
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                tbPageContext.getContext().startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String version = TbConfig.getVersion();
            if (!version.equals(o65.m().s("key_rate_version", ""))) {
                o65.m().B("key_rate_version", version);
                o65.m().A("key_rate_version_time", new Date().getTime());
            }
        }
    }

    public final void k(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbPageContext) != null) || tbPageContext == null || TbConfig.getVersionType() == 2) {
            return;
        }
        if (Long.valueOf(new Date().getTime()).longValue() - o65.m().o("key_rate_version_time", 0L) < 86400000) {
            return;
        }
        String version = TbConfig.getVersion();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        o65 m = o65.m();
        if (m.i("key_rate_same_version_is_score" + version + currentAccount, false)) {
            return;
        }
        o65 m2 = o65.m();
        m2.w("key_rate_same_version_is_score" + version + currentAccount, true);
        n(tbPageContext);
    }

    public void n(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        q4a q4aVar = new q4a(tbPageContext.getContext());
        q4aVar.x(tbPageContext.getContext().getString(R.string.is_tieba_pleased));
        q4aVar.n(8);
        q4aVar.r(0);
        int g = ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07040e);
        int g2 = ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07035d);
        int g3 = ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f07039a);
        q4aVar.w(R.dimen.obfuscated_res_0x7f0701f9);
        q4aVar.v(0, g, 0, g3);
        q4aVar.p(0, 0, 0, g2);
        q4aVar.o(true);
        q4aVar.u(new a(this, tbPageContext));
        v59 v59Var = new v59(tbPageContext.getContext(), q4aVar.j());
        this.b = v59Var;
        v59Var.a(0.7f);
        ug.j(this.b, tbPageContext);
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FIRST_DIALOG_SHOW));
    }

    public void l(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        o65 m = o65.m();
        int n = m.n("key_rate_like_count" + currentAccount, 0) + 1;
        if (n < 3) {
            if (n == 1) {
                Long valueOf = Long.valueOf(new Date().getTime());
                o65 m2 = o65.m();
                m2.A("key_rate_first_like_time" + currentAccount, valueOf.longValue());
                o65 m3 = o65.m();
                m3.z("key_rate_like_count" + currentAccount, n);
                return;
            }
            o65 m4 = o65.m();
            m4.z("key_rate_like_count" + currentAccount, n);
            return;
        }
        o65 m5 = o65.m();
        if (Long.valueOf(new Date().getTime()).longValue() - m5.o("key_rate_first_like_time" + currentAccount, 0L) < 86400000) {
            o65 m6 = o65.m();
            m6.z("key_rate_like_count" + currentAccount, 0);
            k(tbPageContext);
            return;
        }
        o65 m7 = o65.m();
        m7.z("key_rate_like_count" + currentAccount, 0);
    }

    public void o(TbPageContext tbPageContext) {
        q4a.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        q4a q4aVar = new q4a(tbPageContext.getContext());
        int i = this.a;
        if (i != 1 && i != 2) {
            q4aVar.x(tbPageContext.getContext().getString(R.string.go_shop_give_me_comment));
            cVar = new q4a.c(tbPageContext.getContext().getString(R.string.go_score), q4aVar);
        } else {
            q4aVar.x(tbPageContext.getContext().getString(R.string.help_my_improving_experience));
            cVar = new q4a.c(tbPageContext.getContext().getString(R.string.go_feedback), q4aVar);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        q4aVar.q(this.a);
        q4aVar.r(0);
        q4aVar.n(0);
        q4aVar.o(false);
        ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703c7);
        int g = ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070207);
        ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f0703de);
        q4aVar.v(0, ri.g(tbPageContext.getContext(), R.dimen.obfuscated_res_0x7f070383), 0, 0);
        q4aVar.p(0, g, 0, g);
        cVar.h(new b(this, tbPageContext));
        q4aVar.t(new c(this));
        q4aVar.s(arrayList);
        v59 v59Var = new v59(tbPageContext.getContext(), q4aVar.j());
        this.b = v59Var;
        v59Var.a(0.7f);
        ug.j(this.b, tbPageContext);
        int i2 = this.a;
        if (i2 != 1 && i2 != 2) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_SCORE_DIALOG_SHOW));
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_RATE_FEEDBACK_DIALOG_SHOW));
        }
    }
}
