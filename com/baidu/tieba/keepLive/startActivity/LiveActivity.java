package com.baidu.tieba.keepLive.startActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
/* loaded from: classes6.dex */
public class LiveActivity extends Activity {
    private boolean mIsFirstStart = true;

    public static void actionToLiveActivity(Context context) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
