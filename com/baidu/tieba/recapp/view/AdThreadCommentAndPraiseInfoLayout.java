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
import c.a.d.f.p.c;
import c.a.d.f.p.e;
import c.a.d.f.p.n;
import c.a.o0.s.g.g;
import c.a.p0.l3.i0.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes5.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int s0 = 0;
    public static String t0 = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public transient /* synthetic */ FieldHolder $fh;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public a r0;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n0 = 1;
        this.o0 = 0;
        this.p0 = R.drawable.selector_comment_and_prise_item_text_color;
        this.q0 = R.drawable.selector_comment_and_prise_item_text_color;
        d0();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.A == null || this.B == null || (aVar = this.r0) == null) {
            return;
        }
        g0(aVar.getThreadData(), "share", 0);
        h0(this.r0.getThreadData(), "2", "1");
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.B)) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.r0.getTitle();
            shareItem.D = this.r0.getTitle();
            shareItem.t = this.r0.getShareLink();
            shareItem.F = 3;
            shareItem.f30356f = true;
            String imageUrl = this.r0.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.B, shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener(this, shareItem) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ShareItem a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f35770b;

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
                    this.f35770b = this;
                    this.a = shareItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ShareItem shareItem2 = this.a;
                        shareItem2.t = g.v(shareItem2.t, shareItem2.K, UtilHelper.isVideoThread(shareItem2.M));
                        c.a(this.a.t);
                        n.N(this.f35770b.B, view2.getResources().getString(R.string.obfuscated_res_0x7f0f0438));
                    }
                }
            });
            shareDialogConfig.setHideMode(b0(shareItem.t));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void D(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) {
            super.D(threadData);
            if (this.n0 == 1) {
                this.f30122b.setText(StringHelper.cutChineseAndEnglishWithSuffix(threadData.getForum_name(), 12, ""));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.F();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.o0 == 1) {
                    layoutParams2.width = -2;
                    layoutParams2.addRule(11);
                    int i = s0;
                    layoutParams2.setMargins(i, 0, i, 0);
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.setMargins(0, 0, 0, 0);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                if (this.o0 == 1) {
                    layoutParams3.width = -2;
                    layoutParams3.gravity = 5;
                    int i2 = s0;
                    layoutParams3.setMargins(i2, 0, i2, 0);
                    return;
                }
                layoutParams3.width = -1;
                layoutParams3.setMargins(0, 0, 0, 0);
            }
        }
    }

    public void addAdMoreView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view == null) {
            return;
        }
        this.l.setVisibility(0);
        this.l.removeAllViews();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
        this.l.addView(view);
    }

    public final int b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            int length = str.length();
            int i = length > 5120 ? 1 : 0;
            if (length > 5120) {
                i |= 2;
            }
            if (length > 5120) {
                i |= 4;
            }
            if (length > 5120) {
                i |= 8;
            }
            return length > 446 ? i | 16 : i;
        }
        return invokeL.intValue;
    }

    public final String c0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            try {
                return new JSONObject(new String(e.d(str))).getString(str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            s0 = n.f(this.B, R.dimen.tbds44);
            setManageVisible(false);
            setSelectVisible(false);
            setShowFlag(11);
            f0();
        }
    }

    public void disableClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.k.setClickable(false);
            this.f30128h.setClickable(false);
        }
    }

    public final void e0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            if (i == 1) {
                g0(this.r0.getThreadData(), "nozan", 0);
                h0(this.r0.getThreadData(), "1", "2");
                return;
            }
            g0(this.r0.getThreadData(), FeedData.TYPE_ZAN, 0);
            h0(this.r0.getThreadData(), "1", "1");
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f30124d == null) {
            return;
        }
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
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.a.f30124d.getData()) == null) {
                    return;
                }
                this.a.f30124d.getImgAgree().cancelAnimation();
                int i = 0;
                if (data.hasAgree) {
                    if (data.agreeType == 2) {
                        data.agreeType = 2;
                        data.hasAgree = false;
                        data.diffAgreeNum--;
                        data.agreeNum--;
                        this.a.f30124d.B();
                        i = 1;
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum += 2;
                        data.agreeNum++;
                        data.disAgreeNum--;
                        this.a.f30124d.C(true);
                    }
                } else {
                    data.agreeType = 2;
                    data.hasAgree = true;
                    data.diffAgreeNum++;
                    data.agreeNum++;
                    this.a.f30124d.C(true);
                }
                this.a.e0(i);
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
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.a.f30124d.getData()) == null) {
                    return;
                }
                this.a.f30124d.getImgDisagree().cancelAnimation();
                int i = 1;
                if (data.hasAgree) {
                    if (data.agreeType == 5) {
                        data.agreeType = 5;
                        data.hasAgree = false;
                        data.diffAgreeNum++;
                        data.disAgreeNum--;
                        this.a.f30124d.B();
                        this.a.e0(i);
                    }
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum -= 2;
                    data.agreeNum--;
                    data.disAgreeNum++;
                    this.a.f30124d.C(false);
                } else {
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum--;
                    data.disAgreeNum++;
                    this.a.f30124d.C(false);
                }
                i = 0;
                this.a.e0(i);
            }
        };
        this.f30124d.getImgAgree().setOnClickListener(onClickListener);
        this.f30124d.getAgreeNumView().setOnClickListener(onClickListener);
        this.f30124d.getImgDisagree().setOnClickListener(onClickListener2);
        this.f30124d.getDisagreeNumView().setOnClickListener(onClickListener2);
    }

    public final void g0(AdvertAppInfo advertAppInfo, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048586, this, advertAppInfo, str, i) == null) {
            c.a.p0.l3.m0.c b2 = c.a.p0.l3.m0.g.b(advertAppInfo, 8, i);
            b2.c(str);
            c.a.p0.l3.m0.e.b().d(b2);
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30128h : (View) invokeV.objValue;
    }

    public final void h0(AdvertAppInfo advertAppInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, advertAppInfo, str, str2) == null) || advertAppInfo == null) {
            return;
        }
        String str3 = advertAppInfo.f29821h;
        new BdAsyncTask<String, Void, Void>(this, str, str2) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f35771b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f35772c;

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
                this.f35772c = this;
                this.a = str;
                this.f35771b = str2;
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
                    netWork.addPostData("type", this.a);
                    netWork.addPostData("cmd", this.f35771b);
                    netWork.postNetData();
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }.execute(t0, c0(str3, "cpid"), c0(str3, "idea_id"));
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onChangeSkinType();
            this.f30126f.setClickable(false);
            this.f30126f.setEnabled(false);
            SkinManager.setViewTextColor(this.f30125e, this.p0);
            SkinManager.setViewTextColor(this.i, this.q0);
        }
    }

    public void setDisPraiseViewVisibility(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
        }
    }

    public void setPraiseContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setReplayContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                this.p0 = R.color.CAM_X0110;
            } else {
                this.p0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.q0 = R.color.CAM_X0110;
            } else {
                this.q0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareData(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.r0 = aVar;
            setData(aVar.getThreadData());
        }
    }

    public void setStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.n0 = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.o0 = i;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, threadData) == null) {
            if (threadData != null) {
                this.f30124d.setAgreeAlone(true);
                if (this.f30124d.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.f30124d.getLayoutParams()).weight = 1.0f;
                }
                AgreeData agreeData = threadData.getAgreeData();
                if (agreeData != null && agreeData.agreeNum == 0 && agreeData.diffAgreeNum == 0) {
                    agreeData.agreeNum = threadData.getAgreeNum();
                    agreeData.hasAgree = threadData.getHasAgree() == 1;
                    agreeData.agreeType = threadData.getAgreeType();
                    agreeData.diffAgreeNum = threadData.getAgreeNum() - threadData.getDisAgreeNum();
                }
            }
            super.updatePraiseNum(threadData);
            AgreeView agreeView = this.f30124d;
            if (agreeView != null) {
                agreeView.v(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.o0 != 1) {
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
        this.n0 = 1;
        this.o0 = 0;
        this.p0 = R.drawable.selector_comment_and_prise_item_text_color;
        this.q0 = R.drawable.selector_comment_and_prise_item_text_color;
        d0();
    }
}
