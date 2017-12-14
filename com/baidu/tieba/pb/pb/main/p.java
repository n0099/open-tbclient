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
import com.baidu.tieba.d;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aDa = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> eWE = null;
    private a eWF;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes.dex */
    protected interface a {
        void pY(int i);

        void pZ(int i);
    }

    public p(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.ac(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eWE == null) {
            return 0;
        }
        return this.eWE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.eWE == null) {
            return null;
        }
        if (this.eWE.size() - 1 >= i) {
            return this.eWE.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void p(LinkedList<ImageFileInfo> linkedList) {
        this.eWE = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.eni = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.eWH = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.eWI = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.eni.setOnClickListener(this);
            bVar.eWH.setOnClickListener(this);
            bVar.eni.setGifIconSupport(true);
            bVar.eni.setLongIconSupport(true);
            com.baidu.tbadk.core.util.aj.j(bVar.eWI, d.f.icon_delete_img);
            bVar.eni.setTagPaddingDis(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.eni.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.eWE != null && this.eWE.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.eWE.get(i);
            if (imageFileInfo != null) {
                ImageOperation J = com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(J);
                com.baidu.adp.widget.a.a a2 = this.aDa.a(imageFileInfo, true);
                bVar.eni.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.eni.invalidate();
                } else {
                    this.aDa.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.p.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.eni.setTagStr(this.mContext.getString(d.j.edit));
            }
            bVar.eni.setTag(bVar.eni.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.eni.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.eWH.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.eWF != null) {
                this.eWF.pY(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.eWF != null) {
            this.eWF.pZ(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.eWF = aVar;
    }

    /* loaded from: classes.dex */
    class b {
        public LinearLayout eWH;
        private ImageView eWI;
        public TbImageView eni;

        b() {
        }
    }
}
