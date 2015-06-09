package com.baidu.tieba.write.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends BaseAdapter {
    private com.baidu.tbadk.img.e cxY;
    private p cyX;
    private boolean cyY;
    private boolean cyZ;
    private AlbumActivity cya;
    private aa cza;
    private z czb;
    private ab czc;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ac(AlbumActivity albumActivity, p pVar) {
        this.cya = albumActivity;
        this.cxY = albumActivity.arE();
        this.cyX = pVar;
        this.mWidth = (int) this.cya.getResources().getDimension(com.baidu.tieba.o.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.cyY = z;
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
    /* renamed from: jm */
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
        return (this.cyY && i == 0) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ai aiVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            aiVar = new ai(this, null);
            if (itemViewType == 0) {
                view = com.baidu.adp.lib.g.b.hr().a(this.cya.getPageContext().getPageActivity(), com.baidu.tieba.r.album_image_item_view, viewGroup, false);
                aiVar.czj = (HeadImageView) view.findViewById(com.baidu.tieba.q.pic);
                aiVar.bzx = (ImageView) view.findViewById(com.baidu.tieba.q.select_icon);
                aiVar.bzy = (RelativeLayout) view.findViewById(com.baidu.tieba.q.lay_select);
                view.setTag(aiVar);
            } else {
                view = com.baidu.adp.lib.g.b.hr().a(this.cya.getPageContext().getPageActivity(), com.baidu.tieba.r.album_image_item_view_camera, viewGroup, false);
                aiVar.czk = (ViewGroup) view.findViewById(com.baidu.tieba.q.item_camera);
                view.setTag(aiVar);
            }
        } else {
            aiVar = (ai) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            aiVar.czj.setTag(null);
            aiVar.czj.setRadius(1);
            aiVar.czj.setDefaultResource(com.baidu.tieba.p.img_default_100);
            aiVar.czj.c(null, 12, false);
            aiVar.czj.invalidate();
            ah ahVar = new ah(this, null);
            ahVar.czi = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.y(this.mWidth, this.mWidth));
                aiVar.czj.setTag(item.toCachedKey(false));
                if (this.cxY.a(item, false) != null) {
                    aiVar.czj.invalidate();
                } else {
                    this.cxY.a(item, new ad(this, viewGroup, ahVar), false, this.cyZ);
                }
            } else {
                ahVar.czi = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.cyX != null) {
                if (this.cyX.isAdded(item)) {
                    ay.i(aiVar.bzx, com.baidu.tieba.p.chx_camera_pic_s);
                } else {
                    ay.i(aiVar.bzx, com.baidu.tieba.p.chx_camera_pic_n);
                }
                a(aiVar, ahVar, i, item, skinType, this.cyX);
            }
            aiVar.czj.setOnClickListener(new ae(this, ahVar, i, item));
        } else {
            aiVar.czk.setOnClickListener(new af(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.cyZ;
    }

    public void fz(boolean z) {
        this.cyZ = z;
    }

    private void applyNightMode(View view) {
        this.cya.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cya.getLayoutMode().j(view);
    }

    public void a(aa aaVar) {
        this.cza = aaVar;
    }

    public void a(ab abVar) {
        this.czc = abVar;
    }

    public void a(z zVar) {
        this.czb = zVar;
    }

    private void a(ai aiVar, ah ahVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        aiVar.bzy.setOnClickListener(new ag(this, ahVar, pVar, imageFileInfo, i, aiVar));
    }
}
