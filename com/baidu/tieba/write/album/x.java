package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class x extends BaseAdapter {
    private com.baidu.tbadk.img.b amg;
    private AlbumActivity djW;
    private l dkV;
    private boolean dkW;
    private boolean dkX;
    private v dkY;
    private u dkZ;
    private w dla;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public x(AlbumActivity albumActivity, l lVar) {
        this.djW = albumActivity;
        this.amg = albumActivity.aBf();
        this.dkV = lVar;
        this.mWidth = (int) this.djW.getResources().getDimension(i.d.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.dkW = z;
        notifyDataSetChanged();
    }

    public int h(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mList == null || this.mList.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return -1;
            }
            ImageFileInfo imageFileInfo2 = this.mList.get(i2);
            if (imageFileInfo2 == null || imageFileInfo2.getFilePath() == null || !imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lI */
    public ImageFileInfo getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.dkW && i == 0) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            bVar = new b(this, null);
            if (itemViewType == 0) {
                view = LayoutInflater.from(this.djW.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view, viewGroup, false);
                bVar.dlh = (HeadImageView) view.findViewById(i.f.pic);
                bVar.bRH = (ImageView) view.findViewById(i.f.select_icon);
                bVar.bRI = (RelativeLayout) view.findViewById(i.f.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.djW.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view_camera, viewGroup, false);
                bVar.dli = (ViewGroup) view.findViewById(i.f.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.dlh.setTag(null);
            bVar.dlh.setRadius(1);
            bVar.dlh.setDefaultResource(i.e.img_default_100);
            bVar.dlh.d(null, 12, false);
            bVar.dlh.invalidate();
            a aVar = new a(this, null);
            aVar.dlg = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                bVar.dlh.setTag(item.toCachedKey(false));
                if (this.amg.a(item, false) != null) {
                    bVar.dlh.invalidate();
                } else {
                    this.amg.a(item, new y(this, viewGroup, aVar), false, this.dkX);
                }
            } else {
                aVar.dlg = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.dkV != null) {
                if (this.dkV.isAdded(item)) {
                    an.i(bVar.bRH, i.e.chx_camera_pic_s);
                } else {
                    an.i(bVar.bRH, i.e.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.dkV);
            }
            bVar.dlh.setOnClickListener(new z(this, aVar, i, item));
        } else {
            bVar.dli.setOnClickListener(new aa(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.dkX;
    }

    public void gU(boolean z) {
        this.dkX = z;
    }

    private void applyNightMode(View view) {
        this.djW.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.djW.getLayoutMode().k(view);
    }

    public void a(v vVar) {
        this.dkY = vVar;
    }

    public void a(w wVar) {
        this.dla = wVar;
    }

    public void a(u uVar) {
        this.dkZ = uVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView bRH;
        RelativeLayout bRI;
        HeadImageView dlh;
        ViewGroup dli;

        private b() {
        }

        /* synthetic */ b(x xVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean dlg;

        private a() {
        }

        /* synthetic */ a(x xVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, l lVar) {
        bVar.bRI.setOnClickListener(new ab(this, aVar, lVar, imageFileInfo, i, bVar));
    }
}
