package com.baidu.tieba.publisher.a;

import android.app.Activity;
import com.baidu.searchbox.suspensionball.ioc.ISuspensionBallDataInit;
/* loaded from: classes11.dex */
public class f implements ISuspensionBallDataInit {
    @Override // com.baidu.searchbox.suspensionball.ioc.ISuspensionBallDataInit
    public boolean enableInitSuspensionData(Activity activity) {
        return false;
    }

    @Override // com.baidu.searchbox.suspensionball.ioc.ISuspensionBallDataInit
    public void init() {
    }

    @Override // com.baidu.searchbox.suspensionball.ioc.ISuspensionBallDataInit
    public void release() {
    }

    @Override // com.baidu.searchbox.suspensionball.ioc.ISuspensionBallDataInit
    public Activity getTopActivity() {
        return null;
    }
}
