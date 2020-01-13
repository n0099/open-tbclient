package com.baidu.tieba.sdk;

import android.app.Application;
import android.content.Context;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.live.tbadk.ISdkInitCallback;
import com.baidu.live.tbadk.ala.zan.IAlaBdZanBuilder;
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
/* loaded from: classes2.dex */
public class a {
    private static a jOC = null;

    private a() {
    }

    public static a cCD() {
        a aVar;
        if (jOC != null) {
            return jOC;
        }
        synchronized (a.class) {
            if (jOC == null) {
                jOC = new a();
            }
            aVar = jOC;
        }
        return aVar;
    }

    public static void a(ISdkInitCallback iSdkInitCallback) {
        com.baidu.tieba.sdk.c.a.a(iSdkInitCallback);
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.cCH().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.cCH().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.c.a.cCH().init(application);
    }

    public void cCE() {
        com.baidu.tieba.sdk.c.a.cCH().cCE();
    }

    public void cCF() {
        com.baidu.tieba.sdk.c.a.cCH().cCF();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.cCH().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(dVar);
    }

    public void fp(Context context) {
        bg(context, null);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cCH().bg(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cCH().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cCH().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cCH().b(context, str, z, str2, jSONObject);
    }

    public void HY(String str) {
        com.baidu.tieba.sdk.login.a.cCR().cCS();
        com.baidu.tieba.sdk.c.a.cCH().HY(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.cCH().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.cCH().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.cCH().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.cCH().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.d.b bVar) {
        com.baidu.tieba.sdk.c.a.cCH().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.cCH().f(context, str, i);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cCH().fr(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.cCH().a(context, j, i);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cCH().fs(context);
    }

    public void u(Context context, String str, String str2) {
        if (com.baidu.live.s.a.wR().asq != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.s.a.wR().asq.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.cCH().u(context, str2, str);
    }

    public void fq(Context context) {
        com.baidu.tieba.sdk.c.a.cCH().fq(context);
    }

    public void bj(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cCH().bj(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.cCH().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.cCH().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.cCH().openScheme(context, str, schemeCallback);
    }

    public void HZ(String str) {
        com.baidu.tieba.sdk.c.a.cCH().HZ(str);
    }

    public void Ia(String str) {
        com.baidu.tieba.sdk.c.a.cCH().Ia(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.cCH().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.cCH().setSubappVersionCode(i);
    }

    public void v(Context context, String str, String str2) {
        com.baidu.tieba.sdk.c.a.cCH().v(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.cCH().setResourceAdapter(iResourceAdapter);
    }

    public void cCG() {
        com.baidu.tieba.sdk.c.a.cCH().cCG();
    }
}
