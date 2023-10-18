package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.re9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes7.dex */
public class qe9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public TextView b;
    public TbRichTextView c;
    public ViewStub d;
    public View e;
    public ImageView f;
    public View g;
    public re9.a h;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Post a;
        public final /* synthetic */ qe9 b;

        public a(qe9 qe9Var, Post post) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qe9Var, post};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qe9Var;
            this.a = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Post post;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (post = this.a) != null && post.id != null && this.b.h != null) {
                this.b.h.a(String.valueOf(this.a.id));
            }
        }
    }

    public qe9(ViewStub viewStub, re9.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = viewStub;
        this.h = aVar;
    }

    public void d(boolean z) {
        View view2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && (view2 = this.e) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.e == null) {
            View inflate = this.d.inflate();
            this.e = inflate;
            this.a = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09070d);
            this.b = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f09070f);
            this.c = (TbRichTextView) this.e.findViewById(R.id.obfuscated_res_0x7f09070c);
            this.f = (ImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090710);
            this.g = this.e.findViewById(R.id.obfuscated_res_0x7f09070e);
            this.c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public boolean e(Post post, User user) {
        InterceptResult invokeLL;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, post, user)) == null) {
            if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
                b();
                d(true);
                this.b.setText(user.name_show);
                this.f.setOnClickListener(new a(this, post));
                this.a.startLoad(user.portrait, 12, false);
                this.c.setVisibility(0);
                this.c.setText(TbRichTextView.c0(post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLL.booleanValue;
    }
}
