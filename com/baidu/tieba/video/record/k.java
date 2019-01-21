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
    private VideoEffectLayout.a hMS;
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
    /* renamed from: wW */
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
            aVar.hMW = (TbImageView) view.findViewById(e.g.top_sticker);
            aVar.hMX = (TbImageView) view.findViewById(e.g.bottom_sticker);
            aVar.hMU = (RelativeLayout) view.findViewById(e.g.top_container);
            aVar.hNa = (ImageView) view.findViewById(e.g.no_sticker);
            aVar.hMV = (RelativeLayout) view.findViewById(e.g.bottom_container);
            aVar.hMY = (ProgressBar) view.findViewById(e.g.top_progressbar);
            aVar.hMZ = (ProgressBar) view.findViewById(e.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hMW.setAutoChangeStyle(false);
        aVar.hMX.setAutoChangeStyle(false);
        aVar.hMW.setGifIconSupport(false);
        aVar.hMX.setGifIconSupport(false);
        if (v.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hMU.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hNa.setVisibility(0);
                aVar.hMW.setVisibility(8);
                aVar.hNa.setImageResource(e.f.icon_video_sticker_no);
            } else {
                aVar.hNa.setVisibility(8);
                aVar.hMW.setVisibility(0);
                aVar.hMW.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hMU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hMS != null) {
                        k.this.hMS.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hMY.setVisibility(0);
            } else {
                aVar.hMY.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                al.i(aVar.hMU, e.f.bg_select_sticker);
            } else {
                aVar.hMU.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hMU.setVisibility(8);
        }
        if (v.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hMV.setVisibility(0);
            aVar.hMX.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hMV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hMS != null) {
                        k.this.hMS.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hMZ.setVisibility(0);
            } else {
                aVar.hMZ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                al.i(aVar.hMV, e.f.bg_select_sticker);
            } else {
                aVar.hMV.setBackgroundResource(e.d.transparent);
            }
        } else {
            aVar.hMV.setVisibility(8);
        }
        return view;
    }

    public void C(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hMS = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout hMU;
        public RelativeLayout hMV;
        public TbImageView hMW;
        public TbImageView hMX;
        public ProgressBar hMY;
        public ProgressBar hMZ;
        public ImageView hNa;

        public a() {
        }
    }
}
