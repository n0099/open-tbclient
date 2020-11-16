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
/* loaded from: classes22.dex */
public class b extends BaseAdapter implements View.OnClickListener {
    private List<com.baidu.tieba.video.editvideo.data.a> mList = new ArrayList();
    private com.baidu.tieba.video.editvideo.data.a noR;

    public void setData(List<com.baidu.tieba.video.editvideo.data.a> list) {
        if (list != null) {
            this.mList = list;
            if (this.mList.size() > 0) {
                this.noR = this.mList.get(0);
            }
        }
    }

    public List<com.baidu.tieba.video.editvideo.data.a> getData() {
        return this.mList;
    }

    public void a(com.baidu.tieba.video.editvideo.data.a aVar) {
        if (aVar == null) {
            if (this.mList != null) {
                this.noR = this.mList.get(0);
            }
        } else {
            this.noR = aVar;
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
            aVar.noS = (TbImageView) view.findViewById(R.id.iv_effect);
            aVar.noS.setIsRound(true);
            aVar.noS.setDrawerType(1);
            aVar.noS.setDefaultBgResource(R.color.transparent);
            aVar.noS.setBorderWidth(l.getDimens(viewGroup.getContext(), R.dimen.ds4));
            aVar.noS.setBorderColor(ap.getColor(R.color.CAM_X0302));
            aVar.noS.setConrers(15);
            aVar.lvZ = (TextView) view.findViewById(R.id.tv_name);
            ap.setViewTextColor(aVar.lvZ, R.color.CAM_X0107);
            aVar.lvZ = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i >= 0 && i < this.mList.size()) {
            com.baidu.tieba.video.editvideo.data.a aVar2 = this.mList.get(i);
            if (aVar2 != null) {
                aVar.noS.setTag(aVar2);
                aVar.noS.setOnClickListener(this);
                aVar.noS.startLoad(String.valueOf(aVar2.npq), 24, false);
                aVar.lvZ.setText(aVar2.name);
            }
            if (!TextUtils.isEmpty(aVar2.name) && this.noR != null && TextUtils.equals(aVar2.name, this.noR.name)) {
                aVar.noS.setDrawBorder(true);
            } else {
                aVar.noS.setDrawBorder(false);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_effect && (view.getTag() instanceof com.baidu.tieba.video.editvideo.data.a)) {
            this.noR = (com.baidu.tieba.video.editvideo.data.a) view.getTag();
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes22.dex */
    class a {
        TextView lvZ;
        TbImageView noS;

        a() {
        }
    }
}
