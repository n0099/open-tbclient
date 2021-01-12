package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes10.dex */
public class a extends b.a {
    public static boolean oPY = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oPU;
    private long oPV;
    private int oPW;
    private boolean oPX;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oPX = false;
        this.oPU = gVar;
        this.mContext = context;
        this.oPV = j;
        this.mType = str;
        this.oPW = i;
        if (i == 1) {
            this.oPX = false;
        } else {
            this.oPX = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hz(this.mContext).a(this.mType, this.oPV, this.oPX, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oPU != null) {
                    a.oPY = true;
                    a.this.oPU.d(i, str, j);
                }
            }
        });
    }
}
