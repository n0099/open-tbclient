package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes11.dex */
public class a extends b.a {
    public static boolean oUA = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oUw;
    private long oUx;
    private int oUy;
    private boolean oUz;

    public a(Context context, long j, String str, int i, g gVar) {
        this.oUz = false;
        this.oUw = gVar;
        this.mContext = context;
        this.oUx = j;
        this.mType = str;
        this.oUy = i;
        if (i == 1) {
            this.oUz = false;
        } else {
            this.oUz = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hB(this.mContext).a(this.mType, this.oUx, this.oUz, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oUw != null) {
                    a.oUA = true;
                    a.this.oUw.d(i, str, j);
                }
            }
        });
    }
}
