package com.baidu.tieba.square.recommend;

import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.DailyClassicalActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes9.dex */
public class DailyClassicalActivity extends ProxyAdkBaseActivity implements BaseWebView.d {
    public static /* synthetic */ Interceptable $ic;
    public static boolean t;
    public static long u;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f55008e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f55009f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f55010g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55011h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f55012i;
    public BaseWebView j;
    public ProgressBar k;
    public LinearLayout l;
    public c m;
    public boolean n;
    public boolean o;
    public TextView p;
    public TextView q;
    public boolean r;
    public String s;

    /* loaded from: classes9.dex */
    public static class a implements CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<DailyClassicalActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(DailyClassicalActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DailyClassicalActivity f55013e;

        public b(DailyClassicalActivity dailyClassicalActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dailyClassicalActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55013e = dailyClassicalActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.back) {
                    this.f55013e.finish();
                } else if (id == R.id.tag_webview_item) {
                    this.f55013e.y();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55014a;

        /* renamed from: b  reason: collision with root package name */
        public String f55015b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DailyClassicalActivity f55016c;

        public c(DailyClassicalActivity dailyClassicalActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dailyClassicalActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55016c = dailyClassicalActivity;
            this.f55014a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.f55014a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f55016c.r = false;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/s/tag/gettogether");
                this.f55014a = netWork;
                netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.f55014a.addPostData("night_type", "1");
                }
                this.f55014a.addPostData("pn", this.f55016c.s);
                this.f55014a.addPostData("_version_more", "1");
                this.f55014a.addPostData(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
                if (DailyClassicalActivity.t) {
                    boolean unused = DailyClassicalActivity.t = false;
                    this.f55014a.addPostData("msg_click", "1");
                    this.f55014a.addPostData("message_id", String.valueOf(DailyClassicalActivity.u));
                }
                Address j = b.a.e.f.i.a.n().j(false);
                if (j != null && this.f55016c.u()) {
                    NetWork netWork2 = this.f55014a;
                    netWork2.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                }
                try {
                    this.f55015b = this.f55014a.postNetData();
                    if (this.f55014a.isNetSuccess()) {
                        return this.f55015b;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f55016c.m = null;
                this.f55016c.l.setOnClickListener(null);
                NetWork netWork = this.f55014a;
                if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                    this.f55016c.o = false;
                    this.f55016c.p.setVisibility(0);
                    this.f55016c.j.setVisibility(8);
                    this.f55016c.l.setOnClickListener(this.f55016c.f55012i);
                } else {
                    this.f55016c.j.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, "utf-8", "");
                    this.f55016c.p.setVisibility(8);
                    this.f55016c.j.setVisibility(0);
                }
                this.f55016c.n = true;
                this.f55016c.x();
            }
        }

        public /* synthetic */ c(DailyClassicalActivity dailyClassicalActivity, a aVar) {
            this(dailyClassicalActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1394864079, "Lcom/baidu/tieba/square/recommend/DailyClassicalActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1394864079, "Lcom/baidu/tieba/square/recommend/DailyClassicalActivity;");
                return;
            }
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2902021, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public DailyClassicalActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55008e = null;
        this.f55009f = null;
        this.f55010g = null;
        this.f55011h = null;
        this.f55012i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = true;
        this.p = null;
        this.q = null;
        this.r = false;
        this.s = "1";
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            SkinManager.setBgColor(this.f55009f, i2);
            SkinManager.setTopBarBgImage(this.f55010g, i2);
            SkinManager.setTopBarTitleColor(this.f55011h, i2);
            SkinManager.setTopBarBackBgImage(this.f55008e, i2);
            BaseWebView baseWebView = this.j;
            if (baseWebView != null) {
                SkinManager.setBgColor(baseWebView, i2);
                y();
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.day_classical_activity);
            w();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
        }
    }

    public final void s() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (cVar = this.m) == null) {
            return;
        }
        cVar.cancel();
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            int dealOneLinkWithOutJumpWebView = UrlManager.getInstance().dealOneLinkWithOutJumpWebView(getPageContext(), new String[]{str});
            if (dealOneLinkWithOutJumpWebView == 1) {
                finish();
                return true;
            } else if (dealOneLinkWithOutJumpWebView == 0) {
                return true;
            } else {
                if (str.contains("jumptoapp_browser=classic_everyday")) {
                    if (str.contains("pn=")) {
                        String v = v(str, "pn=");
                        if (v != null && v.length() >= 0) {
                            this.s = v;
                        }
                    } else {
                        this.s = "1";
                    }
                    y();
                    return true;
                }
                b.a.q0.m.a.l(this, str + "&_client_version=" + TbConfig.getVersion());
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.j == null) {
                try {
                    if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                        super.showToast(getString(R.string.web_view_corrupted));
                        return false;
                    }
                    BaseWebView baseWebView = new BaseWebView(this);
                    this.j = baseWebView;
                    SkinManager.setBgColor(baseWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.j.setOnLoadUrlListener(this);
                    this.j.setHorizontalScrollBarEnabled(false);
                    this.j.setHorizontalScrollbarOverlay(false);
                    this.j.setScrollBarStyle(33554432);
                    this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.l.addView(this.j);
                    return true;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                int length = indexOf + str2.length();
                int i2 = length;
                while (i2 < str.length() && str.charAt(i2) != '&') {
                    i2++;
                }
                return URLDecoder.decode(str.substring(length, i2));
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f55009f = (RelativeLayout) findViewById(R.id.parent);
            this.f55010g = (RelativeLayout) findViewById(R.id.title);
            this.f55011h = (TextView) findViewById(R.id.title_text);
            this.l = (LinearLayout) findViewById(R.id.tag_webview_item);
            this.f55008e = (ImageView) findViewById(R.id.back);
            this.p = (TextView) this.l.findViewById(R.id.webview_fail);
            this.q = (TextView) this.l.findViewById(R.id.webview_crash_tip);
            this.k = (ProgressBar) findViewById(R.id.tag_progress);
            b bVar = new b(this);
            this.f55012i = bVar;
            this.f55008e.setOnClickListener(bVar);
            if (t()) {
                this.q.setVisibility(8);
                y();
                return;
            }
            this.q.setVisibility(0);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.n) {
            if (!this.o) {
                showToast(getResources().getString(R.string.neterror));
            }
            this.r = false;
            this.k.setVisibility(8);
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !t()) {
                this.q.setVisibility(0);
                return;
            }
            this.q.setVisibility(8);
            if (this.r) {
                return;
            }
            this.r = true;
            this.k.setVisibility(0);
            this.n = false;
            this.o = true;
            s();
            c cVar = new c(this, null);
            this.m = cVar;
            cVar.setPriority(3);
            this.m.execute(new Object[0]);
        }
    }
}
