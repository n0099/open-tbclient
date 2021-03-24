package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class WalletMenuLayout extends LinearLayout {

    /* loaded from: classes5.dex */
    public interface a {
        void a(HomeCfgResponse.TitleItemData titleItemData);
    }

    public WalletMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public void setData(Context context, String str, HomeCfgResponse.TitleItemData[] titleItemDataArr, final a aVar) {
        removeAllViews();
        if (titleItemDataArr == null || titleItemDataArr.length <= 0) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        for (final HomeCfgResponse.TitleItemData titleItemData : titleItemDataArr) {
            if (titleItemData != null) {
                View inflate = from.inflate(ResUtils.layout(context, "wallet_home_menu_item_view"), (ViewGroup) null);
                NetImageView netImageView = (NetImageView) inflate.findViewById(ResUtils.id(context, "logo"));
                ((TextView) inflate.findViewById(ResUtils.id(context, "name"))).setText(titleItemData.setting_name);
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append(titleItemData.setting_icon);
                netImageView.setImageUrl(sb.toString());
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.home.ui.widget.WalletMenuLayout.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        aVar.a(titleItemData);
                    }
                });
                addView(inflate);
            }
        }
    }
}
