package com.baidu.tieba.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Hashtable<Integer, String> f1922a;

    static {
        f1922a = null;
        if (f1922a == null) {
            f1922a = new Hashtable<>();
            f1922a.put(1001, "上线");
            f1922a.put(1002, "GROUP_UPDATE");
            f1922a.put(1003, "PING");
            f1922a.put(202003, "MESSAGE_SYNC");
            f1922a.put(202001, "GROUP_CHAT_MSG");
            f1922a.put(202006, "PUSH_NOTIFY");
            f1922a.put(103002, "吧的群组列表界面网络请求");
            f1922a.put(103004, "群资料页界面网络请求");
            f1922a.put(103005, "根据群的ID获取群的成员列表");
            f1922a.put(103112, "移除群的成员");
            f1922a.put(103006, "根据群的id获取群的等级信息");
            f1922a.put(103110, "加群申请");
            f1922a.put(103111, "往群增加成员");
            f1922a.put(103003, "进群页面接口");
            f1922a.put(103007, "搜群");
            f1922a.put(202004, "删系统群消息");
            f1922a.put(103008, "建群权限获取");
            f1922a.put(103101, "添加群组");
            f1922a.put(103103, "举报群组");
            f1922a.put(103102, "更新群组");
            f1922a.put(202101, "反推计数上传");
        }
    }

    public static String a(int i) {
        if (f1922a == null || !f1922a.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return f1922a.get(Integer.valueOf(i));
    }
}
