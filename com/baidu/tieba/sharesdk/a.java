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
import com.baidu.tieba.tbadkCore.z;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes24.dex */
public class a {
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public void a(int i, ShareItem shareItem, boolean z) {
        Location ctq;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
                return;
            }
            if (z && (ctq = ctq()) != null) {
                shareItem.location = ctq;
            }
            g gVar = new g(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).brB();
                    return;
                }
                a(shareItem, 4);
                gVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).brB();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.fnn) {
                    shareItem.content = l(shareItem);
                }
                gVar.f(shareItem);
            } else if (i == 4) {
                if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    gVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
            } else if (i == 5) {
                if (!shareItem.fnm) {
                    shareItem.content = l(shareItem);
                }
                gVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.fnm) {
                    shareItem.content = l(shareItem);
                }
                gVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.fnm) {
                    shareItem.content = l(shareItem);
                }
                gVar.k(shareItem);
            } else if (i == 8) {
                if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    gVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.fnn) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("fid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fno || shareItem.fnr) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("tid", shareItem.extData).al("obj_type", i).al("obj_source", shareItem.fnE).al("obj_param1", shareItem.fnF).dY("fid", shareItem.fid).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fnG));
            } else if (shareItem.fnp) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dY("tid", shareItem.extData).al("obj_type", i));
            } else if (shareItem.fnm) {
                bN(i, shareItem.fnB);
            } else if (shareItem.fnq) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_param1", 7).al("obj_type", i).dY("fid", shareItem.extData));
            } else if (shareItem.fns) {
                ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).al("obj_type", i);
                al.al("obj_source", shareItem.fnE);
                if (!au.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    al.al("obj_param1", 9);
                }
                TiebaStatic.log(al);
            } else if (shareItem.fnt) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("tid", shareItem.extData).dY("fid", shareItem.fid).al("obj_type", i).al("obj_source", shareItem.fnE).al("obj_param1", shareItem.fnF).al(TiebaInitialize.Params.OBJ_PARAM2, shareItem.fnG).al(TiebaInitialize.Params.OBJ_PARAM3, shareItem.fnH).al("obj_locate", shareItem.fnI));
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

    private Location ctq() {
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
