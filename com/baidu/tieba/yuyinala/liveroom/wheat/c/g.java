package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes10.dex */
public class g {
    private RelativeLayout lzu;
    private final ConcurrentHashMap<String, ConnectionLineView> oIL = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> oIM = new ConcurrentHashMap<>();
    private a oIN;

    /* loaded from: classes10.dex */
    public interface a {
        void WC(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.lzu.indexOfChild(r8.oIL.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String o = o(iArr);
            if (this.oIL.containsKey(o)) {
            }
            this.lzu = relativeLayout;
            ConnectionLineView connectionLineView = new ConnectionLineView(relativeLayout.getContext());
            int a2 = (int) a(dArr, dArr2);
            connectionLineView.setLayoutParams(new RelativeLayout.LayoutParams(a2 - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(52.0f, relativeLayout.getContext()), -2));
            float b = (float) b(dArr, dArr2);
            double[] a3 = a(a2, dArr, dArr2);
            connectionLineView.setX((float) (a3[0] + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(52.0f, relativeLayout.getContext()) / 2)));
            connectionLineView.setY((float) a3[1]);
            if (dArr[1] > dArr2[1]) {
                b = 180.0f - b;
            }
            connectionLineView.setRotation(b);
            relativeLayout.addView(connectionLineView, i + 1);
            this.oIL.put(o, connectionLineView);
            if (this.oIN != null) {
                this.oIN.WC(o);
            }
        }
    }

    public synchronized void WA(String str) {
        if (!ListUtils.isEmpty(this.oIL) && this.oIL.containsKey(str)) {
            ConnectionLineView connectionLineView = this.oIL.get(str);
            if (connectionLineView != null && this.lzu.indexOfChild(connectionLineView) != -1) {
                this.lzu.removeView(connectionLineView);
            }
            this.oIL.remove(str);
        }
    }

    public synchronized void edC() {
        if (!ListUtils.isEmpty(this.oIL)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oIL.entrySet()) {
                WA(entry.getKey());
            }
        }
    }

    public String o(int[] iArr) {
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
        return new double[]{((dArr[0] + dArr2[0]) - i) / 2.0d, ((dArr[1] + dArr2[1]) / 2.0d) - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(11.0f, this.lzu.getContext())};
    }

    public void a(a aVar) {
        this.oIN = aVar;
    }

    public synchronized void p(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.oIL) && (connectionLineView = this.oIL.get(o(iArr))) != null) {
            connectionLineView.efm();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> edD() {
        return this.oIL;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.oIM != null) {
            if (this.oIM.containsKey(str)) {
                this.oIM.remove(str);
            }
            this.oIM.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean WB(String str) {
        return (this.oIM == null || !this.oIM.containsKey(str)) ? false : this.oIM.get(str).booleanValue();
    }

    public synchronized void edE() {
        if (this.oIM != null) {
            this.oIM.clear();
        }
    }
}
