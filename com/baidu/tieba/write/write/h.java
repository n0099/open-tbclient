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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.editortools.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class h extends BaseAdapter {
    private com.baidu.tbadk.img.b fAo;
    private n fAy;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private a ocj;
    private int ock;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean nUf = false;

    /* loaded from: classes7.dex */
    public interface a {
        void KY(int i);

        void Li(int i);

        void dXi();
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public h(Context context, com.baidu.tbadk.img.b bVar, n nVar, a aVar) {
        this.fAy = nVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.fAo = bVar;
        this.ocj = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo != null) {
            this.ock = writeImagesInfo.getMaxImagesAllowed();
            int count = x.getCount(writeImagesInfo.getChosedFiles());
            this.mDataList.clear();
            if (count > 0) {
                this.mDataList.addAll(writeImagesInfo.getChosedFiles());
            }
            if (count < this.ock && this.nUf) {
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
        ImageFileInfo imageFileInfo = (ImageFileInfo) x.getItem(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        View inflate = view == null ? this.mLayoutInflater.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
        int equipmentWidth = (l.getEquipmentWidth(this.mContext) - ((l.getDimens(this.mContext, R.dimen.tbds44) * 2) + (l.getDimens(this.mContext, R.dimen.tbds10) * 2))) / 3;
        if (inflate.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentWidth;
        } else {
            layoutParams = new AbsListView.LayoutParams(equipmentWidth, equipmentWidth);
        }
        inflate.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv);
        tbImageView.setTagTextSize(l.getDimens(this.mContext, R.dimen.T_X10));
        tbImageView.setDrawBorder(true);
        tbImageView.setDrawCorner(true);
        tbImageView.setAutoChangeStyle(true);
        tbImageView.setConrers(15);
        tbImageView.setRadiusById(R.string.J_X05);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.delete_info);
        ((ImageView) inflate.findViewById(R.id.delete)).setImageDrawable(WebPManager.a(R.drawable.icon_mask_post_image_delete16, WebPManager.ResourceStateType.NORMAL));
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            inflate.setBackgroundDrawable(WebPManager.a(R.drawable.icon_pure_post_add, WebPManager.ResourceStateType.NORMAL_PRESS));
            inflate.invalidate();
            frameLayout.setForeground(null);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (h.this.ocj != null) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 13));
                        h.this.ocj.dXi();
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
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.CAM_X0101));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.CAM_X0101));
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
                            l.showLongToast(h.this.mContext, R.string.editor_mutiiamge_image_error);
                            return;
                        }
                        if (h.this.fAy != null) {
                            h.this.fAy.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                        }
                        if (h.this.ocj != null) {
                            h.this.ocj.Li(i);
                        }
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (h.this.ocj != null) {
                    h.this.ocj.KY(i);
                }
            }
        });
        return inflate;
    }

    private void a(ImageFileInfo imageFileInfo, View view, final ViewGroup viewGroup, int i, int i2) {
        if (imageFileInfo != null && i > 0 && i2 > 0) {
            ImageOperation bg = com.baidu.tbadk.img.effect.d.bg(i, i2);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(bg);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
            ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(ao.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.fAo.a(imageFileInfo, true);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    tbImageView.invalidate();
                } else {
                    this.fAo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.h.4
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
                    final String genCacheKey = com.baidu.adp.lib.e.d.mx().genCacheKey(filePath, 20);
                    tbImageView.setTag(genCacheKey);
                    com.baidu.adp.lib.e.d.mx().a(filePath, 20, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.h.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.e.c
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

    public void zf(boolean z) {
        this.nUf = z;
    }
}
