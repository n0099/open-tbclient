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
/* loaded from: classes10.dex */
public class a {
    private static a nfc = null;

    private a() {
    }

    public static a dFF() {
        a aVar;
        if (nfc != null) {
            return nfc;
        }
        synchronized (a.class) {
            if (nfc == null) {
                nfc = new a();
            }
            aVar = nfc;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().setPackageName(str);
    }

    public static void Sp(String str) {
        com.baidu.tieba.sdk.d.a.Sp(str);
    }

    public static void Sq(String str) {
        com.baidu.tieba.sdk.d.a.Sq(str);
    }

    public void c(Application application) {
        com.baidu.tieba.sdk.d.a.dFJ().c(application);
    }

    public void dFG() {
        com.baidu.tieba.sdk.d.a.dFJ().dFG();
    }

    public void dFH() {
        com.baidu.tieba.sdk.d.a.dFJ().dFH();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFJ().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFJ().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFJ().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(cVar);
    }

    public void gO(Context context) {
        bf(context, null);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFJ().be(context, str);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFJ().bf(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFJ().d(context, str, z, str2, jSONObject);
    }

    public void Sr(String str) {
        com.baidu.tieba.sdk.login.a.dFY().dFZ();
        com.baidu.tieba.sdk.d.a.dFJ().Sr(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(eVar);
    }

    public void hD(long j) {
        com.baidu.tieba.sdk.d.a.dFJ().hD(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dFJ().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dFJ().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dFJ().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(cVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dFJ().f(context, str, i);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFJ().gQ(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dFJ().a(context, j, i);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFJ().gR(context);
    }

    public void x(Context context, String str, String str2) {
        if (com.baidu.live.ae.a.Qm().bwx != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.ae.a.Qm().bwx.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dFJ().x(context, str2, str);
    }

    public void gP(Context context) {
        com.baidu.tieba.sdk.d.a.dFJ().gP(context);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFJ().bi(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dFJ().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dFJ().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dFJ().openScheme(context, str, schemeCallback);
    }

    public void Ss(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().Ss(str);
    }

    public void St(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().St(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dFJ().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dFJ().setSubappVersionCode(i);
    }

    public void y(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dFJ().y(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dFJ().setResourceAdapter(iResourceAdapter);
    }

    public void dFI() {
        com.baidu.tieba.sdk.d.a.dFJ().dFI();
    }

    public void bQ(String str, int i) {
        com.baidu.tieba.sdk.d.a.dFJ().bQ(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dFJ().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dFJ().a(dVar);
    }
}
