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
import d.b.c.j.e.n;
import d.b.c.j.e.w;
/* loaded from: classes5.dex */
public class TransmitForumAdapter extends d.b.c.j.e.a<TransmitForumData, TransmitForumViewHolder> {
    public d.b.i0.v3.r.a m;
    public w n;

    /* loaded from: classes5.dex */
    public static class TransmitForumViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22002a;

        /* renamed from: b  reason: collision with root package name */
        public CheckBox f22003b;

        public TransmitForumViewHolder(View view) {
            super(view);
            this.f22002a = (TextView) view.findViewById(R.id.transmit_forum_name);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
            this.f22003b = checkBox;
            checkBox.setButtonDrawable(SkinManager.getDrawable(R.drawable.transmit_check_box));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements w {
        public a() {
        }

        @Override // d.b.c.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof TransmitForumData) {
                CheckBox checkBox = (CheckBox) view.findViewById(R.id.transmit_check_box);
                boolean isChecked = checkBox.isChecked();
                boolean b2 = TransmitForumAdapter.this.m != null ? TransmitForumAdapter.this.m.b() : false;
                if (!isChecked && b2) {
                    TransmitForumAdapter.this.m.a();
                }
                if (isChecked || !b2) {
                    checkBox.setChecked(!checkBox.isChecked());
                    ((TransmitForumData) nVar).checked = checkBox.isChecked();
                    if (TransmitForumAdapter.this.m != null) {
                        TransmitForumAdapter.this.m.c();
                    }
                }
            }
        }
    }

    public TransmitForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        a aVar = new a();
        this.n = aVar;
        c0(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        j0(i, view, viewGroup, transmitForumData, transmitForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: i0 */
    public TransmitForumViewHolder R(ViewGroup viewGroup) {
        return new TransmitForumViewHolder(LayoutInflater.from(this.f42855e).inflate(R.layout.transmit_forum_layout, (ViewGroup) null));
    }

    public View j0(int i, View view, ViewGroup viewGroup, TransmitForumData transmitForumData, TransmitForumViewHolder transmitForumViewHolder) {
        transmitForumViewHolder.f22002a.setText(transmitForumData.forumName);
        transmitForumViewHolder.f22003b.setChecked(transmitForumData.checked);
        SkinManager.setViewTextColor(transmitForumViewHolder.f22002a, R.color.CAM_X0105);
        return view;
    }

    public void l0(d.b.i0.v3.r.a aVar) {
        this.m = aVar;
    }
}
