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
    private LinearLayout cfw;
    private List<TransmitForumData> gJn;
    private com.baidu.tieba.s.a hCX;
    private CustomMessageListener hCY = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.s.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int H = v.H(b.this.mForumList);
                if (H > 0) {
                    b.this.gJn = b.this.mForumList.subList(0, Math.min(6, H));
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
        MessageManager.getInstance().registerListener(this.hCY);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int H = v.H(arrayList);
        if (H > 0) {
            this.gJn = arrayList.subList(0, Math.min(6, H));
        }
    }

    public void a(com.baidu.tieba.s.a aVar) {
        this.hCX = aVar;
    }

    public View getView() {
        if (this.cfw == null) {
            this.cfw = new LinearLayout(this.mContext);
            this.cfw.setOrientation(0);
            int h = l.h(this.mContext, e.C0210e.ds18);
            this.cfw.setPadding(h, l.h(this.mContext, e.C0210e.ds32), h, l.h(this.mContext, e.C0210e.ds26));
            bII();
            bIJ();
            bIK();
        }
        return this.cfw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.cfw != null) {
            this.cfw.removeAllViews();
            bII();
            bIJ();
            bIK();
        }
    }

    private void bII() {
        a bIL = bIL();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bIL.biW.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bIL.bPW.setText(e.j.my_homepage);
        bIL.hDa.setTag(100);
        bIL.hDa.setOnClickListener(this);
        this.cfw.addView(bIL.hDa);
    }

    private void bIJ() {
        int H = v.H(this.gJn);
        for (int i = 0; i < H; i++) {
            TransmitForumData transmitForumData = this.gJn.get(i);
            if (transmitForumData != null) {
                a bIL = bIL();
                bIL.biW.startLoad(transmitForumData.avatar, 10, false);
                bIL.bPW.setText(transmitForumData.forumName);
                bIL.hDa.setTag(transmitForumData);
                bIL.hDa.setOnClickListener(this);
                this.cfw.addView(bIL.hDa);
            }
        }
    }

    private void bIK() {
        a bIL = bIL();
        al.c(bIL.biW, e.f.icon_share_more_ba);
        al.j(bIL.biW, e.d.cp_bg_line_d);
        bIL.bPW.setText(e.j.more_forums);
        bIL.hDa.setTag(200);
        bIL.hDa.setOnClickListener(this);
        this.cfw.addView(bIL.hDa);
    }

    private a bIL() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.cfw, false);
        a aVar = new a();
        aVar.hDa = viewGroup;
        aVar.biW = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bPW = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bPW, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCX != null) {
            this.hCX.bW(view);
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
                ww(11);
            } else if (num.intValue() == 200) {
                bIM();
                ww(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            ww(12);
        }
    }

    private void ww(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").aB(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).aB("tid", this.mShareItem.tid).y("obj_type", i).y(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aST).y("obj_param1", this.mShareItem.aSU));
        }
    }

    private void bIM() {
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
        MessageManager.getInstance().unRegisterListener(this.hCY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TextView bPW;
        public TbImageView biW;
        public ViewGroup hDa;

        private a() {
        }
    }
}
