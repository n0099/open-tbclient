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
import com.baidu.tieba.sdk.b.c;
import com.baidu.tieba.sdk.b.e;
import com.baidu.tieba.sdk.b.f;
import com.baidu.tieba.sdk.e.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private static a mln = null;

    private a() {
    }

    public static a dwI() {
        a aVar;
        if (mln != null) {
            return mln;
        }
        synchronized (a.class) {
            if (mln == null) {
                mln = new a();
            }
            aVar = mln;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dwM().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dwM().setPackageName(str);
    }

    public void init(Application application) {
        com.baidu.tieba.sdk.d.a.dwM().init(application);
    }

    public void dwJ() {
        com.baidu.tieba.sdk.d.a.dwM().dwJ();
    }

    public void dwK() {
        com.baidu.tieba.sdk.d.a.dwM().dwK();
    }

    public com.baidu.tieba.sdk.e.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dwM().a(mAActivity);
    }

    public d b(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.d.a.dwM().b(mAActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(cVar);
    }

    public void fM(Context context) {
        ba(context, null);
    }

    public void aZ(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dwM().aZ(context, str);
    }

    public void ba(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dwM().ba(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dwM().d(context, str, z, str2, jSONObject);
    }

    public void Rb(String str) {
        com.baidu.tieba.sdk.login.a.dxa().dxb();
        com.baidu.tieba.sdk.d.a.dwM().Rb(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(eVar);
    }

    public void gy(long j) {
        com.baidu.tieba.sdk.d.a.dwM().gy(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dwM().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dwM().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dwM().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dwM().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(cVar);
    }

    public void e(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dwM().e(context, str, i);
    }

    public void bb(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dwM().fO(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dwM().a(context, j, i);
    }

    public void bc(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dwM().fP(context);
    }

    public void w(Context context, String str, String str2) {
        if (com.baidu.live.x.a.OS().blo != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.x.a.OS().blo.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dwM().w(context, str2, str);
    }

    public void fN(Context context) {
        com.baidu.tieba.sdk.d.a.dwM().fN(context);
    }

    public void bd(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dwM().bd(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dwM().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dwM().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dwM().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dwM().openScheme(context, str, schemeCallback);
    }

    public void Rc(String str) {
        com.baidu.tieba.sdk.d.a.dwM().Rc(str);
    }

    public void Rd(String str) {
        com.baidu.tieba.sdk.d.a.dwM().Rd(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dwM().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dwM().setSubappVersionCode(i);
    }

    public void x(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dwM().x(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dwM().setResourceAdapter(iResourceAdapter);
    }

    public void dwL() {
        com.baidu.tieba.sdk.d.a.dwM().dwL();
    }

    public void bD(String str, int i) {
        com.baidu.tieba.sdk.d.a.dwM().bD(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dwM().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dwM().a(dVar);
    }
}
