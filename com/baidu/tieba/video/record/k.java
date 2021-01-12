package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes7.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nIq;

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Kw */
    public StickerItem getItem(int i) {
        return (StickerItem) x.getItem(this.mDataList, i);
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
            aVar.nIu = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nIv = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nIs = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nIx = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nIt = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nIw = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mea = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nIu.setAutoChangeStyle(false);
        aVar.nIv.setAutoChangeStyle(false);
        aVar.nIu.setGifIconSupport(false);
        aVar.nIv.setGifIconSupport(false);
        if (x.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nIs.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nIx.setVisibility(0);
                aVar.nIu.setVisibility(8);
                aVar.nIx.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nIx.setVisibility(8);
                aVar.nIu.setVisibility(0);
                aVar.nIu.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nIs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nIq != null) {
                        k.this.nIq.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nIw.setVisibility(0);
            } else {
                aVar.nIw.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ao.setBackgroundResource(aVar.nIs, R.drawable.bg_select_sticker);
            } else {
                aVar.nIs.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nIs.setVisibility(8);
        }
        if (x.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nIt.setVisibility(0);
            aVar.nIv.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nIt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nIq != null) {
                        k.this.nIq.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mea.setVisibility(0);
            } else {
                aVar.mea.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ao.setBackgroundResource(aVar.nIt, R.drawable.bg_select_sticker);
            } else {
                aVar.nIt.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nIt.setVisibility(8);
        }
        return view;
    }

    public void bs(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nIq = aVar;
    }

    /* loaded from: classes7.dex */
    public class a {
        public ProgressBar mea;
        public RelativeLayout nIs;
        public RelativeLayout nIt;
        public TbImageView nIu;
        public TbImageView nIv;
        public ProgressBar nIw;
        public ImageView nIx;

        public a() {
        }
    }
}
