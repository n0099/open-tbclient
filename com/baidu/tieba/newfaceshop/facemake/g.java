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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class g extends BaseAdapter {
    private boolean bLU;
    private int dkj;
    private f lAA;
    private BaseFragmentActivity lBW;
    private int lBX;
    private int lBY;
    private String lBZ;
    private List<ImageFileInfo> mList;
    private int mScreenWidth;
    private int mWidth;
    private LinkedHashMap<String, ImageFileInfo> lBV = new LinkedHashMap<>();
    private com.baidu.tbadk.img.b fyF = new com.baidu.tbadk.img.b();

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        this.lBW = baseFragmentActivity;
        this.mList = list;
        this.mWidth = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        this.mScreenWidth = l.getEquipmentWidth(baseFragmentActivity.getPageContext().getPageActivity());
        this.dkj = (this.mScreenWidth - l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        this.lBX = l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.lBY = (this.lBX * 2) + 1;
    }

    public void OT(String str) {
        this.lBZ = str;
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
    /* renamed from: Fh */
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
            aVar2.am(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.rootView = view;
        int paddingTop = aVar.rootView.getPaddingTop();
        int i2 = i % 3;
        if (i2 == 0) {
            aVar.rootView.setPadding(0, paddingTop, this.lBY, 0);
        } else if (i2 == 1) {
            aVar.rootView.setPadding(this.lBX, paddingTop, this.lBX, 0);
        } else {
            aVar.rootView.setPadding(this.lBY, paddingTop, 0, 0);
        }
        aVar.lCb.getLayoutParams().height = this.dkj;
        aVar.lCb.setTag(null);
        aVar.lCb.setRadius(1);
        aVar.lCb.setDefaultResource(R.drawable.img_default_100);
        aVar.lCb.startLoad(null, 12, false);
        aVar.lCb.invalidate();
        ImageFileInfo imageFileInfo = this.mList.get(i);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.mWidth, this.mWidth));
            com.baidu.adp.widget.ImageView.a a2 = this.fyF.a(imageFileInfo, false);
            aVar.lCb.setTag(imageFileInfo.toCachedKey(false));
            if (a2 != null) {
                aVar.lCb.invalidate();
            } else {
                this.fyF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.g.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                        HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                        if (headImageView != null && aVar3 != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.bLU);
            }
            if (this.lBV.containsKey(imageFileInfo.getFilePath())) {
                ap.setBackgroundResource(aVar.lCc, R.drawable.ic_post_image_selected_s);
            } else {
                ap.setBackgroundResource(aVar.lCc, R.drawable.ic_post_image_selected_n);
            }
            view.setTag(view.getId(), imageFileInfo);
        }
        return view;
    }

    public void b(f fVar) {
        this.lAA = fVar;
    }

    public boolean isScroll() {
        return this.bLU;
    }

    public void dq(boolean z) {
        this.bLU = z;
    }

    public com.baidu.tbadk.img.b diM() {
        return this.fyF;
    }

    public void I(Map<String, ImageFileInfo> map) {
        this.lBV.putAll(map);
    }

    public LinkedHashMap<String, ImageFileInfo> div() {
        return this.lBV;
    }

    /* loaded from: classes9.dex */
    class a {
        public HeadImageView lCb;
        public ImageView lCc;
        public View rootView;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void am(View view) {
            this.lCb = (HeadImageView) view.findViewById(R.id.image);
            this.lCc = (ImageView) view.findViewById(R.id.select_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof ImageFileInfo)) {
                        ImageFileInfo imageFileInfo = (ImageFileInfo) view2.getTag(view2.getId());
                        if (g.this.lBV.containsKey(imageFileInfo.getFilePath())) {
                            g.this.lBV.remove(imageFileInfo.getFilePath());
                            ap.setBackgroundResource(a.this.lCc, R.drawable.ic_post_image_selected_n);
                            if (g.this.lAA != null) {
                                g.this.lAA.czD();
                            }
                        } else if (g.this.lAA != null) {
                            if (g.this.lAA.czE()) {
                                g.this.lBV.put(imageFileInfo.getFilePath(), imageFileInfo);
                                ap.setBackgroundResource(a.this.lCc, R.drawable.ic_post_image_selected_s);
                                g.this.lAA.czC();
                                return;
                            }
                            Activity pageActivity = g.this.lBW.getPageContext().getPageActivity();
                            if (!TextUtils.isEmpty(g.this.lBZ)) {
                                BdToast.b(pageActivity, g.this.lBZ).bqD();
                            } else {
                                BdToast.b(pageActivity, pageActivity.getText(R.string.face_group_add_pic_max)).bqD();
                            }
                        }
                    }
                }
            });
        }
    }
}
