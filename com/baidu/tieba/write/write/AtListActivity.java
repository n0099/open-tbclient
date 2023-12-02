package com.baidu.tieba.write.write;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
import com.baidu.tieba.jeb;
import com.baidu.tieba.lq5;
import com.baidu.tieba.qeb;
import com.baidu.tieba.rd;
import com.baidu.tieba.ti;
import com.baidu.tieba.vhb;
import com.baidu.tieba.write.write.AtSelectFriendList;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes8.dex */
public class AtListActivity extends SuspendedActivity implements lq5, AdapterView.OnItemClickListener, vhb.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TextView B;
    public View C;
    public View D;
    public ImageView E;
    public ImageView F;
    public View G;
    public NoDataView H;
    public RelativeLayout I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1174T;
    public int U;
    public boolean V;
    public boolean W;
    public ArrayList<AtSelectData> X;
    public Intent Y;
    public final Handler Z;
    public final Runnable a0;
    public String b0;
    public String c0;
    public ArrayList<MetaData> k;
    @Nullable
    public Set<String> l;
    public NavigationBar m;
    public EditText n;
    public TextView o;
    public LinearLayout p;
    public LinearLayout q;
    public BdListView r;
    public AtSelectFriendList s;
    public LinearLayout t;
    public Button u;
    public l v;
    public qeb w;
    public vhb x;
    public String y;
    public RelativeLayout z;

    @Override // com.baidu.tieba.lq5
    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtListActivity a;

        /* renamed from: com.baidu.tieba.write.write.AtListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC0522a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0522a(a aVar) {
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
                this.a.a.l1();
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
                this.a.n.getText().clear();
                this.a.B.setVisibility(0);
                this.a.D.setVisibility(0);
                this.a.C.setVisibility(8);
                if (this.a.e == null) {
                    AtListActivity atListActivity = this.a;
                    atListActivity.e = atListActivity.m.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05a0), new View$OnClickListenerC0522a(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.r.requestFocus();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                atListActivity.M2(rd.charSequence2String(atListActivity.n.getText(), ""));
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.n);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
                    if (5 <= this.a.s.getItemLength()) {
                        AtListActivity atListActivity = this.a;
                        atListActivity.showToastWithIcon(String.format(atListActivity.getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                        tbCheckBox.setChecked(false);
                        ((MetaData) obj).setChecked(false);
                        return;
                    }
                    this.a.A2((MetaData) obj);
                    return;
                }
                this.a.L2((MetaData) obj);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.n);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.Y = new Intent();
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA, this.a.s.getDataList());
                bundle.putString(AtListActivityConfig.CALL_AT_LIST_SOURCE, this.a.N);
                bundle.putString(AtListActivityConfig.AT_SELECT_REFER_STRING, this.a.O);
                this.a.Y.putExtras(bundle);
                BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), this.a.n);
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_COMMIT);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", this.a.b0);
                statisticItem.param("fid", this.a.c0);
                StringBuilder sb = new StringBuilder();
                if (this.a.s.getDataList() != null) {
                    Iterator<AtSelectData> it = this.a.s.getDataList().iterator();
                    boolean z = true;
                    while (it.hasNext()) {
                        String uid = it.next().getUid();
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

    /* loaded from: classes8.dex */
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
                View findViewWithTag = this.a.r.findViewWithTag(obj);
                if (findViewWithTag instanceof TbCheckBox) {
                    ((TbCheckBox) findViewWithTag).setChecked(false);
                } else if (!(obj instanceof MetaData)) {
                } else {
                    this.a.L2((MetaData) obj);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
                this.a.B.setVisibility(8);
                this.a.D.setVisibility(8);
                this.a.C.setVisibility(0);
                this.a.n.requestFocus();
                this.a.m.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT).removeAllViews();
                this.a.e = null;
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || (charSequence2String = rd.charSequence2String(editable, null)) == null) {
                return;
            }
            if (!charSequence2String.equals(this.a.y)) {
                this.a.Z.removeCallbacks(this.a.a0);
                this.a.Z.postDelayed(this.a.a0, 300L);
            }
            if (charSequence2String.length() > 0) {
                this.a.o.setVisibility(0);
            } else {
                this.a.o.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a.y = rd.charSequence2String(charSequence, null);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                    BdUtilHelper.hideSoftKeyPad(this.a.getPageContext().getPageActivity(), view2);
                } else {
                    BdUtilHelper.showSoftKeyPad(this.a.getPageContext().getPageActivity(), view2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends BdAsyncTask<String, Integer, jeb> {
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
        public jeb doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                String str = strArr[0];
                this.a = new NetWork();
                String str2 = "1";
                if (this.b.K) {
                    NetWork netWork = this.a;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "1");
                } else if (this.b.L) {
                    NetWork netWork2 = this.a;
                    netWork2.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/list");
                    this.a.addPostData("from", "2");
                } else if (this.b.M) {
                    NetWork netWork3 = this.a;
                    netWork3.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/atSearchUserList");
                    if (!StringUtils.isNull(this.b.c0)) {
                        this.a.addPostData("fid", this.b.c0);
                    }
                    this.a.addPostData("chatroom_id", this.b.P);
                    this.a.addPostData("choose_list", this.b.S);
                    this.a.addPostData("at_from", "chatroom");
                    NetWork netWork4 = this.a;
                    if (!this.b.f1174T) {
                        str2 = "0";
                    }
                    netWork4.addPostData("need_bot", str2);
                    this.a.addPostData("forum_id", this.b.Q);
                    this.a.addPostData("forum_name", this.b.R);
                    this.a.addPostData("rn", YYOption.UrlProtocol.USER);
                    if (!rd.isEmpty(str)) {
                        this.a.addPostData(DownloadStatisticConstants.UBC_VALUE_WORD, str);
                    }
                } else {
                    NetWork netWork5 = this.a;
                    netWork5.setUrl(TbConfig.SERVER_ADDRESS + "c/u/follow/atSearchUserList");
                    this.a.addPostData("rn", YYOption.UrlProtocol.USER);
                    if (!rd.isEmpty(str)) {
                        this.a.addPostData(DownloadStatisticConstants.UBC_VALUE_WORD, str);
                    }
                }
                String postNetData = this.a.postNetData();
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    jeb jebVar = new jeb();
                    jebVar.d(postNetData);
                    return jebVar;
                }
                return null;
            }
            return (jeb) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(jeb jebVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jebVar) == null) {
                this.b.v = null;
                AtListActivity atListActivity = this.b;
                atListActivity.hideNetRefreshView(atListActivity.I);
                if (this.b.t != null && this.b.t.getVisibility() == 0) {
                    this.b.A.setVisibility(0);
                }
                if (this.a.getNetContext().getResponse().isRequestSuccess()) {
                    this.b.w.b(jebVar);
                    if (this.b.x == null) {
                        return;
                    }
                    if (jebVar != null) {
                        AtListActivity atListActivity2 = this.b;
                        atListActivity2.k = atListActivity2.J2(jebVar);
                        this.b.l = jebVar.b();
                    }
                    this.b.x.h(this.b.k);
                    this.b.x.notifyDataSetInvalidated();
                    this.b.r.setSelection(0);
                } else {
                    this.b.showToast(this.a.getErrorString());
                    AtListActivity atListActivity3 = this.b;
                    atListActivity3.showNetRefreshView(atListActivity3.I, this.b.getString(R.string.refresh_view_title_text), null, this.b.getString(R.string.refresh_view_button_text), true, this.b.getNetRefreshListener());
                }
                super.onPostExecute(jebVar);
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
                this.b.v = null;
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
        this.k = new ArrayList<>();
        this.r = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.J = true;
        this.K = false;
        this.L = false;
        this.M = false;
        this.f1174T = true;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.Z = new Handler();
        this.a0 = new c(this);
    }

    public final void P2() {
        int i2;
        ArrayList<AtSelectData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.s.getItemLength() <= 0 && ((arrayList = this.X) == null || arrayList.size() <= 0)) {
                if (this.W) {
                    this.u.setEnabled(true);
                } else {
                    this.u.setEnabled(false);
                }
            } else {
                this.u.setEnabled(true);
            }
            EMManager from = EMManager.from(this.u);
            if (this.u.isEnabled()) {
                i2 = R.color.CAM_X0302;
            } else {
                i2 = R.color.CAM_X0905;
            }
            from.setBackGroundColor(i2);
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048605, this) != null) || isFinishing()) {
            return;
        }
        this.x.h(null);
        this.V = false;
        if (this.w.a() != null) {
            this.x.h(J2(this.w.a()));
        } else {
            this.x.h(null);
            if (this.v == null) {
                l lVar = new l(this, null);
                this.v = lVar;
                lVar.setPriority(3);
                this.v.execute("");
            }
        }
        this.x.notifyDataSetInvalidated();
        this.r.setSelection(0);
    }

    public final void A2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) && metaData != null) {
            this.s.e(metaData);
            N2(this.s.getItemLength());
            P2();
        }
    }

    public boolean H2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Set<String> set = this.l;
            if (set != null && set.size() > 0 && !StringUtils.isNull(str)) {
                return this.l.contains(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void L2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, metaData) == null) && metaData != null) {
            this.s.m(metaData);
            N2(this.s.getItemLength());
            P2();
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bundle) == null) {
            super.onCreate(bundle);
            E2(bundle);
            G2();
            v1();
        }
    }

    @Override // com.baidu.tieba.vhb.c
    public void H0(View view2, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, metaData) != null) || metaData == null) {
            return;
        }
        this.s.g(metaData);
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity
    public lq5 m1(LinearLayout linearLayout, NavigationBar navigationBar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, linearLayout, navigationBar)) == null) {
            this.p = linearLayout;
            this.m = navigationBar;
            LayoutInflater.from(this).inflate(R.layout.obfuscated_res_0x7f0d0132, (ViewGroup) this.p, true);
            return this;
        }
        return (lq5) invokeLL.objValue;
    }

    private void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            this.B = this.m.setCenterTextTitle(getPageContext().getString(R.string.select_friend));
            View addCustomView = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, new i(this));
            this.D = addCustomView;
            this.E = (ImageView) addCustomView.findViewById(R.id.new_friend_search);
            View addCustomView2 = this.m.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.navigationbar_search_edit, (View.OnClickListener) null);
            this.C = addCustomView2;
            addCustomView2.setVisibility(8);
            this.n = (EditText) this.C.findViewById(R.id.et_search);
            this.F = (ImageView) this.C.findViewById(R.id.et_bar_icon);
            this.n.addTextChangedListener(new j(this));
            this.n.setOnFocusChangeListener(new k(this));
            TextView textView = (TextView) findViewById(R.id.et_search_cancel_s);
            this.o = textView;
            textView.setOnClickListener(new a(this));
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070275) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be) + getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
            View view2 = new View(getPageContext().getContext());
            this.G = view2;
            view2.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
            this.G.setFocusable(false);
            this.G.setFocusableInTouchMode(false);
            this.G.setContentDescription("");
            this.G.setVisibility(4);
            this.G.setBackgroundColor(0);
            this.G.setOnClickListener(new b(this));
            this.r.addFooterView(this.G);
        }
    }

    @Override // com.baidu.tieba.lq5
    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.n);
            View view2 = this.C;
            if (view2 != null && view2.getVisibility() == 0) {
                this.C.setVisibility(8);
                this.B.setVisibility(0);
                this.D.setVisibility(0);
                this.n.getText().clear();
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.M && this.U != 0 && !this.V && (TextUtils.equals(this.N, AtListActivityConfig.GROUP_CHAT_PAGE) || TextUtils.equals(this.N, AtListActivityConfig.GROUP_BOT_SKILL))) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public final MetaData C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MetaData metaData = new MetaData();
            metaData.setUserId(AtSelectData.AT_ALL_FAKE_UID);
            metaData.setName_show(AtSelectData.AT_ALL_FAKE_NAME);
            metaData.setPortrait(AtSelectData.AT_ALL_FAKE_PORTRAIT);
            metaData.setChecked(false);
            return metaData;
        }
        return (MetaData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lq5
    public boolean S() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            BdListView bdListView = this.r;
            if (bdListView == null || bdListView.getFirstVisiblePosition() != 0 || (childAt = this.r.getChildAt(0)) == null || childAt.getTop() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lq5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.Y;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            l lVar = this.v;
            if (lVar != null) {
                lVar.cancel();
            }
            this.Z.removeCallbacks(this.a0);
            super.onDestroy();
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity
    public ti onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            BdListView bdListView = this.r;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (ti) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onNetRefreshButtonClicked();
            if (BdUtilHelper.isNetOk()) {
                v1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onStart();
            this.H.d(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onStop();
            this.H.e();
        }
    }

    public final ArrayList<MetaData> D2(@NonNull ArrayList<MetaData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, arrayList)) == null) {
            Iterator<MetaData> it = arrayList.iterator();
            while (it.hasNext()) {
                MetaData next = it.next();
                if (next != null) {
                    next.setChecked(false);
                    if (!StringUtils.isNull(this.S) && this.S.contains(next.getUserId())) {
                        A2(next);
                    }
                }
            }
            if (!ListUtils.isEmpty(arrayList)) {
                O2(0);
            } else {
                O2(1);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void K2(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, metaData) == null) {
            this.Y = new Intent();
            Bundle bundle = new Bundle();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(new AtSelectData(metaData.getPortrait(), metaData.getName_show(), metaData.getUserId(), true));
            bundle.putParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA, arrayList);
            bundle.putBoolean(IntentConfig.IS_AT_SELECT_BOT_DATA, true);
            this.Y.putExtras(bundle);
            finish();
        }
    }

    public final void E2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            this.w = new qeb();
            if (bundle != null) {
                this.J = bundle.getBoolean(IntentConfig.IS_NEED_MULTIPLE);
                this.K = bundle.getBoolean(AtListActivityConfig.IS_FOR_CHAT, false);
                this.L = bundle.getBoolean(AtListActivityConfig.IS_FOR_BJH, false);
                this.M = bundle.getBoolean(AtListActivityConfig.IS_FOR_GROUP_CHAT, false);
                this.N = bundle.getString(AtListActivityConfig.CALL_AT_LIST_SOURCE, "");
                this.O = bundle.getString(AtListActivityConfig.AT_SELECT_REFER_STRING, "");
                this.P = bundle.getString(AtListActivityConfig.GROUP_CHAT_ROOM_ID, "");
                this.Q = bundle.getString(AtListActivityConfig.GROUP_CHAT_FORUM_ID, "");
                this.R = bundle.getString(AtListActivityConfig.GROUP_CHAT_FORUM_NAME, "");
                this.S = bundle.getString(AtListActivityConfig.AT_SELECT_UID_DATA, "");
                this.f1174T = bundle.getBoolean(AtListActivityConfig.IS_SHOW_BOT_INFO, true);
                this.U = bundle.getInt(AtListActivityConfig.USER_ROLE, 0);
                this.X = bundle.getParcelableArrayList(IntentConfig.AT_SELECT_LIST_DATA);
                this.b0 = bundle.getString("thread_id");
                this.c0 = bundle.getString("forum_id");
                this.W = bundle.getBoolean(AtListActivityConfig.CALL_AT_LIST_OPTIONAL, false);
                return;
            }
            this.J = getIntent().getBooleanExtra(IntentConfig.IS_NEED_MULTIPLE, true);
            this.K = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_CHAT, false);
            this.L = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_BJH, false);
            this.M = getIntent().getBooleanExtra(AtListActivityConfig.IS_FOR_GROUP_CHAT, false);
            this.N = getIntent().getStringExtra(AtListActivityConfig.CALL_AT_LIST_SOURCE);
            this.O = getIntent().getStringExtra(AtListActivityConfig.AT_SELECT_REFER_STRING);
            this.P = getIntent().getStringExtra(AtListActivityConfig.GROUP_CHAT_ROOM_ID);
            this.Q = getIntent().getStringExtra(AtListActivityConfig.GROUP_CHAT_FORUM_ID);
            this.R = getIntent().getStringExtra(AtListActivityConfig.GROUP_CHAT_FORUM_NAME);
            this.S = getIntent().getStringExtra(AtListActivityConfig.AT_SELECT_UID_DATA);
            this.f1174T = getIntent().getBooleanExtra(AtListActivityConfig.IS_SHOW_BOT_INFO, true);
            this.U = getIntent().getIntExtra(AtListActivityConfig.USER_ROLE, 0);
            this.X = getIntent().getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
            this.b0 = getIntent().getStringExtra("thread_id");
            this.c0 = getIntent().getStringExtra("forum_id");
            this.W = getIntent().getBooleanExtra(AtListActivityConfig.CALL_AT_LIST_OPTIONAL, false);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.z = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091b42);
            this.H = NoDataViewFactory.b(getPageContext().getContext(), this.z, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOFOLLOW, BdUtilHelper.getDimens(getActivity(), R.dimen.obfuscated_res_0x7f0703bd)), NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)), null, true);
            this.A = findViewById(R.id.obfuscated_res_0x7f090309);
            this.H.setOnTouchListener(new d(this));
            s1();
            this.q = (LinearLayout) findViewById(R.id.bt_search_left);
            this.I = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0907f7);
            this.r = (BdListView) findViewById(R.id.obfuscated_res_0x7f091608);
            vhb vhbVar = new vhb(this, this.J);
            this.x = vhbVar;
            vhbVar.i(this);
            this.x.g(new e(this));
            this.r.setAdapter((ListAdapter) this.x);
            this.r.setOnItemClickListener(this);
            this.r.setOnTouchListener(new f(this));
            if (!getIntent().getBooleanExtra("keyboard", false) && this.n.getParent() != null) {
                ((View) this.n.getParent()).setFocusable(true);
                ((View) this.n.getParent()).setFocusableInTouchMode(true);
            }
            this.t = (LinearLayout) this.z.findViewById(R.id.obfuscated_res_0x7f091210);
            Button button = (Button) this.z.findViewById(R.id.obfuscated_res_0x7f090562);
            this.u = button;
            button.setOnClickListener(new g(this));
            N2(0);
            AtSelectFriendList atSelectFriendList = (AtSelectFriendList) this.z.findViewById(R.id.obfuscated_res_0x7f090583);
            this.s = atSelectFriendList;
            atSelectFriendList.setMaxCount(5);
            this.s.setItemOPerationHandler(new h(this));
            B2();
            ArrayList<AtSelectData> arrayList = this.X;
            if (arrayList != null) {
                Iterator<AtSelectData> it = arrayList.iterator();
                while (it.hasNext()) {
                    AtSelectData next = it.next();
                    MetaData metaData = new MetaData();
                    metaData.setPortrait(next.getPortrait());
                    metaData.setName_show(next.getNameShow());
                    A2(metaData);
                }
            }
        }
    }

    public final ArrayList<MetaData> J2(@NonNull jeb jebVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, jebVar)) == null) {
            ArrayList<MetaData> arrayList = new ArrayList<>();
            if (!ListUtils.isEmpty(jebVar.c()) && !ListUtils.isEmpty(jebVar.a())) {
                ArrayList<MetaData> a2 = jebVar.a();
                ArrayList<MetaData> c2 = jebVar.c();
                if (I2()) {
                    arrayList.add(C2());
                }
                if (this.f1174T) {
                    arrayList.addAll(a2);
                }
                arrayList.addAll(c2);
            } else {
                if (!ListUtils.isEmpty(jebVar.c())) {
                    if (I2()) {
                        arrayList.add(C2());
                    }
                    arrayList.addAll(jebVar.c());
                }
                return arrayList;
            }
            D2(arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void O2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            if (i2 == 2) {
                this.r.setVisibility(8);
                hideNetRefreshView(this.I);
                this.H.setVisibility(0);
                this.H.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.no_chat_friends)));
                this.t.setVisibility(8);
            } else if (i2 == 1) {
                this.r.setVisibility(8);
                hideNetRefreshView(this.I);
                this.H.setVisibility(0);
                this.H.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec0)));
                this.t.setVisibility(8);
            } else if (i2 == 0) {
                this.r.setVisibility(0);
                this.H.setVisibility(8);
                if (this.J) {
                    this.t.setVisibility(0);
                }
            }
        }
    }

    public final void M2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || isFinishing()) {
            return;
        }
        ArrayList<MetaData> arrayList = null;
        if (!this.K && !this.L) {
            l lVar = this.v;
            if (lVar != null) {
                lVar.cancel();
            }
            this.V = !StringUtils.isNull(str);
            l lVar2 = new l(this, null);
            this.v = lVar2;
            lVar2.setPriority(3);
            this.v.execute(str);
            return;
        }
        this.x.h(null);
        if (!ListUtils.isEmpty(this.k)) {
            if (TextUtils.isEmpty(str)) {
                arrayList = this.k;
            } else {
                arrayList = new ArrayList<>();
                Iterator<MetaData> it = this.k.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getName_show() != null && next.getName_show().contains(str)) {
                        arrayList.add(next);
                    }
                }
            }
        }
        if (!ListUtils.isEmpty(arrayList)) {
            O2(0);
        } else {
            O2(1);
        }
        this.x.h(arrayList);
        this.x.notifyDataSetInvalidated();
        this.r.setSelection(0);
    }

    public final void N2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.u.setText(String.format(getPageContext().getString(R.string.obfuscated_res_0x7f0f02e8), Integer.valueOf(i2), 5));
        }
    }

    @Override // com.baidu.tbadk.suspended.SuspendedActivity, com.baidu.tbadk.core.BaseFragmentActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            super.onChangeSkinType(i2);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            getLayoutMode().onModeChanged(this.z);
            NoDataView noDataView = this.H;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.x.notifyDataSetChanged();
            SkinManager.setBackgroundResource(this.G, R.drawable.invite_friend_list_item_bg_color);
            EMManager.from(this.t).setBackGroundColor(R.color.CAM_X0207);
            EMManager textStyle = EMManager.from(this.u).setCorner(R.string.J_X01).setTextSize(R.dimen.T_X08).setBorderColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01);
            if (this.u.isEnabled()) {
                i3 = R.color.CAM_X0302;
            } else {
                i3 = R.color.CAM_X0905;
            }
            textStyle.setBackGroundColor(i3);
            SkinManager.setViewTextColor(this.u, R.color.CAM_X0101, 3);
            this.E.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            SkinManager.setViewTextColor(this.I, (int) R.color.CAM_X0201);
            WebPManager.setPureDrawable(this.F, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            EMManager.from(this.q).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0615).setBackGroundColor(R.color.CAM_X0209);
            EMManager.from(this.n).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.o).setTextStyle(R.string.F_X01);
            EMManager.from(this.e).setTextColor(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{adapterView, view2, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            super.onItemClick(adapterView, view2, i2, j2);
            MetaData item = this.x.getItem(i2);
            if (item == null) {
                return;
            }
            if (this.J) {
                if (this.v != null) {
                    return;
                }
                if (H2(item.getUserId())) {
                    K2(item);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ROBOT_CLICK).param("obj_name", item.getName_show()).param("fid", this.Q).param("room_id", this.P).param("fname", this.R).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    return;
                }
                if (item.isChecked()) {
                    L2(item);
                } else if (5 <= this.s.getItemLength()) {
                    showToastWithIcon(String.format(getPageContext().getString(R.string.invite_friend_exceed_max_count), 5), R.drawable.icon_toast_game_error);
                    return;
                } else {
                    A2(item);
                }
                item.setChecked(!item.isChecked());
                this.x.notifyDataSetChanged();
                return;
            }
            BdUtilHelper.hideSoftKeyPad(getPageContext().getPageActivity(), this.n);
            if (this.K) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, item.getUserIdLong(), item.getUserName(), item.getName_show(), item.getPortrait(), item.getGender(), item.getIsMyFriend())));
                TiebaStatic.log(new StatisticItem("c12930").param("obj_id", item.getUserIdLong()));
            }
            this.Y = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("name_show", item.getName_show());
            bundle.putString("user_name", item.getUserName());
            bundle.putString("user_id", item.getUserId());
            bundle.putString("portrait", item.getPortrait());
            this.Y.putExtras(bundle);
            finish();
        }
    }
}
