package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a jQf;
    private s jQg;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.jQg = new s() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (mVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean cAJ = c.this.jQf != null ? c.this.jQf.cAJ() : false;
                    if (!isChecked && cAJ) {
                        c.this.jQf.cAK();
                    }
                    if (isChecked || !cAJ) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) mVar).checked = checkBox.isChecked();
                        if (c.this.jQf != null) {
                            c.this.jQf.cAL();
                        }
                    }
                }
            }
        };
        setOnAdapterItemClickListener(this.jQg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bZ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.cbW.setText(transmitForumData.forumName);
        aVar.hCf.setChecked(transmitForumData.checked);
        am.j(aVar.cbW, R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public TextView cbW;
        public CheckBox hCf;

        public a(View view) {
            super(view);
            this.cbW = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.hCf = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.hCf.setButtonDrawable(am.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.jQf = aVar;
    }
}
