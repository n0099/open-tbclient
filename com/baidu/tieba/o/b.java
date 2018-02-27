package com.baidu.tieba.o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private com.baidu.tieba.o.a gTq;
    private List<TransmitForumData> gwo;
    private LinearLayout hmS;
    private CustomMessageListener hmT = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.o.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int D = v.D(b.this.mForumList);
                if (D > 0) {
                    b.this.gwo = b.this.mForumList.subList(0, Math.min(6, D));
                }
                b.this.cq();
            }
        }
    };
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.hmT);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int D = v.D(arrayList);
        if (D > 0) {
            this.gwo = arrayList.subList(0, Math.min(6, D));
        }
    }

    public void setShareItemClickListener(com.baidu.tieba.o.a aVar) {
        this.gTq = aVar;
    }

    public View getView() {
        if (this.hmS == null) {
            this.hmS = new LinearLayout(this.mContext);
            this.hmS.setOrientation(0);
            int t = l.t(this.mContext, d.e.ds18);
            this.hmS.setPadding(t, l.t(this.mContext, d.e.ds32), t, l.t(this.mContext, d.e.ds26));
            bAo();
            bAp();
            bAq();
        }
        return this.hmS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cq() {
        if (this.hmS != null) {
            this.hmS.removeAllViews();
            bAo();
            bAp();
            bAq();
        }
    }

    private void bAo() {
        a bAr = bAr();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bAr.bCF.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bAr.bMS.setText(d.j.my_homepage);
        bAr.hmV.setTag(100);
        bAr.hmV.setOnClickListener(this);
        this.hmS.addView(bAr.hmV);
    }

    private void bAp() {
        int D = v.D(this.gwo);
        for (int i = 0; i < D; i++) {
            TransmitForumData transmitForumData = this.gwo.get(i);
            if (transmitForumData != null) {
                a bAr = bAr();
                bAr.bCF.startLoad(transmitForumData.avatar, 10, false);
                bAr.bMS.setText(transmitForumData.forumName);
                bAr.hmV.setTag(transmitForumData);
                bAr.hmV.setOnClickListener(this);
                this.hmS.addView(bAr.hmV);
            }
        }
    }

    private void bAq() {
        a bAr = bAr();
        aj.c(bAr.bCF, d.f.icon_share_more_ba);
        aj.t(bAr.bCF, d.C0141d.cp_bg_line_d);
        bAr.bMS.setText(d.j.more_forums);
        bAr.hmV.setTag(200);
        bAr.hmV.setOnClickListener(this);
        this.hmS.addView(bAr.hmV);
    }

    private a bAr() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.share_dialog_forum_item, (ViewGroup) this.hmS, false);
        a aVar = new a();
        aVar.hmV = viewGroup;
        aVar.bCF = (TbImageView) viewGroup.findViewById(d.g.photo);
        aVar.bMS = (TextView) viewGroup.findViewById(d.g.name);
        aj.r(aVar.bMS, d.C0141d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gTq != null) {
            this.gTq.cN(view);
        }
        if (!j.oJ()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.j.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                wA(11);
            } else if (num.intValue() == 200) {
                bAs();
                wA(13);
            }
        }
        if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            wA(12);
        }
    }

    private void wA(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new ak("c10125").ab(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ab("tid", this.mShareItem.tid).s("obj_type", i).s(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.blt).s("obj_param1", this.mShareItem.blu));
        }
    }

    private void bAs() {
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
        MessageManager.getInstance().unRegisterListener(this.hmT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView bCF;
        public TextView bMS;
        public ViewGroup hmV;

        private a() {
        }
    }
}
