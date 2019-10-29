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
    private VideoEffectLayout.a jFD;
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
    /* renamed from: Bf */
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
            aVar.jFH = (TbImageView) view.findViewById(R.id.top_sticker);
            aVar.jFI = (TbImageView) view.findViewById(R.id.bottom_sticker);
            aVar.jFF = (RelativeLayout) view.findViewById(R.id.top_container);
            aVar.jFL = (ImageView) view.findViewById(R.id.no_sticker);
            aVar.jFG = (RelativeLayout) view.findViewById(R.id.bottom_container);
            aVar.jFJ = (ProgressBar) view.findViewById(R.id.top_progressbar);
            aVar.jFK = (ProgressBar) view.findViewById(R.id.bottom_progressbar);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.jFH.setAutoChangeStyle(false);
        aVar.jFI.setAutoChangeStyle(false);
        aVar.jFH.setGifIconSupport(false);
        aVar.jFI.setGifIconSupport(false);
        if (v.getItem(this.mDataList, i * 2) instanceof StickerItem) {
            aVar.jFF.setVisibility(0);
            if (this.mDataList.get(i * 2).id == -1) {
                aVar.jFL.setVisibility(0);
                aVar.jFH.setVisibility(8);
                aVar.jFL.setImageResource(R.drawable.icon_video_sticker_no);
            } else {
                aVar.jFL.setVisibility(8);
                aVar.jFH.setVisibility(0);
                aVar.jFH.startLoad(this.mDataList.get(i * 2).img, 10, true);
            }
            aVar.jFF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get(i * 2)).isSelect && k.this.jFD != null) {
                        k.this.jFD.a((StickerItem) k.this.mDataList.get(i * 2));
                    }
                }
            });
            if (this.mDataList.get(i * 2).isDownLoading) {
                aVar.jFJ.setVisibility(0);
            } else {
                aVar.jFJ.setVisibility(8);
            }
            if (this.mDataList.get(i * 2).isSelect) {
                am.setBackgroundResource(aVar.jFF, R.drawable.bg_select_sticker);
            } else {
                aVar.jFF.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jFF.setVisibility(8);
        }
        if (v.getItem(this.mDataList, (i * 2) + 1) instanceof StickerItem) {
            aVar.jFG.setVisibility(0);
            aVar.jFI.startLoad(this.mDataList.get((i * 2) + 1).img, 10, true);
            aVar.jFG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.video.record.k.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!((StickerItem) k.this.mDataList.get((i * 2) + 1)).isSelect && k.this.jFD != null) {
                        k.this.jFD.a((StickerItem) k.this.mDataList.get((i * 2) + 1));
                    }
                }
            });
            if (this.mDataList.get((i * 2) + 1).isDownLoading) {
                aVar.jFK.setVisibility(0);
            } else {
                aVar.jFK.setVisibility(8);
            }
            if (this.mDataList.get((i * 2) + 1).isSelect) {
                am.setBackgroundResource(aVar.jFG, R.drawable.bg_select_sticker);
            } else {
                aVar.jFG.setBackgroundResource(R.color.transparent);
            }
        } else {
            aVar.jFG.setVisibility(8);
        }
        return view;
    }

    public void aq(List<StickerItem> list) {
        this.mDataList = list;
    }

    public void a(VideoEffectLayout.a aVar) {
        this.jFD = aVar;
    }

    /* loaded from: classes5.dex */
    public class a {
        public RelativeLayout jFF;
        public RelativeLayout jFG;
        public TbImageView jFH;
        public TbImageView jFI;
        public ProgressBar jFJ;
        public ProgressBar jFK;
        public ImageView jFL;

        public a() {
        }
    }
}
