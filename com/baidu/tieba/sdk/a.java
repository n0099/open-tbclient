package com.baidu.tieba.sdk;

import android.app.Application;
import android.content.Context;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.live.liveroom.e.c;
import com.baidu.live.tbadk.ala.zan.IAlaBdZanBuilder;
import com.baidu.live.tbadk.attention.IAttentionStatusCallBack;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.location.interfaces.ILocationBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.scheme.SchemeCallback;
import com.baidu.live.tbadk.share.single.interfaces.IShareChannelBuild;
import com.baidu.live.tbadk.util.IResourceAdapter;
import com.baidu.megapp.ma.MAActivity;
import com.baidu.tieba.sdk.b.b;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.b.g;
import com.baidu.tieba.sdk.e.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a lVG = null;

    private a() {
    }

    public static a dsX() {
        a aVar;
        if (lVG != null) {
            return lVG;
        }
        synchronized (a.class) {
            if (lVG == null) {
                lVG = new a();
            }
            aVar = lVG;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dtb().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dtb().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dtb().init(application);
    }

    public void dsY() {
        com.baidu.tieba.sdk.d.a.dtb().dsY();
    }

    public void dsZ() {
        com.baidu.tieba.sdk.d.a.dtb().dsZ();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dtb().a(mAActivity);
    }

    public d b(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dtb().b(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(eVar);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(dVar);
    }

    public void fF(Context context) {
        aY(context, null);
    }

    public void aX(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dtb().aX(context, str);
    }

    public void aY(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dtb().aY(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dtb().d(context, str, z, str2, jSONObject);
    }

    public void Qn(String str) {
        com.baidu.tieba.sdk.login.a.dtp().dtq();
        com.baidu.tieba.sdk.d.a.dtb().Qn(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(fVar);
    }

    public void gg(long j) {
        com.baidu.tieba.sdk.d.a.dtb().gg(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dtb().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dtb().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dtb().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dtb().c(eVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dtb().e(context, str, i);
    }

    public void aZ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dtb().fH(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dtb().a(context, j, i);
    }

    public void ba(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dtb().fI(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.x.a.NN().bhy != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.x.a.NN().bhy.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dtb().t(context, str2, str);
    }

    public void fG(Context context) {
        com.baidu.tieba.sdk.d.a.dtb().fG(context);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dtb().bb(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dtb().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dtb().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dtb().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dtb().openScheme(context, str, schemeCallback);
    }

    public void Qo(String str) {
        com.baidu.tieba.sdk.d.a.dtb().Qo(str);
    }

    public void Qp(String str) {
        com.baidu.tieba.sdk.d.a.dtb().Qp(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dtb().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dtb().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dtb().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dtb().setResourceAdapter(iResourceAdapter);
    }

    public void dta() {
        com.baidu.tieba.sdk.d.a.dtb().dta();
    }

    public void bC(String str, int i) {
        com.baidu.tieba.sdk.d.a.dtb().bC(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dtb().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dtb().a(dVar);
    }
}
