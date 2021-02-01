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
/* loaded from: classes8.dex */
public class TransmitForumAdapter extends com.baidu.adp.widget.ListView.a<TransmitForumData, TransmitForumViewHolder> {
    private a ogI;
    private w ogJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        this.ogJ = new w() { // from class: com.baidu.tieba.write.transmit.TransmitForumAdapter.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId2, ViewGroup viewGroup, int i, long j) {
                if (nVar instanceof TransmitForumData) {
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                    boolean isChecked = checkBox.isChecked();
                    boolean dXl = TransmitForumAdapter.this.ogI != null ? TransmitForumAdapter.this.ogI.dXl() : false;
                    if (!isChecked && dXl) {
                        TransmitForumAdapter.this.ogI.dXm();
                    }
                    if (isChecked || !dXl) {
                        checkBox.setChecked(checkBox.isChecked() ? false : true);
                        ((TransmitForumData) nVar).checked = checkBox.isChecked();
                        if (TransmitForumAdapter.this.ogI != null) {
                            TransmitForumAdapter.this.ogI.dXn();
                        }
                    }
                }
            }
        };
        a(this.ogJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: dd */
    public TransmitForumViewHolder e(ViewGroup viewGroup) {
        return new TransmitForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        transmitForumViewHolder.fkQ.setText(transmitForumData.forumName);
        transmitForumViewHolder.lCt.setChecked(transmitForumData.checked);
        ap.setViewTextColor(transmitForumViewHolder.fkQ, R.color.CAM_X0105);
        return view;
    }

    /* loaded from: classes8.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {
        public TextView fkQ;
        public CheckBox lCt;

        public TransmitForumViewHolder(View view) {
            super(view);
            this.fkQ = (TextView) view.findViewById(R.id.transmit_forum_name);
            this.lCt = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.lCt.setButtonDrawable(ap.getDrawable(R.drawable.transmit_check_box));
        }
    }

    public void a(a aVar) {
        this.ogI = aVar;
    }
}
