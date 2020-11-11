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
        Location cpB;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (cpB = cpB()) != null) {
                shareItem.location = cpB;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bpi();
                    return;
                }
                a(shareItem, 4);
                gVar.f(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).bpi();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.fgF) {
                    shareItem.content = m(shareItem);
                }
                gVar.g(shareItem);
            } else if (i == 4) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.i(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
            } else if (i == 5) {
                if (!shareItem.fgE) {
                    shareItem.content = m(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.fgE) {
                    shareItem.content = m(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 7) {
                if (!shareItem.fgE) {
                    shareItem.content = m(shareItem);
                }
                gVar.l(shareItem);
            } else if (i == 8) {
                if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bpi();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fgF) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fgG || shareItem.fgJ) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fgW).al("obj_param1", shareItem.fgX).dR("fid", shareItem.fid).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgY));
            } else if (shareItem.fgH) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dR("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fgE) {
                bP(i, shareItem.fgT);
            } else if (shareItem.fgI) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dR("fid", shareItem.extData));
            } else if (shareItem.fgK) {
                aq al = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                al.al("obj_source", shareItem.fgW);
                if (!at.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    al.al("obj_param1", 9);
                }
                TiebaStatic.log(al);
            } else if (shareItem.fgL) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("tid", shareItem.extData).dR("fid", shareItem.fid).al("obj_type", i).al("obj_source", shareItem.fgW).al("obj_param1", shareItem.fgX).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fgY).al(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fgZ).al("obj_locate", shareItem.fha));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bP(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location cpB() {
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
