package com.baidu.tieba.sdk;

import android.app.Application;
import android.content.Context;
import com.baidu.live.adp.lib.image.loader.interfaces.IImageLoaderBuilder;
import com.baidu.live.adp.lib.network.http.interfaces.INetWorkBuilder;
import com.baidu.live.adp.widget.ICustomToast;
import com.baidu.live.tbadk.ala.zan.IAlaBdZanBuilder;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJumpBuilder;
import com.baidu.live.tbadk.extraparams.interfaces.IExtraParamsBuilder;
import com.baidu.live.tbadk.location.interfaces.ILocationBuilder;
import com.baidu.live.tbadk.pay.channel.interfaces.IPayChannelBuilder;
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
/* loaded from: classes6.dex */
public class a {
    private static a iRz = null;

    private a() {
    }

    public static a chx() {
        a aVar;
        if (iRz != null) {
            return iRz;
        }
        synchronized (a.class) {
            if (iRz == null) {
                iRz = new a();
            }
            aVar = iRz;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.chB().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.chB().setPackageName(str);
    }

    public void d(Application application) {
        com.baidu.tieba.sdk.c.a.chB().d(application);
    }

    public void chy() {
        com.baidu.tieba.sdk.c.a.chB().chy();
    }

    public void chz() {
        com.baidu.tieba.sdk.c.a.chB().chz();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.chB().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.chB().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.chB().a(dVar);
    }

    public void chA() {
        com.baidu.tieba.sdk.c.a.chB().chA();
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chB().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chB().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chB().b(context, str, z, str2, jSONObject);
    }

    public void Db(String str) {
        com.baidu.tieba.sdk.login.a.chN().chO();
        com.baidu.tieba.sdk.c.a.chB().Db(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.chB().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.chB().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.chB().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.chB().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.chB().a(iShareChannelBuild);
    }

    public void a(IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.chB().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.chB().a(iAlaBdZanBuilder);
    }

    public void b(com.baidu.live.liveroom.d.b bVar) {
        com.baidu.tieba.sdk.c.a.chB().b(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.chB().f(context, str, i);
    }

    public void aN(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chB().dY(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.chB().a(context, j, i);
    }

    public void aO(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chB().dZ(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.l.a.uA().ajX != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.l.a.uA().ajX.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.chB().t(context, str2, str);
    }

    public void dX(Context context) {
        com.baidu.tieba.sdk.c.a.chB().dX(context);
    }

    public void aP(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chB().aP(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.chB().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.chB().checkScheme(str);
    }

    public boolean openScheme(String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.chB().openScheme(str, schemeCallback);
    }

    public void Dc(String str) {
        com.baidu.tieba.sdk.c.a.chB().Dc(str);
    }

    public void Dd(String str) {
        com.baidu.tieba.sdk.c.a.chB().Dd(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.chB().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.chB().setSubappVersionCode(i);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chB().aQ(context, str);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.chB().setResourceAdapter(iResourceAdapter);
    }
}
