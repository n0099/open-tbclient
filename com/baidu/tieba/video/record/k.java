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
/* loaded from: classes17.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a mCA;
    private List<StickerItem> mDataList;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Jg */
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
            aVar.mCE = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mCF = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mCC = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mCH = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mCD = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mCG = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kYH = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mCE.setAutoChangeStyle(false);
        aVar.mCF.setAutoChangeStyle(false);
        aVar.mCE.setGifIconSupport(false);
        aVar.mCF.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mCC.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mCH.setVisibility(0);
                aVar.mCE.setVisibility(8);
                aVar.mCH.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mCH.setVisibility(8);
                aVar.mCE.setVisibility(0);
                aVar.mCE.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mCC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mCA != null) {
                        k.this.mCA.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mCG.setVisibility(0);
            } else {
                aVar.mCG.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.mCC, R.drawable.bg_select_sticker);
            } else {
                aVar.mCC.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mCC.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mCD.setVisibility(0);
            aVar.mCF.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mCD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mCA != null) {
                        k.this.mCA.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kYH.setVisibility(0);
            } else {
                aVar.kYH.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.mCD, R.drawable.bg_select_sticker);
            } else {
                aVar.mCD.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mCD.setVisibility(8);
        }
        return view;
    }

    public void aK(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mCA = aVar;
    }

    /* loaded from: classes17.dex */
    public class a {
        public ProgressBar kYH;
        public RelativeLayout mCC;
        public RelativeLayout mCD;
        public TbImageView mCE;
        public TbImageView mCF;
        public ProgressBar mCG;
        public ImageView mCH;

        public a() {
        }
    }
}
