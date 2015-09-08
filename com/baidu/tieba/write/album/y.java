package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class y extends BaseAdapter {
    private AlbumActivity cYB;
    private com.baidu.tbadk.img.b cYw;
    private w cZA;
    private v cZB;
    private x cZC;
    private m cZx;
    private boolean cZy;
    private boolean cZz;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public y(AlbumActivity albumActivity, m mVar) {
        this.cYB = albumActivity;
        this.cYw = albumActivity.axU();
        this.cZx = mVar;
        this.mWidth = (int) this.cYB.getResources().getDimension(i.d.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.cZy = z;
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
    /* renamed from: kR */
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
        return (this.cZy && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.cYB.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view, viewGroup, false);
                bVar.cZJ = (HeadImageView) view.findViewById(i.f.pic);
                bVar.bNU = (ImageView) view.findViewById(i.f.select_icon);
                bVar.bNV = (RelativeLayout) view.findViewById(i.f.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.cYB.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view_camera, viewGroup, false);
                bVar.cZK = (ViewGroup) view.findViewById(i.f.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.cZJ.setTag(null);
            bVar.cZJ.setRadius(1);
            bVar.cZJ.setDefaultResource(i.e.img_default_100);
            bVar.cZJ.d(null, 12, false);
            bVar.cZJ.invalidate();
            a aVar = new a(this, null);
            aVar.cZI = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                bVar.cZJ.setTag(item.toCachedKey(false));
                if (this.cYw.a(item, false) != null) {
                    bVar.cZJ.invalidate();
                } else {
                    this.cYw.a(item, new z(this, viewGroup, aVar), false, this.cZz);
                }
            } else {
                aVar.cZI = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.cZx != null) {
                if (this.cZx.isAdded(item)) {
                    com.baidu.tbadk.core.util.al.h(bVar.bNU, i.e.chx_camera_pic_s);
                } else {
                    com.baidu.tbadk.core.util.al.h(bVar.bNU, i.e.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.cZx);
            }
            bVar.cZJ.setOnClickListener(new aa(this, aVar, i, item));
        } else {
            bVar.cZK.setOnClickListener(new ab(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.cZz;
    }

    public void gF(boolean z) {
        this.cZz = z;
    }

    private void applyNightMode(View view) {
        this.cYB.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cYB.getLayoutMode().k(view);
    }

    public void a(w wVar) {
        this.cZA = wVar;
    }

    public void a(x xVar) {
        this.cZC = xVar;
    }

    public void a(v vVar) {
        this.cZB = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView bNU;
        RelativeLayout bNV;
        HeadImageView cZJ;
        ViewGroup cZK;

        private b() {
        }

        /* synthetic */ b(y yVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean cZI;

        private a() {
        }

        /* synthetic */ a(y yVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, m mVar) {
        bVar.bNV.setOnClickListener(new ac(this, aVar, mVar, imageFileInfo, i, bVar));
    }
}
