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
    private com.baidu.tieba.video.editvideo.data.a hFX;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.hFX = this.mList.get(0);
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
            aVar.hFY = (TbImageView) view.findViewById(e.g.iv_effect);
            aVar.hFY.setIsRound(true);
            aVar.hFY.setDrawerType(1);
            aVar.hFY.setDefaultBgResource(e.d.transparent);
            aVar.hFY.setBorderWidth(l.h(viewGroup.getContext(), e.C0210e.ds4));
            aVar.hFY.setBorderColor(al.getColor(e.d.cp_link_tip_a));
            aVar.gbj = (TextView) view.findViewById(e.g.tv_name);
            al.h(aVar.gbj, e.d.cp_cont_j);
            aVar.gbj = (TextView) view.findViewById(e.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.hFY.setTag(aVar2);
                aVar.hFY.setOnClickListener(this);
                aVar.hFY.startLoad(String.valueOf(aVar2.hGB), 24, false);
                aVar.gbj.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.hFX != null && TextUtils.equals(aVar2.name, this.hFX.name)) {
                aVar.hFY.setDrawBorder(true);
            } else {
                aVar.hFY.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.hFX = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    class a {
        TextView gbj;
        TbImageView hFY;

        a() {
        }
    }
}
