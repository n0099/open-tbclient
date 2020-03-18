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
        Location bwy;
        if (shareItem != null) {
            if (!j.isNetWorkAvailable()) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
                return;
            }
            if (z && (bwy = bwy()) != null) {
                shareItem.location = bwy;
            }
            f fVar = new f(this.mContext, null);
            if (i == 3) {
                IWXAPI createWXAPI = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI != null && !createWXAPI.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aEL();
                    return;
                }
                a(shareItem, 4);
                fVar.e(shareItem);
            } else if (i == 2) {
                IWXAPI createWXAPI2 = WXAPIFactory.createWXAPI(TbadkCoreApplication.getInst(), TbConfig.WEIXIN_SHARE_APP_ID);
                if (createWXAPI2 != null && !createWXAPI2.isWXAppInstalled()) {
                    BdToast.b(this.mContext, TbadkCoreApplication.getInst().getText(R.string.share_weixin_not_installed_yet)).aEL();
                    return;
                }
                a(shareItem, 3);
                if (shareItem.dqo) {
                    shareItem.content = m(shareItem);
                }
                fVar.f(shareItem);
            } else if (i == 4) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 5);
                    fVar.h(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEL();
            } else if (i == 5) {
                if (!shareItem.dqn) {
                    shareItem.content = m(shareItem);
                }
                fVar.i(shareItem);
            } else if (i == 6) {
                a(shareItem, 7);
                if (!shareItem.dqn) {
                    shareItem.content = m(shareItem);
                }
                fVar.j(shareItem);
            } else if (i == 7) {
                if (!shareItem.dqn) {
                    shareItem.content = m(shareItem);
                }
                fVar.k(shareItem);
            } else if (i == 8) {
                if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                    a(shareItem, 9);
                    fVar.g(shareItem);
                    return;
                }
                BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEL();
            }
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dqo) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("fid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dqp || shareItem.dqs) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqE).X("obj_param1", shareItem.dqF).cx("fid", shareItem.fid).X(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqG));
            } else if (shareItem.dqq) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cx("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dqn) {
                aZ(i, shareItem.dqB);
            } else if (shareItem.dqr) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cx("fid", shareItem.extData));
            } else if (shareItem.dqt) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                X.X("obj_source", shareItem.dqE);
                if (!aq.isEmpty(shareItem.linkUrl) && shareItem.linkUrl.contains("worldcup")) {
                    X.X("obj_param1", 9);
                }
                TiebaStatic.log(X);
            } else if (shareItem.dqu) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cx("tid", shareItem.extData).cx("fid", shareItem.fid).X("obj_type", i).X("obj_source", shareItem.dqE).X("obj_param1", shareItem.dqF).X(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqG).X(TiebaInitialize.Params.OBJ_PARAM3, shareItem.dqH).X("obj_locate", shareItem.dqI));
            }
        }
    }

    private String m(ShareItem shareItem) {
        String str = "【" + shareItem.title + "】 " + shareItem.content;
        shareItem.content = str;
        return str;
    }

    private void aZ(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }

    private Location bwy() {
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
