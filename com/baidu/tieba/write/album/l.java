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
    private com.baidu.tbadk.img.e cxY;
    private AlbumActivity cya;
    private String cyu;
    private int cyv;
    private List<a> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.cya = albumActivity;
        this.cxY = albumActivity.arE();
        this.mWidth = (int) this.cya.getResources().getDimension(com.baidu.tieba.o.album_image_height);
        this.cyv = com.baidu.adp.lib.util.n.M(this.cya.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<a> list, String str) {
        this.mList = list;
        this.cyu = str;
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
            view = com.baidu.adp.lib.g.b.hr().a(this.cya.getPageContext().getPageActivity(), com.baidu.tieba.r.album_list_item, viewGroup, false);
            n nVar2 = new n(this, null);
            nVar2.cyx = (HeadImageView) view.findViewById(com.baidu.tieba.q.item_head);
            nVar2.cyy = (TextView) view.findViewById(com.baidu.tieba.q.item_name);
            nVar2.cyz = (ImageView) view.findViewById(com.baidu.tieba.q.item_arrow);
            view.setTag(nVar2);
            nVar = nVar2;
        }
        nVar.cyx.setTag(null);
        nVar.cyx.setDefaultResource(com.baidu.tieba.p.pic_image_h_not);
        nVar.cyx.c(null, 12, false);
        nVar.cyx.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                nVar.cyy.setText(String.valueOf(com.baidu.adp.lib.util.n.a(nVar.cyy.getPaint(), item.getName(), this.cyv)) + "(" + item.arH() + ")");
            } else {
                nVar.cyy.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cyu)) {
                nVar.cyz.setVisibility(0);
            } else {
                nVar.cyz.setVisibility(8);
            }
            ImageFileInfo arI = item.arI();
            if (arI != null) {
                arI.clearPageActions();
                arI.addPageAction(com.baidu.tbadk.img.effect.d.y(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.cxY.a(arI, false);
                nVar.cyx.setTag(arI.toCachedKey(false));
                if (a != null) {
                    nVar.cyx.invalidate();
                } else {
                    this.cxY.a(arI, new m(this, viewGroup), false, this.cya.isScroll());
                }
            }
        } else {
            nVar.cyy.setText("");
        }
        this.cya.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cya.getLayoutMode().j(view);
        return view;
    }
}
