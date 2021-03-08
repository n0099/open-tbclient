package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class CountDownTextView extends TextView {
    private a ovf;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.ovf;
    }

    public void setData(a aVar) {
        this.ovf = aVar;
        if (this.ovf != null) {
            setText(aVar.ovh);
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public int ovg;
        public String ovh;

        public a(int i, String str) {
            this.ovg = i;
            this.ovh = str;
        }
    }
}
