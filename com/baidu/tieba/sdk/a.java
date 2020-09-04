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
import com.baidu.tieba.sdk.b.d;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.b.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static a lMM = null;

    private a() {
    }

    public static a dpn() {
        a aVar;
        if (lMM != null) {
            return lMM;
        }
        synchronized (a.class) {
            if (lMM == null) {
                lMM = new a();
            }
            aVar = lMM;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dpr().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dpr().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dpr().init(application);
    }

    public void dpo() {
        com.baidu.tieba.sdk.d.a.dpr().dpo();
    }

    public void dpp() {
        com.baidu.tieba.sdk.d.a.dpr().dpp();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dpr().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(dVar);
    }

    public void fz(Context context) {
        aU(context, null);
    }

    public void aU(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpr().aU(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpr().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpr().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpr().b(context, str, z, str2, jSONObject);
    }

    public void PN(String str) {
        com.baidu.tieba.sdk.login.a.dpC().dpD();
        com.baidu.tieba.sdk.d.a.dpr().PN(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(fVar);
    }

    public void fS(long j) {
        com.baidu.tieba.sdk.d.a.dpr().fS(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dpr().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dpr().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dpr().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dpr().c(eVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dpr().e(context, str, i);
    }

    public void aV(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpr().fB(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dpr().a(context, j, i);
    }

    public void aW(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpr().fC(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.w.a.Nk().beJ != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.w.a.Nk().beJ.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dpr().t(context, str2, str);
    }

    public void fA(Context context) {
        com.baidu.tieba.sdk.d.a.dpr().fA(context);
    }

    public void aX(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpr().aX(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dpr().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dpr().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dpr().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dpr().openScheme(context, str, schemeCallback);
    }

    public void PO(String str) {
        com.baidu.tieba.sdk.d.a.dpr().PO(str);
    }

    public void PP(String str) {
        com.baidu.tieba.sdk.d.a.dpr().PP(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dpr().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dpr().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dpr().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dpr().setResourceAdapter(iResourceAdapter);
    }

    public void dpq() {
        com.baidu.tieba.sdk.d.a.dpr().dpq();
    }

    public void bC(String str, int i) {
        com.baidu.tieba.sdk.d.a.dpr().bC(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dpr().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dpr().a(dVar);
    }
}
