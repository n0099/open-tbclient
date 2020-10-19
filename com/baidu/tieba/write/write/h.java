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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.editortools.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class h extends BaseAdapter {
    private com.baidu.tbadk.img.b fao;
    private n fay;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private a nwf;
    private int nwg;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean nnm = false;

    /* loaded from: classes3.dex */
    public interface a {
        void KT(int i);

        void Ld(int i);

        void dQH();
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public h(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar) {
        this.fay = nVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.fao = bVar;
        this.nwf = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo != null) {
            this.nwg = writeImagesInfo.getMaxImagesAllowed();
            int count = y.getCount(writeImagesInfo.getChosedFiles());
            this.mDataList.clear();
            if (count > 0) {
                this.mDataList.addAll(writeImagesInfo.getChosedFiles());
            }
            if (count < this.nwg && this.nnm) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath("FLAG_ADD_ICON");
                this.mDataList.add(imageFileInfo);
            }
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        AbsListView.LayoutParams layoutParams;
        ImageFileInfo imageFileInfo = (ImageFileInfo) y.getItem(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        View inflate = view == null ? this.mLayoutInflater.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
        int equipmentWidth = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) - ((com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds44) * 2) + (com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10) * 2))) / 3;
        if (inflate.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
        } else {
            layoutParams = new AbsListView.LayoutParams(equipmentWidth, equipmentWidth);
        }
        inflate.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv);
        tbImageView.setTagTextSize(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds30));
        tbImageView.setDrawBorder(true);
        tbImageView.setDrawCorner(true);
        tbImageView.setConrers(15);
        tbImageView.setRadius(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds10));
        tbImageView.setAutoChangeStyle(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.delete_info);
        ap.setImageResource((ImageView) inflate.findViewById(R.id.delete), R.drawable.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            inflate.setBackgroundDrawable(SvgManager.bmU().a(R.drawable.ic_icon_pure_post_add_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS));
            inflate.invalidate();
            frameLayout.setForeground(null);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (h.this.nwf != null) {
                        TiebaStatic.log(new aq("c12612").aj("obj_locate", 13));
                        h.this.nwf.dQH();
                    }
                }
            });
            return inflate;
        }
        tbImageView.setVisibility(0);
        linearLayout.setVisibility(0);
        inflate.setBackgroundResource(0);
        tbImageView.setGifIconSupport(true);
        tbImageView.setLongIconSupport(true);
        tbImageView.setIsLongPic(imageFileInfo.isLong());
        tbImageView.setTagStr(getString(R.string.edit));
        if (TbadkCoreApplication.getInst().getSkinType() == 1) {
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.cp_cont_a));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.cp_cont_a));
        }
        a(imageFileInfo, inflate, viewGroup, equipmentWidth, equipmentWidth);
        if (imageFileInfo.isFromMoreForum) {
            linearLayout.setVisibility(8);
            tbImageView.setTagStr("");
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) h.this.getItem(i);
                    if (!imageFileInfo2.isFromMoreForum) {
                        if (imageFileInfo2 == null) {
                            z = false;
                        } else if (imageFileInfo2.getImageType() == 1) {
                            z = true;
                        } else {
                            z = new File(imageFileInfo2.getFilePath()).exists();
                        }
                        if (!z) {
                            com.baidu.adp.lib.util.l.showLongToast(h.this.mContext, R.string.editor_mutiiamge_image_error);
                            return;
                        }
                        if (h.this.fay != null) {
                            h.this.fay.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                        }
                        if (h.this.nwf != null) {
                            h.this.nwf.Ld(i);
                        }
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.nwf != null) {
                    h.this.nwf.KT(i);
                }
            }
        });
        return inflate;
    }

    private void a(ImageFileInfo imageFileInfo, View view, final ViewGroup viewGroup, int i, int i2) {
        if (imageFileInfo != null && i > 0 && i2 > 0) {
            ImageOperation bf = com.baidu.tbadk.img.effect.d.bf(i, i2);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bf);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
            ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(ap.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fao.a(imageFileInfo, true);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    tbImageView.invalidate();
                } else {
                    this.fao.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.h.4
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                            TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(str);
                            if (tbImageView2 != null && aVar != null) {
                                tbImageView2.invalidate();
                            }
                        }
                    }, true);
                }
                tbImageView.setTagStr(this.mContext.getString(R.string.edit));
            } else if (imageFileInfo.getImageType() == 1) {
                String filePath = imageFileInfo.getFilePath();
                if (!at.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String genCacheKey = com.baidu.adp.lib.e.c.mS().genCacheKey(filePath, 20);
                    tbImageView.setTag(genCacheKey);
                    com.baidu.adp.lib.e.c.mS().a(filePath, 20, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.h.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i3) {
                            TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(genCacheKey);
                            if (tbImageView2 != null && aVar != null) {
                                tbImageView2.invalidate();
                            }
                        }
                    }, 0, 0, null, null, filePath, false, null);
                }
                tbImageView.setTagStr("");
            }
        }
    }

    public void xW(boolean z) {
        this.nnm = z;
    }
}
