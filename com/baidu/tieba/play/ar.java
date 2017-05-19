package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes.dex */
public class ar extends ContentObserver {
    private a eTf;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void onChange(boolean z);
    }

    public ar(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        aWD();
    }

    private void aWD() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.eTf != null) {
                    this.eTf.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.eTf = aVar;
        aWD();
    }
}
