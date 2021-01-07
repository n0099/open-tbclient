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
    private static bx phw;

    /* renamed from: a  reason: collision with root package name */
    public Application f6116a;
    private boolean d;
    private final ArrayList<ac> f = new ArrayList<>(32);
    private Handler i;
    private Handler k;
    private cn pgK;
    private m pgO;
    private bt phx;
    private ad phy;
    private ce phz;

    public static void a() {
        if (phw != null) {
            phw.b(null);
        }
    }

    private bx() {
    }

    public static bx epy() {
        if (phw == null) {
            synchronized (bx.class) {
                if (phw == null) {
                    phw = new bx();
                }
            }
        }
        return phw;
    }

    public static String c() {
        return epz().f6120a;
    }

    public static ce epz() {
        if (phw != null) {
            return phw.phz;
        }
        au.a(null);
        return null;
    }

    public void a(Application application, cn cnVar, m mVar, bs bsVar) {
        this.f6116a = application;
        this.phy = new ad(application, mVar, cnVar);
        this.pgK = cnVar;
        this.pgO = mVar;
        this.phz = new ce(this.pgO, this.pgK);
        this.f6116a.registerActivityLifecycleCallbacks(bsVar);
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
                au.f6085a = this.pgK.w();
                if (this.pgO.e()) {
                    if (this.pgK.r()) {
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
                arrayList.add(new cc(this.f6116a, this.pgO, this.phz));
                arrayList.add(new bw(this.f6116a, this.pgO, this.pgK));
                arrayList.add(new cb(this.f6116a, this.pgO, this.phy));
                arrayList.add(new cd(this.f6116a, this.phy, this.pgK, this.pgO));
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
                    this.f.add(ce.epB());
                }
                b(null);
                break;
        }
        return true;
    }

    private void g() {
        if (this.pgK.v()) {
            if (this.phx == null) {
                this.phx = new bt(this.f6116a, this.pgO, this.pgK);
                this.i.obtainMessage(6, this.phx).sendToTarget();
            }
        } else if (this.phx != null) {
            this.phx.f();
            this.phx = null;
        }
    }

    public boolean e() {
        this.d = true;
        bu buVar = new bu(this.f6116a, this.pgO);
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
                arrayList.add(ac.YC(str));
            }
        }
        boolean bq = this.pgK.bq(arrayList);
        if (arrayList.size() > 0) {
            if (this.pgK.r()) {
                if (bq || arrayList.size() > 100) {
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
                        if (this.phz.a(next, arrayList2)) {
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
                            this.k.sendEmptyMessageDelayed(7, this.pgK.epL());
                        }
                    }
                    this.phy.a(arrayList2);
                    if (!this.d && this.phz.b() && this.i != null && b.eoU()) {
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
            Intent intent = new Intent(this.f6116a, Collector.class);
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
                this.f6116a.sendBroadcast(intent);
            } catch (Exception e) {
                au.a(e);
            }
        }
    }

    private void h() {
        if (au.f6086b) {
            au.a("packAndSend once, " + this.phz.f6120a + ", hadUI:" + this.phz.b(), null);
        }
        if (this.i != null) {
            this.i.sendMessage(this.k.obtainMessage(6, new by(this.f6116a, this.pgO, this.phy)));
            this.i.sendMessage(this.k.obtainMessage(6, new bz(this.f6116a, this.phy, this.pgK, this.pgO)));
        }
    }

    public static void a(ac acVar) {
        int size;
        bx bxVar = phw;
        if (bxVar == null) {
            au.b("Init comes First!", null);
            cg.a(acVar);
            return;
        }
        if (acVar.f6074a == 0) {
            au.a(null);
        }
        if (acVar instanceof ak) {
            ((ak) acVar).i = bxVar.pgK.i();
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
        bx bxVar = phw;
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
        long j = acVar.f6074a - acVar2.f6074a;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }
}
