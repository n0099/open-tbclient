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
    private String dpK;
    private int dpL;
    private AlbumActivity hKI;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.hKI = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hKI.getPageContext().getPageActivity());
        this.dpL = l.aO(this.hKI.getPageContext().getPageActivity()) / 2;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.dpK = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lm */
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
            aVar.hKT = (TbImageView) view.findViewById(e.g.item_head);
            aVar.dpO = (TextView) view.findViewById(e.g.item_name);
            aVar.dpP = (ImageView) view.findViewById(e.g.item_arrow);
            aVar.hKT.setGifIconSupport(false);
            aVar.hKT.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.dpO.setText(l.a(aVar.dpO.getPaint(), item.getName(), this.dpL) + "(" + item.getCount() + ")");
            } else {
                aVar.dpO.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.dpK)) {
                al.c(aVar.dpP, e.f.icon_list_select_ok_n);
                aVar.dpP.setVisibility(0);
            } else {
                aVar.dpP.setVisibility(8);
            }
            MediaFileInfo uZ = item.uZ();
            if (uZ instanceof VideoFileInfo) {
                aVar.hKT.startLoad(((VideoFileInfo) uZ).videoPath, 37, false);
            } else if (uZ instanceof ImageFileInfo) {
                aVar.hKT.startLoad(((ImageFileInfo) uZ).getFilePath(), 35, false);
            }
            al.h(aVar.dpO, e.d.cp_cont_b);
            al.i(view, e.f.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView dpO;
        ImageView dpP;
        TbImageView hKT;

        private a() {
        }
    }
}
