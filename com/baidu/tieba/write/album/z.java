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
public class z extends BaseAdapter {
    private com.baidu.tbadk.img.b aml;
    private AlbumActivity dlE;
    private m dmD;
    private boolean dmE;
    private boolean dmF;
    private x dmG;
    private v dmH;
    private y dmI;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public z(AlbumActivity albumActivity, m mVar) {
        this.dlE = albumActivity;
        this.aml = albumActivity.aBR();
        this.dmD = mVar;
        this.mWidth = (int) this.dlE.getResources().getDimension(i.d.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.dmE = z;
        notifyDataSetChanged();
    }

    public int i(ImageFileInfo imageFileInfo) {
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
    /* renamed from: lW */
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
        return (this.dmE && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.dlE.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view, viewGroup, false);
                bVar.dmP = (HeadImageView) view.findViewById(i.f.pic);
                bVar.bSc = (ImageView) view.findViewById(i.f.select_icon);
                bVar.bSd = (RelativeLayout) view.findViewById(i.f.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.dlE.getPageContext().getPageActivity()).inflate(i.g.album_image_item_view_camera, viewGroup, false);
                bVar.dmQ = (ViewGroup) view.findViewById(i.f.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.dmP.setTag(null);
            bVar.dmP.setRadius(1);
            bVar.dmP.setDefaultResource(i.e.img_default_100);
            bVar.dmP.d(null, 12, false);
            bVar.dmP.invalidate();
            a aVar = new a(this, null);
            aVar.dmO = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                bVar.dmP.setTag(item.toCachedKey(false));
                if (this.aml.a(item, false) != null) {
                    bVar.dmP.invalidate();
                } else {
                    this.aml.a(item, new aa(this, viewGroup, aVar), false, this.dmF);
                }
            } else {
                aVar.dmO = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.dmD != null) {
                if (this.dmD.isAdded(item)) {
                    com.baidu.tbadk.core.util.an.i(bVar.bSc, i.e.chx_camera_pic_s);
                } else {
                    com.baidu.tbadk.core.util.an.i(bVar.bSc, i.e.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.dmD);
            }
            bVar.dmP.setOnClickListener(new ab(this, aVar, i, item));
        } else {
            bVar.dmQ.setOnClickListener(new ac(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.dmF;
    }

    public void gX(boolean z) {
        this.dmF = z;
    }

    private void applyNightMode(View view) {
        this.dlE.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dlE.getLayoutMode().k(view);
    }

    public void a(x xVar) {
        this.dmG = xVar;
    }

    public void a(y yVar) {
        this.dmI = yVar;
    }

    public void a(v vVar) {
        this.dmH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView bSc;
        RelativeLayout bSd;
        HeadImageView dmP;
        ViewGroup dmQ;

        private b() {
        }

        /* synthetic */ b(z zVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean dmO;

        private a() {
        }

        /* synthetic */ a(z zVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, m mVar) {
        bVar.bSd.setOnClickListener(new ad(this, aVar, mVar, imageFileInfo, i, bVar));
    }
}
