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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout jsB;
    private a jsC;
    private boolean jsD = false;
    private CustomMessageListener jsE = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.transmitShare.b.1
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
    private static final int dUN = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dSf = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iUC = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iUD = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iUE = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int clq = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.jsE);
    }

    public ShareGridLayout ctb() {
        if (this.jsB == null) {
            initView();
        }
        return this.jsB;
    }

    private void initView() {
        this.jsB = new ShareGridLayout(this.mContext);
        this.jsB.setItemParams(dUN, dSf);
    }

    private void ai(int i, int i2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iUC, iUC);
        layoutParams.topMargin = iUD;
        layoutParams.bottomMargin = iUE;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, clq);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        am.c(imageView, i);
        am.j(textView, R.color.cp_cont_f);
        linearLayout.setOnClickListener(this);
        this.jsB.addView(linearLayout, new ViewGroup.LayoutParams(dUN, dSf));
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.jsB.removeAllViews();
        this.jsD = shareDialogConfig.mShowMoreForumShare;
        if (this.jsD) {
            ai(R.drawable.icon_share_wechat_n, R.string.share_weixin, 4);
            ai(R.drawable.icon_share_circle_n, R.string.share_weixin_timeline, 3);
            ai(R.drawable.icon_share_qq_n, R.string.share_qq_friends, 9);
            ai(R.drawable.icon_share_qqzone_n, R.string.share_qzone, 5);
            ai(R.drawable.icon_share_weibo_n, R.string.share_sina_weibo, 7);
            ai(R.drawable.icon_share_moreba_n, R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.ckV) {
            ai(R.drawable.icon_share_wechat_n, R.string.share_weixin, 4);
            ai(R.drawable.icon_share_circle_n, R.string.share_weixin_timeline, 3);
            ai(R.drawable.icon_share_qq_n, R.string.share_qq_friends, 9);
            ai(R.drawable.icon_share_qqzone_n, R.string.share_qzone, 5);
            ai(R.drawable.icon_share_weibo_n, R.string.share_sina_weibo, 7);
            ai(R.drawable.icon_share_copy_n, R.string.share_copy, 10);
        }
        if (z) {
            ai(R.drawable.icon_share_homepage_n, R.string.my_homepage, 11);
            ai(R.drawable.icon_share_moreba_n, R.string.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.jsC = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jsC != null) {
            this.jsC.cU(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.kc() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (BS(num.intValue())) {
                BQ(num.intValue());
            } else {
                BR(num.intValue());
            }
        }
    }

    private void BQ(int i) {
        f fVar = new f(this.mContext, null);
        e eVar = this.mShareItem;
        if (i == 4) {
            k("share_to_weixin", new Object[0]);
            a(eVar, 4);
            if (eVar != null) {
                fVar.e(eVar);
            }
        } else if (i == 3) {
            k("share_to_pyq", new Object[0]);
            a(eVar, 3);
            if (eVar != null) {
                if (eVar.ckr) {
                    eVar.content = "【" + eVar.title + "】 " + eVar.content;
                }
                fVar.f(eVar);
            }
        } else if (i == 9) {
            if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                k("share_to_qq_friend", new Object[0]);
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agQ();
        } else if (i == 5) {
            if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                k("share_to_qzone", new Object[0]);
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agQ();
        } else if (i == 7) {
            k("share_to_sweibo", new Object[0]);
            a(eVar, 7);
            if (eVar != null) {
                if (!eVar.ckq) {
                    if (!StringUtils.isNull(eVar.title) && !StringUtils.isNull(eVar.content) && eVar.title.trim().equals(eVar.content.trim())) {
                        eVar.content = "";
                    }
                    eVar.content = "【" + eVar.title + "】 " + eVar.content;
                }
                fVar.j(eVar);
            }
        } else if (i == 10) {
            a(eVar, 10);
            eVar.linkUrl = f.cb(eVar.linkUrl, eVar.tid);
            com.baidu.adp.lib.util.a.aS(eVar.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(R.string.copy_pb_url_success));
            q(eVar);
            if (eVar != null && eVar.ckq) {
                aD(8, eVar.ckH);
            }
        }
    }

    private void BR(int i) {
        if (i == 11) {
            a("1", null, this.mPrivateThread);
            BT(11);
        } else if (i == 13) {
            ctc();
            BT(13);
        }
    }

    private boolean BS(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void ctc() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, 25018);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.jsD) {
            selectForumActivityConfig.setFrom(4);
            selectForumActivityConfig.setMoreForumImg(this.mShareItem.imageUrl);
            selectForumActivityConfig.setMoreForumUrl(this.mShareItem.linkUrl);
            selectForumActivityConfig.setMoreForumTitle(this.mShareItem.title);
        } else {
            selectForumActivityConfig.setFrom(2);
        }
        selectForumActivityConfig.setOriginalThread(this.mShareItem.originalThreadInfo);
        selectForumActivityConfig.setPrivateThread(this.mPrivateThread);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, selectForumActivityConfig));
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
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.mContext, 9, str3, str2, null, null, 13011, null, null, null, this.mShareItem.originalThreadInfo);
        transmitPostEditActivityConfig.setCallFrom(str);
        transmitPostEditActivityConfig.setPrivateThread(i);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
    }

    public void release() {
        MessageManager.getInstance().unRegisterListener(this.jsE);
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void BT(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new an("c10125").bT("fid", this.mShareItem.fid).bT("tid", this.mShareItem.tid).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.ckK).P("obj_param1", this.mShareItem.ckL));
        }
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.ckr) {
                TiebaStatic.log(new an("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.cks || eVar.ckv) {
                TiebaStatic.log(new an("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.ckK).P("obj_param1", eVar.ckL).bT("fid", eVar.fid));
            } else if (eVar.ckt) {
                TiebaStatic.log(new an("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.ckq) {
                aD(i, eVar.ckH);
            } else if (eVar.cku) {
                TiebaStatic.log(new an("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            }
        }
    }

    private void q(e eVar) {
        an P = new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.ckL != 0) {
            P.P("obj_param1", eVar.ckL);
            if (eVar.ckL == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.ckL == 3) {
                if (eVar.ckP != 0) {
                    P.P("obj_type", eVar.ckP);
                }
                P.bT("tid", eVar.tid).bT("fid", eVar.fid);
            }
        }
        TiebaStatic.log(P);
    }

    private void aD(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
