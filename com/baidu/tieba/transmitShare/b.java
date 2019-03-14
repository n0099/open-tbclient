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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.c.d;
import com.baidu.tbadk.coreExtra.c.e;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b implements View.OnClickListener {
    private ShareGridLayout iTG;
    private a iTH;
    private CustomMessageListener iTI = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.transmitShare.b.1
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
    private d mShareItem;
    private static final int dHi = l.h(TbadkCoreApplication.getInst(), d.e.tbds156);
    private static final int dED = l.h(TbadkCoreApplication.getInst(), d.e.tbds234);
    private static final int ivP = l.h(TbadkCoreApplication.getInst(), d.e.tbds104);
    private static final int ivQ = l.h(TbadkCoreApplication.getInst(), d.e.tbds36);
    private static final int ivR = l.h(TbadkCoreApplication.getInst(), d.e.tbds26);
    private static final int cbV = l.h(TbadkCoreApplication.getInst(), d.e.tbds30);

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.iTI);
    }

    public ShareGridLayout cin() {
        if (this.iTG == null) {
            initView();
        }
        return this.iTG;
    }

    private void initView() {
        this.iTG = new ShareGridLayout(this.mContext);
        this.iTG.setItemParams(dHi, dED);
    }

    private void ag(int i, int i2, int i3) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setTag(Integer.valueOf(i3));
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ivP, ivP);
        layoutParams.topMargin = ivQ;
        layoutParams.bottomMargin = ivR;
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        textView.setTextSize(0, cbV);
        textView.setText(i2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        al.c(imageView, i);
        al.j(textView, d.C0277d.cp_cont_f);
        linearLayout.setOnClickListener(this);
        this.iTG.addView(linearLayout, new ViewGroup.LayoutParams(dHi, dED));
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i, boolean z) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        this.iTG.removeAllViews();
        if (this.mShareItem.cbL) {
            ag(d.f.icon_share_wechat_n, d.j.share_weixin, 4);
            ag(d.f.icon_share_circle_n, d.j.share_weixin_timeline, 3);
            ag(d.f.icon_share_qq_n, d.j.share_qq_friends, 9);
            ag(d.f.icon_share_qqzone_n, d.j.share_qzone, 5);
            ag(d.f.icon_share_weibo_n, d.j.share_sina_weibo, 7);
            ag(d.f.icon_share_copy_n, d.j.share_copy, 10);
        }
        if (z) {
            ag(d.f.icon_share_homepage_n, d.j.my_homepage, 11);
            ag(d.f.icon_share_moreba_n, d.j.more_forums, 13);
        }
    }

    public void a(a aVar) {
        this.iTH = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iTH != null) {
            this.iTH.cJ(view);
        }
        if (view.getTag() instanceof Integer) {
            Integer num = (Integer) view.getTag();
            if (!j.kY() && num.intValue() != 10) {
                l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
            } else if (Ah(num.intValue())) {
                Af(num.intValue());
            } else {
                Ag(num.intValue());
            }
        }
    }

    private void Af(int i) {
        e eVar = new e(this.mContext, null);
        com.baidu.tbadk.coreExtra.c.d dVar = this.mShareItem;
        if (i == 4) {
            k("share_to_weixin", new Object[0]);
            a(dVar, 4);
            if (dVar != null) {
                eVar.b(dVar);
            }
        } else if (i == 3) {
            k("share_to_pyq", new Object[0]);
            a(dVar, 3);
            if (dVar != null) {
                if (dVar.cbi) {
                    dVar.content = "【" + dVar.title + "】 " + dVar.content;
                }
                eVar.c(dVar);
            }
        } else if (i == 9) {
            if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                k("share_to_qq_friend", new Object[0]);
                a(dVar, 9);
                if (dVar != null) {
                    eVar.d(dVar);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
        } else if (i == 5) {
            if (u.isInstalledPackage(this.mContext, "com.tencent.mobileqq")) {
                k("share_to_qzone", new Object[0]);
                a(dVar, 5);
                if (dVar != null) {
                    eVar.e(dVar);
                    return;
                }
                return;
            }
            BdToast.b(this.mContext, this.mContext.getText(d.j.share_qq_not_install)).abh();
        } else if (i == 7) {
            k("share_to_sweibo", new Object[0]);
            a(dVar, 7);
            if (dVar != null) {
                if (!dVar.cbh) {
                    dVar.content = "【" + dVar.title + "】 " + dVar.content;
                }
                eVar.g(dVar);
            }
        } else if (i == 10) {
            a(dVar, 10);
            dVar.linkUrl = e.bQ(dVar.linkUrl, dVar.tid);
            com.baidu.adp.lib.util.a.bh(dVar.linkUrl);
            l.showToast(this.mContext.getApplicationContext(), this.mContext.getResources().getString(d.j.copy_pb_url_success));
            n(dVar);
            if (dVar != null && dVar.cbh) {
                ay(8, dVar.cbx);
            }
        }
    }

    private void Ag(int i) {
        if (i == 11) {
            a("1", null, this.mPrivateThread);
            Ai(11);
        } else if (i == 13) {
            cio();
            Ai(13);
        }
    }

    private boolean Ah(int i) {
        return i == 4 || i == 3 || i == 9 || i == 5 || i == 7 || i == 10;
    }

    private void cio() {
        SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.mContext, 25018);
        selectForumActivityConfig.setForumList(this.mForumList);
        selectForumActivityConfig.setFrom(2);
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
        MessageManager.getInstance().unRegisterListener(this.iTI);
    }

    private void k(String str, Object... objArr) {
        TiebaStatic.eventStat(this.mContext, str, "click", 1, objArr);
    }

    private void Ai(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).bJ("tid", this.mShareItem.tid).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.cbA).T("obj_param1", this.mShareItem.cbB));
        }
    }

    private void a(com.baidu.tbadk.coreExtra.c.d dVar, int i) {
        if (dVar != null && dVar.extData != null) {
            if (dVar.cbi) {
                TiebaStatic.log(new am("c10125").bJ(ImageViewerConfig.FORUM_ID, dVar.extData).T("obj_type", i));
            } else if (dVar.cbj || dVar.cbm) {
                TiebaStatic.log(new am("c10125").bJ("tid", dVar.extData).T("obj_type", i).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.cbA).T("obj_param1", dVar.cbB).bJ(ImageViewerConfig.FORUM_ID, dVar.fid));
            } else if (dVar.cbk) {
                TiebaStatic.log(new am("c10427").bJ("tid", dVar.extData).T("obj_type", i));
            } else if (dVar.cbh) {
                ay(i, dVar.cbx);
            } else if (dVar.cbl) {
                TiebaStatic.log(new am("c10125").T("obj_param1", 7).T("obj_type", i).bJ(ImageViewerConfig.FORUM_ID, dVar.extData));
            }
        }
    }

    private void n(com.baidu.tbadk.coreExtra.c.d dVar) {
        am T = new am("share_success").T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 7);
        if (dVar.cbB != 0) {
            T.T("obj_param1", dVar.cbB);
            if (dVar.cbB == 2) {
                T.bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            } else if (dVar.cbB == 3) {
                if (dVar.cbF != 0) {
                    T.T("obj_type", dVar.cbF);
                }
                T.bJ("tid", dVar.tid).bJ(ImageViewerConfig.FORUM_ID, dVar.fid);
            }
        }
        TiebaStatic.log(T);
    }

    private void ay(int i, String str) {
        TiebaStatic.eventStat(this.mContext, "pb_new_share", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
    }
}
