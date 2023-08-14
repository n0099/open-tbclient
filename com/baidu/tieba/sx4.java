package com.baidu.tieba;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.ApkDetail;
/* loaded from: classes8.dex */
public class sx4 implements qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PermissionJudgePolicy a;
    public pw4 b;

    public static /* synthetic */ WebView y(WebView webView) {
        return webView;
    }

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        pk6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.qk6
    public /* synthetic */ void onDestroy() {
        pk6.b(this);
    }

    /* loaded from: classes8.dex */
    public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public a(sx4 sx4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx4Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = webView;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onError(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", -1);
                rk6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", 0);
                rk6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }
    }

    public sx4() {
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

    public kca A(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("pkgName", hashMap.get("pkgName"));
                a(webView, CommonTbJsBridge.INSTALL_APK_RESULT, jSONObject);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca D(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", hashMap.get("id"));
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("name", hashMap.get("name"));
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca c(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            if (hashMap == null) {
                return kcaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CHANGE_SKIN_TYPE, jSONObject);
            kcaVar.o(jSONObject.toString());
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca e(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            kca kcaVar = new kca();
            if (!StringUtils.isNull(str)) {
                if (UtilHelper.isInstalledPackage(webView.getContext(), str)) {
                    i = 1;
                } else {
                    i = 2;
                }
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca g(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, jSONObject);
            kca kcaVar = new kca();
            kcaVar.o(jSONObject.toString());
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca i(WebView webView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, webView, i)) == null) {
            kca kcaVar = new kca();
            Activity a2 = fk6.a(webView.getContext());
            if (a2 instanceof BaseWebViewActivity) {
                if (i == 0) {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(true);
                } else {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(false);
                }
            }
            return kcaVar;
        }
        return (kca) invokeLI.objValue;
    }

    public kca p(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("imageUrl", hashMap.get("url"));
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public final boolean x(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, list, str)) == null) {
            if (!StringUtils.isNull(str) && !ListUtils.isEmpty(list)) {
                for (String str2 : list) {
                    if (str.startsWith(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public kca B(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", hashMap.get("status"));
                jSONObject.put("source", hashMap.get("source"));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_URL, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_URL));
                jSONObject.put("fileName", hashMap.get("fileName"));
                a(webView, CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT, jSONObject);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca q(WebView webView, HashMap<String, List<HashMap>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, webView, hashMap)) == null) {
            JSONArray jSONArray = null;
            if (hashMap == null) {
                return null;
            }
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                List<HashMap> list = hashMap.get("array");
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 < list.size()) {
                        HashMap hashMap2 = list.get(i2);
                        String str = (String) hashMap2.get("url");
                        if (TextUtils.isEmpty(str)) {
                            break;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("identifier", hashMap2.get("identifier"));
                        jSONObject2.put("imageUrl", str);
                        jSONArray2.put(jSONObject2);
                        i2++;
                    } else {
                        i = 1;
                        jSONArray = jSONArray2;
                        break;
                    }
                }
                jSONObject.put("resultCode", i);
                jSONObject.put("imageArray", jSONArray);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca u(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, webView, str)) == null) {
            kca kcaVar = new kca();
            if (this.a == null) {
                this.a = new PermissionJudgePolicy();
            }
            this.a.clearRequestPermissionList();
            Activity a2 = fk6.a(webView.getContext());
            if (a2 == null) {
                kcaVar.p();
                return kcaVar;
            }
            this.a.appendRequestPermission(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.a.startRequestPermission(a2)) {
                kcaVar.r("权限申请");
                return kcaVar;
            }
            new InsertGalleryAsyncTask(a2, str, new a(this, webView)).execute(new String[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca C(final WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, webView, str, str2)) == null) {
            kca kcaVar = new kca();
            Activity a2 = fk6.a(webView.getContext());
            if (this.b == null) {
                this.b = new pw4(new rh6() { // from class: com.baidu.tieba.ex4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.rh6, java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            WebView webView2 = webView;
                            sx4.y(webView2);
                            return webView2;
                        }
                        return invokeV.objValue;
                    }
                });
            }
            ItemCardHelper.w(this.b);
            if (a2 instanceof BdBaseActivity) {
                ItemCardHelper.v(((BdBaseActivity) a2).getUniqueId(), str, str2);
            } else {
                ItemCardHelper.v(null, str, str2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLLL.objValue;
    }

    public kca G(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, webView, str, str2)) == null) {
            kca kcaVar = new kca();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString("key_local_app_storage_" + str, str2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLLL.objValue;
    }

    public kca E(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, webView, str)) == null) {
            kca kcaVar = new kca();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                ez4.e().f(webView).i(str);
                i = 1;
            } else {
                Activity a2 = fk6.a(webView.getContext());
                if (a2 != null) {
                    BdUtilHelper.showToast(a2, (int) R.string.obfuscated_res_0x7f0f0e21);
                }
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public final String J(WebView webView, String str) {
        int i;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, str)) == null) {
            try {
                ez4.e().h(new JSONObject(str).optString("method_name"));
                if (!ez4.e().f(webView).d()) {
                    ez4.e().f(webView).f();
                }
                i = 1;
            } catch (JSONException e) {
                e.printStackTrace();
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            } catch (JSONException e2) {
                BdLog.e(e2);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public kca d(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, webView, str)) == null) {
            kca kcaVar = new kca();
            if (!StringUtils.isNull(str)) {
                Context a2 = fk6.a(webView.getContext());
                if (a2 == null) {
                    a2 = webView.getContext();
                }
                i = UtilHelper.isInstalledPackage(a2, str);
            } else {
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca f(WebView webView, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, webView, i)) == null) {
            kca kcaVar = new kca();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(z)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return kcaVar;
        }
        return (kca) invokeLI.objValue;
    }

    public kca l(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, webView, str)) == null) {
            kca kcaVar = new kca();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            String string = sharedPrefHelper.getString("key_local_app_storage_" + str, "");
            int i = !bi.isEmpty(string) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", string);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeLL.objValue;
    }

    public kca F(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, webView)) == null) {
            kca kcaVar = new kca();
            boolean g = ez4.e().f(webView).g();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", g ? 1 : 0);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeL.objValue;
    }

    public kca o(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, webView)) == null) {
            kca kcaVar = new kca();
            JSONArray o = my6.n().o();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("historyForumArray", o);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeL.objValue;
    }

    public kca v(WebView webView) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, webView)) == null) {
            kca kcaVar = new kca();
            if (Build.VERSION.SDK_INT >= 19) {
                i = NotificationManagerCompat.from(webView.getContext()).areNotificationsEnabled();
            } else {
                i = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeL.objValue;
    }

    public kca H(WebView webView, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, webView, hashMap)) == null) {
            kca kcaVar = new kca();
            if (hashMap != null && hashMap.get("result").intValue() == -1) {
                kcaVar.r("图片保存错误");
            }
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca h(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            a(webView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, jSONObject);
            kca kcaVar = new kca();
            kcaVar.o(jSONObject.toString());
            return kcaVar;
        }
        return (kca) invokeLL.objValue;
    }

    public kca I(WebView webView, int i, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, i, arrayList)) == null) {
            kca kcaVar = new kca();
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.setMaxImagesAllowed(i);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    JSONObject jSONObject = arrayList.get(i2);
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    try {
                        imageFileInfo.setFilePath(jSONObject.getString("identifier"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    writeImagesInfo.addChooseFile(imageFileInfo);
                }
            }
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(TbadkCoreApplication.getInst().getCurrentActivity(), writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.setRequestCode(12017);
            albumFloatActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WEB_VIEW);
            albumFloatActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 6);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setAlbumShowCapture(false);
            albumFloatActivityConfig.setResourceType(0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 0);
                kcaVar.o(jSONObject2.toString());
                return kcaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return kcaVar;
            }
        }
        return (kca) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public kca K(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        boolean z;
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, webView, str, str2)) == null) {
            kca kcaVar = new kca();
            List<String> a2 = yb5.a();
            Activity a3 = fk6.a(webView.getContext());
            int i = 0;
            try {
                if (x(a2, str2) && a3 != null) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(str2));
                    try {
                        a3.startActivity(intent);
                        z = true;
                    } catch (ActivityNotFoundException unused) {
                    }
                    if (!z && a3 != null && x(a2, str) && (launchIntentForPackage = a3.getPackageManager().getLaunchIntentForPackage(str)) != null) {
                        a3.startActivity(launchIntentForPackage);
                        z = true;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        i = 1;
                    }
                    jSONObject.put("resultCode", i);
                    kcaVar.o(jSONObject.toString());
                    return kcaVar;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (z) {
                }
                jSONObject2.put("resultCode", i);
                kcaVar.o(jSONObject2.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
            z = false;
            if (!z) {
                a3.startActivity(launchIntentForPackage);
                z = true;
            }
        } else {
            return (kca) invokeLLL.objValue;
        }
    }

    public kca L(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, int i2, String str12) {
        InterceptResult invokeCommon;
        String str13;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), str11, Integer.valueOf(i2), str12})) == null) {
            kca kcaVar = new kca();
            Activity a2 = fk6.a(webView.getContext());
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage(a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    kcaVar.o(jSONObject.toString());
                    return kcaVar;
                } catch (JSONException unused) {
                }
            }
            bw6 bw6Var = new bw6();
            ItemData itemData = new ItemData();
            itemData.buttonLink = str;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = str3;
            itemData.pkgName = str3;
            itemData.mIconUrl = str4;
            itemData.mIconSize = 1.0d;
            int i3 = 1;
            itemData.buttonLinkType = 1;
            itemData.forumName = str5;
            ApkDetail.Builder builder = new ApkDetail.Builder();
            builder.authority_url = str9;
            builder.developer = str7;
            builder.privacy_url = str8;
            builder.size = str10;
            builder.version = str6;
            builder.version_code = Integer.valueOf(i);
            builder.pkg_source = 2;
            itemData.itemId = JavaTypesHelper.toLong(str2, 0L);
            itemData.apkDetail = builder.build(true);
            bw6Var.a = itemData;
            if (i2 > 0) {
                bw6Var.b = i2;
            } else {
                bw6Var.b = 3;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921627, bw6Var));
            DownloadData downloadData = new DownloadData(str3 + ".v" + str6);
            downloadData.setUrl(str);
            downloadData.setName(str3);
            downloadData.setUniqueId(String.valueOf(itemData.itemId));
            ApkDownloadData apkDownloadData = new ApkDownloadData();
            apkDownloadData.setPackageName(str11);
            downloadData.setApkDownloadData(apkDownloadData);
            if (i2 > 0) {
                downloadData.setSource(i2);
            } else {
                downloadData.setSource(3);
            }
            downloadData.setType(12);
            boolean h = dz4.a().h(downloadData);
            DownloadFloatBallManager k = DownloadFloatBallManager.k();
            if (webView != null) {
                str13 = webView.getUrl();
            } else {
                str13 = "";
            }
            k.p(h, str, str2, str3, str4, str6, i, str11, i2, str12, str13);
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!h) {
                    i3 = 2;
                }
                jSONObject2.put("resultCode", i3);
                kcaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return kcaVar;
        }
        return (kca) invokeCommon.objValue;
    }

    public kca M(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, JSONObject jSONObject, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), jSONObject, Boolean.valueOf(z7)})) == null) {
            if ("none".equals(str)) {
                BdUtilHelper.showSoftKeyPad(fz4.a(webView), webView);
            } else {
                ay4 ay4Var = new ay4();
                ay4Var.a = str;
                ay4Var.c = z;
                ay4Var.d = z2;
                ay4Var.e = z3;
                ay4Var.f = z4;
                ay4Var.g = z5;
                ay4Var.h = z6;
                ay4Var.b(jSONObject);
                sr6.b().b(new zx4(webView, z7, ay4Var));
            }
            return new kca();
        }
        return (kca) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.qk6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048590, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.START_ACCELEROMETER.equals(str2)) {
                jsPromptResult.confirm(J(webView, str3));
                return false;
            } else if (CommonTbJsBridge.GET_APP_STORAGE.equals(str2)) {
                try {
                    jsPromptResult.confirm(l(webView, new JSONObject(str3).optString("key")).a());
                } catch (JSONException e) {
                    BdLog.e(e);
                }
                return true;
            } else if (CommonTbJsBridge.PUT_APP_STORAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(G(webView, jSONObject.optString("key"), jSONObject.optString("data")).a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                return true;
            } else if (CommonTbJsBridge.START_LOAD_TIME_INTERVAL.equals(str2)) {
                jsPromptResult.confirm(r(webView).a());
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public kca j(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            kca kcaVar = new kca();
            Context a2 = fk6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    kcaVar.o(jSONObject.toString());
                    return kcaVar;
                } catch (JSONException unused) {
                }
            }
            DownloadData downloadData = new DownloadData(str2 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            downloadData.setSource(i);
            dz4.a().b(downloadData);
            vy4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_DELETE, Integer.toString(i), str2, str);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                kcaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return kcaVar;
        }
        return (kca) invokeCommon.objValue;
    }

    public kca k(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            kca kcaVar = new kca();
            DownloadData downloadData = new DownloadData(str2 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            dz4.a().f(downloadData);
            vy4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_PAUSE, Integer.toString(i), str2, str);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return kcaVar;
        }
        return (kca) invokeCommon.objValue;
    }

    public kca m(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048601, this, webView, str, str2, str3)) == null) {
            kca kcaVar = new kca();
            DownloadData downloadData = new DownloadData(str + ".v" + str2);
            downloadData.setName(str);
            int d = dz4.a().d(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", d);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return kcaVar;
        }
        return (kca) invokeLLLL.objValue;
    }

    public kca n(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048602, this, webView, str, str2, str3)) == null) {
            kca kcaVar = new kca();
            DownloadData downloadData = new DownloadData(str + ".v" + str2);
            downloadData.setName(str);
            int e = dz4.a().e(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", e);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return kcaVar;
        }
        return (kca) invokeLLLL.objValue;
    }

    public kca r(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, webView)) == null) {
            kca kcaVar = new kca();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loadUrlTime", webView);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeL.objValue;
    }

    public kca s(WebView webView) {
        InterceptResult invokeL;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, webView)) == null) {
            kca kcaVar = new kca();
            try {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            if (currentActivity == null) {
                return kcaVar;
            }
            currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            return kcaVar;
        }
        return (kca) invokeL.objValue;
    }

    public kca t(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, webView)) == null) {
            kca kcaVar = new kca();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return kcaVar;
            }
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) TbadkCoreApplication.getInst().getCurrentActivity(), new WriteImagesInfo().toJsonString(), true);
            albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            albumActivityConfig.setCanEditImage(false);
            albumActivityConfig.getIntent().putExtra("from", AlbumActivityConfig.FROM_WEB_VIEW);
            albumActivityConfig.setResourceType(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                kcaVar.o(jSONObject.toString());
                return kcaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return kcaVar;
            }
        }
        return (kca) invokeL.objValue;
    }

    public kca w(WebView webView, String str, String str2, String str3, String str4, int i, String str5) {
        InterceptResult invokeCommon;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{webView, str, str2, str3, str4, Integer.valueOf(i), str5})) == null) {
            kca kcaVar = new kca();
            Context a2 = fk6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    kcaVar.o(jSONObject.toString());
                    return kcaVar;
                } catch (JSONException unused) {
                }
            }
            if (StringUtils.isNotNull(str + ".v" + str4)) {
                vy4.c().a(str2, str, Integer.toString(i), str3);
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), str6.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            }
            vy4.c().b(TbadkCoreStatisticKey.KEY_H5_INSTALL_APK, Integer.toString(i), str, str3);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                kcaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return kcaVar;
        }
        return (kca) invokeCommon.objValue;
    }

    public kca z(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            kca kcaVar = new kca();
            boolean startAppByPkgName = UtilHelper.startAppByPkgName(str);
            vy4.c().b(TbadkCoreStatisticKey.KEY_H5_LAUNCH_APK, Integer.toString(i), str2, str3);
            try {
                JSONObject jSONObject = new JSONObject();
                if (startAppByPkgName) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                jSONObject.put("resultCode", i2);
                kcaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return kcaVar;
        }
        return (kca) invokeCommon.objValue;
    }
}
