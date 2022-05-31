package com.baidu.tieba.myAttentionAndFans;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.FollowListSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cx4;
import com.repackage.dq4;
import com.repackage.li;
import com.repackage.n86;
import com.repackage.pj7;
import com.repackage.qj7;
import com.repackage.rj7;
import com.repackage.sj7;
import com.repackage.wo4;
import com.repackage.x8;
import com.repackage.ys4;
import com.repackage.zx5;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FOLLOW_TIP_X_OFFSET = 50;
    public static final int MAX_TIP_COUNT = 2;
    public static final int M_W_X002;
    public static final int SHOW_FOLLOW_TIP_MAX_COUNT = 1;
    public static final String TAG_FOLLOW = "follow";
    public static final String TAG_ID = "user_id";
    public static final String TAG_PORTRAIT = "portrait";
    public static final String TAG_SEX = "user_sex";
    public static final String TAG_TOTLEFOLLOWNUM = "total_follow_num";
    public static final int TBDS26;
    public static final int TIP_DISMISS_TIME = 3000;
    public static final int TYPE_SHOW_BOTH_REMOVE_AND_LOOK = 3;
    public static final int TYPE_SHOW_LOOK_ALL = 1;
    public static final int TYPE_SHOW_REMOVE_ALL = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener attentionListener;
    public boolean isFirstEnter;
    public boolean isFromPush;
    public pj7 mAdapter;
    public final AntiHelper.k mAntiInjectListener;
    public AttentionMode mAttentionMode;
    public PersonListModel.d mCallBack;
    public int mChatPersonPosition;
    public NavigationBarShadowView mConcernSelectShadowView;
    public RelativeLayout mContainer;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public BdListView mFollowListView;
    public ImageView mFollowSwitch;
    public View.OnClickListener mFollowSwitchListener;
    public zx5 mFollowSwitchTipController;
    public n86 mForbiddenFansController;
    public View mForbiddenTipContainer;
    public TextView mForbiddenTipView;
    public boolean mHasNetData;
    public TextView mHeaderTitleText;
    public View mHeaderTitleViewRoot;
    public boolean mIsBjhUser;
    public PbListView mLoadMoreView;
    public PersonListModel mModel;
    public NavigationBar mNavigationBar;
    public NavigationBarShadowView mNavigationShadowView;
    public NoDataView mNoDataView;
    public AbsListView.OnScrollListener mOnScrollListener;
    public NoPressedRelativeLayout mParent;
    public String mPortrait;
    public HttpMessageListener mRemoveFansListener;
    public TextView mResultTipView;
    public zx5 mSelectMenuGuideTipController;
    public ConcernSelectView mSelectView;
    public TextView mSubTitleText;
    public View mSubTitleViewParent;
    public View mSubTitleViewRoot;
    public View mTitleLayout;
    public TextView mTitleText;
    public int mTotalFollowNum;
    public int mUserSex;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class AttentionMode {
        public static final /* synthetic */ AttentionMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AttentionMode ALL;
        public static final AttentionMode NULL;
        public static final AttentionMode TIEBA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(996157408, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity$AttentionMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(996157408, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity$AttentionMode;");
                    return;
                }
            }
            ALL = new AttentionMode("ALL", 0);
            TIEBA = new AttentionMode("TIEBA", 1);
            AttentionMode attentionMode = new AttentionMode("NULL", 2);
            NULL = attentionMode;
            $VALUES = new AttentionMode[]{ALL, TIEBA, attentionMode};
        }

        public AttentionMode(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AttentionMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AttentionMode) Enum.valueOf(AttentionMode.class, str) : (AttentionMode) invokeL.objValue;
        }

        public static AttentionMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AttentionMode[]) $VALUES.clone() : (AttentionMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public a(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mChatPersonPosition = ((Integer) view2.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    this.a.StartChat();
                } else {
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11028)));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public b(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.startGetNetData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public c(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.mAdapter != null && this.a.mAdapter.c()) {
                if (this.a.mLoadMoreView != null && !this.a.mLoadMoreView.m()) {
                    this.a.mLoadMoreView.Q();
                }
                this.a.startGetNetData();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ConcernSelectView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public d(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.mFollowListView.setSelection(0);
                this.a.mModel.H(i);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.a.showGuideTip();
                } else if (this.a.mSelectMenuGuideTipController != null) {
                    this.a.mSelectMenuGuideTipController.I();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public e(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.hideFollowSwitchGuideTip();
                if (this.a.mModel == null) {
                    return;
                }
                int i = i.a[this.a.mAttentionMode.ordinal()];
                if (i == 1) {
                    this.a.mAttentionMode = AttentionMode.TIEBA;
                    this.a.mTitleText.setText(R.string.obfuscated_res_0x7f0f13ed);
                    this.a.sendFollowSwitchMessage(2);
                } else if (i != 2) {
                } else {
                    this.a.mAttentionMode = AttentionMode.ALL;
                    this.a.mTitleText.setText(R.string.obfuscated_res_0x7f0f0264);
                    this.a.sendFollowSwitchMessage(1);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public f(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mSelectMenuGuideTipController == null) {
                return;
            }
            this.a.mSelectMenuGuideTipController.I();
        }
    }

    /* loaded from: classes3.dex */
    public class g extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public g(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.lookForAllForbiddenFans();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public h(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.removeAllForbiddenFans();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                super.updateDrawState(textPaint);
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
                textPaint.setUnderlineText(false);
                textPaint.clearShadowLayer();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1534702904, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1534702904, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity$i;");
                    return;
                }
            }
            int[] iArr = new int[AttentionMode.values().length];
            a = iArr;
            try {
                iArr[AttentionMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AttentionMode.TIEBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public j(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(dq4 dq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dq4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(PersonListActivity personListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity, Integer.valueOf(i)};
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
            this.a = personListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(this.a.getPageContext().getUniqueId()) || updateAttentionMessage.getData().l == null || AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().l, this.a.mAntiInjectListener) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(PersonListActivity personListActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity, Integer.valueOf(i)};
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
            this.a = personListActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (this.a.mAdapter.d(((Long) orginalMessage.getExtra()).longValue())) {
                    this.a.mAdapter.b();
                    this.a.mAdapter.notifyDataSetChanged();
                }
                if (this.a.mAdapter.b) {
                    this.a.processNoData(null, false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public m(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = this.a.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !this.a.mModel.E()) {
                    this.a.mNavigationShadowView.a();
                } else {
                    this.a.mConcernSelectShadowView.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) || this.a.mModel == null) {
                return;
            }
            if (i == 1 || i == 2) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = this.a.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !this.a.mModel.E()) {
                    this.a.mNavigationShadowView.c();
                } else {
                    this.a.mConcernSelectShadowView.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements n86.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public n(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.repackage.n86.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonListActivity personListActivity = this.a;
                personListActivity.showLoadingDialog(personListActivity.getString(R.string.obfuscated_res_0x7f0f0faa));
            }
        }

        @Override // com.repackage.n86.e
        public void b(int i, String str, boolean z, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (z) {
                    this.a.closeLoadingDialog();
                    if (i == 2260104) {
                        return;
                    }
                    if (this.a.mResultTipView == null) {
                        this.a.mResultTipView = new TextView(this.a.getActivity());
                        this.a.mResultTipView.setGravity(19);
                        this.a.mResultTipView.setPadding(li.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                        this.a.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, li.f(this.a.getActivity(), R.dimen.tbds112)));
                        this.a.mResultTipView.setTextSize(0, li.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070331));
                        this.a.mResultTipView.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
                    }
                    this.a.mResultTipView.setText(str);
                    if (i == 0) {
                        this.a.mCoverTipNaviBar.setBackgroundColor(this.a.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                    } else {
                        this.a.mCoverTipNaviBar.setBackgroundColor(this.a.getResources().getColor(R.color.nav_bar_tip_error));
                    }
                    this.a.mCoverTipNaviBar.m(this.a.getActivity(), this.a.mResultTipView, 3000);
                }
                if (i2 == 0) {
                    this.a.mForbiddenTipView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0c65));
                    SkinManager.setViewTextColor(this.a.mForbiddenTipView, (int) R.color.CAM_X0109);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o implements PersonListModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public o(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.d
        public wo4 a(wo4 wo4Var, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, wo4Var, z)) == null) {
                if (wo4Var != null && wo4Var.e != this.a.mTotalFollowNum && this.a.mModel != null && this.a.mModel.E() && this.a.mModel.F() == 0) {
                    this.a.mModel.Q(this.a.mPortrait);
                }
                this.a.update(wo4Var, z);
                return null;
            }
            return (wo4) invokeLZ.objValue;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.d
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) || z) {
                return;
            }
            if (this.a.isLoadingViewAttached()) {
                PersonListActivity personListActivity = this.a;
                personListActivity.hideLoadingView(personListActivity.mContainer);
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.showToast(str);
            }
            this.a.processNoData(null, false);
        }
    }

    /* loaded from: classes3.dex */
    public class p implements NoPressedRelativeLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public p(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
        public void a(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
                Rect rect = new Rect();
                this.a.mSelectView.getGlobalVisibleRect(rect);
                if (!this.a.mSelectView.l() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.a.mParent.setNeedInterceptTouchEvent(false);
                    return;
                }
                this.a.mSelectView.h();
                this.a.mParent.setNeedInterceptTouchEvent(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonListActivity a;

        public q(PersonListActivity personListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UserData userData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && (view2.getTag() instanceof Integer)) {
                int intValue = ((Integer) view2.getTag()).intValue();
                if (this.a.mAdapter == null || this.a.mAdapter.getItemViewType(intValue) != 0 || (userData = (UserData) this.a.mAdapter.getItem(intValue)) == null || userData.getUserId() == null) {
                    return;
                }
                if (this.a.mModel.E()) {
                    TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", "1").param("obj_param1", userData.getUserId()));
                } else {
                    TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", 1).param("obj_param1", userData.getUserId()));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ PersonListActivity b;

        public r(PersonListActivity personListActivity, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personListActivity, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personListActivity;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.mModel == null || this.b.mAdapter == null) {
                return;
            }
            UserData userData = (UserData) this.b.mAdapter.getItem(((Integer) view2.getTag()).intValue());
            boolean z = false;
            if ((userData == null || userData.getAlaUserData() == null || userData.getAlaUserData().live_status != 1) ? false : true) {
                if (this.b.mModel.getId() != null && this.b.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                if (z) {
                    str = "c14286";
                    str2 = YYLiveUtil.SOURCE_PERSON_LIST_OWNER;
                } else {
                    str = "c14283";
                    str2 = YYLiveUtil.SOURCE_PERSON_LIST_OTHER;
                }
                sj7.a(str, userData);
                AlaInfoData alaInfo = userData.getAlaInfo();
                if (alaInfo == null || !alaInfo.isLegalYYLiveData()) {
                    return;
                }
                YYLiveUtil.jumpYYLiveRoom(this.b.getPageContext(), alaInfo, str2);
                return;
            }
            this.a.onClick(view2);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1674378787, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1674378787, "Lcom/baidu/tieba/myAttentionAndFans/PersonListActivity;");
                return;
            }
        }
        M_W_X002 = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002);
        TBDS26 = li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    }

    public PersonListActivity() {
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
        this.mFollowListView = null;
        this.mSubTitleViewRoot = null;
        this.mSubTitleViewParent = null;
        this.mSubTitleText = null;
        this.mHeaderTitleViewRoot = null;
        this.mHeaderTitleText = null;
        this.mAdapter = null;
        this.mParent = null;
        this.isFirstEnter = true;
        this.mTitleText = null;
        this.mFollowSwitch = null;
        this.mTitleLayout = null;
        this.mUserSex = 0;
        this.mIsBjhUser = false;
        this.mTotalFollowNum = 0;
        this.mChatPersonPosition = 0;
        this.mAttentionMode = AttentionMode.NULL;
        this.mAntiInjectListener = new j(this);
        this.attentionListener = new k(this, 2001115);
        this.mRemoveFansListener = new l(this, CmdConfigHttp.CMD_REMOVE_FANS);
        this.mOnScrollListener = new m(this);
        this.mCallBack = new o(this);
        this.mFollowSwitchListener = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StartChat() {
        pj7 pj7Var;
        UserData userData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (pj7Var = this.mAdapter) == null || pj7Var.getItemViewType(this.mChatPersonPosition) != 0 || (userData = (UserData) this.mAdapter.getItem(this.mChatPersonPosition)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addFollowSwitch() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, this) == null) {
            this.mTitleText.setText(R.string.obfuscated_res_0x7f0f0264);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitleText.getLayoutParams();
            int i2 = M_W_X002;
            layoutParams.rightMargin = i2;
            layoutParams.leftMargin = i2;
            this.mTitleText.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
            this.mFollowSwitch = imageView;
            imageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mFollowSwitch.getLayoutParams();
            int i3 = TBDS26;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.mFollowSwitch.setLayoutParams(layoutParams2);
            View centerImgBoxLayout = this.mNavigationBar.getCenterImgBoxLayout();
            this.mTitleLayout = centerImgBoxLayout;
            centerImgBoxLayout.setClickable(true);
            this.mTitleLayout.setOnClickListener(this.mFollowSwitchListener);
            this.mTitleLayout.setVisibility(8);
        }
    }

    private void attatchListTitleHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d06b6, (ViewGroup) null);
            this.mHeaderTitleViewRoot = inflate;
            inflate.setVisibility(8);
            this.mHeaderTitleViewRoot.setClickable(false);
            this.mHeaderTitleViewRoot.setEnabled(false);
            this.mHeaderTitleText = (TextView) this.mHeaderTitleViewRoot.findViewById(R.id.obfuscated_res_0x7f0917f6);
            this.mFollowListView.addHeaderView(this.mHeaderTitleViewRoot, null, false);
        }
    }

    private void dealFollowSwitchGuideTip() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65569, this) == null) || ys4.k().h("key_follow_guide_tip", false)) {
            return;
        }
        ys4.k().u("key_follow_guide_tip", true);
        showFollowSwitchGuideTip();
    }

    private SpannableStringBuilder getForbiddenTipSpannableString(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65570, this, str, i2)) == null) {
            String str3 = null;
            if (StringUtils.isNull(str)) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (i2 == 1) {
                spannableStringBuilder.append((CharSequence) "，");
                String string = getString(R.string.obfuscated_res_0x7f0f03e1);
                spannableStringBuilder.append((CharSequence) string);
                str3 = string;
                str2 = null;
            } else if (i2 == 2) {
                spannableStringBuilder.append((CharSequence) "，");
                str2 = getString(R.string.obfuscated_res_0x7f0f0fa4);
                spannableStringBuilder.append((CharSequence) str2);
            } else if (i2 != 3) {
                str2 = null;
            } else {
                str3 = getString(R.string.obfuscated_res_0x7f0f03e1);
                str2 = getString(R.string.obfuscated_res_0x7f0f0fa4);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) str3);
                spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f1417));
                spannableStringBuilder.append((CharSequence) str2);
            }
            if (!StringUtils.isNull(str3)) {
                UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str3, new g(this));
            }
            if (!StringUtils.isNull(str2)) {
                UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new h(this));
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLI.objValue;
    }

    private void initAndRefreshForbiddenTipView(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65571, this, str, i2) == null) {
            if (this.mForbiddenTipContainer == null) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d029c, (ViewGroup) null);
                this.mForbiddenTipContainer = inflate;
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092395);
                this.mForbiddenTipView = textView;
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.mForbiddenTipContainer, R.color.CAM_X0201);
            }
            if (StringUtils.isNull(str)) {
                this.mForbiddenTipContainer.setVisibility(8);
                return;
            }
            this.mForbiddenTipView.setText(getForbiddenTipSpannableString(str, i2));
            this.mForbiddenTipView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mForbiddenTipView.setHighlightColor(getResources().getColor(R.color.transparent));
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65572, this, bundle) == null) {
            PersonListModel personListModel = new PersonListModel(this, this.mCallBack);
            this.mModel = personListModel;
            if (bundle != null) {
                personListModel.O(bundle.getBoolean("follow", false));
                this.mModel.N(bundle.getString("user_id"));
                this.mUserSex = bundle.getInt("user_sex");
                this.mIsBjhUser = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
                this.mTotalFollowNum = bundle.getInt("total_follow_num");
                this.mPortrait = bundle.getString("portrait");
                this.mModel.setSex(this.mUserSex);
                return;
            }
            Intent intent = getIntent();
            this.mModel.O(intent.getBooleanExtra("follow", false));
            this.mModel.N(intent.getStringExtra("user_id"));
            this.mUserSex = intent.getIntExtra("user_sex", 0);
            this.mIsBjhUser = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
            this.mTotalFollowNum = intent.getIntExtra("total_follow_num", 0);
            this.mPortrait = intent.getStringExtra("portrait");
            this.mModel.setSex(this.mUserSex);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            this.mParent = (NoPressedRelativeLayout) findViewById(R.id.obfuscated_res_0x7f09161e);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923a2);
            this.mNavigationBar = navigationBar;
            this.mTitleText = navigationBar.setCenterTextTitle("");
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationShadowView = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f0914de);
            this.mConcernSelectShadowView = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f0914e1);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091db9);
            this.mSubTitleViewRoot = findViewById;
            this.mSubTitleViewParent = findViewById.findViewById(R.id.obfuscated_res_0x7f091541);
            this.mSubTitleViewRoot.setVisibility(8);
            this.mSubTitleViewRoot.setClickable(false);
            this.mSubTitleViewRoot.setEnabled(false);
            this.mSubTitleText = (TextView) this.mSubTitleViewRoot.findViewById(R.id.obfuscated_res_0x7f0917f6);
            this.mSelectView = (ConcernSelectView) findViewById(R.id.obfuscated_res_0x7f091c61);
            this.mCoverTipNaviBar = (NavigationBarCoverTip) findViewById(R.id.obfuscated_res_0x7f0914d4);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String id = this.mModel.getId();
            if (currentAccount != null && currentAccount.equals(id)) {
                if (this.mModel.E()) {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f0b36);
                    if (FollowListSwitch.isOn()) {
                        addFollowSwitch();
                    }
                    this.mParent.setDispathEventAction(new p(this));
                } else {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f05f8);
                }
            } else if (this.mModel.E()) {
                int i2 = this.mUserSex;
                if (i2 == 2) {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f082d);
                } else if (i2 == 1) {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f0836);
                } else {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f0987);
                }
            } else {
                int i3 = this.mUserSex;
                if (i3 == 2) {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f02b4);
                } else if (i3 == 1) {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f02b5);
                } else {
                    this.mTitleText.setText(R.string.obfuscated_res_0x7f0f02b6);
                }
            }
            q qVar = new q(this);
            r rVar = new r(this, qVar);
            a aVar = new a(this);
            b bVar = new b(this);
            boolean z = this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount());
            int sex = this.mModel.getSex();
            if (getIntent().getBooleanExtra("follow", false)) {
                this.mAdapter = new rj7(this, getIntent().getBooleanExtra("follow", false), z, sex, qVar, aVar, bVar, rVar);
                this.mSubTitleViewRoot.setVisibility(0);
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, li.f(getActivity(), R.dimen.tbds530)), null, null);
            } else {
                this.mAdapter = new qj7(this, z, sex, qVar, bVar);
                this.mSubTitleViewRoot.setVisibility(8);
                this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, li.f(getActivity(), R.dimen.tbds530)), null, null);
            }
            this.mContainer = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906b0);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09123c);
            this.mFollowListView = bdListView;
            bdListView.setAdapter((ListAdapter) this.mAdapter);
            attatchListTitleHeader();
            this.mFollowListView.setOnSrollToBottomListener(new c(this));
            this.mFollowListView.setOnScrollListener(this.mOnScrollListener);
            this.mSelectView.setOnExpandListener(new d(this));
            this.mSelectView.setVisibility(8);
            this.mHeaderTitleViewRoot.setVisibility(8);
            PbListView pbListView = new PbListView(getActivity());
            this.mLoadMoreView = pbListView;
            pbListView.b();
            this.mLoadMoreView.p(R.color.CAM_X0205);
            this.mLoadMoreView.x();
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0107));
            this.mLoadMoreView.G(R.dimen.tbfontsize33);
            this.mLoadMoreView.A(R.color.CAM_X0110);
            this.mLoadMoreView.t(li.f(getActivity(), R.dimen.tbds182));
            this.mFollowListView.setNextPage(this.mLoadMoreView);
        }
    }

    private void loadDataFirstTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            showLoadingView(this.mContainer);
            this.mModel.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lookForAllForbiddenFans() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            TiebaStatic.log(new StatisticItem("c13103"));
            if (!li.D()) {
                showToast(getString(R.string.obfuscated_res_0x7f0f0c33));
            } else {
                sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void processHaveData(wo4 wo4Var) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65576, this, wo4Var) == null) || wo4Var == null) {
            return;
        }
        this.mFollowListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        if (this.mModel.E()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mSubTitleViewRoot.setVisibility(0);
                this.mFollowListView.removeHeaderView(this.mHeaderTitleViewRoot);
                textView = this.mSubTitleText;
                textView.setVisibility(0);
                this.mSelectView.setVisibility(0);
                if (FollowListSwitch.isOn()) {
                    if (this.mModel.F() == 0) {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0276);
                    } else {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f051b);
                    }
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0670);
                } else {
                    if (this.mModel.F() == 0) {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0265);
                    } else {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f051b);
                    }
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0df9);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c91)));
            } else {
                this.mSubTitleViewRoot.setVisibility(8);
                this.mHeaderTitleViewRoot.setVisibility(0);
                textView = this.mHeaderTitleText;
                textView.setVisibility(8);
                this.mSelectView.setVisibility(8);
                int i2 = this.mUserSex;
                if (i2 == 2) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1186);
                } else if (i2 == 1) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0828);
                } else {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0828);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c92)));
                string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0df9);
                z = !ListUtils.isEmpty(wo4Var.a());
                if (!z) {
                    textView.setVisibility(0);
                    textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f1591));
                    return;
                }
                textView.setText(string + StringHelper.numberUniformFormat(wo4Var.e) + string2);
                return;
            }
        } else {
            this.mSubTitleViewRoot.setVisibility(8);
            this.mHeaderTitleViewRoot.setVisibility(0);
            textView = this.mHeaderTitleText;
            this.mSelectView.setVisibility(8);
            textView.setVisibility(8);
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0b3d);
                string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f05fe);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c94)));
            } else {
                int i3 = this.mUserSex;
                if (i3 == 2) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f082e);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f05fe);
                } else if (i3 == 1) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0837);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f05fe);
                } else {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0837);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f05fe);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0830)));
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNoData(wo4 wo4Var, boolean z) {
        String string;
        String string2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65577, this, wo4Var, z) == null) {
            this.mFollowListView.setVisibility(8);
            if (!z) {
                this.mNoDataView.setVisibility(0);
            }
            if (this.mModel.E()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.mSelectView.setVisibility(0);
                    this.mSubTitleText.setVisibility(0);
                    this.mSubTitleViewRoot.setVisibility(0);
                    this.mHeaderTitleViewRoot.setVisibility(8);
                    if (FollowListSwitch.isOn()) {
                        if (this.mModel.F() == 0) {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0276);
                        } else {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f051b);
                        }
                        string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0670);
                    } else {
                        if (this.mModel.F() == 0) {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0265);
                        } else {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f051b);
                        }
                        string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0df9);
                    }
                    this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(this.mModel.F() == 0 ? R.string.obfuscated_res_0x7f0f0c91 : R.string.obfuscated_res_0x7f0f0c93)));
                    TextView textView = this.mSubTitleText;
                    textView.setText(string + 0 + string2);
                    return;
                }
                this.mSelectView.setVisibility(8);
                this.mSubTitleText.setVisibility(8);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c92)));
                return;
            }
            this.mSelectView.setVisibility(8);
            this.mSubTitleText.setVisibility(8);
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                if (wo4Var != null && !StringUtils.isNull(wo4Var.g) && !this.mIsBjhUser) {
                    this.mNoDataView.getSuTextView().setText(getForbiddenTipSpannableString(wo4Var.g, wo4Var.h));
                    this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                    this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                    TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 1));
                    return;
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0c94)));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0830)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllForbiddenFans() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 1));
            if (!li.D()) {
                showToast(getString(R.string.obfuscated_res_0x7f0f0c33));
            } else {
                this.mForbiddenFansController.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFollowSwitchMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65579, this, i2) == null) {
            BdListView bdListView = this.mFollowListView;
            if (bdListView != null) {
                bdListView.setVisibility(8);
            }
            pj7 pj7Var = this.mAdapter;
            if (pj7Var != null) {
                pj7Var.e();
            }
            PersonListModel personListModel = this.mModel;
            if (personListModel != null) {
                personListModel.P(0);
            }
            showLoadingView(this.mContainer);
            setTitleClickable(false);
            PersonListModel personListModel2 = this.mModel;
            if (personListModel2 != null) {
                personListModel2.L(i2);
            }
        }
    }

    private void setTitleClickable(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65580, this, z) == null) || (view2 = this.mTitleLayout) == null) {
            return;
        }
        view2.setClickable(z);
    }

    private void showFollowSwitchGuideTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            if (this.mFollowSwitchTipController == null) {
                zx5 zx5Var = new zx5(getPageContext(), this.mTitleLayout);
                this.mFollowSwitchTipController = zx5Var;
                zx5Var.g0(R.drawable.obfuscated_res_0x7f0802ee);
                this.mFollowSwitchTipController.T(1);
                this.mFollowSwitchTipController.N(3000);
                this.mFollowSwitchTipController.j0(50);
            }
            this.mFollowSwitchTipController.l0(getResources().getString(R.string.obfuscated_res_0x7f0f03ee));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideTip() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65582, this) == null) && this.mSelectMenuGuideTipController == null) {
            zx5 zx5Var = new zx5(getPageContext(), this.mSelectView.h);
            this.mSelectMenuGuideTipController = zx5Var;
            zx5Var.g0(R.drawable.obfuscated_res_0x7f0802ee);
            this.mSelectMenuGuideTipController.T(2);
            this.mSelectMenuGuideTipController.N(3000);
            this.mSelectMenuGuideTipController.j0(-10);
            this.mSelectMenuGuideTipController.k0(-16);
            this.mSelectMenuGuideTipController.M(new f(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetNetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            pj7 pj7Var = this.mAdapter;
            if (pj7Var != null) {
                pj7Var.notifyDataSetChanged();
            }
            this.mModel.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void update(wo4 wo4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65584, this, wo4Var, z) == null) {
            synchronized (this) {
                if (this.mModel != null && wo4Var != null) {
                    if (z && this.mHasNetData) {
                        return;
                    }
                    if (!z) {
                        this.mHasNetData = true;
                        updateModel(wo4Var);
                    }
                    updateLoadMoreView(wo4Var);
                    updateAdapter(wo4Var, z);
                    if (!this.mModel.E()) {
                        cx4.f0().b0(0);
                    }
                    updateView(wo4Var, z);
                    updateTitleView(wo4Var);
                }
            }
        }
    }

    private void updateAdapter(wo4 wo4Var, boolean z) {
        pj7 pj7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65585, this, wo4Var, z) == null) || (pj7Var = this.mAdapter) == null) {
            return;
        }
        if (!z) {
            if (wo4Var.d == 1) {
                pj7Var.e();
            }
            this.mAdapter.f(wo4Var.f);
            this.mAdapter.a(wo4Var);
            this.mAdapter.b();
            this.mAdapter.notifyDataSetChanged();
            return;
        }
        pj7Var.f(false);
        this.mAdapter.a(wo4Var);
        this.mAdapter.b();
        this.mAdapter.notifyDataSetChanged();
    }

    private void updateLoadMoreView(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65586, this, wo4Var) == null) || wo4Var == null) {
            return;
        }
        if (!wo4Var.f && !StringUtils.isNull(wo4Var.g) && !this.mIsBjhUser) {
            initAndRefreshForbiddenTipView(wo4Var.g, wo4Var.h);
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.addFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.removeFooterView(this.mLoadMoreView.b());
            TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 2));
        } else if (!wo4Var.f) {
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mLoadMoreView.C(getString(R.string.obfuscated_res_0x7f0f0c65));
            this.mLoadMoreView.f();
        } else {
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mLoadMoreView.C(getString(R.string.obfuscated_res_0x7f0f0dc7));
            this.mLoadMoreView.f();
        }
    }

    private void updateModel(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65587, this, wo4Var) == null) {
            this.mModel.P(wo4Var.d);
        }
    }

    private void updateTitleView(wo4 wo4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65588, this, wo4Var) == null) || this.mTitleLayout == null) {
            return;
        }
        if (isLoadingViewAttached()) {
            hideLoadingView(this.mContainer);
            setTitleClickable(true);
        }
        if (wo4Var.e > 0) {
            processHaveData(wo4Var);
        }
        int i2 = wo4Var.j;
        if (i2 == 1) {
            this.mAttentionMode = AttentionMode.ALL;
            this.mTitleLayout.setVisibility(0);
            this.mTitleText.setText(R.string.obfuscated_res_0x7f0f0264);
            dealFollowSwitchGuideTip();
        } else if (i2 != 2) {
            this.mAttentionMode = AttentionMode.NULL;
        } else {
            this.mAttentionMode = AttentionMode.TIEBA;
            this.mTitleLayout.setVisibility(0);
            this.mTitleText.setText(R.string.obfuscated_res_0x7f0f13ed);
        }
    }

    private void updateView(wo4 wo4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65589, this, wo4Var, z) == null) {
            if (this.mModel.G() == 0 || this.mModel.G() == 1) {
                hideLoadingView(this.mContainer);
                setTitleClickable(true);
                if (wo4Var.e > 0 && !ListUtils.isEmpty(wo4Var.b())) {
                    processHaveData(wo4Var);
                } else {
                    processNoData(wo4Var, z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.isFromPush) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.finish();
            if (this.isFromPush) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    public void hideFollowSwitchGuideTip() {
        zx5 zx5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (zx5Var = this.mFollowSwitchTipController) != null && zx5Var.J()) {
            this.mFollowSwitchTipController.I();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) && i3 == -1 && i2 == 11028) {
            StartChat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SkinManager.setBackgroundResource(this.mParent, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            pj7 pj7Var = this.mAdapter;
            if (pj7Var != null) {
                pj7Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.mNoDataView;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.mSelectView.m(i2);
            SkinManager.setBackgroundColor(this.mSubTitleText, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mSubTitleText, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.mHeaderTitleText, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.mHeaderTitleText, (int) R.color.CAM_X0109);
            getLayoutMode().k(i2 == 1);
            if (this.mSubTitleViewParent != null) {
                getLayoutMode().j(this.mSubTitleViewParent);
            }
            if (this.mHeaderTitleViewRoot != null) {
                getLayoutMode().j(this.mHeaderTitleViewRoot);
            }
            if (this.mForbiddenTipContainer != null) {
                SkinManager.setViewTextColor(this.mForbiddenTipView, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.mForbiddenTipContainer, R.color.CAM_X0201);
            }
            this.mForbiddenFansController.d();
            this.mLoadMoreView.E(SkinManager.getColor(R.color.CAM_X0109));
            this.mLoadMoreView.d(i2);
            WebPManager.setPureDrawable(this.mFollowSwitch, R.drawable.obfuscated_res_0x7f0809e3, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            boolean z = true;
            z = (x8.g().i("YunPushProxyActivity") && x8.g().h() == 1) ? false : false;
            this.isFromPush = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d06b3);
            initData(bundle);
            initUI();
            n86 n86Var = new n86(getPageContext(), getUniqueId());
            this.mForbiddenFansController = n86Var;
            n86Var.g(new n(this));
            registerListener(this.attentionListener);
            registerListener(this.mRemoveFansListener);
            this.mModel.J();
            this.mModel.I();
            if (this.isFirstEnter) {
                this.isFirstEnter = false;
                loadDataFirstTime();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.mAdapter != null) {
                this.mAdapter = null;
            }
            zx5 zx5Var = this.mSelectMenuGuideTipController;
            if (zx5Var != null) {
                zx5Var.I();
            }
            zx5 zx5Var2 = this.mFollowSwitchTipController;
            if (zx5Var2 != null) {
                zx5Var2.I();
            }
            this.mCoverTipNaviBar.i();
            this.mModel.K();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.mSelectView.l()) {
                    this.mSelectView.h();
                    return false;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("follow", this.mModel.E());
            bundle.putString("user_id", this.mModel.getId());
            bundle.putInt("user_sex", this.mUserSex);
            bundle.putBoolean(IntentConfig.IS_BJH_USER, this.mIsBjhUser);
        }
    }
}
