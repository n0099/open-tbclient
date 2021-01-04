package com.baidu.ufosdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.ufosdk.f.i;
import com.baidu.ufosdk.f.k;
import com.baidu.ufosdk.f.p;
import com.baidu.ufosdk.screencapedt.ScreenCapEditActivity;
import com.baidu.ufosdk.ui.FeedbackEditActivity;
import com.baidu.ufosdk.ui.FeedbackFacePageActivity;
import com.baidu.ufosdk.ui.FeedbackInputActivity;
import com.baidu.ufosdk.ui.FeedbackListActivity;
import com.baidu.ufosdk.ui.FeedbackReportActivity;
import com.tencent.connect.common.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class UfoSDK {
    public static boolean localFirstCall;
    private static Context mApplication;
    public static boolean neverFeedback;
    public static String notSolvedReplyText;
    public static String solvedReplyText;
    public static String clientid = "";
    public static String appid = "";
    public static String devid = "";
    public static String productid = "";
    public static long lastSendTime = -1;
    public static boolean robotAnswer = false;
    public static boolean contactDialogSwitch = true;
    public static boolean showFeedbackBtn = false;
    public static String firstServerText = "您好，我是智能客服，请描述您的问题或建议。";
    public static String autoReplyText = "很抱歉没能解答您的问题，不如进入人工反馈，有专业人员为您解答。";
    public static String startStr = "";

    public static void closeRobotAnswer() {
        robotAnswer = false;
    }

    public static Intent getCaptureScreenAndFeedback(Context context, String str) {
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

    public static Intent getCaptureScreenAndFeedback(Context context, String str, int i) {
        Intent captureScreenAndFeedback = getCaptureScreenAndFeedback(context, str);
        if (captureScreenAndFeedback != null) {
            captureScreenAndFeedback.putExtra("extend_feedback_channel", i);
        }
        return captureScreenAndFeedback;
    }

    public static HashMap getChineseMap() {
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
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "我要反馈");
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "刚刚");
        hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "请输入反馈内容不少于4个有效字符");
        hashMap.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "正在加载...");
        hashMap.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "分钟以前");
        hashMap.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "个月以前");
        hashMap.put(Constants.VIA_REPORT_TYPE_START_WAP, "输入超过200字");
        hashMap.put(Constants.VIA_REPORT_TYPE_START_GROUP, "我的反馈");
        hashMap.put(Constants.VIA_ACT_TYPE_NINETEEN, "网络不给力，请稍后再试");
        hashMap.put("20", "您还没有反馈");
        hashMap.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "图片过大，请调整上传图片大小");
        hashMap.put(Constants.VIA_REPORT_TYPE_DATALINE, "重新加载");
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "请重新加载网络");
        hashMap.put(SoUtils.SO_EVENT_ID_DEFAULT, "发送");
        hashMap.put(SoUtils.SO_EVENT_ID_NEW_SO, "发送中...");
        hashMap.put(SoUtils.SO_EVENT_ID_V8_SO, "谢谢支持");
        hashMap.put("27", "字");
        hashMap.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "确认");
        hashMap.put("31", "选填：请留下您的邮箱/手机/QQ号");
        hashMap.put("32", "联系方式不能超过30个字符");
        hashMap.put("33", "请输入反馈内容");
        hashMap.put("34", "原创视频链接未填写");
        hashMap.put("35", "未上传问题截图");
        hashMap.put("36", PayHelper.STATUS_CANCEL_DESC);
        hashMap.put(PayConfig.PAYMENT_POS_KEY_MANGA, "提交");
        hashMap.put("38", "邮箱/手机/QQ");
        hashMap.put("39", "您的反馈将提交我们跟进，请留下您的联系方式。");
        hashMap.put("41", "请留下您的联系方式");
        hashMap.put("42", "咨询问题");
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
        hashMap.put("64", "网络可能开小差了，请尝试重新接入");
        hashMap.put("65", "数据加载失败，请检查网络或重试");
        return hashMap;
    }

    public static HashMap getEnglishMap() {
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
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, "Feeback");
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "just now");
        hashMap.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "Please input feedback not less than 4 valid characters");
        hashMap.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, "Loading…");
        hashMap.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, " minutes ago");
        hashMap.put(Constants.VIA_REPORT_TYPE_WPA_STATE, " months ago");
        hashMap.put(Constants.VIA_REPORT_TYPE_START_WAP, "Please don't exceed 200 characters.");
        hashMap.put(Constants.VIA_REPORT_TYPE_START_GROUP, "My Feedback");
        hashMap.put(Constants.VIA_ACT_TYPE_NINETEEN, "Network is not avaiable, please try again later.");
        hashMap.put("20", "You have no current feedback");
        hashMap.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, "The picture is oversized, please resize the picture you uploaded.");
        hashMap.put(Constants.VIA_REPORT_TYPE_DATALINE, "Retry");
        hashMap.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "Please try again！");
        hashMap.put(SoUtils.SO_EVENT_ID_DEFAULT, "Send");
        hashMap.put(SoUtils.SO_EVENT_ID_NEW_SO, "Sending...");
        hashMap.put(SoUtils.SO_EVENT_ID_V8_SO, "Thanks for your feedback");
        hashMap.put("27", " characters");
        hashMap.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "okay");
        hashMap.put("31", "option, Email/Tel/QQ");
        hashMap.put("32", "no more than 30 characters");
        hashMap.put("33", "Feedback");
        hashMap.put("34", "Year");
        hashMap.put("35", "Month");
        hashMap.put("36", "Cancel");
        hashMap.put(PayConfig.PAYMENT_POS_KEY_MANGA, "Submit");
        hashMap.put("38", "Email/Tel/QQ");
        hashMap.put("39", "Your feedback will be sent to us, please leave your contact information.");
        hashMap.put("41", "Please leave your contact information");
        hashMap.put("42", "Advisory Service");
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
        hashMap.put("64", "The network may be off, please try again");
        hashMap.put("65", "Data loading failed, please check the network or try again");
        return hashMap;
    }

    public static Intent getFeedbackInputIntent(Context context) {
        Intent intent = new Intent(context, FeedbackInputActivity.class);
        intent.putExtra("currentview", 1);
        return intent;
    }

    public static Intent getFeedbackInputIntent(Context context, int i) {
        Intent feedbackInputIntent = getFeedbackInputIntent(context);
        feedbackInputIntent.putExtra("feedback_channel", i);
        return feedbackInputIntent;
    }

    public static Intent getFeedbackInputIntent(Context context, HashMap hashMap, int i) {
        setExtraData(hashMap);
        return getFeedbackInputIntent(context, i);
    }

    public static Intent getFeedbackListIntent(Context context) {
        return new Intent(context, FeedbackListActivity.class);
    }

    public static Intent getFeedbackListIntent(Context context, int i) {
        Intent feedbackListIntent = getFeedbackListIntent(context);
        feedbackListIntent.putExtra("feedback_channel", i);
        return feedbackListIntent;
    }

    public static Intent getFeedbackListIntent(Context context, HashMap hashMap, int i) {
        setExtraData(hashMap);
        return getFeedbackListIntent(context, i);
    }

    public static Intent getFeedbackManualIntent(Context context) {
        return new Intent(context, FeedbackEditActivity.class);
    }

    public static Intent getFeedbackManualIntent(Context context, int i) {
        Intent feedbackManualIntent = getFeedbackManualIntent(context);
        feedbackManualIntent.putExtra("feedback_channel", i);
        return feedbackManualIntent;
    }

    public static Intent getFeedbackManualIntent(Context context, String str) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(context, FeedbackEditActivity.class);
        if (str.length() > 0) {
            intent.putExtra("shot", Base64.decode(str, 0));
            return intent;
        }
        return intent;
    }

    public static Intent getFeedbackManualIntent(Context context, String str, int i) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(context, FeedbackEditActivity.class);
        if (str.length() > 0) {
            intent.putExtra("shot", Base64.decode(str, 0));
        }
        intent.putExtra("feedback_channel", i);
        return intent;
    }

    public static String getFeedbackNoticeFlag() {
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
            hashMap.put("uid", b.d);
            hashMap.put(DpStatConstants.KEY_USER_ID, b.d);
            hashMap.put("username", b.f5638b);
            hashMap.put("output_style", 1);
            hashMap.put("interval", String.valueOf(b.ai));
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(k.b(a2));
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    return String.valueOf(jSONObject.get("newmsg"));
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
        }
        return null;
    }

    public static Intent getFeedbackReportIntent(Context context) {
        return new Intent(context, FeedbackReportActivity.class);
    }

    public static Intent getFeedbackReportIntent(Context context, int i) {
        Intent feedbackReportIntent = getFeedbackReportIntent(context);
        feedbackReportIntent.putExtra("feedback_channel", i);
        return feedbackReportIntent;
    }

    public static Intent getFeedbackReportIntent(Context context, int i, String str) {
        Intent feedbackReportIntent = getFeedbackReportIntent(context);
        feedbackReportIntent.putExtra("feedback_channel", i);
        feedbackReportIntent.putExtra("app_id", str);
        return feedbackReportIntent;
    }

    public static Intent getFeedbackReportIntent(Context context, ReportCallback reportCallback) {
        b.af = reportCallback;
        return new Intent(context, FeedbackReportActivity.class);
    }

    public static Intent getFeedbackReportIntent(Context context, ReportCallback reportCallback, HashMap hashMap, String str, int i) {
        if (context == null) {
            return null;
        }
        b.af = reportCallback;
        setExtraData(hashMap);
        Intent intent = new Intent(context, FeedbackReportActivity.class);
        intent.putExtra("feedback_channel", i);
        if (str.length() > 0) {
            intent.putExtra("shot", Base64.decode(str, 0));
            return intent;
        }
        return intent;
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i) {
        setExtraData(hashMap);
        return getFeedbackReportIntent(context, i);
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i, String str) {
        setExtraData(hashMap);
        return getFeedbackReportIntent(context, i, str);
    }

    public static Intent getFeedbackReportIntent(Context context, HashMap hashMap, int i, String str, String str2) {
        if (context == null) {
            return null;
        }
        setExtraData(hashMap);
        Intent intent = new Intent(context, FeedbackReportActivity.class);
        intent.putExtra("feedback_channel", i);
        intent.putExtra("app_id", str);
        if (str2.length() > 0) {
            intent.putExtra("shot", Base64.decode(str2, 0));
            return intent;
        }
        return intent;
    }

    public static long getLastSendMessageTime() {
        return lastSendTime;
    }

    private static String getMyFeekackNum() {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", clientid);
            hashMap.put("appid", appid);
            hashMap.put("devid", devid);
            hashMap.put("uid", b.d);
            hashMap.put(DpStatConstants.KEY_USER_ID, b.d);
            hashMap.put("username", b.f5638b);
            hashMap.put("interval", String.valueOf(b.ai));
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=getmsglistcount", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(k.b(a2));
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    return String.valueOf(jSONObject.get("msgnum"));
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getNoticeFlag() {
        if (clientid.length() == 0) {
            if (b.ae != null) {
                b.ae.getNoticeFlagResult(null);
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
            if (b.ae != null) {
                b.ae.getNoticeFlagResult(null);
            }
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("clientid", clientid);
            hashMap.put("appid", appid);
            hashMap.put("devid", devid);
            hashMap.put("uid", b.d);
            hashMap.put(DpStatConstants.KEY_USER_ID, b.d);
            hashMap.put("username", b.f5638b);
            hashMap.put("output_style", 1);
            hashMap.put("interval", String.valueOf(b.ai));
            String a2 = com.baidu.ufosdk.e.b.a("https://ufosdk.baidu.com/?m=Index&a=newmsgnotice", "sdk_encrypt=" + URLEncoder.encode(k.a(com.baidu.ufosdk.c.a.a(hashMap)), "UTF-8"));
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject = new JSONObject(k.b(a2));
                if (((Integer) jSONObject.get(BaseJsonData.TAG_ERRNO)).intValue() == 0) {
                    String valueOf = String.valueOf(jSONObject.get("newmsg"));
                    if (b.ae != null) {
                        b.ae.getNoticeFlagResult(valueOf);
                        return valueOf;
                    }
                    return valueOf;
                }
            }
        } catch (Exception e) {
            com.baidu.ufosdk.f.c.a("sendRecord fail.", e);
        }
        if (b.ae != null) {
            b.ae.getNoticeFlagResult(null);
        }
        return null;
    }

    public static void getNoticeFlagInThread() {
        new Thread(new f()).start();
    }

    public static Intent getReplyNewMsgIntent(Context context, String str, String str2) {
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

    public static Intent getStartFaqIntent(Context context) {
        return new Intent(context, FeedbackFacePageActivity.class);
    }

    public static Intent getStartFaqIntent(Context context, int i, int i2) {
        Intent startFaqIntent = getStartFaqIntent(context);
        startFaqIntent.putExtra("feedback_channel", i);
        startFaqIntent.putExtra("faq_channel", i2);
        return startFaqIntent;
    }

    public static Intent getStartFaqIntent(Context context, HashMap hashMap, int i, int i2) {
        setExtraData(hashMap);
        return getStartFaqIntent(context, i, i2);
    }

    public static void init(Context context) {
        com.baidu.ufosdk.f.c.d("UfoSDK.init 被调用..时间是 -- " + System.currentTimeMillis());
        if (context == null) {
            com.baidu.ufosdk.f.c.d("UfoSDK.init application is null.");
        } else if (mApplication != null) {
            com.baidu.ufosdk.f.c.d("UfoSDK#init called more than once.");
        } else {
            Context applicationContext = context.getApplicationContext();
            mApplication = applicationContext;
            p.a(applicationContext);
            com.baidu.ufosdk.b.e.a(mApplication);
            b.ab = getChineseMap();
            SharedPreferences sharedPreferences = mApplication.getSharedPreferences("UfoSharePreference", 0);
            if (sharedPreferences == null) {
                com.baidu.ufosdk.f.c.d("UfoSDK#sharepreference is null.");
                return;
            }
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
                    int i = sharedPreferences.getInt("editFeedbackViewUV", 0);
                    int i2 = sharedPreferences.getInt("editFeedbackViewFromRobotUV", 0);
                    int i3 = sharedPreferences.getInt("editFeedbackViewFromFaqUV", 0);
                    int i4 = sharedPreferences.getInt("robotUv", 0);
                    if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                        new Thread(new d(i, i2, i3, i4)).start();
                    }
                }
            } else {
                int i5 = sharedPreferences.getInt("editFeedbackViewUV", 0);
                int i6 = sharedPreferences.getInt("editFeedbackViewFromRobotUV", 0);
                int i7 = sharedPreferences.getInt("editFeedbackViewFromFaqUV", 0);
                int i8 = sharedPreferences.getInt("robotUv", 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("robotUv_has", false);
                edit.putBoolean("editFeedbackViewUV_has", false);
                edit.putBoolean("editFeedbackViewFromFaqUV_has", false);
                edit.putBoolean("editFeedbackViewFromRobotUV_has", false);
                edit.commit();
                com.baidu.ufosdk.f.c.a("--UfoSDK:182 -- edit.commit()");
                if (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
                    com.baidu.ufosdk.f.c.a("--UfoSDK:203 -- all zero!!");
                    startStr = b2 + "-enable";
                    edit.putString("lastStart", b2 + "-enable");
                    edit.commit();
                } else {
                    com.baidu.ufosdk.f.c.a("--UfoSDK:189 -- not all zero!!");
                    new Thread(new c(i5, i6, i7, i8)).start();
                }
            }
            if (clientid.length() == 0) {
                new Thread(new e()).start();
            }
        }
    }

    public static void isShowFeedbackBtn(boolean z) {
        showFeedbackBtn = z;
    }

    public static void openLogcatSwitch() {
        b.f5637a = true;
    }

    public static void openRobotAnswer() {
        robotAnswer = true;
    }

    public static void removeAllCache() {
        com.baidu.ufosdk.f.f.a();
        com.baidu.ufosdk.f.f.b();
    }

    public static void setAutoReplyText(String str) {
        autoReplyText = str;
    }

    public static void setBackTextSize(float f) {
        b.M = f;
    }

    public static void setBackbtnText(String str) {
        b.i = str;
    }

    public static void setBackbtnTextColor(int i) {
        b.H = i;
    }

    public static void setBaiduCuid(String str) {
        b.c = str;
    }

    public static void setChatThreadTime(int i) {
        b.ah = i;
    }

    public static void setChatViewTextSize(float f) {
        b.R = f;
    }

    public static void setContactDialogSwitch(boolean z) {
        contactDialogSwitch = z;
    }

    public static void setCurrentUserIcon(Bitmap bitmap) {
        b.g = bitmap;
    }

    public static void setCustomLocation(String str) {
        b.h = str;
    }

    public static void setCustomText(String str, String str2) {
        if (b.ab != null) {
            b.ab.put(str, str2);
        }
    }

    public static void setCustomText(HashMap hashMap) {
        b.ab = hashMap;
    }

    public static void setExtraData(Map map) {
        b.f = com.baidu.ufosdk.c.a.a(map);
    }

    public static void setFaceBottomEntrance(int i) {
        b.q = i;
    }

    public static void setFaceBottomTextSize(float f) {
        b.Z = f;
    }

    public static void setFeedbackDetailsTextSize(float f) {
        b.N = f;
    }

    public static void setFeedbackInputWordCountTextSize(float f) {
        b.V = f;
    }

    public static void setFeedbackPrefix(String str) {
        b.l = str;
    }

    public static void setFeedbackSubfix(String str) {
        b.m = str;
    }

    public static void setFirstServerText(String str) {
        firstServerText = str;
    }

    public static void setGetNoticeFlagCallBack(GetNoticeFlagCallBack getNoticeFlagCallBack) {
        b.ae = getNoticeFlagCallBack;
    }

    public static void setHotProblemTitleSize(float f) {
        b.S = f;
    }

    public static void setListBgColor(int i) {
        b.D = i;
    }

    public static void setListDeleteTextSize(float f) {
        b.Y = f;
    }

    public static void setListDividerColor(int i) {
        b.G = i;
    }

    public static void setListTimeTextColor(int i) {
        b.F = i;
    }

    public static void setListTitleTextColor(int i) {
        b.E = i;
    }

    public static void setListTitleTextSize(float f) {
        b.W = f;
    }

    public static void setLogLevel(int i) {
        b.o = i;
    }

    public static void setMyFeedbackBtnTextSize(float f) {
        b.U = f;
    }

    public static void setNoHaveFeedbackTextSize(float f) {
        b.X = f;
    }

    public static void setNotSolvedReplyText(String str) {
        notSolvedReplyText = str;
    }

    public static void setPlaceholder(String str) {
        b.n = str;
    }

    public static void setReferer(String str) {
        b.p = str;
    }

    public static void setReloadBtnTextSize(float f) {
        b.P = f;
    }

    public static void setReloadBtnTxtColor(int i) {
        b.w = i;
    }

    public static void setReloadTextSize(float f) {
        b.O = f;
    }

    public static void setReloadTxtColor(int i) {
        b.x = i;
    }

    public static void setReportCallBack(ReportCallback reportCallback) {
        b.af = reportCallback;
    }

    public static void setResumeCallBack(ResumeCallBack resumeCallBack) {
        b.ac = resumeCallBack;
    }

    public static void setRightBtnTextColor(int i) {
        b.s = i;
    }

    public static void setRootBackgroundColor(int i) {
        b.z = i;
    }

    public static void setSentBtnTextColor(int i) {
        b.v = i;
    }

    public static void setSolvedReplyText(String str) {
        solvedReplyText = str;
    }

    public static void setSubmitMessageCallBack(SubmitMessageCallBack submitMessageCallBack) {
        b.ad = submitMessageCallBack;
    }

    public static void setSubmitNewMessageCallBack(a aVar) {
        b.ag = aVar;
    }

    public static void setTabBgTextColor(int i) {
        b.u = i;
    }

    public static void setTabDefultTextColor(int i) {
        b.t = i;
    }

    public static void setTimeViewTextSize(float f) {
        b.Q = f;
    }

    public static void setTitleBarColor(int i) {
        b.A = i;
    }

    public static void setTitleHelpAndFeedbackTextSize(float f) {
        b.T = f;
    }

    public static void setTitleTextColor(int i) {
        b.r = i;
    }

    public static void setToggleUpTextColor(int i) {
        b.J = i;
    }

    public static void setUserId(String str) {
        b.d = str;
    }

    public static void setUserName(String str) {
        b.f5638b = str;
    }

    public static void setUserStatus(int i) {
        b.e = i;
    }
}
