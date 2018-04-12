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
    private VideoEffectLayout.a gSC;
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
    /* renamed from: uB */
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
            aVar.gSG = (TbImageView) view2.findViewById(d.g.top_sticker);
            aVar.gSH = (TbImageView) view2.findViewById(d.g.bottom_sticker);
            aVar.gSE = (RelativeLayout) view2.findViewById(d.g.top_container);
            aVar.gSK = (ImageView) view2.findViewById(d.g.no_sticker);
            aVar.gSF = (RelativeLayout) view2.findViewById(d.g.bottom_container);
            aVar.gSI = (ProgressBar) view2.findViewById(d.g.top_progressbar);
            aVar.gSJ = (ProgressBar) view2.findViewById(d.g.bottom_progressbar);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.gSG.setAutoChangeStyle(false);
        aVar.gSH.setAutoChangeStyle(false);
        aVar.gSG.setGifIconSupport(false);
        aVar.gSH.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gSE.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gSK.setVisibility(0);
                aVar.gSG.setVisibility(8);
                aVar.gSK.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gSK.setVisibility(8);
                aVar.gSG.setVisibility(0);
                aVar.gSG.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gSE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.gSC != null) {
                        k.this.gSC.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gSI.setVisibility(0);
            } else {
                aVar.gSI.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ak.i(aVar.gSE, d.f.bg_select_sticker);
            } else {
                aVar.gSE.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gSE.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gSF.setVisibility(0);
            aVar.gSH.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gSF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.gSC != null) {
                        k.this.gSC.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gSJ.setVisibility(0);
            } else {
                aVar.gSJ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ak.i(aVar.gSF, d.f.bg_select_sticker);
            } else {
                aVar.gSF.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gSF.setVisibility(8);
        }
        return view2;
    }

    public void q(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gSC = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gSE;
        public RelativeLayout gSF;
        public TbImageView gSG;
        public TbImageView gSH;
        public ProgressBar gSI;
        public ProgressBar gSJ;
        public ImageView gSK;

        public a() {
        }
    }
}
