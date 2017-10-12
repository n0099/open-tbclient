package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends BaseAdapter {
    private VideoEffectLayout.a gAI;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.u(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uF */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.gAM = (TbImageView) view.findViewById(d.h.top_sticker);
            aVar.gAN = (TbImageView) view.findViewById(d.h.bottom_sticker);
            aVar.gAK = (RelativeLayout) view.findViewById(d.h.top_container);
            aVar.gAQ = (ImageView) view.findViewById(d.h.no_sticker);
            aVar.gAL = (RelativeLayout) view.findViewById(d.h.bottom_container);
            aVar.gAO = (ProgressBar) view.findViewById(d.h.top_progressbar);
            aVar.gAP = (ProgressBar) view.findViewById(d.h.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gAM.setAutoChangeStyle(false);
        aVar.gAN.setAutoChangeStyle(false);
        aVar.gAM.setGifIconSupport(false);
        aVar.gAN.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gAK.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gAQ.setVisibility(0);
                aVar.gAM.setVisibility(8);
                aVar.gAQ.setImageResource(d.g.icon_video_sticker_no);
            } else {
                aVar.gAQ.setVisibility(8);
                aVar.gAM.setVisibility(0);
                aVar.gAM.c(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gAK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.j.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) j.this.mDataList.get(i * 2)).isSelect && j.this.gAI != null) {
                        j.this.gAI.a((StickerItem) j.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gAO.setVisibility(0);
            } else {
                aVar.gAO.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gAK, d.g.bg_select_sticker);
            } else {
                aVar.gAK.setBackgroundResource(d.e.transparent);
            }
        } else {
            aVar.gAK.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gAL.setVisibility(0);
            aVar.gAN.c(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.j.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) j.this.mDataList.get((i * 2) + 1)).isSelect && j.this.gAI != null) {
                        j.this.gAI.a((StickerItem) j.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gAP.setVisibility(0);
            } else {
                aVar.gAP.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gAL, d.g.bg_select_sticker);
            } else {
                aVar.gAL.setBackgroundResource(d.e.transparent);
            }
        } else {
            aVar.gAL.setVisibility(8);
        }
        return view;
    }

    public void p(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gAI = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gAK;
        public RelativeLayout gAL;
        public TbImageView gAM;
        public TbImageView gAN;
        public ProgressBar gAO;
        public ProgressBar gAP;
        public ImageView gAQ;

        public a() {
        }
    }
}
