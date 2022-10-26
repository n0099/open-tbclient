package com.baidu.tieba.write.transmit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ShareFriendTitleData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.c39;
import com.baidu.tieba.cc7;
import com.baidu.tieba.dc7;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.nv4;
import com.baidu.tieba.r29;
import com.baidu.tieba.ra7;
import com.baidu.tieba.u29;
import com.baidu.tieba.vc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class ShareFriendActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public CustomMessageListener F;
    public ThreadData G;
    public ForumData H;
    public final Runnable I;
    public NavigationBar a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;
    public ArrayList e;
    public ArrayList f;
    public u29 g;
    public c39 h;
    public View i;
    public FrameLayout j;
    public BdListView k;
    public k l;
    public TextView m;
    public LinearLayout n;
    public View o;
    public NoDataView p;
    public ImageView q;
    public TextView r;
    public View s;
    public View t;
    public EditText u;
    public String v;
    public ImageView w;
    public ImageView x;
    public boolean y;
    public boolean z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public a(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.setText("");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public b(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.g2(ej.charSequence2String(shareFriendActivity.u.getText(), ""));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ShareFriendActivity shareFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity, Integer.valueOf(i)};
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
            this.a = shareFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                if ((customResponsedMessage.getData() instanceof ThreadData) || (customResponsedMessage.getData() instanceof ForumData)) {
                    if (customResponsedMessage.getData() instanceof ThreadData) {
                        this.a.G = (ThreadData) customResponsedMessage.getData();
                    } else if (customResponsedMessage.getData() instanceof ForumData) {
                        this.a.H = (ForumData) customResponsedMessage.getData();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public d(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
            MetaData item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.h.getItem(i)) == null) {
                return;
            }
            fj.x(this.a.getPageContext().getPageActivity(), this.a.u);
            if (this.a.z) {
                this.a.d2(item);
            } else if (this.a.y) {
                this.a.e2(item);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        public e(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                ShareFriendActivity shareFriendActivity = this.a;
                fj.x(shareFriendActivity, shareFriendActivity.u);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements cc7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // com.baidu.tieba.cc7.b
        public /* synthetic */ void onCancel() {
            dc7.a(this);
        }

        public f(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // com.baidu.tieba.cc7.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public g(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.setVisibility(8);
                this.a.t.setVisibility(8);
                this.a.s.setVisibility(0);
                this.a.u.requestFocus();
                this.a.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
                this.a.o = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public h(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || (charSequence2String = ej.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() == 0) {
                this.a.q.setVisibility(8);
            } else {
                this.a.q.setVisibility(0);
            }
            if (!charSequence2String.equals(this.a.v)) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.mHandler.removeCallbacks(shareFriendActivity.I);
                ShareFriendActivity shareFriendActivity2 = this.a;
                shareFriendActivity2.mHandler.postDelayed(shareFriendActivity2.I, 300L);
            }
            this.a.m.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.v = ej.charSequence2String(charSequence, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public i(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    fj.x(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    fj.L(this.a.getPageContext().getPageActivity(), view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public j(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = shareFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.getText().clear();
                this.a.r.setVisibility(0);
                this.a.t.setVisibility(0);
                this.a.s.setVisibility(8);
                if (this.a.o == null) {
                    ShareFriendActivity shareFriendActivity = this.a;
                    shareFriendActivity.o = shareFriendActivity.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ ShareFriendActivity b;

        public k(ShareFriendActivity shareFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shareFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = shareFriendActivity;
            this.a = null;
        }

        public /* synthetic */ k(ShareFriendActivity shareFriendActivity, b bVar) {
            this(shareFriendActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public r29 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                this.a = new NetWork();
                if (this.b.z) {
                    NetWork netWork = this.a;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "1");
                } else {
                    NetWork netWork2 = this.a;
                    netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "4");
                }
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    r29 r29Var = new r29();
                    r29Var.b(postNetData);
                    return r29Var;
                }
                return null;
            }
            return (r29) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(r29 r29Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r29Var) == null) {
                this.b.l = null;
                ShareFriendActivity shareFriendActivity = this.b;
                shareFriendActivity.hideNetRefreshView(shareFriendActivity.j);
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.k.setVisibility(0);
                    this.b.g.b(r29Var);
                    if (this.b.h == null) {
                        return;
                    }
                    if (this.b.z && r29Var != null && r29Var.a() != null && r29Var.a().isEmpty()) {
                        this.b.i2(2);
                    } else if (!this.b.y || r29Var == null || r29Var.a() == null || !r29Var.a().isEmpty() || vc7.a() == null || !vc7.a().isEmpty()) {
                        this.b.i2(0);
                    } else {
                        this.b.i2(2);
                    }
                    if (r29Var != null) {
                        ArrayList a = r29Var.a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            ((MetaData) a.get(i)).setItemType(this.b.D);
                            this.b.e.add(a.get(i));
                        }
                    }
                    this.b.c2();
                    this.b.h.notifyDataSetInvalidated();
                    this.b.k.setSelection(0);
                } else {
                    this.b.k.setVisibility(8);
                    ShareFriendActivity shareFriendActivity2 = this.b;
                    shareFriendActivity2.showNetRefreshView(shareFriendActivity2.j, this.b.getString(R.string.obfuscated_res_0x7f0f0fec), null, this.b.getString(R.string.obfuscated_res_0x7f0f0feb), true, this.b.getNetRefreshListener());
                }
                super.onPostExecute(r29Var);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.b.l = null;
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                super.onPreExecute();
            }
        }
    }

    public ShareFriendActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = null;
        this.h = null;
        this.k = null;
        this.l = null;
        this.y = false;
        this.z = false;
        this.A = 0;
        this.B = 2;
        this.C = 1;
        this.D = 3;
        this.E = 10;
        this.I = new b(this);
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || isFinishing()) {
            return;
        }
        this.h.d(null);
        if (this.g.a() != null) {
            ArrayList a2 = this.g.a().a();
            if (!ListUtils.isEmpty(a2)) {
                i2(0);
            } else if (ListUtils.isEmpty(a2) && ListUtils.isEmpty(vc7.a())) {
                i2(1);
            }
            this.h.d(a2);
        } else {
            this.h.d(null);
            if (this.l == null) {
                k kVar = new k(this, null);
                this.l = kVar;
                kVar.setPriority(3);
                this.l.execute("");
            }
        }
        this.h.notifyDataSetInvalidated();
        this.k.setSelection(0);
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (((MetaData) this.b.get(i2)).getUserId() == null) {
                    this.c.add(this.b.get(i2));
                } else if (!this.f.contains(((MetaData) this.b.get(i2)).getUserId())) {
                    this.f.add(((MetaData) this.b.get(i2)).getUserId());
                    this.c.add(this.b.get(i2));
                }
            }
        }
    }

    public void X1(ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.B);
            arrayList.add(shareFriendTitleData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d07bd);
            Z1(bundle);
            b2();
            f2();
        }
    }

    public void Y1(String str, ArrayList arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, arrayList) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.A);
            shareFriendTitleData.setTitle(str);
            arrayList.add(shareFriendTitleData);
        }
    }

    public final void Z1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.g = new u29();
            if (bundle != null) {
                this.z = bundle.getBoolean(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
                this.y = bundle.getBoolean(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
                return;
            }
            this.z = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
            this.y = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
        }
    }

    public void e2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, metaData) != null) || ra7.a(getActivity())) {
            return;
        }
        cc7 cc7Var = new cc7(getActivity());
        ThreadData threadData = this.G;
        if (threadData != null) {
            cc7Var.o(threadData, metaData);
        } else {
            ForumData forumData = this.H;
            if (forumData != null) {
                cc7Var.n(forumData, metaData);
            }
        }
        cc7Var.m(new f(this));
        cc7Var.p();
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925ad);
            this.a = navigationBar;
            if (this.z) {
                this.r = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f03ae));
            } else if (this.y) {
                this.r = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f1128));
            }
            this.t = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0079, new g(this));
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.o = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.w = (ImageView) this.t.findViewById(R.id.obfuscated_res_0x7f09167c);
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d062d, (View.OnClickListener) null);
            this.s = addCustomView;
            addCustomView.setVisibility(8);
            ImageView imageView = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f090422);
            this.q = imageView;
            imageView.setVisibility(8);
            this.u = (EditText) this.s.findViewById(R.id.obfuscated_res_0x7f090941);
            this.x = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f090939);
            this.u.addTextChangedListener(new h(this));
            this.u.setOnFocusChangeListener(new i(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090942);
            this.m = textView;
            textView.setOnClickListener(new j(this));
            this.q.setOnClickListener(new a(this));
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.z) {
                Y1(getString(R.string.obfuscated_res_0x7f0f0b6a), this.b);
                this.b.addAll(this.e);
            } else if (this.y) {
                ArrayList a2 = vc7.a();
                this.d = a2;
                int size = a2.size();
                if (size == 0) {
                    Y1(getString(R.string.obfuscated_res_0x7f0f0b6a), this.b);
                    this.b.addAll(this.e);
                } else {
                    Y1(getString(R.string.obfuscated_res_0x7f0f0c61), this.b);
                    if (size <= this.E) {
                        for (int i2 = 0; i2 < size; i2++) {
                            ((MetaData) this.d.get(i2)).setItemType(this.C);
                            this.b.add(this.d.get(i2));
                        }
                    } else {
                        for (int i3 = 0; i3 < this.E; i3++) {
                            ((MetaData) this.d.get(i3)).setItemType(this.C);
                            this.b.add(this.d.get(i3));
                        }
                    }
                    ArrayList arrayList = this.e;
                    if (arrayList != null && arrayList.size() != 0) {
                        X1(this.b);
                        Y1(getString(R.string.obfuscated_res_0x7f0f0b6a), this.b);
                        for (int i4 = 0; i4 < this.e.size(); i4++) {
                            this.b.add(this.e.get(i4));
                        }
                    }
                }
            }
            h2();
            this.h.d(this.b);
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = findViewById(R.id.obfuscated_res_0x7f091e9e);
            this.p = NoDataViewFactory.b(getPageContext().getContext(), this.i, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, fj.f(getActivity(), R.dimen.obfuscated_res_0x7f07029e)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0cab)), null, true);
            a2();
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091eac);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091e88);
            this.k = (BdListView) findViewById(R.id.obfuscated_res_0x7f091318);
            c39 c39Var = new c39(this);
            this.h = c39Var;
            this.k.setAdapter((ListAdapter) c39Var);
            this.h.b(this.e);
            this.k.setOnItemClickListener(new d(this));
            this.k.setOnScrollListener(new e(this));
            if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.u.getParent() != null) {
                ((View) this.u.getParent()).setFocusable(true);
                ((View) this.u.getParent()).setFocusableInTouchMode(true);
            }
        }
    }

    public void d2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
            TiebaStatic.log(new StatisticItem("c12930").param("obj_id", metaData.getUserIdLong()));
        }
    }

    public final void g2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, str) != null) || isFinishing()) {
            return;
        }
        if (this.z || this.y) {
            ArrayList arrayList = null;
            this.h.d(null);
            if (!ListUtils.isEmpty(this.b)) {
                if (TextUtils.isEmpty(str)) {
                    arrayList = this.b;
                } else {
                    arrayList = new ArrayList();
                    Iterator it = this.c.iterator();
                    while (it.hasNext()) {
                        MetaData metaData = (MetaData) it.next();
                        if (metaData.getName_show() != null && metaData.getName_show().contains(str)) {
                            arrayList.add(metaData);
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                i2(0);
            } else {
                i2(1);
            }
            this.h.d(arrayList);
            this.h.notifyDataSetInvalidated();
            this.k.setSelection(0);
        }
    }

    public final void i2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 == 2) {
                this.k.setVisibility(8);
                hideNetRefreshView(this.j);
                this.p.setVisibility(0);
                this.p.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0cab)));
                this.t.setVisibility(8);
            } else if (i2 == 1) {
                this.k.setVisibility(8);
                hideNetRefreshView(this.j);
                this.p.setVisibility(0);
                this.p.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0caa)));
                this.p.setImgOption(NoDataViewFactory.d.a(NoDataViewFactory.ImgType.FINDBAR));
                this.t.setVisibility(8);
            } else if (i2 == 0) {
                this.k.setVisibility(0);
                this.p.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            super.onChangeSkinType(i2);
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.a.onChangeSkinType(getPageContext(), i2);
            this.w.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a26, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            WebPManager.setPureDrawable(this.x, R.drawable.obfuscated_res_0x7f080a7f, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.q, R.drawable.icon_input_close_s);
            this.h.c(i2);
            nv4 d2 = nv4.d(this.n);
            d2.n(R.string.J_X07);
            d2.k(R.color.CAM_X0615);
            d2.f(R.color.CAM_X0209);
            nv4.d(this.u).v(R.color.CAM_X0109);
            nv4 d3 = nv4.d(this.m);
            d3.A(R.string.F_X01);
            d3.v(R.color.CAM_X0107);
            nv4.d(this.o).v(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            k kVar = this.l;
            if (kVar != null) {
                kVar.cancel();
            }
            this.mHandler.removeCallbacks(this.I);
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.F);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onNetRefreshButtonClicked();
            if (fj.D()) {
                f2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (this.F == null) {
                this.F = new c(this, 2921694);
            }
            MessageManager.getInstance().registerListener(this.F);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onStart();
            this.p.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onStop();
            this.p.e();
        }
    }
}
