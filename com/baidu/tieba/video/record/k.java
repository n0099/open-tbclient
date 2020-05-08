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
    private VideoEffectLayout.a lpz;
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
    /* renamed from: Ex */
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
            aVar.lpD = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.lpE = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.lpB = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.lpG = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.lpC = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.lpF = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jMY = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.lpD.setAutoChangeStyle(false);
        aVar.lpE.setAutoChangeStyle(false);
        aVar.lpD.setGifIconSupport(false);
        aVar.lpE.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.lpB.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.lpG.setVisibility(0);
                aVar.lpD.setVisibility(8);
                aVar.lpG.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.lpG.setVisibility(8);
                aVar.lpD.setVisibility(0);
                aVar.lpD.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.lpB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.lpz != null) {
                        k.this.lpz.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.lpF.setVisibility(0);
            } else {
                aVar.lpF.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.lpB, R.drawable.bg_select_sticker);
            } else {
                aVar.lpB.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lpB.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.lpC.setVisibility(0);
            aVar.lpE.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.lpC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.lpz != null) {
                        k.this.lpz.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jMY.setVisibility(0);
            } else {
                aVar.jMY.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.lpC, R.drawable.bg_select_sticker);
            } else {
                aVar.lpC.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.lpC.setVisibility(8);
        }
        return view;
    }

    public void aE(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.lpz = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar jMY;
        public RelativeLayout lpB;
        public RelativeLayout lpC;
        public TbImageView lpD;
        public TbImageView lpE;
        public ProgressBar lpF;
        public ImageView lpG;

        public a() {
        }
    }
}
