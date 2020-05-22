package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a lUF;
    private x lUG;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.lUG = new x() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (oVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dnn = c.this.lUF != null ? c.this.lUF.dnn() : false;
                    if (!isChecked && dnn) {
                        c.this.lUF.dno();
                    }
                    if (isChecked || !dnn) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) oVar).checked = checkBox.isChecked();
                        if (c.this.lUF != null) {
                            c.this.lUF.dnp();
                        }
                    }
                }
            }
        };
        a(this.lUG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cv */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.dWR.setText(transmitForumData.forumName);
        aVar.jxm.setChecked(transmitForumData.checked);
        am.setViewTextColor(aVar.dWR, (int) R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends aa.a {
        public TextView dWR;
        public CheckBox jxm;

        public a(View view) {
            super(view);
            this.dWR = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.jxm = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.jxm.setButtonDrawable(am.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.lUF = aVar;
    }
}
