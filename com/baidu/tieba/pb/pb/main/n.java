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
import com.baidu.tieba.e;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aVc = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fOe = null;
    private a fOf;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes6.dex */
    protected interface a {
        void rx(int i);

        void ry(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds68)) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fOe == null) {
            return 0;
        }
        return this.fOe.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fOe == null) {
            return null;
        }
        if (this.fOe.size() - 1 >= i) {
            return this.fOe.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.fOe = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.asX = (TbImageView) view.findViewById(e.g.iv_photo_live);
            bVar.fOh = (LinearLayout) view.findViewById(e.g.layout_del);
            bVar.fOi = (ImageView) view.findViewById(e.g.delete_photo_live);
            bVar.asX.setOnClickListener(this);
            bVar.fOh.setOnClickListener(this);
            bVar.asX.setGifIconSupport(true);
            bVar.asX.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.i(bVar.fOi, e.f.icon_delete_img);
            bVar.asX.setTagPaddingDis(com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds16), com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.asX.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fOe != null && this.fOe.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fOe.get(i);
            if (imageFileInfo != null) {
                ImageOperation K = com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(K);
                com.baidu.adp.widget.ImageView.a a2 = this.aVc.a(imageFileInfo, true);
                bVar.asX.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.asX.invalidate();
                } else {
                    this.aVc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.asX.setTagStr(this.mContext.getString(e.j.edit));
            }
            bVar.asX.setTag(bVar.asX.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8);
            bVar.asX.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fOh.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fOf != null) {
                this.fOf.rx(((Integer) view.getTag()).intValue());
            }
        } else if (id == e.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fOf != null) {
            this.fOf.ry(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fOf = aVar;
    }

    /* loaded from: classes6.dex */
    static class b {
        public TbImageView asX;
        public LinearLayout fOh;
        private ImageView fOi;

        b() {
        }
    }
}
