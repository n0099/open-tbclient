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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes3.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, d dVar, boolean z) {
        Location asH;
        if (dVar != null) {
            if (!j.kV()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                return;
            }
            if (z && (asH = asH()) != null) {
                dVar.aSP = asH;
            }
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
            if (i == 3) {
                a(dVar, 4);
                eVar.b(dVar);
            } else if (i == 2) {
                a(dVar, 3);
                if (dVar.aSE) {
                    dVar.content = m(dVar);
                }
                eVar.c(dVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 5);
                    eVar.e(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
            } else if (i == 5) {
                a(dVar, 6);
                if (!dVar.aSD) {
                    dVar.content = m(dVar);
                }
                eVar.f(dVar);
            } else if (i == 6) {
                a(dVar, 7);
                if (!dVar.aSD) {
                    dVar.content = m(dVar);
                }
                eVar.g(dVar);
            } else if (i == 7) {
                a(dVar, 8);
                if (!dVar.aSD) {
                    dVar.content = m(dVar);
                }
                eVar.h(dVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 9);
                    eVar.d(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).Ca();
            }
        }
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aSE) {
                TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, dVar.extData).y("obj_type", i));
            } else if (dVar.aSF || dVar.aSI) {
                TiebaStatic.log(new am("c10125").aB("tid", dVar.extData).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aST).y("obj_param1", dVar.aSU).aB(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aSG) {
                TiebaStatic.log(new am("c10427").aB("tid", dVar.extData).y("obj_type", i));
            } else if (dVar.aSD) {
                ai(i, dVar.aSQ);
            } else if (dVar.aSH) {
                TiebaStatic.log(new am("c10125").y("obj_param1", 7).y("obj_type", i).aB(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSJ) {
                am y = new am("c10125").y("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    y.y("obj_param1", 9);
                }
                TiebaStatic.log(y);
            }
        }
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private void ai(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location asH() {
        if (ab.bC(this.mContext)) {
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
