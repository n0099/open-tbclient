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
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tbadk.coreExtra.c.f;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout jvV;
    private a jvW;
    private boolean jvX = false;
    private CustomMessageListener jvY = new CustomMessageListener(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED) { // from class: com.baidu.tieba.transmitShare.b.1
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
    private e mShareItem;
    private static final int ekE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int ekF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iXQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iXR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iXS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int czs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.jvY);
    }

    public ShareGridLayout csa() {
        if (this.jvV == null) {
            initView();
        }
        return this.jvV;
    }

    private void initView() {
        this.jvV = new ShareGridLayout(this.mContext);
        this.jvV.setItemParams(ekE, ekF);
    }

    private void a(com.baidu.tbadk.core.util.f.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iXQ, iXQ);
            layoutParams.topMargin = iXR;
            layoutParams.bottomMargin = iXS;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, czs);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.jvV.addView(linearLayout, new ViewGroup.LayoutParams(ekE, ekF));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.jvV.removeAllViews();
        this.jvX = shareDialogConfig.mShowMoreForumShare;
        if (this.jvX) {
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_moreba_n_svg), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.cyX) {
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_copy_n_svg), R.string.share_copy, 10);
        }
        if (z) {
            a(new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_homepage_n_svg), R.string.my_homepage, 11);
            a(new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_moreba_n_svg), R.string.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.jvW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jvW != null) {
            this.jvW.cS(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.isNetWorkAvailable() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (AE(num.intValue())) {
                AC(num.intValue());
            } else {
                AD(num.intValue());
            }
        }
    }

    private void AC(int i) {
        f fVar = new f(this.mContext, null);
        e eVar = this.mShareItem;
        if (i == 4) {
            j("share_to_weixin", new Object[0]);
            a(eVar, 4);
            if (eVar != null) {
                fVar.e(eVar);
            }
        } else if (i == 3) {
            j("share_to_pyq", new Object[0]);
            a(eVar, 3);
            if (eVar != null) {
                if (eVar.cyt) {
                    eVar.content = "【" + eVar.title + "】 " + eVar.content;
                }
                fVar.f(eVar);
            }
        } else if (i == 9) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                j("share_to_qq_friend", new Object[0]);
                a(eVar, 9);
                if (eVar != null) {
                    if (!StringUtils.isNull(eVar.title) && !StringUtils.isNull(eVar.content) && eVar.title.trim().equals(eVar.content.trim())) {
                        eVar.content = "";
                    }
                    fVar.g(eVar);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
        } else if (i == 5) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                j("share_to_qzone", new Object[0]);
                a(eVar, 5);
                if (eVar != null) {
                    if (!StringUtils.isNull(eVar.title) && !StringUtils.isNull(eVar.content) && eVar.title.trim().equals(eVar.content.trim())) {
                        eVar.content = "";
                    }
                    fVar.h(eVar);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).akT();
        } else if (i == 7) {
            j("share_to_sweibo", new Object[0]);
            a(eVar, 7);
            if (eVar != null) {
                if (!eVar.cys) {
                    if (!StringUtils.isNull(eVar.title) && !StringUtils.isNull(eVar.content) && eVar.title.trim().equals(eVar.content.trim())) {
                        eVar.content = "";
                    }
                    eVar.content = "【" + eVar.title + "】 " + eVar.content;
                }
                fVar.j(eVar);
            }
        } else if (i == 10) {
            a(eVar, 10);
            eVar.linkUrl = f.bY(eVar.linkUrl, eVar.tid);
            com.baidu.adp.lib.util.a.copyToClipboard(eVar.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            n(eVar);
            if (eVar != null && eVar.cys) {
                aE(8, eVar.cyJ);
            }
        }
    }

    private void AD(int i) {
        if (i == 11) {
            a("1", (TransmitForumData) null, this.mPrivateThread);
            AF(11);
        } else if (i == 13) {
            csb();
            AF(13);
        }
    }

    private boolean AE(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void csb() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, RequestResponseCode.REQUEST_SELECT_FORUM);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.jvX) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.originalThreadInfo);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, selectForumActivityConfig));
    }

    private void a(String str, TransmitForumData transmitForumData, int i) {
        String str2;
        String str3;
        if (transmitForumData != null) {
            str3 = String.valueOf(transmitForumData.forumId);
            str2 = transmitForumData.forumName;
        } else {
            str2 = null;
            str3 = null;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, str3, str2, null, null, RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT, null, null, null, this.mShareItem.originalThreadInfo);
        transmitPostEditActivityConfig.setCallFrom(str);
        transmitPostEditActivityConfig.setPrivateThread(i);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, transmitPostEditActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.jvY);
    }

    private void j(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void AF(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("fid", this.mShareItem.fid).bS("tid", this.mShareItem.tid).O("obj_type", i).O("obj_source", this.mShareItem.cyM).O("obj_param1", this.mShareItem.cyN));
        }
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.cyt) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("fid", eVar.extData).O("obj_type", i));
            } else if (eVar.cyu || eVar.cyx) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).bS("tid", eVar.extData).O("obj_type", i).O("obj_source", eVar.cyM).O("obj_param1", eVar.cyN).bS("fid", eVar.fid));
            } else if (eVar.cyv) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_PHOTO_LIVE).bS("tid", eVar.extData).O("obj_type", i));
            } else if (eVar.cys) {
                aE(i, eVar.cyJ);
            } else if (eVar.cyw) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_SHARE_FORUM_OR_THREAD).O("obj_param1", 7).O("obj_type", i).bS("fid", eVar.extData));
            }
        }
    }

    private void n(e eVar) {
        an O = new an(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS).O("obj_source", 7);
        if (eVar.cyN != 0) {
            O.O("obj_param1", eVar.cyN);
            if (eVar.cyN == 2) {
                O.bS("fid", eVar.fid);
            } else if (eVar.cyN == 3) {
                if (eVar.cyR != 0) {
                    O.O("obj_type", eVar.cyR);
                }
                O.bS("tid", eVar.tid).bS("fid", eVar.fid);
            }
        }
        TiebaStatic.log(O);
    }

    private void aE(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
