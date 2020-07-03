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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout lTu;
    private a lTv;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private static final int gmk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gml = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int luo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lup = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int luq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eoo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private boolean lTw = false;
    private CustomMessageListener jwG = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.jwG);
    }

    public ShareGridLayout dlF() {
        if (this.lTu == null) {
            initView();
        }
        return this.lTu;
    }

    private void initView() {
        this.lTu = new ShareGridLayout(this.mContext);
        this.lTu.setItemParams(gmk, gml);
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
                com.baidu.tbadk.core.util.e.a.aXq().lG(1).lH(R.color.cp_bg_line_i).aR(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(luo, luo);
            layoutParams.topMargin = lup;
            layoutParams.bottomMargin = luq;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eoo);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            an.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.lTu.addView(linearLayout, new ViewGroup.LayoutParams(gmk, gml));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.lTu.removeAllViews();
        this.lTw = shareDialogConfig.mShowMoreForumShare;
        if (this.lTw) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.enR) {
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
        this.lTv = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lTv != null) {
            this.lTv.df(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (FL(num.intValue())) {
                FJ(num.intValue());
            } else {
                FK(num.intValue());
            }
        }
    }

    private void FJ(int i) {
        f fVar = new f(this.mContext, null);
        ShareItem shareItem = this.mShareItem;
        if (i == 4) {
            h("share_to_weixin", new Object[0]);
            a(shareItem, 4);
            if (shareItem != null) {
                fVar.f(shareItem);
            }
        } else if (i == 3) {
            h("share_to_pyq", new Object[0]);
            a(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.enq) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.g(shareItem);
            }
        } else if (i == 9) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qq_friend", new Object[0]);
                a(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    fVar.h(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
        } else if (i == 5) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qzone", new Object[0]);
                a(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    fVar.i(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aUS();
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
                if (!shareItem.enp) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.k(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = f.dq(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.enp) {
                by(8, shareItem.enD);
            }
        }
    }

    private void FK(int i) {
        if (i == 11) {
            a("1", null, this.mPrivateThread);
            FM(11);
        } else if (i == 13) {
            dlG();
            FM(13);
        }
    }

    private boolean FL(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void dlG() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.lTw) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.enP != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.enP.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.enP.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.enP.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.enO);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        if (this.mShareItem != null) {
            if (this.mShareItem.enP == null && this.mShareItem.enO != null) {
                this.mShareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(this.mShareItem.enO);
            }
            if (this.mShareItem.enP != null) {
                TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, null, null, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.mShareItem.enO);
                transmitPostEditActivityConfig.setCallFrom(str);
                transmitPostEditActivityConfig.setPrivateThread(i);
                transmitPostEditActivityConfig.setBaijiahaoData(this.mShareItem.enP.baijiahaoData);
                transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mShareItem.enP.transmitOriginThreadComment);
                transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.enP.transmitThreadAuthorNameShow);
                ForwardUploadData forwardUploadData = new ForwardUploadData();
                forwardUploadData.parseForwardAndExt(this.mShareItem.enP);
                transmitPostEditActivityConfig.setForwardUploadData(forwardUploadData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.jwG);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void FM(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("fid", this.mShareItem.fid).dk("tid", this.mShareItem.tid).ag("obj_type", i).ag("obj_source", this.mShareItem.enG).ag("obj_param1", this.mShareItem.enH));
            int i4 = this.mShareItem.enL;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.enL;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.enL;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.enL;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.enG;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.enG;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.enG;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.enG;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new ao("c13567").ag("obj_locate", i != 11 ? 1 : 2).ag("obj_source", i3).ag("obj_type", i2));
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.enq) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("fid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.enr || shareItem.enu) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dk("tid", shareItem.extData).ag("obj_type", i).ag("obj_source", shareItem.enG).ag("obj_param1", shareItem.enH).dk("fid", shareItem.fid).ag(TiebaInitialize.Params.OBJ_PARAM2, shareItem.enI));
            } else if (shareItem.ens) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dk("tid", shareItem.extData).ag("obj_type", i));
            } else if (shareItem.enp) {
                by(i, shareItem.enD);
            } else if (shareItem.ent) {
                TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_param1", 7).ag("obj_type", i).dk("fid", shareItem.extData));
            } else if (shareItem.enw) {
                ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ag("obj_type", i);
                ag.ag("obj_source", shareItem.enG);
                TiebaStatic.log(ag);
            }
        }
    }

    private void n(ShareItem shareItem) {
        ao ag = new ao(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ag("obj_source", 7);
        if (shareItem.enH != 0) {
            ag.ag("obj_param1", shareItem.enH);
            if (shareItem.enH == 2) {
                ag.dk("fid", shareItem.fid);
            } else if (shareItem.enH == 3) {
                if (shareItem.enL != 0) {
                    ag.ag("obj_type", shareItem.enL);
                }
                ag.dk("tid", shareItem.tid).dk("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(ag);
    }

    private void by(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
