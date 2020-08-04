package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes17.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a mky;

    @Override // android.widget.Adapter
    public int getCount() {
        if (x.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: GK */
    public StickerItem getItem(int i) {
        return (StickerItem) x.getItem(this.mDataList, i);
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
            aVar.mkC = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mkD = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mkA = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mkF = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mkB = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mkE = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kIN = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mkC.setAutoChangeStyle(false);
        aVar.mkD.setAutoChangeStyle(false);
        aVar.mkC.setGifIconSupport(false);
        aVar.mkD.setGifIconSupport(false);
        if (x.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mkA.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mkF.setVisibility(0);
                aVar.mkC.setVisibility(8);
                aVar.mkF.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mkF.setVisibility(8);
                aVar.mkC.setVisibility(0);
                aVar.mkC.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mkA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mky != null) {
                        k.this.mky.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mkE.setVisibility(0);
            } else {
                aVar.mkE.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ao.setBackgroundResource(aVar.mkA, R.drawable.bg_select_sticker);
            } else {
                aVar.mkA.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mkA.setVisibility(8);
        }
        if (x.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mkB.setVisibility(0);
            aVar.mkD.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mkB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mky != null) {
                        k.this.mky.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kIN.setVisibility(0);
            } else {
                aVar.kIN.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ao.setBackgroundResource(aVar.mkB, R.drawable.bg_select_sticker);
            } else {
                aVar.mkB.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mkB.setVisibility(8);
        }
        return view;
    }

    public void aK(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mky = aVar;
    }

    /* loaded from: classes17.dex */
    public class a {
        public ProgressBar kIN;
        public RelativeLayout mkA;
        public RelativeLayout mkB;
        public TbImageView mkC;
        public TbImageView mkD;
        public ProgressBar mkE;
        public ImageView mkF;

        public a() {
        }
    }
}
