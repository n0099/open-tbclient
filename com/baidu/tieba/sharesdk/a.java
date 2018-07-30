package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, d dVar, boolean z) {
        Location akT;
        if (dVar != null) {
            if (!j.jE()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
                return;
            }
            if (z && (akT = akT()) != null) {
                dVar.aGd = akT;
            }
            e eVar = new e(this.mContext, null);
            if (i == 3) {
                a(dVar, 4);
                eVar.b(dVar);
            } else if (i == 2) {
                a(dVar, 3);
                if (dVar.aFT) {
                    dVar.content = m(dVar);
                }
                eVar.c(dVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 5);
                    eVar.e(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).xn();
            } else if (i == 5) {
                a(dVar, 6);
                if (!dVar.aFS) {
                    dVar.content = m(dVar);
                }
                eVar.f(dVar);
            } else if (i == 6) {
                a(dVar, 7);
                if (!dVar.aFS) {
                    dVar.content = m(dVar);
                }
                eVar.g(dVar);
            } else if (i == 7) {
                a(dVar, 8);
                if (!dVar.aFS) {
                    dVar.content = m(dVar);
                }
                eVar.h(dVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 9);
                    eVar.d(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).xn();
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aFT) {
                TiebaStatic.log(new an("c10125").af(ImageViewerConfig.FORUM_ID, dVar.extData).r("obj_type", i));
            } else if (dVar.aFU || dVar.aFX) {
                TiebaStatic.log(new an("c10125").af("tid", dVar.extData).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aGh).r("obj_param1", dVar.aGi).af(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aFV) {
                TiebaStatic.log(new an("c10427").af("tid", dVar.extData).r("obj_type", i));
            } else if (dVar.aFS) {
                ai(i, dVar.aGe);
            } else if (dVar.aFW) {
                TiebaStatic.log(new an("c10125").r("obj_param1", 7).r("obj_type", i).af(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aFY) {
                an r = new an("c10125").r("obj_type", i);
                if (!ap.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    r.r("obj_param1", 9);
                }
                TiebaStatic.log(r);
            }
        }
    }

    private String m(com.baidu.tbadk.coreExtra.c.d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location akT() {
        if (ac.aN(this.mContext)) {
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
