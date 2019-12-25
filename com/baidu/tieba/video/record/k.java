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
/* loaded from: classes7.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a kyw;
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
    /* renamed from: Dz */
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
            aVar.kyA = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.kyB = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.kyy = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.kyD = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.kyz = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.kyC = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.iVQ = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kyA.setAutoChangeStyle(false);
        aVar.kyB.setAutoChangeStyle(false);
        aVar.kyA.setGifIconSupport(false);
        aVar.kyB.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.kyy.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.kyD.setVisibility(0);
                aVar.kyA.setVisibility(8);
                aVar.kyD.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.kyD.setVisibility(8);
                aVar.kyA.setVisibility(0);
                aVar.kyA.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.kyy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.kyw != null) {
                        k.this.kyw.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.kyC.setVisibility(0);
            } else {
                aVar.kyC.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.kyy, R.drawable.bg_select_sticker);
            } else {
                aVar.kyy.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kyy.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.kyz.setVisibility(0);
            aVar.kyB.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.kyz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.kyw != null) {
                        k.this.kyw.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.iVQ.setVisibility(0);
            } else {
                aVar.iVQ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.kyz, R.drawable.bg_select_sticker);
            } else {
                aVar.kyz.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.kyz.setVisibility(8);
        }
        return view;
    }

    public void aw(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.kyw = aVar;
    }

    /* loaded from: classes7.dex */
    public class a {
        public ProgressBar iVQ;
        public TbImageView kyA;
        public TbImageView kyB;
        public ProgressBar kyC;
        public ImageView kyD;
        public RelativeLayout kyy;
        public RelativeLayout kyz;

        public a() {
        }
    }
}
