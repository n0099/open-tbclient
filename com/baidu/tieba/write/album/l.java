package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.e cxX;
    private AlbumActivity cxZ;
    private String cyt;
    private int cyu;
    private List<a> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.cxZ = albumActivity;
        this.cxX = albumActivity.arD();
        this.mWidth = (int) this.cxZ.getResources().getDimension(com.baidu.tieba.o.album_image_height);
        this.cyu = com.baidu.adp.lib.util.n.M(this.cxZ.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<a> list, String str) {
        this.mList = list;
        this.cyt = str;
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
    /* renamed from: jo */
    public a getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        if (view != null) {
            nVar = (n) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.hr().a(this.cxZ.getPageContext().getPageActivity(), com.baidu.tieba.r.album_list_item, viewGroup, false);
            n nVar2 = new n(this, null);
            nVar2.cyw = (HeadImageView) view.findViewById(com.baidu.tieba.q.item_head);
            nVar2.cyx = (TextView) view.findViewById(com.baidu.tieba.q.item_name);
            nVar2.cyy = (ImageView) view.findViewById(com.baidu.tieba.q.item_arrow);
            view.setTag(nVar2);
            nVar = nVar2;
        }
        nVar.cyw.setTag(null);
        nVar.cyw.setDefaultResource(com.baidu.tieba.p.pic_image_h_not);
        nVar.cyw.c(null, 12, false);
        nVar.cyw.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                nVar.cyx.setText(String.valueOf(com.baidu.adp.lib.util.n.a(nVar.cyx.getPaint(), item.getName(), this.cyu)) + "(" + item.arG() + ")");
            } else {
                nVar.cyx.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cyt)) {
                nVar.cyy.setVisibility(0);
            } else {
                nVar.cyy.setVisibility(8);
            }
            ImageFileInfo arH = item.arH();
            if (arH != null) {
                arH.clearPageActions();
                arH.addPageAction(com.baidu.tbadk.img.effect.d.y(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.cxX.a(arH, false);
                nVar.cyw.setTag(arH.toCachedKey(false));
                if (a != null) {
                    nVar.cyw.invalidate();
                } else {
                    this.cxX.a(arH, new m(this, viewGroup), false, this.cxZ.isScroll());
                }
            }
        } else {
            nVar.cyx.setText("");
        }
        this.cxZ.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cxZ.getLayoutMode().j(view);
        return view;
    }
}
