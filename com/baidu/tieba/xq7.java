package com.baidu.tieba;

import com.baidu.tbadk.core.data.ErrorData;
import java.util.List;
/* loaded from: classes9.dex */
public interface xq7 {
    void onError(String str, ErrorData errorData);

    void onNoData(ErrorData errorData);

    void onSucc(String str, List<String> list, List<pi> list2);
}
