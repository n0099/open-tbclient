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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a hra;
    private n hrb;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hrb = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bHp = c.this.hra != null ? c.this.hra.bHp() : false;
                    if (!isChecked && bHp) {
                        c.this.hra.bHq();
                    }
                    if (isChecked || !bHp) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.hra != null) {
                            c.this.hra.bHr();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hrb);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.ayc.setText(transmitForumData.forumName);
        aVar.fjw.setChecked(transmitForumData.checked);
        al.h(aVar.ayc, d.C0141d.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView ayc;
        public CheckBox fjw;

        public a(View view) {
            super(view);
            this.ayc = (TextView) view.findViewById(d.g.transmit_forum_name);
            this.fjw = (CheckBox) view.findViewById(d.g.transmit_check_box);
            this.fjw.setButtonDrawable(al.getDrawable(d.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hra = aVar;
    }
}
