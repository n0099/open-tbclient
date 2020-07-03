package com.baidu.tieba.video.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.record.VideoEffectLayout;
import java.util.List;
/* loaded from: classes10.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a mdd;

    @Override // android.widget.Adapter
    public int getCount() {
        if (w.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Go */
    public StickerItem getItem(int i) {
        return (StickerItem) w.getItem(this.mDataList, i);
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
            aVar.mdh = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.mdi = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.mdf = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.mdk = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.mdg = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.mdj = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.kzJ = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.mdh.setAutoChangeStyle(false);
        aVar.mdi.setAutoChangeStyle(false);
        aVar.mdh.setGifIconSupport(false);
        aVar.mdi.setGifIconSupport(false);
        if (w.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.mdf.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.mdk.setVisibility(0);
                aVar.mdh.setVisibility(8);
                aVar.mdk.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.mdk.setVisibility(8);
                aVar.mdh.setVisibility(0);
                aVar.mdh.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.mdf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.mdd != null) {
                        k.this.mdd.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.mdj.setVisibility(0);
            } else {
                aVar.mdj.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                an.setBackgroundResource(aVar.mdf, R.drawable.bg_select_sticker);
            } else {
                aVar.mdf.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mdf.setVisibility(8);
        }
        if (w.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.mdg.setVisibility(0);
            aVar.mdi.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.mdg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.mdd != null) {
                        k.this.mdd.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.kzJ.setVisibility(0);
            } else {
                aVar.kzJ.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                an.setBackgroundResource(aVar.mdg, R.drawable.bg_select_sticker);
            } else {
                aVar.mdg.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.mdg.setVisibility(8);
        }
        return view;
    }

    public void aD(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.mdd = aVar;
    }

    /* loaded from: classes10.dex */
    public class a {
        public ProgressBar kzJ;
        public RelativeLayout mdf;
        public RelativeLayout mdg;
        public TbImageView mdh;
        public TbImageView mdi;
        public ProgressBar mdj;
        public ImageView mdk;

        public a() {
        }
    }
}
