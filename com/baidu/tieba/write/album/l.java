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
    private com.baidu.tbadk.img.b ari;
    private String fyJ;
    private int fyK;
    private AlbumActivity fyo;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.fyo = albumActivity;
        this.ari = albumActivity.ahb();
        this.mWidth = (int) this.fyo.getResources().getDimension(r.e.ds120);
        this.fyK = com.baidu.adp.lib.util.k.I(this.fyo.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<d> list, String str) {
        this.mList = list;
        this.fyJ = str;
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
    /* renamed from: sh */
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
            view = LayoutInflater.from(this.fyo.getPageContext().getPageActivity()).inflate(r.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fyM = (HeadImageView) view.findViewById(r.g.item_head);
            aVar2.fyN = (TextView) view.findViewById(r.g.item_name);
            aVar2.fyO = (ImageView) view.findViewById(r.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fyM.setTag(null);
        aVar.fyM.setDefaultResource(r.f.pic_image_h_not);
        aVar.fyM.c(null, 12, false);
        aVar.fyM.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fyN.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fyN.getPaint(), item.getName(), this.fyK)) + "(" + item.blz() + ")");
            } else {
                aVar.fyN.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fyJ)) {
                aVar.fyO.setVisibility(0);
            } else {
                aVar.fyO.setVisibility(8);
            }
            ImageFileInfo blA = item.blA();
            if (blA != null) {
                blA.clearPageActions();
                blA.addPageAction(com.baidu.tbadk.img.effect.d.F(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.ari.a(blA, false);
                aVar.fyM.setTag(blA.toCachedKey(false));
                if (a2 != null) {
                    aVar.fyM.invalidate();
                } else {
                    this.ari.a(blA, new m(this, viewGroup), false, this.fyo.isScroll());
                }
            }
        } else {
            aVar.fyN.setText("");
        }
        this.fyo.getLayoutMode().ai(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fyo.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fyM;
        TextView fyN;
        ImageView fyO;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
