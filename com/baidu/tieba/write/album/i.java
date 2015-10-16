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
public class i extends BaseAdapter {
    private com.baidu.tbadk.img.b amg;
    private AlbumActivity djW;
    private String dkp;
    private int dkq;
    private List<com.baidu.tieba.write.album.a> mList;
    private int mWidth;

    public i(AlbumActivity albumActivity) {
        this.djW = albumActivity;
        this.amg = albumActivity.aBf();
        this.mWidth = (int) this.djW.getResources().getDimension(i.d.album_image_height);
        this.dkq = com.baidu.adp.lib.util.k.K(this.djW.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tieba.write.album.a> list, String str) {
        this.mList = list;
        this.dkp = str;
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
    /* renamed from: lK */
    public com.baidu.tieba.write.album.a getItem(int i) {
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
            view = LayoutInflater.from(this.djW.getPageContext().getPageActivity()).inflate(i.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.dks = (HeadImageView) view.findViewById(i.f.item_head);
            aVar2.dkt = (TextView) view.findViewById(i.f.item_name);
            aVar2.dku = (ImageView) view.findViewById(i.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.dks.setTag(null);
        aVar.dks.setDefaultResource(i.e.pic_image_h_not);
        aVar.dks.d(null, 12, false);
        aVar.dks.invalidate();
        com.baidu.tieba.write.album.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.dkt.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.dkt.getPaint(), item.getName(), this.dkq)) + "(" + item.aBk() + ")");
            } else {
                aVar.dkt.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dkp)) {
                aVar.dku.setVisibility(0);
            } else {
                aVar.dku.setVisibility(8);
            }
            ImageFileInfo aBl = item.aBl();
            if (aBl != null) {
                aBl.clearPageActions();
                aBl.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.amg.a(aBl, false);
                aVar.dks.setTag(aBl.toCachedKey(false));
                if (a2 != null) {
                    aVar.dks.invalidate();
                } else {
                    this.amg.a(aBl, new j(this, viewGroup), false, this.djW.isScroll());
                }
            }
        } else {
            aVar.dkt.setText("");
        }
        this.djW.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.djW.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView dks;
        TextView dkt;
        ImageView dku;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
