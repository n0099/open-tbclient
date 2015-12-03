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
    private View.OnClickListener aZT;
    private int bbu;
    private int bbv;
    private TbImageView cnN;
    private TextView cnP;
    private final int dDK;
    private TbImageView dDL;
    private TbImageView dDM;
    private ImageView dDN;
    private ImageView dDO;
    private TextView dDP;
    private SkinProgressView dDQ;
    private a dDR;
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
        this.dDK = 10;
        this.aZT = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDK = 10;
        this.aZT = new c(this);
        this.mContext = context;
        initView();
    }

    public SkinItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.dDK = 10;
        this.aZT = new c(this);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.bbv = (com.baidu.adp.lib.util.k.K(this.mContext) - com.baidu.adp.lib.util.k.d(this.mContext, n.d.ds88)) / 3;
        this.bbu = (int) (this.bbv / 0.66d);
        this.mRootView = LayoutInflater.from(this.mContext).inflate(n.g.skin_item_view, this);
        this.dDL = (TbImageView) this.mRootView.findViewById(n.f.skin_image);
        this.cnN = (TbImageView) this.mRootView.findViewById(n.f.skin_permission_icon);
        this.cnN.setDefaultResource(n.e.transparent_bg);
        this.cnN.setDefaultBgResource(n.e.transparent_bg);
        this.cnN.setGifIconSupport(false);
        this.dDM = (TbImageView) this.mRootView.findViewById(n.f.skin_state_icon);
        this.dDM.setDefaultResource(n.e.transparent_bg);
        this.dDM.setDefaultBgResource(n.e.transparent_bg);
        this.dDM.setGifIconSupport(false);
        this.dDN = (ImageView) this.mRootView.findViewById(n.f.skin_choosed_icon);
        this.dDO = (ImageView) this.mRootView.findViewById(n.f.skin_delete_icon);
        this.cnP = (TextView) this.mRootView.findViewById(n.f.text_view_skin_name);
        this.dDP = (TextView) this.mRootView.findViewById(n.f.text_view_skin_size);
        this.dDQ = (SkinProgressView) this.mRootView.findViewById(n.f.text_view_skin_use);
        this.dDQ.setOnClickListener(this.aZT);
        this.dDL.setOnClickListener(this.aZT);
        this.dDO.setOnClickListener(this.aZT);
        this.dDL.setMinimumHeight(this.bbu);
        this.dDL.setMinimumWidth(this.bbv);
    }

    public void a(b bVar) {
        if (bVar != null) {
            if (bVar.getId() == -1) {
                this.dDL.setDefaultBgResource(n.e.transparent_bg);
                this.dDL.setImageResource(n.e.pic_theme_moren);
            } else if (bVar.getId() == -2) {
                this.dDL.setImageResource(n.e.pic_theme_night);
                this.dDL.setDefaultBgResource(n.e.transparent_bg);
            } else {
                this.dDL.setImageBitmap(null);
                this.dDL.setDefaultResource(n.e.img_default_100);
            }
            this.mSkinData = bVar;
            this.dDL.d(bVar.getPicUrl(), 10, false);
            this.cnN.d(bVar.aFc(), 10, false);
            this.dDM.d(bVar.aFd(), 10, false);
            this.cnP.setText(com.baidu.tbadk.util.o.w(bVar.getTitle(), 10));
            this.dDP.setText(bVar.getPackageSize());
            this.dDQ.setSkinData(this.mSkinData);
            if (bVar.aFh() && (bVar.getId() < 0 || bVar.XG() != 7)) {
                this.dDN.setVisibility(0);
                as.c(this.dDN, n.e.icon_choose_photo);
            } else {
                this.dDN.setVisibility(8);
            }
            if (bVar.XG() == 7 && bVar.getId() > 0) {
                this.dDO.setVisibility(0);
                as.c(this.dDO, n.e.account_active_account_check);
            } else {
                this.dDO.setVisibility(4);
            }
            this.dDQ.e(bVar.aFf(), 0.0f);
        }
    }

    public void setListenerTag(BdUniqueId bdUniqueId) {
        if (this.dDQ != null) {
            this.dDQ.setListenerTag(bdUniqueId);
        }
    }

    public void setOnItemClickCallback(a aVar) {
        this.dDR = aVar;
    }
}
