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
/* loaded from: classes8.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a kCd;
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
    /* renamed from: DF */
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
            aVar.kCh = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kCi = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kCf = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kCk = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kCg = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kCj = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.iZy = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kCh.setAutoChangeStyle(false);
        aVar.kCi.setAutoChangeStyle(false);
        aVar.kCh.setGifIconSupport(false);
        aVar.kCi.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kCf.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kCk.setVisibility(0);
                aVar.kCh.setVisibility(8);
                aVar.kCk.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kCk.setVisibility(8);
                aVar.kCh.setVisibility(0);
                aVar.kCh.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kCf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kCd != null) {
                        k.this.kCd.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kCj.setVisibility(0);
            } else {
                aVar.kCj.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kCf, R.drawable.bg_select_sticker);
            } else {
                aVar.kCf.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kCf.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kCg.setVisibility(0);
            aVar.kCi.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kCd != null) {
                        k.this.kCd.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.iZy.setVisibility(0);
            } else {
                aVar.iZy.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kCg, R.drawable.bg_select_sticker);
            } else {
                aVar.kCg.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kCg.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kCd = aVar;
    }

    /* loaded from: classes8.dex */
    public class a {
        public ProgressBar iZy;
        public RelativeLayout kCf;
        public RelativeLayout kCg;
        public TbImageView kCh;
        public TbImageView kCi;
        public ProgressBar kCj;
        public ImageView kCk;

        public a() {
        }
    }
}
