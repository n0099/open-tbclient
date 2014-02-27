package com.baidu.tieba.im.util;

import cn.jingling.lib.file.ImageFile;
/* loaded from: classes.dex */
public final class n {
    public static String a(int i) {
        switch (i) {
            case -85:
                return "定位失败了，右上角点下刷新吧~";
            case -84:
                return "录音发生错误";
            case -52:
            case ImageFile.SDCARD_FULL /* -7 */:
            case -2:
            case -1:
                return "你的网络状况不大好，请稍后重试";
            case -51:
                return "未知错误";
            case -48:
                return "创建私聊不成功，请稍后再试";
            case -47:
                return "内容不合适，请修改下吧";
            case -46:
                return "内容不能为空，请修改下吧";
            case -45:
                return "最多允许20个表情，请修改下吧";
            case -42:
                return "发的太频繁啦";
            case -41:
                return "录音太短啦";
            case -40:
                return "操作违规";
            case -26:
                return "存储卡已满，请清理文件";
            case -25:
                return "存储卡读写失败";
            case -24:
                return "你的存储卡被USB占用，请更改数据线连接方式";
            case -23:
                return "无法找到存储卡";
            case -3:
                return "数据转换失败";
            case 0:
                return null;
            default:
                return "未定义错误";
        }
    }
}
