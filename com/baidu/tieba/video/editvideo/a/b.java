package com.baidu.tieba.video.editvideo.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();
    private com.baidu.tieba.video.editvideo.data.a mVm;

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.mVm = this.mList.get(0);
            }
        }
    }

    public List<com.baidu.tieba.video.editvideo.data.a> getData() {
        return this.mList;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (aVar == null) {
            if (this.mList != null) {
                this.mVm = this.mList.get(0);
            }
        } else {
            this.mVm = aVar;
        }
        notifyDataSetChanged();
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
            aVar.mVn = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.mVn.setIsRound(true);
            aVar.mVn.setDrawerType(1);
            aVar.mVn.setDefaultBgResource(R.color.transparent);
            aVar.mVn.setBorderWidth(l.getDimens(viewGroup.getContext(), R.dimen.ds4));
            aVar.mVn.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            aVar.mVn.setConrers(15);
            aVar.ldj = (TextView) view.findViewById(R.id.tv_name);
            ap.setViewTextColor(aVar.ldj, R.color.cp_cont_j);
            aVar.ldj = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.mVn.setTag(aVar2);
                aVar.mVn.setOnClickListener(this);
                aVar.mVn.startLoad(String.valueOf(aVar2.mVL), 24, false);
                aVar.ldj.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.mVm != null && TextUtils.equals(aVar2.name, this.mVm.name)) {
                aVar.mVn.setDrawBorder(true);
            } else {
                aVar.mVn.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.mVm = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes23.dex */
    class a {
        TextView ldj;
        TbImageView mVn;

        a() {
        }
    }
}
