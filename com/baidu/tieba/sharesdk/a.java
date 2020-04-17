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
        Location bGk;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (bGk = bGk()) != null) {
                shareItem.location = bGk;
            }
            f fVar = new f(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aMZ();
                    return;
                }
                a(shareItem, 4);
                fVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aMZ();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.dQh) {
                    shareItem.content = m(shareItem);
                }
                fVar.f(shareItem);
            } else if (i == 4) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    fVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMZ();
            } else if (i == 5) {
                if (!shareItem.dQg) {
                    shareItem.content = m(shareItem);
                }
                fVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.dQg) {
                    shareItem.content = m(shareItem);
                }
                fVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.dQg) {
                    shareItem.content = m(shareItem);
                }
                fVar.k(shareItem);
            } else if (i == 8) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    fVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMZ();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dQh) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("fid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQi || shareItem.dQl) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("tid", shareItem.extData).af("obj_type", i).af("obj_source", shareItem.dQx).af("obj_param1", shareItem.dQy).cI("fid", shareItem.fid).af(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQz));
            } else if (shareItem.dQj) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cI("tid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQg) {
                bo(i, shareItem.dQu);
            } else if (shareItem.dQk) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_param1", 7).af("obj_type", i).cI("fid", shareItem.extData));
            } else if (shareItem.dQm) {
                an af = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_type", i);
                af.af("obj_source", shareItem.dQx);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    af.af("obj_param1", 9);
                }
                TiebaStatic.log(af);
            } else if (shareItem.dQn) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("tid", shareItem.extData).cI("fid", shareItem.fid).af("obj_type", i).af("obj_source", shareItem.dQx).af("obj_param1", shareItem.dQy).af(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQz).af(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dQA).af("obj_locate", shareItem.dQB));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void bo(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location bGk() {
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
