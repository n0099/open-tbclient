package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MainTabActivity a;
    public PopupWindow b;
    public FragmentTabHost c;
    public String d;
    public long e;
    public View f;
    public TextView g;
    public TextView h;
    public Runnable i;
    public Runnable j;
    public View.OnClickListener k;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nfa a;

        public a(nfa nfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null && this.a.b != null && this.a.b.getContentView() != null) {
                FragmentTabWidget fragmentTabWidget = this.a.c.getFragmentTabWidget();
                int l = yi.l(this.a.a.getActivity());
                int g = yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0703af);
                this.a.b.getContentView().measure(0, 0);
                bh.l(this.a.b, fragmentTabWidget, (l - yi.g(this.a.a.getActivity(), R.dimen.obfuscated_res_0x7f0703db)) / 2, -g);
                da5.p().H("home_tip", this.a.e);
                zg.a().postDelayed(this.a.j, 5000L);
                TiebaStatic.log(new StatisticItem("c13016").param("obj_locate", 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nfa a;

        public b(nfa nfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nfaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nfa a;

        public c(nfa nfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nfaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h();
                if (WriteActivityConfig.isAsyncWriting()) {
                    return;
                }
                WriteActivityConfig.newInstance(this.a.a).setType(9).setTitle(this.a.d).setForumId("0").send();
                TiebaStatic.log(new StatisticItem("c13017").param("obj_locate", 1));
            }
        }
    }

    public nfa(MainTabActivity mainTabActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.a = mainTabActivity;
        this.c = (FragmentTabHost) mainTabActivity.findViewById(R.id.obfuscated_res_0x7f09232f);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            bh.c(this.b);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zg.a().removeCallbacks(this.i);
            zg.a().removeCallbacks(this.j);
            g();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public void j(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j)}) == null) && da5.p().r("home_tip", 0L) != j && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            this.d = str2;
            this.e = j;
            if (this.f == null) {
                View inflate = LayoutInflater.from(this.a.getActivity()).inflate(R.layout.tips_blue_twice_line_down, (ViewGroup) null);
                this.f = inflate;
                this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09253f);
                this.h = (TextView) this.f.findViewById(R.id.tips_content);
                this.f.setOnClickListener(this.k);
            }
            this.g.setText(StringHelper.cutHotTopicShow(str, 24, "..."));
            this.h.setText(R.string.topic_join);
            if (this.b == null) {
                PopupWindow popupWindow = new PopupWindow(this.f, -2, -2);
                this.b = popupWindow;
                GreyUtil.grey(popupWindow);
            } else {
                h();
            }
            zg.a().removeCallbacks(this.i);
            zg.a().postDelayed(this.i, 100L);
        }
    }
}
