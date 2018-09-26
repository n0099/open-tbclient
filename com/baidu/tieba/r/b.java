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
    private List<TransmitForumData> gpy;
    private LinearLayout hiq;
    private com.baidu.tieba.r.a hir;
    private CustomMessageListener his = new CustomMessageListener(2016563) { // from class: com.baidu.tieba.r.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ArrayList)) {
                b.this.mForumList = (ArrayList) customResponsedMessage.getData();
                int y = v.y(b.this.mForumList);
                if (y > 0) {
                    b.this.gpy = b.this.mForumList.subList(0, Math.min(6, y));
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
        MessageManager.getInstance().registerListener(this.his);
    }

    public void a(com.baidu.tbadk.coreExtra.c.d dVar, ArrayList<TransmitForumData> arrayList, int i) {
        this.mShareItem = dVar;
        this.mForumList = arrayList;
        this.mPrivateThread = i;
        int y = v.y(arrayList);
        if (y > 0) {
            this.gpy = arrayList.subList(0, Math.min(6, y));
        }
    }

    public void a(com.baidu.tieba.r.a aVar) {
        this.hir = aVar;
    }

    public View getView() {
        if (this.hiq == null) {
            this.hiq = new LinearLayout(this.mContext);
            this.hiq.setOrientation(0);
            int h = l.h(this.mContext, e.C0141e.ds18);
            this.hiq.setPadding(h, l.h(this.mContext, e.C0141e.ds32), h, l.h(this.mContext, e.C0141e.ds26));
            bCt();
            bCu();
            bCv();
        }
        return this.hiq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateView() {
        if (this.hiq != null) {
            this.hiq.removeAllViews();
            bCt();
            bCu();
            bCv();
        }
    }

    private void bCt() {
        a bCw = bCw();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        bCw.aZt.startLoad(currentAccountInfo != null ? currentAccountInfo.getPortrait() : null, 12, false);
        bCw.bCa.setText(e.j.my_homepage);
        bCw.hiu.setTag(100);
        bCw.hiu.setOnClickListener(this);
        this.hiq.addView(bCw.hiu);
    }

    private void bCu() {
        int y = v.y(this.gpy);
        for (int i = 0; i < y; i++) {
            TransmitForumData transmitForumData = this.gpy.get(i);
            if (transmitForumData != null) {
                a bCw = bCw();
                bCw.aZt.startLoad(transmitForumData.avatar, 10, false);
                bCw.bCa.setText(transmitForumData.forumName);
                bCw.hiu.setTag(transmitForumData);
                bCw.hiu.setOnClickListener(this);
                this.hiq.addView(bCw.hiu);
            }
        }
    }

    private void bCv() {
        a bCw = bCw();
        al.c(bCw.aZt, e.f.icon_share_more_ba);
        al.j(bCw.aZt, e.d.cp_bg_line_d);
        bCw.bCa.setText(e.j.more_forums);
        bCw.hiu.setTag(200);
        bCw.hiu.setOnClickListener(this);
        this.hiq.addView(bCw.hiu);
    }

    private a bCw() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.share_dialog_forum_item, (ViewGroup) this.hiq, false);
        a aVar = new a();
        aVar.hiu = viewGroup;
        aVar.aZt = (TbImageView) viewGroup.findViewById(e.g.photo);
        aVar.bCa = (TextView) viewGroup.findViewById(e.g.name);
        al.h(aVar.bCa, e.d.cp_cont_f);
        return aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hir != null) {
            this.hir.bR(view);
        }
        if (!j.kK()) {
            l.showToast(TbadkCoreApplication.getInst().getContext(), e.j.share_on_no_network);
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof Integer) {
            Integer num = (Integer) tag;
            if (num.intValue() == 100) {
                a("1", (TransmitForumData) null, this.mPrivateThread);
                uT(11);
            } else if (num.intValue() == 200) {
                bCx();
                uT(13);
            }
        } else if (tag instanceof TransmitForumData) {
            a("2", (TransmitForumData) tag, this.mPrivateThread);
            uT(12);
        }
    }

    private void uT(int i) {
        if (this.mShareItem != null) {
            TiebaStatic.log(new am("c10125").al(ImageViewerConfig.FORUM_ID, this.mShareItem.fid).al("tid", this.mShareItem.tid).w("obj_type", i).w(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mShareItem.aJu).w("obj_param1", this.mShareItem.aJv));
        }
    }

    private void bCx() {
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
        MessageManager.getInstance().unRegisterListener(this.his);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView aZt;
        public TextView bCa;
        public ViewGroup hiu;

        private a() {
        }
    }
}
