package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import android.widget.RelativeLayout;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.yuyinala.liveroom.wheat.view.ConnectionLineView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes11.dex */
public class f {
    private RelativeLayout ltF;
    private final ConcurrentHashMap<String, ConnectionLineView> oBm = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Boolean> oBn = new ConcurrentHashMap<>();
    private a oBo;

    /* loaded from: classes11.dex */
    public interface a {
        void Wu(String str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r8.ltF.indexOfChild(r8.oBm.get(r1)) == (-1)) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int[] iArr, RelativeLayout relativeLayout, double[] dArr, double[] dArr2, int i) {
        if (dArr[0] != dArr2[0] || dArr[1] != dArr2[1]) {
            String o = o(iArr);
            if (this.oBm.containsKey(o)) {
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
            this.oBm.put(o, connectionLineView);
            if (this.oBo != null) {
                this.oBo.Wu(o);
            }
        }
    }

    public synchronized void Ws(String str) {
        if (!ListUtils.isEmpty(this.oBm) && this.oBm.containsKey(str)) {
            ConnectionLineView connectionLineView = this.oBm.get(str);
            if (connectionLineView != null && this.ltF.indexOfChild(connectionLineView) != -1) {
                this.ltF.removeView(connectionLineView);
            }
            this.oBm.remove(str);
        }
    }

    public synchronized void eeR() {
        if (!ListUtils.isEmpty(this.oBm)) {
            for (Map.Entry<String, ConnectionLineView> entry : this.oBm.entrySet()) {
                Ws(entry.getKey());
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
        this.oBo = aVar;
    }

    public synchronized void p(int[] iArr) {
        ConnectionLineView connectionLineView;
        if (!ListUtils.isEmpty(this.oBm) && (connectionLineView = this.oBm.get(o(iArr))) != null) {
            connectionLineView.egz();
        }
    }

    public ConcurrentHashMap<String, ConnectionLineView> eeS() {
        return this.oBm;
    }

    public synchronized void bh(String str, boolean z) {
        if (this.oBn != null) {
            if (this.oBn.containsKey(str)) {
                this.oBn.remove(str);
            }
            this.oBn.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized boolean Wt(String str) {
        return (this.oBn == null || !this.oBn.containsKey(str)) ? false : this.oBn.get(str).booleanValue();
    }

    public synchronized void eeT() {
        if (this.oBn != null) {
            this.oBn.clear();
        }
    }
}
