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
/* loaded from: classes10.dex */
public class b extends BaseAdapter {
    private String axs;
    private int axt;
    private AlbumActivity kIz;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.kIz = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.kIz.getPageContext().getPageActivity());
        this.axt = l.getEquipmentWidth(this.kIz.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.axs = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: rZ */
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
            aVar.kIE = (TbImageView) view.findViewById(R.id.item_head);
            aVar.axv = (TextView) view.findViewById(R.id.item_name);
            aVar.axw = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.kIE.setGifIconSupport(false);
            aVar.kIE.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.axv.setText(l.getTextOmit(aVar.axv.getPaint(), item.getName(), this.axt) + "(" + item.getCount() + ")");
            } else {
                aVar.axv.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.axs)) {
                am.setImageResource(aVar.axw, R.drawable.icon_list_select_ok_n);
                aVar.axw.setVisibility(0);
            } else {
                aVar.axw.setVisibility(8);
            }
            MediaFileInfo avW = item.avW();
            if (avW instanceof VideoFileInfo) {
                aVar.kIE.startLoad(((VideoFileInfo) avW).videoPath, 37, false);
            } else if (avW instanceof ImageFileInfo) {
                aVar.kIE.startLoad(((ImageFileInfo) avW).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.axv, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes10.dex */
    private class a {
        TextView axv;
        ImageView axw;
        TbImageView kIE;

        private a() {
        }
    }
}
