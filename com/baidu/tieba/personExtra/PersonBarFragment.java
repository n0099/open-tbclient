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
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.s.f0.f;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.e.c.g.c A;
    public final CustomMessageListener B;
    public HttpMessageListener C;
    public HttpMessageListener D;
    public int currentPageIndex;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.m2.c f55710e;

    /* renamed from: f  reason: collision with root package name */
    public int f55711f;

    /* renamed from: g  reason: collision with root package name */
    public String f55712g;

    /* renamed from: h  reason: collision with root package name */
    public PersonBarModel f55713h;
    public boolean hasMore;

    /* renamed from: i  reason: collision with root package name */
    public View f55714i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f55715j;
    public c.a.p0.s.f0.g k;
    public TextView l;
    public ForumData m;
    public NavigationBarShadowView mHostShadowView;
    public BdListView mListView;
    public m mLoadMoreView;
    public NavigationBarShadowView mTaShadowView;
    public boolean n;
    public String o;
    public View p;
    public int pageSize;
    public TextView q;
    public boolean r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public ArrayList<ForumData> x;
    public int y;
    public AbsListView.OnScrollListener z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55716a;

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
            this.f55716a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && this.f55716a.t) {
                c.a.q0.m2.b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.f55716a.J() != null) {
                    if (personBarData != null) {
                        this.f55716a.u = true;
                    }
                    if (this.f55716a.J().getRequestCode() != 23011) {
                        this.f55716a.p.setVisibility(8);
                    } else {
                        if (!this.f55716a.w) {
                            this.f55716a.w = true;
                            PersonBarFragment personBarFragment = this.f55716a;
                            personBarFragment.mListView.addHeaderView(personBarFragment.p);
                        }
                        this.f55716a.p.setVisibility(0);
                    }
                    this.f55716a.update(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55717a;

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
            this.f55717a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f55717a.n = false;
                if (httpResponsedMessage.getError() == 0) {
                    ArrayList<ForumData> i2 = this.f55717a.f55713h.w().i();
                    int k = this.f55717a.f55713h.w().k();
                    if (this.f55717a.f55711f < k) {
                        this.f55717a.f55713h.w().t(k - 1);
                    }
                    if (i2 != null && this.f55717a.f55711f >= 0 && this.f55717a.f55711f < i2.size()) {
                        i2.remove(this.f55717a.f55711f);
                        TbadkCoreApplication.getInst().delLikeForum(this.f55717a.f55712g);
                        if (this.f55717a.f55710e != null) {
                            this.f55717a.checkNodata(true);
                            this.f55717a.f55710e.g(i2);
                            this.f55717a.f55710e.notifyDataSetChanged();
                        }
                    }
                    this.f55717a.showToast(R.string.success);
                    if (this.f55717a.m == null || TextUtils.isEmpty(this.f55717a.m.getId())) {
                        return;
                    }
                    PersonBarFragment personBarFragment = this.f55717a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.m.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c.a.e.e.m.b.f(this.f55717a.m.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.f55717a.m.getName()));
                    return;
                }
                this.f55717a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55717a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55718a;

        /* loaded from: classes7.dex */
        public class a extends h0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PersonBarModel f55719a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f55720b;

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
                this.f55719a = personBarModel;
                this.f55720b = str;
            }

            @Override // c.a.p0.b1.h0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.f55719a;
                    if (personBarModel != null) {
                        personBarModel.A(this.f55720b);
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
            this.f55718a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment personBarFragment;
            m mVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (this.f55718a.J() != null) {
                    m mVar2 = this.f55718a.mLoadMoreView;
                    if (mVar2 != null && mVar2.b() != null) {
                        this.f55718a.mLoadMoreView.b().setVisibility(0);
                    }
                    this.f55718a.mListView.completePullRefreshPostDelayed(0L);
                    this.f55718a.r = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.f55718a.J().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                c.a.q0.m2.b personBarData = personBarResponseMessage.getPersonBarData();
                                this.f55718a.f55713h.B(this.f55718a.currentPageIndex);
                                k0.b(new a(this, this.f55718a.f55713h, personBarResponseMessage.getResultString()), null);
                                this.f55718a.update(personBarData, false);
                                if (1 != this.f55718a.J().getCurrentPageType() || (mVar = (personBarFragment = this.f55718a).mLoadMoreView) == null) {
                                    return;
                                }
                                mVar.f(personBarFragment.o);
                                return;
                            }
                            this.f55718a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.f55718a;
                            m mVar3 = personBarFragment2.mLoadMoreView;
                            if (mVar3 != null) {
                                mVar3.f(personBarFragment2.o);
                                return;
                            }
                            return;
                        }
                        this.f55718a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.f55718a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (this.f55718a.u) {
                            PersonBarFragment personBarFragment3 = this.f55718a;
                            m mVar4 = personBarFragment3.mLoadMoreView;
                            if (mVar4 != null) {
                                mVar4.f(personBarFragment3.o);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.f55718a.mLoadMoreView;
                        if (mVar5 != null) {
                            mVar5.f("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.f55718a;
                m mVar6 = personBarFragment4.mLoadMoreView;
                if (mVar6 != null) {
                    mVar6.f(personBarFragment4.o);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55721e;

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
            this.f55721e = personBarFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (this.f55721e.t) {
                    this.f55721e.mHostShadowView.hide();
                } else {
                    this.f55721e.mTaShadowView.hide();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 1) {
                if (this.f55721e.t) {
                    this.f55721e.mHostShadowView.show();
                } else {
                    this.f55721e.mTaShadowView.show();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55722e;

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
            this.f55722e = personBarFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setNavbarTitleColor(this.f55722e.l, R.color.CAM_X0106, R.color.navi_op_text_skin);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55723e;

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
            this.f55723e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f55723e.f55710e == null) {
                return;
            }
            if (!this.f55723e.f55710e.c()) {
                this.f55723e.f55710e.f(true);
                this.f55723e.l.setText(R.string.done);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.f55723e.y = R.color.navi_op_text_skin;
                } else {
                    this.f55723e.y = R.color.CAM_X0302;
                }
                SkinManager.setViewTextColor(this.f55723e.l, this.f55723e.y, 1);
                this.f55723e.f55710e.notifyDataSetChanged();
                return;
            }
            this.f55723e.f55710e.f(false);
            this.f55723e.l.setText(R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f55723e.y = R.color.navi_op_text_skin;
            } else {
                this.f55723e.y = R.color.CAM_X0106;
            }
            SkinManager.setViewTextColor(this.f55723e.l, this.f55723e.y, 1);
            this.f55723e.f55710e.notifyDataSetChanged();
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55724e;

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
            this.f55724e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55724e.f55711f = ((Integer) view.getTag()).intValue();
                if (this.f55724e.f55711f < 0 || this.f55724e.f55711f >= this.f55724e.f55710e.getCount() || this.f55724e.n) {
                    return;
                }
                PersonBarFragment personBarFragment = this.f55724e;
                personBarFragment.m = (ForumData) personBarFragment.f55710e.getItem(this.f55724e.f55711f);
                if (this.f55724e.m == null || this.f55724e.m.getId() == null || this.f55724e.m.getName() == null) {
                    return;
                }
                PersonBarFragment personBarFragment2 = this.f55724e;
                personBarFragment2.f55712g = personBarFragment2.m.getName();
                this.f55724e.n = true;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                httpMessage.addParam("fid", this.f55724e.m.getId());
                httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f55724e.f55712g);
                httpMessage.addParam("favo_type", String.valueOf(this.f55724e.m.getFavo_type()));
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                this.f55724e.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55725e;

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
            this.f55725e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.f55725e.f55710e.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) this.f55725e.f55710e.getItem(intValue);
            if (this.f55725e.J() != null) {
                this.f55725e.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f55725e.J().getPageContext().getPageActivity(), c.a.e.e.m.b.f(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55726e;

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
            this.f55726e = personBarFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f55726e.f55710e.getItem(i2) == null || this.f55726e.n) {
                return;
            }
            this.f55726e.f55711f = i2;
            ForumData forumData = (ForumData) this.f55726e.f55710e.getItem(i2);
            if (forumData == null || this.f55726e.J() == null) {
                return;
            }
            if (this.f55726e.v) {
                Intent intent = new Intent();
                intent.putExtra(PersonBarActivityConfig.BAR_NAME, forumData.getName());
                intent.putExtra(PersonBarActivityConfig.BAR_ID, forumData.getId());
                PersonBarActivity J = this.f55726e.J();
                this.f55726e.J();
                J.setResult(-1, intent);
                this.f55726e.J().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f55726e.J().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (this.f55726e.t) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            this.f55726e.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes7.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55727e;

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
            this.f55727e = personBarFragment;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f55727e.J() == null) {
                return;
            }
            PersonBarFragment personBarFragment = this.f55727e;
            personBarFragment.currentPageIndex = 1;
            if (personBarFragment.J() == null || this.f55727e.J().getRequestCode() != 23011) {
                this.f55727e.K();
                return;
            }
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(this.f55727e.currentPageIndex);
            requestGetLivableForumList.setPageSize(this.f55727e.pageSize);
            requestGetLivableForumList.setUserId(c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f55727e.sendMessage(requestGetLivableForumList);
        }
    }

    /* loaded from: classes7.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55728e;

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
            this.f55728e = personBarFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonBarFragment personBarFragment = this.f55728e;
                if (personBarFragment.hasMore) {
                    if (personBarFragment.r) {
                        return;
                    }
                    this.f55728e.r = true;
                    this.f55728e.mLoadMoreView.e();
                    if (this.f55728e.J().getRequestCode() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.f55728e.currentPageIndex);
                        requestGetLivableForumList.setPageSize(this.f55728e.pageSize);
                        requestGetLivableForumList.setUserId(c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.f55728e.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.f55728e;
                    personBarFragment2.refreshData(personBarFragment2.currentPageIndex);
                    return;
                }
                personBarFragment.mLoadMoreView.f(personBarFragment.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends c.a.e.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f55729a;

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
            this.f55729a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f55729a.mListView.completePullRefreshPostDelayed(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.f55729a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.neterror));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() == 0) {
                        if (this.f55729a.J() == null || this.f55729a.J().getRequestCode() == 23011) {
                            if (!this.f55729a.w) {
                                this.f55729a.w = true;
                                PersonBarFragment personBarFragment2 = this.f55729a;
                                personBarFragment2.mListView.addHeaderView(personBarFragment2.p);
                                int miniLevel = responseGetLivableForumList.getMiniLevel();
                                if (miniLevel <= 0) {
                                    miniLevel = 0;
                                }
                                this.f55729a.q.setText(this.f55729a.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                                SkinManager.setViewTextColor(this.f55729a.q, R.color.CAM_X0108, 1);
                                SkinManager.setBackgroundColor(this.f55729a.q, R.color.common_color_10238);
                            }
                            this.f55729a.p.setVisibility(0);
                        } else {
                            this.f55729a.p.setVisibility(8);
                        }
                        if (this.f55729a.f55710e != null) {
                            this.f55729a.x.addAll(responseGetLivableForumList.getData());
                            this.f55729a.L();
                            this.f55729a.f55710e.g(this.f55729a.x);
                            this.f55729a.hasMore = responseGetLivableForumList.hasMore();
                            this.f55729a.checkNodata(true);
                            this.f55729a.f55710e.notifyDataSetChanged();
                            this.f55729a.currentPageIndex++;
                            return;
                        }
                        return;
                    }
                    this.f55729a.showToast(responseGetLivableForumList.getErrorString());
                    PersonBarFragment personBarFragment3 = this.f55729a;
                    personBarFragment3.mLoadMoreView.f(personBarFragment3.o);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m extends c.a.e.l.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f55730f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f55731g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f55732h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f55733i;

        /* renamed from: j  reason: collision with root package name */
        public View.OnClickListener f55734j;
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
            this.f55730f = R.color.CAM_X0201;
            this.f55731g = null;
            this.f55732h = null;
            this.f55733i = null;
            this.f55734j = null;
            this.k = null;
            this.f55731g = baseFragmentActivity;
        }

        @Override // c.a.e.l.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f55731g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                inflate.setPadding(0, this.f55731g.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f55731g.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f55732h = (TextView) this.k.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f55730f);
                SkinManager.setBackgroundColor(this.l, this.f55730f);
                this.l.setVisibility(8);
                this.f55733i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.e.l.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f55734j) == null) {
                return;
            }
            onClickListener.onClick(this.k);
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                SkinManager.setBackgroundColor(this.k, this.f55730f, i2);
                SkinManager.setBackgroundColor(this.l, this.f55730f, i2);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f55733i.setVisibility(0);
                this.f55732h.setText(this.f55731g.getPageContext().getPageActivity().getText(R.string.loading));
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
                ProgressBar progressBar = this.f55733i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f55732h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f55732h.setText(str);
                        return;
                    }
                    this.l.setVisibility(8);
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f55731g.getLayoutMode().j(this.l);
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
        c.a.q0.i3.d0.a.b(2001183, c.a.q0.m2.f.class);
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
        this.mHostShadowView = null;
        this.mTaShadowView = null;
        this.mListView = null;
        this.mLoadMoreView = null;
        this.f55710e = null;
        this.f55711f = -1;
        this.f55712g = null;
        this.f55714i = null;
        this.f55715j = null;
        this.k = null;
        this.l = null;
        this.currentPageIndex = 0;
        this.pageSize = 50;
        this.hasMore = false;
        this.m = null;
        this.n = false;
        this.p = null;
        this.r = false;
        this.s = 0;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = new ArrayList<>();
        this.y = R.color.navi_op_text;
        this.z = new d(this);
        this.A = new l(this, 107129);
        this.B = new a(this, 2001183);
        this.C = new b(this, CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
        this.D = new c(this, CmdConfigHttp.PIC_LIKE_BAR_CMD);
    }

    public final void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.mListView != null) {
                    NoDataView noDataView = this.f55715j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.mListView.removeHeaderView(this.f55715j);
                    this.mListView.addHeaderView(this.f55715j);
                }
            } else if (this.mListView != null) {
                NoDataView noDataView2 = this.f55715j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.mListView.removeHeaderView(this.f55715j);
            }
        }
    }

    public final PersonBarActivity J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
            if (baseFragmentActivity instanceof PersonBarActivity) {
                return (PersonBarActivity) baseFragmentActivity;
            }
            return null;
        }
        return (PersonBarActivity) invokeV.objValue;
    }

    public final void K() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personBarModel = this.f55713h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), this.currentPageIndex, this.pageSize);
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashSet hashSet = new HashSet();
            Iterator<ForumData> it = this.x.iterator();
            while (it.hasNext()) {
                if (!hashSet.add(it.next().getId())) {
                    it.remove();
                }
            }
        }
    }

    public void checkNodata(boolean z) {
        c.a.q0.m2.c cVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (cVar = this.f55710e) == null) {
            return;
        }
        cVar.b();
        if (!this.f55710e.d()) {
            D(false);
            this.mListView.setVisibility(0);
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (J() == null || J().getRequestCode() != 23011 || (textView = this.l) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.f55710e.f(false);
            D(true);
            this.mListView.setVisibility(0);
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            m mVar = this.mLoadMoreView;
            if (mVar == null || mVar.b() == null) {
                return;
            }
            this.mLoadMoreView.b().setVisibility(8);
        }
    }

    public c.a.q0.m2.c getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f55710e : (c.a.q0.m2.c) invokeV.objValue;
    }

    public void loadDataFromCache() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (personBarModel = this.f55713h) == null) {
            return;
        }
        personBarModel.y();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.D);
            registerListener(this.C);
            registerListener(this.B);
            registerListener(this.A);
            this.A.setSelfListener(true);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (isAdded()) {
                if (this.f55714i != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().k(i2 == 1);
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f55714i);
                }
                if (this.f55715j != null && getBaseFragmentActivity() != null) {
                    SkinManager.setBackgroundResource(this.f55715j, R.color.CAM_X0201);
                    this.f55715j.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                if (J() != null) {
                    J().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                c.a.p0.s.f0.g gVar = this.k;
                if (gVar != null) {
                    gVar.D(i2);
                }
                c.a.q0.m2.c cVar = this.f55710e;
                if (cVar != null) {
                    cVar.notifyDataSetChanged();
                }
                m mVar = this.mLoadMoreView;
                if (mVar != null) {
                    mVar.d(i2);
                }
                SkinManager.setNavbarTitleColor(this.l, this.y, R.color.navi_op_text_skin);
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
            this.s = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.friend_fragment, viewGroup, false);
            View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.friend_fragment_header, (ViewGroup) null);
            this.p = inflate2;
            this.q = (TextView) inflate2.findViewById(R.id.header_text_describe);
            if (J() == null) {
                return inflate;
            }
            this.o = getString(R.string.person_bar_no_more);
            this.f55713h = J().getModel();
            this.t = J().getIsHost();
            this.v = J().ismIsChooseBarMode();
            this.f55714i = inflate.findViewById(R.id.friend_fragment_parent);
            if (this.t && !this.v) {
                TextView textView = (TextView) J().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, J()).findViewById(R.id.right_textview);
                this.l = textView;
                textView.postDelayed(new e(this), 100L);
                this.l.setText(R.string.edit);
                this.l.setOnClickListener(new f(this));
                this.l.setVisibility(0);
            }
            c.a.q0.m2.c cVar = new c.a.q0.m2.c(J(), this.f55713h.w(), this.t, this.v);
            this.f55710e = cVar;
            cVar.h(J().getSelectedBarId());
            this.f55710e.e(new g(this));
            this.f55710e.i(new h(this));
            this.mHostShadowView = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
            this.mTaShadowView = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.mListView = bdListView;
            bdListView.setAdapter((ListAdapter) this.f55710e);
            this.mListView.setOnItemClickListener(new i(this));
            this.mListView.setOnScrollListener(this.z);
            c.a.p0.s.f0.g gVar = new c.a.p0.s.f0.g(J().getPageContext());
            this.k = gVar;
            gVar.a(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.mLoadMoreView = mVar;
            this.mListView.setNextPage(mVar);
            this.mListView.setOnSrollToBottomListener(new k(this));
            this.mListView.setPullRefresh(this.k);
            if (this.t) {
                BdListViewHelper.d(getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
                dimension = c.a.e.e.p.l.g(getActivity(), R.dimen.ds220);
                string = getString(R.string.person_bar_no_personal_info);
            } else {
                BdListViewHelper.d(getActivity(), this.mListView, BdListViewHelper.HeadType.HASTAB);
                dimension = (int) getResources().getDimension(R.dimen.ds102);
                if (this.s == 0) {
                    string = getString(R.string.person_bar_no_personal_info);
                } else {
                    string = getString(R.string.no_data_common_txt);
                }
            }
            if (this.v) {
                this.f55715j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.share_choose_bar_nothing_tip)), null);
            } else {
                this.f55715j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.t && J() != null && J().getRequestCode() != 23011) {
                loadDataFromCache();
            }
            if (this.s == J().getCurrentPageType()) {
                this.mListView.startPullRefresh();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f55710e != null) {
                this.f55710e = null;
            }
            MessageManager.getInstance().unRegisterListener(this.C);
            MessageManager.getInstance().unRegisterListener(this.D);
            MessageManager.getInstance().unRegisterListener(this.B);
            MessageManager.getInstance().unRegisterListener(this.A);
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
            NoDataView noDataView = this.f55715j;
            if (noDataView != null) {
                noDataView.onActivityStart(getPageContext());
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onStop();
            NoDataView noDataView = this.f55715j;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    public void refreshData(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (personBarModel = this.f55713h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), i2, this.pageSize);
    }

    public void update(c.a.q0.m2.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, bVar, z) == null) || bVar == null) {
            return;
        }
        this.hasMore = bVar.m();
        if (!z) {
            this.mListView.completePullRefreshPostDelayed(0L);
        }
        int likeBarCount = J().getLikeBarCount();
        if (this.f55713h == null || this.f55710e == null) {
            return;
        }
        if (this.s == J().getCurrentPageType()) {
            if (z) {
                this.currentPageIndex = 1;
                this.f55713h.w().r(bVar.l(), bVar.j());
                this.f55713h.w().p(bVar.h(), bVar.f());
                this.f55713h.w().t(bVar.k());
                this.f55713h.w().q(bVar.g());
            } else if (this.currentPageIndex == 1) {
                this.f55713h.w().r(bVar.l(), bVar.j());
                this.f55713h.w().p(bVar.h(), bVar.f());
                this.f55713h.w().t(bVar.k());
                this.f55713h.w().q(bVar.g());
                this.currentPageIndex++;
            } else {
                this.f55713h.w().c(bVar.l(), bVar.j());
                this.f55713h.w().a(bVar.h(), bVar.f());
                this.f55713h.w().d(bVar.k());
                this.f55713h.w().b(bVar.g());
                this.currentPageIndex++;
            }
        }
        if (this.s == 0) {
            this.f55710e.g(this.f55713h.w().i());
        } else {
            this.f55710e.g(this.f55713h.w().e());
        }
        int size = bVar.e() != null ? this.f55713h.w().e().size() : 0;
        if (J() != null) {
            J().updateTabTitle(likeBarCount, size);
        }
        checkNodata(true);
        this.f55710e.notifyDataSetChanged();
    }

    public void refreshData(int i2, int i3) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (personBarModel = this.f55713h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), i2, i3);
    }
}
