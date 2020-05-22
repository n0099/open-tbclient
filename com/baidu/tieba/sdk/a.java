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
    private static a kSN = null;

    private a() {
    }

    public static a cWf() {
        a aVar;
        if (kSN != null) {
            return kSN;
        }
        synchronized (a.class) {
            if (kSN == null) {
                kSN = new a();
            }
            aVar = kSN;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.cWj().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.cWj().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.cWj().init(application);
    }

    public void cWg() {
        com.baidu.tieba.sdk.d.a.cWj().cWg();
    }

    public void cWh() {
        com.baidu.tieba.sdk.d.a.cWj().cWh();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.cWj().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(dVar);
    }

    public void fj(Context context) {
        aQ(context, null);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWj().aQ(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWj().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWj().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.cWj().b(context, str, z, str2, jSONObject);
    }

    public void LG(String str) {
        com.baidu.tieba.sdk.login.a.cWu().cWv();
        com.baidu.tieba.sdk.d.a.cWj().LG(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.d.a.cWj().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.cWj().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.cWj().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.cWj().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.b bVar) {
        com.baidu.tieba.sdk.d.a.cWj().c(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.cWj().f(context, str, i);
    }

    public void aR(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWj().fl(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.cWj().a(context, j, i);
    }

    public void aS(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWj().fm(context);
    }

    public void u(Context context, String str, String str2) {
        if (com.baidu.live.v.a.Ge().aWF != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.v.a.Ge().aWF.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.cWj().u(context, str2, str);
    }

    public void fk(Context context) {
        com.baidu.tieba.sdk.d.a.cWj().fk(context);
    }

    public void aT(Context context, String str) {
        com.baidu.tieba.sdk.d.a.cWj().aT(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.cWj().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.cWj().checkScheme(str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.cWj().openScheme(context, str, schemeCallback);
    }

    public void LH(String str) {
        com.baidu.tieba.sdk.d.a.cWj().LH(str);
    }

    public void LI(String str) {
        com.baidu.tieba.sdk.d.a.cWj().LI(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.cWj().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.cWj().setSubappVersionCode(i);
    }

    public void v(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.cWj().v(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.cWj().setResourceAdapter(iResourceAdapter);
    }

    public void cWi() {
        com.baidu.tieba.sdk.d.a.cWj().cWi();
    }

    public void bA(String str, int i) {
        com.baidu.tieba.sdk.d.a.cWj().bA(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.cWj().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }
}
