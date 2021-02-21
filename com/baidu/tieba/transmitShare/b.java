package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.view.ShareDialogItemView;
import com.baidu.tieba.tbadkCore.z;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    private static final int hIS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hIT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private ShareGridLayout nJy;
    private a nJz;
    private boolean nJA = false;
    private CustomMessageListener lhQ = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.lhQ);
    }

    public ShareGridLayout dRy() {
        if (this.nJy == null) {
            initView();
        }
        return this.nJy;
    }

    private void initView() {
        this.nJy = new ShareGridLayout(this.mContext);
        this.nJy.setItemParams(hIS, hIT);
    }

    private void b(com.baidu.tbadk.core.util.e.a aVar, int i, int i2) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar, i2);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nJy.addView(shareDialogItemView.dJE());
        }
    }

    private void ag(int i, int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107), i3);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nJy.addView(shareDialogItemView.dJE());
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.nJy.removeAllViews();
        this.nJA = shareDialogConfig.mShowMoreForumShare;
        if (this.nJA) {
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ag(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
            return;
        }
        if (this.mShareItem.fvi) {
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ag(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10);
        }
        if (z) {
            ag(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
        }
    }

    public void a(a aVar) {
        this.nJz = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nJz != null) {
            this.nJz.el(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (Kn(num.intValue())) {
                Kl(num.intValue());
            } else {
                Km(num.intValue());
            }
        }
    }

    private void Kl(int i) {
        g gVar = new g(this.mContext, null);
        ShareItem shareItem = this.mShareItem;
        if (i == 4) {
            f("share_to_weixin", new Object[0]);
            a(shareItem, 4);
            if (shareItem != null) {
                gVar.e(shareItem);
            }
        } else if (i == 3) {
            f("share_to_pyq", new Object[0]);
            a(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.fuG) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.f(shareItem);
            }
        } else if (i == 9) {
            if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                f("share_to_qq_friend", new Object[0]);
                a(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    gVar.g(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
        } else if (i == 5) {
            if (z.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                f("share_to_qzone", new Object[0]);
                a(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    gVar.h(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bqD();
        } else if (i == 7) {
            try {
                if (!WbSdk.isWbInstall(this.mContext)) {
                    WbSdk.install(this.mContext, new AuthInfo(this.mContext, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            f("share_to_sweibo", new Object[0]);
            a(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.fuF) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.j(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = g.dV(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.fuF) {
                bV(8, shareItem.fuU);
            }
        }
    }

    private void Km(int i) {
        if (i == 13) {
            dRz();
            Ko(13);
        }
    }

    private boolean Kn(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void dRz() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.nJA) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.fvg != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.fvg.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.fvg.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.fvg.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.fvf);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.lhQ);
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void Ko(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", this.mShareItem.fid).dR("tid", this.mShareItem.tid).ap("obj_type", i).ap("obj_source", this.mShareItem.fuX).ap("obj_param1", this.mShareItem.fuY));
            int i4 = this.mShareItem.fvc;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.fvc;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.fvc;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.fvc;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.fuX;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.fuX;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.fuX;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.fuX;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new ar("c13567").ap("obj_locate", i != 11 ? 1 : 2).ap("obj_source", i3).ap("obj_type", i2));
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
                TiebaStatic.log(ap);
            }
        }
    }

    private void n(ShareItem shareItem) {
        ar ap = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ap("obj_source", 7);
        if (shareItem.fuY != 0) {
            ap.ap("obj_param1", shareItem.fuY);
            if (shareItem.fuY == 2) {
                ap.dR("fid", shareItem.fid);
            } else if (shareItem.fuY == 3) {
                if (shareItem.fvc != 0) {
                    ap.ap("obj_type", shareItem.fvc);
                }
                ap.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        ap.ap("obj_locate", 9);
        TiebaStatic.log(ap);
    }

    private void bV(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
