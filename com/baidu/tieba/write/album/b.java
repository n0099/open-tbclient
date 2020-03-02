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
/* loaded from: classes13.dex */
public class b extends BaseAdapter {
    private String aCs;
    private int aCt;
    private AlbumActivity kMN;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.kMN = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.kMN.getPageContext().getPageActivity());
        this.aCt = l.getEquipmentWidth(this.kMN.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.aCs = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sk */
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
            aVar.kMS = (TbImageView) view.findViewById(R.id.item_head);
            aVar.aCv = (TextView) view.findViewById(R.id.item_name);
            aVar.aCw = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.kMS.setGifIconSupport(false);
            aVar.kMS.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.aCv.setText(l.getTextOmit(aVar.aCv.getPaint(), item.getName(), this.aCt) + "(" + item.getCount() + ")");
            } else {
                aVar.aCv.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aCs)) {
                am.setImageResource(aVar.aCw, R.drawable.icon_list_select_ok_n);
                aVar.aCw.setVisibility(0);
            } else {
                aVar.aCw.setVisibility(8);
            }
            MediaFileInfo ayE = item.ayE();
            if (ayE instanceof VideoFileInfo) {
                aVar.kMS.startLoad(((VideoFileInfo) ayE).videoPath, 37, false);
            } else if (ayE instanceof ImageFileInfo) {
                aVar.kMS.startLoad(((ImageFileInfo) ayE).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.aCv, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes13.dex */
    private class a {
        TextView aCv;
        ImageView aCw;
        TbImageView kMS;

        private a() {
        }
    }
}
