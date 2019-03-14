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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes6.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, d dVar, boolean z) {
        Location aSz;
        if (dVar != null) {
            if (!j.kY()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                return;
            }
            if (z && (aSz = aSz()) != null) {
                dVar.cbw = aSz;
            }
            e eVar = new e(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(d.j.share_weixin_not_installed_yet)).abh();
                    return;
                }
                a(dVar, 4);
                eVar.b(dVar);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(d.j.share_weixin_not_installed_yet)).abh();
                    return;
                }
                a(dVar, 3);
                if (dVar.cbi) {
                    dVar.content = m(dVar);
                }
                eVar.c(dVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 5);
                    eVar.e(dVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
            } else if (i == 5) {
                a(dVar, 6);
                if (!dVar.cbh) {
                    dVar.content = m(dVar);
                }
                eVar.f(dVar);
            } else if (i == 6) {
                a(dVar, 7);
                if (!dVar.cbh) {
                    dVar.content = m(dVar);
                }
                eVar.g(dVar);
            } else if (i == 7) {
                a(dVar, 8);
                if (!dVar.cbh) {
                    dVar.content = m(dVar);
                }
                eVar.h(dVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 9);
                    eVar.d(dVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.cbi) {
                TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, dVar.extData).T("obj_type", i));
            } else if (dVar.cbj || dVar.cbm) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbA).T("obj_param1", dVar.cbB).bJ(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.cbk) {
                TiebaStatic.log(new am("c10427").bJ("tid", dVar.extData).T("obj_type", i));
            } else if (dVar.cbh) {
                ay(i, dVar.cbx);
            } else if (dVar.cbl) {
                TiebaStatic.log(new am("c10125").T("obj_param1", 7).T("obj_type", i).bJ(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.cbn) {
                am T = new am("c10125").T("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    T.T("obj_param1", 9);
                }
                TiebaStatic.log(T);
            } else if (dVar.cbo) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).bJ(ImageViewerConfig.FORUM_ID, dVar.fid).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbA).T("obj_param1", dVar.cbB).T("obj_param2", dVar.cbC).T("obj_param3", dVar.cbD).T("obj_locate", dVar.cbE));
            }
        }
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private void ay(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location aSz() {
        if (ab.cR(this.mContext)) {
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
