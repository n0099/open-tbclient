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
    private VideoEffectLayout.a hvV;
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
            aVar.hvZ = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hwa = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hvX = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hwd = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hvY = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hwb = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hwc = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hvZ.setAutoChangeStyle(false);
        aVar.hwa.setAutoChangeStyle(false);
        aVar.hvZ.setGifIconSupport(false);
        aVar.hwa.setGifIconSupport(false);
        if (v.f(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hvX.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hwd.setVisibility(0);
                aVar.hvZ.setVisibility(8);
                aVar.hwd.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hwd.setVisibility(8);
                aVar.hvZ.setVisibility(0);
                aVar.hvZ.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hvX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.hvV != null) {
                        l.this.hvV.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hwb.setVisibility(0);
            } else {
                aVar.hwb.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.s(aVar.hvX, d.f.bg_select_sticker);
            } else {
                aVar.hvX.setBackgroundResource(d.C0108d.transparent);
            }
        } else {
            aVar.hvX.setVisibility(8);
        }
        if (v.f(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hvY.setVisibility(0);
            aVar.hwa.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.hvV != null) {
                        l.this.hvV.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hwc.setVisibility(0);
            } else {
                aVar.hwc.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.s(aVar.hvY, d.f.bg_select_sticker);
            } else {
                aVar.hvY.setBackgroundResource(d.C0108d.transparent);
            }
        } else {
            aVar.hvY.setVisibility(8);
        }
        return view;
    }

    public void A(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hvV = aVar;
    }

    public void bDt() {
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
        public RelativeLayout hvX;
        public RelativeLayout hvY;
        public TbImageView hvZ;
        public TbImageView hwa;
        public ProgressBar hwb;
        public ProgressBar hwc;
        public ImageView hwd;

        public a() {
        }
    }
}
