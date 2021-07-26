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
import d.a.p0.t.c.k0;
import d.a.q0.h2.g.d.c;
import d.a.q0.h2.g.d.d;
import d.a.q0.h2.g.d.e;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes4.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHOSEN_PB_TABLE_NAME = "chosen_pb_page_cache";
    public static final String FROM_CHOSEN_PB = "from_chosen_pb";
    public static final String FROM_FRS = "from_frs";
    public static final String ST_TYPE = "pb_chosen";
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.q0.h2.g.d.a adapter;
    public CustomMessageListener attentionListener;
    public LikeModel attentionModel;
    public CustomMessageListener cacheReadListener;
    public d.a.q0.h2.g.c.a chosenData;
    public c.a commentCallback;
    public d.a.q0.h2.g.d.c commentView;
    public d.a.q0.h2.g.a dialog;
    public int from;
    public boolean hasData;
    public boolean isDataLoaded;
    public boolean isShowLoading;
    public BdListView listView;
    public DataModel<PbChosenActivity> mDataModel;
    public d.a.p0.x.w.e mEditor;
    public final NewWriteModel.g mOnPostWriteCallback;
    public d.a.p0.x.w.c mPrePostCallBack;
    public final AbsListView.OnScrollListener mScrollListener;
    public VoiceManager mVoiceManager;
    public NavigationBar navigationBar;
    public d.a.d.c.g.a netListener;
    public d.a.q0.h2.g.c.b pbModel;
    public CustomMessageListener pbNativeZanListener;
    public d.e personInfoCallback;
    public d.a.q0.h2.g.d.d personInfoView;
    public e.c postCallback;
    public d.a.q0.h2.g.d.e postInfoView;
    public int praiseData;
    public View.OnClickListener replyClickListener;
    public View replyNumberRoot;
    public TextView replyNumberView;
    public d.a.q0.h2.g.d.f replyView;
    public RelativeLayout rootView;
    public View.OnClickListener shareListener;
    public String shareUrl;
    public long startTime;
    public CustomMessageListener unAttentionListener;
    public d.a.d.c.g.a zanListener;
    public d.a.q0.h2.g.c.c.a zanModel;

    /* loaded from: classes4.dex */
    public class a implements d.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19218a;

        /* renamed from: com.baidu.tieba.pb.chosen.PbChosenActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0229a extends d.a.d.a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f19219a;

            public C0229a(a aVar) {
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
                this.f19219a = aVar;
            }

            @Override // d.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.f19219a.f19218a.attentionModel.getErrorCode(), this.f19219a.f19218a.attentionModel.getErrorString())) {
                    AntiHelper.u(this.f19219a.f19218a.getActivity(), this.f19219a.f19218a.attentionModel.getErrorString());
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
            this.f19218a = pbChosenActivity;
        }

        @Override // d.a.q0.h2.g.d.d.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f19218a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f19218a.getPageContext().getPageActivity()).createNormalCfg(str, PbChosenActivity.FROM_CHOSEN_PB)));
            if (this.f19218a.chosenData == null || this.f19218a.chosenData.getThreadInfo() == null || this.f19218a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_sourcefid").param("obj_source", this.f19218a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19218a.chosenData.getThreadInfo().abtest));
        }

        @Override // d.a.q0.h2.g.d.d.e
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.f19218a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f19218a.getPageContext().getPageActivity(), str, str2)));
            }
        }

        @Override // d.a.q0.h2.g.d.d.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!d.a.d.e.p.j.z()) {
                    BdToast.c(this.f19218a.getPageContext().getPageActivity(), this.f19218a.getResources().getString(R.string.neterror)).q();
                } else if (!this.f19218a.checkUpIsLogin() || this.f19218a.chosenData == null || this.f19218a.chosenData.getThreadInfo() == null || this.f19218a.chosenData.getThreadInfo().forum.forum_id == null) {
                } else {
                    if (this.f19218a.attentionModel == null) {
                        PbChosenActivity pbChosenActivity = this.f19218a;
                        pbChosenActivity.attentionModel = new LikeModel(pbChosenActivity.getPageContext());
                    }
                    this.f19218a.attentionModel.setFrom("from_frs");
                    this.f19218a.attentionModel.setLoadDataCallBack(new C0229a(this));
                    this.f19218a.attentionModel.L(this.f19218a.chosenData.getThreadInfo().forum.forum_name, String.valueOf(this.f19218a.chosenData.getThreadInfo().forum.forum_id));
                    if (this.f19218a.chosenData == null || this.f19218a.chosenData.getThreadInfo() == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10322");
                    StatisticItem param = statisticItem.param("fid", this.f19218a.chosenData.getThreadInfo().forum.forum_id + "");
                    TiebaStatic.log(param.param("tid", this.f19218a.chosenData.getThreadInfo().thread_id + "").param("obj_source", this.f19218a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19218a.chosenData.getThreadInfo().abtest));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19220a;

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
            this.f19220a = pbChosenActivity;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof d.a.q0.h2.g.c.a)) {
                d.a.q0.h2.g.c.a aVar = (d.a.q0.h2.g.c.a) responsedMessage;
                int erroCode = aVar.getErroCode();
                this.f19220a.isDataLoaded = true;
                if (erroCode == 0) {
                    this.f19220a.updateViews(aVar);
                } else {
                    PbChosenActivity pbChosenActivity = this.f19220a;
                    pbChosenActivity.hideLoadingView(pbChosenActivity.rootView);
                    this.f19220a.showToast(StringUtils.isNull(aVar.getErrorText()) ? this.f19220a.getResources().getString(R.string.neterror) : aVar.getErrorText());
                }
                if (this.f19220a.hasData) {
                    return;
                }
                String string = this.f19220a.getResources().getString(R.string.error_unkown_try_again);
                PbChosenActivity pbChosenActivity2 = this.f19220a;
                pbChosenActivity2.showNetRefreshView(pbChosenActivity2.rootView, string, true);
                this.f19220a.setNetRefreshLayoutMarginTop(false);
                this.f19220a.replyView.e(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19221a;

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
            this.f19221a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19221a.postInfoView.n();
                this.f19221a.postInfoView.f57412h = !this.f19221a.postInfoView.f57412h;
                this.f19221a.postInfoView.m(this.f19221a.postInfoView.f57412h);
                if (this.f19221a.postInfoView.f57412h) {
                    this.f19221a.praiseData = 1;
                } else {
                    this.f19221a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19222a;

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
            this.f19222a = pbChosenActivity;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.f19222a.postInfoView.n();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.f19222a.getResources().getString(R.string.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.c(this.f19222a.getPageContext().getPageActivity(), errorString).q();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                this.f19222a.postInfoView.m(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.f19222a.praiseData = 1;
                } else {
                    this.f19222a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19223a;

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
            this.f19223a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ReadChosenPbCacheResponse) && this.f19223a.getIntent() != null) {
                long longExtra = this.f19223a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = this.f19223a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = this.f19223a.getIntent().getLongExtra("thread_id", 0L);
                d.a.q0.h2.g.c.a chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    this.f19223a.isDataLoaded = true;
                    this.f19223a.updateViews(chosenData);
                }
                if (this.f19223a.pbModel == null) {
                    this.f19223a.pbModel = new d.a.q0.h2.g.c.b();
                }
                this.f19223a.pbModel.c(this.f19223a, longExtra, longExtra2, longExtra3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19224e;

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
            this.f19224e = pbChosenActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                d.a.d.e.p.l.x(this.f19224e.getActivity(), this.f19224e.getCurrentFocus());
                if (this.f19224e.mEditor != null && this.f19224e.mEditor.a() != null) {
                    this.f19224e.mEditor.a().o();
                }
                this.f19224e.replyView.e(true);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19225e;

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
            this.f19225e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19225e.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19226e;

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
            this.f19226e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19226e.chosenData == null || this.f19226e.chosenData.getThreadInfo() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c10091");
            TiebaStatic.log(statisticItem.param("tid", this.f19226e.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.f19226e.chosenData.getThreadInfo().tag_name).param("obj_source", this.f19226e.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19226e.chosenData.getThreadInfo().abtest));
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f19226e.getPageContext().getPageActivity());
            this.f19226e.sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPbChosen(this.f19226e.chosenData.getThreadInfo().thread_id + "", this.f19226e.praiseData)));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends DataModel<PbChosenActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19227e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbChosenActivity pbChosenActivity, d.a.d.a.f fVar) {
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
                    super((d.a.d.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19227e = pbChosenActivity;
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
                if (this.f19227e.chosenData == null || this.f19227e.chosenData.getThreadInfo() == null) {
                    return null;
                }
                WriteData writeData = new WriteData();
                writeData.setForumId(String.valueOf(this.f19227e.chosenData.getThreadInfo().forum.forum_id));
                writeData.setForumName(this.f19227e.chosenData.getThreadInfo().forum.forum_name);
                writeData.setThreadId(String.valueOf(this.f19227e.chosenData.getThreadInfo().thread_id));
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

    /* loaded from: classes4.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19228e;

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
            this.f19228e = pbChosenActivity;
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
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) || i2 == 0 || this.f19228e.mEditor == null || this.f19228e.mEditor.a() == null) {
                return;
            }
            this.f19228e.mEditor.a().o();
            this.f19228e.replyView.e(true);
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.a.p0.x.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19229a;

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
            this.f19229a = pbChosenActivity;
        }

        @Override // d.a.p0.x.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19229a.showProgressBar();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19230e;

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
            this.f19230e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || !this.f19230e.checkUpIsLogin() || this.f19230e.mEditor == null || this.f19230e.mEditor.a() == null) {
                return;
            }
            this.f19230e.mEditor.a().j();
            this.f19230e.replyView.e(false);
        }
    }

    /* loaded from: classes4.dex */
    public class m implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19231a;

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
            this.f19231a = pbChosenActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                this.f19231a.hideProgressBar();
                if (z) {
                    this.f19231a.mEditor.a().o();
                    this.f19231a.replyView.e(true);
                    if (postWriteCallBackData != null) {
                        d.a.q0.h3.q0.m.b(this.f19231a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                } else if (postWriteCallBackData == null || k0Var != null || postWriteCallBackData.getErrorCode() == 227001 || d.a.q0.r3.a.c(postWriteCallBackData.getErrorCode())) {
                } else {
                    if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                        AntiHelper.u(this.f19231a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                    } else {
                        BdToast.c(this.f19231a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).q();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19232a;

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
            this.f19232a = pbChosenActivity;
        }

        @Override // d.a.q0.h2.g.d.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || !this.f19232a.checkUpIsLogin() || this.f19232a.chosenData == null || this.f19232a.chosenData.getThreadInfo() == null || StringUtils.isNull(str)) {
                return;
            }
            if (this.f19232a.chosenData != null && this.f19232a.chosenData.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10093");
                TiebaStatic.log(statisticItem.param("tid", this.f19232a.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.f19232a.chosenData.getThreadInfo().tag_name).param("obj_source", this.f19232a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19232a.chosenData.getThreadInfo().abtest));
            }
            this.f19232a.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.f19232a.getPageContext().getPageActivity()).createSubPbActivityConfig(this.f19232a.chosenData.getThreadInfo().thread_id + "", str, PbChosenActivity.ST_TYPE, true, null, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19233e;

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
            this.f19233e = pbChosenActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f19233e.chosenData != null && this.f19233e.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new StatisticItem("pb_new_share").param("obj_source", this.f19233e.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19233e.chosenData.getThreadInfo().abtest));
                }
                if (this.f19233e.checkUpIsLogin()) {
                    if (this.f19233e.from == 2) {
                        TiebaStatic.log("c10148");
                    }
                    if (this.f19233e.dialog == null) {
                        PbChosenActivity pbChosenActivity = this.f19233e;
                        pbChosenActivity.dialog = new d.a.q0.h2.g.a(pbChosenActivity);
                    }
                    this.f19233e.dialog.f(this.f19233e.chosenData, this.f19233e.shareUrl);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19234a;

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
            this.f19234a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19234a.handleAttentionResponse(true, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19235a;

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
            this.f19235a = pbChosenActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f19235a.handleAttentionResponse(false, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbChosenActivity f19236a;

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
            this.f19236a = pbChosenActivity;
        }

        @Override // d.a.q0.h2.g.d.e.c
        public void a(long j, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.f19236a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f19236a.getPageContext().getPageActivity()).createCfgForPbChosen(str, this.f19236a.praiseData)));
            if (this.f19236a.chosenData == null || this.f19236a.chosenData.getThreadInfo() == null || this.f19236a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_detail_btn").param("obj_source", this.f19236a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19236a.chosenData.getThreadInfo().abtest));
        }

        @Override // d.a.q0.h2.g.d.e.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.f19236a.chosenData == null || this.f19236a.chosenData.getThreadInfo() == null || this.f19236a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            if (this.f19236a.zanModel == null) {
                this.f19236a.zanModel = new d.a.q0.h2.g.c.c.a();
            }
            if (z) {
                d.a.q0.h2.g.c.c.a aVar = this.f19236a.zanModel;
                PbChosenActivity pbChosenActivity = this.f19236a;
                aVar.c(pbChosenActivity, pbChosenActivity.chosenData.getThreadInfo().excid.longValue(), this.f19236a.chosenData.getThreadInfo().thread_id.longValue(), this.f19236a.chosenData.getThreadInfo().post_id.longValue(), 2);
            } else {
                d.a.q0.h2.g.c.c.a aVar2 = this.f19236a.zanModel;
                PbChosenActivity pbChosenActivity2 = this.f19236a;
                aVar2.c(pbChosenActivity2, pbChosenActivity2.chosenData.getThreadInfo().excid.longValue(), this.f19236a.chosenData.getThreadInfo().thread_id.longValue(), this.f19236a.chosenData.getThreadInfo().post_id.longValue(), 1);
            }
            TiebaStatic.log(new StatisticItem("pb_new_like").param("obj_source", this.f19236a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.f19236a.chosenData.getThreadInfo().abtest));
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
        d.a.q0.h2.g.c.a aVar;
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
            d.a.p0.x.w.g gVar = new d.a.p0.x.w.g();
            gVar.q(getPbEditorModel());
            d.a.p0.x.w.e eVar = (d.a.p0.x.w.e) gVar.a(getActivity());
            this.mEditor = eVar;
            eVar.f0(getPageContext());
            this.mEditor.o0(this.mOnPostWriteCallback);
            this.mEditor.p0(this.mPrePostCallBack);
            this.mEditor.a().C(true);
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
            CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new d.a.q0.h2.g.b.b());
            CustomMessage customMessage = new CustomMessage(2001314);
            customMessage.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
        }
    }

    private void setEditor(d.a.p0.x.w.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, eVar) == null) || eVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.rootView.addView(eVar.a(), layoutParams);
        eVar.a().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViews(d.a.q0.h2.g.c.a aVar) {
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
                d.a.q0.h2.g.d.c cVar = this.commentView;
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
                    d.a.q0.h2.l.a aVar2 = new d.a.q0.h2.l.a();
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

    @Override // com.baidu.tbadk.BaseActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a013" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.p0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        d.a.q0.h2.g.c.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.a.p0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (aVar = this.chosenData) != null && aVar.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
                pageStayDurationItem.q(this.chosenData.getThreadInfo().forum.forum_id.longValue());
                pageStayDurationItem.y(this.chosenData.getThreadInfo().thread_id.longValue());
            }
            return pageStayDurationItem;
        }
        return (d.a.p0.m0.d) invokeV.objValue;
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
            d.a.p0.x.w.e eVar = this.mEditor;
            if (eVar != null) {
                eVar.I(i2, i3, intent);
            }
            if (i2 == 23003) {
                d.a.q0.h2.g.a.d(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
            } else if (i2 != 23007) {
            } else {
                long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
                String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
                String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
                d.a.q0.h2.g.a.e(this, this.chosenData, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.shareUrl);
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
            d.a.p0.x.w.e eVar = this.mEditor;
            if (eVar != null && eVar.a() != null) {
                this.mEditor.a().w(i2);
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
            d.a.q0.h2.g.d.a aVar = new d.a.q0.h2.g.d.a(getPageContext().getPageActivity());
            this.adapter = aVar;
            this.listView.setAdapter((ListAdapter) aVar);
            d.a.q0.h2.g.d.f fVar = new d.a.q0.h2.g.d.f(findViewById(R.id.chosen_pb_reply));
            this.replyView = fVar;
            fVar.b(this.replyClickListener);
            this.replyView.d(this.shareListener);
            this.personInfoView = new d.a.q0.h2.g.d.d(getPageContext().getPageActivity());
            this.postInfoView = new d.a.q0.h2.g.d.e(getPageContext().getPageActivity());
            this.commentView = new d.a.q0.h2.g.d.c(getPageContext().getPageActivity(), this.commentCallback);
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
            d.a.p0.s.d0.b.j().t("key_enter_recommend_pb", true);
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
            d.a.p0.x.w.e eVar = this.mEditor;
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
    public d.a.d.k.e.q onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.listView;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (d.a.d.k.e.q) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        d.a.p0.x.w.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (eVar = this.mEditor) != null && eVar.a() != null && this.mEditor.a().u()) {
                this.mEditor.a().q();
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
            this.pbModel = new d.a.q0.h2.g.c.b();
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
            d.a.p0.x.w.e eVar = this.mEditor;
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
            d.a.q0.h2.g.c.a aVar = this.chosenData;
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
