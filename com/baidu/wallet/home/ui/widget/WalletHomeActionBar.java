package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class WalletHomeActionBar extends BdActionBar implements com.baidu.wallet.home.ui.a.a {

    /* renamed from: a  reason: collision with root package name */
    public View f24290a;

    /* renamed from: b  reason: collision with root package name */
    public c f24291b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f24292c;

    /* renamed from: d  reason: collision with root package name */
    public String f24293d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f24294e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.wallet.home.ui.b.a f24295f;

    public WalletHomeActionBar(Context context) {
        super(context);
        this.f24294e = BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void hideRightZone() {
        setRightImgZone2Visibility(8);
    }

    public void initHomeActionBar(final Context context) {
        this.f24295f = new com.baidu.wallet.home.ui.b.a(this);
        setLeftImgZone2NotifyTextColor(getResources().getColor(ResUtils.color(context, "wallet_base_whiteColor")));
        View rightZoneView = getRightZoneView();
        this.f24290a = rightZoneView;
        this.f24291b = new c(rightZoneView);
        this.f24292c = (ImageView) findViewById(ResUtils.id(getContext(), "title_right_imgzone2_dot"));
        setSafeIconVisible(false);
        setRightImgZone2OnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.WalletHomeActionBar.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WalletHomeActionBar.this.f24295f != null) {
                    WalletHomeActionBar.this.f24295f.a(context);
                }
            }
        });
        setRightImgZone2Visibility(8);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshMenu(String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, String str2) {
        if (this.f24291b == null) {
            this.f24291b = new c(this.f24290a);
        }
        this.f24291b.a(str, titleItemDataArr, str2);
        this.f24291b.dismiss();
        this.f24291b.notifyMenuSetChanged();
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZone(String str) {
        setRightImgZone2Visibility(0);
        setRightImgZone2Src(str);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZoneDot(boolean z) {
        if (z) {
            this.f24292c.setVisibility(0);
            this.f24292c.setImageResource(ResUtils.drawable(getContext(), "wallet_home_red_star"));
            return;
        }
        this.f24292c.setVisibility(8);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshSafeTip(String str) {
        setTitleCenterSafeTipText(str);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshTitle(String str) {
        setTitle(str);
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void showMenu() {
        c cVar = this.f24291b;
        if (cVar != null) {
            cVar.show();
        }
    }

    public void toRefreshTitleBar(Context context, String str, HomeCfgResponse.TitleConfig titleConfig, String str2) {
        com.baidu.wallet.home.ui.b.a aVar = this.f24295f;
        if (aVar != null) {
            this.f24293d = str2;
            aVar.a(context, str, titleConfig, str2);
        }
    }

    @Override // com.baidu.wallet.home.ui.a.a
    public void refreshRightZone(int i) {
        if (getRightImgZone2ImgView() instanceof NetImageView) {
            ((NetImageView) getRightImgZone2ImgView()).releaseRemoteDrawable();
        }
        setRightImgZone2Visibility(0);
        setRightImgZone2Src(i);
    }

    public WalletHomeActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24294e = BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }

    public WalletHomeActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24294e = BeanConstants.CHANNEL_ID_KUANG.equals(BeanConstants.CHANNEL_ID);
        initHomeActionBar(context);
    }
}
