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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes18.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location bSV;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            if (z && (bSV = bSV()) != null) {
                shareItem.location = bSV;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aYR();
                    return;
                }
                a(shareItem, 4);
                gVar.f(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aYR();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.etD) {
                    shareItem.content = m(shareItem);
                }
                gVar.g(shareItem);
            } else if (i == 4) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.i(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
            } else if (i == 5) {
                if (!shareItem.etC) {
                    shareItem.content = m(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.etC) {
                    shareItem.content = m(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 7) {
                if (!shareItem.etC) {
                    shareItem.content = m(shareItem);
                }
                gVar.l(shareItem);
            } else if (i == 8) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.etD) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("fid", shareItem.extData).ah("obj_type", i));
            } else if (shareItem.etE || shareItem.etH) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("tid", shareItem.extData).ah("obj_type", i).ah("obj_source", shareItem.etS).ah("obj_param1", shareItem.etT).dn("fid", shareItem.fid).ah(TiebaInitialize.Params.OBJ_PARAM2, shareItem.etU));
            } else if (shareItem.etF) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dn("tid", shareItem.extData).ah("obj_type", i));
            } else if (shareItem.etC) {
                bz(i, shareItem.etP);
            } else if (shareItem.etG) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_param1", 7).ah("obj_type", i).dn("fid", shareItem.extData));
            } else if (shareItem.etI) {
                ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ah("obj_type", i);
                ah.ah("obj_source", shareItem.etS);
                if (!as.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ah.ah("obj_param1", 9);
                }
                TiebaStatic.log(ah);
            } else if (shareItem.etJ) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("tid", shareItem.extData).dn("fid", shareItem.fid).ah("obj_type", i).ah("obj_source", shareItem.etS).ah("obj_param1", shareItem.etT).ah(TiebaInitialize.Params.OBJ_PARAM2, shareItem.etU).ah(TiebaInitialize.Params.OBJ_PARAM3, shareItem.etV).ah("obj_locate", shareItem.etW));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bz(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location bSV() {
        if (ad.checkLocationForGoogle(this.mContext)) {
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
