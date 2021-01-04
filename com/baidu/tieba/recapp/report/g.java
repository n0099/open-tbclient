package com.baidu.tieba.recapp.report;

import androidx.collection.ArrayMap;
/* loaded from: classes.dex */
public class g {
    public static final ArrayMap<Integer, String> mSK = new ArrayMap<>();

    static {
        mSK.put(0, "未被抛弃");
        mSK.put(1, "间隔楼层不足");
        mSK.put(2, "当页楼层不足， 不足以插入广告");
        mSK.put(3, "app 下载安装过， 被抛弃");
        mSK.put(10, "内容校验错误");
        mSK.put(11, "非lego广告， 8.6开始被抛弃");
        mSK.put(12, "card_type=12广告， 8.6开始被抛弃");
        mSK.put(21, "给Android返回IOS广告或者不识别的类型");
        mSK.put(22, "给IOS返回了Android广告或者不识别的类型");
        mSK.put(23, "数据格式错误_adposition为空");
        mSK.put(24, "数据格式错误_广告id为空");
        mSK.put(25, "数据格式错误_goodsInfo为空");
        mSK.put(26, "返回APP广告数据有问题");
        mSK.put(27, "返回URL广告数据有问题");
        mSK.put(28, "lego的开关没打开");
        mSK.put(29, "广告数据位置重复被丢弃");
        mSK.put(30, "广告ID重复被丢弃");
        mSK.put(31, "广告插件未加载成功被丢弃");
        mSK.put(32, "lego数据异常：包括json格式不合法、cardtype不识别、各种子类型数据不合法比如视频类型没有视频url等");
        mSK.put(33, "客户端最后计算出的positon不合法");
        mSK.put(34, "无图模式下需要丢弃有图广告");
        mSK.put(35, "返回lego广告type有问题,客户端不识别");
        mSK.put(36, "拉回了广告却没有拉回帖子");
        mSK.put(37, "返回lego广告数据在该版本不支持");
        mSK.put(100, "其他原因");
    }
}
