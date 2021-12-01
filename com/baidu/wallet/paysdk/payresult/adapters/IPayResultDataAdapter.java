package com.baidu.wallet.paysdk.payresult.adapters;

import android.os.Bundle;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes12.dex */
public interface IPayResultDataAdapter {
    void clearDataOnDestroy();

    String getActionBarTextId();

    String getAuthorizeMsg();

    ArrayList<String> getEventValue();

    String getExpectedTime();

    String getLBSPayText();

    PayResultContent getPayResultContent();

    HashMap<String, String> getPaySuccessContents();

    HashMap<String, String> getPayingContents();

    void handleOKBtnOnclick();

    boolean isBelongPaySdk();

    boolean isPaySuccess();

    boolean isShowLBSPayText();

    boolean onCreateCheckInvalide(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    boolean showResultPage();
}
