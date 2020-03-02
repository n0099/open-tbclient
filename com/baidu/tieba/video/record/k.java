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
    private VideoEffectLayout.a kDa;
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
            aVar.kDe = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kDf = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kDc = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kDh = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kDd = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kDg = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jbb = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kDe.setAutoChangeStyle(false);
        aVar.kDf.setAutoChangeStyle(false);
        aVar.kDe.setGifIconSupport(false);
        aVar.kDf.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kDc.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kDh.setVisibility(0);
                aVar.kDe.setVisibility(8);
                aVar.kDh.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kDh.setVisibility(8);
                aVar.kDe.setVisibility(0);
                aVar.kDe.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kDa != null) {
                        k.this.kDa.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kDg.setVisibility(0);
            } else {
                aVar.kDg.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kDc, R.drawable.bg_select_sticker);
            } else {
                aVar.kDc.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDc.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kDd.setVisibility(0);
            aVar.kDf.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kDa != null) {
                        k.this.kDa.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jbb.setVisibility(0);
            } else {
                aVar.jbb.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kDd, R.drawable.bg_select_sticker);
            } else {
                aVar.kDd.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kDd.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kDa = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jbb;
        public RelativeLayout kDc;
        public RelativeLayout kDd;
        public TbImageView kDe;
        public TbImageView kDf;
        public ProgressBar kDg;
        public ImageView kDh;

        public a() {
        }
    }
}
