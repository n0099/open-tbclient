package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SkinItemView extends LinearLayout {
    private View.OnClickListener aUm;
    private final int ddV;
    private TbImageView ddW;
    private TbImageView ddX;
    private TbImageView ddY;
    private ImageView ddZ;
    private ImageView dea;
    private TextView deb;
    private TextView dec;
    private SkinProgressView ded;
    private a dee;
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
        this.ddV = 10;
        this.aUm = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddV = 10;
        this.aUm = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.ddV = 10;
        this.aUm = new c(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.skin_item_view, this);
        this.ddW = (TbImageView) this.mRootView.findViewById(i.f.skin_image);
        this.ddX = (TbImageView) this.mRootView.findViewById(i.f.skin_permission_icon);
        this.ddX.setDefaultResource(i.e.transparent_bg);
        this.ddX.setDefaultBgResource(i.e.transparent_bg);
        this.ddX.setGifIconSupport(false);
        this.ddY = (TbImageView) this.mRootView.findViewById(i.f.skin_state_icon);
        this.ddY.setDefaultResource(i.e.transparent_bg);
        this.ddY.setDefaultBgResource(i.e.transparent_bg);
        this.ddY.setGifIconSupport(false);
        this.ddZ = (ImageView) this.mRootView.findViewById(i.f.skin_choosed_icon);
        this.dea = (ImageView) this.mRootView.findViewById(i.f.skin_delete_icon);
        this.deb = (TextView) this.mRootView.findViewById(i.f.text_view_skin_name);
        this.dec = (TextView) this.mRootView.findViewById(i.f.text_view_skin_size);
        this.ded = (SkinProgressView) this.mRootView.findViewById(i.f.text_view_skin_use);
        this.ded.setOnClickListener(this.aUm);
        this.ddW.setOnClickListener(this.aUm);
        this.dea.setOnClickListener(this.aUm);
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.getId() == -1) {
                this.ddW.setDefaultResource(i.e.pic_theme_moren);
                this.ddW.setDefaultBgResource(i.e.transparent_bg);
            } else if (bVar.getId() == -2) {
                this.ddW.setDefaultResource(i.e.pic_theme_night);
                this.ddW.setDefaultBgResource(i.e.transparent_bg);
            } else {
                this.ddW.setDefaultResource(i.e.img_default_100);
            }
            this.mSkinData = bVar;
            this.ddW.d(bVar.getPicUrl(), 10, false);
            this.ddX.d(bVar.ayZ(), 10, false);
            this.ddY.d(bVar.aza(), 10, false);
            this.deb.setText(com.baidu.tbadk.util.n.v(bVar.getTitle(), 10));
            this.dec.setText(bVar.getPackageSize());
            this.ded.setSkinData(this.mSkinData);
            if (bVar.aze() && (bVar.getId() < 0 || bVar.Uj() != 7)) {
                this.ddZ.setVisibility(0);
                am.c(this.ddZ, i.e.icon_choose_photo);
            } else {
                this.ddZ.setVisibility(8);
            }
            if (bVar.Uj() == 7 && bVar.getId() > 0) {
                this.dea.setVisibility(0);
                am.c(this.dea, i.e.account_active_account_check);
            } else {
                this.dea.setVisibility(4);
            }
            this.ded.e(bVar.azc(), 0.0f);
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.ded != null) {
            this.ded.setListenerTag(bdUniqueId);
        }
    }

    public void setOnItemClickCallback(a aVar) {
        this.dee = aVar;
    }
}
