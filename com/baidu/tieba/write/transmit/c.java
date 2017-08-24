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
    private com.baidu.tieba.write.transmit.a gEL;
    private h gEM;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.gEM = new h() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.h
            public void a(View view, f fVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (fVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(d.h.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean bzg = c.this.gEL != null ? c.this.gEL.bzg() : false;
                    if (!isChecked && bzg) {
                        c.this.gEL.bzh();
                    }
                    if (isChecked || !bzg) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) fVar).checked = checkBox.isChecked();
                        if (c.this.gEL != null) {
                            c.this.gEL.bzi();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.gEM);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bT */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.j.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bGi.setText(transmitForumData.forumName);
        aVar.gEz.setChecked(transmitForumData.checked);
        ai.i(aVar.bGi, d.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends j.a {
        public TextView bGi;
        public CheckBox gEz;

        public a(View view) {
            super(view);
            this.bGi = (TextView) view.findViewById(d.h.transmit_forum_name);
            this.gEz = (CheckBox) view.findViewById(d.h.transmit_check_box);
            this.gEz.setButtonDrawable(ai.getDrawable(d.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.gEL = aVar;
    }
}
