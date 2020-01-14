package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes.dex */
public class p extends ContentObserver {
    private a jvb;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onChange(boolean z);
    }

    public p(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        xK();
    }

    private void xK() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.jvb != null) {
                    this.jvb.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.jvb = aVar;
        xK();
    }
}
