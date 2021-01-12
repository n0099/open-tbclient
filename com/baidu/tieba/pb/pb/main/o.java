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
    private com.baidu.tbadk.img.b fAo = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> lHg = null;
    private a lHh;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void Fl(int i);

        void Fm(int i);
    }

    public o(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext);
        this.mWidth = ((this.mScreenWidth - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2)) - (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2)) / 3;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.lHg == null) {
            return 0;
        }
        return this.lHg.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.lHg == null) {
            return null;
        }
        if (this.lHg.size() - 1 >= i) {
            return this.lHg.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.lHg = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pb_editor_imgs_item, (ViewGroup) null);
            bVar.fcv = (TbImageView) view.findViewById(R.id.iv_photo_live);
            bVar.lHj = (LinearLayout) view.findViewById(R.id.layout_del);
            bVar.lHk = (ImageView) view.findViewById(R.id.delete_photo_live);
            bVar.fcv.setOnClickListener(this);
            bVar.fcv.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
            bVar.fcv.setDrawBorder(true);
            bVar.fcv.setDrawCorner(false);
            bVar.fcv.setRadius(0);
            bVar.lHj.setOnClickListener(this);
            bVar.fcv.setGifIconSupport(true);
            bVar.fcv.setLongIconSupport(true);
            com.baidu.tbadk.core.util.ao.setBackgroundResource(bVar.lHk, R.drawable.icon_delete_img);
            ViewGroup.LayoutParams layoutParams = bVar.fcv.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.lHg != null && this.lHg.size() - 1 >= i) {
            a(this.lHg.get(i), bVar, viewGroup);
            bVar.fcv.setTag(bVar.fcv.getId(), Integer.valueOf(i));
            bVar.lHj.setTag(Integer.valueOf(i));
        }
        return view;
    }

    private void a(ImageFileInfo imageFileInfo, b bVar, final ViewGroup viewGroup) {
        if (imageFileInfo != null) {
            ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fAo.a(imageFileInfo, true);
                bVar.fcv.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.fcv.invalidate();
                } else {
                    this.fAo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.o.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.fcv.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!com.baidu.tbadk.core.util.at.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(filePath, 20);
                    bVar.fcv.setTag(genCacheKey);
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
                bVar.fcv.setTagStr("");
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.layout_del && (view.getTag() instanceof Integer)) {
            if (this.lHh != null) {
                this.lHh.Fl(((Integer) view.getTag()).intValue());
            }
        } else if (id == R.id.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.lHh != null) {
            this.lHh.Fm(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.lHh = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        public TbImageView fcv;
        public LinearLayout lHj;
        private ImageView lHk;

        b() {
        }
    }
}
