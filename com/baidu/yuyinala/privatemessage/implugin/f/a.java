package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes11.dex */
public class a extends b.a {
    public static boolean pak = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g pag;
    private long pah;
    private int pai;
    private boolean paj;

    public a(Context context, long j, String str, int i, g gVar) {
        this.paj = false;
        this.pag = gVar;
        this.mContext = context;
        this.pah = j;
        this.mType = str;
        this.pai = i;
        if (i == 1) {
            this.paj = false;
        } else {
            this.paj = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.hC(this.mContext).a(this.mType, this.pah, this.paj, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.pag != null) {
                    a.pak = true;
                    a.this.pag.d(i, str, j);
                }
            }
        });
    }
}
