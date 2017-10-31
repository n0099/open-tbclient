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
public class c extends BaseAdapter {
    private com.baidu.tbadk.img.b aCk;
    private s aCu;
    private LayoutInflater gUj;
    private a gXk;
    private Context mContext;
    private List<ImageFileInfo> mDataList = new ArrayList();
    private boolean gXl = false;

    /* loaded from: classes2.dex */
    public interface a {
        void bFa();

        void vG(int i);

        void vs(int i);
    }

    public c(Context context, com.baidu.tbadk.img.b bVar, s sVar, a aVar) {
        this.aCu = sVar;
        this.mContext = context;
        this.gUj = LayoutInflater.from(this.mContext);
        this.aCk = bVar;
        this.gXk = aVar;
    }

    public void a(WriteImagesInfo writeImagesInfo) {
        this.mDataList.clear();
        int u = v.u(writeImagesInfo.getChosedFiles());
        if (writeImagesInfo != null && u > 0) {
            this.mDataList.addAll(writeImagesInfo.getChosedFiles());
        }
        if (u < 10 && this.gXl) {
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
        ImageFileInfo imageFileInfo = (ImageFileInfo) v.c(this.mDataList, i);
        if (imageFileInfo == null) {
            return null;
        }
        if (view == null) {
            view = this.gUj.inflate(d.h.new_frame_editor_muti_image_item, (ViewGroup) null);
        }
        int ac = (l.ac(this.mContext) - ((l.f(this.mContext, d.e.ds34) * 2) + (l.f(this.mContext, d.e.ds16) * 3))) / 4;
        if (view.getLayoutParams() instanceof AbsListView.LayoutParams) {
            layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            layoutParams.width = ac;
            layoutParams.height = ac;
        } else {
            layoutParams = new AbsListView.LayoutParams(ac, ac);
        }
        view.setLayoutParams(layoutParams);
        TbImageView tbImageView = (TbImageView) view.findViewById(d.g.iv);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(d.g.delete_info);
        aj.c((ImageView) view.findViewById(d.g.delete), d.f.new_frame_btn_delete_photo_selector);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(d.g.item_root);
        if ("FLAG_ADD_ICON".equals(imageFileInfo.getFilePath())) {
            tbImageView.setVisibility(8);
            linearLayout.setVisibility(8);
            aj.j(view, d.f.new_frame_btn_add_photo_selector);
            frameLayout.setForeground(null);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gXk != null) {
                        c.this.gXk.bFa();
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
        if (ac > 0) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(ac, ac));
            frameLayout.setForeground(aj.getDrawable(d.f.new_frame_add_photo_foreground_selector));
            tbImageView.setTag(imageFileInfo.toCachedKey(true));
            if (this.aCk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.write.write.c.2
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
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                boolean z;
                if (i >= 0) {
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) c.this.getItem(i);
                    if (imageFileInfo2 == null) {
                        z = false;
                    } else {
                        z = new File(imageFileInfo2.getFilePath()).exists();
                    }
                    if (!z) {
                        l.e(c.this.mContext, d.j.editor_mutiiamge_image_error);
                        return;
                    }
                    if (c.this.aCu != null) {
                        c.this.aCu.b(new com.baidu.tbadk.editortools.a(15, 0, Integer.valueOf(i)));
                    }
                    if (c.this.gXk != null) {
                        c.this.gXk.vG(i);
                    }
                }
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.gXk != null) {
                    c.this.gXk.vs(i);
                }
            }
        });
        return view;
    }

    public void nA(boolean z) {
        this.gXl = z;
    }
}
