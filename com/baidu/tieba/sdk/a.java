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
    private static a kTW = null;

    private a() {
    }

    public static a cWv() {
        a aVar;
        if (kTW != null) {
            return kTW;
        }
        synchronized (a.class) {
            if (kTW == null) {
                kTW = new a();
            }
            aVar = kTW;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.cWz().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.cWz().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.cWz().init(application);
    }

    public void cWw() {
        com.baidu.tieba.sdk.d.a.cWz().cWw();
    }

    public void cWx() {
        com.baidu.tieba.sdk.d.a.cWz().cWx();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.cWz().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(dVar);
    }

    public void fj(Context context) {
        aQ(context, null);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWz().aQ(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWz().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWz().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWz().b(context, str, z, str2, jSONObject);
    }

    public void LH(String str) {
        com.baidu.tieba.sdk.login.a.cWK().cWL();
        com.baidu.tieba.sdk.d.a.cWz().LH(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.cWz().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.cWz().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.cWz().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.cWz().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.d.a.cWz().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.cWz().f(context, str, i);
    }

    public void aR(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWz().fl(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.cWz().a(context, j, i);
    }

    public void aS(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWz().fm(context);
    }

    public void u(Context context, String str, String str2) {
        if (com.baidu.live.v.a.Ge().aWF != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.Ge().aWF.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.cWz().u(context, str2, str);
    }

    public void fk(Context context) {
        com.baidu.tieba.sdk.d.a.cWz().fk(context);
    }

    public void aT(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWz().aT(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.cWz().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.cWz().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.cWz().openScheme(context, str, schemeCallback);
    }

    public void LI(String str) {
        com.baidu.tieba.sdk.d.a.cWz().LI(str);
    }

    public void LJ(String str) {
        com.baidu.tieba.sdk.d.a.cWz().LJ(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.cWz().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.cWz().setSubappVersionCode(i);
    }

    public void v(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.cWz().v(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.cWz().setResourceAdapter(iResourceAdapter);
    }

    public void cWy() {
        com.baidu.tieba.sdk.d.a.cWz().cWy();
    }

    public void bA(String str, int i) {
        com.baidu.tieba.sdk.d.a.cWz().bA(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.cWz().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }
}
