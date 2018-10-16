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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private com.baidu.tbadk.img.b aVc;
    private l aVm;
    private a hQf;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean hJs = false;

    /* loaded from: classes3.dex */
    public interface a {
        void bOp();

        void wG(int i);

        void wz(int i);
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public f(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar) {
        this.aVm = lVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.aVc = bVar;
        this.hQf = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.mDataList.clear();
        int I = v.I(writeImagesInfo.getChosedFiles());
        if (writeImagesInfo != null && I > 0) {
            this.mDataList.addAll(writeImagesInfo.getChosedFiles());
        }
        if (I < 10 && this.hJs) {
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
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams;
        ImageFileInfo imageFileInfo = (ImageFileInfo) v.d(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.mLayoutInflater.inflate(e.h.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int aO = (com.baidu.adp.lib.util.l.aO(this.mContext) - ((com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds34) * 2) + (com.baidu.adp.lib.util.l.h(this.mContext, e.C0175e.ds16) * 3))) / 4;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = aO;
            layoutParams.height = aO;
        } else {
            layoutParams = new AbsListView.LayoutParams(aO, aO);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(e.g.iv);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(e.g.delete_info);
        al.c((ImageView) view.findViewById(e.g.delete), e.f.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(e.g.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            al.i(view, e.f.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.hQf != null) {
                        f.this.hQf.bOp();
                    }
                }
            });
            return view;
        }
        tbImageView.setVisibility(0);
        linearLayout.setVisibility(0);
        view.setBackgroundResource(0);
        tbImageView.setGifIconSupport(true);
        tbImageView.setLongIconSupport(true);
        tbImageView.setIsLongPic(imageFileInfo.isLong());
        tbImageView.setTagStr(getString(e.j.edit));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds8);
        tbImageView.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            tbImageView.setTagColor(this.mContext.getResources().getColor(e.d.cp_cont_i_alpha70));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(e.d.cp_cont_i));
        }
        if (aO > 0) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(aO, aO));
            frameLayout.setForeground(al.getDrawable(e.f.new_frame_add_photo_foreground_selector));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (this.aVc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.f.2
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) f.this.getItem(i);
                    if (imageFileInfo2 == null) {
                        z = false;
                    } else {
                        z = new File(imageFileInfo2.getFilePath()).exists();
                    }
                    if (!z) {
                        com.baidu.adp.lib.util.l.g(f.this.mContext, e.j.editor_mutiiamge_image_error);
                        return;
                    }
                    if (f.this.aVm != null) {
                        f.this.aVm.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                    }
                    if (f.this.hQf != null) {
                        f.this.hQf.wG(i);
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.hQf != null) {
                    f.this.hQf.wz(i);
                }
            }
        });
        return view;
    }

    public void oi(boolean z) {
        this.hJs = z;
    }
}
