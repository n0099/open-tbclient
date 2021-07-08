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
import d.a.c.e.p.c;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.s.g.g;
import d.a.p0.w2.e0.a;
import d.a.p0.w2.i0.e;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdThreadCommentAndPraiseInfoLayout extends ThreadCardBottomOpSegmentWeightLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int v0 = 0;
    public static String w0 = "https://afd.baidu.com/afd/updateTiebaAdExt";
    public transient /* synthetic */ FieldHolder $fh;
    public int q0;
    public int r0;
    public int s0;
    public int t0;
    public a u0;

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
        this.q0 = 1;
        this.r0 = 0;
        int i4 = R.drawable.selector_comment_and_prise_item_text_color;
        this.s0 = i4;
        this.t0 = i4;
        i0();
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void A(View view) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.E == null || this.F == null || (aVar = this.u0) == null) {
            return;
        }
        l0(aVar.getThreadData(), "share", 0);
        m0(this.u0.getThreadData(), "2", "1");
        if (ShareSwitch.isOn() || ViewHelper.checkUpIsLogin(this.F)) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.u0.getTitle();
            shareItem.D = this.u0.getTitle();
            shareItem.t = this.u0.getShareLink();
            shareItem.F = 3;
            shareItem.f12843f = true;
            String imageUrl = this.u0.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.F, shareItem, true, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.setCopyLinkListener(new View.OnClickListener(this, shareItem) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ ShareItem f20614e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f20615f;

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
                    this.f20615f = this;
                    this.f20614e = shareItem;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        ShareItem shareItem2 = this.f20614e;
                        shareItem2.t = g.o(shareItem2.t, shareItem2.K);
                        d.a.c.e.p.a.a(this.f20614e.t);
                        l.M(this.f20615f.F, view2.getResources().getString(R.string.copy_pb_url_success));
                    }
                }
            });
            shareDialogConfig.setHideMode(g0(shareItem.t));
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void G(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            super.G(b2Var);
            if (this.q0 == 1) {
                this.f12552f.setText(StringHelper.cutChineseAndEnglishWithSuffix(b2Var.W(), 12, ""));
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCardBottomOpSegmentWeightLayout, com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.I();
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (this.r0 == 1) {
                    layoutParams2.width = -2;
                    layoutParams2.addRule(11);
                    int i2 = v0;
                    layoutParams2.setMargins(i2, 0, i2, 0);
                    return;
                }
                layoutParams2.width = -1;
                layoutParams2.setMargins(0, 0, 0, 0);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams;
                if (this.r0 == 1) {
                    layoutParams3.width = -2;
                    layoutParams3.gravity = 5;
                    int i3 = v0;
                    layoutParams3.setMargins(i3, 0, i3, 0);
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
        this.p.setVisibility(0);
        this.p.removeAllViews();
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 21));
        this.p.addView(view);
    }

    public void disableClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o.setClickable(false);
            this.l.setClickable(false);
        }
    }

    public final int g0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
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

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public View getCommentContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (View) invokeV.objValue;
    }

    public final String h0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            try {
                return new JSONObject(new String(c.d(str))).getString(str2);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            v0 = l.g(this.F, R.dimen.tbds44);
            setManageVisible(false);
            setSelectVisible(false);
            setShowFlag(11);
            k0();
        }
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 == 1) {
                l0(this.u0.getThreadData(), "nozan", 0);
                m0(this.u0.getThreadData(), "1", "2");
                return;
            }
            l0(this.u0.getThreadData(), FeedData.TYPE_ZAN, 0);
            m0(this.u0.getThreadData(), "1", "1");
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f12554h == null) {
            return;
        }
        View.OnClickListener onClickListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f20612e;

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
                this.f20612e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.f20612e.f12554h.getData()) == null) {
                    return;
                }
                this.f20612e.f12554h.getImgAgree().cancelAnimation();
                int i2 = 0;
                if (data.hasAgree) {
                    if (data.agreeType == 2) {
                        data.agreeType = 2;
                        data.hasAgree = false;
                        data.diffAgreeNum--;
                        data.agreeNum--;
                        this.f20612e.f12554h.z();
                        i2 = 1;
                    } else {
                        data.agreeType = 2;
                        data.hasAgree = true;
                        data.diffAgreeNum += 2;
                        data.agreeNum++;
                        data.disAgreeNum--;
                        this.f20612e.f12554h.A(true);
                    }
                } else {
                    data.agreeType = 2;
                    data.hasAgree = true;
                    data.diffAgreeNum++;
                    data.agreeNum++;
                    this.f20612e.f12554h.A(true);
                }
                this.f20612e.j0(i2);
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f20613e;

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
                this.f20613e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AgreeData data;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) || (data = this.f20613e.f12554h.getData()) == null) {
                    return;
                }
                this.f20613e.f12554h.getImgDisagree().cancelAnimation();
                int i2 = 1;
                if (data.hasAgree) {
                    if (data.agreeType == 5) {
                        data.agreeType = 5;
                        data.hasAgree = false;
                        data.diffAgreeNum++;
                        data.disAgreeNum--;
                        this.f20613e.f12554h.z();
                        this.f20613e.j0(i2);
                    }
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum -= 2;
                    data.agreeNum--;
                    data.disAgreeNum++;
                    this.f20613e.f12554h.A(false);
                } else {
                    data.agreeType = 5;
                    data.hasAgree = true;
                    data.diffAgreeNum--;
                    data.disAgreeNum++;
                    this.f20613e.f12554h.A(false);
                }
                i2 = 0;
                this.f20613e.j0(i2);
            }
        };
        this.f12554h.getImgAgree().setOnClickListener(onClickListener);
        this.f12554h.getAgreeNumView().setOnClickListener(onClickListener);
        this.f12554h.getImgDisagree().setOnClickListener(onClickListener2);
        this.f12554h.getDisagreeNumView().setOnClickListener(onClickListener2);
    }

    public final void l0(AdvertAppInfo advertAppInfo, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048587, this, advertAppInfo, str, i2) == null) {
            d.a.p0.w2.i0.c b2 = d.a.p0.w2.i0.g.b(advertAppInfo, 8, i2);
            b2.c(str);
            e.b().d(b2);
        }
    }

    public final void m0(AdvertAppInfo advertAppInfo, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, advertAppInfo, str, str2) == null) || advertAppInfo == null) {
            return;
        }
        String str3 = advertAppInfo.S3;
        new BdAsyncTask<String, Void, Void>(this, str, str2) { // from class: com.baidu.tieba.recapp.view.AdThreadCommentAndPraiseInfoLayout.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f20616a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f20617b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ AdThreadCommentAndPraiseInfoLayout f20618c;

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
                this.f20618c = this;
                this.f20616a = str;
                this.f20617b = str2;
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
                    netWork.addPostData("type", this.f20616a);
                    netWork.addPostData("cmd", this.f20617b);
                    netWork.postNetData();
                    return null;
                }
                return (Void) invokeL.objValue;
            }
        }.execute(w0, h0(str3, "cpid"), h0(str3, "idea_id"));
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onChangeSkinType();
            this.j.setClickable(false);
            this.j.setEnabled(false);
            SkinManager.setViewTextColor(this.f12555i, this.s0);
            SkinManager.setViewTextColor(this.m, this.t0);
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
                this.s0 = R.color.CAM_X0110;
            } else {
                this.s0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareContainerBgGray(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.t0 = R.color.CAM_X0110;
            } else {
                this.t0 = R.drawable.selector_comment_and_prise_item_text_color;
            }
        }
    }

    public void setShareData(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.u0 = aVar;
            setData(aVar.getThreadData());
        }
    }

    public void setStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.q0 = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.r0 = i2;
        }
    }

    @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout
    public void updatePraiseNum(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b2Var) == null) {
            if (b2Var != null) {
                this.f12554h.setAgreeAlone(true);
                if (this.f12554h.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.f12554h.getLayoutParams()).weight = 1.0f;
                }
                AgreeData z = b2Var.z();
                if (z != null && z.agreeNum == 0 && z.diffAgreeNum == 0) {
                    z.agreeNum = b2Var.A();
                    z.hasAgree = b2Var.a0() == 1;
                    z.agreeType = b2Var.B();
                    z.diffAgreeNum = b2Var.A() - b2Var.O();
                }
            }
            super.updatePraiseNum(b2Var);
            AgreeView agreeView = this.f12554h;
            if (agreeView != null) {
                agreeView.u(TbadkCoreApplication.getInst().getSkinType());
            }
            if (this.r0 != 1) {
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
        this.q0 = 1;
        this.r0 = 0;
        int i4 = R.drawable.selector_comment_and_prise_item_text_color;
        this.s0 = i4;
        this.t0 = i4;
        i0();
    }
}
