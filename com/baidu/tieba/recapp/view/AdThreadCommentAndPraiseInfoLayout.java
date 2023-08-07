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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.AndroidUtils;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.DisableZanSwitch;
import com.baidu.tbadk.switchs.PraiseSwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.ff5;
import com.baidu.tieba.fy9;
import com.baidu.tieba.immessagecenter.mention.FeedData;
import com.baidu.tieba.q31;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.uh;
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
    public static int E0 = 0;
    public static String F0 = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public transient /* synthetic */ FieldHolder $fh;
    public int A0;
    public int B0;
    public int C0;
    public fy9 D0;
    public int z0;

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

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
        }
    }

    public void setDisPraiseViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z0 = 1;
        this.A0 = 0;
        this.B0 = R.drawable.selector_comment_and_prise_item_text_color;
        this.C0 = R.drawable.selector_comment_and_prise_item_text_color;
        n0();
    }

    public final int l0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            int i = 0;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int length = str.length();
            if (length > 5120) {
                i = 1;
            }
            if (length > 5120) {
                i |= 2;
            }
            if (length > 5120) {
                i |= 4;
            }
            if (length > 5120) {
                i |= 8;
            }
            if (length > 446) {
                return i | 16;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public final void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (i == 1) {
                q0(this.D0.getThreadData(), "nozan", 0);
                r0(this.D0.getThreadData(), "1", "2");
                return;
            }
            q0(this.D0.getThreadData(), FeedData.TYPE_ZAN, 0);
            r0(this.D0.getThreadData(), "1", "1");
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.z0 = 1;
        this.A0 = 0;
        this.B0 = R.drawable.selector_comment_and_prise_item_text_color;
        this.C0 = R.drawable.selector_comment_and_prise_item_text_color;
        n0();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void M(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            super.M(threadData);
            if (this.z0 == 1) {
                this.b.setText(StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 12, ""));
            }
        }
    }

    public void addAdMoreView(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, view2) != null) || view2 == null) {
            return;
        }
        this.m.setVisibility(0);
        this.m.removeAllViews();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
        this.m.addView(view2);
    }

    public void setReplayContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.B0 = R.color.CAM_X0110;
            } else {
                this.B0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.C0 = R.color.CAM_X0110;
            } else {
                this.C0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareData(fy9 fy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fy9Var) == null) {
            this.D0 = fy9Var;
            setData(fy9Var.getThreadData());
        }
    }

    public void setStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.z0 = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.A0 = i;
        }
    }

    public final String m0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            try {
                return new JSONObject(new String(uh.d(str))).getString(str2);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void J(View view2) {
        fy9 fy9Var;
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) && this.F != null && this.G != null && (fy9Var = this.D0) != null) {
            q0(fy9Var.getThreadData(), "share", 0);
            r0(this.D0.getThreadData(), "2", "1");
            if (!ShareSwitch.isOn() && !ViewHelper.checkUpIsLogin(this.G)) {
                return;
            }
            ShareItem shareItem = new ShareItem();
            shareItem.title = this.D0.getTitle();
            shareItem.shareAbstract = this.D0.getTitle();
            shareItem.linkUrl = this.D0.getShareLink();
            shareItem.objParam1 = 3;
            shareItem.isFromFeed = true;
            String imageUrl = this.D0.getImageUrl();
            if (imageUrl == null) {
                parse = null;
            } else {
                parse = Uri.parse(imageUrl);
            }
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.G, shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener(this, shareItem) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareItem a;
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, shareItem};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = shareItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                        ShareItem shareItem2 = this.a;
                        shareItem2.linkUrl = ff5.t(shareItem2.linkUrl, shareItem2.tid, UtilHelper.isVideoThread(shareItem2.obj_type));
                        AndroidUtils.copyToClipboard(this.a.linkUrl);
                        BdUtilHelper.showToast(this.b.G, view3.getResources().getString(R.string.copy_pb_url_success));
                    }
                }
            });
            shareDialogConfig.setHideMode(l0(shareItem.linkUrl));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.A0 == 1) {
                    layoutParams2.width = -2;
                    layoutParams2.addRule(11);
                    int i = E0;
                    layoutParams2.setMargins(i, 0, i, 0);
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.setMargins(0, 0, 0, 0);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                if (this.A0 == 1) {
                    layoutParams3.width = -2;
                    layoutParams3.gravity = 5;
                    int i2 = E0;
                    layoutParams3.setMargins(i2, 0, i2, 0);
                    return;
                }
                layoutParams3.width = -1;
                layoutParams3.setMargins(0, 0, 0, 0);
            }
        }
    }

    public void disableClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.setClickable(false);
            this.i.setClickable(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (View) invokeV.objValue;
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            E0 = BdUtilHelper.getDimens(this.G, R.dimen.tbds44);
            setManageVisible(false);
            setSelectVisible(false);
            setShowFlag(11);
            p0();
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onChangeSkinType();
            this.g.setClickable(false);
            this.g.setEnabled(false);
            SkinManager.setViewTextColor(this.f, this.B0);
            SkinManager.setViewTextColor(this.j, this.C0);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.e != null) {
            View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AgreeData data;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) || !PraiseSwitch.isOn() || (data = this.a.e.getData()) == null) {
                        return;
                    }
                    this.a.e.getImgAgree().cancelAnimation();
                    int i = 0;
                    if (data.hasAgree) {
                        if (data.agreeType == 2) {
                            data.agreeType = 2;
                            if (!DisableZanSwitch.getIsOn()) {
                                data.hasAgree = false;
                                data.diffAgreeNum--;
                                data.agreeNum--;
                                this.a.e.d0();
                            }
                            i = 1;
                        } else {
                            data.agreeType = 2;
                            if (!DisableZanSwitch.getIsOn()) {
                                data.hasAgree = true;
                                data.diffAgreeNum += 2;
                                data.agreeNum++;
                                data.disAgreeNum--;
                                this.a.e.e0(true);
                            }
                        }
                    } else {
                        data.agreeType = 2;
                        if (!DisableZanSwitch.getIsOn()) {
                            data.hasAgree = true;
                            data.diffAgreeNum++;
                            data.agreeNum++;
                            this.a.e.e0(true);
                        }
                    }
                    this.a.o0(i);
                    if (WindowGreySwitch.getIsOnNew()) {
                        return;
                    }
                    this.a.h(view2);
                }
            };
            View.OnClickListener onClickListener2 = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    AgreeData data;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 != null && interceptable2.invokeL(1048576, this, view2) != null) || (data = this.a.e.getData()) == null) {
                        return;
                    }
                    this.a.e.getImgDisagree().cancelAnimation();
                    int i = 1;
                    if (data.hasAgree) {
                        if (data.agreeType == 5) {
                            data.agreeType = 5;
                            data.hasAgree = false;
                            data.diffAgreeNum++;
                            data.disAgreeNum--;
                            this.a.e.d0();
                            this.a.o0(i);
                        }
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum -= 2;
                        data.agreeNum--;
                        data.disAgreeNum++;
                        this.a.e.e0(false);
                    } else {
                        data.agreeType = 5;
                        data.hasAgree = true;
                        data.diffAgreeNum--;
                        data.disAgreeNum++;
                        this.a.e.e0(false);
                    }
                    i = 0;
                    this.a.o0(i);
                }
            };
            this.e.getImgAgree().setOnClickListener(onClickListener);
            this.e.getAgreeNumView().setOnClickListener(onClickListener);
            this.e.getImgDisagree().setOnClickListener(onClickListener2);
            this.e.getDisagreeNumView().setOnClickListener(onClickListener2);
        }
    }

    public final void q0(AdvertAppInfo advertAppInfo, String str, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048589, this, advertAppInfo, str, i) == null) {
            boolean equals = "PB_BANNER".equals(advertAppInfo.j);
            ClogBuilder clogBuilder = new ClogBuilder();
            ClogBuilder y = clogBuilder.y(ClogBuilder.LogType.NON_AD_CLICK);
            if (equals) {
                i2 = -1;
            } else {
                i2 = advertAppInfo.position + 1;
            }
            ClogBuilder q = y.q(String.valueOf(i2));
            if (equals) {
                i = -1;
            }
            q.w(String.valueOf(i)).v(advertAppInfo.j).j(str).p(advertAppInfo.g);
            q31.e(clogBuilder);
        }
    }

    public final void r0(AdvertAppInfo advertAppInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048590, this, advertAppInfo, str, str2) == null) && advertAppInfo != null) {
            String str3 = advertAppInfo.g;
            new BdAsyncTask<String, Void, Void>(this, str, str2) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;
                public final /* synthetic */ String b;
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.c = this;
                    this.a = str;
                    this.b = str2;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
                public Void doInBackground(String... strArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                        if (strArr != null && strArr.length > 0) {
                            NetWork netWork = new NetWork(strArr[0]);
                            netWork.addPostData("cpid", strArr[1]);
                            netWork.addPostData("idea_id", strArr[2]);
                            netWork.addPostData("type", this.a);
                            netWork.addPostData("cmd", this.b);
                            netWork.postNetData();
                            return null;
                        }
                        return null;
                    }
                    return (Void) invokeL.objValue;
                }
            }.execute(F0, m0(str3, "cpid"), m0(str3, "idea_id"));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, threadData) == null) {
            if (threadData != null) {
                this.e.setAgreeAlone(true);
                if (this.e.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.e.getLayoutParams()).weight = 1.0f;
                }
                AgreeData agreeData = threadData.getAgreeData();
                if (agreeData != null && agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0) {
                    agreeData.agreeNum = threadData.getAgreeNum();
                    if (threadData.getHasAgree() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    agreeData.hasAgree = z;
                    agreeData.agreeType = threadData.getAgreeType();
                    agreeData.diffAgreeNum = threadData.getAgreeNum() - threadData.getDisAgreeNum();
                }
            }
            super.updatePraiseNum(threadData);
            AgreeView agreeView = this.e;
            if (agreeView != null) {
                agreeView.Q(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.A0 != 1) {
            }
        }
    }
}
