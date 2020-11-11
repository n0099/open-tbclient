package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.af;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a nIF;
    private ab nIG;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.nIG = new ab() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dTX = c.this.nIF != null ? c.this.nIF.dTX() : false;
                    if (!isChecked && dTX) {
                        c.this.nIF.dTY();
                    }
                    if (isChecked || !dTX) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) qVar).checked = checkBox.isChecked();
                        if (c.this.nIF != null) {
                            c.this.nIF.dTZ();
                        }
                    }
                }
            }
        };
        a(this.nIG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cQ */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.eWV.setText(transmitForumData.forumName);
        aVar.lfU.setChecked(transmitForumData.checked);
        ap.setViewTextColor(aVar.eWV, R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends af.a {
        public TextView eWV;
        public CheckBox lfU;

        public a(View view) {
            super(view);
            this.eWV = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.lfU = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.lfU.setButtonDrawable(ap.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.nIF = aVar;
    }
}
