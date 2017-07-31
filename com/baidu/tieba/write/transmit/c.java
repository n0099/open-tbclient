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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a gCT;
    private h gCU;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.gCU = new h() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (fVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean byH = c.this.gCT != null ? c.this.gCT.byH() : false;
                    if (!isChecked && byH) {
                        c.this.gCT.byI();
                    }
                    if (isChecked || !byH) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) fVar).abi = checkBox.isChecked();
                        if (c.this.gCT != null) {
                            c.this.gCT.byJ();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gCU);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.j.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bFy.setText(transmitForumData.forumName);
        aVar.gCH.setChecked(transmitForumData.abi);
        ai.i(aVar.bFy, d.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public TextView bFy;
        public CheckBox gCH;

        public a(View view) {
            super(view);
            this.bFy = (TextView) view.findViewById(d.h.transmit_forum_name);
            this.gCH = (CheckBox) view.findViewById(d.h.transmit_check_box);
            this.gCH.setButtonDrawable(ai.getDrawable(d.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.gCT = aVar;
    }
}
