package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<TransmitForumData, a> {
    private com.baidu.tieba.write.transmit.a lBr;
    private v lBs;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.lBs = new v() { // from class: com.baidu.tieba.write.transmit.c.1
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (mVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dfX = c.this.lBr != null ? c.this.lBr.dfX() : false;
                    if (!isChecked && dfX) {
                        c.this.lBr.dfY();
                    }
                    if (isChecked || !dfX) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) mVar).checked = checkBox.isChecked();
                        if (c.this.lBr != null) {
                            c.this.lBr.dfZ();
                        }
                    }
                }
            }
        };
        a(this.lBs);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ci */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, a aVar) {
        aVar.dIC.setText(transmitForumData.forumName);
        aVar.jik.setChecked(transmitForumData.checked);
        am.setViewTextColor(aVar.dIC, (int) R.color.cp_cont_b);
        return view;
    }

    /* loaded from: classes2.dex */
    public static class a extends y.a {
        public TextView dIC;
        public CheckBox jik;

        public a(View view) {
            super(view);
            this.dIC = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.jik = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.jik.setButtonDrawable(am.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(com.baidu.tieba.write.transmit.a aVar) {
        this.lBr = aVar;
    }
}
