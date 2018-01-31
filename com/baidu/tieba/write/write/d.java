package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private c hIV;
    private List<String> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) v.f(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.hvZ = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hwa = (TbImageView) view.findViewById(d.g.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hvZ.setGifIconSupport(false);
        aVar.hwa.setGifIconSupport(false);
        aVar.hvZ.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.hvZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hIV != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().sj() != null) {
                    d.this.hIV.d(tbImageView.getBdImage().sj(), false);
                }
            }
        });
        aVar.hwa.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.hwa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.hIV != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().sj() != null) {
                    d.this.hIV.d(tbImageView.getBdImage().sj(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.hIV = cVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public TbImageView hvZ;
        public TbImageView hwa;

        public a() {
        }
    }

    public void setData(List<String> list) {
        if (!v.E(list)) {
            this.mDataList = list;
        }
    }
}
