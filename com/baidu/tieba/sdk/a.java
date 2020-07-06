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
/* loaded from: classes3.dex */
public class a {
    private static a lnP = null;

    private a() {
    }

    public static a daL() {
        a aVar;
        if (lnP != null) {
            return lnP;
        }
        synchronized (a.class) {
            if (lnP == null) {
                lnP = new a();
            }
            aVar = lnP;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.daP().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.daP().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.daP().init(application);
    }

    public void daM() {
        com.baidu.tieba.sdk.d.a.daP().daM();
    }

    public void daN() {
        com.baidu.tieba.sdk.d.a.daP().daN();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.daP().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.daP().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.daP().a(dVar);
    }

    public void fj(Context context) {
        aQ(context, null);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.daP().aQ(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.daP().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.daP().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.daP().b(context, str, z, str2, jSONObject);
    }

    public void Mi(String str) {
        com.baidu.tieba.sdk.login.a.dba().dbb();
        com.baidu.tieba.sdk.d.a.daP().Mi(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.daP().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.daP().a(fVar);
    }

    public void fr(long j) {
        com.baidu.tieba.sdk.d.a.daP().fr(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.daP().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.daP().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.daP().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.daP().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.daP().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.daP().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.d.a.daP().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.daP().f(context, str, i);
    }

    public void aR(Context context, String str) {
        com.baidu.tieba.sdk.d.a.daP().fl(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.daP().a(context, j, i);
    }

    public void aS(Context context, String str) {
        com.baidu.tieba.sdk.d.a.daP().fm(context);
    }

    public void u(Context context, String str, String str2) {
        if (com.baidu.live.v.a.Hm().aZp != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.Hm().aZp.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.daP().u(context, str2, str);
    }

    public void fk(Context context) {
        com.baidu.tieba.sdk.d.a.daP().fk(context);
    }

    public void aT(Context context, String str) {
        com.baidu.tieba.sdk.d.a.daP().aT(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.daP().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.daP().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.daP().openScheme(context, str, schemeCallback);
    }

    public void Mj(String str) {
        com.baidu.tieba.sdk.d.a.daP().Mj(str);
    }

    public void Mk(String str) {
        com.baidu.tieba.sdk.d.a.daP().Mk(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.daP().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.daP().setSubappVersionCode(i);
    }

    public void v(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.daP().v(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.daP().setResourceAdapter(iResourceAdapter);
    }

    public void daO() {
        com.baidu.tieba.sdk.d.a.daP().daO();
    }

    public void bz(String str, int i) {
        com.baidu.tieba.sdk.d.a.daP().bz(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.daP().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.daP().a(dVar);
    }
}
