package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private c jSr;
    private List<String> mDataList;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView jCo;
        public TbImageView jCp;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pic_sticker_item, (ViewGroup) null);
            aVar = new a();
            aVar.jCo = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jCp = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jCo.setGifIconSupport(false);
        aVar.jCp.setGifIconSupport(false);
        aVar.jCo.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.jCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jSr != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().nK() != null) {
                    d.this.jSr.e(tbImageView.getBdImage().nK(), false);
                }
            }
        });
        aVar.jCp.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.jCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.jSr != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().nK() != null) {
                    d.this.jSr.e(tbImageView.getBdImage().nK(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.jSr = cVar;
    }

    public void setData(List<String> list) {
        if (!v.aa(list)) {
            this.mDataList = list;
        }
    }
}
