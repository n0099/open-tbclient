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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b aqo;
    private AlbumActivity fGS;
    private String fHn;
    private int fHo;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fGS = albumActivity;
        this.aqo = albumActivity.aii();
        this.mWidth = (int) this.fGS.getResources().getDimension(r.f.ds120);
        this.fHo = com.baidu.adp.lib.util.k.I(this.fGS.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fHn = str;
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
    /* renamed from: sS */
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
            view = LayoutInflater.from(this.fGS.getPageContext().getPageActivity()).inflate(r.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fHq = (HeadImageView) view.findViewById(r.h.item_head);
            aVar2.fHr = (TextView) view.findViewById(r.h.item_name);
            aVar2.fHs = (ImageView) view.findViewById(r.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fHq.setTag(null);
        aVar.fHq.setDefaultResource(r.g.pic_image_h_not);
        aVar.fHq.c(null, 12, false);
        aVar.fHq.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fHr.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fHr.getPaint(), item.getName(), this.fHo)) + "(" + item.bmX() + ")");
            } else {
                aVar.fHr.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fHn)) {
                aVar.fHs.setVisibility(0);
            } else {
                aVar.fHs.setVisibility(8);
            }
            ImageFileInfo bmY = item.bmY();
            if (bmY != null) {
                bmY.clearPageActions();
                bmY.addPageAction(com.baidu.tbadk.img.effect.d.G(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.aqo.a(bmY, false);
                aVar.fHq.setTag(bmY.toCachedKey(false));
                if (a2 != null) {
                    aVar.fHq.invalidate();
                } else {
                    this.aqo.a(bmY, new m(this, viewGroup), false, this.fGS.isScroll());
                }
            }
        } else {
            aVar.fHr.setText("");
        }
        this.fGS.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fGS.getLayoutMode().v(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fHq;
        TextView fHr;
        ImageView fHs;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
