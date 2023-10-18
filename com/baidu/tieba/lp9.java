package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BookInfo;
/* loaded from: classes7.dex */
public class lp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public lp9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(BookInfo bookInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bookInfo) != null) || bookInfo == null) {
            return;
        }
        String str = bookInfo.book_id;
        String str2 = bookInfo.title;
        String str3 = bookInfo.cover;
        bookInfo.update_time.intValue();
        bookInfo.book_type.intValue();
        bookInfo.forum_id.longValue();
        bookInfo.total_chapter.intValue();
    }
}
