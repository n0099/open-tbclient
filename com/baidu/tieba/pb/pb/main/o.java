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
/* loaded from: classes2.dex */
public class o extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b fEW = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> lLK = null;
    private a lLL;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void GR(int i);

        void GS(int i);
    }

    public o(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lLK == null) {
            return 0;
        }
        return this.lLK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lLK == null) {
            return null;
        }
        if (this.lLK.size() - 1 >= i) {
            return this.lLK.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.lLK = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.fhd = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.lLN = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.lLO = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.fhd.setOnClickListener(this);
            bVar.fhd.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.fhd.setDrawBorder(true);
            bVar.fhd.setDrawCorner(false);
            bVar.fhd.setRadius(0);
            bVar.lLN.setOnClickListener(this);
            bVar.fhd.setGifIconSupport(true);
            bVar.fhd.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(bVar.lLO, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.fhd.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.lLK != null && this.lLK.size() - 1 >= i) {
            a(this.lLK.get(i), bVar, viewGroup);
            bVar.fhd.setTag(bVar.fhd.getId(), Integer.valueOf(i));
            bVar.lLN.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fEW.a(imageFileInfo, true);
                bVar.fhd.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.fhd.invalidate();
                } else {
                    this.fEW.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.o.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.fhd.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.at.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(filePath, 20);
                    bVar.fhd.setTag(genCacheKey);
                    com.baidu.adp.lib.e.d.mx().a(filePath, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.o.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(genCacheKey);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                bVar.fhd.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.lLL != null) {
                this.lLL.GR(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.lLL != null) {
            this.lLL.GS(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.lLL = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        public TbImageView fhd;
        public LinearLayout lLN;
        private ImageView lLO;

        b() {
        }
    }
}
