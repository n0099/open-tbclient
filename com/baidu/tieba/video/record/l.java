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
    private VideoEffectLayout.a gYV;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.w(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vG */
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.gYZ = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.gZa = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.gYX = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.gZd = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.gYY = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.gZb = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.gZc = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.gYZ.setAutoChangeStyle(false);
        aVar.gZa.setAutoChangeStyle(false);
        aVar.gYZ.setGifIconSupport(false);
        aVar.gZa.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gYX.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gZd.setVisibility(0);
                aVar.gYZ.setVisibility(8);
                aVar.gZd.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gZd.setVisibility(8);
                aVar.gYZ.setVisibility(0);
                aVar.gYZ.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get(i * 2)).isSelect && l.this.gYV != null) {
                        l.this.gYV.a((StickerItem) l.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gZb.setVisibility(0);
            } else {
                aVar.gZb.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                aj.j(aVar.gYX, d.f.bg_select_sticker);
            } else {
                aVar.gYX.setBackgroundResource(d.C0095d.transparent);
            }
        } else {
            aVar.gYX.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gYY.setVisibility(0);
            aVar.gZa.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gYY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.l.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) l.this.mDataList.get((i * 2) + 1)).isSelect && l.this.gYV != null) {
                        l.this.gYV.a((StickerItem) l.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gZc.setVisibility(0);
            } else {
                aVar.gZc.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                aj.j(aVar.gYY, d.f.bg_select_sticker);
            } else {
                aVar.gYY.setBackgroundResource(d.C0095d.transparent);
            }
        } else {
            aVar.gYY.setVisibility(8);
        }
        return view;
    }

    public void r(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gYV = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gYX;
        public RelativeLayout gYY;
        public TbImageView gYZ;
        public TbImageView gZa;
        public ProgressBar gZb;
        public ProgressBar gZc;
        public ImageView gZd;

        public a() {
        }
    }
}
