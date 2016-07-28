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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b anU;
    private int fCy;
    private AlbumActivity fQb;
    private String fxg;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fQb = albumActivity;
        this.anU = albumActivity.afG();
        this.mWidth = (int) this.fQb.getResources().getDimension(u.e.ds120);
        this.fCy = com.baidu.adp.lib.util.k.A(this.fQb.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fxg = str;
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
    /* renamed from: sx */
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
            view = LayoutInflater.from(this.fQb.getPageContext().getPageActivity()).inflate(u.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fQs = (HeadImageView) view.findViewById(u.g.item_head);
            aVar2.fQt = (TextView) view.findViewById(u.g.item_name);
            aVar2.fQu = (ImageView) view.findViewById(u.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fQs.setTag(null);
        aVar.fQs.setDefaultResource(u.f.pic_image_h_not);
        aVar.fQs.c(null, 12, false);
        aVar.fQs.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fQt.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fQt.getPaint(), item.getName(), this.fCy)) + "(" + item.bnr() + ")");
            } else {
                aVar.fQt.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fxg)) {
                aVar.fQu.setVisibility(0);
            } else {
                aVar.fQu.setVisibility(8);
            }
            ImageFileInfo bns = item.bns();
            if (bns != null) {
                bns.clearPageActions();
                bns.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.anU.a(bns, false);
                aVar.fQs.setTag(bns.toCachedKey(false));
                if (a2 != null) {
                    aVar.fQs.invalidate();
                } else {
                    this.anU.a(bns, new m(this, viewGroup), false, this.fQb.isScroll());
                }
            }
        } else {
            aVar.fQt.setText("");
        }
        this.fQb.getLayoutMode().af(TbadkCoreApplication.m10getInst().getSkinType() == 1);
        this.fQb.getLayoutMode().w(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fQs;
        TextView fQt;
        ImageView fQu;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
