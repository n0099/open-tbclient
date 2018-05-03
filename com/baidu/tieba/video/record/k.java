package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a gSz;
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
    /* renamed from: uA */
    public StickerItem getItem(int i) {
        return (StickerItem) v.c(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.gSD = (TbImageView) view2.findViewById(d.g.top_sticker);
            aVar.gSE = (TbImageView) view2.findViewById(d.g.bottom_sticker);
            aVar.gSB = (RelativeLayout) view2.findViewById(d.g.top_container);
            aVar.gSH = (ImageView) view2.findViewById(d.g.no_sticker);
            aVar.gSC = (RelativeLayout) view2.findViewById(d.g.bottom_container);
            aVar.gSF = (ProgressBar) view2.findViewById(d.g.top_progressbar);
            aVar.gSG = (ProgressBar) view2.findViewById(d.g.bottom_progressbar);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.gSD.setAutoChangeStyle(false);
        aVar.gSE.setAutoChangeStyle(false);
        aVar.gSD.setGifIconSupport(false);
        aVar.gSE.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gSB.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gSH.setVisibility(0);
                aVar.gSD.setVisibility(8);
                aVar.gSH.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gSH.setVisibility(8);
                aVar.gSD.setVisibility(0);
                aVar.gSD.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.gSz != null) {
                        k.this.gSz.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gSF.setVisibility(0);
            } else {
                aVar.gSF.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ak.i(aVar.gSB, d.f.bg_select_sticker);
            } else {
                aVar.gSB.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gSB.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gSC.setVisibility(0);
            aVar.gSE.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gSC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.gSz != null) {
                        k.this.gSz.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gSG.setVisibility(0);
            } else {
                aVar.gSG.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ak.i(aVar.gSC, d.f.bg_select_sticker);
            } else {
                aVar.gSC.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gSC.setVisibility(8);
        }
        return view2;
    }

    public void q(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gSz = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gSB;
        public RelativeLayout gSC;
        public TbImageView gSD;
        public TbImageView gSE;
        public ProgressBar gSF;
        public ProgressBar gSG;
        public ImageView gSH;

        public a() {
        }
    }
}
