package com.baidu.tieba.yuyinala.liveroom.roomcard;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
/* loaded from: classes11.dex */
public class i {
    public static boolean a(Context context, Activity activity) {
        try {
            if (!checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                aF(activity);
                return false;
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        return true;
    }

    private static boolean checkPermissionGranted(Context context, String str) {
        return checkSelfPermission(context, str) == 0;
    }

    private static int checkSelfPermission(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    private static boolean aF(Activity activity) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.roomcard.i.1
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
            }
        });
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
        return permissionJudgePolicy.startRequestPermission(activity);
    }
}
