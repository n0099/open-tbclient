package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a ghJ;
    private x ghK;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.ghK = new i(this);
        setOnAdapterItemClickListener(this.ghK);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bD */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(w.j.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.bAh.setText(transmitForumData.forumName);
        aVar.ghx.setChecked(transmitForumData.aaP);
        as.i(aVar.bAh, w.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends z.a {
        public TextView bAh;
        public CheckBox ghx;

        public a(View view) {
            super(view);
            this.bAh = (TextView) view.findViewById(w.h.transmit_forum_name);
            this.ghx = (CheckBox) view.findViewById(w.h.transmit_check_box);
            this.ghx.setButtonDrawable(as.getDrawable(w.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.ghJ = aVar;
    }
}
