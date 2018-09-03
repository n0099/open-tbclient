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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a hwr;
    private n hws;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.hws = new n() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.n
            public void a(View view, h hVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (hVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(f.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bGF = c.this.hwr != null ? c.this.hwr.bGF() : false;
                    if (!isChecked && bGF) {
                        c.this.hwr.bGG();
                    }
                    if (isChecked || !bGF) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) hVar).checked = checkBox.isChecked();
                        if (c.this.hwr != null) {
                            c.this.hwr.bGH();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.hws);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bF */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.axQ.setText(transmitForumData.forumName);
        aVar.fnx.setChecked(transmitForumData.checked);
        am.h(aVar.axQ, f.d.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends q.a {
        public TextView axQ;
        public CheckBox fnx;

        public a(View view) {
            super(view);
            this.axQ = (TextView) view.findViewById(f.g.transmit_forum_name);
            this.fnx = (CheckBox) view.findViewById(f.g.transmit_check_box);
            this.fnx.setButtonDrawable(am.getDrawable(f.C0146f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.hwr = aVar;
    }
}
