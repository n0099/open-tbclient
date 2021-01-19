package com.bytedance.a;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bytedance.embedapplog.bb;
import com.bytedance.embedapplog.bh;
import com.bytedance.embedapplog.bi;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes4.dex */
public final class b {
    private String oaid;
    private String resultCode;
    private final AtomicBoolean pbT = new AtomicBoolean();
    private volatile boolean pbU = false;
    private final Object mLock = new Object();
    private IIdentifierListener pbV = new IIdentifierListener() { // from class: com.bytedance.a.b.1
    };

    public void hL(Context context) {
        synchronized (this.mLock) {
            this.pbU = true;
            int hM = hM(context);
            if (hM == 1008612) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 不支持的设备");
                this.resultCode = "不支持的设备";
            } else if (hM == 1008613) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 加载配置文件出错");
                this.resultCode = "加载配置文件出错";
            } else if (hM == 1008611) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 不支持的设备厂商");
                this.resultCode = "不支持的设备厂商";
            } else if (hM == 1008614) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.pbT.compareAndSet(false, true)) {
                    hL(context);
                } else {
                    this.resultCode = "结果会在回调中返回";
                }
            } else if (hM == 1008615) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 反射调用出错");
                this.resultCode = "反射调用出错";
            } else if (hM == 0) {
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 正确");
                this.resultCode = "正确";
            } else {
                this.resultCode = "未知 resultCode=" + hM;
                bb.b(bh.f5799a, "OaidMiit#getDeviceIds 未知 resultCode=" + hM);
            }
        }
    }

    private int hM(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.pbV);
    }

    public bi.a hN(Context context) {
        synchronized (this.mLock) {
            if (this.pbU) {
                this.mLock.wait(10000L);
            }
        }
        bi.a aVar = new bi.a();
        aVar.f5801b = this.oaid;
        return aVar;
    }
}
