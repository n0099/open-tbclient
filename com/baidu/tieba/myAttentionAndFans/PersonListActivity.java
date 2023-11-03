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
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.be7;
import com.baidu.tieba.dq6;
import com.baidu.tieba.ly4;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.sl9;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tl9;
import com.baidu.tieba.ul9;
import com.baidu.tieba.view.NavigationBarCoverTip;
import com.baidu.tieba.vl9;
import com.baidu.tieba.x95;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.language.bm.Rule;
/* loaded from: classes7.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static final int P;
    public static final int Q;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcernSelectView A;
    public dq6 B;
    public dq6 C;
    public View D;
    public TextView E;
    public TextView F;
    public be7 G;
    public AttentionMode H;
    public boolean I;
    public final AntiHelper.k J;
    public CustomMessageListener K;
    public HttpMessageListener L;
    public AbsListView.OnScrollListener M;
    public PersonListModel.d N;
    public View.OnClickListener O;
    public RelativeLayout a;
    public BdListView b;
    public PbListView c;
    public View d;
    public View e;
    public TextView f;
    public View g;
    public TextView h;
    public sl9 i;
    public PersonListModel j;
    public NoDataView k;
    public NoPressedRelativeLayout l;
    public boolean m;
    public boolean n;
    public NavigationBar o;
    public NavigationBarCoverTip p;
    public NavigationBarShadowView q;
    public NavigationBarShadowView r;
    public TextView s;
    public ImageView t;
    public View u;
    public int v;
    public boolean w;
    public int x;
    public String y;
    public int z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
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
            ALL = new AttentionMode(Rule.ALL, 0);
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AttentionMode) Enum.valueOf(AttentionMode.class, str);
            }
            return (AttentionMode) invokeL.objValue;
        }

        public static AttentionMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AttentionMode[]) $VALUES.clone();
            }
            return (AttentionMode[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.z = ((Integer) view2.getTag()).intValue();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11028)));
                } else {
                    this.a.J0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.P1();
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null && this.a.i.c()) {
                if (this.a.c != null && !this.a.c.p()) {
                    this.a.c.U();
                }
                this.a.P1();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.b.setSelection(0);
                this.a.j.X(i);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    if (this.a.B != null) {
                        this.a.B.h();
                        return;
                    }
                    return;
                }
                this.a.O1();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.y1();
                if (this.a.j == null) {
                    return;
                }
                int i = i.a[this.a.H.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        this.a.H = AttentionMode.ALL;
                        this.a.s.setText(R.string.obfuscated_res_0x7f0f02a2);
                        this.a.K1(1);
                        return;
                    }
                    return;
                }
                this.a.H = AttentionMode.TIEBA;
                this.a.s.setText(R.string.obfuscated_res_0x7f0f16a9);
                this.a.K1(2);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.B != null) {
                this.a.B.h();
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.F1();
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

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.I1();
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

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        public void onNavigationButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zz4Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(this.a.getPageContext().getUniqueId()) && updateAttentionMessage.getData().blockData != null && AntiHelper.t(this.a.getActivity(), updateAttentionMessage.getData().blockData, this.a.J) != null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.i.d(((Long) orginalMessage.getExtra()).longValue())) {
                    this.a.i.b();
                    this.a.i.notifyDataSetChanged();
                }
                if (!this.a.i.b) {
                    return;
                }
                this.a.H1(null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                String id = this.a.j.getId();
                if (currentAccount != null && currentAccount.equals(id) && this.a.j.U()) {
                    this.a.r.a();
                } else {
                    this.a.q.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) != null) || this.a.j == null) {
                return;
            }
            if (i != 1 && i != 2) {
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String id = this.a.j.getId();
            if (currentAccount != null && currentAccount.equals(id) && this.a.j.U()) {
                this.a.r.c();
            } else {
                this.a.q.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements be7.e {
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

        @Override // com.baidu.tieba.be7.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                PersonListActivity personListActivity = this.a;
                personListActivity.showLoadingDialog(personListActivity.getString(R.string.remove_fans_loading));
            }
        }

        @Override // com.baidu.tieba.be7.e
        public void b(int i, String str, boolean z, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (z) {
                    this.a.closeLoadingDialog();
                    if (i == 2260104) {
                        return;
                    }
                    if (this.a.F == null) {
                        this.a.F = new TextView(this.a.getActivity());
                        this.a.F.setGravity(19);
                        this.a.F.setPadding(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07020f), 0, 0, 0);
                        this.a.F.setLayoutParams(new ViewGroup.LayoutParams(-1, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds112)));
                        this.a.F.setTextSize(0, BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070459));
                        this.a.F.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
                    }
                    this.a.F.setText(str);
                    if (i == 0) {
                        this.a.p.setBackgroundColor(this.a.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                    } else {
                        this.a.p.setBackgroundColor(this.a.getResources().getColor(R.color.nav_bar_tip_error));
                    }
                    this.a.p.k(this.a.getActivity(), this.a.F, 3000);
                }
                if (i2 == 0) {
                    this.a.E.setText(this.a.getString(R.string.no_more_data_tip));
                    SkinManager.setViewTextColor(this.a.E, (int) R.color.CAM_X0109);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        public ly4 a(ly4 ly4Var, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, ly4Var, z)) == null) {
                if (ly4Var != null && ly4Var.e != this.a.x && this.a.j != null && this.a.j.U() && this.a.j.V() == 0) {
                    this.a.j.g0(this.a.y);
                }
                this.a.Q1(ly4Var, z);
                return null;
            }
            return (ly4) invokeLZ.objValue;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.d
        public void b(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) && !z) {
                if (this.a.isLoadingViewAttached()) {
                    PersonListActivity personListActivity = this.a;
                    personListActivity.hideLoadingView(personListActivity.a);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.a.showToast(str);
                }
                this.a.H1(null, false);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.A.getGlobalVisibleRect(rect);
                if (this.a.A.l() && !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    this.a.A.h();
                    this.a.l.setNeedInterceptTouchEvent(true);
                    return;
                }
                this.a.l.setNeedInterceptTouchEvent(false);
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.i != null && this.a.i.getItemViewType(intValue) == 0 && (userData = (UserData) this.a.i.getItem(intValue)) != null && userData.getUserId() != null) {
                    if (this.a.j.U()) {
                        TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", "1").param("obj_param1", userData.getUserId()));
                    } else {
                        TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", 1).param("obj_param1", userData.getUserId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
            boolean z;
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.j != null && this.b.i != null) {
                UserData userData = (UserData) this.b.i.getItem(((Integer) view2.getTag()).intValue());
                boolean z2 = false;
                if (userData != null && userData.getAlaUserData() != null && userData.getAlaUserData().live_status == 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.b.j.getId() != null && this.b.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                    }
                    if (!z2) {
                        str = "c14283";
                        str2 = YYLiveUtil.SOURCE_PERSON_LIST_OTHER;
                    } else {
                        str = "c14286";
                        str2 = YYLiveUtil.SOURCE_PERSON_LIST_OWNER;
                    }
                    vl9.a(str, userData);
                    AlaInfoData alaInfo = userData.getAlaInfo();
                    if (alaInfo != null && alaInfo.isLegalYYLiveData()) {
                        YYLiveUtil.jumpYYLiveRoom(this.b.getPageContext(), alaInfo, str2);
                        return;
                    }
                    return;
                }
                this.a.onClick(view2);
            }
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
        P = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002);
        Q = BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem("c13103"));
            if (!BdUtilHelper.isNetOk()) {
                showToast(getString(R.string.obfuscated_res_0x7f0f0e61));
            } else {
                sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
            }
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 1));
            if (!BdUtilHelper.isNetOk()) {
                showToast(getString(R.string.obfuscated_res_0x7f0f0e61));
            } else {
                this.G.e();
            }
        }
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
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.l = null;
        this.m = true;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = 0;
        this.w = false;
        this.x = 0;
        this.z = 0;
        this.H = AttentionMode.NULL;
        this.J = new j(this);
        this.K = new k(this, 2001115);
        this.L = new l(this, CmdConfigHttp.CMD_REMOVE_FANS);
        this.M = new m(this);
        this.N = new o(this);
        this.O = new e(this);
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.s.setText(R.string.obfuscated_res_0x7f0f02a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.s.getLayoutParams();
            int i2 = P;
            layoutParams.rightMargin = i2;
            layoutParams.leftMargin = i2;
            this.s.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) this.o.getCenterImgBox();
            this.t = imageView;
            imageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.t.getLayoutParams();
            int i3 = Q;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.t.setLayoutParams(layoutParams2);
            View centerImgBoxLayout = this.o.getCenterImgBoxLayout();
            this.u = centerImgBoxLayout;
            centerImgBoxLayout.setClickable(true);
            this.u.setOnClickListener(this.O);
            this.u.setVisibility(8);
        }
    }

    public final void L1(boolean z) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (view2 = this.u) != null) {
            view2.setClickable(z);
        }
    }

    public final void T1(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ly4Var) == null) {
            this.j.f0(ly4Var.d);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048597, this, i2, i3, intent) == null) && i3 == -1 && i2 == 11028) {
            J0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048601, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                if (this.A.l()) {
                    this.A.h();
                    return false;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void B1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            PersonListModel personListModel = new PersonListModel(this, this.N);
            this.j = personListModel;
            if (bundle != null) {
                personListModel.e0(bundle.getBoolean("follow", false));
                this.j.d0(bundle.getString("user_id"));
                this.v = bundle.getInt(IntentConfig.USER_SEX);
                this.w = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
                this.x = bundle.getInt(PersonListActivityConfig.TOTLEFOLLOWNUM);
                this.y = bundle.getString("portrait");
                this.j.setSex(this.v);
                return;
            }
            Intent intent = getIntent();
            this.j.e0(intent.getBooleanExtra("follow", false));
            this.j.d0(intent.getStringExtra("user_id"));
            this.v = intent.getIntExtra(IntentConfig.USER_SEX, 0);
            this.w = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
            this.x = intent.getIntExtra(PersonListActivityConfig.TOTLEFOLLOWNUM, 0);
            this.y = intent.getStringExtra("portrait");
            this.j.setSex(this.v);
        }
    }

    public final void S1(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, ly4Var) != null) || ly4Var == null) {
            return;
        }
        if (!ly4Var.f && !StringUtils.isNull(ly4Var.g) && !this.w) {
            z1(ly4Var.g, ly4Var.h);
            this.b.removeFooterView(this.D);
            this.b.addFooterView(this.D);
            this.b.removeFooterView(this.c.c());
            TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 2));
        } else if (!ly4Var.f) {
            this.b.removeFooterView(this.D);
            this.c.H(getString(R.string.no_more_data_tip));
            this.c.g();
        } else {
            this.b.removeFooterView(this.D);
            this.c.H(getString(R.string.pb_load_more));
            this.c.g();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bundle) == null) {
            boolean z = true;
            z = (BdActivityStack.getInst().isActivityExist("YunPushProxyActivity") && BdActivityStack.getInst().getSize() == 1) ? false : false;
            this.I = z;
            if (z) {
                setIsAddSwipeBackLayout(false);
            }
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0802);
            B1(bundle);
            D1();
            be7 be7Var = new be7(getPageContext(), getUniqueId());
            this.G = be7Var;
            be7Var.g(new n(this));
            registerListener(this.K);
            registerListener(this.L);
            this.j.Z();
            this.j.Y();
            if (this.m) {
                this.m = false;
                E1();
            }
        }
    }

    public final void D1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.l = (NoPressedRelativeLayout) findViewById(R.id.obfuscated_res_0x7f091acb);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.o = navigationBar;
            this.s = navigationBar.setCenterTextTitle("");
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.q = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f091956);
            this.r = (NavigationBarShadowView) findViewById(R.id.obfuscated_res_0x7f091959);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092369);
            this.d = findViewById;
            this.e = findViewById.findViewById(R.id.obfuscated_res_0x7f0919c9);
            this.d.setVisibility(8);
            this.d.setClickable(false);
            this.d.setEnabled(false);
            this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091c97);
            this.A = (ConcernSelectView) findViewById(R.id.obfuscated_res_0x7f0921d3);
            this.p = (NavigationBarCoverTip) findViewById(R.id.obfuscated_res_0x7f091949);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String id = this.j.getId();
            if (currentAccount != null && currentAccount.equals(id)) {
                if (this.j.U()) {
                    this.s.setText(R.string.obfuscated_res_0x7f0f0d44);
                    if (FollowListSwitch.isOn()) {
                        u1();
                    }
                    this.l.setDispathEventAction(new p(this));
                } else {
                    this.s.setText(R.string.obfuscated_res_0x7f0f071e);
                }
            } else if (this.j.U()) {
                int i2 = this.v;
                if (i2 == 2) {
                    this.s.setText(R.string.obfuscated_res_0x7f0f09dd);
                } else if (i2 == 1) {
                    this.s.setText(R.string.obfuscated_res_0x7f0f09eb);
                } else {
                    this.s.setText(R.string.obfuscated_res_0x7f0f0b70);
                }
            } else {
                int i3 = this.v;
                if (i3 == 2) {
                    this.s.setText(R.string.attention_to_her);
                } else if (i3 == 1) {
                    this.s.setText(R.string.attention_to_him);
                } else {
                    this.s.setText(R.string.attention_to_it);
                }
            }
            q qVar = new q(this);
            r rVar = new r(this, qVar);
            a aVar = new a(this);
            b bVar = new b(this);
            if (this.j.getId() != null && this.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
            int sex = this.j.getSex();
            if (getIntent().getBooleanExtra("follow", false)) {
                this.i = new ul9(this, getIntent().getBooleanExtra("follow", false), z, sex, qVar, aVar, bVar, rVar);
                this.d.setVisibility(0);
                this.k = NoDataViewFactory.a(getPageContext().getPageActivity(), this.l, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOFOLLOW, BdUtilHelper.getDimens(getActivity(), R.dimen.tbds530)), null, null);
            } else {
                this.i = new tl9(getPageContext(), z, sex, qVar, bVar);
                this.d.setVisibility(8);
                this.k = NoDataViewFactory.a(getPageContext().getPageActivity(), this.l, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOFOLLOW, BdUtilHelper.getDimens(getActivity(), R.dimen.tbds530)), null, null);
            }
            this.a = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0907db);
            BdListView bdListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f091596);
            this.b = bdListView;
            bdListView.setAdapter((ListAdapter) this.i);
            v1();
            this.b.setOnSrollToBottomListener(new c(this));
            this.b.setOnScrollListener(this.M);
            this.A.setOnExpandListener(new d(this));
            this.A.setVisibility(8);
            this.g.setVisibility(8);
            PbListView pbListView = new PbListView(getActivity());
            this.c = pbListView;
            pbListView.c();
            this.c.s(R.color.CAM_X0205);
            this.c.B();
            this.c.J(SkinManager.getColor(R.color.CAM_X0107));
            this.c.L(R.dimen.tbfontsize33);
            this.c.F(R.color.CAM_X0110);
            this.c.w(BdUtilHelper.getDimens(getActivity(), R.dimen.tbds182));
            this.b.setNextPage(this.c);
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            showLoadingView(this.a);
            this.j.c0();
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            sl9 sl9Var = this.i;
            if (sl9Var != null) {
                sl9Var.notifyDataSetChanged();
            }
            this.j.c0();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.I) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.finish();
            if (this.I) {
                MainTabActivityConfig mainTabActivityConfig = new MainTabActivityConfig(this);
                mainTabActivityConfig.setBottomTab(3);
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, mainTabActivityConfig));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (this.i != null) {
                this.i = null;
            }
            dq6 dq6Var = this.B;
            if (dq6Var != null) {
                dq6Var.h();
            }
            dq6 dq6Var2 = this.C;
            if (dq6Var2 != null) {
                dq6Var2.h();
            }
            this.p.f();
            this.j.a0();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onResume();
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || SharedPrefHelper.getInstance().getBoolean("key_follow_guide_tip", false)) {
            return;
        }
        SharedPrefHelper.getInstance().putBoolean("key_follow_guide_tip", true);
        N1();
    }

    public void y1() {
        dq6 dq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (dq6Var = this.C) != null && dq6Var.i()) {
            this.C.h();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G1(ly4 ly4Var) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, ly4Var) != null) || ly4Var == null) {
            return;
        }
        this.b.setVisibility(0);
        this.k.setVisibility(8);
        if (this.j.U()) {
            if (this.j.getId() != null && this.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.d.setVisibility(0);
                this.b.removeHeaderView(this.g);
                textView = this.f;
                textView.setVisibility(0);
                this.A.setVisibility(0);
                if (FollowListSwitch.isOn()) {
                    if (this.j.V() == 0) {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f02b5);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.forum_friend);
                } else {
                    if (this.j.V() == 0) {
                        string = getPageContext().getString(R.string.obfuscated_res_0x7f0f02a3);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f107b);
                }
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec5)));
            } else {
                this.d.setVisibility(8);
                this.g.setVisibility(0);
                textView = this.h;
                textView.setVisibility(8);
                this.A.setVisibility(8);
                int i2 = this.v;
                if (i2 == 2) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f1417);
                } else if (i2 == 1) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09d5);
                } else {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09d5);
                }
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec6)));
                string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f107b);
                z = !ListUtils.isEmpty(ly4Var.a());
                if (!z) {
                    textView.setVisibility(0);
                    textView.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f189c));
                    return;
                }
                textView.setText(string + StringHelper.numberUniformFormat(ly4Var.e) + string2);
                return;
            }
        } else {
            this.d.setVisibility(8);
            this.g.setVisibility(0);
            textView = this.h;
            this.A.setVisibility(8);
            textView.setVisibility(8);
            if (this.j.getId() != null && this.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                string = getPageContext().getString(R.string.obfuscated_res_0x7f0f0d4a);
                string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0724);
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec8)));
            } else {
                int i3 = this.v;
                if (i3 == 2) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09de);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0724);
                } else if (i3 == 1) {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09ec);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0724);
                } else {
                    string = getPageContext().getString(R.string.obfuscated_res_0x7f0f09ec);
                    string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f0724);
                }
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f09e0)));
            }
        }
        z = false;
        if (!z) {
        }
    }

    public final void H1(ly4 ly4Var, boolean z) {
        String string;
        String string2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048581, this, ly4Var, z) == null) {
            this.b.setVisibility(8);
            if (!z) {
                this.k.setVisibility(0);
            }
            if (this.j.U()) {
                if (this.j.getId() != null && this.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.A.setVisibility(0);
                    this.f.setVisibility(0);
                    this.d.setVisibility(0);
                    this.g.setVisibility(8);
                    if (FollowListSwitch.isOn()) {
                        if (this.j.V() == 0) {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f02b5);
                        } else {
                            string = getPageContext().getString(R.string.each_concerned);
                        }
                        string2 = getPageContext().getString(R.string.forum_friend);
                    } else {
                        if (this.j.V() == 0) {
                            string = getPageContext().getString(R.string.obfuscated_res_0x7f0f02a3);
                        } else {
                            string = getPageContext().getString(R.string.each_concerned);
                        }
                        string2 = getPageContext().getString(R.string.obfuscated_res_0x7f0f107b);
                    }
                    if (this.j.V() == 0) {
                        i2 = R.string.obfuscated_res_0x7f0f0ec5;
                    } else {
                        i2 = R.string.obfuscated_res_0x7f0f0ec7;
                    }
                    this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(i2)));
                    TextView textView = this.f;
                    textView.setText(string + 0 + string2);
                    return;
                }
                this.A.setVisibility(8);
                this.f.setVisibility(8);
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec6)));
                return;
            }
            this.A.setVisibility(8);
            this.f.setVisibility(8);
            if (this.j.getId() != null && this.j.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                if (ly4Var != null && !StringUtils.isNull(ly4Var.g) && !this.w) {
                    this.k.getSuTextView().setText(x1(ly4Var.g, ly4Var.h));
                    this.k.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                    this.k.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                    TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 1));
                    return;
                }
                this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f0ec8)));
                return;
            }
            this.k.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.obfuscated_res_0x7f0f09e0)));
        }
    }

    public final void J0() {
        sl9 sl9Var;
        UserData userData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (sl9Var = this.i) != null && sl9Var.getItemViewType(this.z) == 0 && (userData = (UserData) this.i.getItem(this.z)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                if (getPageContext() != null && getPageContext().getPageActivity() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void K1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            BdListView bdListView = this.b;
            if (bdListView != null) {
                bdListView.setVisibility(8);
            }
            sl9 sl9Var = this.i;
            if (sl9Var != null) {
                sl9Var.e();
            }
            PersonListModel personListModel = this.j;
            if (personListModel != null) {
                personListModel.f0(0);
            }
            showLoadingView(this.a);
            L1(false);
            PersonListModel personListModel2 = this.j;
            if (personListModel2 != null) {
                personListModel2.b0(i2);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("follow", this.j.U());
            bundle.putString("user_id", this.j.getId());
            bundle.putInt(IntentConfig.USER_SEX, this.v);
            bundle.putBoolean(IntentConfig.IS_BJH_USER, this.w);
        }
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.C == null) {
                dq6 dq6Var = new dq6(getPageContext(), this.u);
                this.C = dq6Var;
                dq6Var.L(R.drawable.bg_tip_blue_up);
                this.C.w(1);
                this.C.n(3000);
                this.C.Q(50);
            }
            this.C.S(getResources().getString(R.string.obfuscated_res_0x7f0f0475));
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.B == null) {
            dq6 dq6Var = new dq6(getPageContext(), this.A.h);
            this.B = dq6Var;
            dq6Var.L(R.drawable.bg_tip_blue_up);
            this.B.w(2);
            this.B.n(3000);
            this.B.Q(-10);
            this.B.R(-16);
            this.B.m(new f(this));
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0805, (ViewGroup) null);
            this.g = inflate;
            inflate.setVisibility(8);
            this.g.setClickable(false);
            this.g.setEnabled(false);
            this.h = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091c97);
            this.b.addHeaderView(this.g, null, false);
        }
    }

    public final synchronized void Q1(ly4 ly4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, ly4Var, z) == null) {
            synchronized (this) {
                if (this.j != null && ly4Var != null) {
                    if (z && this.n) {
                        return;
                    }
                    if (!z) {
                        this.n = true;
                        T1(ly4Var);
                    }
                    S1(ly4Var);
                    R1(ly4Var, z);
                    if (!this.j.U()) {
                        x95.p0().j0(0);
                    }
                    V1(ly4Var, z);
                    U1(ly4Var);
                }
            }
        }
    }

    public final void R1(ly4 ly4Var, boolean z) {
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048590, this, ly4Var, z) == null) && (sl9Var = this.i) != null) {
            if (!z) {
                if (ly4Var.d == 1) {
                    sl9Var.e();
                }
                this.i.f(ly4Var.f);
                this.i.a(ly4Var);
                this.i.b();
                this.i.notifyDataSetChanged();
                return;
            }
            sl9Var.f(false);
            this.i.a(ly4Var);
            this.i.b();
            this.i.notifyDataSetChanged();
        }
    }

    public final void U1(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, ly4Var) == null) && this.u != null) {
            if (isLoadingViewAttached()) {
                hideLoadingView(this.a);
                L1(true);
            }
            if (ly4Var.e > 0) {
                G1(ly4Var);
            }
            int i2 = ly4Var.j;
            if (i2 != 1) {
                if (i2 != 2) {
                    this.H = AttentionMode.NULL;
                    return;
                }
                this.H = AttentionMode.TIEBA;
                this.u.setVisibility(0);
                this.s.setText(R.string.obfuscated_res_0x7f0f16a9);
                return;
            }
            this.H = AttentionMode.ALL;
            this.u.setVisibility(0);
            this.s.setText(R.string.obfuscated_res_0x7f0f02a2);
            w1();
        }
    }

    public final void V1(ly4 ly4Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, ly4Var, z) == null) {
            if (this.j.W() == 0 || this.j.W() == 1) {
                hideLoadingView(this.a);
                L1(true);
                if (ly4Var.e > 0 && !ListUtils.isEmpty(ly4Var.b())) {
                    G1(ly4Var);
                } else {
                    H1(ly4Var, z);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.a, R.color.CAM_X0201);
            this.o.onChangeSkinType(getPageContext(), i2);
            sl9 sl9Var = this.i;
            if (sl9Var != null) {
                sl9Var.notifyDataSetChanged();
            }
            NoDataView noDataView = this.k;
            if (noDataView != null) {
                noDataView.f(getPageContext(), i2);
            }
            this.A.m(i2);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            BDLayoutMode layoutMode = getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            if (this.e != null) {
                getLayoutMode().onModeChanged(this.e);
            }
            if (this.g != null) {
                getLayoutMode().onModeChanged(this.g);
            }
            if (this.D != null) {
                SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0201);
            }
            this.G.d();
            this.c.J(SkinManager.getColor(R.color.CAM_X0109));
            this.c.e(i2);
            WebPManager.setPureDrawable(this.t, R.drawable.obfuscated_res_0x7f080c41, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public final SpannableStringBuilder x1(String str, int i2) {
        InterceptResult invokeLI;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, str, i2)) == null) {
            String str3 = null;
            if (StringUtils.isNull(str)) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        str2 = null;
                    } else {
                        str3 = getString(R.string.obfuscated_res_0x7f0f0467);
                        str2 = getString(R.string.obfuscated_res_0x7f0f1257);
                        spannableStringBuilder.append((CharSequence) "，");
                        spannableStringBuilder.append((CharSequence) str3);
                        spannableStringBuilder.append((CharSequence) getString(R.string.obfuscated_res_0x7f0f16de));
                        spannableStringBuilder.append((CharSequence) str2);
                    }
                } else {
                    spannableStringBuilder.append((CharSequence) "，");
                    str2 = getString(R.string.obfuscated_res_0x7f0f1257);
                    spannableStringBuilder.append((CharSequence) str2);
                }
            } else {
                spannableStringBuilder.append((CharSequence) "，");
                String string = getString(R.string.obfuscated_res_0x7f0f0467);
                spannableStringBuilder.append((CharSequence) string);
                str3 = string;
                str2 = null;
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

    public final void z1(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048610, this, str, i2) == null) {
            if (this.D == null) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d02f9, (ViewGroup) null);
                this.D = inflate;
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0929c9);
                this.E = textView;
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0201);
            }
            if (StringUtils.isNull(str)) {
                this.D.setVisibility(8);
                return;
            }
            this.E.setText(x1(str, i2));
            this.E.setMovementMethod(LinkMovementMethod.getInstance());
            this.E.setHighlightColor(getResources().getColor(R.color.transparent));
        }
    }
}
