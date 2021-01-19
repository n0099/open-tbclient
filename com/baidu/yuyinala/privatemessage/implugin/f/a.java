package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes10.dex */
public class a extends b.a {
    public static boolean oPZ = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oPV;
    private long oPW;
    private int oPX;
    private boolean oPY;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oPY = false;
        this.oPV = gVar;
        this.mContext = context;
        this.oPW = j;
        this.mType = str;
        this.oPX = i;
        if (i == 1) {
            this.oPY = false;
        } else {
            this.oPY = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hz(this.mContext).a(this.mType, this.oPW, this.oPY, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oPV != null) {
                    a.oPZ = true;
                    a.this.oPV.d(i, str, j);
                }
            }
        });
    }
}
