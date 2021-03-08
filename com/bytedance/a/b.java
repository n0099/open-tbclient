package com.bytedance.a;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bytedance.embedapplog.bb;
import com.bytedance.embedapplog.bh;
import com.bytedance.embedapplog.bi;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class b {
    private String oaid;
    private String resultCode;
    private final AtomicBoolean poQ = new AtomicBoolean();
    private volatile boolean poR = false;
    private final Object mLock = new Object();
    private IIdentifierListener poS = new IIdentifierListener() { // from class: com.bytedance.a.b.1
    };

    public void hN(Context context) {
        synchronized (this.mLock) {
            this.poR = true;
            int hO = hO(context);
            if (hO == 1008612) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 不支持的设备");
                this.resultCode = "不支持的设备";
            } else if (hO == 1008613) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 加载配置文件出错");
                this.resultCode = "加载配置文件出错";
            } else if (hO == 1008611) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 不支持的设备厂商");
                this.resultCode = "不支持的设备厂商";
            } else if (hO == 1008614) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.poQ.compareAndSet(false, true)) {
                    hN(context);
                } else {
                    this.resultCode = "结果会在回调中返回";
                }
            } else if (hO == 1008615) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 反射调用出错");
                this.resultCode = "反射调用出错";
            } else if (hO == 0) {
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 正确");
                this.resultCode = "正确";
            } else {
                this.resultCode = "未知 resultCode=" + hO;
                bb.b(bh.f3915a, "OaidMiit#getDeviceIds 未知 resultCode=" + hO);
            }
        }
    }

    private int hO(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.poS);
    }

    public bi.a hP(Context context) {
        synchronized (this.mLock) {
            if (this.poR) {
                this.mLock.wait(10000L);
            }
        }
        bi.a aVar = new bi.a();
        aVar.b = this.oaid;
        return aVar;
    }
}
