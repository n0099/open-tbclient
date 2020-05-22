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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a lBx;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.lBx = this.mList.get(0);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_filter, (ViewGroup) null);
            aVar.lBy = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.lBy.setIsRound(true);
            aVar.lBy.setDrawerType(1);
            aVar.lBy.setDefaultBgResource(R.color.transparent);
            aVar.lBy.setBorderWidth(l.getDimens(viewGroup.getContext(), R.dimen.ds4));
            aVar.lBy.setBorderColor(am.getColor(R.color.cp_link_tip_a));
            aVar.lBy.setConrers(15);
            aVar.jMo = (TextView) view.findViewById(R.id.tv_name);
            am.setViewTextColor(aVar.jMo, (int) R.color.cp_cont_j);
            aVar.jMo = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.lBy.setTag(aVar2);
                aVar.lBy.setOnClickListener(this);
                aVar.lBy.startLoad(String.valueOf(aVar2.lBX), 24, false);
                aVar.jMo.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.lBx != null && TextUtils.equals(aVar2.name, this.lBx.name)) {
                aVar.lBy.setDrawBorder(true);
            } else {
                aVar.lBy.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.lBx = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes10.dex */
    class a {
        TextView jMo;
        TbImageView lBy;

        a() {
        }
    }
}
