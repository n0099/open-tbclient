package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.InsertGalleryAsyncTask;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class xu4 implements vb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ShareItem a;
    public PermissionJudgePolicy b;

    @Override // com.baidu.tieba.vb6
    public /* synthetic */ void a(WebView webView, String str, JSONObject jSONObject) {
        ub6.a(this, webView, str, jSONObject);
    }

    /* loaded from: classes7.dex */
    public class a extends InsertGalleryAsyncTask.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ xu4 c;

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void a(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, str) == null) {
            }
        }

        public a(xu4 xu4Var, int i, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xu4Var, Integer.valueOf(i), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xu4Var;
            this.a = i;
            this.b = context;
        }

        @Override // com.baidu.tbadk.util.InsertGalleryAsyncTask.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && new File(str).exists()) {
                if (this.c.a != null) {
                    this.c.a.k0 = 1;
                    this.c.a.B = str;
                }
                int i = this.a;
                if (i != 0) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b, i, this.c.a, true));
                }
            }
        }
    }

    public xu4() {
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

    public final void d(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareItem) == null) {
            this.a = shareItem;
        }
    }

    @Override // com.baidu.tieba.vb6
    public boolean b(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webView, str, str2, str3, jsPromptResult)) == null) {
            if ("share".equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    jsPromptResult.confirm(e(webView, jSONObject.optInt("channel"), jSONObject.optInt("shareimg"), jSONObject.optString("img"), jSONObject.optString("isShowMoreForum"), jSONObject.optString("url"), jSONObject.optString("title"), jSONObject.optString("desc"), jSONObject.optString("topic"), jSONObject.optString("wbtitle"), jSONObject.optString("wbcontent"), jSONObject.optInt("weixin_disable"), jSONObject.optString("extdata"), jSONObject.optInt("source"), jSONObject.optString("topicid"), jSONObject.optLong("roomId"), jSONObject.optInt("filterRooms"), jSONObject.optInt("roomMemberCount"), jSONObject.optLong("fid"), jSONObject.optString("forumName")).a());
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                    BdLog.e(e);
                    return true;
                }
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public b39 e(WebView webView, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3, String str9, int i4, String str10, long j, int i5, int i6, long j2, String str11) {
        InterceptResult invokeCommon;
        CustomResponsedMessage runTask;
        GroupInfoData groupInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{webView, Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4, str5, str6, str7, str8, Integer.valueOf(i3), str9, Integer.valueOf(i4), str10, Long.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j2), str11})) == null) {
            b39 b39Var = new b39();
            Activity a2 = pb6.a(webView.getContext());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("channel", i);
                jSONObject.put("shareimg", i2);
                jSONObject.put("img", str);
                jSONObject.put("isShowMoreForum", str2);
                jSONObject.put("url", str3);
                jSONObject.put("title", str4);
                jSONObject.put("desc", str5);
                jSONObject.put("topic", str6);
                jSONObject.put("wbtitle", str7);
                jSONObject.put("wbcontent", str8);
                jSONObject.put("weixin_disable", i3);
                jSONObject.put("extdata", str9);
                jSONObject.put("roomId", j);
                jSONObject.put("filterRooms", i5);
                jSONObject.put("roomMemberCount", i6);
                jSONObject.put("fid", j2);
                jSONObject.put("forumName", str11);
            } catch (JSONException e) {
                BdLog.e(e);
            }
            String jSONObject2 = jSONObject.toString();
            int i7 = 1;
            if (!dj.isEmpty(jSONObject2) && (runTask = MessageManager.getInstance().runTask(2016568, ShareItem.class, jSONObject2)) != null) {
                ShareItem shareItem = (ShareItem) runTask.getData();
                if (shareItem != null) {
                    shareItem.I = 17;
                    shareItem.g = true;
                    if (i4 == 1) {
                        shareItem.C0 = str10;
                    }
                }
                if (shareItem != null && (groupInfoData = shareItem.M0) != null && groupInfoData.getGroupId() > 0) {
                    h(a2, shareItem, i5);
                    b39Var.o("");
                    return b39Var;
                } else if ("1".equals(str2) && shareItem != null) {
                    shareItem.A = str;
                    shareItem.x = str3;
                    shareItem.v = str4 + " " + str5;
                    shareItem.q = true;
                    if (i4 == 1) {
                        shareItem.C0 = str10;
                    }
                    ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) a2, shareItem, true, (SparseArray<String>) null);
                    shareDialogConfig.mShowMoreForumShare = true;
                    cf6.c().l(shareDialogConfig);
                    b39Var.o("");
                    return b39Var;
                } else if (i == 0) {
                    if (shareItem != null && !dj.isEmpty(str) && i2 == 1) {
                        d(shareItem);
                        f(a2, str, i);
                    }
                    i(a2, shareItem);
                } else if (shareItem != null && !dj.isEmpty(str) && i2 == 1) {
                    d(shareItem);
                    f(a2, str, i);
                } else {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(a2, i, shareItem, true));
                }
            } else {
                i7 = 0;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("resultCode", i7);
                b39Var.o(jSONObject3.toString());
                return b39Var;
            } catch (JSONException e2) {
                BdLog.e(e2);
                return b39Var;
            }
        }
        return (b39) invokeCommon.objValue;
    }

    public final void f(Context context, String str, int i) {
        Activity currentActivity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048580, this, context, str, i) != null) || (currentActivity = TbadkCoreApplication.getInst().getCurrentActivity()) == null) {
            return;
        }
        if (this.b == null) {
            this.b = new PermissionJudgePolicy();
        }
        this.b.clearRequestPermissionList();
        this.b.appendRequestPermission(currentActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
        if (this.b.startRequestPermission(currentActivity)) {
            return;
        }
        InsertGalleryAsyncTask insertGalleryAsyncTask = new InsertGalleryAsyncTask(currentActivity, str, new a(this, i, context));
        insertGalleryAsyncTask.setFrom(1);
        insertGalleryAsyncTask.execute(new String[0]);
    }

    public b39 g(WebView webView, HashMap hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, webView, hashMap)) == null) {
            int intValue = ((Integer) hashMap.get("shareChannel")).intValue();
            ShareItem shareItem = (ShareItem) hashMap.get("shareItem");
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("title", shareItem.v);
                jSONObject2.put("desc", shareItem.w);
                jSONObject2.put("img", shareItem.z);
                jSONObject2.put("url", shareItem.x);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type", intValue);
                jSONObject3.put("shareData", jSONObject2);
                jSONObject.put("resultCode", 1);
                jSONObject.put("data", jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(webView, CommonTbJsBridge.SHARE_SUCCCESS_NOTIFICATION, jSONObject);
            b39 b39Var = new b39();
            b39Var.o(jSONObject.toString());
            return b39Var;
        }
        return (b39) invokeLL.objValue;
    }

    public void h(Context context, ShareItem shareItem, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048582, this, context, shareItem, i) == null) && shareItem != null && shareItem.M0 != null) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            shareItem.N0 = z;
            shareItem.o0 = true;
            shareItem.R = 11;
            cf6.c().l(new ShareDialogConfig(context, shareItem, true, (SparseArray<String>) null));
            wn7.b(shareItem.M0);
        }
    }

    public void i(Context context, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, context, shareItem) != null) || shareItem == null) {
            return;
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig(context, shareItem, true);
        if (shareItem.k0 != 0) {
            shareDialogConfig.hideMode |= 32;
        }
        shareDialogConfig.setIsSupportNightMode(true);
        shareDialogConfig.setIsCopyLink(true);
        StatisticItem statisticItem = new StatisticItem("c10898");
        statisticItem.param(TiebaStatic.Params.OBJ_URL, shareItem.x);
        statisticItem.param("obj_type", 1);
        TiebaStatic.log(statisticItem);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
    }
}
