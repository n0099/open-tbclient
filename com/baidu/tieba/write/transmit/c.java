package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a hPP;
    private o hPQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hPQ = new o() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.o
            public void a(View view, i iVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (iVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bMG = c.this.hPP != null ? c.this.hPP.bMG() : false;
                    if (!isChecked && bMG) {
                        c.this.hPP.bMH();
                    }
                    if (isChecked || !bMG) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) iVar).checked = checkBox.isChecked();
                        if (c.this.hPP != null) {
                            c.this.hPP.bMI();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hPQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bP */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bcI.setText(transmitForumData.forumName);
        aVar.fwO.setChecked(transmitForumData.checked);
        aj.r(aVar.bcI, d.C0108d.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends r.a {
        public TextView bcI;
        public CheckBox fwO;

        public a(View view) {
            super(view);
            this.bcI = (TextView) view.findViewById(d.g.transmit_forum_name);
            this.fwO = (CheckBox) view.findViewById(d.g.transmit_check_box);
            this.fwO.setButtonDrawable(aj.getDrawable(d.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hPP = aVar;
    }
}
