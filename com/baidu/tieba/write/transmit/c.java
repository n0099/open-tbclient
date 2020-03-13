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
/* loaded from: classes13.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a kPP;
    private s kPQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.kPQ = new s() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (mVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean cUY = c.this.kPP != null ? c.this.kPP.cUY() : false;
                    if (!isChecked && cUY) {
                        c.this.kPP.cUZ();
                    }
                    if (isChecked || !cUY) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) mVar).checked = checkBox.isChecked();
                        if (c.this.kPP != null) {
                            c.this.kPP.cVa();
                        }
                    }
                }
            }
        };
        a(this.kPQ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cf */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.diq.setText(transmitForumData.forumName);
        aVar.iwz.setChecked(transmitForumData.checked);
        am.setViewTextColor(aVar.diq, (int) R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes13.dex */
    public static class a extends v.a {
        public TextView diq;
        public CheckBox iwz;

        public a(View view) {
            super(view);
            this.diq = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.iwz = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.iwz.setButtonDrawable(am.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.kPP = aVar;
    }
}
