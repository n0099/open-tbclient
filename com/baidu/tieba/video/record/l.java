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
public class l extends BaseAdapter {
    private VideoEffectLayout.a hvB;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.E(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wY */
    public StickerItem getItem(int i) {
        return (StickerItem) v.f(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.hvF = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hvG = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hvD = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hvJ = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hvE = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hvH = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hvI = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hvF.setAutoChangeStyle(false);
        aVar.hvG.setAutoChangeStyle(false);
        aVar.hvF.setGifIconSupport(false);
        aVar.hvG.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hvD.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hvJ.setVisibility(0);
                aVar.hvF.setVisibility(8);
                aVar.hvJ.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hvJ.setVisibility(8);
                aVar.hvF.setVisibility(0);
                aVar.hvF.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hvB != null) {
                        l.this.hvB.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hvH.setVisibility(0);
            } else {
                aVar.hvH.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hvD, d.f.bg_select_sticker);
            } else {
                aVar.hvD.setBackgroundResource(d.C0107d.transparent);
            }
        } else {
            aVar.hvD.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hvE.setVisibility(0);
            aVar.hvG.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hvE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hvB != null) {
                        l.this.hvB.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hvI.setVisibility(0);
            } else {
                aVar.hvI.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hvE, d.f.bg_select_sticker);
            } else {
                aVar.hvE.setBackgroundResource(d.C0107d.transparent);
            }
        } else {
            aVar.hvE.setVisibility(8);
        }
        return view;
    }

    public void A(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hvB = aVar;
    }

    public void bDr() {
        if (this.mDataList != null) {
            for (StickerItem stickerItem : this.mDataList) {
                if (stickerItem.id == -1) {
                    stickerItem.isSelect = true;
                } else {
                    stickerItem.isSelect = false;
                    stickerItem.isDownLoading = false;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hvD;
        public RelativeLayout hvE;
        public TbImageView hvF;
        public TbImageView hvG;
        public ProgressBar hvH;
        public ProgressBar hvI;
        public ImageView hvJ;

        public a() {
        }
    }
}
