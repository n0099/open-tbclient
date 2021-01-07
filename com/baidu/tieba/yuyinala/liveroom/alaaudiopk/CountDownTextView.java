package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private a onl;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.onl;
    }

    public void setData(a aVar) {
        this.onl = aVar;
        if (this.onl != null) {
            setText(aVar.onn);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int onm;
        public String onn;

        public a(int i, String str) {
            this.onm = i;
            this.onn = str;
        }
    }
}
