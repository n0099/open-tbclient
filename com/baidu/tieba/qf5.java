package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Page;
/* loaded from: classes5.dex */
public class qf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public Object c;

    public qf5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
    }

    public void a(Page page) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, page) != null) || page == null) {
            return;
        }
        if (page.has_more.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.b = z;
        page.has_prev.intValue();
        this.a = page.current_page.intValue();
        page.page_size.intValue();
        page.total_page.intValue();
        page.offset.intValue();
        page.total_count.intValue();
        lg5.b("parserProto--->currentPage=" + this.a + ",hasMore=" + this.b);
    }
}
