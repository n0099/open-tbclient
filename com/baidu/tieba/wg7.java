package com.baidu.tieba;

import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes8.dex */
public interface wg7 {
    void onError(String str, ErrorData errorData);

    void onNoData(ErrorData errorData);

    void onSucc(String str, List<String> list, List<cn> list2);
}
