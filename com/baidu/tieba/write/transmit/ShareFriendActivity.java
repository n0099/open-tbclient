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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tieba.ab8;
import com.baidu.tieba.bb8;
import com.baidu.tieba.bha;
import com.baidu.tieba.cb8;
import com.baidu.tieba.db8;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.p75;
import com.baidu.tieba.p98;
import com.baidu.tieba.qga;
import com.baidu.tieba.rb8;
import com.baidu.tieba.tb8;
import com.baidu.tieba.tga;
import com.baidu.tieba.ub8;
import com.baidu.tieba.vi;
import com.baidu.tieba.wi;
import com.baidu.tieba.ya8;
import com.baidu.tieba.za8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class ShareFriendActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public CustomMessageListener E;
    public ThreadData F;
    public ForumData G;
    public GroupInfoData H;
    public final tb8 I;
    public boolean J;
    public ShareIMCommonCardData K;
    public final Runnable L;
    public NavigationBar a;
    public List<MetaData> b;
    public List<MetaData> c;
    public List<MetaData> d;
    public List<MetaData> e;
    public List<String> f;
    public tga g;
    public bha h;
    public View i;
    public FrameLayout j;
    public BdListView k;
    public n l;
    public TextView m;
    public LinearLayout n;
    public View o;
    public NoDataView p;
    public ImageView q;
    @Nullable
    public TextView r;
    public View s;
    public View t;
    public EditText u;
    public String v;
    public ImageView w;
    public ImageView x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || (charSequence2String = vi.charSequence2String(editable, null)) == null) {
                return;
            }
            if (charSequence2String.length() == 0) {
                this.a.q.setVisibility(8);
            } else {
                this.a.q.setVisibility(0);
            }
            if (!charSequence2String.equals(this.a.v)) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.mHandler.removeCallbacks(shareFriendActivity.L);
                ShareFriendActivity shareFriendActivity2 = this.a;
                shareFriendActivity2.mHandler.postDelayed(shareFriendActivity2.L, 300L);
            }
            this.a.m.setVisibility(0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.v = vi.charSequence2String(charSequence, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnFocusChangeListener {
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

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    wi.z(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    wi.O(this.a.getPageContext().getPageActivity(), view2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public c(ShareFriendActivity shareFriendActivity) {
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
                if (this.a.r != null && this.a.r.getVisibility() != 0) {
                    this.a.r.setVisibility(0);
                }
                this.a.t.setVisibility(0);
                this.a.s.setVisibility(8);
                this.a.o.setVisibility(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.u.setText("");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ShareFriendActivity shareFriendActivity = this.a;
                shareFriendActivity.g2(vi.charSequence2String(shareFriendActivity.u.getText(), ""));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ShareFriendActivity shareFriendActivity, int i) {
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
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getData() instanceof ThreadData) {
                this.a.F = (ThreadData) customResponsedMessage.getData();
            } else if (customResponsedMessage.getData() instanceof ForumData) {
                this.a.G = (ForumData) customResponsedMessage.getData();
            } else if (customResponsedMessage.getData() instanceof GroupInfoData) {
                this.a.H = (GroupInfoData) customResponsedMessage.getData();
            } else if (customResponsedMessage.getData() instanceof ShareIMCommonCardData) {
                this.a.K = (ShareIMCommonCardData) customResponsedMessage.getData();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements AdapterView.OnItemClickListener {
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

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            MetaData item;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || (item = this.a.h.getItem(i)) == null) {
                return;
            }
            wi.z(this.a.getPageContext().getPageActivity(), this.a.u);
            if (this.a.z) {
                this.a.d2(item);
            } else if (this.a.y) {
                this.a.e2(item);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
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

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i == 1) {
                ShareFriendActivity shareFriendActivity = this.a;
                wi.z(shareFriendActivity, shareFriendActivity.u);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements ya8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // com.baidu.tieba.ya8.b
        public /* synthetic */ void onCancel() {
            za8.a(this);
        }

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

        @Override // com.baidu.tieba.ya8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements ya8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // com.baidu.tieba.ya8.b
        public /* synthetic */ void onCancel() {
            za8.a(this);
        }

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

        @Override // com.baidu.tieba.ya8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements ya8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // com.baidu.tieba.ya8.b
        public /* synthetic */ void onCancel() {
            za8.a(this);
        }

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
            this.a = shareFriendActivity;
        }

        @Override // com.baidu.tieba.ya8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements ya8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        @Override // com.baidu.tieba.ya8.b
        public /* synthetic */ void onCancel() {
            za8.a(this);
        }

        public l(ShareFriendActivity shareFriendActivity) {
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

        @Override // com.baidu.tieba.ya8.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareFriendActivity a;

        public m(ShareFriendActivity shareFriendActivity) {
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
                if (this.a.r != null && this.a.r.getVisibility() != 8) {
                    this.a.r.setVisibility(8);
                }
                this.a.t.setVisibility(8);
                this.a.s.setVisibility(0);
                this.a.u.requestFocus();
                this.a.o.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class n extends BdAsyncTask<String, Integer, qga> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<ShareFriendActivity> a;
        public NetWork b;

        public n(ShareFriendActivity shareFriendActivity) {
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
            this.b = null;
            this.a = new WeakReference<>(shareFriendActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public qga doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                ShareFriendActivity shareFriendActivity = this.a.get();
                if (shareFriendActivity == null) {
                    return null;
                }
                this.b = new NetWork();
                if (shareFriendActivity.z) {
                    NetWork netWork = this.b;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.b.addPostData("from", "1");
                } else {
                    NetWork netWork2 = this.b;
                    netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.b.addPostData("from", "4");
                }
                String postNetData = this.b.postNetData();
                if (!this.b.getNetContext().getResponse().isRequestSuccess()) {
                    return null;
                }
                qga qgaVar = new qga();
                qgaVar.d(postNetData);
                return qgaVar;
            }
            return (qga) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(qga qgaVar) {
            ShareFriendActivity shareFriendActivity;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qgaVar) == null) && (shareFriendActivity = this.a.get()) != null) {
                shareFriendActivity.l = null;
                shareFriendActivity.hideNetRefreshView(shareFriendActivity.j);
                if (this.b.getNetContext().getResponse().isRequestSuccess()) {
                    shareFriendActivity.k.setVisibility(0);
                    shareFriendActivity.g.b(qgaVar);
                    if (shareFriendActivity.h == null) {
                        return;
                    }
                    if (shareFriendActivity.z && qgaVar != null && qgaVar.c() != null && qgaVar.c().isEmpty()) {
                        shareFriendActivity.i2(2);
                    } else if (!shareFriendActivity.y || qgaVar == null || qgaVar.c() == null || !qgaVar.c().isEmpty() || ub8.a() == null || !ub8.a().isEmpty()) {
                        shareFriendActivity.i2(0);
                    } else {
                        shareFriendActivity.i2(2);
                    }
                    if (qgaVar != null) {
                        ArrayList<MetaData> c = qgaVar.c();
                        int size = c.size();
                        for (int i = 0; i < size; i++) {
                            c.get(i).setItemType(shareFriendActivity.D);
                            shareFriendActivity.e.add(c.get(i));
                        }
                    }
                    shareFriendActivity.c2();
                    shareFriendActivity.h.notifyDataSetInvalidated();
                    shareFriendActivity.k.setSelection(0);
                } else {
                    shareFriendActivity.k.setVisibility(8);
                    shareFriendActivity.showNetRefreshView(shareFriendActivity.j, shareFriendActivity.getString(R.string.refresh_view_title_text), null, shareFriendActivity.getString(R.string.refresh_view_button_text), true, shareFriendActivity.getNetRefreshListener());
                }
                super.onPostExecute(qgaVar);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                NetWork netWork = this.b;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                ShareFriendActivity shareFriendActivity = this.a.get();
                if (shareFriendActivity != null) {
                    shareFriendActivity.l = null;
                }
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
        this.I = new tb8();
        this.J = false;
        this.L = new e(this);
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || isFinishing()) {
            return;
        }
        this.h.d(null);
        if (this.g.a() != null) {
            ArrayList<MetaData> c2 = this.g.a().c();
            if (!ListUtils.isEmpty(c2)) {
                i2(0);
            } else if (ListUtils.isEmpty(c2) && ListUtils.isEmpty(ub8.a())) {
                i2(1);
            }
            this.h.d(c2);
        } else {
            this.h.d(null);
            if (this.l == null) {
                n nVar = new n(this);
                this.l = nVar;
                nVar.setPriority(3);
                this.l.execute("");
            }
        }
        this.h.notifyDataSetInvalidated();
        this.k.setSelection(0);
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                if (this.b.get(i2).groupData != null) {
                    this.c.add(this.b.get(i2));
                } else if (this.b.get(i2).getUserId() == null) {
                    this.c.add(this.b.get(i2));
                } else if (!this.f.contains(this.b.get(i2).getUserId())) {
                    this.f.add(this.b.get(i2).getUserId());
                    this.c.add(this.b.get(i2));
                }
            }
        }
    }

    public void Y1(List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.B);
            list.add(shareFriendTitleData);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0870);
            a2(bundle);
            initView();
            f2();
        }
    }

    public void Z1(String str, List<MetaData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list) == null) {
            ShareFriendTitleData shareFriendTitleData = new ShareFriendTitleData();
            shareFriendTitleData.setItemType(this.A);
            shareFriendTitleData.setTitle(str);
            list.add(shareFriendTitleData);
        }
    }

    public final void j2(@NonNull ForumData forumData, @NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, forumData, metaData) == null) {
            ya8 ya8Var = new ya8(getActivity(), new bb8(getActivity()));
            ya8Var.j(forumData, metaData);
            ya8Var.i(new j(this));
            ya8Var.k();
        }
    }

    public final void k2(@NonNull GroupInfoData groupInfoData, @NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, groupInfoData, metaData) == null) {
            ya8 ya8Var = new ya8(getActivity(), new cb8(getActivity()));
            ya8Var.j(groupInfoData, metaData);
            ya8Var.i(new k(this));
            ya8Var.k();
        }
    }

    public final void l2(@NonNull ThreadData threadData, @NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, threadData, metaData) == null) {
            ya8 ya8Var = new ya8(getActivity(), new db8(getActivity()));
            ya8Var.j(threadData, metaData);
            ya8Var.i(new i(this));
            ya8Var.k();
        }
    }

    public final void a2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.g = new tga();
            if (bundle != null) {
                this.z = bundle.getBoolean(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
                this.y = bundle.getBoolean(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
                this.J = bundle.getBoolean(ShareFriendActivityConfig.KEY_FILTER_GROUP, false);
                return;
            }
            this.z = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_MESSAGE_TAB, false);
            this.y = getIntent().getBooleanExtra(ShareFriendActivityConfig.FROM_SHARE_FRIEND, false);
            this.J = getIntent().getBooleanExtra(ShareFriendActivityConfig.KEY_FILTER_GROUP, false);
        }
    }

    public void d2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
            TiebaStatic.log(new StatisticItem("c12930").param("obj_id", metaData.getUserIdLong()));
        }
    }

    public void e2(@NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, metaData) != null) || p98.a(getActivity())) {
            return;
        }
        ThreadData threadData = this.F;
        if (threadData != null) {
            l2(threadData, metaData);
            return;
        }
        ForumData forumData = this.G;
        if (forumData != null) {
            j2(forumData, metaData);
        } else if (GroupInfoData.isValidGroup(this.H)) {
            k2(this.H, metaData);
        } else if (ShareIMCommonCardData.isValidTopic(this.K) || ShareIMCommonCardData.isValidAlbum(this.K)) {
            m2(this.K, metaData);
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.a = navigationBar;
            if (this.z) {
                this.r = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.chat_friend));
            } else if (this.y) {
                this.r = navigationBar.setCenterTextTitle(getPageContext().getString(R.string.select_share_friend));
            }
            this.t = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new m(this));
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
            this.o = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.w = (ImageView) this.t.findViewById(R.id.new_friend_search);
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d06b7, (View.OnClickListener) null);
            this.s = addCustomView;
            addCustomView.setVisibility(8);
            ImageView imageView = (ImageView) this.s.findViewById(R.id.obfuscated_res_0x7f09048b);
            this.q = imageView;
            imageView.setVisibility(8);
            this.u = (EditText) this.s.findViewById(R.id.et_search);
            this.x = (ImageView) this.s.findViewById(R.id.et_bar_icon);
            this.u.addTextChangedListener(new a(this));
            this.u.setOnFocusChangeListener(new b(this));
            TextView textView = (TextView) findViewById(R.id.et_search_cancel_s);
            this.m = textView;
            textView.setOnClickListener(new c(this));
            this.q.setOnClickListener(new d(this));
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.z) {
                Z1(getString(R.string.my_focus), this.b);
                this.b.addAll(this.e);
            } else if (this.y) {
                List<MetaData> c2 = this.I.c(!this.J, false);
                this.d = c2;
                int size = c2.size();
                if (size == 0) {
                    Z1(getString(R.string.my_focus), this.b);
                    this.b.addAll(this.e);
                } else {
                    Z1(getString(R.string.nearly_focus), this.b);
                    if (size <= 10) {
                        for (int i2 = 0; i2 < size; i2++) {
                            this.d.get(i2).setItemType(this.C);
                            this.b.add(this.d.get(i2));
                        }
                    } else {
                        for (int i3 = 0; i3 < 10; i3++) {
                            this.d.get(i3).setItemType(this.C);
                            this.b.add(this.d.get(i3));
                        }
                    }
                    List<MetaData> list = this.e;
                    if (list != null && list.size() != 0) {
                        Y1(this.b);
                        Z1(getString(R.string.my_focus), this.b);
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

    public final void g2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || isFinishing()) {
            return;
        }
        if (this.z || this.y) {
            List<MetaData> list = null;
            this.h.d(null);
            if (!ListUtils.isEmpty(this.b)) {
                if (TextUtils.isEmpty(str)) {
                    list = this.b;
                } else {
                    list = new ArrayList<>();
                    for (MetaData metaData : this.c) {
                        if (metaData.getName_show() != null && metaData.getName_show().contains(str)) {
                            list.add(metaData);
                        }
                    }
                }
            }
            if (!ListUtils.isEmpty(list)) {
                i2(0);
            } else {
                i2(1);
            }
            this.h.d(list);
            this.h.notifyDataSetInvalidated();
            this.k.setSelection(0);
        }
    }

    public final void i2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 == 2) {
                this.k.setVisibility(8);
                hideNetRefreshView(this.j);
                this.p.setVisibility(0);
                this.p.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_people_focus)));
                this.t.setVisibility(8);
            } else if (i2 == 1) {
                this.k.setVisibility(8);
                hideNetRefreshView(this.j);
                this.p.setVisibility(0);
                this.p.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_people)));
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
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            super.onChangeSkinType(i2);
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.a.onChangeSkinType(getPageContext(), i2);
            this.w.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            WebPManager.setPureDrawable(this.x, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            SkinManager.setImageResource(this.q, R.drawable.icon_input_close_s);
            this.h.c(i2);
            p75 d2 = p75.d(this.n);
            d2.o(R.string.J_X07);
            d2.l(R.color.CAM_X0615);
            d2.f(R.color.CAM_X0209);
            p75.d(this.u).x(R.color.CAM_X0109);
            p75 d3 = p75.d(this.m);
            d3.D(R.string.F_X01);
            d3.x(R.color.CAM_X0107);
            p75.d(this.o).x(R.color.CAM_X0109);
        }
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.i = findViewById(R.id.obfuscated_res_0x7f092109);
            this.p = NoDataViewFactory.b(getPageContext().getContext(), this.i, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOFOLLOW, wi.g(getActivity(), R.dimen.obfuscated_res_0x7f0703b6)), NoDataViewFactory.e.d(null, getResources().getString(R.string.no_people_focus)), null, true);
            b2();
            this.n = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f092117);
            this.j = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0920f3);
            this.k = (BdListView) findViewById(R.id.obfuscated_res_0x7f0914fb);
            bha bhaVar = new bha(this);
            this.h = bhaVar;
            this.k.setAdapter((ListAdapter) bhaVar);
            this.h.b(this.e);
            this.k.setOnItemClickListener(new g(this));
            this.k.setOnScrollListener(new h(this));
            if (!getIntent().getBooleanExtra("keyboard", false) && this.u.getParent() != null) {
                ((View) this.u.getParent()).setFocusable(true);
                ((View) this.u.getParent()).setFocusableInTouchMode(true);
            }
        }
    }

    public final void m2(@NonNull ShareIMCommonCardData shareIMCommonCardData, @NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, shareIMCommonCardData, metaData) == null) {
            ya8 ya8Var = new ya8(getActivity(), new ab8(getActivity()));
            ya8Var.j(shareIMCommonCardData, metaData);
            ya8Var.i(new l(this));
            if (metaData.groupData != null) {
                rb8.a(shareIMCommonCardData, 2);
            } else if (!TextUtils.isEmpty(metaData.getUserId())) {
                rb8.a(shareIMCommonCardData, 1);
            }
            ya8Var.k();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            n nVar = this.l;
            if (nVar != null) {
                nVar.cancel();
            }
            this.mHandler.removeCallbacks(this.L);
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            if (wi.F()) {
                f2();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            if (this.E == null) {
                this.E = new f(this, 2921694);
            }
            MessageManager.getInstance().registerListener(this.E);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStart();
            this.p.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onStop();
            this.p.e();
        }
    }
}
