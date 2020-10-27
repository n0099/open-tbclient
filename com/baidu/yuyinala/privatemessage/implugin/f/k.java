package com.baidu.yuyinala.privatemessage.implugin.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.pubaccount.IIsSubscribedListener;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class k {
    private static k oor;
    private Context mContext;
    private static final String TAG = k.class.getSimpleName();
    private static Map<Long, h> oos = new HashMap();

    private k(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static k gF(Context context) {
        if (oor == null) {
            synchronized (k.class) {
                if (oor == null) {
                    oor = new k(context);
                }
            }
        }
        return oor;
    }

    public Map<Long, h> ebL() {
        return oos;
    }

    public h gV(long j) {
        return oos.get(Long.valueOf(j));
    }

    public void a(long j, h hVar) {
        oos.put(Long.valueOf(j), hVar);
    }

    public void a(String str, long j, IIsSubscribedListener iIsSubscribedListener) {
        b bVar = new b(this.mContext, str, j, ListenerManager.getInstance().addListener(iIsSubscribedListener));
        HttpHelper.executor(this.mContext, bVar, bVar);
    }

    public void b(String str, long j, IIsSubscribedListener iIsSubscribedListener) {
        c cVar = new c(this.mContext, str, j, ListenerManager.getInstance().addListener(iIsSubscribedListener));
        HttpHelper.executor(this.mContext, cVar, cVar);
    }

    public void a(String str, long j, boolean z, IIsSubscribedListener iIsSubscribedListener) {
        l lVar = new l(this.mContext, str, j, ListenerManager.getInstance().addListener(iIsSubscribedListener), z);
        HttpHelper.executor(this.mContext, lVar, lVar);
    }

    public void a(int i, String str, long j, String str2, boolean z) {
        IIsSubscribedListener iIsSubscribedListener = (IIsSubscribedListener) ListenerManager.getInstance().removeListener(str2);
        if (iIsSubscribedListener != null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(TAG, "strMsg=" + str);
            iIsSubscribedListener.onIsSubscribedResult(i, str, j, z);
        }
    }

    public void a(long j, g gVar) {
        e eVar = new e(this.mContext, j, ListenerManager.getInstance().addListener(gVar));
        HttpHelper.executor(this.mContext, eVar, eVar);
    }

    public void b(long j, g gVar) {
        f fVar = new f(this.mContext, j, ListenerManager.getInstance().addListener(gVar));
        HttpHelper.executor(this.mContext, fVar, fVar);
    }

    public void a(int i, String str, long j, String str2) {
        g gVar = (g) ListenerManager.getInstance().removeListener(str2);
        if (gVar != null) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d(TAG, "strMsg=" + str);
            gVar.d(i, str, j);
        }
    }
}
