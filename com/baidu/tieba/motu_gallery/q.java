package com.baidu.tieba.motu_gallery;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumListActivity f2019a;
    private volatile boolean b;
    private Thread c;

    public q(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.f2019a = jigsawAlbumListActivity;
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x0046 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        int i;
        int i2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap2;
        ViewphotoLinkedHashMap viewphotoLinkedHashMap3;
        Handler handler;
        int i10;
        this.c = Thread.currentThread();
        this.b = false;
        while (!this.b) {
            i = JigsawAlbumListActivity.j;
            if (i + 20 > this.f2019a.f2003a.b()) {
                int b = this.f2019a.f2003a.b();
                i10 = JigsawAlbumListActivity.j;
                i2 = b - i10;
            } else {
                i2 = 20;
            }
            viewphotoLinkedHashMap = this.f2019a.h;
            if (viewphotoLinkedHashMap.size() != 0) {
                i3 = JigsawAlbumListActivity.j;
                int unused = JigsawAlbumListActivity.k = i3;
                for (i4 = JigsawAlbumListActivity.k; i4 < i5 + i2; i4++) {
                    i8 = JigsawAlbumListActivity.k;
                    i9 = JigsawAlbumListActivity.j;
                    if (i8 != i9) {
                        break;
                    }
                    try {
                        viewphotoLinkedHashMap2 = this.f2019a.h;
                        if (viewphotoLinkedHashMap2.containsKey(Integer.valueOf(i4))) {
                            viewphotoLinkedHashMap3 = this.f2019a.h;
                            if (!viewphotoLinkedHashMap3.get((Object) Integer.valueOf(i4)).getTag().toString().equals("bitmap")) {
                                try {
                                    Bitmap a2 = this.f2019a.f2003a.a(this.f2019a, this.f2019a.f2003a.a(i4), this.f2019a.d);
                                    if (a2 != null) {
                                        Message message = new Message();
                                        message.obj = a2;
                                        message.arg1 = i4;
                                        message.what = 0;
                                        handler = this.f2019a.s;
                                        handler.sendMessage(message);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (OutOfMemoryError e2) {
                        e2.printStackTrace();
                    }
                }
                i6 = JigsawAlbumListActivity.k;
                i7 = JigsawAlbumListActivity.j;
                if (i6 == i7) {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e3) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void a() {
        this.b = true;
        if (this.c != null) {
            this.c.interrupt();
        }
    }
}
