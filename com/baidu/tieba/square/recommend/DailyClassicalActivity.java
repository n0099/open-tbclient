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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
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
import com.tencent.connect.common.Constants;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes6.dex */
public class DailyClassicalActivity extends BaseActivity implements BaseWebView.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DAILY_CLASSICAL = "c/s/tag/gettogether";
    public static long msgID;
    public static boolean pvSign;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRefreshing;
    public ImageView mBack;
    public c mContentAsyncTask;
    public View.OnClickListener mOncClickListener;
    public RelativeLayout mParent;
    public ProgressBar mProgressBar;
    public RelativeLayout mTitle;
    public TextView mTitleText;
    public BaseWebView mWebView;
    public boolean refreshWebview;
    public String requestPage;
    public LinearLayout tagWebViewLayout;
    public TextView webviewCrashTip;
    public TextView webviewFail;
    public boolean webviewSucess;

    /* loaded from: classes6.dex */
    public static class a implements CustomMessageTask.CustomRunnable<DailyClassicalActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DailyClassicalActivity a;

        public b(DailyClassicalActivity dailyClassicalActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dailyClassicalActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dailyClassicalActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.obfuscated_res_0x7f0902ef) {
                    this.a.finish();
                } else if (id == R.id.obfuscated_res_0x7f091ec2) {
                    this.a.refresh();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends BdAsyncTask<Object, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        /* renamed from: b  reason: collision with root package name */
        public String f35997b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DailyClassicalActivity f35998c;

        public c(DailyClassicalActivity dailyClassicalActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dailyClassicalActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35998c = dailyClassicalActivity;
            this.a = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public String doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + DailyClassicalActivity.DAILY_CLASSICAL);
                this.a = netWork;
                netWork.getNetContext().getRequest().getNetWorkParam().mIsJson = false;
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    this.a.addPostData("night_type", "1");
                }
                this.a.addPostData(Config.PACKAGE_NAME, this.f35998c.requestPage);
                this.a.addPostData("_version_more", "1");
                this.a.addPostData(Constants.PARAM_PLATFORM, "android");
                if (DailyClassicalActivity.pvSign) {
                    boolean unused = DailyClassicalActivity.pvSign = false;
                    this.a.addPostData("msg_click", "1");
                    this.a.addPostData("message_id", String.valueOf(DailyClassicalActivity.msgID));
                }
                Address j = c.a.d.f.i.a.n().j(false);
                if (j != null && this.f35998c.getIsLocationOn()) {
                    NetWork netWork2 = this.a;
                    netWork2.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                }
                try {
                    this.f35997b = this.a.postNetData();
                    if (this.a.isNetSuccess()) {
                        return this.f35997b;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f35998c.isRefreshing = false;
                super.cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f35998c.mContentAsyncTask = null;
                this.f35998c.tagWebViewLayout.setOnClickListener(null);
                NetWork netWork = this.a;
                if (netWork == null || !netWork.isNetSuccess() || str == null || str.length() <= 0) {
                    this.f35998c.webviewSucess = false;
                    this.f35998c.webviewFail.setVisibility(0);
                    this.f35998c.mWebView.setVisibility(8);
                    this.f35998c.tagWebViewLayout.setOnClickListener(this.f35998c.mOncClickListener);
                } else {
                    this.f35998c.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, SapiWebView.DATA_MIME_TYPE, IMAudioTransRequest.CHARSET, "");
                    this.f35998c.webviewFail.setVisibility(8);
                    this.f35998c.mWebView.setVisibility(0);
                }
                this.f35998c.refreshWebview = true;
                this.f35998c.onRefreshFinish();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBack = null;
        this.mParent = null;
        this.mTitle = null;
        this.mTitleText = null;
        this.mOncClickListener = null;
        this.mWebView = null;
        this.mProgressBar = null;
        this.tagWebViewLayout = null;
        this.mContentAsyncTask = null;
        this.refreshWebview = false;
        this.webviewSucess = true;
        this.webviewFail = null;
        this.webviewCrashTip = null;
        this.isRefreshing = false;
        this.requestPage = "1";
    }

    private void cancelTask() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || (cVar = this.mContentAsyncTask) == null) {
            return;
        }
        cVar.cancel();
    }

    private boolean createWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            if (this.mWebView == null) {
                try {
                    if (UtilHelper.webViewIsProbablyCorrupt(this)) {
                        super.showToast(getString(R.string.obfuscated_res_0x7f0f154a));
                        return false;
                    }
                    BaseWebView baseWebView = new BaseWebView(this);
                    this.mWebView = baseWebView;
                    SkinManager.setBgColor(baseWebView, TbadkCoreApplication.getInst().getSkinType());
                    this.mWebView.setOnLoadUrlListener(this);
                    this.mWebView.setHorizontalScrollBarEnabled(false);
                    this.mWebView.setHorizontalScrollbarOverlay(false);
                    this.mWebView.setScrollBarStyle(33554432);
                    this.mWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    this.tagWebViewLayout.addView(this.mWebView);
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

    private String getMatchStringFromURL(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, this, str, str2)) == null) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                int length = indexOf + str2.length();
                int i = length;
                while (i < str.length() && str.charAt(i) != '&') {
                    i++;
                }
                return URLDecoder.decode(str.substring(length, i));
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static long getMsgID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? msgID : invokeV.longValue;
    }

    public static boolean getPvSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? pvSign : invokeV.booleanValue;
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            this.mParent = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091647);
            this.mTitle = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f09202b);
            this.mTitleText = (TextView) findViewById(R.id.obfuscated_res_0x7f092059);
            this.tagWebViewLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ec2);
            this.mBack = (ImageView) findViewById(R.id.obfuscated_res_0x7f0902ef);
            this.webviewFail = (TextView) this.tagWebViewLayout.findViewById(R.id.obfuscated_res_0x7f09244f);
            this.webviewCrashTip = (TextView) this.tagWebViewLayout.findViewById(R.id.obfuscated_res_0x7f09244e);
            this.mProgressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091e9b);
            b bVar = new b(this);
            this.mOncClickListener = bVar;
            this.mBack.setOnClickListener(bVar);
            if (createWebView()) {
                this.webviewCrashTip.setVisibility(8);
                refresh();
                return;
            }
            this.webviewCrashTip.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRefreshFinish() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65557, this) == null) && this.refreshWebview) {
            if (!this.webviewSucess) {
                showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c15));
            }
            this.isRefreshing = false;
            this.mProgressBar.setVisibility(8);
        }
    }

    public static void setMsgID(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65558, null, j) == null) {
            msgID = j;
        }
    }

    public static void setPvSign(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            pvSign = z;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public boolean getGpuSwitch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst().isGpuOpen() : invokeV.booleanValue;
    }

    public boolean getIsLocationOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            SkinManager.setBgColor(this.mParent, i);
            SkinManager.setTopBarBgImage(this.mTitle, i);
            SkinManager.setTopBarTitleColor(this.mTitleText, i);
            SkinManager.setTopBarBackBgImage(this.mBack, i);
            BaseWebView baseWebView = this.mWebView;
            if (baseWebView != null) {
                SkinManager.setBgColor(baseWebView, i);
                refresh();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0217);
            initUI();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (TbadkCoreApplication.getInst().getWebviewCrashCount() == 0 && !createWebView()) {
                this.webviewCrashTip.setVisibility(0);
                return;
            }
            this.webviewCrashTip.setVisibility(8);
            if (this.isRefreshing) {
                return;
            }
            this.isRefreshing = true;
            this.mProgressBar.setVisibility(0);
            this.refreshWebview = false;
            this.webviewSucess = true;
            cancelTask();
            c cVar = new c(this, null);
            this.mContentAsyncTask = cVar;
            cVar.setPriority(3);
            this.mContentAsyncTask.execute(new Object[0]);
        }
    }

    public void resetPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.requestPage = "1";
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.d
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, str)) == null) {
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
                        String matchStringFromURL = getMatchStringFromURL(str, "pn=");
                        if (matchStringFromURL != null && matchStringFromURL.length() >= 0) {
                            this.requestPage = matchStringFromURL;
                        }
                    } else {
                        this.requestPage = "1";
                    }
                    refresh();
                    return true;
                }
                c.a.o0.l.a.l(this, str + "&_client_version=" + TbConfig.getVersion());
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
