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
import com.baidu.tieba.sdk.a.b;
import com.baidu.tieba.sdk.a.d;
import com.baidu.tieba.sdk.a.e;
import com.baidu.tieba.sdk.a.f;
import com.baidu.tieba.sdk.a.g;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private static a jPR = null;

    private a() {
    }

    public static a cEj() {
        a aVar;
        if (jPR != null) {
            return jPR;
        }
        synchronized (a.class) {
            if (jPR == null) {
                jPR = new a();
            }
            aVar = jPR;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.cEn().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.cEn().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.c.a.cEn().init(application);
    }

    public void cEk() {
        com.baidu.tieba.sdk.c.a.cEn().cEk();
    }

    public void cEl() {
        com.baidu.tieba.sdk.c.a.cEn().cEl();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.cEn().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(dVar);
    }

    public void fp(Context context) {
        bg(context, null);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cEn().bg(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cEn().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cEn().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cEn().b(context, str, z, str2, jSONObject);
    }

    public void In(String str) {
        com.baidu.tieba.sdk.login.a.cEx().cEy();
        com.baidu.tieba.sdk.c.a.cEn().In(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.cEn().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.cEn().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.cEn().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.cEn().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.c.a.cEn().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.cEn().f(context, str, i);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cEn().fr(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.cEn().a(context, j, i);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cEn().fs(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.v.a.zl().awC != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.zl().awC.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.cEn().t(context, str2, str);
    }

    public void fq(Context context) {
        com.baidu.tieba.sdk.c.a.cEn().fq(context);
    }

    public void bj(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cEn().bj(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.cEn().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.cEn().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.cEn().openScheme(context, str, schemeCallback);
    }

    public void Io(String str) {
        com.baidu.tieba.sdk.c.a.cEn().Io(str);
    }

    public void Ip(String str) {
        com.baidu.tieba.sdk.c.a.cEn().Ip(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.cEn().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.cEn().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.c.a.cEn().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.cEn().setResourceAdapter(iResourceAdapter);
    }

    public void cEm() {
        com.baidu.tieba.sdk.c.a.cEn().cEm();
    }

    public void bp(String str, int i) {
        com.baidu.tieba.sdk.c.a.cEn().bp(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.c.a.cEn().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }
}
