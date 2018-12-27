package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hLK;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.I(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wT */
    public StickerItem getItem(int i) {
        return (StickerItem) v.d(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.hLO = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hLP = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hLM = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hLS = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hLN = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hLQ = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hLR = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hLO.setAutoChangeStyle(false);
        aVar.hLP.setAutoChangeStyle(false);
        aVar.hLO.setGifIconSupport(false);
        aVar.hLP.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hLM.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hLS.setVisibility(0);
                aVar.hLO.setVisibility(8);
                aVar.hLS.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hLS.setVisibility(8);
                aVar.hLO.setVisibility(0);
                aVar.hLO.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hLM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hLK != null) {
                        k.this.hLK.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hLQ.setVisibility(0);
            } else {
                aVar.hLQ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hLM, e.f.bg_select_sticker);
            } else {
                aVar.hLM.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hLM.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hLN.setVisibility(0);
            aVar.hLP.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hLN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hLK != null) {
                        k.this.hLK.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hLR.setVisibility(0);
            } else {
                aVar.hLR.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hLN, e.f.bg_select_sticker);
            } else {
                aVar.hLN.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hLN.setVisibility(8);
        }
        return view;
    }

    public void C(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hLK = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hLM;
        public RelativeLayout hLN;
        public TbImageView hLO;
        public TbImageView hLP;
        public ProgressBar hLQ;
        public ProgressBar hLR;
        public ImageView hLS;

        public a() {
        }
    }
}
