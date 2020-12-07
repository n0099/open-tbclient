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
    private static a mSl = null;

    private a() {
    }

    public static a dHh() {
        a aVar;
        if (mSl != null) {
            return mSl;
        }
        synchronized (a.class) {
            if (mSl == null) {
                mSl = new a();
            }
            aVar = mSl;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dHl().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dHl().setPackageName(str);
    }

    public static void SB(String str) {
        com.baidu.tieba.sdk.d.a.SB(str);
    }

    public static void SC(String str) {
        com.baidu.tieba.sdk.d.a.SC(str);
    }

    public void d(Application application) {
        com.baidu.tieba.sdk.d.a.dHl().d(application);
    }

    public void dHi() {
        com.baidu.tieba.sdk.d.a.dHl().dHi();
    }

    public void dHj() {
        com.baidu.tieba.sdk.d.a.dHl().dHj();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHl().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHl().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHl().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(cVar);
    }

    public void gv(Context context) {
        bd(context, null);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHl().bc(context, str);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHl().bd(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHl().d(context, str, z, str2, jSONObject);
    }

    public void SD(String str) {
        com.baidu.tieba.sdk.login.a.dHz().dHA();
        com.baidu.tieba.sdk.d.a.dHl().SD(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(eVar);
    }

    public void hD(long j) {
        com.baidu.tieba.sdk.d.a.dHl().hD(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dHl().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dHl().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dHl().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dHl().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(cVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dHl().f(context, str, i);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHl().gx(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dHl().a(context, j, i);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHl().gy(context);
    }

    public void x(Context context, String str, String str2) {
        if (com.baidu.live.ae.a.RB().brA != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.ae.a.RB().brA.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dHl().x(context, str2, str);
    }

    public void gw(Context context) {
        com.baidu.tieba.sdk.d.a.dHl().gw(context);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHl().bg(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dHl().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dHl().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dHl().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dHl().openScheme(context, str, schemeCallback);
    }

    public void SE(String str) {
        com.baidu.tieba.sdk.d.a.dHl().SE(str);
    }

    public void SF(String str) {
        com.baidu.tieba.sdk.d.a.dHl().SF(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dHl().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dHl().setSubappVersionCode(i);
    }

    public void y(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dHl().y(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dHl().setResourceAdapter(iResourceAdapter);
    }

    public void dHk() {
        com.baidu.tieba.sdk.d.a.dHl().dHk();
    }

    public void bI(String str, int i) {
        com.baidu.tieba.sdk.d.a.dHl().bI(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dHl().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dHl().a(dVar);
    }
}
