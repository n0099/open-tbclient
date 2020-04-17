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
    private static a kAH = null;

    private a() {
    }

    public static a cPf() {
        a aVar;
        if (kAH != null) {
            return kAH;
        }
        synchronized (a.class) {
            if (kAH == null) {
                kAH = new a();
            }
            aVar = kAH;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.cPj().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.cPj().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.c.a.cPj().init(application);
    }

    public void cPg() {
        com.baidu.tieba.sdk.c.a.cPj().cPg();
    }

    public void cPh() {
        com.baidu.tieba.sdk.c.a.cPj().cPh();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.cPj().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(dVar);
    }

    public void fg(Context context) {
        bb(context, null);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPj().bb(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPj().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPj().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.cPj().b(context, str, z, str2, jSONObject);
    }

    public void JR(String str) {
        com.baidu.tieba.sdk.login.a.cPt().cPu();
        com.baidu.tieba.sdk.c.a.cPj().JR(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.cPj().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.cPj().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.cPj().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.cPj().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.c.a.cPj().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.cPj().f(context, str, i);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPj().fi(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.cPj().a(context, j, i);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPj().fj(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.v.a.Eo().aQp != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.Eo().aQp.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.cPj().t(context, str2, str);
    }

    public void fh(Context context) {
        com.baidu.tieba.sdk.c.a.cPj().fh(context);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.c.a.cPj().be(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.cPj().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.cPj().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.cPj().openScheme(context, str, schemeCallback);
    }

    public void JS(String str) {
        com.baidu.tieba.sdk.c.a.cPj().JS(str);
    }

    public void JT(String str) {
        com.baidu.tieba.sdk.c.a.cPj().JT(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.cPj().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.cPj().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.c.a.cPj().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.cPj().setResourceAdapter(iResourceAdapter);
    }

    public void cPi() {
        com.baidu.tieba.sdk.c.a.cPj().cPi();
    }

    public void bz(String str, int i) {
        com.baidu.tieba.sdk.c.a.cPj().bz(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.c.a.cPj().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }
}
