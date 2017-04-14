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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b avZ;
    private AlbumActivity fMV;
    private String fNq;
    private int fNr;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fMV = albumActivity;
        this.avZ = albumActivity.aho();
        this.mWidth = (int) this.fMV.getResources().getDimension(w.f.ds120);
        this.fNr = com.baidu.adp.lib.util.k.af(this.fMV.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fNq = str;
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
    /* renamed from: sP */
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
            view = LayoutInflater.from(this.fMV.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fNt = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.fNu = (TextView) view.findViewById(w.h.item_name);
            aVar2.fNv = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fNt.setTag(null);
        aVar.fNt.setDefaultResource(w.g.pic_image_h_not);
        aVar.fNt.c(null, 12, false);
        aVar.fNt.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fNu.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fNu.getPaint(), item.getName(), this.fNr)) + "(" + item.bnu() + ")");
            } else {
                aVar.fNu.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fNq)) {
                aVar.fNv.setVisibility(0);
            } else {
                aVar.fNv.setVisibility(8);
            }
            ImageFileInfo bnv = item.bnv();
            if (bnv != null) {
                bnv.clearPageActions();
                bnv.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.avZ.a(bnv, false);
                aVar.fNt.setTag(bnv.toCachedKey(false));
                if (a2 != null) {
                    aVar.fNt.invalidate();
                } else {
                    this.avZ.a(bnv, new m(this, viewGroup), false, this.fMV.isScroll());
                }
            }
        } else {
            aVar.fNu.setText("");
        }
        this.fMV.getLayoutMode().aj(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fMV.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fNt;
        TextView fNu;
        ImageView fNv;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
