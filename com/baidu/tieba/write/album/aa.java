package com.baidu.tieba.write.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {
    private com.baidu.tbadk.img.e ctI;
    private AlbumActivity ctK;
    private n cuE;
    private boolean cuF;
    private boolean cuG;
    private y cuH;
    private x cuI;
    private z cuJ;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public aa(AlbumActivity albumActivity, n nVar) {
        this.ctK = albumActivity;
        this.ctI = albumActivity.apN();
        this.cuE = nVar;
        this.mWidth = (int) this.ctK.getResources().getDimension(com.baidu.tieba.t.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.cuF = z;
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
    /* renamed from: iQ */
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
        return (this.cuF && i == 0) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            agVar = new ag(this, null);
            if (itemViewType == 0) {
                view = com.baidu.adp.lib.g.b.hH().a(this.ctK.getPageContext().getPageActivity(), com.baidu.tieba.w.album_image_item_view, viewGroup, false);
                agVar.cuQ = (HeadImageView) view.findViewById(com.baidu.tieba.v.pic);
                agVar.bwO = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
                agVar.bwP = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
                view.setTag(agVar);
            } else {
                view = com.baidu.adp.lib.g.b.hH().a(this.ctK.getPageContext().getPageActivity(), com.baidu.tieba.w.album_image_item_view_camera, viewGroup, false);
                agVar.cuR = (ViewGroup) view.findViewById(com.baidu.tieba.v.item_camera);
                view.setTag(agVar);
            }
        } else {
            agVar = (ag) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            agVar.cuQ.setTag(null);
            agVar.cuQ.setRadius(1);
            agVar.cuQ.setDefaultResource(com.baidu.tieba.u.img_default_100);
            agVar.cuQ.c(null, 12, false);
            agVar.cuQ.invalidate();
            af afVar = new af(this, null);
            afVar.cuP = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.x(this.mWidth, this.mWidth));
                agVar.cuQ.setTag(item.toCachedKey(false));
                if (this.ctI.a(item, false) != null) {
                    agVar.cuQ.invalidate();
                } else {
                    this.ctI.a(item, new ab(this, viewGroup, afVar), false, this.cuG);
                }
            } else {
                afVar.cuP = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.cuE != null) {
                if (this.cuE.isAdded(item)) {
                    ba.i(agVar.bwO, com.baidu.tieba.u.chx_camera_pic_s);
                } else {
                    ba.i(agVar.bwO, com.baidu.tieba.u.chx_camera_pic_n);
                }
                a(agVar, afVar, i, item, skinType, this.cuE);
            }
            agVar.cuQ.setOnClickListener(new ac(this, afVar, i, item));
        } else {
            agVar.cuR.setOnClickListener(new ad(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.cuG;
    }

    public void fd(boolean z) {
        this.cuG = z;
    }

    private void applyNightMode(View view) {
        this.ctK.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ctK.getLayoutMode().h(view);
    }

    public void a(y yVar) {
        this.cuH = yVar;
    }

    public void a(z zVar) {
        this.cuJ = zVar;
    }

    public void a(x xVar) {
        this.cuI = xVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, n nVar) {
        agVar.bwP.setOnClickListener(new ae(this, afVar, nVar, imageFileInfo, i, agVar));
    }
}
