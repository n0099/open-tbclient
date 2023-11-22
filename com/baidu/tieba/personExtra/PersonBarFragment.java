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
import com.baidu.adp.framework.listener.SocketMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BDLayoutMode;
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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a5a;
import com.baidu.tieba.bu5;
import com.baidu.tieba.ci;
import com.baidu.tieba.dra;
import com.baidu.tieba.fu5;
import com.baidu.tieba.g55;
import com.baidu.tieba.h55;
import com.baidu.tieba.im.message.RequestGetLivableForumList;
import com.baidu.tieba.w4a;
import com.baidu.tieba.x4a;
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
    public ArrayList<ForumData> A;
    public int B;
    public AbsListView.OnScrollListener C;
    public final SocketMessageListener D;
    public final CustomMessageListener E;
    public HttpMessageListener F;
    public HttpMessageListener G;
    public NavigationBarShadowView a;
    public NavigationBarShadowView b;
    public BdListView c;
    public m d;
    public x4a e;
    public int f;
    public String g;
    public PersonBarModel h;
    public View i;
    public NoDataView j;
    public h55 k;
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

    /* loaded from: classes7.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonBarFragment a;

        /* loaded from: classes7.dex */
        public class a extends bu5<Object> {
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

            @Override // com.baidu.tieba.bu5
            public Object doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    PersonBarModel personBarModel = this.a;
                    if (personBarModel != null) {
                        personBarModel.S(this.b);
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
            String errorString;
            PersonBarFragment personBarFragment;
            m mVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002002) {
                if (this.a.Z2() != null) {
                    m mVar2 = this.a.d;
                    if (mVar2 != null && mVar2.c() != null) {
                        this.a.d.c().setVisibility(0);
                    }
                    this.a.c.z(0L);
                    this.a.u = false;
                    if (httpResponsedMessage.getOrginalMessage().getTag() == this.a.Z2().getUniqueId()) {
                        if (httpResponsedMessage.getStatusCode() == 200 && (httpResponsedMessage instanceof PersonBarResponseMessage)) {
                            PersonBarResponseMessage personBarResponseMessage = (PersonBarResponseMessage) httpResponsedMessage;
                            if (personBarResponseMessage.getErrCode() == 0) {
                                w4a personBarData = personBarResponseMessage.getPersonBarData();
                                this.a.h.T(this.a.m);
                                fu5.b(new a(this, this.a.h, personBarResponseMessage.getResultString()), null);
                                this.a.e3(personBarData, false);
                                if (1 == this.a.Z2().z1() && (mVar = (personBarFragment = this.a).d) != null) {
                                    mVar.g(personBarFragment.r);
                                    return;
                                }
                                return;
                            }
                            this.a.showToast(httpResponsedMessage.getErrorString());
                            PersonBarFragment personBarFragment2 = this.a;
                            m mVar3 = personBarFragment2.d;
                            if (mVar3 != null) {
                                mVar3.g(personBarFragment2.r);
                                return;
                            }
                            return;
                        }
                        if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                            errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
                        } else {
                            errorString = httpResponsedMessage.getErrorString();
                        }
                        this.a.showToast(errorString);
                        if (this.a.x) {
                            PersonBarFragment personBarFragment3 = this.a;
                            m mVar4 = personBarFragment3.d;
                            if (mVar4 != null) {
                                mVar4.g(personBarFragment3.r);
                                return;
                            }
                            return;
                        }
                        m mVar5 = this.a.d;
                        if (mVar5 != null) {
                            mVar5.g("");
                            return;
                        }
                        return;
                    }
                    return;
                }
                PersonBarFragment personBarFragment4 = this.a;
                m mVar6 = personBarFragment4.d;
                if (mVar6 != null) {
                    mVar6.g(personBarFragment4.r);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                w4a personBarData = ((ResponsePersonBarByUidLocalMessage) customResponsedMessage).getPersonBarData();
                if (this.a.Z2() != null) {
                    if (personBarData != null) {
                        this.a.x = true;
                    }
                    if (this.a.Z2().Y1() != 23011) {
                        this.a.s.setVisibility(8);
                    } else {
                        if (!this.a.z) {
                            this.a.z = true;
                            PersonBarFragment personBarFragment = this.a;
                            personBarFragment.c.addHeaderView(personBarFragment.s);
                        }
                        this.a.s.setVisibility(0);
                    }
                    this.a.e3(personBarData, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            String errorString;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) {
                return;
            }
            this.a.q = false;
            if (httpResponsedMessage.getError() == 0) {
                ArrayList<ForumData> i = this.a.h.O().i();
                int k = this.a.h.O().k();
                if (this.a.f < k) {
                    this.a.h.O().t(k - 1);
                }
                if (i != null && this.a.f >= 0 && this.a.f < i.size()) {
                    i.remove(this.a.f);
                    TbadkCoreApplication.getInst().delLikeForum(this.a.g);
                    if (this.a.e != null) {
                        this.a.W2(true);
                        this.a.e.g(i);
                        this.a.e.notifyDataSetChanged();
                    }
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f14d5);
                if (this.a.p != null && !TextUtils.isEmpty(this.a.p.getId())) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.sendMessage(new CustomMessage(2003004, personBarFragment.p.getId()));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001336, Long.valueOf(JavaTypesHelper.toLong(this.a.p.getId(), 0L))));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001611, this.a.p.getName()));
                    return;
                }
                return;
            }
            if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
            } else {
                errorString = httpResponsedMessage.getErrorString();
            }
            this.a.showToast(errorString);
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                SkinManager.setNavbarTitleColor(this.a.l, R.color.CAM_X0106, R.color.navi_op_text_skin);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.e != null) {
                if (!this.a.e.c()) {
                    this.a.e.f(true);
                    this.a.l.setText(R.string.obfuscated_res_0x7f0f05b4);
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        this.a.B = R.color.navi_op_text_skin;
                    } else {
                        this.a.B = R.color.CAM_X0302;
                    }
                    SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
                    this.a.e.notifyDataSetChanged();
                    return;
                }
                this.a.e.f(false);
                this.a.l.setText(R.string.obfuscated_res_0x7f0f0620);
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    this.a.B = R.color.navi_op_text_skin;
                } else {
                    this.a.B = R.color.CAM_X0106;
                }
                SkinManager.setViewTextColor(this.a.l, this.a.B, 1);
                this.a.e.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.f >= 0 && this.a.f < this.a.e.getCount() && !this.a.q) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.p = (ForumData) personBarFragment.e.getItem(this.a.f);
                    if (this.a.p != null && this.a.p.getId() != null && this.a.p.getName() != null) {
                        PersonBarFragment personBarFragment2 = this.a;
                        personBarFragment2.g = personBarFragment2.p.getName();
                        this.a.q = true;
                        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PIC_DEL_LIKE_BAR_CMD);
                        httpMessage.addParam("fid", this.a.p.getId());
                        httpMessage.addParam(TiebaStatic.Params.H5_FORUM_NAME, this.a.g);
                        httpMessage.addParam("favo_type", String.valueOf(this.a.p.getFavo_type()));
                        httpMessage.addParam("tbs", TbadkCoreApplication.getInst().getTbs());
                        this.a.sendMessage(httpMessage);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (intValue = ((Integer) view2.getTag()).intValue()) >= 0 && intValue < this.a.e.getCount()) {
                ForumData forumData = (ForumData) this.a.e.getItem(intValue);
                if (this.a.Z2() != null) {
                    this.a.sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.Z2().getPageContext().getPageActivity(), JavaTypesHelper.toLong(forumData.getId(), 0L), forumData.getName(), forumData.getImage_url(), 0)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.a.e.getItem(i) == null || this.a.q) {
                return;
            }
            this.a.f = i;
            ForumData forumData = (ForumData) this.a.e.getItem(i);
            if (forumData != null && this.a.Z2() != null) {
                if (this.a.y) {
                    Intent intent = new Intent();
                    intent.putExtra("bar_name", forumData.getName());
                    intent.putExtra("bar_id", forumData.getId());
                    PersonBarActivity Z2 = this.a.Z2();
                    this.a.Z2();
                    Z2.setResult(-1, intent);
                    this.a.Z2().finish();
                    return;
                }
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a.Z2().getPageContext().getPageActivity()).createNormalCfg(forumData.getName(), "tb_mytieba");
                if (this.a.w) {
                    createNormalCfg.setCallFrom(7);
                } else {
                    createNormalCfg.setCallFrom(9);
                }
                this.a.sendMessage(new CustomMessage(2003000, createNormalCfg));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements g55.g {
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

        @Override // com.baidu.tieba.g55.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.Z2() != null) {
                PersonBarFragment personBarFragment = this.a;
                personBarFragment.m = 1;
                if (personBarFragment.Z2() != null && this.a.Z2().Y1() == 23011) {
                    RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                    requestGetLivableForumList.setGetLikeForum(1);
                    requestGetLivableForumList.setPageNo(this.a.m);
                    requestGetLivableForumList.setPageSize(this.a.n);
                    requestGetLivableForumList.setUserId(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                    this.a.sendMessage(requestGetLivableForumList);
                    return;
                }
                this.a.b3();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                    this.a.d.f();
                    if (this.a.Z2().Y1() == 23011) {
                        RequestGetLivableForumList requestGetLivableForumList = new RequestGetLivableForumList();
                        requestGetLivableForumList.setGetLikeForum(1);
                        requestGetLivableForumList.setPageNo(this.a.m);
                        requestGetLivableForumList.setPageSize(this.a.n);
                        requestGetLivableForumList.setUserId(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
                        this.a.sendMessage(requestGetLivableForumList);
                        return;
                    }
                    PersonBarFragment personBarFragment2 = this.a;
                    personBarFragment2.c3(personBarFragment2.m);
                    return;
                }
                personBarFragment.d.g(personBarFragment.r);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends SocketMessageListener {
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
        /* renamed from: g */
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) {
                this.a.c.z(0L);
                if (socketResponsedMessage == null) {
                    PersonBarFragment personBarFragment = this.a;
                    personBarFragment.showToast(personBarFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e61));
                } else if (socketResponsedMessage.getCmd() == 107129 && (socketResponsedMessage instanceof ResponseGetLivableForumList)) {
                    ResponseGetLivableForumList responseGetLivableForumList = (ResponseGetLivableForumList) socketResponsedMessage;
                    if (responseGetLivableForumList.getError() != 0) {
                        this.a.showToast(responseGetLivableForumList.getErrorString());
                        PersonBarFragment personBarFragment2 = this.a;
                        personBarFragment2.d.g(personBarFragment2.r);
                        return;
                    }
                    if (this.a.Z2() != null && this.a.Z2().Y1() != 23011) {
                        this.a.s.setVisibility(8);
                    } else {
                        if (!this.a.z) {
                            this.a.z = true;
                            PersonBarFragment personBarFragment3 = this.a;
                            personBarFragment3.c.addHeaderView(personBarFragment3.s);
                            int miniLevel = responseGetLivableForumList.getMiniLevel();
                            if (miniLevel <= 0) {
                                miniLevel = 0;
                            }
                            this.a.t.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bb5, Integer.valueOf(miniLevel)));
                            SkinManager.setViewTextColor(this.a.t, R.color.CAM_X0108, 1);
                            SkinManager.setBackgroundColor(this.a.t, R.color.common_color_10238);
                        }
                        this.a.s.setVisibility(0);
                    }
                    if (this.a.e != null) {
                        this.a.A.addAll(responseGetLivableForumList.getData());
                        this.a.d3();
                        this.a.e.g(this.a.A);
                        this.a.o = responseGetLivableForumList.hasMore();
                        this.a.W2(true);
                        this.a.e.notifyDataSetChanged();
                        this.a.m++;
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class m extends ci {
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

        @Override // com.baidu.tieba.ci
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.c.getPageContext().getContext()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.g = inflate;
                inflate.setPadding(0, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
                this.d = (TextView) this.g.findViewById(R.id.pb_more_text);
                this.h = this.g.findViewById(R.id.pb_more_view);
                SkinManager.setBackgroundColor(this.g, this.b);
                SkinManager.setBackgroundColor(this.h, this.b);
                this.h.setVisibility(8);
                this.e = (ProgressBar) this.g.findViewById(R.id.obfuscated_res_0x7f091de4);
                i(TbadkCoreApplication.getInst().getSkinType());
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.g;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ci
        public void d() {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onClickListener = this.f) != null) {
                onClickListener.onClick(this.g);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.e.setVisibility(0);
                this.d.setText(this.c.getPageContext().getPageActivity().getText(R.string.obfuscated_res_0x7f0f0c22));
                this.h.setVisibility(0);
            }
        }

        @SuppressLint({"ResourceAsColor"})
        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                SkinManager.setBackgroundColor(this.g, this.b, i);
                SkinManager.setBackgroundColor(this.h, this.b, i);
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                h(false, str);
            }
        }

        public void i(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.c.getLayoutMode().onModeChanged(this.h);
            }
        }

        public void h(boolean z, String str) {
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
        dra.b(2001183, a5a.class);
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

    public void c3(int i2) {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i2) == null) && (personBarModel = this.h) != null) {
            personBarModel.R(this.w, personBarModel.getId(), i2, this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onActivityCreated(bundle);
            registerListener(this.G);
            registerListener(this.F);
            registerListener(this.E);
            registerListener(this.D);
            this.D.setSelfListener(true);
        }
    }

    public void W2(boolean z) {
        x4a x4aVar;
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (x4aVar = this.e) == null) {
            return;
        }
        x4aVar.b();
        if (this.e.d()) {
            if (z) {
                this.e.f(false);
                X2(true);
                this.c.setVisibility(0);
                TextView textView2 = this.l;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                m mVar = this.d;
                if (mVar != null && mVar.c() != null) {
                    this.d.c().setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        X2(false);
        this.c.setVisibility(0);
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        if (Z2() != null && Z2().Y1() == 23011 && (textView = this.l) != null) {
            textView.setVisibility(8);
        }
    }

    public final void X2(boolean z) {
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

    public x4a Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (x4a) invokeV.objValue;
    }

    public final PersonBarActivity Z2() {
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

    public void a3() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (personBarModel = this.h) != null) {
            personBarModel.Q();
        }
    }

    public final void b3() {
        PersonBarModel personBarModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (personBarModel = this.h) != null) {
            personBarModel.R(this.w, personBarModel.getId(), this.m, this.n);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            NoDataView noDataView = this.j;
            if (noDataView != null) {
                noDataView.e();
            }
        }
    }

    public final void d3() {
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
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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

    public void e3(w4a w4aVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, w4aVar, z) != null) || w4aVar == null) {
            return;
        }
        this.o = w4aVar.m();
        if (!z) {
            this.c.z(0L);
        }
        int E1 = Z2().E1();
        int i2 = 0;
        if (this.h != null && this.e != null) {
            if (this.v == Z2().z1()) {
                if (z) {
                    this.m = 1;
                    this.h.O().r(w4aVar.l(), w4aVar.j());
                    this.h.O().p(w4aVar.h(), w4aVar.f());
                    this.h.O().t(w4aVar.k());
                    this.h.O().q(w4aVar.g());
                } else if (this.m == 1) {
                    this.h.O().r(w4aVar.l(), w4aVar.j());
                    this.h.O().p(w4aVar.h(), w4aVar.f());
                    this.h.O().t(w4aVar.k());
                    this.h.O().q(w4aVar.g());
                    this.m++;
                } else {
                    this.h.O().c(w4aVar.l(), w4aVar.j());
                    this.h.O().a(w4aVar.h(), w4aVar.f());
                    this.h.O().d(w4aVar.k());
                    this.h.O().b(w4aVar.g());
                    this.m++;
                }
            }
            if (this.v == 0) {
                this.e.g(this.h.O().i());
            } else {
                this.e.g(this.h.O().e());
            }
            if (w4aVar.e() != null) {
                i2 = this.h.O().e().size();
            }
            if (Z2() != null) {
                Z2().V1(E1, i2);
            }
            W2(true);
            this.e.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (!isAdded()) {
                return;
            }
            if (this.i != null && getBaseFragmentActivity() != null) {
                BDLayoutMode layoutMode = getBaseFragmentActivity().getPageContext().getLayoutMode();
                if (i2 == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                getBaseFragmentActivity().getPageContext().getLayoutMode().onModeChanged(this.i);
            }
            if (this.j != null && getBaseFragmentActivity() != null) {
                SkinManager.setBackgroundResource(this.j, R.color.CAM_X0201);
                this.j.f(getBaseFragmentActivity().getPageContext(), i2);
            }
            if (Z2() != null) {
                Z2().F1().onChangeSkinType(getBaseFragmentActivity().getPageContext(), i2);
            }
            h55 h55Var = this.k;
            if (h55Var != null) {
                h55Var.D(i2);
            }
            x4a x4aVar = this.e;
            if (x4aVar != null) {
                x4aVar.notifyDataSetChanged();
            }
            m mVar = this.d;
            if (mVar != null) {
                mVar.e(i2);
            }
            SkinManager.setNavbarTitleColor(this.l, this.B, R.color.navi_op_text_skin);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        int dimension;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            this.v = getArguments().getInt("page_type", 0);
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0355, viewGroup, false);
            View inflate2 = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0356, (ViewGroup) null);
            this.s = inflate2;
            this.t = (TextView) inflate2.findViewById(R.id.obfuscated_res_0x7f090f74);
            if (Z2() == null) {
                return inflate;
            }
            this.r = getString(R.string.obfuscated_res_0x7f0f1082);
            this.h = Z2().W1();
            this.w = Z2().D1();
            this.y = Z2().U1();
            this.i = inflate.findViewById(R.id.obfuscated_res_0x7f090c87);
            if (this.w && !this.y) {
                TextView textView = (TextView) Z2().F1().addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, Z2()).findViewById(R.id.right_textview);
                this.l = textView;
                textView.postDelayed(new e(this), 100L);
                this.l.setText(R.string.obfuscated_res_0x7f0f0620);
                this.l.setOnClickListener(new f(this));
                this.l.setVisibility(0);
            }
            x4a x4aVar = new x4a(Z2(), this.h.O(), this.w, this.y);
            this.e = x4aVar;
            x4aVar.h(Z2().P1());
            this.e.e(new g(this));
            this.e.i(new h(this));
            this.a = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f091957);
            this.b = (NavigationBarShadowView) inflate.findViewById(R.id.obfuscated_res_0x7f09195e);
            BdListView bdListView = (BdListView) inflate.findViewById(R.id.obfuscated_res_0x7f0918b5);
            this.c = bdListView;
            bdListView.setAdapter((ListAdapter) this.e);
            this.c.setOnItemClickListener(new i(this));
            this.c.setOnScrollListener(this.C);
            h55 h55Var = new h55(Z2().getPageContext());
            this.k = h55Var;
            h55Var.a(new j(this));
            m mVar = new m(getBaseFragmentActivity());
            this.d = mVar;
            this.c.setNextPage(mVar);
            this.c.setOnSrollToBottomListener(new k(this));
            this.c.setPullRefresh(this.k);
            if (this.w) {
                BdListViewHelper.d(getActivity(), this.c, BdListViewHelper.HeadType.DEFAULT);
                dimension = BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f07039a);
                string = getString(R.string.obfuscated_res_0x7f0f1083);
            } else {
                BdListViewHelper.d(getActivity(), this.c, BdListViewHelper.HeadType.HASTAB);
                dimension = (int) getResources().getDimension(R.dimen.obfuscated_res_0x7f07035a);
                if (this.v == 0) {
                    string = getString(R.string.obfuscated_res_0x7f0f1083);
                } else {
                    string = getString(R.string.no_data_common_txt);
                }
            }
            if (this.y) {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, dimension), NoDataViewFactory.e.d(string, getString(R.string.obfuscated_res_0x7f0f13cc)), null);
            } else {
                this.j = NoDataViewFactory.a(getActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, dimension), NoDataViewFactory.e.d(null, string), null);
            }
            if (this.w && Z2() != null && Z2().Y1() != 23011) {
                a3();
            }
            if (this.v == Z2().z1()) {
                this.c.E();
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
