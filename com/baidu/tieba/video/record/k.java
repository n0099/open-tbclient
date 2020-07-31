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
    private VideoEffectLayout.a mkw;

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
            aVar.mkA = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mkB = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mky = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mkD = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mkz = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mkC = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kIL = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mkA.setAutoChangeStyle(false);
        aVar.mkB.setAutoChangeStyle(false);
        aVar.mkA.setGifIconSupport(false);
        aVar.mkB.setGifIconSupport(false);
        if (x.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mky.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mkD.setVisibility(0);
                aVar.mkA.setVisibility(8);
                aVar.mkD.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mkD.setVisibility(8);
                aVar.mkA.setVisibility(0);
                aVar.mkA.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mkw != null) {
                        k.this.mkw.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mkC.setVisibility(0);
            } else {
                aVar.mkC.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ao.setBackgroundResource(aVar.mky, R.drawable.bg_select_sticker);
            } else {
                aVar.mky.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mky.setVisibility(8);
        }
        if (x.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mkz.setVisibility(0);
            aVar.mkB.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mkw != null) {
                        k.this.mkw.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kIL.setVisibility(0);
            } else {
                aVar.kIL.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ao.setBackgroundResource(aVar.mkz, R.drawable.bg_select_sticker);
            } else {
                aVar.mkz.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mkz.setVisibility(8);
        }
        return view;
    }

    public void aK(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mkw = aVar;
    }

    /* loaded from: classes17.dex */
    public class a {
        public ProgressBar kIL;
        public TbImageView mkA;
        public TbImageView mkB;
        public ProgressBar mkC;
        public ImageView mkD;
        public RelativeLayout mky;
        public RelativeLayout mkz;

        public a() {
        }
    }
}
