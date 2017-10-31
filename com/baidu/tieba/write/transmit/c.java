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
    private com.baidu.tieba.write.transmit.a gSP;
    private h gSQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.gSQ = new h() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (fVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.g.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bDp = c.this.gSP != null ? c.this.gSP.bDp() : false;
                    if (!isChecked && bDp) {
                        c.this.gSP.bDq();
                    }
                    if (isChecked || !bDp) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) fVar).checked = checkBox.isChecked();
                        if (c.this.gSP != null) {
                            c.this.gSP.bDr();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gSQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bW */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bRG.setText(transmitForumData.forumName);
        aVar.eCC.setChecked(transmitForumData.checked);
        aj.i(aVar.bRG, d.C0080d.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends j.a {
        public TextView bRG;
        public CheckBox eCC;

        public a(View view) {
            super(view);
            this.bRG = (TextView) view.findViewById(d.g.transmit_forum_name);
            this.eCC = (CheckBox) view.findViewById(d.g.transmit_check_box);
            this.eCC.setButtonDrawable(aj.getDrawable(d.f.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.gSP = aVar;
    }
}
