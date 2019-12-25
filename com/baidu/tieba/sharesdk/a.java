package com.baidu.tieba.sharesdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes8.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location btK;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (btK = btK()) != null) {
                shareItem.location = btK;
            }
            e eVar = new e(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aCb();
                    return;
                }
                a(shareItem, 4);
                eVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aCb();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.dlp) {
                    shareItem.content = m(shareItem);
                }
                eVar.f(shareItem);
            } else if (i == 4) {
                if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    eVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
            } else if (i == 5) {
                a(shareItem, 6);
                if (!shareItem.dlo) {
                    shareItem.content = m(shareItem);
                }
                eVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.dlo) {
                    shareItem.content = m(shareItem);
                }
                eVar.j(shareItem);
            } else if (i == 7) {
                a(shareItem, 8);
                if (!shareItem.dlo) {
                    shareItem.content = m(shareItem);
                }
                eVar.k(shareItem);
            } else if (i == 8) {
                if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    eVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCb();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlp) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlq || shareItem.dlt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlE).Z("obj_param1", shareItem.dlF).cp("fid", shareItem.fid));
            } else if (shareItem.dlr) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlo) {
                aT(i, shareItem.dlB);
            } else if (shareItem.dls) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            } else if (shareItem.dlu) {
                an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_type", i);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    Z.Z("obj_param1", 9);
                }
                TiebaStatic.log(Z);
            } else if (shareItem.dlv) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).cp("fid", shareItem.fid).Z("obj_type", i).Z("obj_source", shareItem.dlE).Z("obj_param1", shareItem.dlF).Z(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dlG).Z(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dlH).Z("obj_locate", shareItem.dlI));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void aT(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location btK() {
        if (ab.checkLocationForGoogle(this.mContext)) {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
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
