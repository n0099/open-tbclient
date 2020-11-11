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
/* loaded from: classes4.dex */
public class a {
    private static a mDP = null;

    private a() {
    }

    public static a dCs() {
        a aVar;
        if (mDP != null) {
            return mDP;
        }
        synchronized (a.class) {
            if (mDP == null) {
                mDP = new a();
            }
            aVar = mDP;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dCw().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dCw().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dCw().init(application);
    }

    public void dCt() {
        com.baidu.tieba.sdk.d.a.dCw().dCt();
    }

    public void dCu() {
        com.baidu.tieba.sdk.d.a.dCw().dCu();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dCw().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dCw().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dCw().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(cVar);
    }

    public void fN(Context context) {
        bc(context, null);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCw().bb(context, str);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCw().bc(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCw().d(context, str, z, str2, jSONObject);
    }

    public void RR(String str) {
        com.baidu.tieba.sdk.login.a.dCK().dCL();
        com.baidu.tieba.sdk.d.a.dCw().RR(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(eVar);
    }

    public void gV(long j) {
        com.baidu.tieba.sdk.d.a.dCw().gV(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dCw().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dCw().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dCw().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dCw().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dCw().e(context, str, i);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCw().fP(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dCw().a(context, j, i);
    }

    public void be(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCw().fQ(context);
    }

    public void w(Context context, String str, String str2) {
        if (com.baidu.live.aa.a.PQ().bod != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.aa.a.PQ().bod.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dCw().w(context, str2, str);
    }

    public void fO(Context context) {
        com.baidu.tieba.sdk.d.a.dCw().fO(context);
    }

    public void bf(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCw().bf(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dCw().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dCw().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dCw().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dCw().openScheme(context, str, schemeCallback);
    }

    public void RS(String str) {
        com.baidu.tieba.sdk.d.a.dCw().RS(str);
    }

    public void RT(String str) {
        com.baidu.tieba.sdk.d.a.dCw().RT(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dCw().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dCw().setSubappVersionCode(i);
    }

    public void x(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dCw().x(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dCw().setResourceAdapter(iResourceAdapter);
    }

    public void dCv() {
        com.baidu.tieba.sdk.d.a.dCw().dCv();
    }

    public void bG(String str, int i) {
        com.baidu.tieba.sdk.d.a.dCw().bG(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dCw().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dCw().a(dVar);
    }
}
