package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a hEO;
    private n hEP;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hEP = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(e.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bJw = c.this.hEO != null ? c.this.hEO.bJw() : false;
                    if (!isChecked && bJw) {
                        c.this.hEO.bJx();
                    }
                    if (isChecked || !bJw) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.hEO != null) {
                            c.this.hEO.bJy();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hEP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.aAN.setText(transmitForumData.forumName);
        aVar.fuU.setChecked(transmitForumData.checked);
        al.h(aVar.aAN, e.d.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView aAN;
        public CheckBox fuU;

        public a(View view) {
            super(view);
            this.aAN = (TextView) view.findViewById(e.g.transmit_forum_name);
            this.fuU = (CheckBox) view.findViewById(e.g.transmit_check_box);
            this.fuU.setButtonDrawable(al.getDrawable(e.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hEO = aVar;
    }
}
