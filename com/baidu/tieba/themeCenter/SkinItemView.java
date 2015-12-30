package com.baidu.tieba.themeCenter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SkinItemView extends LinearLayout {
    private View.OnClickListener bdQ;
    private int bft;
    private int bfu;
    private TbImageView crQ;
    private TextView crS;
    private final int dLo;
    private TbImageView dLp;
    private TbImageView dLq;
    private ImageView dLr;
    private ImageView dLs;
    private TextView dLt;
    private SkinProgressView dLu;
    private a dLv;
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
        this.dLo = 10;
        this.bdQ = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dLo = 10;
        this.bdQ = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dLo = 10;
        this.bdQ = new c(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bfu = (com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.e.ds88)) / 3;
        this.bft = (int) (this.bfu / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.h.skin_item_view, this);
        this.dLp = (TbImageView) this.mRootView.findViewById(n.g.skin_image);
        this.crQ = (TbImageView) this.mRootView.findViewById(n.g.skin_permission_icon);
        this.crQ.setDefaultResource(n.f.transparent_bg);
        this.crQ.setDefaultBgResource(n.f.transparent_bg);
        this.crQ.setGifIconSupport(false);
        this.dLq = (TbImageView) this.mRootView.findViewById(n.g.skin_state_icon);
        this.dLq.setDefaultResource(n.f.transparent_bg);
        this.dLq.setDefaultBgResource(n.f.transparent_bg);
        this.dLq.setGifIconSupport(false);
        this.dLr = (ImageView) this.mRootView.findViewById(n.g.skin_choosed_icon);
        this.dLs = (ImageView) this.mRootView.findViewById(n.g.skin_delete_icon);
        this.crS = (TextView) this.mRootView.findViewById(n.g.text_view_skin_name);
        this.dLt = (TextView) this.mRootView.findViewById(n.g.text_view_skin_size);
        this.dLu = (SkinProgressView) this.mRootView.findViewById(n.g.text_view_skin_use);
        this.dLu.setOnClickListener(this.bdQ);
        this.dLp.setOnClickListener(this.bdQ);
        this.dLs.setOnClickListener(this.bdQ);
        this.dLp.setMinimumHeight(this.bft);
        this.dLp.setMinimumWidth(this.bfu);
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.getId() == -1) {
                this.dLp.setDefaultBgResource(n.f.transparent_bg);
                this.dLp.setImageResource(n.f.pic_theme_moren);
            } else if (bVar.getId() == -2) {
                this.dLp.setImageResource(n.f.pic_theme_night);
                this.dLp.setDefaultBgResource(n.f.transparent_bg);
            } else {
                this.dLp.setImageBitmap(null);
                this.dLp.setDefaultResource(n.f.img_default_100);
            }
            this.mSkinData = bVar;
            this.dLp.d(bVar.getPicUrl(), 10, false);
            this.crQ.d(bVar.aHr(), 10, false);
            this.dLq.d(bVar.aHs(), 10, false);
            this.crS.setText(com.baidu.tbadk.util.o.x(bVar.getTitle(), 10));
            this.dLt.setText(bVar.getPackageSize());
            this.dLu.setSkinData(this.mSkinData);
            if (bVar.aHw() && (bVar.getId() < 0 || bVar.YL() != 7)) {
                this.dLr.setVisibility(0);
                as.c(this.dLr, n.f.icon_choose_photo);
            } else {
                this.dLr.setVisibility(8);
            }
            if (bVar.YL() == 7 && bVar.getId() > 0) {
                this.dLs.setVisibility(0);
                as.c(this.dLs, n.f.account_active_account_check);
            } else {
                this.dLs.setVisibility(4);
            }
            this.dLu.e(bVar.aHu(), 0.0f);
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dLu != null) {
            this.dLu.setListenerTag(bdUniqueId);
        }
    }

    public void setOnItemClickCallback(a aVar) {
        this.dLv = aVar;
    }
}
