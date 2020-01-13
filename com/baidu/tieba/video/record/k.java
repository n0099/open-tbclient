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
    private VideoEffectLayout.a kBY;
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
            aVar.kCc = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kCd = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kCa = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kCf = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kCb = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kCe = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.iZt = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kCc.setAutoChangeStyle(false);
        aVar.kCd.setAutoChangeStyle(false);
        aVar.kCc.setGifIconSupport(false);
        aVar.kCd.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kCa.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kCf.setVisibility(0);
                aVar.kCc.setVisibility(8);
                aVar.kCf.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kCf.setVisibility(8);
                aVar.kCc.setVisibility(0);
                aVar.kCc.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kCa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kBY != null) {
                        k.this.kBY.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kCe.setVisibility(0);
            } else {
                aVar.kCe.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kCa, R.drawable.bg_select_sticker);
            } else {
                aVar.kCa.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kCa.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kCb.setVisibility(0);
            aVar.kCd.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kCb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kBY != null) {
                        k.this.kBY.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.iZt.setVisibility(0);
            } else {
                aVar.iZt.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kCb, R.drawable.bg_select_sticker);
            } else {
                aVar.kCb.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kCb.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kBY = aVar;
    }

    /* loaded from: classes8.dex */
    public class a {
        public ProgressBar iZt;
        public RelativeLayout kCa;
        public RelativeLayout kCb;
        public TbImageView kCc;
        public TbImageView kCd;
        public ProgressBar kCe;
        public ImageView kCf;

        public a() {
        }
    }
}
