package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b apC;
    private AlbumActivity dSj;
    private o dTi;
    private boolean dTj;
    private boolean dTk;
    private z dTl;
    private x dTm;
    private aa dTn;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.dSj = albumActivity;
        this.apC = albumActivity.aJI();
        this.dTi = oVar;
        this.mWidth = (int) this.dSj.getResources().getDimension(n.e.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.dTj = z;
        notifyDataSetChanged();
    }

    public int g(ImageFileInfo imageFileInfo) {
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
    /* renamed from: oa */
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
        return (this.dTj && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.dSj.getPageContext().getPageActivity()).inflate(n.h.album_image_item_view, viewGroup, false);
                bVar.dTu = (HeadImageView) view.findViewById(n.g.pic);
                bVar.cmu = (ImageView) view.findViewById(n.g.select_icon);
                bVar.cmv = (RelativeLayout) view.findViewById(n.g.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.dSj.getPageContext().getPageActivity()).inflate(n.h.album_image_item_view_camera, viewGroup, false);
                bVar.dTv = (ViewGroup) view.findViewById(n.g.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.dTu.setTag(null);
            bVar.dTu.setRadius(1);
            bVar.dTu.setDefaultResource(n.f.img_default_100);
            bVar.dTu.d(null, 12, false);
            bVar.dTu.invalidate();
            a aVar = new a(this, null);
            aVar.dTt = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                bVar.dTu.setTag(item.toCachedKey(false));
                if (this.apC.a(item, false) != null) {
                    bVar.dTu.invalidate();
                } else {
                    this.apC.a(item, new ac(this, viewGroup, aVar), false, this.dTk);
                }
            } else {
                aVar.dTt = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.dTi != null) {
                if (this.dTi.isAdded(item)) {
                    as.i(bVar.cmu, n.f.chx_camera_pic_s);
                } else {
                    as.i(bVar.cmu, n.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.dTi);
            }
            bVar.dTu.setOnClickListener(new ad(this, aVar, i, item));
        } else {
            as.i(bVar.dTv, n.f.icon_camera_pic);
            bVar.dTv.setOnClickListener(new ae(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.dTk;
    }

    public void hO(boolean z) {
        this.dTk = z;
    }

    private void applyNightMode(View view) {
        this.dSj.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dSj.getLayoutMode().k(view);
    }

    public void a(z zVar) {
        this.dTl = zVar;
    }

    public void a(aa aaVar) {
        this.dTn = aaVar;
    }

    public void a(x xVar) {
        this.dTm = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView cmu;
        RelativeLayout cmv;
        HeadImageView dTu;
        ViewGroup dTv;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean dTt;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.cmv.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
