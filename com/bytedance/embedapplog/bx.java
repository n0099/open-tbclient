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
/* loaded from: classes6.dex */
public class bx implements Handler.Callback, Comparator<ac> {
    private static bx ppS;

    /* renamed from: a  reason: collision with root package name */
    public Application f3925a;
    private boolean d;
    private final ArrayList<ac> f = new ArrayList<>(32);
    private Handler i;
    private Handler k;
    private bt ppT;
    private ad ppU;
    private ce ppV;
    private cn ppf;
    private m ppk;

    public static void a() {
        if (ppS != null) {
            ppS.b(null);
        }
    }

    private bx() {
    }

    public static bx eoo() {
        if (ppS == null) {
            synchronized (bx.class) {
                if (ppS == null) {
                    ppS = new bx();
                }
            }
        }
        return ppS;
    }

    public static String c() {
        return eop().f3927a;
    }

    public static ce eop() {
        if (ppS != null) {
            return ppS.ppV;
        }
        au.a(null);
        return null;
    }

    public void a(Application application, cn cnVar, m mVar, bs bsVar) {
        this.f3925a = application;
        this.ppU = new ad(application, mVar, cnVar);
        this.ppf = cnVar;
        this.ppk = mVar;
        this.ppV = new ce(this.ppk, this.ppf);
        this.f3925a.registerActivityLifecycleCallbacks(bsVar);
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
                au.f3906a = this.ppf.w();
                if (this.ppk.e()) {
                    if (this.ppf.r()) {
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
                arrayList.add(new cc(this.f3925a, this.ppk, this.ppV));
                arrayList.add(new bw(this.f3925a, this.ppk, this.ppf));
                arrayList.add(new cb(this.f3925a, this.ppk, this.ppU));
                arrayList.add(new cd(this.f3925a, this.ppU, this.ppf, this.ppk));
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
                    this.f.add(ce.eor());
                }
                b(null);
                break;
        }
        return true;
    }

    private void g() {
        if (this.ppf.v()) {
            if (this.ppT == null) {
                this.ppT = new bt(this.f3925a, this.ppk, this.ppf);
                this.i.obtainMessage(6, this.ppT).sendToTarget();
            }
        } else if (this.ppT != null) {
            this.ppT.f();
            this.ppT = null;
        }
    }

    public boolean e() {
        this.d = true;
        bu buVar = new bu(this.f3925a, this.ppk);
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
                arrayList.add(ac.YP(str));
            }
        }
        boolean bk = this.ppf.bk(arrayList);
        if (arrayList.size() > 0) {
            if (this.ppf.r()) {
                if (bk || arrayList.size() > 100) {
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
                        if (this.ppV.a(next, arrayList2)) {
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
                            this.k.sendEmptyMessageDelayed(7, this.ppf.eoy());
                        }
                    }
                    this.ppU.a(arrayList2);
                    if (!this.d && this.ppV.b() && this.i != null && b.enJ()) {
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
            Intent intent = new Intent(this.f3925a, Collector.class);
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
                this.f3925a.sendBroadcast(intent);
            } catch (Exception e) {
                au.a(e);
            }
        }
    }

    private void h() {
        if (au.b) {
            au.a("packAndSend once, " + this.ppV.f3927a + ", hadUI:" + this.ppV.b(), null);
        }
        if (this.i != null) {
            this.i.sendMessage(this.k.obtainMessage(6, new by(this.f3925a, this.ppk, this.ppU)));
            this.i.sendMessage(this.k.obtainMessage(6, new bz(this.f3925a, this.ppU, this.ppf, this.ppk)));
        }
    }

    public static void a(ac acVar) {
        int size;
        bx bxVar = ppS;
        if (bxVar == null) {
            au.b("Init comes First!", null);
            cg.a(acVar);
            return;
        }
        if (acVar.f3899a == 0) {
            au.a(null);
        }
        if (acVar instanceof ak) {
            ((ak) acVar).i = bxVar.ppf.i();
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
        bx bxVar = ppS;
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
        long j = acVar.f3899a - acVar2.f3899a;
        if (j < 0) {
            return -1;
        }
        if (j > 0) {
            return 1;
        }
        return 0;
    }
}
