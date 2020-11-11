package com.baidu.tieba.yuyinala.liveroom.wheat.e;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class f {
    public static boolean a(Context context, Activity activity) {
        try {
            if (!checkPermissionGranted(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                aB(activity);
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

    private static boolean aB(Activity activity) {
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.setDialogClickListener(new PermissionJudgePolicy.PermissionDialogClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.wheat.e.f.1
            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogCaneled(String str) {
            }

            @Override // com.baidu.live.tbadk.core.util.permission.PermissionJudgePolicy.PermissionDialogClickListener
            public void onDialogComfirmed(String str) {
            }
        });
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(activity, PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        return permissionJudgePolicy.startRequestPermission(activity, true, true);
    }
}
