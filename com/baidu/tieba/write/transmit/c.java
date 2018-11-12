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
    private com.baidu.tieba.write.transmit.a hNL;
    private n hNM;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hNM = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(e.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bMh = c.this.hNL != null ? c.this.hNL.bMh() : false;
                    if (!isChecked && bMh) {
                        c.this.hNL.bMi();
                    }
                    if (isChecked || !bMh) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.hNL != null) {
                            c.this.hNL.bMj();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hNM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bI */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.aGk.setText(transmitForumData.forumName);
        aVar.fDV.setChecked(transmitForumData.checked);
        al.h(aVar.aGk, e.d.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView aGk;
        public CheckBox fDV;

        public a(View view) {
            super(view);
            this.aGk = (TextView) view.findViewById(e.g.transmit_forum_name);
            this.fDV = (CheckBox) view.findViewById(e.g.transmit_check_box);
            this.fDV.setButtonDrawable(al.getDrawable(e.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hNL = aVar;
    }
}
