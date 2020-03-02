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
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout ktT;
    private a ktU;
    private boolean ktV = false;
    private CustomMessageListener ktW = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
    private static final int ffZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int fga = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int jWd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int jWe = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int jWf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int dqH = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.ktW);
    }

    public ShareGridLayout cOE() {
        if (this.ktT == null) {
            initView();
        }
        return this.ktT;
    }

    private void initView() {
        this.ktT = new ShareGridLayout(this.mContext);
        this.ktT.setItemParams(ffZ, fga);
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
                com.baidu.tbadk.core.util.f.a.aHa().kB(1).kC(R.color.cp_bg_line_i).aQ(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(jWd, jWd);
            layoutParams.topMargin = jWe;
            layoutParams.bottomMargin = jWf;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dqH);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.ktT.addView(linearLayout, new ViewGroup.LayoutParams(ffZ, fga));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.ktT.removeAllViews();
        this.ktV = shareDialogConfig.mShowMoreForumShare;
        if (this.ktV) {
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.e.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.dqp) {
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
        this.ktU = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ktU != null) {
            this.ktU.cV(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (Dk(num.intValue())) {
                Di(num.intValue());
            } else {
                Dj(num.intValue());
            }
        }
    }

    private void Di(int i) {
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
                if (shareItem.dpO) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.f(shareItem);
            }
        } else if (i == 9) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEH();
        } else if (i == 5) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).aEH();
        } else if (i == 7) {
            h("share_to_sweibo", new Object[0]);
            a(shareItem, 7);
            if (shareItem != null) {
                if (!shareItem.dpN) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                fVar.j(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = f.cE(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.dpN) {
                aZ(8, shareItem.dqb);
            }
        }
    }

    private void Dj(int i) {
        if (i == 11) {
            a("1", (TransmitForumData) null, this.mPrivateThread);
            Dl(11);
        } else if (i == 13) {
            cOF();
            Dl(13);
        }
    }

    private boolean Dk(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void cOF() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.ktV) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.dqn != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.dqn.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.dqn.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.dqn.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.dqm);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        h a;
        if (this.mShareItem != null) {
            if (this.mShareItem.dqn == null && this.mShareItem.dqm != null) {
                this.mShareItem.dqn = ShareItem.ForwardInfo.generateForwardInfo(this.mShareItem.dqm);
            }
            if (this.mShareItem.dqn != null && (a = h.a(this.mShareItem.dqn)) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921426, a));
            }
        }
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.ktW);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void Dl(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("fid", this.mShareItem.fid).cy("tid", this.mShareItem.tid).X("obj_type", i).X("obj_source", this.mShareItem.dqe).X("obj_param1", this.mShareItem.dqf));
            int i4 = this.mShareItem.dqj;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.dqj;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.dqj;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.dqj;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.dqe;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.dqe;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.dqe;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.dqe;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new an("c13567").X("obj_locate", i != 11 ? 1 : 2).X("obj_source", i3).X("obj_type", i2));
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.dpO) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("fid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpP || shareItem.dpS) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).cy("tid", shareItem.extData).X("obj_type", i).X("obj_source", shareItem.dqe).X("obj_param1", shareItem.dqf).cy("fid", shareItem.fid).X(TiebaInitialize.Params.OBJ_PARAM2, shareItem.dqg));
            } else if (shareItem.dpQ) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).cy("tid", shareItem.extData).X("obj_type", i));
            } else if (shareItem.dpN) {
                aZ(i, shareItem.dqb);
            } else if (shareItem.dpR) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_param1", 7).X("obj_type", i).cy("fid", shareItem.extData));
            } else if (shareItem.dpT) {
                an X = new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).X("obj_type", i);
                X.X("obj_source", shareItem.dqe);
                TiebaStatic.log(X);
            }
        }
    }

    private void n(ShareItem shareItem) {
        an X = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).X("obj_source", 7);
        if (shareItem.dqf != 0) {
            X.X("obj_param1", shareItem.dqf);
            if (shareItem.dqf == 2) {
                X.cy("fid", shareItem.fid);
            } else if (shareItem.dqf == 3) {
                if (shareItem.dqj != 0) {
                    X.X("obj_type", shareItem.dqj);
                }
                X.cy("tid", shareItem.tid).cy("fid", shareItem.fid);
            }
        }
        TiebaStatic.log(X);
    }

    private void aZ(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
