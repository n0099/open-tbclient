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
    private static a mXN = null;

    private a() {
    }

    public static a dGX() {
        a aVar;
        if (mXN != null) {
            return mXN;
        }
        synchronized (a.class) {
            if (mXN == null) {
                mXN = new a();
            }
            aVar = mXN;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dHb().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dHb().setPackageName(str);
    }

    public static void Sk(String str) {
        com.baidu.tieba.sdk.d.a.Sk(str);
    }

    public static void Sl(String str) {
        com.baidu.tieba.sdk.d.a.Sl(str);
    }

    public void c(Application application) {
        com.baidu.tieba.sdk.d.a.dHb().c(application);
    }

    public void dGY() {
        com.baidu.tieba.sdk.d.a.dHb().dGY();
    }

    public void dGZ() {
        com.baidu.tieba.sdk.d.a.dHb().dGZ();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHb().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dHb().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dHb().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(cVar);
    }

    public void gO(Context context) {
        bh(context, null);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHb().bg(context, str);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHb().bh(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dHb().d(context, str, z, str2, jSONObject);
    }

    public void Sm(String str) {
        com.baidu.tieba.sdk.login.a.dHq().dHr();
        com.baidu.tieba.sdk.d.a.dHb().Sm(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(eVar);
    }

    public void hy(long j) {
        com.baidu.tieba.sdk.d.a.dHb().hy(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dHb().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dHb().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dHb().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dHb().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(cVar);
    }

    public void g(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dHb().g(context, str, i);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHb().gQ(context);
    }

    public void b(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dHb().b(context, j, i);
    }

    public void bj(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHb().gR(context);
    }

    public void y(Context context, String str, String str2) {
        if (com.baidu.live.af.a.SE().bwi != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.af.a.SE().bwi.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dHb().y(context, str2, str);
    }

    public void gP(Context context) {
        com.baidu.tieba.sdk.d.a.dHb().gP(context);
    }

    public void bk(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dHb().bk(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dHb().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dHb().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dHb().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dHb().openScheme(context, str, schemeCallback);
    }

    public void Sn(String str) {
        com.baidu.tieba.sdk.d.a.dHb().Sn(str);
    }

    public void So(String str) {
        com.baidu.tieba.sdk.d.a.dHb().So(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dHb().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dHb().setSubappVersionCode(i);
    }

    public void z(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dHb().z(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dHb().setResourceAdapter(iResourceAdapter);
    }

    public void dHa() {
        com.baidu.tieba.sdk.d.a.dHb().dHa();
    }

    public void bP(String str, int i) {
        com.baidu.tieba.sdk.d.a.dHb().bP(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dHb().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dHb().a(dVar);
    }
}
