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
import c.a.o0.t.c.k0;
import c.a.p0.i2.g.d.c;
import c.a.p0.i2.g.d.d;
import c.a.p0.i2.g.d.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
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
import com.baidu.tieba.pb.chosen.cache.ReadChosenPbCacheResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes7.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHOSEN_PB_TABLE_NAME = "chosen_pb_page_cache";
    public static final String FROM_CHOSEN_PB = "from_chosen_pb";
    public static final String FROM_FRS = "from_frs";
    public static final String ST_TYPE = "pb_chosen";
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.i2.g.d.a adapter;
    public CustomMessageListener attentionListener;
    public LikeModel attentionModel;
    public CustomMessageListener cacheReadListener;
    public c.a.p0.i2.g.c.a chosenData;
    public c.a commentCallback;
    public c.a.p0.i2.g.d.c commentView;
    public c.a.p0.i2.g.a dialog;
    public int from;
    public boolean hasData;
    public boolean isDataLoaded;
    public boolean isShowLoading;
    public BdListView listView;
    public DataModel<PbChosenActivity> mDataModel;
    public c.a.o0.x.w.e mEditor;
    public final NewWriteModel.g mOnPostWriteCallback;
    public c.a.o0.x.w.c mPrePostCallBack;
    public final AbsListView.OnScrollListener mScrollListener;
    public VoiceManager mVoiceManager;
    public NavigationBar navigationBar;
    public c.a.e.c.g.a netListener;
    public c.a.p0.i2.g.c.b pbModel;
    public CustomMessageListener pbNativeZanListener;
    public d.e personInfoCallback;
    public c.a.p0.i2.g.d.d personInfoView;
    public e.c postCallback;
    public c.a.p0.i2.g.d.e postInfoView;
    public int praiseData;
    public View.OnClickListener replyClickListener;
    public View replyNumberRoot;
    public TextView replyNumberView;
    public c.a.p0.i2.g.d.f replyView;
    public RelativeLayout rootView;
    public View.OnClickListener shareListener;
    public String shareUrl;
    public long startTime;
    public CustomMessageListener unAttentionListener;
    public c.a.e.c.g.a zanListener;
    public c.a.p0.i2.g.c.c.a zanModel;

    /* loaded from: classes7.dex */
    public class a implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54583a;

        /* renamed from: com.baidu.tieba.pb.chosen.PbChosenActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C1782a extends c.a.e.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f54584a;

            public C1782a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54584a = aVar;
            }

            @Override // c.a.e.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.f54584a.f54583a.attentionModel.getErrorCode(), this.f54584a.f54583a.attentionModel.getErrorString())) {
                    AntiHelper.u(this.f54584a.f54583a.getActivity(), this.f54584a.f54583a.attentionModel.getErrorString());
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54583a = pbChosenActivity;
        }

        @Override // c.a.p0.i2.g.d.d.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f54583a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f54583a.getPageContext().getPageActivity()).createNormalCfg(str, PbChosenActivity.FROM_CHOSEN_PB)));
            if (this.f54583a.chosenData == null || this.f54583a.chosenData.getThreadInfo() == null || this.f54583a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_sourcefid").param("obj_source", this.f54583a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54583a.chosenData.getThreadInfo().abtest));
        }

        @Override // c.a.p0.i2.g.d.d.e
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.f54583a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f54583a.getPageContext().getPageActivity(), str, str2)));
            }
        }

        @Override // c.a.p0.i2.g.d.d.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!c.a.e.e.p.j.z()) {
                    BdToast.c(this.f54583a.getPageContext().getPageActivity(), this.f54583a.getResources().getString(R.string.neterror)).q();
                } else if (!this.f54583a.checkUpIsLogin() || this.f54583a.chosenData == null || this.f54583a.chosenData.getThreadInfo() == null || this.f54583a.chosenData.getThreadInfo().forum.forum_id == null) {
                } else {
                    if (this.f54583a.attentionModel == null) {
                        PbChosenActivity pbChosenActivity = this.f54583a;
                        pbChosenActivity.attentionModel = new LikeModel(pbChosenActivity.getPageContext());
                    }
                    this.f54583a.attentionModel.setFrom("from_frs");
                    this.f54583a.attentionModel.setLoadDataCallBack(new C1782a(this));
                    this.f54583a.attentionModel.L(this.f54583a.chosenData.getThreadInfo().forum.forum_name, String.valueOf(this.f54583a.chosenData.getThreadInfo().forum.forum_id));
                    if (this.f54583a.chosenData == null || this.f54583a.chosenData.getThreadInfo() == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10322");
                    StatisticItem param = statisticItem.param("fid", this.f54583a.chosenData.getThreadInfo().forum.forum_id + "");
                    TiebaStatic.log(param.param("tid", this.f54583a.chosenData.getThreadInfo().thread_id + "").param("obj_source", this.f54583a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54583a.chosenData.getThreadInfo().abtest));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54585a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbChosenActivity pbChosenActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54585a = pbChosenActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof c.a.p0.i2.g.c.a)) {
                c.a.p0.i2.g.c.a aVar = (c.a.p0.i2.g.c.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                this.f54585a.isDataLoaded = true;
                if (erroCode == 0) {
                    this.f54585a.updateViews(aVar);
                } else {
                    PbChosenActivity pbChosenActivity = this.f54585a;
                    pbChosenActivity.hideLoadingView(pbChosenActivity.rootView);
                    this.f54585a.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.f54585a.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (this.f54585a.hasData) {
                    return;
                }
                String string = this.f54585a.getResources().getString(R.string.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.f54585a;
                pbChosenActivity2.showNetRefreshView(pbChosenActivity2.rootView, string, true);
                this.f54585a.setNetRefreshLayoutMarginTop(false);
                this.f54585a.replyView.e(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54586a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbChosenActivity pbChosenActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2)};
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
            this.f54586a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54586a.postInfoView.n();
                this.f54586a.postInfoView.f18703h = !this.f54586a.postInfoView.f18703h;
                this.f54586a.postInfoView.m(this.f54586a.postInfoView.f18703h);
                if (this.f54586a.postInfoView.f18703h) {
                    this.f54586a.praiseData = 1;
                } else {
                    this.f54586a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54587a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbChosenActivity pbChosenActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54587a = pbChosenActivity;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f54587a.postInfoView.n();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.f54587a.getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.c(this.f54587a.getPageContext().getPageActivity(), errorString).q();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                this.f54587a.postInfoView.m(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.f54587a.praiseData = 1;
                } else {
                    this.f54587a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54588a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbChosenActivity pbChosenActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2)};
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
            this.f54588a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ReadChosenPbCacheResponse) && this.f54588a.getIntent() != null) {
                long longExtra = this.f54588a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = this.f54588a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = this.f54588a.getIntent().getLongExtra("thread_id", 0L);
                c.a.p0.i2.g.c.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    this.f54588a.isDataLoaded = true;
                    this.f54588a.updateViews(chosenData);
                }
                if (this.f54588a.pbModel == null) {
                    this.f54588a.pbModel = new c.a.p0.i2.g.c.b();
                }
                this.f54588a.pbModel.c(this.f54588a, longExtra, longExtra2, longExtra3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54589e;

        public f(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54589e = pbChosenActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                c.a.e.e.p.l.x(this.f54589e.getActivity(), this.f54589e.getCurrentFocus());
                if (this.f54589e.mEditor != null && this.f54589e.mEditor.a() != null) {
                    this.f54589e.mEditor.a().hide();
                }
                this.f54589e.replyView.e(true);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54590e;

        public g(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54590e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54590e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54591e;

        public h(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54591e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54591e.chosenData == null || this.f54591e.chosenData.getThreadInfo() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c10091");
            TiebaStatic.log(statisticItem.param("tid", this.f54591e.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.f54591e.chosenData.getThreadInfo().tag_name).param("obj_source", this.f54591e.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54591e.chosenData.getThreadInfo().abtest));
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f54591e.getPageContext().getPageActivity());
            this.f54591e.sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPbChosen(this.f54591e.chosenData.getThreadInfo().thread_id + "", this.f54591e.praiseData)));
        }
    }

    /* loaded from: classes7.dex */
    public class i extends DataModel<PbChosenActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54592e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbChosenActivity pbChosenActivity, c.a.e.a.f fVar) {
            super(fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c.a.e.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54592e = pbChosenActivity;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData C(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (this.f54592e.chosenData == null || this.f54592e.chosenData.getThreadInfo() == null) {
                    return null;
                }
                WriteData writeData = new WriteData();
                writeData.setForumId(String.valueOf(this.f54592e.chosenData.getThreadInfo().forum.forum_id));
                writeData.setForumName(this.f54592e.chosenData.getThreadInfo().forum.forum_name);
                writeData.setThreadId(String.valueOf(this.f54592e.chosenData.getThreadInfo().thread_id));
                writeData.setIsAd(false);
                writeData.setType(1);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean G() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean LoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54593e;

        public j(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54593e = pbChosenActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 == 0 || this.f54593e.mEditor == null || this.f54593e.mEditor.a() == null) {
                return;
            }
            this.f54593e.mEditor.a().hide();
            this.f54593e.replyView.e(true);
        }
    }

    /* loaded from: classes7.dex */
    public class k implements c.a.o0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54594a;

        public k(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54594a = pbChosenActivity;
        }

        @Override // c.a.o0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54594a.showProgressBar();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54595e;

        public l(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54595e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.f54595e.checkUpIsLogin() || this.f54595e.mEditor == null || this.f54595e.mEditor.a() == null) {
                return;
            }
            this.f54595e.mEditor.a().display();
            this.f54595e.replyView.e(false);
        }
    }

    /* loaded from: classes7.dex */
    public class m implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54596a;

        public m(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54596a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                this.f54596a.hideProgressBar();
                if (z) {
                    this.f54596a.mEditor.a().hide();
                    this.f54596a.replyView.e(true);
                    if (postWriteCallBackData != null) {
                        c.a.p0.i3.q0.m.b(this.f54596a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                } else if (postWriteCallBackData == null || k0Var != null || postWriteCallBackData.getErrorCode() == 227001 || c.a.p0.s3.a.c(postWriteCallBackData.getErrorCode())) {
                } else {
                    if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                        AntiHelper.u(this.f54596a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                    } else {
                        BdToast.c(this.f54596a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).q();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54597a;

        public n(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54597a = pbChosenActivity;
        }

        @Override // c.a.p0.i2.g.d.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || !this.f54597a.checkUpIsLogin() || this.f54597a.chosenData == null || this.f54597a.chosenData.getThreadInfo() == null || StringUtils.isNull(str)) {
                return;
            }
            if (this.f54597a.chosenData != null && this.f54597a.chosenData.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10093");
                TiebaStatic.log(statisticItem.param("tid", this.f54597a.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.f54597a.chosenData.getThreadInfo().tag_name).param("obj_source", this.f54597a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54597a.chosenData.getThreadInfo().abtest));
            }
            this.f54597a.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.f54597a.getPageContext().getPageActivity()).createSubPbActivityConfig(this.f54597a.chosenData.getThreadInfo().thread_id + "", str, PbChosenActivity.ST_TYPE, true, null, true)));
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54598e;

        public o(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54598e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54598e.chosenData != null && this.f54598e.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new StatisticItem("pb_new_share").param("obj_source", this.f54598e.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54598e.chosenData.getThreadInfo().abtest));
                }
                if (this.f54598e.checkUpIsLogin()) {
                    if (this.f54598e.from == 2) {
                        TiebaStatic.log("c10148");
                    }
                    if (this.f54598e.dialog == null) {
                        PbChosenActivity pbChosenActivity = this.f54598e;
                        pbChosenActivity.dialog = new c.a.p0.i2.g.a(pbChosenActivity);
                    }
                    this.f54598e.dialog.f(this.f54598e.chosenData, this.f54598e.shareUrl);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54599a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(PbChosenActivity pbChosenActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2)};
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
            this.f54599a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54599a.handleAttentionResponse(true, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54600a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(PbChosenActivity pbChosenActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, Integer.valueOf(i2)};
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
            this.f54600a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f54600a.handleAttentionResponse(false, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f54601a;

        public r(PbChosenActivity pbChosenActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54601a = pbChosenActivity;
        }

        @Override // c.a.p0.i2.g.d.e.c
        public void a(long j2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j2, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f54601a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f54601a.getPageContext().getPageActivity()).createCfgForPbChosen(str, this.f54601a.praiseData)));
            if (this.f54601a.chosenData == null || this.f54601a.chosenData.getThreadInfo() == null || this.f54601a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_detail_btn").param("obj_source", this.f54601a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54601a.chosenData.getThreadInfo().abtest));
        }

        @Override // c.a.p0.i2.g.d.e.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f54601a.chosenData == null || this.f54601a.chosenData.getThreadInfo() == null || this.f54601a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            if (this.f54601a.zanModel == null) {
                this.f54601a.zanModel = new c.a.p0.i2.g.c.c.a();
            }
            if (z) {
                c.a.p0.i2.g.c.c.a aVar = this.f54601a.zanModel;
                PbChosenActivity pbChosenActivity = this.f54601a;
                aVar.c(pbChosenActivity, pbChosenActivity.chosenData.getThreadInfo().excid.longValue(), this.f54601a.chosenData.getThreadInfo().thread_id.longValue(), this.f54601a.chosenData.getThreadInfo().post_id.longValue(), 2);
            } else {
                c.a.p0.i2.g.c.c.a aVar2 = this.f54601a.zanModel;
                PbChosenActivity pbChosenActivity2 = this.f54601a;
                aVar2.c(pbChosenActivity2, pbChosenActivity2.chosenData.getThreadInfo().excid.longValue(), this.f54601a.chosenData.getThreadInfo().thread_id.longValue(), this.f54601a.chosenData.getThreadInfo().post_id.longValue(), 1);
            }
            TiebaStatic.log(new StatisticItem("pb_new_like").param("obj_source", this.f54601a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f54601a.chosenData.getThreadInfo().abtest));
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
        this.shareUrl = null;
        this.hasData = false;
        this.isDataLoaded = false;
        this.from = 1;
        this.praiseData = -1;
        this.mScrollListener = new j(this);
        this.mPrePostCallBack = new k(this);
        this.replyClickListener = new l(this);
        this.mOnPostWriteCallback = new m(this);
        this.commentCallback = new n(this);
        this.shareListener = new o(this);
        this.attentionListener = new p(this, 2001335);
        this.unAttentionListener = new q(this, 2001336);
        this.postCallback = new r(this);
        this.personInfoCallback = new a(this);
        this.netListener = new b(this, CmdConfigHttp.CMD_GET_FINE_PB, 309093);
        this.pbNativeZanListener = new c(this, 2004004);
        this.zanListener = new d(this, CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
        this.cacheReadListener = new e(this, 2001314);
    }

    private DataModel<PbChosenActivity> getPbEditorModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            if (this.mDataModel == null) {
                this.mDataModel = new i(this, getPageContext());
            }
            return this.mDataModel;
        }
        return (DataModel) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAttentionResponse(boolean z, CustomResponsedMessage<?> customResponsedMessage) {
        c.a.p0.i2.g.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65560, this, z, customResponsedMessage) == null) || customResponsedMessage == null || (aVar = this.chosenData) == null || aVar.getThreadInfo() == null || this.chosenData.getThreadInfo().forum.forum_id == null) {
            return;
        }
        Object data = customResponsedMessage.getData();
        if ((data instanceof Long) && ((Long) data).longValue() == this.chosenData.getThreadInfo().forum.forum_id.longValue()) {
            this.personInfoView.f(z);
        }
    }

    private void initEditor(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, this, bundle) == null) {
            c.a.o0.x.w.g gVar = new c.a.o0.x.w.g();
            gVar.q(getPbEditorModel());
            c.a.o0.x.w.e eVar = (c.a.o0.x.w.e) gVar.a(getActivity());
            this.mEditor = eVar;
            eVar.f0(getPageContext());
            this.mEditor.o0(this.mOnPostWriteCallback);
            this.mEditor.p0(this.mPrePostCallBack);
            this.mEditor.a().showLinePositionBottom(true);
            this.mEditor.G(getPageContext(), bundle);
            setEditor(this.mEditor);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.navigationBar = navigationBar;
            if (navigationBar == null) {
                return;
            }
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            this.navigationBar.setTitleText(R.string.chosen_pb_title);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.chosen_pb_reply_layout, (ViewGroup) null);
            this.replyNumberRoot = inflate;
            this.replyNumberView = (TextView) inflate.findViewById(R.id.chosen_pb_reply_number);
            this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.replyNumberRoot, new h(this));
        }
    }

    private void sendReadCacheMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new c.a.p0.i2.g.b.b());
            CustomMessage customMessage = new CustomMessage(2001314);
            customMessage.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
        }
    }

    private void setEditor(c.a.o0.x.w.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, eVar) == null) || eVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.rootView.addView(eVar.a(), layoutParams);
        eVar.a().hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViews(c.a.p0.i2.g.c.a aVar) {
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, aVar) == null) {
            hideLoadingView(this.rootView);
            if (aVar != null && !aVar.isEmpty()) {
                this.hasData = true;
                this.replyView.e(true);
                this.chosenData = aVar;
                UserInfo userInfo = aVar.getUserInfo();
                if (userInfo != null) {
                    this.personInfoView.j(userInfo);
                }
                c.a.p0.i2.g.d.c cVar = this.commentView;
                if (cVar != null) {
                    cVar.d(getPageContext().getPageActivity(), aVar.getPostList(), aVar.getUserList());
                }
                ExcellentPbThreadInfo threadInfo = aVar.getThreadInfo();
                if (threadInfo != null) {
                    if (this.replyNumberView != null && (l2 = threadInfo.post_num) != null) {
                        String numFormatOver10000 = StringHelper.numFormatOver10000(l2.longValue());
                        this.replyNumberView.setText(getResources().getString(R.string.chosen_pb_reply_number_text, numFormatOver10000));
                        this.replyView.c(getResources().getString(R.string.chosen_pb_reply_count_text, numFormatOver10000));
                    }
                    this.postInfoView.o(threadInfo);
                    this.personInfoView.k(getPageContext().getPageActivity(), threadInfo);
                    c.a.p0.i2.l.a aVar2 = new c.a.p0.i2.l.a();
                    aVar2.c(getPageContext(), aVar.getThreadInfo().content);
                    this.adapter.d(aVar2.a());
                    this.adapter.notifyDataSetChanged();
                }
                this.listView.setVisibility(0);
                return;
            }
            showNetRefreshView(this.rootView, getResources().getString(R.string.error_unkown_try_again), true);
            setNetRefreshLayoutMarginTop(false);
            this.replyView.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a013" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public c.a.o0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        c.a.p0.i2.g.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c.a.o0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (aVar = this.chosenData) != null && aVar.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
                pageStayDurationItem.r(this.chosenData.getThreadInfo().forum.forum_id.longValue());
                pageStayDurationItem.A(this.chosenData.getThreadInfo().thread_id.longValue());
            }
            return pageStayDurationItem;
        }
        return (c.a.o0.m0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceData$VoiceModel)) == null) {
            return null;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) && i3 == -1) {
            c.a.o0.x.w.e eVar = this.mEditor;
            if (eVar != null) {
                eVar.I(i2, i3, intent);
            }
            if (i2 == 23003) {
                c.a.p0.i2.g.a.d(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
            } else if (i2 != 23007) {
            } else {
                long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
                String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
                String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
                c.a.p0.i2.g.a.e(this, this.chosenData, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.shareUrl);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            getPageContext().getLayoutMode().k(i2 == 1);
            getPageContext().getLayoutMode().j(this.personInfoView.c());
            getPageContext().getLayoutMode().j(this.postInfoView.h());
            this.commentView.c();
            this.replyView.a();
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(getPageContext(), i2);
            }
            c.a.o0.x.w.e eVar = this.mEditor;
            if (eVar != null && eVar.a() != null) {
                this.mEditor.a().onChangeSkinType(i2);
            }
            SkinManager.setNavbarTitleColor(this.replyNumberView, R.color.navi_op_text, R.color.navi_op_text_skin);
            SkinManager.setBackgroundColor(this.rootView, R.color.CAM_X0201);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(true);
            setContentView(R.layout.chosen_pb_layout);
            this.rootView = (RelativeLayout) findViewById(R.id.chosen_pb_root);
            BdListView bdListView = (BdListView) findViewById(R.id.chosen_pb_listview);
            this.listView = bdListView;
            bdListView.setOnTouchListener(new f(this));
            this.listView.setOnScrollListener(this.mScrollListener);
            c.a.p0.i2.g.d.a aVar = new c.a.p0.i2.g.d.a(getPageContext().getPageActivity());
            this.adapter = aVar;
            this.listView.setAdapter((ListAdapter) aVar);
            c.a.p0.i2.g.d.f fVar = new c.a.p0.i2.g.d.f(findViewById(R.id.chosen_pb_reply));
            this.replyView = fVar;
            fVar.b(this.replyClickListener);
            this.replyView.d(this.shareListener);
            this.personInfoView = new c.a.p0.i2.g.d.d(getPageContext().getPageActivity());
            this.postInfoView = new c.a.p0.i2.g.d.e(getPageContext().getPageActivity());
            this.commentView = new c.a.p0.i2.g.d.c(getPageContext().getPageActivity(), this.commentCallback);
            this.personInfoView.g(this.personInfoCallback);
            this.postInfoView.i(this.postCallback);
            this.listView.addHeaderView(this.personInfoView.c());
            BdListViewHelper.d(getActivity(), this.listView, BdListViewHelper.HeadType.DEFAULT);
            this.listView.addFooterView(this.postInfoView.h());
            this.listView.addFooterView(this.commentView.b());
            initNavigationBar();
            registerListener(this.zanListener);
            registerListener(this.pbNativeZanListener);
            this.cacheReadListener.setSelfListener(true);
            registerListener(this.cacheReadListener);
            registerListener(this.netListener);
            registerListener(this.attentionListener);
            registerListener(this.unAttentionListener);
            sendReadCacheMessage();
            if (getIntent() == null) {
                return;
            }
            this.shareUrl = getIntent().getStringExtra(PbChosenActivityConfig.KEY_SHARE_URL);
            this.from = getIntent().getIntExtra("from", 1);
            this.startTime = SystemClock.elapsedRealtime();
            if (this.from == 2) {
                TiebaStatic.eventStat(getActivity(), "kantie_7", null, 1, new Object[0]);
            }
            c.a.o0.s.d0.b.j().t("key_enter_recommend_pb", true);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            initEditor(bundle);
            adjustResizeForSoftInput();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            c.a.o0.x.w.e eVar = this.mEditor;
            if (eVar != null) {
                eVar.J();
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public c.a.e.k.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.listView;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (c.a.e.k.e.q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        c.a.o0.x.w.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (eVar = this.mEditor) != null && eVar.a() != null && this.mEditor.a().isToolVisible()) {
                this.mEditor.a().hideTools();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || getIntent() == null) {
            return;
        }
        long longExtra = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
        long longExtra2 = getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
        long longExtra3 = getIntent().getLongExtra("thread_id", 0L);
        if (this.pbModel == null) {
            this.pbModel = new c.a.p0.i2.g.c.b();
        }
        this.pbModel.c(this, longExtra, longExtra2, longExtra3);
        hideNetRefreshView(this.rootView);
        showLoadingView(this.rootView, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            c.a.o0.x.w.e eVar = this.mEditor;
            if (eVar != null) {
                eVar.L(bundle);
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onSaveInstanceState(getPageContext().getPageActivity());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onStop();
            c.a.p0.i2.g.c.a aVar = this.chosenData;
            if (aVar != null && aVar.getThreadInfo() != null && this.chosenData.getThreadInfo().excid != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.startTime;
                Activity pageActivity = getPageContext().getPageActivity();
                TiebaStatic.eventStat(pageActivity, "pb_new_duration", null, 1, "duration", elapsedRealtime + "", PbChosenActivityConfig.KEY_TID, this.chosenData.getThreadInfo().excid);
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            super.onWindowFocusChanged(z);
            if (!z || this.isShowLoading || this.isDataLoaded) {
                return;
            }
            this.isShowLoading = true;
            showLoadingView(this.rootView, true);
        }
    }
}
