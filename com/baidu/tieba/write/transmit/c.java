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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a hvj;
    private n hvk;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hvk = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bHQ = c.this.hvj != null ? c.this.hvj.bHQ() : false;
                    if (!isChecked && bHQ) {
                        c.this.hvj.bHR();
                    }
                    if (isChecked || !bHQ) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.hvj != null) {
                            c.this.hvj.bHS();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hvk);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bH */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.ayV.setText(transmitForumData.forumName);
        aVar.fns.setChecked(transmitForumData.checked);
        am.h(aVar.ayV, d.C0142d.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView ayV;
        public CheckBox fns;

        public a(View view) {
            super(view);
            this.ayV = (TextView) view.findViewById(d.g.transmit_forum_name);
            this.fns = (CheckBox) view.findViewById(d.g.transmit_check_box);
            this.fns.setButtonDrawable(am.getDrawable(d.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hvj = aVar;
    }
}
