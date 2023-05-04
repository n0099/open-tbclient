package com.baidu.tieba.post;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.d15;
import com.baidu.tieba.f15;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.z8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ReplyLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<RelativeLayout> a;
    public TbPageContext<?> b;
    public d15 c;
    public ForumManageModel d;
    public TBAlertBuilder e;
    public PersonPostModel.PostInfoList f;
    public String g;
    public View h;
    public f15.f i;
    public z8 j;
    public final View.OnClickListener k;

    /* loaded from: classes5.dex */
    public class a implements f15.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyLinearLayout a;

        /* renamed from: com.baidu.tieba.post.ReplyLinearLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0400a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0400a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.a.e.d().dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    ReplyLinearLayout replyLinearLayout = this.a.a;
                    replyLinearLayout.p("c14539", replyLinearLayout.g);
                    this.a.a.e.d().dismiss();
                    ReplyLinearLayout replyLinearLayout2 = this.a.a;
                    replyLinearLayout2.n(replyLinearLayout2.g, this.a.a.h);
                }
            }
        }

        public a(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyLinearLayout;
        }

        @Override // com.baidu.tieba.f15.f
        public void N0(f15 f15Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIL(1048576, this, f15Var, i, view2) != null) || this.a.b == null) {
                return;
            }
            if (this.a.c != null) {
                this.a.c.dismiss();
            }
            Map map = (Map) f15Var.e().getTag();
            PersonPostModel.PostInfoContent postInfoContent = (PersonPostModel.PostInfoContent) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091d94));
            if (postInfoContent == null) {
                return;
            }
            this.a.g = postInfoContent.getPostId();
            this.a.h = (View) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091d99));
            ReplyLinearLayout replyLinearLayout = this.a;
            replyLinearLayout.p("c14538", replyLinearLayout.g);
            if (this.a.e == null) {
                ReplyLinearLayout replyLinearLayout2 = this.a;
                replyLinearLayout2.e = new TBAlertBuilder(replyLinearLayout2.b.getPageActivity());
            }
            this.a.e.x(this.a.b.getString(R.string.del_post_confirm));
            this.a.e.q(this.a.b.getString(R.string.obfuscated_res_0x7f0f04e0));
            this.a.e.o(true);
            this.a.e.u(new TBAlertConfig.a(this.a.b.getString(R.string.obfuscated_res_0x7f0f038b), TBAlertConfig.OperateBtnStyle.SECONDARY, new View$OnClickListenerC0400a(this)), new TBAlertConfig.a(this.a.b.getString(R.string.obfuscated_res_0x7f0f04e3), TBAlertConfig.OperateBtnStyle.MAIN, new b(this)));
            this.a.e.d().setCanceledOnTouchOutside(false);
            this.a.e.z();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends z8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyLinearLayout a;

        public b(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyLinearLayout;
        }

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.b != null) {
                BdTopToast bdTopToast = new BdTopToast(this.a.b.getPageActivity(), 3000);
                bdTopToast.h(true);
                bdTopToast.g(this.a.b.getString(R.string.delete_success));
                bdTopToast.i((ViewGroup) this.a.b.getPageActivity().getWindow().getDecorView().getRootView());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyLinearLayout a;

        public c(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyLinearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Map map;
            PersonPostModel.PostInfoContent postInfoContent;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || (map = (Map) view2.getTag()) == null || (postInfoContent = (PersonPostModel.PostInfoContent) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091d94))) == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f091da0) {
                if (TextUtils.isEmpty(postInfoContent.targetScheme) || !UrlManager.getInstance().dealOneLink(this.a.b, new String[]{postInfoContent.targetScheme})) {
                    Context context = this.a.getContext();
                    if (postInfoContent.post_type == 0) {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(postInfoContent.threadId, postInfoContent.getPostId(), "person_page");
                        createNormalCfg.setStartFrom(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                        return;
                    }
                    SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(postInfoContent.threadId, postInfoContent.getPostId(), "person_post_reply", false, null, false);
                    createSubPbActivityConfig.setKeyPageStartFrom(4);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
                    return;
                }
                return;
            }
            this.a.p("c14537", postInfoContent.threadId);
            if (this.a.c == null) {
                this.a.c = new d15(this.a.b);
                this.a.c.i(null, new String[]{this.a.b.getString(R.string.obfuscated_res_0x7f0f04e3)}, this.a.i);
            }
            this.a.c.g().e().setTag(map);
            this.a.c.k();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(590442755, "Lcom/baidu/tieba/post/ReplyLinearLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(590442755, "Lcom/baidu/tieba/post/ReplyLinearLayout;");
                return;
            }
        }
        l = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds50);
        m = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (i == getChildCount() - 1) {
                    getChildAt(i).findViewById(R.id.obfuscated_res_0x7f091d9a).setVisibility(4);
                } else {
                    getChildAt(i).findViewById(R.id.obfuscated_res_0x7f091d9a).setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReplyLinearLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.i = new a(this);
        this.j = new b(this);
        this.k = new c(this);
        this.a = new ArrayList();
    }

    public final void n(String str, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2) != null) || this.f == null) {
            return;
        }
        if (this.d == null) {
            if (this.b == null) {
                return;
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.b);
            this.d = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.j);
        }
        ForumManageModel forumManageModel2 = this.d;
        String valueOf = String.valueOf(this.f.forum_id);
        PersonPostModel.PostInfoList postInfoList = this.f;
        forumManageModel2.r0(valueOf, postInfoList.forum_name, String.valueOf(postInfoList.thread_id), str, 1, 0, true, null, false);
        removeView(view2);
        this.a.remove(view2);
        o();
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void setPost(PersonPostModel.PostInfoList postInfoList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, postInfoList) == null) {
            this.f = postInfoList;
        }
    }

    public final void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, viewGroup) != null) || viewGroup == null) {
            return;
        }
        g35 d = g35.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091d93));
        d.B(R.dimen.T_X05);
        d.w(R.color.CAM_X0105);
        d.C(R.string.F_X01);
        WebPManager.setPureDrawable((ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091da0), R.drawable.icon_pure_pb_more18, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        g35 d2 = g35.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091da4));
        d2.B(R.dimen.T_X09);
        d2.w(R.color.CAM_X0109);
        d2.C(R.string.F_X01);
        g35.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091d9a)).f(R.color.CAM_X0203);
    }

    public final void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            PersonPostModel.PostInfoList postInfoList = this.f;
            if (postInfoList != null) {
                statisticItem.param("tid", postInfoList.thread_id);
                statisticItem.param("fid", this.f.forum_id);
                statisticItem.param("uid", this.f.user_id);
            }
            statisticItem.param("pid", str2);
            statisticItem.eventStat();
        }
    }

    public void setContent(List<PersonPostModel.PostInfoContent> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            for (int i = 0; i < list.size() - this.a.size(); i++) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(layoutParams);
                int i2 = l;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
                layoutParams2.addRule(11, -1);
                layoutParams2.topMargin = m;
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams2);
                imageView.setId(R.id.obfuscated_res_0x7f091da0);
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                relativeLayout.addView(imageView);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.addRule(0, R.id.obfuscated_res_0x7f091da0);
                layoutParams3.topMargin = m;
                layoutParams3.rightMargin = ii.g(getContext(), R.dimen.tbds78);
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(layoutParams3);
                textView.setId(R.id.obfuscated_res_0x7f091d93);
                relativeLayout.addView(textView);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(3, R.id.obfuscated_res_0x7f091d93);
                layoutParams4.topMargin = ii.g(getContext(), R.dimen.M_H_X003);
                TextView textView2 = new TextView(getContext());
                textView2.setLayoutParams(layoutParams4);
                textView2.setId(R.id.obfuscated_res_0x7f091da4);
                relativeLayout.addView(textView2);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, ii.g(getContext(), R.dimen.tbds1));
                layoutParams5.topMargin = ii.g(getContext(), R.dimen.tbds26);
                layoutParams5.addRule(3, R.id.obfuscated_res_0x7f091da4);
                TextView textView3 = new TextView(getContext());
                textView3.setLayoutParams(layoutParams5);
                textView3.setId(R.id.obfuscated_res_0x7f091d9a);
                relativeLayout.addView(textView3);
                this.a.add(relativeLayout);
                addView(relativeLayout);
            }
            o();
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                RelativeLayout relativeLayout2 = this.a.get(i3);
                if (i3 < list.size()) {
                    PersonPostModel.PostInfoContent postInfoContent = list.get(i3);
                    m(relativeLayout2);
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091da0);
                    ((TextView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091d93)).setText(postInfoContent.contentStr);
                    ((TextView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091da4)).setText(postInfoContent.timeStr);
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf((int) R.id.obfuscated_res_0x7f091d94), postInfoContent);
                    hashMap.put(Integer.valueOf((int) R.id.obfuscated_res_0x7f091d99), relativeLayout2);
                    imageView2.setTag(hashMap);
                    imageView2.setOnClickListener(this.k);
                    relativeLayout2.setVisibility(0);
                    relativeLayout2.setTag(hashMap);
                    relativeLayout2.setOnClickListener(this.k);
                } else {
                    relativeLayout2.setVisibility(8);
                }
            }
        }
    }
}
