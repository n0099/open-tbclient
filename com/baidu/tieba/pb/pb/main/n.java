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
    private com.baidu.tbadk.img.b aVS = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fPD = null;
    private a fPE;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes6.dex */
    protected interface a {
        void rQ(int i);

        void rR(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.aO(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds68)) - (com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fPD == null) {
            return 0;
        }
        return this.fPD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fPD == null) {
            return null;
        }
        if (this.fPD.size() - 1 >= i) {
            return this.fPD.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.fPD = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.atK = (TbImageView) view.findViewById(e.g.iv_photo_live);
            bVar.fPG = (LinearLayout) view.findViewById(e.g.layout_del);
            bVar.fPH = (ImageView) view.findViewById(e.g.delete_photo_live);
            bVar.atK.setOnClickListener(this);
            bVar.fPG.setOnClickListener(this);
            bVar.atK.setGifIconSupport(true);
            bVar.atK.setLongIconSupport(true);
            com.baidu.tbadk.core.util.al.i(bVar.fPH, e.f.icon_delete_img);
            bVar.atK.setTagPaddingDis(com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds16), com.baidu.adp.lib.util.l.h(this.mContext, e.C0200e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.atK.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fPD != null && this.fPD.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fPD.get(i);
            if (imageFileInfo != null) {
                ImageOperation K = com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(K);
                com.baidu.adp.widget.ImageView.a a2 = this.aVS.a(imageFileInfo, true);
                bVar.atK.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.atK.invalidate();
                } else {
                    this.aVS.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.atK.setTagStr(this.mContext.getString(e.j.edit));
            }
            bVar.atK.setTag(bVar.atK.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds8);
            bVar.atK.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fPG.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == e.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fPE != null) {
                this.fPE.rQ(((Integer) view.getTag()).intValue());
            }
        } else if (id == e.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fPE != null) {
            this.fPE.rR(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fPE = aVar;
    }

    /* loaded from: classes6.dex */
    static class b {
        public TbImageView atK;
        public LinearLayout fPG;
        private ImageView fPH;

        b() {
        }
    }
}
