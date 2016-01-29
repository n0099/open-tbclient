package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b aqu;
    private boolean eha;
    private AlbumActivity emU;
    private o enN;
    private boolean enO;
    private z enP;
    private x enQ;
    private aa enR;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.emU = albumActivity;
        this.aqu = albumActivity.aSw();
        this.enN = oVar;
        this.mWidth = (int) this.emU.getResources().getDimension(t.e.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.enO = z;
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
    /* renamed from: pv */
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
        return (this.enO && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.emU.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view, viewGroup, false);
                bVar.enY = (HeadImageView) view.findViewById(t.g.pic);
                bVar.csZ = (ImageView) view.findViewById(t.g.select_icon);
                bVar.cta = (RelativeLayout) view.findViewById(t.g.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.emU.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view_camera, viewGroup, false);
                bVar.enZ = (ViewGroup) view.findViewById(t.g.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.enY.setTag(null);
            bVar.enY.setRadius(1);
            bVar.enY.setDefaultResource(t.f.img_default_100);
            bVar.enY.d(null, 12, false);
            bVar.enY.invalidate();
            a aVar = new a(this, null);
            aVar.enX = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.G(this.mWidth, this.mWidth));
                bVar.enY.setTag(item.toCachedKey(false));
                if (this.aqu.a(item, false) != null) {
                    bVar.enY.invalidate();
                } else {
                    this.aqu.a(item, new ac(this, viewGroup, aVar), false, this.eha);
                }
            } else {
                aVar.enX = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.enN != null) {
                if (this.enN.isAdded(item)) {
                    ar.k(bVar.csZ, t.f.chx_camera_pic_s);
                } else {
                    ar.k(bVar.csZ, t.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.enN);
            }
            bVar.enY.setOnClickListener(new ad(this, aVar, i, item));
        } else {
            ar.k(bVar.enZ, t.f.icon_camera_pic);
            bVar.enZ.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.eha;
    }

    public void io(boolean z) {
        this.eha = z;
    }

    private void u(View view) {
        this.emU.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.emU.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.enP = zVar;
    }

    public void a(aa aaVar) {
        this.enR = aaVar;
    }

    public void a(x xVar) {
        this.enQ = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        ImageView csZ;
        RelativeLayout cta;
        HeadImageView enY;
        ViewGroup enZ;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean enX;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.cta.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
