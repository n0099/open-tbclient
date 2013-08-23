package com.baidu.tieba.switchs;

import com.baidu.adp.lib.a.d;
import com.baidu.tieba.switchs.features.BaiduWebviewSwitch;
import com.baidu.tieba.switchs.features.MotuSwitch;
import com.baidu.tieba.switchs.features.PushServiceSwitch;
import com.baidu.tieba.switchs.features.TencentMMSwitch;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SwitchModel {
    public static String[] SWITCH_LIST = {MotuSwitch.class.getName(), BaiduWebviewSwitch.class.getName(), PushServiceSwitch.class.getName(), TencentMMSwitch.class.getName()};

    public static void initSwitchManager() {
        for (int i = 0; i < SWITCH_LIST.length; i++) {
            try {
                try {
                    Class.forName(SWITCH_LIST[i]).newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e2) {
                    e2.printStackTrace();
                }
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void refreshSwitchManager(HashMap hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                d.a().a((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
            }
        }
    }
}
