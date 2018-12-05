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
    private LinearLayout ceD;
    private List<TransmitForumData> gFr;
    private com.baidu.tieba.r.a hyD;
    private CustomMessageListener hyE = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int H = v.H(b.this.mForumList);
                if (H > 0) {
                    b.this.gFr = b.this.mForumList.subList(0, Math.min(6, H));
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
        MessageManager.getInstance().registerListener(this.hyE);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int H = v.H(arrayList);
        if (H > 0) {
            this.gFr = arrayList.subList(0, Math.min(6, H));
        }
    }

    public void a(com.baidu.tieba.r.a aVar) {
        this.hyD = aVar;
    }

    public View getView() {
        if (this.ceD == null) {
            this.ceD = new LinearLayout(this.mContext);
            this.ceD.setOrientation(0);
            int h = l.h(this.mContext, e.C0210e.ds18);
            this.ceD.setPadding(h, l.h(this.mContext, e.C0210e.ds32), h, l.h(this.mContext, e.C0210e.ds26));
            bHk();
            bHl();
            bHm();
        }
        return this.ceD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.ceD != null) {
            this.ceD.removeAllViews();
            bHk();
            bHl();
            bHm();
        }
    }

    private void bHk() {
        a bHn = bHn();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bHn.bij.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bHn.bPh.setText(e.j.my_homepage);
        bHn.hyG.setTag(100);
        bHn.hyG.setOnClickListener(this);
        this.ceD.addView(bHn.hyG);
    }

    private void bHl() {
        int H = v.H(this.gFr);
        for (int i = 0; i < H; i++) {
            TransmitForumData transmitForumData = this.gFr.get(i);
            if (transmitForumData != null) {
                a bHn = bHn();
                bHn.bij.startLoad(transmitForumData.avatar, 10, false);
                bHn.bPh.setText(transmitForumData.forumName);
                bHn.hyG.setTag(transmitForumData);
                bHn.hyG.setOnClickListener(this);
                this.ceD.addView(bHn.hyG);
            }
        }
    }

    private void bHm() {
        a bHn = bHn();
        al.c(bHn.bij, e.f.icon_share_more_ba);
        al.j(bHn.bij, e.d.cp_bg_line_d);
        bHn.bPh.setText(e.j.more_forums);
        bHn.hyG.setTag(200);
        bHn.hyG.setOnClickListener(this);
        this.ceD.addView(bHn.hyG);
    }

    private a bHn() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.ceD, false);
        a aVar = new a();
        aVar.hyG = viewGroup;
        aVar.bij = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bPh = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bPh, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hyD != null) {
            this.hyD.bT(view);
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
                wg(11);
            } else if (num.intValue() == 200) {
                bHo();
                wg(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            wg(12);
        }
    }

    private void wg(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).aA("tid", this.mShareItem.tid).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aSl).x("obj_param1", this.mShareItem.aSm));
        }
    }

    private void bHo() {
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
        MessageManager.getInstance().unRegisterListener(this.hyE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TextView bPh;
        public TbImageView bij;
        public ViewGroup hyG;

        private a() {
        }
    }
}
