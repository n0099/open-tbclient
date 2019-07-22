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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.editortools.l;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.effect.ImageOperation;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f extends BaseAdapter {
    private com.baidu.tbadk.img.b ctb;
    private l ctl;
    private a jUl;
    private int jUm;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean jNq = false;

    /* loaded from: classes3.dex */
    public interface a {
        void Dg(int i);

        void Dn(int i);

        void cCs();
    }

    private String getString(int i) {
        return this.mContext.getResources().getString(i);
    }

    public f(Context context, com.baidu.tbadk.img.b bVar, l lVar, a aVar) {
        this.ctl = lVar;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        this.ctb = bVar;
        this.jUl = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        if (writeImagesInfo != null) {
            this.jUm = writeImagesInfo.getMaxImagesAllowed();
            int Z = v.Z(writeImagesInfo.getChosedFiles());
            this.mDataList.clear();
            if (Z > 0) {
                this.mDataList.addAll(writeImagesInfo.getChosedFiles());
            }
            if (Z < this.jUm && this.jNq) {
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
        ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        View inflate = view == null ? this.mLayoutInflater.inflate(R.layout.new_frame_editor_muti_image_item, (ViewGroup) null) : view;
        int af = (com.baidu.adp.lib.util.l.af(this.mContext) - ((com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds44) * 2) + (com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds10) * 2))) / 3;
        if (inflate.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = af;
        } else {
            layoutParams = new AbsListView.LayoutParams(af, af);
        }
        inflate.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.iv);
        tbImageView.setTagTextSize(com.baidu.adp.lib.util.l.g(this.mContext, R.dimen.tbds30));
        tbImageView.setDrawBorder(true);
        tbImageView.setDrawCorner(false);
        tbImageView.setRadius(0);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.delete_info);
        am.c((ImageView) inflate.findViewById(R.id.delete), (int) R.drawable.ic_post_image_delete_n);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            am.k(inflate, R.drawable.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (f.this.jUl != null) {
                        f.this.jUl.cCs();
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
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.cp_btn_a));
        } else {
            tbImageView.setTagColor(this.mContext.getResources().getColor(R.color.cp_btn_a));
        }
        a(imageFileInfo, inflate, viewGroup, af, af);
        if (imageFileInfo.isFromMoreForum) {
            linearLayout.setVisibility(8);
            tbImageView.setTagStr("");
        }
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) f.this.getItem(i);
                    if (!imageFileInfo2.isFromMoreForum) {
                        if (imageFileInfo2 == null) {
                            z = false;
                        } else if (imageFileInfo2.getImageType() == 1) {
                            z = true;
                        } else {
                            z = new File(imageFileInfo2.getFilePath()).exists();
                        }
                        if (!z) {
                            com.baidu.adp.lib.util.l.f(f.this.mContext, R.string.editor_mutiiamge_image_error);
                            return;
                        }
                        if (f.this.ctl != null) {
                            f.this.ctl.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                        }
                        if (f.this.jUl != null) {
                            f.this.jUl.Dn(i);
                        }
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.f.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (f.this.jUl != null) {
                    f.this.jUl.Dg(i);
                }
            }
        });
        return inflate;
    }

    private void a(ImageFileInfo imageFileInfo, View view, final ViewGroup viewGroup, int i, int i2) {
        if (imageFileInfo != null && i > 0 && i2 > 0) {
            ImageOperation al = com.baidu.tbadk.img.effect.d.al(i, i2);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(al);
            TbImageView tbImageView = (TbImageView) view.findViewById(R.id.iv);
            ((FrameLayout) view.findViewById(R.id.item_root)).setForeground(am.getDrawable(R.drawable.new_frame_add_photo_foreground_selector));
            if (imageFileInfo.getImageType() == 0) {
                com.baidu.adp.widget.ImageView.a a2 = this.ctb.a(imageFileInfo, true);
                tbImageView.setTag(imageFileInfo.toCachedKey(true));
                if (a2 != null) {
                    tbImageView.invalidate();
                } else {
                    this.ctb.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.f.4
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
                if (!aq.isEmpty(filePath) && filePath.startsWith("#(")) {
                    final String e = com.baidu.adp.lib.f.c.iE().e(filePath, 20);
                    tbImageView.setTag(e);
                    com.baidu.adp.lib.f.c.iE().a(filePath, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.f.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i3) {
                            TbImageView tbImageView2 = (TbImageView) viewGroup.findViewWithTag(e);
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

    public void sh(boolean z) {
        this.jNq = z;
    }
}
