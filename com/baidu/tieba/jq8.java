package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class jq8 extends tm<bc9, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public ki8 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public lm8 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq8 a;

        public a(jq8 jq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            long j;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09279a) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    if (view2.getTag() != null) {
                        str4 = (String) view2.getTag();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str4});
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092795) {
                    if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                        return;
                    }
                    gt4.x(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092788) {
                    HeadImageView headView = ((HeadPendantClickableView) view2).getHeadView();
                    String userId = headView.getUserId();
                    String userName = headView.getUserName();
                    String fid = headView.getFid();
                    String tid = headView.getTid();
                    String fName = headView.getFName();
                    int floor = headView.getFloor();
                    AlaInfoData alaInfo = headView.getAlaInfo();
                    int liveStatus = headView.getLiveStatus();
                    if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                        if (alaInfo.isLegalYYLiveData()) {
                            YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                        }
                        StatisticItem statisticItem = new StatisticItem("c13715");
                        statisticItem.param("fid", fid);
                        statisticItem.param("fname", fName);
                        AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                        if (alaUserInfoData != null) {
                            j = alaUserInfoData.user_id;
                        } else {
                            j = 0;
                        }
                        statisticItem.param("obj_param1", j);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem.param("tid", tid);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfo));
                        if (alaInfo.mYyExtData != null) {
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                            TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    StatisticItem statisticItem2 = new StatisticItem("c13267");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("fid", fid);
                    statisticItem2.param("tid", tid);
                    statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem2);
                    if (userId != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092794) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    if (view2.getTag(R.id.tag_user_id) instanceof String) {
                        str = (String) view2.getTag(R.id.tag_user_id);
                    } else {
                        str = null;
                    }
                    if (view2.getTag(R.id.tag_user_name) instanceof String) {
                        str2 = (String) view2.getTag(R.id.tag_user_name);
                    } else {
                        str2 = null;
                    }
                    if (this.a.b != null && this.a.b.l() != null) {
                        str3 = this.a.b.l().getName();
                    } else {
                        str3 = null;
                    }
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.b != null) {
                        statisticItem3.param("fid", this.a.b.m());
                        statisticItem3.param("tid", this.a.b.S());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092783 && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.m());
                    statisticItem4.param("tid", this.a.b.S());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.j().O());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).Y3());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f092760 || this.a.mContext == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ jq8 b;

        public b(jq8 jq8Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jq8Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getPortrait() != null && !TextUtils.isEmpty(this.a.getPortrait())) {
                fv5.a(this.b.a.getPageContext(), this.a.getPortrait(), null, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jq8 jq8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq8Var, Integer.valueOf(i)};
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
            this.a = jq8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).p != null) {
                ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).p.setTextSize(TbConfig.getContentSize());
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq8(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = new a(this);
        c cVar = new c(this, 2004018);
        this.n = cVar;
        this.a = baseFragment;
        baseFragment.registerListener(cVar);
    }

    public final void E(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, bc9Var) == null) && (ki8Var = this.b) != null && ki8Var.Q() != null && bc9Var != null) {
            videoTabPbFloatUserInfoViewHolder.n(this.b.Q().getRichTitle(), this.b.Q().getTitle(), this.b.Q(), I(bc9Var), this.b.z0());
            videoTabPbFloatUserInfoViewHolder.m(this.mContext, bc9Var);
        }
    }

    public final void R(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, textView, bc9Var) == null) && textView != null && bc9Var != null) {
            textView.setTag(bc9Var);
            if (bc9Var.r() != null && StringHelper.equals(this.l, bc9Var.r().getUserId())) {
                textView.setVisibility(0);
                n15 d = n15.d(textView);
                d.w(R.color.CAM_X0101);
                d.o(R.string.J_X04);
                d.f(R.color.CAM_X0302);
                textView.setText(R.string.host_name);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void T(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, videoTabPbFloatUserInfoViewHolder, bc9Var) == null) && (ki8Var = this.b) != null && ki8Var.Q() != null) {
            this.c = 0;
            if (!this.b.Q().isMutiForumThread()) {
                if (bc9Var != null && bc9Var.r() != null) {
                    this.c = bc9Var.r().getLevel_id();
                }
                if (!this.b.l0()) {
                    videoTabPbFloatUserInfoViewHolder.j.setVisibility(0);
                    videoTabPbFloatUserInfoViewHolder.g(this.c);
                    return;
                }
                videoTabPbFloatUserInfoViewHolder.j.setVisibility(8);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.j.setVisibility(8);
        }
    }

    public final void U(TbImageView tbImageView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, tbImageView, bc9Var) == null) && tbImageView != null && bc9Var != null && TbSingleton.getInstance().isUserGrowthOpen() && bc9Var.r().getUserGrowthData() != null) {
            int a2 = bc9Var.r().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                tbImageView.setImageResource(sw.b(a2));
                tbImageView.setVisibility(0);
                return;
            }
            tbImageView.setVisibility(8);
        }
    }

    public final void W(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && metaData != null && this.b != null) {
            String ipAddress = metaData.getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                TextView textView = videoTabPbFloatUserInfoViewHolder.t;
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + ipAddress);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.t.setVisibility(8);
        }
    }

    public final void Z(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && this.b != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoTabPbFloatUserInfoViewHolder.k.setTag(R.id.tag_user_id, metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.k.h(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final boolean I(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bc9Var)) == null) {
            if (bc9Var != null && ListUtils.getCount(bc9Var.i0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public void P(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ki8Var) == null) {
            this.b = ki8Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public final void D(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, bc9Var) == null) && (ki8Var = this.b) != null && ki8Var.Q() != null && this.b.Q().getAuthor() != null && bc9Var != null) {
            V(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor(), bc9Var);
            a0(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
            Y(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
            R(videoTabPbFloatUserInfoViewHolder.h, bc9Var);
            U(videoTabPbFloatUserInfoViewHolder.i, bc9Var);
            T(videoTabPbFloatUserInfoViewHolder, bc9Var);
            Z(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
            Q(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
            X(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor(), bc9Var);
            W(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
            G(videoTabPbFloatUserInfoViewHolder, this.b.Q().getAuthor());
        }
    }

    public final void a0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.f.i(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public final void F(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, bc9Var) == null) {
            videoTabPbFloatUserInfoViewHolder.l(8, null);
            ki8 ki8Var = this.b;
            if (ki8Var != null && ki8Var.Q() != null && bc9Var != null) {
                if (bc9Var.S) {
                    videoTabPbFloatUserInfoViewHolder.l(0, bc9Var.O());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).d6(bc9Var.S);
                }
            }
        }
    }

    public final void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && WorldCupEnableSwitch.isOn() && metaData != null) {
            TbImageView tbImageView = videoTabPbFloatUserInfoViewHolder.y;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.y.setImageResource(R.drawable.icon_mask_raise_flag_button);
                videoTabPbFloatUserInfoViewHolder.y.setOnClickListener(new b(this, metaData));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = videoTabPbFloatUserInfoViewHolder.z;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(metaData);
            }
        }
    }

    public final void Y(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.g.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.tag_user_name, metaData.getName_show());
        this.i = metaData.isBigV();
        this.j = metaData.isNewGod();
    }

    public final int H(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ki8Var)) == null) {
            if (ki8Var == null || ki8Var.Q() == null) {
                return 0;
            }
            if (ki8Var.Q().isMutiForumThread()) {
                if (ListUtils.isEmpty(ki8Var.p()) && (ki8Var.h() == null || StringUtils.isNull(ki8Var.h().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        ki8 ki8Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, videoTabPbFloatUserInfoViewHolder) != null) || (ki8Var = this.b) == null) {
            return;
        }
        this.d = ki8Var.j;
        if (ki8Var.Q() != null) {
            boolean z2 = false;
            if (this.b.Q().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if (this.b.Q().getIs_top() == 1) {
                z2 = true;
            }
            this.e = z2;
        }
        videoTabPbFloatUserInfoViewHolder.i(this.d, this.f, this.e);
    }

    public void J(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, videoTabPbFloatUserInfoViewHolder) != null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.g(this.c);
        if (!this.h && !this.i && !this.j) {
            z = false;
        } else {
            z = true;
        }
        videoTabPbFloatUserInfoViewHolder.j(z);
        videoTabPbFloatUserInfoViewHolder.i(this.d, this.f, this.e);
        videoTabPbFloatUserInfoViewHolder.h();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: L */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0732, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, absVideoPbFragment);
            videoTabPbFloatUserInfoViewHolder.k(this.m);
            J(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View M(int i, View view2, ViewGroup viewGroup, bc9 bc9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bc9Var, videoTabPbFloatUserInfoViewHolder})) == null) {
            ki8 ki8Var = this.b;
            if (ki8Var != null && ki8Var.Q() != null && bc9Var != null) {
                mp8.d(this.a.getUniqueId(), this.b, bc9Var, 1, 1);
                S(videoTabPbFloatUserInfoViewHolder);
                D(videoTabPbFloatUserInfoViewHolder, bc9Var);
                E(videoTabPbFloatUserInfoViewHolder, bc9Var);
                F(videoTabPbFloatUserInfoViewHolder, bc9Var);
                J(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.r.setVisibility(8);
                if (this.k) {
                    videoTabPbFloatUserInfoViewHolder.s.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = videoTabPbFloatUserInfoViewHolder.s.getLayoutParams();
                    layoutParams.height = view2.getHeight();
                    videoTabPbFloatUserInfoViewHolder.s.setLayoutParams(layoutParams);
                    videoTabPbFloatUserInfoViewHolder.s.bringToFront();
                } else {
                    videoTabPbFloatUserInfoViewHolder.s.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void N(bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, bc9Var) == null) && bc9Var != null && bc9Var.r() != null) {
            String userId = bc9Var.r().getUserId();
            ki8 ki8Var = this.b;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            ki8 ki8Var2 = this.b;
            if (ki8Var2 != null) {
                str2 = ki8Var2.n();
            }
            int E = bc9Var.E();
            String O = bc9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, E);
            if (bc9Var.r().getAlaInfo() != null) {
                AlaInfoData alaInfo = bc9Var.r().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Q(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.b != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.m;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.m.getLayoutParams();
                layoutParams.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.l.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.l.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.m.getLayoutParams();
            layoutParams2.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.l.setVisibility(8);
        }
    }

    public final void V(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, bc9Var) == null) && this.b != null && metaData != null && bc9Var != null) {
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setTid(bc9Var.O());
            ki8 ki8Var = this.b;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFid(str);
            ki8 ki8Var2 = this.b;
            if (ki8Var2 != null) {
                str2 = ki8Var2.n();
            }
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFName(str2);
            videoTabPbFloatUserInfoViewHolder.d.i(metaData);
            videoTabPbFloatUserInfoViewHolder.d.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoTabPbFloatUserInfoViewHolder.d(true);
                videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(1);
                videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(bc9Var.r().getAlaInfo());
                N(bc9Var);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.d(false);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(0);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(null);
        }
    }

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData, bc9Var) == null) && this.b != null && bc9Var != null && bc9Var.r() != null) {
            ki8 ki8Var = this.b;
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.S();
            }
            int H = H(this.b);
            int i = 4;
            if (this.b.Q() != null && this.b.Q().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.g == null) {
                lm8 lm8Var = new lm8(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.n, i);
                this.g = lm8Var;
                lm8Var.l(this.a.getUniqueId());
            }
            bc9Var.r().setIsLike(bc9Var.r().hadConcerned());
            this.g.n(bc9Var.r());
            this.g.z(str);
            this.g.x(this.b.Q());
            lm8 lm8Var2 = this.g;
            lm8Var2.p = true;
            lm8Var2.y(H);
            this.g.k(true);
            if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.n.setText("");
                videoTabPbFloatUserInfoViewHolder.b();
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.n.setText("");
                videoTabPbFloatUserInfoViewHolder.b();
            }
            if (this.b.i) {
                videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.n.setText("");
                videoTabPbFloatUserInfoViewHolder.b();
            }
            if (bc9Var.r().getIsLike()) {
                videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.n.setText("");
                videoTabPbFloatUserInfoViewHolder.b();
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bc9 bc9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        M(i, view2, viewGroup, bc9Var, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
