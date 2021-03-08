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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class TransmitForumAdapter extends com.baidu.adp.widget.ListView.a<TransmitForumData, TransmitForumViewHolder> {
    private a ojn;
    private w ojo;

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.ojo = new w() { // from class: com.baidu.tieba.write.transmit.TransmitForumAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dXB = TransmitForumAdapter.this.ojn != null ? TransmitForumAdapter.this.ojn.dXB() : false;
                    if (!isChecked && dXB) {
                        TransmitForumAdapter.this.ojn.dXC();
                    }
                    if (isChecked || !dXB) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) nVar).checked = checkBox.isChecked();
                        if (TransmitForumAdapter.this.ojn != null) {
                            TransmitForumAdapter.this.ojn.dXD();
                        }
                    }
                }
            }
        };
        a(this.ojo);
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
        transmitForumViewHolder.fmq.setText(transmitForumData.forumName);
        transmitForumViewHolder.lEJ.setChecked(transmitForumData.checked);
        ap.setViewTextColor(transmitForumViewHolder.fmq, R.color.CAM_X0105);
        return view;
    }

    /* loaded from: classes7.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {
        public TextView fmq;
        public CheckBox lEJ;

        public TransmitForumViewHolder(View view) {
            super(view);
            this.fmq = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.lEJ = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.lEJ.setButtonDrawable(ap.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(a aVar) {
        this.ojn = aVar;
    }
}
