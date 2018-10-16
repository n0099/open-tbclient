package com.baidu.tieba.r;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private List<TransmitForumData> gwZ;
    private LinearLayout hpG;
    private com.baidu.tieba.r.a hpH;
    private CustomMessageListener hpI = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int I = v.I(b.this.mForumList);
                if (I > 0) {
                    b.this.gwZ = b.this.mForumList.subList(0, Math.min(6, I));
                }
                b.this.updateView();
            }
        }
    };
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.hpI);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int I = v.I(arrayList);
        if (I > 0) {
            this.gwZ = arrayList.subList(0, Math.min(6, I));
        }
    }

    public void a(com.baidu.tieba.r.a aVar) {
        this.hpH = aVar;
    }

    public View getView() {
        if (this.hpG == null) {
            this.hpG = new LinearLayout(this.mContext);
            this.hpG.setOrientation(0);
            int h = l.h(this.mContext, e.C0175e.ds18);
            this.hpG.setPadding(h, l.h(this.mContext, e.C0175e.ds32), h, l.h(this.mContext, e.C0175e.ds26));
            bFH();
            bFI();
            bFJ();
        }
        return this.hpG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.hpG != null) {
            this.hpG.removeAllViews();
            bFH();
            bFI();
            bFJ();
        }
    }

    private void bFH() {
        a bFK = bFK();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bFK.bdT.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bFK.bKH.setText(e.j.my_homepage);
        bFK.hpK.setTag(100);
        bFK.hpK.setOnClickListener(this);
        this.hpG.addView(bFK.hpK);
    }

    private void bFI() {
        int I = v.I(this.gwZ);
        for (int i = 0; i < I; i++) {
            TransmitForumData transmitForumData = this.gwZ.get(i);
            if (transmitForumData != null) {
                a bFK = bFK();
                bFK.bdT.startLoad(transmitForumData.avatar, 10, false);
                bFK.bKH.setText(transmitForumData.forumName);
                bFK.hpK.setTag(transmitForumData);
                bFK.hpK.setOnClickListener(this);
                this.hpG.addView(bFK.hpK);
            }
        }
    }

    private void bFJ() {
        a bFK = bFK();
        al.c(bFK.bdT, e.f.icon_share_more_ba);
        al.j(bFK.bdT, e.d.cp_bg_line_d);
        bFK.bKH.setText(e.j.more_forums);
        bFK.hpK.setTag(200);
        bFK.hpK.setOnClickListener(this);
        this.hpG.addView(bFK.hpK);
    }

    private a bFK() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.hpG, false);
        a aVar = new a();
        aVar.hpK = viewGroup;
        aVar.bdT = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bKH = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bKH, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hpH != null) {
            this.hpH.bR(view);
        }
        if (!j.kX()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                vq(11);
            } else if (num.intValue() == 200) {
                bFL();
                vq(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            vq(12);
        }
    }

    private void vq(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").ax(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ax("tid", this.mShareItem.tid).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aNW).x("obj_param1", this.mShareItem.aNX));
        }
    }

    private void bFL() {
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
        MessageManager.getInstance().unRegisterListener(this.hpI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TextView bKH;
        public TbImageView bdT;
        public ViewGroup hpK;

        private a() {
        }
    }
}
