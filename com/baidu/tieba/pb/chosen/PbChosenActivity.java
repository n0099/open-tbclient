package com.baidu.tieba.pb.chosen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.at8;
import com.baidu.tieba.b95;
import com.baidu.tieba.bt8;
import com.baidu.tieba.ct8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.ii;
import com.baidu.tieba.iv4;
import com.baidu.tieba.mn;
import com.baidu.tieba.mt9;
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.pl5;
import com.baidu.tieba.q45;
import com.baidu.tieba.qe5;
import com.baidu.tieba.ss8;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.te5;
import com.baidu.tieba.us8;
import com.baidu.tieba.uz8;
import com.baidu.tieba.ve5;
import com.baidu.tieba.vs8;
import com.baidu.tieba.ws8;
import com.baidu.tieba.xs8;
import com.baidu.tieba.ys8;
import com.baidu.tieba.z8;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes5.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qe5 A;
    public View.OnClickListener B;
    public final NewWriteModel.d C;
    public at8.a D;
    public View.OnClickListener E;
    public CustomMessageListener F;
    public CustomMessageListener G;
    public ct8.c H;
    public bt8.e I;
    public za J;
    public CustomMessageListener K;
    public za L;
    public CustomMessageListener M;
    public RelativeLayout a;
    public BdListView b;
    public bt8 c;
    public ct8 d;
    public NavigationBar e;
    public at8 f;
    public dt8 g;
    public TextView h;
    public View i;
    public ys8 j;
    public vs8 k;
    public LikeModel l;
    public xs8 m;
    public ws8 n;
    public ss8 o;
    public te5 p;
    public DataModel<PbChosenActivity> q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public long v;
    public int w;
    public VoiceManager x;
    public int y;
    public final AbsListView.OnScrollListener z;

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i d1(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tieba.ml5
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "a013" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements bt8.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* renamed from: com.baidu.tieba.pb.chosen.PbChosenActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0379a extends z8 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0379a(a aVar) {
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

            @Override // com.baidu.tieba.z8
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.a.a.l.getErrorCode(), this.a.a.l.getErrorString())) {
                    AntiHelper.u(this.a.a.getActivity(), this.a.a.l.getErrorString());
                }
            }
        }

        public a(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.bt8.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(str, "from_chosen_pb")));
            if (this.a.k != null && this.a.k.getThreadInfo() != null && this.a.k.getThreadInfo().excid != null) {
                TiebaStatic.log(new StatisticItem("pb_new_sourcefid").param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
            }
        }

        @Override // com.baidu.tieba.bt8.e
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str, str2)));
            }
        }

        @Override // com.baidu.tieba.bt8.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdToast.b(this.a.getPageContext().getPageActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b)).o();
                } else if (!this.a.checkUpIsLogin() || this.a.k == null || this.a.k.getThreadInfo() == null || this.a.k.getThreadInfo().forum.forum_id == null) {
                } else {
                    if (this.a.l == null) {
                        PbChosenActivity pbChosenActivity = this.a;
                        pbChosenActivity.l = new LikeModel(pbChosenActivity.getPageContext());
                    }
                    this.a.l.setFrom("from_frs");
                    this.a.l.setLoadDataCallBack(new C0379a(this));
                    this.a.l.i0(this.a.k.getThreadInfo().forum.forum_name, String.valueOf(this.a.k.getThreadInfo().forum.forum_id));
                    if (this.a.k != null && this.a.k.getThreadInfo() != null) {
                        StatisticItem statisticItem = new StatisticItem("c10322");
                        StatisticItem param = statisticItem.param("fid", this.a.k.getThreadInfo().forum.forum_id + "");
                        TiebaStatic.log(param.param("tid", this.a.k.getThreadInfo().thread_id + "").param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbChosenActivity pbChosenActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorText;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof vs8)) {
                vs8 vs8Var = (vs8) responsedMessage;
                int erroCode = vs8Var.getErroCode();
                this.a.u = true;
                if (erroCode == 0) {
                    this.a.b2(vs8Var);
                } else {
                    PbChosenActivity pbChosenActivity = this.a;
                    pbChosenActivity.hideLoadingView(pbChosenActivity.a);
                    if (StringUtils.isNull(vs8Var.getErrorText())) {
                        errorText = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                    } else {
                        errorText = vs8Var.getErrorText();
                    }
                    this.a.showToast(errorText);
                }
                if (!this.a.t) {
                    String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05ec);
                    PbChosenActivity pbChosenActivity2 = this.a;
                    pbChosenActivity2.showNetRefreshView(pbChosenActivity2.a, string, true);
                    this.a.setNetRefreshLayoutMarginTop(false);
                    this.a.g.e(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbChosenActivity pbChosenActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i)};
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
            this.a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.d.n();
                this.a.d.h = !this.a.d.h;
                this.a.d.m(this.a.d.h);
                if (this.a.d.h) {
                    this.a.y = 1;
                } else {
                    this.a.y = 0;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbChosenActivity pbChosenActivity, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            this.a.d.n();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0d1b);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.b(this.a.getPageContext().getPageActivity(), errorString).o();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                this.a.d.m(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.a.y = 1;
                } else {
                    this.a.y = 0;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbChosenActivity pbChosenActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i)};
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
            this.a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ReadChosenPbCacheResponse) || this.a.getIntent() == null) {
                return;
            }
            long longExtra = this.a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
            long longExtra2 = this.a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
            long longExtra3 = this.a.getIntent().getLongExtra("thread_id", 0L);
            vs8 chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
            if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                this.a.u = true;
                this.a.b2(chosenData);
            }
            if (this.a.n == null) {
                this.a.n = new ws8();
            }
            this.a.n.c(this.a, longExtra, longExtra2, longExtra3);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public f(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                ii.z(this.a.getActivity(), this.a.getCurrentFocus());
                if (this.a.p != null && this.a.p.b() != null) {
                    this.a.p.b().q();
                }
                this.a.g.e(true);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public g(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public h(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && this.a.k.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10091");
                TiebaStatic.log(statisticItem.param("tid", this.a.k.getThreadInfo().thread_id + "").param("obj_name", this.a.k.getThreadInfo().tag_name).param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageContext().getPageActivity());
                this.a.sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPbChosen(this.a.k.getThreadInfo().thread_id + "", this.a.y)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends DataModel<PbChosenActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String S() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String U() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String V() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String W() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean Z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean a0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean b0() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean loadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbChosenActivity pbChosenActivity, a9 a9Var) {
            super(a9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, a9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String T() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.k != null && this.a.k.getThreadInfo() != null) {
                    return String.valueOf(this.a.k.getThreadInfo().thread_id);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData X(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (this.a.k != null && this.a.k.getThreadInfo() != null) {
                    WriteData writeData = new WriteData();
                    writeData.setForumId(String.valueOf(this.a.k.getThreadInfo().forum.forum_id));
                    writeData.setForumName(this.a.k.getThreadInfo().forum.forum_name);
                    writeData.setThreadId(String.valueOf(this.a.k.getThreadInfo().thread_id));
                    writeData.setIsAd(false);
                    writeData.setType(1);
                    return writeData;
                }
                return null;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.a.k != null && this.a.k.getThreadInfo() != null && this.a.k.getThreadInfo().forum != null) {
                    return String.valueOf(this.a.k.getThreadInfo().forum.forum_id);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        public j(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) && i != 0 && this.a.p != null && this.a.p.b() != null) {
                this.a.p.b().q();
                this.a.g.e(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements qe5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public k(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.qe5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public l(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.checkUpIsLogin() && this.a.p != null && this.a.p.b() != null) {
                this.a.p.b().j();
                this.a.g.e(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public m(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b95 b95Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, b95Var, writeData, antiData}) == null) {
                this.a.hideProgressBar();
                if (z) {
                    this.a.p.b().q();
                    this.a.g.e(true);
                } else if (postWriteCallBackData != null && b95Var == null && postWriteCallBackData.getErrorCode() != 227001 && !mt9.d(postWriteCallBackData.getErrorCode())) {
                    if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                        AntiHelper.u(this.a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                    } else {
                        BdToast.b(this.a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).o();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements at8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public n(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.at8.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || !this.a.checkUpIsLogin() || this.a.k == null || this.a.k.getThreadInfo() == null || StringUtils.isNull(str)) {
                return;
            }
            if (this.a.k != null && this.a.k.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10093");
                TiebaStatic.log(statisticItem.param("tid", this.a.k.getThreadInfo().thread_id + "").param("obj_name", this.a.k.getThreadInfo().tag_name).param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
            }
            this.a.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(this.a.k.getThreadInfo().thread_id + "", str, "pb_chosen", true, null, true)));
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public o(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.k != null && this.a.k.getThreadInfo() != null) {
                    TiebaStatic.log(new StatisticItem("pb_new_share").param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
                }
                if (!this.a.checkUpIsLogin()) {
                    return;
                }
                if (this.a.w == 2) {
                    TiebaStatic.log("c10148");
                }
                if (this.a.o == null) {
                    PbChosenActivity pbChosenActivity = this.a;
                    pbChosenActivity.o = new ss8(pbChosenActivity);
                }
                this.a.o.e(this.a.k, this.a.r);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PbChosenActivity pbChosenActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i)};
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
            this.a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.W1(true, customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbChosenActivity pbChosenActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i)};
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
            this.a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.W1(false, customResponsedMessage);
        }
    }

    /* loaded from: classes5.dex */
    public class r implements ct8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        public r(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.ct8.c
        public void a(long j, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJL(1048576, this, j, str) != null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getPageContext().getPageActivity()).createCfgForPbChosen(str, this.a.y)));
            if (this.a.k != null && this.a.k.getThreadInfo() != null && this.a.k.getThreadInfo().excid != null) {
                TiebaStatic.log(new StatisticItem("pb_new_detail_btn").param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
            }
        }

        @Override // com.baidu.tieba.ct8.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && this.a.k != null && this.a.k.getThreadInfo() != null && this.a.k.getThreadInfo().excid != null) {
                if (this.a.m == null) {
                    this.a.m = new xs8();
                }
                if (z) {
                    xs8 xs8Var = this.a.m;
                    PbChosenActivity pbChosenActivity = this.a;
                    xs8Var.c(pbChosenActivity, pbChosenActivity.k.getThreadInfo().excid.longValue(), this.a.k.getThreadInfo().thread_id.longValue(), this.a.k.getThreadInfo().post_id.longValue(), 2);
                } else {
                    xs8 xs8Var2 = this.a.m;
                    PbChosenActivity pbChosenActivity2 = this.a;
                    xs8Var2.c(pbChosenActivity2, pbChosenActivity2.k.getThreadInfo().excid.longValue(), this.a.k.getThreadInfo().thread_id.longValue(), this.a.k.getThreadInfo().post_id.longValue(), 1);
                }
                TiebaStatic.log(new StatisticItem("pb_new_like").param("obj_source", this.a.k.getThreadInfo().source.intValue()).param("abtest", this.a.k.getThreadInfo().abtest));
            }
        }
    }

    public PbChosenActivity() {
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
        this.r = null;
        this.t = false;
        this.u = false;
        this.w = 1;
        this.y = -1;
        this.z = new j(this);
        this.A = new k(this);
        this.B = new l(this);
        this.C = new m(this);
        this.D = new n(this);
        this.E = new o(this);
        this.F = new p(this, 2001335);
        this.G = new q(this, 2001336);
        this.H = new r(this);
        this.I = new a(this);
        this.J = new b(this, CmdConfigHttp.CMD_GET_FINE_PB, 309093);
        this.K = new c(this, 2004004);
        this.L = new d(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
        this.M = new e(this, 2001314);
    }

    public final void a2(te5 te5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, te5Var) == null) && te5Var.b() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.a.addView(te5Var.b(), layoutParams);
            te5Var.b().q();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            te5 te5Var = this.p;
            if (te5Var != null) {
                te5Var.F(bundle);
            }
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (z && !this.s && !this.u) {
                this.s = true;
                showLoadingView(this.a, true);
            }
        }
    }

    public final DataModel<PbChosenActivity> V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.q == null) {
                this.q = new i(this, getPageContext());
            }
            return this.q;
        }
        return (DataModel) invokeV.objValue;
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new us8());
            CustomMessage customMessage = new CustomMessage(2001314);
            customMessage.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            te5 te5Var = this.p;
            if (te5Var != null) {
                te5Var.D();
            }
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public mn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            BdListView bdListView = this.b;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (mn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.x;
        }
        return (VoiceManager) invokeV.objValue;
    }

    public final void W1(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, customResponsedMessage) == null) && customResponsedMessage != null && (vs8Var = this.k) != null && vs8Var.getThreadInfo() != null && this.k.getThreadInfo().forum.forum_id != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == this.k.getThreadInfo().forum.forum_id.longValue()) {
                this.c.f(z);
            }
        }
    }

    public final void X1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            ve5 ve5Var = new ve5();
            ve5Var.r(V1());
            te5 te5Var = (te5) ve5Var.a(getActivity());
            this.p = te5Var;
            te5Var.W(getPageContext());
            this.p.f0(this.C);
            this.p.g0(this.A);
            this.p.b().E(true);
            this.p.A(getPageContext(), bundle);
            a2(this.p);
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.e = navigationBar;
            if (navigationBar == null) {
                return;
            }
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            this.e.setTitleText(R.string.chosen_pb_title);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01ee, (ViewGroup) null);
            this.i = inflate;
            this.h = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0906d4);
            this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.i, new h(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public pl5 getPageStayDurationItem() {
        InterceptResult invokeV;
        vs8 vs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            pl5 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (vs8Var = this.k) != null && vs8Var.getThreadInfo() != null && this.k.getThreadInfo().forum != null) {
                pageStayDurationItem.t(this.k.getThreadInfo().forum.forum_id.longValue());
                pageStayDurationItem.C(this.k.getThreadInfo().thread_id.longValue());
            }
            return pageStayDurationItem;
        }
        return (pl5) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || getIntent() == null) {
            return;
        }
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
        long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
        if (this.n == null) {
            this.n = new ws8();
        }
        this.n.c(this, longExtra, longExtra2, longExtra3);
        hideNetRefreshView(this.a);
        showLoadingView(this.a, true);
    }

    public final void b2(vs8 vs8Var) {
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vs8Var) == null) {
            hideLoadingView(this.a);
            if (vs8Var != null && !vs8Var.isEmpty()) {
                this.t = true;
                this.g.e(true);
                this.k = vs8Var;
                UserInfo userInfo = vs8Var.getUserInfo();
                if (userInfo != null) {
                    this.c.update(userInfo);
                }
                at8 at8Var = this.f;
                if (at8Var != null) {
                    at8Var.d(vs8Var.getPostList(), vs8Var.getUserList());
                }
                ExcellentPbThreadInfo threadInfo = vs8Var.getThreadInfo();
                if (threadInfo != null) {
                    if (this.h != null && (l2 = threadInfo.post_num) != null) {
                        String numFormatOver10000 = StringHelper.numFormatOver10000(l2.longValue());
                        this.h.setText(getResources().getString(R.string.obfuscated_res_0x7f0f0406, numFormatOver10000));
                        this.g.c(getResources().getString(R.string.obfuscated_res_0x7f0f0405, numFormatOver10000));
                    }
                    this.d.update(threadInfo);
                    this.c.j(getPageContext().getPageActivity(), threadInfo);
                    uz8 uz8Var = new uz8();
                    uz8Var.c(getPageContext(), vs8Var.getThreadInfo().content);
                    this.j.d(uz8Var.a());
                    this.j.notifyDataSetChanged();
                }
                this.b.setVisibility(0);
                return;
            }
            showNetRefreshView(this.a, getResources().getString(R.string.obfuscated_res_0x7f0f05ec), true);
            setNetRefreshLayoutMarginTop(false);
            this.g.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIIL(1048586, this, i2, i3, intent) != null) || i3 != -1) {
            return;
        }
        te5 te5Var = this.p;
        if (te5Var != null) {
            te5Var.C(i2, i3, intent);
        }
        if (i2 == 23007) {
            long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
            String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
            String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
            ss8.d(this, this.k, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.r);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            iv4 layoutMode = getPageContext().getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            getPageContext().getLayoutMode().k(this.c.c());
            getPageContext().getLayoutMode().k(this.d.h());
            this.f.c();
            this.g.a();
            NavigationBar navigationBar = this.e;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
            te5 te5Var = this.p;
            if (te5Var != null && te5Var.b() != null) {
                this.p.b().y(i2);
            }
            SkinManager.setNavbarTitleColor(this.h, R.color.navi_op_text, R.color.navi_op_text_skin);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
            this.j.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(true);
            setContentView(R.layout.obfuscated_res_0x7f0d01ea);
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906d7);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f0906cf);
            this.b = bdListView;
            bdListView.setOnTouchListener(new f(this));
            this.b.setOnScrollListener(this.z);
            ys8 ys8Var = new ys8(getPageContext().getPageActivity());
            this.j = ys8Var;
            this.b.setAdapter((ListAdapter) ys8Var);
            dt8 dt8Var = new dt8(findViewById(R.id.obfuscated_res_0x7f0906d2));
            this.g = dt8Var;
            dt8Var.b(this.B);
            this.g.d(this.E);
            this.c = new bt8(getPageContext().getPageActivity());
            this.d = new ct8(getPageContext().getPageActivity());
            this.f = new at8(getPageContext().getPageActivity(), this.D);
            this.c.g(this.I);
            this.d.i(this.H);
            this.b.addHeaderView(this.c.c());
            BdListViewHelper.d(getActivity(), this.b, BdListViewHelper.HeadType.DEFAULT);
            this.b.addFooterView(this.d.h());
            this.b.addFooterView(this.f.b());
            Y1();
            registerListener(this.L);
            registerListener(this.K);
            this.M.setSelfListener(true);
            registerListener(this.M);
            registerListener(this.J);
            registerListener(this.F);
            registerListener(this.G);
            Z1();
            if (getIntent() == null) {
                return;
            }
            this.r = getIntent().getStringExtra("share_url");
            this.w = getIntent().getIntExtra("from", 1);
            this.v = SystemClock.elapsedRealtime();
            if (this.w == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            q45.m().w("key_enter_recommend_pb", true);
            VoiceManager voiceManager = new VoiceManager();
            this.x = voiceManager;
            voiceManager.onCreate(getPageContext());
            X1(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        te5 te5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (te5Var = this.p) != null && te5Var.b() != null && this.p.b().w()) {
                this.p.b().s();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onStop();
            vs8 vs8Var = this.k;
            if (vs8Var != null && vs8Var.getThreadInfo() != null && this.k.getThreadInfo().excid != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.v;
                Activity pageActivity = getPageContext().getPageActivity();
                TiebaStatic.eventStat(pageActivity, "pb_new_duration", null, 1, "duration", elapsedRealtime + "", PbChosenActivityConfig.KEY_TID, this.k.getThreadInfo().excid);
            }
            VoiceManager voiceManager = this.x;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }
}
