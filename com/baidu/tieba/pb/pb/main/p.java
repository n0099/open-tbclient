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
/* loaded from: classes9.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b euT = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> kdU = null;
    private a kdV;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes9.dex */
    protected interface a {
        void Bg(int i);

        void Bh(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kdU == null) {
            return 0;
        }
        return this.kdU.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kdU == null) {
            return null;
        }
        if (this.kdU.size() - 1 >= i) {
            return this.kdU.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.kdU = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.dYH = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.kdX = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.kdY = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.dYH.setOnClickListener(this);
            bVar.dYH.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.dYH.setDrawBorder(true);
            bVar.dYH.setDrawCorner(false);
            bVar.dYH.setRadius(0);
            bVar.kdX.setOnClickListener(this);
            bVar.dYH.setGifIconSupport(true);
            bVar.dYH.setLongIconSupport(true);
            com.baidu.tbadk.core.util.an.setBackgroundResource(bVar.kdY, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.dYH.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.kdU != null && this.kdU.size() - 1 >= i) {
            a(this.kdU.get(i), bVar, viewGroup);
            bVar.dYH.setTag(bVar.dYH.getId(), Integer.valueOf(i));
            bVar.kdX.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation aW = com.baidu.tbadk.img.effect.d.aW(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(aW);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.euT.a(imageFileInfo, true);
                bVar.dYH.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.dYH.invalidate();
                } else {
                    this.euT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.dYH.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.ar.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.ln().genCacheKey(filePath, 20);
                    bVar.dYH.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.ln().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.p.2
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
                bVar.dYH.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.kdV != null) {
                this.kdV.Bg(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.kdV != null) {
            this.kdV.Bh(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.kdV = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class b {
        public TbImageView dYH;
        public LinearLayout kdX;
        private ImageView kdY;

        b() {
        }
    }
}
