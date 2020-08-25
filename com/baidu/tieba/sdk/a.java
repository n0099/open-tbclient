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
    private static a lMz = null;

    private a() {
    }

    public static a dpk() {
        a aVar;
        if (lMz != null) {
            return lMz;
        }
        synchronized (a.class) {
            if (lMz == null) {
                lMz = new a();
            }
            aVar = lMz;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dpo().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dpo().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dpo().init(application);
    }

    public void dpl() {
        com.baidu.tieba.sdk.d.a.dpo().dpl();
    }

    public void dpm() {
        com.baidu.tieba.sdk.d.a.dpo().dpm();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dpo().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(dVar);
    }

    public void fz(Context context) {
        aU(context, null);
    }

    public void aU(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpo().aU(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpo().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpo().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dpo().b(context, str, z, str2, jSONObject);
    }

    public void PN(String str) {
        com.baidu.tieba.sdk.login.a.dpz().dpA();
        com.baidu.tieba.sdk.d.a.dpo().PN(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(fVar);
    }

    public void fQ(long j) {
        com.baidu.tieba.sdk.d.a.dpo().fQ(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dpo().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dpo().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dpo().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dpo().c(eVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dpo().e(context, str, i);
    }

    public void aV(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpo().fB(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dpo().a(context, j, i);
    }

    public void aW(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpo().fC(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.w.a.Nk().beH != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.w.a.Nk().beH.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dpo().t(context, str2, str);
    }

    public void fA(Context context) {
        com.baidu.tieba.sdk.d.a.dpo().fA(context);
    }

    public void aX(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dpo().aX(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dpo().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dpo().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dpo().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dpo().openScheme(context, str, schemeCallback);
    }

    public void PO(String str) {
        com.baidu.tieba.sdk.d.a.dpo().PO(str);
    }

    public void PP(String str) {
        com.baidu.tieba.sdk.d.a.dpo().PP(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dpo().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dpo().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dpo().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dpo().setResourceAdapter(iResourceAdapter);
    }

    public void dpn() {
        com.baidu.tieba.sdk.d.a.dpo().dpn();
    }

    public void bC(String str, int i) {
        com.baidu.tieba.sdk.d.a.dpo().bC(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dpo().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dpo().a(dVar);
    }
}
