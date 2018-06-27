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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String cXS;
    private int cXT;
    private AlbumActivity hsG;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.hsG = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hsG.getPageContext().getPageActivity());
        this.cXT = l.ah(this.hsG.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cXS = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.z(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jM */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) w.d(this.mList, i);
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
            view = this.mLayoutInflater.inflate(d.i.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hsR = (TbImageView) view.findViewById(d.g.item_head);
            aVar.cXW = (TextView) view.findViewById(d.g.item_name);
            aVar.cXX = (ImageView) view.findViewById(d.g.item_arrow);
            aVar.hsR.setGifIconSupport(false);
            aVar.hsR.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cXW.setText(l.a(aVar.cXW.getPaint(), item.getName(), this.cXT) + "(" + item.getCount() + ")");
            } else {
                aVar.cXW.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cXS)) {
                am.c(aVar.cXX, d.f.icon_list_select_ok_n);
                aVar.cXX.setVisibility(0);
            } else {
                aVar.cXX.setVisibility(8);
            }
            MediaFileInfo rP = item.rP();
            if (rP instanceof VideoFileInfo) {
                aVar.hsR.startLoad(((VideoFileInfo) rP).videoPath, 37, false);
            } else if (rP instanceof ImageFileInfo) {
                aVar.hsR.startLoad(((ImageFileInfo) rP).getFilePath(), 35, false);
            }
            am.h(aVar.cXW, d.C0142d.cp_cont_b);
            am.i(view, d.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView cXW;
        ImageView cXX;
        TbImageView hsR;

        private a() {
        }
    }
}
