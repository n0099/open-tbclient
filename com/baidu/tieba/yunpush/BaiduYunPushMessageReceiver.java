package com.baidu.tieba.yunpush;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.push.PushRecevierEvent;
import com.baidu.tieba.da5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.push.PushGeneralData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URISyntaxException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class BaiduYunPushMessageReceiver extends PushMessageReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SHAREDPRE_PUSH_STARTWORK = "baidu_yunpush_start_work";
    public static final String TAG = "BaiduYunPush";
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onDelTags(Context context, int i, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Integer.valueOf(i), list, list2, str}) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onListTags(Context context, int i, List<String> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, context, i, list, str) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationArrived(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, str2, str3) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onSetTags(Context context, int i, List<String> list, List<String> list2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), list, list2, str}) == null) {
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onUnbind(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048586, this, context, i, str) == null) {
        }
    }

    public BaiduYunPushMessageReceiver() {
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

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onBind(Context context, int i, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i), str, str2, str3, str4}) == null) {
            TbLog yunPushLog = YunPushLog.getInstance();
            yunPushLog.i(TAG, "onBind errorCode:" + i + " appid:" + str + " userId:" + str2 + " channelId:" + str3 + " requestId:" + str4);
            if (i == 0) {
                PushManager.setPushBackStatus(TbadkCoreApplication.getInst(), false);
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putBoolean(TbConfig.getVersion() + KEY_SHAREDPRE_PUSH_STARTWORK, true);
                TbadkCoreApplication.getInst().setYunpushChannelId(str3);
            }
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onMessage(Context context, String str, String str2, int i) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048579, this, context, str, str2, i) == null) && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str5 = null;
                if (!jSONObject.isNull("title")) {
                    str3 = jSONObject.getString("title");
                } else {
                    str3 = null;
                }
                if (!jSONObject.isNull("description")) {
                    str4 = jSONObject.getString("description");
                } else {
                    str4 = null;
                }
                if (!jSONObject.isNull("custom_content")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("custom_content"));
                    if (!jSONObject2.isNull("scheme")) {
                        str5 = jSONObject2.getString("scheme");
                    }
                }
                String str6 = "";
                if (!TextUtils.isEmpty(str5) && str5.contains("tbyunpushnotifybody=")) {
                    JSONObject jSONObject3 = new JSONObject(str5.substring(str5.indexOf("tbyunpushnotifybody=") + 20));
                    if (!jSONObject3.isNull("task_id")) {
                        str6 = jSONObject3.getString("task_id");
                    }
                }
                if (!jSONObject.isNull("st_ext")) {
                    PushGeneralData pushGeneralData = new PushGeneralData();
                    pushGeneralData.parseData(jSONObject.optString("st_ext"));
                    PushRecevierEvent pushRecevierEvent = new PushRecevierEvent();
                    pushRecevierEvent.generalData = pushGeneralData;
                    MutiProcessManager.publishEvent(pushRecevierEvent);
                } else if (!da5.O()) {
                    int i2 = JavaTypesHelper.toInt(str6, 2500);
                    if (i2 < 2500) {
                        i2 += 2500;
                    }
                    int i3 = i2;
                    Intent parseUri = Intent.parseUri(str5, 1);
                    parseUri.setFlags(276824064);
                    NotificationHelper.showNotification(context, i3, str3, str4, str4, PendingIntent.getActivity(context, i3, parseUri, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION), false);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onMessage(Context context, String str, String str2, int i, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, str2, Integer.valueOf(i), pushCallBackExtra}) == null) {
            TbLog yunPushLog = YunPushLog.getInstance();
            yunPushLog.i(TAG, "onMessage message:" + str + " customContentString:" + str2 + " notifyId:" + i + " extra:" + pushCallBackExtra);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationArrived(Context context, String str, String str2, String str3, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, context, str, str2, str3, pushCallBackExtra) == null) {
            TbLog yunPushLog = YunPushLog.getInstance();
            yunPushLog.i(TAG, "onNotificationArrived title:" + str + " description:" + str2 + " customContentString:" + str3 + " extra:" + pushCallBackExtra);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationClicked(Context context, String str, String str2, String str3, PushMessageReceiver.PushCallBackExtra pushCallBackExtra) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, str2, str3, pushCallBackExtra) == null) {
            TbLog yunPushLog = YunPushLog.getInstance();
            yunPushLog.i(TAG, "onNotificationClicked title:" + str + " description:" + str2 + " customContentString:" + str3 + " extra:" + pushCallBackExtra);
        }
    }

    @Override // com.baidu.android.pushservice.PushMessageReceiver
    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048583, this, context, str, str2, str3) == null) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String str4 = null;
                if (!jSONObject.isNull("scheme")) {
                    str4 = jSONObject.getString("scheme");
                }
                if (!TextUtils.isEmpty(str4)) {
                    Intent parseUri = Intent.parseUri(str4, 1);
                    parseUri.setFlags(276824064);
                    context.startActivity(parseUri);
                    if (str4.contains("unidispatch/hotuserrank")) {
                        TiebaStatic.log(new StatisticItem("c13662").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                    }
                }
            } catch (URISyntaxException e) {
                BdLog.detailException(e);
            } catch (JSONException e2) {
                BdLog.detailException(e2);
            }
        }
    }
}
