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
    private final AtomicBoolean pmI = new AtomicBoolean();
    private volatile boolean pmJ = false;
    private final Object mLock = new Object();
    private IIdentifierListener pmK = new IIdentifierListener() { // from class: com.bytedance.a.b.1
    };

    public void hO(Context context) {
        synchronized (this.mLock) {
            this.pmJ = true;
            int hP = hP(context);
            if (hP == 1008612) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 不支持的设备");
                this.resultCode = "不支持的设备";
            } else if (hP == 1008613) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 加载配置文件出错");
                this.resultCode = "加载配置文件出错";
            } else if (hP == 1008611) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 不支持的设备厂商");
                this.resultCode = "不支持的设备厂商";
            } else if (hP == 1008614) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 获取接口是异步的，结果会在回调中返回，回调执行的回调可能在工作线程");
                if (this.pmI.compareAndSet(false, true)) {
                    hO(context);
                } else {
                    this.resultCode = "结果会在回调中返回";
                }
            } else if (hP == 1008615) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 反射调用出错");
                this.resultCode = "反射调用出错";
            } else if (hP == 0) {
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 正确");
                this.resultCode = "正确";
            } else {
                this.resultCode = "未知 resultCode=" + hP;
                bb.b(bh.f5801a, "OaidMiit#getDeviceIds 未知 resultCode=" + hP);
            }
        }
    }

    private int hP(Context context) {
        return MdidSdkHelper.InitSdk(context, true, this.pmK);
    }

    public bi.a hQ(Context context) {
        synchronized (this.mLock) {
            if (this.pmJ) {
                this.mLock.wait(10000L);
            }
        }
        bi.a aVar = new bi.a();
        aVar.f5803b = this.oaid;
        return aVar;
    }
}
