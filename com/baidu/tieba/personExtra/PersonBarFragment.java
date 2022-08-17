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
import com.repackage.av4;
import com.repackage.bv4;
import com.repackage.cb;
import com.repackage.cf5;
import com.repackage.cn;
import com.repackage.gf5;
import com.repackage.jk8;
import com.repackage.og;
import com.repackage.q48;
import com.repackage.qi;
import com.repackage.r48;
import com.repackage.u48;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class PersonBarFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ForumData> A;
    public int B;
    public AbsListView.OnScrollListener C;
    public final cb D;
    public final CustomMessageListener E;
    public HttpMessageListener F;
    public HttpMessageListener G;
    public NavigationBarShadowView a;
    public NavigationBarShadowView b;
    public BdListView c;
    public m d;
    public r48 e;
    public int f;
    public String g;
    public PersonBarModel h;
    public View i;
    public NoDataView j;
    public bv4 k;
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

    /* loaded from: classes4.dex */
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
                q48 personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.a.X1() != null) {
                    if (personBarData != null) {
                        this.a.x = true;
                    }
                    if (this.a.X1().o1() != 23011) {
                        this.a.s.setVisibility(8);
                    } else {
                        if (!this.a.z) {
                            this.a.z = true;
                            PersonBarFragment personBarFragment = this.a;
                            personBarFragment.c.addHeaderView(personBarFragment.s);
                        }
                        this.a.s.setVisibility(0);
                    }
                    this.a.update(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    ArrayList<ForumData> i = this.a.h.z().i();
                    int k = this.a.h.z().k();
                    if (this.a.f < k) {
                        this.a.h.z().t(k - 1);
                    }
                    if (i != null && this.a.f >= 0 && this.a.f < i.size()) {
                        i.remove(this.a.f);
                        TbadkCoreApplication.getInst().delLikeForum(this.a.g);
                        if (this.a.e != null) {
                            this.a.U1(true);
                            this.a.e.g(i);
                            this.a.e.notifyDataSetChanged();
                        }
                    }
                    this.a.showToast(R.string.obfuscated_res_0x7f0f121c);
                    if (this.a.p == null || TextUtils.isEmpty(this.a.p.getId())) {
                        return;
                    }
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.p.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(og.g(this.a.p.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.a.p.getName()));
                    return;
                }
                this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d) : httpResponsedMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* loaded from: classes4.dex */
        public class a extends cf5<Object> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PersonBarModel a;
            public final /* synthetic */ String b;

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
                this.b = str;
            }

            @Override // com.repackage.cf5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.a;
                    if (personBarModel != null) {
                        personBarModel.D(this.b);
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
                if (this.a.X1() != null) {
                    m mVar2 = this.a.d;
                    if (mVar2 != null && mVar2.b() != null) {
                        this.a.d.b().setVisibility(0);
                    }
                    this.a.c.A(0L);
                    this.a.u = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.a.X1().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                q48 personBarData = personBarResponseMessage.getPersonBarData();
                                this.a.h.E(this.a.m);
                                gf5.b(new a(this, this.a.h, personBarResponseMessage.getResultString()), null);
                                this.a.update(personBarData, false);
                                if (1 != this.a.X1().T0() || (mVar = (personBarFragment = this.a).d) == null) {
                                    return;
                                }
                                mVar.f(personBarFragment.r);
                                return;
                            }
                            this.a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.a;
                            m mVar3 = personBarFragment2.d;
                            if (mVar3 != null) {
                                mVar3.f(personBarFragment2.r);
                                return;
                            }
                            return;
                        }
                        this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c3d) : httpResponsedMessage.getErrorString());
                        if (this.a.x) {
                            PersonBarFragment personBarFragment3 = this.a;
                            m mVar4 = personBarFragment3.d;
                            if (mVar4 != null) {
                                mVar4.f(personBarFragment3.r);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.a.d;
                        if (mVar5 != null) {
                            mVar5.f("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.a;
                m mVar6 = personBarFragment4.d;
                if (mVar6 != null) {
                    mVar6.f(personBarFragment4.r);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.b.a();
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
                    this.a.b.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                SkinManager.setNavbarTitleColor(this.a.l, R.color.CAM_X0106, R.color.obfuscated_res_0x7f06088b);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.e == null) {
                return;
            }
            if (!this.a.e.c()) {
                this.a.e.f(true);
                this.a.l.setText(R.string.obfuscated_res_0x7f0f04f8);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.a.B = R.color.obfuscated_res_0x7f06088b;
                } else {
                    this.a.B = R.color.CAM_X0302;
                }
                SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
                this.a.e.notifyDataSetChanged();
                return;
            }
            this.a.e.f(false);
            this.a.l.setText(R.string.obfuscated_res_0x7f0f0527);
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                this.a.B = R.color.obfuscated_res_0x7f06088b;
            } else {
                this.a.B = R.color.CAM_X0106;
            }
            SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
            this.a.e.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.f = ((Integer) view2.getTag()).intValue();
                if (this.a.f < 0 || this.a.f >= this.a.e.getCount() || this.a.q) {
                    return;
                }
                PersonBarFragment personBarFragment = this.a;
                personBarFragment.p = (ForumData) personBarFragment.e.getItem(this.a.f);
                if (this.a.p == null || this.a.p.getId() == null || this.a.p.getName() == null) {
                    return;
                }
                PersonBarFragment personBarFragment2 = this.a;
                personBarFragment2.g = personBarFragment2.p.getName();
                this.a.q = true;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                httpMessage.addParam("fid", this.a.p.getId());
                httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.a.g);
                httpMessage.addParam("favo_type", String.valueOf(this.a.p.getFavo_type()));
                httpMessage.addParam(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
                this.a.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            int intValue;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (intValue = ((Integer) view2.getTag()).intValue()) < 0 || intValue >= this.a.e.getCount()) {
                return;
            }
            ForumData forumData = (ForumData) this.a.e.getItem(intValue);
            if (this.a.X1() != null) {
                this.a.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.X1().getPageContext().getPageActivity(), og.g(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || this.a.e.getItem(i) == null || this.a.q) {
                return;
            }
            this.a.f = i;
            ForumData forumData = (ForumData) this.a.e.getItem(i);
            if (forumData == null || this.a.X1() == null) {
                return;
            }
            if (this.a.y) {
                Intent intent = new Intent();
                intent.putExtra("bar_name", forumData.getName());
                intent.putExtra("bar_id", forumData.getId());
                PersonBarActivity X1 = this.a.X1();
                this.a.X1();
                X1.setResult(-1, intent);
                this.a.X1().finish();
                return;
            }
            FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.X1().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
            if (this.a.w) {
                createNormalCfg.setCallFrom(7);
            } else {
                createNormalCfg.setCallFrom(9);
            }
            this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
        }
    }

    /* loaded from: classes4.dex */
    public class j implements av4.g {
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

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.X1() == null) {
                return;
            }
            PersonBarFragment personBarFragment = this.a;
            personBarFragment.m = 1;
            if (personBarFragment.X1() == null || this.a.X1().o1() != 23011) {
                this.a.Z1();
                return;
            }
            RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
            requestGetLivableForumList.setGetLikeForum(1);
            requestGetLivableForumList.setPageNo(this.a.m);
            requestGetLivableForumList.setPageSize(this.a.n);
            requestGetLivableForumList.setUserId(og.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            this.a.sendMessage(requestGetLivableForumList);
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.d.e();
                    if (this.a.X1().o1() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.a.m);
                        requestGetLivableForumList.setPageSize(this.a.n);
                        requestGetLivableForumList.setUserId(og.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.a.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.a;
                    personBarFragment2.a2(personBarFragment2.m);
                    return;
                }
                personBarFragment.d.f(personBarFragment.r);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends cb {
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
                this.a.c.A(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c3d));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() == 0) {
                        if (this.a.X1() == null || this.a.X1().o1() == 23011) {
                            if (!this.a.z) {
                                this.a.z = true;
                                PersonBarFragment personBarFragment2 = this.a;
                                personBarFragment2.c.addHeaderView(personBarFragment2.s);
                                int miniLevel = responseGetLivableForumList.getMiniLevel();
                                if (miniLevel <= 0) {
                                    miniLevel = 0;
                                }
                                this.a.t.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d6, Integer.valueOf(miniLevel)));
                                SkinManager.setViewTextColor(this.a.t, R.color.CAM_X0108, 1);
                                SkinManager.setBackgroundColor(this.a.t, R.color.common_color_10238);
                            }
                            this.a.s.setVisibility(0);
                        } else {
                            this.a.s.setVisibility(8);
                        }
                        if (this.a.e != null) {
                            this.a.A.addAll(responseGetLivableForumList.getData());
                            this.a.b2();
                            this.a.e.g(this.a.A);
                            this.a.o = responseGetLivableForumList.hasMore();
                            this.a.U1(true);
                            this.a.e.notifyDataSetChanged();
                            this.a.m++;
                            return;
                        }
                        return;
                    }
                    this.a.showToast(responseGetLivableForumList.getErrorString());
                    PersonBarFragment personBarFragment3 = this.a;
                    personBarFragment3.d.f(personBarFragment3.r);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class m extends cn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int b;
        public BaseFragmentActivity c;
        public TextView d;
        public ProgressBar e;
        public View.OnClickListener f;
        public View g;
        public View h;

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
            this.b = R.color.CAM_X0201;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.c = baseFragmentActivity;
        }

        @Override // com.repackage.cn
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.c.getPageContext().getContext()).inflate(R.layout.obfuscated_res_0x7f0d062d, (ViewGroup) null);
                this.g = inflate;
                inflate.setPadding(0, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
                this.d = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09180d);
                this.h = this.g.findViewById(R.id.obfuscated_res_0x7f091810);
                SkinManager.setBackgroundColor(this.g, this.b);
                SkinManager.setBackgroundColor(this.h, this.b);
                this.h.setVisibility(8);
                this.e = (ProgressBar) this.g.findViewById(R.id.obfuscated_res_0x7f091a78);
                h(TbadkCoreApplication.getInst().getSkinType());
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.g;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.cn
        public void c() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f) == null) {
                return;
            }
            onClickListener.onClick(this.g);
        }

        @SuppressLint({"ResourceAsColor"})
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                SkinManager.setBackgroundColor(this.g, this.b, i);
                SkinManager.setBackgroundColor(this.h, this.b, i);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.e.setVisibility(0);
                this.d.setText(this.c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a3d));
                this.h.setVisibility(0);
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
                ProgressBar progressBar = this.e;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                if (this.d != null) {
                    if (!z) {
                        this.h.setVisibility(0);
                        this.d.setText(str);
                        return;
                    }
                    this.h.setVisibility(8);
                }
            }
        }

        public void h(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.c.getLayoutMode().k(this.h);
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
        jk8.b(2001183, u48.class);
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
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = -1;
        this.g = null;
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

    public void U1(boolean z) {
        r48 r48Var;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (r48Var = this.e) == null) {
            return;
        }
        r48Var.b();
        if (!this.e.d()) {
            V1(false);
            this.c.setVisibility(0);
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (X1() == null || X1().o1() != 23011 || (textView = this.l) == null) {
                return;
            }
            textView.setVisibility(8);
        } else if (z) {
            this.e.f(false);
            V1(true);
            this.c.setVisibility(0);
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
            m mVar = this.d;
            if (mVar == null || mVar.b() == null) {
                return;
            }
            this.d.b().setVisibility(8);
        }
    }

    public final void V1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                if (this.c != null) {
                    NoDataView noDataView = this.j;
                    if (noDataView != null) {
                        noDataView.setVisibility(0);
                    }
                    this.c.removeHeaderView(this.j);
                    this.c.addHeaderView(this.j);
                }
            } else if (this.c != null) {
                NoDataView noDataView2 = this.j;
                if (noDataView2 != null) {
                    noDataView2.setVisibility(8);
                }
                this.c.removeHeaderView(this.j);
            }
        }
    }

    public r48 W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (r48) invokeV.objValue;
    }

    public final PersonBarActivity X1() {
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

    public void Y1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (personBarModel = this.h) == null) {
            return;
        }
        personBarModel.B();
    }

    public final void Z1() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (personBarModel = this.h) == null) {
            return;
        }
        personBarModel.C(this.w, personBarModel.getId(), this.m, this.n);
    }

    public void a2(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (personBarModel = this.h) == null) {
            return;
        }
        personBarModel.C(this.w, personBarModel.getId(), i2, this.n);
    }

    public final void b2() {
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
                    getBaseFragmentActivity().getPageContext().getLayoutMode().l(i2 == 1);
                    getBaseFragmentActivity().getPageContext().getLayoutMode().k(this.i);
                }
                if (this.j != null && getBaseFragmentActivity() != null) {
                    SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
                    this.j.f(getBaseFragmentActivity().getPageContext(), i2);
                }
                if (X1() != null) {
                    X1().Z0().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
                }
                bv4 bv4Var = this.k;
                if (bv4Var != null) {
                    bv4Var.H(i2);
                }
                r48 r48Var = this.e;
                if (r48Var != null) {
                    r48Var.notifyDataSetChanged();
                }
                m mVar = this.d;
                if (mVar != null) {
                    mVar.d(i2);
                }
                SkinManager.setNavbarTitleColor(this.l, this.B, R.color.obfuscated_res_0x7f06088b);
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
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d02e9, viewGroup, false);
            View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02ea, (ViewGroup) null);
            this.s = inflate2;
            this.t = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090d39);
            if (X1() == null) {
                return inflate;
            }
            this.r = getString(R.string.obfuscated_res_0x7f0f0e15);
            this.h = X1().n1();
            this.w = X1().V0();
            this.y = X1().l1();
            this.i = inflate.findViewById(R.id.obfuscated_res_0x7f090abd);
            if (this.w && !this.y) {
                TextView textView = (TextView) X1().Z0().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0612, X1()).findViewById(R.id.obfuscated_res_0x7f091bf8);
                this.l = textView;
                textView.postDelayed(new e(this), 100L);
                this.l.setText(R.string.obfuscated_res_0x7f0f0527);
                this.l.setOnClickListener(new f(this));
                this.l.setVisibility(0);
            }
            r48 r48Var = new r48(X1(), this.h.z(), this.w, this.y);
            this.e = r48Var;
            r48Var.h(X1().h1());
            this.e.e(new g(this));
            this.e.i(new h(this));
            this.a = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f091611);
            this.b = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f091618);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f09159c);
            this.c = bdListView;
            bdListView.setAdapter((ListAdapter) this.e);
            this.c.setOnItemClickListener(new i(this));
            this.c.setOnScrollListener(this.C);
            bv4 bv4Var = new bv4(X1().getPageContext());
            this.k = bv4Var;
            bv4Var.f(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.d = mVar;
            this.c.setNextPage(mVar);
            this.c.setOnSrollToBottomListener(new k(this));
            this.c.setPullRefresh(this.k);
            if (this.w) {
                BdListViewHelper.d(getActivity(), this.c, BdListViewHelper.HeadType.DEFAULT);
                dimension = qi.f(getActivity(), R.dimen.obfuscated_res_0x7f07027a);
                string = getString(R.string.obfuscated_res_0x7f0f0e16);
            } else {
                BdListViewHelper.d(getActivity(), this.c, BdListViewHelper.HeadType.HASTAB);
                dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f070231);
                if (this.v == 0) {
                    string = getString(R.string.obfuscated_res_0x7f0f0e16);
                } else {
                    string = getString(R.string.obfuscated_res_0x7f0f0c56);
                }
            }
            if (this.y) {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.obfuscated_res_0x7f0f112b)), null);
            } else {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.w && X1() != null && X1().o1() != 23011) {
                Y1();
            }
            if (this.v == X1().T0()) {
                this.c.F();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.e != null) {
                this.e = null;
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

    public void update(q48 q48Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048591, this, q48Var, z) == null) || q48Var == null) {
            return;
        }
        this.o = q48Var.m();
        if (!z) {
            this.c.A(0L);
        }
        int W0 = X1().W0();
        if (this.h == null || this.e == null) {
            return;
        }
        if (this.v == X1().T0()) {
            if (z) {
                this.m = 1;
                this.h.z().r(q48Var.l(), q48Var.j());
                this.h.z().p(q48Var.h(), q48Var.f());
                this.h.z().t(q48Var.k());
                this.h.z().q(q48Var.g());
            } else if (this.m == 1) {
                this.h.z().r(q48Var.l(), q48Var.j());
                this.h.z().p(q48Var.h(), q48Var.f());
                this.h.z().t(q48Var.k());
                this.h.z().q(q48Var.g());
                this.m++;
            } else {
                this.h.z().c(q48Var.l(), q48Var.j());
                this.h.z().a(q48Var.h(), q48Var.f());
                this.h.z().d(q48Var.k());
                this.h.z().b(q48Var.g());
                this.m++;
            }
        }
        if (this.v == 0) {
            this.e.g(this.h.z().i());
        } else {
            this.e.g(this.h.z().e());
        }
        int size = q48Var.e() != null ? this.h.z().e().size() : 0;
        if (X1() != null) {
            X1().m1(W0, size);
        }
        U1(true);
        this.e.notifyDataSetChanged();
    }
}
