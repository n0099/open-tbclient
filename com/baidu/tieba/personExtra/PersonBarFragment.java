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
import c.a.q0.c1.k0;
import c.a.q0.c1.n0;
import c.a.q0.r.l0.f;
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
/* loaded from: classes6.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.d.c.g.c A;
    public final CustomMessageListener B;
    public HttpMessageListener C;
    public HttpMessageListener D;
    public int currentPageIndex;

    /* renamed from: e  reason: collision with root package name */
    public c.a.r0.y2.c f45699e;

    /* renamed from: f  reason: collision with root package name */
    public int f45700f;

    /* renamed from: g  reason: collision with root package name */
    public String f45701g;

    /* renamed from: h  reason: collision with root package name */
    public PersonBarModel f45702h;
    public boolean hasMore;

    /* renamed from: i  reason: collision with root package name */
    public View f45703i;

    /* renamed from: j  reason: collision with root package name */
    public NoDataView f45704j;
    public c.a.q0.r.l0.g k;
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

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

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
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001183 && this.a.t) {
                c.a.r0.y2.b personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.a.I() != null) {
                    if (personBarData != null) {
                        this.a.u = true;
                    }
                    if (this.a.I().getRequestCode() != 23011) {
                        this.a.p.setVisibility(8);
                    } else {
                        if (!this.a.w) {
                            this.a.w = true;
                            PersonBarFragment personBarFragment = this.a;
                            personBarFragment.mListView.addHeaderView(personBarFragment.p);
                        }
                        this.a.p.setVisibility(0);
                    }
                    this.a.update(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

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
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.n = false;
                if (httpResponsedMessage.getError() == 0) {
                    ArrayList<ForumData> i2 = this.a.f45702h.w().i();
                    int k = this.a.f45702h.w().k();
                    if (this.a.f45700f < k) {
                        this.a.f45702h.w().t(k - 1);
                    }
                    if (i2 != null && this.a.f45700f >= 0 && this.a.f45700f < i2.size()) {
                        i2.remove(this.a.f45700f);
                        TbadkCoreApplication.getInst().delLikeForum(this.a.f45701g);
                        if (this.a.f45699e != null) {
                            this.a.checkNodata(true);
                            this.a.f45699e.g(i2);
                            this.a.f45699e.notifyDataSetChanged();
                        }
                    }
                    this.a.showToast(R.string.success);
                    if (this.a.m == null || TextUtils.isEmpty(this.a.m.getId())) {
                        return;
                    }
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.m.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(c.a.d.f.m.b.g(this.a.m.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.a.m.getName()));
                    return;
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* loaded from: classes6.dex */
        public class a extends k0<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonBarModel a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f45705b;

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
                this.a = personBarModel;
                this.f45705b = str;
            }

            @Override // c.a.q0.c1.k0
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.a;
                    if (personBarModel != null) {
                        personBarModel.A(this.f45705b);
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
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            PersonBarFragment personBarFragment;
            m mVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (this.a.I() != null) {
                    m mVar2 = this.a.mLoadMoreView;
                    if (mVar2 != null && mVar2.b() != null) {
                        this.a.mLoadMoreView.b().setVisibility(0);
                    }
                    this.a.mListView.completePullRefreshPostDelayed(0L);
                    this.a.r = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.a.I().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                c.a.r0.y2.b personBarData = personBarResponseMessage.getPersonBarData();
                                this.a.f45702h.B(this.a.currentPageIndex);
                                n0.b(new a(this, this.a.f45702h, personBarResponseMessage.getResultString()), null);
                                this.a.update(personBarData, false);
                                if (1 != this.a.I().getCurrentPageType() || (mVar = (personBarFragment = this.a).mLoadMoreView) == null) {
                                    return;
                                }
                                mVar.f(personBarFragment.o);
                                return;
                            }
                            this.a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.a;
                            m mVar3 = personBarFragment2.mLoadMoreView;
                            if (mVar3 != null) {
                                mVar3.f(personBarFragment2.o);
                                return;
                            }
                            return;
                        }
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.neterror) : httpResponsedMessage.getErrorString());
                        if (this.a.u) {
                            PersonBarFragment personBarFragment3 = this.a;
                            m mVar4 = personBarFragment3.mLoadMoreView;
                            if (mVar4 != null) {
                                mVar4.f(personBarFragment3.o);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.a.mLoadMoreView;
                        if (mVar5 != null) {
                            mVar5.f("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.a;
                m mVar6 = personBarFragment4.mLoadMoreView;
                if (mVar6 != null) {
                    mVar6.f(personBarFragment4.o);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45706e;

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
            this.f45706e = personBarFragment;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                if (this.f45706e.t) {
                    this.f45706e.mHostShadowView.hide();
                } else {
                    this.f45706e.mTaShadowView.hide();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) && i2 == 1) {
                if (this.f45706e.t) {
                    this.f45706e.mHostShadowView.show();
                } else {
                    this.f45706e.mTaShadowView.show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45707e;

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
            this.f45707e = personBarFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setNavbarTitleColor(this.f45707e.l, R.color.CAM_X0106, R.color.navi_op_text_skin);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45708e;

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
            this.f45708e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f45708e.f45699e == null) {
                return;
            }
            if (!this.f45708e.f45699e.c()) {
                this.f45708e.f45699e.f(true);
                this.f45708e.l.setText(R.string.done);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.f45708e.y = R.color.navi_op_text_skin;
                } else {
                    this.f45708e.y = R.color.CAM_X0302;
                }
                SkinManager.setViewTextColor(this.f45708e.l, this.f45708e.y, 1);
                this.f45708e.f45699e.notifyDataSetChanged();
                return;
            }
            this.f45708e.f45699e.f(false);
            this.f45708e.l.setText(R.string.edit);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.f45708e.y = R.color.navi_op_text_skin;
            } else {
                this.f45708e.y = R.color.CAM_X0106;
            }
            SkinManager.setViewTextColor(this.f45708e.l, this.f45708e.y, 1);
            this.f45708e.f45699e.notifyDataSetChanged();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45709e;

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
            this.f45709e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45709e.f45700f = ((Integer) view.getTag()).intValue();
                if (this.f45709e.f45700f < 0 || this.f45709e.f45700f >= this.f45709e.f45699e.getCount() || this.f45709e.n) {
                    return;
                }
                PersonBarFragment personBarFragment = this.f45709e;
                personBarFragment.m = (ForumData) personBarFragment.f45699e.getItem(this.f45709e.f45700f);
                if (this.f45709e.m == null || this.f45709e.m.getId() == null || this.f45709e.m.getName() == null) {
                    return;
                }
                PersonBarFragment personBarFragment2 = this.f45709e;
                personBarFragment2.f45701g = personBarFragment2.m.getName();
                this.f45709e.n = true;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                httpMessage.addParam("fid", this.f45709e.m.getId());
                httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.f45709e.f45701g);
                httpMessage.addParam("favo_type", String.valueOf(this.f45709e.m.getFavo_type()));
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                this.f45709e.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45710e;

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
            this.f45710e = personBarFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (intValue = ((Integer) view.getTag()).intValue()) < 0 || intValue >= this.f45710e.f45699e.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) this.f45710e.f45699e.getItem(intValue);
            if (this.f45710e.I() != null) {
                this.f45710e.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f45710e.I().getPageContext().getPageActivity(), c.a.d.f.m.b.g(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45711e;

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
            this.f45711e = personBarFragment;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || this.f45711e.f45699e.getItem(i2) == null || this.f45711e.n) {
                return;
            }
            this.f45711e.f45700f = i2;
            ForumData forumData = (ForumData) this.f45711e.f45699e.getItem(i2);
            if (forumData == null || this.f45711e.I() == null) {
                return;
            }
            if (this.f45711e.v) {
                Intent intent = new Intent();
                intent.putExtra("bar_name", forumData.getName());
                intent.putExtra("bar_id", forumData.getId());
                PersonBarActivity I = this.f45711e.I();
                this.f45711e.I();
                I.setResult(-1, intent);
                this.f45711e.I().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.f45711e.I().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (this.f45711e.t) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            this.f45711e.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes6.dex */
    public class j implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45712e;

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
            this.f45712e = personBarFragment;
        }

        @Override // c.a.q0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f45712e.I() == null) {
                return;
            }
            PersonBarFragment personBarFragment = this.f45712e;
            personBarFragment.currentPageIndex = 1;
            if (personBarFragment.I() == null || this.f45712e.I().getRequestCode() != 23011) {
                this.f45712e.J();
                return;
            }
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(this.f45712e.currentPageIndex);
            requestGetLivableForumList.setPageSize(this.f45712e.pageSize);
            requestGetLivableForumList.setUserId(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.f45712e.sendMessage(requestGetLivableForumList);
        }
    }

    /* loaded from: classes6.dex */
    public class k implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonBarFragment f45713e;

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
            this.f45713e = personBarFragment;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonBarFragment personBarFragment = this.f45713e;
                if (personBarFragment.hasMore) {
                    if (personBarFragment.r) {
                        return;
                    }
                    this.f45713e.r = true;
                    this.f45713e.mLoadMoreView.e();
                    if (this.f45713e.I().getRequestCode() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.f45713e.currentPageIndex);
                        requestGetLivableForumList.setPageSize(this.f45713e.pageSize);
                        requestGetLivableForumList.setUserId(c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.f45713e.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.f45713e;
                    personBarFragment2.refreshData(personBarFragment2.currentPageIndex);
                    return;
                }
                personBarFragment.mLoadMoreView.f(personBarFragment.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends c.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

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
            this.a = personBarFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.mListView.completePullRefreshPostDelayed(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.neterror));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() == 0) {
                        if (this.a.I() == null || this.a.I().getRequestCode() == 23011) {
                            if (!this.a.w) {
                                this.a.w = true;
                                PersonBarFragment personBarFragment2 = this.a;
                                personBarFragment2.mListView.addHeaderView(personBarFragment2.p);
                                int miniLevel = responseGetLivableForumList.getMiniLevel();
                                if (miniLevel <= 0) {
                                    miniLevel = 0;
                                }
                                this.a.q.setText(this.a.getResources().getString(R.string.level_above_six_tip, Integer.valueOf(miniLevel)));
                                SkinManager.setViewTextColor(this.a.q, R.color.CAM_X0108, 1);
                                SkinManager.setBackgroundColor(this.a.q, R.color.common_color_10238);
                            }
                            this.a.p.setVisibility(0);
                        } else {
                            this.a.p.setVisibility(8);
                        }
                        if (this.a.f45699e != null) {
                            this.a.x.addAll(responseGetLivableForumList.getData());
                            this.a.K();
                            this.a.f45699e.g(this.a.x);
                            this.a.hasMore = responseGetLivableForumList.hasMore();
                            this.a.checkNodata(true);
                            this.a.f45699e.notifyDataSetChanged();
                            this.a.currentPageIndex++;
                            return;
                        }
                        return;
                    }
                    this.a.showToast(responseGetLivableForumList.getErrorString());
                    PersonBarFragment personBarFragment3 = this.a;
                    personBarFragment3.mLoadMoreView.f(personBarFragment3.o);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class m extends c.a.d.o.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public int f45714f;

        /* renamed from: g  reason: collision with root package name */
        public BaseFragmentActivity f45715g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f45716h;

        /* renamed from: i  reason: collision with root package name */
        public ProgressBar f45717i;

        /* renamed from: j  reason: collision with root package name */
        public View.OnClickListener f45718j;
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
            this.f45714f = R.color.CAM_X0201;
            this.f45715g = null;
            this.f45716h = null;
            this.f45717i = null;
            this.f45718j = null;
            this.k = null;
            this.f45715g = baseFragmentActivity;
        }

        @Override // c.a.d.o.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f45715g.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.k = inflate;
                inflate.setPadding(0, this.f45715g.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f45715g.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f45716h = (TextView) this.k.findViewById(R.id.pb_more_text);
                this.l = this.k.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.k, this.f45714f);
                SkinManager.setBackgroundColor(this.l, this.f45714f);
                this.l.setVisibility(8);
                this.f45717i = (ProgressBar) this.k.findViewById(R.id.progress);
                h(TbadkCoreApplication.getInst().getSkinType());
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.k;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.d.o.e.b
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f45718j) == null) {
                return;
            }
            onClickListener.onClick(this.k);
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                SkinManager.setBackgroundColor(this.k, this.f45714f, i2);
                SkinManager.setBackgroundColor(this.l, this.f45714f, i2);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f45717i.setVisibility(0);
                this.f45716h.setText(this.f45715g.getPageContext().getPageActivity().getText(R.string.loading));
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
                ProgressBar progressBar = this.f45717i;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.f45716h != null) {
                    if (!z) {
                        this.l.setVisibility(0);
                        this.f45716h.setText(str);
                        return;
                    }
                    this.l.setVisibility(8);
                }
            }
        }

        public void h(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                this.f45715g.getLayoutMode().j(this.l);
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
        c.a.r0.y3.g0.a.b(2001183, c.a.r0.y2.g.class);
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
        this.f45699e = null;
        this.f45700f = -1;
        this.f45701g = null;
        this.f45703i = null;
        this.f45704j = null;
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

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                if (this.mListView != null) {
                    NoDataView noDataView = this.f45704j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.mListView.removeHeaderView(this.f45704j);
                    this.mListView.addHeaderView(this.f45704j);
                }
            } else if (this.mListView != null) {
                NoDataView noDataView2 = this.f45704j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.mListView.removeHeaderView(this.f45704j);
            }
        }
    }

    public final PersonBarActivity I() {
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

    public final void J() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (personBarModel = this.f45702h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), this.currentPageIndex, this.pageSize);
    }

    public final void K() {
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
        c.a.r0.y2.c cVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (cVar = this.f45699e) == null) {
            return;
        }
        cVar.b();
        if (!this.f45699e.d()) {
            H(false);
            this.mListView.setVisibility(0);
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (I() == null || I().getRequestCode() != 23011 || (textView = this.l) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.f45699e.f(false);
            H(true);
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

    public c.a.r0.y2.c getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45699e : (c.a.r0.y2.c) invokeV.objValue;
    }

    public void loadDataFromCache() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (personBarModel = this.f45702h) == null) {
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
                if (this.f45703i != null && getBaseFragmentActivity() != null) {
                    getBaseFragmentActivity().getPageContext().getLayoutMode().k(i2 == 1);
                    getBaseFragmentActivity().getPageContext().getLayoutMode().j(this.f45703i);
                }
                if (this.f45704j != null && getBaseFragmentActivity() != null) {
                    SkinManager.setBackgroundResource(this.f45704j, R.color.CAM_X0201);
                    this.f45704j.onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                if (I() != null) {
                    I().getNavigationBar().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                c.a.q0.r.l0.g gVar = this.k;
                if (gVar != null) {
                    gVar.C(i2);
                }
                c.a.r0.y2.c cVar = this.f45699e;
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
            if (I() == null) {
                return inflate;
            }
            this.o = getString(R.string.person_bar_no_more);
            this.f45702h = I().getModel();
            this.t = I().getIsHost();
            this.v = I().ismIsChooseBarMode();
            this.f45703i = inflate.findViewById(R.id.friend_fragment_parent);
            if (this.t && !this.v) {
                TextView textView = (TextView) I().getNavigationBar().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, I()).findViewById(R.id.right_textview);
                this.l = textView;
                textView.postDelayed(new e(this), 100L);
                this.l.setText(R.string.edit);
                this.l.setOnClickListener(new f(this));
                this.l.setVisibility(0);
            }
            c.a.r0.y2.c cVar = new c.a.r0.y2.c(I(), this.f45702h.w(), this.t, this.v);
            this.f45699e = cVar;
            cVar.h(I().getSelectedBarId());
            this.f45699e.e(new g(this));
            this.f45699e.i(new h(this));
            this.mHostShadowView = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_host_concern_bar);
            this.mTaShadowView = (NavigationBarShadowView) inflate.findViewById(R.id.navi_shadow_view_ta_concern_bar);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.my_friend_list);
            this.mListView = bdListView;
            bdListView.setAdapter((ListAdapter) this.f45699e);
            this.mListView.setOnItemClickListener(new i(this));
            this.mListView.setOnScrollListener(this.z);
            c.a.q0.r.l0.g gVar = new c.a.q0.r.l0.g(I().getPageContext());
            this.k = gVar;
            gVar.a(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.mLoadMoreView = mVar;
            this.mListView.setNextPage(mVar);
            this.mListView.setOnSrollToBottomListener(new k(this));
            this.mListView.setPullRefresh(this.k);
            if (this.t) {
                BdListViewHelper.d(getActivity(), this.mListView, BdListViewHelper.HeadType.DEFAULT);
                dimension = n.f(getActivity(), R.dimen.ds220);
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
                this.f45704j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.share_choose_bar_nothing_tip)), null);
            } else {
                this.f45704j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.t && I() != null && I().getRequestCode() != 23011) {
                loadDataFromCache();
            }
            if (this.s == I().getCurrentPageType()) {
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
            if (this.f45699e != null) {
                this.f45699e = null;
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
            NoDataView noDataView = this.f45704j;
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
            NoDataView noDataView = this.f45704j;
            if (noDataView != null) {
                noDataView.onActivityStop();
            }
        }
    }

    public void refreshData(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (personBarModel = this.f45702h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), i2, this.pageSize);
    }

    public void update(c.a.r0.y2.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, bVar, z) == null) || bVar == null) {
            return;
        }
        this.hasMore = bVar.m();
        if (!z) {
            this.mListView.completePullRefreshPostDelayed(0L);
        }
        int likeBarCount = I().getLikeBarCount();
        if (this.f45702h == null || this.f45699e == null) {
            return;
        }
        if (this.s == I().getCurrentPageType()) {
            if (z) {
                this.currentPageIndex = 1;
                this.f45702h.w().r(bVar.l(), bVar.j());
                this.f45702h.w().p(bVar.h(), bVar.f());
                this.f45702h.w().t(bVar.k());
                this.f45702h.w().q(bVar.g());
            } else if (this.currentPageIndex == 1) {
                this.f45702h.w().r(bVar.l(), bVar.j());
                this.f45702h.w().p(bVar.h(), bVar.f());
                this.f45702h.w().t(bVar.k());
                this.f45702h.w().q(bVar.g());
                this.currentPageIndex++;
            } else {
                this.f45702h.w().c(bVar.l(), bVar.j());
                this.f45702h.w().a(bVar.h(), bVar.f());
                this.f45702h.w().d(bVar.k());
                this.f45702h.w().b(bVar.g());
                this.currentPageIndex++;
            }
        }
        if (this.s == 0) {
            this.f45699e.g(this.f45702h.w().i());
        } else {
            this.f45699e.g(this.f45702h.w().e());
        }
        int size = bVar.e() != null ? this.f45702h.w().e().size() : 0;
        if (I() != null) {
            I().updateTabTitle(likeBarCount, size);
        }
        checkNodata(true);
        this.f45699e.notifyDataSetChanged();
    }

    public void refreshData(int i2, int i3) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) || (personBarModel = this.f45702h) == null) {
            return;
        }
        personBarModel.z(this.t, personBarModel.getId(), i2, i3);
    }
}
