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
import com.repackage.a9;
import com.repackage.b9;
import com.repackage.bp7;
import com.repackage.cj8;
import com.repackage.cp7;
import com.repackage.dp7;
import com.repackage.ep7;
import com.repackage.i75;
import com.repackage.ji;
import com.repackage.li;
import com.repackage.nn;
import com.repackage.to7;
import com.repackage.v15;
import com.repackage.vo7;
import com.repackage.wa;
import com.repackage.wo7;
import com.repackage.wv7;
import com.repackage.ww4;
import com.repackage.x15;
import com.repackage.xo7;
import com.repackage.yo7;
import com.repackage.ys4;
import com.repackage.z15;
import com.repackage.zn8;
import com.repackage.zo7;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
/* loaded from: classes3.dex */
public class PbChosenActivity extends BaseActivity<PbChosenActivity> implements VoiceManager.j {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHOSEN_PB_TABLE_NAME = "chosen_pb_page_cache";
    public static final String FROM_CHOSEN_PB = "from_chosen_pb";
    public static final String FROM_FRS = "from_frs";
    public static final String ST_TYPE = "pb_chosen";
    public transient /* synthetic */ FieldHolder $fh;
    public zo7 adapter;
    public CustomMessageListener attentionListener;
    public LikeModel attentionModel;
    public CustomMessageListener cacheReadListener;
    public wo7 chosenData;
    public bp7.a commentCallback;
    public bp7 commentView;
    public to7 dialog;
    public int from;
    public boolean hasData;
    public boolean isDataLoaded;
    public boolean isShowLoading;
    public BdListView listView;
    public DataModel<PbChosenActivity> mDataModel;
    public x15 mEditor;
    public final NewWriteModel.e mOnPostWriteCallback;
    public v15 mPrePostCallBack;
    public final AbsListView.OnScrollListener mScrollListener;
    public VoiceManager mVoiceManager;
    public NavigationBar navigationBar;
    public wa netListener;
    public xo7 pbModel;
    public CustomMessageListener pbNativeZanListener;
    public cp7.e personInfoCallback;
    public cp7 personInfoView;
    public dp7.c postCallback;
    public dp7 postInfoView;
    public int praiseData;
    public View.OnClickListener replyClickListener;
    public View replyNumberRoot;
    public TextView replyNumberView;
    public ep7 replyView;
    public RelativeLayout rootView;
    public View.OnClickListener shareListener;
    public String shareUrl;
    public long startTime;
    public CustomMessageListener unAttentionListener;
    public wa zanListener;
    public yo7 zanModel;

    /* loaded from: classes3.dex */
    public class a implements cp7.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* renamed from: com.baidu.tieba.pb.chosen.PbChosenActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0220a extends a9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0220a(a aVar) {
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

            @Override // com.repackage.a9
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && AntiHelper.m(this.a.a.attentionModel.getErrorCode(), this.a.a.attentionModel.getErrorString())) {
                    AntiHelper.u(this.a.a.getActivity(), this.a.a.attentionModel.getErrorString());
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

        @Override // com.repackage.cp7.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(str, PbChosenActivity.FROM_CHOSEN_PB)));
            if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || this.a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_sourcefid").param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
        }

