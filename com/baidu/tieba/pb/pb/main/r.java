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
/* loaded from: classes21.dex */
public class r extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b eOh = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> kKH = null;
    private a kKI;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes21.dex */
    protected interface a {
        void EA(int i);

        void EB(int i);
    }

    public r(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.kKH == null) {
            return 0;
        }
        return this.kKH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.kKH == null) {
            return null;
        }
        if (this.kKH.size() - 1 >= i) {
            return this.kKH.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.kKH = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.eqP = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.kKK = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.kKL = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.eqP.setOnClickListener(this);
            bVar.eqP.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.eqP.setDrawBorder(true);
            bVar.eqP.setDrawCorner(false);
            bVar.eqP.setRadius(0);
            bVar.kKK.setOnClickListener(this);
            bVar.eqP.setGifIconSupport(true);
            bVar.eqP.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ap.setBackgroundResource(bVar.kKL, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.eqP.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.kKH != null && this.kKH.size() - 1 >= i) {
            a(this.kKH.get(i), bVar, viewGroup);
            bVar.eqP.setTag(bVar.eqP.getId(), Integer.valueOf(i));
            bVar.kKK.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.eOh.a(imageFileInfo, true);
                bVar.eqP.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.eqP.invalidate();
                } else {
                    this.eOh.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.r.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.eqP.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.at.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.mR().genCacheKey(filePath, 20);
                    bVar.eqP.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.mR().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.pb.pb.main.r.2
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
                bVar.eqP.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.kKI != null) {
                this.kKI.EA(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.kKI != null) {
            this.kKI.EB(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.kKI = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class b {
        public TbImageView eqP;
        public LinearLayout kKK;
        private ImageView kKL;

        b() {
        }
    }
}
