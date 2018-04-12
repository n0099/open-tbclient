package com.baidu.tieba.p;

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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private List<TransmitForumData> fRq;
    private LinearLayout gIQ;
    private CustomMessageListener gIR = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.p.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int v = v.v(b.this.mForumList);
                if (v > 0) {
                    b.this.fRq = b.this.mForumList.subList(0, Math.min(6, v));
                }
                b.this.updateView();
            }
        }
    };
    private com.baidu.tieba.p.a goN;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gIR);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int v = v.v(arrayList);
        if (v > 0) {
            this.fRq = arrayList.subList(0, Math.min(6, v));
        }
    }

    public void setShareItemClickListener(com.baidu.tieba.p.a aVar) {
        this.goN = aVar;
    }

    public View getView() {
        if (this.gIQ == null) {
            this.gIQ = new LinearLayout(this.mContext);
            this.gIQ.setOrientation(0);
            int e = l.e(this.mContext, d.e.ds18);
            this.gIQ.setPadding(e, l.e(this.mContext, d.e.ds32), e, l.e(this.mContext, d.e.ds26));
            bvv();
            bvw();
            bvx();
        }
        return this.gIQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.gIQ != null) {
            this.gIQ.removeAllViews();
            bvv();
            bvw();
            bvx();
        }
    }

    private void bvv() {
        a bvy = bvy();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bvy.aNi.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bvy.blN.setText(d.k.my_homepage);
        bvy.gIT.setTag(100);
        bvy.gIT.setOnClickListener(this);
        this.gIQ.addView(bvy.gIT);
    }

    private void bvw() {
        int v = v.v(this.fRq);
        for (int i = 0; i < v; i++) {
            TransmitForumData transmitForumData = this.fRq.get(i);
            if (transmitForumData != null) {
                a bvy = bvy();
                bvy.aNi.startLoad(transmitForumData.avatar, 10, false);
                bvy.blN.setText(transmitForumData.forumName);
                bvy.gIT.setTag(transmitForumData);
                bvy.gIT.setOnClickListener(this);
                this.gIQ.addView(bvy.gIT);
            }
        }
    }

    private void bvx() {
        a bvy = bvy();
        ak.c(bvy.aNi, d.f.icon_share_more_ba);
        ak.j(bvy.aNi, d.C0126d.cp_bg_line_d);
        bvy.blN.setText(d.k.more_forums);
        bvy.gIT.setTag(200);
        bvy.gIT.setOnClickListener(this);
        this.gIQ.addView(bvy.gIT);
    }

    private a bvy() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.share_dialog_forum_item, (ViewGroup) this.gIQ, false);
        a aVar = new a();
        aVar.gIT = viewGroup;
        aVar.aNi = (TbImageView) viewGroup.findViewById(d.g.photo);
        aVar.blN = (TextView) viewGroup.findViewById(d.g.name);
        ak.h(aVar.blN, d.C0126d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.goN != null) {
            this.goN.bt(view2);
        }
        if (!j.gP()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
            return;
        }
        Object tag = view2.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                ud(11);
            } else if (num.intValue() == 200) {
                bvz();
                ud(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            ud(12);
        }
    }

    private void ud(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new al("c10125").ac(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ac("tid", this.mShareItem.tid).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.axa).r("obj_param1", this.mShareItem.axb));
        }
    }

    private void bvz() {
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
        MessageManager.getInstance().unRegisterListener(this.gIR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aNi;
        public TextView blN;
        public ViewGroup gIT;

        private a() {
        }
    }
}