        @Override // com.repackage.cp7.e
        public void b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                this.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str, str2)));
            }
        }

        @Override // com.repackage.cp7.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!ji.z()) {
                    BdToast.c(this.a.getPageContext().getPageActivity(), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33)).n();
                } else if (!this.a.checkUpIsLogin() || this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || this.a.chosenData.getThreadInfo().forum.forum_id == null) {
                } else {
                    if (this.a.attentionModel == null) {
                        PbChosenActivity pbChosenActivity = this.a;
                        pbChosenActivity.attentionModel = new LikeModel(pbChosenActivity.getPageContext());
                    }
                    this.a.attentionModel.setFrom("from_frs");
                    this.a.attentionModel.setLoadDataCallBack(new C0220a(this));
                    this.a.attentionModel.P(this.a.chosenData.getThreadInfo().forum.forum_name, String.valueOf(this.a.chosenData.getThreadInfo().forum.forum_id));
                    if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c10322");
                    StatisticItem param = statisticItem.param("fid", this.a.chosenData.getThreadInfo().forum.forum_id + "");
                    TiebaStatic.log(param.param("tid", this.a.chosenData.getThreadInfo().thread_id + "").param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && (responsedMessage instanceof wo7)) {
                wo7 wo7Var = (wo7) responsedMessage;
                int erroCode = wo7Var.getErroCode();
                this.a.isDataLoaded = true;
                if (erroCode == 0) {
                    this.a.updateViews(wo7Var);
                } else {
                    PbChosenActivity pbChosenActivity = this.a;
                    pbChosenActivity.hideLoadingView(pbChosenActivity.rootView);
                    this.a.showToast(StringUtils.isNull(wo7Var.getErrorText()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33) : wo7Var.getErrorText());
                }
                if (this.a.hasData) {
                    return;
                }
                String string = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f05ac);
                PbChosenActivity pbChosenActivity2 = this.a;
                pbChosenActivity2.showNetRefreshView(pbChosenActivity2.rootView, string, true);
                this.a.setNetRefreshLayoutMarginTop(false);
                this.a.replyView.e(false);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.postInfoView.n();
                this.a.postInfoView.h = !this.a.postInfoView.h;
                this.a.postInfoView.m(this.a.postInfoView.h);
                if (this.a.postInfoView.h) {
                    this.a.praiseData = 1;
                } else {
                    this.a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            this.a.postInfoView.n();
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    errorString = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                BdToast.c(this.a.getPageContext().getPageActivity(), errorString).n();
                return;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ChosenZanNetMessage) {
                ChosenZanNetMessage chosenZanNetMessage = (ChosenZanNetMessage) extra;
                this.a.postInfoView.m(chosenZanNetMessage.isPraise());
                if (chosenZanNetMessage.isPraise()) {
                    this.a.praiseData = 1;
                } else {
                    this.a.praiseData = 0;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ReadChosenPbCacheResponse) && this.a.getIntent() != null) {
                long longExtra = this.a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TID, 0L);
                long longExtra2 = this.a.getIntent().getLongExtra(PbChosenActivityConfig.KEY_TAG_CODE, 0L);
                long longExtra3 = this.a.getIntent().getLongExtra("thread_id", 0L);
                wo7 chosenData = ((ReadChosenPbCacheResponse) customResponsedMessage).getChosenData();
                if (chosenData != null && chosenData.getThreadInfo() != null && chosenData.getThreadInfo().excid != null && longExtra == chosenData.getThreadInfo().excid.longValue()) {
                    this.a.isDataLoaded = true;
                    this.a.updateViews(chosenData);
                }
                if (this.a.pbModel == null) {
                    this.a.pbModel = new xo7();
                }
                this.a.pbModel.c(this.a, longExtra, longExtra2, longExtra3);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                li.x(this.a.getActivity(), this.a.getCurrentFocus());
                if (this.a.mEditor != null && this.a.mEditor.a() != null) {
                    this.a.mEditor.a().o();
                }
                this.a.replyView.e(true);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c10091");
            TiebaStatic.log(statisticItem.param("tid", this.a.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.a.chosenData.getThreadInfo().tag_name).param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.getPageContext().getPageActivity());
            this.a.sendMessage(new CustomMessage(2004001, pbActivityConfig.createCfgForPbChosen(this.a.chosenData.getThreadInfo().thread_id + "", this.a.praiseData)));
        }
    }

    /* loaded from: classes3.dex */
    public class i extends DataModel<PbChosenActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PbChosenActivity pbChosenActivity, b9 b9Var) {
            super(b9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, b9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((b9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
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
                if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null) {
                    return null;
                }
                return String.valueOf(this.a.chosenData.getThreadInfo().thread_id);
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData F(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null) {
                    return null;
                }
                WriteData writeData = new WriteData();
                writeData.setForumId(String.valueOf(this.a.chosenData.getThreadInfo().forum.forum_id));
                writeData.setForumName(this.a.chosenData.getThreadInfo().forum.forum_name);
                writeData.setThreadId(String.valueOf(this.a.chosenData.getThreadInfo().thread_id));
                writeData.setIsAd(false);
                writeData.setType(1);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean J() {
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
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || this.a.chosenData.getThreadInfo().forum == null) {
                    return null;
                }
                return String.valueOf(this.a.chosenData.getThreadInfo().forum.forum_id);
            }
            return (String) invokeV.objValue;
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
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;

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
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) || i == 0 || this.a.mEditor == null || this.a.mEditor.a() == null) {
                return;
            }
            this.a.mEditor.a().o();
            this.a.replyView.e(true);
        }
    }

    /* loaded from: classes3.dex */
    public class k implements v15 {
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

        @Override // com.repackage.v15
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || !this.a.checkUpIsLogin() || this.a.mEditor == null || this.a.mEditor.a() == null) {
                return;
            }
            this.a.mEditor.a().j();
            this.a.replyView.e(false);
        }
    }

    /* loaded from: classes3.dex */
    public class m implements NewWriteModel.e {
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

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ww4 ww4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ww4Var, writeData, antiData}) == null) {
                this.a.hideProgressBar();
                if (z) {
                    this.a.mEditor.a().o();
                    this.a.replyView.e(true);
                    if (postWriteCallBackData != null) {
                        cj8.b(this.a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    }
                } else if (postWriteCallBackData == null || ww4Var != null || postWriteCallBackData.getErrorCode() == 227001 || zn8.d(postWriteCallBackData.getErrorCode())) {
                } else {
                    if (AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                        AntiHelper.u(this.a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
                    } else {
                        BdToast.c(this.a.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).n();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements bp7.a {
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

        @Override // com.repackage.bp7.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || !this.a.checkUpIsLogin() || this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || StringUtils.isNull(str)) {
                return;
            }
            if (this.a.chosenData != null && this.a.chosenData.getThreadInfo() != null) {
                StatisticItem statisticItem = new StatisticItem("c10093");
                TiebaStatic.log(statisticItem.param("tid", this.a.chosenData.getThreadInfo().thread_id + "").param("obj_name", this.a.chosenData.getThreadInfo().tag_name).param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
            }
            this.a.sendMessage(new CustomMessage(2002001, new SubPbActivityConfig(this.a.getPageContext().getPageActivity()).createSubPbActivityConfig(this.a.chosenData.getThreadInfo().thread_id + "", str, PbChosenActivity.ST_TYPE, true, null, true)));
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.chosenData != null && this.a.chosenData.getThreadInfo() != null) {
                    TiebaStatic.log(new StatisticItem("pb_new_share").param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
                }
                if (this.a.checkUpIsLogin()) {
                    if (this.a.from == 2) {
                        TiebaStatic.log("c10148");
                    }
                    if (this.a.dialog == null) {
                        PbChosenActivity pbChosenActivity = this.a;
                        pbChosenActivity.dialog = new to7(pbChosenActivity);
                    }
                    this.a.dialog.f(this.a.chosenData, this.a.shareUrl);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.handleAttentionResponse(true, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.handleAttentionResponse(false, customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements dp7.c {
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

        @Override // com.repackage.dp7.c
        public void a(long j, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJL(1048576, this, j, str) == null) || StringUtils.isNull(str)) {
                return;
            }
            this.a.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getPageContext().getPageActivity()).createCfgForPbChosen(str, this.a.praiseData)));
            if (this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || this.a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("pb_new_detail_btn").param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
        }

        @Override // com.repackage.dp7.c
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || this.a.chosenData == null || this.a.chosenData.getThreadInfo() == null || this.a.chosenData.getThreadInfo().excid == null) {
                return;
            }
            if (this.a.zanModel == null) {
                this.a.zanModel = new yo7();
            }
            if (z) {
                yo7 yo7Var = this.a.zanModel;
                PbChosenActivity pbChosenActivity = this.a;
                yo7Var.c(pbChosenActivity, pbChosenActivity.chosenData.getThreadInfo().excid.longValue(), this.a.chosenData.getThreadInfo().thread_id.longValue(), this.a.chosenData.getThreadInfo().post_id.longValue(), 2);
            } else {
                yo7 yo7Var2 = this.a.zanModel;
                PbChosenActivity pbChosenActivity2 = this.a;
                yo7Var2.c(pbChosenActivity2, pbChosenActivity2.chosenData.getThreadInfo().excid.longValue(), this.a.chosenData.getThreadInfo().thread_id.longValue(), this.a.chosenData.getThreadInfo().post_id.longValue(), 1);
            }
            TiebaStatic.log(new StatisticItem("pb_new_like").param("obj_source", this.a.chosenData.getThreadInfo().source.intValue()).param("abtest", this.a.chosenData.getThreadInfo().abtest));
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
        wo7 wo7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(65560, this, z, customResponsedMessage) == null) || customResponsedMessage == null || (wo7Var = this.chosenData) == null || wo7Var.getThreadInfo() == null || this.chosenData.getThreadInfo().forum.forum_id == null) {
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
            z15 z15Var = new z15();
            z15Var.r(getPbEditorModel());
            x15 x15Var = (x15) z15Var.a(getActivity());
            this.mEditor = x15Var;
            x15Var.e0(getPageContext());
            this.mEditor.n0(this.mOnPostWriteCallback);
            this.mEditor.o0(this.mPrePostCallBack);
            this.mEditor.a().C(true);
            this.mEditor.F(getPageContext(), bundle);
            setEditor(this.mEditor);
        }
    }

    private void initNavigationBar() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.navigationBar = navigationBar;
            if (navigationBar == null) {
                return;
            }
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new g(this));
            this.navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f03d7);
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01da, (ViewGroup) null);
            this.replyNumberRoot = inflate;
            this.replyNumberView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090624);
            this.navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.replyNumberRoot, new h(this));
        }
    }

    private void sendReadCacheMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001314, new vo7());
            CustomMessage customMessage = new CustomMessage(2001314);
            customMessage.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(customMessage, customMessageTask);
        }
    }

    private void setEditor(x15 x15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65564, this, x15Var) == null) || x15Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        this.rootView.addView(x15Var.a(), layoutParams);
        x15Var.a().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateViews(wo7 wo7Var) {
        Long l2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, this, wo7Var) == null) {
            hideLoadingView(this.rootView);
            if (wo7Var != null && !wo7Var.isEmpty()) {
                this.hasData = true;
                this.replyView.e(true);
                this.chosenData = wo7Var;
                UserInfo userInfo = wo7Var.getUserInfo();
                if (userInfo != null) {
                    this.personInfoView.update(userInfo);
                }
                bp7 bp7Var = this.commentView;
                if (bp7Var != null) {
                    bp7Var.d(wo7Var.getPostList(), wo7Var.getUserList());
                }
                ExcellentPbThreadInfo threadInfo = wo7Var.getThreadInfo();
                if (threadInfo != null) {
                    if (this.replyNumberView != null && (l2 = threadInfo.post_num) != null) {
                        String numFormatOver10000 = StringHelper.numFormatOver10000(l2.longValue());
                        this.replyNumberView.setText(getResources().getString(R.string.obfuscated_res_0x7f0f03d4, numFormatOver10000));
                        this.replyView.c(getResources().getString(R.string.obfuscated_res_0x7f0f03d3, numFormatOver10000));
                    }
                    this.postInfoView.update(threadInfo);
                    this.personInfoView.j(getPageContext().getPageActivity(), threadInfo);
                    wv7 wv7Var = new wv7();
                    wv7Var.c(getPageContext(), wo7Var.getThreadInfo().content);
                    this.adapter.d(wv7Var.a());
                    this.adapter.notifyDataSetChanged();
                }
                this.listView.setVisibility(0);
                return;
            }
            showNetRefreshView(this.rootView, getResources().getString(R.string.obfuscated_res_0x7f0f05ac), true);
            setNetRefreshLayoutMarginTop(false);
            this.replyView.e(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.repackage.f75
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "a013" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public i75 getPageStayDurationItem() {
        InterceptResult invokeV;
        wo7 wo7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            i75 pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (wo7Var = this.chosenData) != null && wo7Var.getThreadInfo() != null && this.chosenData.getThreadInfo().forum != null) {
                pageStayDurationItem.t(this.chosenData.getThreadInfo().forum.forum_id.longValue());
                pageStayDurationItem.C(this.chosenData.getThreadInfo().thread_id.longValue());
            }
            return pageStayDurationItem;
        }
        return (i75) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, voiceModel)) == null) {
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
            x15 x15Var = this.mEditor;
            if (x15Var != null) {
                x15Var.H(i2, i3, intent);
            }
            if (i2 == 23003) {
                to7.d(this, this.chosenData, intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.shareUrl);
            } else if (i2 != 23007) {
            } else {
                long longExtra = intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L);
                String stringExtra = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME);
                String stringExtra2 = intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT);
                to7.e(this, this.chosenData, longExtra, stringExtra, intent.getStringExtra("name_show"), stringExtra2, this.shareUrl);
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
            x15 x15Var = this.mEditor;
            if (x15Var != null && x15Var.a() != null) {
                this.mEditor.a().w(i2);
            }
            SkinManager.setNavbarTitleColor(this.replyNumberView, R.color.navi_op_text, R.color.obfuscated_res_0x7f06087a);
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
            setContentView(R.layout.obfuscated_res_0x7f0d01d6);
            this.rootView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f090627);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09061f);
            this.listView = bdListView;
            bdListView.setOnTouchListener(new f(this));
            this.listView.setOnScrollListener(this.mScrollListener);
            zo7 zo7Var = new zo7(getPageContext().getPageActivity());
            this.adapter = zo7Var;
            this.listView.setAdapter((ListAdapter) zo7Var);
            ep7 ep7Var = new ep7(findViewById(R.id.obfuscated_res_0x7f090622));
            this.replyView = ep7Var;
            ep7Var.b(this.replyClickListener);
            this.replyView.d(this.shareListener);
            this.personInfoView = new cp7(getPageContext().getPageActivity());
            this.postInfoView = new dp7(getPageContext().getPageActivity());
            this.commentView = new bp7(getPageContext().getPageActivity(), this.commentCallback);
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
            ys4.k().u("key_enter_recommend_pb", true);
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
            x15 x15Var = this.mEditor;
            if (x15Var != null) {
                x15Var.I();
            }
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity
    public nn onGetPreLoadListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            BdListView bdListView = this.listView;
            if (bdListView == null) {
                return null;
            }
            return bdListView.getPreLoadHandle();
        }
        return (nn) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        x15 x15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4 && (x15Var = this.mEditor) != null && x15Var.a() != null && this.mEditor.a().u()) {
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
            this.pbModel = new xo7();
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
            x15 x15Var = this.mEditor;
            if (x15Var != null) {
                x15Var.K(bundle);
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
            wo7 wo7Var = this.chosenData;
            if (wo7Var != null && wo7Var.getThreadInfo() != null && this.chosenData.getThreadInfo().excid != null) {
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
