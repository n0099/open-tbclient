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
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b arb;
    private String fFC;
    private int fKT;
    private AlbumActivity gaf;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.gaf = albumActivity;
        this.arb = albumActivity.akr();
        this.mWidth = (int) this.gaf.getResources().getDimension(t.e.ds120);
        this.fKT = com.baidu.adp.lib.util.k.K(this.gaf.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fFC = str;
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
    /* renamed from: sY */
    public d getItem(int i) {
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
            view = LayoutInflater.from(this.gaf.getPageContext().getPageActivity()).inflate(t.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.gax = (HeadImageView) view.findViewById(t.g.item_head);
            aVar2.gay = (TextView) view.findViewById(t.g.item_name);
            aVar2.gaz = (ImageView) view.findViewById(t.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.gax.setTag(null);
        aVar.gax.setDefaultResource(t.f.pic_image_h_not);
        aVar.gax.c(null, 12, false);
        aVar.gax.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.gay.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.gay.getPaint(), item.getName(), this.fKT)) + "(" + item.brH() + ")");
            } else {
                aVar.gay.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fFC)) {
                aVar.gaz.setVisibility(0);
            } else {
                aVar.gaz.setVisibility(8);
            }
            ImageFileInfo brI = item.brI();
            if (brI != null) {
                brI.clearPageActions();
                brI.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.arb.a(brI, false);
                aVar.gax.setTag(brI.toCachedKey(false));
                if (a2 != null) {
                    aVar.gax.invalidate();
                } else {
                    this.arb.a(brI, new m(this, viewGroup), false, this.gaf.isScroll());
                }
            }
        } else {
            aVar.gay.setText("");
        }
        this.gaf.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.gaf.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView gax;
        TextView gay;
        ImageView gaz;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
