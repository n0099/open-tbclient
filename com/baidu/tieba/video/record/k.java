package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a hkz;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.z(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uT */
    public StickerItem getItem(int i) {
        return (StickerItem) w.d(this.mDataList, i);
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
            aVar.hkD = (TbImageView) view.findViewById(d.g.top_sticker);
            aVar.hkE = (TbImageView) view.findViewById(d.g.bottom_sticker);
            aVar.hkB = (RelativeLayout) view.findViewById(d.g.top_container);
            aVar.hkH = (ImageView) view.findViewById(d.g.no_sticker);
            aVar.hkC = (RelativeLayout) view.findViewById(d.g.bottom_container);
            aVar.hkF = (ProgressBar) view.findViewById(d.g.top_progressbar);
            aVar.hkG = (ProgressBar) view.findViewById(d.g.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hkD.setAutoChangeStyle(false);
        aVar.hkE.setAutoChangeStyle(false);
        aVar.hkD.setGifIconSupport(false);
        aVar.hkE.setGifIconSupport(false);
        if (w.d(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.hkB.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.hkH.setVisibility(0);
                aVar.hkD.setVisibility(8);
                aVar.hkH.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.hkH.setVisibility(8);
                aVar.hkD.setVisibility(0);
                aVar.hkD.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.hkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.hkz != null) {
                        k.this.hkz.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.hkF.setVisibility(0);
            } else {
                aVar.hkF.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.i(aVar.hkB, d.f.bg_select_sticker);
            } else {
                aVar.hkB.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            aVar.hkB.setVisibility(8);
        }
        if (w.d(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.hkC.setVisibility(0);
            aVar.hkE.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.hkC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.hkz != null) {
                        k.this.hkz.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.hkG.setVisibility(0);
            } else {
                aVar.hkG.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.i(aVar.hkC, d.f.bg_select_sticker);
            } else {
                aVar.hkC.setBackgroundResource(d.C0140d.transparent);
            }
        } else {
            aVar.hkC.setVisibility(8);
        }
        return view;
    }

    public void t(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.hkz = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout hkB;
        public RelativeLayout hkC;
        public TbImageView hkD;
        public TbImageView hkE;
        public ProgressBar hkF;
        public ProgressBar hkG;
        public ImageView hkH;

        public a() {
        }
    }
}
