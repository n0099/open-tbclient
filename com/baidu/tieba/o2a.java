package com.baidu.tieba;

import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.TbSettingTextTipView;
import com.baidu.tieba.setting.more.AboutActivity;
import com.baidu.tieba.setting.more.SettingTextTestNewView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class o2a extends BdBaseView<AboutActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;
    public static final String w;
    public transient /* synthetic */ FieldHolder $fh;
    public AboutActivity a;
    public long[] b;
    public NavigationBar c;
    public RelativeLayout d;
    public TextView e;
    public SettingTextTestNewView f;
    public ImageView g;
    public TbSettingTextTipView h;
    public TbSettingTextTipView i;
    public TbSettingTextTipView j;
    public TbSettingTextTipView k;
    public TbSettingTextTipView l;
    public TbSettingTextTipView m;
    public TbSettingTextTipView n;
    public TbSettingTextTipView o;
    public TbSettingTextTipView p;
    public TextView q;
    public ProgressBar r;

    /* loaded from: classes7.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o2a o2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                AndroidUtils.copyToClipboard(u2a.a(view2.getContext()));
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r2a a;
        public final /* synthetic */ o2a b;

        public b(o2a o2aVar, r2a r2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o2aVar, r2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o2aVar;
            this.a = r2aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.b.i) {
                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/eula_mobile.html"});
                } else if (view2 == this.b.j) {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<AboutActivity> pageContext = this.b.a.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{o2a.s + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
                } else if (view2 == this.b.k) {
                    UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.b.a.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/secretright.html"}, true);
                    TbSingleton.getInstance().needRefreshForumSquare = true;
                } else if (view2 == this.b.l) {
                    UrlManager urlManager2 = UrlManager.getInstance();
                    TbPageContext<AboutActivity> pageContext2 = this.b.a.getPageContext();
                    urlManager2.dealOneLink(pageContext2, new String[]{o2a.t + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
                } else if (view2 == this.b.m) {
                    if (CurrencySwitchUtil.isYyIsConvert()) {
                        UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/yy/agreement.html"});
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{TbConfig.TIEBA_ADDRESS + "tb/tdou_mobile.html"});
                } else if (view2 == this.b.f) {
                    this.a.a(1);
                } else if (view2 == this.b.h) {
                    this.a.a(2);
                } else if (view2 == this.b.g) {
                    this.a.a(4);
                    System.arraycopy(this.b.b, 1, this.b.b, 0, this.b.b.length - 1);
                    this.b.b[this.b.b.length - 1] = SystemClock.uptimeMillis();
                    if (this.b.b[0] < this.b.b[this.b.b.length - 1] - 2000) {
                        return;
                    }
                    this.b.b = new long[5];
                    this.a.a(6);
                    this.b.X();
                } else if (view2 == this.b.n) {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<AboutActivity> pageContext3 = this.b.a.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{o2a.u + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
                } else if (view2 == this.b.o) {
                    UrlManager urlManager4 = UrlManager.getInstance();
                    TbPageContext<AboutActivity> pageContext4 = this.b.a.getPageContext();
                    urlManager4.dealOneLink(pageContext4, new String[]{o2a.v + ("?curskintype=" + SkinManager.getCurrentSkinTypeString())});
                } else if (view2 == this.b.p) {
                    UrlManager urlManager5 = UrlManager.getInstance();
                    TbPageContext<AboutActivity> pageContext5 = this.b.a.getPageContext();
                    urlManager5.dealOneLink(pageContext5, new String[]{o2a.w + ("?skin=" + SkinManager.getCurrentSkinTypeString())});
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r2a a;
        public final /* synthetic */ o2a b;

        public c(o2a o2aVar, r2a r2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o2aVar, r2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = o2aVar;
            this.a = r2aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (view2 != this.b.g || !TbConfig.ENABLE_VISIT_PREVIEW_SERVER_DIALOG) {
                    return false;
                }
                this.a.a(5);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947981739, "Lcom/baidu/tieba/o2a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947981739, "Lcom/baidu/tieba/o2a;");
                return;
            }
        }
        s = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/privacy-policy";
        t = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/app-permissions";
        u = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/security-check";
        v = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/third-list";
        w = TbConfig.TIEBA_ADDRESS + "tb/mobile/wisemainstatic/text2diagram.html";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o2a(AboutActivity aboutActivity, r2a r2aVar) {
        super(aboutActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aboutActivity, r2aVar};
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
        this.b = new long[5];
        this.a = aboutActivity;
        W();
        V(r2aVar);
    }

    public final void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.findViewById(R.id.obfuscated_res_0x7f091516).setVisibility(i);
        }
    }

    public void T() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (progressBar = this.r) != null) {
            progressBar.setVisibility(0);
        }
    }

    public void U() {
        ProgressBar progressBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (progressBar = this.r) != null) {
            progressBar.setVisibility(8);
        }
    }

    public void Y() {
        SettingTextTestNewView settingTextTestNewView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (settingTextTestNewView = this.f) != null) {
            settingTextTestNewView.i();
        }
    }

    public final void V(r2a r2aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r2aVar) == null) {
            b bVar = new b(this, r2aVar);
            c cVar = new c(this, r2aVar);
            this.f.setOnClickListener(bVar);
            this.h.setOnClickListener(bVar);
            this.i.setOnClickListener(bVar);
            this.j.setOnClickListener(bVar);
            this.k.setOnClickListener(bVar);
            this.l.setOnClickListener(bVar);
            this.m.setOnClickListener(bVar);
            this.n.setOnClickListener(bVar);
            this.o.setOnClickListener(bVar);
            this.p.setOnClickListener(bVar);
            this.g.setOnClickListener(bVar);
            this.g.setOnLongClickListener(cVar);
        }
    }

    public final void W() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d001c);
            this.d = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091a32);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091089);
            NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f17d0));
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092499);
            this.f = (SettingTextTestNewView) this.a.findViewById(R.id.obfuscated_res_0x7f09002a);
            TbSettingTextTipView tbSettingTextTipView = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f090028);
            this.h = tbSettingTextTipView;
            tbSettingTextTipView.c();
            TbSettingTextTipView tbSettingTextTipView2 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09251a);
            this.i = tbSettingTextTipView2;
            tbSettingTextTipView2.c();
            TbSettingTextTipView tbSettingTextTipView3 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092519);
            this.j = tbSettingTextTipView3;
            tbSettingTextTipView3.c();
            TbSettingTextTipView tbSettingTextTipView4 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092518);
            this.k = tbSettingTextTipView4;
            tbSettingTextTipView4.c();
            TbSettingTextTipView tbSettingTextTipView5 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f092517);
            this.l = tbSettingTextTipView5;
            tbSettingTextTipView5.c();
            this.m = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f09251b);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.m.setText(R.string.obfuscated_res_0x7f0f18ed);
            } else {
                this.m.setText(R.string.obfuscated_res_0x7f0f1619);
            }
            this.m.c();
            TbSettingTextTipView tbSettingTextTipView6 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091c43);
            this.n = tbSettingTextTipView6;
            tbSettingTextTipView6.c();
            TbSettingTextTipView tbSettingTextTipView7 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f0924cc);
            this.o = tbSettingTextTipView7;
            tbSettingTextTipView7.c();
            TbSettingTextTipView tbSettingTextTipView8 = (TbSettingTextTipView) this.a.findViewById(R.id.obfuscated_res_0x7f091c75);
            this.p = tbSettingTextTipView8;
            tbSettingTextTipView8.c();
            this.r = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f090029);
            String version = TbConfig.getVersion();
            if (TbConfig.getVersionType() == 1 && !bi.isEmpty(TbConfig.getSubVersion())) {
                version = version + "." + TbConfig.getSubVersion();
            }
            String str3 = this.a.getPageContext().getString(TbadkCoreApplication.getInst().getApplicationInfo().labelRes) + this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f1375) + " " + version;
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("(");
                if (sh.a()) {
                    str = "64";
                } else {
                    str = PayUVEventType.PAY_SPLIT_ORDER_CLOSE_BTN_CLICK;
                }
                sb.append(str);
                if (sh.b()) {
                    str2 = "s";
                } else {
                    str2 = "u";
                }
                sb.append(str2);
                sb.append(SmallTailInfo.EMOTION_SUFFIX);
                String sb2 = sb.toString();
                SpannableString spannableString = new SpannableString(sb2);
                spannableString.setSpan(new AbsoluteSizeSpan(10, true), sb2.length() - 5, sb2.length(), 33);
                this.e.setText(spannableString);
            } else {
                this.e.setText(str3);
            }
            this.q = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f092498);
            a0(TbadkCoreApplication.getInst().getSkinType());
            this.h.setVisibility(8);
            if (SharedPrefHelper.getInstance().getBoolean("debug_plugin_switcher", false)) {
                Z(0);
            }
            this.q.setOnLongClickListener(new a(this));
        }
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && GlobalBuildConfig.isFlutterPerfTool()) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "ToolsSwitchPage", new HashMap())));
        }
    }

    public void a0(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
            this.c.onChangeSkinType(getPageContext(), i);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.d);
            Y();
        }
    }
}
