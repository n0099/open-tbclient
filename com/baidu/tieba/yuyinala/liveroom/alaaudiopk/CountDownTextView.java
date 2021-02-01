package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
/* loaded from: classes11.dex */
public class CountDownTextView extends TextView {
    private a osz;

    public CountDownTextView(Context context) {
        super(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a getData() {
        return this.osz;
    }

    public void setData(a aVar) {
        this.osz = aVar;
        if (this.osz != null) {
            setText(aVar.osB);
        }
    }

    /* loaded from: classes11.dex */
    public static class a {
        public int osA;
        public String osB;

        public a(int i, String str) {
            this.osA = i;
            this.osB = str;
        }
    }
}
