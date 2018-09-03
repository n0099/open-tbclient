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
import com.baidu.tieba.f;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class n extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.img.b aNj = new com.baidu.tbadk.img.b();
    private LinkedList<ImageFileInfo> fyR = null;
    private a fyS;
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
        this.mWidth = ((this.mScreenWidth - com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds68)) - (com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds16) * 3)) / 4;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fyR == null) {
            return 0;
        }
        return this.fyR.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.fyR == null) {
            return null;
        }
        if (this.fyR.size() - 1 >= i) {
            return this.fyR.get(i);
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void s(LinkedList<ImageFileInfo> linkedList) {
        this.fyR = linkedList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.pb_editor_imgs_item, (ViewGroup) null);
            bVar.alA = (TbImageView) view.findViewById(f.g.iv_photo_live);
            bVar.fyU = (LinearLayout) view.findViewById(f.g.layout_del);
            bVar.fyV = (ImageView) view.findViewById(f.g.delete_photo_live);
            bVar.alA.setOnClickListener(this);
            bVar.fyU.setOnClickListener(this);
            bVar.alA.setGifIconSupport(true);
            bVar.alA.setLongIconSupport(true);
            com.baidu.tbadk.core.util.am.i(bVar.fyV, f.C0146f.icon_delete_img);
            bVar.alA.setTagPaddingDis(com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds16), com.baidu.adp.lib.util.l.f(this.mContext, f.e.ds10));
            ViewGroup.LayoutParams layoutParams = bVar.alA.getLayoutParams();
            layoutParams.width = this.mWidth;
            layoutParams.height = this.mWidth;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        if (this.fyR != null && this.fyR.size() - 1 >= i) {
            ImageFileInfo imageFileInfo = this.fyR.get(i);
            if (imageFileInfo != null) {
                ImageOperation I = com.baidu.tbadk.img.effect.d.I(this.mWidth, this.mWidth);
                imageFileInfo.clearPageActions();
                imageFileInfo.addPageAction(I);
                com.baidu.adp.widget.ImageView.a a2 = this.aNj.a(imageFileInfo, true);
                bVar.alA.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    bVar.alA.invalidate();
                } else {
                    this.aNj.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.pb.pb.main.n.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView != null && aVar != null) {
                                tbImageView.invalidate();
                            }
                        }
                    }, true);
                }
                bVar.alA.setTagStr(this.mContext.getString(f.j.edit));
            }
            bVar.alA.setTag(bVar.alA.getId(), Integer.valueOf(i));
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(f.e.ds8);
            bVar.alA.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
            bVar.fyU.setTag(Integer.valueOf(i));
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f.g.layout_del && (view.getTag() instanceof Integer)) {
            if (this.fyS != null) {
                this.fyS.qA(((Integer) view.getTag()).intValue());
            }
        } else if (id == f.g.iv_photo_live && (view.getTag(view.getId()) instanceof Integer) && this.fyS != null) {
            this.fyS.qB(((Integer) view.getTag(view.getId())).intValue());
        }
    }

    public void a(a aVar) {
        this.fyS = aVar;
    }

    /* loaded from: classes2.dex */
    static class b {
        public TbImageView alA;
        public LinearLayout fyU;
        private ImageView fyV;

        b() {
        }
    }
}
