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
    private com.baidu.tbadk.img.b fCD = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> lQp = null;
    private a lQq;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void FE(int i);

        void FF(int i);
    }

    public o(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lQp == null) {
            return 0;
        }
        return this.lQp.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lQp == null) {
            return null;
        }
        if (this.lQp.size() - 1 >= i) {
            return this.lQp.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.lQp = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.feK = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.lQs = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.lQt = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.feK.setOnClickListener(this);
            bVar.feK.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.feK.setDrawBorder(true);
            bVar.feK.setDrawCorner(false);
            bVar.feK.setRadius(0);
            bVar.lQs.setOnClickListener(this);
            bVar.feK.setGifIconSupport(true);
            bVar.feK.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(bVar.lQt, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.feK.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.lQp != null && this.lQp.size() - 1 >= i) {
            a(this.lQp.get(i), bVar, viewGroup);
            bVar.feK.setTag(bVar.feK.getId(), Integer.valueOf(i));
            bVar.lQs.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bd = com.baidu.tbadk.img.effect.d.bd(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bd);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fCD.a(imageFileInfo, true);
                bVar.feK.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.feK.invalidate();
                } else {
                    this.fCD.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.o.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.feK.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.au.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.d.mw().genCacheKey(filePath, 20);
                    bVar.feK.setTag(genCacheKey);
                    com.baidu.adp.lib.e.d.mw().a(filePath, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.o.2
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
                bVar.feK.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.lQq != null) {
                this.lQq.FE(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.lQq != null) {
            this.lQq.FF(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.lQq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        public TbImageView feK;
        public LinearLayout lQs;
        private ImageView lQt;

        b() {
        }
    }
}
