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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
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
/* loaded from: classes8.dex */
public class vr9 extends pm<tha, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public aj9 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public vn9 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr9 a;

        public a(vr9 vr9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vr9Var;
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
                if (view2.getId() == R.id.obfuscated_res_0x7f092975) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092970) {
                    if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                        return;
                    }
                    BrowserHelper.startWebActivity(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092963) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09296f) {
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
                    if (this.a.b != null && this.a.b.k() != null) {
                        str3 = this.a.b.k().getName();
                    } else {
                        str3 = null;
                    }
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.b != null) {
                        statisticItem3.param("fid", this.a.b.l());
                        statisticItem3.param("tid", this.a.b.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09295e && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.l());
                    statisticItem4.param("tid", this.a.b.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.i().U());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).G3());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09293e) {
                    if (this.a.mContext == null) {
                        return;
                    }
                    BrowserHelper.startWebActivity(this.a.mContext, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09296b && this.a.mContext != null && this.a.b != null && this.a.b.O() != null && this.a.b.O().getAuthor() != null && StringUtils.isNotNull(this.a.b.O().getAuthor().getPortrait())) {
                    ky5.d(this.a.b.l(), this.a.b.O().getAuthor().getPortrait(), "2", this.a.mContext);
                    ly5.c("c15281", this.a.b.l(), "2");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(vr9 vr9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vr9Var, Integer.valueOf(i)};
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
            this.a = vr9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q != null) {
                ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q.setTextSize(TbConfig.getContentSize());
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vr9(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
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
        b bVar = new b(this, 2004018);
        this.n = bVar;
        this.a = baseFragment;
        baseFragment.registerListener(bVar);
    }

    public final void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, tha thaVar) {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, thaVar) == null) && (aj9Var = this.b) != null && aj9Var.O() != null && thaVar != null) {
            videoTabPbFloatUserInfoViewHolder.q(this.b.O().getRichTitle(), this.b.O().getTitle(), this.b.O(), J(thaVar), this.b.y0());
            videoTabPbFloatUserInfoViewHolder.p(this.mContext, thaVar);
        }
    }

    public final void T(TbImageView tbImageView, tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, tbImageView, thaVar) == null) && tbImageView != null && thaVar != null && TbSingleton.getInstance().isUserGrowthOpen() && thaVar.t().getUserGrowthData() != null) {
            int a2 = thaVar.t().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                tbImageView.setImageResource(ex.b(a2));
                tbImageView.setVisibility(0);
                return;
            }
            tbImageView.setVisibility(8);
        }
    }

    public final void W(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && metaData != null && this.b != null) {
            String ipAddress = metaData.getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                TextView textView = videoTabPbFloatUserInfoViewHolder.u;
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + ipAddress);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.u.setVisibility(8);
        }
    }

    public final void Z(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && this.b != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoTabPbFloatUserInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final boolean J(tha thaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, thaVar)) == null) {
            if (thaVar != null && ListUtils.getCount(thaVar.r0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void P(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aj9Var) == null) {
            this.b = aj9Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.l = str;
        }
    }

    public final void F(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, tha thaVar) {
        aj9 aj9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, thaVar) == null) && (aj9Var = this.b) != null && aj9Var.O() != null && this.b.O().getAuthor() != null && thaVar != null) {
            U(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor(), thaVar);
            a0(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
            Y(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
            oo9.e(videoTabPbFloatUserInfoViewHolder.i, thaVar, this.b, this.l);
            T(videoTabPbFloatUserInfoViewHolder.j, thaVar);
            S(videoTabPbFloatUserInfoViewHolder, thaVar);
            Z(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
            Q(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
            X(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor(), thaVar);
            W(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
            videoTabPbFloatUserInfoViewHolder.d(this.b.O().getAuthor());
        }
    }

    public final void a0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.g.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.g.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public final void H(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, thaVar) == null) {
            videoTabPbFloatUserInfoViewHolder.o(8, null);
            aj9 aj9Var = this.b;
            if (aj9Var != null && aj9Var.O() != null && thaVar != null) {
                if (thaVar.f1164T) {
                    videoTabPbFloatUserInfoViewHolder.o(0, thaVar.U());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).e5(thaVar.f1164T);
                }
            }
        }
    }

    public final void Y(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.h.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_name, metaData.getName_show());
        this.i = metaData.isBigV();
        this.j = metaData.isNewGod();
    }

    public final int I(aj9 aj9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aj9Var)) == null) {
            if (aj9Var == null || aj9Var.O() == null) {
                return 0;
            }
            if (aj9Var.O().isMutiForumThread()) {
                if (ListUtils.isEmpty(aj9Var.o()) && (aj9Var.g() == null || StringUtils.isNull(aj9Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void R(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        aj9 aj9Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, videoTabPbFloatUserInfoViewHolder) != null) || (aj9Var = this.b) == null) {
            return;
        }
        this.d = aj9Var.j;
        if (aj9Var.O() != null) {
            boolean z2 = false;
            if (this.b.O().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if (this.b.O().getIs_top() == 1) {
                z2 = true;
            }
            this.e = z2;
        }
        videoTabPbFloatUserInfoViewHolder.k(this.d, this.f, this.e);
    }

    public void K(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, videoTabPbFloatUserInfoViewHolder) != null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.j(this.c);
        if (!this.h && !this.i && !this.j) {
            z = false;
        } else {
            z = true;
        }
        videoTabPbFloatUserInfoViewHolder.l(z);
        videoTabPbFloatUserInfoViewHolder.k(this.d, this.f, this.e);
        videoTabPbFloatUserInfoViewHolder.onChangeSkinType();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: L */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07bc, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, absVideoPbFragment);
            videoTabPbFloatUserInfoViewHolder.n(this.m);
            K(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View M(int i, View view2, ViewGroup viewGroup, tha thaVar, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, thaVar, videoTabPbFloatUserInfoViewHolder})) == null) {
            aj9 aj9Var = this.b;
            if (aj9Var != null && aj9Var.O() != null && thaVar != null) {
                nr9.d(this.a.getUniqueId(), this.b, thaVar, 1, 1);
                R(videoTabPbFloatUserInfoViewHolder);
                F(videoTabPbFloatUserInfoViewHolder, thaVar);
                G(videoTabPbFloatUserInfoViewHolder, thaVar);
                H(videoTabPbFloatUserInfoViewHolder, thaVar);
                K(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.s.setVisibility(8);
                if (this.k) {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = videoTabPbFloatUserInfoViewHolder.t.getLayoutParams();
                    layoutParams.height = view2.getHeight();
                    videoTabPbFloatUserInfoViewHolder.t.setLayoutParams(layoutParams);
                    videoTabPbFloatUserInfoViewHolder.t.bringToFront();
                } else {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void N(tha thaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, thaVar) == null) && thaVar != null && thaVar.t() != null) {
            String userId = thaVar.t().getUserId();
            aj9 aj9Var = this.b;
            String str2 = "";
            if (aj9Var == null) {
                str = "";
            } else {
                str = aj9Var.l();
            }
            aj9 aj9Var2 = this.b;
            if (aj9Var2 != null) {
                str2 = aj9Var2.m();
            }
            int L = thaVar.L();
            String U = thaVar.U();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", U);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, L);
            if (thaVar.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = thaVar.t().getAlaInfo();
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
        if (interceptable == null || interceptable.invokeLL(1048587, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.b != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.n;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
                layoutParams.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.m.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.m.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
            layoutParams2.setMargins(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, tha thaVar) {
        aj9 aj9Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, videoTabPbFloatUserInfoViewHolder, thaVar) == null) && (aj9Var = this.b) != null && aj9Var.O() != null) {
            this.c = 0;
            if (!this.b.O().isMutiForumThread()) {
                if (thaVar != null && thaVar.t() != null) {
                    this.c = thaVar.t().getLevel_id();
                    str = thaVar.t().getLevelName();
                } else {
                    str = "";
                }
                if (!this.b.j0()) {
                    videoTabPbFloatUserInfoViewHolder.k.setVisibility(0);
                    videoTabPbFloatUserInfoViewHolder.k.setLevel(this.c, str);
                    return;
                }
                videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void U(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, tha thaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, videoTabPbFloatUserInfoViewHolder, metaData, thaVar) == null) && this.b != null && metaData != null && thaVar != null) {
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserId(metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserName(metaData.getUserName());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setTid(thaVar.U());
            aj9 aj9Var = this.b;
            String str2 = "";
            if (aj9Var == null) {
                str = "";
            } else {
                str = aj9Var.l();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFid(str);
            aj9 aj9Var2 = this.b;
            if (aj9Var2 != null) {
                str2 = aj9Var2.m();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFName(str2);
            videoTabPbFloatUserInfoViewHolder.e.i(metaData);
            videoTabPbFloatUserInfoViewHolder.e.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoTabPbFloatUserInfoViewHolder.g(true);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(1);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(thaVar.t().getAlaInfo());
                N(thaVar);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.g(false);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(0);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(null);
        }
    }

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, tha thaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, thaVar) == null) && this.b != null && thaVar != null && thaVar.t() != null) {
            aj9 aj9Var = this.b;
            if (aj9Var == null) {
                str = "";
            } else {
                str = aj9Var.Q();
            }
            int I = I(this.b);
            int i = 4;
            if (this.b.O() != null && this.b.O().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.g == null) {
                vn9 vn9Var = new vn9(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.o, i);
                this.g = vn9Var;
                vn9Var.j(this.a.getUniqueId());
            }
            thaVar.t().setIsLike(thaVar.t().hadConcerned());
            this.g.l(thaVar.t());
            this.g.x(str);
            this.g.t(this.b.O());
            vn9 vn9Var2 = this.g;
            vn9Var2.p = true;
            vn9Var2.u(I);
            this.g.i(true);
            if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
            if (this.b.i) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
            if (thaVar.t().getIsLike()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tha thaVar, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        M(i, view2, viewGroup, thaVar, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
