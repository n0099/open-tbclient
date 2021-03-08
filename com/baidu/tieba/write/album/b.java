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
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private String bNd;
    private int bNe;
    private BaseFragmentActivity iMq;
    private LayoutInflater mLayoutInflater;
    private List<com.baidu.tbadk.album.a> mList;

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.iMq = baseFragmentActivity;
        this.mLayoutInflater = LayoutInflater.from(this.iMq.getPageContext().getPageActivity());
        this.bNe = l.getEquipmentWidth(this.iMq.getPageContext().getPageActivity()) / 2;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bNd = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ye */
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
            aVar.ogA = (TbImageView) view.findViewById(R.id.item_head);
            aVar.bNg = (TextView) view.findViewById(R.id.item_name);
            aVar.bNh = (ImageView) view.findViewById(R.id.item_arrow);
            aVar.ogA.setGifIconSupport(false);
            aVar.ogA.setLongIconSupport(false);
            view.setTag(aVar);
        }
        com.baidu.tbadk.album.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
            if (!TextUtils.isEmpty(item.getName())) {
                aVar.bNg.setText(l.getTextOmit(aVar.bNg.getPaint(), item.getName(), this.bNe) + "(" + item.getCount() + ")");
            } else {
                aVar.bNg.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bNd)) {
                aVar.bNh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_strok324_select, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                aVar.bNh.setVisibility(0);
            } else {
                aVar.bNh.setVisibility(8);
            }
            MediaFileInfo bjU = item.bjU();
            if (bjU instanceof VideoFileInfo) {
                aVar.ogA.startLoad(((VideoFileInfo) bjU).videoPath, 37, false);
            } else if (bjU instanceof ImageFileInfo) {
                aVar.ogA.startLoad(((ImageFileInfo) bjU).getFilePath(), 35, false);
            }
            ap.setViewTextColor(aVar.bNg, R.color.CAM_X0105);
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        }
        return view;
    }

    /* loaded from: classes7.dex */
    private class a {
        TextView bNg;
        ImageView bNh;
        TbImageView ogA;

        private a() {
        }
    }
}
