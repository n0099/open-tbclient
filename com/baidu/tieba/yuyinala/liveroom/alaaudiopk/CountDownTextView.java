package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private a oiF;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.oiF;
    }

    public void setData(a aVar) {
        this.oiF = aVar;
        if (this.oiF != null) {
            setText(aVar.oiH);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int oiG;
        public String oiH;

        public a(int i, String str) {
            this.oiG = i;
            this.oiH = str;
        }
    }
}
