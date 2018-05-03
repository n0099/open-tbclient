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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a heb;
    private n hec;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hec = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view2, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view2.findViewById(d.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bCm = c.this.heb != null ? c.this.heb.bCm() : false;
                    if (!isChecked && bCm) {
                        c.this.heb.bCn();
                    }
                    if (isChecked || !bCm) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.heb != null) {
                            c.this.heb.bCo();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hec);
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
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.apV.setText(transmitForumData.forumName);
        aVar.eWU.setChecked(transmitForumData.checked);
        ak.h(aVar.apV, d.C0126d.cp_cont_b);
        return view2;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView apV;
        public CheckBox eWU;

        public a(View view2) {
            super(view2);
            this.apV = (TextView) view2.findViewById(d.g.transmit_forum_name);
            this.eWU = (CheckBox) view2.findViewById(d.g.transmit_check_box);
            this.eWU.setButtonDrawable(ak.getDrawable(d.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.heb = aVar;
    }
}
