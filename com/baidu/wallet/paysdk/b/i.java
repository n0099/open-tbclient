package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class i {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static i f25444a = new i();
    }

    public static i a() {
        return a.f25444a;
    }

    public i() {
    }

    public int a(Context context, CardData.BondCard bondCard, boolean z) {
        if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
            return 0;
        }
        if ((context instanceof HalfScreenBaseActivity) || (context instanceof WalletSmsActivity)) {
            if (bondCard != null && 1 == bondCard.is_need_repaired) {
                if ("1".equals(bondCard.need_true_name)) {
                    return 0;
                }
                r2 = "1".equals(bondCard.need_cvv2) ? 1 : 0;
                if (z || "1".equals(bondCard.need_phone_num)) {
                    r2++;
                }
                if ("1".equals(bondCard.need_valid_date)) {
                    r2++;
                }
                if ("1".equals(bondCard.need_identity_code) && "1".equals(bondCard.need_identity_type)) {
                    r2++;
                }
                if (1 == r2 || 2 == r2) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("1");
                    arrayList.add(Integer.toString(r2));
                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
                }
            }
            return r2;
        }
        return 0;
    }

    public int a(Context context, ErrorContentResponse errorContentResponse) {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
            return 0;
        }
        if (((context instanceof HalfScreenBaseActivity) || (context instanceof WalletSmsActivity)) && errorContentResponse != null && errorContentResponse.card_item_required != null && ((certificateTypeInfoArr = errorContentResponse.certificate_type_info) == null || 1 >= certificateTypeInfoArr.length)) {
            int i = "1".equals(errorContentResponse.card_item_required.valid_code) ? 1 : 0;
            if ("1".equals(errorContentResponse.card_item_required.valid_date)) {
                i++;
            }
            if ("1".equals(errorContentResponse.card_item_required.mobile)) {
                i++;
            }
            if ("1".equals(errorContentResponse.card_item_required.certificate_code)) {
                GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = errorContentResponse.certificate_type_info;
                if (1 == certificateTypeInfoArr2.length && "1".equals(certificateTypeInfoArr2[0].type)) {
                    i++;
                }
            }
            if (1 == i || 2 == i) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("2");
                arrayList.add(Integer.toString(i));
                PayStatisticsUtil.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
            }
            return i;
        }
        return 0;
    }
}
