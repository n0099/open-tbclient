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
/* loaded from: classes23.dex */
public class k extends BaseAdapter {
    private List<StickerItem> mDataList;
    private VideoEffectLayout.a nur;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KV */
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
            aVar.nuv = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.nuw = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.nut = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.nuy = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.nuu = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.nux = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.lOY = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.nuv.setAutoChangeStyle(false);
        aVar.nuw.setAutoChangeStyle(false);
        aVar.nuv.setGifIconSupport(false);
        aVar.nuw.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.nut.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.nuy.setVisibility(0);
                aVar.nuv.setVisibility(8);
                aVar.nuy.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.nuy.setVisibility(8);
                aVar.nuv.setVisibility(0);
                aVar.nuv.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.nut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nur != null) {
                        k.this.nur.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.nux.setVisibility(0);
            } else {
                aVar.nux.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.nut, R.drawable.bg_select_sticker);
            } else {
                aVar.nut.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nut.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.nuu.setVisibility(0);
            aVar.nuw.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.nuu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nur != null) {
                        k.this.nur.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.lOY.setVisibility(0);
            } else {
                aVar.lOY.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.nuu, R.drawable.bg_select_sticker);
            } else {
                aVar.nuu.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.nuu.setVisibility(8);
        }
        return view;
    }

    public void bi(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nur = aVar;
    }

    /* loaded from: classes23.dex */
    public class a {
        public ProgressBar lOY;
        public RelativeLayout nut;
        public RelativeLayout nuu;
        public TbImageView nuv;
        public TbImageView nuw;
        public ProgressBar nux;
        public ImageView nuy;

        public a() {
        }
    }
}
