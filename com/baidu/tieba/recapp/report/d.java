package com.baidu.tieba.recapp.report;

import android.support.v4.util.ArrayMap;
/* loaded from: classes.dex */
public class d {
    public static final ArrayMap<Integer, String> fGi = new ArrayMap<>();

    static {
        fGi.put(0, "未被抛弃");
        fGi.put(1, "间隔楼层不足");
        fGi.put(2, "当页楼层不足， 不足以插入广告");
        fGi.put(3, "app 下载安装过， 被抛弃");
        fGi.put(11, "非lego广告， 8.6开始被抛弃");
        fGi.put(12, "card_type=12广告， 8.6开始被抛弃");
        fGi.put(21, "给Android返回IOS广告或者不识别的类型");
        fGi.put(22, "给IOS返回了Android广告或者不识别的类型");
        fGi.put(23, "数据格式错误_adposition为空");
        fGi.put(24, "数据格式错误_广告id为空");
        fGi.put(25, "数据格式错误_goodsInfo为空");
        fGi.put(26, "返回APP广告数据有问题");
        fGi.put(27, "返回URL广告数据有问题");
        fGi.put(28, "lego的开关没打开");
        fGi.put(29, "广告数据位置重复被丢弃");
        fGi.put(30, "广告ID重复被丢弃");
        fGi.put(31, "广告插件未加载成功被丢弃");
        fGi.put(32, "lego数据异常：包括json格式不合法、cardtype不识别、各种子类型数据不合法比如视频类型没有视频url等");
        fGi.put(33, "客户端最后计算出的positon不合法");
        fGi.put(34, "无图模式下需要丢弃有图广告");
        fGi.put(35, "返回lego广告type有问题,客户端不识别");
        fGi.put(36, "拉回了广告却没有拉回帖子");
        fGi.put(37, "返回lego广告数据在该版本不支持");
        fGi.put(100, "其他原因");
    }
}
