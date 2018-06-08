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
import com.baidu.tbadk.core.util.w;
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
    private l aMA;
    private com.baidu.tbadk.img.b aMq;
    private a hvd;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean hoR = false;

    /* loaded from: classes3.dex */
    public interface a {
        void bIV();

        void vB(int i);

        void vu(int i);
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public f(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar) {
        this.aMA = lVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.aMq = bVar;
        this.hvd = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.mDataList.clear();
        int y = w.y(writeImagesInfo.getChosedFiles());
        if (writeImagesInfo != null && y > 0) {
            this.mDataList.addAll(writeImagesInfo.getChosedFiles());
        }
        if (y < 10 && this.hoR) {
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
        ImageFileInfo imageFileInfo = (ImageFileInfo) w.c(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.mLayoutInflater.inflate(d.i.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int ah = (com.baidu.adp.lib.util.l.ah(this.mContext) - ((com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds34) * 2) + (com.baidu.adp.lib.util.l.e(this.mContext, d.e.ds16) * 3))) / 4;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = ah;
            layoutParams.height = ah;
        } else {
            layoutParams = new AbsListView.LayoutParams(ah, ah);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(d.g.iv);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(d.g.delete_info);
        al.c((ImageView) view.findViewById(d.g.delete), d.f.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(d.g.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            al.i(view, d.f.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.hvd != null) {
                        f.this.hvd.bIV();
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
        tbImageView.setTagStr(getString(d.k.edit));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
        tbImageView.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i_alpha70));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        }
        if (ah > 0) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.H(ah, ah));
            frameLayout.setForeground(al.getDrawable(d.f.new_frame_add_photo_foreground_selector));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (this.aMq.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.f.2
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
                        com.baidu.adp.lib.util.l.showLongToast(f.this.mContext, d.k.editor_mutiiamge_image_error);
                        return;
                    }
                    if (f.this.aMA != null) {
                        f.this.aMA.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                    }
                    if (f.this.hvd != null) {
                        f.this.hvd.vB(i);
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.hvd != null) {
                    f.this.hvd.vu(i);
                }
            }
        });
        return view;
    }

    public void nz(boolean z) {
        this.hoR = z;
    }
}
