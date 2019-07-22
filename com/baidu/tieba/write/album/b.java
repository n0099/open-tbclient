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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String fhT;
    private int fhU;
    private AlbumActivity jMV;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jMV = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jMV.getPageContext().getPageActivity());
        this.fhU = l.af(this.jMV.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.fhT = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qT */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.c(this.mList, i);
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
            view = this.mLayoutInflater.inflate(R.layout.album_list_item, viewGroup, false);
            aVar = new a();
            aVar.jNg = (TbImageView) view.findViewById(R.id.item_head);
            aVar.fhX = (TextView) view.findViewById(R.id.item_name);
            aVar.fhY = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jNg.setGifIconSupport(false);
            aVar.jNg.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.fhX.setText(l.a(aVar.fhX.getPaint(), item.getName(), this.fhU) + "(" + item.getCount() + ")");
            } else {
                aVar.fhX.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fhT)) {
                am.c(aVar.fhY, (int) R.drawable.icon_list_select_ok_n);
                aVar.fhY.setVisibility(0);
            } else {
                aVar.fhY.setVisibility(8);
            }
            MediaFileInfo aao = item.aao();
            if (aao instanceof VideoFileInfo) {
                aVar.jNg.startLoad(((VideoFileInfo) aao).videoPath, 37, false);
            } else if (aao instanceof ImageFileInfo) {
                aVar.jNg.startLoad(((ImageFileInfo) aao).getFilePath(), 35, false);
            }
            am.j(aVar.fhX, R.color.cp_cont_b);
            am.k(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView fhX;
        ImageView fhY;
        TbImageView jNg;

        private a() {
        }
    }
}
