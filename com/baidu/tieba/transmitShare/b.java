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
import com.baidu.tieba.tbadkCore.y;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class b implements View.OnClickListener {
    private static final int hnr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hns = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private ShareGridLayout nlF;
    private a nlG;
    private boolean nlH = false;
    private CustomMessageListener kLi = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.kLi);
    }

    public ShareGridLayout dNM() {
        if (this.nlF == null) {
            initView();
        }
        return this.nlF;
    }

    private void initView() {
        this.nlF = new ShareGridLayout(this.mContext);
        this.nlF.setItemParams(hnr, hns);
    }

    private void b(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar, i2);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nlF.addView(shareDialogItemView.dGb());
        }
    }

    private void ah(int i, int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107), i3);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nlF.addView(shareDialogItemView.dGb());
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.nlF.removeAllViews();
        this.nlH = shareDialogConfig.mShowMoreForumShare;
        if (this.nlH) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ah(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
            return;
        }
        if (this.mShareItem.fgp) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ah(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10);
        }
        if (z) {
            ah(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
        }
    }

    public void a(a aVar) {
        this.nlG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nlG != null) {
            this.nlG.dS(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (KU(num.intValue())) {
                KS(num.intValue());
            } else {
                KT(num.intValue());
            }
        }
    }

    private void KS(int i) {
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
                if (shareItem.ffN) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.f(shareItem);
            }
        } else if (i == 9) {
            if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
        } else if (i == 5) {
            if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bom();
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
                if (!shareItem.ffM) {
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
            m(shareItem);
            if (shareItem != null && shareItem.ffM) {
                bN(8, shareItem.fgb);
            }
        }
    }

    private void KT(int i) {
        if (i == 13) {
            dNN();
            KV(13);
        }
    }

    private boolean KU(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void dNN() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.nlH) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.fgn != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.fgn.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.fgn.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.fgn.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.fgm);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.kLi);
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void KV(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dR("fid", this.mShareItem.fid).dR("tid", this.mShareItem.tid).ak("obj_type", i).ak("obj_source", this.mShareItem.fge).ak("obj_param1", this.mShareItem.fgf));
            int i4 = this.mShareItem.fgj;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.fgj;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.fgj;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.fgj;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.fge;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.fge;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.fge;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.fge;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new ar("c13567").ak("obj_locate", i != 11 ? 1 : 2).ak("obj_source", i3).ak("obj_type", i2));
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
                TiebaStatic.log(ak);
            }
        }
    }

    private void m(ShareItem shareItem) {
        ar ak = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ak("obj_source", 7);
        if (shareItem.fgf != 0) {
            ak.ak("obj_param1", shareItem.fgf);
            if (shareItem.fgf == 2) {
                ak.dR("fid", shareItem.fid);
            } else if (shareItem.fgf == 3) {
                if (shareItem.fgj != 0) {
                    ak.ak("obj_type", shareItem.fgj);
                }
                ak.dR("tid", shareItem.tid).dR("fid", shareItem.fid);
            }
        }
        ak.ak("obj_locate", 9);
        TiebaStatic.log(ak);
    }

    private void bN(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
