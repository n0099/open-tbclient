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
/* loaded from: classes2.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b btu = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fOD = null;
    private a fOE;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void sP(int i);

        void sQ(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.ao(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fOD == null) {
            return 0;
        }
        return this.fOD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fOD == null) {
            return null;
        }
        if (this.fOD.size() - 1 >= i) {
            return this.fOD.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void r(LinkedList<ImageFileInfo> linkedList) {
        this.fOD = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.ceW = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.fOG = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.fOH = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.ceW.setOnClickListener(this);
            bVar.fOG.setOnClickListener(this);
            bVar.ceW.setGifIconSupport(true);
            bVar.ceW.setLongIconSupport(true);
            com.baidu.tbadk.core.util.aj.s(bVar.fOH, d.f.icon_delete_img);
            bVar.ceW.setTagPaddingDis(com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.t(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.ceW.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fOD != null && this.fOD.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fOD.get(i);
            if (imageFileInfo != null) {
                ImageOperation aI = com.baidu.tbadk.img.effect.d.aI(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(aI);
                com.baidu.adp.widget.a.a a2 = this.btu.a(imageFileInfo, true);
                bVar.ceW.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.ceW.invalidate();
                } else {
                    this.btu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.ceW.setTagStr(this.mContext.getString(d.j.edit));
            }
            bVar.ceW.setTag(bVar.ceW.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.ceW.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fOG.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fOE != null) {
                this.fOE.sP(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fOE != null) {
            this.fOE.sQ(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fOE = aVar;
    }

    /* loaded from: classes2.dex */
    class b {
        public TbImageView ceW;
        public LinearLayout fOG;
        private ImageView fOH;

        b() {
        }
    }
}
