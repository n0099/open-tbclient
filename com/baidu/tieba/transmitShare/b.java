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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.e;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout ksP;
    private a ksQ;
    private boolean ksR = false;
    private CustomMessageListener ksS = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
            }
        }
    };
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private static final int fcP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fcQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jUW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jUX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jUY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dmx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.ksS);
    }

    public ShareGridLayout cNf() {
        if (this.ksP == null) {
            initView();
        }
        return this.ksP;
    }

    private void initView() {
        this.ksP = new ShareGridLayout(this.mContext);
        this.ksP.setItemParams(fcP, fcQ);
    }

    private void a(com.baidu.tbadk.core.util.e.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setClickable(false);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (aVar instanceof com.baidu.tbadk.core.util.e.c) {
                com.baidu.tbadk.core.util.f.a.aEM().kk(1).kl(R.color.cp_bg_line_i).aQ(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jUW, jUW);
            layoutParams.topMargin = jUX;
            layoutParams.bottomMargin = jUY;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dmx);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.ksP.addView(linearLayout, new ViewGroup.LayoutParams(fcP, fcQ));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.ksP.removeAllViews();
        this.ksR = shareDialogConfig.mShowMoreForumShare;
        if (this.ksR) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.dmf) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b), R.string.share_copy, 10);
        }
        if (z) {
            a(new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_share_homepage40_svg, R.color.cp_cont_b), R.string.my_homepage, 11);
            a(new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.ksQ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ksQ != null) {
            this.ksQ.cT(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (De(num.intValue())) {
                Dc(num.intValue());
            } else {
                Dd(num.intValue());
            }
        }
    }

    private void Dc(int i) {
        e eVar = new e(this.mContext, null);
        ShareItem shareItem = this.mShareItem;
        if (i == 4) {
            h("share_to_weixin", new Object[0]);
            a(shareItem, 4);
            if (shareItem != null) {
                eVar.e(shareItem);
            }
        } else if (i == 3) {
            h("share_to_pyq", new Object[0]);
            a(shareItem, 3);
            if (shareItem != null) {
                if (shareItem.dlF) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                eVar.f(shareItem);
            }
        } else if (i == 9) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qq_friend", new Object[0]);
                a(shareItem, 9);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    eVar.g(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
        } else if (i == 5) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                h("share_to_qzone", new Object[0]);
                a(shareItem, 5);
                if (shareItem != null) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    eVar.h(shareItem);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aCu();
        } else if (i == 7) {
            h("share_to_sweibo", new Object[0]);
            a(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.dlE) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                eVar.j(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = e.cv(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.dlE) {
                aZ(8, shareItem.dlR);
            }
        }
    }

    private void Dd(int i) {
        if (i == 11) {
            a("1", (TransmitForumData) null, this.mPrivateThread);
            Df(11);
        } else if (i == 13) {
            cNg();
            Df(13);
        }
    }

    private boolean De(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void cNg() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.ksR) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.dmd != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.dmd.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.dmd.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.dmd.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.dmc);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        h a;
        if (this.mShareItem != null) {
            if (this.mShareItem.dmd == null && this.mShareItem.dmc != null) {
                this.mShareItem.dmd = ShareItem.ForwardInfo.generateForwardInfo(this.mShareItem.dmc);
            }
            if (this.mShareItem.dmd != null && (a = h.a(this.mShareItem.dmd)) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, a));
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ksS);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void Df(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", this.mShareItem.fid).cp("tid", this.mShareItem.tid).Z("obj_type", i).Z("obj_source", this.mShareItem.dlU).Z("obj_param1", this.mShareItem.dlV));
            int i4 = this.mShareItem.dlZ;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.dlZ;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.dlZ;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.dlZ;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.dlU;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.dlU;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.dlU;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.dlU;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new an("c13567").Z("obj_locate", i != 11 ? 1 : 2).Z("obj_source", i3).Z("obj_type", i2));
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dlF) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("fid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlG || shareItem.dlJ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cp("tid", shareItem.extData).Z("obj_type", i).Z("obj_source", shareItem.dlU).Z("obj_param1", shareItem.dlV).cp("fid", shareItem.fid));
            } else if (shareItem.dlH) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cp("tid", shareItem.extData).Z("obj_type", i));
            } else if (shareItem.dlE) {
                aZ(i, shareItem.dlR);
            } else if (shareItem.dlI) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).Z("obj_param1", 7).Z("obj_type", i).cp("fid", shareItem.extData));
            }
        }
    }

    private void n(ShareItem shareItem) {
        an Z = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).Z("obj_source", 7);
        if (shareItem.dlV != 0) {
            Z.Z("obj_param1", shareItem.dlV);
            if (shareItem.dlV == 2) {
                Z.cp("fid", shareItem.fid);
            } else if (shareItem.dlV == 3) {
                if (shareItem.dlZ != 0) {
                    Z.Z("obj_type", shareItem.dlZ);
                }
                Z.cp("tid", shareItem.tid).cp("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(Z);
    }

    private void aZ(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
