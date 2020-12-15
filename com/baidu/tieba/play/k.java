package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes.dex */
public class k extends ContentObserver {
    private Context mContext;
    private a mxJ;

    /* loaded from: classes.dex */
    public interface a {
        void onChange(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Vk();
    }

    private void Vk() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.mxJ != null) {
                    this.mxJ.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.mxJ = aVar;
        Vk();
    }
}
