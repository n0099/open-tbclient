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
import c.a.s0.s.s.j;
import c.a.s0.s.s.m;
import c.a.t0.z2.d;
import c.a.t0.z2.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.WebPManager;
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
/* loaded from: classes12.dex */
public class ReplyLinearLayout extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_REPLY_DEL = "c14538";
    public static final String KEY_REPLY_DEL_CONFIRM = "c14539";
    public static final String KEY_REPLY_MORE = "c14537";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final List<RelativeLayout> f47450e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f47451f;

    /* renamed from: g  reason: collision with root package name */
    public PopupDialog f47452g;

    /* renamed from: h  reason: collision with root package name */
    public ForumManageModel f47453h;

    /* renamed from: i  reason: collision with root package name */
    public m f47454i;

    /* renamed from: j  reason: collision with root package name */
    public PersonPostModel.PostInfoList f47455j;
    public String k;
    public View l;
    public final int m;
    public final int n;
    public j.e o;
    public e p;
    public final View.OnClickListener q;

    /* loaded from: classes12.dex */
    public class a implements j.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyLinearLayout f47456e;

        /* renamed from: com.baidu.tieba.post.ReplyLinearLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class View$OnClickListenerC1959a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f47457e;

            public View$OnClickListenerC1959a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47457e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f47457e.f47456e.f47454i.c().dismiss();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f47458e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47458e = aVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    ReplyLinearLayout replyLinearLayout = this.f47458e.f47456e;
                    replyLinearLayout.p(ReplyLinearLayout.KEY_REPLY_DEL_CONFIRM, replyLinearLayout.k);
                    this.f47458e.f47456e.f47454i.c().dismiss();
                    ReplyLinearLayout replyLinearLayout2 = this.f47458e.f47456e;
                    replyLinearLayout2.n(replyLinearLayout2.k, this.f47458e.f47456e.l);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47456e = replyLinearLayout;
        }

        @Override // c.a.s0.s.s.j.e
        public void onItemClick(j jVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048576, this, jVar, i2, view) == null) || this.f47456e.f47451f == null) {
                return;
            }
            if (this.f47456e.f47452g != null) {
                this.f47456e.f47452g.dismiss();
            }
            Map map = (Map) jVar.e().getTag();
            String[] strArr = (String[]) map.get(Integer.valueOf(d.reply_contents));
            if (strArr == null) {
                return;
            }
            this.f47456e.k = strArr[2];
            this.f47456e.l = (View) map.get(Integer.valueOf(d.reply_index));
            ReplyLinearLayout replyLinearLayout = this.f47456e;
            replyLinearLayout.p(ReplyLinearLayout.KEY_REPLY_DEL, replyLinearLayout.k);
            if (this.f47456e.f47454i == null) {
                ReplyLinearLayout replyLinearLayout2 = this.f47456e;
                replyLinearLayout2.f47454i = new m(replyLinearLayout2.f47451f.getPageActivity());
            }
            this.f47456e.f47454i.s(this.f47456e.f47451f.getString(g.del_post_confirm));
            this.f47456e.f47454i.n(this.f47456e.f47451f.getString(g.del_post_confirm_subtitle));
            this.f47456e.f47454i.l(true);
            this.f47456e.f47454i.p(new TBAlertConfig.a(this.f47456e.f47451f.getString(g.cancel), TBAlertConfig.OperateBtnStyle.SECONDARY, new View$OnClickListenerC1959a(this)), new TBAlertConfig.a(this.f47456e.f47451f.getString(g.delete), TBAlertConfig.OperateBtnStyle.MAIN, new b(this)));
            this.f47456e.f47454i.c().setCanceledOnTouchOutside(false);
            this.f47456e.f47454i.u();
        }
    }

    /* loaded from: classes12.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || this.a.f47451f == null) {
                return;
            }
            new BdTopToast(this.a.f47451f.getPageActivity(), 3000).setIcon(true).setContent(this.a.f47451f.getString(g.delete_success)).show((ViewGroup) this.a.f47451f.getPageActivity().getWindow().getDecorView().getRootView());
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyLinearLayout f47459e;

        public c(ReplyLinearLayout replyLinearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyLinearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47459e = replyLinearLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Map map;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (map = (Map) view.getTag()) == null || (strArr = (String[]) map.get(Integer.valueOf(d.reply_contents))) == null) {
                return;
            }
            if (view.getId() == d.reply_more) {
                this.f47459e.p(ReplyLinearLayout.KEY_REPLY_MORE, strArr[2]);
                if (this.f47459e.f47452g == null) {
                    this.f47459e.f47452g = new PopupDialog(this.f47459e.f47451f);
                    this.f47459e.f47452g.setDefaultContentView(null, new String[]{this.f47459e.f47451f.getString(g.delete)}, this.f47459e.o);
                }
                this.f47459e.f47452g.getDialogView().e().setTag(map);
                this.f47459e.f47452g.showDialog();
                return;
            }
            Context context = this.f47459e.getContext();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(viewGroup.findViewById(d.reply_content));
        d2.z(c.a.t0.z2.b.T_X05);
        d2.v(c.a.t0.z2.a.CAM_X0105);
        d2.A(g.F_X01);
        WebPManager.setPureDrawable((ImageView) viewGroup.findViewById(d.reply_more), c.a.t0.z2.c.icon_pure_pb_more18, c.a.t0.z2.a.CAM_X0111, WebPManager.ResourceStateType.NORMAL_PRESS);
        c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(viewGroup.findViewById(d.reply_time));
        d3.z(c.a.t0.z2.b.T_X09);
        d3.v(c.a.t0.z2.a.CAM_X0109);
        d3.A(g.F_X01);
        c.a.s0.s.u.c.d(viewGroup.findViewById(d.reply_line)).f(c.a.t0.z2.a.CAM_X0203);
    }

    public final void n(String str, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view) == null) || this.f47455j == null) {
            return;
        }
        if (this.f47453h == null) {
            if (this.f47451f == null) {
                return;
            }
            ForumManageModel forumManageModel = new ForumManageModel(this.f47451f);
            this.f47453h = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.p);
        }
        ForumManageModel forumManageModel2 = this.f47453h;
        String valueOf = String.valueOf(this.f47455j.forum_id);
        PersonPostModel.PostInfoList postInfoList = this.f47455j;
        forumManageModel2.S(valueOf, postInfoList.forum_name, String.valueOf(postInfoList.thread_id), str, 1, 0, true, null, false);
        removeView(view);
        this.f47450e.remove(view);
        o();
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                if (i2 == getChildCount() - 1) {
                    getChildAt(i2).findViewById(d.reply_line).setVisibility(4);
                } else {
                    getChildAt(i2).findViewById(d.reply_line).setVisibility(0);
                }
            }
        }
    }

    public final void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            PersonPostModel.PostInfoList postInfoList = this.f47455j;
            if (postInfoList != null) {
                statisticItem.param("tid", postInfoList.thread_id);
                statisticItem.param("fid", this.f47455j.forum_id);
                statisticItem.param("uid", this.f47455j.user_id);
            }
            statisticItem.param("pid", str2);
            statisticItem.eventStat();
        }
    }

    public void setContent(ArrayList<String[]> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            for (int i2 = 0; i2 < arrayList.size() - this.f47450e.size(); i2++) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setLayoutParams(layoutParams);
                int i3 = this.m;
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i3);
                layoutParams2.addRule(11, -1);
                layoutParams2.topMargin = this.n;
                ImageView imageView = new ImageView(getContext());
                imageView.setLayoutParams(layoutParams2);
                imageView.setId(d.reply_more);
                WebPManager.setPureDrawable(imageView, c.a.t0.z2.c.icon_pure_pb_more18, c.a.t0.z2.a.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
                relativeLayout.addView(imageView);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.addRule(0, d.reply_more);
                layoutParams3.topMargin = this.n;
                layoutParams3.rightMargin = n.f(getContext(), c.a.t0.z2.b.tbds78);
                TextView textView = new TextView(getContext());
                textView.setLayoutParams(layoutParams3);
                textView.setId(d.reply_content);
                relativeLayout.addView(textView);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.addRule(3, d.reply_content);
                layoutParams4.topMargin = n.f(getContext(), c.a.t0.z2.b.M_H_X003);
                TextView textView2 = new TextView(getContext());
                textView2.setLayoutParams(layoutParams4);
                textView2.setId(d.reply_time);
                relativeLayout.addView(textView2);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, n.f(getContext(), c.a.t0.z2.b.tbds1));
                layoutParams5.topMargin = n.f(getContext(), c.a.t0.z2.b.tbds26);
                layoutParams5.addRule(3, d.reply_time);
                TextView textView3 = new TextView(getContext());
                textView3.setLayoutParams(layoutParams5);
                textView3.setId(d.reply_line);
                relativeLayout.addView(textView3);
                this.f47450e.add(relativeLayout);
                addView(relativeLayout);
            }
            o();
            for (int i4 = 0; i4 < this.f47450e.size(); i4++) {
                RelativeLayout relativeLayout2 = this.f47450e.get(i4);
                if (i4 < arrayList.size()) {
                    String[] strArr = arrayList.get(i4);
                    m(relativeLayout2);
                    ImageView imageView2 = (ImageView) relativeLayout2.findViewById(d.reply_more);
                    ((TextView) relativeLayout2.findViewById(d.reply_content)).setText(strArr[0]);
                    ((TextView) relativeLayout2.findViewById(d.reply_time)).setText(strArr[4]);
                    HashMap hashMap = new HashMap();
                    hashMap.put(Integer.valueOf(d.reply_contents), strArr);
                    hashMap.put(Integer.valueOf(d.reply_index), relativeLayout2);
                    imageView2.setTag(hashMap);
                    imageView2.setOnClickListener(this.q);
                    relativeLayout2.setVisibility(0);
                    relativeLayout2.setTag(hashMap);
                    relativeLayout2.setOnClickListener(this.q);
                } else {
                    relativeLayout2.setVisibility(8);
                }
            }
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            this.f47451f = tbPageContext;
        }
    }

    public void setPost(PersonPostModel.PostInfoList postInfoList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, postInfoList) == null) {
            this.f47455j = postInfoList;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = n.f(getContext(), c.a.t0.z2.b.tbds50);
        this.n = n.f(getContext(), c.a.t0.z2.b.M_H_X004);
        this.o = new a(this);
        this.p = new b(this);
        this.q = new c(this);
        this.f47450e = new ArrayList();
    }
}
