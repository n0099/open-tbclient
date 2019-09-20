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
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout jwd;
    private a jwe;
    private boolean jwf = false;
    private CustomMessageListener jwg = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.transmitShare.b.1
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
    private static final int dWF = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds156);
    private static final int dTX = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds234);
    private static final int iYb = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
    private static final int iYc = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds36);
    private static final int iYd = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
    private static final int cmt = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.jwg);
    }

    public ShareGridLayout cul() {
        if (this.jwd == null) {
            initView();
        }
        return this.jwd;
    }

    private void initView() {
        this.jwd = new ShareGridLayout(this.mContext);
        this.jwd.setItemParams(dWF, dTX);
    }

    private void a(com.baidu.tbadk.core.util.f.a aVar, int i, int i2) {
        if (aVar != null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setTag(Integer.valueOf(i2));
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iYb, iYb);
            layoutParams.topMargin = iYc;
            layoutParams.bottomMargin = iYd;
            layoutParams.gravity = 1;
            linearLayout.addView(imageView, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, cmt);
            textView.setText(i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 1;
            linearLayout.addView(textView, layoutParams2);
            imageView.setImageDrawable(aVar.getDrawable());
            am.j(textView, R.color.cp_cont_f);
            linearLayout.setOnClickListener(this);
            this.jwd.addView(linearLayout, new ViewGroup.LayoutParams(dWF, dTX));
        }
    }

    public void a(ShareDialogConfig shareDialogConfig, boolean z) {
        this.mShareItem = shareDialogConfig.shareItem;
        this.mForumList = shareDialogConfig.mForumList;
        this.mPrivateThread = shareDialogConfig.mPrivateThread;
        this.jwd.removeAllViews();
        this.jwf = shareDialogConfig.mShowMoreForumShare;
        if (this.jwf) {
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg), R.string.share_weixin, 4);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg), R.string.share_weixin_timeline, 3);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg), R.string.share_qq_friends, 9);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg), R.string.share_qzone, 5);
            a(new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg), R.string.share_sina_weibo, 7);
            a(new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_moreba_n_svg), R.string.more_forums, 13);
            return;
        }
        if (this.mShareItem.clX) {
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
        this.jwe = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jwe != null) {
            this.jwe.cW(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.kc() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), (int) R.string.share_on_no_network);
            } else if (BY(num.intValue())) {
                BW(num.intValue());
            } else {
                BX(num.intValue());
            }
        }
    }

    private void BW(int i) {
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
                if (eVar.clt) {
                    eVar.content = "【" + eVar.title + "】 " + eVar.content;
                }
                fVar.f(eVar);
            }
        } else if (i == 9) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agW();
        } else if (i == 5) {
            if (w.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
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
            BdToast.b(this.mContext, this.mContext.getText(R.string.share_qq_not_install)).agW();
        } else if (i == 7) {
            k("share_to_sweibo", new Object[0]);
            a(eVar, 7);
            if (eVar != null) {
                if (!eVar.cls) {
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
            if (eVar != null && eVar.cls) {
                aD(8, eVar.clJ);
            }
        }
    }

    private void BX(int i) {
        if (i == 11) {
            a("1", (TransmitForumData) null, this.mPrivateThread);
            BZ(11);
        } else if (i == 13) {
            cum();
            BZ(13);
        }
    }

    private boolean BY(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void cum() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, 25018);
        selectForumActivityConfig.setForumList(this.mForumList);
        if (this.jwf) {
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
        MessageManager.getInstance().unRegisterListener(this.jwg);
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void BZ(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new an("c10125").bT("fid", this.mShareItem.fid).bT("tid", this.mShareItem.tid).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.clM).P("obj_param1", this.mShareItem.clN));
        }
    }

    private void a(e eVar, int i) {
        if (eVar != null && eVar.extData != null) {
            if (eVar.clt) {
                TiebaStatic.log(new an("c10125").bT("fid", eVar.extData).P("obj_type", i));
            } else if (eVar.clu || eVar.clx) {
                TiebaStatic.log(new an("c10125").bT("tid", eVar.extData).P("obj_type", i).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.clM).P("obj_param1", eVar.clN).bT("fid", eVar.fid));
            } else if (eVar.clv) {
                TiebaStatic.log(new an("c10427").bT("tid", eVar.extData).P("obj_type", i));
            } else if (eVar.cls) {
                aD(i, eVar.clJ);
            } else if (eVar.clw) {
                TiebaStatic.log(new an("c10125").P("obj_param1", 7).P("obj_type", i).bT("fid", eVar.extData));
            }
        }
    }

    private void q(e eVar) {
        an P = new an("share_success").P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (eVar.clN != 0) {
            P.P("obj_param1", eVar.clN);
            if (eVar.clN == 2) {
                P.bT("fid", eVar.fid);
            } else if (eVar.clN == 3) {
                if (eVar.clR != 0) {
                    P.P("obj_type", eVar.clR);
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
