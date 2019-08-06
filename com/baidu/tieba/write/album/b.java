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
    private String fiu;
    private int fiv;
    private AlbumActivity jOc;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jOc = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jOc.getPageContext().getPageActivity());
        this.fiv = l.af(this.jOc.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.fiu = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qV */
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
            aVar.jOn = (TbImageView) view.findViewById(R.id.item_head);
            aVar.fiz = (TextView) view.findViewById(R.id.item_name);
            aVar.fiA = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jOn.setGifIconSupport(false);
            aVar.jOn.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.fiz.setText(l.a(aVar.fiz.getPaint(), item.getName(), this.fiv) + "(" + item.getCount() + ")");
            } else {
                aVar.fiz.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fiu)) {
                am.c(aVar.fiA, (int) R.drawable.icon_list_select_ok_n);
                aVar.fiA.setVisibility(0);
            } else {
                aVar.fiA.setVisibility(8);
            }
            MediaFileInfo aao = item.aao();
            if (aao instanceof VideoFileInfo) {
                aVar.jOn.startLoad(((VideoFileInfo) aao).videoPath, 37, false);
            } else if (aao instanceof ImageFileInfo) {
                aVar.jOn.startLoad(((ImageFileInfo) aao).getFilePath(), 35, false);
            }
            am.j(aVar.fiz, R.color.cp_cont_b);
            am.k(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        ImageView fiA;
        TextView fiz;
        TbImageView jOn;

        private a() {
        }
    }
}
