package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class f {
    private RelativeLayout ltF;
    private final ConcurrentHashMap<String, ConnectionLineView> oBl = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> oBm = new ConcurrentHashMap<>();
    private a oBn;

    /* loaded from: classes11.dex */
    public interface a {
        void Wt(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.ltF.indexOfChild(r8.oBl.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String o = o(iArr);
            if (this.oBl.containsKey(o)) {
            }
            this.ltF = relativeLayout;
            ConnectionLineView connectionLineView = new ConnectionLineView(relativeLayout.getContext());
            int a2 = (int) a(dArr, dArr2);
            connectionLineView.setLayoutParams(new RelativeLayout.LayoutParams(a2 - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(52.0f, relativeLayout.getContext()), -2));
            float b2 = (float) b(dArr, dArr2);
            double[] a3 = a(a2, dArr, dArr2);
            connectionLineView.setX((float) (a3[0] + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(52.0f, relativeLayout.getContext()) / 2)));
            connectionLineView.setY((float) a3[1]);
            if (dArr[1] > dArr2[1]) {
                b2 = 180.0f - b2;
            }
            connectionLineView.setRotation(b2);
            relativeLayout.addView(connectionLineView, i + 1);
            this.oBl.put(o, connectionLineView);
            if (this.oBn != null) {
                this.oBn.Wt(o);
            }
        }
    }

    public synchronized void Wr(String str) {
        if (!ListUtils.isEmpty(this.oBl) && this.oBl.containsKey(str)) {
            ConnectionLineView connectionLineView = this.oBl.get(str);
            if (connectionLineView != null && this.ltF.indexOfChild(connectionLineView) != -1) {
                this.ltF.removeView(connectionLineView);
            }
            this.oBl.remove(str);
        }
    }

    public synchronized void eeS() {
        if (!ListUtils.isEmpty(this.oBl)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oBl.entrySet()) {
                Wr(entry.getKey());
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
        return new double[]{((dArr[0] + dArr2[0]) - i) / 2.0d, ((dArr[1] + dArr2[1]) / 2.0d) - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.c(11.0f, this.ltF.getContext())};
    }

    public void a(a aVar) {
        this.oBn = aVar;
    }

    public synchronized void p(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.oBl) && (connectionLineView = this.oBl.get(o(iArr))) != null) {
            connectionLineView.egA();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> eeT() {
        return this.oBl;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.oBm != null) {
            if (this.oBm.containsKey(str)) {
                this.oBm.remove(str);
            }
            this.oBm.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean Ws(String str) {
        return (this.oBm == null || !this.oBm.containsKey(str)) ? false : this.oBm.get(str).booleanValue();
    }

    public synchronized void eeU() {
        if (this.oBm != null) {
            this.oBm.clear();
        }
    }
}
