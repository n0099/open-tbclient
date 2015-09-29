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
    private com.baidu.tbadk.img.b amf;
    private String djP;
    private int djQ;
    private AlbumActivity djw;
    private List<com.baidu.tieba.write.album.a> mList;
    private int mWidth;

    public i(AlbumActivity albumActivity) {
        this.djw = albumActivity;
        this.amf = albumActivity.aAV();
        this.mWidth = (int) this.djw.getResources().getDimension(i.d.album_image_height);
        this.djQ = com.baidu.adp.lib.util.k.K(this.djw.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<com.baidu.tieba.write.album.a> list, String str) {
        this.mList = list;
        this.djP = str;
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
    /* renamed from: lI */
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
            view = LayoutInflater.from(this.djw.getPageContext().getPageActivity()).inflate(i.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.djS = (HeadImageView) view.findViewById(i.f.item_head);
            aVar2.djT = (TextView) view.findViewById(i.f.item_name);
            aVar2.djU = (ImageView) view.findViewById(i.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.djS.setTag(null);
        aVar.djS.setDefaultResource(i.e.pic_image_h_not);
        aVar.djS.d(null, 12, false);
        aVar.djS.invalidate();
        com.baidu.tieba.write.album.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.djT.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.djT.getPaint(), item.getName(), this.djQ)) + "(" + item.aBa() + ")");
            } else {
                aVar.djT.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.djP)) {
                aVar.djU.setVisibility(0);
            } else {
                aVar.djU.setVisibility(8);
            }
            ImageFileInfo aBb = item.aBb();
            if (aBb != null) {
                aBb.clearPageActions();
                aBb.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.amf.a(aBb, false);
                aVar.djS.setTag(aBb.toCachedKey(false));
                if (a2 != null) {
                    aVar.djS.invalidate();
                } else {
                    this.amf.a(aBb, new j(this, viewGroup), false, this.djw.isScroll());
                }
            }
        } else {
            aVar.djT.setText("");
        }
        this.djw.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.djw.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView djS;
        TextView djT;
        ImageView djU;

        private a() {
        }

        /* synthetic */ a(i iVar, a aVar) {
            this();
        }
    }
}
