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
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a jFN;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.aa(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Cz */
    public StickerItem getItem(int i) {
        return (StickerItem) v.c(this.mDataList, i);
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
            aVar.jFR = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jFS = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jFP = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jFV = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jFQ = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jFT = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jFU = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jFR.setAutoChangeStyle(false);
        aVar.jFS.setAutoChangeStyle(false);
        aVar.jFR.setGifIconSupport(false);
        aVar.jFS.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jFP.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jFV.setVisibility(0);
                aVar.jFR.setVisibility(8);
                aVar.jFV.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jFV.setVisibility(8);
                aVar.jFR.setVisibility(0);
                aVar.jFR.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jFP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jFN != null) {
                        k.this.jFN.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jFT.setVisibility(0);
            } else {
                aVar.jFT.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.k(aVar.jFP, R.drawable.bg_select_sticker);
            } else {
                aVar.jFP.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jFP.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jFQ.setVisibility(0);
            aVar.jFS.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jFQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jFN != null) {
                        k.this.jFN.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jFU.setVisibility(0);
            } else {
                aVar.jFU.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.k(aVar.jFQ, R.drawable.bg_select_sticker);
            } else {
                aVar.jFQ.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jFQ.setVisibility(8);
        }
        return view;
    }

    public void T(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jFN = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jFP;
        public RelativeLayout jFQ;
        public TbImageView jFR;
        public TbImageView jFS;
        public ProgressBar jFT;
        public ProgressBar jFU;
        public ImageView jFV;

        public a() {
        }
    }
}
