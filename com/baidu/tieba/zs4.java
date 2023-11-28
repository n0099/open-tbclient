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
import com.baidu.adp.lib.safe.SafeHandler;
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
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.downloadball.DownloadFloatBallManager;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.setting.model.MsgRemindHelper;
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
public class zs4 implements mj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PermissionJudgePolicy a;
    public ur4 b;

    public static /* synthetic */ WebView E(WebView webView) {
        return webView;
    }

    @Override // com.baidu.tieba.mj6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        lj6.a(this, webView, str, jSONObject);
    }

    @Override // com.baidu.tieba.mj6
    public /* synthetic */ void onDestroy() {
        lj6.b(this);
    }

    /* loaded from: classes9.dex */
    public class a extends InsertGalleryAsyncTask.InsertGalleryListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;

        public a(zs4 zs4Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, webView};
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
                nj6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.InsertGalleryListener
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", 0);
                nj6.a().d(this.a, "saveImageSuccess", linkedHashMap);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends ju5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(zs4 zs4Var, WebView webView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, webView, str, str2};
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
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ju5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                da<String> l = b05.l("tb.hybrid_cache");
                if (this.a != null && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && l != null) {
                    return l.get(this.c);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements ot5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ zs4 c;

        public c(zs4 zs4Var, WebView webView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, webView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zs4Var;
            this.a = webView;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ot5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.I(this.a, this.b, str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ HashMap b;

        public d(zs4 zs4Var, WebView webView, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, webView, hashMap};
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
            this.b = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
                nj6.a().d(this.a, "getAppStorageResult", this.b);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends ju5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(zs4 zs4Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zs4Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tieba.ju5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                da<String> l = b05.l("tb.hybrid_cache");
                if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && l != null) {
                    l.g(this.a, this.b);
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    public zs4() {
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

    public gxa x(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048620, this, webView, str, str2, str3)) == null) {
            MsgRemindHelper.d(webView, str, str2, str3);
            return new gxa();
        }
        return (gxa) invokeLLLL.objValue;
    }

    public gxa A(WebView webView) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webView)) == null) {
            gxa gxaVar = new gxa();
            if (Build.VERSION.SDK_INT >= 19) {
                i = NotificationManagerCompat.from(webView.getContext()).areNotificationsEnabled();
            } else {
                i = 1;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa O(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, webView)) == null) {
            gxa gxaVar = new gxa();
            boolean g = pu4.e().f(webView).g();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", g ? 1 : 0);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa q(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, webView)) == null) {
            gxa gxaVar = new gxa();
            JSONArray p = vx6.o().p();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("historyForumArray", p);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa B(WebView webView, String str, String str2, String str3, String str4, int i, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{webView, str, str2, str3, str4, Integer.valueOf(i), str5})) == null) {
            gxa gxaVar = new gxa();
            Context a2 = bj6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    gxaVar.o(jSONObject.toString());
                    return gxaVar;
                } catch (JSONException unused) {
                }
            }
            if (StringUtils.isNotNull(str2)) {
                str = str2;
            }
            String str6 = str + ".v" + str4;
            if (StringUtils.isNotNull(str6)) {
                ItemData itemData = new ItemData();
                itemData.pkgName = str2;
                DownloadData downloadData = new DownloadData(str6);
                downloadData.setItemData(itemData);
                String o = ou4.a(downloadData).o(downloadData);
                if (StringUtils.isNotNull(o)) {
                    AdApkInstallHelper.a(o, downloadData);
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                gxaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa k(WebView webView, String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            gxa gxaVar = new gxa();
            Context a2 = bj6.a(webView.getContext());
            if (a2 == null) {
                a2 = webView.getContext();
            }
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage((Activity) a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    gxaVar.o(jSONObject.toString());
                    return gxaVar;
                } catch (JSONException unused) {
                }
            }
            ItemData itemData = new ItemData();
            itemData.pkgName = str5;
            if (!StringUtils.isNotNull(str5)) {
                str5 = str2;
            }
            DownloadData downloadData = new DownloadData(str5 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            downloadData.setSource(i);
            downloadData.setItemData(itemData);
            ou4.a(downloadData).h(downloadData);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("resultCode", 1);
                gxaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public final boolean C(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, str)) == null) {
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

    public gxa G(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("pkgName", hashMap.get("pkgName"));
                a(webView, CommonTbJsBridge.INSTALL_APK_RESULT, jSONObject);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa L(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", hashMap.get("id"));
                jSONObject.put("resultCode", hashMap.get("resultCode"));
                jSONObject.put("name", hashMap.get("name"));
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa d(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            if (hashMap == null) {
                return gxaVar;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("skin", hashMap.get("skin"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CHANGE_SKIN_TYPE, jSONObject);
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa f(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, webView, str)) == null) {
            gxa gxaVar = new gxa();
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
                gxaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa h(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 1);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(webView, CommonTbJsBridge.CLICK_GO_BACK_TO_H5, jSONObject);
            gxa gxaVar = new gxa();
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa j(WebView webView, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048605, this, webView, i)) == null) {
            gxa gxaVar = new gxa();
            Activity a2 = bj6.a(webView.getContext());
            if (a2 instanceof BaseWebViewActivity) {
                if (i == 0) {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(true);
                } else {
                    ((BaseWebViewActivity) a2).setSwipeBackEnabled(false);
                }
            }
            return gxaVar;
        }
        return (gxa) invokeLI.objValue;
    }

    public gxa n(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048609, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            if (hashMap != null && hashMap.get("result") != null) {
                gxaVar.o(hashMap.get("result"));
                gxaVar.x(hashMap.get("NotificationKey"));
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa r(WebView webView, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048614, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                jSONObject.put("imageUrl", hashMap.get("url"));
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa y(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                if (hashMap.containsKey("key_failed")) {
                    gxaVar.r("权限处理失败");
                }
                gxaVar.o(DataExt.toJson(hashMap));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa D(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, webView)) == null) {
            return new gxa();
        }
        return (gxa) invokeL.objValue;
    }

    public gxa t(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, webView)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("loadUrlTime", webView);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }

    public gxa F(WebView webView, String str, String str2, String str3, int i, String str4) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4})) == null) {
            gxa gxaVar = new gxa();
            boolean startAppByPkgName = UtilHelper.startAppByPkgName(str);
            eu4.b().a(TbadkCoreStatisticKey.KEY_H5_LAUNCH_APK, Integer.toString(i), str2, str3, -1);
            try {
                JSONObject jSONObject = new JSONObject();
                if (startAppByPkgName) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                jSONObject.put("resultCode", i2);
                gxaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa H(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", hashMap.get("status"));
                jSONObject.put("source", hashMap.get("source"));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_STATUS_MSG));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE));
                jSONObject.put(CommonTbJsBridge.FILE_DOWNLOAD_URL, hashMap.get(CommonTbJsBridge.FILE_DOWNLOAD_URL));
                jSONObject.put("fileName", hashMap.get("fileName"));
                jSONObject.put("pkgName", hashMap.get("pkgName"));
                a(webView, CommonTbJsBridge.FILE_DOWNLOAD_STATUS_RESULT, jSONObject);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa s(WebView webView, HashMap<String, List<HashMap>> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, webView, hashMap)) == null) {
            JSONArray jSONArray = null;
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
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
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa z(WebView webView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, webView, str)) == null) {
            gxa gxaVar = new gxa();
            if (this.a == null) {
                this.a = new PermissionJudgePolicy();
            }
            this.a.clearRequestPermissionList();
            Activity a2 = bj6.a(webView.getContext());
            if (a2 == null) {
                gxaVar.p();
                return gxaVar;
            }
            this.a.appendRequestPermission(a2, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.a.startRequestPermission(a2)) {
                gxaVar.r("权限申请");
                return gxaVar;
            }
            new InsertGalleryAsyncTask(a2, str, new a(this, webView)).execute(new String[0]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 0);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public final void I(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, webView, str, str2) == null) {
            int i = !rd.isEmpty(str2) ? 1 : 0;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                jSONObject.put("data", str2);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("result", jSONObject.toString());
                linkedHashMap.put("NotificationKey", str);
                SafeHandler.getInst().post(new d(this, webView, linkedHashMap));
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
    }

    public gxa K(final WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, webView, str, str2)) == null) {
            gxa gxaVar = new gxa();
            Activity a2 = bj6.a(webView.getContext());
            if (this.b == null) {
                this.b = new ur4(new ig6() { // from class: com.baidu.tieba.js4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.ig6, java.util.concurrent.Callable
                    public final Object call() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            WebView webView2 = webView;
                            zs4.E(webView2);
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
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa m(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048608, this, webView, str, str2)) == null) {
            gxa gxaVar = new gxa();
            String str3 = "GetAppStorage_" + System.currentTimeMillis();
            gxaVar.x(str3);
            if ("2".equals(str2)) {
                u(webView, str3, str);
            } else {
                I(webView, str3, SharedPrefHelper.getInstance().getString("key_local_app_storage_" + str, ""));
            }
            return gxaVar;
        }
        return (gxa) invokeLLL.objValue;
    }

    public gxa J(WebView webView, HashMap<String, Object> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, webView, hashMap)) == null) {
            if (hashMap == null) {
                return null;
            }
            gxa gxaVar = new gxa();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("height", hashMap.get("height"));
                jSONObject.put("animationDuration", hashMap.get("animationDuration"));
                jSONObject.put("actionType", hashMap.get("actionType"));
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa N(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, webView, str)) == null) {
            gxa gxaVar = new gxa();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                pu4.e().f(webView).i(str);
                i = 1;
            } else {
                Activity a2 = bj6.a(webView.getContext());
                if (a2 != null) {
                    BdUtilHelper.showToast(a2, (int) R.string.obfuscated_res_0x7f0f0e6f);
                }
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public final String S(WebView webView, String str) {
        int i;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, webView, str)) == null) {
            try {
                pu4.e().h(new JSONObject(str).optString("method_name"));
                if (!pu4.e().f(webView).d()) {
                    pu4.e().f(webView).f();
                }
                i = 1;
            } catch (JSONException e2) {
                e2.printStackTrace();
                i = 0;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", i);
                return jSONObject.toString();
            } catch (JSONException e3) {
                BdLog.e(e3);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public gxa e(WebView webView, String str) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, webView, str)) == null) {
            gxa gxaVar = new gxa();
            if (!StringUtils.isNull(str)) {
                Context a2 = bj6.a(webView.getContext());
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
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa g(WebView webView, int i) {
        InterceptResult invokeLI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048602, this, webView, i)) == null) {
            gxa gxaVar = new gxa();
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921444, Boolean.valueOf(z)));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                gxaVar.o(jSONObject.toString());
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            return gxaVar;
        }
        return (gxa) invokeLI.objValue;
    }

    public gxa v(WebView webView, String str) {
        InterceptResult invokeLL;
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048618, this, webView, str)) == null) {
            gxa gxaVar = new gxa();
            try {
                currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
            }
            if (currentActivity == null) {
                return gxaVar;
            }
            if (TextUtils.equals(str, "notify")) {
                DialogUtil.jumpSystemNotificationSetting(currentActivity);
            } else {
                currentActivity.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + TbadkCoreApplication.getInst().getPackageName())));
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public final void M(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            nu5.b(new e(this, str, str2), null);
        }
    }

    public gxa Q(WebView webView, HashMap<String, Integer> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, webView, hashMap)) == null) {
            gxa gxaVar = new gxa();
            if (hashMap != null && hashMap.get("result").intValue() == -1) {
                gxaVar.r("图片保存错误");
            }
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa i(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, webView, hashMap)) == null) {
            JSONObject jSONObject = new JSONObject();
            a(webView, CommonTbJsBridge.GO_BACK_FROM_NATIVE, jSONObject);
            gxa gxaVar = new gxa();
            gxaVar.o(jSONObject.toString());
            return gxaVar;
        }
        return (gxa) invokeLL.objValue;
    }

    public gxa P(WebView webView, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048590, this, webView, str, str2, str3)) == null) {
            gxa gxaVar = new gxa();
            if ("2".equals(str3)) {
                M(str, str2);
            } else {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putString("key_local_app_storage_" + str, str2);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeLLLL.objValue;
    }

    public gxa R(WebView webView, int i, ArrayList<JSONObject> arrayList) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048592, this, webView, i, arrayList)) == null) {
            gxa gxaVar = new gxa();
            WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
            writeImagesInfo.setMaxImagesAllowed(i);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    JSONObject jSONObject = arrayList.get(i2);
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    try {
                        imageFileInfo.setFilePath(jSONObject.getString("identifier"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
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
                gxaVar.o(jSONObject2.toString());
                return gxaVar;
            } catch (JSONException e3) {
                BdLog.e(e3);
                return gxaVar;
            }
        }
        return (gxa) invokeLIL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gxa T(WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        boolean z;
        Intent launchIntentForPackage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, webView, str, str2)) == null) {
            gxa gxaVar = new gxa();
            List<String> a2 = d85.a();
            Activity a3 = bj6.a(webView.getContext());
            int i = 0;
            try {
                if (C(a2, str2) && a3 != null) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(str2));
                    try {
                        a3.startActivity(intent);
                        z = true;
                    } catch (ActivityNotFoundException unused) {
                    }
                    if (!z && a3 != null && C(a2, str) && (launchIntentForPackage = a3.getPackageManager().getLaunchIntentForPackage(str)) != null) {
                        a3.startActivity(launchIntentForPackage);
                        z = true;
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (z) {
                        i = 1;
                    }
                    jSONObject.put("resultCode", i);
                    gxaVar.o(jSONObject.toString());
                    return gxaVar;
                }
                JSONObject jSONObject2 = new JSONObject();
                if (z) {
                }
                jSONObject2.put("resultCode", i);
                gxaVar.o(jSONObject2.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
            z = false;
            if (!z) {
                a3.startActivity(launchIntentForPackage);
                z = true;
            }
        } else {
            return (gxa) invokeLLL.objValue;
        }
    }

    public gxa U(WebView webView, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, int i2, String str12) {
        InterceptResult invokeCommon;
        String str13;
        String str14;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{webView, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, Integer.valueOf(i), str11, Integer.valueOf(i2), str12})) == null) {
            gxa gxaVar = new gxa();
            Activity a2 = bj6.a(webView.getContext());
            if (a2 != null && !PermissionUtil.checkWriteExternalStorage(a2)) {
                PermissionUtil.requestWriteExternalStorage(a2, 0);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("resultCode", 3);
                    gxaVar.o(jSONObject.toString());
                    return gxaVar;
                } catch (JSONException unused) {
                }
            }
            ItemData itemData = new ItemData();
            itemData.buttonLink = str;
            itemData.buttonName = ItemCardHelper.b;
            itemData.mTitle = str3;
            itemData.pkgName = str11;
            itemData.packageName = str11;
            itemData.mIconUrl = str4;
            itemData.mIconSize = 1.0d;
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
            if (StringUtils.isNotNull(str11)) {
                str13 = str11;
            } else {
                str13 = str3;
            }
            DownloadData downloadData = new DownloadData(str13 + ".v" + str6);
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
            boolean y = ou4.a(downloadData).y(downloadData);
            DownloadFloatBallManager l = DownloadFloatBallManager.l();
            if (webView != null) {
                str14 = webView.getUrl();
            } else {
                str14 = "";
            }
            l.q(y, str, str2, str3, str4, str6, i, str11, i2, str12, str14);
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (y) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                jSONObject2.put("resultCode", i3);
                gxaVar.o(jSONObject2.toString());
            } catch (JSONException unused2) {
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa V(WebView webView, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, JSONObject jSONObject, boolean z7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{webView, str, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6), jSONObject, Boolean.valueOf(z7)})) == null) {
            if ("none".equals(str)) {
                BdUtilHelper.showSoftKeyPad(qu4.a(webView), webView);
            } else if ("aiChat".equals(str)) {
                BdUtilHelper.hideSoftKeyPad(qu4.a(webView), webView);
            } else {
                ht4 ht4Var = new ht4();
                ht4Var.a = str;
                ht4Var.c = z;
                ht4Var.d = z2;
                ht4Var.e = z3;
                ht4Var.f = z4;
                ht4Var.g = z5;
                ht4Var.h = z6;
                ht4Var.b(jSONObject);
                xq6.b().c(new gt4(webView, z7, ht4Var));
            }
            return new gxa();
        }
        return (gxa) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.mj6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048598, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if (CommonTbJsBridge.START_ACCELEROMETER.equals(str2)) {
                jsPromptResult.confirm(S(webView, str3));
                return false;
            } else if (CommonTbJsBridge.GET_APP_STORAGE.equals(str2)) {
                try {
                    jsPromptResult.confirm(m(webView, new JSONObject(str3).optString("key"), "1").a());
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
                return true;
            } else if (CommonTbJsBridge.PUT_APP_STORAGE.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(P(webView, jSONObject.optString("key"), jSONObject.optString("data"), "1").a());
                } catch (JSONException e3) {
                    BdLog.e(e3);
                }
                return true;
            } else if (CommonTbJsBridge.START_LOAD_TIME_INTERVAL.equals(str2)) {
                jsPromptResult.confirm(t(webView).a());
                return true;
            } else {
                return false;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public gxa l(WebView webView, String str, String str2, String str3, int i, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{webView, str, str2, str3, Integer.valueOf(i), str4, str5})) == null) {
            gxa gxaVar = new gxa();
            ItemData itemData = new ItemData();
            itemData.pkgName = str5;
            if (!StringUtils.isNotNull(str5)) {
                str5 = str2;
            }
            DownloadData downloadData = new DownloadData(str5 + ".v" + str3);
            downloadData.setUrl(str);
            downloadData.setName(str2);
            downloadData.setItemData(itemData);
            ou4.a(downloadData).s(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", 1);
                gxaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return gxaVar;
        }
        return (gxa) invokeCommon.objValue;
    }

    public gxa o(WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048610, this, webView, str, str2, str3, str4)) == null) {
            gxa gxaVar = new gxa();
            ItemData itemData = new ItemData();
            itemData.pkgName = str4;
            if (!StringUtils.isNotNull(str4)) {
                str4 = str;
            }
            DownloadData downloadData = new DownloadData(str4 + ".v" + str2);
            downloadData.setName(str);
            downloadData.setItemData(itemData);
            int p = ou4.a(downloadData).p(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", p);
                gxaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return gxaVar;
        }
        return (gxa) invokeLLLLL.objValue;
    }

    public gxa p(WebView webView, String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048612, this, webView, str, str2, str3, str4)) == null) {
            gxa gxaVar = new gxa();
            ItemData itemData = new ItemData();
            itemData.pkgName = str4;
            if (!StringUtils.isNotNull(str4)) {
                str4 = str;
            }
            DownloadData downloadData = new DownloadData(str4 + ".v" + str2);
            downloadData.setName(str);
            downloadData.setItemData(itemData);
            int q = ou4.a(downloadData).q(downloadData);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("resultCode", q);
                gxaVar.o(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return gxaVar;
        }
        return (gxa) invokeLLLLL.objValue;
    }

    public final void u(WebView webView, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048617, this, webView, str, str2) == null) {
            nu5.b(new b(this, webView, str, str2), new c(this, webView, str));
        }
    }

    public gxa w(WebView webView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, webView)) == null) {
            gxa gxaVar = new gxa();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return gxaVar;
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
                gxaVar.o(jSONObject.toString());
                return gxaVar;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return gxaVar;
            }
        }
        return (gxa) invokeL.objValue;
    }
}
