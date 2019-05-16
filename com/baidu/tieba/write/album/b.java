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
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String fcS;
    private int fcT;
    private AlbumActivity jFO;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jFO = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jFO.getPageContext().getPageActivity());
        this.fcT = l.af(this.jFO.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.fcS = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qB */
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
            aVar.jFZ = (TbImageView) view.findViewById(R.id.item_head);
            aVar.fcW = (TextView) view.findViewById(R.id.item_name);
            aVar.fcX = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jFZ.setGifIconSupport(false);
            aVar.jFZ.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.fcW.setText(l.a(aVar.fcW.getPaint(), item.getName(), this.fcT) + "(" + item.getCount() + ")");
            } else {
                aVar.fcW.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fcS)) {
                al.c(aVar.fcX, (int) R.drawable.icon_list_select_ok_n);
                aVar.fcX.setVisibility(0);
            } else {
                aVar.fcX.setVisibility(8);
            }
            MediaFileInfo Zp = item.Zp();
            if (Zp instanceof VideoFileInfo) {
                aVar.jFZ.startLoad(((VideoFileInfo) Zp).videoPath, 37, false);
            } else if (Zp instanceof ImageFileInfo) {
                aVar.jFZ.startLoad(((ImageFileInfo) Zp).getFilePath(), 35, false);
            }
            al.j(aVar.fcW, R.color.cp_cont_b);
            al.k(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView fcW;
        ImageView fcX;
        TbImageView jFZ;

        private a() {
        }
    }
}
