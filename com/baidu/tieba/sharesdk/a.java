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
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes11.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location bME;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (bME = bME()) != null) {
                shareItem.location = bME;
            }
            f fVar = new f(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aSY();
                    return;
                }
                a(shareItem, 4);
                fVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aSY();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.eeG) {
                    shareItem.content = m(shareItem);
                }
                fVar.f(shareItem);
            } else if (i == 4) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    fVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
            } else if (i == 5) {
                if (!shareItem.eeF) {
                    shareItem.content = m(shareItem);
                }
                fVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.eeF) {
                    shareItem.content = m(shareItem);
                }
                fVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.eeF) {
                    shareItem.content = m(shareItem);
                }
                fVar.k(shareItem);
            } else if (i == 8) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    fVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aSY();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eeG) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("fid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.eeH || shareItem.eeK) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.eeV).ag("obj_param1", shareItem.eeW).dh("fid", shareItem.fid).ag(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eeX));
            } else if (shareItem.eeI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dh("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.eeF) {
                bt(i, shareItem.eeS);
            } else if (shareItem.eeJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dh("fid", shareItem.extData));
            } else if (shareItem.eeL) {
                an ag = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                ag.ag("obj_source", shareItem.eeV);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    ag.ag("obj_param1", 9);
                }
                TiebaStatic.log(ag);
            } else if (shareItem.eeM) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dh("tid", shareItem.extData).dh("fid", shareItem.fid).ag("obj_type", i).ag("obj_source", shareItem.eeV).ag("obj_param1", shareItem.eeW).ag(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eeX).ag(TiebaInitialize.Params.OBJ_PARAM3, shareItem.eeY).ag("obj_locate", shareItem.eeZ));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bt(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location bME() {
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
