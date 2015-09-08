package com.baidu.tieba.write.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private AlbumActivity cYB;
    private String cYU;
    private int cYV;
    private com.baidu.tbadk.img.b cYw;
    private List<b> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.cYB = albumActivity;
        this.cYw = albumActivity.axU();
        this.mWidth = (int) this.cYB.getResources().getDimension(i.d.album_image_height);
        this.cYV = com.baidu.adp.lib.util.k.K(this.cYB.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<b> list, String str) {
        this.mList = list;
        this.cYU = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: kT */
    public b getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.cYB.getPageContext().getPageActivity()).inflate(i.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.cYX = (HeadImageView) view.findViewById(i.f.item_head);
            aVar2.cYY = (TextView) view.findViewById(i.f.item_name);
            aVar2.cYZ = (ImageView) view.findViewById(i.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.cYX.setTag(null);
        aVar.cYX.setDefaultResource(i.e.pic_image_h_not);
        aVar.cYX.d(null, 12, false);
        aVar.cYX.invalidate();
        b item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.cYY.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.cYY.getPaint(), item.getName(), this.cYV)) + "(" + item.axX() + ")");
            } else {
                aVar.cYY.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cYU)) {
                aVar.cYZ.setVisibility(0);
            } else {
                aVar.cYZ.setVisibility(8);
            }
            ImageFileInfo axY = item.axY();
            if (axY != null) {
                axY.clearPageActions();
                axY.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.cYw.a(axY, false);
                aVar.cYX.setTag(axY.toCachedKey(false));
                if (a2 != null) {
                    aVar.cYX.invalidate();
                } else {
                    this.cYw.a(axY, new k(this, viewGroup), false, this.cYB.isScroll());
                }
            }
        } else {
            aVar.cYY.setText("");
        }
        this.cYB.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cYB.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView cYX;
        TextView cYY;
        ImageView cYZ;

        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }
    }
}
