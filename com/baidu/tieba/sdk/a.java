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
import com.baidu.searchbox.live.base.LiveBaseActivity;
import com.baidu.tieba.sdk.b.b;
import com.baidu.tieba.sdk.b.c;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.e.d;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static a ncx = null;

    private a() {
    }

    public static a dFp() {
        a aVar;
        if (ncx != null) {
            return ncx;
        }
        synchronized (a.class) {
            if (ncx == null) {
                ncx = new a();
            }
            aVar = ncx;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dFt().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dFt().setPackageName(str);
    }

    public static void RX(String str) {
        com.baidu.tieba.sdk.d.a.RX(str);
    }

    public static void RY(String str) {
        com.baidu.tieba.sdk.d.a.RY(str);
    }

    public void c(Application application) {
        com.baidu.tieba.sdk.d.a.dFt().c(application);
    }

    public void dFq() {
        com.baidu.tieba.sdk.d.a.dFt().dFq();
    }

    public void dFr() {
        com.baidu.tieba.sdk.d.a.dFt().dFr();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFt().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFt().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFt().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(cVar);
    }

    public void gP(Context context) {
        bg(context, null);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFt().bf(context, str);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFt().bg(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFt().d(context, str, z, str2, jSONObject);
    }

    public void RZ(String str) {
        com.baidu.tieba.sdk.login.a.dFI().dFJ();
        com.baidu.tieba.sdk.d.a.dFt().RZ(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(eVar);
    }

    public void hD(long j) {
        com.baidu.tieba.sdk.d.a.dFt().hD(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dFt().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dFt().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dFt().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dFt().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(cVar);
    }

    public void g(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dFt().g(context, str, i);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFt().gR(context);
    }

    public void b(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dFt().b(context, j, i);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFt().gS(context);
    }

    public void y(Context context, String str, String str2) {
        if (com.baidu.live.ae.a.Qj().buX != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.ae.a.Qj().buX.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dFt().y(context, str2, str);
    }

    public void gQ(Context context) {
        com.baidu.tieba.sdk.d.a.dFt().gQ(context);
    }

    public void bj(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFt().bj(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dFt().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dFt().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dFt().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dFt().openScheme(context, str, schemeCallback);
    }

    public void Sa(String str) {
        com.baidu.tieba.sdk.d.a.dFt().Sa(str);
    }

    public void Sb(String str) {
        com.baidu.tieba.sdk.d.a.dFt().Sb(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dFt().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dFt().setSubappVersionCode(i);
    }

    public void z(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dFt().z(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dFt().setResourceAdapter(iResourceAdapter);
    }

    public void dFs() {
        com.baidu.tieba.sdk.d.a.dFt().dFs();
    }

    public void bQ(String str, int i) {
        com.baidu.tieba.sdk.d.a.dFt().bQ(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dFt().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dFt().a(dVar);
    }
}
