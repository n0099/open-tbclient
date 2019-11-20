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
/* loaded from: classes5.dex */
public class k extends BaseAdapter {
    private VideoEffectLayout.a jEM;
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
    /* renamed from: Be */
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
            aVar.jEQ = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jER = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jEO = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jEU = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jEP = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jES = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jET = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jEQ.setAutoChangeStyle(false);
        aVar.jER.setAutoChangeStyle(false);
        aVar.jEQ.setGifIconSupport(false);
        aVar.jER.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jEO.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jEU.setVisibility(0);
                aVar.jEQ.setVisibility(8);
                aVar.jEU.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jEU.setVisibility(8);
                aVar.jEQ.setVisibility(0);
                aVar.jEQ.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jEO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jEM != null) {
                        k.this.jEM.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jES.setVisibility(0);
            } else {
                aVar.jES.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.jEO, R.drawable.bg_select_sticker);
            } else {
                aVar.jEO.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jEO.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jEP.setVisibility(0);
            aVar.jER.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jEP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jEM != null) {
                        k.this.jEM.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jET.setVisibility(0);
            } else {
                aVar.jET.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.jEP, R.drawable.bg_select_sticker);
            } else {
                aVar.jEP.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jEP.setVisibility(8);
        }
        return view;
    }

    public void aq(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jEM = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jEO;
        public RelativeLayout jEP;
        public TbImageView jEQ;
        public TbImageView jER;
        public ProgressBar jES;
        public ProgressBar jET;
        public ImageView jEU;

        public a() {
        }
    }
}
