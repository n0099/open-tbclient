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
    private VideoEffectLayout.a gTD;
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
    /* renamed from: uz */
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
            aVar.gTH = (TbImageView) view2.findViewById(d.g.top_sticker);
            aVar.gTI = (TbImageView) view2.findViewById(d.g.bottom_sticker);
            aVar.gTF = (RelativeLayout) view2.findViewById(d.g.top_container);
            aVar.gTL = (ImageView) view2.findViewById(d.g.no_sticker);
            aVar.gTG = (RelativeLayout) view2.findViewById(d.g.bottom_container);
            aVar.gTJ = (ProgressBar) view2.findViewById(d.g.top_progressbar);
            aVar.gTK = (ProgressBar) view2.findViewById(d.g.bottom_progressbar);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        aVar.gTH.setAutoChangeStyle(false);
        aVar.gTI.setAutoChangeStyle(false);
        aVar.gTH.setGifIconSupport(false);
        aVar.gTI.setGifIconSupport(false);
        if (v.c(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.gTF.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.gTL.setVisibility(0);
                aVar.gTH.setVisibility(8);
                aVar.gTL.setImageResource(d.f.icon_video_sticker_no);
            } else {
                aVar.gTL.setVisibility(8);
                aVar.gTH.setVisibility(0);
                aVar.gTH.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.gTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.gTD != null) {
                        k.this.gTD.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.gTJ.setVisibility(0);
            } else {
                aVar.gTJ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ak.i(aVar.gTF, d.f.bg_select_sticker);
            } else {
                aVar.gTF.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gTF.setVisibility(8);
        }
        if (v.c(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.gTG.setVisibility(0);
            aVar.gTI.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.gTG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.gTD != null) {
                        k.this.gTD.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.gTK.setVisibility(0);
            } else {
                aVar.gTK.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ak.i(aVar.gTG, d.f.bg_select_sticker);
            } else {
                aVar.gTG.setBackgroundResource(d.C0126d.transparent);
            }
        } else {
            aVar.gTG.setVisibility(8);
        }
        return view2;
    }

    public void q(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.gTD = aVar;
    }

    /* loaded from: classes2.dex */
    public class a {
        public RelativeLayout gTF;
        public RelativeLayout gTG;
        public TbImageView gTH;
        public TbImageView gTI;
        public ProgressBar gTJ;
        public ProgressBar gTK;
        public ImageView gTL;

        public a() {
        }
    }
}
