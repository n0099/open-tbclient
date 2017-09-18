package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a gEl;
    private h gEm;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.gEm = new h() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (fVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean byH = c.this.gEl != null ? c.this.gEl.byH() : false;
                    if (!isChecked && byH) {
                        c.this.gEl.byI();
                    }
                    if (isChecked || !byH) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) fVar).checked = checkBox.isChecked();
                        if (c.this.gEl != null) {
                            c.this.gEl.byJ();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gEm);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.j.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bJT.setText(transmitForumData.forumName);
        aVar.eBs.setChecked(transmitForumData.checked);
        aj.i(aVar.bJT, d.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends j.a {
        public TextView bJT;
        public CheckBox eBs;

        public a(View view) {
            super(view);
            this.bJT = (TextView) view.findViewById(d.h.transmit_forum_name);
            this.eBs = (CheckBox) view.findViewById(d.h.transmit_check_box);
            this.eBs.setButtonDrawable(aj.getDrawable(d.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.gEl = aVar;
    }
}
