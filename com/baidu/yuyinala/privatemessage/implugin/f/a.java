package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.yuyinala.privatemessage.implugin.b.b;
/* loaded from: classes4.dex */
public class a extends b.a {
    public static boolean ooj = false;
    private Context mContext;
    private String mKey = "";
    private String mType;
    private g oof;
    private long oog;
    private int ooh;
    private boolean ooi;

    public a(Context context, long j, String str, int i, g gVar) {
        this.ooi = false;
        this.oof = gVar;
        this.mContext = context;
        this.oog = j;
        this.mType = str;
        this.ooh = i;
        if (i == 1) {
            this.ooi = false;
        } else {
            this.ooi = true;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.b.b.a, java.lang.Runnable
    public void run() {
        k.gF(this.mContext).a(this.mType, this.oog, this.ooi, new IIsSubscribedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.f.a.1
            @Override // com.baidu.android.imsdk.pubaccount.IIsSubscribedListener
            public void onIsSubscribedResult(int i, String str, long j, boolean z) {
                if (a.this.oof != null) {
                    a.ooj = true;
                    a.this.oof.d(i, str, j);
                }
            }
        });
    }
}
