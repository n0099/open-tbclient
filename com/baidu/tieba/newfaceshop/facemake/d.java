package com.baidu.tieba.newfaceshop.facemake;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import java.util.List;
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private a lsT;
    private List<FaceData> mList;
    private Context mContext = BdBaseApplication.getInst().getApp();
    private com.baidu.tbadk.img.b fwp = new com.baidu.tbadk.img.b();
    private int mScreenWidth = l.getEquipmentWidth(this.mContext);
    private int mWidth = (this.mScreenWidth - (l.getDimens(this.mContext, R.dimen.ds30) * 3)) / 4;

    /* loaded from: classes8.dex */
    public interface a {
        void a(FaceData faceData);

        void onAdd();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    public void a(a aVar) {
        this.lsT = aVar;
    }

    public d(List<FaceData> list) {
        this.mList = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            b bVar2 = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_make_face, (ViewGroup) null);
            bVar2.ap(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        FaceData faceData = this.mList.get(i);
        if (faceData != null) {
            if (faceData.type == 4) {
                ao.setImageResource(bVar.fcv, R.drawable.emotion_icon_add_pic);
                bVar.lsW.setVisibility(8);
            } else if (faceData.type == 1) {
                bVar.fcv.setImageDrawable(null);
                a(faceData.emotionImageData, viewGroup, bVar);
            } else if (faceData.type == 2) {
                bVar.fcv.setImageDrawable(null);
                a(faceData.emotionImageData, bVar);
            } else {
                bVar.fcv.setImageDrawable(null);
                a(faceData.imageFileInfo, viewGroup, bVar);
            }
            bVar.fcv.setTag(bVar.fcv.getId(), faceData);
        }
        bVar.lsW.setTag(faceData);
        return view;
    }

    private void a(EmotionImageData emotionImageData, b bVar) {
        if (emotionImageData != null) {
            bVar.fcv.setTag(emotionImageData.getThumbUrl());
            bVar.fcv.startLoad(emotionImageData.getThumbUrl(), 10, false);
            bVar.lsW.setVisibility(0);
        }
    }

    private void a(EmotionImageData emotionImageData, final ViewGroup viewGroup, final b bVar) {
        if (emotionImageData != null) {
            Object a2 = com.baidu.adp.lib.e.d.mx().a(emotionImageData.getThumbUrl(), 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.newfaceshop.facemake.d.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    View findViewWithTag;
                    if (aVar != null && (findViewWithTag = viewGroup.findViewWithTag(str)) != null && (findViewWithTag instanceof TbImageView) && str != null) {
                        aVar.drawImageTo(bVar.fcv);
                    }
                }
            }, 0, 0, null, null, emotionImageData.getThumbUrl(), false, null);
            com.baidu.adp.widget.ImageView.a aVar = (a2 == null || !(a2 instanceof com.baidu.adp.widget.ImageView.a)) ? null : (com.baidu.adp.widget.ImageView.a) a2;
            if (aVar != null) {
                aVar.drawImageTo(bVar.fcv);
                bVar.fcv.setTag(null);
            }
            bVar.lsW.setVisibility(0);
        }
    }

    private void a(ImageFileInfo imageFileInfo, final ViewGroup viewGroup, b bVar) {
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth));
            com.baidu.adp.widget.ImageView.a a2 = this.fwp.a(imageFileInfo, false);
            bVar.fcv.setTag(imageFileInfo.toCachedKey(false));
            if (a2 != null) {
                a2.drawImageTo(bVar.fcv);
                bVar.fcv.setTag(null);
            } else {
                this.fwp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.d.2
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                        TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                        if (tbImageView != null && aVar != null) {
                            aVar.drawImageTo(tbImageView);
                        }
                    }
                }, false, false);
            }
            bVar.lsW.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public class b {
        public TbImageView fcv;
        public ImageView lsW;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ap(View view) {
            this.fcv = (TbImageView) view.findViewById(R.id.image);
            this.lsW = (ImageView) view.findViewById(R.id.delete_icon);
            ViewGroup.LayoutParams layoutParams = this.fcv.getLayoutParams();
            layoutParams.width = d.this.mWidth;
            layoutParams.height = d.this.mWidth;
            ao.setImageResource(this.lsW, R.drawable.icon_live_close_n);
            this.fcv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.d.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.lsT != null && view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof FaceData) && ((FaceData) view2.getTag(view2.getId())).type == 4) {
                        d.this.lsT.onAdd();
                    }
                }
            });
            this.lsW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.d.b.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (d.this.lsT != null && view2.getTag() != null && (view2.getTag() instanceof FaceData)) {
                        d.this.lsT.a((FaceData) view2.getTag());
                    }
                }
            });
        }
    }
}
