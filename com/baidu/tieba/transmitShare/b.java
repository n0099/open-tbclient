package com.baidu.tieba.transmitShare;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class b implements View.OnClickListener {
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private ShareGridLayout maN;
    private a maO;
    private static final int gri = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int grj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lBF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lBG = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lBH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int euD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private boolean maP = false;
    private CustomMessageListener jFk = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.jFk);
    }

    public ShareGridLayout doS() {
        if (this.maN == null) {
            initView();
        }
        return this.maN;
    }

    private void initView() {
        this.maN = new ShareGridLayout(this.mContext);
        this.maN.setItemParams(gri, grj);
    }

    private void b(com.baidu.tbadk.core.util.d.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setClickable(false);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.d.c) {
                com.baidu.tbadk.core.util.e.a.bbr().ma(1).mb(R.color.cp_bg_line_i).aX(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lBF, lBF);
            layoutParams.topMargin = lBG;
            layoutParams.bottomMargin = lBH;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, euD);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ao.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.maN.addView(linearLayout, new ViewGroup.LayoutParams(gri, grj));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.maN.removeAllViews();
        this.maP = shareDialogConfig.mShowMoreForumShare;
        if (this.maP) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.eud) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b), R.string.share_copy, 10);
        }
        if (z) {
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_homepage40_svg, R.color.cp_cont_b), R.string.my_homepage, 11);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.maO = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.maO != null) {
            this.maO.dl(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (Gh(num.intValue())) {
                Gf(num.intValue());
            } else {
                Gg(num.intValue());
            }
        }
    }

    private void Gf(int i) {
        g gVar = new g(this.mContext, null);
        ShareItem shareItem = this.mShareItem;
        if (i == 4) {
            h("share_to_weixin", new Object[0]);
            a(shareItem, 4);
            if (shareItem != null) {
                gVar.f(shareItem);
            }
        } else if (i == 3) {
            h("share_to_pyq", new Object[0]);
            a(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.etD) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.g(shareItem);
            }
        } else if (i == 9) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qq_friend", new Object[0]);
                a(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    gVar.h(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
        } else if (i == 5) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qzone", new Object[0]);
                a(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    gVar.i(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aYR();
        } else if (i == 7) {
            try {
                if (!WbSdk.isWbInstall(this.mContext)) {
                    WbSdk.install(this.mContext, new AuthInfo(this.mContext, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
            h("share_to_sweibo", new Object[0]);
            a(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.etC) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.k(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = g.dr(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.etC) {
                bz(8, shareItem.etP);
            }
        }
    }

    private void Gg(int i) {
        if (i == 11) {
            a("1", null, this.mPrivateThread);
            Gi(11);
        } else if (i == 13) {
            doT();
            Gi(13);
        }
    }

    private boolean Gh(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void doT() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.maP) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.eub != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.eub.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.eub.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.eub.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.eua);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        if (this.mShareItem != null) {
            if (this.mShareItem.eub == null && this.mShareItem.eua != null) {
                this.mShareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(this.mShareItem.eua);
            }
            if (this.mShareItem.eub != null) {
                TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, null, null, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.mShareItem.eua);
                transmitPostEditActivityConfig.setCallFrom(str);
                transmitPostEditActivityConfig.setPrivateThread(i);
                transmitPostEditActivityConfig.setBaijiahaoData(this.mShareItem.eub.baijiahaoData);
                transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mShareItem.eub.transmitOriginThreadComment);
                transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.eub.transmitThreadAuthorNameShow);
                ForwardUploadData forwardUploadData = new ForwardUploadData();
                forwardUploadData.parseForwardAndExt(this.mShareItem.eub);
                transmitPostEditActivityConfig.setForwardUploadData(forwardUploadData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.jFk);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void Gi(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dn("fid", this.mShareItem.fid).dn("tid", this.mShareItem.tid).ah("obj_type", i).ah("obj_source", this.mShareItem.etS).ah("obj_param1", this.mShareItem.etT));
            int i4 = this.mShareItem.etX;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.etX;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.etX;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.etX;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.etS;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.etS;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.etS;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.etS;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new ap("c13567").ah("obj_locate", i != 11 ? 1 : 2).ah("obj_source", i3).ah("obj_type", i2));
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
                TiebaStatic.log(ah);
            }
        }
    }

    private void n(ShareItem shareItem) {
        ap ah = new ap(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ah("obj_source", 7);
        if (shareItem.etT != 0) {
            ah.ah("obj_param1", shareItem.etT);
            if (shareItem.etT == 2) {
                ah.dn("fid", shareItem.fid);
            } else if (shareItem.etT == 3) {
                if (shareItem.etX != 0) {
                    ah.ah("obj_type", shareItem.etX);
                }
                ah.dn("tid", shareItem.tid).dn("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ah);
    }

    private void bz(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
