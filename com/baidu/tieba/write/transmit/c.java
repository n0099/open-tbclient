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
    private com.baidu.tieba.write.transmit.a mQD;
    private ab mQE;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mQE = new ab() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dGD = c.this.mQD != null ? c.this.mQD.dGD() : false;
                    if (!isChecked && dGD) {
                        c.this.mQD.dGE();
                    }
                    if (isChecked || !dGD) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) qVar).checked = checkBox.isChecked();
                        if (c.this.mQD != null) {
                            c.this.mQD.dGF();
                        }
                    }
                }
            }
        };
        a(this.mQE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cI */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.eus.setText(transmitForumData.forumName);
        aVar.kpH.setChecked(transmitForumData.checked);
        ap.setViewTextColor(aVar.eus, R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends af.a {
        public TextView eus;
        public CheckBox kpH;

        public a(View view) {
            super(view);
            this.eus = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.kpH = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.kpH.setButtonDrawable(ap.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.mQD = aVar;
    }
}
