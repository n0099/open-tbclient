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
import com.baidu.tieba.util.AdApkInstallHelper;
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
/* loaded from: classes9.dex */
public class yx4 implements tm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PermissionJudgePolicy a;
    public vw4 b;

    public static /* synthetic */ WebView z(WebView webView) {
        return webView;
    }

    @Override // com.baidu.tieba.tm6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        sm6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.tm6
    public /* synthetic */ void onDestroy() {
        sm6.b(this);
    }

    /* loaded from: classes9.dex */
    public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public a(yx4 yx4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yx4Var, webView};
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
                um6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", 0);
                um6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }
    }

    public yx4() {
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

    public mia A(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            mia miaVar = new mia();
            boolean startAppByPkgName = UtilHelper.startAppByPkgName(str);
            dz4.b().a(TbadkCoreStatisticKey.KEY_H5_LAUNCH_APK, Integer.toString(i), str2, str3, -1);
            try {
                JSONObject jSONObject = new JSONObject();
                if (startAppByPkgName) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                jSONObject.put("resultCode", i2);
                miaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }

    public mia B(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, hashMap)) == null) {
            mia miaVar = new mia();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("pkgName", hashMap.get("pkgName"));
                a(webView, CommonTbJsBridge.INSTALL_APK_RESULT, jSONObject);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia D(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            mia miaVar = new mia();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("height", hashMap.get("height"));
                jSONObject.put("animationDuration", hashMap.get("animationDuration"));
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia F(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            mia miaVar = new mia();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", hashMap.get("id"));
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("name", hashMap.get("name"));
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia c(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, hashMap)) == null) {
            mia miaVar = new mia();
            if (hashMap == null) {
                return miaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CHANGE_SKIN_TYPE, jSONObject);
            miaVar.o(jSONObject.toString());
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public mia e(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, webView, str)) == null) {
            mia miaVar = new mia();
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
                miaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public mia g(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, jSONObject);
            mia miaVar = new mia();
            miaVar.o(jSONObject.toString());
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public mia i(WebView webView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, webView, i)) == null) {
            mia miaVar = new mia();
            Activity a2 = im6.a(webView.getContext());
            if (a2 instanceof BaseWebViewActivity) {
                if (i == 0) {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(true);
                } else {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(false);
                }
            }
            return miaVar;
        }
        return (mia) invokeLI.objValue;
    }

    public mia p(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            mia miaVar = new mia();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("imageUrl", hashMap.get("url"));
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public final boolean x(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, list, str)) == null) {
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

    public mia C(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, webView, hashMap)) == null) {
            mia miaVar = new mia();
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
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia q(WebView webView, HashMap<String, List<HashMap>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, webView, hashMap)) == null) {
            JSONArray jSONArray = null;
            if (hashMap == null) {
                return null;
            }
            mia miaVar = new mia();
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
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia u(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, webView, str)) == null) {
            mia miaVar = new mia();
            if (this.a == null) {
                this.a = new PermissionJudgePolicy();
            }
            this.a.clearRequestPermissionList();
            Activity a2 = im6.a(webView.getContext());
            if (a2 == null) {
                miaVar.p();
                return miaVar;
            }
            this.a.appendRequestPermission(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.a.startRequestPermission(a2)) {
                miaVar.r("权限申请");
                return miaVar;
            }
            new InsertGalleryAsyncTask(a2, str, new a(this, webView)).execute(new String[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia E(final WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, webView, str, str2)) == null) {
            mia miaVar = new mia();
            Activity a2 = im6.a(webView.getContext());
            if (this.b == null) {
                this.b = new vw4(new rj6() { // from class: com.baidu.tieba.kx4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.rj6, java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            WebView webView2 = webView;
                            yx4.z(webView2);
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
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLLL.objValue;
    }

    public mia I(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, str, str2)) == null) {
            mia miaVar = new mia();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString("key_local_app_storage_" + str, str2);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLLL.objValue;
    }

    public mia G(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, str)) == null) {
            mia miaVar = new mia();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                oz4.e().f(webView).i(str);
                i = 1;
            } else {
                Activity a2 = im6.a(webView.getContext());
                if (a2 != null) {
                    BdUtilHelper.showToast(a2, (int) R.string.obfuscated_res_0x7f0f0e40);
                }
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public final String L(WebView webView, String str) {
        int i;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, webView, str)) == null) {
            try {
                oz4.e().h(new JSONObject(str).optString("method_name"));
                if (!oz4.e().f(webView).d()) {
                    oz4.e().f(webView).f();
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
    public mia d(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, webView, str)) == null) {
            mia miaVar = new mia();
            if (!StringUtils.isNull(str)) {
                Context a2 = im6.a(webView.getContext());
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
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia f(WebView webView, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048596, this, webView, i)) == null) {
            mia miaVar = new mia();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(z)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                miaVar.o(jSONObject.toString());
            } catch (JSONException e) {
                BdLog.e(e);
            }
            return miaVar;
        }
        return (mia) invokeLI.objValue;
    }

    public mia l(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, webView, str)) == null) {
            mia miaVar = new mia();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            String string = sharedPrefHelper.getString("key_local_app_storage_" + str, "");
            int i = !ei.isEmpty(string) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", string);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeLL.objValue;
    }

    public mia H(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, webView)) == null) {
            mia miaVar = new mia();
            boolean g = oz4.e().f(webView).g();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", g ? 1 : 0);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeL.objValue;
    }

    public mia o(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, webView)) == null) {
            mia miaVar = new mia();
            JSONArray o = e17.n().o();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("historyForumArray", o);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeL.objValue;
    }

    public mia v(WebView webView) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, webView)) == null) {
            mia miaVar = new mia();
            if (Build.VERSION.SDK_INT >= 19) {
                i = NotificationManagerCompat.from(webView.getContext()).areNotificationsEnabled();
            } else {
                i = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeL.objValue;
    }

    public mia J(WebView webView, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, webView, hashMap)) == null) {
            mia miaVar = new mia();
            if (hashMap != null && hashMap.get("result").intValue() == -1) {
                miaVar.r("图片保存错误");
            }
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public mia h(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            a(webView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, jSONObject);
            mia miaVar = new mia();
            miaVar.o(jSONObject.toString());
            return miaVar;
        }
        return (mia) invokeLL.objValue;
    }

    public mia K(WebView webView, int i, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048586, this, webView, i, arrayList)) == null) {
            mia miaVar = new mia();
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
                miaVar.o(jSONObject2.toString());
                return miaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return miaVar;
            }
        }
        return (mia) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public mia M(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        boolean z;
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, webView, str, str2)) == null) {
            mia miaVar = new mia();
            List<String> a2 = pc5.a();
            Activity a3 = im6.a(webView.getContext());
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
                    miaVar.o(jSONObject.toString());
                    return miaVar;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (z) {
                }
                jSONObject2.put("resultCode", i);
                miaVar.o(jSONObject2.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
            z = false;
            if (!z) {
                a3.startActivity(launchIntentForPackage);
                z = true;
            }
        } else {
            return (mia) invokeLLL.objValue;
        }
    }

    public mia N(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, int i2, String str12) {
        InterceptResult invokeCommon;
        String str13;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), str11, Integer.valueOf(i2), str12})) == null) {
            mia miaVar = new mia();
            Activity a2 = im6.a(webView.getContext());
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage(a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    miaVar.o(jSONObject.toString());
                    return miaVar;
                } catch (JSONException unused) {
                }
            }
            ItemData itemData = new ItemData();
            itemData.buttonLink = str;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = str3;
            itemData.pkgName = str3;
            itemData.packageName = str11;
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
            itemData.fileType = "app";
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
            downloadData.setItemData(itemData);
            boolean y = nz4.a(downloadData).y(downloadData);
            DownloadFloatBallManager l = DownloadFloatBallManager.l();
            if (webView != null) {
                str13 = webView.getUrl();
            } else {
                str13 = "";
            }
            l.q(y, str, str2, str3, str4, str6, i, str11, i2, str12, str13);
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!y) {
                    i3 = 2;
                }
                jSONObject2.put("resultCode", i3);
                miaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }

    public mia O(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, JSONObject jSONObject, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), jSONObject, Boolean.valueOf(z7)})) == null) {
            if ("none".equals(str)) {
                BdUtilHelper.showSoftKeyPad(pz4.a(webView), webView);
            } else if ("aiChat".equals(str)) {
                BdUtilHelper.hideSoftKeyPad(pz4.a(webView), webView);
            } else {
                gy4 gy4Var = new gy4();
                gy4Var.a = str;
                gy4Var.c = z;
                gy4Var.d = z2;
                gy4Var.e = z3;
                gy4Var.f = z4;
                gy4Var.g = z5;
                gy4Var.h = z6;
                gy4Var.b(jSONObject);
                hu6.b().b(new fy4(webView, z7, gy4Var));
            }
            return new mia();
        }
        return (mia) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.tm6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048592, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.START_ACCELEROMETER.equals(str2)) {
                jsPromptResult.confirm(L(webView, str3));
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
                    jsPromptResult.confirm(I(webView, jSONObject.optString("key"), jSONObject.optString("data")).a());
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

    public mia j(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            mia miaVar = new mia();
            Context a2 = im6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    miaVar.o(jSONObject.toString());
                    return miaVar;
                } catch (JSONException unused) {
                }
            }
            DownloadData downloadData = new DownloadData(str2 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            downloadData.setSource(i);
            nz4.a(downloadData).h(downloadData);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                miaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }

    public mia k(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            mia miaVar = new mia();
            DownloadData downloadData = new DownloadData(str2 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            nz4.a(downloadData).s(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                miaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }

    public mia m(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048603, this, webView, str, str2, str3)) == null) {
            mia miaVar = new mia();
            DownloadData downloadData = new DownloadData(str + ".v" + str2);
            downloadData.setName(str);
            int p = nz4.a(downloadData).p(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", p);
                miaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return miaVar;
        }
        return (mia) invokeLLLL.objValue;
    }

    public mia n(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048604, this, webView, str, str2, str3)) == null) {
            mia miaVar = new mia();
            DownloadData downloadData = new DownloadData(str + ".v" + str2);
            downloadData.setName(str);
            int q = nz4.a(downloadData).q(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", q);
                miaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return miaVar;
        }
        return (mia) invokeLLLL.objValue;
    }

    public mia r(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, webView)) == null) {
            mia miaVar = new mia();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loadUrlTime", webView);
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeL.objValue;
    }

    public mia y(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, webView)) == null) {
            return new mia();
        }
        return (mia) invokeL.objValue;
    }

    public mia s(WebView webView) {
        InterceptResult invokeL;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, webView)) == null) {
            mia miaVar = new mia();
            try {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            if (currentActivity == null) {
                return miaVar;
            }
            currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            return miaVar;
        }
        return (mia) invokeL.objValue;
    }

    public mia t(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, webView)) == null) {
            mia miaVar = new mia();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return miaVar;
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
                miaVar.o(jSONObject.toString());
                return miaVar;
            } catch (JSONException e) {
                BdLog.e(e);
                return miaVar;
            }
        }
        return (mia) invokeL.objValue;
    }

    public mia w(WebView webView, String str, String str2, String str3, String str4, int i, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{webView, str, str2, str3, str4, Integer.valueOf(i), str5})) == null) {
            mia miaVar = new mia();
            Context a2 = im6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    miaVar.o(jSONObject.toString());
                    return miaVar;
                } catch (JSONException unused) {
                }
            }
            String str6 = str + ".v" + str4;
            if (StringUtils.isNotNull(str6)) {
                DownloadData downloadData = new DownloadData(str6);
                String o = nz4.a(downloadData).o(downloadData);
                if (StringUtils.isNotNull(o)) {
                    AdApkInstallHelper.a(o, downloadData);
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                miaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return miaVar;
        }
        return (mia) invokeCommon.objValue;
    }
}
