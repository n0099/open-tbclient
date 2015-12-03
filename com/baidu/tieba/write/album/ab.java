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
    private com.baidu.tbadk.img.b anY;
    private AlbumActivity dKK;
    private o dLJ;
    private boolean dLK;
    private boolean dLL;
    private z dLM;
    private x dLN;
    private aa dLO;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.dKK = albumActivity;
        this.anY = albumActivity.aHo();
        this.dLJ = oVar;
        this.mWidth = (int) this.dKK.getResources().getDimension(n.d.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.dLK = z;
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
    /* renamed from: ni */
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
        return (this.dLK && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.dKK.getPageContext().getPageActivity()).inflate(n.g.album_image_item_view, viewGroup, false);
                bVar.dLV = (HeadImageView) view.findViewById(n.f.pic);
                bVar.cip = (ImageView) view.findViewById(n.f.select_icon);
                bVar.ciq = (RelativeLayout) view.findViewById(n.f.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.dKK.getPageContext().getPageActivity()).inflate(n.g.album_image_item_view_camera, viewGroup, false);
                bVar.dLW = (ViewGroup) view.findViewById(n.f.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.dLV.setTag(null);
            bVar.dLV.setRadius(1);
            bVar.dLV.setDefaultResource(n.e.img_default_100);
            bVar.dLV.d(null, 12, false);
            bVar.dLV.invalidate();
            a aVar = new a(this, null);
            aVar.dLU = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                bVar.dLV.setTag(item.toCachedKey(false));
                if (this.anY.a(item, false) != null) {
                    bVar.dLV.invalidate();
                } else {
                    this.anY.a(item, new ac(this, viewGroup, aVar), false, this.dLL);
                }
            } else {
                aVar.dLU = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.dLJ != null) {
                if (this.dLJ.isAdded(item)) {
                    as.i(bVar.cip, n.e.chx_camera_pic_s);
                } else {
                    as.i(bVar.cip, n.e.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.dLJ);
            }
            bVar.dLV.setOnClickListener(new ad(this, aVar, i, item));
        } else {
            as.i(bVar.dLW, n.e.icon_camera_pic);
            bVar.dLW.setOnClickListener(new ae(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.dLL;
    }

    public void hF(boolean z) {
        this.dLL = z;
    }

    private void applyNightMode(View view) {
        this.dKK.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dKK.getLayoutMode().k(view);
    }

    public void a(z zVar) {
        this.dLM = zVar;
    }

    public void a(aa aaVar) {
        this.dLO = aaVar;
    }

    public void a(x xVar) {
        this.dLN = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView cip;
        RelativeLayout ciq;
        HeadImageView dLV;
        ViewGroup dLW;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean dLU;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.ciq.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
