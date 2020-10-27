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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes24.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location cna;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            if (z && (cna = cna()) != null) {
                shareItem.location = cna;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bmI();
                    return;
                }
                a(shareItem, 4);
                gVar.f(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bmI();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.faO) {
                    shareItem.content = m(shareItem);
                }
                gVar.g(shareItem);
            } else if (i == 4) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.i(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bmI();
            } else if (i == 5) {
                if (!shareItem.faN) {
                    shareItem.content = m(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.faN) {
                    shareItem.content = m(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 7) {
                if (!shareItem.faN) {
                    shareItem.content = m(shareItem);
                }
                gVar.l(shareItem);
            } else if (i == 8) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bmI();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.faO) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.faP || shareItem.faS) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).aj("obj_type", i).aj("obj_source", shareItem.fbf).aj("obj_param1", shareItem.fbg).dR("fid", shareItem.fid).aj(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fbh));
            } else if (shareItem.faQ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).aj("obj_type", i));
            } else if (shareItem.faN) {
                bL(i, shareItem.fbc);
            } else if (shareItem.faR) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_param1", 7).aj("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.faT) {
                aq aj = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).aj("obj_type", i);
                aj.aj("obj_source", shareItem.fbf);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    aj.aj("obj_param1", 9);
                }
                TiebaStatic.log(aj);
            } else if (shareItem.faU) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).dR("fid", shareItem.fid).aj("obj_type", i).aj("obj_source", shareItem.fbf).aj("obj_param1", shareItem.fbg).aj(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fbh).aj(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fbi).aj("obj_locate", shareItem.fbj));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bL(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location cna() {
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
