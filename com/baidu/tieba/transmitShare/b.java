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
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.coreExtra.share.g;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.y;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class b implements View.OnClickListener {
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private ShareItem mShareItem;
    private ShareGridLayout msA;
    private a msB;
    private static final int gEc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int gEd = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int lTm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int lTn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int lTo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int eFc = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);
    private boolean msC = false;
    private CustomMessageListener jUD = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
        MessageManager.getInstance().registerListener(this.jUD);
    }

    public ShareGridLayout dAo() {
        if (this.msA == null) {
            initView();
        }
        return this.msA;
    }

    private void initView() {
        this.msA = new ShareGridLayout(this.mContext);
        this.msA.setItemParams(gEc, gEd);
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
                com.baidu.tbadk.core.util.e.a.bjQ().oe(1).of(R.color.cp_bg_line_i).aZ(imageView);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(lTm, lTm);
            layoutParams.topMargin = lTn;
            layoutParams.bottomMargin = lTo;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, eFc);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.msA.addView(linearLayout, new ViewGroup.LayoutParams(gEc, gEd));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.msA.removeAllViews();
        this.msC = shareDialogConfig.mShowMoreForumShare;
        if (this.msC) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.eED) {
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg), R.string.share_weixin, 4);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg), R.string.share_weixin_timeline, 3);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg), R.string.share_qq_friends, 9);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg), R.string.share_qzone, 5);
            b(new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg), R.string.share_sina_weibo, 7);
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_copy40_svg, R.color.cp_cont_b), R.string.share_copy, 10);
        }
        if (z) {
            b(new com.baidu.tbadk.core.util.d.c(R.drawable.icon_pure_share_moreba40_svg, R.color.cp_cont_b), R.string.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.msB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.msB != null) {
            this.msB.dp(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), R.string.share_on_no_network);
            } else if (ID(num.intValue())) {
                IB(num.intValue());
            } else {
                IC(num.intValue());
            }
        }
    }

    private void IB(int i) {
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
                if (shareItem.eEb) {
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.g(shareItem);
            }
        } else if (i == 9) {
            if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
        } else if (i == 5) {
            if (y.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).bhm();
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
                if (!shareItem.eEa) {
                    if (!StringUtils.isNull(shareItem.title) && !StringUtils.isNull(shareItem.content) && shareItem.title.trim().equals(shareItem.content.trim())) {
                        shareItem.content = "";
                    }
                    shareItem.content = "【" + shareItem.title + "】 " + shareItem.content;
                }
                gVar.k(shareItem);
            }
        } else if (i == 10) {
            a(shareItem, 10);
            shareItem.linkUrl = g.dH(shareItem.linkUrl, shareItem.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(shareItem);
            if (shareItem != null && shareItem.eEa) {
                bx(8, shareItem.eEp);
            }
        }
    }

    private void IC(int i) {
        if (i == 13) {
            dAp();
            IE(13);
        }
    }

    private boolean ID(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void dAp() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.msC) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        if (this.mShareItem.eEB != null) {
            selectForumActivityConfig.setBaijiahaoData(this.mShareItem.eEB.baijiahaoData);
            selectForumActivityConfig.setTransmitOriginThreadComment(this.mShareItem.eEB.transmitOriginThreadComment);
            selectForumActivityConfig.setTransmitThreadAuthorNameShow(this.mShareItem.eEB.transmitThreadAuthorNameShow);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.eEA);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.jUD);
    }

    private void h(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void IE(int i) {
        int i2;
        int i3 = 3;
        if (this.mShareItem != null) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("fid", this.mShareItem.fid).dD("tid", this.mShareItem.tid).ai("obj_type", i).ai("obj_source", this.mShareItem.eEs).ai("obj_param1", this.mShareItem.eEt));
            int i4 = this.mShareItem.eEx;
            ShareItem shareItem = this.mShareItem;
            if (i4 == 5) {
                i2 = 1;
            } else {
                int i5 = this.mShareItem.eEx;
                ShareItem shareItem2 = this.mShareItem;
                if (i5 == 6) {
                    i2 = 2;
                } else {
                    int i6 = this.mShareItem.eEx;
                    ShareItem shareItem3 = this.mShareItem;
                    if (i6 == 7) {
                        i2 = 3;
                    } else {
                        int i7 = this.mShareItem.eEx;
                        ShareItem shareItem4 = this.mShareItem;
                        i2 = i7 == 8 ? 4 : 0;
                    }
                }
            }
            int i8 = this.mShareItem.eEs;
            ShareItem shareItem5 = this.mShareItem;
            if (i8 == 4) {
                i3 = 1;
            } else {
                int i9 = this.mShareItem.eEs;
                ShareItem shareItem6 = this.mShareItem;
                if (i9 == 3) {
                    i3 = 2;
                } else {
                    int i10 = this.mShareItem.eEs;
                    ShareItem shareItem7 = this.mShareItem;
                    if (i10 != 8) {
                        int i11 = this.mShareItem.eEs;
                        ShareItem shareItem8 = this.mShareItem;
                        i3 = i11 == 6 ? 4 : 0;
                    }
                }
            }
            TiebaStatic.log(new aq("c13567").ai("obj_locate", i != 11 ? 1 : 2).ai("obj_source", i3).ai("obj_type", i2));
        }
    }

    private void a(ShareItem shareItem, int i) {
        if (shareItem != null && shareItem.extData != null) {
            if (shareItem.eEb) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("fid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEc || shareItem.eEf) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).dD("tid", shareItem.extData).ai("obj_type", i).ai("obj_source", shareItem.eEs).ai("obj_param1", shareItem.eEt).dD("fid", shareItem.fid).ai(TiebaInitialize.Params.OBJ_PARAM2, shareItem.eEu));
            } else if (shareItem.eEd) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).dD("tid", shareItem.extData).ai("obj_type", i));
            } else if (shareItem.eEa) {
                bx(i, shareItem.eEp);
            } else if (shareItem.eEe) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_param1", 7).ai("obj_type", i).dD("fid", shareItem.extData));
            } else if (shareItem.eEg) {
                aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).ai("obj_type", i);
                ai.ai("obj_source", shareItem.eEs);
                TiebaStatic.log(ai);
            }
        }
    }

    private void n(ShareItem shareItem) {
        aq ai = new aq(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).ai("obj_source", 7);
        if (shareItem.eEt != 0) {
            ai.ai("obj_param1", shareItem.eEt);
            if (shareItem.eEt == 2) {
                ai.dD("fid", shareItem.fid);
            } else if (shareItem.eEt == 3) {
                if (shareItem.eEx != 0) {
                    ai.ai("obj_type", shareItem.eEx);
                }
                ai.dD("tid", shareItem.tid).dD("fid", shareItem.fid);
            }
        }
        ai.ai("obj_locate", 9);
        TiebaStatic.log(ai);
    }

    private void bx(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
