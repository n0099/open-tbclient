package com.baidu.tieba.recapp.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.c;
import c.a.e.e.p.l;
import c.a.p0.s.q.c2;
import c.a.q0.x2.h0.a;
import c.a.q0.x2.l0.e;
import c.a.q0.x2.l0.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STYLE_NORMAL_AD = 1;
    public static final int STYLE_THREAD_AD = 2;
    public static int TBDS44 = 0;
    public static String URL = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public transient /* synthetic */ FieldHolder $fh;
    public a A;
    public int w;
    public int x;
    public int y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1307047704, "Lcom/baidu/tieba/recapp/view/AdThreadCommentAndPraiseInfoLayout;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1307047704, "Lcom/baidu/tieba/recapp/view/AdThreadCommentAndPraiseInfoLayout;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdThreadCommentAndPraiseInfoLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.w = 1;
        this.x = 0;
        int i4 = R.drawable.selector_comment_and_prise_item_text_color;
        this.y = i4;
        this.z = i4;
        T();
    }

    public final int R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int length = str.length();
            int i2 = length > 5120 ? 1 : 0;
            if (length > 5120) {
                i2 |= 2;
            }
            if (length > 5120) {
                i2 |= 4;
            }
            if (length > 5120) {
                i2 |= 8;
            }
            return length > 446 ? i2 | 16 : i2;
        }
        return invokeL.intValue;
    }

    public final String S(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            try {
                return new JSONObject(new String(c.d(str))).getString(str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TBDS44 = l.g(this.mContext, R.dimen.tbds44);
            setManageVisible(false);
            setSelectVisible(false);
            setShowFlag(11);
            V();
        }
    }

    public final void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 1) {
                W(this.A.getThreadData(), "nozan", 0);
                X(this.A.getThreadData(), "1", "2");
                return;
            }
            W(this.A.getThreadData(), FeedData.TYPE_ZAN, 0);
            X(this.A.getThreadData(), "1", "1");
        }
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.mAgreeView == null) {
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f56325e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56325e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.f56325e.mAgreeView.getData()) == null) {
                    return;
                }
                this.f56325e.mAgreeView.getImgAgree().cancelAnimation();
                int i2 = 0;
                if (data.hasAgree) {
                    if (data.agreeType == 2) {
                        data.agreeType = 2;
                        data.hasAgree = false;
                        data.diffAgreeNum--;
                        data.agreeNum--;
                        this.f56325e.mAgreeView.updateUI();
                        i2 = 1;
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum += 2;
                        data.agreeNum++;
                        data.disAgreeNum--;
                        this.f56325e.mAgreeView.updateUiWithAnimation(true);
                    }
                } else {
                    data.agreeType = 2;
                    data.hasAgree = true;
                    data.diffAgreeNum++;
                    data.agreeNum++;
                    this.f56325e.mAgreeView.updateUiWithAnimation(true);
                }
                this.f56325e.U(i2);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f56326e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56326e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.f56326e.mAgreeView.getData()) == null) {
                    return;
                }
                this.f56326e.mAgreeView.getImgDisagree().cancelAnimation();
                int i2 = 1;
                if (data.hasAgree) {
                    if (data.agreeType == 5) {
                        data.agreeType = 5;
                        data.hasAgree = false;
                        data.diffAgreeNum++;
                        data.disAgreeNum--;
                        this.f56326e.mAgreeView.updateUI();
                        this.f56326e.U(i2);
                    }
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum -= 2;
                    data.agreeNum--;
                    data.disAgreeNum++;
                    this.f56326e.mAgreeView.updateUiWithAnimation(false);
                } else {
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum--;
                    data.disAgreeNum++;
                    this.f56326e.mAgreeView.updateUiWithAnimation(false);
                }
                i2 = 0;
                this.f56326e.U(i2);
            }
        };
        this.mAgreeView.getImgAgree().setOnClickListener(onClickListener);
        this.mAgreeView.getAgreeNumView().setOnClickListener(onClickListener);
        this.mAgreeView.getImgDisagree().setOnClickListener(onClickListener2);
        this.mAgreeView.getDisagreeNumView().setOnClickListener(onClickListener2);
    }

    public final void W(AdvertAppInfo advertAppInfo, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048581, this, advertAppInfo, str, i2) == null) {
            c.a.q0.x2.l0.c b2 = g.b(advertAppInfo, 8, i2);
            b2.c(str);
            e.b().d(b2);
        }
    }

    public final void X(AdvertAppInfo advertAppInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048582, this, advertAppInfo, str, str2) == null) || advertAppInfo == null) {
            return;
        }
        String str3 = advertAppInfo.a4;
        new BdAsyncTask<String, Void, Void>(this, str, str2) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f56329a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f56330b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f56331c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str, str2};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56331c = this;
                this.f56329a = str;
                this.f56330b = str2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(String... strArr) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                    if (strArr == null || strArr.length <= 0) {
                        return null;
                    }
                    NetWork netWork = new NetWork(strArr[0]);
                    netWork.addPostData("cpid", strArr[1]);
                    netWork.addPostData("idea_id", strArr[2]);
                    netWork.addPostData("type", this.f56329a);
                    netWork.addPostData("cmd", this.f56330b);
                    netWork.postNetData();
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }.execute(URL, S(str3, "cpid"), S(str3, "idea_id"));
    }

    public void addAdMoreView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, view) == null) || view == null) {
            return;
        }
        this.mButtonMoreContainer.setVisibility(0);
        this.mButtonMoreContainer.removeAllViews();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
        this.mButtonMoreContainer.addView(view);
    }

    public void disableClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mShareContainer.setClickable(false);
            this.mCommentContainer.setClickable(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mCommentContainer : (View) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onChangeSkinType();
            this.mCommentImageView.setClickable(false);
            this.mCommentImageView.setEnabled(false);
            SkinManager.setViewTextColor(this.mCommentNum, this.y);
            SkinManager.setViewTextColor(this.mShareNum, this.z);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onShareNumClick(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || this.mData == null || this.mContext == null || (aVar = this.A) == null) {
            return;
        }
        W(aVar.getThreadData(), "share", 0);
        X(this.A.getThreadData(), "2", "1");
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.mContext)) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.A.getTitle();
            shareItem.D = this.A.getTitle();
            shareItem.t = this.A.getShareLink();
            shareItem.F = 3;
            shareItem.f47982f = true;
            String imageUrl = this.A.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.mContext, shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener(this, shareItem) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ShareItem f56327e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f56328f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, shareItem};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f56328f = this;
                    this.f56327e = shareItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ShareItem shareItem2 = this.f56327e;
                        shareItem2.t = c.a.p0.t.g.g.o(shareItem2.t, shareItem2.K);
                        c.a.e.e.p.a.a(this.f56327e.t);
                        l.M(this.f56328f.mContext, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                }
            });
            shareDialogConfig.setHideMode(R(shareItem.t));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void setDisPraiseViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (z) {
                this.y = R.color.CAM_X0110;
            } else {
                this.y = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (z) {
                this.z = R.color.CAM_X0110;
            } else {
                this.z = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareData(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            this.A = aVar;
            setData(aVar.getThreadData());
        }
    }

    public void setStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.x = i2;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateBarName(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, c2Var) == null) {
            super.updateBarName(c2Var);
            if (this.w == 1) {
                this.mBarName.setText(StringHelper.cutChineseAndEnglishWithSuffix(c2Var.Z(), 12, ""));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updateLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.updateLayout();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.x == 1) {
                    layoutParams2.width = -2;
                    layoutParams2.addRule(11);
                    int i2 = TBDS44;
                    layoutParams2.setMargins(i2, 0, i2, 0);
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.setMargins(0, 0, 0, 0);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                if (this.x == 1) {
                    layoutParams3.width = -2;
                    layoutParams3.gravity = 5;
                    int i3 = TBDS44;
                    layoutParams3.setMargins(i3, 0, i3, 0);
                    return;
                }
                layoutParams3.width = -1;
                layoutParams3.setMargins(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, c2Var) == null) {
            if (c2Var != null) {
                this.mAgreeView.setAgreeAlone(true);
                if (this.mAgreeView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.mAgreeView.getLayoutParams()).weight = 1.0f;
                }
                AgreeData B = c2Var.B();
                if (B != null && B.agreeNum == 0 && B.diffAgreeNum == 0) {
                    B.agreeNum = c2Var.C();
                    B.hasAgree = c2Var.d0() == 1;
                    B.agreeType = c2Var.D();
                    B.diffAgreeNum = c2Var.C() - c2Var.Q();
                }
            }
            super.updatePraiseNum(c2Var);
            AgreeView agreeView = this.mAgreeView;
            if (agreeView != null) {
                agreeView.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.x != 1) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdThreadCommentAndPraiseInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.w = 1;
        this.x = 0;
        int i4 = R.drawable.selector_comment_and_prise_item_text_color;
        this.y = i4;
        this.z = i4;
        T();
    }
}
