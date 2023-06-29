package com.baidu.tieba;

import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes6.dex */
public interface jc7 {
    void onError(String str, ErrorData errorData);

    void onNoData(ErrorData errorData);

    void onSucc(String str, List<String> list, List<xn> list2);
}
