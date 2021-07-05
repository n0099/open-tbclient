package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.ResponseGetLivableForumList;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.f0.f;
import d.a.r0.z0.f0;
import d.a.r0.z0.i0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public ArrayList<ForumData> E;
    public int F;
    public AbsListView.OnScrollListener G;
    public final d.a.c.c.g.c H;
    public final CustomMessageListener I;
    public HttpMessageListener J;
    public HttpMessageListener K;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBarShadowView f20030e;

    /* renamed from: f  reason: collision with root package name */
    public NavigationBarShadowView f20031f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f20032g;

    /* renamed from: h  reason: collision with root package name */
    public m f20033h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.s0.l2.c f20034i;
    public int j;
    public String k;
    public PersonBarModel l;
    public View m;
    public NoDataView n;
    public d.a.r0.r.f0.g o;
    public TextView p;
    public int q;
    public int r;
    public boolean s;
    public ForumData t;
    public boolean u;
    public String v;
    public View w;
    public TextView x;
    public boolean y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20035a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonBarFragment personBarFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20035a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && this.f20035a.A) {
                d.a.s0.l2.b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.f20035a.l1() != null) {
                    if (personBarData != null) {
                        this.f20035a.B = true;
                    }
                    if (this.f20035a.l1().getRequestCode() != 23011) {
                        this.f20035a.w.setVisibility(8);
                    } else {
                        if (!this.f20035a.D) {
                            this.f20035a.D = true;
                            PersonBarFragment personBarFragment = this.f20035a;
                            personBarFragment.f20032g.addHeaderView(personBarFragment.w);
                        }
                        this.f20035a.w.setVisibility(0);
                    }
                    this.f20035a.q1(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20036a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonBarFragment personBarFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20036a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f20036a.u = false;
                if (httpResponsedMessage.getError() == 0) {
                    ArrayList<ForumData> i2 = this.f20036a.l.w().i();
                    int k = this.f20036a.l.w().k();
                    if (this.f20036a.j < k) {
                        this.f20036a.l.w().t(k - 1);
                    }
                    if (i2 != null && this.f20036a.j >= 0 && this.f20036a.j < i2.size()) {
                        i2.remove(this.f20036a.j);
                        TbadkCoreApplication.getInst().delLikeForum(this.f20036a.k);
                        if (this.f20036a.f20034i != null) {
                            this.f20036a.i1(true);
                            this.f20036a.f20034i.g(i2);
                            this.f20036a.f20034i.notifyDataSetChanged();
                        }
                    }
                    this.f20036a.showToast(R.string.success);
                    if (this.f20036a.t == null || TextUtils.isEmpty(this.f20036a.t.getId())) {
                        return;
                    }
                    PersonBarFragment personBarFragment = this.f20036a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.t.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(d.a.c.e.m.b.f(this.f20036a.t.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f20036a.t.getName()));
                    return;
                }
                this.f20036a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20036a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20037a;

        /* loaded from: classes5.dex */
        public class a extends f0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonBarModel f20038a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f20039b;

            public a(c cVar, PersonBarModel personBarModel, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, personBarModel, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20038a = personBarModel;
                this.f20039b = str;
            }

            @Override // d.a.r0.z0.f0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.f20038a;
                    if (personBarModel != null) {
                        personBarModel.A(this.f20039b);
                        return null;
                    }
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonBarFragment personBarFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20037a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment personBarFragment;
            m mVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (this.f20037a.l1() != null) {
                    m mVar2 = this.f20037a.f20033h;
                    if (mVar2 != null && mVar2.b() != null) {
                        this.f20037a.f20033h.b().setVisibility(0);
                    }
                    this.f20037a.f20032g.A(0L);
                    this.f20037a.y = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.f20037a.l1().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                d.a.s0.l2.b personBarData = personBarResponseMessage.getPersonBarData();
                                this.f20037a.l.B(this.f20037a.q);
                                i0.b(new a(this, this.f20037a.l, personBarResponseMessage.getResultString()), null);
                                this.f20037a.q1(personBarData, false);
                                if (1 != this.f20037a.l1().getCurrentPageType() || (mVar = (personBarFragment = this.f20037a).f20033h) == null) {
                                    return;
                                }
                                mVar.f(personBarFragment.v);
                                return;
                            }
                            this.f20037a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.f20037a;
                            m mVar3 = personBarFragment2.f20033h;
                            if (mVar3 != null) {
                                mVar3.f(personBarFragment2.v);
                                return;
                            }
                            return;
                        }
                        this.f20037a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f20037a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (this.f20037a.B) {
                            PersonBarFragment personBarFragment3 = this.f20037a;
                            m mVar4 = personBarFragment3.f20033h;
                            if (mVar4 != null) {
                                mVar4.f(personBarFragment3.v);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.f20037a.f20033h;
                        if (mVar5 != null) {
                            mVar5.f("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.f20037a;
                m mVar6 = personBarFragment4.f20033h;
                if (mVar6 != null) {
                    mVar6.f(personBarFragment4.v);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20040e;

        public d(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20040e = personBarFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (this.f20040e.A) {
                    this.f20040e.f20030e.a();
                } else {
                    this.f20040e.f20031f.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 1) {
                if (this.f20040e.A) {
                    this.f20040e.f20030e.c();
                } else {
                    this.f20040e.f20031f.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20041e;

        public e(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20041e = personBarFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setNavbarTitleColor(this.f20041e.p, R.color.CAM_X0106, R.color.navi_op_text_skin);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20042e;

        public f(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20042e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20042e.f20034i == null) {
                return;
            }
            if (!this.f20042e.f20034i.c()) {
                this.f20042e.f20034i.f(true);
                this.f20042e.p.setText(R.string.done);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.f20042e.F = R.color.navi_op_text_skin;
                } else {
                    this.f20042e.F = R.color.CAM_X0302;
                }
                SkinManager.setViewTextColor(this.f20042e.p, this.f20042e.F, 1);
                this.f20042e.f20034i.notifyDataSetChanged();
                return;
            }
            this.f20042e.f20034i.f(false);
            this.f20042e.p.setText(R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f20042e.F = R.color.navi_op_text_skin;
            } else {
                this.f20042e.F = R.color.CAM_X0106;
            }
            SkinManager.setViewTextColor(this.f20042e.p, this.f20042e.F, 1);
            this.f20042e.f20034i.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20043e;

        public g(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20043e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20043e.j = ((Integer) view.getTag()).intValue();
                if (this.f20043e.j < 0 || this.f20043e.j >= this.f20043e.f20034i.getCount() || this.f20043e.u) {
                    return;
                }
                PersonBarFragment personBarFragment = this.f20043e;
                personBarFragment.t = (ForumData) personBarFragment.f20034i.getItem(this.f20043e.j);
                if (this.f20043e.t == null || this.f20043e.t.getId() == null || this.f20043e.t.getName() == null) {
                    return;
                }
                PersonBarFragment personBarFragment2 = this.f20043e;
                personBarFragment2.k = personBarFragment2.t.getName();
                this.f20043e.u = true;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                httpMessage.addParam("fid", this.f20043e.t.getId());
                httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f20043e.k);
                httpMessage.addParam("favo_type", String.valueOf(this.f20043e.t.getFavo_type()));
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                this.f20043e.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20044e;

        public h(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20044e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.f20044e.f20034i.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) this.f20044e.f20034i.getItem(intValue);
            if (this.f20044e.l1() != null) {
                this.f20044e.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f20044e.l1().getPageContext().getPageActivity(), d.a.c.e.m.b.f(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20045e;

        public i(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20045e = personBarFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f20045e.f20034i.getItem(i2) == null || this.f20045e.u) {
                return;
            }
            this.f20045e.j = i2;
            ForumData forumData = (ForumData) this.f20045e.f20034i.getItem(i2);
            if (forumData == null || this.f20045e.l1() == null) {
                return;
            }
            if (this.f20045e.C) {
                Intent intent = new Intent();
                intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                PersonBarActivity l1 = this.f20045e.l1();
                this.f20045e.l1();
                l1.setResult(-1, intent);
                this.f20045e.l1().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f20045e.l1().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (this.f20045e.A) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            this.f20045e.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20046e;

        public j(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20046e = personBarFragment;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f20046e.l1() == null) {
                return;
            }
            PersonBarFragment personBarFragment = this.f20046e;
            personBarFragment.q = 1;
            if (personBarFragment.l1() == null || this.f20046e.l1().getRequestCode() != 23011) {
                this.f20046e.n1();
                return;
            }
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(this.f20046e.q);
            requestGetLivableForumList.setPageSize(this.f20046e.r);
            requestGetLivableForumList.setUserId(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f20046e.sendMessage(requestGetLivableForumList);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20047e;

        public k(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20047e = personBarFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonBarFragment personBarFragment = this.f20047e;
                if (personBarFragment.s) {
                    if (personBarFragment.y) {
                        return;
                    }
                    this.f20047e.y = true;
                    this.f20047e.f20033h.e();
                    if (this.f20047e.l1().getRequestCode() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.f20047e.q);
                        requestGetLivableForumList.setPageSize(this.f20047e.r);
                        requestGetLivableForumList.setUserId(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.f20047e.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.f20047e;
                    personBarFragment2.o1(personBarFragment2.q);
                    return;
                }
                personBarFragment.f20033h.f(personBarFragment.v);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends d.a.c.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f20048a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PersonBarFragment personBarFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20048a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f20048a.f20032g.A(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.f20048a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.neterror));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() == 0) {
                        if (this.f20048a.l1() == null || this.f20048a.l1().getRequestCode() == 23011) {
                            if (!this.f20048a.D) {
                                this.f20048a.D = true;
                                PersonBarFragment personBarFragment2 = this.f20048a;
                                personBarFragment2.f20032g.addHeaderView(personBarFragment2.w);
                                int miniLevel = responseGetLivableForumList.getMiniLevel();
                                if (miniLevel <= 0) {
                                    miniLevel = 0;
                                }
                                this.f20048a.x.setText(this.f20048a.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                                SkinManager.setViewTextColor(this.f20048a.x, R.color.CAM_X0108, 1);
                                SkinManager.setBackgroundColor(this.f20048a.x, R.color.common_color_10238);
                            }
                            this.f20048a.w.setVisibility(0);
                        } else {
                            this.f20048a.w.setVisibility(8);
                        }
                        if (this.f20048a.f20034i != null) {
                            this.f20048a.E.addAll(responseGetLivableForumList.getData());
                            this.f20048a.p1();
                            this.f20048a.f20034i.g(this.f20048a.E);
                            this.f20048a.s = responseGetLivableForumList.hasMore();
                            this.f20048a.i1(true);
                            this.f20048a.f20034i.notifyDataSetChanged();
                            this.f20048a.q++;
                            return;
                        }
                        return;
                    }
                    this.f20048a.showToast(responseGetLivableForumList.getErrorString());
                    PersonBarFragment personBarFragment3 = this.f20048a;
                    personBarFragment3.f20033h.f(personBarFragment3.v);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends d.a.c.k.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f20049f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f20050g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f20051h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f20052i;
        public View.OnClickListener j;
        public View k;
        public View l;

        public m(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20049f = R.color.CAM_X0201;
            this.f20050g = null;
            this.f20051h = null;
            this.f20052i = null;
            this.j = null;
            this.k = null;
            this.f20050g = baseFragmentActivity;
        }

        @Override // d.a.c.k.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f20050g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                inflate.setPadding(0, this.f20050g.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f20050g.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f20051h = (TextView) this.k.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f20049f);
                SkinManager.setBackgroundColor(this.l, this.f20049f);
                this.l.setVisibility(8);
                this.f20052i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.c.k.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.j) == null) {
                return;
            }
            onClickListener.onClick(this.k);
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                SkinManager.setBackgroundColor(this.k, this.f20049f, i2);
                SkinManager.setBackgroundColor(this.l, this.f20049f, i2);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f20052i.setVisibility(0);
                this.f20051h.setText(this.f20050g.getPageContext().getPageActivity().getText(R.string.loading));
                this.l.setVisibility(0);
            }
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                g(false, str);
            }
        }

        public void g(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048581, this, z, str) == null) {
                ProgressBar progressBar = this.f20052i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f20051h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f20051h.setText(str);
                        return;
                    }
                    this.l.setVisibility(8);
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f20050g.getLayoutMode().j(this.l);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-122982577, "Lcom/baidu/tieba/personExtra/PersonBarFragment;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-122982577, "Lcom/baidu/tieba/personExtra/PersonBarFragment;");
                return;
            }
        }
        d.a.s0.h3.d0.a.b(2001183, d.a.s0.l2.f.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD, TbConfig.SERVER_ADDRESS + TbConfig.UNFAVOLIKE_ADDRESS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public PersonBarFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f20030e = null;
        this.f20031f = null;
        this.f20032g = null;
        this.f20033h = null;
        this.f20034i = null;
        this.j = -1;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        this.r = 50;
        this.s = false;
        this.t = null;
        this.u = false;
        this.w = null;
        this.y = false;
        this.z = 0;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = new ArrayList<>();
        this.F = R.color.navi_op_text;
        this.G = new d(this);
        this.H = new l(this, 107129);
        this.I = new a(this, 2001183);
        this.J = new b(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
        this.K = new c(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);
    }

    public void i1(boolean z) {
        d.a.s0.l2.c cVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cVar = this.f20034i) == null) {
            return;
        }
        cVar.b();
        if (!this.f20034i.d()) {
            j1(false);
            this.f20032g.setVisibility(0);
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (l1() == null || l1().getRequestCode() != 23011 || (textView = this.p) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.f20034i.f(false);
            j1(true);
            this.f20032g.setVisibility(0);
            TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            m mVar = this.f20033h;
            if (mVar == null || mVar.b() == null) {
                return;
            }
            this.f20033h.b().setVisibility(8);
        }
    }

    public final void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                if (this.f20032g != null) {
                    NoDataView noDataView = this.n;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.f20032g.removeHeaderView(this.n);
                    this.f20032g.addHeaderView(this.n);
                }
            } else if (this.f20032g != null) {
                NoDataView noDataView2 = this.n;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.f20032g.removeHeaderView(this.n);
            }
        }
    }

    public d.a.s0.l2.c k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f20034i : (d.a.s0.l2.c) invokeV.objValue;
    }

    public final PersonBarActivity l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonBarActivity) {
                return (PersonBarActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonBarActivity) invokeV.objValue;
    }

    public void m1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (personBarModel = this.l) == null) {
            return;
        }
        personBarModel.y();
    }

    public final void n1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (personBarModel = this.l) == null) {
            return;
        }
        personBarModel.z(this.A, personBarModel.getId(), this.q, this.r);
    }

    public void o1(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (personBarModel = this.l) == null) {
            return;
        }
        personBarModel.z(this.A, personBarModel.getId(), i2, this.r);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.K);
            registerListener(this.J);
            registerListener(this.I);
            registerListener(this.H);
            this.H.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.m != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().k(i2 == 1);
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.m);
                }
                if (this.n != null && getBaseFragmentActivity() != null) {
                    SkinManager.setBackgroundResource(this.n, R.color.CAM_X0201);
                    this.n.f(getBaseFragmentActivity().getPageContext(), i2);
                }
                if (l1() != null) {
                    l1().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                d.a.r0.r.f0.g gVar = this.o;
                if (gVar != null) {
                    gVar.I(i2);
                }
                d.a.s0.l2.c cVar = this.f20034i;
                if (cVar != null) {
                    cVar.notifyDataSetChanged();
                }
                m mVar = this.f20033h;
                if (mVar != null) {
                    mVar.d(i2);
                }
                SkinManager.setNavbarTitleColor(this.p, this.F, R.color.navi_op_text_skin);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int dimension;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, layoutInflater, viewGroup, bundle)) == null) {
            this.z = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
            this.w = inflate2;
            this.x = (TextView) inflate2.findViewById(R.id.header_text_describe);
            if (l1() == null) {
                return inflate;
            }
            this.v = getString(R.string.person_bar_no_more);
            this.l = l1().getModel();
            this.A = l1().getIsHost();
            this.C = l1().ismIsChooseBarMode();
            this.m = inflate.findViewById(R.id.friend_fragment_parent);
            if (this.A && !this.C) {
                TextView textView = (TextView) l1().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, l1()).findViewById(R.id.right_textview);
                this.p = textView;
                textView.postDelayed(new e(this), 100L);
                this.p.setText(R.string.edit);
                this.p.setOnClickListener(new f(this));
                this.p.setVisibility(0);
            }
            d.a.s0.l2.c cVar = new d.a.s0.l2.c(l1(), this.l.w(), this.A, this.C);
            this.f20034i = cVar;
            cVar.h(l1().getSelectedBarId());
            this.f20034i.e(new g(this));
            this.f20034i.i(new h(this));
            this.f20030e = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
            this.f20031f = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.f20032g = bdListView;
            bdListView.setAdapter((ListAdapter) this.f20034i);
            this.f20032g.setOnItemClickListener(new i(this));
            this.f20032g.setOnScrollListener(this.G);
            d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(l1().getPageContext());
            this.o = gVar;
            gVar.a(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.f20033h = mVar;
            this.f20032g.setNextPage(mVar);
            this.f20032g.setOnSrollToBottomListener(new k(this));
            this.f20032g.setPullRefresh(this.o);
            if (this.A) {
                BdListViewHelper.d(getActivity(), this.f20032g, BdListViewHelper.HeadType.DEFAULT);
                dimension = d.a.c.e.p.l.g(getActivity(), R.dimen.ds220);
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                BdListViewHelper.d(getActivity(), this.f20032g, BdListViewHelper.HeadType.HASTAB);
                dimension = (int) getResources().getDimension(R.dimen.ds102);
                if (this.z == 0) {
                    string = getString(R.string.person_bar_no_personal_info);
                } else {
                    string = getString(R.string.no_data_common_txt);
                }
            }
            if (this.C) {
                this.n = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.share_choose_bar_nothing_tip)), null);
            } else {
                this.n = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.A && l1() != null && l1().getRequestCode() != 23011) {
                m1();
            }
            if (this.z == l1().getCurrentPageType()) {
                this.f20032g.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f20034i != null) {
                this.f20034i = null;
            }
            MessageManager.getInstance().unRegisterListener(this.J);
            MessageManager.getInstance().unRegisterListener(this.K);
            MessageManager.getInstance().unRegisterListener(this.I);
            MessageManager.getInstance().unRegisterListener(this.H);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onStart();
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            NoDataView noDataView = this.n;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void p1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HashSet hashSet = new HashSet();
            Iterator<ForumData> it = this.E.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }

    public void q1(d.a.s0.l2.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, bVar, z) == null) || bVar == null) {
            return;
        }
        this.s = bVar.m();
        if (!z) {
            this.f20032g.A(0L);
        }
        int likeBarCount = l1().getLikeBarCount();
        if (this.l == null || this.f20034i == null) {
            return;
        }
        if (this.z == l1().getCurrentPageType()) {
            if (z) {
                this.q = 1;
                this.l.w().r(bVar.l(), bVar.j());
                this.l.w().p(bVar.h(), bVar.f());
                this.l.w().t(bVar.k());
                this.l.w().q(bVar.g());
            } else if (this.q == 1) {
                this.l.w().r(bVar.l(), bVar.j());
                this.l.w().p(bVar.h(), bVar.f());
                this.l.w().t(bVar.k());
                this.l.w().q(bVar.g());
                this.q++;
            } else {
                this.l.w().c(bVar.l(), bVar.j());
                this.l.w().a(bVar.h(), bVar.f());
                this.l.w().d(bVar.k());
                this.l.w().b(bVar.g());
                this.q++;
            }
        }
        if (this.z == 0) {
            this.f20034i.g(this.l.w().i());
        } else {
            this.f20034i.g(this.l.w().e());
        }
        int size = bVar.e() != null ? this.l.w().e().size() : 0;
        if (l1() != null) {
            l1().updateTabTitle(likeBarCount, size);
        }
        i1(true);
        this.f20034i.notifyDataSetChanged();
    }
}
