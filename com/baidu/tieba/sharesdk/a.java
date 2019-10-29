package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes6.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, e eVar, boolean z) {
        Location bcp;
        if (eVar != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (bcp = bcp()) != null) {
                eVar.cyI = bcp;
            }
            f fVar = new f(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).akT();
                    return;
                }
                a(eVar, 4);
                fVar.e(eVar);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).akT();
                    return;
                }
                a(eVar, 3);
                if (eVar.cyt) {
                    eVar.content = m(eVar);
                }
                fVar.f(eVar);
            } else if (i == 4) {
                if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(eVar, 5);
                    fVar.h(eVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
            } else if (i == 5) {
                a(eVar, 6);
                if (!eVar.cys) {
                    eVar.content = m(eVar);
                }
                fVar.i(eVar);
            } else if (i == 6) {
                a(eVar, 7);
                if (!eVar.cys) {
                    eVar.content = m(eVar);
                }
                fVar.j(eVar);
            } else if (i == 7) {
                a(eVar, 8);
                if (!eVar.cys) {
                    eVar.content = m(eVar);
                }
                fVar.k(eVar);
            } else if (i == 8) {
                if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(eVar, 9);
                    fVar.g(eVar);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
            }
        }
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.cyt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("fid", eVar.extData).O("obj_type", i));
            } else if (eVar.cyu || eVar.cyx) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("tid", eVar.extData).O("obj_type", i).O("obj_source", eVar.cyM).O("obj_param1", eVar.cyN).bS("fid", eVar.fid));
            } else if (eVar.cyv) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).bS("tid", eVar.extData).O("obj_type", i));
            } else if (eVar.cys) {
                aE(i, eVar.cyJ);
            } else if (eVar.cyw) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_param1", 7).O("obj_type", i).bS("fid", eVar.extData));
            } else if (eVar.cyy) {
                an O = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_type", i);
                if (!aq.isEmpty(eVar.linkUrl) && eVar.linkUrl.contains("worldcup")) {
                    O.O("obj_param1", 9);
                }
                TiebaStatic.log(O);
            } else if (eVar.cyz) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("tid", eVar.extData).bS("fid", eVar.fid).O("obj_type", i).O("obj_source", eVar.cyM).O("obj_param1", eVar.cyN).O(TiebaInitialize.Params.OBJ_PARAM2, eVar.cyO).O(TiebaInitialize.Params.OBJ_PARAM3, eVar.cyP).O("obj_locate", eVar.cyQ));
            }
        }
    }

    private String m(e eVar) {
        String str = "【" + eVar.title + "】 " + eVar.content;
        eVar.content = str;
        return str;
    }

    private void aE(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location bcp() {
        if (ab.checkLocationForGoogle(this.mContext)) {
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
