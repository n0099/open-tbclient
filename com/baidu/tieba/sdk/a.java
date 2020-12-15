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
/* loaded from: classes4.dex */
public class a {
    private static a mSn = null;

    private a() {
    }

    public static a dHi() {
        a aVar;
        if (mSn != null) {
            return mSn;
        }
        synchronized (a.class) {
            if (mSn == null) {
                mSn = new a();
            }
            aVar = mSn;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dHm().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dHm().setPackageName(str);
    }

    public static void SB(String str) {
        com.baidu.tieba.sdk.d.a.SB(str);
    }

    public static void SC(String str) {
        com.baidu.tieba.sdk.d.a.SC(str);
    }

    public void d(Application application) {
        com.baidu.tieba.sdk.d.a.dHm().d(application);
    }

    public void dHj() {
        com.baidu.tieba.sdk.d.a.dHm().dHj();
    }

    public void dHk() {
        com.baidu.tieba.sdk.d.a.dHm().dHk();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHm().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHm().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHm().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(cVar);
    }

    public void gv(Context context) {
        bd(context, null);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHm().bc(context, str);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHm().bd(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHm().d(context, str, z, str2, jSONObject);
    }

    public void SD(String str) {
        com.baidu.tieba.sdk.login.a.dHA().dHB();
        com.baidu.tieba.sdk.d.a.dHm().SD(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(eVar);
    }

    public void hD(long j) {
        com.baidu.tieba.sdk.d.a.dHm().hD(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dHm().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dHm().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dHm().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dHm().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(cVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dHm().f(context, str, i);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHm().gx(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dHm().a(context, j, i);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHm().gy(context);
    }

    public void x(Context context, String str, String str2) {
        if (com.baidu.live.ae.a.RB().brA != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.ae.a.RB().brA.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dHm().x(context, str2, str);
    }

    public void gw(Context context) {
        com.baidu.tieba.sdk.d.a.dHm().gw(context);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHm().bg(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dHm().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dHm().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dHm().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dHm().openScheme(context, str, schemeCallback);
    }

    public void SE(String str) {
        com.baidu.tieba.sdk.d.a.dHm().SE(str);
    }

    public void SF(String str) {
        com.baidu.tieba.sdk.d.a.dHm().SF(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dHm().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dHm().setSubappVersionCode(i);
    }

    public void y(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dHm().y(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dHm().setResourceAdapter(iResourceAdapter);
    }

    public void dHl() {
        com.baidu.tieba.sdk.d.a.dHm().dHl();
    }

    public void bI(String str, int i) {
        com.baidu.tieba.sdk.d.a.dHm().bI(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dHm().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dHm().a(dVar);
    }
}
