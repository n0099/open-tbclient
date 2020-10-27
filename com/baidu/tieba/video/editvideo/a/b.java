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
    private com.baidu.tieba.video.editvideo.data.a nhM;

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.nhM = this.mList.get(0);
            }
        }
    }

    public List<com.baidu.tieba.video.editvideo.data.a> getData() {
        return this.mList;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (aVar == null) {
            if (this.mList != null) {
                this.nhM = this.mList.get(0);
            }
        } else {
            this.nhM = aVar;
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
            aVar.nhN = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.nhN.setIsRound(true);
            aVar.nhN.setDrawerType(1);
            aVar.nhN.setDefaultBgResource(R.color.transparent);
            aVar.nhN.setBorderWidth(l.getDimens(viewGroup.getContext(), R.dimen.ds4));
            aVar.nhN.setBorderColor(ap.getColor(R.color.cp_link_tip_a));
            aVar.nhN.setConrers(15);
            aVar.lpM = (TextView) view.findViewById(R.id.tv_name);
            ap.setViewTextColor(aVar.lpM, R.color.cp_cont_j);
            aVar.lpM = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.nhN.setTag(aVar2);
                aVar.nhN.setOnClickListener(this);
                aVar.nhN.startLoad(String.valueOf(aVar2.nim), 24, false);
                aVar.lpM.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.nhM != null && TextUtils.equals(aVar2.name, this.nhM.name)) {
                aVar.nhN.setDrawBorder(true);
            } else {
                aVar.nhN.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.nhM = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes23.dex */
    class a {
        TextView lpM;
        TbImageView nhN;

        a() {
        }
    }
}
