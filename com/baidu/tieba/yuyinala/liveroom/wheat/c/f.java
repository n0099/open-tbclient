package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class f {
    private RelativeLayout jVZ;
    private a ofB;
    private final ConcurrentHashMap<String, ConnectionLineView> ofz = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> ofA = new ConcurrentHashMap<>();

    /* loaded from: classes4.dex */
    public interface a {
        void Vv(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.jVZ.indexOfChild(r8.ofz.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String n = n(iArr);
            if (this.ofz.containsKey(n)) {
            }
            this.jVZ = relativeLayout;
            ConnectionLineView connectionLineView = new ConnectionLineView(relativeLayout.getContext());
            int a2 = (int) a(dArr, dArr2);
            connectionLineView.setLayoutParams(new RelativeLayout.LayoutParams(a2 - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(52.0f, relativeLayout.getContext()), -2));
            float b = (float) b(dArr, dArr2);
            double[] a3 = a(a2, dArr, dArr2);
            connectionLineView.setX((float) (a3[0] + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(52.0f, relativeLayout.getContext()) / 2)));
            connectionLineView.setY((float) a3[1]);
            if (dArr[1] > dArr2[1]) {
                b = 180.0f - b;
            }
            connectionLineView.setRotation(b);
            relativeLayout.addView(connectionLineView, i + 1);
            this.ofz.put(n, connectionLineView);
            if (this.ofB != null) {
                this.ofB.Vv(n);
            }
        }
    }

    public synchronized void Vt(String str) {
        if (!ListUtils.isEmpty(this.ofz) && this.ofz.containsKey(str)) {
            ConnectionLineView connectionLineView = this.ofz.get(str);
            if (connectionLineView != null && this.jVZ.indexOfChild(connectionLineView) != -1) {
                this.jVZ.removeView(connectionLineView);
            }
            this.ofz.remove(str);
        }
    }

    public synchronized void dZl() {
        if (!ListUtils.isEmpty(this.ofz)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.ofz.entrySet()) {
                Vt(entry.getKey());
            }
        }
    }

    public String n(int[] iArr) {
        return (iArr == null || iArr.length != 2) ? "" : Integer.toString(iArr[0]) + Integer.toString(iArr[1]);
    }

    private double a(double[] dArr, double[] dArr2) {
        double abs = Math.abs(dArr2[0] - dArr[0]);
        double abs2 = Math.abs(dArr2[1] - dArr[1]);
        return dArr[1] == dArr2[1] ? abs : Math.sqrt((abs * abs) + (abs2 * abs2));
    }

    public double b(double[] dArr, double[] dArr2) {
        return Math.round((Math.asin(Math.abs(dArr2[1] - dArr[1]) / a(dArr, dArr2)) / 3.141592653589793d) * 180.0d);
    }

    private double[] a(int i, double[] dArr, double[] dArr2) {
        return new double[]{((dArr[0] + dArr2[0]) - i) / 2.0d, ((dArr[1] + dArr2[1]) / 2.0d) - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(11.0f, this.jVZ.getContext())};
    }

    public void a(a aVar) {
        this.ofB = aVar;
    }

    public synchronized void o(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.ofz) && (connectionLineView = this.ofz.get(n(iArr))) != null) {
            connectionLineView.eaw();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> dZm() {
        return this.ofz;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.ofA != null) {
            if (this.ofA.containsKey(str)) {
                this.ofA.remove(str);
            }
            this.ofA.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean Vu(String str) {
        return (this.ofA == null || !this.ofA.containsKey(str)) ? false : this.ofA.get(str).booleanValue();
    }

    public synchronized void dZn() {
        if (this.ofA != null) {
            this.ofA.clear();
        }
    }
}
