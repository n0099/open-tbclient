package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String dgA;
    private int dgB;
    private AlbumActivity hBK;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.hBK = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hBK.getPageContext().getPageActivity());
        this.dgB = l.aO(this.hBK.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.dgA = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.y(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kw */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.d(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = this.mLayoutInflater.inflate(e.h.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hBV = (TbImageView) view.findViewById(e.g.item_head);
            aVar.dgE = (TextView) view.findViewById(e.g.item_name);
            aVar.dgF = (ImageView) view.findViewById(e.g.item_arrow);
            aVar.hBV.setGifIconSupport(false);
            aVar.hBV.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.dgE.setText(l.a(aVar.dgE.getPaint(), item.getName(), this.dgB) + "(" + item.getCount() + ")");
            } else {
                aVar.dgE.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dgA)) {
                al.c(aVar.dgF, e.f.icon_list_select_ok_n);
                aVar.dgF.setVisibility(0);
            } else {
                aVar.dgF.setVisibility(8);
            }
            MediaFileInfo sE = item.sE();
            if (sE instanceof VideoFileInfo) {
                aVar.hBV.startLoad(((VideoFileInfo) sE).videoPath, 37, false);
            } else if (sE instanceof ImageFileInfo) {
                aVar.hBV.startLoad(((ImageFileInfo) sE).getFilePath(), 35, false);
            }
            al.h(aVar.dgE, e.d.cp_cont_b);
            al.i(view, e.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView dgE;
        ImageView dgF;
        TbImageView hBV;

        private a() {
        }
    }
}
