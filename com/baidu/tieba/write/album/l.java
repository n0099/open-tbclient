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
    private com.baidu.tbadk.img.b apC;
    private String dSC;
    private int dSD;
    private AlbumActivity dSj;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.dSj = albumActivity;
        this.apC = albumActivity.aJI();
        this.mWidth = (int) this.dSj.getResources().getDimension(n.e.album_image_height);
        this.dSD = com.baidu.adp.lib.util.k.K(this.dSj.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<d> list, String str) {
        this.mList = list;
        this.dSC = str;
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
    /* renamed from: oc */
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
            view = LayoutInflater.from(this.dSj.getPageContext().getPageActivity()).inflate(n.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.dSF = (HeadImageView) view.findViewById(n.g.item_head);
            aVar2.dSG = (TextView) view.findViewById(n.g.item_name);
            aVar2.dSH = (ImageView) view.findViewById(n.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.dSF.setTag(null);
        aVar.dSF.setDefaultResource(n.f.pic_image_h_not);
        aVar.dSF.d(null, 12, false);
        aVar.dSF.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.dSG.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.dSG.getPaint(), item.getName(), this.dSD)) + "(" + item.aJO() + ")");
            } else {
                aVar.dSG.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dSC)) {
                aVar.dSH.setVisibility(0);
            } else {
                aVar.dSH.setVisibility(8);
            }
            ImageFileInfo aJP = item.aJP();
            if (aJP != null) {
                aJP.clearPageActions();
                aJP.addPageAction(com.baidu.tbadk.img.effect.d.K(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.apC.a(aJP, false);
                aVar.dSF.setTag(aJP.toCachedKey(false));
                if (a2 != null) {
                    aVar.dSF.invalidate();
                } else {
                    this.apC.a(aJP, new m(this, viewGroup), false, this.dSj.isScroll());
                }
            }
        } else {
            aVar.dSG.setText("");
        }
        this.dSj.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.dSj.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView dSF;
        TextView dSG;
        ImageView dSH;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
