package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SkinItemView extends LinearLayout {
    private View.OnClickListener aUx;
    private ImageView deA;
    private TextView deB;
    private TextView deC;
    private SkinProgressView deD;
    private a deE;
    private final int dev;
    private TbImageView dew;
    private TbImageView dex;
    private TbImageView dey;
    private ImageView dez;
    private Context mContext;
    private View mRootView;
    private b mSkinData;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, b bVar);

        void a(SkinItemView skinItemView, b bVar);

        void a(SkinProgressView skinProgressView, b bVar);
    }

    public SkinItemView(Context context) {
        super(context);
        this.dev = 10;
        this.aUx = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dev = 10;
        this.aUx = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dev = 10;
        this.aUx = new c(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.skin_item_view, this);
        this.dew = (TbImageView) this.mRootView.findViewById(i.f.skin_image);
        this.dex = (TbImageView) this.mRootView.findViewById(i.f.skin_permission_icon);
        this.dex.setDefaultResource(i.e.transparent_bg);
        this.dex.setDefaultBgResource(i.e.transparent_bg);
        this.dex.setGifIconSupport(false);
        this.dey = (TbImageView) this.mRootView.findViewById(i.f.skin_state_icon);
        this.dey.setDefaultResource(i.e.transparent_bg);
        this.dey.setDefaultBgResource(i.e.transparent_bg);
        this.dey.setGifIconSupport(false);
        this.dez = (ImageView) this.mRootView.findViewById(i.f.skin_choosed_icon);
        this.deA = (ImageView) this.mRootView.findViewById(i.f.skin_delete_icon);
        this.deB = (TextView) this.mRootView.findViewById(i.f.text_view_skin_name);
        this.deC = (TextView) this.mRootView.findViewById(i.f.text_view_skin_size);
        this.deD = (SkinProgressView) this.mRootView.findViewById(i.f.text_view_skin_use);
        this.deD.setOnClickListener(this.aUx);
        this.dew.setOnClickListener(this.aUx);
        this.deA.setOnClickListener(this.aUx);
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.getId() == -1) {
                this.dew.setDefaultResource(i.e.pic_theme_moren);
                this.dew.setDefaultBgResource(i.e.transparent_bg);
            } else if (bVar.getId() == -2) {
                this.dew.setDefaultResource(i.e.pic_theme_night);
                this.dew.setDefaultBgResource(i.e.transparent_bg);
            } else {
                this.dew.setDefaultResource(i.e.img_default_100);
            }
            this.mSkinData = bVar;
            this.dew.d(bVar.getPicUrl(), 10, false);
            this.dex.d(bVar.azf(), 10, false);
            this.dey.d(bVar.azg(), 10, false);
            this.deB.setText(com.baidu.tbadk.util.n.v(bVar.getTitle(), 10));
            this.deC.setText(bVar.getPackageSize());
            this.deD.setSkinData(this.mSkinData);
            if (bVar.azk() && (bVar.getId() < 0 || bVar.Uf() != 7)) {
                this.dez.setVisibility(0);
                an.c(this.dez, i.e.icon_choose_photo);
            } else {
                this.dez.setVisibility(8);
            }
            if (bVar.Uf() == 7 && bVar.getId() > 0) {
                this.deA.setVisibility(0);
                an.c(this.deA, i.e.account_active_account_check);
            } else {
                this.deA.setVisibility(4);
            }
            this.deD.e(bVar.azi(), 0.0f);
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.deD != null) {
            this.deD.setListenerTag(bdUniqueId);
        }
    }

    public void setOnItemClickCallback(a aVar) {
        this.deE = aVar;
    }
}
