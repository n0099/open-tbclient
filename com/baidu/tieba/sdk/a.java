package com.baidu.tieba.sdk;

import android.app.Application;
import android.content.Context;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
import com.baidu.live.adp.widget.ICustomToast;
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
import com.baidu.tieba.sdk.b.c;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.e.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a mxO = null;

    private a() {
    }

    public static a dzQ() {
        a aVar;
        if (mxO != null) {
            return mxO;
        }
        synchronized (a.class) {
            if (mxO == null) {
                mxO = new a();
            }
            aVar = mxO;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dzU().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dzU().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dzU().init(application);
    }

    public void dzR() {
        com.baidu.tieba.sdk.d.a.dzU().dzR();
    }

    public void dzS() {
        com.baidu.tieba.sdk.d.a.dzU().dzS();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dzU().a(mAActivity);
    }

    public d b(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dzU().b(mAActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dzU().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(cVar);
    }

    public void fN(Context context) {
        bc(context, null);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dzU().bb(context, str);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dzU().bc(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dzU().d(context, str, z, str2, jSONObject);
    }

    public void RA(String str) {
        com.baidu.tieba.sdk.login.a.dAi().dAj();
        com.baidu.tieba.sdk.d.a.dzU().RA(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(eVar);
    }

    public void gz(long j) {
        com.baidu.tieba.sdk.d.a.dzU().gz(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dzU().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dzU().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dzU().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dzU().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dzU().e(context, str, i);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dzU().fP(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dzU().a(context, j, i);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dzU().fQ(context);
    }

    public void w(Context context, String str, String str2) {
        if (com.baidu.live.z.a.Pq().bmJ != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.z.a.Pq().bmJ.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dzU().w(context, str2, str);
    }

    public void fO(Context context) {
        com.baidu.tieba.sdk.d.a.dzU().fO(context);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dzU().bf(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dzU().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dzU().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dzU().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dzU().openScheme(context, str, schemeCallback);
    }

    public void RB(String str) {
        com.baidu.tieba.sdk.d.a.dzU().RB(str);
    }

    public void RC(String str) {
        com.baidu.tieba.sdk.d.a.dzU().RC(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dzU().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dzU().setSubappVersionCode(i);
    }

    public void x(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dzU().x(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dzU().setResourceAdapter(iResourceAdapter);
    }

    public void dzT() {
        com.baidu.tieba.sdk.d.a.dzU().dzT();
    }

    public void bE(String str, int i) {
        com.baidu.tieba.sdk.d.a.dzU().bE(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dzU().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dzU().a(dVar);
    }
}
