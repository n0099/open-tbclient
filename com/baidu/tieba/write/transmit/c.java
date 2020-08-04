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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a myo;
    private z myp;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.myp = new z() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (qVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dvh = c.this.myo != null ? c.this.myo.dvh() : false;
                    if (!isChecked && dvh) {
                        c.this.myo.dvi();
                    }
                    if (isChecked || !dvh) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) qVar).checked = checkBox.isChecked();
                        if (c.this.myo != null) {
                            c.this.myo.dvj();
                        }
                    }
                }
            }
        };
        a(this.myp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: cK */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.ekx.setText(transmitForumData.forumName);
        aVar.kal.setChecked(transmitForumData.checked);
        ao.setViewTextColor(aVar.ekx, R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes3.dex */
    public static class a extends ad.a {
        public TextView ekx;
        public CheckBox kal;

        public a(View view) {
            super(view);
            this.ekx = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.kal = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.kal.setButtonDrawable(ao.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.myo = aVar;
    }
}
