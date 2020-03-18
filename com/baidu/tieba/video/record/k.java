package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a kET;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (v.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DT */
    public StickerItem getItem(int i) {
        return (StickerItem) v.getItem(this.mDataList, i);
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
            aVar.kEX = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kEY = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kEV = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kFa = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kEW = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kEZ = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jcM = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kEX.setAutoChangeStyle(false);
        aVar.kEY.setAutoChangeStyle(false);
        aVar.kEX.setGifIconSupport(false);
        aVar.kEY.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kEV.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kFa.setVisibility(0);
                aVar.kEX.setVisibility(8);
                aVar.kFa.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kFa.setVisibility(8);
                aVar.kEX.setVisibility(0);
                aVar.kEX.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kEV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kET != null) {
                        k.this.kET.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kEZ.setVisibility(0);
            } else {
                aVar.kEZ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kEV, R.drawable.bg_select_sticker);
            } else {
                aVar.kEV.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kEV.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kEW.setVisibility(0);
            aVar.kEY.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kET != null) {
                        k.this.kET.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jcM.setVisibility(0);
            } else {
                aVar.jcM.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kEW, R.drawable.bg_select_sticker);
            } else {
                aVar.kEW.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kEW.setVisibility(8);
        }
        return view;
    }

    public void av(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kET = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jcM;
        public RelativeLayout kEV;
        public RelativeLayout kEW;
        public TbImageView kEX;
        public TbImageView kEY;
        public ProgressBar kEZ;
        public ImageView kFa;

        public a() {
        }
    }
}
