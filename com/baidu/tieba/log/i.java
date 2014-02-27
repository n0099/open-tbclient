package com.baidu.tieba.log;

import java.util.Hashtable;
/* loaded from: classes.dex */
public final class i {
    private static Hashtable<Integer, String> a;

    static {
        a = null;
        if (0 == 0) {
            Hashtable<Integer, String> hashtable = new Hashtable<>();
            a = hashtable;
            hashtable.put(1001, "上线");
            a.put(1002, "GROUP_UPDATE");
            a.put(1003, "PING");
            a.put(202003, "MESSAGE_SYNC");
            a.put(202001, "GROUP_CHAT_MSG");
            a.put(205001, "CMD_COMMIT_PERSONAL_MSG");
            a.put(202006, "PUSH_NOTIFY");
            a.put(103002, "吧的群组列表界面网络请求");
            a.put(103004, "群资料页界面网络请求");
            a.put(103005, "根据群的ID获取群的成员列表");
            a.put(103112, "移除群的成员");
            a.put(103006, "根据群的id获取群的等级信息");
            a.put(103110, "加群申请");
            a.put(103111, "往群增加成员");
            a.put(103003, "进群页面接口");
            a.put(103007, "搜群");
            a.put(202004, "删系统群消息");
            a.put(103008, "建群权限获取");
            a.put(103101, "添加群组");
            a.put(103103, "举报群组");
            a.put(103102, "更新群组");
            a.put(202101, "反推计数上传");
        }
    }

    public static String a(int i) {
        if (a == null || !a.containsKey(Integer.valueOf(i))) {
            return "";
        }
        return a.get(Integer.valueOf(i));
    }
}
