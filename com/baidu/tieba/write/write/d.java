package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends BaseAdapter {
    private c lYw;
    private List<String> mDataList;

    /* loaded from: classes2.dex */
    public static class a {
        public TbImageView lJq;
        public TbImageView lJr;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) v.getItem(this.mDataList, i);
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
            aVar.lJq = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.lJr = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lJq.setGifIconSupport(false);
        aVar.lJr.setGifIconSupport(false);
        aVar.lJq.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.lJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.lYw != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().getRawBitmap() != null) {
                    d.this.lYw.d(tbImageView.getBdImage().getRawBitmap(), false);
                }
            }
        });
        aVar.lJr.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.lJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (d.this.lYw != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().getRawBitmap() != null) {
                    d.this.lYw.d(tbImageView.getBdImage().getRawBitmap(), true);
                }
            }
        });
        return view;
    }

    public void b(c cVar) {
        this.lYw = cVar;
    }

    public void setData(List<String> list) {
        if (!v.isEmpty(list)) {
            this.mDataList = list;
        }
    }
}
