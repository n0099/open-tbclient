package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.google.android.material.badge.BadgeDrawable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes13.dex */
public class TransRecordsResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1418345316412035914L;
    public transient /* synthetic */ FieldHolder $fh;
    public int count;
    public int total_count;
    public TransRecord[] trans_info;

    public TransRecordsResponse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private void decrypt() {
        TransRecord[] transRecordArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (transRecordArr = this.trans_info) == null) {
            return;
        }
        for (TransRecord transRecord : transRecordArr) {
            transRecord.decrypt();
        }
    }

    private void initData() {
        TransRecord[] transRecordArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (transRecordArr = this.trans_info) == null) {
            return;
        }
        int length = transRecordArr.length;
        String valueOf = String.valueOf(Calendar.getInstance(Locale.CHINA).get(1));
        for (int i2 = 0; i2 < length; i2++) {
            TransRecord[] transRecordArr2 = this.trans_info;
            if (transRecordArr2[i2] != null && !TextUtils.isEmpty(transRecordArr2[i2].create_time) && this.trans_info[i2].create_time.length() > 15) {
                if (this.trans_info[i2].create_time.startsWith(valueOf)) {
                    TransRecord[] transRecordArr3 = this.trans_info;
                    transRecordArr3[i2].mCreateTime = transRecordArr3[i2].create_time.substring(5, 16);
                } else {
                    TransRecord[] transRecordArr4 = this.trans_info;
                    transRecordArr4[i2].mCreateTime = transRecordArr4[i2].create_time.substring(0, 10);
                }
            }
            if (TextUtils.isEmpty(this.trans_info[i2].goods_amount)) {
                this.trans_info[i2].goods_amount = "";
            }
            TransRecord[] transRecordArr5 = this.trans_info;
            if (transRecordArr5[i2].behav == 1) {
                TransRecord transRecord = transRecordArr5[i2];
                transRecord.goods_amount = "-" + this.trans_info[i2].goods_amount;
            } else if (transRecordArr5[i2].behav == 2) {
                TransRecord transRecord2 = transRecordArr5[i2];
                transRecord2.goods_amount = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + this.trans_info[i2].goods_amount;
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            initData();
            decrypt();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "TransRecordsContent [trans_info=" + Arrays.toString(this.trans_info) + ", current_rows=" + this.count + ", total_rows=" + this.total_count + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
