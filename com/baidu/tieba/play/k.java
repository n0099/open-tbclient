package com.baidu.tieba.play;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
/* loaded from: classes2.dex */
public class k extends ContentObserver {
    private a lsv;
    private Context mContext;

    /* loaded from: classes2.dex */
    public interface a {
        void onChange(boolean z);
    }

    public k(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Ok();
    }

    private void Ok() {
        if (this.mContext != null) {
            try {
                int i = Settings.System.getInt(this.mContext.getContentResolver(), "accelerometer_rotation");
                if (this.lsv != null) {
                    this.lsv.onChange(i == 1);
                }
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(a aVar) {
        this.lsv = aVar;
        Ok();
    }
}
