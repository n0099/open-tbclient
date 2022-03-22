package com.baidu.tieba.post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.e;
import c.a.d.f.p.n;
import c.a.o0.r.t.j;
import c.a.o0.r.t.l;
import c.a.o0.r.t.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ReplyLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<RelativeLayout> a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f35632b;

    /* renamed from: c  reason: collision with root package name */
    public j f35633c;

    /* renamed from: d  reason: collision with root package name */
    public ForumManageModel f35634d;

    /* renamed from: e  reason: collision with root package name */
    public o f35635e;

    /* renamed from: f  reason: collision with root package name */
    public PersonPostModel.PostInfoList f35636f;

    /* renamed from: g  reason: collision with root package name */
    public String f35637g;

    /* renamed from: h  reason: collision with root package name */
    public View f35638h;
    public final int i;
    public final int j;
    public l.e k;
    public e l;
    public final View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class a implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyLinearLayout a;

        /* renamed from: com.baidu.tieba.post.ReplyLinearLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1889a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC1889a(a aVar) {
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
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.a.a.f35635e.c().dismiss();
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
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ReplyLinearLayout replyLinearLayout = this.a.a;
                    replyLinearLayout.p("c14539", replyLinearLayout.f35637g);
                    this.a.a.f35635e.c().dismiss();
                    ReplyLinearLayout replyLinearLayout2 = this.a.a;
                    replyLinearLayout2.n(replyLinearLayout2.f35637g, this.a.a.f35638h);
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

        @Override // c.a.o0.r.t.l.e
        public void onItemClick(l lVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i, view) == null) || this.a.f35632b == null) {
                return;
            }
            if (this.a.f35633c != null) {
                this.a.f35633c.dismiss();
            }
            Map map = (Map) lVar.e().getTag();
            String[] strArr = (String[]) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091a5b));
            if (strArr == null) {
                return;
            }
            this.a.f35637g = strArr[2];
            this.a.f35638h = (View) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091a60));
            ReplyLinearLayout replyLinearLayout = this.a;
            replyLinearLayout.p("c14538", replyLinearLayout.f35637g);
            if (this.a.f35635e == null) {
                ReplyLinearLayout replyLinearLayout2 = this.a;
                replyLinearLayout2.f35635e = new o(replyLinearLayout2.f35632b.getPageActivity());
            }
            this.a.f35635e.w(this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f048a));
            this.a.f35635e.p(this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f048b));
            this.a.f35635e.n(true);
            this.a.f35635e.r(new TBAlertConfig.a(this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f036c), TBAlertConfig.OperateBtnStyle.SECONDARY, new View$OnClickListenerC1889a(this)), new TBAlertConfig.a(this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f048e), TBAlertConfig.OperateBtnStyle.MAIN, new b(this)));
            this.a.f35635e.c().setCanceledOnTouchOutside(false);
            this.a.f35635e.y();
        }
    }

    /* loaded from: classes5.dex */
    public class b extends e {
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

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.f35632b == null) {
                return;
            }
            BdTopToast bdTopToast = new BdTopToast(this.a.f35632b.getPageActivity(), 3000);
            bdTopToast.i(true);
            bdTopToast.h(this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f049c));
            bdTopToast.j((ViewGroup) this.a.f35632b.getPageActivity().getWindow().getDecorView().getRootView());
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
        public void onClick(View view) {
            Map map;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (map = (Map) view.getTag()) == null || (strArr = (String[]) map.get(Integer.valueOf((int) R.id.obfuscated_res_0x7f091a5b))) == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f091a68) {
                this.a.p("c14537", strArr[2]);
                if (this.a.f35633c == null) {
                    this.a.f35633c = new j(this.a.f35632b);
                    this.a.f35633c.j(null, new String[]{this.a.f35632b.getString(R.string.obfuscated_res_0x7f0f048e)}, this.a.k);
                }
                this.a.f35633c.g().e().setTag(map);
                this.a.f35633c.m();
                return;
            }
            Context context = this.a.getContext();
            if ("0".equals(strArr[3])) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(context).createNormalCfg(strArr[1], strArr[2], "person_page");
                createNormalCfg.setStartFrom(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(context).createSubPbActivityConfig(strArr[1], strArr[2], "person_post_reply", false, null, false);
            createSubPbActivityConfig.setKeyPageStartFrom(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
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
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void m(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091a5a));
        d2.z(R.dimen.T_X05);
        d2.v(R.color.CAM_X0105);
        d2.A(R.string.F_X01);
        WebPManager.setPureDrawable((ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091a68), R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091a6c));
        d3.z(R.dimen.T_X09);
        d3.v(R.color.CAM_X0109);
        d3.A(R.string.F_X01);
        c.a.o0.r.v.c.d(viewGroup.findViewById(R.id.obfuscated_res_0x7f091a62)).f(R.color.CAM_X0203);
    }

    public final void n(String str, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view) == null) || this.f35636f == null) {
            return;
        }
        if (this.f35634d == null) {
            if (this.f35632b == null) {
                return;
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f35632b);
            this.f35634d = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.l);
        }
        ForumManageModel forumManageModel2 = this.f35634d;
        String valueOf = String.valueOf(this.f35636f.forum_id);
        PersonPostModel.PostInfoList postInfoList = this.f35636f;
        forumManageModel2.U(valueOf, postInfoList.forum_name, String.valueOf(postInfoList.thread_id), str, 1, 0, true, null, false);
        removeView(view);
        this.a.remove(view);
        o();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                if (i == getChildCount() - 1) {
                    getChildAt(i).findViewById(R.id.obfuscated_res_0x7f091a62).setVisibility(4);
                } else {
                    getChildAt(i).findViewById(R.id.obfuscated_res_0x7f091a62).setVisibility(0);
                }
            }
        }
    }

    public final void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            PersonPostModel.PostInfoList postInfoList = this.f35636f;
            if (postInfoList != null) {
                statisticItem.param("tid", postInfoList.thread_id);
                statisticItem.param("fid", this.f35636f.forum_id);
                statisticItem.param("uid", this.f35636f.user_id);
            }
            statisticItem.param("pid", str2);
            statisticItem.eventStat();
        }
    }

    public void setContent(ArrayList<String[]> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            for (int i = 0; i < arrayList.size() - this.a.size(); i++) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(layoutParams);
                int i2 = this.i;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
                layoutParams2.addRule(11, -1);
                layoutParams2.topMargin = this.j;
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams2);
                imageView.setId(R.id.obfuscated_res_0x7f091a68);
                WebPManager.setPureDrawable(imageView, R.drawable.obfuscated_res_0x7f080927, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                relativeLayout.addView(imageView);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.addRule(0, R.id.obfuscated_res_0x7f091a68);
                layoutParams3.topMargin = this.j;
                layoutParams3.rightMargin = n.f(getContext(), R.dimen.tbds78);
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(layoutParams3);
                textView.setId(R.id.obfuscated_res_0x7f091a5a);
                relativeLayout.addView(textView);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(3, R.id.obfuscated_res_0x7f091a5a);
                layoutParams4.topMargin = n.f(getContext(), R.dimen.M_H_X003);
                TextView textView2 = new TextView(getContext());
                textView2.setLayoutParams(layoutParams4);
                textView2.setId(R.id.obfuscated_res_0x7f091a6c);
                relativeLayout.addView(textView2);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, n.f(getContext(), R.dimen.tbds1));
                layoutParams5.topMargin = n.f(getContext(), R.dimen.tbds26);
                layoutParams5.addRule(3, R.id.obfuscated_res_0x7f091a6c);
                TextView textView3 = new TextView(getContext());
                textView3.setLayoutParams(layoutParams5);
                textView3.setId(R.id.obfuscated_res_0x7f091a62);
                relativeLayout.addView(textView3);
                this.a.add(relativeLayout);
                addView(relativeLayout);
            }
            o();
            for (int i3 = 0; i3 < this.a.size(); i3++) {
                RelativeLayout relativeLayout2 = this.a.get(i3);
                if (i3 < arrayList.size()) {
                    String[] strArr = arrayList.get(i3);
                    m(relativeLayout2);
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091a68);
                    ((TextView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091a5a)).setText(strArr[0]);
                    ((TextView) relativeLayout2.findViewById(R.id.obfuscated_res_0x7f091a6c)).setText(strArr[4]);
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf((int) R.id.obfuscated_res_0x7f091a5b), strArr);
                    hashMap.put(Integer.valueOf((int) R.id.obfuscated_res_0x7f091a60), relativeLayout2);
                    imageView2.setTag(hashMap);
                    imageView2.setOnClickListener(this.m);
                    relativeLayout2.setVisibility(0);
                    relativeLayout2.setTag(hashMap);
                    relativeLayout2.setOnClickListener(this.m);
                } else {
                    relativeLayout2.setVisibility(8);
                }
            }
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f35632b = tbPageContext;
        }
    }

    public void setPost(PersonPostModel.PostInfoList postInfoList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, postInfoList) == null) {
            this.f35636f = postInfoList;
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = n.f(getContext(), R.dimen.tbds50);
        this.j = n.f(getContext(), R.dimen.M_H_X004);
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this);
        this.a = new ArrayList();
    }
}
