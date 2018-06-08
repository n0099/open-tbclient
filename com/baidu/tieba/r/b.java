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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener {
    private com.baidu.tieba.r.a gBn;
    private LinearLayout gVs;
    private CustomMessageListener gVt = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int y = w.y(b.this.mForumList);
                if (y > 0) {
                    b.this.gdF = b.this.mForumList.subList(0, Math.min(6, y));
                }
                b.this.updateView();
            }
        }
    };
    private List<TransmitForumData> gdF;
    private Context mContext;
    private ArrayList<TransmitForumData> mForumList;
    private int mPrivateThread;
    private com.baidu.tbadk.coreExtra.c.d mShareItem;

    public b(Context context) {
        this.mContext = context;
        MessageManager.getInstance().registerListener(this.gVt);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int y = w.y(arrayList);
        if (y > 0) {
            this.gdF = arrayList.subList(0, Math.min(6, y));
        }
    }

    public void setShareItemClickListener(com.baidu.tieba.r.a aVar) {
        this.gBn = aVar;
    }

    public View getView() {
        if (this.gVs == null) {
            this.gVs = new LinearLayout(this.mContext);
            this.gVs.setOrientation(0);
            int e = l.e(this.mContext, d.e.ds18);
            this.gVs.setPadding(e, l.e(this.mContext, d.e.ds32), e, l.e(this.mContext, d.e.ds26));
            bAA();
            bAB();
            bAC();
        }
        return this.gVs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.gVs != null) {
            this.gVs.removeAllViews();
            bAA();
            bAB();
            bAC();
        }
    }

    private void bAA() {
        a bAD = bAD();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bAD.aVh.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bAD.bui.setText(d.k.my_homepage);
        bAD.gVv.setTag(100);
        bAD.gVv.setOnClickListener(this);
        this.gVs.addView(bAD.gVv);
    }

    private void bAB() {
        int y = w.y(this.gdF);
        for (int i = 0; i < y; i++) {
            TransmitForumData transmitForumData = this.gdF.get(i);
            if (transmitForumData != null) {
                a bAD = bAD();
                bAD.aVh.startLoad(transmitForumData.avatar, 10, false);
                bAD.bui.setText(transmitForumData.forumName);
                bAD.gVv.setTag(transmitForumData);
                bAD.gVv.setOnClickListener(this);
                this.gVs.addView(bAD.gVv);
            }
        }
    }

    private void bAC() {
        a bAD = bAD();
        al.c(bAD.aVh, d.f.icon_share_more_ba);
        al.j(bAD.aVh, d.C0141d.cp_bg_line_d);
        bAD.bui.setText(d.k.more_forums);
        bAD.gVv.setTag(200);
        bAD.gVv.setOnClickListener(this);
        this.gVs.addView(bAD.gVv);
    }

    private a bAD() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.share_dialog_forum_item, (ViewGroup) this.gVs, false);
        a aVar = new a();
        aVar.gVv = viewGroup;
        aVar.aVh = (TbImageView) viewGroup.findViewById(d.g.photo);
        aVar.bui = (TextView) viewGroup.findViewById(d.g.name);
        al.h(aVar.bui, d.C0141d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBn != null) {
            this.gBn.bw(view);
        }
        if (!j.jD()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), d.k.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                un(11);
            } else if (num.intValue() == 200) {
                bAE();
                un(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            un(12);
        }
    }

    private void un(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").ah(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).ah("tid", this.mShareItem.tid).r("obj_type", i).r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aFo).r("obj_param1", this.mShareItem.aFp));
        }
    }

    private void bAE() {
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
        MessageManager.getInstance().unRegisterListener(this.gVt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aVh;
        public TextView bui;
        public ViewGroup gVv;

        private a() {
        }
    }
}
