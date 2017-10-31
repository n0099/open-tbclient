package com.baidu.tieba.keepLive.startActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.adp.lib.g.e;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class LiveActivity extends Activity {
    private static final String LIVEACTIVITY = "com.baidu.tieba.keepLive.startActivity.LiveActivity";

    public static void actionToLiveActivity(Context context) {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.activity_live);
        Window window = getWindow();
        window.setGravity(8388659);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 1;
        attributes.height = 1;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        ScreenManager.getInstance(this).setActivity(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.keepLive.startActivity.LiveActivity.1
            @Override // java.lang.Runnable
            public void run() {
                LiveActivity.this.finish();
            }
        }, 500L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ScreenManager.getInstance(this).finishActivity();
    }
}
