package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class g {
    private RelativeLayout lxr;
    private final ConcurrentHashMap<String, ConnectionLineView> oGG = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> oGH = new ConcurrentHashMap<>();
    private a oGI;

    /* loaded from: classes11.dex */
    public interface a {
        void Wv(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.lxr.indexOfChild(r8.oGG.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String o = o(iArr);
            if (this.oGG.containsKey(o)) {
            }
            this.lxr = relativeLayout;
            ConnectionLineView connectionLineView = new ConnectionLineView(relativeLayout.getContext());
            int a2 = (int) a(dArr, dArr2);
            connectionLineView.setLayoutParams(new RelativeLayout.LayoutParams(a2 - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(52.0f, relativeLayout.getContext()), -2));
            float b2 = (float) b(dArr, dArr2);
            double[] a3 = a(a2, dArr, dArr2);
            connectionLineView.setX((float) (a3[0] + (com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(52.0f, relativeLayout.getContext()) / 2)));
            connectionLineView.setY((float) a3[1]);
            if (dArr[1] > dArr2[1]) {
                b2 = 180.0f - b2;
            }
            connectionLineView.setRotation(b2);
            relativeLayout.addView(connectionLineView, i + 1);
            this.oGG.put(o, connectionLineView);
            if (this.oGI != null) {
                this.oGI.Wv(o);
            }
        }
    }

    public synchronized void Wt(String str) {
        if (!ListUtils.isEmpty(this.oGG) && this.oGG.containsKey(str)) {
            ConnectionLineView connectionLineView = this.oGG.get(str);
            if (connectionLineView != null && this.lxr.indexOfChild(connectionLineView) != -1) {
                this.lxr.removeView(connectionLineView);
            }
            this.oGG.remove(str);
        }
    }

    public synchronized void edu() {
        if (!ListUtils.isEmpty(this.oGG)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oGG.entrySet()) {
                Wt(entry.getKey());
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
        return new double[]{((dArr[0] + dArr2[0]) - i) / 2.0d, ((dArr[1] + dArr2[1]) / 2.0d) - com.baidu.tieba.yuyinala.liveroom.wheat.e.e.d(11.0f, this.lxr.getContext())};
    }

    public void a(a aVar) {
        this.oGI = aVar;
    }

    public synchronized void p(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.oGG) && (connectionLineView = this.oGG.get(o(iArr))) != null) {
            connectionLineView.efe();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> edv() {
        return this.oGG;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.oGH != null) {
            if (this.oGH.containsKey(str)) {
                this.oGH.remove(str);
            }
            this.oGH.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean Wu(String str) {
        return (this.oGH == null || !this.oGH.containsKey(str)) ? false : this.oGH.get(str).booleanValue();
    }

    public synchronized void edw() {
        if (this.oGH != null) {
            this.oGH.clear();
        }
    }
}
