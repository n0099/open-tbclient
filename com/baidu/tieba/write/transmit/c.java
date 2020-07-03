package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a mqk;
    private z mql;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.mql = new z() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean drQ = c.this.mqk != null ? c.this.mqk.drQ() : false;
                    if (!isChecked && drQ) {
                        c.this.mqk.drR();
                    }
                    if (isChecked || !drQ) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) qVar).checked = checkBox.isChecked();
                        if (c.this.mqk != null) {
                            c.this.mqk.drS();
                        }
                    }
                }
            }
        };
        a(this.mql);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cH */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.een.setText(transmitForumData.forumName);
        aVar.jRL.setChecked(transmitForumData.checked);
        an.setViewTextColor(aVar.een, (int) R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends ad.a {
        public TextView een;
        public CheckBox jRL;

        public a(View view) {
            super(view);
            this.een = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.jRL = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.jRL.setButtonDrawable(an.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.mqk = aVar;
    }
}
