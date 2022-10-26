package com.baidu.tieba.write.write;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.suspended.SuspendedActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.fj;
import com.baidu.tieba.io;
import com.baidu.tieba.nv4;
import com.baidu.tieba.oe5;
import com.baidu.tieba.q39;
import com.baidu.tieba.r29;
import com.baidu.tieba.u29;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.tieba.zp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class AtListActivity extends SuspendedActivity implements oe5, AdapterView.OnItemClickListener, q39.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public View C;
    public ImageView D;
    public ImageView E;
    public View F;
    public NoDataView G;
    public RelativeLayout H;
    public boolean I;
    public boolean J;
    public boolean K;
    public ArrayList L;
    public Intent M;
    public final Handler N;
    public final Runnable O;
    public String P;
    public String Q;
    public ArrayList k;
    public NavigationBar l;
    public EditText m;
    public TextView n;
    public LinearLayout o;
    public LinearLayout p;
    public BdListView q;
    public AtSelectFriendList r;
    public LinearLayout s;
    public Button t;
    public l u;
    public u29 v;
    public q39 w;
    public String x;
    public RelativeLayout y;
    public View z;

    @Override // com.baidu.tieba.oe5
    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        /* renamed from: com.baidu.tieba.write.write.AtListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0446a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0446a(a aVar) {
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
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.a.L0();
            }
        }

        public a(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m.getText().clear();
                this.a.A.setVisibility(0);
                this.a.C.setVisibility(0);
                this.a.B.setVisibility(8);
                if (this.a.e == null) {
                    AtListActivity atListActivity = this.a;
                    atListActivity.e = atListActivity.l.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getResources().getString(R.string.dialog_cancel), new View$OnClickListenerC0446a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public b(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q.requestFocus();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public c(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AtListActivity atListActivity = this.a;
                atListActivity.Q1(ej.charSequence2String(atListActivity.m.getText(), ""));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public d(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    fj.x(this.a.getPageContext().getPageActivity(), this.a.m);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements TbCheckBox.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public e(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.b
        public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbCheckBox, Boolean.valueOf(z), obj}) == null) && (obj instanceof MetaData)) {
                if (z) {
                    if (5 <= this.a.r.getItemLength()) {
                        AtListActivity atListActivity = this.a;
                        atListActivity.showToastWithIcon(String.format(atListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0977), 5), R.drawable.obfuscated_res_0x7f080ada);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                        return;
                    }
                    this.a.L1((MetaData) obj);
                    return;
                }
                this.a.P1((MetaData) obj);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public f(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    fj.x(this.a.getPageContext().getPageActivity(), this.a.m);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public g(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.M = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA, this.a.r.getDataList());
                this.a.M.putExtras(bundle);
                fj.x(this.a.getPageContext().getPageActivity(), this.a.m);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_COMMIT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.P);
                statisticItem.param("fid", this.a.Q);
                StringBuilder sb = new StringBuilder();
                if (this.a.r.getDataList() != null) {
                    Iterator it = this.a.r.getDataList().iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        String uid = ((AtSelectData) it.next()).getUid();
                        if (!z) {
                            sb.append(",");
                        }
                        sb.append(uid);
                        z = false;
                    }
                    statisticItem.param(TiebaStatic.Params.FRIEND_UID, sb.toString());
                }
                TiebaStatic.log(statisticItem);
                this.a.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements AtSelectFriendList.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public h(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // com.baidu.tieba.write.write.AtSelectFriendList.b
        public void a(View view2, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, obj) == null) && obj != null) {
                if (obj instanceof TbCheckBox.c) {
                    ((TbCheckBox.c) obj).setChecked(false);
                }
                View findViewWithTag = this.a.q.findViewWithTag(obj);
                if (findViewWithTag instanceof TbCheckBox) {
                    ((TbCheckBox) findViewWithTag).setChecked(false);
                } else if (!(obj instanceof MetaData)) {
                } else {
                    this.a.P1((MetaData) obj);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public i(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.A.setVisibility(8);
                this.a.C.setVisibility(8);
                this.a.B.setVisibility(0);
                this.a.m.requestFocus();
                this.a.l.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public j(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String charSequence2String;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || (charSequence2String = ej.charSequence2String(editable, null)) == null) {
                return;
            }
            if (!charSequence2String.equals(this.a.x)) {
                this.a.N.removeCallbacks(this.a.O);
                this.a.N.postDelayed(this.a.O, 300L);
            }
            if (charSequence2String.length() > 0) {
                this.a.n.setVisibility(0);
            } else {
                this.a.n.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.x = ej.charSequence2String(charSequence, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        public k(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atListActivity;
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
    public class l extends BdAsyncTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ AtListActivity b;

        public l(AtListActivity atListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = atListActivity;
            this.a = null;
        }

        public /* synthetic */ l(AtListActivity atListActivity, c cVar) {
            this(atListActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public r29 doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                String str = strArr[0];
                this.a = new NetWork();
                if (this.b.J) {
                    NetWork netWork = this.a;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "1");
                } else if (this.b.K) {
                    NetWork netWork2 = this.a;
                    netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "2");
                } else {
                    NetWork netWork3 = this.a;
                    netWork3.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/atSearchUserList");
                    this.a.addPostData("rn", "100");
                    if (!ej.isEmpty(str)) {
                        this.a.addPostData("word", str);
                    }
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
                this.b.u = null;
                AtListActivity atListActivity = this.b;
                atListActivity.hideNetRefreshView(atListActivity.H);
                if (this.b.s != null && this.b.s.getVisibility() == 0) {
                    this.b.z.setVisibility(0);
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.v.b(r29Var);
                    if (this.b.w == null) {
                        return;
                    }
                    if (r29Var == null || r29Var.a() == null || !r29Var.a().isEmpty()) {
                        this.b.S1(0);
                    } else {
                        this.b.S1(2);
                    }
                    if (r29Var != null) {
                        this.b.k = r29Var.a();
                    }
                    this.b.w.f(this.b.k);
                    this.b.w.notifyDataSetInvalidated();
                    this.b.q.setSelection(0);
                } else {
                    this.b.showToast(this.a.getErrorString());
                    AtListActivity atListActivity2 = this.b;
                    atListActivity2.showNetRefreshView(atListActivity2.H, this.b.getString(R.string.obfuscated_res_0x7f0f0fec), null, this.b.getString(R.string.obfuscated_res_0x7f0f0feb), true, this.b.getNetRefreshListener());
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
                this.b.u = null;
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

    public AtListActivity() {
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
        this.k = new ArrayList();
        this.q = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.I = true;
        this.J = false;
        this.K = false;
        this.N = new Handler();
        this.O = new c(this);
    }

    public final void L1(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData) == null) && metaData != null) {
            this.r.e(metaData);
            R1(this.r.getItemLength());
            T1();
        }
    }

    public final void P1(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, metaData) == null) && metaData != null) {
            this.r.k(metaData);
            R1(this.r.getItemLength());
            T1();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.onCreate(bundle);
            N1(bundle);
            O1();
            Y0();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public oe5 M0(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, linearLayout, navigationBar)) == null) {
            this.o = linearLayout;
            this.l = navigationBar;
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0123, (ViewGroup) this.o, true);
            return this;
        }
        return (oe5) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.q39.c
    public void r0(View view2, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, view2, metaData) != null) || metaData == null) {
            return;
        }
        this.r.g(metaData);
    }

    private void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            this.A = this.l.setCenterTextTitle(getPageContext().getString(R.string.obfuscated_res_0x7f0f111f));
            View addCustomView = this.l.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0079, new i(this));
            this.C = addCustomView;
            this.D = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09167c);
            View addCustomView2 = this.l.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d062c, (View.OnClickListener) null);
            this.B = addCustomView2;
            addCustomView2.setVisibility(8);
            this.m = (EditText) this.B.findViewById(R.id.obfuscated_res_0x7f090941);
            this.E = (ImageView) this.B.findViewById(R.id.obfuscated_res_0x7f090939);
            this.m.addTextChangedListener(new j(this));
            this.m.setOnFocusChangeListener(new k(this));
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090942);
            this.n = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
            View view2 = new View(getPageContext().getContext());
            this.F = view2;
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.F.setFocusable(false);
            this.F.setFocusableInTouchMode(false);
            this.F.setContentDescription("");
            this.F.setVisibility(4);
            this.F.setBackgroundColor(0);
            this.F.setOnClickListener(new b(this));
            this.q.addFooterView(this.F);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void Y0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || isFinishing()) {
            return;
        }
        this.w.f(null);
        if (this.v.a() != null) {
            ArrayList a2 = this.v.a().a();
            Iterator it = a2.iterator();
            while (it.hasNext()) {
                ((MetaData) it.next()).setChecked(false);
            }
            if (!ListUtils.isEmpty(a2)) {
                S1(0);
            } else {
                S1(1);
            }
            this.w.f(a2);
        } else {
            this.w.f(null);
            if (this.u == null) {
                l lVar = new l(this, null);
                this.u = lVar;
                lVar.setPriority(3);
                this.u.execute("");
            }
        }
        this.w.notifyDataSetInvalidated();
        this.q.setSelection(0);
    }

    @Override // com.baidu.tieba.oe5
    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fj.x(getPageContext().getPageActivity(), this.m);
            View view2 = this.B;
            if (view2 != null && view2.getVisibility() == 0) {
                this.B.setVisibility(8);
                this.A.setVisibility(0);
                this.C.setVisibility(0);
                this.m.getText().clear();
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void N1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.v = new u29();
            if (bundle != null) {
                this.I = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
                this.J = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
                this.K = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
                this.L = bundle.getParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA);
                this.P = bundle.getString("thread_id");
                this.Q = bundle.getString("forum_id");
                return;
            }
            this.I = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
            this.J = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
            this.K = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
            this.L = getIntent().getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
            this.P = getIntent().getStringExtra("thread_id");
            this.Q = getIntent().getStringExtra("forum_id");
        }
    }

    public final void S1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 2) {
                this.q.setVisibility(8);
                hideNetRefreshView(this.H);
                this.G.setVisibility(0);
                this.G.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c80)));
                this.s.setVisibility(8);
            } else if (i2 == 1) {
                this.q.setVisibility(8);
                hideNetRefreshView(this.H);
                this.G.setVisibility(0);
                this.G.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0cb3)));
                this.s.setVisibility(8);
            } else if (i2 == 0) {
                this.q.setVisibility(0);
                this.G.setVisibility(8);
                if (this.I) {
                    this.s.setVisibility(0);
                }
            }
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.y = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091784);
            this.G = NoDataViewFactory.b(getPageContext().getContext(), this.y, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, fj.f(getActivity(), R.dimen.obfuscated_res_0x7f07029e)), NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c80)), null, true);
            this.z = findViewById(R.id.obfuscated_res_0x7f0902cb);
            this.G.setOnTouchListener(new d(this));
            T0();
            this.p = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090423);
            this.H = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906dc);
            this.q = (BdListView) findViewById(R.id.obfuscated_res_0x7f091318);
            q39 q39Var = new q39(this, this.I);
            this.w = q39Var;
            q39Var.g(this);
            this.w.e(new e(this));
            this.q.setAdapter((ListAdapter) this.w);
            this.q.setOnItemClickListener(this);
            this.q.setOnTouchListener(new f(this));
            if (!getIntent().getBooleanExtra(IntentConfig.SHOW_KEYBOARD, false) && this.m.getParent() != null) {
                ((View) this.m.getParent()).setFocusable(true);
                ((View) this.m.getParent()).setFocusableInTouchMode(true);
            }
            this.s = (LinearLayout) this.y.findViewById(R.id.obfuscated_res_0x7f090f7a);
            Button button = (Button) this.y.findViewById(R.id.obfuscated_res_0x7f09048c);
            this.t = button;
            button.setOnClickListener(new g(this));
            R1(0);
            AtSelectFriendList atSelectFriendList = (AtSelectFriendList) this.y.findViewById(R.id.obfuscated_res_0x7f0904b0);
            this.r = atSelectFriendList;
            atSelectFriendList.setMaxCount(5);
            this.r.setItemOPerationHandler(new h(this));
            M1();
            ArrayList arrayList = this.L;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AtSelectData atSelectData = (AtSelectData) it.next();
                    MetaData metaData = new MetaData();
                    metaData.setPortrait(atSelectData.getPortrait());
                    metaData.setName_show(atSelectData.getNameShow());
                    L1(metaData);
                }
            }
        }
    }

    public final void Q1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, str) != null) || isFinishing()) {
            return;
        }
        ArrayList arrayList = null;
        if (!this.J && !this.K) {
            l lVar = this.u;
            if (lVar != null) {
                lVar.cancel();
            }
            l lVar2 = new l(this, null);
            this.u = lVar2;
            lVar2.setPriority(3);
            this.u.execute(str);
            return;
        }
        this.w.f(null);
        if (!ListUtils.isEmpty(this.k)) {
            if (TextUtils.isEmpty(str)) {
                arrayList = this.k;
            } else {
                arrayList = new ArrayList();
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    MetaData metaData = (MetaData) it.next();
                    if (metaData.getName_show() != null && metaData.getName_show().contains(str)) {
                        arrayList.add(metaData);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            S1(0);
        } else {
            S1(1);
        }
        this.w.f(arrayList);
        this.w.notifyDataSetInvalidated();
        this.q.setSelection(0);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.onChangeSkinType(i2);
            zp4 layoutMode = getLayoutMode();
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.y);
            NoDataView noDataView = this.G;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.w.notifyDataSetChanged();
            SkinManager.setBackgroundResource(this.F, R.drawable.invite_friend_list_item_bg_color);
            SkinManager.setBackgroundResource(this.t, R.drawable.post_button_bg);
            nv4 d2 = nv4.d(this.t);
            d2.n(R.string.J_X03);
            d2.f(R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0101, 3);
            this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a26, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0201);
            WebPManager.setPureDrawable(this.E, R.drawable.obfuscated_res_0x7f080a7f, R.color.CAM_X0109, null);
            nv4 d3 = nv4.d(this.p);
            d3.n(R.string.J_X07);
            d3.l(R.dimen.L_X01);
            d3.k(R.color.CAM_X0615);
            d3.f(R.color.CAM_X0209);
            nv4.d(this.m).v(R.color.CAM_X0109);
            nv4.d(this.n).A(R.string.F_X01);
            nv4.d(this.e).v(R.color.CAM_X0109);
        }
    }

    public final void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.t.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f02aa), Integer.valueOf(i2), 5));
        }
    }

    public final void T1() {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.r.getItemLength() <= 0 && ((arrayList = this.L) == null || arrayList.size() <= 0)) {
                this.t.setEnabled(false);
            } else {
                this.t.setEnabled(true);
            }
        }
    }

    @Override // com.baidu.tieba.oe5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.M;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            l lVar = this.u;
            if (lVar != null) {
                lVar.cancel();
            }
            this.N.removeCallbacks(this.O);
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public io onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            BdListView bdListView = this.q;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (io) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            if (fj.D()) {
                Y0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
            this.G.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            this.G.e();
        }
    }

    @Override // com.baidu.tieba.oe5
    public boolean s() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            BdListView bdListView = this.q;
            if (bdListView == null || bdListView.getFirstVisiblePosition() != 0 || (childAt = this.q.getChildAt(0)) == null || childAt.getTop() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view2, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.onItemClick(adapterView, view2, i2, j2);
            MetaData item = this.w.getItem(i2);
            if (item == null) {
                return;
            }
            if (this.I) {
                if (this.u != null) {
                    return;
                }
                if (item.isChecked()) {
                    P1(item);
                } else if (5 <= this.r.getItemLength()) {
                    showToastWithIcon(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f0977), 5), R.drawable.obfuscated_res_0x7f080ada);
                    return;
                } else {
                    L1(item);
                }
                item.setChecked(!item.isChecked());
                this.w.notifyDataSetChanged();
                return;
            }
            fj.x(getPageContext().getPageActivity(), this.m);
            if (this.J) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
            }
            this.M = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.M.putExtras(bundle);
            finish();
        }
    }
}
