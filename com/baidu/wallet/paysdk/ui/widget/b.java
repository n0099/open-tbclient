package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.wallet.base.widget.BdMenu;
import com.baidu.wallet.base.widget.BdMenuItem;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BdMenu {

    /* renamed from: a  reason: collision with root package name */
    public GetCardInfoResponse.CertificateTypeInfo[] f26457a;

    /* renamed from: b  reason: collision with root package name */
    public CertificateMenuView.b f26458b;

    public b(View view, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        super(view);
        this.f26457a = certificateTypeInfoArr;
        setDismissOnClick(true);
    }

    public void a(CertificateMenuView.b bVar) {
        this.f26458b = bVar;
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        CertificateMenuView certificateMenuView = (CertificateMenuView) view;
        certificateMenuView.setCertificertSelectListener(this.f26458b);
        certificateMenuView.layoutMenu(this.f26457a);
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public View getMenuView(Context context) {
        return new CertificateMenuView(context);
    }

    @Override // com.baidu.wallet.base.widget.BdMenu
    public void showMenu(PopupWindow popupWindow) {
        popupWindow.showAsDropDown(this.mViewToAttach);
    }
}
