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
import c.a.d.f.p.n;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.r.l0.f;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ForumData> A;
    public int B;
    public AbsListView.OnScrollListener C;
    public final c.a.d.c.g.c D;
    public final CustomMessageListener E;
    public HttpMessageListener F;
    public HttpMessageListener G;
    public NavigationBarShadowView a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBarShadowView f35400b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f35401c;

    /* renamed from: d  reason: collision with root package name */
    public m f35402d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.a3.c f35403e;

    /* renamed from: f  reason: collision with root package name */
    public int f35404f;

    /* renamed from: g  reason: collision with root package name */
    public String f35405g;

    /* renamed from: h  reason: collision with root package name */
    public PersonBarModel f35406h;
    public View i;
    public NoDataView j;
    public c.a.o0.r.l0.g k;
    public TextView l;
    public int m;
    public int n;
    public boolean o;
    public ForumData p;
    public boolean q;
    public String r;
    public View s;
    public TextView t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonBarFragment personBarFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && this.a.w) {
                c.a.p0.a3.b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.a.h1() != null) {
                    if (personBarData != null) {
                        this.a.x = true;
                    }
                    if (this.a.h1().getRequestCode() != 23011) {
                        this.a.s.setVisibility(8);
                    } else {
                        if (!this.a.z) {
                            this.a.z = true;
                            PersonBarFragment personBarFragment = this.a;
                            personBarFragment.f35401c.addHeaderView(personBarFragment.s);
                        }
                        this.a.s.setVisibility(0);
                    }
                    this.a.update(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonBarFragment personBarFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.q = false;
                if (httpResponsedMessage.getError() == 0) {
                    ArrayList<ForumData> i = this.a.f35406h.y().i();
                    int k = this.a.f35406h.y().k();
                    if (this.a.f35404f < k) {
                        this.a.f35406h.y().t(k - 1);
                    }
                    if (i != null && this.a.f35404f >= 0 && this.a.f35404f < i.size()) {
                        i.remove(this.a.f35404f);
                        TbadkCoreApplication.getInst().delLikeForum(this.a.f35405g);
                        if (this.a.f35403e != null) {
                            this.a.e1(true);
                            this.a.f35403e.g(i);
                            this.a.f35403e.notifyDataSetChanged();
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f11f1);
                    if (this.a.p == null || TextUtils.isEmpty(this.a.p.getId())) {
                        return;
                    }
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.p.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c.a.d.f.m.b.g(this.a.p.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.a.p.getName()));
                    return;
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* loaded from: classes5.dex */
        public class a extends k0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonBarModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f35407b;

            public a(c cVar, PersonBarModel personBarModel, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, personBarModel, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = personBarModel;
                this.f35407b = str;
            }

            @Override // c.a.o0.c1.k0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.a;
                    if (personBarModel != null) {
                        personBarModel.C(this.f35407b);
                        return null;
                    }
                    return null;
                }
                return invokeV.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonBarFragment personBarFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment personBarFragment;
            m mVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (this.a.h1() != null) {
                    m mVar2 = this.a.f35402d;
                    if (mVar2 != null && mVar2.b() != null) {
                        this.a.f35402d.b().setVisibility(0);
                    }
                    this.a.f35401c.A(0L);
                    this.a.u = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.a.h1().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                c.a.p0.a3.b personBarData = personBarResponseMessage.getPersonBarData();
                                this.a.f35406h.D(this.a.m);
                                n0.b(new a(this, this.a.f35406h, personBarResponseMessage.getResultString()), null);
                                this.a.update(personBarData, false);
                                if (1 != this.a.h1().getCurrentPageType() || (mVar = (personBarFragment = this.a).f35402d) == null) {
                                    return;
                                }
                                mVar.f(personBarFragment.r);
                                return;
                            }
                            this.a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.a;
                            m mVar3 = personBarFragment2.f35402d;
                            if (mVar3 != null) {
                                mVar3.f(personBarFragment2.r);
                                return;
                            }
                            return;
                        }
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c15) : httpResponsedMessage.getErrorString());
                        if (this.a.x) {
                            PersonBarFragment personBarFragment3 = this.a;
                            m mVar4 = personBarFragment3.f35402d;
                            if (mVar4 != null) {
                                mVar4.f(personBarFragment3.r);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.a.f35402d;
                        if (mVar5 != null) {
                            mVar5.f("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.a;
                m mVar6 = personBarFragment4.f35402d;
                if (mVar6 != null) {
                    mVar6.f(personBarFragment4.r);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public d(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (this.a.w) {
                    this.a.a.a();
                } else {
                    this.a.f35400b.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                if (this.a.w) {
                    this.a.a.c();
                } else {
                    this.a.f35400b.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public e(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setNavbarTitleColor(this.a.l, R.color.CAM_X0106, R.color.obfuscated_res_0x7f060861);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public f(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f35403e == null) {
                return;
            }
            if (!this.a.f35403e.c()) {
                this.a.f35403e.f(true);
                this.a.l.setText(R.string.obfuscated_res_0x7f0f04e0);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.a.B = R.color.obfuscated_res_0x7f060861;
                } else {
                    this.a.B = R.color.CAM_X0302;
                }
                SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
                this.a.f35403e.notifyDataSetChanged();
                return;
            }
            this.a.f35403e.f(false);
            this.a.l.setText(R.string.obfuscated_res_0x7f0f050c);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.a.B = R.color.obfuscated_res_0x7f060861;
            } else {
                this.a.B = R.color.CAM_X0106;
            }
            SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
            this.a.f35403e.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public g(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f35404f = ((Integer) view.getTag()).intValue();
                if (this.a.f35404f < 0 || this.a.f35404f >= this.a.f35403e.getCount() || this.a.q) {
                    return;
                }
                PersonBarFragment personBarFragment = this.a;
                personBarFragment.p = (ForumData) personBarFragment.f35403e.getItem(this.a.f35404f);
                if (this.a.p == null || this.a.p.getId() == null || this.a.p.getName() == null) {
                    return;
                }
                PersonBarFragment personBarFragment2 = this.a;
                personBarFragment2.f35405g = personBarFragment2.p.getName();
                this.a.q = true;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                httpMessage.addParam("fid", this.a.p.getId());
                httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.a.f35405g);
                httpMessage.addParam("favo_type", String.valueOf(this.a.p.getFavo_type()));
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                this.a.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public h(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.a.f35403e.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) this.a.f35403e.getItem(intValue);
            if (this.a.h1() != null) {
                this.a.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.h1().getPageContext().getPageActivity(), c.a.d.f.m.b.g(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public i(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.f35403e.getItem(i) == null || this.a.q) {
                return;
            }
            this.a.f35404f = i;
            ForumData forumData = (ForumData) this.a.f35403e.getItem(i);
            if (forumData == null || this.a.h1() == null) {
                return;
            }
            if (this.a.y) {
                Intent intent = new Intent();
                intent.putExtra("bar_name", forumData.getName());
                intent.putExtra("bar_id", forumData.getId());
                PersonBarActivity h1 = this.a.h1();
                this.a.h1();
                h1.setResult(-1, intent);
                this.a.h1().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.h1().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (this.a.w) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes5.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public j(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.h1() == null) {
                return;
            }
            PersonBarFragment personBarFragment = this.a;
            personBarFragment.m = 1;
            if (personBarFragment.h1() == null || this.a.h1().getRequestCode() != 23011) {
                this.a.j1();
                return;
            }
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(this.a.m);
            requestGetLivableForumList.setPageSize(this.a.n);
            requestGetLivableForumList.setUserId(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.a.sendMessage(requestGetLivableForumList);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        public k(PersonBarFragment personBarFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonBarFragment personBarFragment = this.a;
                if (personBarFragment.o) {
                    if (personBarFragment.u) {
                        return;
                    }
                    this.a.u = true;
                    this.a.f35402d.e();
                    if (this.a.h1().getRequestCode() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.a.m);
                        requestGetLivableForumList.setPageSize(this.a.n);
                        requestGetLivableForumList.setUserId(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.a.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.a;
                    personBarFragment2.k1(personBarFragment2.m);
                    return;
                }
                personBarFragment.f35402d.f(personBarFragment.r);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PersonBarFragment personBarFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personBarFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.f35401c.A(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c15));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() == 0) {
                        if (this.a.h1() == null || this.a.h1().getRequestCode() == 23011) {
                            if (!this.a.z) {
                                this.a.z = true;
                                PersonBarFragment personBarFragment2 = this.a;
                                personBarFragment2.f35401c.addHeaderView(personBarFragment2.s);
                                int miniLevel = responseGetLivableForumList.getMiniLevel();
                                if (miniLevel <= 0) {
                                    miniLevel = 0;
                                }
                                this.a.t.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d3, Integer.valueOf(miniLevel)));
                                SkinManager.setViewTextColor(this.a.t, R.color.CAM_X0108, 1);
                                SkinManager.setBackgroundColor(this.a.t, R.color.common_color_10238);
                            }
                            this.a.s.setVisibility(0);
                        } else {
                            this.a.s.setVisibility(8);
                        }
                        if (this.a.f35403e != null) {
                            this.a.A.addAll(responseGetLivableForumList.getData());
                            this.a.l1();
                            this.a.f35403e.g(this.a.A);
                            this.a.o = responseGetLivableForumList.hasMore();
                            this.a.e1(true);
                            this.a.f35403e.notifyDataSetChanged();
                            this.a.m++;
                            return;
                        }
                        return;
                    }
                    this.a.showToast(responseGetLivableForumList.getErrorString());
                    PersonBarFragment personBarFragment3 = this.a;
                    personBarFragment3.f35402d.f(personBarFragment3.r);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m extends c.a.d.o.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public int f35408b;

        /* renamed from: c  reason: collision with root package name */
        public BaseFragmentActivity f35409c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f35410d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f35411e;

        /* renamed from: f  reason: collision with root package name */
        public View.OnClickListener f35412f;

        /* renamed from: g  reason: collision with root package name */
        public View f35413g;

        /* renamed from: h  reason: collision with root package name */
        public View f35414h;

        public m(BaseFragmentActivity baseFragmentActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseFragmentActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35408b = R.color.CAM_X0201;
            this.f35409c = null;
            this.f35410d = null;
            this.f35411e = null;
            this.f35412f = null;
            this.f35413g = null;
            this.f35409c = baseFragmentActivity;
        }

        @Override // c.a.d.o.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f35409c.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
                this.f35413g = inflate;
                inflate.setPadding(0, this.f35409c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, this.f35409c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
                this.f35410d = (TextView) this.f35413g.findViewById(R.id.obfuscated_res_0x7f0916ed);
                this.f35414h = this.f35413g.findViewById(R.id.obfuscated_res_0x7f0916f0);
                SkinManager.setBackgroundColor(this.f35413g, this.f35408b);
                SkinManager.setBackgroundColor(this.f35414h, this.f35408b);
                this.f35414h.setVisibility(8);
                this.f35411e = (ProgressBar) this.f35413g.findViewById(R.id.obfuscated_res_0x7f091929);
                h(TbadkCoreApplication.getInst().getSkinType());
                this.f35414h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f35413g;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.d.o.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f35412f) == null) {
                return;
            }
            onClickListener.onClick(this.f35413g);
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                SkinManager.setBackgroundColor(this.f35413g, this.f35408b, i);
                SkinManager.setBackgroundColor(this.f35414h, this.f35408b, i);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f35411e.setVisibility(0);
                this.f35410d.setText(this.f35409c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a2e));
                this.f35414h.setVisibility(0);
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
                ProgressBar progressBar = this.f35411e;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f35410d != null) {
                    if (!z) {
                        this.f35414h.setVisibility(0);
                        this.f35410d.setText(str);
                        return;
                    }
                    this.f35414h.setVisibility(8);
                }
            }
        }

        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.f35409c.getLayoutMode().j(this.f35414h);
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
        c.a.p0.a4.g0.a.b(2001183, c.a.p0.a3.g.class);
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
        this.a = null;
        this.f35400b = null;
        this.f35401c = null;
        this.f35402d = null;
        this.f35403e = null;
        this.f35404f = -1;
        this.f35405g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = 0;
        this.n = 50;
        this.o = false;
        this.p = null;
        this.q = false;
        this.s = null;
        this.u = false;
        this.v = 0;
        this.w = true;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = new ArrayList<>();
        this.B = R.color.navi_op_text;
        this.C = new d(this);
        this.D = new l(this, 107129);
        this.E = new a(this, 2001183);
        this.F = new b(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
        this.G = new c(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);
    }

    public void e1(boolean z) {
        c.a.p0.a3.c cVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (cVar = this.f35403e) == null) {
            return;
        }
        cVar.b();
        if (!this.f35403e.d()) {
            f1(false);
            this.f35401c.setVisibility(0);
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (h1() == null || h1().getRequestCode() != 23011 || (textView = this.l) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.f35403e.f(false);
            f1(true);
            this.f35401c.setVisibility(0);
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            m mVar = this.f35402d;
            if (mVar == null || mVar.b() == null) {
                return;
            }
            this.f35402d.b().setVisibility(8);
        }
    }

    public final void f1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                if (this.f35401c != null) {
                    NoDataView noDataView = this.j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.f35401c.removeHeaderView(this.j);
                    this.f35401c.addHeaderView(this.j);
                }
            } else if (this.f35401c != null) {
                NoDataView noDataView2 = this.j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.f35401c.removeHeaderView(this.j);
            }
        }
    }

    public c.a.p0.a3.c g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f35403e : (c.a.p0.a3.c) invokeV.objValue;
    }

    public final PersonBarActivity h1() {
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

    public void i1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (personBarModel = this.f35406h) == null) {
            return;
        }
        personBarModel.A();
    }

    public final void j1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (personBarModel = this.f35406h) == null) {
            return;
        }
        personBarModel.B(this.w, personBarModel.getId(), this.m, this.n);
    }

    public void k1(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (personBarModel = this.f35406h) == null) {
            return;
        }
        personBarModel.B(this.w, personBarModel.getId(), i2, this.n);
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            HashSet hashSet = new HashSet();
            Iterator<ForumData> it = this.A.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.G);
            registerListener(this.F);
            registerListener(this.E);
            registerListener(this.D);
            this.D.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.i != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().k(i2 == 1);
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.i);
                }
                if (this.j != null && getBaseFragmentActivity() != null) {
                    SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
                    this.j.f(getBaseFragmentActivity().getPageContext(), i2);
                }
                if (h1() != null) {
                    h1().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                c.a.o0.r.l0.g gVar = this.k;
                if (gVar != null) {
                    gVar.H(i2);
                }
                c.a.p0.a3.c cVar = this.f35403e;
                if (cVar != null) {
                    cVar.notifyDataSetChanged();
                }
                m mVar = this.f35402d;
                if (mVar != null) {
                    mVar.d(i2);
                }
                SkinManager.setNavbarTitleColor(this.l, this.B, R.color.obfuscated_res_0x7f060861);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int dimension;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            this.v = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02f9, viewGroup, false);
            View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02fa, (ViewGroup) null);
            this.s = inflate2;
            this.t = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d42);
            if (h1() == null) {
                return inflate;
            }
            this.r = getString(R.string.obfuscated_res_0x7f0f0ddf);
            this.f35406h = h1().getModel();
            this.w = h1().getIsHost();
            this.y = h1().ismIsChooseBarMode();
            this.i = inflate.findViewById(R.id.obfuscated_res_0x7f090ab3);
            if (this.w && !this.y) {
                TextView textView = (TextView) h1().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d05e4, h1()).findViewById(R.id.obfuscated_res_0x7f091ab8);
                this.l = textView;
                textView.postDelayed(new e(this), 100L);
                this.l.setText(R.string.obfuscated_res_0x7f0f050c);
                this.l.setOnClickListener(new f(this));
                this.l.setVisibility(0);
            }
            c.a.p0.a3.c cVar = new c.a.p0.a3.c(h1(), this.f35406h.y(), this.w, this.y);
            this.f35403e = cVar;
            cVar.h(h1().getSelectedBarId());
            this.f35403e.e(new g(this));
            this.f35403e.i(new h(this));
            this.a = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f091504);
            this.f35400b = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f09150d);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f091497);
            this.f35401c = bdListView;
            bdListView.setAdapter((ListAdapter) this.f35403e);
            this.f35401c.setOnItemClickListener(new i(this));
            this.f35401c.setOnScrollListener(this.C);
            c.a.o0.r.l0.g gVar = new c.a.o0.r.l0.g(h1().getPageContext());
            this.k = gVar;
            gVar.f(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.f35402d = mVar;
            this.f35401c.setNextPage(mVar);
            this.f35401c.setOnSrollToBottomListener(new k(this));
            this.f35401c.setPullRefresh(this.k);
            if (this.w) {
                BdListViewHelper.d(getActivity(), this.f35401c, BdListViewHelper.HeadType.DEFAULT);
                dimension = n.f(getActivity(), R.dimen.obfuscated_res_0x7f070271);
                string = getString(R.string.obfuscated_res_0x7f0f0de0);
            } else {
                BdListViewHelper.d(getActivity(), this.f35401c, BdListViewHelper.HeadType.HASTAB);
                dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07022a);
                if (this.v == 0) {
                    string = getString(R.string.obfuscated_res_0x7f0f0de0);
                } else {
                    string = getString(R.string.obfuscated_res_0x7f0f0c2c);
                }
            }
            if (this.y) {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.obfuscated_res_0x7f0f110c)), null);
            } else {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.w && h1() != null && h1().getRequestCode() != 23011) {
                i1();
            }
            if (this.v == h1().getCurrentPageType()) {
                this.f35401c.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.f35403e != null) {
                this.f35403e = null;
            }
            MessageManager.getInstance().unRegisterListener(this.F);
            MessageManager.getInstance().unRegisterListener(this.G);
            MessageManager.getInstance().unRegisterListener(this.E);
            MessageManager.getInstance().unRegisterListener(this.D);
            super.onDestroyView();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStart();
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.d(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStop();
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public void update(c.a.p0.a3.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, bVar, z) == null) || bVar == null) {
            return;
        }
        this.o = bVar.m();
        if (!z) {
            this.f35401c.A(0L);
        }
        int likeBarCount = h1().getLikeBarCount();
        if (this.f35406h == null || this.f35403e == null) {
            return;
        }
        if (this.v == h1().getCurrentPageType()) {
            if (z) {
                this.m = 1;
                this.f35406h.y().r(bVar.l(), bVar.j());
                this.f35406h.y().p(bVar.h(), bVar.f());
                this.f35406h.y().t(bVar.k());
                this.f35406h.y().q(bVar.g());
            } else if (this.m == 1) {
                this.f35406h.y().r(bVar.l(), bVar.j());
                this.f35406h.y().p(bVar.h(), bVar.f());
                this.f35406h.y().t(bVar.k());
                this.f35406h.y().q(bVar.g());
                this.m++;
            } else {
                this.f35406h.y().c(bVar.l(), bVar.j());
                this.f35406h.y().a(bVar.h(), bVar.f());
                this.f35406h.y().d(bVar.k());
                this.f35406h.y().b(bVar.g());
                this.m++;
            }
        }
        if (this.v == 0) {
            this.f35403e.g(this.f35406h.y().i());
        } else {
            this.f35403e.g(this.f35406h.y().e());
        }
        int size = bVar.e() != null ? this.f35406h.y().e().size() : 0;
        if (h1() != null) {
            h1().updateTabTitle(likeBarCount, size);
        }
        e1(true);
        this.f35403e.notifyDataSetChanged();
    }
}
