package com.baidu.wallet.personal.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponse;
import com.google.android.material.badge.BadgeDrawable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes5.dex */
public class TransRecordsResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -1418345316412035914L;
    public int count;
    public int total_count;
    public TransRecord[] trans_info;

    private void decrypt() {
        TransRecord[] transRecordArr = this.trans_info;
        if (transRecordArr != null) {
            for (TransRecord transRecord : transRecordArr) {
                transRecord.decrypt();
            }
        }
    }

    private void initData() {
        TransRecord[] transRecordArr = this.trans_info;
        if (transRecordArr != null) {
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
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        initData();
        decrypt();
        return true;
    }

    @Override // com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
    }

    public String toString() {
        return "TransRecordsContent [trans_info=" + Arrays.toString(this.trans_info) + ", current_rows=" + this.count + ", total_rows=" + this.total_count + "]";
    }
}
