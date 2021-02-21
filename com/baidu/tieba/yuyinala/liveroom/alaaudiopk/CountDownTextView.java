package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private a osZ;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.osZ;
    }

    public void setData(a aVar) {
        this.osZ = aVar;
        if (this.osZ != null) {
            setText(aVar.otb);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int ota;
        public String otb;

        public a(int i, String str) {
            this.ota = i;
            this.otb = str;
        }
    }
}
