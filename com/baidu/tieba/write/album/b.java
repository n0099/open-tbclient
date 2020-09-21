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
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private String bsh;
    private int bsi;
    private BaseFragmentActivity hEa;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hEa = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hEa.getPageContext().getPageActivity());
        this.bsi = l.getEquipmentWidth(this.hEa.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bsh = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wX */
    public com.baidu.tbadk.album.a getItem(int i) {
        return (com.baidu.tbadk.album.a) y.getItem(this.mList, i);
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
            aVar.mXw = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bsk = (TextView) view.findViewById(R.id.item_name);
            aVar.bsl = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.mXw.setGifIconSupport(false);
            aVar.mXw.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bsk.setText(l.getTextOmit(aVar.bsk.getPaint(), item.getName(), this.bsi) + "(" + item.getCount() + ")");
            } else {
                aVar.bsk.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bsh)) {
                ap.setImageResource(aVar.bsl, R.drawable.icon_list_select_ok_n);
                aVar.bsl.setVisibility(0);
            } else {
                aVar.bsl.setVisibility(8);
            }
            MediaFileInfo bbn = item.bbn();
            if (bbn instanceof VideoFileInfo) {
                aVar.mXw.startLoad(((VideoFileInfo) bbn).videoPath, 37, false);
            } else if (bbn instanceof ImageFileInfo) {
                aVar.mXw.startLoad(((ImageFileInfo) bbn).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bsk, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bsk;
        ImageView bsl;
        TbImageView mXw;

        private a() {
        }
    }
}
