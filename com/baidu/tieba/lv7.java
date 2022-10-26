package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class lv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public TextView c;
    public kv7 d;
    public kv7 e;
    public kv7 f;
    public View g;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str);
    }

    public lv7(Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01d5, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090635);
        this.g = this.b.findViewById(R.id.obfuscated_res_0x7f090632);
        this.a = this.b.findViewById(R.id.obfuscated_res_0x7f090690);
        this.d = new kv7((ViewStub) this.b.findViewById(R.id.obfuscated_res_0x7f090636), aVar);
        this.e = new kv7((ViewStub) this.b.findViewById(R.id.obfuscated_res_0x7f090637), aVar);
        this.f = new kv7((ViewStub) this.b.findViewById(R.id.obfuscated_res_0x7f090638), aVar);
    }

    public final User a(Post post, List list) {
        InterceptResult invokeLL;
        Long l;
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, post, list)) == null) {
            if (post == null || list == null || list.isEmpty() || (l = post.author_id) == null) {
                return null;
            }
            long longValue = l.longValue();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                User user = (User) it.next();
                if (user != null && (l2 = user.id) != null && l2.longValue() == longValue) {
                    return user;
                }
            }
            return null;
        }
        return (User) invokeLL.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundResource(this.b, R.color.common_color_10187);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.c, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            this.d.c();
            this.e.c();
            this.f.c();
        }
    }

    public void d(List list, List list2) {
        boolean z;
        boolean update;
        boolean update2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                this.g.setVisibility(0);
                int size = list.size();
                if (size == 1) {
                    z = this.d.update((Post) list.get(0), a((Post) list.get(0), list2));
                    this.e.d(false);
                    this.f.d(false);
                } else {
                    if (size == 2) {
                        boolean update3 = this.d.update((Post) list.get(0), a((Post) list.get(0), list2));
                        boolean update4 = this.e.update((Post) list.get(1), a((Post) list.get(1), list2));
                        this.f.d(false);
                        update = update4;
                        z = update3;
                        update2 = false;
                    } else if (size >= 3) {
                        boolean update5 = this.d.update((Post) list.get(0), a((Post) list.get(0), list2));
                        update = this.e.update((Post) list.get(1), a((Post) list.get(1), list2));
                        update2 = this.f.update((Post) list.get(2), a((Post) list.get(2), list2));
                        z = update5;
                    } else {
                        z = false;
                    }
                    if (z && !update && !update2) {
                        this.c.setVisibility(8);
                        return;
                    } else {
                        this.c.setVisibility(0);
                        return;
                    }
                }
                update2 = false;
                update = false;
                if (z) {
                }
                this.c.setVisibility(0);
                return;
            }
            this.c.setVisibility(8);
            this.d.d(false);
            this.e.d(false);
            this.f.d(false);
            this.g.setVisibility(8);
        }
    }
}
