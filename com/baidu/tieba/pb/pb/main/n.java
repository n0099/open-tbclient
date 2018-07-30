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
    private com.baidu.tbadk.img.b aNm = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fyY = null;
    private a fyZ;
    private Context mContext;
    private int mScreenWidth;
    private int mWidth;

    /* loaded from: classes2.dex */
    protected interface a {
        void qA(int i);

        void qB(int i);
    }

    public n(Context context) {
        this.mContext = null;
        this.mContext = context;
        this.mScreenWidth = com.baidu.adp.lib.util.l.ah(this.mContext);
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds68)) - (com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyY == null) {
            return 0;
        }
        return this.fyY.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fyY == null) {
            return null;
        }
        if (this.fyY.size() - 1 >= i) {
            return this.fyY.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.fyY = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.alB = (TbImageView) view.findViewById(d.g.iv_photo_live);
            bVar.fzb = (LinearLayout) view.findViewById(d.g.layout_del);
            bVar.fzc = (ImageView) view.findViewById(d.g.delete_photo_live);
            bVar.alB.setOnClickListener(this);
            bVar.fzb.setOnClickListener(this);
            bVar.alB.setGifIconSupport(true);
            bVar.alB.setLongIconSupport(true);
            com.baidu.tbadk.core.util.am.i(bVar.fzc, d.f.icon_delete_img);
            bVar.alB.setTagPaddingDis(com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds16), com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.alB.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fyY != null && this.fyY.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fyY.get(i);
            if (imageFileInfo != null) {
                ImageOperation I = com.baidu.tbadk.img.effect.d.I(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(I);
                com.baidu.adp.widget.ImageView.a a2 = this.aNm.a(imageFileInfo, true);
                bVar.alB.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.alB.invalidate();
                } else {
                    this.aNm.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.alB.setTagStr(this.mContext.getString(d.j.edit));
            }
            bVar.alB.setTag(bVar.alB.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
            bVar.alB.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fzb.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fyZ != null) {
                this.fyZ.qA(((Integer) view.getTag()).intValue());
            }
        } else if (id == d.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fyZ != null) {
            this.fyZ.qB(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fyZ = aVar;
    }

    /* loaded from: classes2.dex */
    static class b {
        public TbImageView alB;
        public LinearLayout fzb;
        private ImageView fzc;

        b() {
        }
    }
}
