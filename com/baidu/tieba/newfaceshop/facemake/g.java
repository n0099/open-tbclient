package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class g extends BaseAdapter {
    private boolean bIk;
    private int dhV;
    private f lsv;
    private BaseFragmentActivity ltS;
    private int ltT;
    private int ltU;
    private String ltV;
    private List<ImageFileInfo> mList;
    private int mScreenWidth;
    private int mWidth;
    private LinkedHashMap<String, ImageFileInfo> ltR = new LinkedHashMap<>();
    private com.baidu.tbadk.img.b fwp = new com.baidu.tbadk.img.b();

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        this.ltS = baseFragmentActivity;
        this.mList = list;
        this.mWidth = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        this.mScreenWidth = l.getEquipmentWidth(baseFragmentActivity.getPageContext().getPageActivity());
        this.dhV = (this.mScreenWidth - l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        this.ltT = l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.ltU = (this.ltT * 2) + 1;
    }

    public void Oe(String str) {
        this.ltV = str;
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
    /* renamed from: EP */
    public ImageFileInfo getItem(int i) {
        if (this.mList == null || i > this.mList.size() - 1) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, final ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_album, (ViewGroup) null);
            aVar2.ap(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.rootView = view;
        int paddingTop = aVar.rootView.getPaddingTop();
        int i2 = i % 3;
        if (i2 == 0) {
            aVar.rootView.setPadding(0, paddingTop, this.ltU, 0);
        } else if (i2 == 1) {
            aVar.rootView.setPadding(this.ltT, paddingTop, this.ltT, 0);
        } else {
            aVar.rootView.setPadding(this.ltU, paddingTop, 0, 0);
        }
        aVar.ltX.getLayoutParams().height = this.dhV;
        aVar.ltX.setTag(null);
        aVar.ltX.setRadius(1);
        aVar.ltX.setDefaultResource(R.drawable.img_default_100);
        aVar.ltX.startLoad(null, 12, false);
        aVar.ltX.invalidate();
        ImageFileInfo imageFileInfo = this.mList.get(i);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth));
            com.baidu.adp.widget.ImageView.a a2 = this.fwp.a(imageFileInfo, false);
            aVar.ltX.setTag(imageFileInfo.toCachedKey(false));
            if (a2 != null) {
                aVar.ltX.invalidate();
            } else {
                this.fwp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.g.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                        HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                        if (headImageView != null && aVar3 != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.bIk);
            }
            if (this.ltR.containsKey(imageFileInfo.getFilePath())) {
                ao.setBackgroundResource(aVar.ltY, R.drawable.ic_post_image_selected_s);
            } else {
                ao.setBackgroundResource(aVar.ltY, R.drawable.ic_post_image_selected_n);
            }
            view.setTag(view.getId(), imageFileInfo);
        }
        return view;
    }

    public void b(f fVar) {
        this.lsv = fVar;
    }

    public boolean isScroll() {
        return this.bIk;
    }

    public void di(boolean z) {
        this.bIk = z;
    }

    public com.baidu.tbadk.img.b dgL() {
        return this.fwp;
    }

    public void G(Map<String, ImageFileInfo> map) {
        this.ltR.putAll(map);
    }

    public LinkedHashMap<String, ImageFileInfo> dgu() {
        return this.ltR;
    }

    /* loaded from: classes8.dex */
    class a {
        public HeadImageView ltX;
        public ImageView ltY;
        public View rootView;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ap(View view) {
            this.ltX = (HeadImageView) view.findViewById(R.id.image);
            this.ltY = (ImageView) view.findViewById(R.id.select_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof ImageFileInfo)) {
                        ImageFileInfo imageFileInfo = (ImageFileInfo) view2.getTag(view2.getId());
                        if (g.this.ltR.containsKey(imageFileInfo.getFilePath())) {
                            g.this.ltR.remove(imageFileInfo.getFilePath());
                            ao.setBackgroundResource(a.this.ltY, R.drawable.ic_post_image_selected_n);
                            if (g.this.lsv != null) {
                                g.this.lsv.cys();
                            }
                        } else if (g.this.lsv != null) {
                            if (g.this.lsv.cyt()) {
                                g.this.ltR.put(imageFileInfo.getFilePath(), imageFileInfo);
                                ao.setBackgroundResource(a.this.ltY, R.drawable.ic_post_image_selected_s);
                                g.this.lsv.cyr();
                                return;
                            }
                            Activity pageActivity = g.this.ltS.getPageContext().getPageActivity();
                            if (!TextUtils.isEmpty(g.this.ltV)) {
                                BdToast.b(pageActivity, g.this.ltV).bqk();
                            } else {
                                BdToast.b(pageActivity, pageActivity.getText(R.string.face_group_add_pic_max)).bqk();
                            }
                        }
                    }
                }
            });
        }
    }
}
