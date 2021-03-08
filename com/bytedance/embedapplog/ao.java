package com.bytedance.embedapplog;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ao implements g {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<WeakReference<g>> f3902a = new ArrayList<>(4);

    @Override // com.bytedance.embedapplog.g
    public synchronized void onIdLoaded(String str, String str2, String str3) {
        Iterator<WeakReference<g>> it = f3902a.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar == null) {
                it.remove();
            } else {
                gVar.onIdLoaded(str, str2, str3);
            }
        }
    }

    @Override // com.bytedance.embedapplog.g
    public synchronized void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<WeakReference<g>> it = f3902a.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar == null) {
                it.remove();
            } else {
                gVar.onRemoteIdGet(z, str, str2, str3, str4, str5, str6);
            }
        }
    }

    @Override // com.bytedance.embedapplog.g
    public synchronized void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<g>> it = f3902a.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar == null) {
                it.remove();
            } else {
                gVar.onRemoteConfigGet(z, jSONObject);
            }
        }
    }

    @Override // com.bytedance.embedapplog.g
    public synchronized void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
        Iterator<WeakReference<g>> it = f3902a.iterator();
        while (it.hasNext()) {
            g gVar = it.next().get();
            if (gVar == null) {
                it.remove();
            } else {
                gVar.onRemoteAbConfigGet(z, jSONObject);
            }
        }
    }

    public synchronized void b(g gVar) {
        if (gVar != null) {
            f3902a.add(new WeakReference<>(gVar));
        }
    }
}
