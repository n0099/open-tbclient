package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes8.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nSy;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KQ */
    public StickerItem getItem(int i) {
        return (StickerItem) y.getItem(this.mDataList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_sticker, (ViewGroup) null);
            aVar = new a();
            aVar.nSC = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nSD = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nSA = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nSF = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nSB = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nSE = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.mns = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nSC.setAutoChangeStyle(false);
        aVar.nSD.setAutoChangeStyle(false);
        aVar.nSC.setGifIconSupport(false);
        aVar.nSD.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nSA.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nSF.setVisibility(0);
                aVar.nSC.setVisibility(8);
                aVar.nSF.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nSF.setVisibility(8);
                aVar.nSC.setVisibility(0);
                aVar.nSC.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nSA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nSy != null) {
                        k.this.nSy.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nSE.setVisibility(0);
            } else {
                aVar.nSE.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nSA, R.drawable.bg_select_sticker);
            } else {
                aVar.nSA.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nSA.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nSB.setVisibility(0);
            aVar.nSD.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nSB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nSy != null) {
                        k.this.nSy.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.mns.setVisibility(0);
            } else {
                aVar.mns.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nSB, R.drawable.bg_select_sticker);
            } else {
                aVar.nSB.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nSB.setVisibility(8);
        }
        return view;
    }

    public void bn(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nSy = aVar;
    }

    /* loaded from: classes8.dex */
    public class a {
        public ProgressBar mns;
        public RelativeLayout nSA;
        public RelativeLayout nSB;
        public TbImageView nSC;
        public TbImageView nSD;
        public ProgressBar nSE;
        public ImageView nSF;

        public a() {
        }
    }
}
