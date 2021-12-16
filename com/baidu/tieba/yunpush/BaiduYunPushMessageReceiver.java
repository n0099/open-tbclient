package com.baidu.tieba.yunpush;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import c.a.r0.s.g0.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class BaiduYunPushMessageReceiver extends PushMessageReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SHAREDPRE_PUSH_STARTWORK = "baidu_yunpush_start_work";
    public static final String TAG = "BaiduYunPush";
    public transient /* synthetic */ FieldHolder $fh;

    public BaiduYunPushMessageReceiver() {
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

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onBind(Context context, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            String str5 = "onBind errorCode=" + i2;
            if (i2 == 0) {
                b.j().t(TbConfig.getVersion() + KEY_SHAREDPRE_PUSH_STARTWORK, true);
                TbadkCoreApplication.getInst().setYunpushChannelId(str3);
            }
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onDelTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onListTags(Context context, int i2, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i2, list, str) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onMessage(Context context, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048579, this, context, str, str2, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str3 = null;
            String string = !jSONObject.isNull("title") ? jSONObject.getString("title") : null;
            String string2 = !jSONObject.isNull("description") ? jSONObject.getString("description") : null;
            if (!jSONObject.isNull("custom_content")) {
                JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom_content"));
                if (!jSONObject2.isNull("scheme")) {
                    str3 = jSONObject2.getString("scheme");
                }
            }
            String str4 = "";
            if (!TextUtils.isEmpty(str3) && str3.contains(YunPushProxyActivity.PUSH_BODY)) {
                JSONObject jSONObject3 = new JSONObject(str3.substring(str3.indexOf(YunPushProxyActivity.PUSH_BODY) + 20));
                if (!jSONObject3.isNull("task_id")) {
                    str4 = jSONObject3.getString("task_id");
                }
            }
            int e2 = c.a.d.f.m.b.e(str4, 2500);
            if (e2 < 2500) {
                e2 += 2500;
            }
            int i3 = e2;
            Intent parseUri = Intent.parseUri(str3, 1);
            parseUri.setFlags(276824064);
            NotificationHelper.showNotification(context, i3, string, string2, string2, PendingIntent.getActivity(context, i3, parseUri, 134217728), false);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationArrived(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, str2, str3) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, str2, str3) == null) || TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            String string = jSONObject.isNull("scheme") ? null : jSONObject.getString("scheme");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            Intent parseUri = Intent.parseUri(string, 1);
            parseUri.setFlags(276824064);
            context.startActivity(parseUri);
            if (string.contains("unidispatch/hotuserrank")) {
                TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        } catch (URISyntaxException e2) {
            BdLog.detailException(e2);
        } catch (JSONException e3) {
            BdLog.detailException(e3);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onSetTags(Context context, int i2, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i2), list, list2, str}) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onUnbind(Context context, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, context, i2, str) == null) {
        }
    }
}
