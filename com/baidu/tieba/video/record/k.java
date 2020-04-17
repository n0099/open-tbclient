package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a lpv;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ex */
    public StickerItem getItem(int i) {
        return (StickerItem) v.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.lpz = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.lpA = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.lpx = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.lpC = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.lpy = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.lpB = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jMU = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lpz.setAutoChangeStyle(false);
        aVar.lpA.setAutoChangeStyle(false);
        aVar.lpz.setGifIconSupport(false);
        aVar.lpA.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.lpx.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.lpC.setVisibility(0);
                aVar.lpz.setVisibility(8);
                aVar.lpC.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.lpC.setVisibility(8);
                aVar.lpz.setVisibility(0);
                aVar.lpz.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.lpx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.lpv != null) {
                        k.this.lpv.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.lpB.setVisibility(0);
            } else {
                aVar.lpB.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.lpx, R.drawable.bg_select_sticker);
            } else {
                aVar.lpx.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lpx.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.lpy.setVisibility(0);
            aVar.lpA.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.lpy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.lpv != null) {
                        k.this.lpv.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jMU.setVisibility(0);
            } else {
                aVar.jMU.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.lpy, R.drawable.bg_select_sticker);
            } else {
                aVar.lpy.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lpy.setVisibility(8);
        }
        return view;
    }

    public void aE(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.lpv = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jMU;
        public TbImageView lpA;
        public ProgressBar lpB;
        public ImageView lpC;
        public RelativeLayout lpx;
        public RelativeLayout lpy;
        public TbImageView lpz;

        public a() {
        }
    }
}
