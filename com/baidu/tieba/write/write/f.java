package com.baidu.tieba.write.write;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private List<String> mDataList;
    private e ntG;

    /* loaded from: classes3.dex */
    public static class a {
        public TbImageView nbY;
        public TbImageView nbZ;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    public String getItem(int i) {
        return (String) y.getItem(this.mDataList, i);
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
            aVar.nbY = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nbZ = (TbImageView) view.findViewById(R.id.bottom_sticker);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nbY.setGifIconSupport(false);
        aVar.nbZ.setGifIconSupport(false);
        aVar.nbY.startLoad(this.mDataList.get(i * 2), 10, true);
        aVar.nbY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (f.this.ntG != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().getRawBitmap() != null) {
                    f.this.ntG.d(tbImageView.getBdImage().getRawBitmap(), false);
                }
            }
        });
        aVar.nbZ.startLoad(this.mDataList.get((i * 2) + 1), 10, true);
        aVar.nbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TbImageView tbImageView = (TbImageView) view2;
                if (f.this.ntG != null && tbImageView != null && tbImageView.getBdImage() != null && tbImageView.getBdImage().getRawBitmap() != null) {
                    f.this.ntG.d(tbImageView.getBdImage().getRawBitmap(), true);
                }
            }
        });
        return view;
    }

    public void b(e eVar) {
        this.ntG = eVar;
    }

    public void setData(List<String> list) {
        if (!y.isEmpty(list)) {
            this.mDataList = list;
        }
    }
}
