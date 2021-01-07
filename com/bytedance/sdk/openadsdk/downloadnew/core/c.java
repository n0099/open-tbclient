package com.bytedance.sdk.openadsdk.downloadnew.core;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements TTAppDownloadListener {

    /* renamed from: a  reason: collision with root package name */
    private final List<TTAppDownloadListener> f7399a = Collections.synchronizedList(new LinkedList());

    public void a(TTAppDownloadListener tTAppDownloadListener) {
        if (tTAppDownloadListener != null) {
            for (TTAppDownloadListener tTAppDownloadListener2 : this.f7399a) {
                if (tTAppDownloadListener2 != null && tTAppDownloadListener2 == tTAppDownloadListener) {
                    return;
                }
            }
            this.f7399a.add(tTAppDownloadListener);
        }
    }

    public void a() {
        if (!this.f7399a.isEmpty()) {
            this.f7399a.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onIdle();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onDownloadActive(j, j2, str, str2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onDownloadPaused(j, j2, str, str2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onDownloadFailed(j, j2, str, str2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onInstalled(str, str2);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Iterator<TTAppDownloadListener> it = this.f7399a.iterator();
        while (it.hasNext()) {
            TTAppDownloadListener next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.onDownloadFinished(j, str, str2);
            }
        }
    }
}
