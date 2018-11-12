package com.baidu.tieba.video.editvideo.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a hus;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.hus = this.mList.get(0);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_filter, (ViewGroup) null);
            aVar.hut = (TbImageView) view.findViewById(e.g.iv_effect);
            aVar.hut.setIsRound(true);
            aVar.hut.setDrawerType(1);
            aVar.hut.setDefaultBgResource(e.d.transparent);
            aVar.hut.setBorderWidth(l.h(viewGroup.getContext(), e.C0200e.ds4));
            aVar.hut.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            aVar.fQD = (TextView) view.findViewById(e.g.tv_name);
            al.h(aVar.fQD, e.d.cp_cont_j);
            aVar.fQD = (TextView) view.findViewById(e.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.hut.setTag(aVar2);
                aVar.hut.setOnClickListener(this);
                aVar.hut.startLoad(String.valueOf(aVar2.huW), 24, false);
                aVar.fQD.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.hus != null && TextUtils.equals(aVar2.name, this.hus.name)) {
                aVar.hut.setDrawBorder(true);
            } else {
                aVar.hut.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.hus = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    class a {
        TextView fQD;
        TbImageView hut;

        a() {
        }
    }
}
