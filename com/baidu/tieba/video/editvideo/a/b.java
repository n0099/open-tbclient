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
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a hdB;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.hdB = this.mList.get(0);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.list_item_filter, (ViewGroup) null);
            aVar.hdC = (TbImageView) view.findViewById(f.g.iv_effect);
            aVar.hdC.setIsRound(true);
            aVar.hdC.setDrawerType(1);
            aVar.hdC.setDefaultBgResource(f.d.transparent);
            aVar.hdC.setBorderWidth(l.f(viewGroup.getContext(), f.e.ds4));
            aVar.hdC.setBorderColor(am.getColor(f.d.cp_link_tip_a));
            aVar.fzT = (TextView) view.findViewById(f.g.tv_name);
            am.h(aVar.fzT, f.d.cp_cont_j);
            aVar.fzT = (TextView) view.findViewById(f.g.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.hdC.setTag(aVar2);
                aVar.hdC.setOnClickListener(this);
                aVar.hdC.startLoad(String.valueOf(aVar2.hef), 24, false);
                aVar.fzT.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.hdB != null && TextUtils.equals(aVar2.name, this.hdB.name)) {
                aVar.hdC.setDrawBorder(true);
            } else {
                aVar.hdC.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.hdB = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    class a {
        TextView fzT;
        TbImageView hdC;

        a() {
        }
    }
}
