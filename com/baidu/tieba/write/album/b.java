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
    private String apC;
    private int apD;
    private AlbumActivity jNL;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(AlbumActivity albumActivity) {
        this.jNL = albumActivity;
        this.mLayoutInflater = LayoutInflater.from(this.jNL.getPageContext().getPageActivity());
        this.apD = l.getEquipmentWidth(this.jNL.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.apC = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pT */
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
            aVar.jNQ = (TbImageView) view.findViewById(R.id.item_head);
            aVar.apF = (TextView) view.findViewById(R.id.item_name);
            aVar.apG = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.jNQ.setGifIconSupport(false);
            aVar.jNQ.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.apF.setText(l.getTextOmit(aVar.apF.getPaint(), item.getName(), this.apD) + "(" + item.getCount() + ")");
            } else {
                aVar.apF.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.apC)) {
                am.setImageResource(aVar.apG, R.drawable.icon_list_select_ok_n);
                aVar.apG.setVisibility(0);
            } else {
                aVar.apG.setVisibility(8);
            }
            MediaFileInfo afd = item.afd();
            if (afd instanceof VideoFileInfo) {
                aVar.jNQ.startLoad(((VideoFileInfo) afd).videoPath, 37, false);
            } else if (afd instanceof ImageFileInfo) {
                aVar.jNQ.startLoad(((ImageFileInfo) afd).getFilePath(), 35, false);
            }
            am.setViewTextColor(aVar.apF, (int) R.color.cp_cont_b);
            am.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView apF;
        ImageView apG;
        TbImageView jNQ;

        private a() {
        }
    }
}
