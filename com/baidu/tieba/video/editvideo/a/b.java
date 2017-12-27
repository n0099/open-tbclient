package com.baidu.tieba.video.editvideo.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a hyA;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.hyA = this.mList.get(0);
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_filter, (ViewGroup) null);
            aVar.hyB = (TbImageView) view.findViewById(d.g.iv_effect);
            aVar.hyB.setIsRound(true);
            aVar.hyB.setDrawerType(1);
            aVar.hyB.setDefaultBgResource(d.C0108d.transparent);
            aVar.hyB.setBorderWidth(l.s(viewGroup.getContext(), d.e.ds4));
            aVar.hyB.setBorderColor(aj.getColor(d.C0108d.cp_link_tip_a));
            aVar.fKg = (TextView) view.findViewById(d.g.tv_name);
            aj.r(aVar.fKg, d.C0108d.cp_cont_j);
            aVar.fKg = (TextView) view.findViewById(d.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.hyB.setTag(aVar2);
                aVar.hyB.setOnClickListener(this);
                aVar.hyB.startLoad(String.valueOf(aVar2.hze), 24, false);
                aVar.fKg.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.hyA != null && TextUtils.equals(aVar2.name, this.hyA.name)) {
                aVar.hyB.setDrawBorder(true);
            } else {
                aVar.hyB.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.hyA = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        TextView fKg;
        TbImageView hyB;

        a() {
        }
    }
}
