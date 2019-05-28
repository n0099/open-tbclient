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
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.video.editvideo.data.a jpl;
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.jpl = this.mList.get(0);
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
            aVar.jpm = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.jpm.setIsRound(true);
            aVar.jpm.setDrawerType(1);
            aVar.jpm.setDefaultBgResource(R.color.transparent);
            aVar.jpm.setBorderWidth(l.g(viewGroup.getContext(), R.dimen.ds4));
            aVar.jpm.setBorderColor(al.getColor(R.color.cp_link_tip_a));
            aVar.jpm.setConrers(15);
            aVar.hII = (TextView) view.findViewById(R.id.tv_name);
            al.j(aVar.hII, R.color.cp_cont_j);
            aVar.hII = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.jpm.setTag(aVar2);
                aVar.jpm.setOnClickListener(this);
                aVar.jpm.startLoad(String.valueOf(aVar2.jpO), 24, false);
                aVar.hII.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.jpl != null && TextUtils.equals(aVar2.name, this.jpl.name)) {
                aVar.jpm.setDrawBorder(true);
            } else {
                aVar.jpm.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.jpl = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    class a {
        TextView hII;
        TbImageView jpm;

        a() {
        }
    }
}
