package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import androidx.room.RoomMasterTable;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ufosdk.f.i;
import com.baidu.ufosdk.f.k;
import com.baidu.ufosdk.f.p;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.baidu.ufosdk.ui.FeedbackFacePageActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
import com.baidu.webkit.sdk.WebKitFactory;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.tencent.connect.common.Constants;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UfoSDK {
    public static /* synthetic */ Interceptable $ic = null;
    public static String appid = "";
    public static String autoReplyText = "很抱歉没能解答您的问题，不如进入人工反馈，有专业人员为您解答。";
    public static String clientid = "";
    public static boolean contactDialogSwitch = true;
    public static String devid = "";
    public static String firstServerText = "您好，我是智能客服，请描述您的问题或建议。";
    public static long lastSendTime = -1;
    public static boolean localFirstCall = false;
    public static Context mApplication = null;
    public static boolean neverFeedback = false;
    public static String notSolvedReplyText = null;
    public static String productid = "";
    public static boolean robotAnswer = false;
    public static boolean showFeedbackBtn = false;
    public static String solvedReplyText = null;
    public static String startStr = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2616518, "Lcom/baidu/ufosdk/UfoSDK;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2616518, "Lcom/baidu/ufosdk/UfoSDK;");
        }
    }

    public UfoSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void closeRobotAnswer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            robotAnswer = false;
        }
    }

    public static Intent getCaptureScreenAndFeedback(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            Intent intent = new Intent(context, ScreenCapEditActivity.class);
            intent.addFlags(268435456);
            if (str.length() > 0) {
                intent.putExtra("shot", Base64.decode(str, 0));
            }
            intent.putExtra("from_app", true);
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static Intent getCaptureScreenAndFeedback(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, context, str, i2)) == null) {
            Intent captureScreenAndFeedback = getCaptureScreenAndFeedback(context, str);
            if (captureScreenAndFeedback != null) {
                captureScreenAndFeedback.putExtra("extend_feedback_channel", i2);
            }
            return captureScreenAndFeedback;
        }
        return (Intent) invokeLLI.objValue;
    }

    public static HashMap getChineseMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", "找不到相册应用");
            hashMap.put("1", "复制");
            hashMap.put("2", "天以前");
            hashMap.put("3", "删除");
            hashMap.put("4", "删除中...");
            hashMap.put("6", "请描述您遇到的问题");
            hashMap.put("7", "帮助与反馈");
            hashMap.put("8", "常见问题");
            hashMap.put("9", "小时以前");
            hashMap.put("10", "我要反馈");
            hashMap.put("11", "刚刚");
            hashMap.put("12", "请输入反馈内容不少于4个有效字符");
            hashMap.put("13", "正在加载...");
            hashMap.put("14", "分钟以前");
            hashMap.put("15", "个月以前");
            hashMap.put(Constants.VIA_REPORT_TYPE_START_WAP, "输入超过200字");
            hashMap.put(Constants.VIA_REPORT_TYPE_START_GROUP, "我的反馈");
            hashMap.put(Constants.VIA_ACT_TYPE_NINETEEN, "网络不给力，请稍后再试");
            hashMap.put("20", "您还没有反馈");
            hashMap.put("21", "图片过大，请调整上传图片大小");
            hashMap.put(Constants.VIA_REPORT_TYPE_DATALINE, WeiboSdkWebActivity.CHANNEL_DATA_ERROR_ZH_CN);
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "请重新加载网络");
            hashMap.put("24", "发送");
            hashMap.put("25", "发送中...");
            hashMap.put("26", "谢谢支持");
            hashMap.put("27", "字");
            hashMap.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "确认");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, "选填：请留下您的邮箱/手机/QQ号");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, "联系方式不能超过30个字符");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, "请输入反馈内容");
            hashMap.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, "原创视频链接未填写");
            hashMap.put(EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "未上传问题截图");
            hashMap.put("36", "取消");
            hashMap.put("37", "提交");
            hashMap.put("38", "邮箱/手机/QQ");
            hashMap.put("39", "您的反馈将提交我们跟进，请留下您的联系方式。");
            hashMap.put("41", "请留下您的联系方式");
            hashMap.put(RoomMasterTable.DEFAULT_ID, "咨询问题");
            hashMap.put("43", "反馈建议");
            hashMap.put("44", "感谢您的反馈，祝您生活愉快！");
            hashMap.put("46", "上传问题截图");
            hashMap.put("47", "联系方式");
            hashMap.put("48", "问题描述");
            hashMap.put("49", "反馈记录");
            hashMap.put("50", "问题标注");
            hashMap.put("51", "下一步");
            hashMap.put("52", "圈选反馈内容");
            hashMap.put("53", "清除全部选框");
            hashMap.put("54", "图片选择错误，请重新选择一张。");
            hashMap.put(BaseUtils.METHOD_SENDMESSAGE, "内存不足，图片读取失败，请尝试清理内存稍后再试。");
            hashMap.put("56", "截屏文件已保存至SDCard/ufo目录下");
            hashMap.put("57", "提 示");
            hashMap.put("58", "确定要删除此图片吗？");
            hashMap.put("59", "举报成功！我们将尽快处理");
            hashMap.put("60", "已收到您的评价，我会继续努力哒！");
            hashMap.put("61", "请选择遇到的播放问题！");
            hashMap.put("62", "获取数据失败，请重新加载");
            hashMap.put("63", "网络异常，可前往“我的反馈”查看提交结果");
            hashMap.put(WebKitFactory.OS_64, "网络可能开小差了，请尝试重新接入");
            hashMap.put("65", "数据加载失败，请检查网络或重试");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static HashMap getEnglishMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("0", "Failed to find the photo gallery.");
            hashMap.put("1", "Copy");
            hashMap.put("2", " days ago");
            hashMap.put("3", "Delete");
            hashMap.put("4", "Deleting…");
            hashMap.put("6", "Please describe the problems");
            hashMap.put("7", "Help & Feedback");
            hashMap.put("8", "FAQ");
            hashMap.put("9", " hours ago");
            hashMap.put("10", "Feeback");
            hashMap.put("11", "just now");
            hashMap.put("12", "Please input feedback not less than 4 valid characters");
            hashMap.put("13", "Loading…");
            hashMap.put("14", " minutes ago");
            hashMap.put("15", " months ago");
            hashMap.put(Constants.VIA_REPORT_TYPE_START_WAP, "Please don't exceed 200 characters.");
            hashMap.put(Constants.VIA_REPORT_TYPE_START_GROUP, "My Feedback");
            hashMap.put(Constants.VIA_ACT_TYPE_NINETEEN, "Network is not avaiable, please try again later.");
            hashMap.put("20", "You have no current feedback");
            hashMap.put("21", "The picture is oversized, please resize the picture you uploaded.");
            hashMap.put(Constants.VIA_REPORT_TYPE_DATALINE, ActLog.TYPE_RETRY);
            hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "Please try again！");
            hashMap.put("24", "Send");
            hashMap.put("25", "Sending...");
            hashMap.put("26", "Thanks for your feedback");
            hashMap.put("27", " characters");
            hashMap.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "okay");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_USER_FAIL, "option, Email/Tel/QQ");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS, "no more than 30 characters");
            hashMap.put(EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_FAIL, "Feedback");
            hashMap.put(EventType.GiftEventID.LOAD_ALL_GIFT_SUCCESS, "Year");
            hashMap.put(EventType.GiftEventID.LOAD_ALL_GIFT_FAIL, "Month");
            hashMap.put("36", "Cancel");
            hashMap.put("37", "Submit");
            hashMap.put("38", "Email/Tel/QQ");
            hashMap.put("39", "Your feedback will be sent to us, please leave your contact information.");
            hashMap.put("41", "Please leave your contact information");
            hashMap.put(RoomMasterTable.DEFAULT_ID, "Advisory Service");
            hashMap.put("43", "Product Suggestion");
            hashMap.put("44", "Thank you for your feedback, wish you a happy life!");
            hashMap.put("46", "Upload problem screenshots");
            hashMap.put("47", "Contact information");
            hashMap.put("48", "Problem Description");
            hashMap.put("49", "Feedback record");
            hashMap.put("50", "Question mark");
            hashMap.put("51", "Next step");
            hashMap.put("52", "Mark");
            hashMap.put("53", "Clear all");
            hashMap.put("54", "Picture selected error, please reselect.");
            hashMap.put(BaseUtils.METHOD_SENDMESSAGE, "Insufficient memory, image reading failed, please try to clean up the memory and try again later.");
            hashMap.put("56", "Screen shot has been saved in SDCard/ufo");
            hashMap.put("57", "Attention");
            hashMap.put("58", "Make sure to delete this pic?");
            hashMap.put("59", "Report success! We will deal with it as soon as possible.");
            hashMap.put("60", "Has received your evaluation, I will continue to work hard!");
            hashMap.put("61", "Please select the problem you are experiencing!");
            hashMap.put("62", "Failed to get data, please reload");
            hashMap.put("63", "Network is abnormal, you can go to \"My Feedback\" to view the submission result.");
            hashMap.put(WebKitFactory.OS_64, "The network may be off, please try again");
            hashMap.put("65", "Data loading failed, please check the network or try again");
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public static Intent getFeedbackInputIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            Intent intent = new Intent(context, FeedbackInputActivity.class);
            intent.putExtra("currentview", 1);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static Intent getFeedbackInputIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, context, i2)) == null) {
            Intent feedbackInputIntent = getFeedbackInputIntent(context);
            feedbackInputIntent.putExtra("feedback_channel", i2);
            return feedbackInputIntent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent getFeedbackInputIntent(Context context, HashMap hashMap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65547, null, context, hashMap, i2)) == null) {
            setExtraData(hashMap);
            return getFeedbackInputIntent(context, i2);
        }
        return (Intent) invokeLLI.objValue;
    }

    public static Intent getFeedbackListIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? new Intent(context, FeedbackListActivity.class) : (Intent) invokeL.objValue;
    }

    public static Intent getFeedbackListIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i2)) == null) {
            Intent feedbackListIntent = getFeedbackListIntent(context);
            feedbackListIntent.putExtra("feedback_channel", i2);
            return feedbackListIntent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent getFeedbackListIntent(Context context, HashMap hashMap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65550, null, context, hashMap, i2)) == null) {
            setExtraData(hashMap);
            return getFeedbackListIntent(context, i2);
        }
        return (Intent) invokeLLI.objValue;
    }

    public static Intent getFeedbackManualIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? new Intent(context, FeedbackEditActivity.class) : (Intent) invokeL.objValue;
    }

    public static Intent getFeedbackManualIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, context, i2)) == null) {
            Intent feedbackManualIntent = getFeedbackManualIntent(context);
            feedbackManualIntent.putExtra("feedback_channel", i2);
            return feedbackManualIntent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent getFeedbackManualIntent(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, context, str)) == null) {
            if (context == null) {
                return null;
            }
            Intent intent = new Intent(context, FeedbackEditActivity.class);
            if (str.length() > 0) {
                intent.putExtra("shot", Base64.decode(str, 0));
            }
            return intent;
        }
        return (Intent) invokeLL.objValue;
    }

    public static Intent getFeedbackManualIntent(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65554, null, context, str, i2)) == null) {
            if (context == null) {
                return null;
            }
            Intent intent = new Intent(context, FeedbackEditActivity.class);
            if (str.length() > 0) {
                intent.putExtra("shot", Base64.decode(str, 0));
            }
            intent.putExtra("feedback_channel", i2);
            return intent;
        }
        return (Intent) invokeLLI.objValue;
    }

    public static String getFeedbackNoticeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (clientid.length() == 0) {
                return null;
            }
            if (localFirstCall) {
                String myFeekackNum = getMyFeekackNum();
                if (myFeekackNum != null && myFeekackNum.length() != 0 && Integer.parseInt(myFeekackNum) != 0) {
                    neverFeedback = false;
                    SharedPreferences.Editor edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.commit();
                }
                localFirstCall = false;
                SharedPreferences.Editor edit2 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                edit2.putBoolean("UfoLocalFirstCall", false);
                edit2.commit();
            }
            if (neverFeedback) {
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("clientid", clientid);
                hashMap.put("appid", appid);
                hashMap.put("devid", devid);
                hashMap.put("uid", b.f59551d);
                hashMap.put(DpStatConstants.KEY_USER_ID, b.f59551d);
                hashMap.put("username", b.f59549b);
                hashMap.put("output_style", 1);
                hashMap.put("interval", String.valueOf(b.ai));
                String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject(k.b(a3));
                    if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                        return String.valueOf(jSONObject.get("newmsg"));
                    }
                }
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? new Intent(context, FeedbackReportActivity.class) : (Intent) invokeL.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, context, i2)) == null) {
            Intent feedbackReportIntent = getFeedbackReportIntent(context);
            feedbackReportIntent.putExtra("feedback_channel", i2);
            return feedbackReportIntent;
        }
        return (Intent) invokeLI.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65558, null, context, i2, str)) == null) {
            Intent feedbackReportIntent = getFeedbackReportIntent(context);
            feedbackReportIntent.putExtra("feedback_channel", i2);
            feedbackReportIntent.putExtra("app_id", str);
            return feedbackReportIntent;
        }
        return (Intent) invokeLIL.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, ReportCallback reportCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, context, reportCallback)) == null) {
            b.af = reportCallback;
            return new Intent(context, FeedbackReportActivity.class);
        }
        return (Intent) invokeLL.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, ReportCallback reportCallback, HashMap hashMap, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, null, new Object[]{context, reportCallback, hashMap, str, Integer.valueOf(i2)})) == null) {
            if (context == null) {
                return null;
            }
            b.af = reportCallback;
            setExtraData(hashMap);
            Intent intent = new Intent(context, FeedbackReportActivity.class);
            intent.putExtra("feedback_channel", i2);
            if (str.length() > 0) {
                intent.putExtra("shot", Base64.decode(str, 0));
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65561, null, context, hashMap, i2)) == null) {
            setExtraData(hashMap);
            return getFeedbackReportIntent(context, i2);
        }
        return (Intent) invokeLLI.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i2, String str) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65562, null, context, hashMap, i2, str)) == null) {
            setExtraData(hashMap);
            return getFeedbackReportIntent(context, i2, str);
        }
        return (Intent) invokeLLIL.objValue;
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, null, new Object[]{context, hashMap, Integer.valueOf(i2), str, str2})) == null) {
            if (context == null) {
                return null;
            }
            setExtraData(hashMap);
            Intent intent = new Intent(context, FeedbackReportActivity.class);
            intent.putExtra("feedback_channel", i2);
            intent.putExtra("app_id", str);
            if (str2.length() > 0) {
                intent.putExtra("shot", Base64.decode(str2, 0));
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static long getLastSendMessageTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) ? lastSendTime : invokeV.longValue;
    }

    public static String getMyFeekackNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("clientid", clientid);
                hashMap.put("appid", appid);
                hashMap.put("devid", devid);
                hashMap.put("uid", b.f59551d);
                hashMap.put(DpStatConstants.KEY_USER_ID, b.f59551d);
                hashMap.put("username", b.f59549b);
                hashMap.put("interval", String.valueOf(b.ai));
                String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getmsglistcount", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (TextUtils.isEmpty(a3)) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(k.b(a3));
                if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                    return String.valueOf(jSONObject.get("msgnum"));
                }
                return null;
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public static String getNoticeFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            if (clientid.length() == 0) {
                GetNoticeFlagCallBack getNoticeFlagCallBack = b.ae;
                if (getNoticeFlagCallBack != null) {
                    getNoticeFlagCallBack.getNoticeFlagResult(null);
                }
                return null;
            }
            if (localFirstCall) {
                String myFeekackNum = getMyFeekackNum();
                if (myFeekackNum != null && myFeekackNum.length() != 0 && Integer.parseInt(myFeekackNum) != 0) {
                    neverFeedback = false;
                    SharedPreferences.Editor edit = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                    edit.putBoolean("UfoNeverFeedback", false);
                    edit.commit();
                }
                localFirstCall = false;
                SharedPreferences.Editor edit2 = mApplication.getSharedPreferences("UfoSharePreference", 0).edit();
                edit2.putBoolean("UfoLocalFirstCall", false);
                edit2.commit();
            }
            if (neverFeedback) {
                GetNoticeFlagCallBack getNoticeFlagCallBack2 = b.ae;
                if (getNoticeFlagCallBack2 != null) {
                    getNoticeFlagCallBack2.getNoticeFlagResult(null);
                }
                return null;
            }
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("clientid", clientid);
                hashMap.put("appid", appid);
                hashMap.put("devid", devid);
                hashMap.put("uid", b.f59551d);
                hashMap.put(DpStatConstants.KEY_USER_ID, b.f59551d);
                hashMap.put("username", b.f59549b);
                hashMap.put("output_style", 1);
                hashMap.put("interval", String.valueOf(b.ai));
                String a2 = k.a(com.baidu.ufosdk.c.a.a(hashMap));
                String a3 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(a2, "UTF-8"));
                if (!TextUtils.isEmpty(a3)) {
                    JSONObject jSONObject = new JSONObject(k.b(a3));
                    if (((Integer) jSONObject.get("errno")).intValue() == 0) {
                        String valueOf = String.valueOf(jSONObject.get("newmsg"));
                        if (b.ae != null) {
                            b.ae.getNoticeFlagResult(valueOf);
                        }
                        return valueOf;
                    }
                }
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("sendRecord fail.", e2);
            }
            GetNoticeFlagCallBack getNoticeFlagCallBack3 = b.ae;
            if (getNoticeFlagCallBack3 != null) {
                getNoticeFlagCallBack3.getNoticeFlagResult(null);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static void getNoticeFlagInThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            new Thread(new f()).start();
        }
    }

    public static Intent getReplyNewMsgIntent(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65568, null, context, str, str2)) == null) {
            if (context == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.setClass(context, FeedbackInputActivity.class);
            if (TextUtils.isEmpty(str)) {
                str = appid;
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("appid", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("msgid", str2);
            }
            intent.putExtra("fromList", false);
            return intent;
        }
        return (Intent) invokeLLL.objValue;
    }

    public static Intent getStartFaqIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, context)) == null) ? new Intent(context, FeedbackFacePageActivity.class) : (Intent) invokeL.objValue;
    }

    public static Intent getStartFaqIntent(Context context, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65570, null, context, i2, i3)) == null) {
            Intent startFaqIntent = getStartFaqIntent(context);
            startFaqIntent.putExtra("feedback_channel", i2);
            startFaqIntent.putExtra("faq_channel", i3);
            return startFaqIntent;
        }
        return (Intent) invokeLII.objValue;
    }

    public static Intent getStartFaqIntent(Context context, HashMap hashMap, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65571, null, context, hashMap, i2, i3)) == null) {
            setExtraData(hashMap);
            return getStartFaqIntent(context, i2, i3);
        }
        return (Intent) invokeLLII.objValue;
    }

    public static void init(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, null, context) == null) {
            com.baidu.ufosdk.f.c.d("UfoSDK.init 被调用..时间是 -- " + System.currentTimeMillis());
            if (context == null) {
                str = "UfoSDK.init application is null.";
            } else if (mApplication != null) {
                str = "UfoSDK#init called more than once.";
            } else {
                Context applicationContext = context.getApplicationContext();
                mApplication = applicationContext;
                p.a(applicationContext);
                com.baidu.ufosdk.b.e.a(mApplication);
                b.ab = getChineseMap();
                SharedPreferences sharedPreferences = mApplication.getSharedPreferences("UfoSharePreference", 0);
                if (sharedPreferences != null) {
                    clientid = sharedPreferences.getString("UfoClientId", "");
                    appid = sharedPreferences.getString("UfoAppId", "");
                    devid = sharedPreferences.getString("UfoDevId", "");
                    productid = sharedPreferences.getString("UfoProductId", "");
                    lastSendTime = sharedPreferences.getLong("Ufolastsendtime", -1L);
                    neverFeedback = sharedPreferences.getBoolean("UfoNeverFeedback", true);
                    localFirstCall = sharedPreferences.getBoolean("UfoLocalFirstCall", true);
                    String string = sharedPreferences.getString("lastStart", "");
                    startStr = string;
                    String b2 = i.b(System.currentTimeMillis());
                    com.baidu.ufosdk.f.c.c("--UfoSDK:206 -- today : " + b2 + "; lastStart : " + startStr);
                    if (string.contains(b2)) {
                        com.baidu.ufosdk.f.c.c("--UfoSDK:212 -- today : " + b2 + "; lastStart : " + startStr);
                        if (string.equals(b2 + "-enable")) {
                            int i2 = sharedPreferences.getInt("editFeedbackViewUV", 0);
                            int i3 = sharedPreferences.getInt("editFeedbackViewFromRobotUV", 0);
                            int i4 = sharedPreferences.getInt("editFeedbackViewFromFaqUV", 0);
                            int i5 = sharedPreferences.getInt("robotUv", 0);
                            if (i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
                                new Thread(new d(i2, i3, i4, i5)).start();
                            }
                        }
                    } else {
                        int i6 = sharedPreferences.getInt("editFeedbackViewUV", 0);
                        int i7 = sharedPreferences.getInt("editFeedbackViewFromRobotUV", 0);
                        int i8 = sharedPreferences.getInt("editFeedbackViewFromFaqUV", 0);
                        int i9 = sharedPreferences.getInt("robotUv", 0);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean("robotUv_has", false);
                        edit.putBoolean("editFeedbackViewUV_has", false);
                        edit.putBoolean("editFeedbackViewFromFaqUV_has", false);
                        edit.putBoolean("editFeedbackViewFromRobotUV_has", false);
                        edit.commit();
                        com.baidu.ufosdk.f.c.a("--UfoSDK:182 -- edit.commit()");
                        if (i6 == 0 && i7 == 0 && i8 == 0 && i9 == 0) {
                            com.baidu.ufosdk.f.c.a("--UfoSDK:203 -- all zero!!");
                            startStr = b2 + "-enable";
                            edit.putString("lastStart", b2 + "-enable");
                            edit.commit();
                        } else {
                            com.baidu.ufosdk.f.c.a("--UfoSDK:189 -- not all zero!!");
                            new Thread(new c(i6, i7, i8, i9)).start();
                        }
                    }
                    if (clientid.length() == 0) {
                        new Thread(new e()).start();
                        return;
                    }
                    return;
                }
                str = "UfoSDK#sharepreference is null.";
            }
            com.baidu.ufosdk.f.c.d(str);
        }
    }

    public static void isShowFeedbackBtn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65573, null, z) == null) {
            showFeedbackBtn = z;
        }
    }

    public static void openLogcatSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, null) == null) {
            b.f59548a = true;
        }
    }

    public static void openRobotAnswer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, null) == null) {
            robotAnswer = true;
        }
    }

    public static void removeAllCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, null) == null) {
            com.baidu.ufosdk.f.f.a();
            com.baidu.ufosdk.f.f.b();
        }
    }

    public static void setAutoReplyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, str) == null) {
            autoReplyText = str;
        }
    }

    public static void setBackTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65578, null, f2) == null) {
            b.M = f2;
        }
    }

    public static void setBackbtnText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, str) == null) {
            b.f59556i = str;
        }
    }

    public static void setBackbtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65580, null, i2) == null) {
            b.H = i2;
        }
    }

    public static void setBaiduCuid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, str) == null) {
            b.f59550c = str;
        }
    }

    public static void setChatThreadTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65582, null, i2) == null) {
            b.ah = i2;
        }
    }

    public static void setChatViewTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65583, null, f2) == null) {
            b.R = f2;
        }
    }

    public static void setContactDialogSwitch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65584, null, z) == null) {
            contactDialogSwitch = z;
        }
    }

    public static void setCurrentUserIcon(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, null, bitmap) == null) {
            b.f59554g = bitmap;
        }
    }

    public static void setCustomLocation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, str) == null) {
            b.f59555h = str;
        }
    }

    public static void setCustomText(String str, String str2) {
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, str, str2) == null) || (hashMap = b.ab) == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void setCustomText(HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, null, hashMap) == null) {
            b.ab = hashMap;
        }
    }

    public static void setExtraData(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65589, null, map) == null) {
            b.f59553f = com.baidu.ufosdk.c.a.a(map);
        }
    }

    public static void setFaceBottomEntrance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65590, null, i2) == null) {
            b.q = i2;
        }
    }

    public static void setFaceBottomTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65591, null, f2) == null) {
            b.Z = f2;
        }
    }

    public static void setFeedbackDetailsTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65592, null, f2) == null) {
            b.N = f2;
        }
    }

    public static void setFeedbackInputWordCountTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65593, null, f2) == null) {
            b.V = f2;
        }
    }

    public static void setFeedbackPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65594, null, str) == null) {
            b.l = str;
        }
    }

    public static void setFeedbackSubfix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65595, null, str) == null) {
            b.m = str;
        }
    }

    public static void setFirstServerText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65596, null, str) == null) {
            firstServerText = str;
        }
    }

    public static void setGetNoticeFlagCallBack(GetNoticeFlagCallBack getNoticeFlagCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65597, null, getNoticeFlagCallBack) == null) {
            b.ae = getNoticeFlagCallBack;
        }
    }

    public static void setHotProblemTitleSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65598, null, f2) == null) {
            b.S = f2;
        }
    }

    public static void setListBgColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65599, null, i2) == null) {
            b.D = i2;
        }
    }

    public static void setListDeleteTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65600, null, f2) == null) {
            b.Y = f2;
        }
    }

    public static void setListDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65601, null, i2) == null) {
            b.G = i2;
        }
    }

    public static void setListTimeTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65602, null, i2) == null) {
            b.F = i2;
        }
    }

    public static void setListTitleTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65603, null, i2) == null) {
            b.E = i2;
        }
    }

    public static void setListTitleTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65604, null, f2) == null) {
            b.W = f2;
        }
    }

    public static void setLogLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65605, null, i2) == null) {
            b.o = i2;
        }
    }

    public static void setMyFeedbackBtnTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65606, null, f2) == null) {
            b.U = f2;
        }
    }

    public static void setNoHaveFeedbackTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65607, null, f2) == null) {
            b.X = f2;
        }
    }

    public static void setNotSolvedReplyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65608, null, str) == null) {
            notSolvedReplyText = str;
        }
    }

    public static void setPlaceholder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, str) == null) {
            b.n = str;
        }
    }

    public static void setReferer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65610, null, str) == null) {
            b.p = str;
        }
    }

    public static void setReloadBtnTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65611, null, f2) == null) {
            b.P = f2;
        }
    }

    public static void setReloadBtnTxtColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65612, null, i2) == null) {
            b.w = i2;
        }
    }

    public static void setReloadTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65613, null, f2) == null) {
            b.O = f2;
        }
    }

    public static void setReloadTxtColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65614, null, i2) == null) {
            b.x = i2;
        }
    }

    public static void setReportCallBack(ReportCallback reportCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65615, null, reportCallback) == null) {
            b.af = reportCallback;
        }
    }

    public static void setResumeCallBack(ResumeCallBack resumeCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65616, null, resumeCallBack) == null) {
            b.ac = resumeCallBack;
        }
    }

    public static void setRightBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65617, null, i2) == null) {
            b.s = i2;
        }
    }

    public static void setRootBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65618, null, i2) == null) {
            b.z = i2;
        }
    }

    public static void setSentBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65619, null, i2) == null) {
            b.v = i2;
        }
    }

    public static void setSolvedReplyText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65620, null, str) == null) {
            solvedReplyText = str;
        }
    }

    public static void setSubmitMessageCallBack(SubmitMessageCallBack submitMessageCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65621, null, submitMessageCallBack) == null) {
            b.ad = submitMessageCallBack;
        }
    }

    public static void setSubmitNewMessageCallBack(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65622, null, aVar) == null) {
            b.ag = aVar;
        }
    }

    public static void setTabBgTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65623, null, i2) == null) {
            b.u = i2;
        }
    }

    public static void setTabDefultTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65624, null, i2) == null) {
            b.t = i2;
        }
    }

    public static void setTimeViewTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65625, null, f2) == null) {
            b.Q = f2;
        }
    }

    public static void setTitleBarColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65626, null, i2) == null) {
            b.A = i2;
        }
    }

    public static void setTitleHelpAndFeedbackTextSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65627, null, f2) == null) {
            b.T = f2;
        }
    }

    public static void setTitleTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65628, null, i2) == null) {
            b.r = i2;
        }
    }

    public static void setToggleUpTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65629, null, i2) == null) {
            b.J = i2;
        }
    }

    public static void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65630, null, str) == null) {
            b.f59551d = str;
        }
    }

    public static void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65631, null, str) == null) {
            b.f59549b = str;
        }
    }

    public static void setUserStatus(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65632, null, i2) == null) {
            b.f59552e = i2;
        }
    }
}
