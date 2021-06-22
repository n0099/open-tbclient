package com.baidu.tieba.write.transmit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
/* loaded from: classes5.dex */
public class TransmitForumAdapter extends d.a.c.k.e.a<TransmitForumData, TransmitForumViewHolder> {
    public d.a.o0.w3.q.a m;
    public w n;

    /* loaded from: classes5.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22047a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f22048b;

        public TransmitForumViewHolder(View view) {
            super(view);
            this.f22047a = (TextView) view.findViewById(R.id.transmit_forum_name);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f22048b = checkBox;
            checkBox.setButtonDrawable(SkinManager.getDrawable(R.drawable.transmit_check_box));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar instanceof TransmitForumData) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                boolean isChecked = checkBox.isChecked();
                boolean c2 = TransmitForumAdapter.this.m != null ? TransmitForumAdapter.this.m.c() : false;
                if (!isChecked && c2) {
                    TransmitForumAdapter.this.m.b();
                }
                if (isChecked || !c2) {
                    checkBox.setChecked(!checkBox.isChecked());
                    ((TransmitForumData) nVar).checked = checkBox.isChecked();
                    if (TransmitForumAdapter.this.m != null) {
                        TransmitForumAdapter.this.m.a();
                    }
                }
            }
        }
    }

    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        a aVar = new a();
        this.n = aVar;
        a0(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        h0(i2, view, viewGroup, transmitForumData, transmitForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public TransmitForumViewHolder Q(ViewGroup viewGroup) {
        return new TransmitForumViewHolder(LayoutInflater.from(this.f43012e).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    public View h0(int i2, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        transmitForumViewHolder.f22047a.setText(transmitForumData.forumName);
        transmitForumViewHolder.f22048b.setChecked(transmitForumData.checked);
        SkinManager.setViewTextColor(transmitForumViewHolder.f22047a, R.color.CAM_X0105);
        return view;
    }

    public void i0(d.a.o0.w3.q.a aVar) {
        this.m = aVar;
    }
}
