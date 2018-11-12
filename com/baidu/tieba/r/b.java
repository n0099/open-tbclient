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
    private LinearLayout caJ;
    private List<TransmitForumData> gyB;
    private com.baidu.tieba.r.a hrr;
    private CustomMessageListener hrs = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int H = v.H(b.this.mForumList);
                if (H > 0) {
                    b.this.gyB = b.this.mForumList.subList(0, Math.min(6, H));
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
        MessageManager.getInstance().registerListener(this.hrs);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int H = v.H(arrayList);
        if (H > 0) {
            this.gyB = arrayList.subList(0, Math.min(6, H));
        }
    }

    public void a(com.baidu.tieba.r.a aVar) {
        this.hrr = aVar;
    }

    public View getView() {
        if (this.caJ == null) {
            this.caJ = new LinearLayout(this.mContext);
            this.caJ.setOrientation(0);
            int h = l.h(this.mContext, e.C0200e.ds18);
            this.caJ.setPadding(h, l.h(this.mContext, e.C0200e.ds32), h, l.h(this.mContext, e.C0200e.ds26));
            bFg();
            bFh();
            bFi();
        }
        return this.caJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.caJ != null) {
            this.caJ.removeAllViews();
            bFg();
            bFh();
            bFi();
        }
    }

    private void bFg() {
        a bFj = bFj();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bFj.beI.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bFj.bLs.setText(e.j.my_homepage);
        bFj.hru.setTag(100);
        bFj.hru.setOnClickListener(this);
        this.caJ.addView(bFj.hru);
    }

    private void bFh() {
        int H = v.H(this.gyB);
        for (int i = 0; i < H; i++) {
            TransmitForumData transmitForumData = this.gyB.get(i);
            if (transmitForumData != null) {
                a bFj = bFj();
                bFj.beI.startLoad(transmitForumData.avatar, 10, false);
                bFj.bLs.setText(transmitForumData.forumName);
                bFj.hru.setTag(transmitForumData);
                bFj.hru.setOnClickListener(this);
                this.caJ.addView(bFj.hru);
            }
        }
    }

    private void bFi() {
        a bFj = bFj();
        al.c(bFj.beI, e.f.icon_share_more_ba);
        al.j(bFj.beI, e.d.cp_bg_line_d);
        bFj.bLs.setText(e.j.more_forums);
        bFj.hru.setTag(200);
        bFj.hru.setOnClickListener(this);
        this.caJ.addView(bFj.hru);
    }

    private a bFj() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.caJ, false);
        a aVar = new a();
        aVar.hru = viewGroup;
        aVar.beI = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bLs = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bLs, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hrr != null) {
            this.hrr.bT(view);
        }
        if (!j.kV()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                vJ(11);
            } else if (num.intValue() == 200) {
                bFk();
                vJ(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            vJ(12);
        }
    }

    private void vJ(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").ax(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ax("tid", this.mShareItem.tid).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aOM).x("obj_param1", this.mShareItem.aON));
        }
    }

    private void bFk() {
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
        MessageManager.getInstance().unRegisterListener(this.hrs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TextView bLs;
        public TbImageView beI;
        public ViewGroup hru;

        private a() {
        }
    }
}
