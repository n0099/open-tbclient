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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.s;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends BaseAdapter {
    private s btE;
    private com.baidu.tbadk.img.b btu;
    private a hMq;
    private LayoutInflater kh;
    private Context mContext;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean hFq = false;

    /* loaded from: classes2.dex */
    public interface a {
        void bJe();

        void xO(int i);

        void xz(int i);
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public e(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar) {
        this.btE = sVar;
        this.mContext = context;
        this.kh = LayoutInflater.from(this.mContext);
        this.btu = bVar;
        this.hMq = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.mDataList.clear();
        int D = v.D(writeImagesInfo.getChosedFiles());
        if (writeImagesInfo != null && D > 0) {
            this.mDataList.addAll(writeImagesInfo.getChosedFiles());
        }
        if (D < 10 && this.hFq) {
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
        ImageFileInfo imageFileInfo = (ImageFileInfo) v.f(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.kh.inflate(d.h.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int ao = (l.ao(this.mContext) - ((l.t(this.mContext, d.e.ds34) * 2) + (l.t(this.mContext, d.e.ds16) * 3))) / 4;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = ao;
            layoutParams.height = ao;
        } else {
            layoutParams = new AbsListView.LayoutParams(ao, ao);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(d.g.iv);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(d.g.delete_info);
        aj.c((ImageView) view.findViewById(d.g.delete), d.f.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(d.g.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            aj.s(view, d.f.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.hMq != null) {
                        e.this.hMq.bJe();
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
        tbImageView.setTagStr(getString(d.j.edit));
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds8);
        tbImageView.setTagPaddingDis(dimensionPixelSize, dimensionPixelSize);
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i_alpha70));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(d.C0141d.cp_cont_i));
        }
        if (ao > 0) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.aI(ao, ao));
            frameLayout.setForeground(aj.getDrawable(d.f.new_frame_add_photo_foreground_selector));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (this.btu.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.e.2
                @Override // com.baidu.tbadk.imageManager.b
                public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
                    TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                    if (tbImageView2 != null && aVar != null) {
                        tbImageView2.invalidate();
                    }
                }
            }, true) != null) {
                tbImageView.invalidate();
            }
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) e.this.getItem(i);
                    if (imageFileInfo2 == null) {
                        z = false;
                    } else {
                        z = new File(imageFileInfo2.getFilePath()).exists();
                    }
                    if (!z) {
                        l.s(e.this.mContext, d.j.editor_mutiiamge_image_error);
                        return;
                    }
                    if (e.this.btE != null) {
                        e.this.btE.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                    }
                    if (e.this.hMq != null) {
                        e.this.hMq.xO(i);
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.e.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (e.this.hMq != null) {
                    e.this.hMq.xz(i);
                }
            }
        });
        return view;
    }

    public void nM(boolean z) {
        this.hFq = z;
    }
}
