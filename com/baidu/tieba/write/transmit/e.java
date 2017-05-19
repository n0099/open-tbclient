package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a fOM;
    private w fON;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.fON = new f(this);
        setOnAdapterItemClickListener(this.fON);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bG */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(w.j.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.buI.setText(transmitForumData.forumName);
        aVar.fOP.setChecked(transmitForumData.aaP);
        aq.i(aVar.buI, w.e.cp_cont_b);
        return view;
    }

    /* loaded from: classes.dex */
    public static class a extends y.a {
        public TextView buI;
        public CheckBox fOP;

        public a(View view) {
            super(view);
            this.buI = (TextView) view.findViewById(w.h.transmit_forum_name);
            this.fOP = (CheckBox) view.findViewById(w.h.transmit_check_box);
            this.fOP.setButtonDrawable(aq.getDrawable(w.g.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.fOM = aVar;
    }
}
