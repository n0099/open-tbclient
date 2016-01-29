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
    private com.baidu.tbadk.img.b aqu;
    private String efE;
    private int egV;
    private AlbumActivity emU;
    private List<d> mList;
    private int mWidth;

    public l(AlbumActivity albumActivity) {
        this.emU = albumActivity;
        this.aqu = albumActivity.aSw();
        this.mWidth = (int) this.emU.getResources().getDimension(t.e.album_image_height);
        this.egV = com.baidu.adp.lib.util.k.K(this.emU.getPageContext().getPageActivity()) / 2;
    }

    public void d(List<d> list, String str) {
        this.mList = list;
        this.efE = str;
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
    /* renamed from: px */
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
            view = LayoutInflater.from(this.emU.getPageContext().getPageActivity()).inflate(t.h.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.enl = (HeadImageView) view.findViewById(t.g.item_head);
            aVar2.enm = (TextView) view.findViewById(t.g.item_name);
            aVar2.enn = (ImageView) view.findViewById(t.g.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.enl.setTag(null);
        aVar.enl.setDefaultResource(t.f.pic_image_h_not);
        aVar.enl.d(null, 12, false);
        aVar.enl.invalidate();
        d item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.enm.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.enm.getPaint(), item.getName(), this.egV)) + "(" + item.aSC() + ")");
            } else {
                aVar.enm.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.efE)) {
                aVar.enn.setVisibility(0);
            } else {
                aVar.enn.setVisibility(8);
            }
            ImageFileInfo aSD = item.aSD();
            if (aSD != null) {
                aSD.clearPageActions();
                aSD.addPageAction(com.baidu.tbadk.img.effect.d.G(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.aqu.a(aSD, false);
                aVar.enl.setTag(aSD.toCachedKey(false));
                if (a2 != null) {
                    aVar.enl.invalidate();
                } else {
                    this.aqu.a(aSD, new m(this, viewGroup), false, this.emU.isScroll());
                }
            }
        } else {
            aVar.enm.setText("");
        }
        this.emU.getLayoutMode().ac(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.emU.getLayoutMode().x(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView enl;
        TextView enm;
        ImageView enn;

        private a() {
        }

        /* synthetic */ a(l lVar, a aVar) {
            this();
        }
    }
}
