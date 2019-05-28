package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.u;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes6.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, e eVar, boolean z) {
        Location aZI;
        if (eVar != null) {
            if (!j.jS()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (aZI = aZI()) != null) {
                eVar.cjA = aZI;
            }
            f fVar = new f(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).afO();
                    return;
                }
                a(eVar, 4);
                fVar.e(eVar);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).afO();
                    return;
                }
                a(eVar, 3);
                if (eVar.cjl) {
                    eVar.content = p(eVar);
                }
                fVar.f(eVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(eVar, 5);
                    fVar.h(eVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
            } else if (i == 5) {
                a(eVar, 6);
                if (!eVar.cjk) {
                    eVar.content = p(eVar);
                }
                fVar.i(eVar);
            } else if (i == 6) {
                a(eVar, 7);
                if (!eVar.cjk) {
                    eVar.content = p(eVar);
                }
                fVar.j(eVar);
            } else if (i == 7) {
                a(eVar, 8);
                if (!eVar.cjk) {
                    eVar.content = p(eVar);
                }
                fVar.k(eVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(eVar, 9);
                    fVar.g(eVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).afO();
            }
        }
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.cjl) {
                TiebaStatic.log(new am("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjm || eVar.cjp) {
                TiebaStatic.log(new am("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cjE).P("obj_param1", eVar.cjF).bT("fid", eVar.fid));
            } else if (eVar.cjn) {
                TiebaStatic.log(new am("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.cjk) {
                aD(i, eVar.cjB);
            } else if (eVar.cjo) {
                TiebaStatic.log(new am("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            } else if (eVar.cjq) {
                am P = new am("c10125").P("obj_type", i);
                if (!ap.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    P.P("obj_param1", 9);
                }
                TiebaStatic.log(P);
            } else if (eVar.cjr) {
                TiebaStatic.log(new am("c10125").bT("tid", eVar.extData).bT("fid", eVar.fid).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.cjE).P("obj_param1", eVar.cjF).P("obj_param2", eVar.cjG).P("obj_param3", eVar.cjH).P("obj_locate", eVar.cjI));
            }
        }
    }

    private String p(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private void aD(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location aZI() {
        if (ab.cw(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService(Headers.LOCATION);
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
