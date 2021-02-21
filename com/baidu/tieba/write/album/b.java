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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private String bLD;
    private int bLE;
    private BaseFragmentActivity iKH;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.iKH = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.iKH.getPageContext().getPageActivity());
        this.bLE = l.getEquipmentWidth(this.iKH.getPageContext().getPageActivity()) / 2;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bLD = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yd */
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
            aVar.oeu = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bLG = (TextView) view.findViewById(R.id.item_name);
            aVar.bLH = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.oeu.setGifIconSupport(false);
            aVar.oeu.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bLG.setText(l.getTextOmit(aVar.bLG.getPaint(), item.getName(), this.bLE) + "(" + item.getCount() + ")");
            } else {
                aVar.bLG.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bLD)) {
                aVar.bLH.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                aVar.bLH.setVisibility(0);
            } else {
                aVar.bLH.setVisibility(8);
            }
            MediaFileInfo bjS = item.bjS();
            if (bjS instanceof VideoFileInfo) {
                aVar.oeu.startLoad(((VideoFileInfo) bjS).videoPath, 37, false);
            } else if (bjS instanceof ImageFileInfo) {
                aVar.oeu.startLoad(((ImageFileInfo) bjS).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bLG, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView bLG;
        ImageView bLH;
        TbImageView oeu;

        private a() {
        }
    }
}
