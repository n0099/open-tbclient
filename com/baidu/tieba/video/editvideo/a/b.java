package com.baidu.tieba.video.editvideo.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a gMH;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.gMH = this.mList.get(0);
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a();
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_filter, (ViewGroup) null);
            aVar.gMI = (TbImageView) view2.findViewById(d.g.iv_effect);
            aVar.gMI.setIsRound(true);
            aVar.gMI.setDrawerType(1);
            aVar.gMI.setDefaultBgResource(d.C0126d.transparent);
            aVar.gMI.setBorderWidth(l.e(viewGroup.getContext(), d.e.ds4));
            aVar.gMI.setBorderColor(ak.getColor(d.C0126d.cp_link_tip_a));
            aVar.fks = (TextView) view2.findViewById(d.g.tv_name);
            ak.h(aVar.fks, d.C0126d.cp_cont_j);
            aVar.fks = (TextView) view2.findViewById(d.g.tv_name);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.gMI.setTag(aVar2);
                aVar.gMI.setOnClickListener(this);
                aVar.gMI.startLoad(String.valueOf(aVar2.gNl), 24, false);
                aVar.fks.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.gMH != null && TextUtils.equals(aVar2.name, this.gMH.name)) {
                aVar.gMI.setDrawBorder(true);
            } else {
                aVar.gMI.setDrawBorder(false);
            }
        }
        return view2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2.getId() == d.g.iv_effect && (view2.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.gMH = (com.baidu.tieba.video.editvideo.data.a) view2.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        TextView fks;
        TbImageView gMI;

        a() {
        }
    }
}
