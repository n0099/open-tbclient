package com.baidu.tieba.video.record;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ImageView.BdRoundedImageView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends BaseAdapter implements View.OnClickListener {
    private String gyC;
    private VideoEffectLayout.a gyD;
    private List<d> mList;

    public void d(List<d> list, String str) {
        this.mList = list;
        this.gyC = str;
    }

    public void setListener(VideoEffectLayout.a aVar) {
        this.gyD = aVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList != null && i >= 0 && i < this.mList.size()) {
            return this.mList.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d dVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_item_effect, (ViewGroup) null);
            aVar.gyE = (BdRoundedImageView) view.findViewById(d.h.iv_effect);
            aVar.gkg = (TextView) view.findViewById(d.h.tv_name);
            aj.i(aVar.gkg, d.e.cp_cont_j);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (this.mList != null && i >= 0 && i <= this.mList.size() - 1 && (dVar = this.mList.get(i)) != null) {
            aVar.gyE.setImageResource(dVar.bwN());
            aVar.gyE.setTag(dVar);
            aVar.gyE.setOnClickListener(this);
            aVar.gkg.setText(dVar.getName());
            if (!TextUtils.isEmpty(dVar.getName()) && dVar.getName().equals(this.gyC)) {
                aVar.gyE.setBackgroundResource(d.g.bg_effect_item);
            } else {
                aVar.gyE.setBackgroundResource(0);
            }
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.h.iv_effect && (view.getTag() instanceof d)) {
            d dVar = (d) view.getTag();
            this.gyC = dVar.getName();
            notifyDataSetChanged();
            if (this.gyD != null) {
                this.gyD.a(dVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    class a {
        TextView gkg;
        BdRoundedImageView gyE;

        a() {
        }
    }
}
