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
    private com.baidu.tieba.write.transmit.a gBI;
    private h gBJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.gBJ = new h() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (fVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean byA = c.this.gBI != null ? c.this.gBI.byA() : false;
                    if (!isChecked && byA) {
                        c.this.gBI.byB();
                    }
                    if (isChecked || !byA) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) fVar).ZM = checkBox.isChecked();
                        if (c.this.gBI != null) {
                            c.this.gBI.byC();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gBJ);
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
        aVar.bEo.setText(transmitForumData.forumName);
        aVar.gBw.setChecked(transmitForumData.ZM);
        ai.i(aVar.bEo, d.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public TextView bEo;
        public CheckBox gBw;

        public a(View view) {
            super(view);
            this.bEo = (TextView) view.findViewById(d.h.transmit_forum_name);
            this.gBw = (CheckBox) view.findViewById(d.h.transmit_check_box);
            this.gBw.setButtonDrawable(ai.getDrawable(d.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.gBI = aVar;
    }
}
