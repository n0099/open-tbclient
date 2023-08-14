package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qd6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView a;
    public TbPageContext b;
    public ViewGroup c;
    public BdUniqueId d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;

    /* loaded from: classes7.dex */
    public class a implements NEGFeedBackView.NEGFeedbackEventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onCheckedChanged(NegativeFeedBackData negativeFeedBackData, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, negativeFeedBackData, compoundButton, z) == null) {
            }
        }

        public a(qd6 qd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, negativeFeedBackData) == null) && arrayList != null && negativeFeedBackData != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                if ("ala_frs_demo_hell_live_feed_back_type".equals(negativeFeedBackData.getType())) {
                    TiebaStatic.log(new StatisticItem("c12803").param("tid", negativeFeedBackData.getTid()));
                } else if ("ala_frs_stage_live_feed_back_type".equals(negativeFeedBackData.getType())) {
                    TiebaStatic.log(new StatisticItem("c12807").param("tid", negativeFeedBackData.getTid()));
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.NEGFeedbackEventCallback
        public void onNEGFeedbackWindowShow(NegativeFeedBackData negativeFeedBackData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, negativeFeedBackData) != null) || negativeFeedBackData == null) {
                return;
            }
            if ("ala_frs_demo_hell_live_feed_back_type".equals(negativeFeedBackData.getType())) {
                TiebaStatic.log(new StatisticItem("c12802").param("tid", negativeFeedBackData.getTid()));
            } else if ("ala_frs_stage_live_feed_back_type".equals(negativeFeedBackData.getType())) {
                TiebaStatic.log(new StatisticItem("c12806").param("tid", negativeFeedBackData.getTid()));
            }
        }
    }

    public qd6(TbPageContext tbPageContext, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.b = tbPageContext;
        this.c = viewGroup;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (View) invokeV.objValue;
    }

    public void c() {
        NEGFeedBackView nEGFeedBackView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (nEGFeedBackView = this.a) != null) {
            nEGFeedBackView.onChangeSkinType();
        }
    }

    public void b(ThreadData threadData, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData, str) == null) && threadData != null && threadData.getThreadAlaInfo() != null && this.b != null && this.c != null) {
            int i = 0;
            if (threadData.getAuthor() != null && threadData.getAuthor().getUserId() != null && threadData.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            } else {
                z = false;
            }
            if (TbadkCoreApplication.isLogin() && threadData.getThreadAlaInfo().dislikeInfo != null && !z && threadData.getThreadAlaInfo().dislikeInfo.size() > 0) {
                if (this.a == null) {
                    NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(this.b);
                    this.a = nEGFeedBackView;
                    nEGFeedBackView.setUniqueId(this.d);
                    this.a.setId(R.id.negative_feedback_view);
                    this.a.setDefaultReasonArray(new String[]{this.b.getString(R.string.bad_quality), "", ""});
                    this.a.setEventCallback(this.e);
                    this.a.attachToViewUpperRightConnerFromFrsLive(this.c, BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds120), BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.tbds20));
                    this.a.onChangeSkinType();
                }
                if (this.a.getVisibility() != 0) {
                    this.a.setVisibility(0);
                }
                NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
                negativeFeedBackData.setTid(threadData.getTid());
                negativeFeedBackData.setFid(threadData.getFid());
                negativeFeedBackData.setNid(threadData.getNid());
                negativeFeedBackData.setType(str);
                negativeFeedBackData.setFeedBackReasonMap(threadData.getThreadAlaInfo().dislikeInfo);
                this.a.setData(negativeFeedBackData);
            } else {
                NEGFeedBackView nEGFeedBackView2 = this.a;
                if (nEGFeedBackView2 != null && nEGFeedBackView2.getVisibility() != 8) {
                    this.a.setVisibility(8);
                }
                i = BdUtilHelper.getDimens(this.b.getPageActivity(), R.dimen.obfuscated_res_0x7f070207);
            }
            if (this.c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams.rightMargin = i;
                this.c.setLayoutParams(layoutParams);
            }
            if (this.c.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
                layoutParams2.rightMargin = i;
                this.c.setLayoutParams(layoutParams2);
            }
            NEGFeedBackView nEGFeedBackView3 = this.a;
            if (nEGFeedBackView3 != null) {
                nEGFeedBackView3.dismissPopupWindow();
            }
        }
    }

    public void d(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bdUniqueId) == null) {
            this.d = bdUniqueId;
        }
    }
}
