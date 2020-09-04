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
    private com.baidu.tbadk.img.b eLP = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> kCj = null;
    private a kCk;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes16.dex */
    protected interface a {
        void DZ(int i);

        void Ea(int i);
    }

    public r(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kCj == null) {
            return 0;
        }
        return this.kCj.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kCj == null) {
            return null;
        }
        if (this.kCj.size() - 1 >= i) {
            return this.kCj.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.kCj = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.eoz = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.kCm = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.kCn = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.eoz.setOnClickListener(this);
            bVar.eoz.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.eoz.setDrawBorder(true);
            bVar.eoz.setDrawCorner(false);
            bVar.eoz.setRadius(0);
            bVar.kCm.setOnClickListener(this);
            bVar.eoz.setGifIconSupport(true);
            bVar.eoz.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(bVar.kCn, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.eoz.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.kCj != null && this.kCj.size() - 1 >= i) {
            a(this.kCj.get(i), bVar, viewGroup);
            bVar.eoz.setTag(bVar.eoz.getId(), Integer.valueOf(i));
            bVar.kCm.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.eLP.a(imageFileInfo, true);
                bVar.eoz.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.eoz.invalidate();
                } else {
                    this.eLP.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.eoz.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.at.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.mM().genCacheKey(filePath, 20);
                    bVar.eoz.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.mM().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.r.2
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
                bVar.eoz.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.kCk != null) {
                this.kCk.DZ(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.kCk != null) {
            this.kCk.Ea(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.kCk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class b {
        public TbImageView eoz;
        public LinearLayout kCm;
        private ImageView kCn;

        b() {
        }
    }
}
