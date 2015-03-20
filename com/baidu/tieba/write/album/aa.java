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
    private com.baidu.tbadk.img.e cts;
    private AlbumActivity ctu;
    private n cuo;
    private boolean cup;
    private boolean cuq;
    private y cur;
    private x cus;
    private z cut;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public aa(AlbumActivity albumActivity, n nVar) {
        this.ctu = albumActivity;
        this.cts = albumActivity.apy();
        this.cuo = nVar;
        this.mWidth = (int) this.ctu.getResources().getDimension(com.baidu.tieba.t.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.cup = z;
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
    /* renamed from: iN */
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
        return (this.cup && i == 0) ? 1 : 0;
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
                view = com.baidu.adp.lib.g.b.hH().a(this.ctu.getPageContext().getPageActivity(), com.baidu.tieba.w.album_image_item_view, viewGroup, false);
                agVar.cuA = (HeadImageView) view.findViewById(com.baidu.tieba.v.pic);
                agVar.bwy = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
                agVar.bwz = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
                view.setTag(agVar);
            } else {
                view = com.baidu.adp.lib.g.b.hH().a(this.ctu.getPageContext().getPageActivity(), com.baidu.tieba.w.album_image_item_view_camera, viewGroup, false);
                agVar.cuB = (ViewGroup) view.findViewById(com.baidu.tieba.v.item_camera);
                view.setTag(agVar);
            }
        } else {
            agVar = (ag) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            agVar.cuA.setTag(null);
            agVar.cuA.setRadius(1);
            agVar.cuA.setDefaultResource(com.baidu.tieba.u.img_default_100);
            agVar.cuA.c(null, 12, false);
            agVar.cuA.invalidate();
            af afVar = new af(this, null);
            afVar.cuz = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.x(this.mWidth, this.mWidth));
                agVar.cuA.setTag(item.toCachedKey(false));
                if (this.cts.a(item, false) != null) {
                    agVar.cuA.invalidate();
                } else {
                    this.cts.a(item, new ab(this, viewGroup, afVar), false, this.cuq);
                }
            } else {
                afVar.cuz = false;
            }
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.cuo != null) {
                if (this.cuo.isAdded(item)) {
                    ba.i(agVar.bwy, com.baidu.tieba.u.chx_camera_pic_s);
                } else {
                    ba.i(agVar.bwy, com.baidu.tieba.u.chx_camera_pic_n);
                }
                a(agVar, afVar, i, item, skinType, this.cuo);
            }
            agVar.cuA.setOnClickListener(new ac(this, afVar, i, item));
        } else {
            agVar.cuB.setOnClickListener(new ad(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    public boolean isScroll() {
        return this.cuq;
    }

    public void ff(boolean z) {
        this.cuq = z;
    }

    private void applyNightMode(View view) {
        this.ctu.getLayoutMode().X(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.ctu.getLayoutMode().h(view);
    }

    public void a(y yVar) {
        this.cur = yVar;
    }

    public void a(z zVar) {
        this.cut = zVar;
    }

    public void a(x xVar) {
        this.cus = xVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, n nVar) {
        agVar.bwz.setOnClickListener(new ae(this, afVar, nVar, imageFileInfo, i, agVar));
    }
}
