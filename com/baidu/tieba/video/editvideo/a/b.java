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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a iWn;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.iWn = this.mList.get(0);
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
            aVar.iWo = (TbImageView) view.findViewById(d.g.iv_effect);
            aVar.iWo.setIsRound(true);
            aVar.iWo.setDrawerType(1);
            aVar.iWo.setDefaultBgResource(d.C0277d.transparent);
            aVar.iWo.setBorderWidth(l.h(viewGroup.getContext(), d.e.ds4));
            aVar.iWo.setBorderColor(al.getColor(d.C0277d.cp_link_tip_a));
            aVar.iWo.setConrers(15);
            aVar.hrb = (TextView) view.findViewById(d.g.tv_name);
            al.j(aVar.hrb, d.C0277d.cp_cont_j);
            aVar.hrb = (TextView) view.findViewById(d.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.iWo.setTag(aVar2);
                aVar.iWo.setOnClickListener(this);
                aVar.iWo.startLoad(String.valueOf(aVar2.iWR), 24, false);
                aVar.hrb.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.iWn != null && TextUtils.equals(aVar2.name, this.iWn.name)) {
                aVar.iWo.setDrawBorder(true);
            } else {
                aVar.iWo.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.iWn = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    class a {
        TextView hrb;
        TbImageView iWo;

        a() {
        }
    }
}
