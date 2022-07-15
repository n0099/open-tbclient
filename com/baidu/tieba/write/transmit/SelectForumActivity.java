package com.baidu.tieba.write.transmit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.ForumSearchActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.write.share.ShareSdkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lx8;
import com.repackage.mx8;
import com.repackage.nx8;
import com.repackage.ox8;
import com.repackage.pi;
import com.repackage.px8;
import com.repackage.qx8;
import com.repackage.rx8;
import com.repackage.xz5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class SelectForumActivity extends BaseActivity<SelectForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public String C;
    public CustomMessageListener D;
    public View.OnClickListener E;
    public AdapterView.OnItemClickListener F;
    public BdListView a;
    public NavigationBar b;
    public View c;
    public TextView d;
    public rx8 e;
    public List<TransmitForumData> f;
    public View g;
    public FrameLayout h;
    public View i;
    public LinearLayout j;
    public ImageView k;
    public TextView l;
    public int m;
    public long n;
    public String o;
    public int p;
    public BaijiahaoData q;
    public OriginalThreadInfo.ShareInfo r;
    public String s;
    public String t;
    public mx8 u;
    public lx8 v;
    public nx8 w;
    public qx8 x;
    public String y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SelectForumActivity selectForumActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity, Integer.valueOf(i)};
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
            this.a = selectForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.a.f.clear();
            this.a.f.addAll((ArrayList) customResponsedMessage.getData());
            if (this.a.e != null) {
                SelectForumActivity selectForumActivity = this.a;
                selectForumActivity.hideLoadingView(selectForumActivity.h);
                this.a.e.b(this.a.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements lx8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public b(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.repackage.lx8
        public void a(nx8 nx8Var, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nx8Var, i, str) == null) {
                if (nx8Var == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.hideLoadingView(selectForumActivity.h);
                    this.a.showToast(str);
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, i);
                    this.a.setResult(1008, intent);
                    this.a.finish();
                    return;
                }
                if (this.a.w != null) {
                    this.a.w.c = nx8Var.c;
                    this.a.w.d = nx8Var.d;
                }
                xz5.c().i();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements px8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public c(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.repackage.px8
        public void a(ox8 ox8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ox8Var) == null) {
                if (ox8Var == null) {
                    SelectForumActivity selectForumActivity = this.a;
                    selectForumActivity.showToast(selectForumActivity.getString(R.string.obfuscated_res_0x7f0f116c));
                    Intent intent = new Intent();
                    intent.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, -2113);
                    this.a.setResult(1008, intent);
                } else {
                    ErrorData errorData = ox8Var.a;
                    if (errorData != null && errorData.getError_code() != 0) {
                        this.a.showToast(ox8Var.a.getError_msg());
                        Intent intent2 = new Intent();
                        intent2.putExtra(PmsConstant.Statistic.STATISTIC_ERRCODE, ox8Var.a.getError_code());
                        this.a.setResult(1008, intent2);
                    } else {
                        TiebaStatic.log(new StatisticItem("c13278").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", ox8Var.b).param("tid", ox8Var.c));
                        this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a).createNormalCfg(this.a.w.f, "")));
                    }
                }
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ShareSdkView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public d(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // com.baidu.tieba.write.share.ShareSdkView.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.a.w != null) {
                    this.a.w.m = str;
                }
                if (this.a.x != null) {
                    this.a.x.d(this.a.w);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public e(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null) {
                return;
            }
            if (view2.getId() != this.a.c.getId()) {
                if ((view2.getId() == this.a.k.getId() || view2.getId() == this.a.l.getId()) && ViewHelper.checkUpIsLogin(this.a)) {
                    if (this.a.w != null) {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c13276").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
                    }
                    this.a.Z1(1);
                    ForumSearchActivityConfig forumSearchActivityConfig = new ForumSearchActivityConfig(this.a.getPageContext().getPageActivity());
                    forumSearchActivityConfig.setFrom(this.a.m);
                    forumSearchActivityConfig.setLiveId(this.a.n);
                    forumSearchActivityConfig.setYyAnchorBdUid(this.a.o);
                    forumSearchActivityConfig.setBaijiahaoData(this.a.q);
                    forumSearchActivityConfig.setOriginalThread(this.a.r);
                    forumSearchActivityConfig.setTransmitOriginThreadComment(this.a.s);
                    forumSearchActivityConfig.setTransmitThreadAuthorNameShow(this.a.t);
                    forumSearchActivityConfig.setRequestCode(25019);
                    forumSearchActivityConfig.setIntentAction(IntentAction.ActivityForResult);
                    forumSearchActivityConfig.setMoreForumImg(this.a.z);
                    forumSearchActivityConfig.setMoreForumUrl(this.a.y);
                    forumSearchActivityConfig.setMoreForumTitle(this.a.A);
                    this.a.sendMessage(new CustomMessage(2002001, forumSearchActivityConfig));
                    return;
                }
                return;
            }
            this.a.setResult(0);
            this.a.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SelectForumActivity a;

        public f(SelectForumActivity selectForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selectForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selectForumActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            TransmitForumData transmitForumData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (transmitForumData = (TransmitForumData) this.a.f.get(i)) == null) {
                return;
            }
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(transmitForumData);
            if (this.a.w != null) {
                this.a.w.e = String.valueOf(transmitForumData.forumId);
                this.a.w.f = transmitForumData.forumName;
                this.a.Y1(AddFriendActivityConfig.TYPE_FOCUS);
            } else if (this.a.m != 1 || (this.a.n <= 0 && TextUtils.isEmpty(this.a.o))) {
                if (this.a.m != 2) {
                    if (this.a.m == 4) {
                        if (WriteActivityConfig.isAsyncWriting()) {
                            return;
                        }
                        SelectForumActivity selectForumActivity = this.a;
                        selectForumActivity.d2(transmitForumData, selectForumActivity.p);
                        this.a.finish();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putParcelableArrayListExtra(SelectForumActivityConfig.KEY_OUTPUT_FORUM_LIST, arrayList);
                    this.a.setResult(-1, intent);
                    this.a.finish();
                    return;
                }
                SelectForumActivity selectForumActivity2 = this.a;
                selectForumActivity2.e2(transmitForumData, selectForumActivity2.p);
                this.a.Z1(2);
                this.a.finish();
            } else {
                this.a.c2(arrayList);
            }
        }
    }

    public SelectForumActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.m = 0;
        this.n = -1L;
        this.B = false;
        this.D = new a(this, 2016563);
        this.E = new e(this);
        this.F = new f(this);
    }

    public final void Y1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.w == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c13277").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", str));
        ShareSdkView shareSdkView = new ShareSdkView(this);
        shareSdkView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        shareSdkView.setOnShareListener(new d(this));
        ((ViewGroup) this.g).addView(shareSdkView);
        shareSdkView.setData(this.w);
    }

    public final void Z1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            TiebaStatic.log(new StatisticItem("c12610").param("obj_locate", i));
        }
    }

    public final FrsTabInfoData a2(TransmitForumData transmitForumData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, transmitForumData)) == null) {
            if (transmitForumData == null || ListUtils.isEmpty(transmitForumData.tabItemDatas)) {
                return null;
            }
            ArrayList arrayList = new ArrayList(transmitForumData.tabItemDatas.size());
            Iterator<FrsTabItemData> it = transmitForumData.tabItemDatas.iterator();
            while (it.hasNext()) {
                FrsTabItemData next = it.next();
                if (next != null && next.isGeneralTab == 1) {
                    arrayList.add(next);
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = -1;
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeL.objValue;
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g = findViewById(R.id.obfuscated_res_0x7f091b72);
            this.h = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0921cc);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092437);
            this.b = navigationBar;
            TextView addTextButton = navigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.obfuscated_res_0x7f0f036a));
            this.c = addTextButton;
            if (addTextButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams.leftMargin = pi.f(getActivity(), R.dimen.obfuscated_res_0x7f070232);
                this.c.setLayoutParams(layoutParams);
            }
            this.d = this.b.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f10fe));
            this.c.setOnClickListener(this.E);
            this.j = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091252);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090dd3);
            this.k = imageView;
            imageView.setOnClickListener(this.E);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f092001);
            this.l = textView;
            textView.setOnClickListener(this.E);
            this.i = findViewById(R.id.obfuscated_res_0x7f092424);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f0921cf);
            this.a = bdListView;
            bdListView.setOnItemClickListener(this.F);
            rx8 rx8Var = new rx8(getActivity());
            this.e = rx8Var;
            this.a.setAdapter((ListAdapter) rx8Var);
            this.e.b(this.f);
        }
    }

    public final void c2(ArrayList<TransmitForumData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            AlaWriteShareInBarActivityConfig alaWriteShareInBarActivityConfig = new AlaWriteShareInBarActivityConfig(getPageContext().getPageActivity(), arrayList, String.valueOf(this.n), this.o);
            alaWriteShareInBarActivityConfig.setIntentAction(IntentAction.ActivityForResult);
            alaWriteShareInBarActivityConfig.setRequestCode(25038);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, alaWriteShareInBarActivityConfig));
        }
    }

    public final void d2(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, transmitForumData, i) == null) {
            if (transmitForumData != null) {
                str = String.valueOf(transmitForumData.forumId);
                str2 = transmitForumData.forumName;
            } else {
                str = "0";
                str2 = null;
            }
            WriteActivityConfig.newInstance(getPageContext().getPageActivity()).setType(9).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).setForumId(str).setMoreForumTitle(this.A).setMoreForumUrl(this.y).setMoreForumImg(this.z).setForumName(str2).setPrivateThread(i).send();
        }
    }

    public final void e2(TransmitForumData transmitForumData, int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, transmitForumData, i) == null) {
            if (transmitForumData != null) {
                str = String.valueOf(transmitForumData.forumId);
                str2 = transmitForumData.forumName;
            } else {
                str = null;
                str2 = null;
            }
            TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(getPageContext().getPageActivity(), 9, str, str2, null, null, 13011, null, null, null, this.r);
            transmitPostEditActivityConfig.setTopicId(this.C);
            transmitPostEditActivityConfig.setCallFrom("2");
            transmitPostEditActivityConfig.setPrivateThread(i);
            transmitPostEditActivityConfig.setBaijiahaoData(this.q);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.s);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.t);
            transmitPostEditActivityConfig.setFrsTabInfo(a2(transmitForumData));
            transmitPostEditActivityConfig.setIsShare(this.B);
            sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        }
    }

    public final void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        Uri data = intent.getData();
        String scheme = data != null ? data.getScheme() : null;
        this.C = intent.getStringExtra("topic_id");
        this.B = intent.getBooleanExtra("from_share", false);
        if (!StringUtils.isNull(scheme) && "tieba".equals(scheme)) {
            TiebaStatic.log(new StatisticItem("c13275").param("uid", TbadkCoreApplication.getCurrentAccount()));
            try {
                Class.forName("com.baidu.tieba.enterForum.home.CoreSearchRequestStatic");
                Class.forName("com.repackage.l56");
            } catch (Exception unused) {
            }
            this.m = 3;
            nx8 nx8Var = new nx8();
            this.w = nx8Var;
            nx8Var.a = intent.getStringExtra("appkey");
            this.w.b = intent.getStringExtra(SelectForumActivityConfig.KEY_APPLETSKEY);
            this.w.i = intent.getStringExtra("image");
            this.w.g = intent.getStringExtra("title");
            this.w.h = intent.getStringExtra("desc");
            this.w.k = intent.getStringExtra("link");
            this.w.l = intent.getStringExtra(SelectForumActivityConfig.KEY_SHARE_APPLETS_LINK);
            this.u = new mx8(getUniqueId());
            b bVar = new b(this);
            this.v = bVar;
            this.u.e(bVar);
            qx8 qx8Var = new qx8(getUniqueId());
            this.x = qx8Var;
            qx8Var.c(new c(this));
            return;
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("KEY_INTPUT_FORUM_LIST");
        if (ListUtils.getCount(parcelableArrayListExtra) > 0) {
            this.f.addAll(parcelableArrayListExtra);
        }
        this.m = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, 0);
        this.n = intent.getLongExtra("extra_key_live_id", -1L);
        this.o = intent.getStringExtra("extra_key_yy_anchor_bduid");
        this.p = intent.getIntExtra(SelectForumActivityConfig.EXTRA_KEY_PRIVATE_THREAD, 0);
        this.q = (BaijiahaoData) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_BAIJIAHAO_DATA);
        this.r = (OriginalThreadInfo.ShareInfo) intent.getSerializableExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD);
        this.s = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_ORIGIN_THREAD_CONTENT);
        this.t = intent.getStringExtra(SelectForumActivityConfig.EXTRA_KEY_TRANSMIT_THREAD_AUTHOR_NAME_SHOW);
        this.z = intent.getStringExtra("more_forum_img");
        this.y = intent.getStringExtra("more_forum_url");
        this.A = intent.getStringExtra("more_forum_title");
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 25038) {
                setResult(-1, intent);
                finish();
            } else if (i2 == -1 && i == 25019) {
                nx8 nx8Var = this.w;
                if (nx8Var != null && intent != null) {
                    nx8Var.e = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_ID);
                    this.w.f = intent.getStringExtra(SelectForumActivityConfig.SELECT_FORUM_NAME);
                    Y1("search");
                    return;
                }
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(getPageContext(), i);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0109);
            SkinManager.setImageResource(this.k, R.drawable.icon_post_search_n);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
            this.e.c(i);
            this.a.setSelector(SkinManager.getDrawable(R.drawable.selector_select_forum_item));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d075e);
            initData();
            b2();
            registerListener(this.D);
            if (this.w != null) {
                showLoadingView(this.h);
            }
            ViewHelper.checkUpIsLogin(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (this.u != null && TbadkCoreApplication.isLogin() && ListUtils.isEmpty(this.f)) {
                nx8 nx8Var = this.w;
                if (nx8Var != null) {
                    this.u.d(nx8Var.a, nx8Var.b);
                    return;
                }
                return;
            }
            hideLoadingView(this.h);
        }
    }
}
