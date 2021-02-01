package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nRY;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KQ */
    public StickerItem getItem(int i) {
        return (StickerItem) y.getItem(this.mDataList, i);
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
            aVar.nSc = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nSd = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nSa = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nSf = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nSb = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nSe = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mnd = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nSc.setAutoChangeStyle(false);
        aVar.nSd.setAutoChangeStyle(false);
        aVar.nSc.setGifIconSupport(false);
        aVar.nSd.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nSa.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nSf.setVisibility(0);
                aVar.nSc.setVisibility(8);
                aVar.nSf.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nSf.setVisibility(8);
                aVar.nSc.setVisibility(0);
                aVar.nSc.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nSa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nRY != null) {
                        k.this.nRY.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nSe.setVisibility(0);
            } else {
                aVar.nSe.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nSa, R.drawable.bg_select_sticker);
            } else {
                aVar.nSa.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nSa.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nSb.setVisibility(0);
            aVar.nSd.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nSb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nRY != null) {
                        k.this.nRY.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mnd.setVisibility(0);
            } else {
                aVar.mnd.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nSb, R.drawable.bg_select_sticker);
            } else {
                aVar.nSb.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nSb.setVisibility(8);
        }
        return view;
    }

    public void bn(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nRY = aVar;
    }

    /* loaded from: classes8.dex */
    public class a {
        public ProgressBar mnd;
        public RelativeLayout nSa;
        public RelativeLayout nSb;
        public TbImageView nSc;
        public TbImageView nSd;
        public ProgressBar nSe;
        public ImageView nSf;

        public a() {
        }
    }
}
