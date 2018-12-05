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
        Location aru;
        if (dVar != null) {
            if (!j.kV()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                return;
            }
            if (z && (aru = aru()) != null) {
                dVar.aSh = aru;
            }
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
            if (i == 3) {
                a(dVar, 4);
                eVar.b(dVar);
            } else if (i == 2) {
                a(dVar, 3);
                if (dVar.aRX) {
                    dVar.content = m(dVar);
                }
                eVar.c(dVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 5);
                    eVar.e(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
            } else if (i == 5) {
                a(dVar, 6);
                if (!dVar.aRW) {
                    dVar.content = m(dVar);
                }
                eVar.f(dVar);
            } else if (i == 6) {
                a(dVar, 7);
                if (!dVar.aRW) {
                    dVar.content = m(dVar);
                }
                eVar.g(dVar);
            } else if (i == 7) {
                a(dVar, 8);
                if (!dVar.aRW) {
                    dVar.content = m(dVar);
                }
                eVar.h(dVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 9);
                    eVar.d(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).BN();
            }
        }
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aRX) {
                TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, dVar.extData).x("obj_type", i));
            } else if (dVar.aRY || dVar.aSb) {
                TiebaStatic.log(new am("c10125").aA("tid", dVar.extData).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aSl).x("obj_param1", dVar.aSm).aA(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aRZ) {
                TiebaStatic.log(new am("c10427").aA("tid", dVar.extData).x("obj_type", i));
            } else if (dVar.aRW) {
                af(i, dVar.aSi);
            } else if (dVar.aSa) {
                TiebaStatic.log(new am("c10125").x("obj_param1", 7).x("obj_type", i).aA(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aSc) {
                am x = new am("c10125").x("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    x.x("obj_param1", 9);
                }
                TiebaStatic.log(x);
            }
        }
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private void af(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location aru() {
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
