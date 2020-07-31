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
import com.baidu.tieba.sdk.b.b;
import com.baidu.tieba.sdk.b.d;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.b.g;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a lvk = null;

    private a() {
    }

    public static a ddS() {
        a aVar;
        if (lvk != null) {
            return lvk;
        }
        synchronized (a.class) {
            if (lvk == null) {
                lvk = new a();
            }
            aVar = lvk;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.ddW().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.ddW().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.ddW().init(application);
    }

    public void ddT() {
        com.baidu.tieba.sdk.d.a.ddW().ddT();
    }

    public void ddU() {
        com.baidu.tieba.sdk.d.a.ddW().ddU();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.ddW().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(dVar);
    }

    public void fm(Context context) {
        aP(context, null);
    }

    public void aP(Context context, String str) {
        com.baidu.tieba.sdk.d.a.ddW().aP(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.ddW().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.ddW().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.ddW().b(context, str, z, str2, jSONObject);
    }

    public void MQ(String str) {
        com.baidu.tieba.sdk.login.a.deh().dei();
        com.baidu.tieba.sdk.d.a.ddW().MQ(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(fVar);
    }

    public void fE(long j) {
        com.baidu.tieba.sdk.d.a.ddW().fE(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.ddW().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.ddW().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.ddW().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.d.a.ddW().c(bVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.ddW().e(context, str, i);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.ddW().fo(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.ddW().a(context, j, i);
    }

    public void aR(Context context, String str) {
        com.baidu.tieba.sdk.d.a.ddW().fp(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.v.a.Hs().aZn != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.Hs().aZn.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.ddW().t(context, str2, str);
    }

    public void fn(Context context) {
        com.baidu.tieba.sdk.d.a.ddW().fn(context);
    }

    public void aS(Context context, String str) {
        com.baidu.tieba.sdk.d.a.ddW().aS(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.ddW().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.ddW().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.ddW().openScheme(context, str, schemeCallback);
    }

    public void MR(String str) {
        com.baidu.tieba.sdk.d.a.ddW().MR(str);
    }

    public void MS(String str) {
        com.baidu.tieba.sdk.d.a.ddW().MS(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.ddW().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.ddW().setSubappVersionCode(i);
    }

    public void u(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.ddW().u(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.ddW().setResourceAdapter(iResourceAdapter);
    }

    public void ddV() {
        com.baidu.tieba.sdk.d.a.ddW().ddV();
    }

    public void bx(String str, int i) {
        com.baidu.tieba.sdk.d.a.ddW().bx(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.ddW().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.ddW().a(dVar);
    }
}
