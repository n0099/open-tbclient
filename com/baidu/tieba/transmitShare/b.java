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
/* loaded from: classes24.dex */
public class b implements View.OnClickListener {
    private static final int hwY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds202);
    private static final int hwZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds239);
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private ShareGridLayout nzJ;
    private a nzK;
    private boolean nzL = false;
    private CustomMessageListener kYz = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.kYz);
    }

    public ShareGridLayout dTe() {
        if (this.nzJ == null) {
            initView();
        }
        return this.nzJ;
    }

    private void initView() {
        this.nzJ = new ShareGridLayout(this.mContext);
        this.nzJ.setItemParams(hwY, hwZ);
    }

    private void b(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
            shareDialogItemView.setItemIcon(aVar, i2);
            shareDialogItemView.setItemName(i);
            shareDialogItemView.setOnClickListener(this);
            this.nzJ.addView(shareDialogItemView.dLp());
        }
    }

    private void ag(int i, int i2, int i3) {
        ShareDialogItemView shareDialogItemView = new ShareDialogItemView(this.mContext);
        shareDialogItemView.setItemIcon(i2, ap.getColor(R.color.CAM_X0107), i3);
        shareDialogItemView.setItemName(i);
        shareDialogItemView.setOnClickListener(this);
        this.nzJ.addView(shareDialogItemView.dLp());
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.nzJ.removeAllViews();
        this.nzL = shareDialogConfig.mShowMoreForumShare;
        if (this.nzL) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ag(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
            return;
        }
        if (this.mShareItem.fnP) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            ag(R.string.share_copy, R.drawable.icon_pure_share_copy40, 10);
        }
        if (z) {
            ag(R.string.more_forums, R.drawable.icon_pure_share_moreba40, 13);
        }
    }

    public void a(a aVar) {
        this.nzK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.nzK != null) {
            this.nzK.ed(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (LM(num.intValue())) {
                LK(num.intValue());
            } else {
                LL(num.intValue());
            }
        }
    }

    private void LK(int i) {
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
                if (shareItem.fnn) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).brB();
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
                if (!shareItem.fnm) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.j(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = g.ec(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            m(shareItem);
            if (shareItem != null && shareItem.fnm) {
                bN(8, shareItem.fnB);
            }
        }
    }

    private void LL(int i) {
        if (i == 13) {
            dTf();
            LN(13);
        }
    }

    private boolean LM(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void dTf() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.nzL) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.fnN != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.fnN.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.fnN.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.fnN.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.fnM);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.kYz);
    }

    private void f(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void LN(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dY("fid", this.mShareItem.fid).dY("tid", this.mShareItem.tid).al("obj_type", i).al("obj_source", this.mShareItem.fnE).al("obj_param1", this.mShareItem.fnF));
            int i4 = this.mShareItem.fnJ;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.fnJ;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.fnJ;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.fnJ;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.fnE;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.fnE;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.fnE;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.fnE;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new ar("c13567").al("obj_locate", i != 11 ? 1 : 2).al("obj_source", i3).al("obj_type", i2));
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
                TiebaStatic.log(al);
            }
        }
    }

    private void m(ShareItem shareItem) {
        ar al = new ar(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).al("obj_source", 7);
        if (shareItem.fnF != 0) {
            al.al("obj_param1", shareItem.fnF);
            if (shareItem.fnF == 2) {
                al.dY("fid", shareItem.fid);
            } else if (shareItem.fnF == 3) {
                if (shareItem.fnJ != 0) {
                    al.al("obj_type", shareItem.fnJ);
                }
                al.dY("tid", shareItem.tid).dY("fid", shareItem.fid);
            }
        }
        al.al("obj_locate", 9);
        TiebaStatic.log(al);
    }

    private void bN(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
