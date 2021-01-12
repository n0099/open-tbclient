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
/* loaded from: classes10.dex */
public class a {
    private static a mTc = null;

    private a() {
    }

    public static a dDg() {
        a aVar;
        if (mTc != null) {
            return mTc;
        }
        synchronized (a.class) {
            if (mTc == null) {
                mTc = new a();
            }
            aVar = mTc;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.d.a.dDk().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.d.a.dDk().setPackageName(str);
    }

    public static void Rb(String str) {
        com.baidu.tieba.sdk.d.a.Rb(str);
    }

    public static void Rc(String str) {
        com.baidu.tieba.sdk.d.a.Rc(str);
    }

    public void c(Application application) {
        com.baidu.tieba.sdk.d.a.dDk().c(application);
    }

    public void dDh() {
        com.baidu.tieba.sdk.d.a.dDk().dDh();
    }

    public void dDi() {
        com.baidu.tieba.sdk.d.a.dDk().dDi();
    }

    public com.baidu.tieba.sdk.e.a a(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dDk().a(liveBaseActivity);
    }

    public d b(LiveBaseActivity liveBaseActivity) {
        return com.baidu.tieba.sdk.d.a.dDk().b(liveBaseActivity);
    }

    public void a(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(dVar);
    }

    public void b(com.baidu.tieba.sdk.b.d dVar) {
        com.baidu.tieba.sdk.d.a.dDk().b(dVar);
    }

    public void a(c cVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(cVar);
    }

    public void gM(Context context) {
        bh(context, null);
    }

    public void bg(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dDk().bg(context, str);
    }

    public void bh(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dDk().bh(context, str);
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().b(context, str, z, str2, jSONObject);
    }

    public void c(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().c(context, str, z, str2, jSONObject);
    }

    public void b(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().b(context, j, z, str, jSONObject);
    }

    public void d(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.d.a.dDk().d(context, str, z, str2, jSONObject);
    }

    public void Rd(String str) {
        com.baidu.tieba.sdk.login.a.dDz().dDA();
        com.baidu.tieba.sdk.d.a.dDk().Rd(str);
    }

    public void a(com.baidu.tieba.sdk.b.a aVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(aVar);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(eVar);
    }

    public void hy(long j) {
        com.baidu.tieba.sdk.d.a.dDk().hy(j);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(bVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(fVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.d.a.dDk().a(iShareChannelBuild);
    }

    public void addPayChannelBuilder(PayChannelType payChannelType, IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().addPayChannelBuilder(payChannelType, iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.d.a.dDk().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.d.a.dDk().a(iAlaBdZanBuilder);
    }

    public void c(com.baidu.live.liveroom.e.e eVar) {
        com.baidu.tieba.sdk.d.a.dDk().c(eVar);
    }

    public void a(com.baidu.live.liveroom.e.c cVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(cVar);
    }

    public void g(Context context, String str, int i) {
        com.baidu.tieba.sdk.d.a.dDk().g(context, str, i);
    }

    public void bi(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dDk().gO(context);
    }

    public void b(Context context, long j, int i) {
        com.baidu.tieba.sdk.d.a.dDk().b(context, j, i);
    }

    public void bj(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dDk().gP(context);
    }

    public void y(Context context, String str, String str2) {
        if (com.baidu.live.af.a.OJ().bru != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.af.a.OJ().bru.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.d.a.dDk().y(context, str2, str);
    }

    public void gN(Context context) {
        com.baidu.tieba.sdk.d.a.dDk().gN(context);
    }

    public void bk(Context context, String str) {
        com.baidu.tieba.sdk.d.a.dDk().bk(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.d.a.dDk().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.d.a.dDk().checkScheme(str);
    }

    public boolean openScheme(String str) {
        return openScheme(null, str);
    }

    public boolean openScheme(Context context, String str) {
        return com.baidu.tieba.sdk.d.a.dDk().openScheme(context, str);
    }

    public boolean openScheme(Context context, String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.d.a.dDk().openScheme(context, str, schemeCallback);
    }

    public void Re(String str) {
        com.baidu.tieba.sdk.d.a.dDk().Re(str);
    }

    public void Rf(String str) {
        com.baidu.tieba.sdk.d.a.dDk().Rf(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.d.a.dDk().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.d.a.dDk().setSubappVersionCode(i);
    }

    public void z(Context context, String str, String str2) {
        com.baidu.tieba.sdk.d.a.dDk().z(context, str, str2);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.d.a.dDk().setResourceAdapter(iResourceAdapter);
    }

    public void dDj() {
        com.baidu.tieba.sdk.d.a.dDk().dDj();
    }

    public void bP(String str, int i) {
        com.baidu.tieba.sdk.d.a.dDk().bP(str, i);
    }

    public void setAttentionStatusChangedFromSDKCallBack(IAttentionStatusCallBack iAttentionStatusCallBack) {
        com.baidu.tieba.sdk.d.a.dDk().setAttentionStatusChangedFromSDKCallBack(iAttentionStatusCallBack);
    }

    public void a(com.baidu.live.liveroom.a.d dVar) {
        com.baidu.tieba.sdk.d.a.dDk().a(dVar);
    }
}
