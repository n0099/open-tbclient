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
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private String aWo;
    private int aWp;
    private AlbumActivity lya;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.lya = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.lya.getPageContext().getPageActivity());
        this.aWp = l.getEquipmentWidth(this.lya.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.aWo = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sJ */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) v.getItem(this.mList, i);
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
            aVar.lyf = (TbImageView) view.findViewById(R.id.item_head);
            aVar.aWr = (TextView) view.findViewById(R.id.item_name);
            aVar.aWs = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.lyf.setGifIconSupport(false);
            aVar.lyf.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aWr.setText(l.getTextOmit(aVar.aWr.getPaint(), item.getName(), this.aWp) + "(" + item.getCount() + ")");
            } else {
                aVar.aWr.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aWo)) {
                am.setImageResource(aVar.aWs, R.drawable.icon_list_select_ok_n);
                aVar.aWs.setVisibility(0);
            } else {
                aVar.aWs.setVisibility(8);
            }
            MediaFileInfo aGS = item.aGS();
            if (aGS instanceof VideoFileInfo) {
                aVar.lyf.startLoad(((VideoFileInfo) aGS).videoPath, 37, false);
            } else if (aGS instanceof ImageFileInfo) {
                aVar.lyf.startLoad(((ImageFileInfo) aGS).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.aWr, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes2.dex */
    private class a {
        TextView aWr;
        ImageView aWs;
        TbImageView lyf;

        private a() {
        }
    }
}
