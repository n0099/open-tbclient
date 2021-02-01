package com.baidu.tieba.recapp.report;

import androidx.collection.ArrayMap;
/* loaded from: classes.dex */
public class g {
    public static final ArrayMap<Integer, String> mXr = new ArrayMap<>();

    static {
        mXr.put(0, "未被抛弃");
        mXr.put(1, "间隔楼层不足");
        mXr.put(2, "当页楼层不足， 不足以插入广告");
        mXr.put(3, "app 下载安装过， 被抛弃");
        mXr.put(10, "内容校验错误");
        mXr.put(11, "非lego广告， 8.6开始被抛弃");
        mXr.put(12, "card_type=12广告， 8.6开始被抛弃");
        mXr.put(21, "给Android返回IOS广告或者不识别的类型");
        mXr.put(22, "给IOS返回了Android广告或者不识别的类型");
        mXr.put(23, "数据格式错误_adposition为空");
        mXr.put(24, "数据格式错误_广告id为空");
        mXr.put(25, "数据格式错误_goodsInfo为空");
        mXr.put(26, "返回APP广告数据有问题");
        mXr.put(27, "返回URL广告数据有问题");
        mXr.put(28, "lego的开关没打开");
        mXr.put(29, "广告数据位置重复被丢弃");
        mXr.put(30, "广告ID重复被丢弃");
        mXr.put(31, "广告插件未加载成功被丢弃");
        mXr.put(32, "lego数据异常：包括json格式不合法、cardtype不识别、各种子类型数据不合法比如视频类型没有视频url等");
        mXr.put(33, "客户端最后计算出的positon不合法");
        mXr.put(34, "无图模式下需要丢弃有图广告");
        mXr.put(35, "返回lego广告type有问题,客户端不识别");
        mXr.put(36, "拉回了广告却没有拉回帖子");
        mXr.put(37, "返回lego广告数据在该版本不支持");
        mXr.put(100, "其他原因");
    }
}
