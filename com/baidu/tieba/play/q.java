package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes.dex */
public class q extends ContentObserver {
    private a fxA;
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
        bep();
    }

    private void bep() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.fxA != null) {
                    this.fxA.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.fxA = aVar;
        bep();
    }
}
