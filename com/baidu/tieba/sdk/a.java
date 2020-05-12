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
    private static a kAL = null;

    private a() {
    }

    public static a cPd() {
        a aVar;
        if (kAL != null) {
            return kAL;
        }
        synchronized (a.class) {
            if (kAL == null) {
                kAL = new a();
            }
            aVar = kAL;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.cPh().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.cPh().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.c.a.cPh().init(application);
    }

    public void cPe() {
        com.baidu.tieba.sdk.c.a.cPh().cPe();
    }

    public void cPf() {
        com.baidu.tieba.sdk.c.a.cPh().cPf();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.cPh().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(dVar);
    }

    public void eU(Context context) {
        aP(context, null);
    }

    public void aP(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPh().aP(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPh().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPh().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPh().b(context, str, z, str2, jSONObject);
    }

    public void JU(String str) {
        com.baidu.tieba.sdk.login.a.cPr().cPs();
        com.baidu.tieba.sdk.c.a.cPh().JU(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.cPh().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.cPh().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.cPh().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.cPh().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.c.a.cPh().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.cPh().f(context, str, i);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPh().eW(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.cPh().a(context, j, i);
    }

    public void aR(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPh().eX(context);
    }

    public void v(Context context, String str, String str2) {
        if (com.baidu.live.v.a.En().aQu != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.En().aQu.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.cPh().v(context, str2, str);
    }

    public void eV(Context context) {
        com.baidu.tieba.sdk.c.a.cPh().eV(context);
    }

    public void aS(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPh().aS(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.cPh().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.cPh().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.cPh().openScheme(context, str, schemeCallback);
    }

    public void JV(String str) {
        com.baidu.tieba.sdk.c.a.cPh().JV(str);
    }

    public void JW(String str) {
        com.baidu.tieba.sdk.c.a.cPh().JW(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.cPh().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.cPh().setSubappVersionCode(i);
    }

    public void w(Context context, String str, String str2) {
        com.baidu.tieba.sdk.c.a.cPh().w(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.cPh().setResourceAdapter(iResourceAdapter);
    }

    public void cPg() {
        com.baidu.tieba.sdk.c.a.cPh().cPg();
    }

    public void bz(String str, int i) {
        com.baidu.tieba.sdk.c.a.cPh().bz(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.c.a.cPh().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }
}
