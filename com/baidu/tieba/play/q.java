package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes.dex */
public class q extends ContentObserver {
    private a fQc;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onChange(boolean z);
    }

    public q(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        bjt();
    }

    private void bjt() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.fQc != null) {
                    this.fQc.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.fQc = aVar;
        bjt();
    }
}
