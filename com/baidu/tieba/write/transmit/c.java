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
/* loaded from: classes11.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a kOV;
    private s kOW;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.kOW = new s() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (mVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean cTH = c.this.kOV != null ? c.this.kOV.cTH() : false;
                    if (!isChecked && cTH) {
                        c.this.kOV.cTI();
                    }
                    if (isChecked || !cTH) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) mVar).checked = checkBox.isChecked();
                        if (c.this.kOV != null) {
                            c.this.kOV.cTJ();
                        }
                    }
                }
            }
        };
        a(this.kOW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cg */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.ddX.setText(transmitForumData.forumName);
        aVar.iuq.setChecked(transmitForumData.checked);
        am.setViewTextColor(aVar.ddX, (int) R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes11.dex */
    public static class a extends v.a {
        public TextView ddX;
        public CheckBox iuq;

        public a(View view) {
            super(view);
            this.ddX = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.iuq = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.iuq.setButtonDrawable(am.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.kOV = aVar;
    }
}
