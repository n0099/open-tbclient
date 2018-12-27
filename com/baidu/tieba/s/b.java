package com.baidu.tieba.s;

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
    private LinearLayout ceK;
    private List<TransmitForumData> gIi;
    private com.baidu.tieba.s.a hBP;
    private CustomMessageListener hBQ = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.s.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int H = v.H(b.this.mForumList);
                if (H > 0) {
                    b.this.gIi = b.this.mForumList.subList(0, Math.min(6, H));
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
        MessageManager.getInstance().registerListener(this.hBQ);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int H = v.H(arrayList);
        if (H > 0) {
            this.gIi = arrayList.subList(0, Math.min(6, H));
        }
    }

    public void a(com.baidu.tieba.s.a aVar) {
        this.hBP = aVar;
    }

    public View getView() {
        if (this.ceK == null) {
            this.ceK = new LinearLayout(this.mContext);
            this.ceK.setOrientation(0);
            int h = l.h(this.mContext, e.C0210e.ds18);
            this.ceK.setPadding(h, l.h(this.mContext, e.C0210e.ds32), h, l.h(this.mContext, e.C0210e.ds26));
            bHZ();
            bIa();
            bIb();
        }
        return this.ceK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.ceK != null) {
            this.ceK.removeAllViews();
            bHZ();
            bIa();
            bIb();
        }
    }

    private void bHZ() {
        a bIc = bIc();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bIc.bim.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bIc.bPk.setText(e.j.my_homepage);
        bIc.hBS.setTag(100);
        bIc.hBS.setOnClickListener(this);
        this.ceK.addView(bIc.hBS);
    }

    private void bIa() {
        int H = v.H(this.gIi);
        for (int i = 0; i < H; i++) {
            TransmitForumData transmitForumData = this.gIi.get(i);
            if (transmitForumData != null) {
                a bIc = bIc();
                bIc.bim.startLoad(transmitForumData.avatar, 10, false);
                bIc.bPk.setText(transmitForumData.forumName);
                bIc.hBS.setTag(transmitForumData);
                bIc.hBS.setOnClickListener(this);
                this.ceK.addView(bIc.hBS);
            }
        }
    }

    private void bIb() {
        a bIc = bIc();
        al.c(bIc.bim, e.f.icon_share_more_ba);
        al.j(bIc.bim, e.d.cp_bg_line_d);
        bIc.bPk.setText(e.j.more_forums);
        bIc.hBS.setTag(200);
        bIc.hBS.setOnClickListener(this);
        this.ceK.addView(bIc.hBS);
    }

    private a bIc() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.ceK, false);
        a aVar = new a();
        aVar.hBS = viewGroup;
        aVar.bim = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bPk = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bPk, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hBP != null) {
            this.hBP.bW(view);
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
                wt(11);
            } else if (num.intValue() == 200) {
                bId();
                wt(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            wt(12);
        }
    }

    private void wt(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").aA(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).aA("tid", this.mShareItem.tid).x("obj_type", i).x(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aSn).x("obj_param1", this.mShareItem.aSo));
        }
    }

    private void bId() {
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
        MessageManager.getInstance().unRegisterListener(this.hBQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TextView bPk;
        public TbImageView bim;
        public ViewGroup hBS;

        private a() {
        }
    }
}
