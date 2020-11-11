package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class f {
    private RelativeLayout jVp;
    private final ConcurrentHashMap<String, ConnectionLineView> odV = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> odW = new ConcurrentHashMap<>();
    private a odX;

    /* loaded from: classes4.dex */
    public interface a {
        void VK(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.jVp.indexOfChild(r8.odV.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String k = k(iArr);
            if (this.odV.containsKey(k)) {
            }
            this.jVp = relativeLayout;
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
            this.odV.put(k, connectionLineView);
            if (this.odX != null) {
                this.odX.VK(k);
            }
        }
    }

    public synchronized void VI(String str) {
        if (!ListUtils.isEmpty(this.odV) && this.odV.containsKey(str)) {
            ConnectionLineView connectionLineView = this.odV.get(str);
            if (connectionLineView != null && this.jVp.indexOfChild(connectionLineView) != -1) {
                this.jVp.removeView(connectionLineView);
            }
            this.odV.remove(str);
        }
    }

    public synchronized void dZm() {
        if (!ListUtils.isEmpty(this.odV)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.odV.entrySet()) {
                VI(entry.getKey());
            }
        }
    }

    public String k(int[] iArr) {
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
        return new double[]{((dArr[0] + dArr2[0]) - i) / 2.0d, ((dArr[1] + dArr2[1]) / 2.0d) - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(11.0f, this.jVp.getContext())};
    }

    public void a(a aVar) {
        this.odX = aVar;
    }

    public synchronized void l(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.odV) && (connectionLineView = this.odV.get(k(iArr))) != null) {
            connectionLineView.eax();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> dZn() {
        return this.odV;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.odW != null) {
            if (this.odW.containsKey(str)) {
                this.odW.remove(str);
            }
            this.odW.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean VJ(String str) {
        return (this.odW == null || !this.odW.containsKey(str)) ? false : this.odW.get(str).booleanValue();
    }

    public synchronized void dZo() {
        if (this.odW != null) {
            this.odW.clear();
        }
    }
}
