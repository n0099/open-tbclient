package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class TransmitForumAdapter extends com.baidu.adp.widget.ListView.a<TransmitForumData, TransmitForumViewHolder> {
    private a nWB;
    private w nWC;

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.nWC = new w() { // from class: com.baidu.tieba.write.transmit.TransmitForumAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dUX = TransmitForumAdapter.this.nWB != null ? TransmitForumAdapter.this.nWB.dUX() : false;
                    if (!isChecked && dUX) {
                        TransmitForumAdapter.this.nWB.dUY();
                    }
                    if (isChecked || !dUX) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) nVar).checked = checkBox.isChecked();
                        if (TransmitForumAdapter.this.nWB != null) {
                            TransmitForumAdapter.this.nWB.dUZ();
                        }
                    }
                }
            }
        };
        a(this.nWC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: dc */
    public TransmitForumViewHolder e(ViewGroup viewGroup) {
        return new TransmitForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        transmitForumViewHolder.fiz.setText(transmitForumData.forumName);
        transmitForumViewHolder.lup.setChecked(transmitForumData.checked);
        ao.setViewTextColor(transmitForumViewHolder.fiz, R.color.CAM_X0105);
        return view;
    }

    /* loaded from: classes7.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {
        public TextView fiz;
        public CheckBox lup;

        public TransmitForumViewHolder(View view) {
            super(view);
            this.fiz = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.lup = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.lup.setButtonDrawable(ao.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(a aVar) {
        this.nWB = aVar;
    }
}
