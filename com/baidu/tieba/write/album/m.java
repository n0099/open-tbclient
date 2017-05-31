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
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class m extends BaseAdapter {
    private com.baidu.tbadk.img.b avP;
    private AlbumActivity fTN;
    private String fUp;
    private int fUq;
    private List<e> mList;
    private int mWidth;

    public m(AlbumActivity albumActivity) {
        this.fTN = albumActivity;
        this.avP = albumActivity.ahn();
        this.mWidth = (int) this.fTN.getResources().getDimension(w.f.ds120);
        this.fUq = com.baidu.adp.lib.util.k.af(this.fTN.getPageContext().getPageActivity()) / 2;
    }

    public void b(List<e> list, String str) {
        this.mList = list;
        this.fUp = str;
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
    /* renamed from: tk */
    public e getItem(int i) {
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
            view = LayoutInflater.from(this.fTN.getPageContext().getPageActivity()).inflate(w.j.album_list_item, viewGroup, false);
            a aVar2 = new a(this, null);
            aVar2.fUs = (HeadImageView) view.findViewById(w.h.item_head);
            aVar2.fUt = (TextView) view.findViewById(w.h.item_name);
            aVar2.fUu = (ImageView) view.findViewById(w.h.item_arrow);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.fUs.setTag(null);
        aVar.fUs.setDefaultResource(w.g.pic_image_h_not);
        aVar.fUs.c(null, 12, false);
        aVar.fUs.invalidate();
        e item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.fUt.setText(String.valueOf(com.baidu.adp.lib.util.k.a(aVar.fUt.getPaint(), item.getName(), this.fUq)) + "(" + item.bnF() + ")");
            } else {
                aVar.fUt.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.fUp)) {
                aVar.fUu.setVisibility(0);
            } else {
                aVar.fUu.setVisibility(8);
            }
            ImageFileInfo bnG = item.bnG();
            if (bnG != null) {
                bnG.clearPageActions();
                bnG.addPageAction(com.baidu.tbadk.img.effect.d.L(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a2 = this.avP.a(bnG, false);
                aVar.fUs.setTag(bnG.toCachedKey(false));
                if (a2 != null) {
                    aVar.fUs.invalidate();
                } else {
                    this.avP.a(bnG, new n(this, viewGroup), false, this.fTN.isScroll());
                }
            }
        } else {
            aVar.fUt.setText("");
        }
        this.fTN.getLayoutMode().ah(TbadkCoreApplication.m9getInst().getSkinType() == 1);
        this.fTN.getLayoutMode().t(view);
        return view;
    }

    /* loaded from: classes.dex */
    private class a {
        HeadImageView fUs;
        TextView fUt;
        ImageView fUu;

        private a() {
        }

        /* synthetic */ a(m mVar, a aVar) {
            this();
        }
    }
}
