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
        Location amH;
        if (dVar != null) {
            if (!j.kK()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
                return;
            }
            if (z && (amH = amH()) != null) {
                dVar.aJq = amH;
            }
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e(this.mContext, null);
            if (i == 3) {
                a(dVar, 4);
                eVar.b(dVar);
            } else if (i == 2) {
                a(dVar, 3);
                if (dVar.aJg) {
                    dVar.content = m(dVar);
                }
                eVar.c(dVar);
            } else if (i == 4) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 5);
                    eVar.e(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).yt();
            } else if (i == 5) {
                a(dVar, 6);
                if (!dVar.aJf) {
                    dVar.content = m(dVar);
                }
                eVar.f(dVar);
            } else if (i == 6) {
                a(dVar, 7);
                if (!dVar.aJf) {
                    dVar.content = m(dVar);
                }
                eVar.g(dVar);
            } else if (i == 7) {
                a(dVar, 8);
                if (!dVar.aJf) {
                    dVar.content = m(dVar);
                }
                eVar.h(dVar);
            } else if (i == 8) {
                if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(dVar, 9);
                    eVar.d(dVar);
                    return;
                }
                BdToast.a(this.mContext, this.mContext.getText(e.j.share_qq_not_install)).yt();
            }
        }
    }

    private void a(d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.aJg) {
                TiebaStatic.log(new am("c10125").al(ImageViewerConfig.FORUM_ID, dVar.extData).w("obj_type", i));
            } else if (dVar.aJh || dVar.aJk) {
                TiebaStatic.log(new am("c10125").al("tid", dVar.extData).w("obj_type", i).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aJu).w("obj_param1", dVar.aJv).al(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.aJi) {
                TiebaStatic.log(new am("c10427").al("tid", dVar.extData).w("obj_type", i));
            } else if (dVar.aJf) {
                aj(i, dVar.aJr);
            } else if (dVar.aJj) {
                TiebaStatic.log(new am("c10125").w("obj_param1", 7).w("obj_type", i).al(ImageViewerConfig.FORUM_ID, dVar.extData));
            } else if (dVar.aJl) {
                am w = new am("c10125").w("obj_type", i);
                if (!ao.isEmpty(dVar.linkUrl) && dVar.linkUrl.contains("worldcup")) {
                    w.w("obj_param1", 9);
                }
                TiebaStatic.log(w);
            }
        }
    }

    private String m(d dVar) {
        String str = "【" + dVar.title + "】 " + dVar.content;
        dVar.content = str;
        return str;
    }

    private void aj(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location amH() {
        if (ab.bs(this.mContext)) {
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
