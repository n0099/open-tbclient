package com.baidu.tieba.write.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter {
    private com.baidu.tbadk.img.b aqL;
    private boolean eAY;
    private AlbumActivity eGS;
    private o eHK;
    private boolean eHL;
    private z eHM;
    private x eHN;
    private aa eHO;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, o oVar) {
        this.eGS = albumActivity;
        this.aqL = albumActivity.YO();
        this.eHK = oVar;
        this.mWidth = (int) this.eGS.getResources().getDimension(t.e.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.eHL = z;
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
    /* renamed from: qo */
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
        return (this.eHL && i == 0) ? 1 : 0;
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
                view = LayoutInflater.from(this.eGS.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view, viewGroup, false);
                bVar.eHV = (HeadImageView) view.findViewById(t.g.pic);
                bVar.cDz = (ImageView) view.findViewById(t.g.select_icon);
                bVar.cDA = (RelativeLayout) view.findViewById(t.g.lay_select);
                view.setTag(bVar);
            } else {
                view = LayoutInflater.from(this.eGS.getPageContext().getPageActivity()).inflate(t.h.album_image_item_view_camera, viewGroup, false);
                bVar.eHW = (ViewGroup) view.findViewById(t.g.item_camera);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            bVar.eHV.setTag(null);
            bVar.eHV.setRadius(1);
            bVar.eHV.setDefaultResource(t.f.img_default_100);
            bVar.eHV.c(null, 12, false);
            int i2 = i + 1;
            if (this.eHL) {
                i2 = i;
            }
            bVar.eHV.setContentDescription(String.valueOf(view.getResources().getString(t.j.log_msg_pic)) + i2 + " " + item.getModifyTime());
            bVar.eHV.invalidate();
            a aVar = new a(this, null);
            aVar.eHU = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                bVar.eHV.setTag(item.toCachedKey(false));
                if (this.aqL.a(item, false) != null) {
                    bVar.eHV.invalidate();
                } else {
                    this.aqL.a(item, new ac(this, viewGroup, aVar), false, this.eAY);
                }
            } else {
                aVar.eHU = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.eHK != null) {
                if (this.eHK.isAdded(item)) {
                    bVar.cDz.setContentDescription(this.eGS.getResources().getString(t.j.check_box_checked));
                    at.k(bVar.cDz, t.f.chx_camera_pic_s);
                } else {
                    bVar.cDz.setContentDescription(this.eGS.getResources().getString(t.j.check_box_not_checked));
                    at.k(bVar.cDz, t.f.chx_camera_pic_n);
                }
                a(bVar, aVar, i, item, skinType, this.eHK);
            }
            bVar.eHV.setOnClickListener(new ad(this, aVar, i, item));
        } else {
            at.k(bVar.eHW, t.f.icon_camera_pic);
            bVar.eHW.setOnClickListener(new ae(this, i, item));
        }
        u(view);
        return view;
    }

    public boolean isScroll() {
        return this.eAY;
    }

    public void je(boolean z) {
        this.eAY = z;
    }

    private void u(View view) {
        this.eGS.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.eGS.getLayoutMode().x(view);
    }

    public void a(z zVar) {
        this.eHM = zVar;
    }

    public void a(aa aaVar) {
        this.eHO = aaVar;
    }

    public void a(x xVar) {
        this.eHN = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        RelativeLayout cDA;
        ImageView cDz;
        HeadImageView eHV;
        ViewGroup eHW;

        private b() {
        }

        /* synthetic */ b(ab abVar, b bVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        boolean eHU;

        private a() {
        }

        /* synthetic */ a(ab abVar, a aVar) {
            this();
        }
    }

    private void a(b bVar, a aVar, int i, ImageFileInfo imageFileInfo, int i2, o oVar) {
        bVar.cDA.setOnClickListener(new af(this, aVar, oVar, imageFileInfo, i, bVar));
    }
}
