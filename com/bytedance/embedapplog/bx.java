package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class bx implements Handler.Callback, Comparator<ac> {
    private static bx pcU;

    /* renamed from: a  reason: collision with root package name */
    public Application f5816a;
    private boolean d;
    private final ArrayList<ac> f = new ArrayList<>(32);
    private Handler i;
    private Handler k;
    private bt pcV;
    private ad pcW;
    private ce pcX;
    private cn pch;
    private m pcl;

    public static void a() {
        if (pcU != null) {
            pcU.b(null);
        }
    }

    private bx() {
    }

    public static bx elC() {
        if (pcU == null) {
            synchronized (bx.class) {
                if (pcU == null) {
                    pcU = new bx();
                }
            }
        }
        return pcU;
    }

    public static String c() {
        return elD().f5820a;
    }

    public static ce elD() {
        if (pcU != null) {
            return pcU.pcX;
        }
        au.a(null);
        return null;
    }

    public void a(Application application, cn cnVar, m mVar, bs bsVar) {
        this.f5816a = application;
        this.pcW = new ad(application, mVar, cnVar);
        this.pch = cnVar;
        this.pcl = mVar;
        this.pcX = new ce(this.pcl, this.pch);
        this.f5816a.registerActivityLifecycleCallbacks(bsVar);
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
        handlerThread.start();
        this.k = new Handler(handlerThread.getLooper(), this);
        this.k.sendEmptyMessage(1);
        at.a(cnVar.i() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                au.f5785a = this.pch.w();
                if (this.pcl.e()) {
                    if (this.pch.r()) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        this.i = new Handler(handlerThread.getLooper(), this);
                        this.i.sendEmptyMessage(2);
                        if (this.f.size() > 0) {
                            this.k.removeMessages(4);
                            this.k.sendEmptyMessageDelayed(4, 1000L);
                        }
                        au.d("net|worker start", null);
                    }
                } else {
                    this.k.removeMessages(1);
                    this.k.sendEmptyMessageDelayed(1, 1000L);
                }
                cg.a();
                break;
            case 2:
                ArrayList arrayList = new ArrayList(4);
                arrayList.add(new cc(this.f5816a, this.pcl, this.pcX));
                arrayList.add(new bw(this.f5816a, this.pcl, this.pch));
                arrayList.add(new cb(this.f5816a, this.pcl, this.pcW));
                arrayList.add(new cd(this.f5816a, this.pcW, this.pch, this.pcl));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bv bvVar = (bv) it.next();
                    long h = bvVar.h();
                    if (h < 864000000) {
                        this.i.sendMessageDelayed(this.k.obtainMessage(6, bvVar), h);
                    }
                }
                g();
                break;
            case 3:
            default:
                au.a(null);
                break;
            case 4:
                b(null);
                break;
            case 5:
                b((String[]) message.obj);
                break;
            case 6:
                bv bvVar2 = (bv) message.obj;
                if (!bvVar2.g()) {
                    long h2 = bvVar2.h();
                    if (h2 < 864000000) {
                        this.i.sendMessageDelayed(this.k.obtainMessage(6, bvVar2), h2);
                    }
                    g();
                    break;
                }
                break;
            case 7:
                synchronized (this.f) {
                    this.f.add(ce.elF());
                }
                b(null);
                break;
        }
        return true;
    }

    private void g() {
        if (this.pch.v()) {
            if (this.pcV == null) {
                this.pcV = new bt(this.f5816a, this.pcl, this.pch);
                this.i.obtainMessage(6, this.pcV).sendToTarget();
            }
        } else if (this.pcV != null) {
            this.pcV.f();
            this.pcV = null;
        }
    }

    public boolean e() {
        this.d = true;
        bu buVar = new bu(this.f5816a, this.pcl);
        if (this.i != null) {
            this.i.obtainMessage(6, buVar).sendToTarget();
            return true;
        }
        return false;
    }

    private void b(String[] strArr) {
        ArrayList<ac> arrayList;
        boolean z;
        boolean z2;
        boolean z3 = false;
        synchronized (this.f) {
            arrayList = (ArrayList) this.f.clone();
            this.f.clear();
        }
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(ac.Xu(str));
            }
        }
        boolean bl = this.pch.bl(arrayList);
        if (arrayList.size() > 0) {
            if (this.pch.r()) {
                if (bl || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<ac> arrayList2 = new ArrayList<>(arrayList.size());
                    Iterator<ac> it = arrayList.iterator();
                    boolean z4 = false;
                    while (true) {
                        z = z3;
                        if (!it.hasNext()) {
                            break;
                        }
                        ac next = it.next();
                        if (this.pcX.a(next, arrayList2)) {
                            h();
                        }
                        if (next instanceof aj) {
                            z3 = true;
                            z2 = ce.b(next);
                        } else {
                            z2 = z4;
                            z3 = z;
                        }
                        z4 = z2;
                    }
                    if (z) {
                        if (z4) {
                            this.k.removeMessages(7);
                        } else {
                            this.k.sendEmptyMessageDelayed(7, this.pch.elP());
                        }
                    }
                    this.pcW.a(arrayList2);
                    if (!this.d && this.pcX.b() && this.i != null && b.ekY()) {
                        e();
                        return;
                    }
                    return;
                }
                synchronized (this.f) {
                    this.f.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.f5816a, Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                strArr2[i] = arrayList.get(i).e().toString();
                i++;
                i2 = strArr2[i].length() + i2;
            }
            if (i2 >= 307200) {
                au.a(null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.f5816a.sendBroadcast(intent);
            } catch (Exception e) {
                au.a(e);
            }
        }
    }

    private void h() {
        if (au.f5786b) {
            au.a("packAndSend once, " + this.pcX.f5820a + ", hadUI:" + this.pcX.b(), null);
        }
        if (this.i != null) {
            this.i.sendMessage(this.k.obtainMessage(6, new by(this.f5816a, this.pcl, this.pcW)));
            this.i.sendMessage(this.k.obtainMessage(6, new bz(this.f5816a, this.pcW, this.pch, this.pcl)));
        }
    }

    public static void a(ac acVar) {
        int size;
        bx bxVar = pcU;
        if (bxVar == null) {
            au.b("Init comes First!", null);
            cg.a(acVar);
            return;
        }
        if (acVar.f5774a == 0) {
            au.a(null);
        }
        if (acVar instanceof ak) {
            ((ak) acVar).i = bxVar.pch.i();
        }
        synchronized (bxVar.f) {
            size = bxVar.f.size();
            bxVar.f.add(acVar);
        }
        if (size % 10 == 0 && bxVar.k != null) {
            bxVar.k.removeMessages(4);
            bxVar.k.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
        }
    }

    public static void a(String[] strArr) {
        bx bxVar = pcU;
        if (bxVar == null) {
            au.a(new RuntimeException("Init comes First!"));
        } else if (bxVar.k != null) {
            bxVar.k.removeMessages(4);
            bxVar.k.obtainMessage(5, strArr).sendToTarget();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(ac acVar, ac acVar2) {
        long j = acVar.f5774a - acVar2.f5774a;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }
}
