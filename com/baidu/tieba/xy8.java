package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.post.ReplyLinearLayout;
import com.baidu.tieba.ry8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class xy8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonPostModel.c a;
    public PersonPostModel b;
    public final String c;
    public BdUniqueId d;
    public String e;
    public TbPageContext<BaseFragmentActivity> f;
    public final PersonPostModel.c g;
    public final ry8.a h;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes7.dex */
    public class a implements PersonPostModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy8 a;

        public a(xy8 xy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy8Var;
        }

        @Override // com.baidu.tieba.personPolymeric.mode.PersonPostModel.c
        public void m0(PersonPostModel personPostModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, personPostModel, z) == null) {
                if (!z) {
                    if (this.a.b != null) {
                        for (int i = 0; i < personPostModel.postList.size(); i++) {
                            if (personPostModel.postList.get(i) instanceof PersonPostModel.PostInfoList) {
                                this.a.b.postList.add(personPostModel.postList.get(i));
                            }
                        }
                    }
                } else {
                    this.a.b = personPostModel;
                    Iterator<gn> it = this.a.b.postList.iterator();
                    while (it.hasNext()) {
                        gn next = it.next();
                        if (next != null && !(next instanceof PersonPostModel.PostInfoList)) {
                            it.remove();
                        }
                    }
                }
                if (this.a.a != null) {
                    this.a.a.m0(personPostModel, z);
                }
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ry8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy8 a;

        public b(xy8 xy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy8Var;
        }

        @Override // com.baidu.tieba.ry8.a
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int id = view2.getId();
                if (id == R.id.obfuscated_res_0x7f091bcf) {
                    ((BaseFragmentActivity) this.a.f.getOrignalPage()).finish();
                } else if (id == R.id.obfuscated_res_0x7f0926e6) {
                    ((BaseFragmentActivity) this.a.f.getOrignalPage()).finish();
                } else if ((id == R.id.obfuscated_res_0x7f091110 || id == R.id.obfuscated_res_0x7f0918ee || id == R.id.obfuscated_res_0x7f09110b || id == R.id.obfuscated_res_0x7f091d96) && this.a.b != null && this.a.f != null && this.a.f.getOrignalPage() != null) {
                    PersonPostModel.PostInfoList h = this.a.h(((Integer) view2.getTag()).intValue());
                    if (TextUtils.isEmpty(h.targetScheme) || !UrlManager.getInstance().dealOneLink(((BaseFragmentActivity) this.a.f.getOrignalPage()).getPageContext(), new String[]{h.targetScheme})) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.f.getPageActivity()).createNormalCfg(String.valueOf(h.thread_id), String.valueOf(h.post_id), "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                    }
                }
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    /* loaded from: classes7.dex */
    public static class c extends ry8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ReplyLinearLayout r;
        public TextView s;
        public View t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view2, TbPageContext<BaseFragmentActivity> tbPageContext) {
            super(view2, tbPageContext);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], (TbPageContext) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = view2.findViewById(R.id.obfuscated_res_0x7f091aa6);
            this.i.setIsRound(true);
            ReplyLinearLayout replyLinearLayout = (ReplyLinearLayout) view2.findViewById(R.id.content_container);
            this.r = replyLinearLayout;
            replyLinearLayout.setPageContext(tbPageContext);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0918ee);
            this.s = textView;
            textView.setOnClickListener(this);
            this.e.setVisibility(8);
        }

        @Override // com.baidu.tieba.ry8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                super.a(i);
                n15 d = n15.d(this.s);
                d.w(R.color.CAM_X0107);
                d.o(R.string.J_X05);
                d.f(R.color.CAM_X0206);
                n15 d2 = n15.d(this.t);
                d2.o(R.string.J_X05);
                d2.f(R.color.CAM_X0201);
            }
        }
    }

    public xy8(TbPageContext<BaseFragmentActivity> tbPageContext, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.h = new b(this);
        this.f = tbPageContext;
        this.c = str;
        this.d = bdUniqueId;
    }

    public PersonPostModel.PostInfoList h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return (PersonPostModel.PostInfoList) this.b.postList.get(i);
        }
        return (PersonPostModel.PostInfoList) invokeI.objValue;
    }

    public void i(PersonPostModel.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.a = cVar;
        }
    }

    public void e() {
        PersonPostModel personPostModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (personPostModel = this.b) != null) {
            personPostModel.cancelLoadData();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        ArrayList<gn> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PersonPostModel personPostModel = this.b;
            if (personPostModel != null && (arrayList = personPostModel.postList) != null) {
                return arrayList.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (this.b == null) {
                PersonPostModel personPostModel = new PersonPostModel(this.f, this.d, null, true, 2);
                this.b = personPostModel;
                personPostModel.setUniqueId(this.d);
            }
            this.b.fetchPost(this.f, this.g, z, this.c, false, true, false, null);
        }
    }

    public final void g(int i, c cVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, cVar, viewGroup) == null) {
            PersonPostModel.PostInfoList h = h(i);
            if (this.e == null) {
                this.e = h.user_portrait;
            }
            cVar.d(h, false, this.e, i);
            cVar.r.setPost(h);
            cVar.r.setContent(h.content);
            if (Pattern.compile("^回复：").matcher(h.title).find()) {
                cVar.s.setText(h.title.replaceFirst("回复：", "原贴："));
            } else {
                cVar.s.setText(h.title);
            }
            OriginalThreadInfo originalThreadInfo = h.originalThreadInfo;
            if (originalThreadInfo != null && !StringUtils.isNull(originalThreadInfo.b)) {
                TextView textView = cVar.s;
                textView.setText("分享：" + h.originalThreadInfo.b);
            }
            cVar.s.setTag(Integer.valueOf(i));
            if (h.thread_type == 33) {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_zhibo), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                cVar.s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            SkinManager.setBackgroundResource(cVar.s, R.drawable.person_post_line);
            SkinManager.setViewTextColor(cVar.s, R.color.common_color_10039, 1);
            int dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5);
            cVar.s.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            cVar.c(this.h);
            cVar.a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0783, viewGroup, false);
                cVar = new c(view2, this.f);
                view2.setTag(cVar);
            } else {
                cVar = (c) view2.getTag();
            }
            if (i == 0) {
                cVar.h.setVisibility(0);
            } else {
                cVar.h.setVisibility(8);
            }
            g(i, cVar, viewGroup);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
