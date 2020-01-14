package com.baidu.tieba.recapp.report;

import android.support.v4.util.ArrayMap;
/* loaded from: classes.dex */
public class e {
    public static final ArrayMap<Integer, String> jKU = new ArrayMap<>();

    static {
        jKU.put(0, "未被抛弃");
        jKU.put(1, "间隔楼层不足");
        jKU.put(2, "当页楼层不足， 不足以插入广告");
        jKU.put(3, "app 下载安装过， 被抛弃");
        jKU.put(10, "内容校验错误");
        jKU.put(11, "非lego广告， 8.6开始被抛弃");
        jKU.put(12, "card_type=12广告， 8.6开始被抛弃");
        jKU.put(21, "给Android返回IOS广告或者不识别的类型");
        jKU.put(22, "给IOS返回了Android广告或者不识别的类型");
        jKU.put(23, "数据格式错误_adposition为空");
        jKU.put(24, "数据格式错误_广告id为空");
        jKU.put(25, "数据格式错误_goodsInfo为空");
        jKU.put(26, "返回APP广告数据有问题");
        jKU.put(27, "返回URL广告数据有问题");
        jKU.put(28, "lego的开关没打开");
        jKU.put(29, "广告数据位置重复被丢弃");
        jKU.put(30, "广告ID重复被丢弃");
        jKU.put(31, "广告插件未加载成功被丢弃");
        jKU.put(32, "lego数据异常：包括json格式不合法、cardtype不识别、各种子类型数据不合法比如视频类型没有视频url等");
        jKU.put(33, "客户端最后计算出的positon不合法");
        jKU.put(34, "无图模式下需要丢弃有图广告");
        jKU.put(35, "返回lego广告type有问题,客户端不识别");
        jKU.put(36, "拉回了广告却没有拉回帖子");
        jKU.put(37, "返回lego广告数据在该版本不支持");
        jKU.put(100, "其他原因");
    }
}
