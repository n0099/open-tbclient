package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.personCenter.view.AutoDownloadBannerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class t68 extends p16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public RelativeLayout j;
    public TextView k;
    public AutoDownloadBannerView l;
    public List m;
    public bi5 n;
    public TbPageContext o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public long r;
    public wv4 s;
    public d t;

    @Override // com.baidu.tieba.p16
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R.layout.obfuscated_res_0x7f0d0705 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t68 t68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var, Integer.valueOf(i)};
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
            this.a = t68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921742 && this.a.l != null && this.a.l.getCoverFlowView() != null) {
                this.a.l.getCoverFlowView().x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t68 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t68 t68Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var, Integer.valueOf(i)};
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
            this.a = t68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            List list;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (!(data instanceof Intent)) {
                    return;
                }
                String x = this.a.x((Intent) data);
                if (!TextUtils.isEmpty(x) && (list = this.a.m) != null && list.size() != 0) {
                    Iterator it = this.a.m.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ApkDownloadInfoData apkDownloadInfoData = (ApkDownloadInfoData) it.next();
                        if (apkDownloadInfoData != null && apkDownloadInfoData.getApkPackageName() != null && apkDownloadInfoData.getApkPackageName().equals(x) && this.a.n != null && apkDownloadInfoData.getmApkPath() != null && !TextUtils.isEmpty(apkDownloadInfoData.getmApkPath().getAbsolutePath())) {
                            this.a.n.a(apkDownloadInfoData.getmApkPath().getAbsolutePath());
                            break;
                        }
                    }
                    this.a.A(x);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements wv4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t68 a;

        public c(t68 t68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wv4
        /* renamed from: c */
        public void a(int i, boolean z, ApkDownloadInfoData apkDownloadInfoData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), apkDownloadInfoData}) == null) && this.a.l != null && apkDownloadInfoData != null && this.a.l.a(i)) {
                if (z) {
                    Message obtain = Message.obtain();
                    obtain.what = 1;
                    obtain.obj = apkDownloadInfoData.getApkPackageName();
                    this.a.t.removeMessages(1);
                    this.a.t.sendMessageDelayed(obtain, 300L);
                }
                if (System.currentTimeMillis() - this.a.r >= 500) {
                    this.a.r = System.currentTimeMillis();
                    List list = this.a.m;
                    if (list != null && list.size() == 1) {
                        i = 1;
                    }
                    TiebaStatic.log(new StatisticItem("c14966").param("obj_source", apkDownloadInfoData.getmApkName()).param("obj_param1", i));
                    ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(bi5.f);
                    if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null && !TextUtils.isEmpty(apkDownloadInfoData.getAdDownloadBean().p.a)) {
                        v.p(apkDownloadInfoData.getAdDownloadBean().p.a);
                    }
                    i01.b(v);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wv4
        /* renamed from: d */
        public void b(int i, ApkDownloadInfoData apkDownloadInfoData, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), apkDownloadInfoData, Boolean.valueOf(z)}) == null) && apkDownloadInfoData != null && !TextUtils.isEmpty(apkDownloadInfoData.getApkPackageName()) && apkDownloadInfoData.getmApkPath() != null && !TextUtils.isEmpty(apkDownloadInfoData.getmApkPath().getAbsolutePath()) && this.a.l.a(i)) {
                this.a.n.r(apkDownloadInfoData.getApkPackageName(), false);
                this.a.l.getCoverFlowView().x();
                if (this.a.n.j(apkDownloadInfoData.getApkPackageName())) {
                    fj.M(this.a.c, R.string.obfuscated_res_0x7f0f0e89);
                    this.a.A(apkDownloadInfoData.getApkPackageName());
                } else if (!this.a.n.i(apkDownloadInfoData.getmApkPath().getAbsolutePath())) {
                    fj.M(this.a.c, R.string.obfuscated_res_0x7f0f0e88);
                    this.a.A(apkDownloadInfoData.getApkPackageName());
                } else {
                    this.a.n.h(apkDownloadInfoData.getmApkPath().getAbsolutePath());
                    List list = this.a.m;
                    int i2 = 1;
                    if (list != null && list.size() == 1) {
                        i = 1;
                    }
                    if (!z) {
                        i2 = 2;
                    }
                    TiebaStatic.log(new StatisticItem("c14967").param("obj_source", apkDownloadInfoData.getmApkName()).param("obj_param1", i).param("obj_type", i2));
                    ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_CLICK).v(bi5.f);
                    if (z) {
                        v.i(ClogBuilder.Area.INSTALL_NOW_BUTTON);
                    } else {
                        v.i(ClogBuilder.Area.HOTAREA);
                    }
                    if (apkDownloadInfoData.getAdDownloadBean() != null && apkDownloadInfoData.getAdDownloadBean().p != null && !TextUtils.isEmpty(apkDownloadInfoData.getAdDownloadBean().p.a)) {
                        v.p(apkDownloadInfoData.getAdDownloadBean().p.a);
                    }
                    i01.b(v);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t68 a;

        public d(t68 t68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t68Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    this.a.n.r((String) message.obj, false);
                    this.a.l.getCoverFlowView().x();
                }
            }
        }

        public /* synthetic */ d(t68 t68Var, a aVar) {
            this(t68Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t68(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.p = new a(this, 2921742);
        this.q = new b(this, 2002501);
        this.r = -1L;
        this.s = new c(this);
        this.t = new d(this, null);
        this.o = tbPageContext;
        this.i = k();
        int f = fj.f(this.c, R.dimen.M_W_X003);
        this.i.setPadding(f, 0, f, 0);
        this.j = (RelativeLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091c68);
        this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f092405);
        AutoDownloadBannerView autoDownloadBannerView = (AutoDownloadBannerView) this.i.findViewById(R.id.obfuscated_res_0x7f0918d4);
        this.l = autoDownloadBannerView;
        autoDownloadBannerView.getCoverFlowView().setCallback(this.s);
        this.n = bi5.c();
        this.o.registerListener(this.q);
        this.o.registerListener(this.p);
    }

    public final String x(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                return null;
            }
            String[] split = dataString.split(":");
            if (split != null && split.length == 2) {
                return split[1];
            }
            return dataString;
        }
        return (String) invokeL.objValue;
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            for (ApkDownloadInfoData apkDownloadInfoData : this.m) {
                if (apkDownloadInfoData.getApkPackageName().equals(str)) {
                    this.m.remove(apkDownloadInfoData);
                    this.n.l(str);
                    this.l.getCoverFlowView().y(this.m);
                    return;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p16
    /* renamed from: y */
    public void l(m68 m68Var) {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, m68Var) == null) {
            m(this.b, TbadkCoreApplication.getInst().getSkinType());
            if (this.j != null && m68Var != null && (list = m68Var.b) != null && this.l != null && list.size() != 0) {
                List list2 = m68Var.b;
                this.m = list2;
                this.l.c(list2);
                return;
            }
            this.i.setVisibility(8);
        }
    }

    public void B() {
        AutoDownloadBannerView autoDownloadBannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (autoDownloadBannerView = this.l) != null) {
            autoDownloadBannerView.e();
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            bi5 bi5Var = this.n;
            if (bi5Var != null && bi5Var.d()) {
                this.l.getCoverFlowView().u();
            } else {
                B();
            }
        }
    }

    @Override // com.baidu.tieba.p16
    public void m(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) && this.a != i) {
            AutoDownloadBannerView autoDownloadBannerView = this.l;
            if (autoDownloadBannerView != null) {
                autoDownloadBannerView.d(i);
            }
            nv4 d2 = nv4.d(this.j);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
            this.a = i;
        }
    }
}
