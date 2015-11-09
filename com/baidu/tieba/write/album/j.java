package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private com.baidu.tbadk.img.b aml;
    private AlbumActivity dlE;
    private String dlX;
    private int dlY;
    private List<b> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.dlE = albumActivity;
        this.aml = albumActivity.aBR();
        this.mWidth = (int) this.dlE.getResources().getDimension(i.d.album_image_height);
        this.dlY = com.baidu.adp.lib.util.k.K(this.dlE.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<b> list, String str) {
        this.mList = list;
        this.dlX = str;
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
    /* renamed from: lY */
    public b getItem(int i) {
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
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.dlE.getPageContext().getPageActivity()).inflate(i.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.dma = (HeadImageView) view.findViewById(i.f.item_head);
            aVar2.dmb = (TextView) view.findViewById(i.f.item_name);
            aVar2.dmc = (ImageView) view.findViewById(i.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.dma.setTag(null);
        aVar.dma.setDefaultResource(i.e.pic_image_h_not);
        aVar.dma.d(null, 12, false);
        aVar.dma.invalidate();
        b item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.dmb.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.dmb.getPaint(), item.getName(), this.dlY)) + "(" + item.aBW() + ")");
            } else {
                aVar.dmb.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dlX)) {
                aVar.dmc.setVisibility(0);
            } else {
                aVar.dmc.setVisibility(8);
            }
            ImageFileInfo aBX = item.aBX();
            if (aBX != null) {
                aBX.clearPageActions();
                aBX.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.aml.a(aBX, false);
                aVar.dma.setTag(aBX.toCachedKey(false));
                if (a2 != null) {
                    aVar.dma.invalidate();
                } else {
                    this.aml.a(aBX, new k(this, viewGroup), false, this.dlE.isScroll());
                }
            }
        } else {
            aVar.dmb.setText("");
        }
        this.dlE.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dlE.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView dma;
        TextView dmb;
        ImageView dmc;

        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }
    }
}
