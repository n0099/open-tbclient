package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private com.baidu.tbadk.img.b aDT;
    private l aEd;
    private a hie;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean hbS = false;

    /* loaded from: classes3.dex */
    public interface a {
        void bDS();

        void vd(int i);

        void vk(int i);
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public f(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar) {
        this.aEd = lVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.aDT = bVar;
        this.hie = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.mDataList.clear();
        int v = v.v(writeImagesInfo.getChosedFiles());
        if (writeImagesInfo != null && v > 0) {
            this.mDataList.addAll(writeImagesInfo.getChosedFiles());
        }
        if (v < 10 && this.hbS) {
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath("FLAG_ADD_ICON");
            this.mDataList.add(imageFileInfo);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mDataList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view2, final ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams;
        ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        if (view2 == null) {
            view2 = this.mLayoutInflater.inflate(d.i.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int af = (com.baidu.adp.lib.util.l.af(this.mContext) - ((com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds34) * 2) + (com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds16) * 3))) / 4;
        if (view2.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = af;
        } else {
            layoutParams = new AbsListView.LayoutParams(af, af);
        }
        view2.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view2.findViewById(d.g.iv);
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(d.g.delete_info);
        ak.c((ImageView) view2.findViewById(d.g.delete), d.f.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) view2.findViewById(d.g.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            ak.i(view2, d.f.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    if (f.this.hie != null) {
                        f.this.hie.bDS();
                    }
                }
            });
            return view2;
        }
        tbImageView.setVisibility(0);
        linearLayout.setVisibility(0);
        view2.setBackgroundResource(0);
        tbImageView.setGifIconSupport(true);
        tbImageView.setLongIconSupport(true);
        tbImageView.setIsLongPic(imageFileInfo.isLong());
        tbImageView.setTagStr(getString(d.k.edit));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
        tbImageView.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i_alpha70));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0126d.cp_cont_i));
        }
        if (af > 0) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(af, af));
            frameLayout.setForeground(ak.getDrawable(d.f.new_frame_add_photo_foreground_selector));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (this.aDT.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.f.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                    TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                    if (tbImageView2 != null && aVar != null) {
                        tbImageView2.invalidate();
                    }
                }
            }, true) != null) {
                tbImageView.invalidate();
            }
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) f.this.getItem(i);
                    if (imageFileInfo2 == null) {
                        z = false;
                    } else {
                        z = new File(imageFileInfo2.getFilePath()).exists();
                    }
                    if (!z) {
                        com.baidu.adp.lib.util.l.showLongToast(f.this.mContext, d.k.editor_mutiiamge_image_error);
                        return;
                    }
                    if (f.this.aEd != null) {
                        f.this.aEd.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                    }
                    if (f.this.hie != null) {
                        f.this.hie.vk(i);
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (f.this.hie != null) {
                    f.this.hie.vd(i);
                }
            }
        });
        return view2;
    }

    public void nq(boolean z) {
        this.hbS = z;
    }
}
