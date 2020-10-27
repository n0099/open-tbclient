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
    private VideoEffectLayout.a nov;

    @Override // android.widget.Adapter
    public int getCount() {
        if (y.isEmpty(this.mDataList)) {
            return 0;
        }
        return (int) Math.ceil(this.mDataList.size() / 2.0d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: KI */
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
            aVar.noA = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.noB = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.noy = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.noD = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.noz = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.noC = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.lJc = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.noA.setAutoChangeStyle(false);
        aVar.noB.setAutoChangeStyle(false);
        aVar.noA.setGifIconSupport(false);
        aVar.noB.setGifIconSupport(false);
        if (y.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.noy.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.noD.setVisibility(0);
                aVar.noA.setVisibility(8);
                aVar.noD.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.noD.setVisibility(8);
                aVar.noA.setVisibility(0);
                aVar.noA.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.noy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.nov != null) {
                        k.this.nov.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.noC.setVisibility(0);
            } else {
                aVar.noC.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                ap.setBackgroundResource(aVar.noy, R.drawable.bg_select_sticker);
            } else {
                aVar.noy.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.noy.setVisibility(8);
        }
        if (y.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.noz.setVisibility(0);
            aVar.noB.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.noz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.nov != null) {
                        k.this.nov.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.lJc.setVisibility(0);
            } else {
                aVar.lJc.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                ap.setBackgroundResource(aVar.noz, R.drawable.bg_select_sticker);
            } else {
                aVar.noz.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.noz.setVisibility(8);
        }
        return view;
    }

    public void bb(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.nov = aVar;
    }

    /* loaded from: classes23.dex */
    public class a {
        public ProgressBar lJc;
        public TbImageView noA;
        public TbImageView noB;
        public ProgressBar noC;
        public ImageView noD;
        public RelativeLayout noy;
        public RelativeLayout noz;

        public a() {
        }
    }
}
