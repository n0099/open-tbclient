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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes23.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location cpc;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            if (z && (cpc = cpc()) != null) {
                shareItem.location = cpc;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bom();
                    return;
                }
                a(shareItem, 4);
                gVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bom();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.ffN) {
                    shareItem.content = l(shareItem);
                }
                gVar.f(shareItem);
            } else if (i == 4) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
            } else if (i == 5) {
                if (!shareItem.ffM) {
                    shareItem.content = l(shareItem);
                }
                gVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.ffM) {
                    shareItem.content = l(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.ffM) {
                    shareItem.content = l(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 8) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.ffN) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).ak("obj_type", i));
            } else if (shareItem.ffO || shareItem.ffR) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).ak("obj_type", i).ak("obj_source", shareItem.fge).ak("obj_param1", shareItem.fgf).dR("fid", shareItem.fid).ak(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgg));
            } else if (shareItem.ffP) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).ak("obj_type", i));
            } else if (shareItem.ffM) {
                bN(i, shareItem.fgb);
            } else if (shareItem.ffQ) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_param1", 7).ak("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.ffS) {
                ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ak("obj_type", i);
                ak.ak("obj_source", shareItem.fge);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ak.ak("obj_param1", 9);
                }
                TiebaStatic.log(ak);
            } else if (shareItem.ffT) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).dR("fid", shareItem.fid).ak("obj_type", i).ak("obj_source", shareItem.fge).ak("obj_param1", shareItem.fgf).ak(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgg).ak(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgh).ak("obj_locate", shareItem.fgi));
            }
        }
    }

    private String l(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bN(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location cpc() {
        if (ae.checkLocationForGoogle(this.mContext)) {
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
