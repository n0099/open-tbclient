package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private a onm;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.onm;
    }

    public void setData(a aVar) {
        this.onm = aVar;
        if (this.onm != null) {
            setText(aVar.ono);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int onn;
        public String ono;

        public a(int i, String str) {
            this.onn = i;
            this.ono = str;
        }
    }
}
