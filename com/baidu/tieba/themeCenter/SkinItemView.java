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
    private View.OnClickListener aUF;
    private final int dgb;
    private TbImageView dgc;
    private TbImageView dgd;
    private TbImageView dge;
    private ImageView dgf;
    private ImageView dgg;
    private TextView dgh;
    private TextView dgi;
    private SkinProgressView dgj;
    private a dgk;
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
        this.dgb = 10;
        this.aUF = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgb = 10;
        this.aUF = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dgb = 10;
        this.aUF = new c(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(i.g.skin_item_view, this);
        this.dgc = (TbImageView) this.mRootView.findViewById(i.f.skin_image);
        this.dgd = (TbImageView) this.mRootView.findViewById(i.f.skin_permission_icon);
        this.dgd.setDefaultResource(i.e.transparent_bg);
        this.dgd.setDefaultBgResource(i.e.transparent_bg);
        this.dgd.setGifIconSupport(false);
        this.dge = (TbImageView) this.mRootView.findViewById(i.f.skin_state_icon);
        this.dge.setDefaultResource(i.e.transparent_bg);
        this.dge.setDefaultBgResource(i.e.transparent_bg);
        this.dge.setGifIconSupport(false);
        this.dgf = (ImageView) this.mRootView.findViewById(i.f.skin_choosed_icon);
        this.dgg = (ImageView) this.mRootView.findViewById(i.f.skin_delete_icon);
        this.dgh = (TextView) this.mRootView.findViewById(i.f.text_view_skin_name);
        this.dgi = (TextView) this.mRootView.findViewById(i.f.text_view_skin_size);
        this.dgj = (SkinProgressView) this.mRootView.findViewById(i.f.text_view_skin_use);
        this.dgj.setOnClickListener(this.aUF);
        this.dgc.setOnClickListener(this.aUF);
        this.dgg.setOnClickListener(this.aUF);
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.getId() == -1) {
                this.dgc.setDefaultResource(i.e.pic_theme_moren);
                this.dgc.setDefaultBgResource(i.e.transparent_bg);
            } else if (bVar.getId() == -2) {
                this.dgc.setDefaultResource(i.e.pic_theme_night);
                this.dgc.setDefaultBgResource(i.e.transparent_bg);
            } else {
                this.dgc.setDefaultResource(i.e.img_default_100);
            }
            this.mSkinData = bVar;
            this.dgc.d(bVar.getPicUrl(), 10, false);
            this.dgd.d(bVar.azV(), 10, false);
            this.dge.d(bVar.azW(), 10, false);
            this.dgh.setText(com.baidu.tbadk.util.n.v(bVar.getTitle(), 10));
            this.dgi.setText(bVar.getPackageSize());
            this.dgj.setSkinData(this.mSkinData);
            if (bVar.aAa() && (bVar.getId() < 0 || bVar.UA() != 7)) {
                this.dgf.setVisibility(0);
                an.c(this.dgf, i.e.icon_choose_photo);
            } else {
                this.dgf.setVisibility(8);
            }
            if (bVar.UA() == 7 && bVar.getId() > 0) {
                this.dgg.setVisibility(0);
                an.c(this.dgg, i.e.account_active_account_check);
            } else {
                this.dgg.setVisibility(4);
            }
            this.dgj.e(bVar.azY(), 0.0f);
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dgj != null) {
            this.dgj.setListenerTag(bdUniqueId);
        }
    }

    public void setOnItemClickCallback(a aVar) {
        this.dgk = aVar;
    }
}
