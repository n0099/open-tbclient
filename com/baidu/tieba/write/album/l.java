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
    private com.baidu.tbadk.img.b aqL;
    private int eAT;
    private AlbumActivity eGS;
    private String ezC;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.eGS = albumActivity;
        this.aqL = albumActivity.YO();
        this.mWidth = (int) this.eGS.getResources().getDimension(t.e.album_image_height);
        this.eAT = com.baidu.adp.lib.util.k.B(this.eGS.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.ezC = str;
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
    /* renamed from: qq */
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
            view = LayoutInflater.from(this.eGS.getPageContext().getPageActivity()).inflate(t.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.eHi = (HeadImageView) view.findViewById(t.g.item_head);
            aVar2.eHj = (TextView) view.findViewById(t.g.item_name);
            aVar2.eHk = (ImageView) view.findViewById(t.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.eHi.setTag(null);
        aVar.eHi.setDefaultResource(t.f.pic_image_h_not);
        aVar.eHi.c(null, 12, false);
        aVar.eHi.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.eHj.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.eHj.getPaint(), item.getName(), this.eAT)) + "(" + item.aZc() + ")");
            } else {
                aVar.eHj.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.ezC)) {
                aVar.eHk.setVisibility(0);
            } else {
                aVar.eHk.setVisibility(8);
            }
            ImageFileInfo aZd = item.aZd();
            if (aZd != null) {
                aZd.clearPageActions();
                aZd.addPageAction(com.baidu.tbadk.img.effect.d.D(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.aqL.a(aZd, false);
                aVar.eHi.setTag(aZd.toCachedKey(false));
                if (a2 != null) {
                    aVar.eHi.invalidate();
                } else {
                    this.aqL.a(aZd, new m(this, viewGroup), false, this.eGS.isScroll());
                }
            }
        } else {
            aVar.eHj.setText("");
        }
        this.eGS.getLayoutMode().ab(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.eGS.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView eHi;
        TextView eHj;
        ImageView eHk;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
