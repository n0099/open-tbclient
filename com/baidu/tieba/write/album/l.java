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
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private com.baidu.tbadk.img.b anY;
    private AlbumActivity dKK;
    private String dLd;
    private int dLe;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.dKK = albumActivity;
        this.anY = albumActivity.aHo();
        this.mWidth = (int) this.dKK.getResources().getDimension(n.d.album_image_height);
        this.dLe = com.baidu.adp.lib.util.k.K(this.dKK.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<d> list, String str) {
        this.mList = list;
        this.dLd = str;
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
    /* renamed from: nk */
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
            view = LayoutInflater.from(this.dKK.getPageContext().getPageActivity()).inflate(n.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.dLg = (HeadImageView) view.findViewById(n.f.item_head);
            aVar2.dLh = (TextView) view.findViewById(n.f.item_name);
            aVar2.dLi = (ImageView) view.findViewById(n.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.dLg.setTag(null);
        aVar.dLg.setDefaultResource(n.e.pic_image_h_not);
        aVar.dLg.d(null, 12, false);
        aVar.dLg.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.dLh.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.dLh.getPaint(), item.getName(), this.dLe)) + "(" + item.aHt() + ")");
            } else {
                aVar.dLh.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dLd)) {
                aVar.dLi.setVisibility(0);
            } else {
                aVar.dLi.setVisibility(8);
            }
            ImageFileInfo aHu = item.aHu();
            if (aHu != null) {
                aHu.clearPageActions();
                aHu.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.anY.a(aHu, false);
                aVar.dLg.setTag(aHu.toCachedKey(false));
                if (a2 != null) {
                    aVar.dLg.invalidate();
                } else {
                    this.anY.a(aHu, new m(this, viewGroup), false, this.dKK.isScroll());
                }
            }
        } else {
            aVar.dLh.setText("");
        }
        this.dKK.getLayoutMode().af(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dKK.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView dLg;
        TextView dLh;
        ImageView dLi;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
