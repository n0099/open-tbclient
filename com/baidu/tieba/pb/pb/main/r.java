package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes16.dex */
public class r extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b eBm = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> kmI = null;
    private a kmJ;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes16.dex */
    protected interface a {
        void BF(int i);

        void BG(int i);
    }

    public r(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kmI == null) {
            return 0;
        }
        return this.kmI.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kmI == null) {
            return null;
        }
        if (this.kmI.size() - 1 >= i) {
            return this.kmI.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.kmI = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.eeU = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.kmL = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.kmM = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.eeU.setOnClickListener(this);
            bVar.eeU.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.eeU.setDrawBorder(true);
            bVar.eeU.setDrawCorner(false);
            bVar.eeU.setRadius(0);
            bVar.kmL.setOnClickListener(this);
            bVar.eeU.setGifIconSupport(true);
            bVar.eeU.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(bVar.kmM, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.eeU.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.kmI != null && this.kmI.size() - 1 >= i) {
            a(this.kmI.get(i), bVar, viewGroup);
            bVar.eeU.setTag(bVar.eeU.getId(), Integer.valueOf(i));
            bVar.kmL.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation aX = com.baidu.tbadk.img.effect.d.aX(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(aX);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.eBm.a(imageFileInfo, true);
                bVar.eeU.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.eeU.invalidate();
                } else {
                    this.eBm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.eeU.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.as.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.ln().genCacheKey(filePath, 20);
                    bVar.eeU.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.ln().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.r.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(genCacheKey);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                bVar.eeU.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.kmJ != null) {
                this.kmJ.BF(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.kmJ != null) {
            this.kmJ.BG(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.kmJ = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class b {
        public TbImageView eeU;
        public LinearLayout kmL;
        private ImageView kmM;

        b() {
        }
    }
}
