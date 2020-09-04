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
    private String boY;
    private int boZ;
    private BaseFragmentActivity hwW;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.hwW = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.hwW.getPageContext().getPageActivity());
        this.boZ = l.getEquipmentWidth(this.hwW.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.boY = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wy */
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
            aVar.mNz = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bpb = (TextView) view.findViewById(R.id.item_name);
            aVar.bpc = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.mNz.setGifIconSupport(false);
            aVar.mNz.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bpb.setText(l.getTextOmit(aVar.bpb.getPaint(), item.getName(), this.boZ) + "(" + item.getCount() + ")");
            } else {
                aVar.bpb.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.boY)) {
                ap.setImageResource(aVar.bpc, R.drawable.icon_list_select_ok_n);
                aVar.bpc.setVisibility(0);
            } else {
                aVar.bpc.setVisibility(8);
            }
            MediaFileInfo bat = item.bat();
            if (bat instanceof VideoFileInfo) {
                aVar.mNz.startLoad(((VideoFileInfo) bat).videoPath, 37, false);
            } else if (bat instanceof ImageFileInfo) {
                aVar.mNz.startLoad(((ImageFileInfo) bat).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bpb, R.color.cp_cont_b);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes3.dex */
    private class a {
        TextView bpb;
        ImageView bpc;
        TbImageView mNz;

        private a() {
        }
    }
}
