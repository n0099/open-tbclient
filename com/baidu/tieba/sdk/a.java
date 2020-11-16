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
    private static a mEm = null;

    private a() {
    }

    public static a dBW() {
        a aVar;
        if (mEm != null) {
            return mEm;
        }
        synchronized (a.class) {
            if (mEm == null) {
                mEm = new a();
            }
            aVar = mEm;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dCa().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dCa().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dCa().init(application);
    }

    public void dBX() {
        com.baidu.tieba.sdk.d.a.dCa().dBX();
    }

    public void dBY() {
        com.baidu.tieba.sdk.d.a.dCa().dBY();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dCa().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dCa().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(cVar);
    }

    public void fM(Context context) {
        aZ(context, null);
    }

    public void aY(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCa().aY(context, str);
    }

    public void aZ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCa().aZ(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dCa().d(context, str, z, str2, jSONObject);
    }

    public void Rp(String str) {
        com.baidu.tieba.sdk.login.a.dCo().dCp();
        com.baidu.tieba.sdk.d.a.dCa().Rp(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(eVar);
    }

    public void gY(long j) {
        com.baidu.tieba.sdk.d.a.dCa().gY(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dCa().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dCa().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dCa().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dCa().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dCa().e(context, str, i);
    }

    public void ba(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCa().fO(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dCa().a(context, j, i);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCa().fP(context);
    }

    public void w(Context context, String str, String str2) {
        if (com.baidu.live.aa.a.Ph().bms != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.aa.a.Ph().bms.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dCa().w(context, str2, str);
    }

    public void fN(Context context) {
        com.baidu.tieba.sdk.d.a.dCa().fN(context);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dCa().bc(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dCa().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dCa().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dCa().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dCa().openScheme(context, str, schemeCallback);
    }

    public void Rq(String str) {
        com.baidu.tieba.sdk.d.a.dCa().Rq(str);
    }

    public void Rr(String str) {
        com.baidu.tieba.sdk.d.a.dCa().Rr(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dCa().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dCa().setSubappVersionCode(i);
    }

    public void x(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dCa().x(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dCa().setResourceAdapter(iResourceAdapter);
    }

    public void dBZ() {
        com.baidu.tieba.sdk.d.a.dCa().dBZ();
    }

    public void bF(String str, int i) {
        com.baidu.tieba.sdk.d.a.dCa().bF(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dCa().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dCa().a(dVar);
    }
}
