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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.z;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes8.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location ctF;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            if (z && (ctF = ctF()) != null) {
                shareItem.location = ctF;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bqD();
                    return;
                }
                a(shareItem, 4);
                gVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bqD();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.fuG) {
                    shareItem.content = m(shareItem);
                }
                gVar.f(shareItem);
            } else if (i == 4) {
                if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
            } else if (i == 5) {
                if (!shareItem.fuF) {
                    shareItem.content = m(shareItem);
                }
                gVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.fuF) {
                    shareItem.content = m(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.fuF) {
                    shareItem.content = m(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 8) {
                if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fuG) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ap("obj_type", i));
            } else if (shareItem.fuH || shareItem.fuK) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ap("obj_type", i).ap("obj_source", shareItem.fuX).ap("obj_param1", shareItem.fuY).dR("fid", shareItem.fid).ap(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fuZ));
            } else if (shareItem.fuI) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ap("obj_type", i));
            } else if (shareItem.fuF) {
                bV(i, shareItem.fuU);
            } else if (shareItem.fuJ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_param1", 7).ap("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fuL) {
                ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ap("obj_type", i);
                ap.ap("obj_source", shareItem.fuX);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ap.ap("obj_param1", 9);
                }
                TiebaStatic.log(ap);
            } else if (shareItem.fuM) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).dR("fid", shareItem.fid).ap("obj_type", i).ap("obj_source", shareItem.fuX).ap("obj_param1", shareItem.fuY).ap(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fuZ).ap(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fva).ap("obj_locate", shareItem.fvb));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bV(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location ctF() {
        if (ae.checkLocationForGoogle(this.mContext)) {
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
