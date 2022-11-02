package com.baidu.ufosdk;

import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.tencent.connect.common.Constants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class t1 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, String> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (a == null) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("0", "找不到相册应用");
                hashMap.put("1", "        继续描述您遇到的问题");
                hashMap.put("2", "天以前");
                hashMap.put("3", "删除");
                hashMap.put("4", "删除中...");
                hashMap.put("5", "反馈详情");
                hashMap.put("6", "请描述您遇到的问题");
                hashMap.put("7", "帮助与反馈");
                hashMap.put("8", "常见问题");
                hashMap.put("9", "小时以前");
                hashMap.put("10", "我要反馈");
                hashMap.put("11", "刚刚");
                hashMap.put("12", "请输入反馈内容不少于4个字");
                hashMap.put("13", "正在加载...");
                hashMap.put("14", "分钟以前");
                hashMap.put("15", "个月以前");
                hashMap.put("16", "输入超过200字");
                hashMap.put("17", "我的反馈");
                hashMap.put("18", "网络中断，请检查网络配置");
                hashMap.put("19", "网络中断，请检查网络配置");
                hashMap.put(PayUVEventType.PAY_WALLET_BANNER_SHOW, "您还没有反馈");
                hashMap.put("21", "图片过大，请调整上传图片大小");
                hashMap.put("22", WeiboSdkWebActivity.CHANNEL_DATA_ERROR_ZH_CN);
                hashMap.put("23", "请重新加载网络");
                hashMap.put("24", "发送");
                hashMap.put("25", "发送中...");
                hashMap.put("26", "谢谢支持");
                hashMap.put(PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK, "字");
                hashMap.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, "确认");
                hashMap.put("29", "发送超时");
                hashMap.put("30", "昨天");
                hashMap.put("31", "选填：请留下您的邮箱/手机/QQ号");
                hashMap.put("32", "联系方式不能超过30个字符");
                hashMap.put("33", "原创文章链接未填写（最少5个字符）");
                hashMap.put("34", "未上传问题截图");
                hashMap.put("35", "感谢您的反馈！");
                hashMap.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, "已收到您的评价，我会继续努力哒！");
                hashMap.put(PayConfig.PAYMENT_POS_KEY_MANGA, "请输入反馈内容不少于8个字");
                a = hashMap;
            }
            if (a.containsKey(str)) {
                return a.get(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}
