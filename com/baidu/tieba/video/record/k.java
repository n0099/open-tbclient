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
    private VideoEffectLayout.a kCY;
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
    /* renamed from: DL */
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
            aVar.kDc = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kDd = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kDa = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kDf = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kDb = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kDe = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jaZ = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kDc.setAutoChangeStyle(false);
        aVar.kDd.setAutoChangeStyle(false);
        aVar.kDc.setGifIconSupport(false);
        aVar.kDd.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kDa.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kDf.setVisibility(0);
                aVar.kDc.setVisibility(8);
                aVar.kDf.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kDf.setVisibility(8);
                aVar.kDc.setVisibility(0);
                aVar.kDc.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kCY != null) {
                        k.this.kCY.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kDe.setVisibility(0);
            } else {
                aVar.kDe.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kDa, R.drawable.bg_select_sticker);
            } else {
                aVar.kDa.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDa.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kDb.setVisibility(0);
            aVar.kDd.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kCY != null) {
                        k.this.kCY.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jaZ.setVisibility(0);
            } else {
                aVar.jaZ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kDb, R.drawable.bg_select_sticker);
            } else {
                aVar.kDb.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDb.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kCY = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jaZ;
        public RelativeLayout kDa;
        public RelativeLayout kDb;
        public TbImageView kDc;
        public TbImageView kDd;
        public ProgressBar kDe;
        public ImageView kDf;

        public a() {
        }
    }
}
