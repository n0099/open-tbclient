package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private a oiG;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.oiG;
    }

    public void setData(a aVar) {
        this.oiG = aVar;
        if (this.oiG != null) {
            setText(aVar.oiI);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int oiH;
        public String oiI;

        public a(int i, String str) {
            this.oiH = i;
            this.oiI = str;
        }
    }
}
