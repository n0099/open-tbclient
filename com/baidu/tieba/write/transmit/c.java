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
    private com.baidu.tieba.write.transmit.a nYo;
    private ab nYp;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.nYp = new ab() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dZr = c.this.nYo != null ? c.this.nYo.dZr() : false;
                    if (!isChecked && dZr) {
                        c.this.nYo.dZs();
                    }
                    if (isChecked || !dZr) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) qVar).checked = checkBox.isChecked();
                        if (c.this.nYo != null) {
                            c.this.nYo.dZt();
                        }
                    }
                }
            }
        };
        a(this.nYp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cP */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.fdz.setText(transmitForumData.forumName);
        aVar.ltN.setChecked(transmitForumData.checked);
        ap.setViewTextColor(aVar.fdz, R.color.CAM_X0105);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends af.a {
        public TextView fdz;
        public CheckBox ltN;

        public a(View view) {
            super(view);
            this.fdz = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.ltN = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.ltN.setButtonDrawable(ap.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.nYo = aVar;
    }
}
