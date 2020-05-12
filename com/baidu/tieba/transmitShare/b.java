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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.write.upload.ForwardUploadData;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout lfV;
    private a lfW;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private static final int fLc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fLd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int kHf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int kHg = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int kHh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dRj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private boolean lfX = false;
    private CustomMessageListener iPH = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.iPH);
    }

    public ShareGridLayout cZU() {
        if (this.lfV == null) {
            initView();
        }
        return this.lfV;
    }

    private void initView() {
        this.lfV = new ShareGridLayout(this.mContext);
        this.lfV.setItemParams(fLc, fLd);
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
                com.baidu.tbadk.core.util.e.a.aPr().kL(1).kM(R.color.cp_bg_line_i).aR(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(kHf, kHf);
            layoutParams.topMargin = kHg;
            layoutParams.bottomMargin = kHh;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dRj);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.lfV.addView(linearLayout, new ViewGroup.LayoutParams(fLc, fLd));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.lfV.removeAllViews();
        this.lfX = shareDialogConfig.mShowMoreForumShare;
        if (this.lfX) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.dQN) {
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
        this.lfW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.lfW != null) {
            this.lfW.dd(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (DW(num.intValue())) {
                DU(num.intValue());
            } else {
                DV(num.intValue());
            }
        }
    }

    private void DU(int i) {
        f fVar = new f(this.mContext, null);
        ShareItem shareItem = this.mShareItem;
        if (i == 4) {
            h("share_to_weixin", new Object[0]);
            a(shareItem, 4);
            if (shareItem != null) {
                fVar.e(shareItem);
            }
        } else if (i == 3) {
            h("share_to_pyq", new Object[0]);
            a(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.dQm) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.f(shareItem);
            }
        } else if (i == 9) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qq_friend", new Object[0]);
                a(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    fVar.g(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMX();
        } else if (i == 5) {
            if (x.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qzone", new Object[0]);
                a(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    fVar.h(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aMX();
        } else if (i == 7) {
            h("share_to_sweibo", new Object[0]);
            a(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.dQl) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.j(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = f.cO(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.dQl) {
                bo(8, shareItem.dQz);
            }
        }
    }

    private void DV(int i) {
        if (i == 11) {
            a("1", null, this.mPrivateThread);
            DX(11);
        } else if (i == 13) {
            cZV();
            DX(13);
        }
    }

    private boolean DW(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void cZV() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.lfX) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.dQL != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.dQL.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.dQL.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.dQL.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.dQK);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        if (this.mShareItem != null) {
            if (this.mShareItem.dQL == null && this.mShareItem.dQK != null) {
                this.mShareItem.dQL = ShareItem.ForwardInfo.generateForwardInfo(this.mShareItem.dQK);
            }
            if (this.mShareItem.dQL != null) {
                TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, null, null, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.mShareItem.dQK);
                transmitPostEditActivityConfig.setCallFrom(str);
                transmitPostEditActivityConfig.setPrivateThread(i);
                transmitPostEditActivityConfig.setBaijiahaoData(this.mShareItem.dQL.baijiahaoData);
                transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.mShareItem.dQL.transmitOriginThreadComment);
                transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.dQL.transmitThreadAuthorNameShow);
                ForwardUploadData forwardUploadData = new ForwardUploadData();
                forwardUploadData.parseForwardAndExt(this.mShareItem.dQL);
                transmitPostEditActivityConfig.setForwardUploadData(forwardUploadData);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.iPH);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void DX(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("fid", this.mShareItem.fid).cI("tid", this.mShareItem.tid).af("obj_type", i).af("obj_source", this.mShareItem.dQC).af("obj_param1", this.mShareItem.dQD));
            int i4 = this.mShareItem.dQH;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.dQH;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.dQH;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.dQH;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.dQC;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.dQC;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.dQC;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.dQC;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new an("c13567").af("obj_locate", i != 11 ? 1 : 2).af("obj_source", i3).af("obj_type", i2));
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dQm) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("fid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQn || shareItem.dQq) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cI("tid", shareItem.extData).af("obj_type", i).af("obj_source", shareItem.dQC).af("obj_param1", shareItem.dQD).cI("fid", shareItem.fid).af(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dQE));
            } else if (shareItem.dQo) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cI("tid", shareItem.extData).af("obj_type", i));
            } else if (shareItem.dQl) {
                bo(i, shareItem.dQz);
            } else if (shareItem.dQp) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_param1", 7).af("obj_type", i).cI("fid", shareItem.extData));
            } else if (shareItem.dQr) {
                an af = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).af("obj_type", i);
                af.af("obj_source", shareItem.dQC);
                TiebaStatic.log(af);
            }
        }
    }

    private void n(ShareItem shareItem) {
        an af = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).af("obj_source", 7);
        if (shareItem.dQD != 0) {
            af.af("obj_param1", shareItem.dQD);
            if (shareItem.dQD == 2) {
                af.cI("fid", shareItem.fid);
            } else if (shareItem.dQD == 3) {
                if (shareItem.dQH != 0) {
                    af.af("obj_type", shareItem.dQH);
                }
                af.cI("tid", shareItem.tid).cI("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(af);
    }

    private void bo(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
