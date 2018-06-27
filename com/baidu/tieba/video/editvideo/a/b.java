package com.baidu.tieba.video.editvideo.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a hco;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.hco = this.mList.get(0);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_filter, (ViewGroup) null);
            aVar.hcp = (TbImageView) view.findViewById(d.g.iv_effect);
            aVar.hcp.setIsRound(true);
            aVar.hcp.setDrawerType(1);
            aVar.hcp.setDefaultBgResource(d.C0142d.transparent);
            aVar.hcp.setBorderWidth(l.e(viewGroup.getContext(), d.e.ds4));
            aVar.hcp.setBorderColor(am.getColor(d.C0142d.cp_link_tip_a));
            aVar.fzO = (TextView) view.findViewById(d.g.tv_name);
            am.h(aVar.fzO, d.C0142d.cp_cont_j);
            aVar.fzO = (TextView) view.findViewById(d.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.hcp.setTag(aVar2);
                aVar.hcp.setOnClickListener(this);
                aVar.hcp.startLoad(String.valueOf(aVar2.hcS), 24, false);
                aVar.fzO.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.hco != null && TextUtils.equals(aVar2.name, this.hco.name)) {
                aVar.hcp.setDrawBorder(true);
            } else {
                aVar.hcp.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.hco = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        TextView fzO;
        TbImageView hcp;

        a() {
        }
    }
}
