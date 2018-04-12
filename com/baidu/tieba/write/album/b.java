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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String cPG;
    private int cPH;
    private AlbumActivity hbA;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.hbA = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hbA.getPageContext().getPageActivity());
        this.cPH = l.af(this.hbA.getPageContext().getPageActivity()) / 2;
    }

    public void f(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.cPG = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: jN */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.c(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 != null && (view2.getTag() instanceof a)) {
            aVar = (a) view2.getTag();
        } else {
            view2 = this.mLayoutInflater.inflate(d.i.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.hbL = (TbImageView) view2.findViewById(d.g.item_head);
            aVar.cPK = (TextView) view2.findViewById(d.g.item_name);
            aVar.cPL = (ImageView) view2.findViewById(d.g.item_arrow);
            aVar.hbL.setGifIconSupport(false);
            aVar.hbL.setLongIconSupport(false);
            view2.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view2.setVisibility(4);
        } else {
            view2.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.cPK.setText(l.a(aVar.cPK.getPaint(), item.getName(), this.cPH) + "(" + item.getCount() + ")");
            } else {
                aVar.cPK.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cPG)) {
                ak.c(aVar.cPL, d.f.icon_list_select_ok_n);
                aVar.cPL.setVisibility(0);
            } else {
                aVar.cPL.setVisibility(8);
            }
            MediaFileInfo ov = item.ov();
            if (ov instanceof VideoFileInfo) {
                aVar.hbL.startLoad(((VideoFileInfo) ov).videoPath, 37, false);
            } else if (ov instanceof ImageFileInfo) {
                aVar.hbL.startLoad(((ImageFileInfo) ov).getFilePath(), 35, false);
            }
            ak.h(aVar.cPK, d.C0126d.cp_cont_b);
            ak.i(view2, d.f.addresslist_item_bg);
        }
        return view2;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView cPK;
        ImageView cPL;
        TbImageView hbL;

        private a() {
        }
    }
}
