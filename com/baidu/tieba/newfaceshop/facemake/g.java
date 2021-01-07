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
/* loaded from: classes9.dex */
public class g extends BaseAdapter {
    private boolean bMW;
    private int dmK;
    private f lxb;
    private int lyA;
    private String lyB;
    private BaseFragmentActivity lyy;
    private int lyz;
    private List<ImageFileInfo> mList;
    private int mScreenWidth;
    private int mWidth;
    private LinkedHashMap<String, ImageFileInfo> lyx = new LinkedHashMap<>();
    private com.baidu.tbadk.img.b fAX = new com.baidu.tbadk.img.b();

    public g(BaseFragmentActivity baseFragmentActivity, List<ImageFileInfo> list) {
        this.lyy = baseFragmentActivity;
        this.mList = list;
        this.mWidth = (int) baseFragmentActivity.getResources().getDimension(R.dimen.ds220);
        this.mScreenWidth = l.getEquipmentWidth(baseFragmentActivity.getPageContext().getPageActivity());
        this.dmK = (this.mScreenWidth - l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds16)) / 3;
        this.lyz = l.getDimens(baseFragmentActivity.getPageContext().getPageActivity(), R.dimen.ds8) / 3;
        this.lyA = (this.lyz * 2) + 1;
    }

    public void Pl(String str) {
        this.lyB = str;
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
    /* renamed from: Gv */
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
            aVar.rootView.setPadding(0, paddingTop, this.lyA, 0);
        } else if (i2 == 1) {
            aVar.rootView.setPadding(this.lyz, paddingTop, this.lyz, 0);
        } else {
            aVar.rootView.setPadding(this.lyA, paddingTop, 0, 0);
        }
        aVar.lyD.getLayoutParams().height = this.dmK;
        aVar.lyD.setTag(null);
        aVar.lyD.setRadius(1);
        aVar.lyD.setDefaultResource(R.drawable.img_default_100);
        aVar.lyD.startLoad(null, 12, false);
        aVar.lyD.invalidate();
        ImageFileInfo imageFileInfo = this.mList.get(i);
        if (imageFileInfo != null) {
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth));
            com.baidu.adp.widget.ImageView.a a2 = this.fAX.a(imageFileInfo, false);
            aVar.lyD.setTag(imageFileInfo.toCachedKey(false));
            if (a2 != null) {
                aVar.lyD.invalidate();
            } else {
                this.fAX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.newfaceshop.facemake.g.1
                    @Override // com.baidu.tbadk.imageManager.b
                    public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                        HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                        if (headImageView != null && aVar3 != null) {
                            headImageView.invalidate();
                        }
                    }
                }, false, this.bMW);
            }
            if (this.lyx.containsKey(imageFileInfo.getFilePath())) {
                ao.setBackgroundResource(aVar.lyE, R.drawable.ic_post_image_selected_s);
            } else {
                ao.setBackgroundResource(aVar.lyE, R.drawable.ic_post_image_selected_n);
            }
            view.setTag(view.getId(), imageFileInfo);
        }
        return view;
    }

    public void b(f fVar) {
        this.lxb = fVar;
    }

    public boolean isScroll() {
        return this.bMW;
    }

    public void dm(boolean z) {
        this.bMW = z;
    }

    public com.baidu.tbadk.img.b dkD() {
        return this.fAX;
    }

    public void G(Map<String, ImageFileInfo> map) {
        this.lyx.putAll(map);
    }

    public LinkedHashMap<String, ImageFileInfo> dkm() {
        return this.lyx;
    }

    /* loaded from: classes9.dex */
    class a {
        public HeadImageView lyD;
        public ImageView lyE;
        public View rootView;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void ap(View view) {
            this.lyD = (HeadImageView) view.findViewById(R.id.image);
            this.lyE = (ImageView) view.findViewById(R.id.select_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newfaceshop.facemake.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (view2.getTag(view2.getId()) != null && (view2.getTag(view2.getId()) instanceof ImageFileInfo)) {
                        ImageFileInfo imageFileInfo = (ImageFileInfo) view2.getTag(view2.getId());
                        if (g.this.lyx.containsKey(imageFileInfo.getFilePath())) {
                            g.this.lyx.remove(imageFileInfo.getFilePath());
                            ao.setBackgroundResource(a.this.lyE, R.drawable.ic_post_image_selected_n);
                            if (g.this.lxb != null) {
                                g.this.lxb.cCk();
                            }
                        } else if (g.this.lxb != null) {
                            if (g.this.lxb.cCl()) {
                                g.this.lyx.put(imageFileInfo.getFilePath(), imageFileInfo);
                                ao.setBackgroundResource(a.this.lyE, R.drawable.ic_post_image_selected_s);
                                g.this.lxb.cCj();
                                return;
                            }
                            Activity pageActivity = g.this.lyy.getPageContext().getPageActivity();
                            if (!TextUtils.isEmpty(g.this.lyB)) {
                                BdToast.b(pageActivity, g.this.lyB).bue();
                            } else {
                                BdToast.b(pageActivity, pageActivity.getText(R.string.face_group_add_pic_max)).bue();
                            }
                        }
                    }
                }
            });
        }
    }
}
