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
    private com.baidu.tbadk.img.b cPM;
    private AlbumActivity cPQ;
    private String cQj;
    private int cQk;
    private List<b> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.cPQ = albumActivity;
        this.cPM = albumActivity.atB();
        this.mWidth = (int) this.cPQ.getResources().getDimension(i.d.album_image_height);
        this.cQk = com.baidu.adp.lib.util.k.K(this.cPQ.getPageContext().getPageActivity()) / 2;
    }

    public void c(List<b> list, String str) {
        this.mList = list;
        this.cQj = str;
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
    /* renamed from: ki */
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
            view = LayoutInflater.from(this.cPQ.getPageContext().getPageActivity()).inflate(i.g.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.cQm = (HeadImageView) view.findViewById(i.f.item_head);
            aVar2.cQn = (TextView) view.findViewById(i.f.item_name);
            aVar2.cQo = (ImageView) view.findViewById(i.f.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.cQm.setTag(null);
        aVar.cQm.setDefaultResource(i.e.pic_image_h_not);
        aVar.cQm.d(null, 12, false);
        aVar.cQm.invalidate();
        b item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.cQn.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.cQn.getPaint(), item.getName(), this.cQk)) + "(" + item.atE() + ")");
            } else {
                aVar.cQn.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.cQj)) {
                aVar.cQo.setVisibility(0);
            } else {
                aVar.cQo.setVisibility(8);
            }
            ImageFileInfo atF = item.atF();
            if (atF != null) {
                atF.clearPageActions();
                atF.addPageAction(com.baidu.tbadk.img.effect.d.J(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.cPM.a(atF, false);
                aVar.cQm.setTag(atF.toCachedKey(false));
                if (a2 != null) {
                    aVar.cQm.invalidate();
                } else {
                    this.cPM.a(atF, new k(this, viewGroup), false, this.cPQ.isScroll());
                }
            }
        } else {
            aVar.cQn.setText("");
        }
        this.cPQ.getLayoutMode().ad(TbadkCoreApplication.m411getInst().getSkinType() == 1);
        this.cPQ.getLayoutMode().k(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView cQm;
        TextView cQn;
        ImageView cQo;

        private a() {
        }

        /* synthetic */ a(j jVar, a aVar) {
            this();
        }
    }
}
