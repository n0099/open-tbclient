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
    private static a ncX = null;

    private a() {
    }

    public static a dFx() {
        a aVar;
        if (ncX != null) {
            return ncX;
        }
        synchronized (a.class) {
            if (ncX == null) {
                ncX = new a();
            }
            aVar = ncX;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dFB().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dFB().setPackageName(str);
    }

    public static void Sj(String str) {
        com.baidu.tieba.sdk.d.a.Sj(str);
    }

    public static void Sk(String str) {
        com.baidu.tieba.sdk.d.a.Sk(str);
    }

    public void c(Application application) {
        com.baidu.tieba.sdk.d.a.dFB().c(application);
    }

    public void dFy() {
        com.baidu.tieba.sdk.d.a.dFB().dFy();
    }

    public void dFz() {
        com.baidu.tieba.sdk.d.a.dFB().dFz();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFB().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dFB().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dFB().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(cVar);
    }

    public void gP(Context context) {
        bf(context, null);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFB().be(context, str);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFB().bf(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dFB().d(context, str, z, str2, jSONObject);
    }

    public void Sl(String str) {
        com.baidu.tieba.sdk.login.a.dFQ().dFR();
        com.baidu.tieba.sdk.d.a.dFB().Sl(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(eVar);
    }

    public void hD(long j) {
        com.baidu.tieba.sdk.d.a.dFB().hD(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dFB().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dFB().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dFB().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dFB().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(cVar);
    }

    public void g(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dFB().g(context, str, i);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFB().gR(context);
    }

    public void b(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dFB().b(context, j, i);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFB().gS(context);
    }

    public void x(Context context, String str, String str2) {
        if (com.baidu.live.ae.a.Qj().buX != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.ae.a.Qj().buX.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dFB().x(context, str2, str);
    }

    public void gQ(Context context) {
        com.baidu.tieba.sdk.d.a.dFB().gQ(context);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dFB().bi(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dFB().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dFB().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dFB().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dFB().openScheme(context, str, schemeCallback);
    }

    public void Sm(String str) {
        com.baidu.tieba.sdk.d.a.dFB().Sm(str);
    }

    public void Sn(String str) {
        com.baidu.tieba.sdk.d.a.dFB().Sn(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dFB().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dFB().setSubappVersionCode(i);
    }

    public void y(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dFB().y(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dFB().setResourceAdapter(iResourceAdapter);
    }

    public void dFA() {
        com.baidu.tieba.sdk.d.a.dFB().dFA();
    }

    public void bQ(String str, int i) {
        com.baidu.tieba.sdk.d.a.dFB().bQ(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dFB().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dFB().a(dVar);
    }
}
