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
    private static a iQI = null;

    private a() {
    }

    public static a chv() {
        a aVar;
        if (iQI != null) {
            return iQI;
        }
        synchronized (a.class) {
            if (iQI == null) {
                iQI = new a();
            }
            aVar = iQI;
        }
        return aVar;
    }

    public static void setAppId(String str) {
        com.baidu.tieba.sdk.c.a.chz().setAppId(str);
    }

    public static void setPackageName(String str) {
        com.baidu.tieba.sdk.c.a.chz().setPackageName(str);
    }

    public void d(Application application) {
        com.baidu.tieba.sdk.c.a.chz().d(application);
    }

    public void chw() {
        com.baidu.tieba.sdk.c.a.chz().chw();
    }

    public void chx() {
        com.baidu.tieba.sdk.c.a.chz().chx();
    }

    public com.baidu.tieba.sdk.d.a a(MAActivity mAActivity) {
        return com.baidu.tieba.sdk.c.a.chz().a(mAActivity);
    }

    public void a(e eVar) {
        com.baidu.tieba.sdk.c.a.chz().a(eVar);
    }

    public void a(d dVar) {
        com.baidu.tieba.sdk.c.a.chz().a(dVar);
    }

    public void chy() {
        com.baidu.tieba.sdk.c.a.chz().chy();
    }

    public void a(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chz().a(context, str, z, str2, jSONObject);
    }

    public void a(Context context, long j, boolean z, String str, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chz().a(context, j, z, str, jSONObject);
    }

    public void b(Context context, String str, boolean z, String str2, JSONObject jSONObject) {
        com.baidu.tieba.sdk.c.a.chz().b(context, str, z, str2, jSONObject);
    }

    public void Db(String str) {
        com.baidu.tieba.sdk.login.a.chL().chM();
        com.baidu.tieba.sdk.c.a.chz().Db(str);
    }

    public void a(com.baidu.tieba.sdk.a.a aVar) {
        com.baidu.tieba.sdk.c.a.chz().a(aVar);
    }

    public void a(f fVar) {
        com.baidu.tieba.sdk.c.a.chz().a(fVar);
    }

    public void a(b bVar) {
        com.baidu.tieba.sdk.c.a.chz().a(bVar);
    }

    public void a(g gVar) {
        com.baidu.tieba.sdk.c.a.chz().a(gVar);
    }

    public void a(INetWorkBuilder iNetWorkBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iNetWorkBuilder);
    }

    public void a(IImageLoaderBuilder iImageLoaderBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iImageLoaderBuilder);
    }

    public void a(IShareChannelBuild iShareChannelBuild) {
        com.baidu.tieba.sdk.c.a.chz().a(iShareChannelBuild);
    }

    public void a(IPayChannelBuilder iPayChannelBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iPayChannelBuilder);
    }

    public void a(ILocationBuilder iLocationBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iLocationBuilder);
    }

    public void a(IExtraJumpBuilder iExtraJumpBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iExtraJumpBuilder);
    }

    public void a(IExtraParamsBuilder iExtraParamsBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iExtraParamsBuilder);
    }

    public void setCustomToast(ICustomToast iCustomToast) {
        com.baidu.tieba.sdk.c.a.chz().setCustomToast(iCustomToast);
    }

    public void a(IAlaBdZanBuilder iAlaBdZanBuilder) {
        com.baidu.tieba.sdk.c.a.chz().a(iAlaBdZanBuilder);
    }

    public void b(com.baidu.live.liveroom.d.b bVar) {
        com.baidu.tieba.sdk.c.a.chz().b(bVar);
    }

    public void f(Context context, String str, int i) {
        com.baidu.tieba.sdk.c.a.chz().f(context, str, i);
    }

    public void aN(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chz().dY(context);
    }

    public void a(Context context, long j, int i) {
        com.baidu.tieba.sdk.c.a.chz().a(context, j, i);
    }

    public void aO(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chz().dZ(context);
    }

    public void t(Context context, String str, String str2) {
        if (com.baidu.live.l.a.uB().ajF != null) {
            TbadkCoreApplication.getInst().setBigHeaderPhotoUrlPrefix(com.baidu.live.l.a.uB().ajF.mBigHeaderPhotoUrlPrefix);
        }
        com.baidu.tieba.sdk.c.a.chz().t(context, str2, str);
    }

    public void dX(Context context) {
        com.baidu.tieba.sdk.c.a.chz().dX(context);
    }

    public void aP(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chz().aP(context, str);
    }

    public void setCustomProtocol(String str) {
        com.baidu.tieba.sdk.c.a.chz().setCustomProtocol(str);
    }

    public boolean checkScheme(String str) {
        return com.baidu.tieba.sdk.c.a.chz().checkScheme(str);
    }

    public boolean openScheme(String str, SchemeCallback schemeCallback) {
        return com.baidu.tieba.sdk.c.a.chz().openScheme(str, schemeCallback);
    }

    public void Dc(String str) {
        com.baidu.tieba.sdk.c.a.chz().Dc(str);
    }

    public void Dd(String str) {
        com.baidu.tieba.sdk.c.a.chz().Dd(str);
    }

    public void setSubappVersionName(String str) {
        com.baidu.tieba.sdk.c.a.chz().setSubappVersionName(str);
    }

    public void setSubappVersionCode(int i) {
        com.baidu.tieba.sdk.c.a.chz().setSubappVersionCode(i);
    }

    public void aQ(Context context, String str) {
        com.baidu.tieba.sdk.c.a.chz().aQ(context, str);
    }

    public void setResourceAdapter(IResourceAdapter iResourceAdapter) {
        com.baidu.tieba.sdk.c.a.chz().setResourceAdapter(iResourceAdapter);
    }
}
